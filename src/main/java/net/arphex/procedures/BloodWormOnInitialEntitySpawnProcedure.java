package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistEntity;
import net.arphex.entity.BeetleTickMiteEntity;
import net.arphex.entity.BloodWormEntity;
import net.arphex.entity.LocustLandscourgeEntity;
import net.arphex.entity.RoachRiverspawnEntity;
import net.arphex.entity.SilverfishSpectreEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class BloodWormOnInitialEntitySpawnProcedure {
   @SubscribeEvent
   public static void onEntitySpawned(EntityJoinLevelEvent event) {
      execute(event, event.getLevel(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute(null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof LocustLandscourgeEntity) {
            entity.getPersistentData().putDouble("randomsize", Mth.nextDouble(RandomSource.create(), 0.6, 1.7));
            entity.getPersistentData().putDouble("flyboost", 1.0);
            entity.getPersistentData().putDouble("flywalk", 1.0);
         }

         if (entity instanceof SilverfishSpectreEntity) {
            entity.getPersistentData().putDouble("randomsize", Mth.nextDouble(RandomSource.create(), 0.6, 1.7));
         }

         if (entity instanceof BloodWormEntity || entity instanceof AntArsonistEntity) {
            entity.getPersistentData().putDouble("randomsize", Mth.nextDouble(RandomSource.create(), 0.3, 1.5));
         }

         if (entity instanceof BloodWormEntity && Mth.nextInt(RandomSource.create(), 1, 2) == 2 && entity instanceof BloodWormEntity animatable) {
            animatable.setTexture("bloodworm2");
         }

         if (entity instanceof AntArsonistEntity) {
            if (ArphexModVariables.MapVariables.get(world).gem_mob_challenge) {
               ArphexMod.queueServerWork(2, () -> {
                  if (Mth.nextInt(RandomSource.create(), 1, 500) == 4 && entity instanceof AntArsonistEntity animatable) {
                     animatable.setTexture("ruby_mob");
                  }
               });
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1 && entity instanceof AntArsonistEntity animatable) {
               animatable.setTexture("antfire");
            }
         }

         if (entity instanceof RoachRiverspawnEntity) {
            entity.getPersistentData().putDouble("randomsize", Mth.nextDouble(RandomSource.create(), 0.3, 0.9));
            if (ArphexModVariables.MapVariables.get(world).gem_mob_challenge) {
               ArphexMod.queueServerWork(2, () -> {
                  if (Mth.nextInt(RandomSource.create(), 1, 350) == 4 && entity instanceof RoachRiverspawnEntity animatable) {
                     animatable.setTexture("platinum_mob");
                  }
               });
            }

            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (entity instanceof RoachRiverspawnEntity animatable) {
                  animatable.setTexture("waterroach2noclaws");
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (entity instanceof RoachRiverspawnEntity animatable) {
                     animatable.setTexture("waterroach2");
                  }
               } else if (entity instanceof RoachRiverspawnEntity animatable) {
                  animatable.setTexture("waterroach");
               }
            }
         }

         if (entity instanceof BeetleTickMiteEntity && Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (entity instanceof BeetleTickMiteEntity animatable) {
                  animatable.setTexture("beetletickmiteb");
               }
            } else if (entity instanceof BeetleTickMiteEntity animatable) {
               animatable.setTexture("beetletickmitem");
            }
         }

         if (entity instanceof BloodWormEntity) {
            entity.getPersistentData().putDouble("climbradius", 1.0);
         }

         if (entity instanceof RoachRiverspawnEntity) {
            entity.getPersistentData().putDouble("climbradius", 0.9);
         }

         if (entity instanceof AntArsonistEntity) {
            entity.getPersistentData().putDouble("climbradius", 0.5);
         }

         if (entity instanceof SilverfishSpectreEntity) {
            entity.getPersistentData().putDouble("climbradius", 0.7);
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, false, false));
         }
      }
   }
}
