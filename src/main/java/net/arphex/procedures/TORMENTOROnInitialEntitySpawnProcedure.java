package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.AscendSphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TORMENTOROnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 60, 0, false, false));
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()) {
            ArphexModVariables.MapVariables.get(world).tormentor_last_player_spawned = true;
            ArphexModVariables.MapVariables.get(world).syncData(world);
            ArphexModVariables.MapVariables.get(world).tormentor_health = entity instanceof LivingEntity _livEnt ? (double)_livEnt.getMaxHealth() : -1.0;
            ArphexModVariables.MapVariables.get(world).syncData(world);
            entity.getPersistentData().putBoolean("spawnedbyplayer", true);
            if (!world.getEntitiesOfClass(AscendSphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true).isEmpty()) {
               Entity var9 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var9 instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal("TORMENTOR MARKED AS SPAWNED BY PLAYER - Nearby Ascended Cube is preventing the entity spawn"), true
                  );
               }
            } else {
               Entity var14 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var14 instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("TORMENTOR MARKED AS SPAWNED BY PLAYER + CAN USE TORMENT ON ALL PLAYERS"), true);
               }
            }

            if (!(ArphexModVariables.MapVariables.get(world).tormentor_seal_limit > 0.0)) {
               ArphexMod.queueServerWork(
                  3,
                  () -> {
                     if (world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
                        && world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR.get())
                           .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                        }
                     }
                  }
               );
            }
         } else if (entity instanceof LivingEntity _entity) {
            _entity.setHealth((float)ArphexModVariables.MapVariables.get(world).tormentor_health);
         }

         entity.getPersistentData().putDouble("yvtar", -230.0);
         ArphexModVariables.MapVariables.get(world).tormentor_seal_limit = 200.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
      }
   }
}
