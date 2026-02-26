package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class VoidlasherChaosControlOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.NECROSIS.get(), 5, 0, false, false));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 0, false, false));
         }

         if (!(entity.getPersistentData().getDouble("voidlashtime") > 0.0)) {
            entity.getPersistentData().putDouble("voidlashtime", (double)Mth.nextInt(RandomSource.create(), 10, 60));
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FLY_INTO_WALL)), 2.0F);
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) >= 15.0F) {
               entity.setDeltaMovement(
                  new Vec3(
                     (double)(
                        (float)Mth.nextInt(RandomSource.create(), -2, 2)
                           / ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) / 20.0F)
                     ),
                     (double)(
                        (float)Mth.nextInt(RandomSource.create(), -2, 2)
                           / ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 25.0F)
                     ),
                     (double)(
                        (float)Mth.nextInt(RandomSource.create(), -2, 2)
                           / ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 25.0F)
                     )
                  )
               );
            } else {
               entity.setDeltaMovement(
                  new Vec3(
                     (double)Mth.nextInt(RandomSource.create(), -2, 2),
                     (double)Mth.nextInt(RandomSource.create(), -2, 2),
                     (double)Mth.nextInt(RandomSource.create(), -2, 2)
                  )
               );
            }
         } else {
            entity.getPersistentData().putDouble("voidlashtime", entity.getPersistentData().getDouble("voidlashtime") - 1.0);
         }

         if (entity.getPersistentData().getDouble("tornadoparticle") <= 0.0) {
            entity.getPersistentData().putDouble("tornadoparticle", 360.0);
         } else {
            entity.getPersistentData().putDouble("tornadoparticle", entity.getPersistentData().getDouble("tornadoparticle") - 40.0);
         }

         if (entity.getPersistentData().getDouble("tornadoparticley") < 0.2) {
            entity.getPersistentData().putBoolean("tornidoydir", true);
         } else if (entity.getPersistentData().getDouble("tornadoparticley") > 2.0) {
            entity.getPersistentData().putBoolean("tornidoydir", false);
         }

         if (entity.getPersistentData().getBoolean("tornidoydir")) {
            entity.getPersistentData().putDouble("tornadoparticley", entity.getPersistentData().getDouble("tornadoparticley") + 0.2);
         } else {
            entity.getPersistentData().putDouble("tornadoparticley", entity.getPersistentData().getDouble("tornadoparticley") - 0.2);
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "execute as @e[limit=1,sort=nearest] at @s rotated "
                     + entity.getPersistentData().getDouble("tornadoparticle")
                     + " 3 as @e[limit=1,sort=nearest] run particle arphex:scorch_flame ^ ^"
                     + entity.getPersistentData().getDouble("tornadoparticley")
                     + " ^1.5"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 2, 0.4, 0.4, 0.4, 1.0);
         }
      }
   }
}
