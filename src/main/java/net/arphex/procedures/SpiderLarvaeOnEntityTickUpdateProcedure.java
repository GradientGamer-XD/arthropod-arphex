package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SmallWebEntity;
import net.arphex.entity.SpiderBroodEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderLarvaeTinyEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;

public class SpiderLarvaeOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(entity.getPersistentData().getDouble("slow_scan") > 0.0)) {
            entity.getPersistentData().putDouble("slow_scan", 100.0);
            if (!entity.getPersistentData().getBoolean("funneldone")
               && world.getEntitiesOfClass(SmallWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 6.0, 6.0, 6.0), e -> true).isEmpty()
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()
               && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)Math.round(y), (double)Math.round(z)))
               && world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 1L), (double)Math.round(z)))
               && (
                  !world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) + 1L), (double)(Math.round(y) + 1L), (double)Math.round(z)))
                        && !world.isEmptyBlock(BlockPos.containing((double)(Math.round(x) - 1L), (double)(Math.round(y) + 1L), (double)Math.round(z)))
                     || !world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 1L), (double)(Math.round(z) + 1L)))
                        && !world.isEmptyBlock(BlockPos.containing((double)Math.round(x), (double)(Math.round(y) + 1L), (double)(Math.round(z) - 1L)))
               )) {
               entity.getPersistentData().putBoolean("funneldone", true);
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SMALL_WEB.get())
                     .spawn(_level, BlockPos.containing((double)Math.round(x), (double)Math.round(y), (double)Math.round(z)), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("slow_scan", entity.getPersistentData().getDouble("slow_scan") - 1.0);
         }

         if (!ModList.get().isLoaded("nyfsspiders")) {
            if (world.isEmptyBlock(BlockPos.containing(x, y - 0.5, z))
               && (!entity.onGround() || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty())) {
               if (world.getBlockState(BlockPos.containing(x, y + 0.7, z)).canOcclude()) {
                  entity.setShiftKeyDown(false);
                  entity.setSprinting(true);
               } else {
                  entity.setShiftKeyDown(true);
                  entity.setSprinting(false);
               }
            } else {
               entity.setShiftKeyDown(false);
               entity.setSprinting(false);
            }
         }

         if (entity instanceof SpiderLarvaeEntity _datEntL26
            && (Boolean)_datEntL26.getEntityData().get(SpiderLarvaeEntity.DATA_shiny)
            && entity instanceof SpiderLarvaeEntity animatable) {
            animatable.setTexture("golden_mob");
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()
            && (!(entity instanceof SpiderLarvaeEntity _datEntL29) || !(Boolean)_datEntL29.getEntityData().get(SpiderLarvaeEntity.DATA_shiny))
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("spidergrab")) {
            entity.lookAt(
               Anchor.EYES,
               new Vec3(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  y,
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               )
            );
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).isEmpty()) {
            entity.lookAt(
               Anchor.EYES,
               new Vec3(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               )
            );
            if (entity instanceof SpiderLarvaeEntity
               && !((SpiderLarvaeEntity)entity).animationprocedure.equals("animation.spiderlarvae.grab")
               && entity instanceof SpiderLarvaeEntity) {
               ((SpiderLarvaeEntity)entity).setAnimation("animation.spiderlarvae.grab");
            }

            if (entity instanceof SpiderLarvaeTinyEntity
               && !((SpiderLarvaeTinyEntity)entity).animationprocedure.equals("animation.spiderlarvae.grab")
               && entity instanceof SpiderLarvaeTinyEntity) {
               ((SpiderLarvaeTinyEntity)entity).setAnimation("animation.spiderlarvae.grab");
            }
         } else {
            if (entity instanceof SpiderLarvaeEntity && entity instanceof SpiderLarvaeEntity) {
               ((SpiderLarvaeEntity)entity).setAnimation("empty");
            }

            if (entity instanceof SpiderLarvaeTinyEntity && entity instanceof SpiderLarvaeTinyEntity) {
               ((SpiderLarvaeTinyEntity)entity).setAnimation("empty");
            }
         }

         if (entity instanceof Mob _entity) {
            Entity var12 = world.getEntitiesOfClass(SpiderBroodEntity.class, AABB.ofSize(new Vec3(x, y, z), 5.0, 5.0, 5.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((var12 instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _ent) {
               _entity.setTarget(_ent);
            }
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y, z))
            && (!world.isEmptyBlock(BlockPos.containing(x, y + 3.0, z)) || !world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z)))) {
            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 0, false, false));
            }

            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 1, false, false));
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 1, 0.0, 1.0, 0.0, 0.0);
            }
         }

         if ((
               !world.isEmptyBlock(BlockPos.containing(x, y, z))
                  || !world.isEmptyBlock(BlockPos.containing(x + 0.7, y, z))
                  || !world.isEmptyBlock(BlockPos.containing(x - 0.7, y, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y, z + 0.7))
                  || !world.isEmptyBlock(BlockPos.containing(x, y, z - 0.7))
            )
            && Mth.nextInt(RandomSource.create(), 1, 200) == 2) {
            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 15, 0, false, false));
            }

            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 0, false, false));
            }
         }

         if (entity instanceof SpiderLarvaeEntity
            && (
               (entity instanceof SpiderLarvaeEntity animatablex ? animatablex.getTexture() : "null").equals("spiderwidow")
                  || (entity instanceof SpiderLarvaeEntity animatable ? animatable.getTexture() : "null").equals("spiderlarvae4")
            )
            && (!(entity instanceof LivingEntity _livEnt76) || !_livEnt76.hasEffect(MobEffects.DAMAGE_RESISTANCE))
            && entity instanceof LivingEntity _entityx
            && !_entityx.level().isClientSide()) {
            _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
         }

         if (!entity.getPersistentData().getBoolean("despawnedrider")) {
            entity.getPersistentData().putBoolean("despawnedrider", true);
            if (entity.isVehicle() && entity.getFirstPassenger() != null && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }
         }
      }
   }
}
