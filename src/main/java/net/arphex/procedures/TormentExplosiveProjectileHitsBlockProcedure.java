package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentExplosiveProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean toggle = false;
         double togglelimit = 0.0;
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(
               Entity.class,
               new AABB(_center, _center)
                  .inflate(
                     (double)(
                           (
                                 5L
                                    + Math.round(
                                       Math.floor(
                                          ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                   .orElse(new ArphexModVariables.PlayerVariables()))
                                                .wrath_charge_time
                                             / 20.0
                                             * 1.0
                                       )
                                    )
                              )
                              * 2L
                        )
                        / 2.0
                  ),
               e -> true
            )
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            entityiterator.hurt(
               new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
               (float)(
                  60L
                     + Math.round(
                           Math.floor(
                              ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .wrath_charge_time
                                 / 20.0
                           )
                        )
                        * 4L
                     - (long)(entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)
               )
            );
         }

         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
            }
         }

         if (!world.isClientSide() && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_ITEM_GRIEFING.get()) {
            int horizontalRadiusSphere = (int)(
                  5L
                     + Math.round(
                        Math.floor(
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .wrath_charge_time
                              / 20.0
                              / 1.0
                        )
                     )
               )
               - 1;
            int verticalRadiusSphere = (int)(
                  5L
                     + Math.round(
                        Math.floor(
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .wrath_charge_time
                              / 20.0
                              / 1.0
                        )
                     )
               )
               - 1;
            int yIterationsSphere = verticalRadiusSphere;

            for (int i = -verticalRadiusSphere; i <= yIterationsSphere; i++) {
               for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                  for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                     double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere)
                        + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere)
                        + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
                     if (distanceSq <= 1.0
                        && !(world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() instanceof LiquidBlock)
                        && !world.isEmptyBlock(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi))) {
                        if (!(togglelimit > 0.0)) {
                           WaitExplodeProcedure.execute(world, x + (double)xi, y + (double)i, z + (double)zi);
                           togglelimit = 20.0;
                        } else {
                           togglelimit--;
                        }
                     }
                  }
               }
            }
         }

         ArphexMod.queueServerWork(
            1,
            () -> {
               if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity patt4466$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (patt4466$temp instanceof SphereAnimEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "-");
                  }

                  patt4466$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (patt4466$temp instanceof SphereAnimEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           SphereAnimEntity.DATA_max_size,
                           (int)(
                              ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .wrath_charge_time
                                 * 2.0
                           )
                        );
                  }
               }
            }
         );
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
