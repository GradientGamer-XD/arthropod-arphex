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

public class Modelspectral<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modelspectral"), "main");
   public final ModelPart Helmet;
   public final ModelPart Chestplate;
   public final ModelPart LeftPlate;
   public final ModelPart RightPlate;
   public final ModelPart RightLegging;
   public final ModelPart LeftLegging;
   public final ModelPart RightBoot;
   public final ModelPart LeftBoot;

   public Modelspectral(ModelPart root) {
      this.Helmet = root.getChild("Helmet");
      this.Chestplate = root.getChild("Chestplate");
      this.LeftPlate = root.getChild("LeftPlate");
      this.RightPlate = root.getChild("RightPlate");
      this.RightLegging = root.getChild("RightLegging");
      this.LeftLegging = root.getChild("LeftLegging");
      this.RightBoot = root.getChild("RightBoot");
      this.LeftBoot = root.getChild("LeftBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Helmet = partdefinition.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -0.6F));
      PartDefinition HatLayer_r1 = Helmet.addOrReplaceChild(
         "HatLayer_r1",
         CubeListBuilder.create().texOffs(7, 3).mirror().addBox(-3.5F, 0.5F, -3.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(4.7F, -4.825F, 1.3F, 0.2217F, -0.0984F, 1.2969F)
      );
      PartDefinition HatLayer_r2 = Helmet.addOrReplaceChild(
         "HatLayer_r2",
         CubeListBuilder.create().texOffs(11, 4).addBox(0.5F, -0.5F, 0.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-2.025F, -8.95F, -2.025F, -0.0175F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r3 = Helmet.addOrReplaceChild(
         "HatLayer_r3",
         CubeListBuilder.create().texOffs(6, 2).addBox(-0.5F, -0.5F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-1.525F, -8.15F, 0.575F, 0.1396F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r4 = Helmet.addOrReplaceChild(
         "HatLayer_r4",
         CubeListBuilder.create().texOffs(12, 6).addBox(1.5F, -0.5F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-3.825F, -5.625F, -2.2F, -0.1201F, 0.0412F, -1.2085F)
      );
      PartDefinition HatLayer_r5 = Helmet.addOrReplaceChild(
         "HatLayer_r5",
         CubeListBuilder.create().texOffs(12, 6).addBox(1.5F, -0.5F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(3.775F, -5.725F, -2.0F, 0.1379F, 0.0792F, -2.0042F)
      );
      PartDefinition HatLayer_r6 = Helmet.addOrReplaceChild(
         "HatLayer_r6",
         CubeListBuilder.create().texOffs(9, 2).addBox(2.5F, -0.5F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(3.9F, -5.725F, 0.0F, -0.0366F, 0.0792F, -1.917F)
      );
      PartDefinition HatLayer_r7 = Helmet.addOrReplaceChild(
         "HatLayer_r7",
         CubeListBuilder.create().texOffs(7, 3).addBox(-3.5F, 0.5F, -3.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-4.7F, -4.825F, 1.3F, 0.2217F, 0.0984F, -1.2969F)
      );
      PartDefinition HatLayer_r8 = Helmet.addOrReplaceChild(
         "HatLayer_r8",
         CubeListBuilder.create().texOffs(9, 2).addBox(2.5F, -0.5F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-3.875F, -5.725F, 0.0F, 0.0373F, 0.0789F, -1.2115F)
      );
      PartDefinition Chestplate = partdefinition.addOrReplaceChild(
         "Chestplate",
         CubeListBuilder.create().texOffs(-1, 0).addBox(-1.7F, -0.3F, -2.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r1 = Chestplate.addOrReplaceChild(
         "BodyLayer_r1",
         CubeListBuilder.create().texOffs(19, 16).mirror().addBox(0.0F, -3.5F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.4681F, 1.2542F, -1.1F, 0.0F, 0.0F, -1.2785F)
      );
      PartDefinition HatLayer_r9 = Chestplate.addOrReplaceChild(
         "HatLayer_r9",
         CubeListBuilder.create().texOffs(8, 22).addBox(-1.5F, -0.5F, 5.3F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-2.575F, 1.325F, 1.85F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r10 = Chestplate.addOrReplaceChild(
         "HatLayer_r10",
         CubeListBuilder.create().texOffs(12, 24).addBox(-1.5F, -0.5F, 5.3F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(-2.575F, -3.375F, 2.275F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r2 = Chestplate.addOrReplaceChild(
         "BodyLayer_r2",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 13.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.0F, 6.2F, -0.975F, 0.0F, 0.0F, -2.378F)
      );
      PartDefinition BodyLayer_r3 = Chestplate.addOrReplaceChild(
         "BodyLayer_r3",
         CubeListBuilder.create().texOffs(21, 18).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(5.05F, 10.95F, -0.975F, 0.0F, 0.0F, 1.5839F)
      );
      PartDefinition BodyLayer_r4 = Chestplate.addOrReplaceChild(
         "BodyLayer_r4",
         CubeListBuilder.create()
            .texOffs(21, 18)
            .addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.26F))
            .texOffs(21, 16)
            .addBox(1.0F, -6.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(-1.95F, 10.95F, -0.975F, 0.0F, 0.0F, 1.5839F)
      );
      PartDefinition BodyLayer_r5 = Chestplate.addOrReplaceChild(
         "BodyLayer_r5",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 14.0F, 4.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(-0.15F, 5.45F, -0.975F, 0.0F, 0.0F, 2.3693F)
      );
      PartDefinition BodyLayer_r6 = Chestplate.addOrReplaceChild(
         "BodyLayer_r6",
         CubeListBuilder.create().texOffs(19, 16).addBox(-1.0F, -3.5F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.4681F, 1.2542F, -1.1F, 0.0F, 0.0F, 1.2785F)
      );
      PartDefinition BodyLayer_r7 = Chestplate.addOrReplaceChild(
         "BodyLayer_r7",
         CubeListBuilder.create().texOffs(35, 0).addBox(0.0F, -2.2F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)),
         PartPose.offsetAndRotation(0.2F, 7.225F, -0.975F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, -0.7F));
      PartDefinition LeftArmLayer_r1 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r1",
         CubeListBuilder.create()
            .texOffs(38, 15)
            .addBox(-4.0F, -6.0F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.55F))
            .texOffs(38, 15)
            .addBox(-4.0F, -10.525F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.55F))
            .texOffs(38, 15)
            .addBox(-4.0F, -14.1F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(3.275F, 11.725F, 0.275F, 0.0F, 0.1745F, 0.0F)
      );
      PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, -0.7F));
      PartDefinition RightArmLayer_r1 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r1",
         CubeListBuilder.create()
            .texOffs(38, 15)
            .mirror()
            .addBox(0.0F, -6.0F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(38, 15)
            .mirror()
            .addBox(0.0F, -10.525F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(38, 15)
            .mirror()
            .addBox(0.0F, -14.1F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.55F))
            .mirror(false),
         PartPose.offsetAndRotation(-3.275F, 11.725F, 0.275F, 0.0F, -0.1745F, 0.0F)
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

   public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void renderToBuffer(
      PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha
   ) {
      this.Helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Chestplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
