package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.AscendantArrowEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.HitResult.Type;

public class AbyssAscendantEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (!(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                     } else {
                        return _ent.level().isClientSide() && _ent instanceof Player _player
                           ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                              && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR
                           : false;
                     }
                  }
               })
               .checkGamemode(entity)
            && entity instanceof Player player
            && player.containerMenu == player.inventoryMenu) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.5);
            }

            entity.getPersistentData().putDouble("justswung", 0.0);
            if ((!(entity instanceof Player _plrCldCheck4) || !_plrCldCheck4.getCooldowns().isOnCooldown(itemstack.getItem()))
               && (entity instanceof LivingEntity _entUseItem5 ? _entUseItem5.getUseItem() : ItemStack.EMPTY).getItem() != ArphexModItems.ABYSS_ASCENDANT.get()
               && entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getType()
                  != Type.BLOCK) {
               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!(entity.getPersistentData().getDouble("openhit") > 0.0)) {
                        if (entity instanceof Player _plrCldCheck10 && _plrCldCheck10.getCooldowns().isOnCooldown(itemstack.getItem())) {
                           return;
                        }

                        entity.getPersistentData().putDouble("abyssdestruction", 20.0);
                        if (itemstack.getItem() == ArphexModItems.ABYSS_ASCENDANT.get() && entity instanceof Player _player) {
                           _player.getCooldowns().addCooldown(itemstack.getItem(), 19);
                        }

                        Level projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           Projectile _entityToSpawn = (new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new AscendantArrowEntity(
                                       (EntityType<? extends AscendantArrowEntity>)ArphexModEntities.ASCENDANT_ARROW.get(), level
                                    );
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })
                              .getArrow(projectileLevel, entity, 5.0F, 4);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                    CommandSource.NULL,
                                    entity.position(),
                                    entity.getRotationVector(),
                                    entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                    4,
                                    entity.getName().getString(),
                                    entity.getDisplayName(),
                                    entity.level().getServer(),
                                    entity
                                 ),
                                 "particle arphex:abyss_destruction "
                                    + entity.getX()
                                    + " "
                                    + (entity.getY() + 1.0)
                                    + " "
                                    + entity.getZ()
                                    + " "
                                    + (entity.getLookAngle().x * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                    + " "
                                    + (entity.getLookAngle().y * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                    + " "
                                    + (entity.getLookAngle().z * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                    + " 1 0 force"
                              );
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                    CommandSource.NULL,
                                    entity.position(),
                                    entity.getRotationVector(),
                                    entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                    4,
                                    entity.getName().getString(),
                                    entity.getDisplayName(),
                                    entity.level().getServer(),
                                    entity
                                 ),
                                 "particle arphex:heavy_red_smoke "
                                    + entity.getX()
                                    + " "
                                    + (entity.getY() + 1.0)
                                    + " "
                                    + entity.getZ()
                                    + " "
                                    + (entity.getLookAngle().x * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                    + " "
                                    + (entity.getLookAngle().y * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                    + " "
                                    + (entity.getLookAngle().z * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                    + " 1 0 force"
                              );
                        }

                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.ABYSS_ASCENDANT.get()) {
                           ArphexMod.queueServerWork(
                              9,
                              () -> {
                                 if (entity instanceof LivingEntity _entity) {
                                    _entity.swing(InteractionHand.OFF_HAND, true);
                                 }

                                 Level projectileLevelx = entity.level();
                                 if (!projectileLevelx.isClientSide()) {
                                    Projectile _entityToSpawnx = (new Object() {
                                          public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                             AbstractArrow entityToSpawn = new AscendantArrowEntity(
                                                (EntityType<? extends AscendantArrowEntity>)ArphexModEntities.ASCENDANT_ARROW.get(), level
                                             );
                                             entityToSpawn.setOwner(shooter);
                                             entityToSpawn.setBaseDamage((double)damage);
                                             entityToSpawn.setKnockback(knockback);
                                             entityToSpawn.setSilent(true);
                                             return entityToSpawn;
                                          }
                                       })
                                       .getArrow(projectileLevelx, entity, 5.0F, 4);
                                    _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                                    _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.0F);
                                    projectileLevelx.addFreshEntity(_entityToSpawnx);
                                 }

                                 if (!entity.level().isClientSide() && entity.getServer() != null) {
                                    entity.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                             CommandSource.NULL,
                                             entity.position(),
                                             entity.getRotationVector(),
                                             entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                             4,
                                             entity.getName().getString(),
                                             entity.getDisplayName(),
                                             entity.level().getServer(),
                                             entity
                                          ),
                                          "particle arphex:abyss_destruction "
                                             + entity.getX()
                                             + " "
                                             + (entity.getY() + 1.0)
                                             + " "
                                             + entity.getZ()
                                             + " "
                                             + (entity.getLookAngle().x * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                             + " "
                                             + (entity.getLookAngle().y * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                             + " "
                                             + (entity.getLookAngle().z * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                             + " 1 0 force"
                                       );
                                 }

                                 if (!entity.level().isClientSide() && entity.getServer() != null) {
                                    entity.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                             CommandSource.NULL,
                                             entity.position(),
                                             entity.getRotationVector(),
                                             entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                             4,
                                             entity.getName().getString(),
                                             entity.getDisplayName(),
                                             entity.level().getServer(),
                                             entity
                                          ),
                                          "particle arphex:heavy_red_smoke "
                                             + entity.getX()
                                             + " "
                                             + (entity.getY() + 1.0)
                                             + " "
                                             + entity.getZ()
                                             + " "
                                             + (entity.getLookAngle().x * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                             + " "
                                             + (entity.getLookAngle().y * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                             + " "
                                             + (entity.getLookAngle().z * 5.0 + Mth.nextDouble(RandomSource.create(), -0.02, 0.02))
                                             + " 1 0 force"
                                       );
                                 }
                              }
                           );
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 30, 0.3, 0.3, 0.3, 0.3);
                        }
                     }
                  }
               );
            }
         }
      }
   }
}
