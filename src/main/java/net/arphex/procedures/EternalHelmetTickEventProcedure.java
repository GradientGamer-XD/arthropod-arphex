package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class EternalHelmetTickEventProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double raytrace_distance = 0.0;
         double Radius = 0.0;
         double loop = 0.0;
         double particleSpeed = 0.0;
         double _setval = 0.0;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.shadertime = _setval;
            capability.syncPlayerVariables(entity);
         });
         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.BLINDNESS);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.CONFUSION);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.VOIDLASHER_CHAOS_CONTROL.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WEAKNESS);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.POISON);
         }

         if (entity.isShiftKeyDown()) {
            label99:
            if ((entity instanceof LivingEntity _entGetArmorxxx ? _entGetArmorxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.ETERNAL_BOOTS.get()
               && (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.ETERNAL_LEGGINGS.get()
               && (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.ETERNAL_CHESTPLATE.get()
               && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.ETERNAL_HELMET.get()) {
               if (entity instanceof Player _plrCldCheck18 && _plrCldCheck18.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  break label99;
               }

               itemstack.getOrCreateTag().putDouble("etdirx", entity.getX());
               itemstack.getOrCreateTag().putDouble("etdirz", entity.getZ());
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 60);
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get(), 15, 0, false, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ETERNAL_FLAME.get(), x, y, z, 30, 0.3, 1.5, 0.3, 0.01);
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.LEVITATION);
            }
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:eternals"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "item modify entity @s armor.head {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }
      }
   }
}
