package net.arphex.procedures;

import java.util.Comparator;
import java.util.Locale;
import net.arphex.ArphexMod;
import net.arphex.entity.BlockTestEntity;
import net.arphex.init.ArphexModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockTestOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
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
                  "data merge entity @s {Invulnerable:True}"
               );
         }

         if (!world.isClientSide()) {
            entity.setYRot(0.0F);
            entity.setXRot(0.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }

         entity.noPhysics = true;
         if (entity.getPersistentData().getBoolean("blocktesttp")) {
            if (entity.getPersistentData().getBoolean("movetimeblocktest")) {
               if (entity.getPersistentData().getBoolean("movedownblocktest")) {
                  entity.teleportTo(x, y - 0.1, z);
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(x, y - 0.1, z, entity.getYRot(), entity.getXRot());
                  }

                  ArphexMod.queueServerWork(15, () -> {
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  });
               } else {
                  entity.teleportTo(x, y + 1.0, z);
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(x, y + 1.0, z, entity.getYRot(), entity.getXRot());
                  }

                  entity.getPersistentData().putBoolean("movedownblocktest", true);
               }
            }
         } else {
            entity.getPersistentData().putBoolean("blocktesttp", true);
            if ((double)world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) > 0.3
               && (double)world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1.0, z)) < 0.3) {
               entity.getPersistentData()
                  .putString("blocktypetest", ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString());
               entity.getPersistentData().putDouble("ydama", y - 2.3);
               entity.teleportTo(x, y - 2.3, z);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(x, y - 2.3, z, entity.getYRot(), entity.getXRot());
               }
            } else if ((double)world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1.0, z)) > 0.3
               && (double)world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 2.0, z)) < 0.3) {
               entity.getPersistentData()
                  .putString("blocktypetest", ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock()).toString());
               entity.getPersistentData().putDouble("ydama", y - 1.3);
               entity.teleportTo(x, y - 1.3, z);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(x, y - 1.3, z, entity.getYRot(), entity.getXRot());
               }
            } else if ((double)world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 2.0, z)) > 0.3
               && (double)world.getBlockState(BlockPos.containing(x, y + 3.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 3.0, z)) < 0.3) {
               entity.getPersistentData()
                  .putString("blocktypetest", ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getBlock()).toString());
               entity.getPersistentData().putDouble("ydama", y - 0.3);
               entity.teleportTo(x, y - 0.3, z);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(x, y - 0.3, z, entity.getYRot(), entity.getXRot());
               }
            } else if ((double)world.getBlockState(BlockPos.containing(x, y + 3.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 3.0, z)) > 0.3
               && (double)world.getBlockState(BlockPos.containing(x, y + 4.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 4.0, z)) < 0.3) {
               entity.getPersistentData()
                  .putString("blocktypetest", ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y + 3.0, z)).getBlock()).toString());
               entity.getPersistentData().putDouble("ydama", y + 1.3);
               entity.teleportTo(x, y + 1.3, z);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(x, y + 1.3, z, entity.getYRot(), entity.getXRot());
               }
            } else if ((double)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getDestroySpeed(world, BlockPos.containing(x, y - 1.0, z)) > 0.3
               && (double)world.getBlockState(BlockPos.containing(x, y - 0.0, z)).getDestroySpeed(world, BlockPos.containing(x, y - 0.0, z)) < 0.3) {
               entity.getPersistentData()
                  .putString("blocktypetest", ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock()).toString());
               entity.getPersistentData().putDouble("ydama", y - 3.3);
               entity.teleportTo(x, y - 3.3, z);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(x, y - 3.3, z, entity.getYRot(), entity.getXRot());
               }
            } else {
               if ((double)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getDestroySpeed(world, BlockPos.containing(x, y - 2.0, z)) > 0.3) {
                  entity.getPersistentData()
                     .putString("blocktypetest", ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock()).toString());
               }

               entity.getPersistentData().putDouble("ydama", y - 4.3);
               entity.teleportTo(x, y - 4.3, z);
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(x, y - 4.3, z, entity.getYRot(), entity.getXRot());
               }
            }

            ArphexMod.queueServerWork(
               5,
               () -> {
                  if (entity instanceof Player _player) {
                     _player.getInventory()
                        .armor
                        .set(
                           3,
                           new ItemStack(
                              (ItemLike)ForgeRegistries.BLOCKS
                                 .getValue(new ResourceLocation(entity.getPersistentData().getString("blocktypetest").toLowerCase(Locale.ENGLISH)))
                           )
                        );
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity _living) {
                     _living.setItemSlot(
                        EquipmentSlot.HEAD,
                        new ItemStack(
                           (ItemLike)ForgeRegistries.BLOCKS
                              .getValue(new ResourceLocation(entity.getPersistentData().getString("blocktypetest").toLowerCase(Locale.ENGLISH)))
                        )
                     );
                  }

                  if ((entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                        != ItemStack.EMPTY.getItem()
                     && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                        != Blocks.AIR.asItem()) {
                     Vec3 _center = new Vec3(x, entity.getPersistentData().getDouble("ydama") + 2.4, z);

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (!(entityiterator instanceof BlockTestEntity) && entityiterator instanceof LivingEntity) {
                           if (entityiterator instanceof Player) {
                              Player _plrCldCheck68 = (Player)entityiterator;
                              if (_plrCldCheck68.getCooldowns().isOnCooldown((Item)ArphexModItems.SEISMIC_PULSE.get())) {
                                 continue;
                              }
                           }

                           if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) < 60) {
                              entityiterator.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                                 (float)(18 - Math.round((float)((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) / 10)))
                              );
                           } else {
                              entityiterator.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)),
                                 6.0F
                              );
                           }

                           if (!world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x + 1.0, y, z), 1.0, 1.0, 1.0), e -> true).isEmpty()
                              && world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x + 1.0, y, z), 1.0, 1.0, 1.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x + 1.0, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getBoolean("movetimeblocktest")) {
                              entityiterator.setDeltaMovement(new Vec3(-0.2, entityiterator.getDeltaMovement().y(), entityiterator.getDeltaMovement().z()));
                           }

                           if (!world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x - 1.0, y, z), 1.0, 1.0, 1.0), e -> true).isEmpty()
                              && world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x - 1.0, y, z), 1.0, 1.0, 1.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x - 1.0, y, z))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getBoolean("movetimeblocktest")) {
                              entityiterator.setDeltaMovement(new Vec3(0.2, entityiterator.getDeltaMovement().y(), entityiterator.getDeltaMovement().z()));
                           }

                           if (!world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x, y, z - 1.0), 1.0, 1.0, 1.0), e -> true).isEmpty()
                              && world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x, y, z - 1.0), 1.0, 1.0, 1.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z - 1.0))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getBoolean("movetimeblocktest")) {
                              entityiterator.setDeltaMovement(new Vec3(entityiterator.getDeltaMovement().x(), entityiterator.getDeltaMovement().y(), 0.2));
                           }

                           if (!world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x, y, z + 1.0), 1.0, 1.0, 1.0), e -> true).isEmpty()
                              && world.getEntitiesOfClass(BlockTestEntity.class, AABB.ofSize(new Vec3(x, y, z + 1.0), 1.0, 1.0, 1.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z + 1.0))
                                 .findFirst()
                                 .orElse(null)
                                 .getPersistentData()
                                 .getBoolean("movetimeblocktest")) {
                              entityiterator.setDeltaMovement(new Vec3(entityiterator.getDeltaMovement().x(), entityiterator.getDeltaMovement().y(), -0.2));
                           }

                           entityiterator.setDeltaMovement(new Vec3(entityiterator.getDeltaMovement().x(), 0.5, entityiterator.getDeltaMovement().z()));
                        }
                     }

                     entity.getPersistentData().putBoolean("movetimeblocktest", true);
                  } else if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 4, false, false));
            }
         }

         ArphexMod.queueServerWork(100, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
      }
   }
}
