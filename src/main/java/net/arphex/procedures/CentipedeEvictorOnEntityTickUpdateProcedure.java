package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.CentipedeEvictorLarvaeEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class CentipedeEvictorOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphexclimber", true);
         if (!(entity.getPersistentData().getDouble("timer") > 0.0)) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, false));
            }

            entity.getPersistentData().putDouble("timer", 1.0);
         } else {
            if (entity.getPersistentData().getDouble("timer") > 150.0) {
               entity.getPersistentData().putDouble("timer", 1.0);
            } else if (entity.getPersistentData().getBoolean("targetnear") && !(entity instanceof CentipedeEvictorLarvaeEntity)) {
               entity.getPersistentData().putDouble("timer", 1.0);
            } else {
               entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") + 1.0);
            }

            if (entity instanceof CentipedeEvictorEntity && entity.getPersistentData().getDouble("timer") == 150.0 && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.TINY_CENTIPEDE_BREACHER.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (entity instanceof CentipedeEvictorEntity) {
               entity.getPersistentData().putDouble("timer", 1.0);
            }

            entity.setSprinting(false);
         } else if (!(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).isAlive() && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var21) {
               var21.printStackTrace();
            }
         }

         if (entity instanceof CentipedeEvictorEntity) {
            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
                  x,
                  y,
                  z,
                  (int)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F),
                  1.0,
                  1.0,
                  1.0,
                  0.5
               );
            }

            if (entity.getDisplayName().getString().equals("Small Evictor")
               && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                  == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
               if ((entity instanceof CentipedeEvictorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(CentipedeEvictorEntity.DATA_evictor_limit) : 0)
                  > 0) {
                  if (entity instanceof CentipedeEvictorEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           CentipedeEvictorEntity.DATA_evictor_limit,
                           (
                                 entity instanceof CentipedeEvictorEntity _datEntIx
                                    ? (Integer)_datEntIx.getEntityData().get(CentipedeEvictorEntity.DATA_evictor_limit)
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
                        && (!(entityiterator instanceof LivingEntity _livEnt35) || !_livEnt35.hasEffect(MobEffects.DIG_SLOWDOWN))) {
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.FATIGUE_SHOW.get(), 5, 0, false, false));
                        }

                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2000, 2, false, false));
                        }

                        if (world instanceof Level _levelx) {
                           if (!_levelx.isClientSide()) {
                              _levelx.playSound(
                                 null,
                                 BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                 (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")),
                                 SoundSource.HOSTILE,
                                 0.5F,
                                 0.5F
                              );
                           } else {
                              _levelx.playLocalSound(
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

                        if (entity instanceof CentipedeEvictorEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(CentipedeEvictorEntity.DATA_evictor_limit, 1200);
                        }

                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:crawling_barrier_bypass_2"));
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
            }
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) && !entity.onGround()) {
            if (world.isClientSide()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
                  if (entity instanceof CentipedeEvictorEntity) {
                     if (entity instanceof CentipedeEvictorEntity) {
                        ((CentipedeEvictorEntity)entity).setAnimation("animation.centipedeevictor.grabmove");
                     }
                  } else if (entity instanceof CentipedeEvictorLarvaeEntity
                     && !ModList.get().isLoaded("nyfsspiders")
                     && entity instanceof CentipedeEvictorLarvaeEntity) {
                     ((CentipedeEvictorLarvaeEntity)entity).setAnimation("animation.centipedeevictor.grabmove");
                  }
               } else if (entity instanceof CentipedeEvictorEntity) {
                  if (((CentipedeEvictorEntity)entity).animationprocedure.equals("animation.centipedeevictor.grabmove")
                     && entity instanceof CentipedeEvictorEntity) {
                     ((CentipedeEvictorEntity)entity).setAnimation("empty");
                  }
               } else if (entity instanceof CentipedeEvictorLarvaeEntity
                  && ((CentipedeEvictorLarvaeEntity)entity).animationprocedure.equals("animation.centipedeevictor.grabmove")
                  && entity instanceof CentipedeEvictorLarvaeEntity) {
                  ((CentipedeEvictorLarvaeEntity)entity).setAnimation("empty");
               }
            }

            if (!ModList.get().isLoaded("nyfsspiders") || !(entity instanceof CentipedeEvictorLarvaeEntity)) {
               entity.setShiftKeyDown(true);
            }
         } else {
            if (world.isClientSide()) {
               if (entity instanceof CentipedeEvictorEntity) {
                  if (((CentipedeEvictorEntity)entity).animationprocedure.equals("animation.centipedeevictor.grabmove")
                     && entity instanceof CentipedeEvictorEntity) {
                     ((CentipedeEvictorEntity)entity).setAnimation("empty");
                  }
               } else if (entity instanceof CentipedeEvictorLarvaeEntity
                  && ((CentipedeEvictorLarvaeEntity)entity).animationprocedure.equals("animation.centipedeevictor.grabmove")
                  && entity instanceof CentipedeEvictorLarvaeEntity) {
                  ((CentipedeEvictorLarvaeEntity)entity).setAnimation("empty");
               }
            }

            entity.setShiftKeyDown(false);
         }

         if (!ModList.get().isLoaded("nyfsspiders")
            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
            && !entity.onGround()) {
            if (!world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))) {
               entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
            } else if (!world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))) {
               entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y, z));
            } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))) {
               entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 1.0));
            } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
               entity.lookAt(Anchor.EYES, new Vec3(x, y, z - 1.0));
            } else {
               entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y, z - 1.0));
            }
         }

         if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
            && !entity.onGround()
            && entity.getY() > (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY()) {
            if (!world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))) {
               entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), -0.5, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
            } else if (!world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))) {
               entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), -0.5, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
            } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))) {
               entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), -0.5, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
            } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
               entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), -0.5, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
            } else {
               entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), -0.5, Mth.nextDouble(RandomSource.create(), -0.5, 0.5)));
            }
         }

         label534: {
            if (entity instanceof LivingEntity _livEnt112 && _livEnt112.hasEffect(MobEffects.REGENERATION)) {
               break label534;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
            }

            if (entity instanceof CentipedeEvictorEntity) {
               entity.setMaxUpStep(2.0F);
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
               }
            }
         }

         if (entity instanceof CentipedeEvictorLarvaeEntity _datEntL117
            && (Boolean)_datEntL117.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_stronger)
            && world instanceof ServerLevel _levelxx) {
            _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
         }

         label434:
         if (entity instanceof CentipedeEvictorLarvaeEntity _datEntL119 && (Boolean)_datEntL119.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_stronger)
            )
          {
            if (entity instanceof LivingEntity _livEnt120 && _livEnt120.hasEffect(MobEffects.DAMAGE_BOOST)) {
               break label434;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
            }
         }

         if (entity.getDisplayName().getString().equals("Small Evictor") && entity instanceof CentipedeEvictorEntity) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, false, false));
            }

            if (world.isClientSide() && entity instanceof CentipedeEvictorEntity animatable) {
               animatable.setTexture("mediumevictor");
            }
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
            < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 3.0F) {
            if (entity instanceof CentipedeEvictorEntity) {
               if (world.isClientSide() && entity instanceof CentipedeEvictorEntity animatable) {
                  animatable.setTexture("centipedeevictorbossmissinglegs");
               }
            } else {
               label417:
               if (world.isClientSide()) {
                  if (entity instanceof CentipedeEvictorLarvaeEntity _datEntL134
                     && (Boolean)_datEntL134.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_stronger)) {
                     if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                        animatable.setTexture("centipedeevictorbossmissinglegs");
                     }
                     break label417;
                  }

                  if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                     animatable.setTexture("centipedeevictorlegsmissing");
                  }
               }
            }

            if ((!(entity instanceof LivingEntity _livEnt137) || !_livEnt137.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
            }
         } else if (entity instanceof CentipedeEvictorEntity) {
            if (world.isClientSide() && entity instanceof CentipedeEvictorEntity animatable) {
               animatable.setTexture("centipedeevictorboss");
            }
         } else {
            label407:
            if (world.isClientSide()) {
               if (entity instanceof CentipedeEvictorLarvaeEntity _datEntL143
                  && (Boolean)_datEntL143.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_stronger)) {
                  if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                     animatable.setTexture("centipedeevictorboss");
                  }
                  break label407;
               }

               if (entity instanceof CentipedeEvictorLarvaeEntity _datEntL145
                  && (Boolean)_datEntL145.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_shinier)) {
                  if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                     animatable.setTexture("sapphire_mob");
                  }
                  break label407;
               }

               if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                  animatable.setTexture("centipedeevictor");
               }
            }
         }

         if (entity instanceof CentipedeEvictorLarvaeEntity) {
            if (!entity.getPersistentData().getBoolean("despawn_skeleton")) {
               if (entity.isVehicle()
                  && entity.getFirstPassenger() != null
                  && entity.getFirstPassenger() instanceof Skeleton
                  && !entity.getFirstPassenger().level().isClientSide()) {
                  entity.getFirstPassenger().discard();
               }

               entity.getPersistentData().putBoolean("despawn_skeleton", true);
            }

            if (!world.getEntitiesOfClass(CentipedeEvictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
               && entity instanceof Mob _entity) {
               Entity var68 = world.getEntitiesOfClass(CentipedeEvictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var68 instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
            && entity instanceof CentipedeEvictorEntity
            && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
            if (!(entity.getPersistentData().getDouble("breaktime") > 0.0)) {
               entity.getPersistentData().putDouble("breaktime", 15.0);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass_pane"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #arphex:breakable_doors"
                        );
                  }
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #minecraft:leaves"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace cobweb"
                        );
                  }
               }
            } else {
               entity.getPersistentData().putDouble("breaktime", entity.getPersistentData().getDouble("breaktime") - 1.0);
            }
         }
      }
   }
}
