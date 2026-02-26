package net.arphex.potion;

import net.arphex.procedures.TimeFreezeEffectExpiresProcedure;
import net.arphex.procedures.TimeFreezeOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class TimeFreezeMobEffect extends MobEffect {
   public TimeFreezeMobEffect() {
      super(MobEffectCategory.HARMFUL, -10027162);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      TimeFreezeOnEffectActiveTickProcedure.execute(entity, (double)amplifier);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      TimeFreezeEffectExpiresProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
