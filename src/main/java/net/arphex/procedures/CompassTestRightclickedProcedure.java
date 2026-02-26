package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CompassTestRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean proceed = false;
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            return;
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 50, 0.3, 0.3, 0.3, 0.3);
         }

         if (entity.level().dimension() == Level.OVERWORLD) {
            proceed = true;
            entity.getPersistentData().putString("structure_choice", "arphex:crawling_castle");
         } else if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            proceed = true;
            if (entity.getY() > 229.0) {
               entity.getPersistentData().putString("structure_choice", "arphex:layer_one_dungeon");
            } else if (entity.getY() > 119.0) {
               if (entity.isShiftKeyDown()) {
                  entity.getPersistentData().putString("structure_choice", "arphex:layer_one_dungeon");
               } else {
                  entity.getPersistentData().putString("structure_choice", "arphex:layer_two_dungeon");
               }
            } else if (entity.getY() > 59.0) {
               if (entity.isShiftKeyDown()) {
                  entity.getPersistentData().putString("structure_choice", "arphex:layer_two_dungeon");
               } else {
                  entity.getPersistentData().putString("structure_choice", "arphex:layer_three_dungeon");
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("The compass can not find altars of the tormentor..."), true);
            }
         } else {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Item only works in the overworld and crawling dimensions"), true);
            }

            proceed = false;
         }

         if (proceed) {
            itemstack.setHoverName(Component.literal("scanning..."));
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 200);
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "scoreboard objectives add arphextriang0 dummy"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "scoreboard objectives add arphextriangx100 dummy"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "scoreboard objectives add arphextriangz100 dummy"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute as @p at @s positioned ~0 ~ ~ store result score @s arphextriang0 run locate structure "
                        + entity.getPersistentData().getString("structure_choice")
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute as @p at @s positioned ~100 ~ ~ store result score @s arphextriangx100 run locate structure "
                        + entity.getPersistentData().getString("structure_choice")
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute as @p at @s positioned ~ ~ ~100 store result score @s arphextriangz100 run locate structure "
                        + entity.getPersistentData().getString("structure_choice")
                  );
            }

            itemstack.getOrCreateTag().putBoolean("hasscanned", true);
         }
      }
   }
}
