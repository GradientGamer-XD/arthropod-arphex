package net.arphex.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class InfernalBootsTickEventProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         entity.fallDistance = 0.0F;
         if (entity.isShiftKeyDown() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0, false, false));
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
                  "item modify entity @s armor.feet {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }

         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (entity.isPassenger()
            && entity.getFirstPassenger() != null
            && entity.getFirstPassenger() instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false));
         }
      }
   }
}
