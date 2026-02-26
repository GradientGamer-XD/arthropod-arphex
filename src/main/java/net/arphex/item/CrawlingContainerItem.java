package net.arphex.item;

import java.util.List;
import net.arphex.procedures.PocketDimensionItemTestItemInInventoryTickProcedure;
import net.arphex.procedures.PocketDimensionItemTestRightclickedProcedure;
import net.arphex.procedures.RequiredForAnimProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CrawlingContainerItem extends Item {
   public CrawlingContainerItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BOW;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 20;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§cEnables you to teleport to a personal pocket dimension above the Crawling (one chunk in size, one per player per world)"));
      list.add(
         Component.literal(
            "- §6Right click to enter your pocket dimension, or right click again to return to your previous location and dimension (or your spawnpoint if crouching)"
         )
      );
      list.add(
         Component.literal(
            "- §dLeft click a weak mob or any player, then teleport (right click) within five seconds to bring them with you (players need to give permission within this time by right clicking you)"
         )
      );
      list.add(Component.literal("- When in your pocket dimension, hitting an entity expels it back to your previous location"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      PocketDimensionItemTestRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      PocketDimensionItemTestItemInInventoryTickProcedure.execute(entity, itemstack);
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      RequiredForAnimProcedure.execute();
   }
}
