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

public class Modelvitality<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modelvitality"), "main");
   public final ModelPart Helmet;
   public final ModelPart Chestplate;
   public final ModelPart RightPlate;
   public final ModelPart LeftPlate;
   public final ModelPart RightLegging;
   public final ModelPart LeftLegging;
   public final ModelPart RightBoot;
   public final ModelPart LeftBoot;

   public Modelvitality(ModelPart root) {
      this.Helmet = root.getChild("Helmet");
      this.Chestplate = root.getChild("Chestplate");
      this.RightPlate = root.getChild("RightPlate");
      this.LeftPlate = root.getChild("LeftPlate");
      this.RightLegging = root.getChild("RightLegging");
      this.LeftLegging = root.getChild("LeftLegging");
      this.RightBoot = root.getChild("RightBoot");
      this.LeftBoot = root.getChild("LeftBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Helmet = partdefinition.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition HatLayer_r1 = Helmet.addOrReplaceChild(
         "HatLayer_r1",
         CubeListBuilder.create().texOffs(11, 7).addBox(-0.5F, -0.5F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-1.525F, -8.15F, 7.075F, -0.1658F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r2 = Helmet.addOrReplaceChild(
         "HatLayer_r2",
         CubeListBuilder.create().texOffs(11, 7).addBox(-0.5F, -0.5F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-1.525F, -8.15F, 4.075F, -0.1658F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r3 = Helmet.addOrReplaceChild(
         "HatLayer_r3",
         CubeListBuilder.create().texOffs(11, 7).addBox(-0.5F, -0.5F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-1.525F, -8.15F, 0.575F, -0.1658F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r4 = Helmet.addOrReplaceChild(
         "HatLayer_r4",
         CubeListBuilder.create().texOffs(7, 2).addBox(1.5F, -0.5F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-3.825F, -5.625F, -2.2F, -0.1201F, 0.0412F, -1.2085F)
      );
      PartDefinition HatLayer_r5 = Helmet.addOrReplaceChild(
         "HatLayer_r5",
         CubeListBuilder.create().texOffs(7, 2).addBox(1.5F, -0.5F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(3.775F, -5.725F, -2.0F, 0.1379F, 0.0792F, -2.0042F)
      );
      PartDefinition Chestplate = partdefinition.addOrReplaceChild(
         "Chestplate",
         CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.26F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r1 = Chestplate.addOrReplaceChild(
         "BodyLayer_r1",
         CubeListBuilder.create().texOffs(18, 14).addBox(0.0F, -8.0F, -2.0F, 1.0F, 8.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-4.1F, 2.7F, -0.475F, 0.0F, 0.0F, 1.5752F)
      );
      PartDefinition BodyLayer_r2 = Chestplate.addOrReplaceChild(
         "BodyLayer_r2",
         CubeListBuilder.create().texOffs(18, 14).addBox(0.0F, -8.0F, -2.0F, 1.0F, 8.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-4.1F, 5.2F, -0.475F, 0.0F, 0.0F, 1.5752F)
      );
      PartDefinition BodyLayer_r3 = Chestplate.addOrReplaceChild(
         "BodyLayer_r3",
         CubeListBuilder.create().texOffs(18, 14).addBox(0.0F, -8.0F, -2.0F, 1.0F, 8.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-4.1F, 7.7F, -0.475F, 0.0F, 0.0F, 1.5752F)
      );
      PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
      PartDefinition RightArmLayer_r1 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r1",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-1.35F, -1.975F, 0.4F, 0.1309F, 0.0F, -0.6109F)
      );
      PartDefinition RightArmLayer_r2 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r2",
         CubeListBuilder.create()
            .texOffs(1, 24)
            .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(1, 24)
            .addBox(-2.0F, -7.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(1, 24)
            .addBox(-2.0F, -4.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-1.5F, 8.6F, 0.0F, 0.0F, -0.1745F, 0.0F)
      );
      PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
      PartDefinition LeftArmLayer_r1 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r1",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.0F, -2.1F, 0.4F, 0.1309F, 0.0F, 0.5585F)
      );
      PartDefinition LeftArmLayer_r2 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r2",
         CubeListBuilder.create()
            .texOffs(34, 22)
            .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(34, 22)
            .addBox(-2.0F, -7.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(34, 22)
            .addBox(-2.0F, -4.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(1.5F, 8.6F, 0.0F, 0.0F, 0.1745F, 0.0F)
      );
      PartDefinition RightLegging = partdefinition.addOrReplaceChild(
         "RightLegging",
         CubeListBuilder.create()
            .texOffs(0, 35)
            .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.25F))
            .texOffs(0, 35)
            .addBox(-2.0F, 3.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.25F))
            .texOffs(0, 35)
            .addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftLegging = partdefinition.addOrReplaceChild(
         "LeftLegging",
         CubeListBuilder.create()
            .texOffs(48, 35)
            .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.25F))
            .texOffs(48, 35)
            .addBox(-2.0F, 3.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.25F))
            .texOffs(48, 35)
            .addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      PartDefinition RightBoot = partdefinition.addOrReplaceChild(
         "RightBoot",
         CubeListBuilder.create()
            .texOffs(32, 48)
            .addBox(-2.0F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.45F))
            .texOffs(32, 48)
            .addBox(-2.0F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftBoot = partdefinition.addOrReplaceChild(
         "LeftBoot",
         CubeListBuilder.create()
            .texOffs(16, 48)
            .addBox(-2.0F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.45F))
            .texOffs(16, 48)
            .addBox(-2.0F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(
      PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha
   ) {
      this.Helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Chestplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
