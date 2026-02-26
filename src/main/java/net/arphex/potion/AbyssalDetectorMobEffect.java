package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class AbyssalDetectorMobEffect extends MobEffect {
   public AbyssalDetectorMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -6750208);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
