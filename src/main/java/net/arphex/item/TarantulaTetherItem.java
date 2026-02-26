package net.arphex.item;

import java.util.List;
import net.arphex.entity.WebRopeEntity;
import net.arphex.procedures.SlingWebPlayerFinishesUsingItemProcedure;
import net.arphex.procedures.SlingWebRightclickedProcedure;
import net.arphex.procedures.TarantulaTetherHoldingTickProcedure;
import net.arphex.procedures.TarantulaTetherItemInInventoryTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TarantulaTetherItem extends Item {
   public TarantulaTetherItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BOW;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 30;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§5Powerful web-based grappling hook"));
      list.add(
         Component.literal(
            "- Aim and hold the right mouse button to fire a grappling hook, pulling you towards any solid surface or pulling entities towards you"
         )
      );
      list.add(
         Component.literal(
            "- §eTo rappel, hit the block below you, then walk off an edge, retaining the ability to pull yourself back up by holding spacebar (double jump locks position)"
         )
      );
      list.add(Component.literal("Bonus: Climb walls like a spider by walking into them and holding spacebar"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = InteractionResultHolder.fail(entity.getItemInHand(hand));
      if (entity.getAbilities().instabuild || this.findAmmo(entity) != ItemStack.EMPTY) {
         ar = InteractionResultHolder.success(entity.getItemInHand(hand));
         entity.startUsingItem(hand);
      }

      SlingWebRightclickedProcedure.execute(entity);
      return ar;
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      SlingWebPlayerFinishesUsingItemProcedure.execute(entity);
      return retval;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         TarantulaTetherHoldingTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
      }

      TarantulaTetherItemInInventoryTickProcedure.execute(entity);
   }

   public void onUseTick(Level world, LivingEntity entity, ItemStack itemstack, int count) {
      if (!world.isClientSide() && entity instanceof ServerPlayer player) {
         ItemStack stack = this.findAmmo(player);
         if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
            WebRopeEntity projectile = WebRopeEntity.shoot(world, entity, world.getRandom());
            if (player.getAbilities().instabuild) {
               projectile.pickup = Pickup.CREATIVE_ONLY;
            } else if (stack.isDamageableItem()) {
               if (stack.hurt(1, world.getRandom(), player)) {
                  stack.shrink(1);
                  stack.setDamageValue(0);
                  if (stack.isEmpty()) {
                     player.getInventory().removeItem(stack);
                  }
               }
            } else {
               stack.shrink(1);
               if (stack.isEmpty()) {
                  player.getInventory().removeItem(stack);
               }
            }
         }

         entity.releaseUsingItem();
      }
   }

   private ItemStack findAmmo(Player player) {
      ItemStack stack = ProjectileWeaponItem.getHeldProjectile(player, e -> e.getItem() == WebRopeEntity.PROJECTILE_ITEM.getItem());
      if (stack == ItemStack.EMPTY) {
         for (int i = 0; i < player.getInventory().items.size(); i++) {
            ItemStack teststack = (ItemStack)player.getInventory().items.get(i);
            if (teststack != null && teststack.getItem() == WebRopeEntity.PROJECTILE_ITEM.getItem()) {
               stack = teststack;
               break;
            }
         }
      }

      return stack;
   }
}
