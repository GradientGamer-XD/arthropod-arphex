package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.WebHarnessEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WebHookProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         entity.getPersistentData().putBoolean("onblock", true);
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty() && y + 5.0 > entity.getY()) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.WEB_HARNESS.get())
                  .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(
                        WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                     )
                     .isEmpty()) {
                     world.getEntitiesOfClass(
                           WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .putDouble("targetX", immediatesourceentity.getX());
                     world.getEntitiesOfClass(
                           WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .putDouble("targetY", immediatesourceentity.getY());
                     world.getEntitiesOfClass(
                           WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .putDouble("targetZ", immediatesourceentity.getZ());
                  }
               }
            );
            ArphexMod.queueServerWork(
               2,
               () -> {
                  if (!world.getEntitiesOfClass(
                        WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                     )
                     .isEmpty()) {
                     world.getEntitiesOfClass(
                           WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .putDouble("targetX", immediatesourceentity.getX());
                     world.getEntitiesOfClass(
                           WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .putDouble("targetY", immediatesourceentity.getY());
                     world.getEntitiesOfClass(
                           WebHarnessEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 20.0, 20.0, 20.0), e -> true
                        )
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                        .findFirst()
                        .orElse(null)
                        .getPersistentData()
                        .putDouble("targetZ", immediatesourceentity.getZ());
                  }
               }
            );
         }
      }
   }
}
