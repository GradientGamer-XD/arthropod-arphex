package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTestEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorTestOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean player_exists = false;
         if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
            if (entity instanceof TormentorTestEntity) {
               if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
                  TormentorTestEntity tormentor = (TormentorTestEntity)entity;
                  tormentor.deathTime = 0;
               }

               for (Entity entityiterator : new ArrayList(world.players())) {
                  if ((entity instanceof TormentorTestEntity _datEntS ? (String)_datEntS.getEntityData().get(TormentorTestEntity.DATA_uuid_target) : "")
                     .equals(entityiterator.getStringUUID())) {
                     player_exists = true;
                     entity.setDeltaMovement(
                        new Vec3(entityiterator.getDeltaMovement().x(), entityiterator.getDeltaMovement().y(), entityiterator.getDeltaMovement().z())
                     );
                     entity.teleportTo(entityiterator.getX(), entityiterator.getY() + 0.7, entityiterator.getZ());
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(entityiterator.getX(), entityiterator.getY() + 0.7, entityiterator.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               if ((entity instanceof TormentorTestEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorTestEntity.DATA_big_attack) : 0) > 0
                  && entity instanceof TormentorTestEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorTestEntity.DATA_big_attack,
                        (entity instanceof TormentorTestEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorTestEntity.DATA_big_attack) : 0) - 1
                     );
               }

               if ((entity instanceof TormentorTestEntity _datEntSx ? (String)_datEntSx.getEntityData().get(TormentorTestEntity.DATA_uuid_target) : "")
                     .equals("none")
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
            if (entity instanceof TormentorT2Entity) {
               if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
                  TormentorT2Entity tormentor = (TormentorT2Entity)entity;
                  tormentor.deathTime = 0;
               }

               for (Entity entityiteratorx : new ArrayList(world.players())) {
                  if ((entity instanceof TormentorT2Entity _datEntSx ? (String)_datEntSx.getEntityData().get(TormentorT2Entity.DATA_uuid_target) : "")
                     .equals(entityiteratorx.getStringUUID())) {
                     player_exists = true;
                     entity.setDeltaMovement(
                        new Vec3(entityiteratorx.getDeltaMovement().x(), entityiteratorx.getDeltaMovement().y(), entityiteratorx.getDeltaMovement().z())
                     );
                     entity.teleportTo(entityiteratorx.getX(), entityiteratorx.getY() + 0.7, entityiteratorx.getZ());
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(entityiteratorx.getX(), entityiteratorx.getY() + 0.7, entityiteratorx.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               if ((entity instanceof TormentorT2Entity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorT2Entity.DATA_big_attack) : 0) > 0
                  && entity instanceof TormentorT2Entity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorT2Entity.DATA_big_attack,
                        (entity instanceof TormentorT2Entity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorT2Entity.DATA_big_attack) : 0) - 1
                     );
               }

               if ((entity instanceof TormentorT2Entity _datEntSxx ? (String)_datEntSxx.getEntityData().get(TormentorT2Entity.DATA_uuid_target) : "")
                     .equals("none")
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
            if (entity instanceof TormentorT3Entity) {
               if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
                  TormentorT3Entity tormentor = (TormentorT3Entity)entity;
                  tormentor.deathTime = 0;
               }

               for (Entity entityiteratorxx : new ArrayList(world.players())) {
                  if ((entity instanceof TormentorT3Entity _datEntSxx ? (String)_datEntSxx.getEntityData().get(TormentorT3Entity.DATA_uuid_target) : "")
                     .equals(entityiteratorxx.getStringUUID())) {
                     player_exists = true;
                     entity.setDeltaMovement(
                        new Vec3(entityiteratorxx.getDeltaMovement().x(), entityiteratorxx.getDeltaMovement().y(), entityiteratorxx.getDeltaMovement().z())
                     );
                     entity.teleportTo(entityiteratorxx.getX(), entityiteratorxx.getY() + 0.7, entityiteratorxx.getZ());
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(entityiteratorxx.getX(), entityiteratorxx.getY() + 0.7, entityiteratorxx.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               if ((entity instanceof TormentorT3Entity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorT3Entity.DATA_big_attack) : 0) > 0
                  && entity instanceof TormentorT3Entity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorT3Entity.DATA_big_attack,
                        (entity instanceof TormentorT3Entity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorT3Entity.DATA_big_attack) : 0) - 1
                     );
               }

               if ((entity instanceof TormentorT3Entity _datEntSxxx ? (String)_datEntSxxx.getEntityData().get(TormentorT3Entity.DATA_uuid_target) : "")
                     .equals("none")
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
            if (entity instanceof TormentorT4Entity) {
               if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
                  TormentorT4Entity tormentor = (TormentorT4Entity)entity;
                  tormentor.deathTime = 0;
               }

               for (Entity entityiteratorxxx : new ArrayList(world.players())) {
                  if ((entity instanceof TormentorT4Entity _datEntSxxx ? (String)_datEntSxxx.getEntityData().get(TormentorT4Entity.DATA_uuid_target) : "")
                     .equals(entityiteratorxxx.getStringUUID())) {
                     player_exists = true;
                     entity.setDeltaMovement(
                        new Vec3(entityiteratorxxx.getDeltaMovement().x(), entityiteratorxxx.getDeltaMovement().y(), entityiteratorxxx.getDeltaMovement().z())
                     );
                     entity.teleportTo(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 0.7, entityiteratorxxx.getZ());
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 0.7, entityiteratorxxx.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               if ((entity instanceof TormentorT4Entity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorT4Entity.DATA_big_attack) : 0) > 0
                  && entity instanceof TormentorT4Entity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorT4Entity.DATA_big_attack,
                        (entity instanceof TormentorT4Entity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorT4Entity.DATA_big_attack) : 0) - 1
                     );
               }

               if ((entity instanceof TormentorT4Entity _datEntSxxxx ? (String)_datEntSxxxx.getEntityData().get(TormentorT4Entity.DATA_uuid_target) : "")
                     .equals("none")
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0) {
            if (entity instanceof TormentorT5Entity) {
               if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
                  TormentorT5Entity tormentor = (TormentorT5Entity)entity;
                  tormentor.deathTime = 0;
               }

               for (Entity entityiteratorxxxx : new ArrayList(world.players())) {
                  if ((entity instanceof TormentorT5Entity _datEntSxxxx ? (String)_datEntSxxxx.getEntityData().get(TormentorT5Entity.DATA_uuid_target) : "")
                     .equals(entityiteratorxxxx.getStringUUID())) {
                     player_exists = true;
                     entity.setDeltaMovement(
                        new Vec3(
                           entityiteratorxxxx.getDeltaMovement().x(), entityiteratorxxxx.getDeltaMovement().y(), entityiteratorxxxx.getDeltaMovement().z()
                        )
                     );
                     entity.teleportTo(entityiteratorxxxx.getX(), entityiteratorxxxx.getY() + 0.7, entityiteratorxxxx.getZ());
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(entityiteratorxxxx.getX(), entityiteratorxxxx.getY() + 0.7, entityiteratorxxxx.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               if ((entity instanceof TormentorT5Entity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorT5Entity.DATA_big_attack) : 0) > 0
                  && entity instanceof TormentorT5Entity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorT5Entity.DATA_big_attack,
                        (entity instanceof TormentorT5Entity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorT5Entity.DATA_big_attack) : 0) - 1
                     );
               }

               if ((entity instanceof TormentorT5Entity _datEntSxxxxx ? (String)_datEntSxxxxx.getEntityData().get(TormentorT5Entity.DATA_uuid_target) : "")
                     .equals("none")
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

         if (!player_exists && !entity.level().isClientSide()) {
            entity.discard();
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
                  "data merge entity @s {NoAI:1}"
               );
         }

         player_exists = false;
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiteratorxxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiteratorxxxxx != entity) {
               if (entity instanceof TormentorTestEntity) {
                  if (entityiteratorxxxxx instanceof TormentorTestEntity
                     && entity.getPersistentData().getDouble("unique_separator") > entityiteratorxxxxx.getPersistentData().getDouble("unique_separator")
                     && (entity instanceof TormentorTestEntity _datEntSxxxxxx
                           ? (String)_datEntSxxxxxx.getEntityData().get(TormentorTestEntity.DATA_uuid_target)
                           : "")
                        .equals(
                           entityiteratorxxxxx instanceof TormentorTestEntity _datEntSxxxxx
                              ? _datEntSxxxxx.getEntityData().get(TormentorTestEntity.DATA_uuid_target)
                              : ""
                        )
                     && !entityiteratorxxxxx.level().isClientSide()) {
                     entityiteratorxxxxx.discard();
                  }
               } else if (entity instanceof TormentorT2Entity) {
                  if (entityiteratorxxxxx instanceof TormentorT2Entity
                     && entity.getPersistentData().getDouble("unique_separator") > entityiteratorxxxxx.getPersistentData().getDouble("unique_separator")
                     && (entity instanceof TormentorT2Entity _datEntSxxxxxx
                           ? (String)_datEntSxxxxxx.getEntityData().get(TormentorT2Entity.DATA_uuid_target)
                           : "")
                        .equals(
                           entityiteratorxxxxx instanceof TormentorT2Entity _datEntSxxxxx
                              ? _datEntSxxxxx.getEntityData().get(TormentorT2Entity.DATA_uuid_target)
                              : ""
                        )
                     && !entityiteratorxxxxx.level().isClientSide()) {
                     entityiteratorxxxxx.discard();
                  }
               } else if (entity instanceof TormentorT3Entity) {
                  if (entityiteratorxxxxx instanceof TormentorT3Entity
                     && entity.getPersistentData().getDouble("unique_separator") > entityiteratorxxxxx.getPersistentData().getDouble("unique_separator")
                     && (entity instanceof TormentorT3Entity _datEntSxxxxxx
                           ? (String)_datEntSxxxxxx.getEntityData().get(TormentorT3Entity.DATA_uuid_target)
                           : "")
                        .equals(
                           entityiteratorxxxxx instanceof TormentorT3Entity _datEntSxxxxx
                              ? _datEntSxxxxx.getEntityData().get(TormentorT3Entity.DATA_uuid_target)
                              : ""
                        )
                     && !entityiteratorxxxxx.level().isClientSide()) {
                     entityiteratorxxxxx.discard();
                  }
               } else if (entity instanceof TormentorT4Entity) {
                  if (entityiteratorxxxxx instanceof TormentorT4Entity
                     && entity.getPersistentData().getDouble("unique_separator") > entityiteratorxxxxx.getPersistentData().getDouble("unique_separator")
                     && (entity instanceof TormentorT4Entity _datEntSxxxxxx
                           ? (String)_datEntSxxxxxx.getEntityData().get(TormentorT4Entity.DATA_uuid_target)
                           : "")
                        .equals(
                           entityiteratorxxxxx instanceof TormentorT4Entity _datEntSxxxxx
                              ? _datEntSxxxxx.getEntityData().get(TormentorT4Entity.DATA_uuid_target)
                              : ""
                        )
                     && !entityiteratorxxxxx.level().isClientSide()) {
                     entityiteratorxxxxx.discard();
                  }
               } else if (entity instanceof TormentorT5Entity
                  && entityiteratorxxxxx instanceof TormentorT5Entity
                  && entity.getPersistentData().getDouble("unique_separator") > entityiteratorxxxxx.getPersistentData().getDouble("unique_separator")
                  && (entity instanceof TormentorT5Entity _datEntSxxxxxx ? (String)_datEntSxxxxxx.getEntityData().get(TormentorT5Entity.DATA_uuid_target) : "")
                     .equals(
                        entityiteratorxxxxx instanceof TormentorT5Entity _datEntSxxxxx
                           ? _datEntSxxxxx.getEntityData().get(TormentorT5Entity.DATA_uuid_target)
                           : ""
                     )
                  && !entityiteratorxxxxx.level().isClientSide()) {
                  entityiteratorxxxxx.discard();
               }
            }
         }

         if (!(ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0)
            && !(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!world.getEntitiesOfClass(
               TormentorSphereEntity.class,
               AABB.ofSize(
                  new Vec3(
                     ArphexModVariables.MapVariables.get(world).tormentor_x,
                     ArphexModVariables.MapVariables.get(world).tormentor_y,
                     ArphexModVariables.MapVariables.get(world).tormentor_z
                  ),
                  15.0,
                  15.0,
                  15.0
               ),
               e -> true
            )
            .isEmpty()) {
            if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
               if (entity instanceof TormentorTestEntity) {
                  ((TormentorTestEntity)entity).setAnimation("animation.tormentor.bigattack");
               }

               if (entity instanceof TormentorTestEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorTestEntity.DATA_big_attack, 1200);
               }
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
               if (entity instanceof TormentorT2Entity) {
                  ((TormentorT2Entity)entity).setAnimation("animation.tormentor_t2.bigattack");
               }

               if (entity instanceof TormentorT2Entity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorT2Entity.DATA_big_attack, 1200);
               }
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
               if (entity instanceof TormentorT3Entity) {
                  ((TormentorT3Entity)entity).setAnimation("animation.tormentor_t3.bigattack");
               }

               if (entity instanceof TormentorT3Entity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorT3Entity.DATA_big_attack, 1200);
               }
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
               if (entity instanceof TormentorT4Entity) {
                  ((TormentorT4Entity)entity).setAnimation("animation.tormentor_t4.bigattack");
               }

               if (entity instanceof TormentorT4Entity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorT4Entity.DATA_big_attack, 1200);
               }
            } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0) {
               if (entity instanceof TormentorT5Entity) {
                  ((TormentorT5Entity)entity).setAnimation("animation.tormentor_t5.bigattack");
               }

               if (entity instanceof TormentorT5Entity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorT5Entity.DATA_big_attack, 1200);
               }
            }
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_animode.equals("splay")) {
            entity.setSprinting(false);
            entity.setShiftKeyDown(false);
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_animode.equals("fold")) {
            entity.setSprinting(false);
            entity.setShiftKeyDown(true);
         } else {
            entity.setSprinting(true);
            entity.setShiftKeyDown(false);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeAllEffects();
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
            if (entity instanceof LivingEntity _entity) {
               _entity.setHealth((float)ArphexModVariables.MapVariables.get(world).tormentor_health);
            }
         } else {
            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)
                     && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 0.0F) {
                     if (entity instanceof LivingEntity _entityx) {
                        _entityx.setHealth(1.0F);
                     }

                     entity.hurt(
                        new DamageSource(
                           world.registryAccess()
                              .registryOrThrow(Registries.DAMAGE_TYPE)
                              .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))
                        ),
                        100.0F
                     );
                  }
               }
            );
         }

         if (world.isClientSide()) {
            if (entity instanceof TormentorTestEntity) {
               if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
                  if (entity instanceof TormentorTestEntity animatable) {
                     animatable.setTexture("tormentordead");
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_health < 512.0) {
                  if (entity instanceof TormentorTestEntity animatable) {
                     animatable.setTexture("tormentor2");
                  }
               } else if (entity instanceof TormentorTestEntity animatable) {
                  animatable.setTexture("tormentor");
               }
            } else if (entity instanceof TormentorT2Entity) {
               if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
                  if (entity instanceof TormentorT2Entity animatable) {
                     animatable.setTexture("tormentordead");
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_health < 512.0) {
                  if (entity instanceof TormentorT2Entity animatable) {
                     animatable.setTexture("tormentort2_low");
                  }
               } else if (entity instanceof TormentorT2Entity animatable) {
                  animatable.setTexture("tormentort2");
               }
            } else if (entity instanceof TormentorT3Entity) {
               if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
                  if (entity instanceof TormentorT3Entity animatable) {
                     animatable.setTexture("tormentordead");
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_health < 512.0) {
                  if (entity instanceof TormentorT3Entity animatable) {
                     animatable.setTexture("tormentort3_low");
                  }
               } else if (entity instanceof TormentorT3Entity animatable) {
                  animatable.setTexture("tormentort3");
               }
            } else if (entity instanceof TormentorT4Entity) {
               if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
                  if (entity instanceof TormentorT4Entity animatable) {
                     animatable.setTexture("tormentordead");
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_health < 512.0) {
                  if (entity instanceof TormentorT4Entity animatable) {
                     animatable.setTexture("tormentort4_low");
                  }
               } else if (entity instanceof TormentorT4Entity animatable) {
                  animatable.setTexture("tormentort4");
               }
            } else if (entity instanceof TormentorT5Entity) {
               if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
                  if (entity instanceof TormentorT5Entity animatable) {
                     animatable.setTexture("tormentordead");
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_health < 512.0) {
                  if (entity instanceof TormentorT5Entity animatable) {
                     animatable.setTexture("tormentort5_low");
                  }
               } else if (entity instanceof TormentorT5Entity animatable) {
                  animatable.setTexture("tormentort5");
               }
            }
         }

         entity.setYRot(0.0F);
         entity.setXRot(0.0F);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity _entity) {
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         entity.getPersistentData().putBoolean("tormentor_target", false);
      }
   }
}
