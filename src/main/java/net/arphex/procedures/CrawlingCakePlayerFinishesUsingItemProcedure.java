package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CrawlingCakePlayerFinishesUsingItemProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 0));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 1));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0));
         }

         ArphexMod.queueServerWork(
            1,
            () -> {
               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.CRAWLING_CAKE.get()) {
                  if (entity.getPersistentData().getDouble("cake_dura_store") < 8.0) {
                     if (!entity.getPersistentData().getBoolean("creativespectator")) {
                        (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                           .setDamageValue((int)(entity.getPersistentData().getDouble("cake_dura_store") + 1.0));
                     }
                  } else if (entity instanceof LivingEntity _entityxx) {
                     ItemStack _setstack = ItemStack.EMPTY.copy();
                     _setstack.setCount(1);
                     _entityxx.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entityxx instanceof Player _player) {
                        _player.getInventory().setChanged();
                     }
                  }
               } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ArphexModItems.CRAWLING_CAKE.get()) {
                  if (entity.getPersistentData().getDouble("cake_dura_store") < 8.0) {
                     if (!entity.getPersistentData().getBoolean("creativespectator")) {
                        (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY)
                           .setDamageValue((int)(entity.getPersistentData().getDouble("cake_dura_store") + 1.0));
                     }
                  } else if (entity instanceof LivingEntity _entityx) {
                     ItemStack _setstack = ItemStack.EMPTY.copy();
                     _setstack.setCount(1);
                     _entityx.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                     if (_entityx instanceof Player _player) {
                        _player.getInventory().setChanged();
                     }
                  }
               }
            }
         );
      }
   }
}
