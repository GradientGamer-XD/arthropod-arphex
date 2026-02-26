package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.SpiderInfestorEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SpiderInfestorEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderInfestorEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderInfestorEntity.DATA_ontheprowl, 2000);
         }

         if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.INVISIBILITY)) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 100, 1.0, 0.5, 1.0, 0.8);
            }

            if (entity instanceof SpiderInfestorEntity) {
               ((SpiderInfestorEntity)entity).setAnimation("animation.spider_infestor.pouncing");
            }

            ArphexMod.queueServerWork(
               12,
               () -> entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0,
                        0.4,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0
                     )
                  )
            );
            return;
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
            && Mth.nextInt(RandomSource.create(), 1, 5) == 3
            && !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            && !entity.getPersistentData().getBoolean("crashdown")) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0,
                  2.0,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0
               )
            );
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 20, 0.8, 0.8, 0.8, 0.3);
            }

            ArphexMod.queueServerWork(
               15,
               () -> {
                  if (world.isEmptyBlock(BlockPos.containing(x, entity.getY() - 1.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, entity.getY() - 2.0, z))
                     && !entity.onGround()) {
                     entity.getPersistentData().putBoolean("crashdown", true);
                  }
               }
            );
         }
      }
   }
}
