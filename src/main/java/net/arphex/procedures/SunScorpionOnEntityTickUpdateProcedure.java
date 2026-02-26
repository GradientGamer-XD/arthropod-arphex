package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.LongLegsEntity;
import net.arphex.entity.LongLegsTinyEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SunScorpionOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphexclimber", true);
         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.6, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 1.6, z))) {
            entity.setSprinting(true);
         } else {
            entity.setSprinting(false);
         }

         if (entity instanceof LongLegsTinyEntity
            && !world.getEntitiesOfClass(LongLegsEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
            && entity instanceof Mob _entity) {
            Entity var12 = world.getEntitiesOfClass(LongLegsEntity.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((var12 instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _ent) {
               _entity.setTarget(_ent);
            }
         }

         if ((entity instanceof LongLegsEntity || entity instanceof LongLegsTinyEntity)
            && Mth.nextInt(RandomSource.create(), 1, 5000) == 5
            && entity instanceof LivingEntity _entityx
            && !_entityx.level().isClientSide()) {
            _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 200, 0, false, false));
         }
      }
   }
}
