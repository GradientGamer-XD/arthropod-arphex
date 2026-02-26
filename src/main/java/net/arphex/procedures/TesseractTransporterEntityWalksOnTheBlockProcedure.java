package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TesseractTransporterEntityWalksOnTheBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "activatedportal")
            && (new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "teleportation_time") != 0.0
            && !(entity.getPersistentData().getDouble("just_teleported_arphex") > 0.0)) {
            if ((new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                  }
               }).getValue(world, BlockPos.containing(x, y, z), "teleportation_time") < 7.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 4, 0, false, false));
            }

            if ((new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
               }
            }).getValue(world, BlockPos.containing(x, y, z), "teleportation_time") < 6.0) {
               if ((new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                  }
               }).getValue(world, BlockPos.containing(x, y, z), "portal_lock_x") != 0.0) {
                  if (!(entity.getPersistentData().getDouble("just_teleported_arphex") > 0.0)) {
                     entity.getPersistentData().putDouble("just_teleported_arphex", 45.0);
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
                              "execute in "
                                 + (new Object() {
                                       public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                          BlockEntity blockEntity = world.getBlockEntity(pos);
                                          return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                                       }
                                    })
                                    .getValue(world, BlockPos.containing(x, y, z), "portal_lock_dimension")
                                    .replace("ResourceKey[minecraft:dimension / ", "")
                                    .replace("]", "")
                                    .strip()
                                 + " run tp @s "
                                 + (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                       BlockEntity blockEntity = world.getBlockEntity(pos);
                                       return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                                    }
                                 }).getValue(world, BlockPos.containing(x, y, z), "portal_lock_x")
                                 + " "
                                 + (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                       BlockEntity blockEntity = world.getBlockEntity(pos);
                                       return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                                    }
                                 }).getValue(world, BlockPos.containing(x, y, z), "portal_lock_y")
                                 + " "
                                 + (new Object() {
                                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                       BlockEntity blockEntity = world.getBlockEntity(pos);
                                       return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                                    }
                                 }).getValue(world, BlockPos.containing(x, y, z), "portal_lock_z")
                           );
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_WHITE_SMOKES.get(), x, y, z, 20, 0.1, 0.1, 0.1, 0.2);
                     }
                  }
               } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Teleporter not configured"), true);
               }
            }
         }
      }
   }
}
