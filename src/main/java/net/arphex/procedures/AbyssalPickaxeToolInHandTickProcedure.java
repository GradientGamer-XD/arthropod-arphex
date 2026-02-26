package net.arphex.procedures;

import java.util.Map;
import net.arphex.init.ArphexModEnchantments;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;

public class AbyssalPickaxeToolInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.getItem() == ArphexModItems.ABYSS_ATOMISER.get()) {
            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor
                  > 49.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 5, 0, false, false));
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor
                  > 99.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 5, 1, false, false));
            }
         }

         if (!itemstack.getOrCreateTag().getBoolean("crafted")
            && EnchantmentHelper.getItemEnchantmentLevel((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), itemstack) == 0
            && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, itemstack) == 0
            && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemstack) == 0
            && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, itemstack) == 0) {
            itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 3);
            itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
            itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.DARKNESS);
         }

         if (itemstack.getItem() == ArphexModItems.ABYSSAL_PICKAXE.get()) {
            itemstack.setDamageValue(0);
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ABYSSAL_CRYSTAL_PARTICLE.get(), x, y, z, 2, 0.2, 0.2, 0.2, 0.3);
            }
         } else if (entity instanceof Player _plrCldCheck27
            && _plrCldCheck27.getCooldowns().isOnCooldown(itemstack.getItem())
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 1, 0.2, 0.2, 0.2, 0.1);
         }

         if (EnchantmentHelper.getItemEnchantmentLevel((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), itemstack) != 0) {
            if (entity instanceof Player _plrCldCheck32 && _plrCldCheck32.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_BLADE.get()
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 5, 0, false, false));
               }

               Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
               if (_enchantments.containsKey(Enchantments.SILK_TOUCH)) {
                  _enchantments.remove(Enchantments.SILK_TOUCH);
                  EnchantmentHelper.setEnchantments(_enchantments, itemstack);
               }

               _enchantments = EnchantmentHelper.getEnchantments(itemstack);
               if (_enchantments.containsKey(Enchantments.BLOCK_FORTUNE)) {
                  _enchantments.remove(Enchantments.BLOCK_FORTUNE);
                  EnchantmentHelper.setEnchantments(_enchantments, itemstack);
               }
            }

            if (!(entity instanceof Player _plrCldCheck41) || !_plrCldCheck41.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if (entity.isShiftKeyDown()) {
                  if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, itemstack) == 0) {
                     Map<Enchantment, Integer> _enchantmentsx = EnchantmentHelper.getEnchantments(itemstack);
                     if (_enchantmentsx.containsKey(Enchantments.BLOCK_FORTUNE)) {
                        _enchantmentsx.remove(Enchantments.BLOCK_FORTUNE);
                        EnchantmentHelper.setEnchantments(_enchantmentsx, itemstack);
                     }

                     itemstack.enchant(Enchantments.SILK_TOUCH, 3);
                  }
               } else if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemstack) == 0) {
                  Map<Enchantment, Integer> _enchantmentsx = EnchantmentHelper.getEnchantments(itemstack);
                  if (_enchantmentsx.containsKey(Enchantments.SILK_TOUCH)) {
                     _enchantmentsx.remove(Enchantments.SILK_TOUCH);
                     EnchantmentHelper.setEnchantments(_enchantmentsx, itemstack);
                  }

                  itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
               }
            }

            if (itemstack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY) > 5) {
               Map<Enchantment, Integer> _enchantmentsx = EnchantmentHelper.getEnchantments(itemstack);
               if (_enchantmentsx.containsKey(Enchantments.BLOCK_EFFICIENCY)) {
                  _enchantmentsx.remove(Enchantments.BLOCK_EFFICIENCY);
                  EnchantmentHelper.setEnchantments(_enchantmentsx, itemstack);
               }

               itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
            }
         }

         if (itemstack.getItem() == ArphexModItems.ABYSSAL_PICKAXE.get()) {
            if (entity instanceof ServerPlayer _player) {
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:abyssal_pick_craft"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for (String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof ServerPlayer _playerx) {
            Advancement _adv = _playerx.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:reduced_to_atoms"));
            AdvancementProgress _ap = _playerx.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _playerx.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (itemstack.getDisplayName().getString().equals("§dAbysmal Pickaxe") && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 2));
         }
      }
   }
}
