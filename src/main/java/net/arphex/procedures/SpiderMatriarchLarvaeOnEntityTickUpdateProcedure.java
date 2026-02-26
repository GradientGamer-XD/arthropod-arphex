package net.arphex.procedures;

import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderMatriarchLarvaeOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if ((entity instanceof SpiderMatriarchLarvaeEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0)
               <= 12000
            && (entity instanceof SpiderMatriarchLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0)
               <= 8000) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 0, false, false));
            }

            if ((
                     entity instanceof SpiderMatriarchLarvaeEntity _datEntIxx
                        ? (Integer)_datEntIxx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_variant)
                        : 0
                  )
                  == 1
               && entity instanceof SpiderMatriarchLarvaeEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderMatriarchLarvaeEntity.DATA_grow,
                     (
                           entity instanceof SpiderMatriarchLarvaeEntity _datEntIxxx
                              ? (Integer)_datEntIxxx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow)
                              : 0
                        )
                        + 2
                  );
            }
         }

         if ((entity instanceof SpiderMatriarchLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0)
            > 12000) {
            if ((entity instanceof SpiderMatriarchLarvaeEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_variant) : 0)
               == 2) {
               if (entity instanceof SpiderMatriarchLarvaeEntity animatable) {
                  animatable.setTexture("wolfspider3");
               }
            } else if (entity instanceof SpiderMatriarchLarvaeEntity animatable) {
               animatable.setTexture("wolfspider");
            }
         } else if ((
               entity instanceof SpiderMatriarchLarvaeEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_grow) : 0
            )
            > 6000) {
            if ((
                  entity instanceof SpiderMatriarchLarvaeEntity _datEntIxxx
                     ? (Integer)_datEntIxxx.getEntityData().get(SpiderMatriarchLarvaeEntity.DATA_variant)
                     : 0
               )
               == 2) {
               if (entity instanceof SpiderMatriarchLarvaeEntity animatable) {
                  animatable.setTexture("wolfspider2");
               }
            } else if (entity instanceof SpiderMatriarchLarvaeEntity animatable) {
               animatable.setTexture("wolfspider");
            }
         } else if (entity instanceof SpiderMatriarchLarvaeEntity animatable) {
            animatable.setTexture("wolfspiderlarvae");
         }

         if (entity.isInWall()) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.3, entity.getDeltaMovement().z()));
         }

         ArphexModVariables.MapVariables.get(world).mat_larvae_limit++;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         Vec3 motion = entity.getDeltaMovement();
         if (motion.x != 0.0 || motion.y != 0.0 || motion.z != 0.0) {
            boolean inCobweb = false;
            AABB box = entity.getBoundingBox();
            Level lvl = entity.level();
            double minX = box.minX;
            double minY = box.minY;
            double minZ = box.minZ;
            double maxX = box.maxX;
            double maxY = box.maxY;
            double maxZ = box.maxZ;

            for (int bx = (int)Math.floor(minX); bx <= (int)Math.floor(maxX); bx++) {
               for (int by = (int)Math.floor(minY); by <= (int)Math.floor(maxY); by++) {
                  for (int bz = (int)Math.floor(minZ); bz <= (int)Math.floor(maxZ); bz++) {
                     BlockState state = lvl.getBlockState(new BlockPos(bx, by, bz));
                     if (state.getBlock() == Blocks.COBWEB
                        && (double)(bx + 1) > minX
                        && (double)bx < maxX
                        && (double)(by + 1) > minY
                        && (double)by < maxY
                        && (double)(bz + 1) > minZ
                        && (double)bz < maxZ) {
                        inCobweb = true;
                        entity.makeStuckInBlock(state, new Vec3(2.0, 3.0, 2.0));
                        break;
                     }
                  }

                  if (inCobweb) {
                     break;
                  }
               }

               if (inCobweb) {
                  break;
               }
            }
         }
      }
   }
}
