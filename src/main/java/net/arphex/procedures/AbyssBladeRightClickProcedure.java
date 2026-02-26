package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AbyssBladeRightClickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            return;
         }

         if (entity instanceof Player _player) {
            _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 5, 1.0, 0.5, 1.0, 0.5);
         }

         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
                  SoundSource.PLAYERS,
                  0.8F,
                  0.7F
               );
            } else {
               _level.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
                  SoundSource.PLAYERS,
                  0.8F,
                  0.7F,
                  false
               );
            }
         }

         label64: {
            if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.DAMAGE_BOOST)) {
               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new BloodProjectileEntity(
                              (EntityType<? extends BloodProjectileEntity>)ArphexModEntities.BLOOD_PROJECTILE.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setSecondsOnFire(100);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, 5.0F, 1);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2.0F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_BLADE.get()
                  && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_BLADE.get()) {
                  ArphexMod.queueServerWork(
                     2,
                     () -> {
                        Level projectileLevelx = entity.level();
                        if (!projectileLevelx.isClientSide()) {
                           Projectile _entityToSpawnx = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new BloodProjectileEntity(
                                       (EntityType<? extends BloodProjectileEntity>)ArphexModEntities.BLOOD_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    entityToSpawn.setSecondsOnFire(100);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevelx, entity, 4.0F, 1);
                           _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                           _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2.0F, 0.0F);
                           projectileLevelx.addFreshEntity(_entityToSpawnx);
                        }
                     }
                  );
                  ArphexMod.queueServerWork(
                     4,
                     () -> {
                        Level projectileLevelx = entity.level();
                        if (!projectileLevelx.isClientSide()) {
                           Projectile _entityToSpawnx = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new BloodProjectileEntity(
                                       (EntityType<? extends BloodProjectileEntity>)ArphexModEntities.BLOOD_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    entityToSpawn.setSecondsOnFire(100);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevelx, entity, 4.0F, 1);
                           _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                           _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2.0F, 0.0F);
                           projectileLevelx.addFreshEntity(_entityToSpawnx);
                        }
                     }
                  );
               }
               break label64;
            }

            Level projectileLevelx = entity.level();
            if (!projectileLevelx.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new BloodProjectileEntity(
                           (EntityType<? extends BloodProjectileEntity>)ArphexModEntities.BLOOD_PROJECTILE.get(), level
                        );
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                     }
                  })
                  .getArrow(projectileLevelx, entity, 4.0F, 1);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
               projectileLevelx.addFreshEntity(_entityToSpawn);
            }
         }

         if (entity.onGround()) {
            entity.getPersistentData().putString("doublejump", "reset");
            if (!entity.isShiftKeyDown()) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0,
                     0.6,
                     Math.sin((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 0, false, false));
               }
            }
         } else if (entity.getPersistentData().getString("doublejump").equals("reset")) {
            if (!entity.isShiftKeyDown()) {
               entity.getPersistentData().putString("doublejump", "doublejump");
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0,
                     0.6,
                     Math.sin((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            }
         } else {
            entity.getPersistentData().putString("doublejump", "doublejump");
         }
      }
   }
}
