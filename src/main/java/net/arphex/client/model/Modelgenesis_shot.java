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

public class Modelgenesis_shot<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modelgenesis_shot"), "main");
   public final ModelPart warpstaff;

   public Modelgenesis_shot(ModelPart root) {
      this.warpstaff = root.getChild("warpstaff");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition warpstaff = partdefinition.addOrReplaceChild(
         "warpstaff",
         CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(-1.1848F, -12.2689F, -0.795F, 2.0F, 27.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 1)
            .addBox(-0.6533F, -21.4989F, -0.3F, 1.0F, 45.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.6548F, -7.9789F, -1.325F, 3.0F, 19.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-2.5948F, -4.2189F, -1.855F, 5.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(0, 1)
            .addBox(-3.0648F, -0.8689F, -2.385F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
            .texOffs(1, 0)
            .addBox(-2.5398F, -0.3189F, -2.885F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
            .texOffs(1, 2)
            .addBox(-3.5398F, -0.3189F, -1.885F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(-0.0382F, 20.2054F, -0.5F)
      );
      return LayerDefinition.create(meshdefinition, 72, 72);
   }

   public void renderToBuffer(
      PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha
   ) {
      this.warpstaff.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
