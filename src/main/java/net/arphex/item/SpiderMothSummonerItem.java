package net.arphex.item;

import java.util.List;
import net.arphex.procedures.SpiderMothPortalRightclickedProcedure;
import net.arphex.procedures.SpiderMothSummonInventoryProcedure;
import net.arphex.procedures.SpiderMothSummonerEntitySwingsItemProcedure;
import net.arphex.procedures.SpiderMothSummonerItemInHandTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpiderMothSummonerItem extends Item {
   public SpiderMothSummonerItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§4Spider Moth Container, an overwhelmingly powerful and nightmarish ally"));
      list.add(
         Component.literal("- §cRight click the ground to summon, or right click again to recall (one summon at a time per player - name follows item name)")
      );
      list.add(Component.literal("- Summon is rideable"));
      list.add(Component.literal("- §dLeft click while riding to wither nearby entities"));
      list.add(Component.literal("Bonus: Regenerates health while stored in item"));
      list.add(Component.literal("§7Drops from Monstrous Spider Moth [DUNGEON BOSS]"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      SpiderMothPortalRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      SpiderMothSummonerEntitySwingsItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      return retval;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         SpiderMothSummonerItemInHandTickProcedure.execute(entity, itemstack);
      }

      SpiderMothSummonInventoryProcedure.execute(entity, itemstack);
   }
}
