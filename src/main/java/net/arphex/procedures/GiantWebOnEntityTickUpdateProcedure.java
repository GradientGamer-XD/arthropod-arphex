package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.GiantWebEntity;
import net.arphex.entity.SpiderSnatcherEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GiantWebOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double randomattempt = 0.0;
         double randomattemptz = 0.0;
         double randomattempty = 0.0;
         if (!(entity instanceof LivingEntity _livEnt0) || !_livEnt0.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
            ArphexMod.queueServerWork(20, () -> {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 1, false, false));
               }
            });
         }

         if ((
               !world.isEmptyBlock(BlockPos.containing(x + 2.0, y + 5.0, z)) && !world.isEmptyBlock(BlockPos.containing(x - 2.0, y + 5.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y + 5.0, z + 2.0)) && !world.isEmptyBlock(BlockPos.containing(x, y + 5.0, z - 2.0))
            )
            && !(entity instanceof GiantWebEntity animatable ? animatable.getTexture() : "null").equals("cocoon")) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 1, 1.0, 1.0, 1.0, 0.05);
            }
         } else {
            label214:
            if (!world.isEmptyBlock(BlockPos.containing(x, y + 5.0, z))) {
               if (!(entity instanceof LivingEntity _livEnt10) || !_livEnt10.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  entity.getPersistentData().putBoolean("cocoon", true);
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 1, 1.0, 1.0, 1.0, 0.05);
                  }

                  if (entity instanceof GiantWebEntity) {
                     ((GiantWebEntity)entity).setAnimation("animation.giantweb.cocoon");
                  }

                  if (entity instanceof GiantWebEntity animatablex) {
                     animatablex.setTexture("cocoon");
                  }

                  entity.setShiftKeyDown(false);
                  entity.setSprinting(false);
                  break label214;
               }

               if (!entity.getPersistentData().getBoolean("cocoon")) {
                  if (world instanceof ServerLevel _level) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                     }
                  }

                  if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                     }
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                        .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                     }
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else {
               if (world instanceof ServerLevel _levelxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                     .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               if (world instanceof ServerLevel _levelxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                     .spawn(_levelxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               if (world instanceof ServerLevel _levelxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                     .spawn(_levelxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

         if (!world.isEmptyBlock(BlockPos.containing(x + 2.0, y + 5.0, z)) && !world.isEmptyBlock(BlockPos.containing(x - 2.0, y + 5.0, z))) {
            entity.lookAt(Anchor.EYES, new Vec3(entity.getX() - 5.0, entity.getY(), entity.getZ()));
         } else {
            entity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ() - 5.0));
         }

         if (!entity.getPersistentData().getBoolean("done_spawn_web")) {
            Vec3 _center = new Vec3(x, y + 2.0, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!entityiterator.getPersistentData().getBoolean("creativespectator") && !entityiterator.getPersistentData().getBoolean("spidertype")) {
                  entityiterator.setDeltaMovement(new Vec3(entityiterator.getDeltaMovement().x(), -5.0, entityiterator.getDeltaMovement().z()));
                  if (entityiterator instanceof Player) {
                     ArphexMod.queueServerWork(10, () -> {
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 10, 4, false, false));
                        }

                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                        }
                     });
                  } else {
                     ArphexMod.queueServerWork(
                        10,
                        () -> {
                           if (!(entityiterator instanceof GiantWebEntity)
                              && !entityiterator.getPersistentData().getBoolean("spidertype")
                              && entityiterator instanceof LivingEntity _entity
                              && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 10, 3, false, false));
                           }
                        }
                     );
                  }

                  if (world.getEntitiesOfClass(SpiderSnatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()
                     && entityiterator instanceof Player
                     && Mth.nextInt(RandomSource.create(), 1, 5) == 5) {
                     randomattempty = (double)Mth.nextInt(RandomSource.create(), -5, 5);
                     if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        randomattempt = (double)Mth.nextInt(RandomSource.create(), -10, -28);
                     } else {
                        randomattempt = (double)Mth.nextInt(RandomSource.create(), 10, 28);
                     }

                     if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                        randomattemptz = (double)Mth.nextInt(RandomSource.create(), -10, -28);
                     } else {
                        randomattemptz = (double)Mth.nextInt(RandomSource.create(), 10, 28);
                     }

                     if (world.isEmptyBlock(BlockPos.containing(x + randomattempt, y, z + randomattemptz))
                        && world.isEmptyBlock(BlockPos.containing(x + randomattempt + 1.0, y, z + randomattemptz))
                        && world.isEmptyBlock(BlockPos.containing(x + randomattempt - 1.0, y, z + randomattemptz))
                        && world.isEmptyBlock(BlockPos.containing(x + randomattempt, y, z + randomattemptz - 1.0))
                        && world.isEmptyBlock(BlockPos.containing(x + randomattempt, y + 1.0, z + randomattemptz))
                        && world.isEmptyBlock(BlockPos.containing(x + randomattempt + 1.0, y + 1.0, z + randomattemptz))
                        && world.isEmptyBlock(BlockPos.containing(x + randomattempt - 1.0, y + 1.0, z + randomattemptz))
                        && world.isEmptyBlock(BlockPos.containing(x + randomattempt, y + 1.0, z + randomattemptz - 1.0))) {
                        entity.getPersistentData().putBoolean("done_spawn_web", true);
                        if (world instanceof ServerLevel) {
                           ServerLevel _levelxxxxxx = (ServerLevel)world;
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_SNATCHER.get())
                              .spawn(_levelxxxxxx, BlockPos.containing(x + randomattempt, y, z + randomattemptz), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                           }
                        }

                        ArphexMod.queueServerWork(400, () -> {
                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }
                        });
                     }
                  }
               }
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeAllEffects();
         }

         if (entity.isInWall()
            || (
                  !world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
                     || !world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(x + 1.0, y + 1.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x - 1.0, y + 1.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(x + 1.0, y + 2.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x - 1.0, y + 2.0, z))
               )
               && !entity.getPersistentData().getBoolean("cocoon")
               && entity instanceof LivingEntity _livEnt88
               && _livEnt88.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
            if (world instanceof ServerLevel _levelxxxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelxxxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }
      }
   }
}
