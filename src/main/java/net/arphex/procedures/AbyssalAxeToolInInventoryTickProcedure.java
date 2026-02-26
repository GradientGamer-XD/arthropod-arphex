package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class AbyssalAxeToolInInventoryTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.ABYSSAL_AXE.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.ABYSSAL_AXE.get()) {
            entity.getPersistentData().putDouble("axefallcheck", 0.0);
         }
      }
   }
}
