package net.arphex.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import net.arphex.procedures.SpearOfParalysisRightclickedProcedure;
import net.arphex.procedures.VisionarySpearEntitySwingsItemProcedure;
import net.arphex.procedures.VisionarySpearItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.VisionarySpearOnPlayerStoppedUsingProcedure;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class VisionarySpearItem extends Item {
   public VisionarySpearItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.SPEAR;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 2000;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 29.0, Operation.ADDITION));
         builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, Operation.ADDITION));
         return builder.build();
      } else {
         return super.getDefaultAttributeModifiers(equipmentSlot);
      }
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§2A powerful extended-reach weapon capable of freezing nearby entities in time"));
      list.add(Component.literal("- §dHold right mouse button to use time freeze cube power - any entities nearby will gradually freeze in time"));
      list.add(Component.literal("- §cRelease in time to fire multiple projectiles in each direction (these do not damage tamed mobs)"));
      list.add(Component.literal("- §dProvides time-accelerated health regeneration, especially when using the special ability"));
      list.add(Component.literal("- §7Dual wielding grants an additional ranged projectile left click ability"));
      list.add(Component.literal("§9+4 attack reach when held"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      return ar;
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      VisionarySpearEntitySwingsItemProcedure.execute(entity.level(), entity, itemstack);
      return retval;
   }

   public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
      super.onCraftedBy(itemstack, world, entity);
      VisionarySpearItemIsCraftedsmeltedProcedure.execute(itemstack);
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         SpearOfParalysisRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      VisionarySpearOnPlayerStoppedUsingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
   }
}
