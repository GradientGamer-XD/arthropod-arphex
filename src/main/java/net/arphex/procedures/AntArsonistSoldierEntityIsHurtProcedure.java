package net.arphex.procedures;

import net.arphex.entity.AntArsonistSoldierEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class AntArsonistSoldierEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((!(entity instanceof AntArsonistSoldierEntity _datEntL0) || !(Boolean)_datEntL0.getEntityData().get(AntArsonistSoldierEntity.DATA_larvae))
            && entity instanceof LivingEntity _livEnt1
            && _livEnt1.hasEffect(MobEffects.DAMAGE_RESISTANCE)
            && Mth.nextInt(RandomSource.create(), 1, 15) == 5
            && world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST_DRONE.get())
               .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
            }
         }
      }
   }
}
