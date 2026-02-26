package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;

public class AntArsonistWorkerFollowOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
            entity.setCustomName(
               Component.literal(
                  (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getDisplayName().getString() + "'s Fire Ant Worker (following)"
               )
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
         }
      }
   }
}
