package net.arphex.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AscendedCubePlayerStartsToDestroyProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.getStringUUID().equals((new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         }).getValue(world, BlockPos.containing(x, y, z), "ascendedowner")) && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1200, 2, false, false));
         }
      }
   }
}
