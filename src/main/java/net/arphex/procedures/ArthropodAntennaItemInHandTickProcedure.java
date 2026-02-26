package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ArthropodAntennaItemInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _entUseTicks0 ? _entUseTicks0.getTicksUsingItem() : 0) > 34) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entityiterator;
                  if (_livEnt1.getMobType() == MobType.ARTHROPOD) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 80, 0, false, false));
                        }
                     }

                     entity.getPersistentData().putBoolean("found", true);
                  }
               }
            }

            if (entity.getPersistentData().getBoolean("found")) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 20, 0.3, 0.3, 0.3, 0.2);
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("No arthropods found nearby"), true);
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
            }
         } else {
            entity.getPersistentData().putBoolean("found", false);
         }

         if ((entity instanceof LivingEntity _entUseTicks11 ? _entUseTicks11.getTicksUsingItem() : 0) > 1 && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 15, 0.3, 0.3, 0.3, 0.2);
         }
      }
   }
}
