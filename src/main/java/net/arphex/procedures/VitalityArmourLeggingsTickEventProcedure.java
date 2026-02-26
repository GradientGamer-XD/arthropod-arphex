package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class VitalityArmourLeggingsTickEventProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         if ((entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.VITALITY_ARMOUR_BOOTS.get()
            && (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
               == ArphexModItems.VITALITY_ARMOUR_CHESTPLATE.get()
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
               == ArphexModItems.VITALITY_ARMOUR_HELMET.get()) {
            int var12;
            label51: {
               if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION)) {
                  var12 = _livEnt.getEffect(MobEffects.REGENERATION).getAmplifier();
                  break label51;
               }

               var12 = 0;
            }

            if (var12 < 2 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, false));
            }
         } else {
            int var11;
            label56: {
               if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION)) {
                  var11 = _livEnt.getEffect(MobEffects.REGENERATION).getAmplifier();
                  break label56;
               }

               var11 = 0;
            }

            if (var11 < 1 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1, false, false));
            }
         }
      }
   }
}
