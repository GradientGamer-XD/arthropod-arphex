package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class TamedTarantulaTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphexclimber", true);
         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.9, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 1.9, z)) && !entity.onGround()) {
            if (world.isClientSide()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
                  if ((entity instanceof TamedTarantulaEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0)
                     == 0) {
                     if (entity instanceof TamedTarantulaEntity) {
                        ((TamedTarantulaEntity)entity).setAnimation("animation.spidertarantula.grabwalk");
                     }
                  } else if ((
                        entity instanceof TamedTarantulaEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0
                     )
                     == 1) {
                     if (entity instanceof TamedTarantulaEntity) {
                        ((TamedTarantulaEntity)entity).setAnimation("animation.spiderwander.grabmove");
                     }
                  } else if ((
                        entity instanceof TamedTarantulaEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                           : 0
                     )
                     == 3) {
                     if (entity instanceof TamedTarantulaEntity) {
                        ((TamedTarantulaEntity)entity).setAnimation("animation.spiderwidow.grabmove");
                     }
                  } else if ((
                        entity instanceof TamedTarantulaEntity _datEntIxxx
                           ? (Integer)_datEntIxxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                           : 0
                     )
                     == 4) {
                     if (entity instanceof TamedTarantulaEntity) {
                        ((TamedTarantulaEntity)entity).setAnimation("animation.spider_recluse.grabmoveride");
                     }
                  } else if (entity instanceof TamedTarantulaEntity) {
                     ((TamedTarantulaEntity)entity).setAnimation("empty");
                  }
               } else if (entity instanceof TamedTarantulaEntity) {
                  ((TamedTarantulaEntity)entity).setAnimation("empty");
               }
            }

            entity.setShiftKeyDown(true);
         } else {
            if (entity instanceof TamedTarantulaEntity) {
               ((TamedTarantulaEntity)entity).setAnimation("empty");
            }

            entity.setShiftKeyDown(false);
         }

         if ((entity instanceof TamedTarantulaEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0)
            == 0) {
            if (entity instanceof TamedTarantulaEntity spider) {
               spider.getPersistentData().putString("glowTexture", "spiderlarvaeglow");
            }

            if (entity instanceof TamedTarantulaEntity animatable) {
               animatable.setTexture(
                  entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : ""
               );
            }
         } else if ((
               entity instanceof TamedTarantulaEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0
            )
            == 1) {
            if (entity instanceof TamedTarantulaEntity spider) {
               spider.getPersistentData().putString("glowTexture", "spiderlarvaeglow");
            }

            if (entity instanceof TamedTarantulaEntity animatable) {
               animatable.setTexture("spiderwander");
            }
         } else if ((
               entity instanceof TamedTarantulaEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0
            )
            == 2) {
            if (entity instanceof TamedTarantulaEntity spider) {
               spider.getPersistentData().putString("glowTexture", "spider_ambush_glow");
            }

            if (entity instanceof TamedTarantulaEntity animatable) {
               animatable.setTexture("spider_ambusher");
            }
         } else if ((
               entity instanceof TamedTarantulaEntity _datEntIxxxx ? (Integer)_datEntIxxxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0
            )
            == 3) {
            if (entity instanceof TamedTarantulaEntity spider) {
               spider.getPersistentData().putString("glowTexture", "widowglow");
            }

            if (entity instanceof TamedTarantulaEntity animatable) {
               animatable.setTexture("spiderwidow");
            }
         } else {
            if (entity instanceof TamedTarantulaEntity spider) {
               spider.getPersistentData().putString("glowTexture", "spider_ambush_glow");
            }

            if (entity instanceof TamedTarantulaEntity animatable) {
               animatable.setTexture("spider_recluse_2");
            }
         }

         if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
            .equals("tarantula1")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
            }
         }

         if ((!(entity instanceof LivingEntity _livEnt32) || !_livEnt32.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
         }

         if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula4")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1, false, false));
         }

         if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula3")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false));
         }

         if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula2")
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0, false, false));
         }

         if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula6")
            && entity.isVehicle()
            && entity.getFirstPassenger() != null
            && (!(entity.getFirstPassenger() instanceof LivingEntity _livEnt45) || !_livEnt45.hasEffect(MobEffects.REGENERATION))
            && entity.getFirstPassenger() instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
         }

         if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
               .equals("tarantula7")
            && entity.isVehicle()
            && entity.getFirstPassenger() != null
            && (!(entity.getFirstPassenger() instanceof LivingEntity _livEnt53) || !_livEnt53.hasEffect(MobEffects.DAMAGE_BOOST))
            && entity.getFirstPassenger() instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
         }

         if ((entity instanceof TamedTarantulaEntity _datEntS ? (String)_datEntS.getEntityData().get(TamedTarantulaEntity.DATA_variant) : "")
            .equals("tarantula5")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }

            if (entity.isVehicle()
               && entity.getFirstPassenger() != null
               && entity.getFirstPassenger() instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 10, 0, false, false));
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.3);
         }

         if (entity.isVehicle() && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            ArphexMod.queueServerWork(15, () -> {
               if (entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var2) {
                     var2.printStackTrace();
                  }
               }
            });
         }

         if (entity.getPersistentData().getDouble("spiderjump") > 0.0) {
            entity.getPersistentData().putDouble("spiderjump", entity.getPersistentData().getDouble("spiderjump") - 1.0);
         }

         if (entity.isShiftKeyDown() && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 1.0, z, 15, 0.1, 0.2, 0.1, 0.1);
         }

         if (!entity.isInWater()
            && (
               (double)world.getBlockState(BlockPos.containing(x, y + 0.5, z)).getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z)) >= 0.3
                  || (double)world.getBlockState(BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") - 0.05, y + 0.5, z))
                        .getDestroySpeed(world, BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") - 0.05, y + 0.5, z))
                     >= 0.3
                  || (double)world.getBlockState(BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") - 0.05), y + 0.5, z))
                        .getDestroySpeed(world, BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") - 0.05), y + 0.5, z))
                     >= 0.3
                  || (double)world.getBlockState(BlockPos.containing(x, y + 0.5, z - (entity.getPersistentData().getDouble("climbradius") - 0.05)))
                        .getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z - (entity.getPersistentData().getDouble("climbradius") - 0.05)))
                     >= 0.3
                  || (double)world.getBlockState(BlockPos.containing(x, y + 0.5, z + entity.getPersistentData().getDouble("climbradius") - 0.05))
                        .getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z + entity.getPersistentData().getDouble("climbradius") - 0.05))
                     >= 0.3
            )
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0, false, false));
         }

         entity.setMaxUpStep(1.0F);
      }
   }
}
