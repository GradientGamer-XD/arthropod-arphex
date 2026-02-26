package net.arphex.item;

import java.util.List;
import net.arphex.procedures.AntCommanderItemInInventoryTickProcedure;
import net.arphex.procedures.AntCommanderRightclickedProcedure;
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
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AntCommanderItem extends Item {
   public AntCommanderItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.RARE));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Command staff for worker ants in your colony"));
      list.add(Component.literal("- §eRight click to command nearby ants to build a temporary defensive structure at your position "));
      list.add(Component.literal("§7§lQueen proximity functions"));
      list.add(Component.literal("- Left click a block type to mark it for breaking (stone or logs, any other disables)"));
      list.add(
         Component.literal(
            "- §eCrouch+Right click to prioritize current area near queen for defending, planting, or block breaking (for ants not following you)"
         )
      );
      list.add(Component.literal("- Crouch+Left click ground anywhere to remove area designation"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      AntCommanderRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      AntCommanderItemInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      RequiredForAnimProcedure.execute();
   }
}
