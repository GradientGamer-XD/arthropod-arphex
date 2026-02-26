package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GiantHornetHarbingerSpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("flyboost", 1.0);
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER.get())
               .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.1, 0.0, 0.0);
            }
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof ServerLevel _levelx) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER.get())
               .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(-0.1, 0.1, 0.1);
            }
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof ServerLevel _levelxx) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.HORNET_HARBINGER.get())
               .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(-0.1, -0.1, 0.1);
            }
         }

         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == Level.OVERWORLD
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()
            && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
            ArphexMod.queueServerWork(1, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }
      }
   }
}
