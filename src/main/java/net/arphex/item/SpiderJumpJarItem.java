package net.arphex.item;

import java.util.List;
import net.arphex.procedures.JumpJarTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class SpiderJumpJarItem extends Item {
   public SpiderJumpJarItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§nSpiderJump pet in a jar, renameable"));
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      JumpJarTickProcedure.execute(itemstack);
   }
}
