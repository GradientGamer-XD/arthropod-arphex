package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TormentorBurningOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("tormentburntime", entity.getPersistentData().getDouble("tormentburntime") + 1.0);
         if (entity instanceof Player) {
            double _setval = 5.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.time_in_portal = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         entity.setSecondsOnFire(1);
         if (entity.getPersistentData().getDouble("tormentburntime") > 30.0) {
            if (!(entity.getPersistentData().getDouble("tormentburn") > 0.0)) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 1, 0.5, 0.5, 0.5, 0.5);
               }

               if ((float)(400 / (((entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 4) / 4))
                  > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 10.0F) {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                     (float)(400 / (((entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 4) / 4))
                  );
               } else {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                     (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 10.0F
                  );
               }

               entity.getPersistentData().putDouble("tormentburn", 10.0);
            } else {
               entity.getPersistentData().putDouble("tormentburn", entity.getPersistentData().getDouble("tormentburn") - 1.0);
            }
         }
      }
   }
}
