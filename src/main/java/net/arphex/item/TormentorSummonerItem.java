package net.arphex.item;

import java.util.List;
import net.arphex.procedures.TormentorPortalRightClixProcedure;
import net.arphex.procedures.TormentorSummonerEntitySwingsItemProcedure;
import net.arphex.procedures.TormentorSummonerInventoryProcedure;
import net.arphex.procedures.TormentorSummonerItemInHandTickProcedure;
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

public class TormentorSummonerItem extends Item {
   public TormentorSummonerItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§cTormentor Container, an ultimate nightmarish ally"));
      list.add(Component.literal("- §4Right click the ground to summon, or again to recall (one summon at a time per player - nametag follows item name)"));
      list.add(
         Component.literal("§7§lSummon becomes larger and stronger the more Tormentor kills you have, plus unlocks bonus abilities at higher kill levels")
      );
      list.add(Component.literal("- Summon is rideable at level 10+ and can fly through walls"));
      list.add(Component.literal("- §6At level 20+ you can fire a monstrous solar sphere attack by left clicking the item while riding"));
      list.add(Component.literal("Bonus: Regenerates health while stored in item"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      TormentorPortalRightClixProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      TormentorSummonerEntitySwingsItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      return retval;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         TormentorSummonerItemInHandTickProcedure.execute(entity, itemstack);
      }

      TormentorSummonerInventoryProcedure.execute(entity, itemstack);
   }
}
