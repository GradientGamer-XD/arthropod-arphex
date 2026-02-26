package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderObstructerEntity;
import net.arphex.init.ArphexModItems;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent.ComputeCameraAngles;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class RenderTest5Procedure {
   public static ComputeCameraAngles provider = null;

   public static void setAngles(float yaw, float pitch, float roll) {
      provider.setYaw(yaw);
      provider.setPitch(pitch);
      provider.setRoll(roll);
   }

   @SubscribeEvent
   public static void computeCameraAngles(ComputeCameraAngles event) {
      provider = event;
      ClientLevel level = Minecraft.getInstance().level;
      Entity entity = provider.getCamera().getEntity();
      if (level != null && entity != null) {
         Vec3 entPos = entity.getPosition((float)provider.getPartialTick());
         execute(provider, entity);
      }
   }

   public static void execute(Entity entity) {
      execute(null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double i = 0.0;
         double j = 0.0;
         double k = 0.0;
         double l = 0.0;
         double roll = 0.0;
         roll = 0.0;
         if (entity.isPassenger()
            && entity.getVehicle() instanceof SpiderObstructerEntity
            && Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON) {
            roll = 45.0;
            setAngles(entity.getYRot(), (float)((double)entity.getXRot() + 9.5), (float)roll);
         }

         if ((Boolean)ConfigurationSettingsConfiguration.SPACETIME_FLIGHT_VIEW_TILT.get()) {
            if ((
                  (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                        == ArphexModItems.SPACETIME_BOOTS.get()
                     || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                        == ArphexModItems.IMMORTAL_BOOTS.get()
               )
               && roll == 0.0
               && !entity.onGround()
               && (
                  (new Object() {
                           public boolean checkGamemode(Entity _ent) {
                              if (_ent instanceof ServerPlayer _serverPlayer) {
                                 return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                              } else {
                                 return _ent.level().isClientSide() && _ent instanceof Player _player
                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                       && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                          == GameType.SURVIVAL
                                    : false;
                              }
                           }
                        })
                        .checkGamemode(entity)
                     || (new Object() {
                           public boolean checkGamemode(Entity _ent) {
                              if (_ent instanceof ServerPlayer _serverPlayer) {
                                 return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                              } else {
                                 return _ent.level().isClientSide() && _ent instanceof Player _player
                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                       && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                          == GameType.ADVENTURE
                                    : false;
                              }
                           }
                        })
                        .checkGamemode(entity)
               )) {
               roll = 0.0
                  - Math.min(
                     Math.max(
                        (
                              entity.getDeltaMovement().x() * Math.cos(Math.toRadians((double)entity.getYRot()))
                                 + entity.getDeltaMovement().z() * Math.sin(Math.toRadians((double)entity.getYRot()))
                           )
                           * 15.0,
                        -11.25
                     ),
                     11.25
                  );
               if (Math.abs(roll) < 5.0) {
                  roll = 0.0;
               } else {
                  roll = Math.signum(roll) * (Math.abs(roll) - 5.0);
               }

               setAngles(
                  Minecraft.getInstance().gameRenderer.getMainCamera().getYRot(), Minecraft.getInstance().gameRenderer.getMainCamera().getXRot(), (float)roll
               );
            }

            if ((entity instanceof LivingEntity _entUseItem22 ? _entUseItem22.getUseItem() : ItemStack.EMPTY).getItem() == ArphexModItems.GENESIS_RIFLE.get()
               && Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON) {
               setAngles(entity.getYRot(), (float)((double)entity.getXRot() + 0.5), (float)roll);
            }
         }
      }
   }
}
