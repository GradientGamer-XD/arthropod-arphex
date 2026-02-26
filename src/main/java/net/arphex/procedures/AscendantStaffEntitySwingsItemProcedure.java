package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.OpalArrowEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AscendantStaffEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
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
            ArphexMod.queueServerWork(
               1,
               () -> {
                  if ((!(entity instanceof Player _plrCldCheck2) || !_plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))
                     && !(entity.getPersistentData().getDouble("openhit") > 0.0)) {
                     Level projectileLevel = entity.level();
                     if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new OpalArrowEntity(
                                 (EntityType<? extends OpalArrowEntity>)ArphexModEntities.OPAL_ARROW.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              return entityToSpawn;
                           }
                        }).getArrow(projectileLevel, entity, 1.0F, 1);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.6F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }

                     if (entity instanceof Player _player) {
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 19);
                     }
                  }
               }
            );
         }
      }
   }
}
