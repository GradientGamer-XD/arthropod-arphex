package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class ReturnCoords2Procedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
         return (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_2_x")
            + " / "
            + (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_2_y")
            + " / "
            + (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_2_z");
      } else {
         return (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()
            ? (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_2_x")
               + " / "
               + (entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_2_y")
               + " / "
               + (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("target_2_z")
            : "No wayfinder found";
      }
   }
}
