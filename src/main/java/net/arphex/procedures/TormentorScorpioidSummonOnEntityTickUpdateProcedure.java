package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.BloodthirstyTendrilEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentorScorpioidSummonOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean onetarget = false;
         entity.noPhysics = true;
         entity.getPersistentData().putBoolean("tormentor_target", false);
         if (entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
            for (Entity entityiterator : new ArrayList(world.players())) {
               double _setval = 5.0;
               entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.sphere_near = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
            }
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            if (entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
               (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getPersistentData().putBoolean("tormentor_target", true);
            }

            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof TORMENTOREntity && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var18) {
                  var18.printStackTrace();
               }
            }
         }

         if (!world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true).isEmpty()
            || entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
            world.addParticle((SimpleParticleType)ArphexModParticleTypes.TORMENTOR_SMOKE.get(), x, y, z, 0.0, 0.0, 0.0);
            onetarget = false;
            if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) && entity instanceof TormentorScorpioidSummonEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(TormentorScorpioidSummonEntity.DATA_flee_mode, false);
            }

            label252: {
               if (entity instanceof TormentorScorpioidSummonEntity _datEntL16
                  && (Boolean)_datEntL16.getEntityData().get(TormentorScorpioidSummonEntity.DATA_flee_mode)) {
                  if (entity instanceof Mob) {
                     try {
                        ((Mob)entity).setTarget(null);
                     } catch (Exception var17) {
                        var17.printStackTrace();
                     }
                  }

                  if (!world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()) {
                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof Player
                           && !entityiterator.getPersistentData().getBoolean("creativespectator")
                           && entityiterator instanceof Player) {
                           Player _player = (Player)entityiterator;
                           if (!_player.level().isClientSide()) {
                              _player.displayClientMessage(Component.literal("It healed the Tormentor! Don't let it hit you and get away."), true);
                           }
                        }
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "particle arphex:solid_red_smoke ~ ~ ~ 1 1 1 0.8 160 force"
                           );
                     }

                     if (ArphexModVariables.MapVariables.get(world).tormentor_health < 1010.0) {
                        ArphexModVariables.MapVariables.get(world).tormentor_health += 6.0;
                        ArphexModVariables.MapVariables.get(world).syncData(world);
                     }

                     if (entity instanceof TormentorScorpioidSummonEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(TormentorScorpioidSummonEntity.DATA_flee_mode, false);
                     }
                  }

                  if (world.isClientSide() && entity instanceof TormentorScorpioidSummonEntity animatable) {
                     animatable.setTexture("tormentlusterobtained");
                  }

                  if (entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())
                     || world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()
                     || entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
                     break label252;
                  }

                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getX(),
                        world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getY(),
                        world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true)
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
                  );
                  if (entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     break label252;
                  }

                  if (entity.getY()
                     > world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getY()) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.6,
                           -0.8,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.6
                        )
                     );
                  } else {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.6,
                           0.8,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.6
                        )
                     );
                  }
                  break label252;
               }

               if (world.isClientSide() && entity instanceof TormentorScorpioidSummonEntity animatable) {
                  animatable.setTexture("tormentluster");
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(250.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (!onetarget
                     && entityiteratorx.getPersistentData().getBoolean("tormentor_target")
                     && !(
                        ((ArphexModVariables.PlayerVariables)entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .tormentor_respite
                           > 0.0
                     )) {
                     onetarget = true;
                     if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null && entity instanceof Mob) {
                        Mob _entity = (Mob)entity;
                        if (entityiteratorx instanceof LivingEntity _ent) {
                           _entity.setTarget(_ent);
                        }
                     }
                  }
               }

               if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
                  label210:
                  if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
                     entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 40));
                     if (entity instanceof LivingEntity _livEnt60 && _livEnt60.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        break label210;
                     }

                     label204:
                     if (entity.getY() < (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY() + 0.5) {
                        if (entity instanceof LivingEntity _livEnt65 && _livEnt65.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                           entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.3, entity.getDeltaMovement().z()));
                           break label204;
                        }

                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                              0.3,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                           )
                        );
                     } else {
                        label259: {
                           if (entity instanceof LivingEntity _livEnt72 && _livEnt72.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                              entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.3, entity.getDeltaMovement().z()));
                              break label259;
                           }

                           entity.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                                 -0.2,
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                              )
                           );
                        }
                     }
                  } else {
                     entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
                  }
               }
            }

            if (entity instanceof LivingEntity _livEnt81 && _livEnt81.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y + 6.0, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:huge_fire ~ ~ ~ 0 0 0 0.1 5 force"
                     );
               }

               label181: {
                  entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                  if (entity instanceof LivingEntity _livEnt84 && _livEnt84.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     break label181;
                  }

                  entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
               }

               if (!(entity.getPersistentData().getDouble("partilimit") > 0.0)) {
                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
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
                                 entityToSpawn.setSecondsOnFire(100);
                                 return entityToSpawn;
                              }
                           })
                           .getArrow(projectileLevel, entity, 10.0F, 1, (byte)2);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 0.3F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }
                  }

                  entity.getPersistentData().putDouble("partilimit", 20.0);
               } else {
                  entity.getPersistentData().putDouble("partilimit", entity.getPersistentData().getDouble("partilimit") - 1.0);
               }
            }
         } else if (!entity.getPersistentData().getBoolean("spawned_by_player_summon") && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!entity.getPersistentData().getBoolean("spawned_by_player_summon")) {
            ArphexMod.queueServerWork(6000, () -> {
               if (!entity.getPersistentData().getBoolean("spawned_by_player_summon") && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }
      }
   }
}
