package net.arphex.procedures;

import net.arphex.entity.CaveWebEntity;
import net.arphex.entity.SpiderRecluseEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;

public class SpiderRecluseTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean solidfound = false;
         Entity nearest = null;
         if ((entity instanceof SpiderRecluseEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0) < 27) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 20.0F && entity instanceof LivingEntity _entity) {
               _entity.setHealth(20.0F);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, false, false));
            }
         }

         if ((entity instanceof SpiderRecluseEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderRecluseEntity.DATA_hangweb) : 0) > 0
            && entity instanceof SpiderRecluseEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SpiderRecluseEntity.DATA_hangweb,
                  (entity instanceof SpiderRecluseEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderRecluseEntity.DATA_hangweb) : 0) - 1
               );
         }

         if (!ModList.get().isLoaded("nyfsspiders")) {
            if ((!world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) || !world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z)))
               && (entity instanceof SpiderRecluseEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderRecluseEntity.DATA_hangweb) : 0) <= 0) {
               entity.setShiftKeyDown(false);
               if (world.isClientSide() && entity instanceof SpiderRecluseEntity) {
                  ((SpiderRecluseEntity)entity).setAnimation("empty");
               }
            } else if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))
               && (entity instanceof SpiderRecluseEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderRecluseEntity.DATA_hangweb) : 0) <= 0) {
               entity.setShiftKeyDown(false);
               if (world.isClientSide() && entity instanceof SpiderRecluseEntity) {
                  ((SpiderRecluseEntity)entity).setAnimation("animation.spider_recluse.grabmove");
               }
            } else {
               if (world.isClientSide() && entity instanceof SpiderRecluseEntity) {
                  ((SpiderRecluseEntity)entity).setAnimation("empty");
               }

               entity.setShiftKeyDown(true);
            }
         }

         if (!entity.getPersistentData().getBoolean("despawnedrider")) {
            entity.getPersistentData().putBoolean("despawnedrider", true);
            if (entity.isVehicle() && entity.getFirstPassenger() != null && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }
         }

         if (!entity.onGround() && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 2.0, z, 1, 0.05, 0.8, 0.05, 0.0);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (!(entity.getPersistentData().getDouble("slow_web_check") > 0.0)) {
               if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                  && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                  && !entity.getPersistentData().getBoolean("doneweb")) {
                  if (world.getBlockState(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 4.0, entity.getZ())).canOcclude()
                     && world.getBlockState(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 4.0, entity.getZ())).canOcclude()) {
                     entity.getPersistentData().putBoolean("doneweb", true);
                     if (world.getEntitiesOfClass(CaveWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 2.0, z, 40, 0.3, 2.0, 0.3, 0.3);
                        }

                        if (world instanceof ServerLevel _level) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.CAVE_WEB.get())
                              .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 4.0, entity.getZ() + 1.0)).canOcclude()
                     && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 4.0, entity.getZ() - 1.0)).canOcclude()) {
                     entity.getPersistentData().putBoolean("doneweb", true);
                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 2.0, z, 40, 0.3, 2.0, 0.3, 0.3);
                     }

                     if (world instanceof ServerLevel _levelx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CAVE_WEB.get())
                           .spawn(_levelx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(entity.getX() + 2.0, entity.getY() + 3.0, entity.getZ())).canOcclude()
                     && world.getBlockState(BlockPos.containing(entity.getX() - 2.0, entity.getY() + 3.0, entity.getZ())).canOcclude()) {
                     entity.getPersistentData().putBoolean("doneweb", true);
                     if (world instanceof ServerLevel _levelxx) {
                        _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 2.0, z, 40, 0.3, 2.0, 0.3, 0.3);
                     }

                     if (world instanceof ServerLevel _levelxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CAVE_WEB.get())
                           .spawn(_levelxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 3.0, entity.getZ() + 2.0)).canOcclude()
                     && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 3.0, entity.getZ() - 2.0)).canOcclude()) {
                     entity.getPersistentData().putBoolean("doneweb", true);
                     if (world instanceof ServerLevel _levelxxx) {
                        _levelxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 2.0, z, 40, 0.3, 2.0, 0.3, 0.3);
                     }

                     if (world instanceof ServerLevel _levelxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CAVE_WEB.get())
                           .spawn(_levelxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 3.0, entity.getZ())).canOcclude()
                     && world.getBlockState(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 3.0, entity.getZ())).canOcclude()) {
                     entity.getPersistentData().putBoolean("doneweb", true);
                     if (world instanceof ServerLevel _levelxxxx) {
                        _levelxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 2.0, z, 40, 0.3, 2.0, 0.3, 0.3);
                     }

                     if (world instanceof ServerLevel _levelxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CAVE_WEB.get())
                           .spawn(_levelxxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 3.0, entity.getZ() + 1.0)).canOcclude()
                     && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 3.0, entity.getZ() - 1.0)).canOcclude()) {
                     entity.getPersistentData().putBoolean("doneweb", true);
                     if (world instanceof ServerLevel _levelxxxxx) {
                        _levelxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 2.0, z, 40, 0.3, 2.0, 0.3, 0.3);
                     }

                     if (world instanceof ServerLevel _levelxxxxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.CAVE_WEB.get())
                           .spawn(_levelxxxxx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  }
               }

               entity.getPersistentData().putDouble("slow_web_check", 5.0);
            } else {
               entity.getPersistentData().putDouble("slow_web_check", entity.getPersistentData().getDouble("slow_web_check") - 1.0);
            }
         }
      }
   }
}
