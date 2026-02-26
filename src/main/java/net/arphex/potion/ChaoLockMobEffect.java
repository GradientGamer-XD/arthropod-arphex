package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ChaoLockMobEffect extends MobEffect {
   public ChaoLockMobEffect() {
      super(MobEffectCategory.HARMFUL, -13434829);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
