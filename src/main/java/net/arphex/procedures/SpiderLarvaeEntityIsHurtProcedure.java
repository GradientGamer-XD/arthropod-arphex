package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.SpiderLarvaeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderLarvaeEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof SpiderLarvaeEntity) {
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) * 0.1,
                     0.5,
                     Math.sin((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) * 0.1
                  )
               );
            } else if (!entity.getPersistentData().getBoolean("spidergrab")) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) * 0.1,
                     0.5,
                     Math.sin((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) * 0.1
                  )
               );
            }
         }

         entity.setSprinting(true);
         ArphexMod.queueServerWork(20, () -> entity.setSprinting(false));
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) < 3.0F
            && (entity instanceof SpiderLarvaeEntity animatablex ? animatablex.getTexture() : "null").equals("spiderwidow")
            && entity instanceof SpiderLarvaeEntity animatable) {
            animatable.setTexture("spiderwidowmissinglegs");
         }
      }
   }
}
