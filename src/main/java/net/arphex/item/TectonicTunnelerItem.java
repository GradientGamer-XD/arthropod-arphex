package net.arphex.item;

import java.util.List;
import net.arphex.procedures.BlockBroken2Procedure;
import net.arphex.procedures.TectonicTunnelerToolInHandTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TectonicTunnelerItem extends PickaxeItem {
   public TectonicTunnelerItem() {
      super(new Tier() {
         public int getUses() {
            return 300;
         }

         public float getSpeed() {
            return 15.0F;
         }

         public float getAttackDamageBonus() {
            return 3.0F;
         }

         public int getLevel() {
            return 3;
         }

         public int getEnchantmentValue() {
            return 0;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, 1, -3.0F, new Properties());
   }

   public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
      boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
      BlockBroken2Procedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), entity);
      return retval;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal("A powerful pickaxe capable of mining out 2x1 passageways for fast travel underground (Used in crafting the Abyssal Pickaxe) ")
      );
      list.add(Component.literal("- Crouch to mine one block at a time"));
      list.add(Component.literal("§7Drops from Termite Tunneler Queen [DUNGEON MINIBOSS]"));
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         TectonicTunnelerToolInHandTickProcedure.execute(entity);
      }
   }
}
