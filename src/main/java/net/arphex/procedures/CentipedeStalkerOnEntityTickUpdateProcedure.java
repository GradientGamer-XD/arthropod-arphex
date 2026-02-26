package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CentipedeStalkerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphexclimber", true);
         if (entity.onGround()
            && !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 10, 0, true, false));
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 600, 0, true, false));
         }

         if ((!(entity instanceof LivingEntity _livEnt8) || !_livEnt8.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get()))
            && (
               !world.isEmptyBlock(BlockPos.containing(x, y + 3.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y + 4.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
            )) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 15, 20, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 10, false, false));
            }
         }

         if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.LEVITATION);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.SLOW_FALLING);
            }
         }

         entity.setMaxUpStep(1.0F);
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
            if ((!(entity instanceof LivingEntity _livEnt24) || !_livEnt24.hasEffect(MobEffects.LEVITATION)) && entity instanceof Mob _entity) {
               _entity.getNavigation()
                  .moveTo(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                     1.0
                  );
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 2, false, false));
            }
         }

         if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player
            && !entity.getPersistentData().getBoolean("triggered")
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 25.0, 25.0, 25.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 6, false, false));
         }

         if (Mth.nextInt(RandomSource.create(), 1, 200) == 1
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
            && entity.getDisplayName().getString().equals("Centipede Stalker")) {
            ArphexMod.queueServerWork(
               20,
               () -> {
                  if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
                     && entity.getDisplayName().getString().equals("Centipede Stalker")
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         }

         entity.setMaxUpStep(1.0F);
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 1, 0.4, 0.2, 0.4, 0.1);
         }

         if (!entity.getPersistentData().getBoolean("skeleton_despawn")) {
            if (entity.isVehicle()
               && entity.getFirstPassenger() != null
               && entity.getFirstPassenger() instanceof Skeleton
               && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }

            entity.getPersistentData().putBoolean("skeleton_despawn", true);
         }

         if (entity instanceof LivingEntity _livEnt60 && _livEnt60.hasEffect(MobEffects.LEVITATION) && !world.isEmptyBlock(BlockPos.containing(x, y + 0.5, z))) {
            ArphexMod.queueServerWork(
               10,
               () -> {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entity.position(),
                              entity.getRotationVector(),
                              entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                              4,
                              entity.getName().getString(),
                              entity.getDisplayName(),
                              entity.level().getServer(),
                              entity
                           ),
                           "data merge entity @s {NoAI:1}"
                        );
                  }
               }
            );
            return;
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "data merge entity @s {NoAI:0}"
               );
         }
      }
   }
}
