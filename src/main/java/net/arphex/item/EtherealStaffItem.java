package net.arphex.item;

import java.util.List;
import net.arphex.procedures.EtherealStaffItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.EtherealStaffRightclickedProcedure;
import net.arphex.procedures.EtherealStaffToolInHandTickProcedure;
import net.arphex.procedures.RequiredForAnimProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EtherealStaffItem extends ShieldItem {
   public EtherealStaffItem() {
      super(new Properties().durability(0).fireResistant());
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      RequiredForAnimProcedure.execute();
      return ar;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§bStaff of intangibility, providing varied ghostly abilities "));
      list.add(Component.literal("- §dHold right click and walk forward into a wall to walk straight through it and block damage (nearby mobs will glow)"));
      list.add(
         Component.literal(
            "- §eHit a block to place down a temporary portal that you can teleport back to by hitting any block again before portal expiry, or teleport weak mobs towards by hitting them with the staff"
         )
      );
      list.add(Component.literal("Bonus: Immunity to suffocation damage when held "));
   }

   public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
      super.onCraftedBy(itemstack, world, entity);
      EtherealStaffItemIsCraftedsmeltedProcedure.execute(itemstack);
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         EtherealStaffToolInHandTickProcedure.execute(entity);
      }

      EtherealStaffRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }
}
