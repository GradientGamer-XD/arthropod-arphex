package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ButterflyBewitcherEntity;
import net.arphex.entity.ButterflyBewitcherGiantEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ButterflyTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         if (!entity.onGround() && world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            entity.setShiftKeyDown(false);
            if (entity.getPersistentData().getDouble("flywalk") < 300.0) {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
            } else {
               if (entity.getPersistentData().getDouble("flyboost") == 5.0) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        entity.getX() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0), y, entity.getZ() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
                     )
                  );
                  entity.setDeltaMovement(
                     new Vec3(Mth.nextDouble(RandomSource.create(), -0.4, 0.4), entity.getDeltaMovement().y(), Mth.nextDouble(RandomSource.create(), -0.4, 0.4))
                  );
               }

               if (entity.getPersistentData().getDouble("yboost") == 5.0) {
                  entity.setDeltaMovement(
                     new Vec3(entity.getDeltaMovement().x(), Mth.nextDouble(RandomSource.create(), -0.3, 0.3), entity.getDeltaMovement().z())
                  );
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
               && world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
               && world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
               && world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
               entity.setSprinting(false);
            } else if (!(entity.getDeltaMovement().x() > 0.1) && !(entity.getDeltaMovement().z() > 0.1)
               || world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
               entity.setSprinting(true);
               if (!world.isEmptyBlock(BlockPos.containing(x + 0.3, y, z))) {
                  entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
               } else if (!world.isEmptyBlock(BlockPos.containing(x - 0.3, y, z))) {
                  entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y, z));
               } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
                  entity.lookAt(Anchor.EYES, new Vec3(x, y, z - 0.3));
               } else {
                  entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 0.3));
               }
            }
         } else {
            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
            if (entity.getDeltaMovement().x() < 0.1 && entity.getDeltaMovement().z() < 0.1) {
               entity.setShiftKeyDown(true);
            } else {
               entity.setShiftKeyDown(false);
            }

            entity.setSprinting(false);
         }

         if (!(entity.getPersistentData().getDouble("flywalk") > 4000.0)) {
            entity.getPersistentData().putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
         } else {
            entity.getPersistentData().putDouble("flywalk", 0.0);
         }

         if (entity.isInWater()) {
            entity.setDeltaMovement(
               new Vec3(
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                  Mth.nextDouble(RandomSource.create(), 0.3, 0.8),
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
               )
            );
         }

         if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
               && !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).isShiftKeyDown()) {
               entity.getPersistentData().putDouble("flywalk", 300.0);
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.3, entity.getDeltaMovement().z()));
            }

            entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 15));
         } else {
            entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("yboost") > 0.0)) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!(entityiterator instanceof ButterflyBewitcherEntity)
                  && !(entityiterator instanceof ButterflyBewitcherGiantEntity)
                  && !entityiterator.getPersistentData().getBoolean("creativespectator")
                  && !world.isEmptyBlock(BlockPos.containing(x, entityiterator.getY() - 1.0, z))
                  && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 0));
                  }
               }
            }

            if (entity.getDisplayName().getString().equals("Butterfly Bewitcher")
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
               && entity.getDisplayName().getString().equals("Butterfly Bewitcher")
               && (!(entity instanceof TamableAnimal _tamEntx) || !_tamEntx.isTame())
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == null) {
               ArphexMod.queueServerWork(
                  20,
                  () -> {
                     if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
                        && entity.getDisplayName().getString().equals("Butterfly Bewitcher")
                        && (!(entity instanceof TamableAnimal _tamEntxxx) || !_tamEntxxx.isTame())
                        && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) == null
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }

            entity.getPersistentData().putDouble("yboost", (double)Mth.nextInt(RandomSource.create(), 15, 20));
         } else {
            entity.getPersistentData().putDouble("yboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("flywalk") > 1000.0)) {
            entity.getPersistentData().putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
         } else {
            entity.getPersistentData().putDouble("flywalk", 0.0);
         }
      }
   }
}
