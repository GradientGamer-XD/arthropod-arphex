package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DwellerSleepSpawnerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
            entity.setDeltaMovement(new Vec3(10.0, 5.0, 10.0));
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")
            && entity.getPersistentData().getBoolean("donespawn")) {
            entity.getPersistentData().putBoolean("donespawn", true);
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
            ArphexMod.queueServerWork(
               100,
               () -> {
                  if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
                     && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).isShiftKeyDown()
                     && !entity.getPersistentData().getBoolean("donespawn")) {
                     entity.getPersistentData().putBoolean("donespawn", true);
                     if (world instanceof ServerLevel _levelx) {
                        Entity entityToSpawnx = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                           .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawnx != null) {
                           entityToSpawnx.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               }
            );
         }

         if (!world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))) {
            entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
         } else if (!world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))) {
            entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y, z));
         } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))) {
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 1.0));
         } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z - 1.0));
         } else {
            entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y, z - 1.0));
         }
      }
   }
}
