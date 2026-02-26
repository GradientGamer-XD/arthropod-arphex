package net.arphex.item;

import java.util.List;
import net.arphex.procedures.InfiniteTormentItemInHandTickProcedure;
import net.arphex.procedures.InfiniteTormentItemInInventoryTickProcedure;
import net.arphex.procedures.InfiniteTormentLivingEntityIsHitWithItemProcedure;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class InfiniteTormentItem extends Item {
   public InfiniteTormentItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BOW;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 128000;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public boolean isCorrectToolForDrops(BlockState state) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§dAttempts to instantly kill any mob you hit with it, no matter how strong"));
      list.add(Component.literal("- §aCrouch while hitting to despawn them instead"));
      list.add(Component.literal("- §4Hold right mouse button for AoE percentage-based damage output"));
      list.add(Component.literal("- §6Extreme attack reach"));
      list.add(Component.literal("- §eInvincible while holding"));
      list.add(Component.literal("- Gives trophies instantly for any ArPhEx mob"));
      list.add(Component.literal("§l§fObtainable in creative mode only"));
      list.add(Component.literal("§c§lINFINITE ATTACK DAMAGE"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      return ar;
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      InfiniteTormentLivingEntityIsHitWithItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
      return retval;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         InfiniteTormentItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
      }

      InfiniteTormentItemInInventoryTickProcedure.execute(entity);
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      RequiredForAnimProcedure.execute();
   }
}
