package net.arphex.procedures;

import net.arphex.entity.ButterflyBewitcherGiantEntity;
import net.arphex.entity.MantisMutilatorEntity;
import net.arphex.entity.SpiderLungerEntity;
import net.arphex.entity.SpiderMothSummonEntity;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.entity.WebHarnessEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class ReturnSpaceBarUnsetProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean client = false;
         client = false;
         if (entity.isPassenger()
            && entity.getVehicle() != null
            && (
               entity.getVehicle() instanceof ButterflyBewitcherGiantEntity
                  || entity.getVehicle() instanceof TamedTarantulaEntity
                  || entity.getVehicle() instanceof MantisMutilatorEntity
                  || entity.getVehicle() instanceof SpiderMothSummonEntity
                  || entity.getVehicle() instanceof WebHarnessEntity
                  || entity.getVehicle() instanceof TormentorSummonEntity
                  || entity.getVehicle() instanceof SpiderLungerEntity
            )) {
            client = true;
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
            || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()) {
            client = true;
         }

         if ((entity instanceof LivingEntity _entGetArmorxxxxxx ? _entGetArmorxxxxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_BOOTS.get()
            || (entity instanceof LivingEntity _entGetArmorxxxxx ? _entGetArmorxxxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_TIER_2_BOOTS.get()
            || (entity instanceof LivingEntity _entGetArmorxxxx ? _entGetArmorxxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_TIER_3_BOOTS.get()
            || (entity instanceof LivingEntity _entGetArmorxxx ? _entGetArmorxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.JUGGERNAUT_BOOTS.get()
            || (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.SPACETIME_BOOTS.get()
            || (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
               == ArphexModItems.ETERNAL_CHESTPLATE.get()
            || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.IMMORTAL_BOOTS.get()) {
            client = true;
         }

         return ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .player_overlay
            && client;
      }
   }
}
