package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Map.Entry;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderEggOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Entity null_avoider = null;
      if (!ArphexModVariables.MapVariables.get(world).matlarave_spawncap_exceeded_toggle && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
         null_avoider = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
            }
         }).compareDistOf(x, y, z)).findFirst().orElse(null);
         if (null_avoider != null && !null_avoider.getPersistentData().getBoolean("creativespectator")) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH_LARVAE.get())
                  .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }

            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.SILKEN_SOIL.get()
               || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.SILKEN_STONE.get()
               || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.STONE) {
               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!world.getEntitiesOfClass(SpiderMatriarchLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                        Entity patt2922$temp = world.getEntitiesOfClass(
                              SpiderMatriarchLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt2922$temp instanceof SpiderMatriarchLarvaeEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderMatriarchLarvaeEntity.DATA_grow, 6500);
                        }
                     }
                  }
               );
               if (!world.isClientSide()) {
                  BlockPos _bp = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bs = ((Block)ArphexModBlocks.CRAWLING_CLAY.get()).defaultBlockState();
                  BlockState _bso = world.getBlockState(_bp);
                  UnmodifiableIterator var11 = _bso.getValues().entrySet().iterator();

                  while (var11.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var11.next();
                     Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                        } catch (Exception var15) {
                        }
                     }
                  }

                  world.setBlock(_bp, _bs, 3);
               }
            }
         }
      }

      if (!world.isClientSide() && Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
      }
   }
}
