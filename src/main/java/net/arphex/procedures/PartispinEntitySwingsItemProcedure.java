package net.arphex.procedures;

import net.arphex.entity.SpinpartitestEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class PartispinEntitySwingsItemProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         Level projectileLevel = entity.level();
         if (!projectileLevel.isClientSide()) {
            Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new SpinpartitestEntity(
                        (EntityType<? extends SpinpartitestEntity>)ArphexModEntities.SPINPARTITEST.get(), level
                     );
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     return entityToSpawn;
                  }
               })
               .getArrow(projectileLevel, 5.0F, 1);
            _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }
   }
}
