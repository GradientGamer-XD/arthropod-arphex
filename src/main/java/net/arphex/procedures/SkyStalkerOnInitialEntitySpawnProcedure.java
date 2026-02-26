package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.SkyStalkerEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SkyStalkerOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(SkyStalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 4000, 6000), () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()) {
            entity.getPersistentData().putBoolean("spawnedaway", false);
         } else {
            entity.getPersistentData().putBoolean("spawnedaway", true);
         }
      }
   }
}
