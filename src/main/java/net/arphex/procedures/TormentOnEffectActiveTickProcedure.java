package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class TormentOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
               != ArphexModItems.IMMORTAL_HELMET.get()) {
            double _setval = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .torment_intensity
               + 2.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.torment_intensity = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .torment_intensity
            > 119.0) {
            if (!(entity.getPersistentData().getDouble("torment_tick") > 0.0)) {
               entity.getPersistentData().putDouble("torment_tick", 200.0);
               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 1) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§c§lIt can torment you when you're out in the open wearing armour..."), true);
                  }

                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CRAMMING)),
                     (float)Math.round((double)((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 15.0F) * amplifier)
                  );
                  if (Mth.nextInt(RandomSource.create(), 1, 100) == 5) {
                     boolean _setval = true;
                     entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.show_tormentor_overlay = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 400) == 5) {
                     double _setval = 100.0;
                     entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.shadertime = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 0, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10, 0, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 10, 0, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.MOTH_CURSE.get(), 200, 0, false, false));
                  }
               }
            } else {
               entity.getPersistentData().putDouble("torment_tick", entity.getPersistentData().getDouble("torment_tick") - 1.0);
            }
         }
      }
   }
}
