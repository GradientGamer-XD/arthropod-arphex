package net.arphex.procedures;

import java.util.Comparator;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InvisibleDetectorBlockOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30.0), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator instanceof Player && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
            if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
               if (entityiterator instanceof Player) {
                  Player _player = (Player)entityiterator;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("The Tormentor beckons... It slowly warps your mind, demanding an Abyssal Crystal"), true);
                  }
               }
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (entityiterator instanceof Player) {
                  Player _player = (Player)entityiterator;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("You must give the Tormentor an Abyssal Crystal..."), true);
                  }
               }
            } else if (entityiterator instanceof Player) {
               Player _player = (Player)entityiterator;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Just throw an Abyssal Crystal down into the void..."), true);
               }
            }
         }
      }
   }
}
