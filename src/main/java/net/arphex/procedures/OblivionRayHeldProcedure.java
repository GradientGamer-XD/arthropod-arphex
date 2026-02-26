package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.WarpStaffDirectionEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class OblivionRayHeldProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean upside_down_mode = false;
         double expand = 0.0;
         double distance = 0.0;
         double zfind = 0.0;
         double spheresize = 0.0;
         double pitch_distance_variance = 0.0;
         double pitch_variance = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_distance_variance = 0.0;
         double xfind = 0.0;
         double yfind = 0.0;
         double y_offset = 0.0;
         double yaw_variance = 0.0;
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
            && (entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).getItem() == ArphexModItems.OBLIVION_RAY.get()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:teleportermoth")),
                     SoundSource.NEUTRAL,
                     0.4F,
                     3.0F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:teleportermoth")),
                     SoundSource.NEUTRAL,
                     0.4F,
                     3.0F,
                     false
                  );
               }
            }

            if ((entity instanceof LivingEntity _entUseTicks6 ? _entUseTicks6.getTicksUsingItem() : 0) > 253) {
               if (entity instanceof Player _player) {
                  _player.getCooldowns()
                     .addCooldown(
                        itemstack.getItem(), Math.round((float)((entity instanceof LivingEntity _entUseTicks7 ? _entUseTicks7.getTicksUsingItem() : 0) / 2))
                     );
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.stopUsingItem();
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.releaseUsingItem();
               }
            }

            pitch_distance_variance = 140.0;
            yaw_distance_variance = 40.0;
            distance_scaling_factor = 1.0;
            y_offset = 1.0;
            xfind = (double)entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(125.0)), Block.COLLIDER, Fluid.NONE, entity
                  )
               )
               .getBlockPos()
               .getX();
            yfind = (double)entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(125.0)), Block.COLLIDER, Fluid.NONE, entity
                  )
               )
               .getBlockPos()
               .getY();
            zfind = (double)entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(125.0)), Block.COLLIDER, Fluid.NONE, entity
                  )
               )
               .getBlockPos()
               .getZ();
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(125.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player) {
                  double _setval = 5.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.laser_emitter_near = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }

               if (!itemstack.getOrCreateTag().getBoolean("oblivion_ray_mining_mode")
                  && entityiterator instanceof LivingEntity
                  && !(entityiterator instanceof WarpStaffDirectionEntity)
                  && entityiterator != entity) {
                  if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)) {
                     continue;
                  }

                  spheresize = 1.0;
                  distance = Math.sqrt(
                     (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                        + (entity.getY() - (entityiterator.getY() + y_offset)) * (entity.getY() - (entityiterator.getY() + y_offset))
                        + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                  );
                  pitch_variance = pitch_distance_variance / (distance / 0.7);
                  yaw_variance = yaw_distance_variance / (distance / 2.0);
                  expand = Math.sqrt(
                        (xfind - entity.getX()) * (xfind - entity.getX())
                           + (yfind - (entity.getY() + y_offset)) * (yfind - (entity.getY() + y_offset))
                           + (zfind - entity.getZ()) * (zfind - entity.getZ())
                     )
                     + 2.0;
                  if (!(expand < distance)
                     && Math.round(yaw_variance)
                        >= Math.round(
                           Math.min(
                              Math.abs(
                                 (
                                          Math.toDegrees(Math.atan2(entity.getZ() - entityiterator.getZ(), entity.getX() - entityiterator.getX()))
                                             - (double)entity.getYRot()
                                             + 360.0
                                       )
                                       % 360.0
                                    - 270.0
                              ),
                              360.0
                                 - Math.abs(
                                    (
                                             Math.toDegrees(Math.atan2(entity.getZ() - entityiterator.getZ(), entity.getX() - entityiterator.getX()))
                                                - (double)entity.getYRot()
                                                + 360.0
                                          )
                                          % 360.0
                                       - 270.0
                                 )
                           )
                        )
                     && Math.round(pitch_variance)
                        >= Math.round(
                           Math.abs(
                              (double)entity.getXRot()
                                 - Math.toDegrees(
                                    Math.atan2(
                                       entity.getY() + y_offset - entityiterator.getY(),
                                       Math.sqrt(
                                          (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                             + (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                       )
                                    )
                                 )
                           )
                        )) {
                     if (entityiterator instanceof Player) {
                        double _setval = 5.0;
                        entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.overlay_white = _setval;
                           capability.syncPlayerVariables(entityiterator);
                        });
                     }

                     if (entity.getPersistentData().getDouble("shootslow") == 5.0 || entity.getPersistentData().getDouble("shootslow") == 15.0) {
                        if (entity.getPersistentData().getBoolean("toggle_damage_health")) {
                           if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) < 30) {
                              if (Math.round(
                                    (double)(entity instanceof LivingEntity _entUseTicks66 ? _entUseTicks66.getTicksUsingItem() : 0) / 4.21
                                       - (double)((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) / 3)
                                 )
                                 >= 1L) {
                                 entityiterator.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                    (float)Math.round(
                                       (double)(entity instanceof LivingEntity _entUseTicks68 ? _entUseTicks68.getTicksUsingItem() : 0) / 4.21
                                          - (double)((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) / 3)
                                    )
                                 );
                              } else {
                                 entityiterator.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                    1.0F
                                 );
                              }
                           } else if (Math.round((double)(entity instanceof LivingEntity _entUseTicks74 ? _entUseTicks74.getTicksUsingItem() : 0) / 4.21 - 10.0)
                              >= 1L) {
                              entityiterator.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                 (float)Math.round(
                                    (double)(entity instanceof LivingEntity _entUseTicks75 ? _entUseTicks75.getTicksUsingItem() : 0) / 4.21 - 10.0
                                 )
                              );
                           } else {
                              entityiterator.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                 1.0F
                              );
                           }

                           entity.getPersistentData().putBoolean("toggle_damage_health", false);
                        } else {
                           if ((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) < 100.0F) {
                              if (Math.round(
                                    (double)(entity instanceof LivingEntity _entUseTicks82 ? _entUseTicks82.getTicksUsingItem() : 0) / 4.21
                                       - (double)(entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0)
                                 )
                                 < 5L) {
                                 entityiterator.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                    (float)Math.round(
                                       (double)(entity instanceof LivingEntity _entUseTicks84 ? _entUseTicks84.getTicksUsingItem() : 0) / 4.21
                                          - (double)(entityiterator instanceof LivingEntity _livEntxxx ? _livEntxxx.getArmorValue() : 0)
                                    )
                                 );
                              } else {
                                 entityiterator.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
                                    5.0F
                                 );
                              }
                           }

                           entity.getPersistentData().putBoolean("toggle_damage_health", true);
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:charred_blood "
                                    + entityiterator.getX()
                                    + " "
                                    + entityiterator.getY()
                                    + " "
                                    + entityiterator.getZ()
                                    + " 1 1 1 0.2 50 force"
                              );
                        }

                        if ((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) > 49.0F) {
                           if (world instanceof ServerLevel _levelx) {
                              _levelx.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:white_glow_smoke "
                                       + entityiterator.getX()
                                       + " "
                                       + entityiterator.getY()
                                       + " "
                                       + entityiterator.getZ()
                                       + " 0 0 0 0.2 3 force"
                                 );
                           }
                        } else if (world instanceof ServerLevel _levelx) {
                           _levelx.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:small_white_glow_smoke "
                                    + entityiterator.getX()
                                    + " "
                                    + entityiterator.getY()
                                    + " "
                                    + entityiterator.getZ()
                                    + " 0 0 0 0.1 3 force"
                              );
                        }
                     }
                  }
               }
            }

            if (!(entity.getPersistentData().getDouble("shootslow") > 0.0)) {
               entity.getPersistentData().putDouble("shootslow", 20.0);
               if (itemstack.getOrCreateTag().getBoolean("oblivion_ray_mining_mode")
                  && world.getBlockFloorHeight(BlockPos.containing(xfind, yfind, zfind)) > 0.0
                  && world instanceof Level _levelx
                  && !_levelx.isClientSide()) {
                  _levelx.explode(null, xfind, yfind, zfind, 2.0F, ExplosionInteraction.BLOCK);
               }
            } else {
               entity.getPersistentData().putDouble("shootslow", entity.getPersistentData().getDouble("shootslow") - 1.0);
            }
         }
      }
   }
}
