package net.arphex.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;

public class WarpWayfinderRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.isShiftKeyDown()) {
            if (entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Cannot set waypoints while the item is cooling down"), true);
               }

               return;
            }

            if (entity instanceof Player _player) {
               _player.closeContainer();
            }

            if (itemstack.getOrCreateTag().getDouble("target_1_x") == 0.0
               && itemstack.getOrCreateTag().getDouble("target_1_y") == 0.0
               && itemstack.getOrCreateTag().getDouble("target_1_z") == 0.0) {
               itemstack.getOrCreateTag().putDouble("target_1_x", x);
               itemstack.getOrCreateTag().putDouble("target_1_y", y);
               itemstack.getOrCreateTag().putDouble("target_1_z", z);
               itemstack.getOrCreateTag()
                  .putString(
                     "target_1_dimension",
                     (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                        + ""
                  );
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal("Added " + Math.round(x) + " / " + Math.round(y) + " / " + Math.round(z) + " waypoint position to slot 1"), true
                  );
               }
            } else if (itemstack.getOrCreateTag().getDouble("target_2_x") == 0.0
               && itemstack.getOrCreateTag().getDouble("target_2_y") == 0.0
               && itemstack.getOrCreateTag().getDouble("target_2_z") == 0.0) {
               itemstack.getOrCreateTag().putDouble("target_2_x", x);
               itemstack.getOrCreateTag().putDouble("target_2_y", y);
               itemstack.getOrCreateTag().putDouble("target_2_z", z);
               itemstack.getOrCreateTag()
                  .putString(
                     "target_2_dimension",
                     (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                        + ""
                  );
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal("Added " + Math.round(x) + " / " + Math.round(y) + " / " + Math.round(z) + " waypoint position to slot 2"), true
                  );
               }
            } else if (itemstack.getOrCreateTag().getDouble("target_3_x") == 0.0
               && itemstack.getOrCreateTag().getDouble("target_3_y") == 0.0
               && itemstack.getOrCreateTag().getDouble("target_3_z") == 0.0) {
               itemstack.getOrCreateTag().putDouble("target_3_x", x);
               itemstack.getOrCreateTag().putDouble("target_3_y", y);
               itemstack.getOrCreateTag().putDouble("target_3_z", z);
               itemstack.getOrCreateTag()
                  .putString(
                     "target_3_dimension",
                     (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                        + ""
                  );
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal("Added " + Math.round(x) + " / " + Math.round(y) + " / " + Math.round(z) + " waypoint position to slot 3"), true
                  );
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("3/3 waypoint slots used"), true);
            }
         }
      }
   }
}
