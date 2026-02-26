package net.arphex.procedures;

import java.util.Comparator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RepelCrucifixProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator != entity && entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entityiterator;
               if (_livEnt1.getMobType() == MobType.UNDEAD) {
                  if (x - entityiterator.getX() > 0.0 && z - entityiterator.getZ() > 0.0) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           (0.0 - (x - entityiterator.getX()))
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5),
                           0.3,
                           (0.0 - (z - entityiterator.getZ()))
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F))) / 1.5)
                        )
                     );
                  } else if (x - entityiterator.getX() < 0.0 && z - entityiterator.getZ() < 0.0) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           Math.abs(x - entityiterator.getX())
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5),
                           0.3,
                           Math.abs(z - entityiterator.getZ())
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F))) / 1.5)
                        )
                     );
                  } else if (x - entityiterator.getX() > 0.0 && z - entityiterator.getZ() < 0.0) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           (0.0 - (x - entityiterator.getX()))
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5),
                           0.3,
                           Math.abs(z - entityiterator.getZ())
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F))) / 1.5)
                        )
                     );
                  } else {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           Math.abs(x - entityiterator.getX())
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5),
                           0.3,
                           (0.0 - (z - entityiterator.getZ()))
                              * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F))) / 1.5)
                        )
                     );
                  }
               }
            }
         }
      }
   }
}
