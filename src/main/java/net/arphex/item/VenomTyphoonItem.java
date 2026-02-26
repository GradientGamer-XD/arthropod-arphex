package net.arphex.item;

import java.util.List;
import net.arphex.procedures.HornetHailstormItemInHandTickProcedure;
import net.arphex.procedures.VenomTyphoonRightClickedProcedure;
import net.arphex.procedures.VenomTyphoonStoppedUsingProcedure;
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

public class VenomTyphoonItem extends Item {
   public VenomTyphoonItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BOW;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 127999;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§cA weapon capable of supplying endless swarms of tarantula hawks to sting your enemies to death"));
      list.add(
         Component.literal("- §dHold right mouse button to lock onto up to five targets, then release to fire a swarm of eight tarantula hawks to attack them")
      );
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      VenomTyphoonRightClickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         HornetHailstormItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      VenomTyphoonStoppedUsingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
   }
}
