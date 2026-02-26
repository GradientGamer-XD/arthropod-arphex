package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.AoEflameEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class FireblasterRightClickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.getPersistentData().getBoolean("usinggauntlet") && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.FORCE_POWER.get(), 2, 0, false, false));
         }

         if (entity.getPersistentData().getDouble("flamecool") > 40.0 && entity.isUnderWater()) {
            entity.getPersistentData().putDouble("flamecool", 40.0);
         }

         if (entity.getPersistentData().getBoolean("usingff")
            && (!(entity instanceof Player _plrCldCheck7) || !_plrCldCheck7.getCooldowns().isOnCooldown(itemstack.getItem()))
            && !(entity.getPersistentData().getDouble("shootslow") > 0.0)
            && (entity instanceof LivingEntity _entUseTicks9 ? _entUseTicks9.getTicksUsingItem() : 0) > 0) {
            if (entity.getPersistentData().getDouble("shootslow") <= 0.0) {
               entity.getPersistentData().putDouble("shootslow", 3.0);
            }

            if (entity.getPersistentData().getDouble("flamecool") <= 0.0) {
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 80);
               }

               entity.getPersistentData().putDouble("flamecool", 140.0);
            } else {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.SMOKE, x, y, z, (int)(140.0 / entity.getPersistentData().getDouble("flamecool") * 3.0), 0.2, 0.2, 0.2, 0.2);
               }

               entity.getPersistentData().putDouble("flamecool", entity.getPersistentData().getDouble("flamecool") - 8.0);
            }

            label146:
            if (itemstack.getOrCreateTag().getBoolean("mainhand")) {
               if (entity instanceof Player _plrCldCheck23 && _plrCldCheck23.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  break label146;
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 0, false, false));
               }

               for (int index0 = 0; index0 < 12; index0++) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles(
                        ParticleTypes.FLAME,
                        entity.getX(),
                        entity.getY() + 1.0,
                        entity.getZ(),
                        0,
                        entity.getLookAngle().x * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                        entity.getLookAngle().y * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                        entity.getLookAngle().z * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                        0.2
                     );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles(
                        (SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(),
                        entity.getX(),
                        entity.getY() + 1.0,
                        entity.getZ(),
                        0,
                        entity.getLookAngle().x * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                        entity.getLookAngle().y * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                        entity.getLookAngle().z * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                        0.2
                     );
                  }
               }

               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new AoEflameEntity((EntityType<? extends AoEflameEntity>)ArphexModEntities.AO_EFLAME.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        return entityToSpawn;
                     }
                  }).getArrow(projectileLevel, entity, 2.0F, 3, (byte)10);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.1F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
                        SoundSource.NEUTRAL,
                        0.5F,
                        0.3F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
                        SoundSource.NEUTRAL,
                        0.5F,
                        0.3F,
                        false
                     );
                  }
               }

               Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator != entity
                     && !(entityiterator instanceof AoEflameEntity)
                     && entity.getRootVehicle() != entityiterator
                     && Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot() < 50.0
                        == Math.atan2(entityiterator.getX() - entity.getX(), entityiterator.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot()
                           > -50.0) {
                     entityiterator.setSecondsOnFire(15);
                     if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 5) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity),
                           (float)(2 / ((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) / 5))
                        );
                     } else {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity),
                           2.0F
                        );
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 0, false, false));
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(ParticleTypes.FLAME, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 5, 0.3, 0.3, 0.3, 0.3);
                     }
                  }
               }
            }
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:fireblaster_obtain"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }
      }
   }
}
