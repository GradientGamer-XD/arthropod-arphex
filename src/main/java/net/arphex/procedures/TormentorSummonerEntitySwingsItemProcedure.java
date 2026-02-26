package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class TormentorSummonerEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.isPassenger()) {
            ArphexMod.queueServerWork(
               1,
               () -> {
                  if ((!(entity instanceof Player _plrCldCheck2) || !_plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))
                     && entity.isPassenger()
                     && entity.getVehicle() instanceof TormentorSummonEntity
                     && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .killedtormentor
                        > 20.0) {
                     if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SUMMON_SUN_BLAST.get())
                           .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }

                     if (entity instanceof Player _player) {
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 200);
                     }
                  }
               }
            );
         }
      }
   }
}
