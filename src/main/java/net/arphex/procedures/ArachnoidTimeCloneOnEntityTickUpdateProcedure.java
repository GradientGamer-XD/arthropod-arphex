package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ArachnoidTimeCloneOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("arachnoid_time_clone", entity.getPersistentData().getDouble("arachnoid_time_clone") + 1.0);
         if (entity instanceof LivingEntity _entity) {
            _entity.removeAllEffects();
         }

         if (entity.getPersistentData().getDouble("arachnoid_time_clone") % 8.0 < 4.0
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0));
         }

         entity.setDeltaMovement(new Vec3(0.0, -1.0, 0.0));
         if (!entity.isInWall() && !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))) {
            if (!world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()) {
               if (entity.getPersistentData().getDouble("arachnoid_time_clone") > 600.0) {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  Entity _ent = world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if ((double)(_ent instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                     < entity.getPersistentData().getDouble("trisector_past_health")) {
                     Entity _entfound = world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (_entfound instanceof LivingEntity _entity) {
                        _entity.setHealth((float)entity.getPersistentData().getDouble("trisector_past_health"));
                     }

                     _ent = world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _ent.teleportTo(entity.getX(), entity.getY(), entity.getZ());
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ(), _ent.getYRot(), _ent.getXRot());
                     }

                     _ent = world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     _ent.setYRot(entity.getYRot());
                     _ent.setXRot(0.0F);
                     _ent.setYBodyRot(_ent.getYRot());
                     _ent.setYHeadRot(_ent.getYRot());
                     _ent.yRotO = _ent.getYRot();
                     _ent.xRotO = _ent.getXRot();
                     if (_ent instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "particle arphex:heavy_red_smoke ~ ~ ~ 2 2 2 0 50 force"
                           );
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof Player && entityiterator instanceof Player) {
                           Player _player = (Player)entityiterator;
                           if (!_player.level().isClientSide()) {
                              _player.displayClientMessage(Component.literal("§cThe Arachnoid travelled back in time to its clone, regaining health!"), true);
                           }
                        }
                     }
                  }
               }
            } else {
               ArphexMod.queueServerWork(
                  20,
                  () -> {
                     if (world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
