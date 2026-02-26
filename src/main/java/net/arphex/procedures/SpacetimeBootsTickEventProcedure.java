package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SpacetimeBootsTickEventProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double recover_y = 0.0;
         boolean fly_or_sprint = false;
         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
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
            .checkGamemode(entity)) {
            if (entity instanceof Player _player) {
               _player.getAbilities().mayfly = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .holdingspace
                  && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.SPACETIME_BOOTS.get();
               _player.onUpdateAbilities();
            }

            if (entity instanceof Player _player) {
               _player.getAbilities().flying = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .holdingspace
                  && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.SPACETIME_BOOTS.get();
               _player.onUpdateAbilities();
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
                     } else if (!(new Object() {
                              public boolean checkGamemode(Entity _ent) {
                                 if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                 } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                       ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                          && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                             == GameType.SPECTATOR
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
                                          && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                             == GameType.CREATIVE
                                       : false;
                                 }
                              }
                           })
                           .checkGamemode(entity)) {
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

         if (entity.isPassenger()
            && entity.getFirstPassenger() != null
            && entity.getFirstPassenger() instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false));
         }
      }
   }
}
