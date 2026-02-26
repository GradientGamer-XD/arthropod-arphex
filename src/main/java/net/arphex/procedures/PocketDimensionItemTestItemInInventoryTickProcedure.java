package net.arphex.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PocketDimensionItemTestItemInInventoryTickProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1
            && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false));
         }

         if (itemstack.getOrCreateTag().getString("trackfortp").equals("none")) {
            itemstack.getOrCreateTag().putDouble("fiveseconds", 100.0);
         } else if (itemstack.getOrCreateTag().getDouble("fiveseconds") > 0.0) {
            itemstack.getOrCreateTag().putDouble("fiveseconds", itemstack.getOrCreateTag().getDouble("fiveseconds") - 1.0);
         }

         if (!(itemstack.getOrCreateTag().getDouble("fiveseconds") > 0.0)
            && !itemstack.getOrCreateTag().getString("playertrackfortp").equals("none")
            && !itemstack.getOrCreateTag().getString("trackfortp").equals("none")) {
            if ((!itemstack.getOrCreateTag().getString("playertrackfortp").isEmpty() || !itemstack.getOrCreateTag().getString("trackfortp").isEmpty())
               && entity instanceof Player _player
               && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Entity invitation reset (5 seconds reached)"), true);
            }

            itemstack.getOrCreateTag().putString("trackfortp", "none");
            itemstack.getOrCreateTag().putString("playertrackfortp", "none");
         }
      }
   }
}
