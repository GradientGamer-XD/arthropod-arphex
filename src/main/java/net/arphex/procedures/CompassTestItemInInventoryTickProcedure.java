package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;

public class CompassTestItemInInventoryTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         label60: {
            double angletodestination = 0.0;
            double arphextriangx = 0.0;
            double arphextriangz = 0.0;
            double auxiliaryx = 0.0;
            double auxiliaryz = 0.0;
            double initxpos = 0.0;
            double initzpos = 0.0;
            boolean proceed = false;
            if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if (Math.floor((double)(new Object() {
                  public int getScore(String score, Entity _ent) {
                     Scoreboard _sc = _ent.level().getScoreboard();
                     Objective _so = _sc.getObjective(score);
                     return _so != null ? _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore() : 0;
                  }
               }).getScore("arphextriang0", entity)) != 0.0 && Math.floor((double)(new Object() {
                  public int getScore(String score, Entity _ent) {
                     Scoreboard _sc = _ent.level().getScoreboard();
                     Objective _so = _sc.getObjective(score);
                     return _so != null ? _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore() : 0;
                  }
               }).getScore("arphextriangx100", entity)) != 0.0 && Math.floor((double)(new Object() {
                  public int getScore(String score, Entity _ent) {
                     Scoreboard _sc = _ent.level().getScoreboard();
                     Objective _so = _sc.getObjective(score);
                     return _so != null ? _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore() : 0;
                  }
               }).getScore("arphextriangz100", entity)) != 0.0) {
                  double _setval = entity.getX() + (Math.pow((double)(new Object() {
                     public int getScore(String score, Entity _ent) {
                        Scoreboard _sc = _ent.level().getScoreboard();
                        Objective _so = _sc.getObjective(score);
                        return _so != null ? _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore() : 0;
                     }
                  }).getScore("arphextriangx100", entity), 2.0) - Math.pow((double)(new Object() {
                     public int getScore(String score, Entity _ent) {
                        Scoreboard _sc = _ent.level().getScoreboard();
                        Objective _so = _sc.getObjective(score);
                        return _so != null ? _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore() : 0;
                     }
                  }).getScore("arphextriang0", entity), 2.0) - 10000.0) / -200.0;
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.arphextriangx = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  _setval = entity.getZ() + (Math.pow((double)(new Object() {
                     public int getScore(String score, Entity _ent) {
                        Scoreboard _sc = _ent.level().getScoreboard();
                        Objective _so = _sc.getObjective(score);
                        return _so != null ? _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore() : 0;
                     }
                  }).getScore("arphextriangz100", entity), 2.0) - Math.pow((double)(new Object() {
                     public int getScore(String score, Entity _ent) {
                        Scoreboard _sc = _ent.level().getScoreboard();
                        Objective _so = _sc.getObjective(score);
                        return _so != null ? _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore() : 0;
                     }
                  }).getScore("arphextriang0", entity), 2.0) - 10000.0) / -200.0;
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.arphextriangz = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  itemstack.setHoverName(
                     Component.literal(
                        "Crawling Compass - Triangulated: X="
                           + Math.floor(
                              ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .arphextriangx
                           )
                           + ", Z="
                           + Math.floor(
                              ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .arphextriangz
                           )
                     )
                  );
                  if (entity instanceof Player _player) {
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 0);
                  }
               }
               break label60;
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "scoreboard objectives remove arphextriang0"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "scoreboard objectives remove arphextriangx100"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "scoreboard objectives remove arphextriangz100"
                  );
            }

            if (itemstack.getDisplayName().getString().replace("[", "").replace("]", "").equals("scanning...")) {
               itemstack.setHoverName(Component.literal("Not yet found (right click to attempt)"));
            }
         }

         if (!world.isClientSide()) {
            double _setval = Math.floor(
                  ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .arphexanglevsyaw
                     / 22.5
               )
               + 8.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.arphexcompass = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         double var27 = Math.floor(
            Math.atan2(
                  ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .arphextriangx
                     - entity.getX(),
                  ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .arphextriangz
                     - entity.getZ()
               )
               * (180.0 / Math.PI)
         );
         double _setval = var27 - (double)(entity.getYRot() * -1.0F);
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.arphexanglevsyaw = _setval;
            capability.syncPlayerVariables(entity);
         });
         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .arphexanglevsyaw
               > 180.0
            || ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .arphexanglevsyaw
               < -180.0) {
            if (itemstack.getOrCreateTag().getBoolean("hasscanned")) {
               if (var27 < (double)(entity.getYRot() * -1.0F)) {
                  _setval = var27 + 360.0 - (double)(entity.getYRot() * -1.0F);
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.arphexanglevsyaw = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               } else {
                  _setval = var27 - (double)(entity.getYRot() * -1.0F + 360.0F);
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.arphexanglevsyaw = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            } else {
               _setval = (double)Mth.nextInt(RandomSource.create(), -360, 360);
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.arphexanglevsyaw = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }
         }
      }
   }
}
