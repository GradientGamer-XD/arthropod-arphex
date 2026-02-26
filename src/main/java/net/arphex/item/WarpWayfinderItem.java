package net.arphex.item;

import io.netty.buffer.Unpooled;
import java.util.List;
import javax.annotation.Nullable;
import net.arphex.item.inventory.WarpWayfinderInventoryCapability;
import net.arphex.procedures.WarpWayfinderItemInHandTickProcedure;
import net.arphex.procedures.WarpWayfinderRightclickedOnBlockProcedure;
import net.arphex.world.inventory.WayfinderMenu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

public class WarpWayfinderItem extends Item {
   public WarpWayfinderItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
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

   public InteractionResultHolder<ItemStack> use(Level world, final Player entity, final InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      if (entity instanceof ServerPlayer serverPlayer) {
         NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
            public Component getDisplayName() {
               return Component.literal("Warp Wayfinder");
            }

            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
               FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
               packetBuffer.writeBlockPos(entity.blockPosition());
               packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
               return new WayfinderMenu(id, inventory, packetBuffer);
            }
         }, buf -> {
            buf.writeBlockPos(entity.blockPosition());
            buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
         });
      }

      return ar;
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      WarpWayfinderRightclickedOnBlockProcedure.execute(
         context.getLevel(),
         (double)context.getClickedPos().getX(),
         (double)context.getClickedPos().getY(),
         (double)context.getClickedPos().getZ(),
         context.getPlayer(),
         context.getItemInHand()
      );
      return InteractionResult.SUCCESS;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         WarpWayfinderItemInHandTickProcedure.execute(entity, itemstack);
      }
   }

   public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag compound) {
      return new WarpWayfinderInventoryCapability();
   }

   public CompoundTag getShareTag(ItemStack stack) {
      CompoundTag nbt = stack.getOrCreateTag();
      stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> nbt.put("Inventory", ((ItemStackHandler)capability).serializeNBT()));
      return nbt;
   }

   public void readShareTag(ItemStack stack, @Nullable CompoundTag nbt) {
      super.readShareTag(stack, nbt);
      if (nbt != null) {
         stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
            .ifPresent(capability -> ((ItemStackHandler)capability).deserializeNBT((CompoundTag)nbt.get("Inventory")));
      }
   }
}
