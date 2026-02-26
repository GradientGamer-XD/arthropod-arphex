package net.arphex.item;

import java.util.List;
import net.arphex.procedures.WarpConnectorItemInHandTickProcedure;
import net.arphex.procedures.WarpConnectorRightclickedProcedure;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WarpConnectorItem extends Item {
   public WarpConnectorItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Used for linking tesseract transporters"));
      list.add(Component.literal("- Right click a target tesseract to store its coordinates, then another to set the target for teleportation"));
      list.add(Component.literal("- To reset coordinates, crouch + right click"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      WarpConnectorRightclickedProcedure.execute(world, entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         WarpConnectorItemInHandTickProcedure.execute(entity, itemstack);
      }
   }
}
