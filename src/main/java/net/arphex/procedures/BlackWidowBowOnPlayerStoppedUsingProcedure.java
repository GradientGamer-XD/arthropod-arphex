package net.arphex.procedures;

import net.arphex.entity.WidowArrowEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlackWidowBowOnPlayerStoppedUsingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _entUseTicks0 ? _entUseTicks0.getTicksUsingItem() : 0) >= 20) {
            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.8F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.8F,
                     false
                  );
               }
            }

            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new WidowArrowEntity((EntityType<? extends WidowArrowEntity>)ArphexModEntities.WIDOW_ARROW.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setSecondsOnFire(100);
                     return entityToSpawn;
                  }
               }).getArrow(projectileLevel, entity, 4.0F, 2, (byte)2);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.0F, 0.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         } else if ((entity instanceof LivingEntity _entUseTicks4 ? _entUseTicks4.getTicksUsingItem() : 0) >= 10) {
            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.5F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.5F,
                     false
                  );
               }
            }

            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new WidowArrowEntity((EntityType<? extends WidowArrowEntity>)ArphexModEntities.WIDOW_ARROW.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     return entityToSpawn;
                  }
               }).getArrow(projectileLevel, entity, 2.0F, 1, (byte)2);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2.0F, 0.1F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         } else if ((entity instanceof LivingEntity _entUseTicks8 ? _entUseTicks8.getTicksUsingItem() : 0) >= 5) {
            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.4F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.4F,
                     false
                  );
               }
            }

            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new WidowArrowEntity((EntityType<? extends WidowArrowEntity>)ArphexModEntities.WIDOW_ARROW.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     return entityToSpawn;
                  }
               }).getArrow(projectileLevel, entity, 1.0F, 1, (byte)1);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.5F, 0.2F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         } else if ((entity instanceof LivingEntity _entUseTicks12 ? _entUseTicks12.getTicksUsingItem() : 0) >= 3) {
            if (world instanceof Level _levelxxx) {
               if (!_levelxxx.isClientSide()) {
                  _levelxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.3F
                  );
               } else {
                  _levelxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.5F,
                     0.3F,
                     false
                  );
               }
            }

            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new WidowArrowEntity((EntityType<? extends WidowArrowEntity>)ArphexModEntities.WIDOW_ARROW.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     return entityToSpawn;
                  }
               }).getArrow(projectileLevel, entity, 1.0F, 0);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.4F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         } else {
            if (world instanceof Level _levelxxxx) {
               if (!_levelxxxx.isClientSide()) {
                  _levelxxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.2F,
                     0.2F
                  );
               } else {
                  _levelxxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")),
                     SoundSource.NEUTRAL,
                     0.2F,
                     0.2F,
                     false
                  );
               }
            }

            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new WidowArrowEntity((EntityType<? extends WidowArrowEntity>)ArphexModEntities.WIDOW_ARROW.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     return entityToSpawn;
                  }
               }).getArrow(projectileLevel, entity, 0.5F, 0);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.5F, 0.7F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         }
      }
   }
}
