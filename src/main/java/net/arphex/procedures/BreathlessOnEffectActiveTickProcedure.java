package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BreathlessOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!entity.getPersistentData().getBoolean("creativespectator")) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
               || entity instanceof LivingEntity _livEnt5 && _livEnt5.isFallFlying()
               || entity.isPassenger()
               || entity.getX() == entity.getPersistentData().getDouble("comparexbreath")
                  && entity.getY() == entity.getPersistentData().getDouble("compareybreath")
                  && entity.getZ() == entity.getPersistentData().getDouble("comparezbreath")) {
               if (entity.getPersistentData().getDouble("breathless_cycle") > 0.0) {
                  entity.getPersistentData().putDouble("breathless_cycle", entity.getPersistentData().getDouble("breathless_cycle") - 3.0);
               }
            } else {
               entity.getPersistentData().putDouble("breathless_cycle", entity.getPersistentData().getDouble("breathless_cycle") + 1.0);
            }

            if (entity.getPersistentData().getDouble("breathless_cycle") > 1200.0) {
               ArphexMod.queueServerWork(20, () -> {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("The fog is making you breathless, you need to rest"), true);
                  }
               });
            }

            entity.getPersistentData().putDouble("comparexbreath", entity.getX());
            entity.getPersistentData().putDouble("compareybreath", entity.getY());
            entity.getPersistentData().putDouble("comparezbreath", entity.getZ());
         }
      }
   }
}
