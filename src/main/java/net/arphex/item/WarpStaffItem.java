package net.arphex.item;

import java.util.List;
import net.arphex.procedures.WarpStaffRightclickedProcedure;
import net.arphex.procedures.WarpStaffToolInHandTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WarpStaffItem extends SwordItem {
   public WarpStaffItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 4.0F;
         }

         public float getAttackDamageBonus() {
            return 4.0F;
         }

         public int getLevel() {
            return 1;
         }

         public int getEnchantmentValue() {
            return 0;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, 3, -3.0F, new Properties().fireResistant());
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      WarpStaffRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
      return ar;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§4Staff enabling teleportation in whatever direction the holder is moving (including vertically) "));
      list.add(Component.literal("- §bTeleportation is triggered by crouching, enabling easy combination with other items"));
      list.add(
         Component.literal(
            "- §9Right click to create a magical platform at any position, or if you teleport to a midair position, one will be created automatically"
         )
      );
      list.add(Component.literal("Bonus: Total fall immunity when held"));
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      WarpStaffToolInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }
}
