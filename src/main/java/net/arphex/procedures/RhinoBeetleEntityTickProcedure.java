package net.arphex.procedures;

import net.arphex.entity.BeetleBulwarkEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class RhinoBeetleEntityTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getString("beetlever").equals("scarabb")) {
            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("scarab2");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("lady")) {
            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("beetleladybird");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("rhino")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }

            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("rhinobeetle");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("stag")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
            }

            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("stagbeetle");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabg")) {
            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("scarab1");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabt")) {
            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("scarab4");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabi")) {
            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("iridescentbeetle");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabp")) {
            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("scarab5");
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabgold")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }

            if (entity instanceof BeetleBulwarkEntity animatable) {
               animatable.setTexture("scarab3");
            }
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 5, false, false));
         }

         if (entity.getPersistentData().getDouble("randomfly") > 750.0
            && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
            && entity.getPersistentData().getDouble("flyingsound") == 5.0
            && world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:rhinobeetlefly")),
                  SoundSource.NEUTRAL,
                  0.6F,
                  1.0F
               );
            } else {
               _level.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:rhinobeetlefly")),
                  SoundSource.NEUTRAL,
                  0.6F,
                  1.0F,
                  false
               );
            }
         }

         if (!(entity.getPersistentData().getDouble("flyingsound") > 0.0)) {
            entity.getPersistentData().putDouble("flyingsound", 50.0);
         } else {
            entity.getPersistentData().putDouble("flyingsound", entity.getPersistentData().getDouble("flyingsound") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("randomfly") > 0.0)) {
            entity.getPersistentData().putDouble("randomfly", (double)Mth.nextInt(RandomSource.create(), 700, 1000));
         } else {
            entity.getPersistentData().putDouble("randomfly", entity.getPersistentData().getDouble("randomfly") - 1.0);
         }

         if (entity.getPersistentData().getDouble("randomfly") > 750.0) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 6.0,
                  Mth.nextDouble(RandomSource.create(), -0.2, 0.35),
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 6.0
               )
            );
         }

         entity.setMaxUpStep(1.0F);
         if (!entity.getPersistentData().getBoolean("despawn_skeleton")) {
            if (entity.isVehicle()
               && entity.getFirstPassenger() != null
               && entity.getFirstPassenger() instanceof Skeleton
               && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }

            entity.getPersistentData().putBoolean("despawn_skeleton", true);
         }
      }
   }
}
