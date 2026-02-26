package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderCocoonPlayerNeighbourBlockChangesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
      }

      if (!ArphexModVariables.MapVariables.get(world).matlarave_spawncap_exceeded_toggle) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH_LARVAE.get())
               .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }

         ArphexMod.queueServerWork(
            1,
            () -> {
               if (!world.getEntitiesOfClass(SpiderMatriarchLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                  Entity patt1732$temp = world.getEntitiesOfClass(
                        SpiderMatriarchLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (patt1732$temp instanceof SpiderMatriarchLarvaeEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SpiderMatriarchLarvaeEntity.DATA_grow, 6000);
                  }
               }
            }
         );
      }
   }
}
