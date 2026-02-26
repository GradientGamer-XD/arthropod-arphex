package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.GiantWebEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderSnatcherEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderLarvaeOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getEntitiesOfClass(SpiderSnatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(GiantWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            if (Mth.nextInt(RandomSource.create(), 1, 6) == 3) {
               entity.getPersistentData().putString("spidershade", "2");
               if (entity instanceof SpiderLarvaeEntity animatable) {
                  animatable.setTexture("spiderlarvae2");
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 6) == 2) {
               entity.getPersistentData().putString("spidershade", "3");
               if (entity instanceof SpiderLarvaeEntity animatable) {
                  animatable.setTexture("spiderlarvae3");
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 60) == 1) {
               entity.getPersistentData().putString("spidershade", "4");
               if (entity instanceof SpiderLarvaeEntity animatable) {
                  animatable.setTexture("spiderlarvae4");
               }
            }

            if (Mth.nextInt(RandomSource.create(), 1, 6) == 4) {
               entity.getPersistentData().putString("spidershade", "5");
               if (entity instanceof SpiderLarvaeEntity animatable) {
                  animatable.setTexture("spiderlarvae5");
               }
            }
         } else {
            if (entity instanceof SpiderLarvaeEntity animatable) {
               animatable.setTexture("spiderwidow");
            }

            entity.getPersistentData().putString("spidershade", "widow");
            if (entity instanceof Mob _entity) {
               Entity var12 = world.getEntitiesOfClass(SpiderSnatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
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
         }

         entity.getPersistentData().putDouble("climbradius", 0.8);
         if (ArphexModVariables.MapVariables.get(world).gem_mob_challenge) {
            ArphexMod.queueServerWork(2, () -> {
               if (Mth.nextInt(RandomSource.create(), 1, 1000) == 4 && entity instanceof SpiderLarvaeEntity animatablex) {
                  animatablex.setTexture("golden_mob");
               }
            });
         }
      }
   }
}
