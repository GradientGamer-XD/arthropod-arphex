package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class RushScareOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double pitch_variance = 0.0;
         double random_once = 0.0;
         double store_dist = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "execute as @e[type=arphex:rush_scare,limit=1,sort=nearest] run data merge entity @s {Invulnerable:1}"
               );
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()) {
            entity.setSprinting(true);
         } else {
            entity.setSprinting(false);
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.5, 4.5, 4.5), e -> true).isEmpty()) {
            if (entity.getPersistentData().getBoolean("onescream")) {
               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.2)
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        (float)Mth.nextDouble(RandomSource.create(), 0.8, 1.2),
                        false
                     );
                  }
               }

               entity.getPersistentData().putBoolean("onescream", false);
            }

            if (entity.getPersistentData().getBoolean("puller")) {
               label200: {
                  Entity _livEnt57 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.5, 4.5, 4.5), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_livEnt57 instanceof LivingEntity _livEnt13 && _livEnt13.isBlocking()) {
                     break label200;
                  }

                  int var10000;
                  label184: {
                     _livEnt57 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.5, 4.5, 4.5), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (_livEnt57 instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON)) {
                        var10000 = _livEnt.getEffect(MobEffects.POISON).getAmplifier();
                        break label184;
                     }

                     var10000 = 0;
                  }

                  if (var10000 <= 1 && world instanceof ServerLevel _levelx) {
                     _levelx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "effect give @p[distance=..6] poison 10 2 true"
                        );
                  }
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "effect give @p[distance=..6] levitation 4 0 true"
                     );
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "effect give @p[distance=..6] darkness 2 0 true"
                     );
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "effect give @p[distance=..6] slow_falling 10 0 true"
                     );
               }

               ArphexMod.queueServerWork(
                  300,
                  () -> {
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "effect clear @p levitation"
                           );
                     }
                  }
               );
            } else {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "effect give @p[distance=..6] blindness 1 1 true"
                     );
               }

               ArphexMod.queueServerWork(8, () -> {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               });
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).isEmpty()) {
            entity.lookAt(
               Anchor.EYES,
               new Vec3(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  y,
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               )
            );
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).isEmpty()
               && entity.getPersistentData().getBoolean("puller")
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3.0, 3.0, 3.0), e -> true).isEmpty()) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            } else {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                     0.0,
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                  )
               );
            }

            entity.teleportTo(
               x, world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(), z
            );
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection
                  .teleport(
                     x, world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(), z, entity.getYRot(), entity.getXRot()
                  );
            }
         }

         ArphexMod.queueServerWork(500, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 5, false, false));
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()
            && (
               entity.isInWall()
                  || world.getBlockState(BlockPos.containing(x + 1.0, y, z)).canOcclude()
                  || world.getBlockState(BlockPos.containing(x - 1.0, y, z)).canOcclude()
                  || world.getBlockState(BlockPos.containing(x, y + 1.0, z)).canOcclude()
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).canOcclude()
                  || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).canOcclude()
                  || world.getBlockState(BlockPos.containing(x, y, z - 1.0)).canOcclude()
            )
            && world instanceof ServerLevel _levelx) {
            _levelx.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null)
                     .withSuppressedOutput(),
                  "execute at @e[type=arphex:rush_scare,limit=1,sort=nearest] run tp @e[type=arphex:rush_scare,limit=1,sort=nearest] ^ ^0.02 ^0.08"
               );
         }

         if (entity.isInWater() && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.setCustomName(Component.literal(""));

         for (Entity entityiterator : new ArrayList(world.players())) {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt57x = (LivingEntity)entityiterator;
               if (_livEnt57x.hasEffect((MobEffect)ArphexModMobEffects.SPLINTERED_SANITY.get())) {
                  store_dist = Math.sqrt(
                     (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                        + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                        + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                  );
                  if (store_dist < 4.0) {
                     if (!(entity.getPersistentData().getDouble("slow_splinter") > 0.0)) {
                        entity.getPersistentData().putDouble("slow_splinter", 10.0);
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 5.0F
                        );
                     } else {
                        entity.getPersistentData().putDouble("slow_splinter", entity.getPersistentData().getDouble("slow_splinter") - 1.0);
                     }
                  } else if (store_dist < 100.0 && entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (_entity.swinging) {
                        pitch_variance = 25.0;
                        yaw_variance = 25.0;
                        distance_scaling_factor = 0.1;
                        if (yaw_variance
                                 / (
                                    Math.sqrt(
                                          (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                             + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                             + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                       )
                                       / 2.0
                                       * distance_scaling_factor
                                 )
                              > Math.min(
                                 Math.abs(
                                    (
                                             Math.toDegrees(Math.atan2(entityiterator.getZ() - entity.getZ(), entityiterator.getX() - entity.getX()))
                                                - (double)entityiterator.getYRot()
                                                + 360.0
                                          )
                                          % 360.0
                                       - 270.0
                                 ),
                                 360.0
                                    - Math.abs(
                                       (
                                                Math.toDegrees(Math.atan2(entityiterator.getZ() - entity.getZ(), entityiterator.getX() - entity.getX()))
                                                   - (double)entityiterator.getYRot()
                                                   + 360.0
                                             )
                                             % 360.0
                                          - 270.0
                                    )
                              )
                           && pitch_variance
                                 / (
                                    Math.sqrt(
                                          (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                             + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                             + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                       )
                                       / 2.0
                                       * distance_scaling_factor
                                 )
                              > (double)Math.round(
                                 Math.abs(
                                    (double)entityiterator.getXRot()
                                       - Math.toDegrees(
                                          Math.atan2(
                                             entityiterator.getY() - entity.getY(),
                                             Math.sqrt(
                                                (entityiterator.getZ() - entity.getZ()) * (entityiterator.getZ() - entity.getZ())
                                                   + (entityiterator.getX() - entity.getX()) * (entityiterator.getX() - entity.getX())
                                             )
                                          )
                                       )
                                 )
                              )) {
                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }

                           random_once = (double)Mth.nextInt(RandomSource.create(), 1, 5);
                           if (random_once == 1.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 2));
                                 }
                              }
                           } else if (random_once == 2.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 2));
                                 }
                              }
                           } else if (random_once == 3.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2));
                                 }
                              }
                           } else if (random_once == 4.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entityx = (LivingEntity)entityiterator;
                                 if (!_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2));
                                 }
                              }
                           } else if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entityx = (LivingEntity)entityiterator;
                              if (!_entityx.level().isClientSide()) {
                                 _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2));
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
