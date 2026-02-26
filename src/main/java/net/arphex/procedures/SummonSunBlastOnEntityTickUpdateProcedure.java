package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SummonSunBlastEntity;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SummonSunBlastOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ArphexMod.queueServerWork(280, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         entity.setNoGravity(true);
         if (!(entity.getPersistentData().getDouble("summonsuntimer") > 0.0)) {
            Vec3 _center = new Vec3(x, y, z);

            SummonSunBlastEntity _datEntI;
            for (Entity entityiterator : world.getEntitiesOfClass(
                  Entity.class,
                  new AABB(_center, _center)
                     .inflate(
                        (double)Math.round(
                              (double)(
                                    entity instanceof SummonSunBlastEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SummonSunBlastEntity.DATA_size) : 0
                                 )
                                 / 2.2
                           )
                           / 2.0
                     ),
                  e -> true
               )
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity
                  && !(entityiterator instanceof SummonSunBlastEntity)
                  && !(entityiterator instanceof TormentorSummonEntity)) {
                  if (entityiterator.isPassenger()) {
                     if (!(entityiterator.getVehicle() instanceof TormentorSummonEntity)) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                           40.0F
                        );
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0, false, false));
                           }
                        }
                     }
                  } else {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), 40.0F
                     );
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0, false, false));
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().putDouble("summonsuntimer", 20.0);
         } else {
            entity.getPersistentData().putDouble("summonsuntimer", entity.getPersistentData().getDouble("summonsuntimer") - 1.0);
         }

         if (!world.getEntitiesOfClass(TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
            entity.setYRot(
               world.getEntitiesOfClass(TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getYRot()
            );
            entity.setXRot(
               world.getEntitiesOfClass(TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getXRot()
            );
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putBoolean("chosedirectiontorsph", true);
         }

         if (entity.getPersistentData().getBoolean("chosedirectiontorsph")) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0,
                  0.0 - Math.sin((double)entity.getXRot() * (Math.PI / 180.0)) / 1.0,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0
               )
            );
         }

         label130: {
            if (entity instanceof SummonSunBlastEntity _datEntL33 && (Boolean)_datEntL33.getEntityData().get(SummonSunBlastEntity.DATA_shrinkagain)) {
               if ((entity instanceof SummonSunBlastEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SummonSunBlastEntity.DATA_size) : 0) >= 0) {
                  if (entity instanceof SummonSunBlastEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           SummonSunBlastEntity.DATA_size,
                           (entity instanceof SummonSunBlastEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SummonSunBlastEntity.DATA_size) : 0) - 1
                        );
                  }
               } else if (!entity.level().isClientSide()) {
                  entity.discard();
               }
               break label130;
            }

            if (entity instanceof SummonSunBlastEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SummonSunBlastEntity.DATA_size,
                     (entity instanceof SummonSunBlastEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SummonSunBlastEntity.DATA_size) : 0) + 1
                  );
            }

            if ((entity instanceof SummonSunBlastEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SummonSunBlastEntity.DATA_size) : 0) > 120
               && entity instanceof SummonSunBlastEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(SummonSunBlastEntity.DATA_shrinkagain, true);
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TORMENTOR_SMOKE.get(), x, y, z, 2, 0.3, 0.3, 0.3, 0.1);
         }

         if ((
               !world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
                  || !world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
                  || !world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))
                  || !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            )
            && entity instanceof SummonSunBlastEntity _datEntSetL) {
            _datEntSetL.getEntityData().set(SummonSunBlastEntity.DATA_shrinkagain, true);
         }
      }
   }
}
