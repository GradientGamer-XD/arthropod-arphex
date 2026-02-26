package net.arphex.potion;

import net.arphex.procedures.TormentOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class TormentMobEffect extends MobEffect {
   public TormentMobEffect() {
      super(MobEffectCategory.HARMFUL, -11253187);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      TormentOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, (double)amplifier);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
