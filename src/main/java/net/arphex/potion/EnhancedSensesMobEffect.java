package net.arphex.potion;

import net.arphex.procedures.EnhancedSensesOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EnhancedSensesMobEffect extends MobEffect {
   public EnhancedSensesMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -7803406);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      EnhancedSensesOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
