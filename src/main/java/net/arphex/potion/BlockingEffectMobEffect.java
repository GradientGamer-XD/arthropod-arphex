package net.arphex.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class BlockingEffectMobEffect extends MobEffect {
   public BlockingEffectMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -14874592);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
