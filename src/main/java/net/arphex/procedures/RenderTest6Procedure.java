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
import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.AscendSphereAnimEntity;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TormentorHitboxEntity;
import net.arphex.entity.TormentorMothSummonEntity;
import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;

@EventBusSubscriber({Dist.CLIENT})
public class RenderTest6Procedure {
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
               RenderTest6Procedure.mode = mode;
               RenderTest6Procedure.format = format;
               bufferBuilder = Tesselator.getInstance().getBuilder();
               bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_COLOR);
               return true;
            }

            if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
               RenderTest6Procedure.mode = mode;
               RenderTest6Procedure.format = format;
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
      RenderTest6Procedure.worldCoordinate = worldCoordinate;
   }

   private static boolean target(int targetStage) {
      if (targetStage == currentStage) {
         RenderTest6Procedure.targetStage = targetStage;
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
         execute(event, level, pos.x(), pos.y(), pos.z(), entity);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableDepthTest();
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack warp_wayfinder = ItemStack.EMPTY;
         Entity render_entity = null;
         double i = 0.0;
         double j = 0.0;
         double k = 0.0;
         double l = 0.0;
         double spheresize = 0.0;
         double col_r = 0.0;
         double col_g = 0.0;
         double col_b = 0.0;
         double tormentor_distance = 0.0;
         double rotation_from_tormentor = 0.0;
         double opacity = 0.0;
         double distance = 0.0;
         double max_entities = 0.0;
         double xcalc = 0.0;
         double dist_to_rendered = 0.0;
         double ycalc = 0.0;
         double colg = 0.0;
         double zcalc = 0.0;
         double colr = 0.0;
         double colb = 0.0;
         double dists = 0.0;
         double sphere_gradient = 0.0;
         double tier_multiply = 0.0;
         double true_dists = 0.0;
         double dropoff = 0.0;
         double sphere_num = 0.0;
         double asc_sphere_x = 0.0;
         double asc_sphere_y = 0.0;
         double asc_sphere_z = 0.0;
         if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, true)) {
            for (int index0 = 0; index0 < 90; index0++) {
               for (int index1 = 0; index1 < 45; index1++) {
                  k = 255.0 - j / 180.0 * 95.0;
                  l = 255.0 - (j + 4.0) / 180.0 * 95.0;
                  add(
                     Math.sin(Math.toRadians(i)) * Math.sin(Math.toRadians(j)) * 0.5,
                     Math.cos(Math.toRadians(j)) * 0.5,
                     Math.cos(Math.toRadians(i)) * Math.sin(Math.toRadians(j)) * 0.5,
                     0xFF000000 | (int)k << 16 | (int)k << 8 | (int)k
                  );
                  add(
                     Math.sin(Math.toRadians(i)) * Math.sin(Math.toRadians(j + 4.0)) * 0.5,
                     Math.cos(Math.toRadians(j + 4.0)) * 0.5,
                     Math.cos(Math.toRadians(i)) * Math.sin(Math.toRadians(j + 4.0)) * 0.5,
                     0xFF000000 | (int)l << 16 | (int)l << 8 | (int)l
                  );
                  add(
                     Math.sin(Math.toRadians(i + 4.0)) * Math.sin(Math.toRadians(j + 4.0)) * 0.5,
                     Math.cos(Math.toRadians(j + 4.0)) * 0.5,
                     Math.cos(Math.toRadians(i + 4.0)) * Math.sin(Math.toRadians(j + 4.0)) * 0.5,
                     0xFF000000 | (int)l << 16 | (int)l << 8 | (int)l
                  );
                  add(
                     Math.sin(Math.toRadians(i + 4.0)) * Math.sin(Math.toRadians(j)) * 0.5,
                     Math.cos(Math.toRadians(j)) * 0.5,
                     Math.cos(Math.toRadians(i + 4.0)) * Math.sin(Math.toRadians(j)) * 0.5,
                     0xFF000000 | (int)k << 16 | (int)k << 8 | (int)k
                  );
                  j += 4.0;
               }

               j = 0.0;
               i += 4.0;
            }

            i = 0.0;
            end();
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("warp_wayfinder_check")
            || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("warp_wayfinder_check")) {
            if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("warp_wayfinder_check")) {
               warp_wayfinder = entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY;
            } else {
               warp_wayfinder = entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY;
            }

            RenderSystem.disableCull();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            if ((
                  warp_wayfinder.getOrCreateTag().getDouble("target_1_x") != 0.0
                     || warp_wayfinder.getOrCreateTag().getDouble("target_1_y") != 0.0
                     || warp_wayfinder.getOrCreateTag().getDouble("target_1_z") != 0.0
               )
               && warp_wayfinder.getOrCreateTag()
                  .getString("target_1_dimension")
                  .equals(
                     (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                        + ""
                  )) {
               dists = Math.sqrt(
                  (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_1_x"))
                        * (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_1_x"))
                     + (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_1_y"))
                        * (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_1_y"))
                     + (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_1_z"))
                        * (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_1_z"))
               );
               xcalc = x
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_1_x") - x)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               ycalc = y
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_1_y") - y)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               zcalc = z
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_1_z") - z)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               dist_to_rendered = Math.sqrt(
                  (entity.getX() - xcalc) * (entity.getX() - xcalc)
                     + (entity.getY() - ycalc) * (entity.getY() - ycalc)
                     + (entity.getZ() - zcalc) * (entity.getZ() - zcalc)
               );
               if (dist_to_rendered > dists) {
                  if (target(2)) {
                     renderShape(
                        shape(),
                        warp_wayfinder.getOrCreateTag().getDouble("target_1_x") + 0.5,
                        warp_wayfinder.getOrCreateTag().getDouble("target_1_y") + 0.5,
                        warp_wayfinder.getOrCreateTag().getDouble("target_1_z") + 0.5,
                        0.0F,
                        0.0F,
                        0.0F,
                        1.0F,
                        200.0F,
                        1.0F,
                        1694121020
                     );
                     release();
                  }
               } else if (target(2)) {
                  renderShape(shape(), xcalc + 0.5, ycalc + 0.5, zcalc + 0.5, 0.0F, 0.0F, 0.0F, 1.0F, 200.0F, 1.0F, 1694121020);
                  release();
               }
            }

            if ((
                  warp_wayfinder.getOrCreateTag().getDouble("target_2_x") != 0.0
                     || warp_wayfinder.getOrCreateTag().getDouble("target_2_y") != 0.0
                     || warp_wayfinder.getOrCreateTag().getDouble("target_2_z") != 0.0
               )
               && warp_wayfinder.getOrCreateTag()
                  .getString("target_2_dimension")
                  .equals(
                     (
                           world instanceof Level _lvlx
                              ? _lvlx.dimension()
                              : (world instanceof WorldGenLevel _wglx ? _wglx.getLevel().dimension() : Level.OVERWORLD)
                        )
                        + ""
                  )) {
               dists = Math.sqrt(
                  (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_2_x"))
                        * (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_2_x"))
                     + (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_2_y"))
                        * (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_2_y"))
                     + (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_2_z"))
                        * (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_2_z"))
               );
               xcalc = x
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_2_x") - x)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               ycalc = y
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_2_y") - y)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               zcalc = z
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_2_z") - z)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               dist_to_rendered = Math.sqrt(
                  (entity.getX() - xcalc) * (entity.getX() - xcalc)
                     + (entity.getY() - ycalc) * (entity.getY() - ycalc)
                     + (entity.getZ() - zcalc) * (entity.getZ() - zcalc)
               );
               if (dist_to_rendered > dists) {
                  if (target(2)) {
                     renderShape(
                        shape(),
                        warp_wayfinder.getOrCreateTag().getDouble("target_2_x") + 0.5,
                        warp_wayfinder.getOrCreateTag().getDouble("target_2_y") + 0.5,
                        warp_wayfinder.getOrCreateTag().getDouble("target_2_z") + 0.5,
                        0.0F,
                        0.0F,
                        0.0F,
                        1.0F,
                        200.0F,
                        1.0F,
                        1681717820
                     );
                     release();
                  }
               } else if (target(2)) {
                  renderShape(shape(), xcalc + 0.5, ycalc + 0.5, zcalc + 0.5, 0.0F, 0.0F, 0.0F, 1.0F, 200.0F, 1.0F, 1681717820);
                  release();
               }
            }

            if ((
                  warp_wayfinder.getOrCreateTag().getDouble("target_3_x") != 0.0
                     || warp_wayfinder.getOrCreateTag().getDouble("target_3_y") != 0.0
                     || warp_wayfinder.getOrCreateTag().getDouble("target_3_z") != 0.0
               )
               && warp_wayfinder.getOrCreateTag()
                  .getString("target_3_dimension")
                  .equals(
                     (
                           world instanceof Level _lvlxx
                              ? _lvlxx.dimension()
                              : (world instanceof WorldGenLevel _wglxx ? _wglxx.getLevel().dimension() : Level.OVERWORLD)
                        )
                        + ""
                  )) {
               dists = Math.sqrt(
                  (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_3_x"))
                        * (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_3_x"))
                     + (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_3_y"))
                        * (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_3_y"))
                     + (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_3_z"))
                        * (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_3_z"))
               );
               xcalc = x
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_3_x") - x)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               ycalc = y
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_3_y") - y)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               zcalc = z
                  + (warp_wayfinder.getOrCreateTag().getDouble("target_3_z") - z)
                     / dists
                     * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
               dist_to_rendered = Math.sqrt(
                  (entity.getX() - xcalc) * (entity.getX() - xcalc)
                     + (entity.getY() - ycalc) * (entity.getY() - ycalc)
                     + (entity.getZ() - zcalc) * (entity.getZ() - zcalc)
               );
               if (dist_to_rendered > dists) {
                  if (target(2)) {
                     renderShape(
                        shape(),
                        warp_wayfinder.getOrCreateTag().getDouble("target_3_x") + 0.5,
                        warp_wayfinder.getOrCreateTag().getDouble("target_3_y") + 0.5,
                        warp_wayfinder.getOrCreateTag().getDouble("target_3_z") + 0.5,
                        0.0F,
                        0.0F,
                        0.0F,
                        1.0F,
                        200.0F,
                        1.0F,
                        1681669370
                     );
                     release();
                  }
               } else if (target(2)) {
                  renderShape(shape(), xcalc + 0.5, ycalc + 0.5, zcalc + 0.5, 0.0F, 0.0F, 0.0F, 1.0F, 200.0F, 1.0F, 1681669370);
                  release();
               }
            }
         }

         label606: {
            if (!(
                  ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .sphere_near
                     > 0.0
               )
               && !(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)
               && !(
                  ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .tormentorjustdiednearby
                     > 0.0
               )) {
               int var192;
               label528: {
                  if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get())) {
                     var192 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get()).getAmplifier();
                     break label528;
                  }

                  var192 = 0;
               }

               if (var192 < 9) {
                  break label606;
               }
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .tormentorjustdiednearby
               > 0.0) {
               RenderSystem.disableDepthTest();
               RenderSystem.depthMask(false);
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof ItemEntity
                     && (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()
                     && target(2)) {
                     renderShape(
                        shape(),
                        entityiterator.getX(),
                        entityiterator.getY(),
                        entityiterator.getZ(),
                        0.0F,
                        0.0F,
                        0.0F,
                        6.0F,
                        6.0F,
                        6.0F,
                        (int)(100.0 - rotation_from_tormentor * 0.86) << 24 | 0xFF0000 | 12800 | 50
                     );
                     release();
                  }
               }
            }

            if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0
               && ArphexModVariables.MapVariables.get(world)
                  .tormentor_target_dimension
                  .equals((entity.level().dimension() + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip())
               && !(
                  ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .tormentor_render
                     > 0.0
               )) {
               tormentor_distance = Math.sqrt(
                  (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                        * (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                     + (entity.getY() + 1.0 - (ArphexModVariables.MapVariables.get(world).tormentor_y + 4.0))
                        * (entity.getY() + 1.0 - (ArphexModVariables.MapVariables.get(world).tormentor_y + 4.0))
                     + (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                        * (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
               );
               RenderSystem.disableDepthTest();
               RenderSystem.depthMask(false);
               if (tormentor_distance < 1000.0 && target(2)) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(125.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorx instanceof TormentorMothSummonEntity) {
                        renderShape(
                           shape(),
                           entityiteratorx.getX(),
                           entityiteratorx.getY() + 4.0,
                           entityiteratorx.getZ(),
                           0.0F,
                           0.0F,
                           0.0F,
                           10.0F,
                           10.0F,
                           10.0F,
                           1681666650
                        );
                     }

                     if (entityiteratorx instanceof TormentorScorpioidSummonEntity) {
                        renderShape(
                           shape(),
                           entityiteratorx.getX(),
                           entityiteratorx.getY() + 2.0,
                           entityiteratorx.getZ(),
                           0.0F,
                           0.0F,
                           0.0F,
                           5.0F,
                           5.0F,
                           5.0F,
                           1684288050
                        );
                     }

                     if (entityiteratorx instanceof TormentorVoidlasherSummonEntity) {
                        renderShape(
                           shape(),
                           entityiteratorx.getX(),
                           entityiteratorx.getY() + 2.0,
                           entityiteratorx.getZ(),
                           0.0F,
                           0.0F,
                           0.0F,
                           5.0F,
                           5.0F,
                           5.0F,
                           1685586040
                        );
                     }
                  }

                  release();
               }

               if ((Boolean)ConfigurationSettingsConfiguration.SPECIAL_TORMENTOR_RENDERING.get() && target(1)) {
                  dists = Math.sqrt(
                     (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                           * (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                        + (entity.getY() - (ArphexModVariables.MapVariables.get(world).tormentor_y + 200.0))
                           * (entity.getY() - (ArphexModVariables.MapVariables.get(world).tormentor_y + 200.0))
                        + (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                           * (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                  );
                  xcalc = x
                     + (ArphexModVariables.MapVariables.get(world).tormentor_x - x)
                        / dists
                        * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
                  ycalc = y
                     + (ArphexModVariables.MapVariables.get(world).tormentor_y + 200.0 - y)
                        / dists
                        * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F)
                     + dists * 0.0025;
                  zcalc = z
                     + (ArphexModVariables.MapVariables.get(world).tormentor_z - z)
                        / dists
                        * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
                  dist_to_rendered = Math.sqrt(
                     (entity.getX() - xcalc) * (entity.getX() - xcalc)
                        + (entity.getY() - ycalc) * (entity.getY() - ycalc)
                        + (entity.getZ() - zcalc) * (entity.getZ() - zcalc)
                  );
                  RenderSystem.blendFuncSeparate(SourceFactor.DST_COLOR, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
                  sphere_gradient = 600.0;
                  tier_multiply = 50.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 2.5;
                  dropoff = 25.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 2.5;
                  sphere_num = 33.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier;
                  if (dist_to_rendered > dists) {
                     for (int index2 = 0; index2 < (int)sphere_num; index2++) {
                        renderShape(
                           shape(),
                           ArphexModVariables.MapVariables.get(world).tormentor_x,
                           ArphexModVariables.MapVariables.get(world).tormentor_y + 200.0,
                           ArphexModVariables.MapVariables.get(world).tormentor_z,
                           0.0F,
                           0.0F,
                           0.0F,
                           (float)sphere_gradient,
                           (float)(sphere_gradient / 10.0),
                           (float)sphere_gradient,
                           (int)Math.max(3.0, 85.0 - sphere_gradient / dropoff) << 24 | 983040 | 0 | 0
                        );
                        sphere_gradient += tier_multiply;
                     }
                  } else {
                     for (int index3 = 0; index3 < (int)sphere_num; index3++) {
                        renderShape(
                           shape(),
                           xcalc,
                           ycalc,
                           zcalc,
                           0.0F,
                           0.0F,
                           0.0F,
                           (float)(sphere_gradient * ((double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F) / dists)),
                           (float)(sphere_gradient * ((double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F) / dists) / 10.0),
                           (float)(sphere_gradient * ((double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F) / dists)),
                           (int)Math.max(3.0, 85.0 - sphere_gradient / dropoff) << 24 | 983040 | 0 | 0
                        );
                        sphere_gradient += tier_multiply;
                     }
                  }

                  true_dists = Math.sqrt(
                     (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                           * (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                        + (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                           * (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                        + (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                           * (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                  );
                  if (true_dists < 420.0) {
                     RenderSystem.disableCull();
                     renderShape(
                        shape(),
                        x,
                        y,
                        z,
                        0.0F,
                        0.0F,
                        0.0F,
                        Minecraft.getInstance().gameRenderer.getRenderDistance() * 8.0F,
                        Minecraft.getInstance().gameRenderer.getRenderDistance() * 8.0F,
                        Minecraft.getInstance().gameRenderer.getRenderDistance() * 8.0F,
                        (int)Math.min(255.0, 255.0 * Math.pow((420.0 - Math.max(true_dists - 20.0, 0.0)) / 400.0, 1.5)) << 24 | 655360 | 0 | 0
                     );
                  }

                  release();
               }

               if (ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0 && tormentor_distance < 400.0) {
                  rotation_from_tormentor = Math.min(
                     Math.abs(
                        (
                                 Math.toDegrees(
                                       Math.atan2(
                                          ArphexModVariables.MapVariables.get(world).tormentor_z - entity.getZ(),
                                          ArphexModVariables.MapVariables.get(world).tormentor_x - entity.getX()
                                       )
                                    )
                                    - ArphexModVariables.MapVariables.get(world).tormentor_rotation
                                    + 360.0
                              )
                              % 360.0
                           - 270.0
                     ),
                     360.0
                        - Math.abs(
                           (
                                    Math.toDegrees(
                                          Math.atan2(
                                             ArphexModVariables.MapVariables.get(world).tormentor_z - entity.getZ(),
                                             ArphexModVariables.MapVariables.get(world).tormentor_x - entity.getX()
                                          )
                                       )
                                       - ArphexModVariables.MapVariables.get(world).tormentor_rotation
                                       + 360.0
                                 )
                                 % 360.0
                              - 270.0
                        )
                  );
                  if (!(ArphexModVariables.MapVariables.get(world).tormentor_hitbox_split > 0.0)) {
                     if (rotation_from_tormentor < 115.0) {
                        spheresize = 10.0;
                        if (target(2)) {
                           renderShape(
                              shape(),
                              ArphexModVariables.MapVariables.get(world).tormentor_x,
                              ArphexModVariables.MapVariables.get(world).tormentor_y + 4.0,
                              ArphexModVariables.MapVariables.get(world).tormentor_z,
                              0.0F,
                              0.0F,
                              0.0F,
                              (float)spheresize,
                              (float)spheresize,
                              (float)spheresize,
                              (int)(100.0 - rotation_from_tormentor * 0.86) << 24 | 0xFF0000 | 12800 | 50
                           );
                           if (spheresize / 2.0 > tormentor_distance) {
                              double _setval = 5.0;
                              entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                 capability.overlay_red = _setval;
                                 capability.syncPlayerVariables(entity);
                              });
                           }

                           release();
                        }
                     }
                  } else if (rotation_from_tormentor < 115.0) {
                     spheresize = 8.0;
                     if (target(2)) {
                        Vec3 _center = new Vec3(
                           ArphexModVariables.MapVariables.get(world).tormentor_x,
                           ArphexModVariables.MapVariables.get(world).tormentor_y,
                           ArphexModVariables.MapVariables.get(world).tormentor_z
                        );

                        for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80.0), e -> true)
                           .stream()
                           .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                           .toList()) {
                           if (entityiteratorx instanceof TormentorHitboxEntity) {
                              renderShape(
                                 shape(),
                                 entityiteratorx.getX(),
                                 entityiteratorx.getY() + 4.0,
                                 entityiteratorx.getZ(),
                                 0.0F,
                                 0.0F,
                                 0.0F,
                                 (float)spheresize,
                                 (float)spheresize,
                                 (float)spheresize,
                                 (int)(100.0 - rotation_from_tormentor * 0.86) << 24 | 0xFF0000 | 12800 | 50
                              );
                              if (spheresize / 2.0 > tormentor_distance) {
                                 double _setval = 5.0;
                                 entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.overlay_red = _setval;
                                    capability.syncPlayerVariables(entity);
                                 });
                              }
                           }
                        }

                        release();
                     }
                  }
               }
            }

            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            max_entities = 100.0;
            if (world instanceof ClientLevel) {
               for (Entity entityiteratorxx : ((ClientLevel)world).entitiesForRendering()) {
                  if (entityiteratorxx instanceof LivingEntity) {
                     if ((entity instanceof LivingEntity _entUseItem247 ? _entUseItem247.getUseItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .getBoolean("limit_checks_arphex")
                        && entity.getPersistentData().getString("hornetlock_uuids").contains(entityiteratorxx.getStringUUID())) {
                        RenderSystem.depthMask(false);
                        RenderSystem.disableDepthTest();
                        if (target(2)) {
                           renderShape(
                              shape(),
                              entityiteratorxx.getX(),
                              entityiteratorxx.getY(),
                              entityiteratorxx.getZ(),
                              0.0F,
                              0.0F,
                              0.0F,
                              0.7F,
                              0.7F,
                              0.7F,
                              -1761607936
                           );
                           release();
                        }
                     }

                     if (max_entities > 0.0
                        && entity.isShiftKeyDown()
                        && entity != entityiteratorxx
                        && (
                           (entity instanceof LivingEntity _entGetArmorxxxxxxx ? _entGetArmorxxxxxxx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                                       .getItem()
                                    == ArphexModItems.SPACETIME_HELMET.get()
                                 && (entity instanceof LivingEntity _entGetArmorxxxxxx
                                          ? _entGetArmorxxxxxx.getItemBySlot(EquipmentSlot.CHEST)
                                          : ItemStack.EMPTY)
                                       .getItem()
                                    == ArphexModItems.SPACETIME_CHESTPLATE.get()
                                 && (entity instanceof LivingEntity _entGetArmorxxxxx ? _entGetArmorxxxxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                                       .getItem()
                                    == ArphexModItems.SPACETIME_LEGGINGS.get()
                                 && (entity instanceof LivingEntity _entGetArmorxxxx ? _entGetArmorxxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                                       .getItem()
                                    == ArphexModItems.SPACETIME_BOOTS.get()
                              || (entity instanceof LivingEntity _entGetArmorxxx ? _entGetArmorxxx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                                       .getItem()
                                    == ArphexModItems.IMMORTAL_HELMET.get()
                                 && (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                                       .getItem()
                                    == ArphexModItems.IMMORTAL_CHESTPLATE.get()
                                 && (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                                       .getItem()
                                    == ArphexModItems.IMMORTAL_LEGGINGS.get()
                                 && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                                    == ArphexModItems.IMMORTAL_BOOTS.get()
                        )) {
                        col_r = 255.0;
                        col_g = 255.0;
                        col_b = 255.0;
                        if (entityiteratorxx instanceof Monster) {
                           col_r = 255.0;
                           col_g = 0.0;
                           col_b = 0.0;
                        }

                        if (entityiteratorxx instanceof TamableAnimal) {
                           TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxx;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                                 col_r = 0.0;
                                 col_g = 255.0;
                                 col_b = 0.0;
                              }
                           }
                        }

                        if (entityiteratorxx instanceof Player) {
                           col_r = 0.0;
                           col_g = 0.0;
                           col_b = 255.0;
                        }

                        RenderSystem.depthMask(false);
                        RenderSystem.disableDepthTest();
                        max_entities--;
                        if (target(2)) {
                           renderShape(
                              shape(),
                              entityiteratorxx.getX(),
                              entityiteratorxx.getY() + 1.0,
                              entityiteratorxx.getZ(),
                              0.0F,
                              0.0F,
                              0.0F,
                              (float)((double)entityiteratorxx.getBbHeight() * 0.65),
                              (float)((double)entityiteratorxx.getBbHeight() * 0.65),
                              (float)((double)entityiteratorxx.getBbHeight() * 0.65),
                              -1778384896 | (int)col_r << 16 | (int)col_g << 8 | (int)col_b
                           );
                           release();
                        }
                     }

                     if (entityiteratorxx instanceof Player) {
                        RenderSystem.depthMask(true);
                        RenderSystem.enableDepthTest();
                        if ((
                              entityiteratorxx instanceof Player _plrCldCheck296
                                    && _plrCldCheck296.getCooldowns().isOnCooldown((Item)ArphexModItems.SPACETIME_CHESTPLATE.get())
                                 || entityiteratorxx instanceof Player _plrCldCheck297
                                    && _plrCldCheck297.getCooldowns().isOnCooldown((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get())
                           )
                           && (
                              (
                                       entityiteratorxx instanceof Player _plrCldRem298
                                          ? _plrCldRem298.getCooldowns().getCooldownPercent((Item)ArphexModItems.SPACETIME_CHESTPLATE.get(), 0.0F) * 100.0F
                                          : 0.0F
                                    )
                                    >= 75.0F
                                 || (
                                       entityiteratorxx instanceof Player _plrCldRem299
                                          ? _plrCldRem299.getCooldowns().getCooldownPercent((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get(), 0.0F) * 100.0F
                                          : 0.0F
                                    )
                                    >= 75.0F
                           )) {
                           if ((entityiteratorxx instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                                 .getItem()
                              == ArphexModItems.IMMORTAL_CHESTPLATE.get()) {
                              spheresize = (double)Math.min(
                                 50.0F
                                    - Math.abs(
                                       50.0F
                                          - Math.abs(
                                             (
                                                   75.0F
                                                      - (
                                                         entityiteratorxx instanceof Player _plrCldRem302
                                                            ? _plrCldRem302.getCooldowns()
                                                                  .getCooldownPercent((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get(), 0.0F)
                                                               * 100.0F
                                                            : 0.0F
                                                      )
                                                )
                                                * 4.0F
                                          )
                                    ),
                                 10.0F
                              );
                           } else {
                              spheresize = (double)Math.min(
                                 50.0F
                                    - Math.abs(
                                       50.0F
                                          - Math.abs(
                                             (
                                                   75.0F
                                                      - (
                                                         entityiteratorxx instanceof Player _plrCldRem303
                                                            ? _plrCldRem303.getCooldowns()
                                                                  .getCooldownPercent((Item)ArphexModItems.SPACETIME_CHESTPLATE.get(), 0.0F)
                                                               * 100.0F
                                                            : 0.0F
                                                      )
                                                )
                                                * 4.0F
                                          )
                                    ),
                                 10.0F
                              );
                           }

                           opacity = 140.0;
                           col_r = 50.0;
                           col_g = 50.0;
                           col_b = 170.0;
                           RenderSystem.disableCull();
                           RenderSystem.blendFuncSeparate(SourceFactor.DST_COLOR, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
                           if (target(2)) {
                              renderShape(
                                 shape(),
                                 entityiteratorxx.getX(),
                                 entityiteratorxx.getY() + 1.0,
                                 entityiteratorxx.getZ(),
                                 0.0F,
                                 0.0F,
                                 0.0F,
                                 (float)spheresize,
                                 (float)spheresize,
                                 (float)spheresize,
                                 (int)opacity << 24 | (int)col_r << 16 | (int)col_g << 8 | (int)col_b
                              );
                              if (entityiteratorxx instanceof SphereAnimEntity && spheresize / 2.0 > distance) {
                                 if ((entityiteratorxx instanceof SphereAnimEntity _datEntS
                                       ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color)
                                       : "")
                                    .equals("white")) {
                                    double _setval = 5.0;
                                    entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                       capability.overlay_white = _setval;
                                       capability.syncPlayerVariables(entity);
                                    });
                                 } else {
                                    double _setval = 5.0;
                                    entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                       capability.overlay_black = _setval;
                                       capability.syncPlayerVariables(entity);
                                    });
                                 }
                              }

                              release();
                           }
                        }
                     }

                     if (entityiteratorxx instanceof SphereAnimEntity) {
                        distance = Math.sqrt(
                           (entity.getX() - entityiteratorxx.getX()) * (entity.getX() - entityiteratorxx.getX())
                              + (entity.getY() + 1.0 - entityiteratorxx.getY()) * (entity.getY() + 1.0 - entityiteratorxx.getY())
                              + (entity.getZ() - entityiteratorxx.getZ()) * (entity.getZ() - entityiteratorxx.getZ())
                        );
                        spheresize = (double)(
                           (
                                 entityiteratorxx instanceof SphereAnimEntity _datEntI
                                    ? (Integer)_datEntI.getEntityData().get(SphereAnimEntity.DATA_sphere_size)
                                    : 0
                              )
                              / 10
                        );
                        opacity = entityiteratorxx instanceof SphereAnimEntity _datEntIx
                           ? (double)((Integer)_datEntIx.getEntityData().get(SphereAnimEntity.DATA_opacity)).intValue()
                           : 0.0;
                        if ((entityiteratorxx instanceof SphereAnimEntity _datEntS ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color) : "")
                           .equals("red")) {
                           col_r = 255.0;
                           col_g = 0.0;
                           col_b = 0.0;
                        } else if ((entityiteratorxx instanceof SphereAnimEntity _datEntS
                              ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color)
                              : "")
                           .equals("white")) {
                           col_r = 255.0;
                           col_g = 255.0;
                           col_b = 255.0;
                        } else if ((entityiteratorxx instanceof SphereAnimEntity _datEntS
                              ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color)
                              : "")
                           .equals("purple")) {
                           col_r = 141.0;
                           col_g = 21.0;
                           col_b = 161.0;
                        } else if ((entityiteratorxx instanceof SphereAnimEntity _datEntS
                              ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color)
                              : "")
                           .equals("green")) {
                           col_r = 0.0;
                           col_g = 200.0;
                           col_b = 0.0;
                        } else {
                           col_r = 0.0;
                           col_g = 0.0;
                           col_b = 0.0;
                        }

                        if (target(2)) {
                           renderShape(
                              shape(),
                              entityiteratorxx.getX(),
                              entityiteratorxx.getY(),
                              entityiteratorxx.getZ(),
                              0.0F,
                              0.0F,
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

         if (ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.strip().length() > 1) {
            RenderSystem.disableCull();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            system(true);
            String _setval = ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.current_ascendant = _setval;
               capability.syncPlayerVariables(entity);
            });
            _setval = "";
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.asc_subchain = _setval;
               capability.syncPlayerVariables(entity);
            });

            for (int index4 = 0;
               index4
                     < ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.strip().length()
                        - ArphexModVariables.MapVariables.get(world).ascend_cube_coord_list.replace("]", "").strip().length()
                  && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .current_ascendant
                        .length()
                     > 1;
               index4++
            ) {
               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .current_ascendant
                     .contains("[")
                  && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .current_ascendant
                     .contains("]")) {
                  String _setvalx = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .current_ascendant
                     .substring(
                        ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .current_ascendant
                           .lastIndexOf("["),
                        ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .current_ascendant
                           .length()
                     )
                     .replace("]", "")
                     .replace("[", "");
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.asc_subchain = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }

               String _setvalx = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .current_ascendant
                  .replace(
                     "["
                        + ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .asc_subchain
                        + "]",
                     ""
                  );
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.current_ascendant = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .asc_subchain
                  .contains(
                     ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .current_player_dimenson
                        .strip()
                  )) {
                  if (!((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .asc_subchain
                        .contains("@")
                     && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .asc_subchain
                        .contains(",")) {
                     double _setvalxx = (new Object() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return 0.0;
                              }
                           }
                        })
                        .convert(
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .asc_subchain
                              .substring(
                                 0,
                                 ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .asc_subchain
                                    .indexOf(",")
                              )
                              .replace(",", "")
                              .strip()
                        );
                     entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.asc_x = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     double _setvalxxx = (new Object() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return 0.0;
                              }
                           }
                        })
                        .convert(
                           ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .asc_subchain
                              .substring(
                                 ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .asc_subchain
                                    .indexOf(","),
                                 ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .asc_subchain
                                    .lastIndexOf(",")
                              )
                              .replace(",", "")
                              .strip()
                        );
                     entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.asc_y = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .asc_subchain
                        .contains("-")) {
                        if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .asc_subchain
                              .length()
                           > ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .asc_subchain
                              .indexOf("-")) {
                           double _setvalxxxx = (new Object() {
                                 double convert(String s) {
                                    try {
                                       return Double.parseDouble(s.trim());
                                    } catch (Exception var3) {
                                       return 0.0;
                                    }
                                 }
                              })
                              .convert(
                                 ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .asc_subchain
                                    .substring(
                                       ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                             .orElse(new ArphexModVariables.PlayerVariables()))
                                          .asc_subchain
                                          .lastIndexOf(","),
                                       Math.max(
                                          ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                .orElse(new ArphexModVariables.PlayerVariables()))
                                             .asc_subchain
                                             .lastIndexOf("-"),
                                          ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                   .orElse(new ArphexModVariables.PlayerVariables()))
                                                .asc_subchain
                                                .lastIndexOf(",")
                                             + 1
                                       )
                                    )
                                    .replace(",", "")
                                    .strip()
                              );
                           entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.asc_z = _setval;
                              capability.syncPlayerVariables(entity);
                           });
                        }

                        if (target(2)) {
                           renderShape(
                              shape(),
                              ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .asc_x,
                              ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .asc_y
                                 + 1.0,
                              ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .asc_z,
                              0.0F,
                              0.0F,
                              0.0F,
                              200.0F,
                              200.0F,
                              200.0F,
                              1174405120
                                 | DyeColor.byId(
                                       world.getEntitiesOfClass(
                                                AscendSphereAnimEntity.class,
                                                AABB.ofSize(
                                                   new Vec3(
                                                      ((ArphexModVariables.PlayerVariables)entity.getCapability(
                                                               ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                            )
                                                            .orElse(new ArphexModVariables.PlayerVariables()))
                                                         .asc_x,
                                                      ((ArphexModVariables.PlayerVariables)entity.getCapability(
                                                               ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                            )
                                                            .orElse(new ArphexModVariables.PlayerVariables()))
                                                         .asc_y,
                                                      ((ArphexModVariables.PlayerVariables)entity.getCapability(
                                                               ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                            )
                                                            .orElse(new ArphexModVariables.PlayerVariables()))
                                                         .asc_z
                                                   ),
                                                   5.0,
                                                   5.0,
                                                   5.0
                                                ),
                                                e -> (Integer)e.getEntityData().get(AscendSphereAnimEntity.DATA_barriermode) > 0
                                             )
                                             .isEmpty()
                                          ? (int)(new Object() {
                                                double convert(String s) {
                                                   try {
                                                      return Double.parseDouble(s.trim());
                                                   } catch (Exception var3) {
                                                      return 0.0;
                                                   }
                                                }
                                             })
                                             .convert(
                                                ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                      .orElse(new ArphexModVariables.PlayerVariables()))
                                                   .asc_subchain
                                                   .substring(
                                                      ((ArphexModVariables.PlayerVariables)entity.getCapability(
                                                                  ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                               )
                                                               .orElse(new ArphexModVariables.PlayerVariables()))
                                                            .asc_subchain
                                                            .lastIndexOf("-")
                                                         + 1,
                                                      ((ArphexModVariables.PlayerVariables)entity.getCapability(
                                                               ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                            )
                                                            .orElse(new ArphexModVariables.PlayerVariables()))
                                                         .asc_subchain
                                                         .length()
                                                   )
                                                   .split("\\\\")[0]
                                             )
                                          : 0
                                    )
                                    .getTextColor()
                           );
                           release();
                        }
                     }
                  }

                  _setvalx = "";
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.asc_subchain = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }
         }
      }
   }
}
