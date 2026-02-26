package net.arphex.procedures;

import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class SpiderMothSummonEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (Mth.nextInt(RandomSource.create(), 1, 40) == 5 && world instanceof ServerLevel _level) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH_SUMMON_LARVAE.get())
            .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
         }
      }
   }
}
