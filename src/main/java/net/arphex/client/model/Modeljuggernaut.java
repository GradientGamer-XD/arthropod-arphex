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

public class Modeljuggernaut<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modeljuggernaut"), "main");
   public final ModelPart Helmet;
   public final ModelPart Chestplate;
   public final ModelPart RightPlate;
   public final ModelPart LeftPlate;
   public final ModelPart RightLegging;
   public final ModelPart LeftLegging;
   public final ModelPart RightBoot;
   public final ModelPart LeftBoot;

   public Modeljuggernaut(ModelPart root) {
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
         CubeListBuilder.create().texOffs(10, 4).mirror().addBox(-1.5F, 0.5F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(1.05F)).mirror(false),
         PartPose.offsetAndRotation(6.35F, -3.35F, -1.175F, 0.1818F, -0.161F, 1.6073F)
      );
      PartDefinition HatLayer_r2 = Helmet.addOrReplaceChild(
         "HatLayer_r2",
         CubeListBuilder.create().texOffs(14, 23).mirror().addBox(-8.5F, -2.5F, 0.3F, 11.0F, 4.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
         PartPose.offsetAndRotation(2.925F, -5.125F, 2.35F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r3 = Helmet.addOrReplaceChild(
         "HatLayer_r3",
         CubeListBuilder.create().texOffs(10, 4).addBox(-1.5F, 0.5F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(1.05F)),
         PartPose.offsetAndRotation(-6.35F, -3.35F, -1.175F, 0.1818F, 0.161F, -1.6073F)
      );
      PartDefinition HatLayer_r4 = Helmet.addOrReplaceChild(
         "HatLayer_r4",
         CubeListBuilder.create().texOffs(10, 4).addBox(-1.5F, 0.5F, -4.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(1.05F)),
         PartPose.offsetAndRotation(-4.925F, -7.65F, -1.175F, 0.2419F, -0.0128F, -0.8382F)
      );
      PartDefinition HatLayer_r5 = Helmet.addOrReplaceChild(
         "HatLayer_r5",
         CubeListBuilder.create().texOffs(12, 4).mirror().addBox(-3.5F, 0.5F, -4.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(1.05F)).mirror(false),
         PartPose.offsetAndRotation(4.925F, -7.65F, -1.175F, 0.2419F, 0.0128F, 0.8382F)
      );
      PartDefinition HatLayer_r6 = Helmet.addOrReplaceChild(
         "HatLayer_r6",
         CubeListBuilder.create().texOffs(5, 3).addBox(-3.5F, -0.5F, -2.0F, 9.0F, 1.0F, 5.0F, new CubeDeformation(1.0F)),
         PartPose.offsetAndRotation(-1.075F, -7.65F, 2.525F, -0.9948F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r7 = Helmet.addOrReplaceChild(
         "HatLayer_r7",
         CubeListBuilder.create().texOffs(6, 2).addBox(-0.5F, -0.5F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(1.0F)),
         PartPose.offsetAndRotation(-1.525F, -8.425F, 0.575F, -0.1658F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r8 = Helmet.addOrReplaceChild(
         "HatLayer_r8",
         CubeListBuilder.create().texOffs(12, 6).addBox(1.5F, -0.5F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(1.05F)),
         PartPose.offsetAndRotation(-3.825F, -5.625F, -2.2F, -0.1201F, 0.0412F, -1.2085F)
      );
      PartDefinition HatLayer_r9 = Helmet.addOrReplaceChild(
         "HatLayer_r9",
         CubeListBuilder.create().texOffs(12, 6).addBox(1.5F, -0.5F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(1.05F)),
         PartPose.offsetAndRotation(3.775F, -5.725F, -2.0F, 0.1379F, 0.0792F, -2.0042F)
      );
      PartDefinition Chestplate = partdefinition.addOrReplaceChild(
         "Chestplate",
         CubeListBuilder.create()
            .texOffs(24, 16)
            .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.76F))
            .texOffs(-1, 0)
            .addBox(-1.7F, -0.3F, -2.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.5F))
            .texOffs(-1, 0)
            .mirror()
            .addBox(-1.3F, -0.3F, -2.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.5F))
            .mirror(false),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r1 = Chestplate.addOrReplaceChild(
         "BodyLayer_r1",
         CubeListBuilder.create().texOffs(21, 20).mirror().addBox(-2.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false),
         PartPose.offsetAndRotation(5.0F, 4.7F, -1.15F, 0.0F, 0.0F, 0.2225F)
      );
      PartDefinition HatLayer_r10 = Chestplate.addOrReplaceChild(
         "HatLayer_r10",
         CubeListBuilder.create().texOffs(16, 23).addBox(-2.5F, -1.5F, 0.3F, 9.0F, 0.0F, 4.0F, new CubeDeformation(1.0F)),
         PartPose.offsetAndRotation(-2.025F, 12.325F, 1.725F, -1.885F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r11 = Chestplate.addOrReplaceChild(
         "HatLayer_r11",
         CubeListBuilder.create().texOffs(13, 22).addBox(-3.5F, -1.5F, 1.3F, 12.0F, 2.0F, 5.0F, new CubeDeformation(1.0F)),
         PartPose.offsetAndRotation(-2.375F, 7.375F, 1.95F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r12 = Chestplate.addOrReplaceChild(
         "HatLayer_r12",
         CubeListBuilder.create().texOffs(11, 22).addBox(-3.5F, -1.5F, -0.7F, 9.0F, 0.0F, 9.0F, new CubeDeformation(1.0F)),
         PartPose.offsetAndRotation(-0.825F, 1.45F, 3.9F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r13 = Chestplate.addOrReplaceChild(
         "HatLayer_r13",
         CubeListBuilder.create().texOffs(9, 20).addBox(-4.5F, -1.5F, -0.7F, 13.0F, 2.0F, 9.0F, new CubeDeformation(1.0F)),
         PartPose.offsetAndRotation(-1.825F, -0.375F, 2.725F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r2 = Chestplate.addOrReplaceChild(
         "BodyLayer_r2",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -8.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.75F)),
         PartPose.offsetAndRotation(-4.1F, 1.7F, -0.475F, 0.0F, 0.0F, 1.5752F)
      );
      PartDefinition BodyLayer_r3 = Chestplate.addOrReplaceChild(
         "BodyLayer_r3",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -8.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.75F)),
         PartPose.offsetAndRotation(-4.1F, 7.7F, -0.475F, 0.0F, 0.0F, 1.5752F)
      );
      PartDefinition BodyLayer_r4 = Chestplate.addOrReplaceChild(
         "BodyLayer_r4",
         CubeListBuilder.create().texOffs(21, 20).addBox(0.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.75F)),
         PartPose.offsetAndRotation(-5.0F, 4.7F, -1.15F, 0.0F, 0.0F, -0.2225F)
      );
      PartDefinition RightPlate = partdefinition.addOrReplaceChild(
         "RightPlate",
         CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -1.4F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.75F)),
         PartPose.offset(-5.0F, 2.0F, 0.0F)
      );
      PartDefinition RightArmLayer_r1 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r1",
         CubeListBuilder.create().texOffs(39, 15).mirror().addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.75F)).mirror(false),
         PartPose.offsetAndRotation(-1.0F, -2.1F, 0.5F, 0.1309F, 0.0F, -0.5585F)
      );
      PartDefinition RightArmLayer_r2 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r2",
         CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(1.05F)),
         PartPose.offsetAndRotation(-1.5F, 5.6F, 0.0F, 0.0F, -0.1745F, 0.0F)
      );
      PartDefinition LeftPlate = partdefinition.addOrReplaceChild(
         "LeftPlate",
         CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -1.35F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.75F)),
         PartPose.offset(5.0F, 2.0F, 0.0F)
      );
      PartDefinition LeftArmLayer_r1 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r1",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.75F)),
         PartPose.offsetAndRotation(1.0F, -2.1F, 0.5F, 0.1309F, 0.0F, 0.5585F)
      );
      PartDefinition LeftArmLayer_r2 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r2",
         CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(1.05F)),
         PartPose.offsetAndRotation(1.5F, 5.6F, 0.0F, 0.0F, 0.1745F, 0.0F)
      );
      PartDefinition RightLegging = partdefinition.addOrReplaceChild(
         "RightLegging",
         CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.75F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftLegging = partdefinition.addOrReplaceChild(
         "LeftLegging",
         CubeListBuilder.create().texOffs(39, 14).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.75F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      PartDefinition RightBoot = partdefinition.addOrReplaceChild(
         "RightBoot",
         CubeListBuilder.create()
            .texOffs(32, 48)
            .addBox(-2.0F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.95F))
            .texOffs(32, 48)
            .addBox(-2.0F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(1.05F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftBoot = partdefinition.addOrReplaceChild(
         "LeftBoot",
         CubeListBuilder.create()
            .texOffs(16, 48)
            .addBox(-2.0F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.95F))
            .texOffs(16, 48)
            .addBox(-2.0F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(1.05F)),
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
      this.RightPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
