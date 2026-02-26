package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentorMothSummonEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorMothSummonOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label343: {
            boolean onetarget = false;
            entity.noPhysics = true;
            label316:
            if (world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true).isEmpty()) {
               if (entity instanceof TormentorMothSummonEntity _datEntL2
                  && (Boolean)_datEntL2.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)) {
                  break label316;
               }

               if ((
                     !(entity instanceof TormentorMothSummonEntity _datEntL117)
                        || !(Boolean)_datEntL117.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)
                  )
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
               break label343;
            }

            world.addParticle((SimpleParticleType)ArphexModParticleTypes.TORMENTOR_SMOKE.get(), x, y, z, 0.0, 0.0, 0.0);
            entity.getPersistentData().putBoolean("tormentor_target", false);
            if (!(entity.getPersistentData().getDouble("damagetime") > 0.0)) {
               entity.getPersistentData().putDouble("damagetime", 5.0);
               Vec3 _center = new Vec3(entity.getX(), entity.getY() + 11.0, entity.getZ());

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (!(entityiterator instanceof TORMENTOREntity)
                     && entityiterator.getPersistentData().getBoolean("tormentor_target")
                     && !(
                        ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .tormentor_respite
                           > 0.0
                     )) {
                     if (entityiterator instanceof Player) {
                        if (!world.isClientSide()) {
                           entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()));
                        }

                        entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                     }

                     if (!(entityiterator instanceof TormentorMothSummonEntity)) {
                        entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                     }

                     if (Math.round((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 15.0F)
                        > Math.round((float)(170 / ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) + 1)))) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
                           (float)Math.round((entityiterator instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 15.0F)
                        );
                     } else {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
                           (float)Math.round((float)(170 / ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 10 + 1)))
                        );
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("damagetime", entity.getPersistentData().getDouble("damagetime") - 1.0);
            }

            if ((entity instanceof TormentorMothSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorMothSummonEntity.DATA_changedir) : 0)
               <= 0) {
               onetarget = false;
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

                     if (!world.isClientSide()) {
                        entity.lookAt(Anchor.EYES, new Vec3(entityiteratorx.getX(), entityiteratorx.getY(), entityiteratorx.getZ()));
                     }
                  }
               }

               if (entity instanceof TormentorMothSummonEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(TormentorMothSummonEntity.DATA_changedir, 100);
               }

               if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == null) {
                  if (!world.isClientSide()) {
                     if (!world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true).isEmpty()) {
                        entity.lookAt(
                           Anchor.EYES,
                           new Vec3(
                              entity.getX() + (double)Mth.nextInt(RandomSource.create(), -5, 5),
                              entity.getY(),
                              entity.getZ() + (double)Mth.nextInt(RandomSource.create(), -5, 5)
                           )
                        );
                     } else if (!(entity instanceof TormentorMothSummonEntity _datEntL54)
                        || !(Boolean)_datEntL54.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)) {
                        entity.lookAt(
                           Anchor.EYES,
                           new Vec3(
                              world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getX(),
                              world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getY(),
                              world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
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
                     }
                  }
               } else {
                  label242:
                  if (!world.isClientSide()) {
                     label248:
                     if (world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 450.0, 450.0, 450.0), e -> true).isEmpty()) {
                        if (entity instanceof TormentorMothSummonEntity _datEntL64
                           && (Boolean)_datEntL64.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)) {
                           break label248;
                        }

                        if (!(entity instanceof TormentorMothSummonEntity _datEntL72)
                           || !(Boolean)_datEntL72.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)) {
                           entity.lookAt(
                              Anchor.EYES,
                              new Vec3(
                                 world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getX(),
                                 world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getY(),
                                 world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
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
                        }
                        break label242;
                     }

                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ()
                        )
                     );
                  }
               }
            } else {
               if (entity instanceof TormentorMothSummonEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorMothSummonEntity.DATA_changedir,
                        (
                              entity instanceof TormentorMothSummonEntity _datEntI
                                 ? (Integer)_datEntI.getEntityData().get(TormentorMothSummonEntity.DATA_changedir)
                                 : 0
                           )
                           - 1
                     );
               }

               label286:
               if ((
                     !(entity instanceof TormentorMothSummonEntity _datEntL82)
                        || !(Boolean)_datEntL82.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)
                  )
                  && (
                     (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) == null
                           && world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 180.0, 180.0, 180.0), e -> true).isEmpty()
                        || (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
                           && world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true).isEmpty()
                  )) {
                  if (entity instanceof TormentorMothSummonEntity _datEntL89
                     && (Boolean)_datEntL89.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)) {
                     break label286;
                  }

                  if (entity instanceof LivingEntity _livEnt90 && _livEnt90.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     break label286;
                  }

                  if (!(
                     entity.getY()
                        > world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getY()
                           - 11.0
                  )) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2,
                           -0.6,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2
                        )
                     );
                  } else {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2,
                           0.6,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2
                        )
                     );
                  }
               } else {
                  label267:
                  if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null) {
                     if (entity instanceof LivingEntity _livEnt103 && _livEnt103.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        break label267;
                     }

                     if (entity.getY() > (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY() - 11.0) {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2,
                              -0.6,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2
                           )
                        );
                     } else {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2,
                              0.6,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 2.2
                           )
                        );
                     }
                  }
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.1);
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(), x, y, z, 50, 0.5, 0.5, 0.5, 0.2);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TINY_MOTH.get(), x, y, z, 50, 0.5, 0.5, 0.5, 0.2);
            }
         }

         if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null) {
            if (entity instanceof TormentorMothSummonEntity _datEntL121
               && (Boolean)_datEntL121.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)) {
               (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getPersistentData().putBoolean("tormentor_target", true);
            }

            if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) instanceof TORMENTOREntity && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var18) {
                  var18.printStackTrace();
               }
            }
         }

         if (!(entity instanceof TormentorMothSummonEntity _datEntL127)
            || !(Boolean)_datEntL127.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)) {
            ArphexMod.queueServerWork(
               6000,
               () -> {
                  if ((
                        !(entity instanceof TormentorMothSummonEntity _datEntL128)
                           || !(Boolean)_datEntL128.getEntityData().get(TormentorMothSummonEntity.DATA_playerspawned)
                     )
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         }
      }
   }
}
