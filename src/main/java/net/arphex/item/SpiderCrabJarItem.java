package net.arphex.item;

import java.util.List;
import net.arphex.procedures.SpiderCrabJarRightclickedProcedure;
import net.arphex.procedures.SpiderJarItemInInventoryTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class SpiderCrabJarItem extends Item {
   public SpiderCrabJarItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§nSpider Crab pet crammed into a jar, renameable"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      SpiderCrabJarRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      SpiderJarItemInInventoryTickProcedure.execute(entity, itemstack);
   }
}
