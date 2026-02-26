package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WebHarnessDownSpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5.0, 5.0, 5.0), e -> true).isEmpty()) {
            world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5.0, 5.0, 5.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).startRiding(entity);
            ArphexMod.queueServerWork(
               50,
               () -> {
                  if (entity.isVehicle() && entity.getControllingPassenger() instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal("Grappling hook hanging mode - You can move around and use spacebar to rappel upwards. Shift to dismount."), false
                     );
                  }
               }
            );
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

         entity.getPersistentData().putDouble("targetX", entity.getX());
         entity.getPersistentData().putDouble("targetY", entity.getY());
         entity.getPersistentData().putDouble("targetZ", entity.getZ());
      }
   }
}
