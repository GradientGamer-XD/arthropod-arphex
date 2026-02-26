package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistDroneEntity;
import net.arphex.entity.AntArsonistSoldierEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DroneTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphex", true);
         ArphexMod.queueServerWork(1200, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            entity.setShiftKeyDown(false);
            if (world.isEmptyBlock(BlockPos.containing(x + 0.5, y, z))
               && world.isEmptyBlock(BlockPos.containing(x - 0.5, y, z))
               && world.isEmptyBlock(BlockPos.containing(x, y, z + 0.5))
               && world.isEmptyBlock(BlockPos.containing(x, y, z - 0.5))) {
               entity.setSprinting(false);
            } else if (!(entity.getDeltaMovement().x() < 0.1) && !(entity.getDeltaMovement().z() < 0.1)) {
               entity.setSprinting(true);
            } else {
               entity.setSprinting(false);
            }
         } else {
            entity.setShiftKeyDown(true);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (!world.getEntitiesOfClass(AntArsonistSoldierEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
               Entity _mobEntx = world.getEntitiesOfClass(AntArsonistSoldierEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((_mobEntx instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null && entity instanceof Mob _entity) {
                  Entity var14 = world.getEntitiesOfClass(AntArsonistSoldierEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if ((var14 instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               }
            }
         } else {
            entity.setSprinting(false);
            if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 40));
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (entity instanceof AntArsonistDroneEntity && Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof Level _level) {
                     if (!_level.isClientSide()) {
                        _level.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzlong")),
                           SoundSource.HOSTILE,
                           0.4F,
                           (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2)
                        );
                     } else {
                        _level.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzlong")),
                           SoundSource.HOSTILE,
                           0.4F,
                           (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2),
                           false
                        );
                     }
                  }
               } else if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzshort")),
                        SoundSource.HOSTILE,
                        0.4F,
                        (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2)
                     );
                  } else {
                     _levelx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzshort")),
                        SoundSource.HOSTILE,
                        0.4F,
                        (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2),
                        false
                     );
                  }
               }

               if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 0.5) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        0.3,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               } else {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                     )
                  );
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               }
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }
         }

         if (entity.isInWater()) {
            entity.setDeltaMovement(
               new Vec3(entity.getDeltaMovement().x() / 8.0, Mth.nextDouble(RandomSource.create(), 0.3, 0.8), entity.getDeltaMovement().z() / 8.0)
            );
         }
      }
   }
}
