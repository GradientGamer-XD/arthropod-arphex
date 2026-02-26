package net.arphex.procedures;

import javax.annotation.Nullable;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SpiderMothDwellerBoundingBoxScaleProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      execute(event);
   }

   public static double execute() {
      return execute(null);
   }

   private static double execute(@Nullable Event event) {
      double dwellerhitbox = 0.0;
      return 1.48;
   }
}
