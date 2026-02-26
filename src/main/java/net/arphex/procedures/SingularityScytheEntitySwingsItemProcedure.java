package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SingularityScytheEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         itemstack.getOrCreateTag().putString("prevent_double_uuid", "");
         if (!entity.isShiftKeyDown()
            && !((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .just_right_clicked
            && entity instanceof Player player
            && player.containerMenu == player.inventoryMenu) {
            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (entity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown(itemstack.getItem())) {
                     return;
                  }

                  if (entity instanceof Player _player) {
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
                  }

                  entity.getPersistentData().putDouble("sing_scythe_anim", 10.0);
                  if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.SINGULARITY_SCYTHE.get()
                     && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.SINGULARITY_SCYTHE.get()) {
                     ArphexMod.queueServerWork(5, () -> {
                        if (entity instanceof LivingEntity _entity) {
                           _entity.swing(InteractionHand.OFF_HAND, true);
                        }
                     });
                  }
               }
            );
         }
      }
   }
}
