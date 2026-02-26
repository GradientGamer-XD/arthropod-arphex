package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class WebbedArrowProjectileHitsLivingEntityProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if ((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) < entity.getPersistentData().getDouble("momenthealth")) {
            entity.getPersistentData().putDouble("momenthealth", 0.0);
            if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
               int var12;
               label85: {
                  if (entity instanceof LivingEntity _livEntx && _livEntx.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                     var12 = _livEntx.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                     break label85;
                  }

                  var12 = 0;
               }

               if (var12 == 0) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 80, 1, false, false));
                     return;
                  }

                  return;
               } else {
                  label79: {
                     if (entity instanceof LivingEntity _livEntx && _livEntx.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                        var12 = _livEntx.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                        break label79;
                     }

                     var12 = 0;
                  }

                  if (var12 == 1) {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 100, 2, false, false));
                        return;
                     }

                     return;
                  } else {
                     label73: {
                        if (entity instanceof LivingEntity _livEntx && _livEntx.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                           var12 = _livEntx.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                           break label73;
                        }

                        var12 = 0;
                     }

                     if (var12 == 2) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 120, 3, false, false));
                           return;
                        }
                     } else {
                        label67: {
                           if (entity instanceof LivingEntity _livEntx && _livEntx.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())) {
                              var12 = _livEntx.getEffect((MobEffect)ArphexModMobEffects.WEBBED.get()).getAmplifier();
                              break label67;
                           }

                           var12 = 0;
                        }

                        if (var12 >= 3 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 140, 4, false, false));
                           return;
                        }
                     }

                     return;
                  }
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.WEBBED.get(), 60, 0, false, false));
            }
         }
      }
   }
}
