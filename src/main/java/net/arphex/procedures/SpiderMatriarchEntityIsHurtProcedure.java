package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMatriarchEntity;
import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderMatriarchEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
            && (entity instanceof SpiderMatriarchEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderMatriarchEntity.DATA_eggs_grow) : 0) > 998) {
            if (entity instanceof SpiderMatriarchEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SpiderMatriarchEntity.DATA_eggs_grow, 0);
            }

            for (int index0 = 0; index0 < 6; index0++) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MATRIARCH_LARVAE.get())
                     .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.3, 0.3), 0.0, Mth.nextDouble(RandomSource.create(), -0.3, 0.3));
                  }
               }
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof SpiderMatriarchLarvaeEntity) {
                        if (entityiterator instanceof SpiderMatriarchLarvaeEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderMatriarchLarvaeEntity.DATA_grow, Mth.nextInt(RandomSource.create(), 300, 9000));
                        }

                        if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null && entityiterator instanceof Mob) {
                           Mob _entity = (Mob)entityiterator;
                           Entity patt2637$temp = entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null;
                           if (patt2637$temp instanceof LivingEntity _ent) {
                              _entity.setTarget(_ent);
                           }
                        }
                     }
                  }
               }
            );
         }

         if (entity instanceof SpiderMatriarchEntity _datEntSetL) {
            _datEntSetL.getEntityData().set(SpiderMatriarchEntity.DATA_done_rot_clay, true);
         }
      }
   }
}
