package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SingularityScytheRightclickedProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SINGULARITY_SCYTHE.get()) {
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 200);
            }

            itemstack.getOrCreateTag().putDouble("shield_scythe", 20.0);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 10, 0));
            }
         }
      }
   }
}
