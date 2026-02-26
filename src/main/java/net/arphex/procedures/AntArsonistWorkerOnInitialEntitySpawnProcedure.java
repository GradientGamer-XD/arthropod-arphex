package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AntArsonistWorkerOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
            Entity _datEntSetL = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (_datEntSetL instanceof TamableAnimal _tamEnt && _tamEnt.isTame() && entity instanceof AntArsonistWorkerEntity _datEntSetLx) {
               _datEntSetLx.getEntityData().set(AntArsonistWorkerEntity.DATA_larvae, true);
            }
         }
      }
   }
}
