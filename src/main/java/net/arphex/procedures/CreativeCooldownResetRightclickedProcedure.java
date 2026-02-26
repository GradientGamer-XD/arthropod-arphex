package net.arphex.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

public class CreativeCooldownResetRightclickedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
         entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
         if (_iitemhandlerref.get() != null) {
            for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
               ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstackiterator.getItem(), 1);
               }
            }
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns()
               .addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem(), 1);
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns()
               .addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem(), 1);
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns()
               .addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem(), 1);
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns()
               .addCooldown((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem(), 1);
         }

         double _setval = 0.0;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.inherent_power_cooldown = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }
}
