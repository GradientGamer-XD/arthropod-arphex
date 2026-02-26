package net.arphex.potion;

import net.arphex.procedures.VoidlasherChaosControlOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class VoidlasherChaosControlMobEffect extends MobEffect {
   public VoidlasherChaosControlMobEffect() {
      super(MobEffectCategory.HARMFUL, -13426381);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      VoidlasherChaosControlOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
