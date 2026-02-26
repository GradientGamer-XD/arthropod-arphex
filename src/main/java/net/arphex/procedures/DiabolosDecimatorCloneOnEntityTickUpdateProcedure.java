package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.SlowLookTestEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class DiabolosDecimatorCloneOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity nearest_diabolos = null;
         double distance = 0.0;
         entity.setNoGravity(true);
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

         entity.noPhysics = true;
         nearest_diabolos = world.getEntitiesOfClass(DiabolosDecimatorEntity.class, AABB.ofSize(new Vec3(x, y, z), 260.0, 260.0, 260.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if ((nearest_diabolos instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (entity.getPersistentData().getDouble("lifespan_diaclone") < 380.0) {
               entity.getPersistentData().putDouble("lifespan_diaclone", 380.0);
            }
         } else {
            entity.teleportTo(entity.getX(), nearest_diabolos.getY(), entity.getZ());
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection.teleport(entity.getX(), nearest_diabolos.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
            }

            distance = Math.sqrt(
               (entity.getX() - nearest_diabolos.getX()) * (entity.getX() - nearest_diabolos.getX())
                  + (entity.getY() - nearest_diabolos.getY()) * (entity.getY() - nearest_diabolos.getY())
                  + (entity.getZ() - nearest_diabolos.getZ()) * (entity.getZ() - nearest_diabolos.getZ())
            );
            if (distance > 30.0) {
               entity.setDeltaMovement(
                  new Vec3((nearest_diabolos.getX() - entity.getX()) / distance, 0.0, (nearest_diabolos.getZ() - entity.getZ()) / distance)
               );
            } else if (distance < 15.0) {
               if (distance == 0.0) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 1.0));
               } else {
                  entity.setDeltaMovement(
                     new Vec3((entity.getX() - nearest_diabolos.getX()) / distance, 0.0, (entity.getZ() - nearest_diabolos.getZ()) / distance)
                  );
               }
            }

            if (!world.isClientSide()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     (nearest_diabolos instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                     (nearest_diabolos instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                     (nearest_diabolos instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                  )
               );
            }
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 60, 0, false, false));
         }

         entity.getPersistentData().putDouble("lifespan_diaclone", entity.getPersistentData().getDouble("lifespan_diaclone") + 1.0);
         if (entity.getPersistentData().getDouble("lifespan_diaclone") > 350.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _level,
                           4,
                           "",
                           Component.literal(""),
                           _level.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "particle arphex:heavy_gold_smoke ~ ~ ~ 2 12 2 0.2 100 force"
                  );
            }

            if (entity.getPersistentData().getDouble("lifespan_diaclone") > 400.0 && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (entity.isInWall() && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!entity.getPersistentData().getBoolean("lim_one_spawn")
            && world.getEntitiesOfClass(
                  SlowLookTestEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY() + 15.0, entity.getZ()), 15.0, 15.0, 15.0), e -> true
               )
               .isEmpty()) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SLOW_LOOK_TEST.get())
                  .spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 15.0, entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(entity.getYRot());
                  entityToSpawn.setYBodyRot(entity.getYRot());
                  entityToSpawn.setYHeadRot(entity.getYRot());
                  entityToSpawn.setXRot(entity.getXRot());
               }
            }

            entity.getPersistentData().putBoolean("lim_one_spawn", true);
         }
      }
   }
}
