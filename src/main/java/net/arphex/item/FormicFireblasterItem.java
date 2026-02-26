package net.arphex.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import net.arphex.procedures.FireblasterRightClickProcedure;
import net.arphex.procedures.FormicFireblasterItemInInventoryTickProcedure;
import net.arphex.procedures.FormicFireblasterOnPlayerStoppedUsingProcedure;
import net.arphex.procedures.FormicFireblasterRightclickProcedure;
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

public class FormicFireblasterItem extends Item {
   public FormicFireblasterItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BOW;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 9999;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 4.0, Operation.ADDITION));
         builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, Operation.ADDITION));
         return builder.build();
      } else {
         return super.getDefaultAttributeModifiers(equipmentSlot);
      }
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§cFlamethrower harnessing the power of fire ants, ideal for clearing out large quantities of enemies"));
      list.add(Component.literal("- Hold right click to use (may burn blocks and drops)"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      FormicFireblasterRightclickProcedure.execute(entity);
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         FireblasterRightClickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }

      FormicFireblasterItemInInventoryTickProcedure.execute(entity, itemstack);
   }

   public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
      FormicFireblasterOnPlayerStoppedUsingProcedure.execute(entity);
      return true;
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      FormicFireblasterOnPlayerStoppedUsingProcedure.execute(entity);
   }
}
