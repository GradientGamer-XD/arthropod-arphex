package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.VenusFlytrapEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FlytrapOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.CRAWLING_COMPOST.get()) {
            ArphexMod.queueServerWork(
               100,
               () -> {
                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.CRAWLING_COMPOST.get()
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         }

         ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 6000, 12000), () -> entity.getPersistentData().putBoolean("spawntime", true));
         if (entity.getPersistentData().getBoolean("spawntime") && !entity.getPersistentData().getBoolean("spawndone")) {
            entity.getPersistentData().putBoolean("spawndone", true);
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.VENUS_FLYTRAP.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            ArphexMod.queueServerWork(
               3,
               () -> {
                  if (!world.getEntitiesOfClass(VenusFlytrapEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                     world.getEntitiesOfClass(VenusFlytrapEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .setCustomName(Component.literal("Tamed Flytrap"));
                  }
               }
            );
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         entity.setDeltaMovement(new Vec3(0.0, -0.3, 0.0));
      }
   }
}
