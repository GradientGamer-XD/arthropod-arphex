package net.arphex.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import net.arphex.procedures.ChaosGauntletHeldProcedure;
import net.arphex.procedures.ForceGauntletEntitySwingsItemProcedure;
import net.arphex.procedures.ForceGauntletItemInInventoryTickProcedure;
import net.arphex.procedures.ForceGauntletItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.ForceGauntletItemIsDroppedByPlayerProcedure;
import net.arphex.procedures.ForceGauntletRightclickedProcedure;
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

public class ChaosGauntletItem extends Item {
   public ChaosGauntletItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.SPEAR;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 300;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 3.0, Operation.ADDITION));
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
      list.add(Component.literal("§5Gauntlet with the power to control chaos and temporarily turn entities on each other"));
      list.add(
         Component.literal(
            "- §dRight click towards an entity to control or remove control (purple particles) - Stronger mobs are less controllable, forcing an early cooldown and shorter control time - or unlimited time in creative mode (usable for mob battles)"
         )
      );
      list.add(
         Component.literal(
            "- §cLeft click towards an entity to set or remove it as a target (red particles). Control and targeting only work for entities that can have potion effects "
         )
      );
      list.add(Component.literal("- §eHit the ground while crouching to clear nearby controls/targets"));
      list.add(Component.literal("Bonus: Hit ground to create a shockwave that knocks nearby mobs away"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      entity.startUsingItem(hand);
      ForceGauntletRightclickedProcedure.execute(entity);
      return ar;
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      ForceGauntletItemIsDroppedByPlayerProcedure.execute(entity);
      return retval;
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      ForceGauntletEntitySwingsItemProcedure.execute(entity.level(), entity);
      return retval;
   }

   public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
      super.onCraftedBy(itemstack, world, entity);
      ForceGauntletItemIsCraftedsmeltedProcedure.execute(itemstack);
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         ChaosGauntletHeldProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }

      ForceGauntletItemInInventoryTickProcedure.execute(world, entity, itemstack);
   }

   public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
      ForceGauntletItemIsDroppedByPlayerProcedure.execute(entity);
      return true;
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      ForceGauntletItemIsDroppedByPlayerProcedure.execute(entity);
   }
}
