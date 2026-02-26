package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ScarabSummonEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ScarabSummonOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double homing = 0.0;
         if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 1.0F) && !entity.level().isClientSide()) {
            entity.discard();
         }

         ArphexMod.queueServerWork(5, () -> entity.getPersistentData().putBoolean("despawnable", true));
         if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), ex -> true).isEmpty()
            && entity instanceof TamableAnimal _toTame) {
            Entity _entfound = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), ex -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (_entfound instanceof Player _owner) {
               _toTame.tame(_owner);
            }
         }

         if (entity instanceof TamableAnimal _tamEntx && _tamEntx.isTame()) {
            entity.getPersistentData().putBoolean("nearown", false);
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), ex -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator == (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null)) {
                  entity.getPersistentData().putBoolean("nearown", true);
               }
            }

            if (!entity.getPersistentData().getBoolean("nearown") && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null) {
               homing = Math.sqrt(
                  Math.pow((entity instanceof TamableAnimal _tamEntxxxxx ? _tamEntxxxxx.getOwner() : null).getX() - entity.getX(), 2.0)
                     + Math.pow((entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null).getY() - entity.getY(), 2.0)
                     + Math.pow((entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getZ() - entity.getZ(), 2.0)
               );
               entity.setDeltaMovement(
                  new Vec3(
                     ((entity instanceof TamableAnimal _tamEntxxxxxxxx ? _tamEntxxxxxxxx.getOwner() : null).getX() - entity.getX()) / homing * 0.3,
                     ((entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null).getY() + 0.6 - entity.getY()) / homing * 0.3,
                     ((entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null).getZ() - entity.getZ()) / homing * 0.3
                  )
               );
            }
         }

         ArphexMod.queueServerWork(350, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (!entity.getPersistentData().getBoolean("variantlock")) {
            entity.getPersistentData().putBoolean("variantlock", true);
            if (entity instanceof ScarabSummonEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_brownfound, false);
            }

            if (entity instanceof ScarabSummonEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_greenfound, false);
            }

            if (entity instanceof ScarabSummonEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_greengoldfound, false);
            }

            if (entity instanceof ScarabSummonEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_iridescentfound, false);
            }

            if (entity instanceof ScarabSummonEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_purplefound, false);
            }

            if (entity instanceof ScarabSummonEntity _datEntSetL) {
               _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_goldfound, false);
            }

            if (entity instanceof TamableAnimal _tamEntxx
               && _tamEntxx.isTame()
               && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null) {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), ex -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx instanceof ScarabSummonEntity
                     && entityiteratorx instanceof TamableAnimal _tamEntxxxxx
                     && _tamEntxxxxx.isTame()
                     && entityiteratorx != entity
                     && (entityiteratorx instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null)
                        == (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null)) {
                     if ((entityiteratorx instanceof ScarabSummonEntity _datEntS ? (String)_datEntS.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                           .equals("brown")
                        && entity instanceof ScarabSummonEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_brownfound, true);
                     }

                     if ((entityiteratorx instanceof ScarabSummonEntity _datEntS ? (String)_datEntS.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                           .equals("green")
                        && entity instanceof ScarabSummonEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_greenfound, true);
                     }

                     if ((entityiteratorx instanceof ScarabSummonEntity _datEntS ? (String)_datEntS.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                           .equals("greengold")
                        && entity instanceof ScarabSummonEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_greengoldfound, true);
                     }

                     if ((entityiteratorx instanceof ScarabSummonEntity _datEntS ? (String)_datEntS.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                           .equals("iridescent")
                        && entity instanceof ScarabSummonEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_iridescentfound, true);
                     }

                     if ((entityiteratorx instanceof ScarabSummonEntity _datEntS ? (String)_datEntS.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                           .equals("purple")
                        && entity instanceof ScarabSummonEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_purplefound, true);
                     }

                     if ((entityiteratorx instanceof ScarabSummonEntity _datEntS ? (String)_datEntS.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                           .equals("gold")
                        && entity instanceof ScarabSummonEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(ScarabSummonEntity.DATA_goldfound, true);
                     }
                  }

                  if (entityiteratorx != entity
                     && (entityiteratorx instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null)
                        == (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null)) {
                     entity.getPersistentData().putBoolean("foundotherscarab", true);
                  }
               }

               if (entity instanceof ScarabSummonEntity _datEntSetS) {
                  _datEntSetS.getEntityData().set(ScarabSummonEntity.DATA_scarab, "gold");
               }

               if (!((entity instanceof TamableAnimal _tamEntxxxxx ? _tamEntxxxxx.getOwner() : null).getPersistentData().getDouble("goldbeetles") > 0.0)
                  || entity instanceof ScarabSummonEntity _datEntL76 && (Boolean)_datEntL76.getEntityData().get(ScarabSummonEntity.DATA_goldfound)
                  || (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null) instanceof Player _plrCldCheck78
                     && _plrCldCheck78.getCooldowns().isOnCooldown((Item)ArphexModItems.SEALED_GOLDEN_SCARAB.get())
                  || !(entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getPersistentData().getBoolean("justsummonedgold")) {
                  if (entity instanceof ScarabSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(ScarabSummonEntity.DATA_scarab, "purple");
                  }

                  if (!(
                        (entity instanceof TamableAnimal _tamEntxxxxxxxx ? _tamEntxxxxxxxx.getOwner() : null).getPersistentData().getDouble("purplebeetles")
                           > 0.0
                     )
                     || entity instanceof ScarabSummonEntity _datEntL84 && (Boolean)_datEntL84.getEntityData().get(ScarabSummonEntity.DATA_purplefound)
                     || (entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null) instanceof Player _plrCldCheck86
                        && _plrCldCheck86.getCooldowns().isOnCooldown((Item)ArphexModItems.SEALED_PURPLE_SCARAB.get())
                     || !(entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null).getPersistentData().getBoolean("justsummonedpurple")
                     )
                   {
                     if (entity instanceof ScarabSummonEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(ScarabSummonEntity.DATA_scarab, "iridescent");
                     }

                     if (!(
                           (entity instanceof TamableAnimal _tamEntxxxxxxxxxxx ? _tamEntxxxxxxxxxxx.getOwner() : null)
                                 .getPersistentData()
                                 .getDouble("irbeetles")
                              > 0.0
                        )
                        || entity instanceof ScarabSummonEntity _datEntL92 && (Boolean)_datEntL92.getEntityData().get(ScarabSummonEntity.DATA_iridescentfound)
                        || (entity instanceof TamableAnimal _tamEntxxxxxxxxxx ? _tamEntxxxxxxxxxx.getOwner() : null) instanceof Player _plrCldCheck94
                           && _plrCldCheck94.getCooldowns().isOnCooldown((Item)ArphexModItems.SEALED_IRIDESCENT_SCARAB.get())
                        || !(entity instanceof TamableAnimal _tamEntxxxxxxxxx ? _tamEntxxxxxxxxx.getOwner() : null)
                           .getPersistentData()
                           .getBoolean("justsummonediridescent")) {
                        if (entity instanceof ScarabSummonEntity _datEntSetS) {
                           _datEntSetS.getEntityData().set(ScarabSummonEntity.DATA_scarab, "greengold");
                        }

                        if (!(
                              (entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxxx.getOwner() : null)
                                    .getPersistentData()
                                    .getDouble("ggbeetles")
                                 > 0.0
                           )
                           || entity instanceof ScarabSummonEntity _datEntL100
                              && (Boolean)_datEntL100.getEntityData().get(ScarabSummonEntity.DATA_greengoldfound)
                           || (entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxx.getOwner() : null) instanceof Player _plrCldCheck102
                              && _plrCldCheck102.getCooldowns().isOnCooldown((Item)ArphexModItems.SEALED_GREEN_GOLD_SCARAB.get())
                           || !(entity instanceof TamableAnimal _tamEntxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxx.getOwner() : null)
                              .getPersistentData()
                              .getBoolean("justsummonedgreengold")) {
                           if (entity instanceof ScarabSummonEntity _datEntSetS) {
                              _datEntSetS.getEntityData().set(ScarabSummonEntity.DATA_scarab, "green");
                           }

                           if (!(
                                 (entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxxxxxx.getOwner() : null)
                                       .getPersistentData()
                                       .getDouble("greenbeetles")
                                    > 0.0
                              )
                              || entity instanceof ScarabSummonEntity _datEntL108
                                 && (Boolean)_datEntL108.getEntityData().get(ScarabSummonEntity.DATA_greenfound)
                              || (entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxxxxx.getOwner() : null) instanceof Player _plrCldCheck110
                                 && _plrCldCheck110.getCooldowns().isOnCooldown((Item)ArphexModItems.SEALED_GREEN_SCARAB.get())
                              || !(entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxxxx.getOwner() : null)
                                 .getPersistentData()
                                 .getBoolean("justsummonedgreen")) {
                              if (entity instanceof ScarabSummonEntity _datEntSetS) {
                                 _datEntSetS.getEntityData().set(ScarabSummonEntity.DATA_scarab, "brown");
                              }

                              if ((
                                    !(
                                          (entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxxxxxxxxx.getOwner() : null)
                                                .getPersistentData()
                                                .getDouble("brownbeetles")
                                             > 0.0
                                       )
                                       || entity instanceof ScarabSummonEntity _datEntL116
                                          && (Boolean)_datEntL116.getEntityData().get(ScarabSummonEntity.DATA_brownfound)
                                       || (entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxxxxxxxx.getOwner() : null) instanceof Player _plrCldCheck118
                                          && _plrCldCheck118.getCooldowns().isOnCooldown((Item)ArphexModItems.SEALED_BROWN_SCARAB.get())
                                       || !(entity instanceof TamableAnimal _tamEntxxxxxxxxxxxxxxxxxx ? _tamEntxxxxxxxxxxxxxxxxxx.getOwner() : null)
                                          .getPersistentData()
                                          .getBoolean("justsummonedbrown")
                                 )
                                 && !entity.level().isClientSide()) {
                                 entity.discard();
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (entity instanceof TamableAnimal _tamEntx && _tamEntx.isTame()) {
            if ((entity instanceof TamableAnimal _tamEntxxxxxxxx ? _tamEntxxxxxxxx.getOwner() : null) != null
               && !(
                  0.0
                     < (entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null).getPersistentData().getDouble("purplebeetles")
                        + (entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null).getPersistentData().getDouble("goldbeetles")
                        + (entity instanceof TamableAnimal _tamEntxxxxx ? _tamEntxxxxx.getOwner() : null).getPersistentData().getDouble("irbeetles")
                        + (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null).getPersistentData().getDouble("ggbeetles")
                        + (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getPersistentData().getDouble("greenbeetles")
                        + (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getPersistentData().getDouble("brownbeetles")
               )
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7.5), ex -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorx instanceof Player && entityiteratorx == (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null)) {
                  if ((entity instanceof ScarabSummonEntity _datEntS ? (String)_datEntS.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                     .equals("brown")) {
                     if (entityiteratorx instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiteratorx;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 0, false, false));
                        }
                     }
                  } else if ((entity instanceof ScarabSummonEntity _datEntSx ? (String)_datEntSx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                     .equals("green")) {
                     if (entityiteratorx instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiteratorx;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 1, false, false));
                        }
                     }
                  } else if ((entity instanceof ScarabSummonEntity _datEntSxx ? (String)_datEntSxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                     .equals("greengold")) {
                     if (entityiteratorx instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiteratorx;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 1, false, false));
                        }
                     }
                  } else if ((entity instanceof ScarabSummonEntity _datEntSxxx ? (String)_datEntSxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                     .equals("iridescent")) {
                     if (entityiteratorx instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiteratorx;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 2, false, false));
                        }
                     }
                  } else if ((entity instanceof ScarabSummonEntity _datEntSxxxx ? (String)_datEntSxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
                     .equals("purple")) {
                     if (entityiteratorx instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiteratorx;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 2, false, false));
                        }
                     }
                  } else if ((entity instanceof ScarabSummonEntity _datEntSxxxxx
                           ? (String)_datEntSxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab)
                           : "")
                        .equals("gold")
                     && entityiteratorx instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiteratorx;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 3, false, false));
                     }
                  }
               }
            }
         }

         if (!(entity instanceof ScarabSummonEntity _datEntSxxxxxxx ? (String)_datEntSxxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
               .equals("brown")
            && !(entity instanceof ScarabSummonEntity _datEntSxxxxxx ? (String)_datEntSxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
               .equals("green")) {
            if (!(entity.getPersistentData().getDouble("dashtime") > 0.0)) {
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        entity.getDeltaMovement().y(),
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 8.0
                     )
                  );
               }

               entity.getPersistentData().putDouble("dashtime", 20.0);
            } else {
               entity.getPersistentData().putDouble("dashtime", entity.getPersistentData().getDouble("dashtime") - 1.0);
            }
         }

         if ((entity instanceof ScarabSummonEntity _datEntSxxxxxxxx ? (String)_datEntSxxxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
            .equals("gold")) {
            if (world.isClientSide() && entity instanceof ScarabSummonEntity animatable) {
               animatable.setTexture("scarab3");
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GOLDEN_OPAL.get(), x, y, z, 1, 0.2, 0.2, 0.2, 0.0);
            }

            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1, false, false));
            }
         }

         if ((entity instanceof ScarabSummonEntity _datEntSxxxxxxxx ? (String)_datEntSxxxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
            .equals("purple")) {
            if (world.isClientSide() && entity instanceof ScarabSummonEntity animatable) {
               animatable.setTexture("scarab5");
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.PURPLE_GLINTS.get(), x, y, z, 3, 0.2, 0.2, 0.2, 0.1);
            }

            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0, false, false));
            }
         }

         if ((entity instanceof ScarabSummonEntity _datEntSxxxxxxxx ? (String)_datEntSxxxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
            .equals("iridescent")) {
            if (world.isClientSide() && entity instanceof ScarabSummonEntity animatable) {
               animatable.setTexture("iridescentbeetle");
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.FIRE_OPAL_SHARDS.get(), x, y, z, 1, 0.2, 0.2, 0.2, 0.1);
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0, false, false));
            }
         }

         if ((entity instanceof ScarabSummonEntity _datEntSxxxxxxxx ? (String)_datEntSxxxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
            .equals("green")) {
            if (world.isClientSide() && entity instanceof ScarabSummonEntity animatable) {
               animatable.setTexture("scarab1");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 0, false, false));
            }
         }

         if ((entity instanceof ScarabSummonEntity _datEntSxxxxxxxx ? (String)_datEntSxxxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
            .equals("greengold")) {
            if (world.isClientSide() && entity instanceof ScarabSummonEntity animatable) {
               animatable.setTexture("scarab4");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 0, false, false));
            }
         }

         if ((entity instanceof ScarabSummonEntity _datEntSxxxxxxxx ? (String)_datEntSxxxxxxxx.getEntityData().get(ScarabSummonEntity.DATA_scarab) : "")
            .equals("brown")) {
            if (world.isClientSide() && entity instanceof ScarabSummonEntity animatable) {
               animatable.setTexture("scarab2");
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 1, false, false));
            }
         }

         if (entity instanceof TamableAnimal _tamEntxxx
            && _tamEntxxx.isTame()
            && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null) {
            if (!(entity.getPersistentData().getDouble("retarget") > 0.0)) {
               entity.getPersistentData().putDouble("retarget", 50.0);
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), ex -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entityiteratorxx instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
                     && (entityiteratorxx instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                        == (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null)
                     && entity instanceof Mob _entity
                     && entityiteratorxx instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("retarget", entity.getPersistentData().getDouble("retarget") - 1.0);
            }
         }

         if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
            && !(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).isAlive()
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var43) {
               var43.printStackTrace();
            }
         }
      }
   }
}
