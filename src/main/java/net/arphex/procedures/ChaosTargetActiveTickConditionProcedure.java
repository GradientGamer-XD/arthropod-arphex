package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChaosTargetActiveTickConditionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         if ((!(entity instanceof LivingEntity _livEnt0) || !_livEnt0.hasEffect((MobEffect)ArphexModMobEffects.CHAO_LOCK.get()))
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.1);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get());
         }

         if (entity.getPersistentData().getBoolean("creativecontrol")) {
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
               if ((
                     !((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof LivingEntity _livEnt7)
                        || !_livEnt7.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())
                        || !(entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).isAlive()
                  )
                  && entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var24) {
                     var24.printStackTrace();
                  }
               }
            } else {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entityiterator;
                     if (_livEnt11.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get()) && entity instanceof Mob) {
                        Mob _entity = (Mob)entity;
                        if (entityiterator instanceof LivingEntity _ent) {
                           _entity.setTarget(_ent);
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
