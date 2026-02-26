package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SpiderMothDwellerEntityVisualScaleProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static double execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      return execute(null, world, x, y, z, entity);
   }

   private static double execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double mobsize = 0.0;
         if (entity instanceof SpiderMothEntity) {
            if (entity.getDisplayName().getString().equals("Monstrous Spider Moth")) {
               mobsize = 2.0;
            } else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()) {
               if (((ArphexModVariables.PlayerVariables)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .ShowOverlay
                  .equals("true")) {
                  mobsize = 1.7;
               } else if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
                  && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))
                  && world.isEmptyBlock(BlockPos.containing(x, y + 3.0, z))
                  && world.isEmptyBlock(BlockPos.containing(x, y + 4.0, z))) {
                  mobsize = entity.getPersistentData().getDouble("enbeetee");
               } else {
                  mobsize = 1.5;
               }
            } else if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y + 3.0, z))
               && world.isEmptyBlock(BlockPos.containing(x, y + 4.0, z))) {
               mobsize = entity.getPersistentData().getDouble("enbeetee");
            } else {
               mobsize = 1.5;
            }
         }

         return mobsize;
      }
   }
}
