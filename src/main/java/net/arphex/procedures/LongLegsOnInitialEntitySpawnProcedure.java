package net.arphex.procedures;

import net.arphex.entity.LongLegsEntity;
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

public class LongLegsOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
            if (entity instanceof LongLegsEntity animatable) {
               animatable.setTexture("longlegsmap");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 99999, 0, false, false));
            }
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_TINY.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.LONG_LEGS_TINY.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         entity.getPersistentData().putDouble("climbradius", 1.0);
      }
   }
}
