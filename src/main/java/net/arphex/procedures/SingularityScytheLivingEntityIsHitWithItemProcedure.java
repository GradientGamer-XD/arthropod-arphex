package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class SingularityScytheLivingEntityIsHitWithItemProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         itemstack.getOrCreateTag().putString("prevent_double_uuid", entity.getStringUUID());
      }
   }
}
