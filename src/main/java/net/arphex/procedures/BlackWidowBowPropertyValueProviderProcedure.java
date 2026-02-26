package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class BlackWidowBowPropertyValueProviderProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BLACK_WIDOW_BOW.get()) {
         return entity instanceof LivingEntity _entUseTicks2 ? (double)_entUseTicks2.getTicksUsingItem() : 0.0;
      } else {
         return 0.0;
      }
   }
}
