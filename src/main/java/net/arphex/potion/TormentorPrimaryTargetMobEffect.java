package net.arphex.potion;

import net.arphex.procedures.TormentorPrimaryTargetOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class TormentorPrimaryTargetMobEffect extends MobEffect {
   public TormentorPrimaryTargetMobEffect() {
      super(MobEffectCategory.HARMFUL, -16777216);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      TormentorPrimaryTargetOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
