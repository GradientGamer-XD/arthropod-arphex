package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class EternalEvasionMobEffect extends MobEffect {
   public EternalEvasionMobEffect() {
      super(MobEffectCategory.NEUTRAL, -2385613);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
