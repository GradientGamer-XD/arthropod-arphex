package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class PowerHookHitsEntityProcedure {
   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (sourceentity != entity) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.sin(Math.toRadians((double)(sourceentity.getYRot() + 180.0F))) * 2.0 * -1.2,
                  (Math.sin(Math.toRadians((double)(0.0F - sourceentity.getXRot()))) + 0.5) * 1.8,
                  Math.cos(Math.toRadians((double)sourceentity.getYRot())) * 2.0 * -1.2
               )
            );
            if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
               int var10000;
               label82: {
                  if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                     break label82;
                  }

                  var10000 = 0;
               }

               if (var10000 == 0) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 100, 2, false, false));
                     return;
                  }

                  return;
               } else {
                  label76: {
                     if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                        break label76;
                     }

                     var10000 = 0;
                  }

                  if (var10000 == 1) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 120, 3, false, false));
                        return;
                     }

                     return;
                  } else {
                     label70: {
                        if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                           var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                           break label70;
                        }

                        var10000 = 0;
                     }

                     if (var10000 == 2) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 140, 3, false, false));
                           return;
                        }
                     } else {
                        label64: {
                           if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                              var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                              break label64;
                           }

                           var10000 = 0;
                        }

                        if (var10000 >= 3 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 200, 4, false, false));
                           return;
                        }
                     }

                     return;
                  }
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 80, 1, false, false));
            }
         }
      }
   }
}
