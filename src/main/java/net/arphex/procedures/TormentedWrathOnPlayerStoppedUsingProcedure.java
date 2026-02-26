package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.TormentExplosiveEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class TormentedWrathOnPlayerStoppedUsingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .killedtormentor
            > 0.0) {
            if ((entity instanceof LivingEntity _entUseTicks0 ? _entUseTicks0.getTicksUsingItem() : 0) > 20) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ABYSS_DESTRUCTION.get(), x, y, z, 50, 0.3, 0.3, 0.3, 0.2);
               }

               if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TORMENTED_WRATH.get()
                  && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TORMENTED_WRATH.get()) {
                  if (entity instanceof Player _player) {
                     _player.getCooldowns()
                        .addCooldown(
                           itemstack.getItem(),
                           (int)(
                              0.75
                                 * (
                                    119.0
                                       + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                             .orElse(new ArphexModVariables.PlayerVariables()))
                                          .wrath_charge_time
                                 )
                                 * Math.log10(
                                    ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                          .orElse(new ArphexModVariables.PlayerVariables()))
                                       .wrath_charge_time
                                 )
                           )
                        );
                  }
               } else if (entity instanceof Player _player) {
                  _player.getCooldowns()
                     .addCooldown(
                        itemstack.getItem(),
                        (int)(
                           1.5
                              * (
                                 119.0
                                    + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                          .orElse(new ArphexModVariables.PlayerVariables()))
                                       .wrath_charge_time
                              )
                              * Math.log10(
                                 ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .wrath_charge_time
                              )
                        )
                     );
               }

               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new TormentExplosiveEntity(
                              (EntityType<? extends TormentExplosiveEntity>)ArphexModEntities.TORMENT_EXPLOSIVE.get(), level
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

               if (!(Boolean)ConfigurationSettingsConfiguration.ARPHEX_ITEM_GRIEFING.get()
                  && entity instanceof Player _player
                  && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§cExplosive item griefing is disabled in config"), true);
               }

               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:genesis_shot")),
                        SoundSource.NEUTRAL,
                        5.0F,
                        0.001F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:genesis_shot")),
                        SoundSource.NEUTRAL,
                        5.0F,
                        0.001F,
                        false
                     );
                  }
               }
            }
         } else if (entity.getPersistentData().getBoolean("creativespectator")) {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("You need at least one Tormentor kill to use this item (try /arphex set_tormentor_level)"), true);
            }
         } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("You need at least one Tormentor kill to use this item"), true);
         }
      }
   }
}
