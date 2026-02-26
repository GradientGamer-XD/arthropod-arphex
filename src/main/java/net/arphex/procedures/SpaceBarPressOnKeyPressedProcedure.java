package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class SpaceBarPressOnKeyPressedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         boolean _setval = true;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.holdingspace = _setval;
            capability.syncPlayerVariables(entity);
         });
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
            || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()) {
            if (entity.getPersistentData().getDouble("doublejumpascendant") > 0.0) {
               if (!entity.getPersistentData().getBoolean("abflymode")) {
                  entity.getPersistentData().putBoolean("abflymode", true);
               } else {
                  entity.getPersistentData().putBoolean("abflymode", false);
               }
            }

            entity.getPersistentData().putDouble("doublejumpascendant", 6.0);
         }
      }
   }
}
