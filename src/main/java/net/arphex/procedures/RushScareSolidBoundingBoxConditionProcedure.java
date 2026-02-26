package net.arphex.procedures;

import javax.annotation.Nullable;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RushScareSolidBoundingBoxConditionProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      execute(event);
   }

   public static boolean execute() {
      return execute(null);
   }

   private static boolean execute(@Nullable Event event) {
      return true;
   }
}
