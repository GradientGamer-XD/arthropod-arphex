package net.arphex.procedures;

import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.ArachnoidShadowCloneEntity;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.MothShadowCloneEntity;
import net.arphex.entity.SpiderFunnelEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EntitySpawnsProcedure {
   @SubscribeEvent
   public static void onEntitySpawned(EntityJoinLevelEvent event) {
      execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof TORMENTOREntity
            && !(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")) {
            for (String stringiterator : (List)ConfigurationSettingsConfiguration.DISABLE_SPECIFIC_MOBS.get()) {
               if (stringiterator.replace("arphex:", "")
                  .strip()
                  .equals(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().replace("arphex:", "").strip())) {
                  if (event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }

                  if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).isEmpty()) {
                     Entity var12 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (var12 instanceof Player) {
                        Player _player = (Player)var12;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("This mob has been disabled in ArPhEx config"), true);
                        }
                     }
                  }
               }
            }
         }

         if (entity instanceof SpiderFunnelEntity) {
            if (entity instanceof SpiderFunnelEntity) {
               ((SpiderFunnelEntity)entity).setAnimation("animation.spiderfunnel.spawn");
            }

            ArphexMod.queueServerWork(1, () -> {
               if (entity instanceof SpiderFunnelEntity) {
                  ((SpiderFunnelEntity)entity).setAnimation("animation.spiderfunnel.spawn");
               }
            });
         }

         if (entity instanceof MothShadowCloneEntity
            && world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof ArachnoidShadowCloneEntity
            && world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }
      }
   }
}
