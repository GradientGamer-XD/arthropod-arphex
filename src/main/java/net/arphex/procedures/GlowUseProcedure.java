package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GlowUseProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      boolean glowup = false;
      if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
         Entity var9 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).stream().sorted((new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
            }
         }).compareDistOf(x, y, z)).findFirst().orElse(null);
         if (var9 instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
            glowup = true;
            return glowup;
         }

         glowup = false;
      } else {
         glowup = false;
      }

      return glowup;
   }
}
