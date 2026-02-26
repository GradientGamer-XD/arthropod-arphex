package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentorCaterpillarEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TormentSpiralOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         boolean onemax = false;
         if (!entity.getPersistentData().getBoolean("creativespectator")
            && entity instanceof LivingEntity
            && !entity.getPersistentData().getBoolean("tormentor_summon")
            && !(entity instanceof TORMENTOREntity)
            && entity.getPersistentData().getBoolean("tormentor_target")) {
            if (amplifier > 0.0) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 5, 0.0, 0.0, 0.0, 0.3);
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_REPULSION.get(), 15, 0, false, false));
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 0.0, 0.0, 0.0, 0.3);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.HOSTILE,
                     0.4F,
                     0.5F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.HOSTILE,
                     0.4F,
                     0.5F,
                     false
                  );
               }
            }

            if (entity instanceof Player) {
               double _setval = 10.0;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.shadertime = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }

            onemax = false;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!onemax && entityiterator instanceof TormentorCaterpillarEntity) {
                  onemax = true;
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                     (float)((double)(70 / (((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) + 3) / 16)) * 1.8)
                  );
               }
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) > 200.0F) {
               if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F)
                     - (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 10.0F
                  < (entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)) {
                  if (entity instanceof LivingEntity _entity) {
                     _entity.setHealth(
                        (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getHealth() : -1.0F)
                           - (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) / 10.0F
                     );
                  }
               } else if (((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getArmorValue() : 0) + 3) / 16 != 0) {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                     (float)((double)(40 / (((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getArmorValue() : 0) + 3) / 16)) * 1.8)
                  );
               } else {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                     (float)(25.0 / ((double)((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getArmorValue() : 0) + 3) / 1.2))
                  );
               }
            } else if (((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getArmorValue() : 0) + 3) / 16 != 0) {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                  (float)((double)(40 / (((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getArmorValue() : 0) + 3) / 16)) * 1.9)
               );
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.TORMENT_SPIRAL.get());
         }
      }
   }
}
