package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class VortexCooldownMobEffect extends MobEffect {
   public VortexCooldownMobEffect() {
      super(MobEffectCategory.NEUTRAL, -10092442);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
