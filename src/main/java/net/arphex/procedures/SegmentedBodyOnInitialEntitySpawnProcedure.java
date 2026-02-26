package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.ArthropleuraAbominationEntity;
import net.arphex.entity.SegmentedBodyEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SegmentedBodyOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean foundbodyneedingsegment = false;
         double segmentchoose = 0.0;
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
                  "data merge entity @s {NoAI:1}"
               );
         }

         if (entity instanceof SegmentedBodyEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SegmentedBodyEntity.DATA_segmentnum_arphex, 0);
         }

         if (!world.isClientSide()) {
            entity.getPersistentData().putDouble("segmentcooldown", 15.0);
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator != entity && entityiterator instanceof SegmentedBodyEntity && entityiterator.isAlive()) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt7 = (LivingEntity)entityiterator;
                     if (_livEnt7.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                        continue;
                     }
                  }

                  if (entity instanceof SegmentedBodyEntity _datEntSetS) {
                     _datEntSetS.getEntityData()
                        .set(
                           SegmentedBodyEntity.DATA_uuid_map,
                           entityiterator instanceof SegmentedBodyEntity _datEntS
                              ? (String)_datEntS.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map)
                              : ""
                        );
                  }

                  if ((entityiterator instanceof SegmentedBodyEntity _datEntSx ? (String)_datEntSx.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")
                        .equals(entity instanceof SegmentedBodyEntity _datEntS ? _datEntS.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")
                     && (
                           entityiterator instanceof SegmentedBodyEntity _datEntIx
                              ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                              : 0
                        )
                        > (
                           entity instanceof SegmentedBodyEntity _datEntI
                              ? (Integer)_datEntI.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                              : 0
                        )) {
                     entity.getPersistentData().putBoolean("activated_arphsegment", true);
                     if (entity instanceof SegmentedBodyEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              SegmentedBodyEntity.DATA_segmentnum_arphex,
                              (
                                    entityiterator instanceof SegmentedBodyEntity _datEntIxx
                                       ? (Integer)_datEntIxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                                       : 0
                                 )
                                 + 1
                           );
                     }
                  }
               }
            }

            if (!entity.getPersistentData().getBoolean("activated_arphsegment")) {
               if (!world.getEntitiesOfClass(ArthropleuraAbominationEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                  entity.getPersistentData().putBoolean("activated_arphsegment", true);
                  if (entity instanceof SegmentedBodyEntity _datEntSetS) {
                     _datEntSetS.getEntityData()
                        .set(
                           SegmentedBodyEntity.DATA_uuid_map,
                           world.getEntitiesOfClass(ArthropleuraAbominationEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getStringUUID()
                        );
                  }

                  if (entity instanceof SegmentedBodyEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SegmentedBodyEntity.DATA_segmentnum_arphex, 1);
                  }
               } else {
                  entity.getPersistentData().putBoolean("despawnsegmentarph", true);
               }
            }
         }
      }
   }
}
