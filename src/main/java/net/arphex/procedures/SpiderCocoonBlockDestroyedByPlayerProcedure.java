package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SpiderCocoonBlockDestroyedByPlayerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Entity checkmat = null;
      ArphexMod.queueServerWork(
         1,
         () -> {
            if (!ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("cocoon")
               && !ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("egg")) {
               if (world instanceof ServerLevel _level) {
                  _level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
                  && world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH_LARVAE.get())
                     .spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                  }
               }

               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!world.getEntitiesOfClass(SpiderMatriarchLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                        Entity patt2244$temp = world.getEntitiesOfClass(
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
                        if (patt2244$temp instanceof SpiderMatriarchLarvaeEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderMatriarchLarvaeEntity.DATA_grow, 7000);
                        }
                     }
                  }
               );
            }
         }
      );
   }
}
