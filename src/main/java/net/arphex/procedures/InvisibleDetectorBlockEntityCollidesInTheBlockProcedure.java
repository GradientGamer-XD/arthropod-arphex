package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class InvisibleDetectorBlockEntityCollidesInTheBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean closest_target = false;
         String tier_message = "";
         if (entity instanceof ItemEntity
            && (
               (entity instanceof ItemEntity _itemEntx ? _itemEntx.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_CRYSTAL.get()
                  || (entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.FIRE_OPAL.get()
            )) {
            if ((entity instanceof ItemEntity _itemEntxx ? _itemEntxx.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_CRYSTAL.get()) {
               ArphexModVariables.MapVariables.get(world).tormentor_tier = 1.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            } else if ((entity instanceof ItemEntity _itemEntxx ? _itemEntxx.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.FIRE_OPAL.get()) {
               ArphexModVariables.MapVariables.get(world).tormentor_tier = 2.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            } else if ((entity instanceof ItemEntity _itemEntxx ? _itemEntxx.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VOID_GEODE.get()) {
               ArphexModVariables.MapVariables.get(world).tormentor_tier = 2.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            } else if ((entity instanceof ItemEntity _itemEntxx ? _itemEntxx.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TIME_PRISM.get()) {
               ArphexModVariables.MapVariables.get(world).tormentor_tier = 2.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            } else {
               ArphexModVariables.MapVariables.get(world).tormentor_tier = 2.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            }

            if ((Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get()) {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof Player && entityiterator instanceof Player) {
                        Player _player = (Player)entityiterator;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(
                              Component.literal("The Tormentor is already awakened. The mineral fell into the void pointlessly..."), true
                           );
                        }
                     }
                  }
               } else {
                  closest_target = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorx instanceof Player) {
                        if (entityiteratorx instanceof ServerPlayer _player) {
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:tormentor_summoned"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for (String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }

                        if (!closest_target) {
                           ArphexModVariables.MapVariables.get(world).tormentor_target_follow = entityiteratorx.getStringUUID();
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                           closest_target = true;
                        }
                     }
                  }

                  if (ArphexModVariables.MapVariables.get(world).tormentor_countdown > 0.0) {
                     if (!ArphexModVariables.MapVariables.get(world).messagesequence.equals("ten")) {
                        ArphexModVariables.MapVariables.get(world).messagesequence = "ten";
                        ArphexModVariables.MapVariables.get(world).syncData(world);
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "tellraw @a {\"text\":\"TORMENTOR COUNTDOWN RESET TO FULL TEN MINUTES\",\"bold\":true,\"color\":\"red\"}"
                              );
                        }

                        if (!world.isClientSide() && world.getServer() != null) {
                           world.getServer()
                              .getPlayerList()
                              .broadcastSystemMessage(Component.literal("TEN MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
                        }
                     }
                  } else if (!ArphexModVariables.MapVariables.get(world).messagesequence.equals("ten")) {
                     ArphexModVariables.MapVariables.get(world).messagesequence = "ten";
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
                        tier_message = "TIER 1";
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
                        tier_message = "§bTIER 2";
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
                        tier_message = "§dTIER 3";
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
                        tier_message = "§6TIER 4";
                     } else {
                        tier_message = "§4TIER 5";
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "tellraw @a {\"text\":\"THE TORMENTOR IS AWAKENING AT "
                                 + tier_message
                                 + " POWER. EVERY DIMENSION SHUDDERS IN TERROR. THE COUNTDOWN BEGINS!\",\"bold\":true,\"color\":\"red\"}"
                           );
                     }

                     if ((entity instanceof ItemEntity _itemEntxx ? _itemEntxx.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VOID_GEODE.get()) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "tellraw @a {\"text\":\"Player attempted to summon TIER 3, but this is not implemented yet. Defaulting to tier 2\",\"bold\":true,\"color\":\"red\"}"
                              );
                        }
                     } else if ((entity instanceof ItemEntity _itemEntxxx ? _itemEntxxx.getItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.TIME_PRISM.get()) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "tellraw @a {\"text\":\"Player attempted to summon TIER 4, but this is not implemented yet. Defaulting to tier 2\",\"bold\":true,\"color\":\"red\"}"
                              );
                        }
                     } else if ((entity instanceof ItemEntity _itemEntxxxx ? _itemEntxxxx.getItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.ENTROPY_MATRIX.get()
                        && world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "tellraw @a {\"text\":\"Player attempted to summon TIER 5, but this is not implemented yet. Defaulting to tier 2\",\"bold\":true,\"color\":\"red\"}"
                           );
                     }

                     if (!world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("TEN MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
                     }

                     _center = new Vec3(x, y, z);

                     for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiteratorxx instanceof Player) {
                           boolean _setval = true;
                           entityiteratorxx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.show_tormentor_overlay = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                        }
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "effect give @e[type=player] arphex:terror 60 0 false"
                        );
                  }

                  ArphexModVariables.MapVariables.get(world).tormentor_countdown = 3600.0;
                  ArphexModVariables.MapVariables.get(world).syncData(world);
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "effect give @e[type=player] darkness 5 0 false"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
                     entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                     entityToSpawn.setVisualOnly(true);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (!world.isClientSide()) {
                     world.setBlock(BlockPos.containing(x, y, z), Blocks.BEDROCK.defaultBlockState(), 3);
                     world.setBlock(BlockPos.containing(x, y + 22.0, z), Blocks.BEDROCK.defaultBlockState(), 3);
                  }
               }
            } else {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorxxx instanceof Player && entityiteratorxxx instanceof Player) {
                     Player _playerx = (Player)entityiteratorxxx;
                     if (!_playerx.level().isClientSide()) {
                        _playerx.displayClientMessage(Component.literal("Bosses disabled in config. Therefore, you cannot spawn the Tormentor"), true);
                     }
                  }
               }
            }
         }
      }
   }
}
