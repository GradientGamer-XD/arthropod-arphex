package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.HornetProjectileEntity;
import net.arphex.entity.NemesisProjectileEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class HornetProjectileOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ArphexMod.queueServerWork(5, () -> {
            if (entity instanceof HornetProjectileEntity) {
               if (entity instanceof HornetProjectileEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(HornetProjectileEntity.DATA_scale_switch, 1);
               }
            } else if (entity instanceof NemesisProjectileEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(NemesisProjectileEntity.DATA_scale_switch, 1);
            }
         });
         if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == null) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
               if (entity instanceof TamableAnimal _toTame) {
                  Entity _center = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_center instanceof Player _owner) {
                     _toTame.tame(_owner);
                  }
               }

               entity.getPersistentData()
                  .putString(
                     "hornetlock_uuids",
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getString("hornetlock_uuids")
                  );
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               ArphexMod.queueServerWork(5, () -> {
                  if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 50, 0.1, 0.1, 0.1, 0.5);
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               });
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entity.getPersistentData().getString("hornetlock_uuids").contains(entityiterator.getStringUUID()) && entity != entityiterator) {
                     if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                     }
                     break;
                  }
               }
            } else if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).isAlive()) {
               if (!(entity.getPersistentData().getDouble("boostlim_wasp") > 0.0)) {
                  if (!world.isClientSide()) {
                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                        )
                     );
                  }

                  entity.setDeltaMovement(new Vec3(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z));
                  entity.getPersistentData().putDouble("boostlim_wasp", (double)Mth.nextInt(RandomSource.create(), 10, 30));
               } else {
                  entity.getPersistentData().putDouble("boostlim_wasp", entity.getPersistentData().getDouble("boostlim_wasp") - 1.0);
               }
            } else {
               if (entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var17) {
                     var17.printStackTrace();
                  }
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entity.getPersistentData().getString("hornetlock_uuids").contains(entityiteratorx.getStringUUID()) && entity != entityiteratorx) {
                     if (entity instanceof Mob _entity && entityiteratorx instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                     }
                     break;
                  }
               }
            }

            if (entity.getPersistentData().getString("hornetlock_uuids").length() < 4 && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.6, 0.6, 0.6, 0.1);
         }

         if (!(entity.getPersistentData().getDouble("lifelim_wasp") > 0.0)) {
            entity.getPersistentData().putDouble("lifelim_wasp", 0.0);
         } else {
            entity.getPersistentData().putDouble("lifelim_wasp", entity.getPersistentData().getDouble("lifelim_wasp") + 1.0);
         }

         if (entity.getPersistentData().getDouble("lifelim_wasp") > 400.0) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 50, 0.1, 0.1, 0.1, 0.5);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeAllEffects();
         }
      }
   }
}
