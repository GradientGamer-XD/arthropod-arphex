package net.arphex.procedures;

import net.arphex.entity.SpiderGoliathEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SpiderGoliathOnInitialEntitySpawnProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, -1, 0));
         }

         if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (entity instanceof SpiderGoliathEntity animatable) {
               animatable.setTexture("tarantula1");
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (entity instanceof SpiderGoliathEntity animatable) {
               animatable.setTexture("tarantula2");
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (entity instanceof SpiderGoliathEntity animatable) {
               animatable.setTexture("tarantula3");
            }
         } else if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (entity instanceof SpiderGoliathEntity animatable) {
                  animatable.setTexture("tarantula5");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
               if (entity instanceof SpiderGoliathEntity animatable) {
                  animatable.setTexture("tarantula6");
               }
            } else if (entity instanceof SpiderGoliathEntity animatable) {
               animatable.setTexture("tarantula7");
            }
         } else if (entity instanceof SpiderGoliathEntity animatable) {
            animatable.setTexture("tarantula4");
         }

         entity.getPersistentData().putDouble("climbradius", 1.5);
      }
   }
}
