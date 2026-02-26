package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class TormentedMobEffect extends MobEffect {
   public TormentedMobEffect() {
      super(MobEffectCategory.HARMFUL, -8621226);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
