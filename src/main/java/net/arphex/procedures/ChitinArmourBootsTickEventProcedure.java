package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class ChitinArmourBootsTickEventProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double strength = 0.0;
         if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_BOOTS.get()) {
            strength = 0.3;
         } else if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_TIER_2_BOOTS.get()) {
            strength = 0.5;
         } else {
            if (itemstack.getItem() == ArphexModItems.JUGGERNAUT_BOOTS.get()) {
               entity.fallDistance = 0.0F;
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
            strength = 0.8;
         }

         if (entity.onGround()) {
            entity.getPersistentData().putString("chitindoublejump", "reset");
         } else if (!((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .orElse(new ArphexModVariables.PlayerVariables()))
            .holdingspace) {
            if (entity.getPersistentData().getString("chitindoublejump").equals("reset")) {
               entity.getPersistentData().putString("chitindoublejump", "primed");
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 2);
               }
            }
         } else if (entity.getPersistentData().getString("chitindoublejump").equals("primed")
            && (!(entity instanceof Player _plrCldCheck18) || !_plrCldCheck18.getCooldowns().isOnCooldown(itemstack.getItem()))) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), strength, entity.getDeltaMovement().z()));
            entity.fallDistance = 0.0F;
            ArphexMod.queueServerWork(10, () -> {
               entity.fallDistance = 0.0F;
               ArphexMod.queueServerWork(10, () -> entity.fallDistance = 0.0F);
            });
            entity.getPersistentData().putString("chitindoublejump", "done");
         }
      }
   }
}
