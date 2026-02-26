package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.RepellantEntity;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.ScorpioidCloneEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RepulsionActiveTickConditionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()
            && !(entity instanceof ScorpioidBloodlusterEntity)
            && !(entity instanceof ScorpioidCloneEntity)
            && !entity.getPersistentData().getBoolean("creativespectator")) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos(
                        (double)(
                              world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getYRot()
                                 + 90.0F
                           )
                           * (Math.PI / 180.0)
                     )
                     / 4.0,
                  0.2,
                  Math.sin(
                        (double)(
                              world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getYRot()
                                 + 90.0F
                           )
                           * (Math.PI / 180.0)
                     )
                     / 4.0
               )
            );
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 2.0F) {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
            }
         } else if (!world.getEntitiesOfClass(RepellantEntity.class, AABB.ofSize(new Vec3(x, y, z), 35.0, 35.0, 35.0), e -> true).isEmpty()
            && entity instanceof LivingEntity _livEnt13
            && _livEnt13.getMobType() == MobType.ARTHROPOD) {
            int var10000;
            label199: {
               Entity _livEnt = world.getEntitiesOfClass(RepellantEntity.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (_livEnt instanceof LivingEntity _livEntx && _livEntx.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  var10000 = _livEntx.getEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get()).getDuration();
                  break label199;
               }

               var10000 = 0;
            }

            if (var10000 > 200) {
               if ((!(entity instanceof LivingEntity _livEnt16) || !_livEnt16.hasEffect(MobEffects.WITHER))
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 0, false, false));
               }

               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) > 199.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) > 99.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) > 50.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) > 40.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 3, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) > 30.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 4, false, false));
                  }
               } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 5, false, false));
               }
            } else if (!world.getEntitiesOfClass(RepellantEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()) {
               if ((!(entity instanceof LivingEntity _livEnt30) || !_livEnt30.hasEffect(MobEffects.WITHER))
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 0, false, false));
               }

               if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMaxHealth() : -1.0F) > 199.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F) > 99.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F) > 50.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMaxHealth() : -1.0F) > 40.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 3, false, false));
                  }
               } else if ((entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMaxHealth() : -1.0F) > 30.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 4, false, false));
                  }
               } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 5, false, false));
               }
            }
         }
      }
   }
}
