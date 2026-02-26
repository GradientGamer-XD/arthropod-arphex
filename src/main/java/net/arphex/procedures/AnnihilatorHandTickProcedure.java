package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.AbyssExplosiveEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class AnnihilatorHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         label101:
         if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
            && (entity instanceof LivingEntity _entUseTicks2 ? _entUseTicks2.getTicksUsingItem() : 0) > 50) {
            if (itemstack.getDisplayName().getString().equals("[§dAbysmal Annihilator]")) {
               if (world instanceof Level _level && !_level.isClientSide()) {
                  _level.explode(null, x, y, z, 1.0F, ExplosionInteraction.NONE);
               }
            } else {
               if (!(Boolean)ConfigurationSettingsConfiguration.ARPHEX_ITEM_GRIEFING.get()
                  && entity instanceof Player _player
                  && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§cExplosive item griefing is disabled in config"), true);
               }

               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new AbyssExplosiveEntity(
                              (EntityType<? extends AbyssExplosiveEntity>)ArphexModEntities.ABYSS_EXPLOSIVE.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(projectileLevel, entity, 6.0F, 3);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.3F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ABYSS_DESTRUCTION.get(), x, y, z, 50, 0.3, 0.3, 0.3, 0.2);
            }

            if (entity instanceof Player _plrCldCheck12 && _plrCldCheck12.getCooldowns().isOnCooldown(itemstack.getItem())) {
               break label101;
            }

            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_ANNIHILATOR.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_ANNIHILATOR.get()) {
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 250);
               }
            } else if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 500);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.stopUsingItem();
            }
         }

         if ((entity instanceof LivingEntity _entUseTicks22 ? _entUseTicks22.getTicksUsingItem() : 0) >= 1) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
                  x,
                  y,
                  z,
                  entity instanceof LivingEntity _entUseTicks23 ? _entUseTicks23.getTicksUsingItem() : 0,
                  0.3,
                  0.3,
                  0.3,
                  0.2
               );
            }

            if (entity.isShiftKeyDown() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ZOOM.get(), 5, 1, false, false));
            }
         }
      }
   }
}
