package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModBlocks;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WorldTickProcedure {
   @SubscribeEvent
   public static void onWorldTick(LevelTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.level);
      }
   }

   public static void execute(LevelAccessor world) {
      execute(null, world);
   }

   private static void execute(@Nullable Event event, LevelAccessor world) {
      double xcalc = 0.0;
      double col_b = 0.0;
      double distance = 0.0;
      double spheresize = 0.0;
      double col_g = 0.0;
      double true_dists = 0.0;
      double col_r = 0.0;
      double sphere_num = 0.0;
      double ycalc = 0.0;
      double sphere_gradient = 0.0;
      double tormentor_distance = 0.0;
      double asc_sphere_y = 0.0;
      double asc_sphere_x = 0.0;
      double asc_sphere_z = 0.0;
      double dist_to_rendered = 0.0;
      double rotation_from_tormentor = 0.0;
      double dropoff = 0.0;
      double i = 0.0;
      double tier_multiply = 0.0;
      double j = 0.0;
      double zcalc = 0.0;
      double k = 0.0;
      double l = 0.0;
      double max_entities = 0.0;
      double opacity = 0.0;
      double dists = 0.0;
      double asc_x_local = 0.0;
      double asc_y_local = 0.0;
      double asc_z_local = 0.0;
      String substring_chunk = "";
      String current_ascendant = "";
      String asc_subchain = "";
      if (ArphexModVariables.MapVariables.get(world).tormentor_seal_limit > 0.0) {
         ArphexModVariables.MapVariables.get(world).tormentor_seal_limit--;
         ArphexModVariables.MapVariables.get(world).syncData(world);
      }

      if (ArphexModVariables.MapVariables.get(world).tormentor_countdown > 0.0) {
         ArphexModVariables.MapVariables.get(world).tormentor_countdown -= 0.075;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 540.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("nine")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NINE MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "nine";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 480.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("eight")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("EIGHT MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "eight";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 420.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("seven")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("SEVEN MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "seven";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 360.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("six")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("SIX MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "six";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 300.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("five")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("FIVE MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "five";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 240.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("four")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("FOUR MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "four";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 180.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("three")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("THREE MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "three";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 120.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("two")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("TWO MINUTES REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "two";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 60.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("one")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ONE MINUTE REMAINING UNTIL THE TORMENTOR ARISES"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "one";
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (Math.floor(ArphexModVariables.MapVariables.get(world).tormentor_countdown / 6.0) == 1.0
            && !ArphexModVariables.MapVariables.get(world).messagesequence.equals("done")) {
            if (!world.isClientSide() && world.getServer() != null) {
               world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("THE TORMENTOR HAS AWAKENED"), false);
            }

            ArphexModVariables.MapVariables.get(world).messagesequence = "done";
            ArphexModVariables.MapVariables.get(world).syncData(world);
            ArphexModVariables.MapVariables.get(world).tormentor_last_player_spawned = false;
            ArphexModVariables.MapVariables.get(world).syncData(world);
            ArphexModVariables.MapVariables.get(world).tormentor_health = 1024.0;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }
      }

      if (ArphexModVariables.MapVariables.get(world).playeronlayer1 > 0.0) {
         ArphexModVariables.MapVariables.get(world).playeronlayer1--;
         ArphexModVariables.MapVariables.get(world).syncData(world);
      }

      if (ArphexModVariables.MapVariables.get(world).playeronlayer2 > 0.0) {
         ArphexModVariables.MapVariables.get(world).playeronlayer2--;
         ArphexModVariables.MapVariables.get(world).syncData(world);
      }

      if (ArphexModVariables.MapVariables.get(world).playeronlayer3 > 0.0) {
         ArphexModVariables.MapVariables.get(world).playeronlayer3--;
         ArphexModVariables.MapVariables.get(world).syncData(world);
      }

      if (ArphexModVariables.MapVariables.get(world).playeronlayer4 > 0.0) {
         ArphexModVariables.MapVariables.get(world).playeronlayer4--;
         ArphexModVariables.MapVariables.get(world).syncData(world);
      }

      if (ArphexModVariables.MapVariables.get(world).alternate_entity_tick) {
         ArphexModVariables.MapVariables.get(world).alternate_entity_tick = false;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (ArphexModVariables.MapVariables.get(world).mat_larvae_limit > 20.0) {
            ArphexModVariables.MapVariables.get(world).matlarave_spawncap_exceeded_toggle = true;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         } else {
            ArphexModVariables.MapVariables.get(world).matlarave_spawncap_exceeded_toggle = false;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         ArphexModVariables.MapVariables.get(world).mat_larvae_limit = 0.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (!(ArphexModVariables.MapVariables.get(world).slow_global_check_5s > 0.0)) {
            ArphexModVariables.MapVariables.get(world).slow_global_check_5s = 100.0;
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.strip().length() > 1) {
               current_ascendant = ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list;
               asc_subchain = "";

               for (int index0 = 0;
                  index0
                        < ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.strip().length()
                           - ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.replace("]", "").strip().length()
                     && current_ascendant.length() > 1;
                  index0++
               ) {
                  if (current_ascendant.contains("[") && current_ascendant.contains("[") && current_ascendant.contains("]")) {
                     asc_subchain = current_ascendant.substring(current_ascendant.lastIndexOf("["), current_ascendant.length())
                        .replace("]", "")
                        .replace("[", "");
                  }

                  if (asc_subchain.contains(
                     ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                           + "")
                        .replace("ResourceKey[minecraft:dimension / ", "")
                        .replace("]", "")
                        .strip()
                  )) {
                     current_ascendant = current_ascendant.replace("[" + asc_subchain + "]", "");
                     if (asc_subchain.contains(",")) {
                        asc_x_local = (new Object() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return 0.0;
                              }
                           }
                        }).convert(asc_subchain.substring(0, asc_subchain.indexOf(",")).replace(",", "").strip());
                        asc_y_local = (new Object() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return 0.0;
                              }
                           }
                        }).convert(asc_subchain.substring(asc_subchain.indexOf(","), asc_subchain.lastIndexOf(",")).replace(",", "").strip());
                        if (asc_subchain.contains("-") && asc_subchain.length() > asc_subchain.indexOf("-")) {
                           asc_z_local = (new Object() {
                                 double convert(String s) {
                                    try {
                                       return Double.parseDouble(s.trim());
                                    } catch (Exception var3) {
                                       return 0.0;
                                    }
                                 }
                              })
                              .convert(
                                 asc_subchain.substring(
                                       asc_subchain.lastIndexOf(","), Math.max(asc_subchain.lastIndexOf("-"), asc_subchain.lastIndexOf(",") + 1)
                                    )
                                    .replace(",", "")
                                    .strip()
                              );
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(asc_x_local, asc_y_local, asc_z_local)).getBlock() != ArphexModBlocks.ASCENDED_CUBE.get()) {
                        ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list = ArphexModVariables.MapVariables.get(world)
                           .ascend_cube_coord_list
                           .replace("[" + asc_subchain + "]", "");
                        ArphexModVariables.MapVariables.get(world).syncData(world);
                     }

                     asc_subchain = "";
                  }
               }
            }
         } else {
            ArphexModVariables.MapVariables.get(world).slow_global_check_5s--;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }
      }
   }
}
