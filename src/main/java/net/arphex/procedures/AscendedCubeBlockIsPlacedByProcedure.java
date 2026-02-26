package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AscendedCubeBlockIsPlacedByProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String substring = "";
         if (x == 0.0 && y == 0.0 && z == 0.0) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("ASCENDED CUBE DOES NOT WORK AT X0, Y0, Z0 COORDINATES"), true);
            }
         } else {
            if (!world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putString("ascendedowner", entity.getStringUUID());
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            if (!world.isClientSide()) {
               BlockPos _bpx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
               BlockState _bsx = world.getBlockState(_bpx);
               if (_blockEntityx != null) {
                  _blockEntityx.getPersistentData().putString("stored_colour", "14");
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
               }
            }

            if (entity instanceof ServerPlayer _player) {
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:ascended"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for (String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }

            if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("Ascended Cube marked as owned by you"), true);
            }

            if (ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.contains("[" + x + "," + y + "," + z)) {
               if (ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.contains("[" + x + "," + y + "," + z)) {
                  substring = ArphexModVariables.MapVariables.get(world)
                     .ascend_cube_coord_list
                     .substring(0, ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.indexOf("[" + x + "," + y + "," + z));
                  if (substring.contains("]")) {
                     substring = substring.substring(0, ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.indexOf("]"));
                  }

                  if (!substring.contains(
                     ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                           + "")
                        .replace("ResourceKey[minecraft:dimension / ", "")
                        .replace("]", "")
                        .strip()
                  )) {
                     ArphexModVariables.MapVariables var10000 = ArphexModVariables.MapVariables.get(world);
                     ResourceKey var10005 = world instanceof Level _lvlx
                        ? _lvlx.dimension()
                        : (world instanceof WorldGenLevel _wglx ? _wglx.getLevel().dimension() : Level.OVERWORLD);
                     var10000.ascend_cube_coord_list = ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list
                        + "["
                        + x
                        + ","
                        + y
                        + ","
                        + z
                        + "-14\\"
                        + (var10005 + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip()
                        + "]";
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                  }
               }
            } else {
               ArphexModVariables.MapVariables var31 = ArphexModVariables.MapVariables.get(world);
               ResourceKey var32 = world instanceof Level _lvl
                  ? _lvl.dimension()
                  : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD);
               var31.ascend_cube_coord_list = ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list
                  + "["
                  + x
                  + ","
                  + y
                  + ","
                  + z
                  + "-14\\"
                  + (var32 + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip()
                  + "]";
               ArphexModVariables.MapVariables.get(world).syncData(world);
            }
         }
      }
   }
}
