package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TormentorLarvaeEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorLarvaeOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.isClientSide() && entity instanceof TormentorLarvaeEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(TormentorLarvaeEntity.DATA_sizevar, Mth.nextInt(RandomSource.create(), 10, 50));
         }

         if (!(ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0)
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
            entity.getPersistentData().putBoolean("spawnedbyplayer", true);
            Entity var9 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (var9 instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Marked larvae as spawned by player"), true);
            }
         }
      }
   }
}
