package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent.ComputeFov;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class RenderTest4Procedure {
   public static ComputeFov provider = null;

   public static void setFOV(double fov) {
      provider.setFOV(fov);
   }

   @SubscribeEvent
   public static void computeFOV(ComputeFov event) {
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
         boolean upside_down_mode = false;
         if (upside_down_mode) {
            setFOV(200.0);
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .fov_smoothen
            > 0.0) {
            setFOV(
               (double)((Integer)Minecraft.getInstance().options.fov().get()).intValue()
                  - ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .fov_smoothen
            );
         }

         if ((entity instanceof LivingEntity _entUseItem3 ? _entUseItem3.getUseItem() : ItemStack.EMPTY).getItem() == ArphexModItems.GENESIS_RIFLE.get()) {
            if ((Integer)Minecraft.getInstance().options.fov().get() > 50) {
               if ((entity instanceof LivingEntity _entUseTicks6 ? _entUseTicks6.getTicksUsingItem() : 0) > 10) {
                  setFOV((double)((Integer)Minecraft.getInstance().options.fov().get() - 40));
               } else {
                  setFOV(
                     (double)(
                        (Integer)Minecraft.getInstance().options.fov().get()
                           - (entity instanceof LivingEntity _entUseTicks10 ? _entUseTicks10.getTicksUsingItem() : 0) * 4
                     )
                  );
               }
            } else if ((entity instanceof LivingEntity _entUseTicks12 ? _entUseTicks12.getTicksUsingItem() : 0) > 10) {
               setFOV((double)((Integer)Minecraft.getInstance().options.fov().get() - 20));
            } else {
               setFOV(
                  (double)(
                     (Integer)Minecraft.getInstance().options.fov().get()
                        - (entity instanceof LivingEntity _entUseTicks16 ? _entUseTicks16.getTicksUsingItem() : 0) * 2
                  )
               );
            }
         }
      }
   }
}
