package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistSoldierEntity;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AntArsonistQueenOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         entity.getPersistentData().putBoolean("arphex", true);
         label834:
         if (!(entity.getPersistentData().getDouble("queentickslow") > 0.0)) {
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               if (!(entity.getPersistentData().getDouble("minspawnwait") <= 0.0)) {
                  entity.getPersistentData()
                     .putDouble(
                        "queentickslow",
                        (double)Mth.nextInt(
                           RandomSource.create(),
                           (int)entity.getPersistentData().getDouble("minspawnwait"),
                           (int)(entity.getPersistentData().getDouble("minspawnwait") + 1200.0)
                        )
                     );
                  if (entity instanceof AntArsonistAlateQueenEntity _datEntL8
                     && (Boolean)_datEntL8.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)
                     && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                     && world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ()))
                     && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1.0))
                     && world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ() + 1.0))
                     && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                     && world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 1.0, entity.getZ()))
                     && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() + 1.0))
                     && world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 1.0, entity.getZ() + 1.0))) {
                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator == (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null)) {
                           if ((
                                 Mth.nextInt(RandomSource.create(), 1, 5) == 3
                                    || world.getEntitiesOfClass(AntArsonistSoldierEntity.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), e -> true)
                                       .isEmpty()
                              )
                              && (
                                    entity instanceof AntArsonistAlateQueenEntity _datEntI
                                       ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                                       : 0
                                 )
                                 > 1200) {
                              if (world instanceof ServerLevel _level) {
                                 Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                                    .spawn(_level, BlockPos.containing(entity.getX() + 0.5, entity.getY(), entity.getZ() + 0.5), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawn != null) {
                                 }
                              }

                              if (world instanceof ServerLevel _levelx) {
                                 Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                                    .spawn(_levelx, BlockPos.containing(entity.getX() + 0.5, entity.getY(), entity.getZ() + 0.5), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawn != null) {
                                 }
                              }

                              if (world instanceof ServerLevel _levelxx) {
                                 Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST_SOLDIER.get())
                                    .spawn(_levelxx, BlockPos.containing(entity.getX() + 0.5, entity.getY(), entity.getZ() + 0.5), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawn != null) {
                                 }
                              }
                           } else {
                              if (world instanceof ServerLevel _levelxxx) {
                                 Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                                    .spawn(_levelxxx, BlockPos.containing(entity.getX() + 0.5, entity.getY(), entity.getZ() + 0.5), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawn != null) {
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxx) {
                                 Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST.get())
                                    .spawn(_levelxxxx, BlockPos.containing(entity.getX() + 0.5, entity.getY(), entity.getZ() + 0.5), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawn != null) {
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxx) {
                                 Entity entityToSpawn = ((EntityType)ArphexModEntities.ANT_ARSONIST_WORKER.get())
                                    .spawn(_levelxxxxx, BlockPos.containing(entity.getX() + 0.5, entity.getY(), entity.getZ() + 0.5), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawn != null) {
                                 }
                              }
                           }
                        }
                     }
                  }
               }
               break label834;
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            entity.getPersistentData().putDouble("queentickslow", (double)Mth.nextInt(RandomSource.create(), 1200, 2400));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, Mth.nextInt(RandomSource.create(), 20, 200), 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, Mth.nextInt(RandomSource.create(), 300, 600), 0, false, false));
            }
         } else {
            entity.getPersistentData().putDouble("queentickslow", entity.getPersistentData().getDouble("queentickslow") - 1.0);
         }

         label843: {
            if (entity instanceof TamableAnimal _tamEntxx && _tamEntxx.isTame()) {
               break label843;
            }

            if (!entity.getDisplayName().getString().isEmpty()) {
               entity.setCustomName(Component.literal("".strip()));
            }

            if (entity instanceof LivingEntity _livEnt84 && _livEnt84.hasEffect(MobEffects.LEVITATION)) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                     entity.getDeltaMovement().y(),
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            }
         }

         if (!(entity.getPersistentData().getDouble("queenticks") > 0.0)) {
            if ((
                  entity instanceof AntArsonistAlateQueenEntity _datEntI
                     ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                     : 0
               )
               >= 36000) {
               if (entity instanceof TamableAnimal _tamEntxx && _tamEntxx.isTame()) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if ((entityiteratorx instanceof AntArsonistWorkerEntity || entityiteratorx instanceof AntArsonistSoldierEntity)
                        && entityiteratorx instanceof TamableAnimal) {
                        TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorx;
                        LivingEntity _entity = entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null;
                        if (_entity instanceof LivingEntity) {
                           LivingEntity _livEnt = _entity;
                           if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                              if (entityiteratorx instanceof LivingEntity) {
                                 _entity = (LivingEntity)entityiteratorx;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 0, false, false));
                                 }
                              }

                              if (entityiteratorx instanceof LivingEntity) {
                                 _entity = (LivingEntity)entityiteratorx;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 0, false, false));
                                 }
                              }

                              if (entityiteratorx instanceof LivingEntity) {
                                 _entity = (LivingEntity)entityiteratorx;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 0, false, false));
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               entity.getPersistentData().putDouble("minspawnwait", 2400.0);
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
               }
            } else if ((
                  entity instanceof AntArsonistAlateQueenEntity _datEntI
                     ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                     : 0
               )
               <= 12000) {
               if ((
                     entity instanceof AntArsonistAlateQueenEntity _datEntIx
                        ? (Integer)_datEntIx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                        : 0
                  )
                  > 1200) {
                  entity.getPersistentData().putDouble("minspawnwait", 12000.0);
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
                  }
               } else {
                  entity.getPersistentData().putDouble("minspawnwait", 24000.0);
               }
            } else {
               if (entity instanceof TamableAnimal _tamEntxx && _tamEntxx.isTame()) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorxx instanceof AntArsonistSoldierEntity && entityiteratorxx instanceof TamableAnimal) {
                        TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxx;
                        LivingEntity _entity = entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null;
                        if (_entity instanceof LivingEntity) {
                           LivingEntity _livEnt = _entity;
                           if (_tamIsTamedBy.isOwnedBy(_livEnt) && entityiteratorxx instanceof LivingEntity) {
                              _entity = (LivingEntity)entityiteratorxx;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 0, false, false));
                              }
                           }
                        }
                     }
                  }
               }

               entity.getPersistentData().putDouble("minspawnwait", 7200.0);
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
               }
            }

            if (entity instanceof AntArsonistAlateQueenEntity _datEntL117
               && (Boolean)_datEntL117.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)) {
               if ((
                     entity instanceof AntArsonistAlateQueenEntity _datEntIxx
                        ? (Integer)_datEntIxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                        : 0
                  )
                  < 40000) {
                  if (entity instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           AntArsonistAlateQueenEntity.DATA_queenlevel,
                           (
                                 entity instanceof AntArsonistAlateQueenEntity _datEntIxxx
                                    ? (Integer)_datEntIxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                                    : 0
                              )
                              + 1
                        );
                  }
               } else if (entity instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(AntArsonistAlateQueenEntity.DATA_queenlevel, 40000);
               }
            }

            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                  < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
               && world instanceof ServerLevel _levelxxxxxx) {
               _levelxxxxxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 20, 0.4, 0.4, 0.4, 0.4);
            }

            label763:
            if (entity instanceof TamableAnimal _tamEntxx && _tamEntxx.isTame()) {
               if (entity instanceof AntArsonistAlateQueenEntity _datEntL126
                  && (Boolean)_datEntL126.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)) {
                  break label763;
               }

               if (entity instanceof Mob _entity) {
                  _entity.getNavigation()
                     .moveTo(
                        (entity instanceof TamableAnimal _tamEntxxxxx ? _tamEntxxxxx.getOwner() : null).getX(),
                        (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null).getY(),
                        (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getZ(),
                        1.0
                     );
               }

               ArphexMod.queueServerWork(
                  5980,
                  () -> {
                     if (entity instanceof AntArsonistAlateQueenEntity _datEntL134
                        && (Boolean)_datEntL134.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)) {
                        return;
                     }

                     if (entity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(
                           Component.literal("Your tamed alate has shed its wings and turned into a queen! It needs to be under cover at all times now."), true
                        );
                     }

                     if (entity instanceof AntArsonistAlateQueenEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(AntArsonistAlateQueenEntity.DATA_alatequeen, true);
                     }
                  }
               );
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
            }

            label851: {
               if (entity instanceof AntArsonistAlateQueenEntity _datEntL139
                  && (Boolean)_datEntL139.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)) {
                  if (entity instanceof AntArsonistAlateQueenEntity animatable) {
                     animatable.setTexture("antgiant");
                  }

                  if (world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
                     if ((Boolean)ConfigurationSettingsConfiguration.ANT_QUEEN_OUTSIDE_DAMAGE.get()) {
                        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE)), 1.0F);
                     }

                     if (!world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX() + 5.0, entity.getY(), entity.getZ()))) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().moveTo(entity.getX() + 5.0, entity.getY(), entity.getZ(), 1.0);
                        }
                     } else if (!world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX() - 5.0, entity.getY(), entity.getZ()))) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().moveTo(entity.getX() - 5.0, entity.getY(), entity.getZ(), 1.0);
                        }
                     } else if (!world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 5.0))) {
                        if (entity instanceof Mob _entity) {
                           _entity.getNavigation().moveTo(entity.getX(), entity.getY(), entity.getZ() - 5.0, 1.0);
                        }
                     } else if (!world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 5.0))
                        && entity instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(entity.getX(), entity.getY(), entity.getZ() + 5.0, 1.0);
                     }
                  } else if (Mth.nextInt(RandomSource.create(), 1, 10) != 5 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 21, 100, false, false));
                  }
                  break label851;
               }

               if (entity instanceof AntArsonistAlateQueenEntity animatable) {
                  animatable.setTexture("antsoldier");
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 1, false, false));
               }

               if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())) && Mth.nextInt(RandomSource.create(), 1, 5) == 5) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        entity.getX() + (double)Mth.nextInt(RandomSource.create(), -1, 1),
                        entity.getY(),
                        entity.getZ() + (double)Mth.nextInt(RandomSource.create(), -1, 1)
                     )
                  );
               }
            }

            if (entity instanceof TamableAnimal _tamEntxx
               && _tamEntxx.isTame()
               && (
                     entity instanceof AntArsonistAlateQueenEntity _datEntIxxx
                        ? (Integer)_datEntIxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)
                        : 0
                  )
                  != 0) {
               Vec3 _center;
               Vec3 var182 = _center = new Vec3(
                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxx
                     ? (double)((Integer)_datEntIxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)).intValue()
                     : 0.0,
                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxx
                     ? (double)((Integer)_datEntIxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)).intValue()
                     : 0.0,
                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxx
                     ? (double)((Integer)_datEntIxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)).intValue()
                     : 0.0
               );

               for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorxxx instanceof AntArsonistWorkerEntity && entityiteratorxxx instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxxx;
                     LivingEntity var137 = entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null;
                     if (var137 instanceof LivingEntity) {
                        LivingEntity _livEnt = var137;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt)
                           && (
                              !(entityiteratorxxx instanceof AntArsonistWorkerEntity _datEntL203)
                                 || !(Boolean)_datEntL203.getEntityData().get(AntArsonistWorkerEntity.DATA_following)
                           )) {
                           if (entityiteratorxxx instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get(), 60, 1, false, false));
                           }

                           if ((entity instanceof AntArsonistAlateQueenEntity _datEntS
                                 ? (String)_datEntS.getEntityData().get(AntArsonistAlateQueenEntity.DATA_antcommand)
                                 : "")
                              .equals("logs")) {
                              if (!world.getBlockState(BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 1.0, entityiteratorxxx.getZ()))
                                    .is(BlockTags.create(new ResourceLocation("minecraft:logs")))
                                 && !world.getBlockState(
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 1.0, entityiteratorxxx.getZ())
                                    )
                                    .is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
                                 if (!world.getBlockState(
                                          BlockPos.containing(entityiteratorxxx.getX() + 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ())
                                       )
                                       .is(BlockTags.create(new ResourceLocation("minecraft:logs")))
                                    && !world.getBlockState(
                                          BlockPos.containing(entityiteratorxxx.getX() + 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ())
                                       )
                                       .is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
                                    if (!world.getBlockState(
                                             BlockPos.containing(entityiteratorxxx.getX() - 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ())
                                          )
                                          .is(BlockTags.create(new ResourceLocation("minecraft:logs")))
                                       && !world.getBlockState(
                                             BlockPos.containing(entityiteratorxxx.getX() - 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ())
                                          )
                                          .is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
                                       if (!world.getBlockState(
                                                BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() - 1.0)
                                             )
                                             .is(BlockTags.create(new ResourceLocation("minecraft:logs")))
                                          && !world.getBlockState(
                                                BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() - 1.0)
                                             )
                                             .is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
                                          if (!world.getBlockState(
                                                   BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() - 1.0, entityiteratorxxx.getZ())
                                                )
                                                .is(BlockTags.create(new ResourceLocation("minecraft:logs")))
                                             && !world.getBlockState(
                                                   BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() - 1.0, entityiteratorxxx.getZ())
                                                )
                                                .is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
                                             if (!world.getBlockState(
                                                      BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() + 1.0)
                                                   )
                                                   .is(BlockTags.create(new ResourceLocation("minecraft:logs")))
                                                && !world.getBlockState(
                                                      BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() + 1.0)
                                                   )
                                                   .is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
                                                if (Mth.nextInt(RandomSource.create(), 1, 10) == 5 && entityiteratorxxx instanceof Mob _entity) {
                                                   _entity.getNavigation()
                                                      .moveTo(
                                                         (double)(
                                                            (
                                                                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxx
                                                                     ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)
                                                                     : 0
                                                               )
                                                               + Mth.nextInt(RandomSource.create(), -15, 15)
                                                         ),
                                                         entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxx
                                                            ? (double)((Integer)_datEntIxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea))
                                                               .intValue()
                                                            : 0.0,
                                                         (double)(
                                                            (
                                                                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxx
                                                                     ? (Integer)_datEntIxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)
                                                                     : 0
                                                               )
                                                               + Mth.nextInt(RandomSource.create(), -15, 15)
                                                         ),
                                                         1.5
                                                      );
                                                }
                                             } else if (!world.isClientSide()) {
                                                BlockPos _pos = BlockPos.containing(
                                                   entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() + 1.0
                                                );
                                                Block.dropResources(
                                                   world.getBlockState(_pos),
                                                   world,
                                                   BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() + 1.0),
                                                   null
                                                );
                                                world.destroyBlock(_pos, false);
                                             }
                                          } else if (!world.isClientSide()) {
                                             BlockPos _pos = BlockPos.containing(
                                                entityiteratorxxx.getX(), entityiteratorxxx.getY() - 1.0, entityiteratorxxx.getZ()
                                             );
                                             Block.dropResources(
                                                world.getBlockState(_pos),
                                                world,
                                                BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() - 1.0, entityiteratorxxx.getZ()),
                                                null
                                             );
                                             world.destroyBlock(_pos, false);
                                          }
                                       } else if (!world.isClientSide()) {
                                          BlockPos _pos = BlockPos.containing(
                                             entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() - 1.0
                                          );
                                          Block.dropResources(
                                             world.getBlockState(_pos),
                                             world,
                                             BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() - 1.0),
                                             null
                                          );
                                          world.destroyBlock(_pos, false);
                                       }
                                    } else if (!world.isClientSide()) {
                                       BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX() - 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ());
                                       Block.dropResources(
                                          world.getBlockState(_pos),
                                          world,
                                          BlockPos.containing(entityiteratorxxx.getX() - 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ()),
                                          null
                                       );
                                       world.destroyBlock(_pos, false);
                                    }
                                 } else if (!world.isClientSide()) {
                                    BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX() + 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ());
                                    Block.dropResources(
                                       world.getBlockState(_pos),
                                       world,
                                       BlockPos.containing(entityiteratorxxx.getX() + 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ()),
                                       null
                                    );
                                    world.destroyBlock(_pos, false);
                                 }
                              } else if (!world.isClientSide()) {
                                 BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 1.0, entityiteratorxxx.getZ());
                                 Block.dropResources(
                                    world.getBlockState(_pos),
                                    world,
                                    BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 1.0, entityiteratorxxx.getZ()),
                                    null
                                 );
                                 world.destroyBlock(_pos, false);
                              }

                              sx = -1.0;

                              for (int index0 = 0; index0 < 2; index0++) {
                                 sy = -3.0;

                                 for (int index1 = 0; index1 < 12; index1++) {
                                    sz = -1.0;

                                    for (int index2 = 0; index2 < 2; index2++) {
                                       if (world.getBlockState(
                                             BlockPos.containing(entityiteratorxxx.getX() + sx, entityiteratorxxx.getY() + sy, entityiteratorxxx.getZ() + sz)
                                          )
                                          .is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
                                          entityiteratorxxx.getPersistentData().putDouble("navgx", entityiteratorxxx.getX() + sx);
                                          entityiteratorxxx.getPersistentData().putDouble("navgy", entityiteratorxxx.getY() + sy);
                                          entityiteratorxxx.getPersistentData().putDouble("navgz", entityiteratorxxx.getZ() + sz);
                                          break;
                                       }

                                       sz++;
                                    }

                                    sy++;
                                 }

                                 sx++;
                              }
                           } else if (!(entity instanceof AntArsonistAlateQueenEntity _datEntS
                                 ? (String)_datEntS.getEntityData().get(AntArsonistAlateQueenEntity.DATA_antcommand)
                                 : "")
                              .equals("stone")) {
                              if (Mth.nextInt(RandomSource.create(), 1, 10) == 5 && entityiteratorxxx instanceof Mob _entity) {
                                 _entity.getNavigation()
                                    .moveTo(
                                       (double)(
                                          (
                                                entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)
                                                   : 0
                                             )
                                             + Mth.nextInt(RandomSource.create(), -15, 15)
                                       ),
                                       entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxx
                                          ? (double)((Integer)_datEntIxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)).intValue()
                                          : 0.0,
                                       (double)(
                                          (
                                                entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)
                                                   : 0
                                             )
                                             + Mth.nextInt(RandomSource.create(), -15, 15)
                                       ),
                                       1.5
                                    );
                              }
                           } else {
                              if (world.getBlockState(BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 1.0, entityiteratorxxx.getZ()))
                                    .getBlock()
                                 == Blocks.STONE) {
                                 if (!world.isClientSide()) {
                                    BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 1.0, entityiteratorxxx.getZ());
                                    Block.dropResources(
                                       world.getBlockState(_pos),
                                       world,
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() + 1.0, entityiteratorxxx.getZ()),
                                       null
                                    );
                                    world.destroyBlock(_pos, false);
                                 }
                              } else if (world.getBlockState(
                                       BlockPos.containing(entityiteratorxxx.getX() + 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ())
                                    )
                                    .getBlock()
                                 == Blocks.STONE) {
                                 if (!world.isClientSide()) {
                                    BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX() + 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ());
                                    Block.dropResources(
                                       world.getBlockState(_pos),
                                       world,
                                       BlockPos.containing(entityiteratorxxx.getX() + 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ()),
                                       null
                                    );
                                    world.destroyBlock(_pos, false);
                                 }
                              } else if (world.getBlockState(
                                       BlockPos.containing(entityiteratorxxx.getX() - 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ())
                                    )
                                    .getBlock()
                                 == Blocks.STONE) {
                                 if (!world.isClientSide()) {
                                    BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX() - 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ());
                                    Block.dropResources(
                                       world.getBlockState(_pos),
                                       world,
                                       BlockPos.containing(entityiteratorxxx.getX() - 1.0, entityiteratorxxx.getY(), entityiteratorxxx.getZ()),
                                       null
                                    );
                                    world.destroyBlock(_pos, false);
                                 }
                              } else if (world.getBlockState(
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() - 1.0)
                                    )
                                    .getBlock()
                                 == Blocks.STONE) {
                                 if (!world.isClientSide()) {
                                    BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() - 1.0);
                                    Block.dropResources(
                                       world.getBlockState(_pos),
                                       world,
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() - 1.0),
                                       null
                                    );
                                    world.destroyBlock(_pos, false);
                                 }
                              } else if (world.getBlockState(
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() - 1.0, entityiteratorxxx.getZ())
                                    )
                                    .getBlock()
                                 == Blocks.STONE) {
                                 if (!world.isClientSide()) {
                                    BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() - 1.0, entityiteratorxxx.getZ());
                                    Block.dropResources(
                                       world.getBlockState(_pos),
                                       world,
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY() - 1.0, entityiteratorxxx.getZ()),
                                       null
                                    );
                                    world.destroyBlock(_pos, false);
                                 }
                              } else if (world.getBlockState(
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() + 1.0)
                                    )
                                    .getBlock()
                                 == Blocks.STONE) {
                                 if (!world.isClientSide()) {
                                    BlockPos _pos = BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() + 1.0);
                                    Block.dropResources(
                                       world.getBlockState(_pos),
                                       world,
                                       BlockPos.containing(entityiteratorxxx.getX(), entityiteratorxxx.getY(), entityiteratorxxx.getZ() + 1.0),
                                       null
                                    );
                                    world.destroyBlock(_pos, false);
                                 }
                              } else if (Mth.nextInt(RandomSource.create(), 1, 10) == 5 && entityiteratorxxx instanceof Mob _entity) {
                                 _entity.getNavigation()
                                    .moveTo(
                                       (double)(
                                          (
                                                entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)
                                                   : 0
                                             )
                                             + Mth.nextInt(RandomSource.create(), -15, 15)
                                       ),
                                       entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxx
                                          ? (double)((Integer)_datEntIxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)).intValue()
                                          : 0.0,
                                       (double)(
                                          (
                                                entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)
                                                   : 0
                                             )
                                             + Mth.nextInt(RandomSource.create(), -15, 15)
                                       ),
                                       1.5
                                    );
                              }

                              sx = -1.0;

                              for (int index3 = 0; index3 < 3; index3++) {
                                 sy = -3.0;

                                 for (int index4 = 0; index4 < 4; index4++) {
                                    sz = -1.0;

                                    for (int index5 = 0; index5 < 3; index5++) {
                                       if (world.getBlockState(
                                                BlockPos.containing(entityiteratorxxx.getX() + sx, entityiteratorxxx.getY() + sy, entityiteratorxxx.getZ() + sz)
                                             )
                                             .getBlock()
                                          == Blocks.STONE) {
                                          entityiteratorxxx.getPersistentData().putDouble("navgx", entityiteratorxxx.getX() + sx);
                                          entityiteratorxxx.getPersistentData().putDouble("navgy", entityiteratorxxx.getY() + sy);
                                          entityiteratorxxx.getPersistentData().putDouble("navgz", entityiteratorxxx.getZ() + sz);
                                          break;
                                       }

                                       sz++;
                                    }

                                    sy++;
                                 }

                                 sx++;
                              }
                           }
                        }
                     }
                  }
               }

               var182 = _center = new Vec3(
                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxx
                     ? (double)((Integer)_datEntIxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)).intValue()
                     : 0.0,
                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxx
                     ? (double)((Integer)_datEntIxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)).intValue()
                     : 0.0,
                  entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxx
                     ? (double)((Integer)_datEntIxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)).intValue()
                     : 0.0
               );

               for (Entity entityiteratorxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(27.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorxxxx instanceof AntArsonistWorkerEntity) {
                     if (entityiteratorxxxx instanceof LivingEntity) {
                        LivingEntity _livEnt441 = (LivingEntity)entityiteratorxxxx;
                        if (_livEnt441.hasEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get())) {
                           continue;
                        }
                     }

                     if (entityiteratorxxxx instanceof AntArsonistWorkerEntity) {
                        AntArsonistWorkerEntity _datEntL442 = (AntArsonistWorkerEntity)entityiteratorxxxx;
                        if ((Boolean)_datEntL442.getEntityData().get(AntArsonistWorkerEntity.DATA_following)) {
                           continue;
                        }
                     }

                     if (entityiteratorxxxx instanceof TamableAnimal) {
                        TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxxxx;
                        LivingEntity var149 = entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null;
                        if (var149 instanceof LivingEntity) {
                           LivingEntity _livEnt = var149;
                           if (_tamIsTamedBy.isOwnedBy(_livEnt) && Mth.nextInt(RandomSource.create(), 1, 3) == 2 && entityiteratorxxxx instanceof Mob _entity) {
                              _entity.getNavigation()
                                 .moveTo(
                                    (double)(
                                       (
                                             entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxxx
                                                ? (Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)
                                                : 0
                                          )
                                          + Mth.nextInt(RandomSource.create(), -15, 15)
                                    ),
                                    entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxx
                                       ? (double)((Integer)_datEntIxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)).intValue()
                                       : 0.0,
                                    (double)(
                                       (
                                             entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxx
                                                ? (Integer)_datEntIxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)
                                                : 0
                                          )
                                          + Mth.nextInt(RandomSource.create(), -15, 15)
                                    ),
                                    1.5
                                 );
                           }
                        }
                     }
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxx) {
                  _levelxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(
                                 entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxxx
                                    ? (double)((Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)).intValue()
                                    : 0.0,
                                 (double)(
                                    (
                                          entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxx
                                             ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)
                                             : 0
                                       )
                                       + 1
                                 ),
                                 entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxx
                                    ? (double)((Integer)_datEntIxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)).intValue()
                                    : 0.0
                              ),
                              Vec2.ZERO,
                              _levelxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:charcoal ~ ~ ~ 4 0.3 4 0 100 force"
                     );
               }

               if (world instanceof ServerLevel _levelxxxxxx) {
                  _levelxxxxxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(
                                 entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxxx
                                    ? (double)((Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)).intValue()
                                    : 0.0,
                                 (double)(
                                    (
                                          entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxx
                                             ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)
                                             : 0
                                       )
                                       + 1
                                 ),
                                 entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxx
                                    ? (double)((Integer)_datEntIxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)).intValue()
                                    : 0.0
                              ),
                              Vec2.ZERO,
                              _levelxxxxxx,
                              4,
                              "",
                              Component.literal(""),
                              _levelxxxxxx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:whitecoal ~ ~ ~ 4 0.3 4 0 100 force"
                     );
               }

               ArphexMod.queueServerWork(
                  10,
                  () -> {
                     if (world instanceof ServerLevel _levelxxxxxx) {
                        _levelxxxxxx.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(
                                       entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxxx
                                          ? (double)((Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)).intValue()
                                          : 0.0,
                                       (double)(
                                          (
                                                entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)
                                                   : 0
                                             )
                                             + 1
                                       ),
                                       entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxx
                                          ? (double)((Integer)_datEntIxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)).intValue()
                                          : 0.0
                                    ),
                                    Vec2.ZERO,
                                    _levelxxxxxx,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _levelxxxxxx.getServer(),
                                    null
                                 )
                                 .withSuppressedOutput(),
                              "particle arphex:charcoal ~ ~ ~ 4 0.3 4 0 100 force"
                           );
                     }

                     if (world instanceof ServerLevel _levelxxxxxx) {
                        _levelxxxxxx.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(
                                       entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxxx
                                          ? (double)((Integer)_datEntIxxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Xarea)).intValue()
                                          : 0.0,
                                       (double)(
                                          (
                                                entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxxx
                                                   ? (Integer)_datEntIxxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Yarea)
                                                   : 0
                                             )
                                             + 1
                                       ),
                                       entity instanceof AntArsonistAlateQueenEntity _datEntIxxxxxxxxxx
                                          ? (double)((Integer)_datEntIxxxxxxxxxx.getEntityData().get(AntArsonistAlateQueenEntity.DATA_Zarea)).intValue()
                                          : 0.0
                                    ),
                                    Vec2.ZERO,
                                    _levelxxxxxx,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _levelxxxxxx.getServer(),
                                    null
                                 )
                                 .withSuppressedOutput(),
                              "particle arphex:whitecoal ~ ~ ~ 4 0.3 4 0 100 force"
                           );
                     }
                  }
               );
            }

            if ((!(entity instanceof TamableAnimal _tamEntxx) || !_tamEntxx.isTame())
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()) {
               ArphexMod.queueServerWork(
                  20,
                  () -> {
                     if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }

            entity.getPersistentData().putDouble("queenticks", 20.0);
         } else {
            entity.getPersistentData().putDouble("queenticks", entity.getPersistentData().getDouble("queenticks") - 1.0);
         }
      }
   }
}
