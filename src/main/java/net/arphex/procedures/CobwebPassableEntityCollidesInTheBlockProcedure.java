package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class CobwebPassableEntityCollidesInTheBlockProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _entGetArmorxxxx ? _entGetArmorxxxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               != ArphexModItems.CHITIN_ARMOUR_LEGGINGS.get()
            && (entity instanceof LivingEntity _entGetArmorxxx ? _entGetArmorxxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               != ArphexModItems.CHITIN_ARMOUR_TIER_2_LEGGINGS.get()
            && (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               != ArphexModItems.CHITIN_ARMOUR_TIER_3_LEGGINGS.get()
            && (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               != ArphexModItems.JUGGERNAUT_LEGGINGS.get()
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               != ArphexModItems.IMMORTAL_LEGGINGS.get()
            && entity.getDeltaMovement().x() + entity.getDeltaMovement().y() + entity.getDeltaMovement().z() > 1.0) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.9, entity.getDeltaMovement().y() * 0.9, entity.getDeltaMovement().z() * 0.9));
         }
      }
   }
}
