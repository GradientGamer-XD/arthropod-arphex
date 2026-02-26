package net.arphex.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.arphex.procedures.BroadcastWikiProcedure;
import net.arphex.procedures.DebugDespawnsProcedure;
import net.arphex.procedures.DespawnCommandProcedure;
import net.arphex.procedures.ForceSpawnTormentorProcedure;
import net.arphex.procedures.IndividualResetBossKillsProcedure;
import net.arphex.procedures.MirrorCommandProcedure;
import net.arphex.procedures.ResetBossKillsProcedure;
import net.arphex.procedures.SealCommandProcedure;
import net.arphex.procedures.SeismicCommandProcedure;
import net.arphex.procedures.TormentorHealthProcedure;
import net.arphex.procedures.TormentorRotationProcedure;
import net.arphex.procedures.TormentorTierSetProcedure;
import net.arphex.procedures.TormentorlevelsetProcedure;
import net.arphex.procedures.TrophyCommandProcedure;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ArphexCommandCommand {
   @SubscribeEvent
   public static void registerCommand(RegisterCommandsEvent event) {
      event.getDispatcher()
         .register(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal(
                                                      "arphex"
                                                   )
                                                   .requires(s -> s.hasPermission(2)))
                                                .then(Commands.literal("seal_tormentor").executes(arguments -> {
                                                   Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                                   double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                                   double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                                   double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                                   Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                                   if (entity == null && world instanceof ServerLevel _servLevel) {
                                                      entity = FakePlayerFactory.getMinecraft(_servLevel);
                                                   }

                                                   Direction direction = Direction.DOWN;
                                                   if (entity != null) {
                                                      direction = entity.getDirection();
                                                   }

                                                   SealCommandProcedure.execute(world, x, y, z, entity);
                                                   return 0;
                                                })))
                                             .then(
                                                Commands.literal("set_tormentor_level")
                                                   .then(
                                                      Commands.argument("player_name", EntityArgument.players())
                                                         .then(Commands.argument("level", DoubleArgumentType.doubleArg(0.0, 100.0)).executes(arguments -> {
                                                            Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                                            double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                                            double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                                            double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                                            Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                                            if (entity == null && world instanceof ServerLevel _servLevel) {
                                                               entity = FakePlayerFactory.getMinecraft(_servLevel);
                                                            }

                                                            Direction direction = Direction.DOWN;
                                                            if (entity != null) {
                                                               direction = entity.getDirection();
                                                            }

                                                            TormentorlevelsetProcedure.execute(world, arguments);
                                                            return 0;
                                                         }))
                                                   )
                                             ))
                                          .then(
                                             Commands.literal("set_tormentor_tier")
                                                .then(Commands.argument("tier", DoubleArgumentType.doubleArg(1.0, 5.0)).executes(arguments -> {
                                                   Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                                   double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                                   double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                                   double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                                   Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                                   if (entity == null && world instanceof ServerLevel _servLevel) {
                                                      entity = FakePlayerFactory.getMinecraft(_servLevel);
                                                   }

                                                   Direction direction = Direction.DOWN;
                                                   if (entity != null) {
                                                      direction = entity.getDirection();
                                                   }

                                                   TormentorTierSetProcedure.execute(world, arguments, entity);
                                                   return 0;
                                                }))
                                          ))
                                       .then(
                                          Commands.literal("set_tormentor_health")
                                             .then(Commands.argument("tormentor_health", DoubleArgumentType.doubleArg(0.0, 1024.0)).executes(arguments -> {
                                                Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                                double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                                double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                                double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                                Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                                if (entity == null && world instanceof ServerLevel _servLevel) {
                                                   entity = FakePlayerFactory.getMinecraft(_servLevel);
                                                }

                                                Direction direction = Direction.DOWN;
                                                if (entity != null) {
                                                   direction = entity.getDirection();
                                                }

                                                TormentorHealthProcedure.execute(world, arguments);
                                                return 0;
                                             }))
                                       ))
                                    .then(
                                       Commands.literal("set_tormentor_rotation")
                                          .then(Commands.argument("tormentor_rotation", DoubleArgumentType.doubleArg(-180.0, 180.0)).executes(arguments -> {
                                             Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                             double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                             double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                             double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                             Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                             if (entity == null && world instanceof ServerLevel _servLevel) {
                                                entity = FakePlayerFactory.getMinecraft(_servLevel);
                                             }

                                             Direction direction = Direction.DOWN;
                                             if (entity != null) {
                                                direction = entity.getDirection();
                                             }

                                             TormentorRotationProcedure.execute(world, arguments);
                                             return 0;
                                          }))
                                    ))
                                 .then(
                                    ((LiteralArgumentBuilder)Commands.literal("boss_kills_reset")
                                          .then(Commands.literal("individual").then(Commands.argument("name", EntityArgument.players()).executes(arguments -> {
                                             Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                             double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                             double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                             double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                             Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                             if (entity == null && world instanceof ServerLevel _servLevel) {
                                                entity = FakePlayerFactory.getMinecraft(_servLevel);
                                             }

                                             Direction direction = Direction.DOWN;
                                             if (entity != null) {
                                                direction = entity.getDirection();
                                             }

                                             IndividualResetBossKillsProcedure.execute(world, arguments, entity);
                                             return 0;
                                          }))))
                                       .then(Commands.literal("global").executes(arguments -> {
                                          Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                          double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                          double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                          double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                          Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                          if (entity == null && world instanceof ServerLevel _servLevel) {
                                             entity = FakePlayerFactory.getMinecraft(_servLevel);
                                          }

                                          Direction direction = Direction.DOWN;
                                          if (entity != null) {
                                             direction = entity.getDirection();
                                          }

                                          ResetBossKillsProcedure.execute(world);
                                          return 0;
                                       }))
                                 ))
                              .then(Commands.literal("broadcast_wiki_link").executes(arguments -> {
                                 Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                 double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                 double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                 double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                 Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                 if (entity == null && world instanceof ServerLevel _servLevel) {
                                    entity = FakePlayerFactory.getMinecraft(_servLevel);
                                 }

                                 Direction direction = Direction.DOWN;
                                 if (entity != null) {
                                    direction = entity.getDirection();
                                 }

                                 BroadcastWikiProcedure.execute(entity);
                                 return 0;
                              })))
                           .then(
                              Commands.literal("give_trophy")
                                 .then(
                                    Commands.argument("players", EntityArgument.players())
                                       .then(Commands.argument("mob_id", StringArgumentType.word()).executes(arguments -> {
                                          Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                          double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                          double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                          double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                          Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                          if (entity == null && world instanceof ServerLevel _servLevel) {
                                             entity = FakePlayerFactory.getMinecraft(_servLevel);
                                          }

                                          Direction direction = Direction.DOWN;
                                          if (entity != null) {
                                             direction = entity.getDirection();
                                          }

                                          TrophyCommandProcedure.execute(world, arguments);
                                          return 0;
                                       }))
                                 )
                           ))
                        .then(
                           Commands.literal("despawn").then(Commands.argument("arphex_entities_to_despawn", EntityArgument.entities()).executes(arguments -> {
                              Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                              double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                              double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                              double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                              Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                              if (entity == null && world instanceof ServerLevel _servLevel) {
                                 entity = FakePlayerFactory.getMinecraft(_servLevel);
                              }

                              Direction direction = Direction.DOWN;
                              if (entity != null) {
                                 direction = entity.getDirection();
                              }

                              DespawnCommandProcedure.execute(arguments, entity);
                              return 0;
                           }))
                        ))
                     .then(Commands.literal("debug_despawns").executes(arguments -> {
                        Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                        double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                        double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                        double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                        Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                        if (entity == null && world instanceof ServerLevel _servLevel) {
                           entity = FakePlayerFactory.getMinecraft(_servLevel);
                        }

                        Direction direction = Direction.DOWN;
                        if (entity != null) {
                           direction = entity.getDirection();
                        }

                        DebugDespawnsProcedure.execute(world, entity);
                        return 0;
                     })))
                  .then(Commands.literal("tormentor_force_spawn").executes(arguments -> {
                     Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                     double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                     double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                     double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                     Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                     if (entity == null && world instanceof ServerLevel _servLevel) {
                        entity = FakePlayerFactory.getMinecraft(_servLevel);
                     }

                     Direction direction = Direction.DOWN;
                     if (entity != null) {
                        direction = entity.getDirection();
                     }

                     ForceSpawnTormentorProcedure.execute(world, entity);
                     return 0;
                  })))
               .then(
                  Commands.literal("power_unlocks")
                     .then(
                        ((RequiredArgumentBuilder)Commands.argument("players", EntityArgument.players())
                              .then(Commands.literal("seismic_pulse").then(Commands.argument("enabled", BoolArgumentType.bool()).executes(arguments -> {
                                 Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                                 double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                                 double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                                 double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                                 Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                                 if (entity == null && world instanceof ServerLevel _servLevel) {
                                    entity = FakePlayerFactory.getMinecraft(_servLevel);
                                 }

                                 Direction direction = Direction.DOWN;
                                 if (entity != null) {
                                    direction = entity.getDirection();
                                 }

                                 SeismicCommandProcedure.execute(arguments, entity);
                                 return 0;
                              }))))
                           .then(Commands.literal("celestial_mirror").then(Commands.argument("enabled", BoolArgumentType.bool()).executes(arguments -> {
                              Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
                              double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
                              double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
                              double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
                              Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
                              if (entity == null && world instanceof ServerLevel _servLevel) {
                                 entity = FakePlayerFactory.getMinecraft(_servLevel);
                              }

                              Direction direction = Direction.DOWN;
                              if (entity != null) {
                                 direction = entity.getDirection();
                              }

                              MirrorCommandProcedure.execute(arguments, entity);
                              return 0;
                           })))
                     )
               )
         );
   }
}
