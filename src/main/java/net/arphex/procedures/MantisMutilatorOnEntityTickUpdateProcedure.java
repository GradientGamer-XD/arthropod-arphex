package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.MantisMutilatorEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MantisMutilatorOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         boolean targetone = false;
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         entity.getPersistentData().putBoolean("arphex", true);
         if ((entity instanceof MantisMutilatorEntity _datEntS ? (String)_datEntS.getEntityData().get(MantisMutilatorEntity.DATA_variant) : "").equals("stick")
            )
          {
            if (world.isClientSide()) {
               if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F
                  < (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
                  if (entity instanceof MantisMutilatorEntity animatable) {
                     animatable.setTexture("stickmantis");
                  }
               } else if (entity instanceof MantisMutilatorEntity animatable) {
                  animatable.setTexture("stickmantislowhealth");
               }
            }
         } else if ((entity instanceof MantisMutilatorEntity _datEntSx ? (String)_datEntSx.getEntityData().get(MantisMutilatorEntity.DATA_variant) : "")
            .equals("orchid")) {
            if (world.isClientSide()) {
               if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) / 2.0F
                  < (entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F)) {
                  if (entity instanceof MantisMutilatorEntity animatable) {
                     animatable.setTexture("orchidmantismutilator");
                  }
               } else if (entity instanceof MantisMutilatorEntity animatable) {
                  animatable.setTexture("orchidmantislowhealth");
               }
            }
         } else if (world.isClientSide()) {
            if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMaxHealth() : -1.0F) / 2.0F
               < (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getHealth() : -1.0F)) {
               if (entity instanceof MantisMutilatorEntity animatable) {
                  animatable.setTexture("mantismutilator");
               }
            } else if (entity instanceof MantisMutilatorEntity animatable) {
               animatable.setTexture("mantismutilatorlowhealth");
            }
         }

         label469:
         if (!(entity.getPersistentData().getDouble("mantisnav") > 0.0)) {
            entity.getPersistentData().putDouble("mantisnav", 200.0);
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               break label469;
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), ex -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!found && entityiterator instanceof Player && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
                  found = true;
                  if (Math.atan2(entity.getX() - entityiterator.getX(), entity.getZ() - entityiterator.getZ()) * 57.5 - 0.0 + (double)entityiterator.getYRot()
                        < 90.0
                     && Math.atan2(entity.getX() - entityiterator.getX(), entity.getZ() - entityiterator.getZ()) * 57.5
                           - 0.0
                           + (double)entityiterator.getYRot()
                        > -90.0) {
                     if (entity.getDirection() == Direction.NORTH) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().moveTo(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ() + 50.0, 1.0);
                        }
                     } else if (entity.getDirection() == Direction.SOUTH) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().moveTo(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ() - 50.0, 1.0);
                        }
                     } else if (entity.getDirection() == Direction.EAST) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().moveTo(entityiterator.getX() - 50.0, entityiterator.getY(), entityiterator.getZ(), 1.0);
                        }
                     } else if (entity.getDirection() == Direction.WEST && entity instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(entityiterator.getX() + 50.0, entityiterator.getY(), entityiterator.getZ(), 1.0);
                     }
                  } else if (entity instanceof Mob _entity) {
                     _entity.getNavigation().moveTo(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 1.0);
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("mantisnav", entity.getPersistentData().getDouble("mantisnav") - 1.0);
         }

         if (entity.getPersistentData().getBoolean("noai_reset") && !entity.level().isClientSide() && entity.getServer() != null) {
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
                  "data modify entity @s NoAI set value 0b"
               );
         }

         if (!(entity.getPersistentData().getDouble("checkangle") > 0.0)) {
            if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
               && !entity.isVehicle()
               && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY() > entity.getY() + 2.0) {
               if (!world.isClientSide()) {
                  entity.getPersistentData().putBoolean("noai_reset", true);
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
                           "data modify entity @s NoAI set value 1b"
                        );
                  }

                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ()
                     )
                  );
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
                           "data modify entity @s NoAI set value 0b"
                        );
                  }

                  entity.getPersistentData().putBoolean("noai_reset", false);
               }

               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                     0.7,
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                  )
               );
            }

            if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame()) && entity.getDisplayName().getString().equals("Mantis Mutilator")) {
               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).isEmpty()) {
                  ArphexMod.queueServerWork(
                     20,
                     () -> {
                        if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), ex -> true).isEmpty()
                           && !entity.level().isClientSide()) {
                           entity.discard();
                        }
                     }
                  );
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true).isEmpty()
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")
                  && (
                     !(
                           Math.atan2(
                                       entity.getX()
                                          - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true)
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null)
                                             .getX(),
                                       entity.getZ()
                                          - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true)
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null)
                                             .getZ()
                                    )
                                    * 57.5
                                 - 0.0
                                 + (double)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getYRot()
                              < 90.0
                        )
                        || !(
                           Math.atan2(
                                       entity.getX()
                                          - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true)
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null)
                                             .getX(),
                                       entity.getZ()
                                          - world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true)
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null)
                                             .getZ()
                                    )
                                    * 57.5
                                 - 0.0
                                 + (double)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getYRot()
                              > -90.0
                        )
                  )
                  && entity instanceof Mob _entity) {
                  Entity var71 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (var71 instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               }
            }

            entity.getPersistentData().putDouble("checkangle", 20.0);
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
               if (entity instanceof TamableAnimal _tamEnt
                  && _tamEnt.isTame()
                  && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Player
                  && entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var32) {
                     var32.printStackTrace();
                  }
               }

               if ((!(entity instanceof LivingEntity _livEnt124) || !_livEnt124.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get()))
                  && (
                     (
                              (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof LivingEntity _livEntxxxxxx
                                 ? _livEntxxxxxx.getHealth()
                                 : -1.0F
                           )
                           > 19.0F
                        || (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Player
                  )) {
                  if (Math.atan2(
                                 entity.getX() - (entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getX(),
                                 entity.getZ() - (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getZ()
                              )
                              * 57.5
                           - 0.0
                           + (double)(entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getYRot()
                        < 90.0
                     && Math.atan2(
                                 entity.getX() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX(),
                                 entity.getZ() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ()
                              )
                              * 57.5
                           - 0.0
                           + (double)(entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getYRot()
                        > -90.0) {
                     if (entity instanceof Mob) {
                        try {
                           ((Mob)entity).setTarget(null);
                        } catch (Exception var31) {
                           var31.printStackTrace();
                        }
                     }
                  } else if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                     _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2, false, false));
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("checkangle", entity.getPersistentData().getDouble("checkangle") - 1.0);
         }

         if (entity instanceof TamableAnimal _tamEntxx
            && _tamEntxx.isTame()
            && (entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null) != null
            && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null)
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var30) {
               var30.printStackTrace();
            }
         }

         if (!entity.onGround()
            && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            && entity instanceof LivingEntity _entityx
            && !_entityx.level().isClientSide()) {
            _entityx.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false));
         }

         if ((!(entity instanceof LivingEntity _livEnt161) || !_livEnt161.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entityx
            && !_entityx.level().isClientSide()) {
            _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 0, false, false));
         }

         if (entity.isVehicle()
            && entity.getFirstPassenger() != null
            && (
               !(entity instanceof TamableAnimal _tamIsTamedBy)
                  || !(entity.getFirstPassenger() instanceof LivingEntity _livEntxxxxxxx)
                  || !_tamIsTamedBy.isOwnedBy(_livEntxxxxxxx)
            )) {
            entity.getFirstPassenger().stopRiding();
         }

         entity.setMaxUpStep(1.5F);
         if ((entity instanceof MantisMutilatorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(MantisMutilatorEntity.DATA_timeloop) : 0) <= 0) {
            if (entity instanceof MantisMutilatorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(MantisMutilatorEntity.DATA_timeloop, Mth.nextInt(RandomSource.create(), 2400, 3600));
            }
         } else if (entity instanceof MantisMutilatorEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  MantisMutilatorEntity.DATA_timeloop,
                  (entity instanceof MantisMutilatorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(MantisMutilatorEntity.DATA_timeloop) : 0) - 1
               );
         }

         if ((entity instanceof MantisMutilatorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(MantisMutilatorEntity.DATA_timeloop) : 0) > 3000
            && entity.getDeltaMovement().x() + entity.getDeltaMovement().z() == 0.0) {
            entity.setSprinting(true);
         } else {
            entity.setSprinting(false);
         }
      }
   }
}
