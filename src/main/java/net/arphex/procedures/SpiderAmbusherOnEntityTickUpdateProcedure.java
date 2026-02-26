package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.entity.LongLegsFlyEntity;
import net.arphex.entity.SpiderAmbusherEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderAmbusherOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double ambusherfall = 0.0;
         boolean targetfound = false;
         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 4.0, z))
            && !entity.onGround()) {
            if (entity instanceof SpiderAmbusherEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderAmbusherEntity.DATA_time_in_air,
                     (entity instanceof SpiderAmbusherEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderAmbusherEntity.DATA_time_in_air) : 0) + 1
                  );
            }
         } else if (entity instanceof SpiderAmbusherEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderAmbusherEntity.DATA_time_in_air, 0);
         }

         if ((entity instanceof SpiderAmbusherEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderAmbusherEntity.DATA_time_in_air) : 0) > 10) {
            if (!(
                  (double)world.getBlockState(BlockPos.containing(entity.getX() + 1.5, entity.getY(), entity.getZ()))
                        .getDestroySpeed(world, BlockPos.containing(entity.getX() + 1.5, entity.getY(), entity.getZ()))
                     > 0.3
               )
               && !(
                  (double)world.getBlockState(BlockPos.containing(entity.getX() + 1.5, entity.getY() + 1.0, entity.getZ()))
                        .getDestroySpeed(world, BlockPos.containing(entity.getX() + 1.5, entity.getY() + 1.0, entity.getZ()))
                     > 0.3
               )) {
               if (!(
                     (double)world.getBlockState(BlockPos.containing(entity.getX() - 1.5, entity.getY(), entity.getZ()))
                           .getDestroySpeed(world, BlockPos.containing(entity.getX() - 1.5, entity.getY(), entity.getZ()))
                        > 0.3
                  )
                  && !(
                     (double)world.getBlockState(BlockPos.containing(entity.getX() - 1.5, entity.getY() + 1.0, entity.getZ()))
                           .getDestroySpeed(world, BlockPos.containing(entity.getX() - 1.5, entity.getY() + 1.0, entity.getZ()))
                        > 0.3
                  )) {
                  if (!(
                        (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1.5))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1.5))
                           > 0.3
                     )
                     && !(
                        (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() + 1.5))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() + 1.5))
                           > 0.3
                     )) {
                     if (!(
                           (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1.5))
                                 .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1.5))
                              > 0.3
                        )
                        && !(
                           (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() - 1.5))
                                 .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() - 1.5))
                              > 0.3
                        )) {
                        if (entity instanceof SpiderAmbusherEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderAmbusherEntity.DATA_time_in_air, 0);
                        }
                     } else if (!world.isClientSide()) {
                        entity.lookAt(Anchor.EYES, new Vec3(entity.getX(), -100.0, entity.getZ() + 1.0));
                     }
                  } else if (!world.isClientSide()) {
                     entity.lookAt(Anchor.EYES, new Vec3(entity.getX(), -100.0, entity.getZ() - 1.0));
                  }
               } else if (!world.isClientSide()) {
                  entity.lookAt(Anchor.EYES, new Vec3(entity.getX() + 1.0, -100.0, entity.getZ()));
               }
            } else if (!world.isClientSide()) {
               entity.lookAt(Anchor.EYES, new Vec3(entity.getX() - 1.0, -100.0, entity.getZ()));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 120, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, false, false));
            }

            targetfound = false;
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               if (!world.getEntitiesOfClass(LongLegsFlyEntity.class, AABB.ofSize(new Vec3(x, y - 5.0, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
                  && entity instanceof Mob _entity) {
                  Entity var44 = world.getEntitiesOfClass(LongLegsFlyEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (var44 instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               }

               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            } else {
               Vec3 _center = new Vec3(entity.getX(), entity.getY() - 4.0, entity.getZ());

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == entityiterator) {
                     targetfound = true;
                  }
               }

               _center = new Vec3(entity.getX(), entity.getY() - 9.0, entity.getZ());

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == entityiteratorx) {
                     targetfound = true;
                  }
               }

               _center = new Vec3(entity.getX(), entity.getY() - 14.0, entity.getZ());

               for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == entityiteratorxx) {
                     targetfound = true;
                  }
               }

               _center = new Vec3(entity.getX(), entity.getY() - 19.0, entity.getZ());

               for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == entityiteratorxxx) {
                     targetfound = true;
                  }
               }

               if (targetfound) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                     )
                  );
                  if (entity instanceof SpiderAmbusherEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SpiderAmbusherEntity.DATA_time_in_air, 0);
                  }

                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -1.0,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               } else {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }
            }

            entity.setShiftKeyDown(true);
         } else {
            entity.setShiftKeyDown(false);
         }

         if (entity instanceof LivingEntity _livEnt104
            && _livEnt104.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y - 5.8, z, 5, 0.2, 0.3, 0.2, 0.04);
         }

         if (!entity.getPersistentData().getBoolean("despawned_rider")) {
            entity.getPersistentData().putBoolean("despawned_rider", true);

            for (Entity entityiteratorxxxx : new ArrayList(entity.getPassengers())) {
               if (entityiteratorxxxx instanceof Skeleton && !entityiteratorxxxx.level().isClientSide()) {
                  entityiteratorxxxx.discard();
               }
            }
         }
      }
   }
}
