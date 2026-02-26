package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModEnchantments;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;

public class AbyssAscendantItemInInventoryTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof LivingEntity _livEnt0
            && _livEnt0.isFallFlying()
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.ELYTRA) {
            (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).setDamageValue(0);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get());
         }

         ArphexMod.queueServerWork(
            10,
            () -> {
               if (itemstack.getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
                  && !itemstack.getOrCreateTag().getBoolean("crafted")
                  && EnchantmentHelper.getItemEnchantmentLevel((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), itemstack) == 0
                  && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, itemstack) == 0
                  && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, itemstack) == 0) {
                  itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 3);
                  itemstack.enchant(Enchantments.BANE_OF_ARTHROPODS, 3);
                  itemstack.enchant(Enchantments.FIRE_ASPECT, 3);
                  itemstack.enchant(Enchantments.MOB_LOOTING, 3);
                  itemstack.enchant(Enchantments.KNOCKBACK, 3);
                  itemstack.enchant(Enchantments.SHARPNESS, 5);
               }
            }
         );
         if (entity.getPersistentData().getBoolean("creativespectator")) {
            entity.getPersistentData().putBoolean("abflymode", false);
         }

         entity.getPersistentData().putDouble("allow_floatingsequence", 5.0);
         if (!(
               ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor
                  > 0.0
            )
            && itemstack.getOrCreateTag().getBoolean("crafted")) {
            if (!itemstack.getDisplayName().getString().strip().replace("]", "").endsWith(")") && itemstack.getItem() == ArphexModItems.ABYSS_ASCENDANT.get()) {
               if (itemstack.getDisplayName().getString().strip().replace("]", "").endsWith(" ")) {
                  itemstack.setHoverName(Component.literal((itemstack.getDisplayName().getString() + "(inactive)").replace("]", "").replace("[", "")));
               } else {
                  itemstack.setHoverName(Component.literal((itemstack.getDisplayName().getString() + " (inactive)").replace("]", "").replace("[", "")));
               }
            }
         } else if (itemstack.getDisplayName().getString().strip().replace("]", "").endsWith(")")
            && itemstack.getItem() == ArphexModItems.ABYSS_ASCENDANT.get()) {
            itemstack.setHoverName(
               Component.literal(
                  itemstack.getDisplayName().getString().replace("(inactive)", "]").replace(" (inactive)", "]").replace("[", "").replace("]", "")
               )
            );
         }

         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
            && (entity instanceof LivingEntity _entUseTicks64 ? _entUseTicks64.getTicksUsingItem() : 0) > 0
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false));
         }
      }
   }
}
