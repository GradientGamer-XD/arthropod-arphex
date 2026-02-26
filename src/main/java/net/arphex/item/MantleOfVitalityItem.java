package net.arphex.item;

import java.util.List;
import net.arphex.procedures.MantleOfVitalityItemInInventoryTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MantleOfVitalityItem extends Item {
   public MantleOfVitalityItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.RARE));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§bKeep in your inventory to prevent withering, necrosis, and poison"));
      list.add(Component.literal("§7Also works in Singularity Satchel slot"));
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      MantleOfVitalityItemInInventoryTickProcedure.execute(entity);
   }
}
