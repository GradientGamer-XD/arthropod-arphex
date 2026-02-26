package net.arphex.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.lang.reflect.Method;
import net.arphex.entity.BeetleBulwarkEntity;
import net.arphex.entity.model.BeetleBulwarkModel;
import net.arphex.procedures.BeetleBulwarkEntityVisualScaleProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BeetleBulwarkRenderer extends GeoEntityRenderer<BeetleBulwarkEntity> {
   private static Boolean isNyfsSpidersLoaded = null;
   private static Class<?> iClimberEntityClass;
   private static Class<?> orientationClass;
   private float lastScale = 1.0F;

   public BeetleBulwarkRenderer(Context renderManager) {
      super(renderManager, new BeetleBulwarkModel());
      this.shadowRadius = 0.0F;
      checkNyfsSpidersIntegration();
   }

   private static void checkNyfsSpidersIntegration() {
      if (isNyfsSpidersLoaded == null) {
         try {
            iClimberEntityClass = Class.forName("com.nyfaria.nyfsspiders.common.entity.mob.IClimberEntity");
            orientationClass = Class.forName("com.nyfaria.nyfsspiders.common.entity.mob.Orientation");
            isNyfsSpidersLoaded = true;
         } catch (ClassNotFoundException var1) {
            isNyfsSpidersLoaded = false;
         }
      }
   }

   public RenderType getRenderType(BeetleBulwarkEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      BeetleBulwarkEntity entity,
      BakedGeoModel model,
      MultiBufferSource bufferSource,
      VertexConsumer buffer,
      boolean isReRender,
      float partialTick,
      int packedLight,
      int packedOverlay,
      float red,
      float green,
      float blue,
      float alpha
   ) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)BeetleBulwarkEntityVisualScaleProcedure.execute(entity);
      this.lastScale = scale;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void applyRotations(BeetleBulwarkEntity entity, PoseStack poseStack, float ageInTicks, float netHeadYaw, float partialTick) {
      if (!isNyfsSpidersLoaded || !this.tryNyfsRotation(entity, poseStack, partialTick)) {
         super.applyRotations(entity, poseStack, ageInTicks, netHeadYaw, partialTick);
      }
   }

   private boolean tryNyfsRotation(BeetleBulwarkEntity entity, PoseStack poseStack, float partialTick) {
      try {
         if (!iClimberEntityClass.isInstance(entity)) {
            return false;
         } else {
            Object climberEntity = iClimberEntityClass.cast(entity);
            Object orientationObj = this.getOrientationObject(climberEntity);
            if (orientationObj == null) {
               return false;
            } else {
               Vec3 normal = (Vec3)orientationClass.getField("normal").get(orientationObj);
               float yaw = Mth.lerp(partialTick, entity.yRotO, entity.getYRot());
               float halfHeight = entity.getBbHeight() / 2.0F;
               boolean onCeiling = this.isOnCeiling(normal);
               float inverseScale = 1.0F / this.lastScale;
               Quaternionf alignment = new Quaternionf()
                  .rotationTo(new Vector3f(0.0F, 1.0F, 0.0F), new Vector3f((float)normal.x, (float)normal.y, (float)normal.z))
                  .normalize();
               poseStack.translate(0.0F, halfHeight * inverseScale, 0.0F);
               if (onCeiling) {
                  Vector3f movementDir = new Vector3f(-Mth.sin(-yaw * (float) (Math.PI / 180.0)), 0.0F, Mth.cos(-yaw * (float) (Math.PI / 180.0)));
                  movementDir.rotate(alignment);
                  float surfaceYaw = (float)Math.atan2((double)movementDir.x, (double)movementDir.z);
                  poseStack.mulPose(alignment);
                  poseStack.mulPose(new Quaternionf().rotateY(surfaceYaw));
               } else {
                  poseStack.mulPose(alignment);
                  poseStack.mulPose(new Quaternionf().rotateY((float) (Math.PI / 180.0) * (-yaw + 180.0F)));
               }

               poseStack.translate(0.0F, -halfHeight * inverseScale, 0.0F);
               return true;
            }
         }
      } catch (Exception var14) {
         return false;
      }
   }

   private boolean isOnCeiling(Vec3 normal) {
      return normal.y < -0.9 && Math.abs(normal.y) > Math.max(Math.abs(normal.x), Math.abs(normal.z));
   }

   private Object getOrientationObject(Object climberEntity) throws Exception {
      try {
         Method method = iClimberEntityClass.getMethod("getRenderOrientation");
         Object result = method.invoke(climberEntity);
         if (result != null) {
            return result;
         }
      } catch (NoSuchMethodException var5) {
      }

      try {
         Method method = iClimberEntityClass.getMethod("getOrientation");
         return method.invoke(climberEntity);
      } catch (NoSuchMethodException var4) {
         return null;
      }
   }
}
