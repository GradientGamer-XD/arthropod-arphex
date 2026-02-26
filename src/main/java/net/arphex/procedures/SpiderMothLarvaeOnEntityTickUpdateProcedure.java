package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.SpiderMothLarvaeEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderMothLarvaeOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("rushtime") > 0.0) {
            entity.getPersistentData().putDouble("rushtime", entity.getPersistentData().getDouble("rushtime") - 1.0);
         } else {
            entity.getPersistentData().putDouble("rushtime", 400.0);
         }

         if (entity instanceof SpiderMothLarvaeEntity) {
            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get());
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.WITHER);
            }
         }

         if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true).isEmpty()) {
            Entity e = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((e instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null && entity instanceof Mob _entity) {
               Entity var13 = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), ex -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var13 instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }
         }

         if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Player
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), ex -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), ex -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var14) {
               var14.printStackTrace();
            }
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 4.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 5.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 6.0, z))) {
            entity.setSprinting(true);
         } else {
            entity.setSprinting(false);
         }

         if (!entity.getPersistentData().getBoolean("despawnedrider")) {
            entity.getPersistentData().putBoolean("despawnedrider", true);
            if (entity.isVehicle() && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }
         }
      }
   }
}
