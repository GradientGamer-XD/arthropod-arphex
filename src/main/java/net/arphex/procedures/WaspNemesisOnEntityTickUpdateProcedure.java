package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.WaspNemesisEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class WaspNemesisOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof WaspNemesisEntity _datEntI ? (Integer)_datEntI.getEntityData().get(WaspNemesisEntity.DATA_size) : 0) < 12) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 2, false, false));
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 60.0F) {
               ArphexMod.queueServerWork(
                  5,
                  () -> {
                     if ((entity instanceof WaspNemesisEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(WaspNemesisEntity.DATA_size) : 0) < 12
                        && entity instanceof LivingEntity _entityx) {
                        _entityx.setHealth(60.0F);
                     }
                  }
               );
            }

            if (!world.isClientSide() && Mth.nextInt(RandomSource.create(), 1, 1200) == 5 && entity instanceof WaspNemesisEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     WaspNemesisEntity.DATA_size,
                     (entity instanceof WaspNemesisEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(WaspNemesisEntity.DATA_size) : 0) + 1
                  );
            }
         }

         if (entity.isInWaterOrBubble() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 0, false, false));
         }

         label484:
         if (!(entity.getPersistentData().getDouble("eagletickslow") > 0.0)) {
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               break label484;
            }

            entity.getPersistentData().putDouble("eagletickslow", (double)Mth.nextInt(RandomSource.create(), 1200, 2400));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, Mth.nextInt(RandomSource.create(), 20, 200), 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, Mth.nextInt(RandomSource.create(), 300, 600), 0, false, false));
            }
         } else {
            entity.getPersistentData().putDouble("eagletickslow", entity.getPersistentData().getDouble("eagletickslow") - 1.0);
         }

         label478: {
            if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MobEffects.LEVITATION)) {
               if (Mth.nextInt(RandomSource.create(), 1, 5) == 5 && world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y + 1.6, z, 1, 1.0, 0.3, 1.0, 0.0);
               }

               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                     entity.getDeltaMovement().y(),
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
               ArphexMod.queueServerWork(
                  5,
                  () -> entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           entity.getDeltaMovement().y(),
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     )
               );
               break label478;
            }

            if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                     entity.getDeltaMovement().y(),
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
               if (Mth.nextInt(RandomSource.create(), 1, 5) == 5 && world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y + 1.6, z, 1, 1.0, 0.3, 1.0, 0.0);
               }
            }
         }

         if (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().z()) != 0.0) {
            if (!(entity.getPersistentData().getDouble("eagleflap") > 0.0)) {
               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzshort")),
                        SoundSource.HOSTILE,
                        1.0F,
                        (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.5)
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzshort")),
                        SoundSource.HOSTILE,
                        1.0F,
                        (float)Mth.nextDouble(RandomSource.create(), 0.1, 0.5),
                        false
                     );
                  }
               }

               entity.getPersistentData().putDouble("eagleflap", (double)Mth.nextInt(RandomSource.create(), 2, 4));
            } else {
               entity.getPersistentData().putDouble("eagleflap", entity.getPersistentData().getDouble("eagleflap") - 1.0);
            }
         }

         if (!(entity.getPersistentData().getDouble("eagletick") > 0.0)) {
            if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
               && (Mth.nextInt(RandomSource.create(), 1, 5) == 5 || (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null)) {
               if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null) {
                  if (!world.isClientSide()) {
                     if (entity.getDirection() != Direction.NORTH
                        || world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1.0))
                           && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() - 1.0))) {
                        if (entity.getDirection() != Direction.SOUTH
                           || world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1.0))
                              && world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() + 1.0))) {
                           if (entity.getDirection() != Direction.WEST
                              || world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY(), entity.getZ()))
                                 && world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 1.0, entity.getZ()))) {
                              if (entity.getDirection() != Direction.EAST
                                 || world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ()))
                                    && world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 1.0, entity.getZ()))) {
                                 entity.lookAt(
                                    Anchor.EYES,
                                    new Vec3(
                                       entity.getX() + (double)Mth.nextInt(RandomSource.create(), -1, 1),
                                       entity.getY(),
                                       entity.getZ() + (double)Mth.nextInt(RandomSource.create(), -1, 1)
                                    )
                                 );
                              } else {
                                 entity.lookAt(Anchor.EYES, new Vec3(entity.getX() + 1.0, entity.getY(), entity.getLookAngle().z));
                              }
                           } else {
                              entity.lookAt(Anchor.EYES, new Vec3(entity.getX() + 1.0, entity.getY(), entity.getLookAngle().z));
                           }
                        } else {
                           entity.lookAt(Anchor.EYES, new Vec3(entity.getLookAngle().x, entity.getY(), entity.getZ() - 1.0));
                        }
                     } else {
                        entity.lookAt(Anchor.EYES, new Vec3(entity.getLookAngle().x, entity.getY(), entity.getZ() + 1.0));
                     }
                  }
               } else {
                  if (!world.isClientSide()) {
                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ()
                        )
                     );
                  }

                  if ((entity instanceof WaspNemesisEntity _datEntI ? (Integer)_datEntI.getEntityData().get(WaspNemesisEntity.DATA_size) : 0) >= 12
                     && 30.0
                        > Math.sqrt(
                              (entity.getX() - (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getX())
                                    * (entity.getX() - (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX())
                                 + (entity.getY() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY())
                                    * (entity.getY() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY())
                                 + (entity.getZ() - (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ())
                                    * (entity.getZ() - (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ())
                           )
                           / 2.0) {
                     Level projectileLevel = entity.level();
                     if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = (new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new BloodProjectileEntity(
                                    (EntityType<? extends BloodProjectileEntity>)ArphexModEntities.BLOOD_PROJECTILE.get(), level
                                 );
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })
                           .getArrow(projectileLevel, entity, 5.0F, 1);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.8F, 0.2F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }

                     ArphexMod.queueServerWork(
                        20,
                        () -> {
                           Level projectileLevelx = entity.level();
                           if (!projectileLevelx.isClientSide()) {
                              Projectile _entityToSpawnx = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new BloodProjectileEntity(
                                          (EntityType<? extends BloodProjectileEntity>)ArphexModEntities.BLOOD_PROJECTILE.get(), level
                                       );
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       return entityToSpawn;
                                    }
                                 })
                                 .getArrow(projectileLevelx, entity, 5.0F, 1);
                              _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                              _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.8F, 0.2F);
                              projectileLevelx.addFreshEntity(_entityToSpawnx);
                           }
                        }
                     );
                     ArphexMod.queueServerWork(
                        40,
                        () -> {
                           Level projectileLevelx = entity.level();
                           if (!projectileLevelx.isClientSide()) {
                              Projectile _entityToSpawnx = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                       AbstractArrow entityToSpawn = new BloodProjectileEntity(
                                          (EntityType<? extends BloodProjectileEntity>)ArphexModEntities.BLOOD_PROJECTILE.get(), level
                                       );
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       return entityToSpawn;
                                    }
                                 })
                                 .getArrow(projectileLevelx, entity, 5.0F, 1);
                              _entityToSpawnx.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                              _entityToSpawnx.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.8F, 0.2F);
                              projectileLevelx.addFreshEntity(_entityToSpawnx);
                           }
                        }
                     );
                  }
               }
            }

            if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
               && (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() > entity.getY() + 3.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 50, 3, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 65, 0, false, false));
            }

            if (Mth.nextInt(RandomSource.create(), 1, 10) == 1 && world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large")),
                     SoundSource.HOSTILE,
                     4.0F,
                     (float)Mth.nextDouble(RandomSource.create(), 0.5, 1.5)
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large")),
                     SoundSource.HOSTILE,
                     4.0F,
                     (float)Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
                     false
                  );
               }
            }

            entity.getPersistentData().putDouble("eagletick", 60.0);
         } else {
            entity.getPersistentData().putDouble("eagletick", entity.getPersistentData().getDouble("eagletick") - 1.0);
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
            && world instanceof ServerLevel _levelxx) {
            _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 1, 1.0, 1.0, 1.0, 0.1);
         }

         if (!(entity.getPersistentData().getDouble("wanderbreak") > 0.0)) {
            entity.getPersistentData().putDouble("wanderbreak", 30.0);
            if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
               && entity.getY() > (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY()) {
               if (!world.isClientSide()) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ()
                     )
                  );
               }

               if (8.0
                  > Math.sqrt(
                        (entity.getX() - (entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null).getX())
                              * (entity.getX() - (entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getX())
                           + (entity.getY() - (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getY())
                              * (entity.getY() - (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getY())
                           + (entity.getZ() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getZ())
                              * (entity.getZ() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ())
                     )
                     / 2.0) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 4.0,
                        -1.0,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 4.0
                     )
                  );
               }
            }

            if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
               )
             {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace glass"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace glass_pane"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace #arphex:breakable_doors"
                        );
                  }
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #minecraft:leaves"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace cobweb"
                        );
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("wanderbreak", entity.getPersistentData().getDouble("wanderbreak") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("downalternate") > 0.0)) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               entity.getPersistentData().putString("curvefly", "straight");
            } else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               entity.getPersistentData().putString("curvefly", "anticlockwise");
            } else {
               entity.getPersistentData().putString("curvefly", "clockwise");
            }

            entity.getPersistentData().putDouble("downalternate", 100.0);
         } else {
            entity.getPersistentData().putDouble("downalternate", entity.getPersistentData().getDouble("downalternate") - 1.0);
         }

         if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) == null) {
            if (entity instanceof LivingEntity _livEnt232 && _livEnt232.hasEffect(MobEffects.LEVITATION)) {
               if (entity.getPersistentData().getString("curvefly").equals("clockwise")) {
                  if (!world.isClientSide()) {
                     entity.setYRot((float)((double)entity.getYRot() + 0.5));
                     entity.setXRot(entity.getXRot());
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }
               } else if (entity.getPersistentData().getString("curvefly").equals("anticlockwise") && !world.isClientSide()) {
                  entity.setYRot((float)((double)entity.getYRot() - 0.5));
                  entity.setXRot(entity.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }
            }
         } else {
            label417:
            if (entity.getY() > (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY()) {
               if (entity.getPersistentData().getDouble("downalternate") == 50.0 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 60, 0, false, false));
               }

               if (entity instanceof LivingEntity _livEnt248 && _livEnt248.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
                  break label417;
               }

               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.4, entity.getDeltaMovement().z()));
            }

            if ((entity.onGround() || world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 25, 1, false, false));
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && entity.getY() > 55.0
            && entity.getY() < 60.0) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
         }
      }
   }
}
