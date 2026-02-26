package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.FlyFestererEntity;
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

public class FlyFestererOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("flyboost", 1.0);
         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && entity instanceof FlyFestererEntity animatable) {
            animatable.setTexture("flyfesterer2");
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
