package net.arphex.item;

import java.util.List;
import net.arphex.procedures.AbyssalBladeHasItemGlowingEffectProcedure;
import net.arphex.procedures.AbyssalPickaxeItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.AbyssalPickaxeLivingEntityIsHitWithToolProcedure;
import net.arphex.procedures.AbyssalPickaxeRightclickedProcedure;
import net.arphex.procedures.AbyssalPickaxeToolInHandTickProcedure;
import net.arphex.procedures.BlockBrokenProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AbyssalPickaxeItem extends PickaxeItem {
   public AbyssalPickaxeItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 36.0F;
         }

         public float getAttackDamageBonus() {
            return 8.0F;
         }

         public int getLevel() {
            return 4;
         }

         public int getEnchantmentValue() {
            return 1;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, 1, -3.0F, new Properties().fireResistant());
   }

   public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
      boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
      BlockBrokenProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity, itemstack);
      return retval;
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      AbyssalPickaxeLivingEntityIsHitWithToolProcedure.execute(entity);
      return retval;
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      AbyssalPickaxeRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§5A powerful tool capable of rapidly mining out 2x1 passageways for fast travel underground "));
      list.add(Component.literal("- §eRight click to activate double-break ability for 10 seconds"));
      list.add(Component.literal("- Alternates betwen fortune and silk touch (when crouching), except when using the double break ability"));
      list.add(Component.literal("- §dGlows when you are being targeted"));
      list.add(Component.literal("Bonus: Night vision if you have a bane of the darkness and use double-break ability"));
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
