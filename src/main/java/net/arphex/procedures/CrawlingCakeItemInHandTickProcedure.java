package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class CrawlingCakeItemInHandTickProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.getOrCreateTag().getBoolean("cake_ready")) {
            entity.getPersistentData().putDouble("cake_dura_store", (double)itemstack.getDamageValue());
         }

         itemstack.getOrCreateTag().putBoolean("cake_ready", true);
      }
   }
}
