package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BlockOfTimePrismOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator instanceof Player) {
            if ((entityiterator instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
                  != ArphexModItems.SPACETIME_LEGGINGS.get()
               && (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
                  != ArphexModItems.IMMORTAL_LEGGINGS.get()) {
               if ((double)(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                  > entityiterator.getPersistentData().getDouble("bcst1")) {
                  entityiterator.getPersistentData().putDouble("bcst1", entityiterator instanceof LivingEntity _livEntx ? (double)_livEntx.getHealth() : -1.0);
               }

               if (!(entityiterator.getPersistentData().getDouble("buffer_cycle_spacetime") > 0.0)) {
                  entityiterator.getPersistentData().putDouble("bcst5", entityiterator.getPersistentData().getDouble("bcst4"));
                  entityiterator.getPersistentData().putDouble("bcst4", entityiterator.getPersistentData().getDouble("bcst3"));
                  entityiterator.getPersistentData().putDouble("bcst3", entityiterator.getPersistentData().getDouble("bcst2"));
                  entityiterator.getPersistentData().putDouble("bcst2", entityiterator.getPersistentData().getDouble("bcst1"));
                  entityiterator.getPersistentData().putDouble("bcst1", 0.0);
                  entityiterator.getPersistentData().putDouble("buffer_cycle_spacetime", 2.0);
               } else {
                  entityiterator.getPersistentData()
                     .putDouble("buffer_cycle_spacetime", entityiterator.getPersistentData().getDouble("buffer_cycle_spacetime") - 1.0);
               }

               if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) < 5.0F) {
                  if (entityiterator instanceof Player) {
                     Player _plrCldCheck26 = (Player)entityiterator;
                     if (_plrCldCheck26.getCooldowns().isOnCooldown((Item)ArphexModItems.SPACETIME_LEGGINGS.get())) {
                        continue;
                     }
                  }

                  if (entityiterator.getPersistentData().getDouble("bcst5") > entityiterator.getPersistentData().getDouble("bcst4")) {
                     entityiterator.getPersistentData().putDouble("bcst4", entityiterator.getPersistentData().getDouble("bcst5"));
                  }

                  if (entityiterator.getPersistentData().getDouble("bcst4") > entityiterator.getPersistentData().getDouble("bcst3")) {
                     entityiterator.getPersistentData().putDouble("bcst3", entityiterator.getPersistentData().getDouble("bcst4"));
                  }

                  if (entityiterator.getPersistentData().getDouble("bcst3") > entityiterator.getPersistentData().getDouble("bcst2")) {
                     entityiterator.getPersistentData().putDouble("bcst2", entityiterator.getPersistentData().getDouble("bcst3"));
                  }

                  if (entityiterator.getPersistentData().getDouble("bcst2") > entityiterator.getPersistentData().getDouble("bcst1")) {
                     entityiterator.getPersistentData().putDouble("bcst1", entityiterator.getPersistentData().getDouble("bcst2"));
                  }

                  if (entityiterator.getPersistentData().getDouble("bcst1")
                        > (double)(entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F)
                     && (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) > 0.0F) {
                     if (entityiterator instanceof LivingEntity _entity) {
                        _entity.setHealth((float)entityiterator.getPersistentData().getDouble("bcst1"));
                     }

                     if (entityiterator instanceof Player _player) {
                        _player.getCooldowns().addCooldown((Item)ArphexModItems.SPACETIME_LEGGINGS.get(), 500);
                     }

                     if (entityiterator instanceof Player) {
                        Player _player = (Player)entityiterator;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("§2Health recovered through time by Time Prism block!"), true);
                        }
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TIME_SPLASH_PARTICLE.get(), x, y, z, 5, 0.2, 0.3, 0.2, 0.1);
                     }
                  }
               }
            } else if ((
                     entityiterator instanceof Player _plrCldRem5
                        ? _plrCldRem5.getCooldowns().getCooldownPercent((Item)ArphexModItems.SPACETIME_LEGGINGS.get(), 0.0F) * 100.0F
                        : 0.0F
                  )
                  < 20.0F
               && (
                     entityiterator instanceof Player _plrCldRem6
                        ? _plrCldRem6.getCooldowns().getCooldownPercent((Item)ArphexModItems.SPACETIME_LEGGINGS.get(), 0.0F) * 100.0F
                        : 0.0F
                  )
                  > 0.0F
               && entityiterator instanceof Player _player) {
               _player.getCooldowns().addCooldown((Item)ArphexModItems.SPACETIME_LEGGINGS.get(), 1);
            }
         }
      }
   }
}
