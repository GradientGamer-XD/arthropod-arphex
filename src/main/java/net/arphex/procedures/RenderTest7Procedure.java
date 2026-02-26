package net.arphex.procedures;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexBuffer.Usage;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.mojang.math.Axis;
import javax.annotation.Nullable;
import net.arphex.entity.HomingSparkEntity;
import net.arphex.entity.SlowLookTestEntity;
import net.arphex.entity.TormentorLaserEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;

@EventBusSubscriber({Dist.CLIENT})
public class RenderTest7Procedure {
   private static BufferBuilder bufferBuilder = null;
   private static VertexBuffer vertexBuffer = null;
   private static Mode mode = null;
   private static VertexFormat format = null;
   private static PoseStack poseStack = null;
   private static Matrix4f projectionMatrix = null;
   private static boolean worldCoordinate = true;
   private static Vec3 offset = Vec3.ZERO;
   private static int currentStage = 0;
   private static int targetStage = 0;

   private static void add(double x, double y, double z, int color) {
      add(x, y, z, 0.0F, 0.0F, color);
   }

   private static void add(double x, double y, double z, float u, float v, int color) {
      if (bufferBuilder != null && bufferBuilder.building()) {
         if (format == DefaultVertexFormat.POSITION_COLOR) {
            bufferBuilder.vertex(x, y, z).color(color).endVertex();
         } else if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
            bufferBuilder.vertex(x, y, z).uv(u, v).color(color).endVertex();
         }
      }
   }

   private static boolean begin(Mode mode, VertexFormat format, boolean update) {
      if (bufferBuilder == null || !bufferBuilder.building()) {
         if (update) {
            clear();
         }

         if (vertexBuffer == null) {
            if (format == DefaultVertexFormat.POSITION_COLOR) {
               RenderTest7Procedure.mode = mode;
               RenderTest7Procedure.format = format;
               bufferBuilder = Tesselator.getInstance().getBuilder();
               bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_COLOR);
               return true;
            }

            if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
               RenderTest7Procedure.mode = mode;
               RenderTest7Procedure.format = format;
               bufferBuilder = Tesselator.getInstance().getBuilder();
               bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_TEX_COLOR);
               return true;
            }
         }
      }

      return false;
   }

   private static void clear() {
      if (vertexBuffer != null) {
         vertexBuffer.close();
         vertexBuffer = null;
      }
   }

   private static void end() {
      if (bufferBuilder != null && bufferBuilder.building()) {
         if (vertexBuffer != null) {
            vertexBuffer.close();
         }

         vertexBuffer = new VertexBuffer(Usage.STATIC);
         vertexBuffer.bind();
         vertexBuffer.upload(bufferBuilder.end());
         VertexBuffer.unbind();
      }
   }

   private static void offset(double x, double y, double z) {
      offset = new Vec3(x, y, z);
   }

   private static void release() {
      targetStage = 0;
   }

   private static VertexBuffer shape() {
      return vertexBuffer;
   }

   private static void system(boolean worldCoordinate) {
      RenderTest7Procedure.worldCoordinate = worldCoordinate;
   }

   private static boolean target(int targetStage) {
      if (targetStage == currentStage) {
         RenderTest7Procedure.targetStage = targetStage;
         return true;
      } else {
         return false;
      }
   }

   private static void renderShape(
      VertexBuffer vertexBuffer, double x, double y, double z, float yaw, float pitch, float roll, float xScale, float yScale, float zScale, int color
   ) {
      if (currentStage != 0 && currentStage == targetStage) {
         if (poseStack != null && projectionMatrix != null) {
            if (vertexBuffer != null) {
               float i;
               float j;
               float k;
               if (worldCoordinate) {
                  Vec3 pos = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
                  i = (float)(x - pos.x());
                  j = (float)(y - pos.y());
                  k = (float)(z - pos.z());
               } else {
                  i = (float)x;
                  j = (float)y;
                  k = (float)z;
               }

               poseStack.pushPose();
               poseStack.translate(i, j, k);
               poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
               poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
               poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
               poseStack.scale(xScale, yScale, zScale);
               poseStack.translate(offset.x(), offset.y(), offset.z());
               RenderSystem.setShaderColor(
                  (float)(color >> 16 & 0xFF) / 255.0F, (float)(color >> 8 & 0xFF) / 255.0F, (float)(color & 0xFF) / 255.0F, (float)(color >>> 24) / 255.0F
               );
               vertexBuffer.bind();
               vertexBuffer.drawWithShader(
                  poseStack.last().pose(),
                  projectionMatrix,
                  vertexBuffer.getFormat().hasUV(0) ? GameRenderer.getPositionTexColorShader() : GameRenderer.getPositionColorShader()
               );
               VertexBuffer.unbind();
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               poseStack.popPose();
            }
         }
      }
   }

   @SubscribeEvent
   public static void renderLevel(RenderLevelStageEvent event) {
      if (event.getStage() == Stage.AFTER_SKY) {
         currentStage = 1;
         RenderSystem.depthMask(false);
         renderShapes(event);
         RenderSystem.enableCull();
         RenderSystem.depthMask(true);
         currentStage = 0;
      } else if (event.getStage() == Stage.AFTER_PARTICLES) {
         currentStage = 2;
         RenderSystem.depthMask(true);
         renderShapes(event);
         RenderSystem.enableCull();
         RenderSystem.depthMask(true);
         currentStage = 0;
      }
   }

   private static void renderShapes(RenderLevelStageEvent event) {
      Minecraft minecraft = Minecraft.getInstance();
      ClientLevel level = minecraft.level;
      Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
      if (level != null && entity != null) {
         poseStack = event.getPoseStack();
         projectionMatrix = event.getProjectionMatrix();
         Vec3 pos = entity.getPosition(event.getPartialTick());
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         execute(event, level, pos.x(), pos.z(), entity);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableDepthTest();
      }
   }

   public static void execute(LevelAccessor world, double x, double z, Entity entity) {
      execute(null, world, x, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double z, Entity entity) {
      if (entity != null) {
         boolean entity_found = false;
         boolean disabled = false;
         double i = 0.0;
         double j = 0.0;
         double k = 0.0;
         double l = 0.0;
         double spheresize = 0.0;
         double col_r = 0.0;
         double col_g = 0.0;
         double col_b = 0.0;
         double negx = 0.0;
         double posx = 0.0;
         double negz = 0.0;
         double posz = 0.0;
         double stretch1 = 0.0;
         double stretch2 = 0.0;
         double pitch_variance = 0.0;
         double distance_scaling_factor = 0.0;
         double yaw_variance = 0.0;
         double convert_yaw = 0.0;
         double ringspan = 0.0;
         double raytrace_distance = 0.0;
         double newpositionz = 0.0;
         double newpositiony = 0.0;
         double ringspin = 0.0;
         double newpositionx = 0.0;
         double pitch_distance_variance = 0.0;
         double distance = 0.0;
         double yaw_distance_variance = 0.0;
         double expand = 0.0;
         double y_offset = 0.0;
         double xfind = 0.0;
         double yfind = 0.0;
         double zfind = 0.0;
         double opacity = 0.0;
         double expandsearch = 0.0;
         double distance_level = 0.0;
         double math_limit = 0.0;
         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, true)) {
               add(0.5, 0.0, -0.5, -1);
               add(0.5, 0.0, 0.5, -1);
               add(-0.5, 0.0, 0.5, -1);
               add(-0.5, 0.0, -0.5, -1);
               end();
            }

            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.disableCull();
            if (target(2)) {
               RenderSystem.defaultBlendFunc();
               math_limit = Math.floor(
                  100.0
                     - Math.abs(
                        ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .crawling_color_cycle
                              / 1.0
                           - 100.0
                     )
               );
               renderShape(
                  shape(),
                  x,
                  230.2,
                  z,
                  0.0F,
                  0.0F,
                  0.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  1677721600 | (int)(70.0 + math_limit) << 16 | 5120 | 0
               );
               renderShape(
                  shape(),
                  x,
                  120.2,
                  z,
                  0.0F,
                  0.0F,
                  0.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  1677721600 | (int)(70.0 + math_limit) << 16 | 0 | (int)(100.0 - math_limit)
               );
               renderShape(
                  shape(),
                  x,
                  60.2,
                  z,
                  0.0F,
                  0.0F,
                  0.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  Minecraft.getInstance().gameRenderer.getRenderDistance() * 2.0F,
                  -603979776 | (int)Math.floor(math_limit / 4.0) << 16 | (int)Math.floor(math_limit / 4.0) << 8 | (int)Math.floor(math_limit / 4.0)
               );
               release();
            }
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .laser_emitter_near
            > 0.0) {
            RenderSystem.disableCull();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            system(true);
            negx = -3.0;
            posx = 3.0;
            negz = -3.0;
            posz = 3.0;
            stretch1 = 0.0;
            pitch_distance_variance = 140.0;
            yaw_distance_variance = 40.0;
            distance_scaling_factor = 1.0;
            y_offset = 1.0;
            if (world instanceof ClientLevel) {
               for (Entity entityiterator : ((ClientLevel)world).entitiesForRendering()) {
                  if (entityiterator instanceof Player || entityiterator instanceof HomingSparkEntity) {
                     if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, false)) {
                        add(0.5, -0.5, -0.5, -6250336);
                        add(0.5, -0.5, 0.5, -6250336);
                        add(-0.5, -0.5, 0.5, -6250336);
                        add(-0.5, -0.5, -0.5, -6250336);
                        add(0.5, 0.5, 0.5, -1);
                        add(0.5, 0.5, -0.5, -1);
                        add(-0.5, 0.5, -0.5, -1);
                        add(-0.5, 0.5, 0.5, -1);
                        add(0.5, 0.5, -0.5, -2039584);
                        add(0.5, -0.5, -0.5, -2039584);
                        add(-0.5, -0.5, -0.5, -2039584);
                        add(-0.5, 0.5, -0.5, -2039584);
                        add(-0.5, 0.5, 0.5, -2039584);
                        add(-0.5, -0.5, 0.5, -2039584);
                        add(0.5, -0.5, 0.5, -2039584);
                        add(0.5, 0.5, 0.5, -2039584);
                        add(0.5, 0.5, 0.5, -4144960);
                        add(0.5, -0.5, 0.5, -4144960);
                        add(0.5, -0.5, -0.5, -4144960);
                        add(0.5, 0.5, -0.5, -4144960);
                        add(-0.5, 0.5, -0.5, -4144960);
                        add(-0.5, -0.5, -0.5, -4144960);
                        add(-0.5, -0.5, 0.5, -4144960);
                        add(-0.5, 0.5, 0.5, -4144960);
                        end();
                     }

                     if (entityiterator instanceof HomingSparkEntity) {
                        if (target(2)) {
                           RenderSystem.defaultBlendFunc();
                           RenderSystem.enableCull();
                           renderShape(
                              shape(),
                              entityiterator.getX(),
                              entityiterator.getY() + 400.0,
                              entityiterator.getZ(),
                              0.0F,
                              0.0F,
                              0.0F,
                              (float)Math.max(0.3, Math.min(0.3 + (double)(entityiterator.tickCount / 20), 1.2)),
                              1500.0F,
                              (float)Math.max(0.3, Math.min(0.3 + (double)(entityiterator.tickCount / 20), 1.2)),
                              Math.min(entityiterator.tickCount * 5, 240) << 24 | 10485760 | 40960 | 0xFF
                           );
                           release();
                        }
                     } else if ((entityiterator instanceof LivingEntity _entUseItem100 ? _entUseItem100.getUseItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.VISIONARY_SPEAR.get()
                        && target(2)) {
                        RenderSystem.defaultBlendFunc();
                        RenderSystem.disableCull();
                        renderShape(
                           shape(), entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 0.0F, 0.0F, 0.0F, 18.0F, 18.0F, 18.0F, 587253840
                        );
                        release();
                     }
                  }

                  if (entityiterator instanceof SlowLookTestEntity
                     || entityiterator instanceof TormentorLaserEntity
                     || entityiterator instanceof Player
                        && (entityiterator instanceof LivingEntity _entUseItem114 ? _entUseItem114.getUseItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.OBLIVION_RAY.get()) {
                     distance = Math.sqrt(
                        (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                           + (entity.getY() - (entityiterator.getY() + y_offset)) * (entity.getY() - (entityiterator.getY() + y_offset))
                           + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                     );
                     if (entityiterator instanceof TormentorLaserEntity) {
                        RenderSystem.disableCull();
                        if (distance > 170.0) {
                           RenderSystem.enableDepthTest();
                        } else {
                           RenderSystem.disableDepthTest();
                        }
                     }

                     opacity = 200.0;
                     if ((entityiterator instanceof LivingEntity _entUseItem132 ? _entUseItem132.getUseItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.OBLIVION_RAY.get()) {
                        opacity = entity instanceof LivingEntity _entUseTicks134 ? (double)_entUseTicks134.getTicksUsingItem() : 0.0;
                     }

                     spheresize = 1.0;
                     pitch_variance = pitch_distance_variance / (distance / 0.7);
                     yaw_variance = yaw_distance_variance / (distance / 2.0);
                     if (!(entityiterator instanceof TormentorLaserEntity) && !(entityiterator instanceof SlowLookTestEntity)) {
                        xfind = (double)entityiterator.level()
                           .clip(
                              new ClipContext(
                                 entityiterator.getEyePosition(1.0F),
                                 entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(100.0)),
                                 Block.COLLIDER,
                                 Fluid.NONE,
                                 entityiterator
                              )
                           )
                           .getBlockPos()
                           .getX();
                        yfind = (double)entityiterator.level()
                           .clip(
                              new ClipContext(
                                 entityiterator.getEyePosition(1.0F),
                                 entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(100.0)),
                                 Block.COLLIDER,
                                 Fluid.NONE,
                                 entityiterator
                              )
                           )
                           .getBlockPos()
                           .getY();
                        zfind = (double)entityiterator.level()
                           .clip(
                              new ClipContext(
                                 entityiterator.getEyePosition(1.0F),
                                 entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(100.0)),
                                 Block.COLLIDER,
                                 Fluid.NONE,
                                 entityiterator
                              )
                           )
                           .getBlockPos()
                           .getZ();
                     } else {
                        xfind = (double)entityiterator.level()
                           .clip(
                              new ClipContext(
                                 entityiterator.getEyePosition(1.0F),
                                 entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(300.0)),
                                 Block.COLLIDER,
                                 Fluid.NONE,
                                 entityiterator
                              )
                           )
                           .getBlockPos()
                           .getX();
                        yfind = (double)entityiterator.level()
                           .clip(
                              new ClipContext(
                                 entityiterator.getEyePosition(1.0F),
                                 entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(300.0)),
                                 Block.COLLIDER,
                                 Fluid.NONE,
                                 entityiterator
                              )
                           )
                           .getBlockPos()
                           .getY();
                        zfind = (double)entityiterator.level()
                           .clip(
                              new ClipContext(
                                 entityiterator.getEyePosition(1.0F),
                                 entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(300.0)),
                                 Block.COLLIDER,
                                 Fluid.NONE,
                                 entityiterator
                              )
                           )
                           .getBlockPos()
                           .getZ();
                     }

                     expand = Math.sqrt(
                           (xfind - entityiterator.getX()) * (xfind - entityiterator.getX())
                              + (yfind - (entityiterator.getY() + y_offset)) * (yfind - (entityiterator.getY() + y_offset))
                              + (zfind - entityiterator.getZ()) * (zfind - entityiterator.getZ())
                        )
                        + 2.0;
                     stretch2 = 0.0 - expand;
                     if (entityiterator instanceof TormentorLaserEntity) {
                        spheresize = Mth.nextDouble(
                              RandomSource.create(),
                              entityiterator instanceof TormentorLaserEntity _datEntIx
                                 ? (double)((Integer)_datEntIx.getEntityData().get(TormentorLaserEntity.DATA_growspawn)).intValue()
                                 : 0.0,
                              entityiterator instanceof TormentorLaserEntity _datEntI
                                 ? (double)((Integer)_datEntI.getEntityData().get(TormentorLaserEntity.DATA_growspawn)).intValue()
                                 : 0.0
                           )
                           / 10.0;
                        stretch2 = (0.0 - expand) / 5.0;
                        if ((
                              entityiterator instanceof TormentorLaserEntity _datEntIxx
                                 ? (Integer)_datEntIxx.getEntityData().get(TormentorLaserEntity.DATA_timer)
                                 : 0
                           )
                           > 30) {
                           RenderSystem.defaultBlendFunc();
                           opacity = 30.0;
                           col_r = 200.0;
                           col_g = 20.0;
                           col_b = 20.0;
                        } else {
                           RenderSystem.defaultBlendFunc();
                           opacity = 80.0;
                           col_r = 230.0;
                           col_g = 100.0;
                           col_b = 100.0;
                        }
                     } else {
                        col_r = 255.0;
                        col_g = 120.0;
                        col_b = 120.0;
                        if ("1.20.1".startsWith("1.19.")) {
                           RenderSystem.blendFuncSeparate(
                              SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA
                           );
                        } else {
                           RenderSystem.blendFuncSeparate(SourceFactor.DST_COLOR, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
                        }
                     }

                     if (entityiterator instanceof SlowLookTestEntity) {
                        if (entityiterator.tickCount > 260) {
                           opacity = (double)Math.max(80 - Math.abs(260 - entityiterator.tickCount), 1);
                        } else {
                           opacity = (double)Math.min((float)entityiterator.tickCount / 2.0F, 80.0F);
                        }

                        if ((
                              entityiterator instanceof SlowLookTestEntity _datEntI
                                 ? (Integer)_datEntI.getEntityData().get(SlowLookTestEntity.DATA_laser_switch_time)
                                 : 0
                           )
                           > 40) {
                           col_g = 0.0;
                           col_b = 0.0;
                        } else {
                           if (opacity >= 79.0) {
                              opacity = 200.0;
                           }

                           col_g = 120.0;
                           col_b = 120.0;
                           posx = 10.0;
                           negx = -10.0;
                           negz = -10.0;
                           posz = 10.0;
                        }

                        RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
                     }

                     if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, true)) {
                        add(posx, stretch2, negz, -1);
                        add(posx, stretch2, posz, -1);
                        add(negx, stretch2, posz, -1);
                        add(negx, stretch2, negz, -1);
                        add(0.5, stretch1, 0.5, -1);
                        add(0.5, stretch1, -0.5, -1);
                        add(-0.5, stretch1, -0.5, -1);
                        add(-0.5, stretch1, 0.5, -1);
                        add(0.5, stretch1, -0.5, -1);
                        add(posx, stretch2, negz, -1);
                        add(negx, stretch2, negz, -1);
                        add(-0.5, stretch1, -0.5, -1);
                        add(-0.5, stretch1, 0.5, -1);
                        add(negx, stretch2, posz, -1);
                        add(posx, stretch2, posz, -1);
                        add(0.5, stretch1, 0.5, -1);
                        add(0.5, stretch1, 0.5, -1);
                        add(posx, stretch2, posz, -1);
                        add(posx, stretch2, negz, -1);
                        add(0.5, stretch1, -0.5, -1);
                        add(-0.5, stretch1, -0.5, -1);
                        add(negx, stretch2, negz, -1);
                        add(negx, stretch2, posz, -1);
                        add(-0.5, stretch1, 0.5, -1);
                        end();
                     }

                     if (target(2)) {
                        renderShape(
                           shape(),
                           entityiterator.getX(),
                           entityiterator.getY() + y_offset,
                           entityiterator.getZ(),
                           entityiterator.getYRot(),
                           entityiterator.getXRot() - 90.0F,
                           0.0F,
                           (float)spheresize,
                           (float)spheresize,
                           (float)spheresize,
                           (int)opacity << 24 | (int)col_r << 16 | (int)col_g << 8 | (int)col_b
                        );
                        release();
                     }
                  }
               }
            }
         }
      }
   }
}
