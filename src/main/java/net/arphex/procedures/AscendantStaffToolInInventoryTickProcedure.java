package net.arphex.procedures;

import java.util.Comparator;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AscendantStaffToolInInventoryTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.onGround()) {
            entity.getPersistentData().putBoolean("ascend_reset", true);
         }

         if (entity.isPassenger() && entity.getVehicle().onGround()) {
            entity.getPersistentData().putBoolean("ascend_reset", true);
         }

         if ((
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ASCENDANT_STAFF.get()
                  || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ASCENDANT_STAFF.get()
            )
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 2, false, false));
         }

         if (entity.getPersistentData().getDouble("levotime") > 0.0) {
            Vec3 _center = new Vec3(
               entity.getPersistentData().getDouble("oplevx"), entity.getPersistentData().getDouble("oplevy"), entity.getPersistentData().getDouble("oplevz")
            );

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if ((
                     !(entityiterator instanceof Player _playerHasItem)
                        || !_playerHasItem.getInventory().contains(new ItemStack((ItemLike)ArphexModItems.ASCENDANT_STAFF.get()))
                  )
                  && !entityiterator.getPersistentData().getBoolean("creativespectator")
                  && entityiterator instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 1, false, true));
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.FIRE_OPAL_SHARDS.get(),
                  entity.getPersistentData().getDouble("oplevx"),
                  entity.getPersistentData().getDouble("oplevy"),
                  entity.getPersistentData().getDouble("oplevz"),
                  5,
                  0.3,
                  0.3,
                  0.3,
                  0.3
               );
            }

            entity.getPersistentData().putDouble("levotime", entity.getPersistentData().getDouble("levotime") - 1.0);
         }
      }
   }
}
