package net.arphex.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment.Rarity;

public class WitherAuraEnchantment extends Enchantment {
   public WitherAuraEnchantment(EquipmentSlot... slots) {
      super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
   }

   public int getMinLevel() {
      return 0;
   }

   public int getMaxLevel() {
      return 3;
   }

   public boolean isTreasureOnly() {
      return true;
   }

   public boolean isTradeable() {
      return false;
   }
}
