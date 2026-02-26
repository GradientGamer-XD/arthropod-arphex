package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderLarvaeTinyEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GiantWebEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelxxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelxxxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelxxxxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      if (world instanceof ServerLevel _levelxxxxxx) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
            .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }

      ArphexMod.queueServerWork(
         2,
         () -> {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof SpiderLarvaeTinyEntity && entityiterator instanceof SpiderLarvaeTinyEntity animatable) {
                  animatable.setTexture("spiderwidow");
               }
            }
         }
      );
   }
}
