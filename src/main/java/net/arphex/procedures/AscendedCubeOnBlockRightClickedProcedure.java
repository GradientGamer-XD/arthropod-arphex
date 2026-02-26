package net.arphex.procedures;

import java.text.DecimalFormat;
import java.util.Comparator;
import net.arphex.entity.AscendSphereAnimEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AscendedCubeOnBlockRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String letter_transfer = "";
         String saved_letter = "";
         double number_transfer = 0.0;
         Entity nearest_anim = null;
         saved_letter = "none";
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BLACK_DYE) {
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }

            saved_letter = "15";
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.RED_DYE) {
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }

            saved_letter = "14";
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GREEN_DYE) {
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }

            saved_letter = "13";
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BROWN_DYE) {
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }

            saved_letter = "12";
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BLUE_DYE) {
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }

            saved_letter = "11";
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.PURPLE_DYE) {
            saved_letter = "10";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.CYAN_DYE) {
            saved_letter = "9";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.LIGHT_GRAY_DYE) {
            saved_letter = "8";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GRAY_DYE) {
            saved_letter = "7";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.YELLOW_DYE) {
            saved_letter = "4";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.LIGHT_BLUE_DYE) {
            saved_letter = "3";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.PINK_DYE) {
            saved_letter = "6";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ORANGE_DYE) {
            saved_letter = "1";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.MAGENTA_DYE) {
            saved_letter = "2";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.LIME_DYE) {
            saved_letter = "5";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
            == ArphexModItems.CHITIN.get()) {
            saved_letter = "@";
            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
            == ArphexModItems.ABYSSAL_CRYSTAL.get()) {
            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .killedtormentor
               > 0.0) {
               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  (entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
               }

               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor
                  > 100.0) {
                  if (!world.isClientSide()) {
                     BlockPos _bp = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntity = world.getBlockEntity(_bp);
                     BlockState _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("expel_enemies", 60000.0);
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }
               } else if (!world.isClientSide()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                  BlockState _bsx = world.getBlockState(_bpx);
                  if (_blockEntityx != null) {
                     _blockEntityx.getPersistentData()
                        .putDouble(
                           "expel_enemies",
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .killedtormentor
                              * 600.0
                        );
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                  }
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("You need at least 1 Tormentor kill to use this ability"), true);
            }
         }

         if (!saved_letter.equals("none")) {
            number_transfer = 0.0;

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
                        + new DecimalFormat("##").format(number_transfer)
                        + "\\"
                        + ((
                                 world instanceof Level _lvlx
                                    ? _lvlx.dimension()
                                    : (world instanceof WorldGenLevel _wglx ? _wglx.getLevel().dimension() : Level.OVERWORLD)
                              )
                              + "")
                           .replace("ResourceKey[minecraft:dimension / ", "")
                           .replace("]", "")
                           .strip()
                        + "]",
                     "["
                        + x
                        + ","
                        + y
                        + ","
                        + z
                        + "-"
                        + saved_letter
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
                        + "]"
                  );
               ArphexModVariables.MapVariables.get(world).syncData(world);
               number_transfer++;
            }

            ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list = ArphexModVariables.MapVariables.get(world)
               .ascend_cube_coord_list
               .replace(
                  "["
                     + x
                     + ","
                     + y
                     + ","
                     + z
                     + "-@\\"
                     + ((
                              world instanceof Level _lvlx
                                 ? _lvlx.dimension()
                                 : (world instanceof WorldGenLevel _wglx ? _wglx.getLevel().dimension() : Level.OVERWORLD)
                           )
                           + "")
                        .replace("ResourceKey[minecraft:dimension / ", "")
                        .replace("]", "")
                        .strip()
                     + "]",
                  "["
                     + x
                     + ","
                     + y
                     + ","
                     + z
                     + "-"
                     + saved_letter
                     + "\\"
                     + ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                           + "")
                        .replace("ResourceKey[minecraft:dimension / ", "")
                        .replace("]", "")
                        .strip()
                     + "]"
               );
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
            == ItemStack.EMPTY.getItem()) {
            nearest_anim = world.getEntitiesOfClass(AscendSphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (nearest_anim == null) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Cube currently activating..."), true);
               }
            } else if ((
                  nearest_anim instanceof AscendSphereAnimEntity _datEntI ? (Integer)_datEntI.getEntityData().get(AscendSphereAnimEntity.DATA_barriermode) : 0
               )
               > 0) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal(
                        "Cube repulsion power activated for: "
                           + Math.round(
                              (float)(
                                 (
                                       nearest_anim instanceof AscendSphereAnimEntity _datEntIx
                                          ? (Integer)_datEntIx.getEntityData().get(AscendSphereAnimEntity.DATA_barriermode)
                                          : 0
                                    )
                                    / 20
                              )
                           )
                           + "s"
                     ),
                     true
                  );
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Repulsion power not currently active"), true);
            }
         }
      }
   }
}
