package net.arphex.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import net.arphex.procedures.AbyssalBladeHasItemGlowingEffectProcedure;
import net.arphex.procedures.AbyssalPickaxeItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.AbyssalPickaxeLivingEntityIsHitWithToolProcedure;
import net.arphex.procedures.AbyssalPickaxeRightclickedProcedure;
import net.arphex.procedures.AbyssalPickaxeToolInHandTickProcedure;
import net.arphex.procedures.BlockBroken4Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class AbyssAtomiserItem extends TieredItem {
   public AbyssAtomiserItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 45.0F;
         }

         public float getAttackDamageBonus() {
            return 14.0F;
         }

         public int getLevel() {
            return 5;
         }

         public int getEnchantmentValue() {
            return 1;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, new Properties().fireResistant());
   }

   public boolean isCorrectToolForDrops(BlockState blockstate) {
      int tier = 5;
      if (tier < 3 && blockstate.is(BlockTags.NEEDS_DIAMOND_TOOL)) {
         return false;
      } else if (tier < 2 && blockstate.is(BlockTags.NEEDS_IRON_TOOL)) {
         return false;
      } else {
         return tier < 1 && blockstate.is(BlockTags.NEEDS_STONE_TOOL)
            ? false
            : blockstate.is(BlockTags.MINEABLE_WITH_AXE)
               || blockstate.is(BlockTags.MINEABLE_WITH_HOE)
               || blockstate.is(BlockTags.MINEABLE_WITH_PICKAXE)
               || blockstate.is(BlockTags.MINEABLE_WITH_SHOVEL);
      }
   }

   public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
      return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction)
         || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction)
         || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction)
         || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction)
         || ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
   }

   public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
      return 45.0F;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 15.0, Operation.ADDITION));
         builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.8, Operation.ADDITION));
         return builder.build();
      } else {
         return super.getDefaultAttributeModifiers(equipmentSlot);
      }
   }

   public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
      itemstack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
      BlockBroken4Procedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity, itemstack);
      return true;
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      itemstack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
      AbyssalPickaxeLivingEntityIsHitWithToolProcedure.execute(entity);
      return true;
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      AbyssalPickaxeRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§cThe Abyss Atomiser is an ultimate multitool (pickaxe/axe/shovel/sword/hoe) "));
      list.add(Component.literal("- §6Right click to enable 2x3 multi-break mining ability for ten seconds (or 6x1 if sneaking) "));
      list.add(Component.literal("- §eAlternates betwen fortune and silk touch (when crouching), except when using the multi-break ability"));
      list.add(Component.literal("- §dGlows when you are being targeted"));
      list.add(Component.literal("Bonus: Night vision if you have a bane of the darkness when using multi-break ability"));
      list.add(Component.literal("§9+2 block reach when held"));
      list.add(Component.literal("§7Power scales with Tormentor kills: 50+ gives haste or 100+ gives haste 2"));
   }

   public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
      super.onCraftedBy(itemstack, world, entity);
      AbyssalPickaxeItemIsCraftedsmeltedProcedure.execute(itemstack);
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         AbyssalPickaxeToolInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      Entity entity = Minecraft.getInstance().player;
      return AbyssalBladeHasItemGlowingEffectProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
   }
}
