package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ForceGauntletRightclickedProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("usinggauntlet", true);
         if ((!(entity instanceof LivingEntity _livEnt1) || !_livEnt1.hasEffect((MobEffect)ArphexModMobEffects.BLOCKING_EFFECT.get()))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.BLOCKING_EFFECT.get(), 15, 0, false, false));
         }
      }
   }
}
