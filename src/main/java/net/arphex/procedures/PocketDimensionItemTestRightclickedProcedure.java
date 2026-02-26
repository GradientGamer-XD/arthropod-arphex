package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class PocketDimensionItemTestRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GHOST_TELEPORT.get(), x, y, z, 5, 0.4, 0.4, 0.4, 0.1);
            }

            return;
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .pocketdimensionx
            != 0.0) {
            if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling")) && entity.getY() > 255.0) {
               if (itemstack.getOrCreateTag().getDouble("latestx") == 0.0) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("No previous location stored in item. Defaulting to your overworld spawnpoint"), true);
                  }

                  CompoundTag var10000;
                  double var10002;
                  label291: {
                     itemstack.getOrCreateTag().putString("camefrom", "minecraft:overworld");
                     var10000 = itemstack.getOrCreateTag();
                     if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                        var10002 = (double)(
                           _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                              ? _player.getRespawnPosition().getX()
                              : _player.level().getLevelData().getXSpawn()
                        );
                        break label291;
                     }

                     var10002 = 0.0;
                  }

                  label281: {
                     var10000.putDouble("latestx", var10002);
                     var10000 = itemstack.getOrCreateTag();
                     if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                        var10002 = (double)(
                           _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                              ? _player.getRespawnPosition().getY()
                              : _player.level().getLevelData().getYSpawn()
                        );
                        break label281;
                     }

                     var10002 = 0.0;
                  }

                  label271: {
                     var10000.putDouble("latesty", var10002);
                     var10000 = itemstack.getOrCreateTag();
                     if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                        var10002 = (double)(
                           _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                              ? _player.getRespawnPosition().getZ()
                              : _player.level().getLevelData().getZSpawn()
                        );
                        break label271;
                     }

                     var10002 = 0.0;
                  }

                  var10000.putDouble("latestz", var10002);
               }

               int var42;
               label261: {
                  if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get())) {
                     var42 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get()).getAmplifier();
                     break label261;
                  }

                  var42 = 0;
               }

               if (var42 == 2) {
                  if (!entity.isShiftKeyDown()) {
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
                                 + itemstack.getOrCreateTag().getString("camefrom")
                                 + " run tp "
                                 + itemstack.getOrCreateTag().getDouble("latestx")
                                 + " "
                                 + itemstack.getOrCreateTag().getDouble("latesty")
                                 + " "
                                 + itemstack.getOrCreateTag().getDouble("latestz")
                           );
                     }
                  } else {
                     if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                        ResourceKey<Level> destinationType = Level.OVERWORLD;
                        if (_player.level().dimension() == destinationType) {
                           return;
                        }

                        ServerLevel nextLevel = _player.server.getLevel(destinationType);
                        if (nextLevel != null) {
                           _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0.0F));
                           _player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
                           _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));

                           for (MobEffectInstance _effectinstance : _player.getActiveEffects()) {
                              _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
                           }

                           _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                        }
                     }

                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        int var48;
                        CommandSourceStack var10001;
                        label241: {
                           var43 = entity.getServer().getCommands();
                           var10001 = new CommandSourceStack(
                              CommandSource.NULL,
                              entity.position(),
                              entity.getRotationVector(),
                              entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                              4,
                              entity.getName().getString(),
                              entity.getDisplayName(),
                              entity.level().getServer(),
                              entity
                           );
                           if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                              var48 = _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                                 ? _player.getRespawnPosition().getX()
                                 : _player.level().getLevelData().getXSpawn();
                              break label241;
                           }

                           var48 = 0;
                        }

                        int var10003;
                        label232: {
                           if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                              var10003 = _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                                 ? _player.getRespawnPosition().getY()
                                 : _player.level().getLevelData().getYSpawn();
                              break label232;
                           }

                           var10003 = 0;
                        }

                        int var10004;
                        label223: {
                           if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                              var10004 = _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                                 ? _player.getRespawnPosition().getZ()
                                 : _player.level().getLevelData().getZSpawn();
                              break label223;
                           }

                           var10004 = 0;
                        }

                        var43.performPrefixedCommand(var10001, "tp " + var48 + " " + var10003 + " " + var10004);
                     }
                  }
               } else {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator.getStringUUID().equals(itemstack.getOrCreateTag().getString("trackfortp"))
                        && !entityiterator.level().isClientSide()
                        && entityiterator.getServer() != null) {
                        entityiterator.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                 CommandSource.NULL,
                                 entityiterator.position(),
                                 entityiterator.getRotationVector(),
                                 entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                                 4,
                                 entityiterator.getName().getString(),
                                 entityiterator.getDisplayName(),
                                 entityiterator.level().getServer(),
                                 entityiterator
                              ),
                              "tp "
                                 + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .pocketdimensionx
                                 + " 257 "
                                 + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .pocketdimensionx
                           );
                     }

                     if (entityiterator == entity && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                        entityiterator.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                 CommandSource.NULL,
                                 entityiterator.position(),
                                 entityiterator.getRotationVector(),
                                 entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                                 4,
                                 entityiterator.getName().getString(),
                                 entityiterator.getDisplayName(),
                                 entityiterator.level().getServer(),
                                 entityiterator
                              ),
                              "tp "
                                 + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .pocketdimensionx
                                 + " 257 "
                                 + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .pocketdimensionx
                           );
                     }
                  }
               }
            } else {
               itemstack.getOrCreateTag()
                  .putString("camefrom", (entity.level().dimension() + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip());
               itemstack.getOrCreateTag().putDouble("latestx", entity.getX());
               itemstack.getOrCreateTag().putDouble("latesty", entity.getY());
               itemstack.getOrCreateTag().putDouble("latestz", entity.getZ());
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator.getStringUUID().equals(itemstack.getOrCreateTag().getString("trackfortp"))
                     && !entityiterator.level().isClientSide()
                     && entityiterator.getServer() != null) {
                     entityiterator.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entityiterator.position(),
                              entityiterator.getRotationVector(),
                              entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                              4,
                              entityiterator.getName().getString(),
                              entityiterator.getDisplayName(),
                              entityiterator.level().getServer(),
                              entityiterator
                           ),
                           "execute in arphex:the_crawling run tp "
                              + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .pocketdimensionx
                              + " 257 "
                              + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .pocketdimensionx
                        );
                  }

                  if (entityiterator == entity && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entityiterator.position(),
                              entityiterator.getRotationVector(),
                              entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                              4,
                              entityiterator.getName().getString(),
                              entityiterator.getDisplayName(),
                              entityiterator.level().getServer(),
                              entityiterator
                           ),
                           "execute in arphex:the_crawling run tp "
                              + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .pocketdimensionx
                              + " 257 "
                              + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .pocketdimensionx
                        );
                  }
               }
            }

            if (entity.getPersistentData().getBoolean("creativespectator")) {
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
               }
            } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ArphexModItems.CRAWLING_CONTAINER.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.CRAWLING_CONTAINER.get()) {
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 400);
               }
            } else if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 800);
            }
         } else {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Generated your pocket dimension location - Use again to teleport"), true);
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 60);
            }

            double _setval = ArphexModVariables.MapVariables.get(world).pocket_dimension_count * 32.0 + 0.5;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.pocketdimensionx = _setval;
               capability.syncPlayerVariables(entity);
            });
            ArphexModVariables.MapVariables.get(world).pocket_dimension_count++;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }
      }
   }
}
