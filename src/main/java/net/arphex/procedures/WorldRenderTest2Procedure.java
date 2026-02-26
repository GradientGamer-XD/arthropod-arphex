package net.arphex.procedures;

import com.mojang.blaze3d.shaders.FogShape;
import javax.annotation.Nullable;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent.RenderFog;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class WorldRenderTest2Procedure {
   public static RenderFog provider = null;

   public static void setDistance(float start, float end) {
      provider.setNearPlaneDistance(start);
      provider.setFarPlaneDistance(end);
      if (!provider.isCanceled()) {
         provider.setCanceled(true);
      }
   }

   public static void setShape(FogShape shape) {
      provider.setFogShape(shape);
      if (!provider.isCanceled()) {
         provider.setCanceled(true);
      }
   }

   @SubscribeEvent
   public static void renderFog(RenderFog event) {
      provider = event;
      if (provider.getMode() == FogMode.FOG_TERRAIN) {
         ClientLevel level = Minecraft.getInstance().level;
         Entity entity = provider.getCamera().getEntity();
         if (level != null && entity != null) {
            Vec3 pos = entity.getPosition((float)provider.getPartialTick());
            execute(provider, level, level.dimension(), entity);
         }
      }
   }

   public static void execute(LevelAccessor world, ResourceKey<Level> dimension, Entity entity) {
      execute(null, world, dimension, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, ResourceKey<Level> dimension, Entity entity) {
      if (dimension != null && entity != null) {
         boolean thunder_test = false;
         double distance = 0.0;
         double torfog_stages = 0.0;
         if ((Boolean)ConfigurationSettingsConfiguration.SPECIAL_TORMENTOR_RENDERING.get()) {
            if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0) {
               if (ArphexModVariables.MapVariables.get(world)
                  .tormentor_target_dimension
                  .equals(
                     ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .player_dimension
                  )) {
                  distance = Math.sqrt(
                     (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                           * (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                        + (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                           * (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                        + (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                           * (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                  );
                  if (distance > 1200.0) {
                     torfog_stages = 0.0;
                  } else if (distance > 700.0) {
                     torfog_stages = 100.0 * (1.0 - (distance - 700.0) / 500.0);
                  } else {
                     torfog_stages = 100.0;
                  }

                  setDistance(
                     (float)((double)Minecraft.getInstance().gameRenderer.getRenderDistance() + torfog_stages),
                     Minecraft.getInstance().gameRenderer.getRenderDistance() + 200.0F
                  );
               }
            } else if (dimension == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
               if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get())) {
                  int var10000;
                  label56: {
                     if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get()).getDuration();
                        break label56;
                     }

                     var10000 = 0;
                  }

                  if (var10000 > 147) {
                     setDistance(7.0F, 75.0F);
                  } else {
                     int var10001;
                     label50: {
                        if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get())) {
                           var10001 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get()).getDuration();
                           break label50;
                        }

                        var10001 = 0;
                     }

                     int var10002;
                     label45: {
                        var15 = (float)(157 - var10001);
                        if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get())) {
                           var10002 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get()).getDuration();
                           break label45;
                        }

                        var10002 = 0;
                     }

                     setDistance(var15, (float)(225 - var10002));
                  }

                  return;
               }

               if (entity.getY() < 60.0) {
                  setDistance(Math.abs(entity.getXRot() * 3.0F) + 70.0F, Math.abs(entity.getXRot() * 3.0F + 75.0F) + 70.0F);
               }
            }
         }
      }
   }
}
