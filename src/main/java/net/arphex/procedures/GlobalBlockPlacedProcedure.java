package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class GlobalBlockPlacedProcedure {
   @SubscribeEvent
   public static void onBlockPlace(EntityPlaceEvent event) {
      execute(
         event,
         event.getLevel(),
         (double)event.getPos().getX(),
         (double)event.getPos().getY(),
         (double)event.getPos().getZ(),
         event.getState(),
         event.getEntity()
      );
   }

   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
      execute(null, world, x, y, z, blockstate, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
      if (entity != null) {
         if (!world.isClientSide()
            && blockstate.getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && y > 255.0) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Cannot place these blocks in Crawling Containers"), true);
            }

            BlockPos _pos = BlockPos.containing(x, y, z);
            Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
            world.destroyBlock(_pos, false);
         }
      }
   }
}
