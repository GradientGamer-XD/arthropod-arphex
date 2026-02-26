package net.arphex.item;

import java.util.List;
import net.arphex.procedures.AscendantStaffItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.VortexDevastatorEntitySwingsItemProcedure;
import net.arphex.procedures.VortexDevastatorRightclickedProcedure;
import net.arphex.procedures.VortexDevastatorToolInHandTickProcedure;
import net.arphex.procedures.VortexDevastatorToolInInventoryTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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

public class VortexDevastatorItem extends SwordItem {
   public VortexDevastatorItem() {
      super(new Tier() {
         public int getUses() {
            return 0;
         }

         public float getSpeed() {
            return 4.0F;
         }

         public float getAttackDamageBonus() {
            return 0.0F;
         }

         public int getLevel() {
            return 1;
         }

         public int getEnchantmentValue() {
            return 2;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, 3, -3.0F, new Properties().fireResistant());
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      VortexDevastatorRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§4Provides devastating telekinetic abilities for both offense and defense"));
      list.add(Component.literal("- §dLeft click to shoot a vortex blast projectile, dealing devastating damage to any enemies near its collision position"));
      list.add(Component.literal("- §9Right click to power jump in the direction you are moving, with fall immunity during cooldown"));
      list.add(
         Component.literal(
            "Bonus: Crouch while holding to use the vortex shield - this shield has unlimited usage but recharges for a few seconds each time it blocks an attack"
         )
      );
   }

   public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
      super.onCraftedBy(itemstack, world, entity);
      AscendantStaffItemIsCraftedsmeltedProcedure.execute(itemstack);
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      VortexDevastatorEntitySwingsItemProcedure.execute(entity, itemstack);
      return retval;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         VortexDevastatorToolInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }

      VortexDevastatorToolInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }
}
