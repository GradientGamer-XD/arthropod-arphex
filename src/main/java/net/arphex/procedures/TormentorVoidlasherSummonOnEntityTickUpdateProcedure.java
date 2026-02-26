package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.DraconFireEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.VoidSpearEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorVoidlasherSummonOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean foundnearest = false;
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof TORMENTOREntity && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var18) {
                  var18.printStackTrace();
               }
            }
         } else if (entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
            (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getPersistentData().putBoolean("tormentor_target", true);
         }

         if (!world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true).isEmpty()
            || entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
            world.addParticle((SimpleParticleType)ArphexModParticleTypes.TORMENTOR_SMOKE.get(), x, y + 14.0, z, 0.0, 0.0, 0.0);
            entity.noPhysics = false;
            entity.getPersistentData().putBoolean("tormentor_target", false);
            if (entity.isAlive()) {
               foundnearest = false;
               if (!(entity.getPersistentData().getDouble("torlasher_switch") > 0.0)) {
                  entity.getPersistentData().putDouble("torlasher_switch", 1200.0);
               } else {
                  entity.getPersistentData().putDouble("torlasher_switch", entity.getPersistentData().getDouble("torlasher_switch") - 1.0);
               }

               if (!(entity.getPersistentData().getDouble("torlasher_cooldown") > 0.0)) {
                  entity.getPersistentData().putDouble("torlasher_cooldown", 20.0);
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(250.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (!(
                        ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .tormentor_respite
                           > 0.0
                     )) {
                        if (entityiterator.getPersistentData().getBoolean("tormentor_target") && entity instanceof Mob) {
                           Mob _entity = (Mob)entity;
                           if (entityiterator instanceof LivingEntity _ent) {
                              _entity.setTarget(_ent);
                           }
                        }

                        if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
                           && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == entityiterator) {
                           entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()));
                           if (entity.getPersistentData().getDouble("torlasher_switch") > 600.0) {
                              if (entity.getPersistentData().getDouble("torlasher_switch") > 1170.0) {
                                 Level projectileLevel = entity.level();
                                 if (!projectileLevel.isClientSide()) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new DraconFireEntity(
                                                (EntityType<? extends DraconFireEntity>)ArphexModEntities.DRACON_FIRE.get(), level
                                             );
                                             entityToSpawn.setOwner(shooter);
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevel, entity, 5.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.0F, 0.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 if (world instanceof ServerLevel _level) {
                                    _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 5, 0.0, 0.0, 0.0, 0.0);
                                 }
                              }

                              if (entity.getPersistentData().getDouble("torlasher_switch") > 1070.0
                                 && entity.getPersistentData().getDouble("torlasher_switch") < 1100.0) {
                                 Level projectileLevelx = entity.level();
                                 if (!projectileLevelx.isClientSide()) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new DraconFireEntity(
                                                (EntityType<? extends DraconFireEntity>)ArphexModEntities.DRACON_FIRE.get(), level
                                             );
                                             entityToSpawn.setOwner(shooter);
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevelx, entity, 5.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.0F, 0.0F);
                                    projectileLevelx.addFreshEntity(_entityToSpawn);
                                 }

                                 if (world instanceof ServerLevel _level) {
                                    _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 5, 0.0, 0.0, 0.0, 0.0);
                                 }
                              }

                              if (entity.getPersistentData().getDouble("torlasher_switch") > 970.0
                                 && entity.getPersistentData().getDouble("torlasher_switch") < 900.0) {
                                 Level projectileLevelxx = entity.level();
                                 if (!projectileLevelxx.isClientSide()) {
                                    Projectile _entityToSpawn = (new Object() {
                                          public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new DraconFireEntity(
                                                (EntityType<? extends DraconFireEntity>)ArphexModEntities.DRACON_FIRE.get(), level
                                             );
                                             entityToSpawn.setOwner(shooter);
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevelxx, entity, 5.0F, 1);
                                    _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.0F, 0.0F);
                                    projectileLevelxx.addFreshEntity(_entityToSpawn);
                                 }

                                 if (world instanceof ServerLevel _level) {
                                    _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 5, 0.0, 0.0, 0.0, 0.0);
                                 }
                              }
                           } else if (world instanceof ServerLevel projectileLevelxxx) {
                              Projectile _entityToSpawn = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new VoidSpearEntity(
                                          (EntityType<? extends VoidSpearEntity>)ArphexModEntities.VOID_SPEAR.get(), level
                                       );
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       return entityToSpawn;
                                    }
                                 })
                                 .getArrow(projectileLevelxxx, entity, 5.0F, 1);
                              _entityToSpawn.setPos(entity.getX(), entity.getY() + 45.0, entity.getZ());
                              _entityToSpawn.shoot(1.0, 1.0, 1.0, 1.0F, 0.0F);
                              projectileLevelxxx.addFreshEntity(_entityToSpawn);
                           }

                           label143: {
                              foundnearest = true;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt50 = (LivingEntity)entity;
                                 if (_livEnt50.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                                    entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                                    break label143;
                                 }
                              }

                              if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                                 entity.setDeltaMovement(
                                    new Vec3(
                                       Math.cos((double)(entity.getYRot() - 0.0F) * (Math.PI / 180.0)) / 1.0,
                                       entity.getDeltaMovement().y(),
                                       Math.sin((double)(entity.getYRot() - 0.0F) * (Math.PI / 180.0)) / 1.0
                                    )
                                 );
                              } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                                 entity.setDeltaMovement(
                                    new Vec3(
                                       Math.cos((double)(entity.getYRot() - 180.0F) * (Math.PI / 180.0)) / 1.0,
                                       entity.getDeltaMovement().y(),
                                       Math.sin((double)(entity.getYRot() - 180.0F) * (Math.PI / 180.0)) / 1.0
                                    )
                                 );
                              } else {
                                 entity.setDeltaMovement(
                                    new Vec3(
                                       Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                                       entity.getDeltaMovement().y(),
                                       Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                                    )
                                 );
                              }
                           }

                           label137: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt66 = (LivingEntity)entity;
                                 if (_livEnt66.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                                    entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                                    break label137;
                                 }
                              }

                              if (entity.getY() < entityiterator.getY()) {
                                 entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.5, entity.getDeltaMovement().z()));
                              } else {
                                 entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.5, entity.getDeltaMovement().z()));
                              }
                           }

                           foundnearest = true;
                        }
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("torlasher_cooldown", entity.getPersistentData().getDouble("torlasher_cooldown") - 1.0);
               }
            }
         } else if (!entity.getPersistentData().getBoolean("spawned_by_player_summon") && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
            ArphexMod.queueServerWork(6000, () -> {
               if (!entity.getPersistentData().getBoolean("spawned_by_player_summon") && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }
      }
   }
}
