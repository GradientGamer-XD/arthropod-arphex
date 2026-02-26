package net.arphex.item;

import java.util.List;
import net.arphex.procedures.RequiredForAnimProcedure;
import net.arphex.procedures.VitalityViewfinderEntitySwingsItemProcedure;
import net.arphex.procedures.VitalityViewfinderItemInHandTickProcedure;
import net.arphex.procedures.VitalityViewfinderItemInInventoryTickProcedure;
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

public class VitalityViewfinderItem extends Item {
   public VitalityViewfinderItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BOW;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 40;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§bProvides a way to view the health information of any entity"));
      list.add(
         Component.literal("- Look at a mob and hold right click to measure its max health and current health (measures at longer distances if crouching)")
      );
      list.add(
         Component.literal(
            "- Left click to toggle \"lens mode\", where every time you hit an enemy it will inform you on damage output and target health percentage "
         )
      );
      list.add(Component.literal("§7Storable in Singularity Satchel slot"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      return ar;
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      VitalityViewfinderEntitySwingsItemProcedure.execute(entity, itemstack);
      return retval;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         VitalityViewfinderItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }

      VitalityViewfinderItemInInventoryTickProcedure.execute(entity, itemstack);
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      RequiredForAnimProcedure.execute();
   }
}
