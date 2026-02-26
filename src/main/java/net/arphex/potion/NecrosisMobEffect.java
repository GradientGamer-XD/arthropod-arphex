package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NecrosisMobEffect extends MobEffect {
   public NecrosisMobEffect() {
      super(MobEffectCategory.HARMFUL, -15069425);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
