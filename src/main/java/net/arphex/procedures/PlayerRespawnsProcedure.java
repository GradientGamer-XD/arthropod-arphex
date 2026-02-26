package net.arphex.procedures;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerRespawnsProcedure {
   @SubscribeEvent
   public static void onPlayerRespawned(PlayerRespawnEvent event) {
      execute(event, event.getEntity().level(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute(null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            double var10001;
            label101: {
               if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                  var10001 = (double)(
                     _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                        ? _player.getRespawnPosition().getX()
                        : _player.level().getLevelData().getXSpawn()
                  );
                  break label101;
               }

               var10001 = 0.0;
            }

            double var10002;
            label91: {
               if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                  var10002 = (double)(
                     _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                        ? _player.getRespawnPosition().getY()
                        : _player.level().getLevelData().getYSpawn()
                  );
                  break label91;
               }

               var10002 = 0.0;
            }

            double var10003;
            label81: {
               if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                  var10003 = (double)(
                     _player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null
                        ? _player.getRespawnPosition().getZ()
                        : _player.level().getLevelData().getZSpawn()
                  );
                  break label81;
               }

               var10003 = 0.0;
            }

            if (!world.getBlockState(BlockPos.containing(var10001, var10002, var10003)).is(BlockTags.create(new ResourceLocation("minecraft:beds")))) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§cYour crawling dimension bed was missing"), true);
               }

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

               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.setRespawnPosition(
                     _serverPlayer.level().dimension(),
                     new BlockPos(world.getLevelData().getXSpawn(), world.getLevelData().getYSpawn(), world.getLevelData().getZSpawn()),
                     _serverPlayer.getYRot(),
                     true,
                     false
                  );
               }

               entity.teleportTo((double)world.getLevelData().getXSpawn(), (double)world.getLevelData().getYSpawn(), (double)world.getLevelData().getZSpawn());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(
                        (double)world.getLevelData().getXSpawn(),
                        (double)world.getLevelData().getYSpawn(),
                        (double)world.getLevelData().getZSpawn(),
                        entity.getYRot(),
                        entity.getXRot()
                     );
               }
            }
         }
      }
   }
}
