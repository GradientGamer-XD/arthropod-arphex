package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderSinkerEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderSinkerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance_to_target = 0.0;
         boolean ai_allow = false;
         Entity nearest_targetable = null;
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            if (entity instanceof SpiderSinkerEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SpiderSinkerEntity.DATA_float_time, 200);
            }

            if (!world.isClientSide()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                     (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                     (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                  )
               );
            }

            if (entity.isUnderWater() && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() > entity.getY()) {
               entity.setDeltaMovement(new Vec3(entity.getLookAngle().x / 2.0, 0.2, entity.getLookAngle().z / 2.0));
            }

            if ((
                  !(entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).isAlive()
                     || (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).isRemoved()
               )
               && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var16) {
                  var16.printStackTrace();
               }
            }
         }

         if (entity.isUnderWater()) {
            if ((entity instanceof SpiderSinkerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderSinkerEntity.DATA_float_time) : 0) <= 0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.2, 0.0));
            }

            if (entity instanceof SpiderSinkerEntity) {
               ((SpiderSinkerEntity)entity).setAnimation("animation.spider_wolf.swimming");
            }
         } else {
            if (entity instanceof SpiderSinkerEntity) {
               ((SpiderSinkerEntity)entity).setAnimation("empty");
            }

            if (entity.onGround() && entity instanceof SpiderSinkerEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SpiderSinkerEntity.DATA_float_time, 50);
            }

            if (entity.isShiftKeyDown()) {
               if ((entity instanceof SpiderSinkerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderSinkerEntity.DATA_limnav) : 0) > 40
                  && entity instanceof SpiderSinkerEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderSinkerEntity.DATA_limnav, 40);
               }

               distance_to_target = 15.0;
            } else {
               distance_to_target = 250.0;
            }

            if ((entity instanceof SpiderSinkerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderSinkerEntity.DATA_limnav) : 0) % 20 == 0
               && entity.getDisplayName().getString().equals("Spider Sinker")
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if ((entity instanceof SpiderSinkerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderSinkerEntity.DATA_limnav) : 0) <= 0) {
               if (entity instanceof SpiderSinkerEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderSinkerEntity.DATA_limnav, 300);
               }

               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
                  nearest_targetable = world.getEntitiesOfClass(
                        WaterAnimal.class, AABB.ofSize(new Vec3(x, y, z), distance_to_target, distance_to_target, distance_to_target), e -> true
                     )
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (nearest_targetable != null) {
                     if (entity instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(nearest_targetable.getX(), nearest_targetable.getY(), nearest_targetable.getZ(), 1.4);
                     }

                     if (!(nearest_targetable instanceof Squid) && entity instanceof Mob _entity && nearest_targetable instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                     }

                     if (entity.isShiftKeyDown()) {
                        entity.setShiftKeyDown(false);
                        if (entity instanceof SpiderSinkerEntity) {
                           ((SpiderSinkerEntity)entity).setAnimation("animation.spider_wolf.swimattack");
                        }
                     }
                  }
               }
            } else if (entity instanceof SpiderSinkerEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderSinkerEntity.DATA_limnav,
                     (entity instanceof SpiderSinkerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderSinkerEntity.DATA_limnav) : 0) - 1
                  );
            }
         }

         if ((entity instanceof SpiderSinkerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderSinkerEntity.DATA_float_time) : 0) > 0) {
            if (entity instanceof SpiderSinkerEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderSinkerEntity.DATA_float_time,
                     (entity instanceof SpiderSinkerEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderSinkerEntity.DATA_float_time) : 0) - 1
                  );
            }
         } else if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).getBlock() != Blocks.WATER
            && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).getBlock() != Blocks.WATER) {
            entity.setShiftKeyDown(false);
         } else {
            if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getBlock() != Blocks.WATER
               && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).getBlock() != Blocks.WATER) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }

            if (entity.isUnderWater()) {
               entity.setShiftKeyDown(false);
            } else {
               entity.setShiftKeyDown(true);
            }
         }
      }
   }
}
