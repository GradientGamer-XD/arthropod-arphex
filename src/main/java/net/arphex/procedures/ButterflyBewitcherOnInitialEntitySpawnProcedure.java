package net.arphex.procedures;

import net.arphex.entity.ButterflyBewitcherEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class ButterflyBewitcherOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 3) != 1) {
            if (Mth.nextInt(RandomSource.create(), 1, 8) == 2) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 7) == 2) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly2");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly3");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly4");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly5");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly9");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly8");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (entity instanceof ButterflyBewitcherEntity animatable) {
                  animatable.setTexture("butterfly6");
               }
            } else if (entity instanceof ButterflyBewitcherEntity animatable) {
               animatable.setTexture("butterfly7");
            }
         }

         if (Mth.nextInt(RandomSource.create(), 1, 15) == 1
            && world.isEmptyBlock(BlockPos.containing(x, y, z))
            && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
            && world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
            && world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
            && world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))
            && world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
            && world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.BUTTERFLY_BEWITCHER_GIANT.get())
               .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
            }
         }
      }
   }
}
