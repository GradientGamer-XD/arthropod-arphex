package net.arphex.potion;

import net.arphex.procedures.ParalysisOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ParalysisMobEffect extends MobEffect {
   public ParalysisMobEffect() {
      super(MobEffectCategory.HARMFUL, -9097168);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      ParalysisOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, (double)amplifier);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
