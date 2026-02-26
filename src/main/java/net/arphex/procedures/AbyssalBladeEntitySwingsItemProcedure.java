package net.arphex.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class AbyssalBladeEntitySwingsItemProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((entity instanceof Player _plrCldRem1 ? _plrCldRem1.getCooldowns().getCooldownPercent(itemstack.getItem(), 0.0F) * 100.0F : 0.0F) > 50.0F
            && (entity instanceof Player _plrCldRem3 ? _plrCldRem3.getCooldowns().getCooldownPercent(itemstack.getItem(), 0.0F) * 100.0F : 0.0F) < 99.0F
            && !entity.isShiftKeyDown()) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                  entity.getDeltaMovement().y(),
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
         }

         entity.getPersistentData().putDouble("justswung", 0.0);
      }
   }
}
