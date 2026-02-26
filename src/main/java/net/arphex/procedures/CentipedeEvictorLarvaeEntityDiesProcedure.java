package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.CentipedeEvictorLarvaeEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CentipedeEvictorLarvaeEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         if (!entity.getPersistentData().getBoolean("done")
            && entity instanceof CentipedeEvictorLarvaeEntity _datEntL1
            && (Boolean)_datEntL1.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_stronger)
            && !world.getBlockState(BlockPos.containing(x + 1.0, y, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y + 1.0, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y + 1.0, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y + 1.0, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y + 1.0, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y + 1.0, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y + 1.0, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y + 1.0, z)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y + 1.0, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x, y + 1.0, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y + 1.0, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y + 1.0, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y + 1.0, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y + 1.0, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y + 1.0, z + 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x - 2.0, y + 1.0, z + 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y + 1.0, z - 1.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y + 1.0, z - 2.0)).canOcclude()
            && !world.getBlockState(BlockPos.containing(x + 2.0, y, z - 1.0)).canOcclude()) {
            entity.getPersistentData().putBoolean("done", true);
            if (world instanceof ServerLevel _level) {
               LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
               entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
               entityToSpawn.setVisualOnly(true);
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 150, 1.0, 1.0, 1.0, 0.5);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player
                  && 20 > (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)
                  && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
                  if (entityiterator instanceof Player) {
                     Player _player = (Player)entityiterator;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("§cBeware, killing this larvae has summoned the Centipede Evictor! RUN!"), true);
                     }
                  }

                  ArphexMod.queueServerWork(20, () -> {
                     if (entityiterator instanceof Player _playerx && !_playerx.level().isClientSide()) {
                        _playerx.displayClientMessage(Component.literal("§cBeware, killing this larvae has summoned the Centipede Evictor! RUN!"), true);
                     }
                  });
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }

            ArphexMod.queueServerWork(10, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
               }
            });
            ArphexMod.queueServerWork(40, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
               }
            });
            ArphexMod.queueServerWork(60, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
               }
            });
            ArphexMod.queueServerWork(80, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
               }
            });
            ArphexMod.queueServerWork(
               100,
               () -> {
                  if (world instanceof ServerLevel _levelxxx) {
                     LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_levelxxx);
                     entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                     entityToSpawn.setVisualOnly(true);
                     _levelxxx.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.CENTIPEDE_EVICTOR.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 3.0, 3.0, 3.0, 1.0);
                  }
               }
            );
         }
      }
   }
}
