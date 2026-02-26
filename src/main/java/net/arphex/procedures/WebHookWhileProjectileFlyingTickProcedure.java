package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WebHookWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ROPE_WEB.get(), x, y, z, 30, 0.03, 0.03, 0.03, 0.05);
      }

      ArphexMod.queueServerWork(
         20,
         () -> {
            if (world instanceof ServerLevel _levelx) {
               _levelx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null)
                        .withSuppressedOutput(),
                     "execute at @p run kill @e[type=arphex:projectile_power_hook,distance=..4]"
                  );
            }
         }
      );
   }
}
