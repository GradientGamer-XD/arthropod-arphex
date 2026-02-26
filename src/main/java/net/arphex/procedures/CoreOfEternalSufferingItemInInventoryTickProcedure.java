package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CoreOfEternalSufferingItemInInventoryTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 50, 0.4, 0.4, 0.4, 0.5);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 0.4, 0.4, 0.4, 0.5);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 0.4, 0.4, 0.4, 0.5);
         }

         entity.setSecondsOnFire(5);
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0, false, false));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0, false, true));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.NECROSIS.get(), 100, 0, false, false));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 0, false, false));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.MOTH_CURSE.get(), 100, 0, false, false));
         }

         if (world.isClientSide()) {
            Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:destroyer"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
            _playerx.displayClientMessage(
               Component.literal(
                  "§c§lYour TORMENTOR level is "
                     + Math.round(
                        ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .killedtormentor
                     )
               ),
               true
            );
         }
      }
   }
}
