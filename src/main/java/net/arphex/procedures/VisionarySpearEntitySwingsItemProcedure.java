package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.ChronoSpearShotEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class VisionarySpearEntitySwingsItemProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         ArphexMod.queueServerWork(
            1,
            () -> {
               if ((!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
                  && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VISIONARY_SPEAR.get()
                  && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VISIONARY_SPEAR.get()) {
                  if (entity instanceof Player _player) {
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
                  }

                  Level projectileLevel = entity.level();
                  if (!projectileLevel.isClientSide()) {
                     Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new ChronoSpearShotEntity(
                                 (EntityType<? extends ChronoSpearShotEntity>)ArphexModEntities.CHRONO_SPEAR_SHOT.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              return entityToSpawn;
                           }
                        })
                        .getArrow(projectileLevel, entity, 20.0F, 1);
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2.0F, 0.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }
            }
         );
      }
   }
}
