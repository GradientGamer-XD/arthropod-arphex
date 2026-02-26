package net.arphex.procedures;

import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class TORMENTOREntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 1.0
            && !(ArphexModVariables.MapVariables.get(world).tormentor_hitbox_split > 0.0)
            && (entity instanceof TORMENTOREntity _datEntS ? (String)_datEntS.getEntityData().get(TORMENTOREntity.DATA_tormentcycle) : "").equals("splay")) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_HITBOX.get())
                  .spawn(_level, BlockPos.containing(x + 50.0, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_HITBOX.get())
                  .spawn(_levelx, BlockPos.containing(x - 50.0, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }
         }
      }
   }
}
