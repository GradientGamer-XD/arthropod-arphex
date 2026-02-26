package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AbyssalDaggerItemInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()) && world instanceof ServerLevel _level) {
            SimpleParticleType var10001;
            int var10005;
            label57: {
               var10001 = (SimpleParticleType)ArphexModParticleTypes.ABYSSAL_CRYSTAL_PARTICLE.get();
               if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                  var10005 = _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier();
                  break label57;
               }

               var10005 = 0;
            }

            _level.sendParticles(var10001, x, y, z, var10005 * 2, 0.5, 0.5, 0.5, 0.2);
         }

         if (entity.getPersistentData().getDouble("immunity_cooldown_dagger") > 0.0) {
            entity.getPersistentData().putDouble("immunity_cooldown_dagger", entity.getPersistentData().getDouble("immunity_cooldown_dagger") - 1.0);
         }

         if (itemstack.getDisplayName().getString().equals("[§dAbysmal Dagger]") && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2));
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_DAGGER.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_DAGGER.get()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 0));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 0));
            }
         }
      }
   }
}
