package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.HomingVoidseekerEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VoidseekerHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
            && (entity instanceof LivingEntity _entUseTicks2 ? _entUseTicks2.getTicksUsingItem() : 0) > 0) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.2);
            }

            label158:
            if (entity.isShiftKeyDown()) {
               entity.getPersistentData().putDouble("distancetravelledvoid", 0.0);
               if (entity instanceof Player _plrCldCheck7
                  && _plrCldCheck7.getCooldowns()
                     .isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())) {
                  break label158;
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
               }

               entity.getPersistentData().putBoolean("sneakfire", true);
               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new HomingVoidseekerEntity(
                              (EntityType<? extends HomingVoidseekerEntity>)ArphexModEntities.HOMING_VOIDSEEKER.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, 50.0F, 3);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            } else {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(
                     (SimpleParticleType)ArphexModParticleTypes.HEAVY_WHITE_SMOKES.get(),
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("zoomglow"))),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("zoomglow"))),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY(),
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("zoomglow"))),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ(),
                     5,
                     0.1,
                     0.1,
                     0.1,
                     0.1
                  );
               }

               Vec3 _center = new Vec3(
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("zoomglow"))),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getX(),
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("zoomglow"))),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getY(),
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("zoomglow"))),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getZ()
               );

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entity instanceof LivingEntity _entUseTicks26 ? _entUseTicks26.getTicksUsingItem() : 0) >= 5) {
                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ZOOM.get(), 8, 0, false, false));
                     }

                     if (entity != entityiterator) {
                        if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)
                           )
                         {
                           continue;
                        }

                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.HEALTH_ANALYSIS.get(), 8, 0, false, false));
                        }

                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 8, 0, false, false));
                        }

                        if (entityiterator instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect((MobEffect)ArphexModMobEffects.HEALTH_ANALYSIS.get())) {
                           label174: {
                              entity.getPersistentData().putDouble("zoomglow", 0.0);
                              entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 0.5, entityiterator.getZ()));
                              if (entity instanceof Player _plrCldCheck39
                                 && _plrCldCheck39.getCooldowns()
                                    .isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())) {
                                 break label174;
                              }

                              if (entity instanceof Player _player) {
                                 _player.getCooldowns()
                                    .addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
                              }

                              entity.getPersistentData().putBoolean("sneakfire", false);
                              Level projectileLevel = entity.level();
                              if (!projectileLevel.isClientSide()) {
                                 Projectile _entityToSpawn = (new Object() {
                                       public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                          AbstractArrow entityToSpawn = new HomingVoidseekerEntity(
                                             (EntityType<? extends HomingVoidseekerEntity>)ArphexModEntities.HOMING_VOIDSEEKER.get(), level
                                          );
                                          entityToSpawn.setOwner(shooter);
                                          entityToSpawn.setBaseDamage((double)damage);
                                          entityToSpawn.setKnockback(knockback);
                                          entityToSpawn.setSilent(true);
                                          return entityToSpawn;
                                       }
                                    })
                                    .getArrow(projectileLevel, entity, 45.0F, 3);
                                 _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                 _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }
                           }

                           if (entityiterator.isAlive()) {
                              entity.getPersistentData().putDouble("voidtrackingx", entityiterator.getX());
                              entity.getPersistentData().putDouble("voidtrackingy", entityiterator.getY());
                              entity.getPersistentData().putDouble("voidtrackingz", entityiterator.getZ());
                              ArphexMod.queueServerWork(
                                 20,
                                 () -> {
                                    if (entityiterator.isAlive()) {
                                       entity.getPersistentData().putDouble("voidtrackingx", entityiterator.getX());
                                       entity.getPersistentData().putDouble("voidtrackingy", entityiterator.getY());
                                       entity.getPersistentData().putDouble("voidtrackingz", entityiterator.getZ());
                                       ArphexMod.queueServerWork(
                                          20,
                                          () -> {
                                             if (entityiterator.isAlive()) {
                                                entity.getPersistentData().putDouble("voidtrackingx", entityiterator.getX());
                                                entity.getPersistentData().putDouble("voidtrackingy", entityiterator.getY());
                                                entity.getPersistentData().putDouble("voidtrackingz", entityiterator.getZ());
                                                ArphexMod.queueServerWork(
                                                   20,
                                                   () -> {
                                                      if (entityiterator.isAlive()) {
                                                         entity.getPersistentData().putDouble("voidtrackingx", entityiterator.getX());
                                                         entity.getPersistentData().putDouble("voidtrackingy", entityiterator.getY());
                                                         entity.getPersistentData().putDouble("voidtrackingz", entityiterator.getZ());
                                                         ArphexMod.queueServerWork(
                                                            20,
                                                            () -> {
                                                               if (entityiterator.isAlive()) {
                                                                  entity.getPersistentData().putDouble("voidtrackingx", entityiterator.getX());
                                                                  entity.getPersistentData().putDouble("voidtrackingy", entityiterator.getY());
                                                                  entity.getPersistentData().putDouble("voidtrackingz", entityiterator.getZ());
                                                                  ArphexMod.queueServerWork(
                                                                     20,
                                                                     () -> {
                                                                        if (entityiterator.isAlive()) {
                                                                           entity.getPersistentData().putDouble("voidtrackingx", entityiterator.getX());
                                                                           entity.getPersistentData().putDouble("voidtrackingy", entityiterator.getY());
                                                                           entity.getPersistentData().putDouble("voidtrackingz", entityiterator.getZ());
                                                                           ArphexMod.queueServerWork(
                                                                              20,
                                                                              () -> {
                                                                                 if (entityiterator.isAlive()) {
                                                                                    entity.getPersistentData()
                                                                                       .putDouble("voidtrackingx", entityiterator.getX());
                                                                                    entity.getPersistentData()
                                                                                       .putDouble("voidtrackingy", entityiterator.getY());
                                                                                    entity.getPersistentData()
                                                                                       .putDouble("voidtrackingz", entityiterator.getZ());
                                                                                    ArphexMod.queueServerWork(
                                                                                       20,
                                                                                       () -> {
                                                                                          if (entityiterator.isAlive()) {
                                                                                             entity.getPersistentData()
                                                                                                .putDouble("voidtrackingx", entityiterator.getX());
                                                                                             entity.getPersistentData()
                                                                                                .putDouble("voidtrackingy", entityiterator.getY());
                                                                                             entity.getPersistentData()
                                                                                                .putDouble("voidtrackingz", entityiterator.getZ());
                                                                                             ArphexMod.queueServerWork(
                                                                                                20,
                                                                                                () -> {
                                                                                                   if (entityiterator.isAlive()) {
                                                                                                      entity.getPersistentData()
                                                                                                         .putDouble("voidtrackingx", entityiterator.getX());
                                                                                                      entity.getPersistentData()
                                                                                                         .putDouble("voidtrackingy", entityiterator.getY());
                                                                                                      entity.getPersistentData()
                                                                                                         .putDouble("voidtrackingz", entityiterator.getZ());
                                                                                                      ArphexMod.queueServerWork(
                                                                                                         20,
                                                                                                         () -> {
                                                                                                            if (entityiterator.isAlive()) {
                                                                                                               entity.getPersistentData()
                                                                                                                  .putDouble(
                                                                                                                     "voidtrackingx", entityiterator.getX()
                                                                                                                  );
                                                                                                               entity.getPersistentData()
                                                                                                                  .putDouble(
                                                                                                                     "voidtrackingy", entityiterator.getY()
                                                                                                                  );
                                                                                                               entity.getPersistentData()
                                                                                                                  .putDouble(
                                                                                                                     "voidtrackingz", entityiterator.getZ()
                                                                                                                  );
                                                                                                               ArphexMod.queueServerWork(
                                                                                                                  20,
                                                                                                                  () -> {
                                                                                                                     if (entityiterator.isAlive()) {
                                                                                                                        entity.getPersistentData()
                                                                                                                           .putDouble(
                                                                                                                              "voidtrackingx",
                                                                                                                              entityiterator.getX()
                                                                                                                           );
                                                                                                                        entity.getPersistentData()
                                                                                                                           .putDouble(
                                                                                                                              "voidtrackingy",
                                                                                                                              entityiterator.getY()
                                                                                                                           );
                                                                                                                        entity.getPersistentData()
                                                                                                                           .putDouble(
                                                                                                                              "voidtrackingz",
                                                                                                                              entityiterator.getZ()
                                                                                                                           );
                                                                                                                     }
                                                                                                                  }
                                                                                                               );
                                                                                                            }
                                                                                                         }
                                                                                                      );
                                                                                                   }
                                                                                                }
                                                                                             );
                                                                                          }
                                                                                       }
                                                                                    );
                                                                                 }
                                                                              }
                                                                           );
                                                                        }
                                                                     }
                                                                  );
                                                               }
                                                            }
                                                         );
                                                      }
                                                   }
                                                );
                                             }
                                          }
                                       );
                                    }
                                 }
                              );
                           }
                        }
                     }
                  }
               }

               if ((entity instanceof LivingEntity _entUseTicks133 ? _entUseTicks133.getTicksUsingItem() : 0) <= 1) {
                  entity.getPersistentData().putDouble("zoomglow", 6.0);
               } else if (!(entity.getPersistentData().getDouble("zoomglow") > 240.0)) {
                  entity.getPersistentData().putDouble("zoomglow", entity.getPersistentData().getDouble("zoomglow") + 4.0);
               } else {
                  entity.getPersistentData().putDouble("zoomglow", 6.0);
               }
            }
         }

         if (entity.isShiftKeyDown() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ZOOM.get(), 5, 1, false, false));
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:voidseeker_obtain"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }
      }
   }
}
