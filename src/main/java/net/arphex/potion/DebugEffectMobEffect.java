package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DebugEffectMobEffect extends MobEffect {
   public DebugEffectMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
