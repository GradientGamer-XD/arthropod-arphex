package net.arphex.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class MantisMacheteItem extends SwordItem {
   public MantisMacheteItem() {
      super(new Tier() {
         public int getUses() {
            return 800;
         }

         public float getSpeed() {
            return 14.0F;
         }

         public float getAttackDamageBonus() {
            return 6.0F;
         }

         public int getLevel() {
            return 4;
         }

         public int getEnchantmentValue() {
            return 2;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, 3, -3.2F, new Properties().fireResistant());
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("A deadly claw weapon dealing heavy armour piercing damage for backstab attacks"));
      list.add(Component.literal("§7Drops from Mantis Mutilator"));
   }
}
