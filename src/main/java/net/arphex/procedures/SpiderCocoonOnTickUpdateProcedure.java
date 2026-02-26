package net.arphex.procedures;

import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderCocoonOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
         && !ArphexModVariables.MapVariables.get(world).matlarave_spawncap_exceeded_toggle
         && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
         && world instanceof ServerLevel _level) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH_LARVAE.get())
            .spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
         }
      }
   }
}
