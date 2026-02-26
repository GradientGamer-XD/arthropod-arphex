package net.arphex.procedures;

import java.text.DecimalFormat;
import java.util.Comparator;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTestEntity;
import net.arphex.entity.WarpStaffDirectionEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class VitalityViewfinderItemInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Radius = 0.0;
         double loop = 0.0;
         double particleSpeed = 0.0;
         double particleAmount = 0.0;
         if ((entity instanceof LivingEntity _entUseTicks0 ? _entUseTicks0.getTicksUsingItem() : 0) > 0) {
            loop = 0.0;
            particleAmount = 24.0;
            Radius = 0.75;

            for (double var38 = -0.25; loop < particleAmount; loop++) {
               world.addParticle(
                  (SimpleParticleType)ArphexModParticleTypes.WHITECOAL.get(),
                  x
                     + 0.25 * entity.getLookAngle().x
                     - 0.1 * entity.getLookAngle().z
                     + 0.75 * entity.getLookAngle().x
                     - Math.cos((Math.PI * 2) / particleAmount * loop) * Radius * entity.getLookAngle().z,
                  y + 1.3 + Math.sin((Math.PI * 2) / particleAmount * loop) * Radius,
                  z
                     + 0.25 * entity.getLookAngle().z
                     + 0.1 * entity.getLookAngle().x
                     + 0.75 * entity.getLookAngle().z
                     + Math.cos((Math.PI * 2) / particleAmount * loop) * Radius * entity.getLookAngle().x,
                  0.0 - Math.cos((Math.PI * 2) / particleAmount * loop) * var38 * entity.getLookAngle().z,
                  Math.sin((Math.PI * 2) / particleAmount * loop) * var38,
                  0.0 + Math.cos((Math.PI * 2) / particleAmount * loop) * var38 * entity.getLookAngle().x
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

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entity != entityiterator
                  && (!entity.isPassenger() || entity.getVehicle() != entityiterator || !(entity.getXRot() < 70.0F))
                  && !(entityiterator instanceof WarpStaffDirectionEntity)
                  && !(entityiterator instanceof TormentorTestEntity)
                  && !(entityiterator instanceof TormentorT2Entity)
                  && !(entityiterator instanceof TormentorT3Entity)
                  && !(entityiterator instanceof TormentorT4Entity)
                  && !(entityiterator instanceof TormentorT5Entity)) {
                  label579: {
                     if (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect((MobEffect)ArphexModMobEffects.ZOOM.get())) {
                        break label579;
                     }

                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.HEALTH_ANALYSIS.get(), 8, 0, false, false));
                     }

                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 8, 0, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ZOOM.get(), 8, 0, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt33 = (LivingEntity)entityiterator;
                     if (_livEnt33.hasEffect((MobEffect)ArphexModMobEffects.HEALTH_ANALYSIS.get())) {
                        entity.lookAt(
                           Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + (double)(entity.getBbHeight() / 2.0F), entityiterator.getZ())
                        );
                        if ((double)(entityiterator instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                           >= (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) * 0.1) {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle flame ^2.7 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        } else if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "execute as @p at @p anchored eyes run particle soul_fire_flame ^2.7 ^ ^"
                                    + new DecimalFormat("##.##")
                                       .format(
                                          Math.sqrt(
                                                (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                   + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                   + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                             )
                                             / 2.0
                                       )
                                    + " 0 0 0 0 10 force"
                              );
                        }

                        if ((entity instanceof LivingEntity _entUseTicks67 ? _entUseTicks67.getTicksUsingItem() : 0) > 8) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxx ? _livEntxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) * 0.2) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^2.1 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^2.1 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks96 ? _entUseTicks96.getTicksUsingItem() : 0) > 12) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) * 0.3) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^1.5 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^1.5 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks125 ? _entUseTicks125.getTicksUsingItem() : 0) > 16) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F) * 0.4) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^0.9 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^0.9 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks154 ? _entUseTicks154.getTicksUsingItem() : 0) > 20) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMaxHealth() : -1.0F) * 0.5) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^0.3 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^0.3 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks183 ? _entUseTicks183.getTicksUsingItem() : 0) > 24) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getMaxHealth() : -1.0F) * 0.6) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^-0.3 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^-0.3 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks212 ? _entUseTicks212.getTicksUsingItem() : 0) > 28) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getMaxHealth() : -1.0F) * 0.7) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^-0.9 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^-0.9 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks241 ? _entUseTicks241.getTicksUsingItem() : 0) > 32) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getMaxHealth() : -1.0F) * 0.8) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^-1.5 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^-1.5 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks270 ? _entUseTicks270.getTicksUsingItem() : 0) > 36) {
                           if ((double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxx.getHealth() : -1.0F)
                              >= (double)(entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxx.getMaxHealth() : -1.0F)
                                 * 0.9) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^-2.1 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^-2.1 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }

                        if ((entity instanceof LivingEntity _entUseTicks299 ? _entUseTicks299.getTicksUsingItem() : 0) >= 39) {
                           label504:
                           if (entityiterator instanceof LivingEntity _livEnt300 && _livEnt300.hasEffect(MobEffects.ABSORPTION)
                              || entityiterator instanceof LivingEntity _livEnt301 && _livEnt301.hasEffect(MobEffects.HEALTH_BOOST)) {
                              if (entityiterator instanceof LivingEntity _livEnt302 && _livEnt302.hasEffect(MobEffects.ABSORPTION)) {
                                 if (entityiterator instanceof LivingEntity _livEnt303 && _livEnt303.hasEffect(MobEffects.HEALTH_BOOST)) {
                                    if (entity instanceof Player _player && !_player.level().isClientSide()) {
                                       DecimalFormat var159;
                                       float var167;
                                       float var174;
                                       int var181;
                                       label489: {
                                          var159 = new DecimalFormat("##.##");
                                          var167 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                             ? _livEntxxxxxxxxxxxxxxxxxx.getHealth()
                                             : -1.0F;
                                          var174 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                             ? _livEntxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                             : -1.0F;
                                          if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx
                                             && _livEntxxxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.HEALTH_BOOST)) {
                                             var181 = _livEntxxxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.HEALTH_BOOST).getAmplifier();
                                             break label489;
                                          }

                                          var181 = 0;
                                       }

                                       label484: {
                                          var174 += (float)((var181 + 1) * 4);
                                          if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                             && _livEntxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.ABSORPTION)) {
                                             var181 = _livEntxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.ABSORPTION).getAmplifier();
                                             break label484;
                                          }

                                          var181 = 0;
                                       }

                                       label478: {
                                          var160 = var159.format((double)(var167 / (var174 + (float)((var181 + 1) * 4)) * 100.0F));
                                          var168 = new DecimalFormat("##.##");
                                          var174 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                             ? _livEntxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                             : -1.0F;
                                          if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                             && _livEntxxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.HEALTH_BOOST)) {
                                             var181 = _livEntxxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.HEALTH_BOOST).getAmplifier();
                                             break label478;
                                          }

                                          var181 = 0;
                                       }

                                       label473: {
                                          var174 += (float)((var181 + 1) * 4);
                                          if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                             && _livEntxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.ABSORPTION)) {
                                             var181 = _livEntxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.ABSORPTION).getAmplifier();
                                             break label473;
                                          }

                                          var181 = 0;
                                       }

                                       _player.displayClientMessage(
                                          Component.literal(
                                             "Analysis: " + var160 + "% of " + var168.format((double)(var174 + (float)((var181 + 1) * 4))) + " Max Health"
                                          ),
                                          true
                                       );
                                    }
                                    break label504;
                                 }

                                 if (entity instanceof Player _player && !_player.level().isClientSide()) {
                                    DecimalFormat var157;
                                    float var165;
                                    float var172;
                                    int var179;
                                    label465: {
                                       var157 = new DecimalFormat("##.##");
                                       var165 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                          ? _livEntxxxxxxxxxxxxxxxxxx.getHealth()
                                          : -1.0F;
                                       var172 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                          ? _livEntxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                          : -1.0F;
                                       if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx
                                          && _livEntxxxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.ABSORPTION)) {
                                          var179 = _livEntxxxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.ABSORPTION).getAmplifier();
                                          break label465;
                                       }

                                       var179 = 0;
                                    }

                                    label459: {
                                       var158 = var157.format((double)(var165 / (var172 + (float)((var179 + 1) * 4)) * 100.0F));
                                       var166 = new DecimalFormat("##.##");
                                       var172 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                          ? _livEntxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                          : -1.0F;
                                       if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                          && _livEntxxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.ABSORPTION)) {
                                          var179 = _livEntxxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.ABSORPTION).getAmplifier();
                                          break label459;
                                       }

                                       var179 = 0;
                                    }

                                    _player.displayClientMessage(
                                       Component.literal(
                                          "Analysis: " + var158 + "% of " + var166.format((double)(var172 + (float)((var179 + 1) * 4))) + " Max Health"
                                       ),
                                       true
                                    );
                                 }
                                 break label504;
                              }

                              if (entity instanceof Player _player && !_player.level().isClientSide()) {
                                 DecimalFormat var155;
                                 float var163;
                                 float var170;
                                 int var10004;
                                 label451: {
                                    var155 = new DecimalFormat("##.##");
                                    var163 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getHealth() : -1.0F;
                                    var170 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                       ? _livEntxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                       : -1.0F;
                                    if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx
                                       && _livEntxxxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.HEALTH_BOOST)) {
                                       var10004 = _livEntxxxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.HEALTH_BOOST).getAmplifier();
                                       break label451;
                                    }

                                    var10004 = 0;
                                 }

                                 label445: {
                                    var156 = var155.format((double)(var163 / (var170 + (float)((var10004 + 1) * 4)) * 100.0F));
                                    var164 = new DecimalFormat("##.##");
                                    var170 = entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                       ? _livEntxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                       : -1.0F;
                                    if (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                       && _livEntxxxxxxxxxxxxxxxxxxx.hasEffect(MobEffects.HEALTH_BOOST)) {
                                       var10004 = _livEntxxxxxxxxxxxxxxxxxxx.getEffect(MobEffects.HEALTH_BOOST).getAmplifier();
                                       break label445;
                                    }

                                    var10004 = 0;
                                 }

                                 _player.displayClientMessage(
                                    Component.literal(
                                       "Analysis: " + var156 + "% of " + var164.format((double)(var170 + (float)((var10004 + 1) * 4))) + " Max Health"
                                    ),
                                    true
                                 );
                              }
                           } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                              _player.displayClientMessage(
                                 Component.literal(
                                    "Analysis: "
                                       + new DecimalFormat("##.##")
                                          .format(
                                             (double)(
                                                (
                                                      entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx
                                                         ? _livEntxxxxxxxxxxxxxxxxxxxx.getHealth()
                                                         : -1.0F
                                                   )
                                                   / (
                                                      entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                                         ? _livEntxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                         : -1.0F
                                                   )
                                                   * 100.0F
                                             )
                                          )
                                       + "% of "
                                       + new DecimalFormat("##.##")
                                          .format(
                                             entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                                ? (double)_livEntxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                : -1.0
                                          )
                                       + " Max Health"
                                 ),
                                 true
                              );
                           }

                           if (entity instanceof Player _player) {
                              _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
                           }

                           if ((entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxx.getHealth() : -1.0F)
                              == (entityiterator instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getMaxHealth() : -1.0F)) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "execute as @p at @p anchored eyes run particle flame ^-2.7 ^ ^"
                                          + new DecimalFormat("##.##")
                                             .format(
                                                Math.sqrt(
                                                      (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                         + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                         + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                   )
                                                   / 2.0
                                             )
                                          + " 0 0 0 0 10 force"
                                    );
                              }
                           } else if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "execute as @p at @p anchored eyes run particle soul_fire_flame ^-2.7 ^ ^"
                                       + new DecimalFormat("##.##")
                                          .format(
                                             Math.sqrt(
                                                   (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                      + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                      + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                                )
                                                / 2.0
                                          )
                                       + " 0 0 0 0 10 force"
                                 );
                           }
                        }
                     }
                  }
               }
            }

            if ((entity instanceof LivingEntity _entUseTicks359 ? _entUseTicks359.getTicksUsingItem() : 0) == 1) {
               entity.getPersistentData().putDouble("zoomglow", 0.0);
            }

            if (!(entity instanceof LivingEntity _livEnt361) || !_livEnt361.hasEffect((MobEffect)ArphexModMobEffects.ZOOM.get())) {
               if (entity.getPersistentData().getDouble("zoomglow") > 20.0
                  && (entity.getPersistentData().getDouble("zoomglow") > 200.0 || !entity.isShiftKeyDown())) {
                  entity.getPersistentData().putDouble("zoomglow", 0.0);
               } else {
                  entity.getPersistentData().putDouble("zoomglow", entity.getPersistentData().getDouble("zoomglow") + 3.0);
               }
            }
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:viewfinder_obtain"));
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
