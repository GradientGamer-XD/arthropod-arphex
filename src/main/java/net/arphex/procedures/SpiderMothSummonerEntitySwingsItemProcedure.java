package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothSummonEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderMothSummonerEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.isPassenger()) {
            ArphexMod.queueServerWork(
               4,
               () -> {
                  if (entity.isPassenger() && entity.getVehicle() instanceof SpiderMothSummonEntity) {
                     if (entity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown(itemstack.getItem())) {
                        return;
                     }

                     if (entity instanceof Player _player) {
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 60);
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entity != entityiterator && !(entity instanceof SpiderMothSummonEntity)) {
                           if (entityiterator instanceof TamableAnimal) {
                              TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                                    continue;
                                 }
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 2));
                              }
                           }
                        }
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5);
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 80, 0.5, 0.5, 0.3, 0.5);
                     }

                     ArphexMod.queueServerWork(
                        3,
                        () -> {
                           if (world instanceof ServerLevel _levelxx) {
                              _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5);
                           }

                           if (world instanceof ServerLevel _levelx) {
                              _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5);
                           }

                           ArphexMod.queueServerWork(
                              3,
                              () -> {
                                 if (world instanceof ServerLevel _levelxxxx) {
                                    _levelxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5);
                                 }

                                 if (world instanceof ServerLevel _levelxxx) {
                                    _levelxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5);
                                 }

                                 ArphexMod.queueServerWork(
                                    3,
                                    () -> {
                                       if (world instanceof ServerLevel _levelxxxxxx) {
                                          _levelxxxxxx.sendParticles(
                                             (SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5
                                          );
                                       }

                                       if (world instanceof ServerLevel _levelxxxxx) {
                                          _levelxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5);
                                       }

                                       Vec3 _centerx = new Vec3(x, y, z);

                                       for (Entity entityiteratorx : world.getEntitiesOfClass(
                                             Entity.class, new AABB(_centerx, _centerx).inflate(5.0), e -> true
                                          )
                                          .stream()
                                          .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                          .toList()) {
                                          if (entity != entityiteratorx && !(entity instanceof SpiderMothSummonEntity)) {
                                             if (entityiteratorx instanceof TamableAnimal) {
                                                TamableAnimal _tamIsTamedByx = (TamableAnimal)entityiteratorx;
                                                if (entity instanceof LivingEntity) {
                                                   LivingEntity _livEntx = (LivingEntity)entity;
                                                   if (_tamIsTamedByx.isOwnedBy(_livEntx)) {
                                                      continue;
                                                   }
                                                }
                                             }

                                             if (entityiteratorx instanceof LivingEntity) {
                                                LivingEntity _entityx = (LivingEntity)entityiteratorx;
                                                if (!_entityx.level().isClientSide()) {
                                                   _entityx.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 2));
                                                }
                                             }
                                          }
                                       }

                                       ArphexMod.queueServerWork(
                                          3,
                                          () -> {
                                             if (world instanceof ServerLevel _levelxxxxxxxx) {
                                                _levelxxxxxxxx.sendParticles(
                                                   (SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5
                                                );
                                             }

                                             if (world instanceof ServerLevel _levelxxxxxxx) {
                                                _levelxxxxxxx.sendParticles(
                                                   (SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5
                                                );
                                             }

                                             ArphexMod.queueServerWork(
                                                3,
                                                () -> {
                                                   if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                                                      _levelxxxxxxxxxx.sendParticles(
                                                         (SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5
                                                      );
                                                   }

                                                   if (world instanceof ServerLevel _levelxxxxxxxxx) {
                                                      _levelxxxxxxxxx.sendParticles(
                                                         (SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5
                                                      );
                                                   }

                                                   ArphexMod.queueServerWork(
                                                      3,
                                                      () -> {
                                                         if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                                                            _levelxxxxxxxxxxxx.sendParticles(
                                                               (SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5
                                                            );
                                                         }

                                                         if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                                                            _levelxxxxxxxxxxx.sendParticles(
                                                               (SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 80, 0.5, 0.5, 0.5, 0.5
                                                            );
                                                         }

                                                         Vec3 _centerx = new Vec3(x, y, z);

                                                         for (Entity entityiteratorxx : world.getEntitiesOfClass(
                                                               Entity.class, new AABB(_centerx, _centerx).inflate(5.0), e -> true
                                                            )
                                                            .stream()
                                                            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                                            .toList()) {
                                                            if (entity != entityiteratorxx && !(entity instanceof SpiderMothSummonEntity)) {
                                                               if (entityiteratorxx instanceof TamableAnimal) {
                                                                  TamableAnimal _tamIsTamedByxx = (TamableAnimal)entityiteratorxx;
                                                                  if (entity instanceof LivingEntity) {
                                                                     LivingEntity _livEntxx = (LivingEntity)entity;
                                                                     if (_tamIsTamedByxx.isOwnedBy(_livEntxx)) {
                                                                        continue;
                                                                     }
                                                                  }
                                                               }

                                                               if (entityiteratorxx instanceof LivingEntity) {
                                                                  LivingEntity _entityxx = (LivingEntity)entityiteratorxx;
                                                                  if (!_entityxx.level().isClientSide()) {
                                                                     _entityxx.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 2));
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   );
                                                }
                                             );
                                          }
                                       );
                                    }
                                 );
                              }
                           );
                        }
                     );
                  }
               }
            );
         }
      }
   }
}
