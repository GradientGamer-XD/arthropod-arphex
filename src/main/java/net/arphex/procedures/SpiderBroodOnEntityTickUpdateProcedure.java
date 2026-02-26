package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderBroodEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderJumpEntity;
import net.arphex.entity.SpiderSnatcherEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class SpiderBroodOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.getPersistentData().getBoolean("despawnedrider")) {
            entity.getPersistentData().putBoolean("despawnedrider", true);
            if (entity.isVehicle() && entity.getFirstPassenger() != null && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }
         }

         entity.getPersistentData().putBoolean("arphexclimber", true);
         label615:
         if (entity instanceof SpiderFlatEntity || entity instanceof SpiderJumpEntity) {
            if (Mth.nextInt(RandomSource.create(), 1, 1000) == 5 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 200, 0, true, false));
            }

            if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.REGENERATION)) {
               break label615;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, true, false));
            }

            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                  < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
               && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 25, 1.0, 1.0, 1.0, 0.4);
            }
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) && !entity.onGround()) {
            if (entity instanceof SpiderBroodEntity && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 1.0, z, 12, 0.1, 0.3, 0.1, 0.0);
            }

            if (entity instanceof SpiderSnatcherEntity && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 12, 1.0, 1.0, 1.0, 0.0);
            }
         }

         if (entity instanceof SpiderBroodEntity) {
            if (entity.getPersistentData().getDouble("webtime") > 150.0) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 5, false, false));
               }

               entity.getPersistentData().putDouble("webtime", 0.0);
            }

            entity.getPersistentData().putDouble("webtime", entity.getPersistentData().getDouble("webtime") + 1.0);
         }

         if (entity instanceof SpiderSnatcherEntity
            && entity.getDisplayName().getString().equals("Overgrown Snatcher")
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if ((entity instanceof SpiderSnatcherEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderSnatcherEntity.DATA_snatcher_limit) : 0) > 0) {
               if (entity instanceof SpiderSnatcherEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        SpiderSnatcherEntity.DATA_snatcher_limit,
                        (
                              entity instanceof SpiderSnatcherEntity _datEntIx
                                 ? (Integer)_datEntIx.getEntityData().get(SpiderSnatcherEntity.DATA_snatcher_limit)
                                 : 0
                           )
                           - 1
                     );
               }
            } else {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof Player
                     && (
                        (new Object() {
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
                              .checkGamemode(entityiterator)
                           || (new Object() {
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
                              .checkGamemode(entityiterator)
                     )
                     && (!(entityiterator instanceof LivingEntity _livEnt40) || !_livEnt40.hasEffect(MobEffects.DIG_SLOWDOWN))) {
                     if (entity instanceof SpiderSnatcherEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(SpiderSnatcherEntity.DATA_snatcher_limit, 1200);
                     }

                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.FATIGUE_SHOW.get(), 5, 0, false, false));
                     }

                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2000, 2, false, false));
                     }

                     if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                           _level.playSound(
                              null,
                              BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")),
                              SoundSource.HOSTILE,
                              0.5F,
                              0.5F
                           );
                        } else {
                           _level.playLocalSound(
                              entityiterator.getX(),
                              entityiterator.getY(),
                              entityiterator.getZ(),
                              (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")),
                              SoundSource.HOSTILE,
                              0.5F,
                              0.5F,
                              false
                           );
                        }
                     }

                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entityiterator;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:crawling_barrier_bypass"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for (String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }

               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) < 20.0F) {
                  if (entity instanceof SpiderSnatcherEntity animatable) {
                     animatable.setTexture("spiderwidowmissinglegs");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
                  }
               }
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.COBWEB
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 6, false, false));
         }

         if (entity instanceof SpiderSnatcherEntity) {
            if (entity.getPersistentData().getDouble("webtime") > 20.0) {
               entity.getPersistentData().putDouble("webtime", 0.0);
            }

            entity.getPersistentData().putDouble("webtime", entity.getPersistentData().getDouble("webtime") + 1.0);
            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
               && entity.getY() > (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY() + 0.8) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)), -2.0, Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                  )
               );
            }
         }

         if (entity instanceof SpiderFlatEntity) {
            if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) == 0) {
               if (entity instanceof SpiderFlatEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "widowglow");
               }

               if (entity instanceof SpiderFlatEntity animatable) {
                  animatable.setTexture("spiderflat");
               }
            } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) == 1) {
               if (entity instanceof SpiderFlatEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "widowglow");
               }

               if (entity instanceof SpiderFlatEntity animatable) {
                  animatable.setTexture("spiderbrood");
               }
            } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) == 2) {
               if (entity instanceof SpiderFlatEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "invisible");
               }

               if (entity instanceof SpiderFlatEntity animatable) {
                  animatable.setTexture("sunscorpion2");
               }
            } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) == 3) {
               if (entity instanceof SpiderFlatEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "invisible");
               }

               if (entity instanceof SpiderFlatEntity animatable) {
                  animatable.setTexture("longlegs2");
               }
            } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) == 4) {
               if (entity instanceof SpiderFlatEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "invisible");
               }

               if (entity instanceof SpiderFlatEntity animatable) {
                  animatable.setTexture("waterroach");
               }
            } else {
               if (entity instanceof SpiderFlatEntity spider) {
                  spider.getPersistentData().putString("glowTexture", "invisible");
               }

               if (entity instanceof SpiderFlatEntity animatable) {
                  animatable.setTexture("centipedeevictor");
               }
            }

            if (entity instanceof SpiderFlatEntity _datEntL81
               && (Boolean)_datEntL81.getEntityData().get(SpiderFlatEntity.DATA_sit)
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
            }

            if ((!(entity instanceof TamableAnimal _tamEntx) || !_tamEntx.isTame())
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == null
               && entity.getDisplayName().getString().equals("Spider Flat")
               && entity.getDisplayName().getString().equals("Spider Flat")) {
               if (!(entity.getPersistentData().getDouble("flat_despawn_check") > 0.0)) {
                  entity.getPersistentData().putDouble("flat_despawn_check", 100.0);
                  if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()) {
                     ArphexMod.queueServerWork(
                        20,
                        () -> {
                           if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()
                              && !entity.level().isClientSide()) {
                              entity.discard();
                           }
                        }
                     );
                  }
               } else {
                  entity.getPersistentData().putDouble("flat_despawn_check", entity.getPersistentData().getDouble("flat_despawn_check") - 1.0);
               }
            }

            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
               && !(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).isAlive()
               && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var21) {
                  var21.printStackTrace();
               }
            }
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.1, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 0.8, z)) && !entity.onGround()) {
            if (world.isClientSide()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
                  if (entity instanceof SpiderSnatcherEntity && entity instanceof SpiderSnatcherEntity) {
                     ((SpiderSnatcherEntity)entity).setAnimation("animation.spiderwidow.grabmove");
                  }

                  if (!ModList.get().isLoaded("nyfsspiders")) {
                     if (entity instanceof SpiderFlatEntity) {
                        if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0)
                           == 0) {
                           if (entity instanceof SpiderFlatEntity) {
                              ((SpiderFlatEntity)entity).setAnimation("animation.spiderflat.grabmove");
                           }
                        } else if ((
                              entity instanceof SpiderFlatEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0
                           )
                           == 1) {
                           if (entity instanceof SpiderFlatEntity) {
                              ((SpiderFlatEntity)entity).setAnimation("animation.spiderbrood.grabmove");
                           }
                        } else if ((
                              entity instanceof SpiderFlatEntity _datEntIxxx
                                 ? (Integer)_datEntIxxx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin)
                                 : 0
                           )
                           == 2) {
                           if (entity instanceof SpiderFlatEntity) {
                              ((SpiderFlatEntity)entity).setAnimation("animation.scorpionstriker.grab");
                           }
                        } else if (entity instanceof SpiderFlatEntity) {
                           ((SpiderFlatEntity)entity).setAnimation("animation.longlegs.grab");
                        }
                     }

                     if (entity instanceof SpiderBroodEntity && entity instanceof SpiderBroodEntity) {
                        ((SpiderBroodEntity)entity).setAnimation("animation.spiderbrood.grabmove");
                     }

                     if (entity instanceof SpiderJumpEntity && entity instanceof SpiderJumpEntity) {
                        ((SpiderJumpEntity)entity).setAnimation("animation.spiderjumping.grabmove");
                     }
                  }
               } else {
                  if (entity instanceof SpiderSnatcherEntity && entity instanceof SpiderSnatcherEntity) {
                     ((SpiderSnatcherEntity)entity).setAnimation("empty");
                  }

                  if (!ModList.get().isLoaded("nyfsspiders")) {
                     if (entity instanceof SpiderFlatEntity && entity instanceof SpiderFlatEntity) {
                        ((SpiderFlatEntity)entity).setAnimation("empty");
                     }

                     if (entity instanceof SpiderBroodEntity && entity instanceof SpiderBroodEntity) {
                        ((SpiderBroodEntity)entity).setAnimation("empty");
                     }

                     if (entity instanceof SpiderJumpEntity && entity instanceof SpiderJumpEntity) {
                        ((SpiderJumpEntity)entity).setAnimation("empty");
                     }
                  }
               }
            }

            if (!ModList.get().isLoaded("nyfsspiders") || entity instanceof SpiderSnatcherEntity) {
               entity.setShiftKeyDown(true);
            }
         } else {
            if (world.isClientSide()) {
               label521:
               if (entity instanceof SpiderFlatEntity) {
                  if (entity instanceof SpiderFlatEntity _datEntL136 && (Boolean)_datEntL136.getEntityData().get(SpiderFlatEntity.DATA_sit)) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
                     }

                     if (entity instanceof SpiderFlatEntity) {
                        ((SpiderFlatEntity)entity).setAnimation("animation.spiderflat.sit");
                     }
                     break label521;
                  }

                  if (entity instanceof SpiderFlatEntity) {
                     ((SpiderFlatEntity)entity).setAnimation("empty");
                  }
               }

               if (entity instanceof SpiderSnatcherEntity && entity instanceof SpiderSnatcherEntity) {
                  ((SpiderSnatcherEntity)entity).setAnimation("empty");
               }

               if (entity instanceof SpiderBroodEntity && entity instanceof SpiderBroodEntity) {
                  ((SpiderBroodEntity)entity).setAnimation("empty");
               }

               label511:
               if (entity instanceof SpiderJumpEntity) {
                  if (entity instanceof SpiderJumpEntity _datEntL145 && (Boolean)_datEntL145.getEntityData().get(SpiderJumpEntity.DATA_sit)) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
                     }

                     if (entity instanceof SpiderJumpEntity) {
                        ((SpiderJumpEntity)entity).setAnimation("animation.spiderjumping.sit");
                     }
                     break label511;
                  }

                  if (entity instanceof SpiderJumpEntity) {
                     ((SpiderJumpEntity)entity).setAnimation("empty");
                  }
               }
            }

            entity.setShiftKeyDown(false);
         }

         if (entity instanceof SpiderJumpEntity) {
            if (entity instanceof SpiderJumpEntity _datEntL151
               && (Boolean)_datEntL151.getEntityData().get(SpiderJumpEntity.DATA_sit)
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
            }

            if ((!(entity instanceof TamableAnimal _tamEntxxx) || !_tamEntxxx.isTame())
               && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) == null
               && entity.getDisplayName().getString().equals("Spider Jump")
               && Mth.nextInt(RandomSource.create(), 1, 80) == 5
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()) {
               ArphexMod.queueServerWork(
                  20,
                  () -> {
                     if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }

            if ((entity instanceof SpiderJumpEntity animatable ? animatable.getTexture() : "null").equals("spiderjumpingrare")) {
               label495: {
                  if (entity instanceof SpiderJumpEntity _datEntL163 && (Boolean)_datEntL163.getEntityData().get(SpiderJumpEntity.DATA_ritual)) {
                     if (Mth.nextInt(RandomSource.create(), 1, 600) == 10 && entity instanceof SpiderJumpEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(SpiderJumpEntity.DATA_ritual, false);
                     }
                     break label495;
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 2400) == 10 && entity instanceof SpiderJumpEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(SpiderJumpEntity.DATA_ritual, true);
                  }
               }

               if (entity instanceof SpiderJumpEntity _datEntL168
                  && (Boolean)_datEntL168.getEntityData().get(SpiderJumpEntity.DATA_ritual)
                  && entity.getDeltaMovement().x() + entity.getDeltaMovement().y() + entity.getDeltaMovement().z() < 0.05) {
                  entity.setSprinting(true);
                  return;
               }

               entity.setSprinting(false);
            }
         }
      }
   }
}
