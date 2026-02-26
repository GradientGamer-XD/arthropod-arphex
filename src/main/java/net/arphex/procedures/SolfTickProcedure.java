package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.SolifugeSkulkerEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SolfTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double checkx = 0.0;
         double checky = 0.0;
         double checkz = 0.0;
         double lowest = 0.0;
         boolean found = false;
         entity.getPersistentData().putBoolean("arphexclimber", true);
         entity.getPersistentData().putDouble("climbradius", 1.5);
         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.5, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 0.8, z)) && !entity.onGround()) {
            if (world.isClientSide()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
                  if (entity instanceof SolifugeSkulkerEntity) {
                     ((SolifugeSkulkerEntity)entity).setAnimation("animation.sunspider.grabmove");
                  }
               } else if (entity instanceof SolifugeSkulkerEntity) {
                  ((SolifugeSkulkerEntity)entity).setAnimation("empty");
               }
            }

            entity.setSprinting(true);
            entity.setShiftKeyDown(false);
         } else {
            label482: {
               if (entity instanceof SolifugeSkulkerEntity) {
                  ((SolifugeSkulkerEntity)entity).setAnimation("empty");
               }

               entity.setSprinting(false);
               if (entity instanceof SolifugeSkulkerEntity _datEntL13
                  && (Boolean)_datEntL13.getEntityData().get(SolifugeSkulkerEntity.DATA_warn)
                  && entity.getDeltaMovement().x() + entity.getDeltaMovement().y() + entity.getDeltaMovement().z() < 0.05) {
                  entity.setShiftKeyDown(true);
                  break label482;
               }

               entity.setShiftKeyDown(false);
            }
         }

         label456: {
            if (entity instanceof SolifugeSkulkerEntity _datEntL19 && (Boolean)_datEntL19.getEntityData().get(SolifugeSkulkerEntity.DATA_warn)) {
               if (Mth.nextInt(RandomSource.create(), 1, 600) == 10 && entity instanceof SolifugeSkulkerEntity _datEntSetL) {
                  _datEntSetL.getEntityData().set(SolifugeSkulkerEntity.DATA_warn, false);
               }
               break label456;
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2400) == 10 && entity instanceof SolifugeSkulkerEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(SolifugeSkulkerEntity.DATA_warn, true);
            }
         }

         entity.setMaxUpStep(1.0F);
         if (!(entity.getPersistentData().getDouble("findshadow") > 0.0)) {
            entity.getPersistentData().putDouble("findshadow", (double)Mth.nextInt(RandomSource.create(), 10, 20));
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               if (world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z)) >= world.getMaxLocalRawBrightness(BlockPos.containing(x - 5.0, y, z))
                  || world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z)) >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0))
                  || world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z)) >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 5.0))
                  || !world.isEmptyBlock(BlockPos.containing(x + 5.0, y, z))) {
                  if (world.getMaxLocalRawBrightness(BlockPos.containing(x - 5.0, y, z)) >= world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z))
                     || world.getMaxLocalRawBrightness(BlockPos.containing(x - 5.0, y, z))
                        >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0))
                     || world.getMaxLocalRawBrightness(BlockPos.containing(x - 5.0, y, z))
                        >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 5.0))
                     || !world.isEmptyBlock(BlockPos.containing(x - 5.0, y, z))) {
                     if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 5.0))
                           < world.getMaxLocalRawBrightness(BlockPos.containing(x - 5.0, y, z))
                        && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 5.0))
                           < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0))
                        && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 5.0))
                           < world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z))
                        && world.isEmptyBlock(BlockPos.containing(x, y, z + 5.0))) {
                        if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 5.0)) < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                           if (entity instanceof Mob _entity) {
                              _entity.getNavigation().moveTo(x, y, z + 5.0, 1.0);
                           }

                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                           }
                        }
                     } else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0))
                           < world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z))
                        && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0))
                           < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0))
                        && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0))
                           < world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z))
                        && world.isEmptyBlock(BlockPos.containing(x, y, z - 5.0))) {
                        if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 5.0)) < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                           if (entity instanceof Mob _entity) {
                              _entity.getNavigation().moveTo(x, y, z - 5.0, 1.0);
                           }

                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                           }
                        }
                     } else if (world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                           >= world.getMaxLocalRawBrightness(BlockPos.containing(x - 10.0, y, z))
                        || world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                           >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                        || world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                           >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 10.0))
                        || !world.isEmptyBlock(BlockPos.containing(x + 10.0, y, z))) {
                        if (world.getMaxLocalRawBrightness(BlockPos.containing(x - 10.0, y, z))
                              >= world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                           || world.getMaxLocalRawBrightness(BlockPos.containing(x - 10.0, y, z))
                              >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                           || world.getMaxLocalRawBrightness(BlockPos.containing(x - 10.0, y, z))
                              >= world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 10.0))
                           || !world.isEmptyBlock(BlockPos.containing(x - 10.0, y, z))) {
                           if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x - 10.0, y, z))
                              && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                              && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                              && world.isEmptyBlock(BlockPos.containing(x, y, z + 10.0))) {
                              if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z + 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                                 if (entity instanceof Mob _entity) {
                                    _entity.getNavigation().moveTo(x, y, z + 10.0, 1.0);
                                 }

                                 if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                                 }
                              }
                           } else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                              && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                              && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                              && world.isEmptyBlock(BlockPos.containing(x, y, z - 10.0))
                              && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z - 10.0))
                                 < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                              if (entity instanceof Mob _entity) {
                                 _entity.getNavigation().moveTo(x, y, z - 10.0, 1.0);
                              }

                              if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                              }
                           }
                        } else if (world.getMaxLocalRawBrightness(BlockPos.containing(x - 10.0, y, z))
                           < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                           if (entity instanceof Mob _entity) {
                              _entity.getNavigation().moveTo(x - 10.0, y, z, 1.0);
                           }

                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                           }
                        }
                     } else if (world.getMaxLocalRawBrightness(BlockPos.containing(x + 10.0, y, z))
                        < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().moveTo(x + 10.0, y, z, 1.0);
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                        }
                     }
                  } else if (world.getMaxLocalRawBrightness(BlockPos.containing(x - 5.0, y, z)) < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                     if (entity instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(x - 5.0, y, z, 1.0);
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                     }
                  }
               } else if (world.getMaxLocalRawBrightness(BlockPos.containing(x + 5.0, y, z)) < world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z))) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().moveTo(x + 5.0, y, z, 1.0);
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 8, false, false));
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("findshadow", entity.getPersistentData().getDouble("findshadow") - 1.0);
         }

         if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null
            && (!(entity instanceof LivingEntity _livEnt122) || !_livEnt122.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get()))
            && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) < 11
            && world instanceof Level _lvl124
            && _lvl124.isDay()
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 8, false, false));
         }

         if (!(entity.getPersistentData().getDouble("timer") > 0.0)) {
            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                     0.6,
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            }

            entity.getPersistentData().putDouble("timer", (double)Mth.nextInt(RandomSource.create(), 200, 600));
         } else {
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
               x,
               y + 1.0,
               z,
               (int)((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) / 6.0F),
               1.2,
               0.8,
               1.2,
               0.05
            );
         }

         label475: {
            if (entity instanceof LivingEntity _livEnt138 && _livEnt138.hasEffect(MobEffects.REGENERATION)) {
               break label475;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
            }

            if (entity instanceof CentipedeEvictorEntity) {
               entity.setMaxUpStep(4.0F);
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
               }
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
            < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 8.0F) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 3, false, false));
            }
         } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getHealth() : -1.0F)
            < (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 6.0F) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2, false, false));
            }
         } else if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getHealth() : -1.0F)
            < (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) / 4.0F) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
            }
         } else if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F) / 2.0F
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false));
         }

         if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getHealth() : -1.0F)
            < (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F) / 3.0F) {
            if (entity instanceof SolifugeSkulkerEntity animatable) {
               animatable.setTexture("sunspider2");
            }
         } else if (entity instanceof SolifugeSkulkerEntity animatable) {
            animatable.setTexture("sunspider");
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass_pane"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace #arphex:breakable_doors"
                     );
               }
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace oak_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace azalea_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace acacia_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace dark_oak_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace cherry_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace flowering_azalea_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace jungle_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace mangrove_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace spruce_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace birch_leaves"
                     );
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace cobweb"
                     );
               }
            }
         }
      }
   }
}
