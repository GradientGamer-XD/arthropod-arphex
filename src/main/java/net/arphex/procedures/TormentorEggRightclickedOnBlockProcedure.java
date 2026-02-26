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

public class TormentorEggRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ArphexModVariables.MapVariables.get(world).tormentor_health = 1024.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).tormentor_tier = 1.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (entity.getPersistentData().getBoolean("creativespectator")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§cSPAWNED TORMENTOR AT §bTIER 1 §f(you can use /arphex set_tormentor_tier)"), false);
            }
         } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§cSPAWNED TORMENTOR AT §bTIER 1"), false);
         }

         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR.get()).spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
            }
         }

         ArphexModVariables.MapVariables.get(world).tormentor_x = x;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).tormentor_y = y;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).tormentor_z = z;
         ArphexModVariables.MapVariables.get(world).syncData(world);
      }
   }
}
