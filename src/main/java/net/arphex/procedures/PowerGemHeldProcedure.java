package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class PowerGemHeldProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.ABYSSAL_CRYSTAL.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.ABYSSAL_CRYSTAL.get()) {
            if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.FIRE_OPAL.get()
               && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.FIRE_OPAL.get()) {
               if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     != ArphexModItems.VOID_GEODE.get()
                  && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.VOID_GEODE.get()
                  )
                {
                  if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        != ArphexModItems.INFERNAL_SHARD.get()
                     && (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                        != ArphexModItems.INFERNAL_SHARD.get()) {
                     if ((entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                           != ArphexModItems.UMBRAL_SHARD.get()
                        && (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                           != ArphexModItems.UMBRAL_SHARD.get()) {
                        if ((entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                              != ArphexModItems.SPECTRAL_SHARD.get()
                           && (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                              != ArphexModItems.SPECTRAL_SHARD.get()) {
                           if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                 != ArphexModItems.TIME_PRISM.get()
                              && (entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                 != ArphexModItems.TIME_PRISM.get()) {
                              if ((
                                    (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                                             .getItem()
                                          == ArphexModItems.ENTROPY_MATRIX.get()
                                       || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                                             .getItem()
                                          == ArphexModItems.ENTROPY_MATRIX.get()
                                 )
                                 && entity instanceof LivingEntity _entity
                                 && !_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
                              }
                           } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
                           }
                        } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
                        }
                     } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
                     }
                  } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
                  }
               } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
               }
            } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
            }
         } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
         }

         if (itemstack.getItem() == ArphexModItems.VOID_GEODE.get()
            && (
               !(entity instanceof ServerPlayer _plr42)
                  || !(_plr42.level() instanceof ServerLevel)
                  || !_plr42.getAdvancements()
                     .getOrStartProgress(_plr42.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:voidlasher_killed")))
                     .isDone()
            )
            && entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:voidlasher_killed"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (itemstack.getItem() == ArphexModItems.FIRE_OPAL.get()
            && (
               !(entity instanceof ServerPlayer _plr46)
                  || !(_plr46.level() instanceof ServerLevel)
                  || !_plr46.getAdvancements()
                     .getOrStartProgress(_plr46.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:scorpioid_killed")))
                     .isDone()
            )
            && entity instanceof ServerPlayer _playerx) {
            Advancement _adv = _playerx.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:scorpioid_killed"));
            AdvancementProgress _ap = _playerx.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _playerx.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (itemstack.getItem() == ArphexModItems.ABYSSAL_CRYSTAL.get()
            && (
               !(entity instanceof ServerPlayer _plr50)
                  || !(_plr50.level() instanceof ServerLevel)
                  || !_plr50.getAdvancements()
                     .getOrStartProgress(_plr50.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:moth_kill")))
                     .isDone()
            )
            && entity instanceof ServerPlayer _playerxx) {
            Advancement _adv = _playerxx.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:moth_kill"));
            AdvancementProgress _ap = _playerxx.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _playerxx.getAdvancements().award(_adv, criteria);
               }
            }
         }
      }
   }
}
