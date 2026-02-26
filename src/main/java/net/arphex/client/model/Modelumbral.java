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

public class Modelumbral<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modelumbral"), "main");
   public final ModelPart Helmet;
   public final ModelPart Chestplate;
   public final ModelPart RightPlate;
   public final ModelPart LeftPlate;
   public final ModelPart RightLegging;
   public final ModelPart LeftLegging;
   public final ModelPart RightBoot;
   public final ModelPart LeftBoot;

   public Modelumbral(ModelPart root) {
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
         CubeListBuilder.create().texOffs(13, 5).mirror().addBox(-3.5F, 0.5F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(4.325F, -5.925F, -1.4F, 0.2293F, -0.0789F, 1.2159F)
      );
      PartDefinition HatLayer_r2 = Helmet.addOrReplaceChild(
         "HatLayer_r2",
         CubeListBuilder.create().texOffs(26, 22).addBox(-2.5F, 0.5F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(0.075F, -7.425F, 4.725F, -1.5708F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r3 = Helmet.addOrReplaceChild(
         "HatLayer_r3",
         CubeListBuilder.create().texOffs(17, 9).addBox(2.0F, -0.5F, -3.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-2.025F, -10.075F, -1.925F, -0.0175F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r4 = Helmet.addOrReplaceChild(
         "HatLayer_r4",
         CubeListBuilder.create().texOffs(8, 1).addBox(0.5F, -0.5F, -3.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-2.025F, -8.95F, -2.025F, -0.0175F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r5 = Helmet.addOrReplaceChild(
         "HatLayer_r5",
         CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -0.5F, -5.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-1.525F, -8.15F, 0.575F, 0.1396F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r6 = Helmet.addOrReplaceChild(
         "HatLayer_r6",
         CubeListBuilder.create().texOffs(11, 6).addBox(1.5F, -0.5F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-3.825F, -5.625F, -2.2F, -0.1201F, 0.0412F, -1.2085F)
      );
      PartDefinition HatLayer_r7 = Helmet.addOrReplaceChild(
         "HatLayer_r7",
         CubeListBuilder.create().texOffs(11, 6).addBox(1.5F, -0.5F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(3.775F, -5.725F, -2.0F, 0.1379F, 0.0792F, -2.0042F)
      );
      PartDefinition HatLayer_r8 = Helmet.addOrReplaceChild(
         "HatLayer_r8",
         CubeListBuilder.create().texOffs(6, 0).addBox(2.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(4.975F, -3.625F, 0.0F, -0.0366F, 0.0792F, -1.917F)
      );
      PartDefinition HatLayer_r9 = Helmet.addOrReplaceChild(
         "HatLayer_r9",
         CubeListBuilder.create().texOffs(6, 0).addBox(2.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(3.9F, -5.725F, 0.0F, -0.0366F, 0.0792F, -1.917F)
      );
      PartDefinition HatLayer_r10 = Helmet.addOrReplaceChild(
         "HatLayer_r10",
         CubeListBuilder.create().texOffs(13, 5).addBox(0.5F, 0.5F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-4.475F, -5.925F, -1.4F, 0.2293F, 0.0789F, -1.2115F)
      );
      PartDefinition HatLayer_r11 = Helmet.addOrReplaceChild(
         "HatLayer_r11",
         CubeListBuilder.create().texOffs(7, 0).addBox(2.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-5.125F, -3.625F, 0.0F, 0.0373F, 0.0789F, -1.2115F)
      );
      PartDefinition HatLayer_r12 = Helmet.addOrReplaceChild(
         "HatLayer_r12",
         CubeListBuilder.create().texOffs(7, 0).addBox(2.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-3.875F, -5.725F, 0.0F, 0.0373F, 0.0789F, -1.2115F)
      );
      PartDefinition Chestplate = partdefinition.addOrReplaceChild(
         "Chestplate",
         CubeListBuilder.create()
            .texOffs(16, 16)
            .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.26F))
            .texOffs(-1, 0)
            .addBox(-1.7F, -0.3F, -2.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r13 = Chestplate.addOrReplaceChild(
         "HatLayer_r13",
         CubeListBuilder.create().texOffs(8, 22).addBox(-2.5F, -0.5F, 8.3F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-1.825F, -0.375F, 2.725F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r14 = Chestplate.addOrReplaceChild(
         "HatLayer_r14",
         CubeListBuilder.create().texOffs(15, 26).addBox(-1.5F, -0.5F, 1.9F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-2.05F, -0.375F, 2.725F, -1.6886F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r1 = Chestplate.addOrReplaceChild(
         "BodyLayer_r1",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.0F, 3.375F, -0.475F, 0.0F, 0.0F, -2.378F)
      );
      PartDefinition BodyLayer_r2 = Chestplate.addOrReplaceChild(
         "BodyLayer_r2",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(-0.15F, 2.7F, -0.475F, 0.0F, 0.0F, 2.3693F)
      );
      PartDefinition BodyLayer_r3 = Chestplate.addOrReplaceChild(
         "BodyLayer_r3",
         CubeListBuilder.create().texOffs(20, 16).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-0.7F, 4.3F, -1.1F, 0.0F, 0.0F, 0.781F)
      );
      PartDefinition BodyLayer_r4 = Chestplate.addOrReplaceChild(
         "BodyLayer_r4",
         CubeListBuilder.create().texOffs(19, 16).addBox(0.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, -1.15F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition BodyLayer_r5 = Chestplate.addOrReplaceChild(
         "BodyLayer_r5",
         CubeListBuilder.create().texOffs(35, 0).addBox(0.0F, -2.2F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)),
         PartPose.offsetAndRotation(0.2F, 5.0F, -1.275F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
      PartDefinition RightArmLayer_r1 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r1",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.3F, -0.8F, 0.4F, 0.1309F, 0.0F, -0.6109F)
      );
      PartDefinition RightArmLayer_r2 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r2",
         CubeListBuilder.create()
            .texOffs(0, 16)
            .addBox(-1.0F, 1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(0, 16)
            .addBox(-1.0F, 2.625F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(0, 16)
            .addBox(-1.0F, 4.35F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-2.1F, 2.25F, -0.3F, 0.0F, -0.1745F, 0.0F)
      );
      PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate", CubeListBuilder.create(), PartPose.offset(4.1F, 2.0F, 0.0F));
      PartDefinition LeftArmLayer_r1 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r1",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.975F, -0.05F, 0.4F, 0.1309F, 0.0F, 0.5585F)
      );
      PartDefinition LeftArmLayer_r2 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r2",
         CubeListBuilder.create()
            .texOffs(40, 16)
            .addBox(-3.0F, 1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(40, 16)
            .addBox(-3.0F, 2.6F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(40, 16)
            .addBox(-3.0F, 4.275F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(1.975F, 2.325F, -0.225F, 0.0F, 0.1745F, 0.0F)
      );
      PartDefinition RightLegging = partdefinition.addOrReplaceChild(
         "RightLegging",
         CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition RightLegLayer_r1 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r1",
         CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.175F, 6.0F, 0.0F, 0.1963F, 0.0F, 0.3534F)
      );
      PartDefinition RightLegLayer_r2 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r2",
         CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.175F, 3.0F, 0.0F, 0.1963F, 0.0F, 0.3534F)
      );
      PartDefinition LeftLegging = partdefinition.addOrReplaceChild(
         "LeftLegging",
         CubeListBuilder.create().texOffs(48, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      PartDefinition RightLegLayer_r3 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r3",
         CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.2F, 6.0F, 0.0F, 0.1963F, 0.0F, -0.3272F)
      );
      PartDefinition RightLegLayer_r4 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r4",
         CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.2F, 3.0F, 0.0F, 0.1963F, 0.0F, -0.3272F)
      );
      PartDefinition RightBoot = partdefinition.addOrReplaceChild(
         "RightBoot",
         CubeListBuilder.create()
            .texOffs(32, 48)
            .addBox(-2.0F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.45F))
            .texOffs(32, 36)
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
