package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class TimeFreezeOnEffectActiveTickProcedure {
   public static void execute(Entity entity, double amplifier) {
      if (entity != null) {
         boolean found = false;
         double amp_limit = 0.0;
         double particleRadius = 0.0;
         double particleAmount = 0.0;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double limit_parti_lowamp = 0.0;
         if (!entity.getPersistentData().getBoolean("creativespectator")) {
            if (entity instanceof Player && entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§2Beware, you are being frozen in time!"), true);
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) < 1024.0F) {
               if (entity.getPersistentData().getDouble("back_time_x_vx") != 0.0 || entity.getPersistentData().getDouble("back_time_z_vx") != 0.0) {
                  entity.teleportTo(
                     entity.getPersistentData().getDouble("back_time_x_vx"),
                     entity.getPersistentData().getDouble("back_time_y_vx"),
                     entity.getPersistentData().getDouble("back_time_z_vx")
                  );
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection
                        .teleport(
                           entity.getPersistentData().getDouble("back_time_x_vx"),
                           entity.getPersistentData().getDouble("back_time_y_vx"),
                           entity.getPersistentData().getDouble("back_time_z_vx"),
                           entity.getYRot(),
                           entity.getXRot()
                        );
                  }
               }

               amp_limit = amplifier;
               if (amplifier > 19.0) {
                  amp_limit = 19.0;
               }

               if (entity.getPersistentData().getDouble("back_time_loop_vx") > 0.0 && !(amplifier > 19.0)) {
                  entity.getPersistentData().putDouble("back_time_loop_vx", entity.getPersistentData().getDouble("back_time_loop_vx") - 1.0);
                  if (entity.getPersistentData().getDouble("back_time_x_vx") != 0.0 || entity.getPersistentData().getDouble("back_time_z_vx") != 0.0) {
                     entity.getPersistentData().putDouble("back_time_x_vx", 0.0);
                     entity.getPersistentData().putDouble("back_time_y_vx", 0.0);
                     entity.getPersistentData().putDouble("back_time_z_vx", 0.0);
                  }
               } else {
                  sx = (double)(0.0F - entity.getBbWidth() * 2.0F);
                  if (amplifier > 12.0) {
                     limit_parti_lowamp = 6.0;
                  } else if (amplifier > 10.0) {
                     limit_parti_lowamp = 5.0;
                  } else if (amplifier > 8.0) {
                     limit_parti_lowamp = 4.0;
                  } else if (amplifier > 6.0) {
                     limit_parti_lowamp = 3.0;
                  } else if (amplifier > 3.0) {
                     limit_parti_lowamp = 2.0;
                  } else {
                     limit_parti_lowamp = 1.0;
                  }

                  for (int index0 = 0; index0 < 6; index0++) {
                     sy = (double)(0.0F - entity.getBbHeight() / 2.0F);

                     for (int index1 = 0; index1 < (int)limit_parti_lowamp; index1++) {
                        sz = (double)(0.0F - entity.getBbWidth() * 2.0F);

                        for (int index2 = 0; index2 < 6; index2++) {
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
                                    "particle arphex:tiny_time ~"
                                       + (sx + (double)(entity.getBbWidth() / 2.0F))
                                       + " ~"
                                       + sy
                                       + " ~"
                                       + (sz + (double)(entity.getBbWidth() / 2.0F))
                                       + " 0 0 0 0 1 force"
                                 );
                           }

                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 0, false, false));
                           }

                           sz += (double)(entity.getBbWidth() * 2.0F / 3.0F);
                        }

                        sy += (double)(entity.getBbHeight() / 3.0F);
                     }

                     sx += (double)(entity.getBbWidth() * 2.0F / 3.0F);
                  }

                  if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) > 200.0F) {
                     entity.getPersistentData().putDouble("back_time_loop_vx", 30.0 - amp_limit);
                  } else {
                     entity.getPersistentData().putDouble("back_time_loop_vx", 20.0 - amp_limit);
                  }

                  entity.getPersistentData().putDouble("back_time_x_vx", entity.getX());
                  entity.getPersistentData().putDouble("back_time_y_vx", entity.getY());
                  entity.getPersistentData().putDouble("back_time_z_vx", entity.getZ());
               }

               int var34;
               label101: {
                  if (entity instanceof LivingEntity _livEntx && _livEntx.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                     var34 = _livEntx.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                     break label101;
                  }

                  var34 = 0;
               }

               if (var34 > 1 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.TIME_FREEZE.get(), 10, (int)Math.round(amplifier - 1.0), false, false));
               }
            }
         }
      }
   }
}
