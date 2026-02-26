package net.arphex.procedures;

import net.arphex.init.ArphexModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class BaneBlossomMobplayerCollidesWithPlantProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == ArphexModBlocks.BANE_BLOSSOM.get()
            && world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getBlock() == ArphexModBlocks.BANE_BLOSSOM.get()
            && world.getBlockState(BlockPos.containing(x, y + 3.0, z)).getBlock() == ArphexModBlocks.BANE_BLOSSOM.get()
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 1));
         }
      }
   }
}
