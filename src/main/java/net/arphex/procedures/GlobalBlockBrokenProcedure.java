package net.arphex.procedures;

import java.text.DecimalFormat;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class GlobalBlockBrokenProcedure {
   @SubscribeEvent
   public static void onBlockBreak(BreakEvent event) {
      execute(
         event,
         event.getLevel(),
         (double)event.getPos().getX(),
         (double)event.getPos().getY(),
         (double)event.getPos().getZ(),
         event.getState(),
         event.getPlayer()
      );
   }

   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
      execute(null, world, x, y, z, blockstate, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
      if (entity != null) {
         double cycle = 0.0;
         double milestone_value = 0.0;
         ItemStack drop_trophy = ItemStack.EMPTY;
         ItemStack custom_itemstack = ItemStack.EMPTY;
         if (!world.isClientSide()
            && blockstate.getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && y > 255.0
            && !entity.getPersistentData().getBoolean("creativespectator")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Cannot break these blocks in Crawling Containers"), true);
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (blockstate.getBlock() == ArphexModBlocks.ASCENDED_CUBE.get()) {
            cycle = 0.0;

            for (int index0 = 0; index0 < 16; index0++) {
               ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list = ArphexModVariables.MapVariables.get(world)
                  .ascend_cube_coord_list
                  .replace(
                     "["
                        + x
                        + ","
                        + y
                        + ","
                        + z
                        + "-"
                        + new DecimalFormat("##.##").format(cycle)
                        + "\\"
                        + ((
                                 world instanceof Level _lvl
                                    ? _lvl.dimension()
                                    : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)
                              )
                              + "")
                           .replace("ResourceKey[minecraft:dimension / ", "")
                           .replace("]", "")
                           .strip()
                        + "]",
                     ""
                  );
               ArphexModVariables.MapVariables.get(world).syncData(world);
               cycle++;
            }

            ArphexModVariables.MapVariables var29 = ArphexModVariables.MapVariables.get(world);
            ResourceKey var30 = world instanceof Level _lvl
               ? _lvl.dimension()
               : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD);
            var29.ascend_cube_coord_list = ArphexModVariables.MapVariables.get(world)
               .ascend_cube_coord_list
               .replace(
                  "[" + x + "," + y + "," + z + "-@\\" + (var30 + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip() + "]", ""
               );
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (!world.isClientSide() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.MOB_TROPHY.get()) {
            drop_trophy = new ItemStack((ItemLike)ArphexModItems.TROPHY_ITEM.get());
            drop_trophy.setHoverName(Component.literal((new Object() {
               public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
               }
            }).getValue(world, BlockPos.containing(x, y, z), "saved_name").replace("]", "").replace("[", "")));
            drop_trophy.getOrCreateTag().putString("trophy_entity", (new Object() {
               public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
               }
            }).getValue(world, BlockPos.containing(x, y, z), "trophy_entity"));
            drop_trophy.getOrCreateTag().putDouble("trophy_entity_size", (new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "trophy_entity_size"));
            drop_trophy.getOrCreateTag().putDouble("milestone_number", (new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "milestone_number"));
            if ((new Object() {
               public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
               }
            }).getValue(world, BlockPos.containing(x, y, z), "trophy_entity").length() < 1) {
               drop_trophy.getOrCreateTag().putString("trophy_entity", "failed");
            }

            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop_trophy);
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }
      }
   }
}
