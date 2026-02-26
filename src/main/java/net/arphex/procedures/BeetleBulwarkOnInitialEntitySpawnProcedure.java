package net.arphex.procedures;

import net.arphex.entity.BeetleBulwarkEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BeetleBulwarkOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
            entity.getPersistentData().putDouble("randomfly", (double)Mth.nextInt(RandomSource.create(), 100, 600));
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            if (entity instanceof BeetleBulwarkEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(BeetleBulwarkEntity.DATA_randsize, 0);
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            if (entity instanceof BeetleBulwarkEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(BeetleBulwarkEntity.DATA_randsize, 1);
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 3) != 1) {
            if (entity instanceof BeetleBulwarkEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(BeetleBulwarkEntity.DATA_randsize, 2);
            }
         } else if (entity instanceof BeetleBulwarkEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(BeetleBulwarkEntity.DATA_randsize, 3);
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            entity.getPersistentData().putString("beetlever", "scarabb");
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            entity.getPersistentData().putString("beetlever", "lady");
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            entity.getPersistentData().putString("beetlever", "rhino");
         } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
            entity.getPersistentData().putString("beetlever", "stag");
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            entity.getPersistentData().putString("beetlever", "scarabg");
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            entity.getPersistentData().putString("beetlever", "scarabt");
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
            entity.getPersistentData().putString("beetlever", "scarabi");
         } else if (Mth.nextInt(RandomSource.create(), 1, 3) != 1) {
            entity.getPersistentData().putString("beetlever", "scarabp");
         } else {
            entity.getPersistentData().putString("beetlever", "scarabgold");
         }
      }
   }
}
