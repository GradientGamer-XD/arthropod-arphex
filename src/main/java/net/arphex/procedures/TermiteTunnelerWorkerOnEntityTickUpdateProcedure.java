package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.TermiteTunnelerWorkerEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TermiteTunnelerWorkerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 0.95);
         if (entity.getPersistentData().getBoolean("arphexclimber")) {
            if (Mth.nextInt(RandomSource.create(), 0, 300) == 1) {
               entity.getPersistentData().putBoolean("arphexclimber", false);
            }
         } else if (Mth.nextInt(RandomSource.create(), 0, 300) == 1) {
            entity.getPersistentData().putBoolean("arphexclimber", true);
         }

         entity.getPersistentData().putBoolean("arphex", true);
         if (entity.getPersistentData().getBoolean("tunneling")) {
            if (5.0F
               <= world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                  .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
               entity.getPersistentData().putBoolean("tunneling", false);
            }

            if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
               entity.teleportTo(entity.getX(), entity.getY() - 1.0, entity.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() - 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.2, 0.2, 0.2, 0.8);
            }

            if (Mth.nextInt(RandomSource.create(), 1, 100) == 5 && world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")),
                     SoundSource.NEUTRAL,
                     0.4F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")),
                     SoundSource.NEUTRAL,
                     0.4F,
                     1.0F,
                     false
                  );
               }
            }

            entity.noPhysics = true;
            entity.setNoGravity(true);
            entity.setShiftKeyDown(false);
            entity.setSprinting(true);
         } else {
            entity.noPhysics = false;
            entity.setNoGravity(false);
            entity.setSprinting(false);
            if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())) && !entity.onGround()) {
               entity.setShiftKeyDown(true);
            } else {
               entity.setShiftKeyDown(false);
            }
         }

         if (!(entity.getPersistentData().getDouble("termitetick") > 0.0)) {
            if (entity.getPersistentData().getBoolean("tunneling")) {
               entity.getPersistentData().putBoolean("tunneling", false);
               entity.getPersistentData().putDouble("termitetick", (double)Mth.nextInt(RandomSource.create(), 1200, 2400));
            } else {
               entity.getPersistentData().putBoolean("tunneling", true);
               entity.getPersistentData().putDouble("termitetick", (double)Mth.nextInt(RandomSource.create(), 100, 250));
            }
         } else {
            entity.getPersistentData().putDouble("termitetick", entity.getPersistentData().getDouble("termitetick") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("reversefromsolid") > 0.0)) {
            entity.getPersistentData().putDouble("prevxtermite", entity.getX());
            entity.getPersistentData().putDouble("prevytermite", entity.getY());
            entity.getPersistentData().putDouble("prevztermite", entity.getZ());
            entity.getPersistentData().putDouble("reversefromsolid", 10.0);
         } else {
            entity.getPersistentData().putDouble("reversefromsolid", entity.getPersistentData().getDouble("reversefromsolid") - 1.0);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (!world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
               if (entity instanceof Mob _entity) {
                  Entity _mobEntx = world.getEntitiesOfClass(AntArsonistAlateQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (_mobEntx instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               }
            } else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")
               && entity instanceof Mob _entityx) {
               Entity var33 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var33 instanceof LivingEntity _ent) {
                  _entityx.setTarget(_ent);
               }
            }

            if (entity.isInWall()) {
               entity.getPersistentData().putBoolean("tunneling", true);
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.2, entity.getDeltaMovement().z()));
            } else {
               entity.getPersistentData().putBoolean("tunneling", false);
            }
         } else if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            if (!world.getEntitiesOfClass(
                     TermiteTunnelerWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           (entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getZ()
                        ),
                        10.0,
                        10.0,
                        10.0
                     ),
                     e -> true
                  )
                  .isEmpty()
               && !world.getEntitiesOfClass(
                     TermiteTunnelerWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ()
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
                           (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                        )
                  )
                  .findFirst()
                  .orElse(null)
                  .isInWall()) {
               world.getEntitiesOfClass(
                     TermiteTunnelerWorkerEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           (entity instanceof Mob _mobEntxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxx.getTarget() : null).getZ()
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
                           (entity instanceof Mob _mobEntxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxxxxxxxxxxx ? _mobEntxxxxxxxxxxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null).getZ()
                        )
                  )
                  .findFirst()
                  .orElse(null)
                  .getPersistentData()
                  .putBoolean("tunneling", false);
            }

            if (entity.getPersistentData().getBoolean("tunneling")) {
               if (!(entity.getPersistentData().getDouble("termiteboost") > 0.0)) {
                  entity.getPersistentData().putDouble("termiteboost", 20.0);
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                     )
                  );
                  if (!(
                        5.0F
                           <= world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                     )
                     && !(
                        5.0F
                           <= world.getBlockState(BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ()))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX() + 1.0, entity.getY(), entity.getZ()))
                     )
                     && !(
                        5.0F
                           <= world.getBlockState(BlockPos.containing(entity.getX() - 1.0, entity.getY(), entity.getZ()))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX() - 1.0, entity.getY(), entity.getZ()))
                     )
                     && !(
                        5.0F
                           <= world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1.0))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1.0))
                     )
                     && !(
                        5.0F
                           <= world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1.0))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1.0))
                     )
                     && !(
                        5.0F
                           <= world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                     )
                     && !(
                        5.0F
                           <= world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                              .getDestroySpeed(world, BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                     )) {
                     entity.setDeltaMovement(
                        new Vec3(
                           ((entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null).getX() - entity.getX())
                              / Math.sqrt(
                                 Math.pow((entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getX() - entity.getX(), 2.0)
                                    + Math.pow((entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getZ() - entity.getZ(), 2.0)
                              )
                              / 12.0,
                           entity.getDeltaMovement().y(),
                           ((entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getZ() - entity.getZ())
                              / Math.sqrt(
                                 Math.pow((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX() - entity.getX(), 2.0)
                                    + Math.pow((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getZ() - entity.getZ(), 2.0)
                              )
                              / 12.0
                        )
                     );
                  } else {
                     if (entity.getPersistentData().getDouble("prevxtermite") - entity.getX() != 0.0
                        || entity.getPersistentData().getDouble("prevztermite") - entity.getZ() != 0.0) {
                        entity.setDeltaMovement(
                           new Vec3(
                              (entity.getPersistentData().getDouble("prevxtermite") - entity.getX())
                                 / Math.sqrt(
                                    Math.pow(entity.getPersistentData().getDouble("prevxtermite") - entity.getX(), 2.0)
                                       + Math.pow(entity.getPersistentData().getDouble("prevztermite") - entity.getZ(), 2.0)
                                 )
                                 / 8.0,
                              entity.getDeltaMovement().y(),
                              (entity.getPersistentData().getDouble("prevztermite") - entity.getZ())
                                 / Math.sqrt(
                                    Math.pow(entity.getPersistentData().getDouble("prevxtermite") - entity.getX(), 2.0)
                                       + Math.pow(entity.getPersistentData().getDouble("prevztermite") - entity.getZ(), 2.0)
                                 )
                                 / 8.0
                           )
                        );
                     }

                     if (entity.getPersistentData().getDouble("prevxtermite") != 0.0
                        && entity.getPersistentData().getDouble("prevytermite") != 0.0
                        && entity.getPersistentData().getDouble("prevztermite") != 0.0) {
                        if (entity.getY() < entity.getPersistentData().getDouble("prevytermite")) {
                           entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.2, entity.getDeltaMovement().z()));
                        } else {
                           entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.2, entity.getDeltaMovement().z()));
                        }
                     }
                  }

                  if ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) != null) {
                     if (entity.getY() < (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getY()
                        && !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
                        && !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ()))
                        && !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 2.0, entity.getZ()))) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.2, entity.getDeltaMovement().z()));
                     } else {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.2, entity.getDeltaMovement().z()));
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("termiteboost", entity.getPersistentData().getDouble("termiteboost") - 1.0);
               }
            }
         }
      }
   }
}
