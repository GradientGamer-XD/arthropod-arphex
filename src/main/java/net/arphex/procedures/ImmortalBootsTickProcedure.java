package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ImmortalBootsTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean fly_or_sprint = false;
         double strength = 0.0;
         double crash_power = 0.0;
         double dist_reuse = 0.0;
         entity.fallDistance = 0.0F;
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.VOIDLASHER_CHAOS_CONTROL.get());
         }

         if (!world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
            && !world.isEmptyBlock(BlockPos.containing(x, y, z))
            && world.isEmptyBlock(BlockPos.containing(x, y + 0.1, z))
            && !entity.isShiftKeyDown()) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y - 0.2, z, 15, 0.3, 0.2, 0.3, 0.3);
            }

            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.01, entity.getDeltaMovement().z()));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 5, false, false));
            }
         }

         if (entity.getY() < 0.0 && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.VOID_AIR) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 50, 0.4, 0.1, 0.4, 0.2);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 160, 2));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 50, 3));
            }
         }

         if (entity.isSprinting()) {
            entity.setMaxUpStep(1.0F);
         } else {
            entity.setMaxUpStep(0.6F);
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:immortal_god"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "item modify entity @s armor.feet {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }

         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (entity.onGround()
            && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .holdingspace) {
            if (entity.isShiftKeyDown()) {
               entity.getPersistentData().putDouble("sneakjump_enable", 20.0);
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 10.0, entity.getDeltaMovement().z()));
            } else {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.8, entity.getDeltaMovement().z()));
            }
         }

         if (entity.isShiftKeyDown()
            && !(world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getBlock() instanceof LiquidBlock)
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 3, 12, false, false));
         }

         if (!(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                     } else {
                        return _ent.level().isClientSide() && _ent instanceof Player _player
                           ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                              && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR
                           : false;
                     }
                  }
               })
               .checkGamemode(entity)
            && !(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                     } else {
                        return _ent.level().isClientSide() && _ent instanceof Player _player
                           ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                              && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE
                           : false;
                     }
                  }
               })
               .checkGamemode(entity)
            && !(entity.getPersistentData().getDouble("sneakjump_enable") > 0.0)) {
            if (entity instanceof Player _playerx) {
               _playerx.getAbilities().mayfly = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .holdingspace
                  && !entity.onGround();
               _playerx.onUpdateAbilities();
            }

            if (entity instanceof Player _playerx) {
               _playerx.getAbilities().flying = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .holdingspace
                  && !entity.onGround();
               _playerx.onUpdateAbilities();
            }
         }

         fly_or_sprint = false;
         if (!(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                     } else {
                        return _ent.level().isClientSide() && _ent instanceof Player _player
                           ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                              && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR
                           : false;
                     }
                  }
               })
               .checkGamemode(entity)
            && !(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                     } else {
                        return _ent.level().isClientSide() && _ent instanceof Player _player
                           ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                              && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE
                           : false;
                     }
                  }
               })
               .checkGamemode(entity)) {
            if (entity.onGround()) {
               if (entity.isSprinting()) {
                  entity.setMaxUpStep(1.0F);
               } else {
                  entity.setMaxUpStep(0.6F);
               }

               entity.getPersistentData().putDouble("time_off_ground_vx", 0.0);
            } else {
               if (entity.getPersistentData().getDouble("time_off_ground_vx") < 21.0) {
                  entity.getPersistentData().putDouble("time_off_ground_vx", entity.getPersistentData().getDouble("time_off_ground_vx") + 1.0);
               }

               if (entity instanceof Player player && player.getAbilities().flying) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 0, false, false));
                  }

                  fly_or_sprint = true;
                  if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .holdingspace) {
                     if (!entity.isSprinting()) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() * 1.1, entity.getDeltaMovement().z()));
                     }
                  } else if (entity.getDeltaMovement().y() > -2.0) {
                     if (entity.getDeltaMovement().y() < 0.0) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() * 1.05, entity.getDeltaMovement().z()));
                     } else if (!(entity.getPersistentData().getDouble("sneakjump_enable") > 0.0)) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() - 0.02, entity.getDeltaMovement().z()));
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("time_off_ground_vx") > 12.0 && entity.isSprinting()) {
                  fly_or_sprint = true;
                  if (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().z()) < 1.65) {
                     entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 1.5, entity.getDeltaMovement().y(), entity.getDeltaMovement().z() * 1.5));
                  }
               }
            }

            if (fly_or_sprint && !entity.isPassenger() && world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.ENTROPY_SPLASH_PARTICLE.get(),
                  entity.getX(),
                  entity.getY() - 0.7,
                  entity.getZ(),
                  2,
                  0.0,
                  0.0,
                  0.0,
                  0.0
               );
            }

            entity.fallDistance = 0.0F;
         }

         if (entity.isShiftKeyDown()
            && !((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .holdingspace
            && entity.getDeltaMovement().y() < 0.0
            && !entity.onGround()
            && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))) {
            entity.getPersistentData().putDouble("immortal_impact_charge", entity.getPersistentData().getDouble("immortal_impact_charge") + 4.0);
            if (!(entity.getPersistentData().getDouble("sneakjump_enable") > 0.0)) {
               entity.setDeltaMovement(
                  new Vec3(
                     entity.getDeltaMovement().x(),
                     Math.min(entity.getDeltaMovement().y(), 0.0 - entity.getPersistentData().getDouble("immortal_impact_charge") / 40.0),
                     entity.getDeltaMovement().z()
                  )
               );
            }

            if (entity.getPersistentData().getDouble("immortal_impact_charge") > 20.0 && world instanceof ServerLevel _level) {
               _level.sendParticles(
                  ParticleTypes.EXPLOSION,
                  entity.getX(),
                  entity.getY() - 3.0,
                  entity.getZ(),
                  (int)Math.round(entity.getPersistentData().getDouble("immortal_impact_charge") / 4.0),
                  0.3 * (entity.getPersistentData().getDouble("immortal_impact_charge") / 20.0),
                  0.3 * (entity.getPersistentData().getDouble("immortal_impact_charge") / 20.0),
                  0.3 * (entity.getPersistentData().getDouble("immortal_impact_charge") / 20.0),
                  0.2
               );
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(
                  new MobEffectInstance(
                     MobEffects.MOVEMENT_SPEED, 10, (int)(entity.getPersistentData().getDouble("immortal_impact_charge") / 10.0), false, false
                  )
               );
            }

            if (entity.getPersistentData().getDouble("immortal_impact_charge") >= 200.0) {
               if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                  _playerx.displayClientMessage(Component.literal("§cImmortal Impact charged to full power"), true);
               }
            } else if (entity.getPersistentData().getDouble("immortal_impact_charge") > 49.0) {
               if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                  _playerx.displayClientMessage(
                     Component.literal("§6Immortal Impact charge level: " + Math.round(entity.getPersistentData().getDouble("immortal_impact_charge") / 10.0)),
                     true
                  );
               }
            } else if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(
                  Component.literal("Immortal Impact charge level: " + Math.round(entity.getPersistentData().getDouble("immortal_impact_charge") / 10.0)), true
               );
            }
         } else {
            if (entity.onGround() || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))) {
               crash_power = (double)Math.round(entity.getPersistentData().getDouble("immortal_impact_charge") / 10.0);
               if (crash_power > 20.0) {
                  crash_power = 20.0;
               }

               if (crash_power > 4.0) {
                  if (world instanceof Level _level) {
                     if (!_level.isClientSide()) {
                        _level.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:horrorcrash")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           0.8F
                        );
                     } else {
                        _level.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:horrorcrash")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           0.8F,
                           false
                        );
                     }
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(
                        ParticleTypes.EXPLOSION, x, y, z, (int)(crash_power * 10.0), 0.3 * crash_power, 0.3 * crash_power, 0.3 * crash_power, 0.2
                     );
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(crash_power / 2.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof LivingEntity) {
                        if (entityiterator instanceof TamableAnimal) {
                           TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                                 continue;
                              }
                           }
                        }

                        if (entityiterator != entity) {
                           dist_reuse = Math.sqrt(
                                 (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                    + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                    + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                              )
                              / 2.0;
                           if (dist_reuse < crash_power / 2.0) {
                              entityiterator.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                                 (float)Math.max(crash_power * 4.0 - dist_reuse, 5.0)
                              );
                           }
                        }
                     }
                  }

                  if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                        .spawn(_levelx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                     }
                  }

                  ArphexMod.queueServerWork(
                     2,
                     () -> {
                        if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                           Entity patt16411$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null);
                           if (patt16411$temp instanceof SphereAnimEntity _datEntSetS) {
                              _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "red");
                           }

                           patt16411$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null);
                           if (patt16411$temp instanceof SphereAnimEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_max_size, 100);
                           }
                        }
                     }
                  );
               }
            }

            entity.getPersistentData().putDouble("immortal_impact_charge", 0.0);
         }

         if (entity.isPassenger()
            && entity.getFirstPassenger() != null
            && entity.getFirstPassenger() instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false));
         }
      }
   }
}
