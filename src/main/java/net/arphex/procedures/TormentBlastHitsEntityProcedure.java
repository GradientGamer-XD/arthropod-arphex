package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentBlastHitsEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         double tier_scale = 0.0;
         if (entity == sourceentity && !immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")) {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         } else {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            ArphexMod.queueServerWork(
               2,
               () -> {
                  if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                     Entity patt2167$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (patt2167$temp instanceof SphereAnimEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "black");
                     }

                     patt2167$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (patt2167$temp instanceof SphereAnimEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_max_size, 200);
                     }
                  }
               }
            );
            if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
               tier_scale = (double)(
                  (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) / 4.0F
                     - (float)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0)
                        / ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 4.0F)
                     + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 3.0F
               );
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
               tier_scale = (double)(
                  (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) / 3.0F
                     - (float)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0)
                        / ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 4.0F)
                     + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 3.0F
               );
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
               tier_scale = (double)(entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) / 2.5
                  - (double)(
                     (float)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0)
                        / ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 4.0F)
                  )
                  + (double)((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F);
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
               tier_scale = (double)(
                  (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) / 2.0F
                     - (float)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0)
                        / ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 4.0F)
                     + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
               );
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0) {
               tier_scale = (double)((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) * 100.0F);
            }

            if (!entity.getPersistentData().getBoolean("creativespectator") && !entity.isInvulnerable()) {
               if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack") && entity instanceof TORMENTOREntity) {
                  entity.getPersistentData().putDouble("able_to_harm_self", 5.0);
               }

               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                  (float)Math.round(tier_scale * 0.8)
               );
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 1, 0.0, 0.0, 0.0, 0.0);
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.3, 0.3, 0.2, 0.6);
            }

            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }
      }
   }
}
