package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult.Type;

public class TemporalTransmitterItemInHandTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean northsouth = false;
         double lookoffsetx = 0.0;
         double sx = 0.0;
         double crouchbigger = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double lookoffsetz = 0.0;
         double blocklookx = 0.0;
         double blocklooky = 0.0;
         double blocklookz = 0.0;
         if (!(entity.getPersistentData().getDouble("temporal_display_place") > 0.0)) {
            if (entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(6.0)), Block.OUTLINE, Fluid.NONE, entity
                     )
                  )
                  .getType()
               == Type.BLOCK) {
               blocklookx = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity
                     )
                  )
                  .getBlockPos()
                  .getX();
               blocklooky = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity
                     )
                  )
                  .getBlockPos()
                  .getY();
               blocklookz = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity
                     )
                  )
                  .getBlockPos()
                  .getZ();
               if (itemstack.getOrCreateTag().getDouble("flatmodetemp") == 1.0) {
                  if (entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH) {
                     northsouth = false;
                     if (entity.getDirection() == Direction.EAST) {
                        if (entity.isShiftKeyDown()) {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        } else {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        }
                     } else if (entity.isShiftKeyDown()) {
                        lookoffsetx = 0.0;
                        lookoffsetz = -15.0;
                     } else {
                        lookoffsetx = 0.0;
                        lookoffsetz = -8.0;
                     }
                  } else {
                     northsouth = true;
                     if (entity.getDirection() == Direction.NORTH) {
                        if (entity.isShiftKeyDown()) {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        } else {
                           lookoffsetx = 0.0;
                           lookoffsetz = 0.0;
                        }
                     } else if (entity.isShiftKeyDown()) {
                        lookoffsetx = -15.0;
                        lookoffsetz = 0.0;
                     } else {
                        lookoffsetx = -8.0;
                        lookoffsetz = 0.0;
                     }
                  }

                  if (entity.isShiftKeyDown()) {
                     crouchbigger = 4.0;
                  } else {
                     crouchbigger = 3.0;
                  }

                  sx = lookoffsetx;
                  sz = lookoffsetz;

                  for (int index0 = 0; index0 < (int)Math.pow(crouchbigger, 2.0); index0++) {
                     if (entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getDirection()
                        == Direction.UP) {
                        sy = 1.0;
                     } else {
                        sy = 0.0;
                     }

                     for (int index1 = 0; index1 < (int)crouchbigger; index1++) {
                        if (world.getBlockState(BlockPos.containing(blocklookx + sx, blocklooky + sy, blocklookz + sz)).getBlock() == Blocks.AIR) {
                           world.addParticle(
                              (SimpleParticleType)ArphexModParticleTypes.SMALL_TIME.get(),
                              blocklookx + 0.5 + sx,
                              blocklooky + 0.5 + sy,
                              blocklookz + 0.5 + sz,
                              0.0,
                              0.0,
                              0.0
                           );
                        }

                        sy++;
                     }

                     if (northsouth) {
                        sx++;
                     } else {
                        sz++;
                     }
                  }
               } else {
                  if (entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH) {
                     if (entity.getDirection() == Direction.EAST) {
                        if (entity.isShiftKeyDown()) {
                           lookoffsetx = 2.0;
                           lookoffsetz = 1.0;
                        } else {
                           lookoffsetx = 1.0;
                           lookoffsetz = 0.0;
                        }
                     } else if (entity.isShiftKeyDown()) {
                        lookoffsetx = -1.0;
                        lookoffsetz = 0.0;
                     } else {
                        lookoffsetx = -1.0;
                        lookoffsetz = 0.0;
                     }
                  } else if (entity.getDirection() == Direction.NORTH) {
                     if (entity.isShiftKeyDown()) {
                        lookoffsetx = 1.0;
                        lookoffsetz = -1.0;
                     } else {
                        lookoffsetx = 0.0;
                        lookoffsetz = -1.0;
                     }
                  } else if (entity.isShiftKeyDown()) {
                     lookoffsetx = 0.0;
                     lookoffsetz = 2.0;
                  } else {
                     lookoffsetx = 0.0;
                     lookoffsetz = 1.0;
                  }

                  if (entity.isShiftKeyDown()) {
                     crouchbigger = 4.0;
                  } else {
                     crouchbigger = 3.0;
                  }

                  sx = -1.0 + lookoffsetx;
                  if (entity.isShiftKeyDown()) {
                     sx--;
                  }

                  for (int index2 = 0; index2 < (int)crouchbigger; index2++) {
                     if (entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getDirection()
                        == Direction.UP) {
                        sy = 1.0;
                     } else {
                        sy = 0.0;
                     }

                     for (int index3 = 0; index3 < (int)crouchbigger; index3++) {
                        sz = -1.0 + lookoffsetz;
                        if (entity.isShiftKeyDown()) {
                           sz--;
                        }

                        for (int index4 = 0; index4 < (int)crouchbigger; index4++) {
                           if (world.getBlockState(BlockPos.containing(blocklookx + sx, blocklooky + sy, blocklookz + sz)).getBlock() == Blocks.AIR) {
                              world.addParticle(
                                 (SimpleParticleType)ArphexModParticleTypes.SMALL_TIME.get(),
                                 blocklookx + 0.5 + sx,
                                 blocklooky + 0.5 + sy,
                                 blocklookz + 0.5 + sz,
                                 0.0,
                                 0.0,
                                 0.0
                              );
                           }

                           sz++;
                        }

                        sy++;
                     }

                     sx++;
                  }
               }
            }

            entity.getPersistentData().putDouble("temporal_display_place", 15.0);
         } else {
            entity.getPersistentData().putDouble("temporal_display_place", entity.getPersistentData().getDouble("temporal_display_place") - 1.0);
         }
      }
   }
}
