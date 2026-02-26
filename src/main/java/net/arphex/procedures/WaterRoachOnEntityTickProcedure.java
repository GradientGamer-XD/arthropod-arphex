package net.arphex.procedures;

import net.arphex.entity.RoachRiverspawnEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class WaterRoachOnEntityTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphexclimber", true);
         if (Mth.nextInt(RandomSource.create(), 1, 5000) == 5 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 200, 0, false, false));
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
            entity.setSprinting(true);
         } else {
            entity.setSprinting(false);
         }

         if (entity instanceof RoachRiverspawnEntity _datEntL6
            && (Boolean)_datEntL6.getEntityData().get(RoachRiverspawnEntity.DATA_shiny)
            && entity instanceof RoachRiverspawnEntity animatable) {
            animatable.setTexture("platinum_mob");
         }
      }
   }
}
