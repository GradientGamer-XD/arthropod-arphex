package net.arphex.procedures;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class BloodWormEntityVisualScaleProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      execute(event, event.getEntity());
   }

   public static double execute(Entity entity) {
      return execute(null, entity);
   }

   private static double execute(@Nullable Event event, Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double randomsize = 0.0;
         if (entity.getPersistentData().getDouble("randomsize") < 0.3) {
            randomsize = 1.0;
         } else {
            randomsize = entity.getPersistentData().getDouble("randomsize");
         }

         return randomsize;
      }
   }
}
