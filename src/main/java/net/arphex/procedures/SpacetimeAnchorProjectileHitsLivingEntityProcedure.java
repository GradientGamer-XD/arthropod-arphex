package net.arphex.procedures;

import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SpacetimeAnchorProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         if (entity != sourceentity || immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SUPERGRAVITY.get(), 600, 0, false, true));
            }

            if (entity instanceof Player) {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                  (float)((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) * 1.5)
               );
            } else if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")) {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                  (float)((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) * 0.25)
               );
            } else {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                  (float)((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) * 0.25)
               );
            }
         }

         if (entity instanceof ArachnoidTrisectorEntity && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
