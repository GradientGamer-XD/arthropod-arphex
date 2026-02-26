package net.arphex.procedures;

import java.util.Comparator;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class EntropyConduitOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator instanceof Player && !entityiterator.getPersistentData().getBoolean("creativespectator") && entityiterator instanceof Player) {
            Player _player = (Player)entityiterator;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§cIt is trying to heal with pylons - destroy them before it gets the chance!"), true);
            }
         }
      }
   }
}
