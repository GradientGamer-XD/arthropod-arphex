package net.arphex.procedures;

import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class ForceSpawnTormentorProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (ArphexModVariables.MapVariables.get(world).tormentor_health <= 0.0) {
            ArphexModVariables.MapVariables.get(world).tormentor_health = 1024.0;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR.get())
               .spawn(
                  _level,
                  BlockPos.containing(
                     ArphexModVariables.MapVariables.get(world).tormentor_x,
                     ArphexModVariables.MapVariables.get(world).tormentor_y,
                     ArphexModVariables.MapVariables.get(world).tormentor_z
                  ),
                  MobSpawnType.MOB_SUMMONED
               );
            if (entityToSpawn != null) {
               entityToSpawn.setYRot((float)ArphexModVariables.MapVariables.get(world).tormentor_rotation);
               entityToSpawn.setYBodyRot((float)ArphexModVariables.MapVariables.get(world).tormentor_rotation);
               entityToSpawn.setYHeadRot((float)ArphexModVariables.MapVariables.get(world).tormentor_rotation);
            }
         }

         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§aTormentor forcibly spawned at current locked position!"), true);
         }
      }
   }
}
