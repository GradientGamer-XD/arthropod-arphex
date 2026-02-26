package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTestEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorScareProceedProcedure {
   public static Entity execute(LevelAccessor world, double x, double y, double z) {
      Entity nearest_tormentor_at_tier = null;
      if (ArphexModVariables.MapVariables.get(world).tormentor_tier < 2.0) {
         nearest_tormentor_at_tier = world.getEntitiesOfClass(TormentorTestEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (nearest_tormentor_at_tier == null) {
            return nearest_tormentor_at_tier;
         } else {
            return world instanceof Level _level ? new TORMENTOREntity((EntityType<TORMENTOREntity>)ArphexModEntities.TORMENTOR.get(), _level) : null;
         }
      } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier < 3.0) {
         nearest_tormentor_at_tier = world.getEntitiesOfClass(TormentorT2Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (nearest_tormentor_at_tier == null) {
            return nearest_tormentor_at_tier;
         } else {
            return world instanceof Level _level ? new TormentorT2Entity((EntityType<TormentorT2Entity>)ArphexModEntities.TORMENTOR_T_2.get(), _level) : null;
         }
      } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier < 4.0) {
         nearest_tormentor_at_tier = world.getEntitiesOfClass(TormentorT3Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (nearest_tormentor_at_tier == null) {
            return nearest_tormentor_at_tier;
         } else {
            return world instanceof Level _level ? new TormentorT3Entity((EntityType<TormentorT3Entity>)ArphexModEntities.TORMENTOR_T_3.get(), _level) : null;
         }
      } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier < 5.0) {
         nearest_tormentor_at_tier = world.getEntitiesOfClass(TormentorT4Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (nearest_tormentor_at_tier == null) {
            return nearest_tormentor_at_tier;
         } else {
            return world instanceof Level _level ? new TORMENTOREntity((EntityType<TORMENTOREntity>)ArphexModEntities.TORMENTOR.get(), _level) : null;
         }
      } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier < 6.0) {
         nearest_tormentor_at_tier = world.getEntitiesOfClass(TormentorT5Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
            .stream()
            .sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z))
            .findFirst()
            .orElse(null);
         if (nearest_tormentor_at_tier == null) {
            return nearest_tormentor_at_tier;
         } else {
            return world instanceof Level _level ? new TormentorT5Entity((EntityType<TormentorT5Entity>)ArphexModEntities.TORMENTOR_T_5.get(), _level) : null;
         }
      } else {
         return world instanceof Level _level ? new TormentorTestEntity((EntityType<TormentorTestEntity>)ArphexModEntities.TORMENTOR_TEST.get(), _level) : null;
      }
   }
}
