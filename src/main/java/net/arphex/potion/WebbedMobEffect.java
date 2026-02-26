package net.arphex.potion;

import net.arphex.procedures.WebbedOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WebbedMobEffect extends MobEffect {
   public WebbedMobEffect() {
      super(MobEffectCategory.HARMFUL, -3355444);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      WebbedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
