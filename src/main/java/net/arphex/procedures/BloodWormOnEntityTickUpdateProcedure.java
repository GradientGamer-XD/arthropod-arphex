package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistEntity;
import net.arphex.entity.SilverfishSpectreEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BloodWormOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.getPersistentData().getBoolean("notfromqueen")) {
            ArphexMod.queueServerWork(1200, () -> entity.getPersistentData().putBoolean("notfromqueen", true));
            if (!world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
               entity.getPersistentData().putBoolean("fromqueen", true);
               ArphexMod.queueServerWork(1200, () -> {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               });
            }
         }

         entity.getPersistentData().putBoolean("arphexclimber", true);
         if (entity.getPersistentData().getDouble("randomsize") > 0.6
            && Mth.nextInt(RandomSource.create(), 1, 100) == 1
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 8000, 0, false, false));
         }

         if (entity.getPersistentData().getDouble("randomsize") > 0.9) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
            }
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) && entity.getDeltaMovement().y() > 0.0) {
            entity.setShiftKeyDown(true);
         } else {
            entity.setShiftKeyDown(false);
         }

         if (entity instanceof AntArsonistEntity) {
            if (Mth.nextInt(RandomSource.create(), 1, 1000) == 5 && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               if (!world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x + 50.0, y, z), 47.0, 47.0, 47.0), e -> true).isEmpty()) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x + 50.0, y, z), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x + 50.0, y, z))
                              .findFirst()
                              .orElse(null)
                              .getX(),
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x + 50.0, y, z), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x + 50.0, y, z))
                              .findFirst()
                              .orElse(null)
                              .getY(),
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x + 50.0, y, z), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x + 50.0, y, z))
                              .findFirst()
                              .orElse(null)
                              .getZ(),
                           1.5
                        );
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x - 50.0, y, z), 47.0, 47.0, 47.0), e -> true).isEmpty()) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x - 50.0, y, z), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x - 50.0, y, z))
                              .findFirst()
                              .orElse(null)
                              .getX(),
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x - 50.0, y, z), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x - 50.0, y, z))
                              .findFirst()
                              .orElse(null)
                              .getY(),
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x - 50.0, y, z), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x - 50.0, y, z))
                              .findFirst()
                              .orElse(null)
                              .getZ(),
                           1.5
                        );
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z - 50.0), 47.0, 47.0, 47.0), e -> true).isEmpty()) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z - 50.0), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z - 50.0))
                              .findFirst()
                              .orElse(null)
                              .getX(),
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z - 50.0), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z - 50.0))
                              .findFirst()
                              .orElse(null)
                              .getY(),
                           world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z - 50.0), 47.0, 47.0, 47.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z - 50.0))
                              .findFirst()
                              .orElse(null)
                              .getZ(),
                           1.5
                        );
                  }
               } else if (!world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z + 50.0), 47.0, 47.0, 47.0), e -> true).isEmpty()
                  && entity instanceof Mob _entity) {
                  _entity.getNavigation()
                     .moveTo(
                        world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z + 50.0), 47.0, 47.0, 47.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z + 50.0))
                           .findFirst()
                           .orElse(null)
                           .getX(),
                        world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z + 50.0), 47.0, 47.0, 47.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z + 50.0))
                           .findFirst()
                           .orElse(null)
                           .getY(),
                        world.getEntitiesOfClass(AntArsonistEntity.class, AABB.ofSize(new Vec3(x, y, z + 50.0), 47.0, 47.0, 47.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z + 50.0))
                           .findFirst()
                           .orElse(null)
                           .getZ(),
                        1.5
                     );
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 5000) == 5 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 200, 0, false, false));
            }
         }

         label137:
         if (entity instanceof SilverfishSpectreEntity) {
            if (Mth.nextInt(RandomSource.create(), 1, 5000) == 5 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 200, 0, false, false));
            }

            if (entity instanceof LivingEntity _livEnt59 && _livEnt59.hasEffect(MobEffects.INVISIBILITY) && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 15, 0.3, 0.3, 0.3, 0.7);
            }

            if (entity instanceof LivingEntity _livEnt61 && _livEnt61.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
               break label137;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Mth.nextInt(RandomSource.create(), 200, 400), 0, false, false));
            }
         }

         entity.setMaxUpStep(1.0F);
         if (entity instanceof AntArsonistEntity) {
            if (entity instanceof AntArsonistEntity _datEntL68
               && (Boolean)_datEntL68.getEntityData().get(AntArsonistEntity.DATA_shiny)
               && entity instanceof AntArsonistEntity animatable) {
               animatable.setTexture("ruby_mob");
            }

            if (entity.getDisplayName().getString().equals("Ant Arsonist")
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
               && !entity.level().isClientSide()) {
               entity.discard();
            }
         }
      }
   }
}
