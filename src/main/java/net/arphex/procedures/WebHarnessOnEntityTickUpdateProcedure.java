package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WebHarnessOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(),
               entity.getPersistentData().getDouble("targetX"),
               entity.getPersistentData().getDouble("targetY"),
               entity.getPersistentData().getDouble("targetZ"),
               10,
               0.1,
               0.1,
               0.1,
               0.1
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 3.0, z, 20, 0.1, 0.2, 0.1, 0.1);
         }

         entity.lookAt(
            Anchor.EYES,
            new Vec3(
               entity.getPersistentData().getDouble("targetX"),
               entity.getPersistentData().getDouble("targetY"),
               entity.getPersistentData().getDouble("targetZ")
            )
         );
         if (Math.abs(entity.getDeltaMovement().x()) > 0.1 || Math.abs(entity.getDeltaMovement().z()) > 0.1 || Math.abs(entity.getDeltaMovement().y()) > 0.1) {
            ArphexMod.queueServerWork(
               60,
               () -> {
                  if (Math.abs(entity.getDeltaMovement().x()) > 0.1
                     || Math.abs(entity.getDeltaMovement().z()) > 0.1
                     || Math.abs(entity.getDeltaMovement().y()) > 0.1) {
                     ArphexMod.queueServerWork(
                        10,
                        () -> {
                           if ((
                                 Math.abs(entity.getDeltaMovement().x()) > 0.1
                                    || Math.abs(entity.getDeltaMovement().z()) > 0.1
                                    || Math.abs(entity.getDeltaMovement().y()) > 0.1
                              )
                              && !entity.level().isClientSide()) {
                              entity.discard();
                           }
                        }
                     );
                  }
               }
            );
         }

         if (entity.getDeltaMovement().x() > 0.15) {
            ArphexMod.queueServerWork(30, () -> {
               if (entity.getDeltaMovement().x() < -0.15 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity.getDeltaMovement().z() > 0.15) {
            ArphexMod.queueServerWork(30, () -> {
               if (entity.getDeltaMovement().z() < -0.15 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity.getDeltaMovement().x() < -0.15) {
            ArphexMod.queueServerWork(30, () -> {
               if (entity.getDeltaMovement().x() > 0.15 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity.getDeltaMovement().z() < -0.15) {
            ArphexMod.queueServerWork(30, () -> {
               if (entity.getDeltaMovement().z() > 0.15 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity.getY() < entity.getPersistentData().getDouble("targetY") - 1.0) {
            if (entity.getX() > entity.getPersistentData().getDouble("targetX") - 3.0
               && entity.getX() < entity.getPersistentData().getDouble("targetX") + 3.0
               && entity.getY() > entity.getPersistentData().getDouble("targetY") - 3.0
               && entity.getY() < entity.getPersistentData().getDouble("targetY") + 3.0
               && entity.getZ() > entity.getPersistentData().getDouble("targetZ") - 3.0
               && entity.getZ() < entity.getPersistentData().getDouble("targetZ") + 3.0) {
               entity.getPersistentData().putBoolean("solidlock", true);
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 3, false, false));
               }

               if (world.isEmptyBlock(BlockPos.containing(x, y + 2.6, z))) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 24.0,
                        0.1,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 24.0
                     )
                  );
               }

               if (!world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX"),
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ")
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX") + 1.0,
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ")
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX") - 1.0,
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ")
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX"),
                           entity.getPersistentData().getDouble("targetY") + 1.0,
                           entity.getPersistentData().getDouble("targetZ")
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX"),
                           entity.getPersistentData().getDouble("targetY") - 1.0,
                           entity.getPersistentData().getDouble("targetZ")
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX"),
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ") + 1.0
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX"),
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ") - 1.0
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX") + 1.0,
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ") - 1.0
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX") - 1.0,
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ") - 1.0
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX") + 1.0,
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ") + 1.0
                        )
                     )
                     .canOcclude()
                  && !world.getBlockState(
                        BlockPos.containing(
                           entity.getPersistentData().getDouble("targetX") - 1.0,
                           entity.getPersistentData().getDouble("targetY"),
                           entity.getPersistentData().getDouble("targetZ") + 1.0
                        )
                     )
                     .canOcclude()
                  && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               entity.getPersistentData().putBoolean("solidlock", false);
               if (world.isEmptyBlock(BlockPos.containing(x, y + 2.6, z))) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        entity.getPersistentData().getDouble("up"),
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               }
            }
         } else if (world.isEmptyBlock(BlockPos.containing(x, y + 2.5, z))) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * entity.getPersistentData().getDouble("tetherspeed"),
                  entity.getDeltaMovement().y(),
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * entity.getPersistentData().getDouble("tetherspeed")
               )
            );
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty() && !entity.level().isClientSide()
            )
          {
            entity.discard();
         }

         if (entity.isVehicle()) {
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
               Entity var9 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var9 instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TARANTULA_TETHER.get()) {
                  if (!entity.getPersistentData().getBoolean("solidlock")) {
                     entity.getPersistentData().putDouble("tetherspeed", 2.0);
                     entity.getPersistentData().putDouble("up", Mth.nextDouble(RandomSource.create(), 0.5, 0.75));
                  } else {
                     entity.getPersistentData().putDouble("tetherspeed", 0.1);
                     entity.getPersistentData().putDouble("up", 0.1);
                  }
               } else if (!entity.getPersistentData().getBoolean("solidlock")) {
                  entity.getPersistentData().putDouble("tetherspeed", 1.0);
                  entity.getPersistentData().putDouble("up", Mth.nextDouble(RandomSource.create(), 0.4, 0.65));
               } else {
                  entity.getPersistentData().putDouble("tetherspeed", 0.1);
                  entity.getPersistentData().putDouble("up", 0.1);
               }
            }
         } else {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "effect give @p[distance=..5] slow falling 2 0 true"
                  );
            }

            ArphexMod.queueServerWork(
               10,
               () -> {
                  if (!entity.isVehicle()) {
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "effect give @p[distance=..5] slow falling 2 0 true"
                           );
                     }
                  }
               }
            );
         }

         if (entity.getPersistentData().getDouble("targetX") == 0.0
            || entity.getPersistentData().getDouble("targetX") == 0.0
            || entity.getPersistentData().getDouble("targetZ") == 0.0) {
            ArphexMod.queueServerWork(
               2,
               () -> {
                  if ((
                        entity.getPersistentData().getDouble("targetX") == 0.0
                           || entity.getPersistentData().getDouble("targetX") == 0.0
                           || entity.getPersistentData().getDouble("targetZ") == 0.0
                     )
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         }

         entity.fallDistance = 0.0F;
         ArphexMod.queueServerWork(85, () -> entity.getPersistentData().putBoolean("spacelimit", true));
      }
   }
}
