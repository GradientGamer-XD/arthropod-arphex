package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ScorpioidShadowCloneTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()) {
            entity.lookAt(
               Anchor.EYES,
               new Vec3(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               )
            );
            if (!world.getEntitiesOfClass(
                     Player.class,
                     AABB.ofSize(
                        new Vec3(x, y, z),
                        ArphexModVariables.MapVariables.get(world).clonesize + 100.0,
                        ArphexModVariables.MapVariables.get(world).clonesize + 100.0,
                        ArphexModVariables.MapVariables.get(world).clonesize + 100.0
                     ),
                     e -> true
                  )
                  .isEmpty()
               && Mth.nextInt(RandomSource.create(), 1, 60) == 10
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 3) {
                  if (world instanceof ServerLevel _level) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               } else if (world instanceof ServerLevel _levelxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                     .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (world instanceof ServerLevel _levelxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_CHASER_HALLUCINATION.get())
                  .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
            && entity.getPersistentData().getBoolean("spawnedaway")
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.setDeltaMovement(
            new Vec3(
               Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0,
               entity.getDeltaMovement().y(),
               Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0
            )
         );
         if (Mth.nextInt(RandomSource.create(), 1, 500) == 10 && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
