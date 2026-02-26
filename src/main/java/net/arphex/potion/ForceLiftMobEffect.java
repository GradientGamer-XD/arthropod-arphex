package net.arphex.potion;

import net.arphex.procedures.ForceLiftActiveTickConditionProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ForceLiftMobEffect extends MobEffect {
   public ForceLiftMobEffect() {
      super(MobEffectCategory.HARMFUL, -10092442);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      ForceLiftActiveTickConditionProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
