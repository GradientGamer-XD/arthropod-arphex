package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.BloodthirstyTendrilEntity;
import net.arphex.entity.ScorpioidCloneEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ScorpioidBloodlusterEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity.getPersistentData().getDouble("attackcycle") == 3.0
            && world.getEntitiesOfClass(ScorpioidCloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CLONE.get())
                  .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CLONE.get())
                  .spawn(_levelx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         if (entity.getPersistentData().getDouble("attackcycle") == 16.0) {
            entity.getPersistentData().putDouble("attackcycle", 15.0);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(
                  new MobEffectInstance((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get(), Mth.nextInt(RandomSource.create(), 250, 300), 1, false, false)
               );
            }
         }

         if (entity.getPersistentData().getDouble("attackcycle") == 13.0) {
            entity.getPersistentData().putDouble("attackcycle", 12.0);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(
                  new MobEffectInstance((MobEffect)ArphexModMobEffects.FORCE_POWER.get(), Mth.nextInt(RandomSource.create(), 150, 200), 1, false, false)
               );
            }
         }

         if ((entity.getPersistentData().getDouble("attackcycle") == 8.0 || entity.getPersistentData().getDouble("attackcycle") > 25.0)
            && Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - (float)Mth.nextInt(RandomSource.create(), 90, 180)) * (Math.PI / 180.0)) / 2.0,
                     Mth.nextDouble(RandomSource.create(), -0.4, 0.4),
                     Math.sin((double)(entity.getYRot() - (float)Mth.nextInt(RandomSource.create(), 90, 180)) * (Math.PI / 180.0)) / 2.0
                  )
               );
            } else {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 90, 180)) * (Math.PI / 180.0)) / 2.0,
                     Mth.nextDouble(RandomSource.create(), -0.4, 0.4),
                     Math.sin((double)(entity.getYRot() + (float)Mth.nextInt(RandomSource.create(), 90, 180)) * (Math.PI / 180.0)) / 2.0
                  )
               );
            }
         }

         if ((
               entity.getPersistentData().getDouble("attackcycle") == 5.0
                  || entity.getPersistentData().getDouble("attackcycle") == 15.0
                  || entity.getPersistentData().getDouble("attackcycle") == 20.0
            )
            && (entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0,
                  Mth.nextDouble(RandomSource.create(), 0.0, 0.4),
                  Math.sin((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(
                  new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), Mth.nextInt(RandomSource.create(), 40, 80), 1, false, false)
               );
            }

            if (world.getEntitiesOfClass(BloodthirstyTendrilEntity.class, AABB.ofSize(new Vec3(x, y, z), 6.0, 6.0, 6.0), e -> true).isEmpty()) {
               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new BloodthirstyTendrilEntity(
                              (EntityType<? extends BloodthirstyTendrilEntity>)ArphexModEntities.BLOODTHIRSTY_TENDRIL.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setSecondsOnFire(100);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, (float)(Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get()) + 5L), 1);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.0F, 0.3F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - 180.0F) * (Math.PI / 180.0)) / 2.0,
                     Mth.nextDouble(RandomSource.create(), 0.0, 0.2),
                     Math.sin((double)(entity.getYRot() - 180.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            } else {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - 0.0F) * (Math.PI / 180.0)) / 2.0,
                     Mth.nextDouble(RandomSource.create(), 0.0, 0.2),
                     Math.sin((double)(entity.getYRot() - 0.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            }
         }

         if (sourceentity != null && world instanceof Level _levelxx) {
            if (!_levelxx.isClientSide()) {
               _levelxx.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream")),
                  SoundSource.HOSTILE,
                  0.4F,
                  0.1F
               );
            } else {
               _levelxx.playLocalSound(
                  x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscream")), SoundSource.HOSTILE, 0.4F, 0.1F, false
               );
            }
         }
      }
   }
}
