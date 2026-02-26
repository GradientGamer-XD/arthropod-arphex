package net.arphex.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import net.arphex.procedures.AbyssalBladeHasItemGlowingEffectProcedure;
import net.arphex.procedures.AbyssalDaggerItemInHandTickProcedure;
import net.arphex.procedures.AbyssalDaggerRightclickedProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AbyssalDaggerItem extends Item {
   public AbyssalDaggerItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 7.0, Operation.ADDITION));
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
      list.add(Component.literal("§5A dagger suited to an unstoppable assassin"));
      list.add(
         Component.literal("§eAttacking enemies gives them the anti-resistance necrosis effect at level 2 for 10 seconds, plus weakness and wither effects")
      );
      list.add(
         Component.literal(
            "- Right click for special ability where each attack gives you a faster and faster speed boost until the cooldown runs out (resets shorter each hit, strength at max level, brief invincibility after attacking mobs)"
         )
      );
      list.add(Component.literal("- §dGlows when you are being targeted"));
      list.add(Component.literal("Bonus: If attacked while holding this item, you get a brief burst of invisibility and slow your enemy"));
      list.add(Component.literal("Bonus: Try combining with another abyssal dagger in offhand for additional powers"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      AbyssalDaggerRightclickedProcedure.execute(entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         AbyssalDaggerItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }
   }
}
