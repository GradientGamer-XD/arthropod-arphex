package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class TormentedWrathRightclickedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.TORMENTED_WRATH.get()
            && (entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TORMENTED_WRATH.get()
            && entity instanceof LivingEntity _entity) {
            _entity.stopUsingItem();
         }
      }
   }
}
