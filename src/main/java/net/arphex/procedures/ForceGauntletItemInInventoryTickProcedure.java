package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;

public class ForceGauntletItemInInventoryTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("forcecharges") > 0.0) {
            if (!(entity instanceof LivingEntity _livEnt1) || !_livEnt1.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
               entity.getPersistentData().putDouble("forcecharges", entity.getPersistentData().getDouble("forcecharges") - 1.0);
            }
         } else {
            entity.getPersistentData().putDouble("forcecharges", 0.0);
         }

         if (!entity.getPersistentData().getBoolean("crafted") && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.KNOCKBACK, itemstack) == 0) {
            itemstack.enchant(Enchantments.KNOCKBACK, 5);
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.FORCE_GAUNTLET.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.CHAOS_GAUNTLET.get()) {
            entity.getPersistentData().putBoolean("usinggauntlet", false);
         }

         if (entity.getPersistentData().getBoolean("firegauntlet")) {
            ArphexMod.queueServerWork(3, () -> entity.getPersistentData().putBoolean("firegauntlet", false));
         }
      }
   }
}
