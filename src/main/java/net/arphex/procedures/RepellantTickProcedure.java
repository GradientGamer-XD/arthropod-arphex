package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class RepellantTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(entity instanceof LivingEntity _livEnt0) || !_livEnt0.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
            ArphexMod.queueServerWork(
               20,
               () -> {
                  if ((!(entity instanceof LivingEntity _livEnt1) || !_livEnt1.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get()))
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 30, 15.0, 0.3, 15.0, 0.3);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 30, 5.0, 5.0, 5.0, 0.3);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 30, 0.4, 0.4, 0.4, 0.3);
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 1, false, false));
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "effect give @e[type=!player,distance=..30] arphex:repulsion 1 1 false"
               );
         }
      }
   }
}
