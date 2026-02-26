package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class TormentAnnihilatorHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         label126: {
            double killedtormentor_limit = 0.0;
            if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
               break label126;
            }

            double _setval = entity instanceof LivingEntity _entUseTicks2 ? (double)_entUseTicks2.getTicksUsingItem() : 0.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.wrath_charge_time = _setval;
               capability.syncPlayerVariables(entity);
            });
            if ((entity instanceof LivingEntity _entUseTicks3 ? _entUseTicks3.getTicksUsingItem() : 0) > 0) {
               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor
                  > 100.0) {
                  killedtormentor_limit = 100.0;
               } else {
                  killedtormentor_limit = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor;
               }

               if (killedtormentor_limit > (Double)ConfigurationSettingsConfiguration.LIMIT_TORMENTED_WRATH.get()) {
                  killedtormentor_limit = (Double)ConfigurationSettingsConfiguration.LIMIT_TORMENTED_WRATH.get();
               }

               if (Math.floor((double)((entity instanceof LivingEntity _entUseTicks6 ? _entUseTicks6.getTicksUsingItem() : 0) / 20)) > killedtormentor_limit) {
                  double _setvalx = (double)Math.round(Math.floor(killedtormentor_limit) * 20.0);
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.wrath_charge_time = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedtormentor
                     >= 100.0) {
                     if (entity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(
                           Component.literal(
                              "§l§aCHARGED TO MAXIMUM POWER: 100§r (your tormentor level is "
                                 + Math.round(
                                    ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                          .orElse(new ArphexModVariables.PlayerVariables()))
                                       .killedtormentor
                                 )
                                 + ", switch to another item to cancel) "
                           ),
                           true
                        );
                     }
                  } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal(
                           "§l§aCHARGED TO MAXIMUM POWER: "
                              + Math.round(
                                 Math.floor(
                                    ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                          .orElse(new ArphexModVariables.PlayerVariables()))
                                       .killedtormentor
                                 )
                              )
                              + "§r (your tormentor level is "
                              + Math.round(
                                 ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .killedtormentor
                              )
                              + ", switch to another item to cancel) "
                        ),
                        true
                     );
                  }
               } else {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal(
                           "§l§cCHARGED TO POWER: "
                              + Math.round(Math.floor((double)((entity instanceof LivingEntity _entUseTicks9 ? _entUseTicks9.getTicksUsingItem() : 0) / 20)))
                              + "§r (switch to another item to cancel) "
                        ),
                        true
                     );
                  }

                  double _setvalx = Math.floor((double)((entity instanceof LivingEntity _entUseTicks11 ? _entUseTicks11.getTicksUsingItem() : 0) / 20)) * 20.0;
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.wrath_charge_time = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }
         }

         if ((entity instanceof LivingEntity _entUseTicks12 ? _entUseTicks12.getTicksUsingItem() : 0) > 0) {
            if ((
                  (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.TORMENTED_WRATH.get()
                     || entity instanceof Player _plrCldCheck16 && _plrCldCheck16.getCooldowns().isOnCooldown(itemstack.getItem())
               )
               && entity instanceof LivingEntity _entity) {
               _entity.stopUsingItem();
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
                  x,
                  y + 0.0,
                  z,
                  (int)((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .wrath_charge_time,
                  0.3,
                  0.3,
                  0.3,
                  0.35
               );
            }
         }

         if (entity.isShiftKeyDown() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ZOOM.get(), 5, 1, false, false));
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:demonic_wrath"));
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
