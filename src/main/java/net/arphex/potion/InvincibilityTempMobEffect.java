package net.arphex.potion;

import net.arphex.procedures.InvincibilityTempOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class InvincibilityTempMobEffect extends MobEffect {
   public InvincibilityTempMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -65536);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      InvincibilityTempOnEffectActiveTickProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
