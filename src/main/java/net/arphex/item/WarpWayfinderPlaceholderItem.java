package net.arphex.item;

import java.util.List;
import net.arphex.procedures.PlaceholderWarpProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WarpWayfinderPlaceholderItem extends Item {
   public WarpWayfinderPlaceholderItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(
         Component.literal("§dWarp Wayfinder enables you to keep track of up to three positions in the world, and teleport to them when in the same dimension")
      );
      list.add(Component.literal("- §aCrouch+Right click a block to add a waypoint at that position"));
      list.add(Component.literal("- §3While held, you will see markers representing the positions of the waypoints"));
      list.add(
         Component.literal(
            "- §bRight click in the air to open a menu where you can teleport to markers (10 minute cooldown), label them with items, or delete them"
         )
      );
      list.add(Component.literal("- While standing still, you can see the item labels assigned to markers"));
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      PlaceholderWarpProcedure.execute(entity);
   }
}
