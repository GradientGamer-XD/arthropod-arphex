package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class PlayerSleepsProcedure {
   @SubscribeEvent
   public static void onPlayerInBed(PlayerSleepInBedEvent event) {
      execute(event, event.getEntity().level(), (double)event.getPos().getX(), (double)event.getPos().getY(), (double)event.getPos().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0
            && 400.0
               > Math.sqrt(
                     (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                           * (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                        + (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                           * (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                        + (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                           * (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                  )
                  / 2.0) {
            boolean _setval = true;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.show_tormentor_overlay = _setval;
               capability.syncPlayerVariables(entity);
            });
            ArphexMod.queueServerWork(
               20,
               () -> {
                  if (world instanceof Level _level) {
                     if (!_level.isClientSide()) {
                        _level.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:horrorcrash")),
                           SoundSource.HOSTILE,
                           0.3F,
                           0.3F
                        );
                     } else {
                        _level.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:horrorcrash")),
                           SoundSource.HOSTILE,
                           0.3F,
                           0.3F,
                           false
                        );
                     }
                  }

                  boolean _setvalx = true;
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.show_tormentor_overlay = _setvalx;
                     capability.syncPlayerVariables(entity);
                  });
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 0.0F);
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("The TORMENTOR is nearby, preventing you from sleeping"), true);
                  }
               }
            );
         }
      }
   }
}
