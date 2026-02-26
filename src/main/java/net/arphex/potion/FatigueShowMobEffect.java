package net.arphex.potion;

import net.arphex.procedures.ShowOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FatigueShowMobEffect extends MobEffect {
   public FatigueShowMobEffect() {
      super(MobEffectCategory.NEUTRAL, -13421773);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      ShowOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
