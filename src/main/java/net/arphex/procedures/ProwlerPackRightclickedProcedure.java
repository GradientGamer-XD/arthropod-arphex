package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class ProwlerPackRightclickedProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (!world.isClientSide()) {
            if (entity.isShiftKeyDown()) {
               if (entity instanceof Player _player) {
                  _player.closeContainer();
               }

               if (itemstack.getOrCreateTag().getBoolean("graspmode")) {
                  itemstack.getOrCreateTag().putBoolean("graspmode", false);
               } else {
                  itemstack.getOrCreateTag().putBoolean("graspmode", true);
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.stopUsingItem();
            }
         }
      }
   }
}
