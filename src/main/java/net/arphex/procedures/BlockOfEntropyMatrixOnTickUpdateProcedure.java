package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BlockOfEntropyMatrixOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player) {
               if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.IMMORTAL_CHESTPLATE.get()) {
                  if ((
                           entityiterator instanceof Player _plrCldRem4
                              ? _plrCldRem4.getCooldowns().getCooldownPercent((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get(), 0.0F) * 100.0F
                              : 0.0F
                        )
                        < 10.0F
                     && (
                           entityiterator instanceof Player _plrCldRem5
                              ? _plrCldRem5.getCooldowns().getCooldownPercent((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get(), 0.0F) * 100.0F
                              : 0.0F
                        )
                        > 0.0F
                     && entityiterator instanceof Player _player) {
                     _player.getCooldowns().addCooldown((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get(), 1);
                  }
               } else {
                  int var20;
                  label52: {
                     if (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        var20 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                        break label52;
                     }

                     var20 = 0;
                  }

                  if (var20 <= 0) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(
                           (SimpleParticleType)ArphexModParticleTypes.ENTROPY_GLOW.get(),
                           entityiterator.getX(),
                           entityiterator.getY(),
                           entityiterator.getZ(),
                           1,
                           0.3,
                           0.3,
                           0.3,
                           0.2
                        );
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1));
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
