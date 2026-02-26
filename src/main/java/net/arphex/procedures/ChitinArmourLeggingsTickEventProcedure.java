package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class ChitinArmourLeggingsTickEventProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.WEBBED.get());
         }

         if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_TIER_3_LEGGINGS.get() || itemstack.getItem() == ArphexModItems.JUGGERNAUT_LEGGINGS.get()) {
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

            itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         }

         if (itemstack.getItem() != ArphexModItems.CHITIN_ARMOUR_LEGGINGS.get()
            && !world.isClientSide()
            && !entity.level().isClientSide()
            && entity.getServer() != null) {
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
                  "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 arphex:cobweb_passable replace cobweb"
               );
         }
      }
   }
}
