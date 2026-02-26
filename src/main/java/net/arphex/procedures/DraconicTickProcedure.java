package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.DraconFireEntity;
import net.arphex.entity.DraconicCloneEntity;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.entity.VoidSpearEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DraconicTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         boolean found2 = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double tx = 0.0;
         double ty = 0.0;
         double tz = 0.0;
         double randomxside = 0.0;
         double randomzside = 0.0;
         double yhalf = 0.0;
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         Entity nearestplayer250 = null;
         Entity nearestplayer80 = null;
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
         }

         if ((Boolean)ConfigurationSettingsConfiguration.DWELLER_HEALTH.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 60.0F
            && entity instanceof LivingEntity _entity) {
            _entity.setHealth(60.0F);
         }

         if (entity.getPersistentData().getDouble("levattack") <= 0.0) {
            entity.getPersistentData().putDouble("levattack", entity.getPersistentData().getDouble("levattack") - 1.0);
         }

         if (!(Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "voidlasher-bosses-disabled";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), ex -> true).isEmpty()) {
            nearestplayer250 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), ex -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (!nearestplayer250.getPersistentData().getBoolean("creativespectator")) {
               nearestplayer250.getPersistentData().putBoolean("voidnear", true);
               if (entity instanceof Mob _entity && nearestplayer250 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }
         }

         if ((entity instanceof SpiderMothDwellerEntity _datEntS ? (String)_datEntS.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack) : "")
            .equals("forcewall")) {
            entity.setSprinting(true);
            entity.setShiftKeyDown(false);
         } else {
            entity.setSprinting(false);
            if ((entity instanceof SpiderMothDwellerEntity _datEntS ? (String)_datEntS.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack) : "")
               .equals("forcecharge")) {
               entity.setShiftKeyDown(true);
            } else {
               entity.setShiftKeyDown(false);
            }
         }

         boolean var339;
         label1852: {
            if (entity instanceof SpiderMothDwellerEntity _datEntL21 && (Boolean)_datEntL21.getEntityData().get(SpiderMothDwellerEntity.DATA_primed)) {
               var339 = true;
               break label1852;
            }

            var339 = false;
         }

         if (var339
            || world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).isEmpty()
            || !(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                        } else {
                           return _ent.level().isClientSide() && _ent instanceof Player _player
                              ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                 && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL
                              : false;
                        }
                     }
                  })
                  .checkGamemode(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null)
                  )
               && !(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                        } else {
                           return _ent.level().isClientSide() && _ent instanceof Player _player
                              ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                 && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL
                              : false;
                        }
                     }
                  })
                  .checkGamemode(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null)
                  )) {
            if ((entity instanceof SpiderMothDwellerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMothDwellerEntity.DATA_attacktimer) : 0) <= 0
               )
             {
               if (Mth.nextInt(RandomSource.create(), 1, 5) != 1) {
                  label1826:
                  if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
                     if (!(entity instanceof SpiderMothDwellerEntity _datEntS
                              ? (String)_datEntS.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                              : "")
                           .equals("forcewall")
                        && entity instanceof SpiderMothDwellerEntity _datEntL42
                        && (Boolean)_datEntL42.getEntityData().get(SpiderMothDwellerEntity.DATA_primed)) {
                        if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                           _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcecharge");
                        }

                        ArphexMod.queueServerWork(
                           40,
                           () -> {
                              if (entity.isAlive() && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
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
                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.5F, 0.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                 }

                                 ArphexMod.queueServerWork(
                                    100,
                                    () -> {
                                       if (entity.isAlive()
                                          && (entity instanceof SpiderMothDwellerEntity _datEntSx
                                                ? (String)_datEntSx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                                                : "")
                                             .equals("forcecharge")) {
                                          Level projectileLevelx = entity.level();
                                          if (!projectileLevelx.isClientSide()) {
                                             Projectile _entityToSpawnx = (new Object() {
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
                                             _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                             _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.5F, 0.0F);
                                             projectileLevelx.addFreshEntity(_entityToSpawnx);
                                          }
                                       }
                                    }
                                 );
                              }
                           }
                        );
                        break label1826;
                     }

                     if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forceshield");
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
                     if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcelifesteal");
                     }

                     if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                        Vec3 _center = new Vec3(x, y, z);

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), ex -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (!(entityiterator instanceof SpiderMothDwellerEntity)
                              && !entityiterator.getPersistentData().getBoolean("creativespectator")
                              && !(entityiterator instanceof ItemEntity)) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt63 = (LivingEntity)entity;
                                 if (_livEnt63.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt64 = (LivingEntity)entityiterator;
                                       if (_livEnt64.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())) {
                                          continue;
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(
                                             new MobEffectInstance(
                                                (MobEffect)ArphexModMobEffects.CHAOS_TARGET.get(), Mth.nextInt(RandomSource.create(), 50, 200), 1, false, false
                                             )
                                          );
                                       }
                                    }
                                    continue;
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt67 = (LivingEntity)entity;
                                 if (_livEnt67.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())) {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt68 = (LivingEntity)entityiterator;
                                       if (_livEnt68.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                                          continue;
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(
                                             new MobEffectInstance(
                                                (MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get(),
                                                Mth.nextInt(RandomSource.create(), 50, 200),
                                                1,
                                                false,
                                                false
                                             )
                                          );
                                       }
                                    }
                                    continue;
                                 }
                              }

                              LivingEntity _livEnt73 = entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null;
                              if (_livEnt73 instanceof LivingEntity) {
                                 LivingEntity _livEnt72 = _livEnt73;
                                 if (_livEnt72.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                                    if (entityiterator instanceof LivingEntity) {
                                       _livEnt73 = (LivingEntity)entityiterator;
                                       if (_livEnt73.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                                          continue;
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(
                                             new MobEffectInstance(
                                                (MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get(),
                                                Mth.nextInt(RandomSource.create(), 50, 200),
                                                1,
                                                false,
                                                false
                                             )
                                          );
                                       }
                                    }
                                    continue;
                                 }
                              }

                              LivingEntity _livEnt78 = entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null;
                              if (_livEnt78 instanceof LivingEntity) {
                                 LivingEntity _livEnt77 = _livEnt78;
                                 if (_livEnt77.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())) {
                                    if (entityiterator instanceof LivingEntity) {
                                       _livEnt78 = (LivingEntity)entityiterator;
                                       if (_livEnt78.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())) {
                                          continue;
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(
                                             new MobEffectInstance(
                                                (MobEffect)ArphexModMobEffects.CHAOS_TARGET.get(), Mth.nextInt(RandomSource.create(), 50, 200), 1, false, false
                                             )
                                          );
                                       }
                                    }
                                    continue;
                                 }
                              }

                              if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                                 if (entityiterator instanceof LivingEntity) {
                                    _livEnt78 = (LivingEntity)entityiterator;
                                    if (_livEnt78.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                                       continue;
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(
                                          new MobEffectInstance(
                                             (MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get(),
                                             Mth.nextInt(RandomSource.create(), 50, 200),
                                             1,
                                             false,
                                             false
                                          )
                                       );
                                    }
                                 }
                              } else {
                                 if (entityiterator instanceof LivingEntity) {
                                    _livEnt78 = (LivingEntity)entityiterator;
                                    if (_livEnt78.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())) {
                                       continue;
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(
                                          new MobEffectInstance(
                                             (MobEffect)ArphexModMobEffects.CHAOS_TARGET.get(), Mth.nextInt(RandomSource.create(), 50, 200), 1, false, false
                                          )
                                       );
                                    }
                                 }
                              }
                           }
                        }
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                     if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcepull");
                     }

                     entity.getPersistentData().putDouble("weaponfire", 33.0);
                     ArphexMod.queueServerWork(7, () -> {
                        entity.getPersistentData().putDouble("weaponfire", 33.0);
                        ArphexMod.queueServerWork(7, () -> entity.getPersistentData().putDouble("weaponfire", 39.0));
                     });
                  } else if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forceshield");
                  }
               } else if ((entity instanceof SpiderMothDwellerEntity _datEntS
                     ? (String)_datEntS.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcecharge")) {
                  if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forceshield");
                  }
               } else {
                  if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcewall");
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 1 && entity.getPersistentData().getDouble("levattack") <= 0.0) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 55, 3.0, 0.4, 3.0, 0.3);
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), ex -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (!(entityiteratorx instanceof SpiderMothDwellerEntity)
                           && !entityiteratorx.getPersistentData().getBoolean("creativespectator")
                           && entityiteratorx instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiteratorx;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 1, false, false));
                           }
                        }
                     }

                     entity.getPersistentData().putDouble("levattack", 500.0);
                  }
               }

               if (entity instanceof SpiderMothDwellerEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderMothDwellerEntity.DATA_attacktimer, Mth.nextInt(RandomSource.create(), 100, 350));
               }
            } else if (entity instanceof SpiderMothDwellerEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderMothDwellerEntity.DATA_attacktimer,
                     (entity instanceof SpiderMothDwellerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMothDwellerEntity.DATA_attacktimer) : 0)
                        - 1
                  );
            }
         } else if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
            _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcewall");
         }

         if ((entity.isShiftKeyDown() || entity.isSprinting()) && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 20, false, false));
            }

            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
            entity.getPersistentData().putBoolean("usingpower", true);
         } else {
            entity.getPersistentData().putBoolean("usingpower", false);
         }

         if (world.getBlockState(BlockPos.containing(x, y - 0.1, z)).getBlock() instanceof LiquidBlock) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.1, entity.getDeltaMovement().z()));
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            entity.getPersistentData().putDouble("radius", 4.0);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 20, false, false));
            }

            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
         } else if (entity instanceof SpiderMothDwellerEntity _datEntL122 && (Boolean)_datEntL122.getEntityData().get(SpiderMothDwellerEntity.DATA_primed)) {
            label1737: {
               if (entity instanceof SpiderMothDwellerEntity _datEntL123 && (Boolean)_datEntL123.getEntityData().get(SpiderMothDwellerEntity.DATA_primed)) {
                  var339 = true;
                  break label1737;
               }

               var339 = false;
            }

            if (var339
               || world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).isEmpty()
               || !(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                           } else {
                              return _ent.level().isClientSide() && _ent instanceof Player _player
                                 ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                       == GameType.SURVIVAL
                                 : false;
                           }
                        }
                     })
                     .checkGamemode(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null)
                     )
                  && !(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                           } else {
                              return _ent.level().isClientSide() && _ent instanceof Player _player
                                 ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                       == GameType.ADVENTURE
                                 : false;
                           }
                        }
                     })
                     .checkGamemode(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null)
                     )) {
               if ((entity instanceof SpiderMothDwellerEntity _datEntSx
                     ? (String)_datEntSx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcewall")) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y + 2.0, z, 10, 2.0, 2.0, 2.0, 0.0);
                  }

                  if (!world.getEntitiesOfClass(
                           LivingEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
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
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
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
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getZ()
                              ),
                              10.0,
                              10.0,
                              10.0
                           ),
                           ex -> true
                        )
                        .isEmpty()
                     && (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
                     && world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
                                    (double)entity.level()
                                       .clip(
                                          new ClipContext(
                                             entity.getEyePosition(1.0F),
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                             Block.OUTLINE,
                                             Fluid.NONE,
                                             entity
                                          )
                                       )
                                       .getBlockPos()
                                       .getZ()
                                 ),
                                 10.0,
                                 10.0,
                                 10.0
                              ),
                              ex -> true
                           )
                           .stream()
                           .sorted(
                              (new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 })
                                 .compareDistOf(
                                    (double)entity.level()
                                       .clip(
                                          new ClipContext(
                                             entity.getEyePosition(1.0F),
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                             Block.OUTLINE,
                                             Fluid.NONE,
                                             entity
                                          )
                                       )
                                       .getBlockPos()
                                       .getZ()
                                 )
                           )
                           .findFirst()
                           .orElse(null)
                        == (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 4));
                     }

                     if ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) instanceof LivingEntity _entity
                        && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 1));
                     }

                     lineX = entity.getX() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX();
                     lineY = entity.getY() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY();
                     lineZ = entity.getZ() - (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getZ();
                     expand = expand;

                     for (int index0 = 0; index0 < 10; index0++) {
                        if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof ServerLevel _level) {
                           _level.sendParticles(
                              (SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(),
                              entity.getX() + lineX * expand,
                              entity.getY() + lineY * expand,
                              entity.getZ() + lineZ * expand,
                              1,
                              0.05,
                              0.2,
                              0.05,
                              0.0
                           );
                        }

                        expand -= 0.1;
                     }
                  }
               } else if ((entity instanceof SpiderMothDwellerEntity _datEntSx
                     ? (String)_datEntSx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcecharge")) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(), x, y + 2.0, z, 10, 2.0, 2.0, 2.0, 0.0);
                  }

                  if (entity.getPersistentData().getDouble("animtime") > 5.0 && world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y + 4.0, z, 30, 1.0, 1.0, 1.0, 0.3);
                  }
               } else if ((entity instanceof SpiderMothDwellerEntity _datEntSx
                     ? (String)_datEntSx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forceshield")) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.PURPLE_GLINTS.get(), x, y + 2.0, z, 30, 2.0, 2.0, 2.0, 0.0);
                  }

                  if (entity.getPersistentData().getDouble("voidspear") == 5.0) {
                     Level projectileLevel = entity.level();
                     if (!projectileLevel.isClientSide()) {
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
                           .getArrow(projectileLevel, entity, 0.0F, 1);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 50, 1, false, false));
                     }
                  }
               } else if (!(entity instanceof SpiderMothDwellerEntity _datEntSx
                     ? (String)_datEntSx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcepull")) {
                  if ((entity instanceof SpiderMothDwellerEntity _datEntSxx
                        ? (String)_datEntSxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                        : "")
                     .equals("forcelifesteal")) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y + 2.0, z, 2, 2.6, 2.4, 2.6, 0.0);
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), ex -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if ((entity.getPersistentData().getDouble("weaponfire") == 2.0 || entity.getPersistentData().getDouble("weaponfire") == 22.0)
                           && !(entityiteratorxx instanceof SpiderMothDwellerEntity)
                           && !entityiteratorxx.getPersistentData().getBoolean("creativespectator")
                           && entityiteratorxx instanceof LivingEntity) {
                           entityiteratorxx.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F
                           );
                           entityiteratorxx.setDeltaMovement(
                              new Vec3(
                                 (x + entityiteratorxx.getX())
                                    * (double)(
                                       300.0F / (200.0F + (entityiteratorxx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)) / 25.0F
                                    )
                                    / 10.0,
                                 0.5,
                                 (x + entityiteratorxx.getX())
                                    * (double)(300.0F / (200.0F + (entityiteratorxx instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)) / 25.0F)
                                    / 10.0
                              )
                           );
                        }
                     }
                  }
               } else if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y + 2.0, z, 10, 2.0, 2.0, 2.0, 0.0);
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7.5), ex -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (!(entityiteratorxxx instanceof SpiderMothDwellerEntity) && !entityiteratorxxx.getPersistentData().getBoolean("creativespectator")) {
                        if (entityiteratorxxx instanceof VoidSpearEntity && entity instanceof LivingEntity) {
                           LivingEntity _livEnt183 = (LivingEntity)entity;
                           if (_livEnt183.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                              continue;
                           }
                        }

                        if (!(entityiteratorxxx instanceof ItemEntity)
                           && (entity.getPersistentData().getDouble("weaponfire") == 32.0 || entity.getPersistentData().getDouble("weaponfire") == 12.0)) {
                           entity.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                              7.0F
                           );
                           if (entityiteratorxxx instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiteratorxxx;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 30, 1, false, false));
                              }
                           }

                           entityiteratorxxx.setDeltaMovement(
                              new Vec3(
                                 (x - entityiteratorxxx.getX())
                                    * (double)(
                                       300.0F / (200.0F + (entityiteratorxxx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)) / 25.0F
                                    ),
                                 0.5,
                                 (z - entityiteratorxxx.getZ())
                                    * (double)(300.0F / (200.0F + (entityiteratorxxx instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)) / 25.0F)
                              )
                           );
                        }
                     }
                  }

                  _center = new Vec3(x, y, z);

                  for (Entity entityiteratorxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), ex -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if ((entity.getPersistentData().getDouble("weaponfire") == 2.0 || entity.getPersistentData().getDouble("weaponfire") == 22.0)
                        && !(entityiteratorxxxx instanceof SpiderMothDwellerEntity)
                        && !entityiteratorxxxx.getPersistentData().getBoolean("creativespectator")
                        && !(entityiteratorxxxx instanceof ItemEntity)) {
                        entityiteratorxxxx.setDeltaMovement(
                           new Vec3(
                              (x - entityiteratorxxxx.getX())
                                 * (double)(300.0F / (200.0F + (entityiteratorxxxx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)) / 25.0F),
                              0.5,
                              (z - entityiteratorxxxx.getZ())
                                 * (double)(300.0F / (200.0F + (entityiteratorxxxx instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)) / 25.0F)
                           )
                        );
                     }
                  }
               }

               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY() >= entity.getY() + entity.getPersistentData().getDouble("yvertarget")) {
                  if (entity.getPersistentData().getDouble("yvertarget") < 20.0) {
                     entity.getPersistentData().putDouble("yvertarget", entity.getPersistentData().getDouble("yvertarget") + 0.11);
                  }
               } else if (entity.getPersistentData().getDouble("yvertarget") > -20.0) {
                  entity.getPersistentData().putDouble("yvertarget", entity.getPersistentData().getDouble("yvertarget") - 0.11);
               }

               if (entity.getPersistentData().getDouble("loop") < entity.getPersistentData().getDouble("particlecount")) {
                  entity.getPersistentData()
                     .putDouble(
                        "xver",
                        entity.getX()
                           + 0.5
                           + Math.cos((Math.PI * 2) / entity.getPersistentData().getDouble("particlecount") * entity.getPersistentData().getDouble("loop"))
                              * entity.getPersistentData().getDouble("radius")
                     );
                  entity.getPersistentData()
                     .putDouble(
                        "zver",
                        entity.getZ()
                           + 0.5
                           + Math.sin((Math.PI * 2) / entity.getPersistentData().getDouble("particlecount") * entity.getPersistentData().getDouble("loop"))
                              * entity.getPersistentData().getDouble("radius")
                     );
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(
                                    entity.getPersistentData().getDouble("xver"),
                                    entity.getY() + entity.getPersistentData().getDouble("yvertarget"),
                                    entity.getPersistentData().getDouble("zver")
                                 ),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:solid_smoke ~ ~ ~ 0 0 0 0 1 force"
                        );
                  }

                  Vec3 _center = new Vec3(
                     entity.getPersistentData().getDouble("xver"),
                     entity.getY() + entity.getPersistentData().getDouble("yvertarget"),
                     entity.getPersistentData().getDouble("zver")
                  );

                  for (Entity entityiteratorxxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), ex -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (!entityiteratorxxxxx.getPersistentData().getBoolean("creativespectator")
                        && !(entityiteratorxxxxx instanceof SpiderMothDwellerEntity)
                        && !(entityiteratorxxxxx instanceof DraconicCloneEntity)
                        && !(entityiteratorxxxxx instanceof ItemEntity)) {
                        label1647:
                        if ((entityiteratorxxxxx instanceof LivingEntity _entUseItem257 ? _entUseItem257.getUseItem() : ItemStack.EMPTY).getItem()
                              != ArphexModItems.ABYSSAL_BLADE.get()
                           && (entityiteratorxxxxx instanceof LivingEntity _entUseItem259 ? _entUseItem259.getUseItem() : ItemStack.EMPTY).getItem()
                              != ArphexModItems.ABYSS_ASCENDANT.get()) {
                           if (entityiteratorxxxxx instanceof LivingEntity) {
                              LivingEntity _livEnt261 = (LivingEntity)entityiteratorxxxxx;
                              if (_livEnt261.isBlocking()) {
                                 break label1647;
                              }
                           }

                           if ((entityiteratorxxxxx instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) < 3) {
                              entityiteratorxxxxx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                 15.0F
                              );
                           } else {
                              entityiteratorxxxxx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                 (float)(15 / (((entityiteratorxxxxx instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) + 3) / 6))
                              );
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 3, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 0, false, false));
                           }
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(
                              (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
                              entityiteratorxxxxx.getX(),
                              entityiteratorxxxxx.getY(),
                              entityiteratorxxxxx.getZ(),
                              20,
                              0.6,
                              0.4,
                              0.6,
                              0.5
                           );
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(
                              ParticleTypes.EXPLOSION,
                              entityiteratorxxxxx.getX(),
                              entityiteratorxxxxx.getY(),
                              entityiteratorxxxxx.getZ(),
                              5,
                              0.4,
                              0.3,
                              0.4,
                              0.5
                           );
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound(
                                 null,
                                 BlockPos.containing(entityiteratorxxxxx.getX(), entityiteratorxxxxx.getY(), entityiteratorxxxxx.getZ()),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                                 SoundSource.HOSTILE,
                                 0.2F,
                                 0.5F
                              );
                           } else {
                              _level.playLocalSound(
                                 entityiteratorxxxxx.getX(),
                                 entityiteratorxxxxx.getY(),
                                 entityiteratorxxxxx.getZ(),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                                 SoundSource.HOSTILE,
                                 0.2F,
                                 0.5F,
                                 false
                              );
                           }
                        }

                        if (entityiteratorxxxxx instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiteratorxxxxx;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_REPULSION.get(), 1, 0, false, false));
                           }
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("loop", entity.getPersistentData().getDouble("loop") + 1.0);
               } else {
                  entity.getPersistentData().putDouble("loop", 0.0);
               }
            }
         }

         if ((entity instanceof SpiderMothDwellerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMothDwellerEntity.DATA_attacktimer) : 0) <= 0) {
            if (Mth.nextInt(RandomSource.create(), 1, 5) != 1) {
               label1624:
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
                  if (!(entity instanceof SpiderMothDwellerEntity _datEntSxx
                           ? (String)_datEntSxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                           : "")
                        .equals("forcewall")
                     && entity instanceof SpiderMothDwellerEntity _datEntL365
                     && (Boolean)_datEntL365.getEntityData().get(SpiderMothDwellerEntity.DATA_primed)) {
                     if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcecharge");
                     }
                     break label1624;
                  }

                  if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcelifesteal");
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
                  if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcelifesteal");
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                  if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcepull");
                  }
               } else if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forceshield");
               }
            } else if ((entity instanceof SpiderMothDwellerEntity _datEntSxxx
                  ? (String)_datEntSxxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                  : "")
               .equals("forcecharge")) {
               if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcelifesteal");
               }
            } else {
               if (entity instanceof SpiderMothDwellerEntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(SpiderMothDwellerEntity.DATA_currentattack, "forcewall");
               }

               if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
                  && entity instanceof SpiderMothDwellerEntity _datEntL294
                  && (Boolean)_datEntL294.getEntityData().get(SpiderMothDwellerEntity.DATA_primed)) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorxxxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), ex -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 1));
                        }
                     }
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                     if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(
                              _level,
                              BlockPos.containing(
                                 (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX(),
                                 (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY(),
                                 (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ() + 16.0
                              ),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(
                              _levelx,
                              BlockPos.containing(
                                 (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX(),
                                 (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY(),
                                 (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ() - 16.0
                              ),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(
                              _levelxx,
                              BlockPos.containing(
                                 (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX() - 16.0,
                                 (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY(),
                                 (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ()
                              ),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(
                              _levelxxx,
                              BlockPos.containing(
                                 (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX() + 16.0,
                                 (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY(),
                                 (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ()
                              ),
                              MobSpawnType.MOB_SUMMONED
                           );
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  } else if (entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH) {
                     if (world instanceof ServerLevel _levelxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 6.0), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 6.0), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 12.0), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxxxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 12.0), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  } else {
                     if (world instanceof ServerLevel _levelxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxxxxxx, BlockPos.containing(entity.getX() + 6.0, entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxxxxxxx, BlockPos.containing(entity.getX() - 6.0, entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxxxxxxxx, BlockPos.containing(entity.getX() + 12.0, entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_CLONE.get())
                           .spawn(_levelxxxxxxxxxxx, BlockPos.containing(entity.getX() - 12.0, entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  }
               }
            }

            if (entity instanceof SpiderMothDwellerEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SpiderMothDwellerEntity.DATA_attacktimer, Mth.nextInt(RandomSource.create(), 100, 400));
            }
         } else if (entity instanceof SpiderMothDwellerEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SpiderMothDwellerEntity.DATA_attacktimer,
                  (entity instanceof SpiderMothDwellerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMothDwellerEntity.DATA_attacktimer) : 0)
                     - 1
               );
         }

         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiteratorxxxxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.5), ex -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (!(entityiteratorxxxxxxx instanceof VoidSpearEntity)
               && !(entityiteratorxxxxxxx instanceof DraconFireEntity)
               && !(entityiteratorxxxxxxx instanceof SpiderMothDwellerEntity)
               && !(entityiteratorxxxxxxx instanceof ItemEntity)
               && !entityiteratorxxxxxxx.getPersistentData().getBoolean("creativespectator")) {
               if (!entityiteratorxxxxxxx.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:impact_projectiles")))
                  && !(entityiteratorxxxxxxx instanceof WebbedArrowEntity)
                  && !(entityiteratorxxxxxxx instanceof BloodProjectileEntity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt386 = (LivingEntity)entity;
                     if (_livEnt386.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                        continue;
                     }
                  }

                  if (entity.getPersistentData().getDouble("slowtime") == 5.0 || !(entityiteratorxxxxxxx instanceof Player)) {
                     if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) == null) {
                        if (Math.abs(entityiteratorxxxxxxx.getDeltaMovement().y()) > 0.003) {
                           entityiteratorxxxxxxx.setDeltaMovement(
                              new Vec3(
                                 entityiteratorxxxxxxx.getDeltaMovement().x(),
                                 entityiteratorxxxxxxx.getDeltaMovement().y() * 0.5,
                                 entityiteratorxxxxxxx.getDeltaMovement().z()
                              )
                           );
                        }

                        if (Math.abs(entityiteratorxxxxxxx.getDeltaMovement().x()) > 4.5E-4 || Math.abs(entityiteratorxxxxxxx.getDeltaMovement().z()) > 4.5E-4) {
                           entityiteratorxxxxxxx.setDeltaMovement(
                              new Vec3(
                                 entityiteratorxxxxxxx.getDeltaMovement().x() * 0.25,
                                 entityiteratorxxxxxxx.getDeltaMovement().y(),
                                 entityiteratorxxxxxxx.getDeltaMovement().z() * 0.25
                              )
                           );
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              _levelxxxxxxxxxxxx.sendParticles(
                                 (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
                                 entityiteratorxxxxxxx.getX(),
                                 entityiteratorxxxxxxx.getY(),
                                 entityiteratorxxxxxxx.getZ(),
                                 1,
                                 0.3,
                                 0.3,
                                 0.3,
                                 0.2
                              );
                           }
                        }
                     } else if (entityiteratorxxxxxxx == (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null)) {
                        if (Math.abs(entityiteratorxxxxxxx.getDeltaMovement().y()) > 0.006) {
                           entityiteratorxxxxxxx.setDeltaMovement(
                              new Vec3(
                                 entityiteratorxxxxxxx.getDeltaMovement().x(),
                                 entityiteratorxxxxxxx.getDeltaMovement().y() * 0.5,
                                 entityiteratorxxxxxxx.getDeltaMovement().z()
                              )
                           );
                        }

                        if (Math.abs(entityiteratorxxxxxxx.getDeltaMovement().x()) > 0.001 || Math.abs(entityiteratorxxxxxxx.getDeltaMovement().z()) > 0.001) {
                           entityiteratorxxxxxxx.setDeltaMovement(
                              new Vec3(
                                 entityiteratorxxxxxxx.getDeltaMovement().x() * 0.25,
                                 entityiteratorxxxxxxx.getDeltaMovement().y(),
                                 entityiteratorxxxxxxx.getDeltaMovement().z() * 0.25
                              )
                           );
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              _levelxxxxxxxxxxxx.sendParticles(
                                 (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
                                 entityiteratorxxxxxxx.getX(),
                                 entityiteratorxxxxxxx.getY(),
                                 entityiteratorxxxxxxx.getZ(),
                                 1,
                                 0.3,
                                 0.3,
                                 0.3,
                                 0.2
                              );
                           }
                        }
                     } else {
                        if (Math.abs(entityiteratorxxxxxxx.getDeltaMovement().y()) > 0.003) {
                           entityiteratorxxxxxxx.setDeltaMovement(
                              new Vec3(
                                 entityiteratorxxxxxxx.getDeltaMovement().x(),
                                 entityiteratorxxxxxxx.getDeltaMovement().y() * 0.5,
                                 entityiteratorxxxxxxx.getDeltaMovement().z()
                              )
                           );
                        }

                        if (Math.abs(entityiteratorxxxxxxx.getDeltaMovement().x()) > 4.5E-4 || Math.abs(entityiteratorxxxxxxx.getDeltaMovement().z()) > 4.5E-4) {
                           entityiteratorxxxxxxx.setDeltaMovement(
                              new Vec3(
                                 entityiteratorxxxxxxx.getDeltaMovement().x() * 0.25,
                                 entityiteratorxxxxxxx.getDeltaMovement().y(),
                                 entityiteratorxxxxxxx.getDeltaMovement().z() * 0.25
                              )
                           );
                           if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                              _levelxxxxxxxxxxxx.sendParticles(
                                 (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
                                 entityiteratorxxxxxxx.getX(),
                                 entityiteratorxxxxxxx.getY(),
                                 entityiteratorxxxxxxx.getZ(),
                                 1,
                                 0.3,
                                 0.3,
                                 0.3,
                                 0.2
                              );
                           }
                        }
                     }
                  }
               } else {
                  entityiteratorxxxxxxx.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
               }
            }
         }

         if (!(entity.getPersistentData().getDouble("slowtime") > 0.0)) {
            entity.getPersistentData().putDouble("slowtime", 10.0);
         } else {
            entity.getPersistentData().putDouble("slowtime", entity.getPersistentData().getDouble("slowtime") - 1.0);
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F
            > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
            if ((!entity.isShiftKeyDown() || (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) == null)
               && world instanceof ServerLevel _levelxxxxxxxxxxxx) {
               _levelxxxxxxxxxxxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
                  x,
                  y + 2.0,
                  z,
                  (int)((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) / 2.0F),
                  2.0,
                  2.0,
                  2.0,
                  0.0
               );
            }

            if ((!entity.getPersistentData().getBoolean("usingpower") || (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) == null)
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1, false, false));
            }

            if (!(entity instanceof SpiderMothDwellerEntity _datEntSxxxxx
                     ? (String)_datEntSxxxxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcewall")
               && !(entity instanceof SpiderMothDwellerEntity _datEntSxxxx
                     ? (String)_datEntSxxxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcecharge")) {
               if (entity instanceof SpiderMothDwellerEntity animatable) {
                  animatable.setTexture("draconicvoidlasherlowhealth");
               }
            } else if (entity instanceof SpiderMothDwellerEntity animatable) {
               animatable.setTexture("draconicvoidlasherpowerlowhealth");
            }
         } else {
            if ((!entity.isShiftKeyDown() || (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) == null)
               && world instanceof ServerLevel _levelxxxxxxxxxxxx) {
               _levelxxxxxxxxxxxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.PURPLE_GLINTS.get(),
                  x,
                  y + 2.0,
                  z,
                  (int)((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) / 2.0F),
                  2.0,
                  2.0,
                  2.0,
                  0.0
               );
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 2, false, false));
            }

            if (!(entity instanceof SpiderMothDwellerEntity _datEntSxxxxxxx
                     ? (String)_datEntSxxxxxxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcewall")
               && !(entity instanceof SpiderMothDwellerEntity _datEntSxxxxxx
                     ? (String)_datEntSxxxxxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                     : "")
                  .equals("forcecharge")) {
               if (entity instanceof SpiderMothDwellerEntity animatable) {
                  animatable.setTexture("draconicvoidlasher");
               }
            } else if (entity instanceof SpiderMothDwellerEntity animatable) {
               animatable.setTexture("draconicvoidlasherpower");
            }
         }

         if (!(entity.getPersistentData().getDouble("stillattack") > 0.0)) {
            entity.getPersistentData().putDouble("stillattack", (double)Mth.nextInt(RandomSource.create(), 200, 600));
         } else {
            entity.getPersistentData().putDouble("stillattack", entity.getPersistentData().getDouble("stillattack") - 1.0);
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), ex -> true).isEmpty()) {
            nearestplayer80 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), ex -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            label1522:
            if ((new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                        } else {
                           return _ent.level().isClientSide() && _ent instanceof Player _player
                              ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                 && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL
                              : false;
                        }
                     }
                  })
                  .checkGamemode(nearestplayer80)
               || (new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                        } else {
                           return _ent.level().isClientSide() && _ent instanceof Player _player
                              ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                 && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE
                              : false;
                        }
                     }
                  })
                  .checkGamemode(nearestplayer80)) {
               if (entity instanceof SpiderMothDwellerEntity _datEntL477 && (Boolean)_datEntL477.getEntityData().get(SpiderMothDwellerEntity.DATA_primed)) {
                  break label1522;
               }

               if (entity instanceof SpiderMothDwellerEntity _datEntSetL) {
                  _datEntSetL.getEntityData().set(SpiderMothDwellerEntity.DATA_primed, true);
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                  LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_levelxxxxxxxxxxxx);
                  entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                  entityToSpawn.setVisualOnly(true);
                  _levelxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof Level _levelxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(nearestplayer80.getX(), nearestplayer80.getY(), nearestplayer80.getZ()),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                        SoundSource.HOSTILE,
                        0.3F,
                        0.1F
                     );
                  } else {
                     _levelxxxxxxxxxxxx.playLocalSound(
                        nearestplayer80.getX(),
                        nearestplayer80.getY(),
                        nearestplayer80.getZ(),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                        SoundSource.HOSTILE,
                        0.3F,
                        0.1F,
                        false
                     );
                  }
               }

               if (nearestplayer80 instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1, false, false));
               }

               String _setval = "true";
               world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), ex -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .ifPresent(
                     capability -> {
                        capability.ShowOverlay3 = _setval;
                        capability.syncPlayerVariables(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), ex -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null)
                        );
                     }
                  );
            }
         }

         if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null) {
            if (Math.sqrt(
                  (entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null).getX())
                        * (entity.getX() - (entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getX())
                     + (entity.getY() - (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getY())
                        * (entity.getY() - (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getY())
                     + (entity.getZ() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getZ())
                        * (entity.getZ() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ())
               )
               > entity.getPersistentData().getDouble("radius")) {
               if (entity.getPersistentData().getDouble("radius") < 30.0) {
                  entity.getPersistentData().putDouble("radius", entity.getPersistentData().getDouble("radius") + 0.1);
               } else {
                  entity.getPersistentData().putDouble("radius", 30.0);
               }
            } else if (entity.getPersistentData().getDouble("radius") > 4.0) {
               entity.getPersistentData().putDouble("radius", entity.getPersistentData().getDouble("radius") - 0.1);
            } else {
               entity.getPersistentData().putDouble("radius", 4.0);
            }
         }

         entity.getPersistentData().putDouble("particlecount", 80.0);
         if (entity.getPersistentData().getDouble("yvertarget") == 0.0) {
            entity.getPersistentData().putDouble("yvertarget", 1.0);
         }

         if (!(entity.getPersistentData().getDouble("weaponfire") > 0.0)) {
            entity.getPersistentData().putDouble("weaponfire", 40.0);
         } else {
            entity.getPersistentData().putDouble("weaponfire", entity.getPersistentData().getDouble("weaponfire") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("voidspear") > 0.0)) {
            entity.getPersistentData().putDouble("voidspear", 40.0);
         } else {
            entity.getPersistentData().putDouble("voidspear", entity.getPersistentData().getDouble("voidspear") - 1.0);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         if (!(entity instanceof SpiderMothDwellerEntity _datEntSxxxxxxxx
                  ? (String)_datEntSxxxxxxxx.getEntityData().get(SpiderMothDwellerEntity.DATA_currentattack)
                  : "")
               .equals("forcepull")
            || world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y - 4.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y - 5.0, z))
            || (entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null) == null) {
            ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 8, 25), () -> {
               if (entity instanceof LivingEntity _entityx) {
                  _entityx.removeEffect(MobEffects.LEVITATION);
               }
            });
         } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, Mth.nextInt(RandomSource.create(), 30, 120), 1, false, false));
         }

         if (entity.getPersistentData().getDouble("tping") < 30.0 && !entity.isSprinting() && world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
            _levelxxxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 5, 1.0, 1.0, 1.0, 0.4);
         }

         if ((entity instanceof Mob _mobEntxxxxxxxxxxx ? _mobEntxxxxxxxxxxx.getTarget() : null) != null
            && !(entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null).isAlive()
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var54) {
               var54.printStackTrace();
            }
         }

         if (!(entity.getPersistentData().getDouble("tping") > 0.0)) {
            if ((entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null) == null) {
               entity.getPersistentData().putDouble("tping", (double)Mth.nextInt(RandomSource.create(), 1200, 3600));
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                  randomxside = (double)Mth.nextInt(RandomSource.create(), 10, 20);
               } else {
                  randomxside = (double)Mth.nextInt(RandomSource.create(), -20, -10);
               }

               if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                  randomzside = (double)Mth.nextInt(RandomSource.create(), 10, 20);
               } else {
                  randomzside = (double)Mth.nextInt(RandomSource.create(), -20, -10);
               }

               yhalf = 0.0;
            } else if (entity.getX() + 40.0 > (entity instanceof Mob _mobEntxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxx.getTarget() : null).getX()
               && entity.getX() - 40.0 < (entity instanceof Mob _mobEntxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxx.getTarget() : null).getX()
               && entity.getZ() + 40.0 > (entity instanceof Mob _mobEntxxxxxxxxxxx ? _mobEntxxxxxxxxxxx.getTarget() : null).getZ()
               && entity.getZ() - 40.0 < (entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null).getZ()) {
               entity.getPersistentData()
                  .putDouble(
                     "tping",
                     (double)(
                        (float)Mth.nextInt(RandomSource.create(), 400, 600)
                           * (((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) + 50.0F) / 150.0F)
                     )
                  );
               yhalf = 0.0;
               if (Math.round(entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getX()) > 0L) {
                  randomxside = (double)(
                     0L - Math.round(entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxx.getTarget() : null).getX())
                  );
               } else {
                  randomxside = (double)Math.abs(
                     Math.round(entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getX())
                  );
               }

               if (Math.round(entity.getZ() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getZ()) > 0L) {
                  randomzside = (double)(
                     0L - Math.round(entity.getZ() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxx.getTarget() : null).getZ())
                  );
               } else {
                  randomzside = (double)Math.abs(
                     Math.round(entity.getZ() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getZ())
                  );
               }

               if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                  randomxside += (double)Mth.nextInt(RandomSource.create(), 10, 30);
               } else {
                  randomxside += (double)Mth.nextInt(RandomSource.create(), -30, -10);
               }

               if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                  randomzside += (double)Mth.nextInt(RandomSource.create(), 10, 30);
               } else {
                  randomzside += (double)Mth.nextInt(RandomSource.create(), -30, -10);
               }
            } else {
               entity.getPersistentData().putDouble("tping", (double)Mth.nextInt(RandomSource.create(), 200, 600));
               randomxside = (double)Math.round(
                  (entity.getX() + (entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null).getX()) / 2.0 - entity.getX()
               );
               randomzside = (double)Math.round(
                  (entity.getZ() + (entity instanceof Mob _mobEntxxxxxxxxxxx ? _mobEntxxxxxxxxxxx.getTarget() : null).getZ()) / 2.0 - entity.getZ()
               );
               yhalf = (double)Math.round(
                  (entity.getY() + (entity instanceof Mob _mobEntxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxx.getTarget() : null).getY()) / 2.0 - entity.getY()
               );
            }

            sx = -8.0;
            found = false;
            if (!found) {
               for (int index1 = 0; index1 < 4; index1++) {
                  if (!found) {
                     sy = -4.0;

                     for (int index2 = 0; index2 < 4; index2++) {
                        if (!found) {
                           sz = -8.0;

                           for (int index3 = 0; index3 < 4; index3++) {
                              if (!world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy - 1.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx, (double)Math.round(y) + yhalf + sy, (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx - 1.0,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz + 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 1.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 2.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )
                                 && world.isEmptyBlock(
                                    BlockPos.containing(
                                       (double)Math.round(x) + randomxside + sx + 1.0,
                                       (double)Math.round(y) + yhalf + sy + 3.0,
                                       (double)Math.round(z) + randomzside + sz - 1.0
                                    )
                                 )) {
                                 if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                    _levelxxxxxxxxxxxxx.sendParticles(
                                       (SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(), x, y, z, 30, 1.0, 1.0, 1.0, 0.4
                                    );
                                 }

                                 entity.teleportTo(
                                    (double)Math.round(x) + randomxside + sx, (double)Math.round(y) + yhalf + sy, (double)Math.round(z) + randomzside + sz
                                 );
                                 if (entity instanceof ServerPlayer _serverPlayer) {
                                    _serverPlayer.connection
                                       .teleport(
                                          (double)Math.round(x) + randomxside + sx,
                                          (double)Math.round(y) + yhalf + sy,
                                          (double)Math.round(z) + randomzside + sz,
                                          entity.getYRot(),
                                          entity.getXRot()
                                       );
                                 }

                                 if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                                    _levelxxxxxxxxxxxxx.sendParticles(
                                       (SimpleParticleType)ArphexModParticleTypes.GHOST_TELEPORT.get(),
                                       (double)Math.round(x) + randomxside + sx,
                                       (double)Math.round(y) + yhalf + sy,
                                       (double)Math.round(z) + randomzside + sz,
                                       30,
                                       1.0,
                                       1.0,
                                       1.0,
                                       0.8
                                    );
                                 }

                                 found = true;
                              }

                              sz += 4.0;
                           }

                           sy += 2.0;
                        }
                     }

                     sx += 4.0;
                  }
               }
            }
         } else if (entity.isSprinting()) {
            if ((entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null) != null) {
               entity.setYRot(
                  (float)(
                     Math.atan2(
                              entity.getZ() - (entity instanceof Mob _mobEntxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxx.getTarget() : null).getZ(),
                              entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxx ? _mobEntxxxxxxxxxxx.getTarget() : null).getX()
                           )
                           * 57.5
                        + 90.0
                  )
               );
               entity.setXRot(
                  (float)(
                     Math.atan2(
                           entity.getY() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxxxx.getTarget() : null).getY(),
                           Math.sqrt(
                              (entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxxx.getTarget() : null).getX())
                                    * (entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxx.getTarget() : null).getX())
                                 + (entity.getZ() - (entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getZ())
                                    * (entity.getZ() - (entity instanceof Mob _mobEntxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxx.getTarget() : null).getZ())
                           )
                        )
                        * 57.5
                  )
               );
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (entity.getPersistentData().getDouble("tping") > 2.0 && !(entity.getPersistentData().getDouble("tping") > 30.0)) {
                  entity.getPersistentData().putDouble("tping", entity.getPersistentData().getDouble("tping") - 1.0);
               } else {
                  entity.getPersistentData().putDouble("tping", 30.0);
                  entity.getPersistentData().putDouble("prevswapx", entity.getX());
                  entity.getPersistentData().putDouble("prevswapy", entity.getY());
                  entity.getPersistentData().putDouble("prevswapz", entity.getZ());
                  Vec3 _centerx = new Vec3(x, y, z);

                  for (Entity entityiteratorxxxxxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(50.0), ex -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (!entity.getPersistentData().getBoolean("justswapped")
                        && entityiteratorxxxxxxxx instanceof DraconicCloneEntity
                        && !entityiteratorxxxxxxxx.isInWall()
                        && Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                        entity.getPersistentData().putBoolean("justswapped", true);
                        entity.teleportTo(entityiteratorxxxxxxxx.getX(), entityiteratorxxxxxxxx.getY(), entityiteratorxxxxxxxx.getZ());
                        if (entity instanceof ServerPlayer _serverPlayer) {
                           _serverPlayer.connection
                              .teleport(
                                 entityiteratorxxxxxxxx.getX(),
                                 entityiteratorxxxxxxxx.getY(),
                                 entityiteratorxxxxxxxx.getZ(),
                                 entity.getYRot(),
                                 entity.getXRot()
                              );
                        }

                        entityiteratorxxxxxxxx.teleportTo(
                           entity.getPersistentData().getDouble("prevswapz"),
                           entity.getPersistentData().getDouble("prevswapy"),
                           entity.getPersistentData().getDouble("prevswapz")
                        );
                        if (entityiteratorxxxxxxxx instanceof ServerPlayer _serverPlayer) {
                           _serverPlayer.connection
                              .teleport(
                                 entity.getPersistentData().getDouble("prevswapz"),
                                 entity.getPersistentData().getDouble("prevswapy"),
                                 entity.getPersistentData().getDouble("prevswapz"),
                                 entityiteratorxxxxxxxx.getYRot(),
                                 entityiteratorxxxxxxxx.getXRot()
                              );
                        }
                     }
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("tping", entity.getPersistentData().getDouble("tping") - 1.0);
         }

         if (entity.getPersistentData().getBoolean("justswapped")) {
            ArphexMod.queueServerWork(3, () -> entity.getPersistentData().putBoolean("justswapped", false));
         }

         if (entity.isInWall()) {
            entity.teleportTo(x, y + 1.0, z);
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection.teleport(x, y + 1.0, z, entity.getYRot(), entity.getXRot());
            }

            entity.getPersistentData().putDouble("tping", 0.0);
         }

         if (entity instanceof LivingEntity _livEnt710
            && _livEnt710.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())
            && !entity.getPersistentData().getBoolean("justblasted")
            && entity.getPersistentData().getDouble("blasttime") >= 1.0
            && entity.getPersistentData().getDouble("shockwavecycle") == 2.0) {
            entity.getPersistentData().putBoolean("justblasted", true);
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
               _levelxxxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y + 1.0, z, 80, 2.0, 0.6, 2.0, 0.5);
            }

            if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
               _levelxxxxxxxxxxxxx.sendParticles(ParticleTypes.DRAGON_BREATH, x, y + 1.0, z, 10, 2.0, 0.6, 2.0, 0.5);
            }

            if (world instanceof Level _levelxxxxxxxxxxxxx) {
               if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                  _levelxxxxxxxxxxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.HOSTILE,
                     1.0F,
                     0.5F
                  );
               } else {
                  _levelxxxxxxxxxxxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.HOSTILE,
                     1.0F,
                     0.5F,
                     false
                  );
               }
            }

            Vec3 _centerx = new Vec3(x, y, z);

            for (Entity entityiteratorxxxxxxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(6.0), ex -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorxxxxxxxxx != entity
                  && !entityiteratorxxxxxxxxx.getPersistentData().getBoolean("creativespectator")
                  && !(entityiteratorxxxxxxxxx instanceof ItemEntity)) {
                  entityiteratorxxxxxxxxx.setDeltaMovement(
                     new Vec3(
                        (entityiteratorxxxxxxxxx.getX() - entity.getX())
                           * (double)(300.0F / (200.0F + (entityiteratorxxxxxxxxx instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F)))
                           * (double)(Mth.nextInt(RandomSource.create(), 1, 10) / 2),
                        0.8,
                        (entityiteratorxxxxxxxxx.getZ() - entity.getZ())
                           * (double)(300.0F / (200.0F + (entityiteratorxxxxxxxxx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)))
                           * (double)(Mth.nextInt(RandomSource.create(), 1, 10) / 2)
                     )
                  );
               }
            }
         }

         if (entity.getPersistentData().getDouble("blasttime") > 0.0) {
            entity.getPersistentData().putDouble("blasttime", entity.getPersistentData().getDouble("blasttime") - 1.0);
         }

         if (entity.getPersistentData().getBoolean("justblasted")) {
            ArphexMod.queueServerWork(20, () -> entity.getPersistentData().putBoolean("justblasted", false));
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.VOID_AIR) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.5, entity.getDeltaMovement().z()));
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
               _levelxxxxxxxxxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 10, 1.5, 0.3, 1.5, 0.4);
            }
         }

         if ((entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxxxxxx.getTarget() : null) != null
            && (
               !(entity instanceof Mob _mobEntxxxxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxxxxx.getTarget() : null).isAlive()
                  || (entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null).getPersistentData().getBoolean("creativespectator")
            )
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var53) {
               var53.printStackTrace();
            }
         }

         ArphexMod.queueServerWork(12000, () -> {
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).isEmpty()) {
               entity.getPersistentData().putDouble("nonenear", entity.getPersistentData().getDouble("nonenear") + 1.0);
            } else {
               entity.getPersistentData().putDouble("nonenear", 0.0);
            }
         });
         if (entity.getPersistentData().getDouble("nonenear") > 400.0
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), ex -> true).isEmpty()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "voidlasher-no-player-near";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
            _levelxxxxxxxxxxxxxx.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(x, y, z),
                        Vec2.ZERO,
                        _levelxxxxxxxxxxxxxx,
                        4,
                        "",
                        Component.literal(""),
                        _levelxxxxxxxxxxxxxx.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 arphex:cobweb_passable replace cobweb"
               );
         }
      }
   }
}
