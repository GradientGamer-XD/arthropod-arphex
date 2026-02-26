package net.arphex.item;

import java.util.List;
import net.arphex.procedures.VoidSherbetConsumedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class VoidSherbetItem extends Item {
   public VoidSherbetItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE).food(new Builder().nutrition(50).saturationMod(2.0F).alwaysEat().build()));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 30;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("A chillingly smooth sherbet laced with void essence, invigorating those with the mental fortitude to endure. "));
      list.add(Component.literal("- §cBeware, it deals heavy damage to those not wearing strong armour (netherite+)"));
      list.add(Component.literal("§7Effects: Resistance II (120s), Regeneration II (120s), Water Breathing (120s), Blindness (10s) "));
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      VoidSherbetConsumedProcedure.execute(entity);
      return retval;
   }
}
