package net.arphex.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class AntArsonistWorkerEntityIsHurtProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.isInWall() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false));
         }
      }
   }
}
