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

public class Modelspacetime<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modelspacetime"), "main");
   public final ModelPart Helmet;
   public final ModelPart Chestplate;
   public final ModelPart RightPlate;
   public final ModelPart RightLegging;
   public final ModelPart LeftLegging;
   public final ModelPart RightBoot;
   public final ModelPart LeftBoot;
   public final ModelPart LeftPlate;

   public Modelspacetime(ModelPart root) {
      this.Helmet = root.getChild("Helmet");
      this.Chestplate = root.getChild("Chestplate");
      this.RightPlate = root.getChild("RightPlate");
      this.RightLegging = root.getChild("RightLegging");
      this.LeftLegging = root.getChild("LeftLegging");
      this.RightBoot = root.getChild("RightBoot");
      this.LeftBoot = root.getChild("LeftBoot");
      this.LeftPlate = root.getChild("LeftPlate");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Helmet = partdefinition.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition HatLayer_r1 = Helmet.addOrReplaceChild(
         "HatLayer_r1",
         CubeListBuilder.create().texOffs(12, 4).addBox(0.5F, 0.5F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-3.475F, -7.85F, 0.5F, 0.44F, 0.1738F, -1.1669F)
      );
      PartDefinition HatLayer_r2 = Helmet.addOrReplaceChild(
         "HatLayer_r2",
         CubeListBuilder.create().texOffs(11, 3).addBox(0.5F, 0.5F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-3.475F, -9.775F, 3.325F, 0.459F, 0.3271F, -1.0906F)
      );
      PartDefinition HatLayer_r3 = Helmet.addOrReplaceChild(
         "HatLayer_r3",
         CubeListBuilder.create().texOffs(27, 23).mirror().addBox(-2.5F, 0.5F, -2.0F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false),
         PartPose.offsetAndRotation(-0.075F, -6.425F, 4.725F, -1.4312F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r4 = Helmet.addOrReplaceChild(
         "HatLayer_r4",
         CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-3.5F, -1.5F, -5.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false),
         PartPose.offsetAndRotation(1.525F, -7.45F, 0.575F, 0.0524F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r5 = Helmet.addOrReplaceChild(
         "HatLayer_r5",
         CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-3.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-3.9F, -5.725F, 0.0F, -0.0366F, -0.0792F, 1.917F)
      );
      PartDefinition HatLayer_r6 = Helmet.addOrReplaceChild(
         "HatLayer_r6",
         CubeListBuilder.create().texOffs(11, 3).mirror().addBox(-3.5F, 0.5F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(3.475F, -9.775F, 3.325F, 0.459F, -0.3271F, 1.0906F)
      );
      PartDefinition HatLayer_r7 = Helmet.addOrReplaceChild(
         "HatLayer_r7",
         CubeListBuilder.create().texOffs(12, 4).mirror().addBox(-3.5F, 0.5F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(3.475F, -7.85F, 0.5F, 0.44F, -0.1738F, 1.1669F)
      );
      PartDefinition HatLayer_r8 = Helmet.addOrReplaceChild(
         "HatLayer_r8",
         CubeListBuilder.create().texOffs(11, 3).mirror().addBox(-3.5F, 0.5F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(4.475F, -6.925F, -1.4F, 0.5347F, -0.0789F, 1.2115F)
      );
      PartDefinition HatLayer_r9 = Helmet.addOrReplaceChild(
         "HatLayer_r9",
         CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-3.5F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(4.325F, -3.625F, 0.0F, 0.0193F, -0.0851F, 1.4303F)
      );
      PartDefinition HatLayer_r10 = Helmet.addOrReplaceChild(
         "HatLayer_r10",
         CubeListBuilder.create().texOffs(7, 0).addBox(2.5F, -0.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(3.9F, -5.725F, 0.0F, -0.0366F, 0.0792F, -1.917F)
      );
      PartDefinition HatLayer_r11 = Helmet.addOrReplaceChild(
         "HatLayer_r11",
         CubeListBuilder.create().texOffs(11, 3).addBox(0.5F, 0.5F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-4.475F, -6.925F, -1.4F, 0.5347F, 0.0789F, -1.2115F)
      );
      PartDefinition HatLayer_r12 = Helmet.addOrReplaceChild(
         "HatLayer_r12",
         CubeListBuilder.create().texOffs(6, 0).addBox(1.5F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-4.325F, -3.625F, 0.0F, 0.0193F, 0.0851F, -1.4303F)
      );
      PartDefinition Chestplate = partdefinition.addOrReplaceChild(
         "Chestplate",
         CubeListBuilder.create()
            .texOffs(38, 1)
            .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 5.0F, new CubeDeformation(0.26F))
            .texOffs(-1, 0)
            .mirror()
            .addBox(-1.3F, -0.3F, -2.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .mirror(false),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r1 = Chestplate.addOrReplaceChild(
         "BodyLayer_r1",
         CubeListBuilder.create().texOffs(37, 9).mirror().addBox(-8.0F, -2.0F, -2.5F, 13.0F, 2.0F, 5.0F, new CubeDeformation(0.26F)).mirror(false),
         PartPose.offsetAndRotation(0.0F, 7.225F, 1.45F, 0.0F, 0.0F, 0.9163F)
      );
      PartDefinition HatLayer_r13 = Chestplate.addOrReplaceChild(
         "HatLayer_r13",
         CubeListBuilder.create()
            .texOffs(8, 22)
            .mirror()
            .addBox(-5.5F, -0.5F, 8.3F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.5F))
            .mirror(false)
            .texOffs(8, 22)
            .addBox(-6.15F, -0.5F, 8.3F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.5F)),
         PartPose.offsetAndRotation(1.825F, -0.375F, 2.725F, -1.6755F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r2 = Chestplate.addOrReplaceChild(
         "BodyLayer_r2",
         CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-1.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-1.0F, 7.875F, -0.475F, 0.0F, 0.0F, 2.378F)
      );
      PartDefinition BodyLayer_r3 = Chestplate.addOrReplaceChild(
         "BodyLayer_r3",
         CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-1.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-1.0F, 3.375F, -0.475F, 0.0F, 0.0F, 2.378F)
      );
      PartDefinition BodyLayer_r4 = Chestplate.addOrReplaceChild(
         "BodyLayer_r4",
         CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-1.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false),
         PartPose.offsetAndRotation(-0.55F, 3.0F, -0.675F, 0.0F, 0.0F, 3.1285F)
      );
      PartDefinition BodyLayer_r5 = Chestplate.addOrReplaceChild(
         "BodyLayer_r5",
         CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-1.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false),
         PartPose.offsetAndRotation(0.375F, 7.2F, -0.475F, 0.0F, 0.0F, -2.3693F)
      );
      PartDefinition BodyLayer_r6 = Chestplate.addOrReplaceChild(
         "BodyLayer_r6",
         CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-1.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false),
         PartPose.offsetAndRotation(0.15F, 2.7F, -0.475F, 0.0F, 0.0F, -2.3693F)
      );
      PartDefinition BodyLayer_r7 = Chestplate.addOrReplaceChild(
         "BodyLayer_r7",
         CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-1.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(0.7F, 4.3F, -1.1F, 0.0F, 0.0F, -0.781F)
      );
      PartDefinition BodyLayer_r8 = Chestplate.addOrReplaceChild(
         "BodyLayer_r8",
         CubeListBuilder.create().texOffs(19, 16).mirror().addBox(-2.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(0.0F, 5.0F, -1.15F, 0.0F, 0.0F, 0.7898F)
      );
      PartDefinition BodyLayer_r9 = Chestplate.addOrReplaceChild(
         "BodyLayer_r9",
         CubeListBuilder.create().texOffs(35, 0).mirror().addBox(-2.0F, -2.2F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false),
         PartPose.offsetAndRotation(-0.2F, 5.0F, -1.275F, 0.0F, 0.0F, 0.7898F)
      );
      PartDefinition BodyLayer_r10 = Chestplate.addOrReplaceChild(
         "BodyLayer_r10",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.0F, 7.875F, -0.475F, 0.0F, 0.0F, -2.378F)
      );
      PartDefinition BodyLayer_r11 = Chestplate.addOrReplaceChild(
         "BodyLayer_r11",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.0F, 3.375F, -0.475F, 0.0F, 0.0F, -2.378F)
      );
      PartDefinition BodyLayer_r12 = Chestplate.addOrReplaceChild(
         "BodyLayer_r12",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(0.55F, 3.0F, -0.675F, 0.0F, 0.0F, -3.1285F)
      );
      PartDefinition BodyLayer_r13 = Chestplate.addOrReplaceChild(
         "BodyLayer_r13",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(-0.375F, 7.2F, -0.475F, 0.0F, 0.0F, 2.3693F)
      );
      PartDefinition BodyLayer_r14 = Chestplate.addOrReplaceChild(
         "BodyLayer_r14",
         CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(-0.15F, 2.7F, -0.475F, 0.0F, 0.0F, 2.3693F)
      );
      PartDefinition BodyLayer_r15 = Chestplate.addOrReplaceChild(
         "BodyLayer_r15",
         CubeListBuilder.create().texOffs(20, 16).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-0.7F, 4.3F, -1.1F, 0.0F, 0.0F, 0.781F)
      );
      PartDefinition BodyLayer_r16 = Chestplate.addOrReplaceChild(
         "BodyLayer_r16",
         CubeListBuilder.create().texOffs(19, 16).addBox(0.0F, -8.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, -1.15F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition BodyLayer_r17 = Chestplate.addOrReplaceChild(
         "BodyLayer_r17",
         CubeListBuilder.create().texOffs(37, 9).addBox(-5.0F, -2.0F, -2.5F, 13.0F, 2.0F, 5.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(0.0F, 7.225F, 1.375F, 0.0F, 0.0F, -0.9163F)
      );
      PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
      PartDefinition RightArmLayer_r1 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r1",
         CubeListBuilder.create().texOffs(42, 21).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.3F, -0.7F, 0.4F, 0.1309F, 0.0F, -0.6109F)
      );
      PartDefinition RightArmLayer_r2 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r2",
         CubeListBuilder.create()
            .texOffs(0, 16)
            .addBox(-1.0F, 1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(0, 16)
            .addBox(-1.0F, 3.3F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(0, 16)
            .addBox(-1.0F, 5.975F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-2.1F, 1.025F, -0.3F, 0.0F, -0.1745F, 0.0F)
      );
      PartDefinition RightLegging = partdefinition.addOrReplaceChild(
         "RightLegging",
         CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftLegLayer_r1 = RightLegging.addOrReplaceChild(
         "LeftLegLayer_r1",
         CubeListBuilder.create().texOffs(31, 48).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(-0.2F, 5.9F, 0.0F, 0.1848F, -0.0668F, 0.6701F)
      );
      PartDefinition RightLegLayer_r1 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r1",
         CubeListBuilder.create().texOffs(31, 48).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.175F, 2.75F, 0.0F, 0.1918F, -0.0422F, 0.5675F)
      );
      PartDefinition LeftLegging = partdefinition.addOrReplaceChild(
         "LeftLegging",
         CubeListBuilder.create().texOffs(48, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftLegLayer_r2 = LeftLegging.addOrReplaceChild(
         "LeftLegLayer_r2",
         CubeListBuilder.create().texOffs(31, 48).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(0.175F, 2.75F, 0.0F, 0.1918F, 0.0422F, -0.5675F)
      );
      PartDefinition RightLegLayer_r2 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r2",
         CubeListBuilder.create().texOffs(31, 48).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.2F, 5.9F, 0.0F, 0.1848F, 0.0668F, -0.6701F)
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
      PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
      PartDefinition LeftArmLayer_r1 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r1",
         CubeListBuilder.create().texOffs(42, 21).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(1.3F, -0.7F, 0.4F, 0.1309F, 0.0F, 0.6109F)
      );
      PartDefinition LeftArmLayer_r2 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r2",
         CubeListBuilder.create()
            .texOffs(0, 16)
            .mirror()
            .addBox(-3.0F, 1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(0, 16)
            .mirror()
            .addBox(-3.0F, -1.675F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(0, 16)
            .mirror()
            .addBox(-3.0F, -3.975F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.55F))
            .mirror(false),
         PartPose.offsetAndRotation(2.1F, 6.0F, -0.3F, 0.0F, 0.1745F, 0.0F)
      );
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(
      PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha
   ) {
      this.Helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Chestplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLegging.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
