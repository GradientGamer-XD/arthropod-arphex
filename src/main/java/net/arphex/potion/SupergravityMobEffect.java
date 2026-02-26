package net.arphex.potion;

import net.arphex.procedures.SupergravityEffectStartedappliedProcedure;
import net.arphex.procedures.SupergravityOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class SupergravityMobEffect extends MobEffect {
   public SupergravityMobEffect() {
      super(MobEffectCategory.HARMFUL, -7846400);
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      SupergravityEffectStartedappliedProcedure.execute(entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      SupergravityOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
