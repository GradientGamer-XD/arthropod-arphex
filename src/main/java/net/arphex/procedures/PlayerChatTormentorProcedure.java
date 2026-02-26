package net.arphex.procedures;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerChatTormentorProcedure {
   @SubscribeEvent
   public static void onChat(ServerChatEvent event) {
      execute(
         event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getRawText()
      );
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String text) {
      execute(null, world, x, y, z, entity, text);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String text) {
      if (entity != null && text != null) {
         String config_chat = "";
         double chat_count = 0.0;
         double store_random = 0.0;
         boolean preset_found = false;
         if (entity.getName().getString().equals("Vllax") && text.toLowerCase().startsWith("vxc ")) {
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
                     text.substring(4)
                  );
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (text.toLowerCase().contains("tormentor".toLowerCase())) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               ArphexModVariables.MapVariables.get(world).torchatcooldown = (Double)ConfigurationSettingsConfiguration.TORMENTOR_RESPONSE_CHANCE.get() * 20.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
            }

            if (!(ArphexModVariables.MapVariables.get(world).torchatcooldown > 0.0) && Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               for (Entity entityiterator : new ArrayList(world.players())) {
                  boolean _setval = true;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.show_tormentor_overlay = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }

               chat_count = 0.0;

               for (String stringiterator : (List)ConfigurationSettingsConfiguration.BONUS_TORMENTOR_CHAT.get()) {
                  chat_count++;
               }

               if (chat_count < 32.0) {
                  chat_count = 32.0;
               }

               store_random = (double)Mth.nextInt(RandomSource.create(), 1, (int)chat_count);
               chat_count = 0.0;
               preset_found = false;

               for (String stringiterator : (List)ConfigurationSettingsConfiguration.BONUS_TORMENTOR_CHAT.get()) {
                  if (++chat_count == store_random) {
                     preset_found = true;
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 60),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\"" + stringiterator + "\"}]"
                                 );
                           }
                        }
                     );
                  }
               }

               if (!preset_found) {
                  store_random = (double)Mth.nextInt(RandomSource.create(), 1, 32);
                  if (store_random == 1.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" The end is coming\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 2.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Do you think you can escape\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 3.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" They crawl beneath you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 4.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Demonic entities are coming for you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 5.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You have no chance\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 6.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Nothing can save you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 7.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You are fragile\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 8.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Suffering and torment await you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 9.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Darkness will consume you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 10.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Do you believe you know anything?\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 11.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Do you trust your senses?\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 12.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Do you trust your mind?\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 13.0) {
                     if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)
                        && !(
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .killedtormentor
                              > 0.0
                        )) {
                        ArphexMod.queueServerWork(
                           Mth.nextInt(RandomSource.create(), 1, 32),
                           () -> {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" I await your challenge, "
                                          + entity.getDisplayName().getString()
                                          + "\"}]"
                                    );
                              }
                           }
                        );
                     }
                  } else if (store_random == 14.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" I know you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 15.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Death awaits you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 16.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Decadence awaits you\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 17.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You will be cast into the deepest depths of the Crawling\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 18.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You have no real allies\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 19.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You have no hope\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 20.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You cannot hide from me\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 21.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" It is already too late, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 22.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You are surrounded, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 23.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Fear is your only ally, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 24.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" The Crawling exists for you, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 25.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" The void is your destination, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 26.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" The abyss will consume you, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 27.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" The walls are closing in, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 28.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Your nightmares are real, "
                                       + entity.getDisplayName().getString()
                                       + "\"}]"
                                 );
                           }
                        }
                     );
                  } else if (store_random == 29.0) {
                     if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
                        ArphexMod.queueServerWork(
                           Mth.nextInt(RandomSource.create(), 1, 32),
                           () -> {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Things worse than death await you, "
                                          + entity.getDisplayName().getString()
                                          + "\"}]"
                                    );
                              }
                           }
                        );
                     } else {
                        ArphexMod.queueServerWork(
                           Mth.nextInt(RandomSource.create(), 1, 32),
                           () -> {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                          )
                                          .withSuppressedOutput(),
                                       "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" An interesting world name.. "
                                          + (world.getLevelData() instanceof ServerLevelData _levelData112 ? _levelData112.getLevelName() : "")
                                          + "...\"}]"
                                    );
                              }
                           }
                        );
                     }
                  } else if (store_random == 30.0) {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" You will be forgotten\"}]"
                                 );
                           }
                        }
                     );
                  } else {
                     ArphexMod.queueServerWork(
                        Mth.nextInt(RandomSource.create(), 1, 32),
                        () -> {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "/tellraw @a [\"\",{\"text\":\"<TORMENTOR>\",\"color\":\"red\"},{\"text\":\" Nothing you do can stop me permanently\"}]"
                                 );
                           }
                        }
                     );
                  }
               }
            }
         }
      }
   }
}
