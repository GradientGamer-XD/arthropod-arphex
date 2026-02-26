package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.entity.CrabLarvaeEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CrabLarvaeOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label365: {
            ArphexMod.queueServerWork(10, () -> {
               if (!entity.getPersistentData().getBoolean("attackwait")) {
                  entity.getPersistentData().putBoolean("attackwait", true);
               }
            });
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               break label365;
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
               && (
                  (new Object() {
                           public boolean checkGamemode(Entity _ent) {
                              if (_ent instanceof ServerPlayer _serverPlayer) {
                                 return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                              } else {
                                 return _ent.level().isClientSide() && _ent instanceof Player _player
                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                       && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                          == GameType.SURVIVAL
                                    : false;
                              }
                           }
                        })
                        .checkGamemode(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null)
                        )
                     || (new Object() {
                           public boolean checkGamemode(Entity _ent) {
                              if (_ent instanceof ServerPlayer _serverPlayer) {
                                 return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                              } else {
                                 return _ent.level().isClientSide() && _ent instanceof Player _player
                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                       && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                          == GameType.ADVENTURE
                                    : false;
                              }
                           }
                        })
                        .checkGamemode(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null)
                        )
               )) {
               if (entity instanceof TamableAnimal _toTame) {
                  Entity _entity = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_entity instanceof Player _owner) {
                     _toTame.tame(_owner);
                  }
               }

               Entity var49 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var49 instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Tamed Crab Larvae"), true);
               }

               entity.setCustomName(
                  Component.literal(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getDisplayName().getString() + "'s Crab Constrictor Larvae"
                  )
               );
            }

            if (!world.getEntitiesOfClass(CrabConstrictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
               Entity var50 = world.getEntitiesOfClass(CrabConstrictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var50 instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null && entity instanceof Mob _entity) {
                  Entity _livEnt = world.getEntitiesOfClass(CrabConstrictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if ((_livEnt instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               }
            }
         }

         if (entity.isShiftKeyDown()) {
            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 20, false, false));
            }

            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX(),
                     (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY(),
                     (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ()
                  )
               );
               Vec3 _center = new Vec3(
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.5)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getX(),
                  (double)(
                     entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.5)),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY()
                        + 1
                  ),
                  (double)entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.5)),
                           Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getBlockPos()
                     .getZ()
               );

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator == (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null)
                     && !((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) > 100.0F)
                     && (!(entityiterator instanceof LivingEntity _livEnt42) || !_livEnt42.hasEffect((MobEffect)ArphexModMobEffects.CONSTRICTED.get()))
                     && entityiterator instanceof LivingEntity _entityx
                     && !_entityx.level().isClientSide()) {
                     _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CONSTRICTED.get(), 20, 1, false, false));
                  }
               }
            }

            if (entity instanceof CrabLarvaeEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     CrabLarvaeEntity.DATA_grabbingtime,
                     (entity instanceof CrabLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(CrabLarvaeEntity.DATA_grabbingtime) : 0) - 1
                  );
            }
         }

         if ((entity instanceof CrabLarvaeEntity _datEntI ? (Integer)_datEntI.getEntityData().get(CrabLarvaeEntity.DATA_grabbingtime) : 0) <= 0) {
            entity.setShiftKeyDown(false);
            if (entity instanceof CrabLarvaeEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(CrabLarvaeEntity.DATA_grabbingtime, 120);
            }
         }

         if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
            && Mth.nextInt(RandomSource.create(), 1, 100) == 5
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

         if (600 > (entity instanceof CrabLarvaeEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0)) {
            if (entity instanceof CrabLarvaeEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(CrabLarvaeEntity.DATA_crab_growth, 600);
            }
         } else if (96001 > (entity instanceof CrabLarvaeEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0)
            && entity instanceof CrabLarvaeEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  CrabLarvaeEntity.DATA_crab_growth,
                  (entity instanceof CrabLarvaeEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) + 1
               );
         }

         if (entity instanceof CrabLarvaeEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(CrabLarvaeEntity.DATA_crab_growth, 96002);
         }

         if (96001 > (entity instanceof CrabLarvaeEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0)) {
            if (entity instanceof CrabLarvaeEntity animatable) {
               animatable.setTexture("crablarvae");
            }
         } else if (entity instanceof CrabLarvaeEntity animatable) {
            animatable.setTexture("crabconstrictor_larvae_fullsize");
         }

         label305:
         if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
            if ((entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null
               && (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
               && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null)
               && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var17) {
                  var17.printStackTrace();
               }
            }

            if (entity instanceof CrabLarvaeEntity _datEntL74 && (Boolean)_datEntL74.getEntityData().get(CrabLarvaeEntity.DATA_following)) {
               if (!entity.getDisplayName().getString().endsWith("(following)")) {
                  entity.setCustomName(Component.literal(entity.getDisplayName().getString() + " (following)"));
               }
               break label305;
            }

            if (entity.getDisplayName().getString().endsWith("(following)")) {
               entity.setCustomName(
                  Component.literal(
                     entity.getDisplayName()
                        .getString()
                        .replace("(following)", "")
                        .substring(0, entity.getDisplayName().getString().replace("(following)", "").length() - 1)
                  )
               );
            }
         }

         if ((entity instanceof CrabLarvaeEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) < 15000) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 50.0F && entity instanceof LivingEntity _entityx) {
               _entityx.setHealth(50.0F);
            }

            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 2, false, false));
            }
         } else if ((entity instanceof CrabLarvaeEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) < 35000) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 100.0F && entity instanceof LivingEntity _entityx) {
               _entityx.setHealth(100.0F);
            }

            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 1, false, false));
            }
         } else if ((entity instanceof CrabLarvaeEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(CrabLarvaeEntity.DATA_crab_growth) : 0) < 65000) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 150.0F && entity instanceof LivingEntity _entityx) {
               _entityx.setHealth(150.0F);
            }

            if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
               _entityx.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 0, false, false));
            }
         }

         if ((!(entity instanceof LivingEntity _livEnt94) || !_livEnt94.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entityx
            && !_entityx.level().isClientSide()) {
            _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
         }

         if ((!(entity instanceof CrabLarvaeEntity _datEntL96) || !(Boolean)_datEntL96.getEntityData().get(CrabLarvaeEntity.DATA_following))
            && entity instanceof LivingEntity _entityx
            && !_entityx.level().isClientSide()) {
            _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
         }
      }
   }
}
