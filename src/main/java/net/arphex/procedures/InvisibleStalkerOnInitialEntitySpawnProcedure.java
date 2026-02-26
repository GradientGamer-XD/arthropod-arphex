package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.InvisibleStalkerEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InvisibleStalkerOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()) {
            entity.getPersistentData().putBoolean("spawnedaway", false);
         } else {
            entity.getPersistentData().putBoolean("spawnedaway", true);
         }

         if (!world.getEntitiesOfClass(InvisibleStalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getDouble("mothsurvivals") >= 3.0
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (entity.getY() > 100.0
            && Mth.nextInt(RandomSource.create(), 1, 2) == 1
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
