package net.arphex.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import net.arphex.procedures.AbyssBladeRightClickProcedure;
import net.arphex.procedures.AbyssalBladeEntitySwingsItemProcedure;
import net.arphex.procedures.AbyssalBladeHasItemGlowingEffectProcedure;
import net.arphex.procedures.AbyssalBladeItemInHandTickProcedure;
import net.arphex.procedures.AbyssalBladeItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.AbyssalBladeLivingEntityIsHitWithItemProcedure;
import net.arphex.procedures.AbyssalBladePlayerFinishesUsingItemProcedure;
import net.arphex.procedures.RequiredForAnimProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
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

public class AbyssalBladeItem extends Item {
   public AbyssalBladeItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BOW;
   }

   public int getEnchantmentValue() {
      return 25;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 1200;
   }

   public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
      return 1.5F;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 14.0, Operation.ADDITION));
         builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, Operation.ADDITION));
         return builder.build();
      } else {
         return super.getDefaultAttributeModifiers(equipmentSlot);
      }
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      Entity entity = Minecraft.getInstance().player;
      return AbyssalBladeHasItemGlowingEffectProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal(
            "§5A sword forged from the darkest depths of the abyss, imbued with the power to combat the nightmarish horrors that lurk beneath the surface"
         )
      );
      list.add(Component.literal("- §eAttacks weaken and wither enemies"));
      list.add(Component.literal("- Right click to dodge/block damage and fire a lifesteal projectile, or left click immediately afterward to lunge forwards"));
      list.add(Component.literal("- §dGlows when you are being targeted"));
      list.add(Component.literal("Bonus: Try combining with another abyssal blade in offhand for additional powers"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      AbyssBladeRightClickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      AbyssalBladePlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      AbyssalBladeLivingEntityIsHitWithItemProcedure.execute(sourceentity);
      return retval;
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      AbyssalBladeEntitySwingsItemProcedure.execute(entity, itemstack);
      return retval;
   }

   public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
      super.onCraftedBy(itemstack, world, entity);
      AbyssalBladeItemIsCraftedsmeltedProcedure.execute(itemstack);
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         AbyssalBladeItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      RequiredForAnimProcedure.execute();
   }
}
