package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModEnchantments;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AbyssalBladeItemInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         ArphexMod.queueServerWork(
            10,
            () -> {
               if (!itemstack.getOrCreateTag().getBoolean("crafted")
                  && EnchantmentHelper.getItemEnchantmentLevel((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), itemstack) == 0
                  && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, itemstack) == 0
                  && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, itemstack) == 0) {
                  itemstack.enchant((Enchantment)ArphexModEnchantments.WITHER_AURA.get(), 3);
                  itemstack.enchant(Enchantments.BANE_OF_ARTHROPODS, 3);
                  itemstack.enchant(Enchantments.MOB_LOOTING, 3);
               }
            }
         );
         if (entity.getPersistentData().getDouble("justswung") < 20.0) {
            entity.getPersistentData().putDouble("justswung", entity.getPersistentData().getDouble("justswung") + 1.0);
         }

         if (entity.getPersistentData().getDouble("ringspin") <= 0.0) {
            entity.getPersistentData().putDouble("ringspin", 360.0);
         } else {
            entity.getPersistentData().putDouble("ringspin", entity.getPersistentData().getDouble("ringspin") - 25.0);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         if (entity.onGround()) {
            entity.getPersistentData().putString("doublejump", "reset");
         }

         if (entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(MobEffects.SLOW_FALLING)) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute as @p at @s rotated "
                        + entity.getPersistentData().getDouble("ringspin")
                        + " 3 as @p run particle arphex:abyssal_crystal_particle ^ ^0.3 ^1.5"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute as @p at @s rotated "
                        + entity.getPersistentData().getDouble("ringspin")
                        + " 3 as @p run particle arphex:heavy_red_smoke ^ ^0.3 ^1.5"
                  );
            }

            world.addParticle((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y - 1.0, z, 0.0, 0.0, 0.0);
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_BLADE.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_BLADE.get()
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1, false, false));
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:abyssal_blade_crafted"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (itemstack.getDisplayName().getString().equals("[§dAbysmal Blade]") && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2));
         }
      }
   }
}
