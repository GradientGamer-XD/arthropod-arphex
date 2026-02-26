package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ArachnoidTimeCloneOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity nearest_trisector = null;
         nearest_trisector = world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (nearest_trisector != null) {
            entity.getPersistentData()
               .putDouble("trisector_past_health", nearest_trisector instanceof LivingEntity _livEnt ? (double)_livEnt.getHealth() : -1.0);
            if (!world.isClientSide()) {
               entity.setYRot(nearest_trisector.getYRot());
               entity.setXRot(0.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }
         }
      }
   }
}
