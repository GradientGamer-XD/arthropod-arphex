package net.arphex.procedures;

import java.util.Comparator;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorScorpioidSummonOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("tormentor_summon", true);
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).isEmpty()) {
            entity.getPersistentData().putBoolean("spawned_by_player_summon", true);
            Entity var9 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (var9 instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Marked as spawned by player"), true);
            }
         }
      }
   }
}
