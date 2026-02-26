package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTestEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorTestOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("unique_separator", Mth.nextDouble(RandomSource.create(), -9999999.0, 9999999.0));
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
            if (entity instanceof TormentorTestEntity) {
               if (entity instanceof TormentorTestEntity _datEntSetS) {
                  _datEntSetS.getEntityData()
                     .set(
                        TormentorTestEntity.DATA_uuid_target,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getStringUUID()
                     );
               }
            } else if (entity instanceof TormentorT2Entity) {
               if (entity instanceof TormentorT2Entity _datEntSetS) {
                  _datEntSetS.getEntityData()
                     .set(
                        TormentorT2Entity.DATA_uuid_target,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getStringUUID()
                     );
               }
            } else if (entity instanceof TormentorT3Entity) {
               if (entity instanceof TormentorT3Entity _datEntSetS) {
                  _datEntSetS.getEntityData()
                     .set(
                        TormentorT3Entity.DATA_uuid_target,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getStringUUID()
                     );
               }
            } else if (entity instanceof TormentorT4Entity) {
               if (entity instanceof TormentorT4Entity _datEntSetS) {
                  _datEntSetS.getEntityData()
                     .set(
                        TormentorT4Entity.DATA_uuid_target,
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getStringUUID()
                     );
               }
            } else if (entity instanceof TormentorT5Entity && entity instanceof TormentorT5Entity _datEntSetS) {
               _datEntSetS.getEntityData()
                  .set(
                     TormentorT5Entity.DATA_uuid_target,
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getStringUUID()
                  );
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
