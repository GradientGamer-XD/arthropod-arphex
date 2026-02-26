package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SeismicPulsePlayerFinishedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean _setval = true;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.slam_power_unlocked = _setval;
            capability.syncPlayerVariables(entity);
         });
         double _setvalx = 0.0;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.power_slam_cooldown = _setval;
            capability.syncPlayerVariables(entity);
         });
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ABYSS_DESTRUCTION.get(), x, y, z, 150, 0.5, 0.5, 0.5, 0.3);
         }

         ArphexMod.queueServerWork(20, () -> {
            boolean _setvalxx = true;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.slam_power_unlocked = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ABYSS_DESTRUCTION.get(), x, y, z, 150, 0.5, 0.5, 0.5, 0.3);
            }

            ArphexMod.queueServerWork(20, () -> {
               boolean _setvalx = true;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.slam_power_unlocked = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.ABYSS_DESTRUCTION.get(), x, y, z, 150, 0.5, 0.5, 0.5, 0.3);
               }
            });
         });
         if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("§cSEISMIC PULSE INHERENT POWER UNLOCKED PERMANENTLY!"), true);
         }
      }
   }
}
