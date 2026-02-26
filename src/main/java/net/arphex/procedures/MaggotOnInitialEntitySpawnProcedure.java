package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.entity.MaggotLarvaeEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class MaggotOnInitialEntitySpawnProcedure {
   @SubscribeEvent
   public static void onEntitySpawned(EntityJoinLevelEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute(null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 10) == 5 && entity instanceof MaggotLarvaeEntity animatable) {
            animatable.setTexture("maggotlayersbrown");
         }

         if (entity instanceof MaggotLarvaeEntity) {
            entity.getPersistentData().putDouble("randomsize", Mth.nextDouble(RandomSource.create(), 0.3, 1.1));
         }
      }
   }
}
