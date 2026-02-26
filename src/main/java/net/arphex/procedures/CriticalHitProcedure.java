package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class CriticalHitProcedure {
   @SubscribeEvent
   public static void onPlayerCriticalHit(CriticalHitEvent event) {
      execute(
         event,
         event.getEntity().level(),
         event.getEntity().getX(),
         event.getEntity().getY(),
         event.getEntity().getZ(),
         event.getTarget(),
         event.getEntity(),
         event.isVanillaCritical()
      );
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, boolean isvanillacritical) {
      execute(null, world, x, y, z, entity, sourceentity, isvanillacritical);
   }

   private static void execute(
      @Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, boolean isvanillacritical
   ) {
      if (entity != null && sourceentity != null) {
         if (isvanillacritical
            && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_AXE.get()) {
            entity.setDeltaMovement(new Vec3(0.0, -1.0, 0.0));
            sourceentity.fallDistance = 0.0F;
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 8, 4, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.4, 0.4, 0.4, 0.5);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 15, 0.3, 0.3, 0.3, 0.5);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     0.5F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     0.5F,
                     false
                  );
               }
            }

            if (sourceentity.getPersistentData().getDouble("axefallcheck") - sourceentity.getY() > 2.0) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(
                     new MobEffectInstance(
                        MobEffects.WITHER,
                        30,
                        (int)(20L + Math.round((sourceentity.getPersistentData().getDouble("axefallcheck") - sourceentity.getY()) / 3.0)),
                        false,
                        false
                     )
                  );
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator != entity && entityiterator != sourceentity) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(
                              new MobEffectInstance(
                                 MobEffects.WITHER,
                                 30,
                                 (int)(20L + Math.round((sourceentity.getPersistentData().getDouble("axefallcheck") - sourceentity.getY()) / 3.0)),
                                 false,
                                 false
                              )
                           );
                        }
                     }

                     if (x - entityiterator.getX() > 0.0 && z - entityiterator.getZ() > 0.0) {
                        entityiterator.setDeltaMovement(
                           new Vec3(
                              (0.0 - (x - entityiterator.getX()))
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              (0.0 - (z - entityiterator.getZ()))
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     } else if (x - entityiterator.getX() < 0.0 && z - entityiterator.getZ() < 0.0) {
                        entityiterator.setDeltaMovement(
                           new Vec3(
                              Math.abs(x - entityiterator.getX())
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              Math.abs(z - entityiterator.getZ())
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     } else if (x - entityiterator.getX() > 0.0 && z - entityiterator.getZ() < 0.0) {
                        entityiterator.setDeltaMovement(
                           new Vec3(
                              (0.0 - (x - entityiterator.getX()))
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              Math.abs(z - entityiterator.getZ())
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     } else {
                        entityiterator.setDeltaMovement(
                           new Vec3(
                              Math.abs(x - entityiterator.getX())
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              (0.0 - (z - entityiterator.getZ()))
                                 * ((double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 30, 20, false, false));
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx != entity && entityiteratorx != sourceentity) {
                     if (entityiteratorx instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiteratorx;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 30, 20, false, false));
                        }
                     }

                     if (x - entityiteratorx.getX() > 0.0 && z - entityiteratorx.getZ() > 0.0) {
                        entityiteratorx.setDeltaMovement(
                           new Vec3(
                              (0.0 - (x - entityiteratorx.getX()))
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              (0.0 - (z - entityiteratorx.getZ()))
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     } else if (x - entityiteratorx.getX() < 0.0 && z - entityiteratorx.getZ() < 0.0) {
                        entityiteratorx.setDeltaMovement(
                           new Vec3(
                              Math.abs(x - entityiteratorx.getX())
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              Math.abs(z - entityiteratorx.getZ())
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     } else if (x - entityiteratorx.getX() > 0.0 && z - entityiteratorx.getZ() < 0.0) {
                        entityiteratorx.setDeltaMovement(
                           new Vec3(
                              (0.0 - (x - entityiteratorx.getX()))
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              Math.abs(z - entityiteratorx.getZ())
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     } else {
                        entityiteratorx.setDeltaMovement(
                           new Vec3(
                              Math.abs(x - entityiteratorx.getX())
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))) / 1.5),
                              0.3,
                              (0.0 - (z - entityiteratorx.getZ()))
                                 * ((double)(300.0F / (200.0F + (entityiteratorx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))) / 1.5)
                           )
                        );
                     }
                  }
               }
            }
         }
      }
   }
}
