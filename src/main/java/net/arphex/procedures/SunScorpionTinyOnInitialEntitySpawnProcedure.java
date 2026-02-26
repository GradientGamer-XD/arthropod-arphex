package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ScorpionLarvaeEntity;
import net.arphex.entity.ScorpionStrikerEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SunScorpionTinyOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 0.9);
         ArphexMod.queueServerWork(
            2,
            () -> {
               if (!world.getEntitiesOfClass(ScorpionStrikerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                  Entity patt1372$temp = world.getEntitiesOfClass(ScorpionStrikerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if ((patt1372$temp instanceof ScorpionStrikerEntity animatablex ? animatablex.getTexture() : "null").equals("sunscorpion2")
                     && entity instanceof ScorpionLarvaeEntity animatable) {
                     animatable.setTexture("sunscorpion2");
                  }
               } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
                  if (entity instanceof ScorpionLarvaeEntity animatable) {
                     animatable.setTexture("sunscorpion2");
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 99999, 0, false, false));
                  }
               }
            }
         );
      }
   }
}
