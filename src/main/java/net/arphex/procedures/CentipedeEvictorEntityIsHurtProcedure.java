package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class CentipedeEvictorEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (!(entity.getPersistentData().getDouble("evictorcycle") > 0.0)) {
            entity.getPersistentData().putDouble("evictorcycle", 1.0);
         } else if (entity.getPersistentData().getDouble("evictorcycle") > 20.0) {
            entity.getPersistentData().putDouble("evictorcycle", 1.0);
         } else {
            entity.getPersistentData().putDouble("evictorcycle", entity.getPersistentData().getDouble("evictorcycle") + 1.0);
         }

         if (entity instanceof CentipedeEvictorEntity
            && entity.getPersistentData().getDouble("evictorcycle") == 5.0
            && sourceentity != null
            && world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR_LARVAE.get())
               .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
            }
         }

         ArphexMod.queueServerWork(10, () -> {
            if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
            }
         });
      }
   }
}
