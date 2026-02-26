package net.arphex.procedures;

import java.util.Map;
import net.arphex.init.ArphexModEnchantments;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
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

public class AbyssalAxeHeldProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (!itemstack.getOrCreateTag().getBoolean("crafted")
            && EnchantmentHelper.getItemEnchantmentLevel((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), itemstack) == 0
            && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, itemstack) == 0
            && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemstack) == 0
            && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, itemstack) == 0) {
            itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 3);
            itemstack.enchant(Enchantments.BLOCK_EFFICIENCY, 3);
            itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.DARKNESS);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ABYSSAL_CRYSTAL_PARTICLE.get(), x, y, z, 2, 0.2, 0.2, 0.2, 0.3);
         }

         itemstack.setDamageValue(0);
         label64:
         if (EnchantmentHelper.getItemEnchantmentLevel((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), itemstack) != 0) {
            if (entity instanceof Player _plrCldCheck23 && _plrCldCheck23.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemstack) != 0) {
                  Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
                  if (_enchantments.containsKey(Enchantments.BLOCK_FORTUNE)) {
                     _enchantments.remove(Enchantments.BLOCK_FORTUNE);
                     EnchantmentHelper.setEnchantments(_enchantments, itemstack);
                  }
               }
               break label64;
            }

            if (itemstack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE) < 3) {
               Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
               if (_enchantments.containsKey(Enchantments.BLOCK_FORTUNE)) {
                  _enchantments.remove(Enchantments.BLOCK_FORTUNE);
                  EnchantmentHelper.setEnchantments(_enchantments, itemstack);
               }

               itemstack.enchant(Enchantments.BLOCK_FORTUNE, 3);
            }
         }

         if (entity.onGround()) {
            entity.getPersistentData().putDouble("axefallcheck", 0.0);
         } else if (entity.getPersistentData().getDouble("axefallcheck") == 0.0) {
            entity.getPersistentData().putDouble("axefallcheck", entity.getY());
         }

         if (itemstack.getDisplayName().getString().equals("[§dAbysmal Axe]")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 2));
            }
         }
      }
   }
}
