package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.BloodthirstyTendrilEntity;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.ScorpioidCloneEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.monster.hoglin.Hoglin;
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

public class ScorpioidBloodlusterOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double homing = 0.0;
         if ((Boolean)ConfigurationSettingsConfiguration.DWELLER_HEALTH.get()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 60.0F
            && entity instanceof LivingEntity _entity) {
            _entity.setHealth(60.0F);
         }

         if (entity.isInWall() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 5, false, false));
         }

         if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 0.0F)) {
            if (entity instanceof Mob _entity) {
               _entity.getNavigation().stop();
            }

            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F
            > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
            int var111;
            label665: {
               if (entity instanceof LivingEntity _livEntxx && _livEntxx.hasEffect(MobEffects.REGENERATION)) {
                  var111 = _livEntxx.getEffect(MobEffects.REGENERATION).getAmplifier();
                  break label665;
               }

               var111 = 0;
            }

            if (var111 < 1 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
            }
         }

         if (world.isClientSide()) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F
               > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
               if (entity instanceof ScorpioidBloodlusterEntity animatable) {
                  animatable.setTexture("scorpioidbloodluster2");
               }
            } else if (entity instanceof ScorpioidBloodlusterEntity animatable) {
               animatable.setTexture("scorpioidbloodluster");
            }
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getHealth() : -1.0F)
               > (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 2.0F) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(
                     (SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(),
                     x,
                     y,
                     z,
                     (int)((double)(entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getHealth() : -1.0F) / 2.5),
                     0.8,
                     2.0,
                     0.8,
                     3.0
                  );
               }
            } else if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(),
                  x,
                  y,
                  z,
                  (int)((double)(entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getHealth() : -1.0F) / 2.5),
                  0.8,
                  2.0,
                  0.8,
                  3.0
               );
            }
         }

         int var115;
         label657: {
            if (entity instanceof LivingEntity _livEntxxxx && _livEntxxxx.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
               var115 = _livEntxxxx.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
               break label657;
            }

            var115 = 0;
         }

         if (var115 == 99) {
            entity.setSprinting(false);
            entity.setShiftKeyDown(false);
         } else if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            entity.setSprinting(false);
            entity.setShiftKeyDown(false);
         } else if (!(entity.getDeltaMovement().x() > 0.0) && !(entity.getDeltaMovement().z() > 0.0)) {
            entity.setShiftKeyDown(true);
            entity.setSprinting(false);
         } else {
            if (!(entity.getDeltaMovement().x() > 0.0) && !(entity.getDeltaMovement().z() > 0.0)) {
               entity.teleportTo(entity.getX(), entity.getY() + 0.1, entity.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 0.1, entity.getZ(), entity.getYRot(), entity.getXRot());
               }
            }

            entity.setShiftKeyDown(false);
            entity.setSprinting(true);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (entity.isInWall() && world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute at @e[type=arphex:scorpioid_bloodluster,limit=1,sort=nearest] run tp @e[type=arphex:scorpioid_bloodluster,limit=1,sort=nearest] ^ ^0.01 ^0.17"
                  );
            }

            if (!(entity.getPersistentData().getDouble("tptime") > 0.0)) {
               entity.getPersistentData().putDouble("tptime", 40.0);
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString().equals("zoniex:blood_eagle") && entity instanceof Mob) {
                     Mob _entity = (Mob)entity;
                     if (entityiterator instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("tptime", entity.getPersistentData().getDouble("tptime") - 1.0);
            }
         } else {
            if (entity.isInWater() || entity.isInLava()) {
               homing = Math.sqrt(
                  Math.pow((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX() - entity.getX(), 2.0)
                     + Math.pow((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() - entity.getY(), 2.0)
                     + Math.pow((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ() - entity.getZ(), 2.0)
               );
               entity.setDeltaMovement(
                  new Vec3(
                     ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX() - entity.getX()) / homing * 0.3,
                     ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY() + 0.6 - entity.getY()) / homing * 0.3,
                     ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ() - entity.getZ()) / homing * 0.3
                  )
               );
            }

            label684: {
               if (entity instanceof LivingEntity _livEnt74 && _livEnt74.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  break label684;
               }

               if (entity instanceof LivingEntity _livEnt75
                  && _livEnt75.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())
                  && entity.getX() + 10.0 > (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX()
                  && entity.getX() - 10.0 < (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX()
                  && entity.getZ() + 10.0 > (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                  && entity.getZ() - 10.0 < (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()) {
                  if (entity.getY() < (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY() + 1.6) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 6.0,
                           0.3,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 6.0
                        )
                     );
                  } else {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 5.0,
                           -0.2,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 5.0
                        )
                     );
                  }
                  break label684;
               }

               if (entity.getY() < (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY() + 0.5) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 6.0,
                        0.3,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 6.0
                     )
                  );
               } else {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 5.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 5.0
                     )
                  );
               }
            }

            if ((
                  entity.getPersistentData().getDouble("tptime") == 5.0
                     || entity.getPersistentData().getDouble("tptime") == 45.0
                     || entity.getPersistentData().getDouble("tptime") == 20.0
                     || entity.getPersistentData().getDouble("tptime") == 60.0
               )
               && (
                  !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY(), entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY(), entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY(), entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 1.0, entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 1.0, entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 1.0, entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 1.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 1.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 1.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 2.0, entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 2.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 2.0, entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 2.0, entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 2.0, entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() + 2.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 2.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() + 2.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ()))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ() - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() + 1.0, entity.getY() - 1.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ() + 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(entity.getX() - 1.0, entity.getY() - 1.0, entity.getZ() + 1.0))
               )) {
               if (entity.getY() < (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY() + 0.5) {
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
                           "tp @s ^ ^0.2 ^0.15"
                        );
                  }
               } else if (!entity.level().isClientSide() && entity.getServer() != null) {
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
                        "tp @s ^ ^-0.2 ^0.15"
                     );
               }
            }

            if (entity.getPersistentData().getDouble("tptime") > 0.0) {
               entity.getPersistentData().putDouble("tptime", entity.getPersistentData().getDouble("tptime") - 1.0);
            } else {
               entity.getPersistentData().putDouble("tptime", 80.0);
            }

            if (entity.getPersistentData().getDouble("tptime") == 30.0) {
               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = (new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new BloodthirstyTendrilEntity(
                              (EntityType<? extends BloodthirstyTendrilEntity>)ArphexModEntities.BLOODTHIRSTY_TENDRIL.get(), level
                           );
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setPierceLevel(piercing);
                           return entityToSpawn;
                        }
                     })
                     .getArrow(
                        projectileLevel, entity, (float)(Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get()) + 1L), 0, (byte)1
                     );
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2.0F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }
         }

         ArphexMod.queueServerWork(12000, () -> {
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
               ArphexMod.queueServerWork(100, () -> {
                  if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
                     ArphexMod.queueServerWork(100, () -> {
                        if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
                           if (world instanceof ServerLevel _levelx) {
                              _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 2, 0.3, 0.3, 0.3, 0.3);
                           }

                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }
                        }
                     });
                  }
               });
            }
         });
         if (!world.getEntitiesOfClass(ScorpioidCloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0, false, false));
            }

            entity.getPersistentData().putBoolean("smaller", true);
         } else {
            entity.getPersistentData().putBoolean("smaller", false);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.REPULSION.get());
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator") && entity instanceof Mob _entity) {
               Entity var77 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var77 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }
         } else if (!world.getEntitiesOfClass(Hoglin.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
            && (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null) == null
            && entity instanceof Mob _entityx) {
            Entity var87 = world.getEntitiesOfClass(Hoglin.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (var87 instanceof LivingEntity _ent) {
               _entityx.setTarget(_ent);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getHealth() : -1.0F) < 35.0F && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 1, 0.5, 1.0, 0.5, 0.1);
         }

         if (!(Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get() && !entity.level().isClientSide()) {
            entity.discard();
         }

         if ((Boolean)ConfigurationSettingsConfiguration.DWELLER_HEALTH.get()
            && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getHealth() : -1.0F) > 60.0F
            && entity instanceof LivingEntity _entityxx) {
            _entityxx.setHealth(60.0F);
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            if (!(entity.getPersistentData().getDouble("scorpbreak") > 0.0)) {
               entity.getPersistentData().putDouble("scorpbreak", 15.0);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass_pane"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #arphex:breakable_doors"
                        );
                  }
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace minecraft:nether_wart_block"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace minecraft:warped_wart_block"
                        );
                  }
               }
            } else {
               entity.getPersistentData().putDouble("scorpbreak", entity.getPersistentData().getDouble("scorpbreak") - 1.0);
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty() && !entity.isShiftKeyDown()) {
            if (!(entity.getPersistentData().getDouble("wingsound") > 1.0)) {
               entity.getPersistentData().putDouble("wingsound", (double)Mth.nextInt(RandomSource.create(), 2, 8));
               if ((entity.getDeltaMovement().x() + entity.getDeltaMovement().y() + entity.getDeltaMovement().z()) / 3.0 < 0.6) {
                  if (world instanceof Level _level) {
                     if (!_level.isClientSide()) {
                        _level.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth1")),
                           SoundSource.HOSTILE,
                           (float)(
                              0.3
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 4.0
                           ),
                           (float)(
                              0.8
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 1.0
                           )
                        );
                     } else {
                        _level.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth1")),
                           SoundSource.HOSTILE,
                           (float)(
                              0.3
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 4.0
                           ),
                           (float)(
                              0.8
                                 + (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().y()) + Math.abs(entity.getDeltaMovement().z()))
                                    / 1.0
                           ),
                           false
                        );
                     }
                  }
               } else if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth2")),
                        SoundSource.HOSTILE,
                        0.3F,
                        (float)Mth.nextDouble(RandomSource.create(), 2.0, 3.3)
                     );
                  } else {
                     _levelx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:flyingmoth2")),
                        SoundSource.HOSTILE,
                        0.3F,
                        (float)Mth.nextDouble(RandomSource.create(), 2.0, 3.3),
                        false
                     );
                  }
               }
            } else {
               entity.getPersistentData().putDouble("wingsound", entity.getPersistentData().getDouble("wingsound") - 1.0);
            }
         }

         label561: {
            if (entity instanceof LivingEntity _livEnt314 && _livEnt314.hasEffect((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get())) {
               if (entity instanceof LivingEntity _entityxx && !_entityxx.level().isClientSide()) {
                  _entityxx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 3, false, false));
               }

               if (entity instanceof LivingEntity _entityxx && !_entityxx.level().isClientSide()) {
                  _entityxx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 3, false, false));
               }

               Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (!(entityiteratorx instanceof ScorpioidBloodlusterEntity)
                     && !(entityiteratorx instanceof ScorpioidCloneEntity)
                     && !entity.getPersistentData().getBoolean("creativespectator")
                     && entityiteratorx instanceof LivingEntity) {
                     LivingEntity _entityxx = (LivingEntity)entityiteratorx;
                     if (!_entityxx.level().isClientSide()) {
                        _entityxx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.REPULSION.get(), 15, 1, false, false));
                     }
                  }
               }

               if (entity instanceof LivingEntity _entityxx && !_entityxx.level().isClientSide()) {
                  _entityxx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 10, 1, false, false));
               }

               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 14.0,
                     0.05,
                     Math.sin((double)(entity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 14.0
                  )
               );
               if (!(entity.getPersistentData().getDouble("slowshield") > 0.0)) {
                  if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getHealth() : -1.0F)
                     > (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) / 2.0F) {
                     int horizontalRadiusSphere = (int)entity.getPersistentData().getDouble("spheregrow") - 1;
                     int verticalRadiusSphere = (int)entity.getPersistentData().getDouble("spheregrow") - 1;
                     int yIterationsSphere = verticalRadiusSphere;

                     for (int i = -verticalRadiusSphere; i <= yIterationsSphere; i++) {
                        for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                           for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                              double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere)
                                 + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere)
                                 + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
                              if (distanceSq <= 1.0 && world instanceof ServerLevel _levelxx) {
                                 _levelxx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(),
                                    x + (double)xi,
                                    y + (double)i,
                                    z + (double)zi,
                                    1,
                                    0.1,
                                    0.1,
                                    0.1,
                                    0.0
                                 );
                              }
                           }
                        }
                     }
                  } else {
                     int horizontalRadiusSphere = (int)entity.getPersistentData().getDouble("spheregrow") - 1;
                     int verticalRadiusSphere = (int)entity.getPersistentData().getDouble("spheregrow") - 1;
                     int yIterationsSphere = verticalRadiusSphere;

                     for (int i = -verticalRadiusSphere; i <= yIterationsSphere; i++) {
                        for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                           for (int zix = -horizontalRadiusSphere; zix <= horizontalRadiusSphere; zix++) {
                              double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere)
                                 + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere)
                                 + (double)(zix * zix) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
                              if (distanceSq <= 1.0 && world instanceof ServerLevel _levelxx) {
                                 _levelxx.sendParticles(
                                    (SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(),
                                    x + (double)xi,
                                    y + (double)i,
                                    z + (double)zix,
                                    1,
                                    0.1,
                                    0.1,
                                    0.1,
                                    0.0
                                 );
                              }
                           }
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("slowshield", 5.0);
               } else {
                  entity.getPersistentData().putDouble("slowshield", entity.getPersistentData().getDouble("slowshield") - 1.0);
               }

               if (entity.getPersistentData().getDouble("spheregrow") < 10.0) {
                  entity.getPersistentData().putDouble("spheregrow", entity.getPersistentData().getDouble("spheregrow") + 0.5);
               }
               break label561;
            }

            entity.getPersistentData().putDouble("spheregrow", 0.0);
         }

         if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getHealth() : -1.0F) < 1.0F) {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         }
      }
   }
}
