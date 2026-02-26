package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SmallTormentSphereOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double hominglink = 0.0;
         if (!(entity.getPersistentData().getDouble("vectorlim") > 0.0)) {
            entity.getPersistentData().putDouble("vectorlim", 5.0);
         } else {
            entity.getPersistentData().putDouble("vectorlim", entity.getPersistentData().getDouble("vectorlim") - 1.0);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            ArphexMod.queueServerWork(
               20,
               () -> {
                  if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null
                     && !entity.getPersistentData().getBoolean("flytowardstarget")
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         } else {
            ArphexMod.queueServerWork(200, () -> {
               entity.getPersistentData().putBoolean("lockinplace", true);
               if (ArphexModVariables.MapVariables.get(world).tormentor_health > 500.0) {
                  ArphexMod.queueServerWork(120, () -> entity.getPersistentData().putBoolean("flytowardstarget", true));
               } else {
                  ArphexMod.queueServerWork(50, () -> entity.getPersistentData().putBoolean("flytowardstarget", true));
               }
            });
            if (!entity.getPersistentData().getBoolean("lockinplace")
               && !entity.getPersistentData().getBoolean("flytowardstarget")
               && entity.getPersistentData().getDouble("vectorlim") == 5.0) {
               entity.setDeltaMovement(
                  new Vec3(
                     entity.getPersistentData().getDouble("originallockx") / 2.0,
                     entity.getPersistentData().getDouble("originallocky") / 2.0,
                     entity.getPersistentData().getDouble("originallockz") / 2.0
                  )
               );
            }

            if (entity.getPersistentData().getBoolean("lockinplace") && !entity.getPersistentData().getBoolean("flytowardstarget")) {
               entity.getPersistentData().putDouble("lockx", (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX());
               entity.getPersistentData().putDouble("locky", (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY());
               entity.getPersistentData().putDouble("lockz", (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ());
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().getDouble("vectorlim") == 5.0) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof Player) {
                        double _setval = 60.0;
                        entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.shadertime = _setval;
                           capability.syncPlayerVariables(entityiterator);
                        });
                     }

                     if (entityiterator instanceof LivingEntity
                        && entityiterator != entity
                        && !(entityiterator instanceof TORMENTOREntity)
                        && !entityiterator.getPersistentData().getBoolean("tormentor_summon")) {
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.TORMENT.get(), 20, 0, false, false));
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 20, 0.6, 0.7, 0.6, 0.5);
                        }

                        if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 0.0) {
                           if ((270.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 50.0)
                                 / (double)(((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 8) / 8)
                              > (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                                 / (6.0 - ArphexModVariables.MapVariables.get(world).tormentor_tier)) {
                              entityiterator.hurt(
                                 new DamageSource(
                                    world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity
                                 ),
                                 (float)(270 / (((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 8) / 8))
                              );
                           } else {
                              entityiterator.hurt(
                                 new DamageSource(
                                    world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity
                                 ),
                                 (float)(
                                    (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                                       / (6.0 - ArphexModVariables.MapVariables.get(world).tormentor_tier)
                                 )
                              );
                           }
                        }

                        if (world instanceof Level _level && !_level.isClientSide()) {
                           _level.explode(null, x, y, z, 7.0F, ExplosionInteraction.MOB);
                        }

                        entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                        if (!entity.level().isClientSide()) {
                           entity.discard();
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().getBoolean("flytowardstarget")) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 1, 0.3, 0.3, 0.3, 0.2);
               }

               if (entity.getPersistentData().getDouble("lockxgo") != 0.0) {
                  if (entity.getPersistentData().getDouble("vectorlim") == 5.0) {
                     entity.setDeltaMovement(
                        new Vec3(
                           entity.getPersistentData().getDouble("lockxgo") * 2.0,
                           entity.getPersistentData().getDouble("lockygo") * 2.0,
                           entity.getPersistentData().getDouble("lockzgo") * 2.0
                        )
                     );
                  }
               } else {
                  hominglink = Math.sqrt(
                     Math.pow(entity.getPersistentData().getDouble("lockx") - entity.getX(), 2.0)
                        + Math.pow(entity.getPersistentData().getDouble("locky") - (entity.getY() + 0.6), 2.0)
                        + Math.pow(entity.getPersistentData().getDouble("lockz") - entity.getZ(), 2.0)
                  );
                  if (hominglink != 0.0) {
                     entity.getPersistentData().putDouble("lockxgo", (entity.getPersistentData().getDouble("lockx") - entity.getX()) / hominglink * 1.9);
                     entity.getPersistentData().putDouble("lockygo", (entity.getPersistentData().getDouble("locky") - entity.getY()) / hominglink * 1.9);
                     entity.getPersistentData().putDouble("lockzgo", (entity.getPersistentData().getDouble("lockz") - entity.getZ()) / hominglink * 1.9);
                  }
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof Player) {
                     double _setval = 60.0;
                     entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.shadertime = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }

                  if (entityiterator instanceof LivingEntity
                     && entityiterator != entity
                     && !(entityiterator instanceof TORMENTOREntity)
                     && !entityiterator.getPersistentData().getBoolean("tormentor_summon")) {
                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.TORMENT.get(), 20, 0, false, false));
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 20, 0.6, 0.7, 0.6, 0.5);
                     }

                     if ((float)(320 / (((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 8) / 8))
                        > (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 5.0F) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity),
                           (float)(320 / (((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 8) / 8))
                        );
                     } else {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity),
                           (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 5.0F
                        );
                     }

                     if (world instanceof Level _level && !_level.isClientSide()) {
                        _level.explode(null, x, y, z, 7.0F, ExplosionInteraction.MOB);
                     }

                     entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               }
            }
         }

         if (!(ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0) && !entity.level().isClientSide()) {
            entity.discard();
         }

         ArphexMod.queueServerWork(500, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
      }
   }
}
