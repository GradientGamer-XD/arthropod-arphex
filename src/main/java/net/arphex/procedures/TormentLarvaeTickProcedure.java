package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.MiniatureCoreEntity;
import net.arphex.entity.TormentorLarvaeEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentLarvaeTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ArphexMod.queueServerWork(100, () -> entity.getPersistentData().putBoolean("ready", true));
         if ((!(entity instanceof LivingEntity _livEnt2) || !_livEnt2.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 0, false, false));
         }

         if (entity.getPersistentData().getBoolean("ready")) {
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null && !world.isClientSide()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                     (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                     (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                  )
               );
            }

            if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator.getPersistentData().getBoolean("tormentor_target")) {
                        if (entityiterator instanceof Player) {
                           if (!(
                                 ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                          .orElse(new ArphexModVariables.PlayerVariables()))
                                       .tormentor_respite
                                    > 0.0
                              )
                              && entity instanceof Mob) {
                              Mob _entity = (Mob)entity;
                              if (entityiterator instanceof LivingEntity _ent) {
                                 _entity.setTarget(_ent);
                              }
                           }
                        } else if (entity instanceof Mob) {
                           Mob _entity = (Mob)entity;
                           if (entityiterator instanceof LivingEntity _ent) {
                              _entity.setTarget(_ent);
                           }
                        }
                     }
                  }
               } else {
                  if (((ArphexModVariables.PlayerVariables)(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                              .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .tormentor_respite
                        > 0.0
                     && entity instanceof Mob) {
                     try {
                        ((Mob)entity).setTarget(null);
                     } catch (Exception var15) {
                        var15.printStackTrace();
                     }
                  }

                  if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                     if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
                        Level projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                    AbstractArrow entityToSpawn = new MiniatureCoreEntity(
                                       (EntityType<? extends MiniatureCoreEntity>)ArphexModEntities.MINIATURE_CORE.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    entityToSpawn.setPierceLevel(piercing);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 1.0F, 1, (byte)1);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.8F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     } else if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 4.0) {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5,
                              0.3,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5
                           )
                        );
                     } else {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5,
                              -0.2,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5
                           )
                        );
                     }
                  }
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 4, 0.5, 0.5, 0.5, 0.1);
               }

               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 40));
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }

            if (entity.isInWater()) {
               entity.setDeltaMovement(
                  new Vec3(entity.getDeltaMovement().x() / 8.0, Mth.nextDouble(RandomSource.create(), 0.3, 0.8), entity.getDeltaMovement().z() / 8.0)
               );
            }

            entity.noPhysics = true;
            if (ArphexModVariables.MapVariables.get(world).tormentor_health < 200.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2, false, false));
            }

            if ((entity instanceof TormentorLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorLarvaeEntity.DATA_sizevar) : 0) > 10) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
               }

               if ((entity instanceof TormentorLarvaeEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorLarvaeEntity.DATA_sizevar) : 0) > 20) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
                  }

                  if ((entity instanceof TormentorLarvaeEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TormentorLarvaeEntity.DATA_sizevar) : 0)
                     > 28) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 4, 0.5, 0.5, 0.5, 0.1);
                     }
                  }
               }
            }

            if (!entity.getPersistentData().getBoolean("spawnedbyplayer")) {
               ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1600, 4800), () -> {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               });
            }
         }

         entity.getPersistentData().putBoolean("tormentor_summon", true);
      }
   }
}
