package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentedExplosiveFlyingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double damage_size = 0.0;
         immediatesourceentity.setNoGravity(true);
         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .wrath_charge_time
               / 20.0
            > 79.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "particle arphex:solid_core ~ ~ ~ 0 0 0 0 1 force"
                  );
            }
         } else if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .wrath_charge_time
               / 20.0
            > 39.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "particle arphex:solid_core_medium ~ ~ ~ 0 0 0 0 1 force"
                  );
            }
         } else if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:solid_core_small ~ ~ ~ 0 0 0 0 1 force"
               );
         }

         ArphexMod.queueServerWork(110, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         if (immediatesourceentity.getPersistentData().getDouble("deltalockx") == 0.0) {
            immediatesourceentity.getPersistentData().putDouble("deltalockx", immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("deltalocky", immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("deltalockz", immediatesourceentity.getDeltaMovement().z());
         } else {
            immediatesourceentity.setDeltaMovement(
               new Vec3(
                  immediatesourceentity.getPersistentData().getDouble("deltalockx"),
                  immediatesourceentity.getPersistentData().getDouble("deltalocky"),
                  immediatesourceentity.getPersistentData().getDouble("deltalockz")
               )
            );
         }

         immediatesourceentity.getPersistentData().putString("owner_deletecheck", entity.getStringUUID());
         if (!immediatesourceentity.getPersistentData().getBoolean("damaged_tormentor")) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof TORMENTOREntity) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt21 = (LivingEntity)entityiterator;
                     if (_livEnt21.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                        continue;
                     }
                  }

                  if (ArphexModVariables.MapVariables.get(world).tormentor_health > 51.0) {
                     ArphexModVariables.MapVariables.get(world).tormentor_health = ArphexModVariables.MapVariables.get(world).tormentor_health
                        - (double)Math.round(
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .wrath_charge_time
                              / 44.5
                        );
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), entity), 60.0F
                     );
                  } else if (1L
                     > Math.round(
                        ArphexModVariables.MapVariables.get(world).tormentor_health
                           - ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .wrath_charge_time
                              / 44.5
                     )) {
                     ArphexModVariables.MapVariables.get(world).tormentor_health = ArphexModVariables.MapVariables.get(world).tormentor_health
                        - (double)Math.round(
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .wrath_charge_time
                              / 44.5
                        );
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), entity), 60.0F
                     );
                  } else {
                     ArphexModVariables.MapVariables.get(world).tormentor_health = 1.0;
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), entity), 1000.0F
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

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                     }
                  }

                  ArphexMod.queueServerWork(
                     1,
                     () -> {
                        if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                           Entity patt7437$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null);
                           if (patt7437$temp instanceof SphereAnimEntity _datEntSetS) {
                              _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "-");
                           }

                           patt7437$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null);
                           if (patt7437$temp instanceof SphereAnimEntity _datEntSetI) {
                              _datEntSetI.getEntityData()
                                 .set(
                                    SphereAnimEntity.DATA_max_size,
                                    (int)(
                                       10L
                                          * Math.round(
                                             ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                      .orElse(new ArphexModVariables.PlayerVariables()))
                                                   .wrath_charge_time
                                                / 5.0
                                          )
                                    )
                                 );
                           }
                        }
                     }
                  );
                  immediatesourceentity.getPersistentData().putBoolean("damaged_tormentor", true);
                  if (!immediatesourceentity.level().isClientSide()) {
                     immediatesourceentity.discard();
                  }
               }
            }
         }
      }
   }
}
