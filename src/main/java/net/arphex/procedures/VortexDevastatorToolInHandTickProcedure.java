package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class VortexDevastatorToolInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean entity_found = false;
         double raytrace_distance = 0.0;
         double Radius = 0.0;
         double loop = 0.0;
         double particleSpeed = 0.0;
         double particleAmount = 0.0;
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            entity.fallDistance = 0.0F;
         }

         label46:
         if (entity.isShiftKeyDown()) {
            if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect((MobEffect)ArphexModMobEffects.VORTEX_COOLDOWN.get())) {
               break label46;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.BLOCKING_EFFECT.get(), 5, 0, false, false));
            }

            entity.getPersistentData().putDouble("pitchadjustment", Math.sin((double)entity.getXRot()) * 0.5);
            entity.getPersistentData().putDouble("pitchfactor", Math.cos((double)entity.getXRot()));
            entity.getPersistentData()
               .putDouble("normalisedx", entity.getLookAngle().x / Math.sqrt(Math.pow(entity.getLookAngle().x, 2.0) + Math.pow(entity.getLookAngle().z, 2.0)));
            entity.getPersistentData()
               .putDouble("normalisedz", entity.getLookAngle().z / Math.sqrt(Math.pow(entity.getLookAngle().x, 2.0) + Math.pow(entity.getLookAngle().z, 2.0)));
            loop = 0.0;
            particleAmount = 24.0;
            Radius = 0.75;
            particleSpeed = -0.25;
            entity.getPersistentData().putDouble("angle", (Math.PI * 2) / particleAmount * loop);
            entity.getPersistentData()
               .putDouble("offsetx", Math.cos((double)entity.getYRot()) * Math.cos(entity.getPersistentData().getDouble("angle")) * Radius);
            entity.getPersistentData().putDouble("offsety", Math.sin((double)entity.getXRot()) * Radius);
            entity.getPersistentData()
               .putDouble("offsetz", Math.sin((double)entity.getYRot()) * Math.cos(entity.getPersistentData().getDouble("angle")) * Radius);

            while (loop < particleAmount) {
               world.addParticle(
                  (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
                  x
                     + 0.25 * entity.getPersistentData().getDouble("normalisedx")
                     - 0.1 * entity.getPersistentData().getDouble("normalisedz")
                     + 0.75 * entity.getPersistentData().getDouble("normalisedx")
                     - Math.cos((Math.PI * 2) / particleAmount * loop) * Radius * entity.getPersistentData().getDouble("normalisedz"),
                  y + 1.15 + Math.sin((Math.PI * 2) / particleAmount * loop) * Radius,
                  z
                     + 0.25 * entity.getPersistentData().getDouble("normalisedz")
                     + 0.1 * entity.getPersistentData().getDouble("normalisedx")
                     + 0.75 * entity.getPersistentData().getDouble("normalisedz")
                     + Math.cos((Math.PI * 2) / particleAmount * loop) * Radius * entity.getPersistentData().getDouble("normalisedx"),
                  0.0 - Math.cos((Math.PI * 2) / particleAmount * loop) * particleSpeed * entity.getLookAngle().z,
                  Math.sin((Math.PI * 2) / particleAmount * loop) * particleSpeed,
                  0.0 + Math.cos((Math.PI * 2) / particleAmount * loop) * particleSpeed * entity.getLookAngle().x
               );
               loop++;
            }
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:vortex_devastator_obtain"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }
      }
   }
}
