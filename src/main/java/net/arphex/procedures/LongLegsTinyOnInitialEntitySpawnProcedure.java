package net.arphex.procedures;

import net.arphex.entity.LongLegsTinyEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LongLegsTinyOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
            if (entity instanceof LongLegsTinyEntity animatable) {
               animatable.setTexture("longlegsmap");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 99999, 0, false, false));
            }
         }

         entity.getPersistentData().putDouble("climbradius", 0.7);
      }
   }
}
