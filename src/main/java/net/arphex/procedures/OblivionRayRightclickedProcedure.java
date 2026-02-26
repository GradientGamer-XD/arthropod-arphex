package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class OblivionRayRightclickedProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())
            || (entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).getItem() == ArphexModItems.OBLIVION_RAY.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.OBLIVION_RAY.get()) {
            if (entity instanceof LivingEntity _entity) {
               _entity.stopUsingItem();
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.releaseUsingItem();
            }
         }
      }
   }
}
