package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TermiteTunnelerKingEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TermiteTunnelerQueenOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
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
                  "data merge entity @s {NoAI:1}"
               );
         }

         entity.getPersistentData().putBoolean("arphex", true);
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
            if (!(entity.getPersistentData().getDouble("termitequeentick") > 0.0)) {
               if (!entity.isInWall()) {
                  if (world.getEntitiesOfClass(TermiteTunnelerKingEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
                     if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.TERMITE_TUNNELER_KING.get())
                           .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                     }
                  } else if (world instanceof ServerLevel _levelx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_TERMITE.get())
                        .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                     }
                  }
               }

               entity.getPersistentData().putDouble("termitequeentick", (double)Mth.nextInt(RandomSource.create(), 200, 800));
            } else {
               entity.getPersistentData().putDouble("termitequeentick", entity.getPersistentData().getDouble("termitequeentick") - 1.0);
            }
         }

         if (!entity.getPersistentData().getBoolean("angled")) {
            if (world.getBlockState(BlockPos.containing(entity.getX() + 2.0, entity.getY(), entity.getZ() - 2.0)).getBlock()
               == ArphexModBlocks.TERMITE_MOUND.get()) {
               entity.getPersistentData().putBoolean("angled", true);
               entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y + 1.0, z + 1.0));
            } else if (world.getBlockState(BlockPos.containing(entity.getX() - 2.0, entity.getY(), entity.getZ() - 2.0)).getBlock()
               == ArphexModBlocks.TERMITE_MOUND.get()) {
               entity.getPersistentData().putBoolean("angled", true);
               entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y + 1.0, z + 1.0));
            } else if (world.getBlockState(BlockPos.containing(entity.getX() - 2.0, entity.getY(), entity.getZ() + 2.0)).getBlock()
               == ArphexModBlocks.TERMITE_MOUND.get()) {
               entity.getPersistentData().putBoolean("angled", true);
               entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y + 1.0, z - 1.0));
            } else if (world.getBlockState(BlockPos.containing(entity.getX() + 2.0, entity.getY(), entity.getZ() + 2.0)).getBlock()
               == ArphexModBlocks.TERMITE_MOUND.get()) {
               entity.getPersistentData().putBoolean("angled", true);
               entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y + 1.0, z - 1.0));
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
            Entity var14 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (!(var14 instanceof LivingEntity _livEnt44) || !_livEnt44.hasEffect(MobEffects.DIG_SLOWDOWN)) {
               boolean _setval = true;
               world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .ifPresent(
                     capability -> {
                        capability.totemfatigue = _setval;
                        capability.syncPlayerVariables(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                        );
                     }
                  );
            }
         }
      }
   }
}
