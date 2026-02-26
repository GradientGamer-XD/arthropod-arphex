package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MillipedeTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getDeltaMovement().x() < 0.01 && entity.getDeltaMovement().z() < 0.01) {
            entity.setShiftKeyDown(false);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 1, false, false));
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 3, 0.3, 0.2, 0.3, 0.1);
            }
         } else {
            entity.setShiftKeyDown(true);
         }

         entity.setMaxUpStep(1.0F);
         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
            && entity.getDisplayName().getString().equals("")
            && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
