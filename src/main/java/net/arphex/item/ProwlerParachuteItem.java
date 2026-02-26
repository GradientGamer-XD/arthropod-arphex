package net.arphex.item;

import java.util.List;
import net.arphex.procedures.ProwlerParachuteItemInHandTickProcedure;
import net.arphex.procedures.ProwlerParachuteRightclickedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class ProwlerParachuteItem extends Item {
   public ProwlerParachuteItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("A silken web parachute, providing slow falling when held. Right click for an upwards boost"));
      list.add(Component.literal("§7Dungeon-only loot"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      ProwlerParachuteRightclickedProcedure.execute(entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      ProwlerParachuteItemInHandTickProcedure.execute(entity);
   }
}
