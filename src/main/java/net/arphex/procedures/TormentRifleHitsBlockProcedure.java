package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentRifleHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double tier_scale = 0.0;
         if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_GRIEFING.get() && world instanceof Level _level && !_level.isClientSide()) {
            _level.explode(null, x, y, z, (float)(4.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier), ExplosionInteraction.MOB);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 20, 0.4, 0.4, 0.4, 0.4);
         }

         if (entity instanceof TORMENTOREntity) {
            entity.getPersistentData().putDouble("able_to_harm_self", 5.0);
         }

         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(
               Entity.class, new AABB(_center, _center).inflate((5.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 3.0) / 2.0), e -> true
            )
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player) {
               double _setval = 60.0;
               entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.shadertime = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
            }

            if (entityiterator instanceof LivingEntity && entityiterator != entity) {
               if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.TORMENT.get(), 20, 0, false, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 20, 0.6, 0.7, 0.6, 0.5);
               }

               if (ArphexModVariables.MapVariables.get(world).tormentor_tier > 0.0) {
                  if ((50.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 50.0)
                        / (double)(((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 4) / 4)
                     > (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                        / (20.0 / ArphexModVariables.MapVariables.get(world).tormentor_tier)) {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE)),
                        (float)(
                           (50.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 50.0)
                              / (double)(((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 4) / 4)
                        )
                     );
                  } else {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE)),
                        (float)(
                           (double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                              / (20.0 / ArphexModVariables.MapVariables.get(world).tormentor_tier)
                        )
                     );
                  }

                  entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
               }
            }
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
