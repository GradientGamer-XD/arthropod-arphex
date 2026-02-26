package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ArthropleuraAbominationEntity;
import net.arphex.entity.SegmentedBodyEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SegmentedBodyOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean headnear = false;
         boolean bodyfound = false;
         double dists = 0.0;
         double avoid_overlap = 0.0;
         double followed_segment_y = 0.0;
         double segments_required = 0.0;
         double limitspawns = 0.0;
         double flexibility = 0.0;
         double store_pitch_when_still = 0.0;
         if (entity.isAlive()
            && (entity instanceof SegmentedBodyEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0) > 0) {
            entity.setNoGravity(true);
            if ((entity instanceof SegmentedBodyEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0) == 1
               )
             {
               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (entity.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
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
                              "execute unless entity @e[distance=..10,type=arphex:arthropleura_abomination,nbt={Datauuidmap:"
                                 + (entity instanceof SegmentedBodyEntity _datEntSx
                                       ? (String)_datEntSx.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map)
                                       : "")
                                    .strip()
                                 + "}] run data merge entity @s {Datasegmentnum_arphex:0}"
                           );
                     }
                  }
               );
            } else {
               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (entity.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
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
                              "execute unless entity @e[distance=..10,type=arphex:segmented_body,nbt={Datasegmentnum_arphex:"
                                 + (
                                    Math.round(
                                          entity instanceof SegmentedBodyEntity _datEntIx
                                             ? (float)((Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)).intValue()
                                             : 0.0F
                                       )
                                       - 1
                                 )
                                 + ",Datauuid_map:"
                                 + (
                                    entity instanceof SegmentedBodyEntity _datEntSx
                                       ? (String)_datEntSx.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map)
                                       : ""
                                 )
                                 + "}] run data merge entity @s {Datasegmentnum_arphex:0}"
                           );
                     }
                  }
               );
            }

            if (entity.getPersistentData().getBoolean("despawnsegmentarph")) {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if ((
                  entity instanceof SegmentedBodyEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0
               )
               <= 0) {
               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if ((
                              entity instanceof SegmentedBodyEntity _datEntIxx
                                 ? (Integer)_datEntIxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                                 : 0
                           )
                           <= 0
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }

            segments_required = 15.0;
            entity.getPersistentData().putDouble("segments_required_arph", segments_required);
            headnear = false;
            bodyfound = false;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if ((double)(
                     entity instanceof SegmentedBodyEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0
                  )
                  == segments_required) {
                  if (entityiterator instanceof SegmentedBodyEntity
                     && (entityiterator instanceof SegmentedBodyEntity _datEntSx
                           ? (String)_datEntSx.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map)
                           : "")
                        .equals(entity instanceof SegmentedBodyEntity _datEntS ? _datEntS.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")) {
                     if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                        && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.4, entity.getZ()))
                        && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                        && entityiterator instanceof LivingEntity _entity
                        && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.MOTH_CURSE.get(), 2, 0, false, false));
                     }

                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 2, 0, false, false));
                     }
                  }

                  if (entityiterator instanceof ArthropleuraAbominationEntity
                     && (entityiterator instanceof ArthropleuraAbominationEntity _datEntSx
                           ? (String)_datEntSx.getEntityData().get(ArthropleuraAbominationEntity.DATA_uuidmap)
                           : "")
                        .equals(entity instanceof SegmentedBodyEntity _datEntS ? _datEntS.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")) {
                     if (entity.getY() < entityiterator.getY()
                        && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                        && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.4, entity.getZ()))
                        && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                        && entityiterator instanceof LivingEntity _entity
                        && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.MOTH_CURSE.get(), 2, 0, false, false));
                     }

                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 2, 0, false, false));
                     }
                  }
               }

               if ((entity instanceof SegmentedBodyEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex) : 0)
                     == 1
                  && entityiterator instanceof ArthropleuraAbominationEntity) {
                  if (entityiterator instanceof ArthropleuraAbominationEntity
                     && (entityiterator instanceof ArthropleuraAbominationEntity _datEntSx
                           ? (String)_datEntSx.getEntityData().get(ArthropleuraAbominationEntity.DATA_uuidmap)
                           : "")
                        .equals(entity instanceof SegmentedBodyEntity _datEntS ? _datEntS.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")) {
                     headnear = true;
                     if (entityiterator instanceof TamableAnimal _tamEntxxx
                        && _tamEntxxx.isTame()
                        && (!(entity instanceof TamableAnimal _tamEntxx) || !_tamEntxx.isTame())
                        && (entityiterator instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
                        && entity instanceof TamableAnimal _toTame
                        && (entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) instanceof Player _owner) {
                        _toTame.tame(_owner);
                     }

                     dists = Math.sqrt(
                        (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                           + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                           + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                     );
                     avoid_overlap = 1.4;
                     if (entity instanceof LivingEntity _entity) {
                        _entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F);
                     }

                     label517:
                     if (entity.getPersistentData().getDouble("segdamagetransfer") > 0.0) {
                        if (entityiterator instanceof LivingEntity _livEnt84 && _livEnt84.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                           break label517;
                        }

                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                           (float)entity.getPersistentData().getDouble("segdamagetransfer")
                        );
                        entity.getPersistentData().putDouble("segdamagetransfer", 0.0);
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                        }
                     }

                     if (dists > avoid_overlap || dists < 0.5) {
                        entity.teleportTo(
                           entityiterator.getX() - (entityiterator.getX() - entity.getX()) / dists * avoid_overlap,
                           entityiterator.getY() - (entityiterator.getY() - entity.getY()) / dists * avoid_overlap,
                           entityiterator.getZ() - (entityiterator.getZ() - entity.getZ()) / dists * avoid_overlap
                        );
                        if (entity instanceof ServerPlayer _serverPlayer) {
                           _serverPlayer.connection
                              .teleport(
                                 entityiterator.getX() - (entityiterator.getX() - entity.getX()) / dists * avoid_overlap,
                                 entityiterator.getY() - (entityiterator.getY() - entity.getY()) / dists * avoid_overlap,
                                 entityiterator.getZ() - (entityiterator.getZ() - entity.getZ()) / dists * avoid_overlap,
                                 entity.getYRot(),
                                 entity.getXRot()
                              );
                        }

                        flexibility = 0.7;

                        for (int index0 = 0; index0 < 7; index0++) {
                           if (entity.isInWall()) {
                              if ((double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                                    .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                                 > 0.2) {
                                 if (!(
                                       (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                                             .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                                          > 0.2
                                    )
                                    && entityiterator.getY() - flexibility < entity.getY()) {
                                    entity.teleportTo(entity.getX(), entity.getY() - 0.1, entity.getZ());
                                    if (entity instanceof ServerPlayer _serverPlayer) {
                                       _serverPlayer.connection.teleport(entity.getX(), entity.getY() - 0.1, entity.getZ(), entity.getYRot(), entity.getXRot());
                                    }
                                 }
                              } else if (entityiterator.getY() + flexibility > entity.getY()) {
                                 entity.teleportTo(entity.getX(), entity.getY() + 0.1, entity.getZ());
                                 if (entity instanceof ServerPlayer _serverPlayer) {
                                    _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 0.1, entity.getZ(), entity.getYRot(), entity.getXRot());
                                 }
                              }
                           } else if (!(
                              (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ()))
                                    .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ()))
                                 > 0.2
                           )) {
                              if (entityiterator.getY() - flexibility < entity.getY()) {
                                 entity.teleportTo(entity.getX(), entity.getY() - 0.1, entity.getZ());
                                 if (entity instanceof ServerPlayer _serverPlayer) {
                                    _serverPlayer.connection.teleport(entity.getX(), entity.getY() - 0.1, entity.getZ(), entity.getYRot(), entity.getXRot());
                                 }
                              }
                           } else if ((double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 0.1, entity.getZ()))
                                    .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() + 0.1, entity.getZ()))
                                 > 0.2
                              && !(
                                 (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                                       .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                                    > 0.2
                              )
                              && entityiterator.getY() + flexibility > entity.getY()) {
                              entity.teleportTo(entity.getX(), entity.getY() + 0.1, entity.getZ());
                              if (entity instanceof ServerPlayer _serverPlayer) {
                                 _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 0.1, entity.getZ(), entity.getYRot(), entity.getXRot());
                              }
                           }
                        }
                     }

                     entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 0.6, entityiterator.getZ()));
                  }
               } else if (entityiterator instanceof SegmentedBodyEntity
                  && (entityiterator instanceof SegmentedBodyEntity _datEntSx ? (String)_datEntSx.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")
                     .equals(entity instanceof SegmentedBodyEntity _datEntS ? _datEntS.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")) {
                  if ((
                        entityiterator instanceof SegmentedBodyEntity _datEntIxxx
                           ? (Integer)_datEntIxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                           : 0
                     )
                     == (
                        entity instanceof SegmentedBodyEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                           : 0
                     )) {
                     if (entity.getX() > entityiterator.getX() && !entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                     }
                  } else if ((
                        entityiterator instanceof SegmentedBodyEntity _datEntIxxxxx
                           ? (Integer)_datEntIxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                           : 0
                     )
                     != (
                           entity instanceof SegmentedBodyEntity _datEntIxxxx
                              ? (Integer)_datEntIxxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                              : 0
                        )
                        - 1) {
                     if ((
                              entityiterator instanceof SegmentedBodyEntity _datEntIxxxxxxx
                                 ? (Integer)_datEntIxxxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                                 : 0
                           )
                           == (
                                 entity instanceof SegmentedBodyEntity _datEntIxxxxxx
                                    ? (Integer)_datEntIxxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                                    : 0
                              )
                              + 1
                        && (entity.getPersistentData().getDouble("segdamagetransfer") > 0.0 || entity.getPersistentData().getDouble("segupwardstransfer") > 0.0)
                        )
                      {
                        entityiterator.getPersistentData().putDouble("segupwardstransfer", 1.0);
                        entity.getPersistentData().putDouble("segupwardstransfer", 0.0);
                        if (entityiterator instanceof LivingEntity _livEnt214 && _livEnt214.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                           continue;
                        }

                        entityiterator.hurt(
                           new DamageSource(
                              world.registryAccess()
                                 .registryOrThrow(Registries.DAMAGE_TYPE)
                                 .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))
                           ),
                           0.0F
                        );
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                        }
                     }
                  } else {
                     headnear = true;
                     if (entityiterator instanceof TamableAnimal _tamEntxxx
                        && _tamEntxxx.isTame()
                        && (!(entity instanceof TamableAnimal _tamEntxx) || !_tamEntxx.isTame())
                        && (entityiterator instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
                        && entity instanceof TamableAnimal _toTame
                        && (entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) instanceof Player _owner) {
                        _toTame.tame(_owner);
                     }

                     if (entityiterator instanceof SegmentedBodyEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(SegmentedBodyEntity.DATA_cooldown_arphex, 20);
                     }

                     label476:
                     if (entity.getPersistentData().getDouble("segdamagetransfer") > 0.0) {
                        entityiterator.getPersistentData().putDouble("segdamagetransfer", entity.getPersistentData().getDouble("segdamagetransfer"));
                        entity.getPersistentData().putDouble("segdamagetransfer", 0.0);
                        if (entityiterator instanceof LivingEntity _livEnt170 && _livEnt170.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                           break label476;
                        }

                        entityiterator.hurt(
                           new DamageSource(
                              world.registryAccess()
                                 .registryOrThrow(Registries.DAMAGE_TYPE)
                                 .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))
                           ),
                           0.0F
                        );
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity _entity) {
                        _entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F);
                     }

                     dists = Math.sqrt(
                        (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                           + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                           + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                     );
                     avoid_overlap = 1.4;
                     if (dists > avoid_overlap
                        || dists < 0.5
                        || entity instanceof LivingEntity _livEnt188
                           && _livEnt188.hasEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get())
                           && !(
                              (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.4, entity.getZ()))
                                    .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() - 0.4, entity.getZ()))
                                 > 0.2
                           )) {
                        entity.teleportTo(
                           entityiterator.getX() - (entityiterator.getX() - entity.getX()) / dists * avoid_overlap,
                           entityiterator.getY() - (entityiterator.getY() - entity.getY()) / dists * avoid_overlap,
                           entityiterator.getZ() - (entityiterator.getZ() - entity.getZ()) / dists * avoid_overlap
                        );
                        if (entity instanceof ServerPlayer _serverPlayer) {
                           _serverPlayer.connection
                              .teleport(
                                 entityiterator.getX() - (entityiterator.getX() - entity.getX()) / dists * avoid_overlap,
                                 entityiterator.getY() - (entityiterator.getY() - entity.getY()) / dists * avoid_overlap,
                                 entityiterator.getZ() - (entityiterator.getZ() - entity.getZ()) / dists * avoid_overlap,
                                 entity.getYRot(),
                                 entity.getXRot()
                              );
                        }
                     }

                     if (world.isClientSide()) {
                        entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 0.7, entityiterator.getZ()));
                     }
                  }
               }
            }

            entity.getPersistentData().putDouble("segdamagetransfer", 0.0);
            entity.getPersistentData().putDouble("segupwardstransfer", 0.0);
            if (!entity.isInWall()
               && !(
                  (double)world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.4, entity.getZ()))
                        .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() - 0.4, entity.getZ()))
                     > 0.2
               )
               && entity instanceof LivingEntity _livEnt226
               && _livEnt226.hasEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get())
               && !entity.level().isClientSide()
               && entity.getServer() != null) {
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
                     "tp @s ^ ^-0.1 ^-0.15"
                  );
            }

            if ((
                  entity instanceof SegmentedBodyEntity _datEntIxxxxxx
                     ? (Integer)_datEntIxxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_cooldown_arphex)
                     : 0
               )
               <= 0) {
               if (entity instanceof SegmentedBodyEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SegmentedBodyEntity.DATA_cooldown_arphex, 20);
               }

               if ((double)(
                        entity instanceof SegmentedBodyEntity _datEntIxxxxxxx
                           ? (Integer)_datEntIxxxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                           : 0
                     )
                     < segments_required
                  && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(entity.getX() + 0.1, entity.getY() + 0.0, entity.getZ()),
                              Vec2.ZERO,
                              _level,
                              4,
                              "",
                              Component.literal(""),
                              _level.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "execute unless entity @e[distance=..10,type=arphex:segmented_body,nbt={Datasegmentnum_arphex:"
                           + (
                              Math.round(
                                    entity instanceof SegmentedBodyEntity _datEntIxxxxxxxx
                                       ? (float)((Integer)_datEntIxxxxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)).intValue()
                                       : 0.0F
                                 )
                                 + 1
                           )
                           + ",Datauuid_map:"
                           + (entity instanceof SegmentedBodyEntity _datEntSxx ? (String)_datEntSxx.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")
                           + "}] run summon arphex:segmented_body"
                     );
               }
            } else if (entity instanceof SegmentedBodyEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SegmentedBodyEntity.DATA_cooldown_arphex,
                     (
                           entity instanceof SegmentedBodyEntity _datEntIxxxxxx
                              ? (Integer)_datEntIxxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_cooldown_arphex)
                              : 0
                        )
                        - 1
                  );
            }

            if (!world.getEntitiesOfClass(
                  ArthropleuraAbominationEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 1.0, 1.0, 1.0), e -> true
               )
               .isEmpty()) {
               entity.noPhysics = true;
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            } else {
               entity.noPhysics = false;
            }

            if ((double)(
                     entity instanceof SegmentedBodyEntity _datEntIxxxxxx
                        ? (Integer)_datEntIxxxxxx.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                        : 0
                  )
                  > segments_required
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame()) && entity.isVehicle()) {
               for (Entity entityiterator : entity.getIndirectPassengers()) {
                  if (!entityiterator.getPersistentData().getBoolean("creativespectator")) {
                     entityiterator.stopRiding();
                  }
               }
            }

            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                  < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
               && world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 25, 0.4, 0.4, 0.4, 0.1);
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
