package net.arphex.potion;

import net.arphex.procedures.MothCurseEffectStartedappliedProcedure;
import net.arphex.procedures.MothCurseOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class MothCurseMobEffect extends MobEffect {
   public MothCurseMobEffect() {
      super(MobEffectCategory.HARMFUL, -13434880);
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      MothCurseEffectStartedappliedProcedure.execute(entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      MothCurseOnEffectActiveTickProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
