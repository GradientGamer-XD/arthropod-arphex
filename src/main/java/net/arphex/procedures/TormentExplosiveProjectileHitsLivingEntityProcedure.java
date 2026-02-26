package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentExplosiveProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         double damage_size = 0.0;
         if (!immediatesourceentity.getPersistentData().getBoolean("damaged_tormentor")) {
            damage_size = (double)Math.round(
               (
                        ((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .wrath_charge_time
                           - 20.0
                     )
                     * 0.4747474747
                  + 60.0
                  - (double)((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 2)
            );
            if (entity instanceof TORMENTOREntity
               && (!(entity instanceof LivingEntity _livEnt3) || !_livEnt3.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get()))
               && ArphexModVariables.MapVariables.get(world).tormentor_health > 51.0) {
               ArphexModVariables.MapVariables.get(world).tormentor_health = (double)Math.round(
                  ArphexModVariables.MapVariables.get(world).tormentor_health
                     - ((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .wrath_charge_time
                        / 40.8
               );
               ArphexModVariables.MapVariables.get(world).syncData(world);
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), sourceentity), 10.0F
               );
            }

            if (damage_size > 0.0) {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                  (float)damage_size
               );
            } else {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity), 1.0F
               );
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 3, 0.3, 0.3, 0.3, 0.3);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 15, 0.3, 0.3, 0.3, 0.3);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 30, 0.3, 0.3, 0.3, 0.5);
            }

            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                     Entity patt4060$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (patt4060$temp instanceof SphereAnimEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "-");
                     }

                     patt4060$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (patt4060$temp instanceof SphereAnimEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              SphereAnimEntity.DATA_max_size,
                              (int)Math.round(
                                 ((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                          .orElse(new ArphexModVariables.PlayerVariables()))
                                       .wrath_charge_time
                                    / 5.0
                              )
                           );
                     }
                  }
               }
            );
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
