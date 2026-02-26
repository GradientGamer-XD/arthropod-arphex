package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;

public class Tel3dimensionmatchProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
            if (((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) + "")
                  .equals(
                     (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getOrCreateTag()
                        .getString("target_3_dimension")
                  )
               || (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .getString("target_3_dimension")
                     .length()
                  < 2) {
               return false;
            }
         } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
               == ArphexModItems.WARP_WAYFINDER.get()
            && (
               ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) + "")
                     .equals(
                        (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .getString("target_3_dimension")
                     )
                  || (entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY)
                        .getOrCreateTag()
                        .getString("target_3_dimension")
                        .length()
                     < 2
            )) {
            return false;
         }

         return true;
      }
   }
}
