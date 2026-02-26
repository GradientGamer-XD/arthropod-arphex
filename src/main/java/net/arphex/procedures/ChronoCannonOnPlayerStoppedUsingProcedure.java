package net.arphex.procedures;

import net.arphex.entity.ChronoShotEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ChronoCannonOnPlayerStoppedUsingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) && !world.isClientSide()) {
            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new ChronoShotEntity((EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     return entityToSpawn;
                  }
               }).getArrow(projectileLevel, entity, 5.0F, 1);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.0F, 0.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 15, 1.0, 1.0, 1.0, 0.0);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:genesis_shot")),
                     SoundSource.NEUTRAL,
                     30.0F,
                     0.1F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:genesis_shot")),
                     SoundSource.NEUTRAL,
                     30.0F,
                     0.1F,
                     false
                  );
               }
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 200);
            }

            entity.getPersistentData().putDouble("recoil_genesis", 10.0);
         }
      }
   }
}
