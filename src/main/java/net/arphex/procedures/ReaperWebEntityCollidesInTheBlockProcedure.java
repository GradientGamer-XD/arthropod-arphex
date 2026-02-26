package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ReaperWebEntityCollidesInTheBlockProcedure {
   public static void execute(double y, Entity entity) {
      if (entity != null) {
         if (entity.getY() < y + 0.5 && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("spider")) {
            entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
         }
      }
   }
}
