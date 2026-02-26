package net.arphex.procedures;

import net.arphex.entity.ChronoSpearShotEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class VisionarySpearOnPlayerStoppedUsingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            return;
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns().addCooldown(itemstack.getItem(), (entity instanceof LivingEntity _entUseTicks2 ? _entUseTicks2.getTicksUsingItem() : 0) * 2);
         }

         if (!entity.isShiftKeyDown()) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 1, 0.0, 0.0, 0.0, 0.0);
            }

            if ((entity instanceof LivingEntity _entUseTicks7 ? _entUseTicks7.getTicksUsingItem() : 0) > 40) {
               if (world instanceof ServerLevel projectileLevel) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                              (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, 20.0F, 3);
                  _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                  _entityToSpawn.shoot(1.0, 0.0, 0.0, 1.5F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if (world instanceof ServerLevel projectileLevel) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                              (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, 20.0F, 3);
                  _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                  _entityToSpawn.shoot(-1.0, 0.0, 0.0, 1.5F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if (world instanceof ServerLevel projectileLevel) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                              (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, 20.0F, 3);
                  _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                  _entityToSpawn.shoot(0.0, 0.0, 1.0, 1.5F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if (world instanceof ServerLevel projectileLevel) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                              (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, 20.0F, 3);
                  _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                  _entityToSpawn.shoot(0.0, 0.0, -1.0, 1.5F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if ((entity instanceof LivingEntity _entUseTicks28 ? _entUseTicks28.getTicksUsingItem() : 0) > 80) {
                  if (world instanceof ServerLevel projectileLevel) {
                     Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                                 (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              return entityToSpawn;
                           }
                        })
                        .getArrow(projectileLevel, entity, 20.0F, 3);
                     _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                     _entityToSpawn.shoot(0.77, 0.0, 0.77, 1.5F, 0.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }

                  if (world instanceof ServerLevel projectileLevel) {
                     Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                                 (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              return entityToSpawn;
                           }
                        })
                        .getArrow(projectileLevel, entity, 20.0F, 3);
                     _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                     _entityToSpawn.shoot(-0.77, 0.0, -0.77, 1.5F, 0.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }

                  if (world instanceof ServerLevel projectileLevel) {
                     Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                                 (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              return entityToSpawn;
                           }
                        })
                        .getArrow(projectileLevel, entity, 20.0F, 3);
                     _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                     _entityToSpawn.shoot(0.77, 0.0, -0.77, 1.5F, 0.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }

                  if (world instanceof ServerLevel projectileLevel) {
                     Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                                 (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              return entityToSpawn;
                           }
                        })
                        .getArrow(projectileLevel, entity, 20.0F, 3);
                     _entityToSpawn.setPos(entity.getX(), entity.getY() + 1.0, entity.getZ());
                     _entityToSpawn.shoot(-0.77, 0.0, 0.77, 1.5F, 0.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }
            }
         }
      }
   }
}
