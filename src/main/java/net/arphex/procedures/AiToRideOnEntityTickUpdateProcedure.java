package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderGoliathEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AiToRideOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(entity.getPersistentData().getDouble("spawnlimit") > 0.0)) {
            if (world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
               && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_GOLIATH.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }
         } else {
            entity.getPersistentData().putDouble("spawnlimit", entity.getPersistentData().getDouble("spawnlimit") - 1.0);
         }

         if (!world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
            Entity _ent = world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
               _ent.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        _ent.position(),
                        _ent.getRotationVector(),
                        _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null,
                        4,
                        _ent.getName().getString(),
                        _ent.getDisplayName(),
                        _ent.level().getServer(),
                        _ent
                     ),
                     "data merge entity @s {NoAI:1}"
                  );
            }

            if (Math.round(entity.getX() * 100.0)
                  != Math.round(
                     world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getX()
                        * 100.0
                  )
               || Math.round(entity.getY() * 100.0)
                  != Math.round(
                     world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getY()
                        * 100.0
                  )
               || Math.round(entity.getZ() * 100.0)
                  != Math.round(
                     world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getZ()
                        * 100.0
                  )) {
               _ent = world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
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
            }

            if (Math.round(entity.getYRot())
               != Math.round(
                  world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getYRot()
               )) {
               _ent = world.getEntitiesOfClass(SpiderGoliathEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                  _ent.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                           CommandSource.NULL,
                           _ent.position(),
                           _ent.getRotationVector(),
                           _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null,
                           4,
                           _ent.getName().getString(),
                           _ent.getDisplayName(),
                           _ent.level().getServer(),
                           _ent
                        ),
                        "execute as @s at @s anchored eyes rotated as @e[type="
                           + ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()
                           + ",limit=1,sort=nearest] positioned ^ ^ ^5 rotated as @s positioned ^ ^ ^40 facing entity @s eyes facing ^ ^ ^-1 positioned as @s run tp @s ~ ~ ~ ~ ~"
                     );
               }
            }
         }
      }
   }
}
