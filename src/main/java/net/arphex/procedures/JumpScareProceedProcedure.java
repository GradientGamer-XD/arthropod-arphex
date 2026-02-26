package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class JumpScareProceedProcedure {
   public static Entity execute(LevelAccessor world, double x, double y, double z) {
      Entity nearest_moth = null;
      nearest_moth = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true)
         .stream()
         .sorted((new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
            }
         }).compareDistOf(x, y, z))
         .findFirst()
         .orElse(null);
      if (nearest_moth != null) {
         return nearest_moth;
      } else {
         return world instanceof Level _level ? new SpiderMothEntity((EntityType<SpiderMothEntity>)ArphexModEntities.SPIDER_MOTH.get(), _level) : null;
      }
   }
}
