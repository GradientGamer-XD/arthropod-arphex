package net.arphex.procedures;

import net.arphex.entity.JudgementBlastEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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

public class JudgementHandProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5, 0, false, false));
         }

         if (entity.getPersistentData().getDouble("flamecool") > 100.0 && entity.isUnderWater()) {
            entity.getPersistentData().putDouble("flamecool", 100.0);
         }

         label64:
         if ((entity instanceof LivingEntity _entUseTicks4 ? _entUseTicks4.getTicksUsingItem() : 0) > 2 && itemstack.getOrCreateTag().getBoolean("mainhand")) {
            if (entity instanceof Player _plrCldCheck8 && _plrCldCheck8.getCooldowns().isOnCooldown(itemstack.getItem())) {
               break label64;
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.WHITE_PARTICLES.get(),
                  x,
                  y,
                  z,
                  (int)(140.0 / entity.getPersistentData().getDouble("flamecool") * 3.0),
                  0.2,
                  0.2,
                  0.2,
                  0.1
               );
            }

            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new JudgementBlastEntity(
                           (EntityType<? extends JudgementBlastEntity>)ArphexModEntities.JUDGEMENT_BLAST.get(), level
                        );
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        return entityToSpawn;
                     }
                  })
                  .getArrow(projectileLevel, entity, 4.0F, 3, (byte)10);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.5F, 0.1F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 25);
            }
         }

         if ((entity instanceof LivingEntity _entUseTicks15 ? _entUseTicks15.getTicksUsingItem() : 0) > 100 && entity instanceof Player _player) {
            _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:judgement_blaster_obtain"));
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
