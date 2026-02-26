package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.ButterflyBewitcherGiantEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BewitcherGiantSpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 3) != 1) {
            if (Mth.nextInt(RandomSource.create(), 1, 8) == 2) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 7) == 2) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly2");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly3");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly4");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly5");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly9");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly8");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
                  animatable.setTexture("butterfly6");
               }
            } else if (entity instanceof ButterflyBewitcherGiantEntity animatable) {
               animatable.setTexture("butterfly7");
            }
         }

         if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
            ArphexMod.queueServerWork(1, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }
      }
   }
}
