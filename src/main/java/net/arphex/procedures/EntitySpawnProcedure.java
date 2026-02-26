package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.DraconFireEntity;
import net.arphex.entity.WebHookEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntitySpawnProcedure {
   @SubscribeEvent
   public static void onEntitySpawned(EntityJoinLevelEvent event) {
      execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof WebbedArrowEntity) {
            ArphexMod.queueServerWork(1200, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity instanceof WebHookEntity) {
            ArphexMod.queueServerWork(300, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity instanceof DraconFireEntity) {
            entity.teleportTo(x, y + 2.0, z);
            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.connection.teleport(x, y + 2.0, z, entity.getYRot(), entity.getXRot());
            }
         }
      }
   }
}
