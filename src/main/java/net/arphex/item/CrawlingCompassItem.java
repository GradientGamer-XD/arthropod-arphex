package net.arphex.item;

import java.util.List;
import net.arphex.procedures.CompassTestItemInInventoryTickProcedure;
import net.arphex.procedures.CompassTestRightclickedProcedure;
import net.arphex.procedures.CrawlingCompassItemInHandTickProcedure;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CrawlingCompassItem extends Item {
   public CrawlingCompassItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("A compass to seek out the furthest reaches of darkness and navigate between layers of the Crawling "));
      list.add(Component.literal("§7§iRight click to scan (if it cannot find a nearby structure within 10 seconds, it breaks off the search)"));
      list.add(Component.literal("- If you scan in the overworld, it locates the Crawling castle/portal (often underground)"));
      list.add(Component.literal("- If you scan in the Crawling dimension, it locates a dungeon to access the next layer down "));
      list.add(Component.literal("- If you scan in the Crawling dimension while crouching, it finds a dungeon to go back up a layer "));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      CompassTestRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         CrawlingCompassItemInHandTickProcedure.execute(world, entity);
      }

      CompassTestItemInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
   }
}
