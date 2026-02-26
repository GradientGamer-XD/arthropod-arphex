package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.HornetHarbingerEntity;
import net.arphex.entity.MosquitoMorbidityEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class HornetHarbingerOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("flyboost", 1.0);
         if (!(entity instanceof MosquitoMorbidityEntity)
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               == Level.OVERWORLD
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()
            && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
            ArphexMod.queueServerWork(1, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity instanceof HornetHarbingerEntity && ArphexModVariables.MapVariables.get(world).gem_mob_challenge) {
            ArphexMod.queueServerWork(2, () -> {
               if (Mth.nextInt(RandomSource.create(), 1, 800) == 4 && entity instanceof HornetHarbingerEntity animatable) {
                  animatable.setTexture("emerald_mob");
               }
            });
         }
      }
   }
}
