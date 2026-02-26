package net.arphex.procedures;

import net.arphex.entity.HornetHarbingerEntity;
import net.arphex.entity.HornetHarbingerGiantEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HornetTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            entity.setShiftKeyDown(false);
            if (world.isEmptyBlock(BlockPos.containing(x + 0.5, y, z))
               && world.isEmptyBlock(BlockPos.containing(x - 0.5, y, z))
               && world.isEmptyBlock(BlockPos.containing(x, y, z + 0.5))
               && world.isEmptyBlock(BlockPos.containing(x, y, z - 0.5))) {
               entity.setSprinting(false);
            } else if (!(entity.getDeltaMovement().x() < 0.1) && !(entity.getDeltaMovement().z() < 0.1)) {
               entity.setSprinting(true);
            } else {
               entity.setSprinting(false);
            }
         } else {
            entity.setShiftKeyDown(true);
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
               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 40));
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
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        0.3,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
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
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               }
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("flywalk") < 150.0) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() / 8.0, -0.4, entity.getDeltaMovement().z() / 8.0));
         }

         if (entity.isInWater()) {
            entity.setDeltaMovement(
               new Vec3(entity.getDeltaMovement().x() / 8.0, Mth.nextDouble(RandomSource.create(), 0.3, 0.8), entity.getDeltaMovement().z() / 8.0)
            );
         }

         if (entity instanceof HornetHarbingerEntity
            && entity instanceof HornetHarbingerEntity _datEntL59
            && (Boolean)_datEntL59.getEntityData().get(HornetHarbingerEntity.DATA_shiny)
            && entity instanceof HornetHarbingerEntity animatable) {
            animatable.setTexture("emerald_mob");
         }
      }
   }
}
