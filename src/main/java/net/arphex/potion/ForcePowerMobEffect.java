package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ForcePowerMobEffect extends MobEffect {
   public ForcePowerMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -10066330);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
