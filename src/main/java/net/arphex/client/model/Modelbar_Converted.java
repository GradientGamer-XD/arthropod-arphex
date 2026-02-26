package net.arphex.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelbar_Converted<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modelbar_converted"), "main");
   public final ModelPart warpstaff;

   public Modelbar_Converted(ModelPart root) {
      this.warpstaff = root.getChild("warpstaff");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition warpstaff = partdefinition.addOrReplaceChild("warpstaff", CubeListBuilder.create(), PartPose.offset(-0.0382F, 20.2054F, -0.5F));
      PartDefinition blade_r1 = warpstaff.addOrReplaceChild(
         "blade_r1",
         CubeListBuilder.create().texOffs(52, 0).addBox(-1.425F, -20.0F, -1.435F, 2.85F, 58.0F, 2.87F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.075F, -12.8504F, 1.6F, 0.0F, -1.5708F, -1.5708F)
      );
      return LayerDefinition.create(meshdefinition, 72, 72);
   }

   public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void renderToBuffer(
      PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha
   ) {
      this.warpstaff.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
