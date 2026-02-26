package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.DraconicCloneEntity;
import net.arphex.entity.DraconicFlyStalkEntity;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DraconicCloneOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double randomxside = 0.0;
         double expand = 0.0;
         double yhalf = 0.0;
         double sx = 0.0;
         double lineZ = 0.0;
         double sy = 0.0;
         double lineY = 0.0;
         double randomzside = 0.0;
         double sz = 0.0;
         double lineX = 0.0;
         if (entity instanceof DraconicFlyStalkEntity) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                  )
               );
            }

            if (!world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z)) && !entity.level().isClientSide()) {
               entity.discard();
            }

            if ((
                  !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 4.0, z))
               )
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 7, 7, false, false));
            }

            if (Mth.nextInt(RandomSource.create(), 1, 500) == 5) {
               entity.teleportTo(x + (double)Mth.nextInt(RandomSource.create(), -60, 60), y, z + (double)Mth.nextInt(RandomSource.create(), -60, 60));
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        x + (double)Mth.nextInt(RandomSource.create(), -60, 60),
                        y,
                        z + (double)Mth.nextInt(RandomSource.create(), -60, 60),
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }
            }
         }

         if (entity.isInWall()) {
            for (int index0 = 0; index0 < 10; index0++) {
               if (entity.isInWall()) {
                  entity.teleportTo(x, y + 1.0, z);
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(x, y + 1.0, z, entity.getYRot(), entity.getXRot());
                  }
               }
            }

            ArphexMod.queueServerWork(1, () -> {
               if (entity.isInWall() && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity instanceof DraconicCloneEntity) {
            if (!world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()) {
               entity.setDeltaMovement(new Vec3(0.0, -3.0, 0.0));
               Entity var42 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var42 instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                  Anchor var10001 = Anchor.EYES;
                  Entity var49 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  double var85 = (var49 instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getX();
                  var49 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  double var86 = (var49 instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY();
                  var49 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  entity.lookAt(var10001, new Vec3(var85, var86, (var49 instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ()));
                  if (entity instanceof Mob _entity) {
                     Entity var34 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((var34 instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                     }
                  }

                  if (!world.getEntitiesOfClass(
                        LivingEntity.class,
                        AABB.ofSize(
                           new Vec3(
                              (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getY(),
                              (double)entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                       Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                           ),
                           10.0,
                           10.0,
                           10.0
                        ),
                        e -> true
                     )
                     .isEmpty()) {
                     Entity var73 = world.getEntitiesOfClass(
                           LivingEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getX(),
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY(),
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getZ()
                              ),
                              10.0,
                              10.0,
                              10.0
                           ),
                           e -> true
                        )
                        .stream()
                        .sorted(
                           (new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              })
                              .compareDistOf(
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getX(),
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY(),
                                 (double)entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)Mth.nextInt(RandomSource.create(), 1, 20))),
                                          Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getZ()
                              )
                        )
                        .findFirst()
                        .orElse(null);
                     var49 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (var73 == (var49 instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null)) {
                        Entity var64 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (var64 instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                           _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 4));
                        }

                        Entity var71 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if ((var71 instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null) instanceof LivingEntity _entityx
                           && !_entityx.level().isClientSide()) {
                           _entityx.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 1));
                        }

                        double var75 = entity.getX();
                        var64 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        lineX = var75 - (var64 instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX();
                        double var76 = entity.getY();
                        var64 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        lineY = var76 - (var64 instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getY();
                        double var77 = entity.getZ();
                        var64 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        lineZ = var77 - (var64 instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getZ();
                        expand = expand;

                        for (int index1 = 0; index1 < 10; index1++) {
                           if (Mth.nextInt(RandomSource.create(), 1, 2) == 2 && world instanceof ServerLevel _level) {
                              _level.sendParticles(
                                 (SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(),
                                 entity.getX() + lineX * expand,
                                 entity.getY() + lineY * expand,
                                 entity.getZ() + lineZ * expand,
                                 1,
                                 0.05,
                                 0.2,
                                 0.05,
                                 0.0
                              );
                           }

                           expand -= 0.1;
                        }
                     }
                  }
               }

               Entity var60 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               float var79 = (var60 instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F;
               var60 = world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var79 > (var60 instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)) {
                  if (entity instanceof DraconicCloneEntity animatable) {
                     animatable.setTexture("draconicvoidlasherpowerlowhealth");
                  }
               } else if (entity instanceof DraconicCloneEntity animatable) {
                  animatable.setTexture("draconicvoidlasherpower");
               }

               if (!world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .isSprinting()) {
                  ArphexMod.queueServerWork(
                     5,
                     () -> {
                        if (!world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
                           && !world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .isSprinting()
                           && !entity.level().isClientSide()) {
                           entity.discard();
                        }
                     }
                  );
               }
            } else {
               ArphexMod.queueServerWork(
                  5,
                  () -> {
                     if (world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y - 0.1, z)).getBlock() instanceof LiquidBlock) {
            entity.setDeltaMovement(new Vec3(0.0, 0.02, 0.0));
         }

         ArphexMod.queueServerWork(350, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
      }
   }
}
