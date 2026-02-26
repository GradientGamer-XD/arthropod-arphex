package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.SpiderLungerEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SpiderLungerOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (entity instanceof SpiderLungerEntity animatable) {
                  animatable.setTexture("gianthuntsman2");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
               if (entity instanceof SpiderLungerEntity animatable) {
                  animatable.setTexture("gianthuntsman4");
               }
            } else if (entity instanceof SpiderLungerEntity animatable) {
               animatable.setTexture("gianthuntsman3");
            }
         }

         ArphexMod.queueServerWork(20, () -> {
            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.INVISIBILITY);
            }
         });
      }
   }
}
