package net.arphex.procedures;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import javax.annotation.Nullable;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent.ComputeFogColor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class WorldRenderTest3Procedure {
   public static ComputeFogColor provider = null;

   public static void setColor(int color) {
      provider.setRed((float)(color >> 16 & 0xFF) / 255.0F);
      provider.setGreen((float)(color >> 8 & 0xFF) / 255.0F);
      provider.setBlue((float)(color & 0xFF) / 255.0F);
   }

   public static void setColor(float level, int color) {
      if (!(level <= 0.0F)) {
         if (level >= 1.0F) {
            provider.setRed((float)(color >> 16 & 0xFF) / 255.0F);
            provider.setGreen((float)(color >> 8 & 0xFF) / 255.0F);
            provider.setBlue((float)(color & 0xFF) / 255.0F);
         } else {
            level = Mth.clamp(level, 0.0F, 1.0F);
            provider.setRed(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getRed(), 0.0F, 1.0F), (float)(color >> 16 & 0xFF) / 255.0F), 0.0F, 1.0F));
            provider.setGreen(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getGreen(), 0.0F, 1.0F), (float)(color >> 8 & 0xFF) / 255.0F), 0.0F, 1.0F));
            provider.setBlue(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getBlue(), 0.0F, 1.0F), (float)(color & 0xFF) / 255.0F), 0.0F, 1.0F));
         }
      }
   }

   @SubscribeEvent
   public static void computeFogColor(ComputeFogColor event) {
      provider = event;
      ClientLevel level = Minecraft.getInstance().level;
      Entity entity = provider.getCamera().getEntity();
      if (level != null && entity != null) {
         Vec3 entPos = entity.getPosition((float)provider.getPartialTick());
         execute(provider, level.dimension(), entity);
      }
   }

   public static void execute(ResourceKey<Level> dimension, Entity entity) {
      execute(null, dimension, entity);
   }

   private static void execute(@Nullable Event event, ResourceKey<Level> dimension, Entity entity) {
      if (dimension != null && entity != null) {
         if ((Boolean)ConfigurationSettingsConfiguration.SPECIAL_TORMENTOR_RENDERING.get()
            && dimension == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity.getY() < 60.0) {
               RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
               setColor(100.0F, -13499131);
            } else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get())) {
               setColor(80.0F, -10197916);
            }
         }
      }
   }
}
