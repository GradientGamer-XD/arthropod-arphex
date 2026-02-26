package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothSummonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SummonLarvaeTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ArphexMod.queueServerWork(400, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (entity.getPersistentData().getDouble("rushtime") > 0.0) {
            entity.getPersistentData().putDouble("rushtime", entity.getPersistentData().getDouble("rushtime") - 1.0);
         } else {
            entity.getPersistentData().putDouble("rushtime", 300.0);
         }

         if (entity instanceof Mob _entity) {
            Entity var12 = world.getEntitiesOfClass(SpiderMothSummonEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
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

         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 4.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 5.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 6.0, z))) {
            entity.setSprinting(true);
         } else {
            entity.setSprinting(false);
         }

         if (!entity.getPersistentData().getBoolean("despawnedrider")) {
            entity.getPersistentData().putBoolean("despawnedrider", true);
            if (entity.isVehicle() && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }
         }
      }
   }
}
