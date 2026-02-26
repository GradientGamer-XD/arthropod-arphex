package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TamedTarantulaEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TamedTarantulaOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 1.3);
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
            && entity instanceof TamableAnimal _toTame) {
            Entity var10 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (var10 instanceof Player _owner) {
               _toTame.tame(_owner);
            }
         }

         if (!entity.getPersistentData().getString("tametype").equals("") && entity instanceof TamedTarantulaEntity animatable) {
            animatable.setTexture(entity.getPersistentData().getString("tametype"));
         }

         ArphexMod.queueServerWork(2, () -> {
            if (!entity.getPersistentData().getString("tametype").equals("") && entity instanceof TamedTarantulaEntity animatablex) {
               animatablex.setTexture(entity.getPersistentData().getString("tametype"));
            }
         });
      }
   }
}
