package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Map.Entry;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderObstructerEntity;
import net.arphex.init.ArphexModBlocks;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderObstructerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         boolean foundplayer = false;
         double scan_dirt_x = 0.0;
         double scan_dirt_y = 0.0;
         double scan_dirt_z = 0.0;
         double sqrt = 0.0;
         if (world.getBlockState(BlockPos.containing(x, y + 0.55, z)).getBlock() == ArphexModBlocks.TRAPDOOR_GRASS.get()) {
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               entity.setNoGravity(true);
            } else {
               entity.setNoGravity(false);
            }

            entity.setShiftKeyDown(true);
         } else {
            entity.setNoGravity(false);
            entity.setShiftKeyDown(false);
         }

         if (!(entity.getPersistentData().getDouble("slownav_arphex") > 0.0)) {
            entity.getPersistentData().putDouble("slownav_arphex", 50.0);
         } else {
            entity.getPersistentData().putDouble("slownav_arphex", entity.getPersistentData().getDouble("slownav_arphex") - 1.0);
         }

         if ((entity instanceof SpiderObstructerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderObstructerEntity.DATA_cooldown) : 0) > 0
            && entity instanceof SpiderObstructerEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SpiderObstructerEntity.DATA_cooldown,
                  (entity instanceof SpiderObstructerEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderObstructerEntity.DATA_cooldown) : 0) - 1
               );
         }

         if ((entity instanceof SpiderObstructerEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x) : 0) == 0
            && (entity instanceof SpiderObstructerEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y) : 0) == 0
            && (entity instanceof SpiderObstructerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z) : 0) == 0) {
            entity.getPersistentData().putDouble("build_count_arphex", 0.0);
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
               && world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 1.0, Math.floor(entity.getZ()))).getBlock()
                  == Blocks.GRASS_BLOCK
               && world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 2.0, Math.floor(entity.getZ()))).getBlock() == Blocks.DIRT
               && world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 3.0, Math.floor(entity.getZ()))).getBlock() == Blocks.DIRT
               && !world.isEmptyBlock(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 3.0, Math.floor(entity.getZ())))
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 3.0, Math.floor(entity.getZ())))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 3.0, Math.floor(entity.getZ())))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 3.0, Math.floor(entity.getZ())))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 3.0, Math.floor(entity.getZ())))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 3.0, Math.floor(entity.getZ()) + 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 3.0, Math.floor(entity.getZ()) + 1.0))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 3.0, Math.floor(entity.getZ()) - 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 3.0, Math.floor(entity.getZ()) - 1.0))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 1.0, Math.floor(entity.getZ())))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 1.0, Math.floor(entity.getZ())))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 1.0, Math.floor(entity.getZ())))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 1.0, Math.floor(entity.getZ())))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 1.0, Math.floor(entity.getZ()) + 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 1.0, Math.floor(entity.getZ()) + 1.0))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 1.0, Math.floor(entity.getZ()) - 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 1.0, Math.floor(entity.getZ()) - 1.0))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) + 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) + 1.0))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) - 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) - 1.0))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) - 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) + 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) - 1.0))
                     < 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) + 1.0))
                        .getDestroySpeed(world, BlockPos.containing(Math.floor(entity.getX()) - 1.0, entity.getY() - 1.0, Math.floor(entity.getZ()) + 1.0))
                     < 0.3
               )) {
               if (!world.isClientSide()) {
                  BlockPos _bp = BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 1.0, Math.floor(entity.getZ()));
                  BlockState _bs = ((Block)ArphexModBlocks.TRAPDOOR_GRASS.get()).defaultBlockState();
                  BlockState _bso = world.getBlockState(_bp);
                  UnmodifiableIterator var133 = _bso.getValues().entrySet().iterator();

                  while (var133.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var133.next();
                     Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                        } catch (Exception var43) {
                        }
                     }
                  }

                  world.setBlock(_bp, _bs, 3);
                  _bp = BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 2.0, Math.floor(entity.getZ()));
                  _bs = ((Block)ArphexModBlocks.TRAPDOOR_DIRT.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var133 = _bso.getValues().entrySet().iterator();

                  while (var133.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var133.next();
                     Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                        } catch (Exception var42) {
                        }
                     }
                  }

                  world.setBlock(_bp, _bs, 3);
                  _bp = BlockPos.containing(Math.floor(entity.getX()), entity.getY() - 3.0, Math.floor(entity.getZ()));
                  _bs = ((Block)ArphexModBlocks.TRAPDOOR_DIRT.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var133 = _bso.getValues().entrySet().iterator();

                  while (var133.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var133.next();
                     Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                        } catch (Exception var41) {
                        }
                     }
                  }

                  world.setBlock(_bp, _bs, 3);
               }

               if (entity instanceof SpiderObstructerEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderObstructerEntity.DATA_trapdoor_x, (int)Math.floor(entity.getX()));
               }

               if (entity instanceof SpiderObstructerEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderObstructerEntity.DATA_trapdoor_y, (int)(entity.getY() - 1.0));
               }

               if (entity instanceof SpiderObstructerEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderObstructerEntity.DATA_trapdoor_z, (int)Math.floor(entity.getZ()));
               }
            }
         } else {
            if (world.getBlockState(
                        BlockPos.containing(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                              : 0.0,
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)).intValue()
                              : 0.0,
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                              ? (double)((Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                              : 0.0
                        )
                     )
                     .getBlock()
                  != ArphexModBlocks.TRAPDOOR_GRASS.get()
               || world.getBlockState(
                        BlockPos.containing(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxx
                              ? (double)((Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                              : 0.0,
                           (double)(
                              (
                                    entity instanceof SpiderObstructerEntity _datEntIxxxx
                                       ? (Integer)_datEntIxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                                 - 1
                           ),
                           entity instanceof SpiderObstructerEntity _datEntIxxx
                              ? (double)((Integer)_datEntIxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                              : 0.0
                        )
                     )
                     .getBlock()
                  != ArphexModBlocks.TRAPDOOR_DIRT.get()) {
               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (world.getBlockState(
                                 BlockPos.containing(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxx
                                       ? (double)((Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                                       : 0.0,
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxx
                                       ? (double)((Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)).intValue()
                                       : 0.0,
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxx
                                       ? (double)((Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                                       : 0.0
                                 )
                              )
                              .getBlock()
                           != ArphexModBlocks.TRAPDOOR_GRASS.get()
                        || world.getBlockState(
                                 BlockPos.containing(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxx
                                       ? (double)((Integer)_datEntIxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                                       : 0.0,
                                    (double)(
                                       (
                                             entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxx
                                                ? (Integer)_datEntIxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                                : 0
                                          )
                                          - 1
                                    ),
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxx
                                       ? (double)((Integer)_datEntIxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                                       : 0.0
                                 )
                              )
                              .getBlock()
                           != ArphexModBlocks.TRAPDOOR_DIRT.get()) {
                        if (entity instanceof SpiderObstructerEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderObstructerEntity.DATA_trapdoor_x, 0);
                        }

                        if (entity instanceof SpiderObstructerEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderObstructerEntity.DATA_trapdoor_y, 0);
                        }

                        if (entity instanceof SpiderObstructerEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderObstructerEntity.DATA_trapdoor_z, 0);
                        }
                     }
                  }
               );
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               foundplayer = false;
               if (!world.getEntitiesOfClass(
                     Player.class,
                     AABB.ofSize(
                        new Vec3(x, y, z),
                        entity.getPersistentData().getDouble("trigger_range_arphex"),
                        entity.getPersistentData().getDouble("trigger_range_arphex"),
                        entity.getPersistentData().getDouble("trigger_range_arphex")
                     ),
                     e -> true
                  )
                  .isEmpty()) {
                  if (!world.getEntitiesOfClass(
                        Player.class,
                        AABB.ofSize(
                           new Vec3(x, y, z),
                           entity.getPersistentData().getDouble("trigger_range_arphex"),
                           entity.getPersistentData().getDouble("trigger_range_arphex"),
                           entity.getPersistentData().getDouble("trigger_range_arphex")
                        ),
                        e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getPersistentData()
                     .getBoolean("creativespectator")) {
                     foundplayer = true;
                     entity.getPersistentData().putDouble("target_time_limit", 200.0);
                     if (entity instanceof Mob _entity) {
                        Entity var106 = world.getEntitiesOfClass(
                              Player.class,
                              AABB.ofSize(
                                 new Vec3(x, y, z),
                                 entity.getPersistentData().getDouble("trigger_range_arphex"),
                                 entity.getPersistentData().getDouble("trigger_range_arphex"),
                                 entity.getPersistentData().getDouble("trigger_range_arphex")
                              ),
                              e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (var106 instanceof LivingEntity _ent) {
                           _entity.setTarget(_ent);
                        }
                     }
                  } else {
                     if (4.0
                        > Math.sqrt(
                           (
                                    entity.getX()
                                       - (double)(
                                          entity instanceof SpiderObstructerEntity _datEntIxxxxxxxx
                                             ? (Integer)_datEntIxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                             : 0
                                       )
                                 )
                                 * (
                                    entity.getX()
                                       - (double)(
                                          entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                                             ? (Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                             : 0
                                       )
                                 )
                              + (
                                    entity.getY()
                                       - (double)(
                                          entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                                             ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                             : 0
                                       )
                                 )
                                 * (
                                    entity.getY()
                                       - (double)(
                                          entity instanceof SpiderObstructerEntity _datEntIxxxxx
                                             ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                             : 0
                                       )
                                 )
                              + (
                                    entity.getZ()
                                       - (double)(
                                          entity instanceof SpiderObstructerEntity _datEntIxxxx
                                             ? (Integer)_datEntIxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                             : 0
                                       )
                                 )
                                 * (
                                    entity.getZ()
                                       - (double)(
                                          entity instanceof SpiderObstructerEntity _datEntIxxx
                                             ? (Integer)_datEntIxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                             : 0
                                       )
                                 )
                        )) {
                        entity.teleportTo(
                           (double)(
                                 entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                    : 0
                              )
                              + 0.41,
                           (double)(
                                 entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                    : 0
                              )
                              - 0.05,
                           (double)(
                                 entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                    : 0
                              )
                              + 0.5
                        );
                        if (entity instanceof ServerPlayer _serverPlayer) {
                           _serverPlayer.connection
                              .teleport(
                                 (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                          : 0
                                    )
                                    + 0.41,
                                 (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                          : 0
                                    )
                                    - 0.05,
                                 (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                          : 0
                                    )
                                    + 0.5,
                                 entity.getYRot(),
                                 entity.getXRot()
                              );
                        }

                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     } else if (entity.getPersistentData().getDouble("slownav_arphex") == 5.0 && entity instanceof Mob _entityx) {
                        _entityx.getNavigation()
                           .moveTo(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxx
                                 ? (double)((Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                                 : 0.0,
                              (double)(
                                 (
                                       entity instanceof SpiderObstructerEntity _datEntIxxxx
                                          ? (Integer)_datEntIxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                          : 0
                                    )
                                    - 1
                              ),
                              entity instanceof SpiderObstructerEntity _datEntIxxx
                                 ? (double)((Integer)_datEntIxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                                 : 0.0,
                              1.0
                           );
                     }

                     if (!world.isClientSide()) {
                        entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
                        if (!(entity.getPersistentData().getDouble("build_count_arphex") > 65.0)) {
                           scan_dirt_x = (double)Mth.nextInt(RandomSource.create(), -2, 2);
                           scan_dirt_y = (double)Mth.nextInt(RandomSource.create(), -3, 0);
                           scan_dirt_z = (double)Mth.nextInt(RandomSource.create(), -2, 2);
                           if (world.getBlockState(BlockPos.containing(x + scan_dirt_x, y + scan_dirt_y, z + scan_dirt_z)).getBlock() == Blocks.DIRT
                              && !world.isEmptyBlock(BlockPos.containing(x + scan_dirt_x, y + scan_dirt_y + 1.0, z + scan_dirt_z))) {
                              entity.getPersistentData().putDouble("build_count_arphex", entity.getPersistentData().getDouble("build_count_arphex") + 1.0);
                              BlockPos _bp = BlockPos.containing(x + scan_dirt_x, y + scan_dirt_y, z + scan_dirt_z);
                              BlockState _bs = ((Block)ArphexModBlocks.TRAPDOOR_DIRT.get()).defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var126 = _bso.getValues().entrySet().iterator();

                              while (var126.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var126.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var40) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                           }
                        }
                     }
                  }
               }

               if (!foundplayer) {
                  if (!world.getEntitiesOfClass(
                        Chicken.class,
                        AABB.ofSize(
                           new Vec3(x, y, z),
                           entity.getPersistentData().getDouble("trigger_range_arphex"),
                           entity.getPersistentData().getDouble("trigger_range_arphex"),
                           entity.getPersistentData().getDouble("trigger_range_arphex")
                        ),
                        e -> true
                     )
                     .isEmpty()) {
                     entity.getPersistentData().putDouble("target_time_limit", 200.0);
                     if (entity instanceof Mob _entityx) {
                        Entity var107 = world.getEntitiesOfClass(
                              Chicken.class,
                              AABB.ofSize(
                                 new Vec3(x, y, z),
                                 entity.getPersistentData().getDouble("trigger_range_arphex"),
                                 entity.getPersistentData().getDouble("trigger_range_arphex"),
                                 entity.getPersistentData().getDouble("trigger_range_arphex")
                              ),
                              e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (var107 instanceof LivingEntity _ent) {
                           _entityx.setTarget(_ent);
                        }
                     }
                  } else if (4.0
                     > Math.sqrt(
                        (
                                 entity.getX()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                          : 0
                                    )
                              )
                              * (
                                 entity.getX()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                                          ? (Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                          : 0
                                    )
                              )
                           + (
                                 entity.getY()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                                          ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                          : 0
                                    )
                              )
                              * (
                                 entity.getY()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxx
                                          ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                          : 0
                                    )
                              )
                           + (
                                 entity.getZ()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxx
                                          ? (Integer)_datEntIxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                          : 0
                                    )
                              )
                              * (
                                 entity.getZ()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxx
                                          ? (Integer)_datEntIxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                          : 0
                                    )
                              )
                     )) {
                     entity.teleportTo(
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                 : 0
                           )
                           + 0.41,
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                 : 0
                           )
                           - 0.05,
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                 : 0
                           )
                           + 0.5
                     );
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                       : 0
                                 )
                                 + 0.41,
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                                 - 0.05,
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                       : 0
                                 )
                                 + 0.5,
                              entity.getYRot(),
                              entity.getXRot()
                           );
                     }

                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     if (!world.isClientSide()) {
                        entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
                        if (!(entity.getPersistentData().getDouble("build_count_arphex") > 65.0)) {
                           scan_dirt_x = (double)Mth.nextInt(RandomSource.create(), -3, 3);
                           scan_dirt_y = (double)Mth.nextInt(RandomSource.create(), -3, 0);
                           scan_dirt_z = (double)Mth.nextInt(RandomSource.create(), -3, 3);
                           if (world.getBlockState(BlockPos.containing(x + scan_dirt_x, y + scan_dirt_y, z + scan_dirt_z)).getBlock() == Blocks.DIRT
                              && !world.isEmptyBlock(BlockPos.containing(x + scan_dirt_x, y + scan_dirt_y + 1.0, z + scan_dirt_z))) {
                              entity.getPersistentData().putDouble("build_count_arphex", entity.getPersistentData().getDouble("build_count_arphex") + 1.0);
                              BlockPos _bp = BlockPos.containing(x + scan_dirt_x, y + scan_dirt_y, z + scan_dirt_z);
                              BlockState _bs = ((Block)ArphexModBlocks.TRAPDOOR_DIRT.get()).defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var207 = _bso.getValues().entrySet().iterator();

                              while (var207.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var207.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var39) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                           }
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("slownav_arphex") == 5.0 && entity instanceof Mob _entityxx) {
                     _entityxx.getNavigation()
                        .moveTo(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxx
                              ? (double)((Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                              : 0.0,
                           (double)(
                              (
                                    entity instanceof SpiderObstructerEntity _datEntIxxxx
                                       ? (Integer)_datEntIxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                                 - 1
                           ),
                           entity instanceof SpiderObstructerEntity _datEntIxxx
                              ? (double)((Integer)_datEntIxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                              : 0.0,
                           1.0
                        );
                  }
               }
            } else if (entity.isVehicle()) {
               if (entity.getY()
                  > (double)(
                     entity instanceof SpiderObstructerEntity _datEntIxxx
                        ? (Integer)_datEntIxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                        : 0
                  )) {
                  sqrt = Math.sqrt(
                     (
                              entity.getX()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                       : 0
                                 )
                           )
                           * (
                              entity.getX()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                       : 0
                                 )
                           )
                        + (
                              entity.getY()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                                       ? (Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                           )
                           * (
                              entity.getY()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                                       ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                           )
                        + (
                              entity.getZ()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxx
                                       ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                       : 0
                                 )
                           )
                           * (
                              entity.getZ()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxx
                                       ? (Integer)_datEntIxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                       : 0
                                 )
                           )
                  );
                  if (1.5 > sqrt) {
                     entity.teleportTo(
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                 : 0
                           )
                           + 0.41,
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                 : 0
                           )
                           - 0.05,
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                 : 0
                           )
                           + 0.5
                     );
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                       : 0
                                 )
                                 + 0.41,
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                                 - 0.05,
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                       : 0
                                 )
                                 + 0.5,
                              entity.getYRot(),
                              entity.getXRot()
                           );
                     }
                  } else if (4.0 > sqrt) {
                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                              : 0.0,
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)).intValue()
                              : 0.0,
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                              : 0.0
                        )
                     );
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 6.0,
                           entity.getDeltaMovement().y(),
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 6.0
                        )
                     );
                  }
               }
            } else if (entity.getY()
               < (double)(
                     entity instanceof SpiderObstructerEntity _datEntIxxxx
                        ? (Integer)_datEntIxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                        : 0
                  )
                  - 0.5) {
               if (4.0
                  > Math.sqrt(
                     (
                              entity.getX()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                       : 0
                                 )
                           )
                           * (
                              entity.getX()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                                       ? (Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                       : 0
                                 )
                           )
                        + (
                              entity.getZ()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                                       ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                       : 0
                                 )
                           )
                           * (
                              entity.getZ()
                                 - (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxx
                                       ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                       : 0
                                 )
                           )
                  )) {
                  found = false;
                  Vec3 _center;
                  Vec3 var233 = _center = new Vec3(
                     entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxx
                        ? (double)((Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                        : 0.0,
                     (double)(
                        (
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                 : 0
                           )
                           - 1
                     ),
                     entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxx
                        ? (double)((Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                        : 0.0
                  );

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
                        && entityiterator == (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                        && entityiterator.getY()
                           < (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                 : 0
                           )) {
                        entity.getPersistentData().putDouble("target_in_burrow", 10.0);
                        found = true;
                     }
                  }

                  if (!found) {
                     entity.teleportTo(
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                 : 0
                           )
                           + 0.41,
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                 : 0
                           )
                           - 0.4,
                        (double)(
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxx
                                 ? (Integer)_datEntIxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                 : 0
                           )
                           + 0.5
                     );
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                       : 0
                                 )
                                 + 0.41,
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                                 - 0.4,
                              (double)(
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxx
                                       ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                       : 0
                                 )
                                 + 0.5,
                              entity.getYRot(),
                              entity.getXRot()
                           );
                     }

                     if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.sin(Math.toRadians((double)((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getYRot() + 180.0F)))
                                 * 2.0
                                 * -1.0,
                              1.2,
                              Math.cos(Math.toRadians((double)(entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getYRot())) * 2.0 * -1.0
                           )
                        );
                        ArphexMod.queueServerWork(
                           3,
                           () -> {
                              if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null) {
                                 entity.lookAt(
                                    Anchor.EYES,
                                    new Vec3(
                                       (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                                       (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                                       (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                                    )
                                 );
                                 entity.setDeltaMovement(
                                    new Vec3(
                                       Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                                       -0.3,
                                       Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                                    )
                                 );
                              }
                           }
                        );
                     }
                  }
               }
            } else {
               found = false;
               Vec3 _center;
               Vec3 var237 = _center = new Vec3(
                  entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                     ? (double)((Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                     : 0.0,
                  (double)(
                     (
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                              : 0
                        )
                        - 1
                  ),
                  entity instanceof SpiderObstructerEntity _datEntIxxxxx
                     ? (double)((Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                     : 0.0
               );

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
                     && entityiteratorx == (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                     && entityiteratorx.getY()
                        < (double)(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                              : 0
                        )) {
                     entity.getPersistentData().putDouble("target_in_burrow", 10.0);
                     found = true;
                  }
               }

               if (found
                  && 4.0
                     > Math.sqrt(
                        (
                                 entity.getX()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                          : 0
                                    )
                              )
                              * (
                                 entity.getX()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                          : 0
                                    )
                              )
                           + (
                                 entity.getY()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                          : 0
                                    )
                              )
                              * (
                                 entity.getY()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                          : 0
                                    )
                              )
                           + (
                                 entity.getZ()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                          : 0
                                    )
                              )
                              * (
                                 entity.getZ()
                                    - (double)(
                                       entity instanceof SpiderObstructerEntity _datEntIxxxxxxxx
                                          ? (Integer)_datEntIxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                          : 0
                                    )
                              )
                     )) {
                  entity.teleportTo(
                     (double)(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                              : 0
                        )
                        + 0.41,
                     (double)(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                              : 0
                        )
                        - 0.05,
                     (double)(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                              ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                              : 0
                        )
                        + 0.5
                  );
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection
                        .teleport(
                           (double)(
                                 entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                                    : 0
                              )
                              + 0.41,
                           (double)(
                                 entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                    : 0
                              )
                              - 0.05,
                           (double)(
                                 entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxx
                                    ? (Integer)_datEntIxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                                    : 0
                              )
                              + 0.5,
                           entity.getYRot(),
                           entity.getXRot()
                        );
                  }
               }
            }
         }

         if (entity.isVehicle() && entity.getFirstPassenger() != null) {
            if ((
                     entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                        ? (Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)
                        : 0
                  )
                  == 0
               && (
                     entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                        ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                        : 0
                  )
                  == 0
               && (
                     entity instanceof SpiderObstructerEntity _datEntIxxxxx
                        ? (Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)
                        : 0
                  )
                  == 0) {
               entity.getFirstPassenger().stopRiding();
            } else if (world.getBlockState(
                        BlockPos.containing(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                              : 0.0,
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)).intValue()
                              : 0.0,
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                              : 0.0
                        )
                     )
                     .getBlock()
                  != ArphexModBlocks.TRAPDOOR_GRASS.get()
               || world.getBlockState(
                        BlockPos.containing(
                           entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                              ? (double)((Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                              : 0.0,
                           (double)(
                              (
                                    entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                                       ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                       : 0
                                 )
                                 - 1
                           ),
                           entity instanceof SpiderObstructerEntity _datEntIxxxxx
                              ? (double)((Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                              : 0.0
                        )
                     )
                     .getBlock()
                  != ArphexModBlocks.TRAPDOOR_DIRT.get()) {
               entity.getFirstPassenger().stopRiding();
            } else if (entity.getPersistentData().getDouble("slownav_arphex") == 5.0 && entity instanceof Mob _entityxx) {
               _entityxx.getNavigation()
                  .moveTo(
                     entity instanceof SpiderObstructerEntity _datEntIxxxxxxx
                        ? (double)((Integer)_datEntIxxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_x)).intValue()
                        : 0.0,
                     (double)(
                        (
                              entity instanceof SpiderObstructerEntity _datEntIxxxxxx
                                 ? (Integer)_datEntIxxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_y)
                                 : 0
                           )
                           - 1
                     ),
                     entity instanceof SpiderObstructerEntity _datEntIxxxxx
                        ? (double)((Integer)_datEntIxxxxx.getEntityData().get(SpiderObstructerEntity.DATA_trapdoor_z)).intValue()
                        : 0.0,
                     1.0
                  );
            }
         }

         if (entity.getPersistentData().getDouble("target_in_burrow") > 0.0
            || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.TRAPDOOR_DIRT.get()) {
            ArphexMod.queueServerWork(5, () -> {
               if (entity.isVehicle() && entity.getFirstPassenger() != null) {
                  entity.getFirstPassenger().stopRiding();
               }

               entity.getPersistentData().putDouble("target_in_burrow", entity.getPersistentData().getDouble("target_in_burrow") - 1.0);
            });
         }

         if (entity.getPersistentData().getDouble("target_time_limit") > 0.0) {
            entity.getPersistentData().putDouble("target_time_limit", entity.getPersistentData().getDouble("target_time_limit") - 1.0);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Chicken
               && entity instanceof LivingEntity _entityxx
               && !_entityxx.level().isClientSide()) {
               _entityxx.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 4, 0));
            }

            if ((
                  (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getPersistentData().getBoolean("creativespectator")
                     || !(entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).isAlive()
                     || !(entity.getPersistentData().getDouble("target_time_limit") > 0.0)
               )
               && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var38) {
                  var38.printStackTrace();
               }
            }
         }

         Vec3 motion = entity.getDeltaMovement();
         if (motion.x != 0.0 || motion.y != 0.0 || motion.z != 0.0) {
            boolean inCobweb = false;
            AABB box = entity.getBoundingBox();
            Level lvl = entity.level();
            double minX = box.minX;
            double minY = box.minY;
            double minZ = box.minZ;
            double maxX = box.maxX;
            double maxY = box.maxY;
            double maxZ = box.maxZ;

            for (int bx = (int)Math.floor(minX); bx <= (int)Math.floor(maxX); bx++) {
               for (int by = (int)Math.floor(minY); by <= (int)Math.floor(maxY); by++) {
                  for (int bz = (int)Math.floor(minZ); bz <= (int)Math.floor(maxZ); bz++) {
                     BlockState state = lvl.getBlockState(new BlockPos(bx, by, bz));
                     if (state.getBlock() == Blocks.COBWEB
                        && (double)(bx + 1) > minX
                        && (double)bx < maxX
                        && (double)(by + 1) > minY
                        && (double)by < maxY
                        && (double)(bz + 1) > minZ
                        && (double)bz < maxZ) {
                        inCobweb = true;
                        entity.makeStuckInBlock(state, new Vec3(2.0, 3.0, 2.0));
                        break;
                     }
                  }

                  if (inCobweb) {
                     break;
                  }
               }

               if (inCobweb) {
                  break;
               }
            }
         }
      }
   }
}
