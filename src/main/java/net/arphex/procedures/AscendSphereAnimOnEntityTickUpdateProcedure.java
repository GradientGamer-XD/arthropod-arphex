package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.AscendSphereAnimEntity;
import net.arphex.entity.GenesisShotEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentBlastEntity;
import net.arphex.entity.TormentExplosiveEntity;
import net.arphex.entity.TormentorLarvaeEntity;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.TormentorTendrilEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AscendSphereAnimOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String saved_letter = "";
         double checkdouble = 0.0;
         double tormentor_active = 0.0;
         double number_transfer = 0.0;
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != ArphexModBlocks.ASCENDED_CUBE.get() && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
            tormentor_active = 400.0;
         } else {
            tormentor_active = 200.0;
         }

         if ((entity instanceof AscendSphereAnimEntity _datEntI ? (Integer)_datEntI.getEntityData().get(AscendSphereAnimEntity.DATA_barriermode) : 0) > 0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "particle arphex:heavy_white_smokes ~ ~ ~ 0 0 0 0.3 5 force"
                  );
            }

            if (entity instanceof AscendSphereAnimEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     AscendSphereAnimEntity.DATA_barriermode,
                     (entity instanceof AscendSphereAnimEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(AscendSphereAnimEntity.DATA_barriermode) : 0)
                        - 1
                  );
            }
         }

         if ((new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         }).getValue(world, BlockPos.containing(x, y, z), "ascendedowner").length() > 1) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(tormentor_active / 2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof Player) {
                  double _setval = 25.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.sphere_near = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }

               if (entityiterator instanceof TORMENTOREntity && !entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }

               if (100.0
                  > Math.sqrt(
                     (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                        + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                        + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                  )) {
                  if (entityiterator instanceof LivingEntity
                     && !(entityiterator instanceof ArmorStand)
                     && (entity instanceof AscendSphereAnimEntity _datEntI ? (Integer)_datEntI.getEntityData().get(AscendSphereAnimEntity.DATA_barriermode) : 0)
                        > 0
                     && (!(entityiterator instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
                     && !((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) > 199.0F)
                     && entityiterator != entity
                     && !entityiterator.getStringUUID().equals((new Object() {
                        public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                        }
                     }).getValue(world, BlockPos.containing(x, y, z), "ascendedowner"))
                     && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           (entityiterator.getX() - entity.getX())
                              / (
                                 Math.sqrt(
                                       (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                          + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                          + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                    )
                                    / 2.0
                              ),
                           (entityiterator.getY() - entity.getY())
                              / (
                                 Math.sqrt(
                                       (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                          + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                          + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                    )
                                    / 2.0
                              ),
                           (entityiterator.getZ() - entity.getZ())
                              / (
                                 Math.sqrt(
                                       (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                          + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                          + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                    )
                                    / 2.0
                              )
                        )
                     );
                  }

                  entityiterator.getPersistentData().putDouble("ascendedprotection", 5.0);
                  if (entityiterator instanceof Player) {
                     if (entityiterator.getStringUUID().equals((new Object() {
                        public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                        }
                     }).getValue(world, BlockPos.containing(x, y, z), "ascendedowner"))) {
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 0, false, false));
                        }
                     } else {
                        if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                              == ArphexModItems.ETHEREAL_STAFF.get()
                           && entityiterator instanceof Player _player) {
                           _player.getCooldowns()
                              .addCooldown((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem(), 5);
                        }

                        if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.ETHEREAL_STAFF.get()) {
                           if (entityiterator instanceof Player _player) {
                              _player.getCooldowns()
                                 .addCooldown((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem(), 5);
                           }

                           if (entityiterator instanceof Player _player && !_player.level().isClientSide()) {
                              _player.displayClientMessage(Component.literal("Ethereal Staff can not be used in other player's ascended cube forcefield"), true);
                           }
                        }
                     }
                  }

                  if (entityiterator instanceof GenesisShotEntity) {
                     entityiterator.getPersistentData().putBoolean("done_explode", true);
                  }

                  if (entityiterator instanceof TormentorTendrilEntity
                     || entityiterator instanceof TormentorSphereEntity
                     || entityiterator instanceof TormentBlastEntity
                     || entityiterator instanceof TormentorLarvaeEntity
                     || entityiterator.getPersistentData().getBoolean("tormentor_summon")) {
                     if (!entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                 )
                                 .withSuppressedOutput(),
                              "particle arphex:heavy_red_smoke ~ ~ ~ 0.3 0.3 0.3 0.5 30 force"
                           );
                     }
                  }

                  if (entityiterator instanceof TormentExplosiveEntity
                     && !entityiterator.getPersistentData().getString("owner_deletecheck").equals((new Object() {
                        public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                        }
                     }).getValue(world, BlockPos.containing(x, y, z), "ascendedowner"))) {
                     ArphexMod.queueServerWork(
                        2,
                        () -> {
                           if (!entityiterator.getPersistentData().getString("owner_deletecheck").equals((new Object() {
                              public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                 BlockEntity blockEntity = world.getBlockEntity(pos);
                                 return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                              }
                           }).getValue(world, BlockPos.containing(x, y, z), "ascendedowner"))) {
                              if (!entityiterator.level().isClientSide()) {
                                 entityiterator.discard();
                              }

                              if (world instanceof ServerLevel _levelx) {
                                 _levelx.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                             Vec2.ZERO,
                                             _levelx,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _levelx.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "particle arphex:heavy_red_smoke ~ ~ ~ 0.3 0.3 0.3 0.5 30 force"
                                    );
                              }
                           }
                        }
                     );
                  }
               }
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeAllEffects();
         }
      }
   }
}
