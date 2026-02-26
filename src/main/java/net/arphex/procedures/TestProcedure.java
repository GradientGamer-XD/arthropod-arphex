package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.level.LevelEvent.Load;
import net.minecraftforge.event.level.LevelEvent.Unload;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class TestProcedure {
   public static void execute() {
   }

   @SubscribeEvent
   public static void onWorldLoad(Load event) {
      LevelAccessor levelAccess = event.getLevel();
      String dimensionName = "unknown";
      if (levelAccess instanceof Level level) {
         try {
            if (level.dimension() != null) {
               dimensionName = level.dimension().location().toString();
            }
         } catch (Exception var5) {
            dimensionName = "failed_to_get_dimension";
         }
      }

      ArphexMod.LOGGER.warn("[WORLD LOAD] Dimension: " + dimensionName);
   }

   @SubscribeEvent
   public static void onWorldUnload(Unload event) {
      LevelAccessor levelAccess = event.getLevel();
      String dimensionName = "unknown";
      if (levelAccess instanceof Level level) {
         try {
            if (level.dimension() != null) {
               dimensionName = level.dimension().location().toString();
            }
         } catch (Exception var5) {
            dimensionName = "failed_to_get_dimension";
         }
      }

      ArphexMod.LOGGER.warn("[WORLD UNLOAD] Dimension: " + dimensionName);
   }
}
