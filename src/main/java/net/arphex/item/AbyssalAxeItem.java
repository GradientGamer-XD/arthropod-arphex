package net.arphex.item;

import java.util.List;
import net.arphex.procedures.AbyssalAxeHeldProcedure;
import net.arphex.procedures.AbyssalAxeRightClickProcedure;
import net.arphex.procedures.AbyssalAxeToolInInventoryTickProcedure;
import net.arphex.procedures.AbyssalBladeHasItemGlowingEffectProcedure;
import net.arphex.procedures.AbyssalPickaxeItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.BlockBroken3Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AbyssalAxeItem extends AxeItem {
   public AbyssalAxeItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 36.0F;
         }

         public float getAttackDamageBonus() {
            return 17.0F;
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
      }, 1.0F, -3.7F, new Properties().fireResistant());
   }

   public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
      boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
      BlockBroken3Procedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity, itemstack);
      return retval;
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      AbyssalAxeRightClickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      return retval;
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      AbyssalAxeRightClickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§5A powerful tool for destroying enemies and blocks"));
      list.add(Component.literal("- Right click to activate double-break ability for 10 seconds"));
      list.add(
         Component.literal(
            "- §ePowerful critical hit abilities: Slow, wither, and knock down enemies, along with lifestealing and resetting fall damage - Fall height increases critical hit damage and adds larger AoE withering radius to nearby entities"
         )
      );
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
         AbyssalAxeHeldProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }

      AbyssalAxeToolInInventoryTickProcedure.execute(entity);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      Entity entity = Minecraft.getInstance().player;
      return AbyssalBladeHasItemGlowingEffectProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
   }
}
