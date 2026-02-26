package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AscendantStaffRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ETHEREAL_STAFF.get()
            || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ETHEREAL_STAFF.get()) {
            entity.getPersistentData().putBoolean("ascend_reset", true);
         }

         if (entity.getPersistentData().getBoolean("ascend_reset")) {
            if (entity instanceof Player _plrCldCheck7 && _plrCldCheck7.getCooldowns().isOnCooldown(itemstack.getItem())) {
               return;
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ASCENDANT_STAFF.get()
               && entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ASCENDANT_STAFF.get()
               && entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.OFF_HAND, true);
            }

            entity.getPersistentData().putBoolean("ascend_reset", false);
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 90);
            }

            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 10.0,
                  0.8,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 10.0
               )
            );
            if (entity.isPassenger() && entity.getVehicle() instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 90, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 90, 1, false, false));
            }

            ArphexMod.queueServerWork(3, () -> {
               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 87, 1, false, false));
               }
            });
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.FIRE_OPAL_SHARDS.get(), x, y, z, 30, 0.5, 0.5, 0.5, 0.4);
            }
         }
      }
   }
}
