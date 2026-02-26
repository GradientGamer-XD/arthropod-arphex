package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class SlingWebRightclickedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("slingtime") <= 2.0
            || entity.getPersistentData().getDouble("slingtime") == 5.0
            || entity.getPersistentData().getDouble("slingtime") == 9.0) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.SILK_SLINGER.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.TARANTULA_TETHER.get()) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.OFF_HAND, true);
               }
            } else if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }
         }

         entity.getPersistentData().putDouble("slingtime", entity.getPersistentData().getDouble("slingtime") + 1.0);
      }
   }
}
