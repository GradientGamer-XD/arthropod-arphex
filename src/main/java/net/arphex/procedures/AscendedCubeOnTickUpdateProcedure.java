package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.AscendSphereAnimEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AscendedCubeOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      String saved_letter = "";
      double checkdouble = 0.0;
      double number_transfer = 0.0;
      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x + 0.5, y + 0.5, z + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
      }

      checkdouble = 0.0;
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator instanceof AscendSphereAnimEntity) {
            if (entityiterator instanceof AscendSphereAnimEntity _datEntSetS) {
               _datEntSetS.getEntityData().set(AscendSphereAnimEntity.DATA_color, (new Object() {
                  public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                  }
               }).getValue(world, BlockPos.containing(x, y, z), "forcefield_colour"));
            }

            checkdouble++;
            if ((new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "expel_enemies") > 0.0) {
               if (entityiterator instanceof AscendSphereAnimEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(AscendSphereAnimEntity.DATA_barriermode, (int)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                     }
                  }).getValue(world, BlockPos.containing(x, y, z), "expel_enemies"));
               }

               if (!world.isClientSide()) {
                  BlockPos _bp = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntity = world.getBlockEntity(_bp);
                  BlockState _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("expel_enemies", 0.0);
                  }

                  if (world instanceof Level _level) {
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }
            }
         }
      }

      if (!(checkdouble > 0.0)) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.ASCEND_SPHERE_ANIM.get())
               .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }
      } else if (checkdouble > 1.0) {
         _center = new Vec3(x, y, z);

         for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiteratorx instanceof AscendSphereAnimEntity && !entityiteratorx.level().isClientSide()) {
               entityiteratorx.discard();
            }
         }

         if (world instanceof ServerLevel _levelx) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.ASCEND_SPHERE_ANIM.get())
               .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }
      }
   }
}
