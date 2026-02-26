package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SpacetimeLeggingsTickEventProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double sideways_key = 0.0;
         double forward_backwards_key = 0.0;
         double dot = 0.0;
         double theta = 0.0;
         double speed = 0.0;
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
                  "item modify entity @s armor.legs {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }

         if ((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > entity.getPersistentData().getDouble("bcst1")) {
            entity.getPersistentData().putDouble("bcst1", entity instanceof LivingEntity _livEntx ? (double)_livEntx.getHealth() : -1.0);
         }

         if (!(entity.getPersistentData().getDouble("buffer_cycle_spacetime") > 0.0)) {
            entity.getPersistentData().putDouble("bcst5", entity.getPersistentData().getDouble("bcst4"));
            entity.getPersistentData().putDouble("bcst4", entity.getPersistentData().getDouble("bcst3"));
            entity.getPersistentData().putDouble("bcst3", entity.getPersistentData().getDouble("bcst2"));
            entity.getPersistentData().putDouble("bcst2", entity.getPersistentData().getDouble("bcst1"));
            entity.getPersistentData().putDouble("bcst1", 0.0);
            entity.getPersistentData().putDouble("buffer_cycle_spacetime", 20.0);
         } else {
            entity.getPersistentData().putDouble("buffer_cycle_spacetime", entity.getPersistentData().getDouble("buffer_cycle_spacetime") - 1.0);
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) < 5.0F) {
            if (entity instanceof Player _plrCldCheck22 && _plrCldCheck22.getCooldowns().isOnCooldown(itemstack.getItem())) {
               return;
            }

            if (entity.getPersistentData().getDouble("bcst5") > entity.getPersistentData().getDouble("bcst4")) {
               entity.getPersistentData().putDouble("bcst4", entity.getPersistentData().getDouble("bcst5"));
            }

            if (entity.getPersistentData().getDouble("bcst4") > entity.getPersistentData().getDouble("bcst3")) {
               entity.getPersistentData().putDouble("bcst3", entity.getPersistentData().getDouble("bcst4"));
            }

            if (entity.getPersistentData().getDouble("bcst3") > entity.getPersistentData().getDouble("bcst2")) {
               entity.getPersistentData().putDouble("bcst2", entity.getPersistentData().getDouble("bcst3"));
            }

            if (entity.getPersistentData().getDouble("bcst2") > entity.getPersistentData().getDouble("bcst1")) {
               entity.getPersistentData().putDouble("bcst1", entity.getPersistentData().getDouble("bcst2"));
            }

            if (entity.getPersistentData().getDouble("bcst1") > (double)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F)
               && (entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) > 0.0F) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.setHealth((float)entity.getPersistentData().getDouble("bcst1"));
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 600);
               }

               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§2Health recovered through time!"), true);
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TIME_SPLASH_PARTICLE.get(), x, y, z, 5, 0.2, 0.3, 0.2, 0.1);
               }
            }
         }
      }
   }
}
