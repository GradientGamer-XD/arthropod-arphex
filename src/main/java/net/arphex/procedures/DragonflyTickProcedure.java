package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.HornetHarbingerGiantEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DragonflyTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.isShiftKeyDown()) {
            entity.setSprinting(false);
            ArphexMod.queueServerWork(20, () -> entity.setShiftKeyDown(false));
         } else {
            label133: {
               if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
                  entity.setSprinting(true);
               } else {
                  entity.setSprinting(false);
               }

               if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  entity.setSprinting(false);
                  break label133;
               }

               entity.setShiftKeyDown(false);
            }
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (!(entity.getPersistentData().getDouble("flywalk") > 1000.0)) {
               entity.getPersistentData()
                  .putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
            } else {
               entity.getPersistentData().putDouble("flywalk", 0.0);
            }
         } else {
            entity.setSprinting(false);
            entity.getPersistentData().putDouble("flywalk", 1000.0);
            if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 20));
               if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (entity instanceof HornetHarbingerGiantEntity && Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof Level _level) {
                     if (!_level.isClientSide()) {
                        _level.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzlong")),
                           SoundSource.HOSTILE,
                           0.4F,
                           (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2)
                        );
                     } else {
                        _level.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzlong")),
                           SoundSource.HOSTILE,
                           0.4F,
                           (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2),
                           false
                        );
                     }
                  }
               } else if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzshort")),
                        SoundSource.HOSTILE,
                        0.4F,
                        (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2)
                     );
                  } else {
                     _levelx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzshort")),
                        SoundSource.HOSTILE,
                        0.4F,
                        (float)Mth.nextDouble(RandomSource.create(), -0.8, 1.2),
                        false
                     );
                  }
               }

               if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 0.5) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0,
                        0.3,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0
                     )
                  );
               } else {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                     )
                  );
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0
                     )
                  );
               }
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("flywalk") < 150.0) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() / 8.0, -0.4, entity.getDeltaMovement().z() / 8.0));
         } else {
            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null && entity.getPersistentData().getDouble("flywalk") == 155.0) {
               if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(x + (double)Mth.nextInt(RandomSource.create(), 20, 40), y, z + (double)Mth.nextInt(RandomSource.create(), 20, 40), 1.0);
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(x + (double)Mth.nextInt(RandomSource.create(), -20, -40), y, z + (double)Mth.nextInt(RandomSource.create(), 20, 40), 1.0);
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(x + (double)Mth.nextInt(RandomSource.create(), -20, -40), y, z + (double)Mth.nextInt(RandomSource.create(), -20, -40), 1.0);
                  }
               } else if (entity instanceof Mob _entity) {
                  _entity.getNavigation()
                     .moveTo(x + (double)Mth.nextInt(RandomSource.create(), 20, 40), y, z + (double)Mth.nextInt(RandomSource.create(), -20, -40), 1.0);
               }
            }

            if (entity.getPersistentData().getDouble("continuousflight") == 2.0) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0,
                     entity.getDeltaMovement().y(),
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0
                  )
               );
            }
         }

         if (entity.isInWater()) {
            ArphexMod.queueServerWork(
               20,
               () -> entity.setDeltaMovement(
                     new Vec3(entity.getDeltaMovement().x() / 8.0, Mth.nextDouble(RandomSource.create(), 0.3, 0.8), entity.getDeltaMovement().z() / 8.0)
                  )
            );
         }

         if (!(entity.getPersistentData().getDouble("continuousflight") > 0.0)) {
            entity.getPersistentData().putDouble("continuousflight", 4.0);
         } else {
            entity.getPersistentData().putDouble("continuousflight", entity.getPersistentData().getDouble("continuousflight") - 1.0);
         }
      }
   }
}
