package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class AbyssalDaggerRightclickedProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            return;
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_DAGGER.get()
            && entity instanceof LivingEntity _entity) {
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_DAGGER.get()
            && entity instanceof LivingEntity _entity) {
            _entity.swing(InteractionHand.OFF_HAND, true);
         }
      }
   }
}
