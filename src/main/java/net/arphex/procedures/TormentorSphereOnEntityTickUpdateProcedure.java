package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.TormentorTendrilEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentorSphereOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double ringspan = 0.0;
         double ringspin = 0.0;
         boolean scansnearestfirst = false;
         boolean onecheck = false;
         entity.getPersistentData().putBoolean("tormentor_summon", true);
         entity.noPhysics = true;
         if ((entity instanceof TormentorSphereEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSphereEntity.DATA_wait_check) : 0) > 300) {
            if ((entity instanceof TormentorSphereEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0) < 1) {
               if (entity instanceof TormentorSphereEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorSphereEntity.DATA_growsize, 1);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (entity instanceof TormentorSphereEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  TormentorSphereEntity.DATA_wait_check,
                  (entity instanceof TormentorSphereEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorSphereEntity.DATA_wait_check) : 0) + 1
               );
         }

         if (entity.isAlive()) {
            if (!entity.getPersistentData().getBoolean("donepos")) {
               entity.setYRot((float)ArphexModVariables.MapVariables.get(world).tormentor_rotation);
               entity.setXRot(45.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity _entity) {
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(400.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (!onecheck
                     && entityiterator.getPersistentData().getBoolean("tormentor_target")
                     && !(
                        ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .tormentor_respite
                           > 0.0
                     )) {
                     entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()));
                     entity.getPersistentData().putDouble("targety", entityiterator.getY());
                     onecheck = true;
                     break;
                  }
               }
            }

            entity.getPersistentData().putBoolean("donepos", true);
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 60, 0, true, false));
            }

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
                     "tp @s ^ ^ ^" + (0.2 + ArphexModVariables.MapVariables.get(world).tormentor_tier / 3.5)
                  );
            }

            if ((entity instanceof TormentorSphereEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0) > 2000) {
               entity.teleportTo(entity.getX(), entity.getY() - 0.8, entity.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() - 0.8, entity.getZ(), entity.getYRot(), entity.getXRot());
               }
            } else {
               entity.teleportTo(entity.getX(), entity.getY() - (entity.getY() - entity.getPersistentData().getDouble("targety")) / 50.0, entity.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        entity.getX(),
                        entity.getY() - (entity.getY() - entity.getPersistentData().getDouble("targety")) / 50.0,
                        entity.getZ(),
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }
            }

            if ((entity instanceof TormentorSphereEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0) < 0
               && entity instanceof TormentorSphereEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(TormentorSphereEntity.DATA_growsize, 0);
            }

            label292: {
               if (entity instanceof TormentorSphereEntity _datEntL35 && (Boolean)_datEntL35.getEntityData().get(TormentorSphereEntity.DATA_donesize)) {
                  if ((entity instanceof TormentorSphereEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0)
                        < 105
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }

                  if ((entity instanceof TormentorSphereEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0)
                           - 100
                        > 1
                     && entity instanceof TormentorSphereEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           TormentorSphereEntity.DATA_growsize,
                           (
                                 entity instanceof TormentorSphereEntity _datEntIxxx
                                    ? (Integer)_datEntIxxx.getEntityData().get(TormentorSphereEntity.DATA_growsize)
                                    : 0
                              )
                              - 100
                        );
                  }
                  break label292;
               }

               if ((entity instanceof TormentorSphereEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0)
                  > 3500) {
                  if (entity instanceof TormentorSphereEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(TormentorSphereEntity.DATA_donesize, true);
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
                  if (entity instanceof TormentorSphereEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           TormentorSphereEntity.DATA_growsize,
                           (
                                 entity instanceof TormentorSphereEntity _datEntIxxx
                                    ? (Integer)_datEntIxxx.getEntityData().get(TormentorSphereEntity.DATA_growsize)
                                    : 0
                              )
                              + 10
                        );
                  }
               } else if (entity instanceof TormentorSphereEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorSphereEntity.DATA_growsize,
                        (
                              entity instanceof TormentorSphereEntity _datEntIxxx
                                 ? (Integer)_datEntIxxx.getEntityData().get(TormentorSphereEntity.DATA_growsize)
                                 : 0
                           )
                           + 15
                     );
               }
            }

            label294: {
               if (entity instanceof TormentorSphereEntity _datEntL47 && (Boolean)_datEntL47.getEntityData().get(TormentorSphereEntity.DATA_donesize)) {
                  ArphexMod.queueServerWork(100, () -> {
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  });
                  break label294;
               }

               if (!world.isEmptyBlock(BlockPos.containing(x, y, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y - 4.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y - 5.0, z))) {
                  if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_GRIEFING.get()) {
                     ArphexMod.queueServerWork(
                        1,
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "summon fireball ~ ~ ~ {Motion:[0d,-10d],ExplosionPower:"
                                       + Math.max(
                                          15L,
                                          Math.round(
                                             ArphexModVariables.MapVariables.get(world).tormentor_tier
                                                * (5.0 + 4.0 * ArphexModVariables.MapVariables.get(world).tormentor_tier)
                                          )
                                       )
                                       + "}"
                                 );
                           }

                           ArphexMod.queueServerWork(
                              1,
                              () -> {
                                 if (world instanceof ServerLevel _levelx) {
                                    Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                                       .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                       entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                    }
                                 }

                                 ArphexMod.queueServerWork(
                                    1,
                                    () -> {
                                       if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                                          .isEmpty()) {
                                          Entity patt9898$temp = world.getEntitiesOfClass(
                                                SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true
                                             )
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null);
                                          if (patt9898$temp instanceof SphereAnimEntity _datEntSetI) {
                                             _datEntSetI.getEntityData()
                                                .set(SphereAnimEntity.DATA_max_size, (int)(ArphexModVariables.MapVariables.get(world).tormentor_tier * 400.0));
                                          }

                                          patt9898$temp = world.getEntitiesOfClass(
                                                SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true
                                             )
                                             .stream()
                                             .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                   return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                             }).compareDistOf(x, y, z))
                                             .findFirst()
                                             .orElse(null);
                                          if (patt9898$temp instanceof SphereAnimEntity _datEntSetS) {
                                             _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "white");
                                          }
                                       }
                                    }
                                 );
                              }
                           );
                        }
                     );
                  }

                  if (entity instanceof TormentorSphereEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(TormentorSphereEntity.DATA_donesize, true);
                  }
               }
            }

            if (!(entity.getPersistentData().getDouble("spherelim") > 0.0)) {
               entity.getPersistentData().putDouble("spherelim", 14.0);
               Vec3 _center = new Vec3(x, y, z);

               TormentorSphereEntity _datEntIxxx;
               for (Entity entityiteratorx : world.getEntitiesOfClass(
                     Entity.class,
                     new AABB(_center, _center)
                        .inflate(
                           (double)(
                                 5L
                                    + Math.round(
                                       (double)(
                                             entity instanceof TormentorSphereEntity _datEntIxxx
                                                ? (Integer)_datEntIxxx.getEntityData().get(TormentorSphereEntity.DATA_growsize)
                                                : 0
                                          )
                                          / 21.75
                                    )
                              )
                              / 2.0
                        ),
                     e -> true
                  )
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx instanceof LivingEntity
                     && !(entityiteratorx instanceof TormentorSphereEntity)
                     && !entityiteratorx.getPersistentData().getBoolean("tormentor_summon")
                     && !entityiteratorx.getPersistentData().getBoolean("creativespectator")
                     && !(entityiteratorx instanceof TormentorTendrilEntity)
                     && !(entityiteratorx instanceof TORMENTOREntity)) {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles(
                           (SimpleParticleType)ArphexModParticleTypes.HUGE_FIRE.get(),
                           entityiteratorx.getX(),
                           entityiteratorx.getY(),
                           entityiteratorx.getZ(),
                           1,
                           0.0,
                           0.0,
                           0.0,
                           0.2
                        );
                     }

                     if (entityiteratorx instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiteratorx;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10, 0, false, false));
                        }
                     }

                     entityiteratorx.getPersistentData().putDouble("tormentburntime", entityiteratorx.getPersistentData().getDouble("tormentburntime") + 25.0);
                     if (entityiteratorx instanceof Player && entityiteratorx instanceof Player) {
                        Player _player = (Player)entityiteratorx;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("You feel yourself melting from the inside out... ESCAPE!"), true);
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("spherelim", entity.getPersistentData().getDouble("spherelim") - 1.0);
            }

            if (entity.isInWall() && !entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

         if (world.isClientSide()) {
            if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
               if (entity instanceof TormentorSphereEntity tormentor) {
                  tormentor.getPersistentData().putString("glowTexture", "tormentsphere");
               }
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
               if (entity instanceof TormentorSphereEntity tormentor) {
                  tormentor.getPersistentData().putString("glowTexture", "torment_neutron_sphere");
               }
            } else if (entity instanceof TormentorSphereEntity) {
               entity.getPersistentData().putString("glowTexture", "tormentor_magnetar_sphere");
            }

            if ((entity instanceof TormentorSphereEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(TormentorSphereEntity.DATA_growsize) : 0)
               > 3250) {
               if (entity instanceof TormentorSphereEntity animatable) {
                  animatable.setTexture("black");
               }
            } else if (entity instanceof TormentorSphereEntity animatable) {
               animatable.setTexture("tormentsphere");
            }
         }
      }
   }
}
