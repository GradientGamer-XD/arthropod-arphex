package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentBlastHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 20, 0.4, 0.4, 0.4, 0.4);
         }

         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
            }
         }

         ArphexMod.queueServerWork(
            2,
            () -> {
               if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity patt1934$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (patt1934$temp instanceof SphereAnimEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "black");
                  }

                  patt1934$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (patt1934$temp instanceof SphereAnimEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           SphereAnimEntity.DATA_max_size,
                           (int)((double)Mth.nextInt(RandomSource.create(), 250, 400) + ArphexModVariables.MapVariables.get(world).tormentor_tier * 80.0)
                        );
                  }
               }
            }
         );
         if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_GRIEFING.get() && world instanceof Level _levelx && !_levelx.isClientSide()) {
            _levelx.explode(null, x, y, z, (float)(17.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 3.0), ExplosionInteraction.MOB);
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
