package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BlockOfVoidGeodeTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (!entityiterator.getPersistentData().getBoolean("creativespectator") && entityiterator instanceof Player) {
               if ((entityiterator instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.UMBRAL_CHESTPLATE.get()
                  || (entityiterator instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ETERNAL_CHESTPLATE.get()
                  || (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.IMMORTAL_CHESTPLATE.get()) {
                  int var21;
                  label54: {
                     if (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get())) {
                        var21 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get()).getDuration();
                        break label54;
                     }

                     var21 = 0;
                  }

                  if (var21 < 600 && entityiterator instanceof LivingEntity _entity) {
                     _entity.removeEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get());
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entityiterator;
                  if (_livEnt11.hasEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get())) {
                     continue;
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_PROTECTION.get(), 20, 0, false, false));
                  }
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(), x, y, z, 1, 0.3, 0.3, 0.3, 0.1);
               }
            }
         }
      }
   }
}
