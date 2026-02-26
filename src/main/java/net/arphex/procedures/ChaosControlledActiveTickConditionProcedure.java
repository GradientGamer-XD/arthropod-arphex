package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChaosControlledActiveTickConditionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         if (entity instanceof Player) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
            }
         } else {
            if (entity instanceof TORMENTOREntity) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(
                     (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
                     entity.getX() + lineX * expand,
                     entity.getY() + lineY * expand,
                     entity.getZ() + lineZ * expand,
                     10,
                     0.05,
                     0.2,
                     0.05,
                     1.0
                  );
               }
            } else {
               label111:
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                  if (entity.getPersistentData().getBoolean("creativecontrol")) {
                     ArphexMod.queueServerWork(20, () -> {
                        entity.getPersistentData().putBoolean("stopparticle", true);
                        if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
                           Entity patt2092$temp = entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null;
                           if (patt2092$temp instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                              _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CHAO_LOCK.get(), 10, 0, false, false));
                           }
                        }
                     });
                  }

                  if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof LivingEntity _livEnt17
                     && _livEnt17.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())
                     && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).isAlive()) {
                     if (entity.getPersistentData().getBoolean("stopparticle")) {
                        break label111;
                     }

                     lineX = entity.getX() - (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX();
                     lineY = entity.getY() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY();
                     lineZ = entity.getZ() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getZ();
                     expand = expand;
                     int index0 = 0;

                     while (true) {
                        if (index0 >= 10) {
                           break label111;
                        }

                        if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof ServerLevel _level) {
                           _level.sendParticles(
                              (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
                              entity.getX() + lineX * expand,
                              entity.getY() + lineY * expand,
                              entity.getZ() + lineZ * expand,
                              1,
                              0.05,
                              0.2,
                              0.05,
                              0.0
                           );
                        }

                        expand -= 0.1;
                        index0++;
                     }
                  }

                  if (entity instanceof Mob) {
                     try {
                        ((Mob)entity).setTarget(null);
                     } catch (Exception var24) {
                        var24.printStackTrace();
                     }
                  }
               } else {
                  entity.getPersistentData().putBoolean("stopparticle", false);
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt37 = (LivingEntity)entityiterator;
                        if (_livEnt37.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                           if (entity instanceof TORMENTOREntity) {
                              entityiterator.getPersistentData().putBoolean("tormentor_target", true);
                           } else if (entity instanceof Mob) {
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

            if (!entity.getPersistentData().getBoolean("stopparticle") && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.0);
            }
         }
      }
   }
}
