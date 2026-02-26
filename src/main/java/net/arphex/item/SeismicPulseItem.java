package net.arphex.item;

import java.util.List;
import net.arphex.procedures.PortalAcceleratorItemInHandTickProcedure;
import net.arphex.procedures.RequiredForAnimProcedure;
import net.arphex.procedures.SeismicPulsePlayerFinishedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SeismicPulseItem extends Item {
   public SeismicPulseItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).food(new Builder().nutrition(0).saturationMod(0.3F).alwaysEat().build()));
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
      list.add(Component.literal("Consume to unlock the special §l§6Seismic Pulse Power"));
      list.add(
         Component.literal("§bThis power enables you to create powerful shockwaves by crouching and punching the ground, damaging and repelling nearby mobs")
      );
      list.add(Component.literal("After consumption, the power will be accessible via powers menu (see keyboard controls)"));
      list.add(Component.literal("§7Found rarely in dungeon chests"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      return ar;
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      SeismicPulsePlayerFinishedProcedure.execute(world, x, y, z, entity);
      return retval;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         PortalAcceleratorItemInHandTickProcedure.execute(entity);
      }
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      RequiredForAnimProcedure.execute();
   }
}
