package net.arphex.procedures;

import net.arphex.entity.ScorpionStrikerEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class SunScorpionOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && entity instanceof ScorpionStrikerEntity animatable) {
            animatable.setTexture("sunscorpion2");
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_LARVAE.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPION_LARVAE.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         entity.getPersistentData().putDouble("climbradius", 1.0);
      }
   }
}
