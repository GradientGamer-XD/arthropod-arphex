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

public class Modelimmortal<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modelimmortal"), "main");
   public final ModelPart Helmet;
   public final ModelPart Chestplate;
   public final ModelPart RightPlate;
   public final ModelPart LeftPlate;
   public final ModelPart RightLegging;
   public final ModelPart LeftLegging;
   public final ModelPart RightBoot;
   public final ModelPart LeftBoot;

   public Modelimmortal(ModelPart root) {
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
      PartDefinition Helmet = partdefinition.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
      PartDefinition HatLayer_r1 = Helmet.addOrReplaceChild(
         "HatLayer_r1",
         CubeListBuilder.create()
            .texOffs(16, 6)
            .addBox(-2.0F, 0.65F, 0.5F, 4.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .texOffs(16, 6)
            .addBox(-2.475F, 0.0F, 0.5F, 5.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .texOffs(16, 6)
            .mirror()
            .addBox(-2.15F, 0.65F, 0.5F, 4.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .mirror(false),
         PartPose.offsetAndRotation(0.075F, -8.575F, -3.25F, 0.7854F, 0.0F, 0.0F)
      );
      PartDefinition HatLayer_r2 = Helmet.addOrReplaceChild(
         "HatLayer_r2",
         CubeListBuilder.create().texOffs(19, 7).addBox(0.0F, -1.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(2.075F, -9.575F, -3.35F, -0.4608F, -0.1393F, -0.2727F)
      );
      PartDefinition BodyLayer_r1 = Helmet.addOrReplaceChild(
         "BodyLayer_r1",
         CubeListBuilder.create().texOffs(25, 10).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.825F, -1.175F, 0.05F, -2.6497F, 0.0725F, 2.7909F)
      );
      PartDefinition BodyLayer_r2 = Helmet.addOrReplaceChild(
         "BodyLayer_r2",
         CubeListBuilder.create().texOffs(25, 10).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.425F, -2.6829F, 0.835F, -2.6494F, 0.0704F, 2.7948F)
      );
      PartDefinition BodyLayer_r3 = Helmet.addOrReplaceChild(
         "BodyLayer_r3",
         CubeListBuilder.create().texOffs(25, 10).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.8F, -5.477F, 2.2895F, -3.0987F, 0.0082F, 2.9101F)
      );
      PartDefinition BodyLayer_r4 = Helmet.addOrReplaceChild(
         "BodyLayer_r4",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-1.9F, -7.1623F, 3.1668F, -3.0987F, 0.0082F, 2.9101F)
      );
      PartDefinition BodyLayer_r5 = Helmet.addOrReplaceChild(
         "BodyLayer_r5",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.0F, -7.1623F, 3.1668F, -3.0987F, -0.0082F, -2.9101F)
      );
      PartDefinition BodyLayer_r6 = Helmet.addOrReplaceChild(
         "BodyLayer_r6",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.9F, -5.477F, 2.2895F, -3.0987F, -0.0082F, -2.9101F)
      );
      PartDefinition BodyLayer_r7 = Helmet.addOrReplaceChild(
         "BodyLayer_r7",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.525F, -2.6829F, 0.835F, -2.6494F, -0.0704F, -2.7948F)
      );
      PartDefinition BodyLayer_r8 = Helmet.addOrReplaceChild(
         "BodyLayer_r8",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.925F, -1.175F, 0.05F, -2.6497F, -0.0725F, -2.7909F)
      );
      PartDefinition BodyLayer_r9 = Helmet.addOrReplaceChild(
         "BodyLayer_r9",
         CubeListBuilder.create().texOffs(28, 6).addBox(1.0F, -1.2F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.4F)),
         PartPose.offsetAndRotation(0.15F, -6.9F, -2.35F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition BodyLayer_r10 = Helmet.addOrReplaceChild(
         "BodyLayer_r10",
         CubeListBuilder.create().texOffs(64, 0).addBox(1.0F, -1.2F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.4F)),
         PartPose.offsetAndRotation(0.15F, -7.7F, -2.35F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition BodyLayer_r11 = Helmet.addOrReplaceChild(
         "BodyLayer_r11",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.875F, -1.175F, -1.15F, 0.0412F, -0.0941F, -0.3457F)
      );
      PartDefinition BodyLayer_r12 = Helmet.addOrReplaceChild(
         "BodyLayer_r12",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.475F, -2.875F, -1.15F, 0.0449F, -0.0924F, -0.3851F)
      );
      PartDefinition BodyLayer_r13 = Helmet.addOrReplaceChild(
         "BodyLayer_r13",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.85F, -6.025F, -1.15F, -0.4257F, -0.0988F, -0.2099F)
      );
      PartDefinition BodyLayer_r14 = Helmet.addOrReplaceChild(
         "BodyLayer_r14",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-1.95F, -7.925F, -1.15F, -0.4257F, -0.0988F, -0.2099F)
      );
      PartDefinition BodyLayer_r15 = Helmet.addOrReplaceChild(
         "BodyLayer_r15",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.95F, -7.925F, -1.15F, -0.4257F, 0.0988F, 0.2099F)
      );
      PartDefinition BodyLayer_r16 = Helmet.addOrReplaceChild(
         "BodyLayer_r16",
         CubeListBuilder.create().texOffs(25, 10).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.85F, -6.025F, -1.15F, -0.4257F, 0.0988F, 0.2099F)
      );
      PartDefinition BodyLayer_r17 = Helmet.addOrReplaceChild(
         "BodyLayer_r17",
         CubeListBuilder.create().texOffs(25, 10).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.475F, -2.875F, -1.15F, 0.0449F, 0.0924F, 0.3851F)
      );
      PartDefinition BodyLayer_r18 = Helmet.addOrReplaceChild(
         "BodyLayer_r18",
         CubeListBuilder.create().texOffs(25, 10).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.875F, -1.175F, -1.15F, 0.0412F, 0.0941F, 0.3457F)
      );
      PartDefinition BodyLayer_r19 = Helmet.addOrReplaceChild(
         "BodyLayer_r19",
         CubeListBuilder.create().texOffs(63, 1).mirror().addBox(-1.0F, -1.2F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.4F)).mirror(false),
         PartPose.offsetAndRotation(-0.15F, -6.9F, -2.35F, 0.0F, 0.0F, 0.7898F)
      );
      PartDefinition BodyLayer_r20 = Helmet.addOrReplaceChild(
         "BodyLayer_r20",
         CubeListBuilder.create().texOffs(28, 6).mirror().addBox(-1.0F, -1.2F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.4F)).mirror(false),
         PartPose.offsetAndRotation(-0.15F, -7.7F, -2.35F, 0.0F, 0.0F, 0.7898F)
      );
      PartDefinition BodyLayer_r21 = Helmet.addOrReplaceChild(
         "BodyLayer_r21",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.925F, -1.175F, 0.05F, -2.6497F, 0.0725F, 2.7909F)
      );
      PartDefinition BodyLayer_r22 = Helmet.addOrReplaceChild(
         "BodyLayer_r22",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.525F, -2.6829F, 0.835F, -2.6494F, 0.0704F, 2.7948F)
      );
      PartDefinition BodyLayer_r23 = Helmet.addOrReplaceChild(
         "BodyLayer_r23",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.9F, -5.477F, 2.2895F, -3.0987F, 0.0082F, 2.9101F)
      );
      PartDefinition BodyLayer_r24 = Helmet.addOrReplaceChild(
         "BodyLayer_r24",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.0F, -7.1623F, 3.1668F, -3.0987F, 0.0082F, 2.9101F)
      );
      PartDefinition BodyLayer_r25 = Helmet.addOrReplaceChild(
         "BodyLayer_r25",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(1.9F, -7.1623F, 3.1668F, -3.0987F, -0.0082F, -2.9101F)
      );
      PartDefinition BodyLayer_r26 = Helmet.addOrReplaceChild(
         "BodyLayer_r26",
         CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.8F, -5.477F, 2.2895F, -3.0987F, -0.0082F, -2.9101F)
      );
      PartDefinition BodyLayer_r27 = Helmet.addOrReplaceChild(
         "BodyLayer_r27",
         CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.425F, -2.6829F, 0.835F, -2.6494F, -0.0704F, -2.7948F)
      );
      PartDefinition BodyLayer_r28 = Helmet.addOrReplaceChild(
         "BodyLayer_r28",
         CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.825F, -1.175F, 0.05F, -2.6497F, -0.0725F, -2.7909F)
      );
      PartDefinition BodyLayer_r29 = Helmet.addOrReplaceChild(
         "BodyLayer_r29",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.475F, -2.875F, 3.35F, 0.0408F, 0.0943F, 0.3413F)
      );
      PartDefinition BodyLayer_r30 = Helmet.addOrReplaceChild(
         "BodyLayer_r30",
         CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.85F, -6.025F, 3.35F, -0.4257F, -0.0988F, -0.2099F)
      );
      PartDefinition BodyLayer_r31 = Helmet.addOrReplaceChild(
         "BodyLayer_r31",
         CubeListBuilder.create().texOffs(21, 6).mirror().addBox(-1.15F, -1.775F, -4.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-1.95F, -7.925F, 3.35F, -0.2546F, -0.075F, -0.2207F)
      );
      PartDefinition BodyLayer_r32 = Helmet.addOrReplaceChild(
         "BodyLayer_r32",
         CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-1.0F, -7.0F, -2.0F, 0.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.7F, -6.475F, -1.95F, -0.4228F, 0.1114F, 0.2466F)
      );
      PartDefinition BodyLayer_r33 = Helmet.addOrReplaceChild(
         "BodyLayer_r33",
         CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-1.0F, -8.0F, -2.0F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-1.45F, -6.475F, -1.95F, -0.4228F, 0.1114F, 0.2466F)
      );
      PartDefinition BodyLayer_r34 = Helmet.addOrReplaceChild(
         "BodyLayer_r34",
         CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.875F, -1.175F, 3.35F, 0.0412F, -0.0941F, -0.3457F)
      );
      PartDefinition BodyLayer_r35 = Helmet.addOrReplaceChild(
         "BodyLayer_r35",
         CubeListBuilder.create().texOffs(25, 10).mirror().addBox(-1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-2.475F, -2.875F, 3.35F, 0.0408F, -0.0943F, -0.3413F)
      );
      PartDefinition BodyLayer_r36 = Helmet.addOrReplaceChild(
         "BodyLayer_r36",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.875F, -1.175F, 3.35F, 0.0412F, 0.0941F, 0.3457F)
      );
      PartDefinition BodyLayer_r37 = Helmet.addOrReplaceChild(
         "BodyLayer_r37",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -6.0F, -2.0F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.85F, -6.025F, 3.35F, -0.4257F, 0.0988F, 0.2099F)
      );
      PartDefinition BodyLayer_r38 = Helmet.addOrReplaceChild(
         "BodyLayer_r38",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.15F, -1.775F, -4.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.95F, -7.925F, 3.35F, -0.2546F, 0.075F, 0.2207F)
      );
      PartDefinition BodyLayer_r39 = Helmet.addOrReplaceChild(
         "BodyLayer_r39",
         CubeListBuilder.create().texOffs(26, 0).addBox(1.0F, -8.0F, -2.0F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.45F, -6.475F, -1.95F, -0.4228F, -0.1114F, -0.2466F)
      );
      PartDefinition BodyLayer_r40 = Helmet.addOrReplaceChild(
         "BodyLayer_r40",
         CubeListBuilder.create().texOffs(26, 0).addBox(1.0F, -7.0F, -2.0F, 0.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(2.7F, -6.475F, -1.95F, -0.4228F, -0.1114F, -0.2466F)
      );
      PartDefinition HatLayer_r3 = Helmet.addOrReplaceChild(
         "HatLayer_r3",
         CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-2.075F, -9.575F, -3.35F, -0.4608F, 0.1393F, 0.2727F)
      );
      PartDefinition HatLayer_r4 = Helmet.addOrReplaceChild(
         "HatLayer_r4",
         CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(1.925F, -9.575F, -3.35F, -0.4608F, -0.1393F, -0.2727F)
      );
      PartDefinition Chestplate = partdefinition.addOrReplaceChild("Chestplate", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition HatLayer_r5 = Chestplate.addOrReplaceChild(
         "HatLayer_r5",
         CubeListBuilder.create()
            .texOffs(9, 36)
            .addBox(0.5F, 0.5F, -4.0F, 18.0F, 0.0F, 2.0F, new CubeDeformation(0.25F))
            .texOffs(9, 36)
            .addBox(0.5F, 0.5F, -4.0F, 13.0F, 0.0F, 2.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(5.35F, -1.275F, 4.7F, -0.2381F, -0.1247F, -0.9129F)
      );
      PartDefinition HatLayer_r6 = Chestplate.addOrReplaceChild(
         "HatLayer_r6",
         CubeListBuilder.create()
            .texOffs(6, 37)
            .addBox(0.5F, 0.5F, -3.0F, 22.0F, 0.0F, 0.0F, new CubeDeformation(0.35F))
            .texOffs(9, 37)
            .addBox(0.5F, 0.5F, -3.0F, 15.0F, 0.0F, 0.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(5.35F, -0.675F, 3.775F, -0.4549F, -0.4774F, -0.4507F)
      );
      PartDefinition HatLayer_r7 = Chestplate.addOrReplaceChild(
         "HatLayer_r7",
         CubeListBuilder.create()
            .texOffs(9, 37)
            .mirror()
            .addBox(-16.5F, 0.5F, -3.0F, 16.0F, 0.0F, 0.0F, new CubeDeformation(0.35F))
            .mirror(false)
            .texOffs(9, 37)
            .mirror()
            .addBox(-10.5F, 0.5F, -3.0F, 10.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .mirror(false),
         PartPose.offsetAndRotation(-4.05F, -0.675F, 3.775F, -0.5926F, -0.0797F, -1.2572F)
      );
      PartDefinition HatLayer_r8 = Chestplate.addOrReplaceChild(
         "HatLayer_r8",
         CubeListBuilder.create()
            .texOffs(18, 37)
            .mirror()
            .addBox(-10.5F, 0.5F, -3.0F, 10.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(9, 37)
            .mirror()
            .addBox(-19.5F, 0.5F, -3.0F, 19.0F, 0.0F, 0.0F, new CubeDeformation(0.35F))
            .mirror(false),
         PartPose.offsetAndRotation(-5.35F, -0.675F, 3.775F, -0.5116F, 0.323F, -0.6249F)
      );
      PartDefinition HatLayer_r9 = Chestplate.addOrReplaceChild(
         "HatLayer_r9",
         CubeListBuilder.create()
            .texOffs(9, 37)
            .addBox(0.5F, 0.5F, -3.125F, 14.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .texOffs(9, 37)
            .addBox(10.425F, 0.5F, -3.0F, 11.0F, 0.0F, 0.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(5.35F, -0.675F, 3.775F, -0.6312F, -0.1531F, 0.0977F)
      );
      PartDefinition BodyLayer_r41 = Chestplate.addOrReplaceChild(
         "BodyLayer_r41",
         CubeListBuilder.create().texOffs(40, 3).mirror().addBox(-2.0F, -4.2F, -3.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
         PartPose.offsetAndRotation(-0.225F, 6.0F, -1.375F, 0.0F, 0.0F, 0.7898F)
      );
      PartDefinition HatLayer_r10 = Chestplate.addOrReplaceChild(
         "HatLayer_r10",
         CubeListBuilder.create()
            .texOffs(22, 37)
            .mirror()
            .addBox(-21.425F, 0.5F, -3.0F, 11.0F, 0.0F, 0.0F, new CubeDeformation(0.35F))
            .mirror(false)
            .texOffs(14, 37)
            .mirror()
            .addBox(-14.5F, 0.5F, -3.125F, 14.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .mirror(false),
         PartPose.offsetAndRotation(-5.35F, -0.675F, 3.775F, -0.6312F, 0.1531F, -0.0977F)
      );
      PartDefinition HatLayer_r11 = Chestplate.addOrReplaceChild(
         "HatLayer_r11",
         CubeListBuilder.create()
            .texOffs(13, 37)
            .mirror()
            .addBox(-15.5F, 0.5F, -3.0F, 15.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(6, 37)
            .mirror()
            .addBox(-22.5F, 0.5F, -3.0F, 22.0F, 0.0F, 0.0F, new CubeDeformation(0.35F))
            .mirror(false),
         PartPose.offsetAndRotation(-5.35F, -0.675F, 3.775F, -0.4549F, 0.4774F, 0.4507F)
      );
      PartDefinition BodyLayer_r42 = Chestplate.addOrReplaceChild(
         "BodyLayer_r42",
         CubeListBuilder.create().texOffs(20, 14).mirror().addBox(-0.5F, -9.0F, -3.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-0.725F, 3.5F, -0.625F, 0.0F, 0.0F, 2.378F)
      );
      PartDefinition BodyLayer_r43 = Chestplate.addOrReplaceChild(
         "BodyLayer_r43",
         CubeListBuilder.create().texOffs(19, 14).mirror().addBox(-1.0F, -8.0F, -2.0F, 0.0F, 12.0F, 6.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(1.95F, 6.5F, -1.1F, 0.0F, 0.0F, -0.6065F)
      );
      PartDefinition BodyLayer_r44 = Chestplate.addOrReplaceChild(
         "BodyLayer_r44",
         CubeListBuilder.create().texOffs(19, 15).mirror().addBox(-1.2F, -6.175F, -1.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(2.05F, 1.35F, -0.975F, 0.0F, 0.0F, 0.6152F)
      );
      PartDefinition BodyLayer_r45 = Chestplate.addOrReplaceChild(
         "BodyLayer_r45",
         CubeListBuilder.create().texOffs(19, 14).mirror().addBox(-0.5F, -8.0F, -3.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-0.725F, 5.525F, -0.475F, 0.0F, 0.0F, -0.6763F)
      );
      PartDefinition BodyLayer_r46 = Chestplate.addOrReplaceChild(
         "BodyLayer_r46",
         CubeListBuilder.create().texOffs(19, 14).addBox(0.5F, -9.0F, -3.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(0.725F, 3.5F, -0.625F, 0.0F, 0.0F, -2.378F)
      );
      PartDefinition BodyLayer_r47 = Chestplate.addOrReplaceChild(
         "BodyLayer_r47",
         CubeListBuilder.create().texOffs(19, 14).addBox(0.5F, -8.0F, -3.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(0.725F, 5.525F, -0.475F, 0.0F, 0.0F, 0.6763F)
      );
      PartDefinition BodyLayer_r48 = Chestplate.addOrReplaceChild(
         "BodyLayer_r48",
         CubeListBuilder.create().texOffs(19, 14).addBox(1.0F, -8.0F, -2.0F, 0.0F, 12.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-1.95F, 6.5F, -1.1F, 0.0F, 0.0F, 0.6065F)
      );
      PartDefinition BodyLayer_r49 = Chestplate.addOrReplaceChild(
         "BodyLayer_r49",
         CubeListBuilder.create().texOffs(20, 15).addBox(1.2F, -6.175F, -1.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-2.05F, 1.35F, -0.9F, 0.0F, 0.0F, -0.6152F)
      );
      PartDefinition BodyLayer_r50 = Chestplate.addOrReplaceChild(
         "BodyLayer_r50",
         CubeListBuilder.create().texOffs(40, 3).addBox(2.0F, -4.2F, -3.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.3F)),
         PartPose.offsetAndRotation(0.225F, 6.0F, -1.375F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition HatLayer_r12 = Chestplate.addOrReplaceChild(
         "HatLayer_r12",
         CubeListBuilder.create()
            .texOffs(9, 37)
            .addBox(0.5F, 0.5F, -3.0F, 10.0F, 0.0F, 0.0F, new CubeDeformation(0.55F))
            .texOffs(9, 37)
            .addBox(0.5F, 0.5F, -3.0F, 16.0F, 0.0F, 0.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(4.05F, -0.675F, 3.775F, -0.5926F, 0.0797F, 1.2572F)
      );
      PartDefinition HatLayer_r13 = Chestplate.addOrReplaceChild(
         "HatLayer_r13",
         CubeListBuilder.create()
            .texOffs(9, 37)
            .addBox(0.5F, 0.5F, -3.0F, 19.0F, 0.0F, 0.0F, new CubeDeformation(0.35F))
            .texOffs(9, 37)
            .addBox(0.5F, 0.5F, -3.0F, 10.0F, 0.0F, 0.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(5.35F, -0.675F, 3.775F, -0.5116F, -0.323F, 0.6249F)
      );
      PartDefinition HatLayer_r14 = Chestplate.addOrReplaceChild(
         "HatLayer_r14",
         CubeListBuilder.create()
            .texOffs(14, 36)
            .mirror()
            .addBox(-13.5F, 0.5F, -4.0F, 13.0F, 0.0F, 2.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(9, 36)
            .mirror()
            .addBox(-18.5F, 0.5F, -4.0F, 18.0F, 0.0F, 2.0F, new CubeDeformation(0.25F))
            .mirror(false),
         PartPose.offsetAndRotation(-5.35F, -1.275F, 4.7F, -0.2381F, 0.1247F, 0.9129F)
      );
      PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate", CubeListBuilder.create(), PartPose.offset(-4.45F, 2.0F, 0.0F));
      PartDefinition RightArmLayer_r1 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r1",
         CubeListBuilder.create().texOffs(39, 15).mirror().addBox(-1.0F, 1.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-1.3F, -3.2F, 0.45F, 0.102F, 0.0822F, -1.235F)
      );
      PartDefinition HatLayer_r15 = RightPlate.addOrReplaceChild(
         "HatLayer_r15",
         CubeListBuilder.create().texOffs(11, 3).mirror().addBox(-3.5F, -0.625F, -5.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(-0.375F, -0.95F, 1.8F, 0.2364F, 0.2567F, 1.291F)
      );
      PartDefinition RightArmLayer_r2 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r2",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-5.3F, 0.9F, 0.4F, 0.1309F, 0.0F, -0.6109F)
      );
      PartDefinition RightArmLayer_r3 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r3",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.4F, -1.775F, 0.4F, 0.1309F, 0.0F, -0.6109F)
      );
      PartDefinition RightArmLayer_r4 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r4",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.85F, 4.225F, 0.4F, 0.121F, 0.05F, -1.0005F)
      );
      PartDefinition HatLayer_r16 = RightPlate.addOrReplaceChild(
         "HatLayer_r16",
         CubeListBuilder.create().texOffs(14, 7).mirror().addBox(-7.575F, 0.5F, -1.55F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-0.375F, -1.05F, 1.8F, 0.2364F, 0.2567F, 1.291F)
      );
      PartDefinition RightArmLayer_r5 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r5",
         CubeListBuilder.create().texOffs(-2, 15).addBox(-8.0F, 0.0F, -3.0F, 10.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.4F, 0.2F, 0.4F, 0.1285F, 0.0249F, -0.8012F)
      );
      PartDefinition HatLayer_r17 = RightPlate.addOrReplaceChild(
         "HatLayer_r17",
         CubeListBuilder.create().texOffs(15, 7).mirror().addBox(-7.6F, 0.5F, -1.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(-1.45F, -3.7F, 1.85F, 0.2441F, 0.2397F, 1.2912F)
      );
      PartDefinition HatLayer_r18 = RightPlate.addOrReplaceChild(
         "HatLayer_r18",
         CubeListBuilder.create().texOffs(11, 3).mirror().addBox(-3.5F, -0.35F, -5.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.45F)).mirror(false),
         PartPose.offsetAndRotation(-1.55F, -4.6F, 2.65F, 0.2441F, 0.2397F, 1.2912F)
      );
      PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate", CubeListBuilder.create(), PartPose.offset(4.45F, 2.0F, 0.0F));
      PartDefinition LeftArmLayer_r1 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r1",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, 1.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.3F, -3.2F, 0.45F, 0.102F, -0.0822F, 1.235F)
      );
      PartDefinition LeftArmLayer_r2 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r2",
         CubeListBuilder.create().texOffs(-1, 15).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(5.3F, 0.9F, 0.4F, 0.1309F, 0.0F, 0.6109F)
      );
      PartDefinition HatLayer_r19 = LeftPlate.addOrReplaceChild(
         "HatLayer_r19",
         CubeListBuilder.create().texOffs(13, 5).addBox(0.5F, -0.35F, -5.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.45F)),
         PartPose.offsetAndRotation(1.55F, -4.6F, 2.65F, 0.2441F, -0.2397F, -1.2912F)
      );
      PartDefinition HatLayer_r20 = LeftPlate.addOrReplaceChild(
         "HatLayer_r20",
         CubeListBuilder.create().texOffs(15, 7).addBox(4.6F, 0.5F, -1.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(1.45F, -3.7F, 1.85F, 0.2441F, -0.2397F, -1.2912F)
      );
      PartDefinition LeftArmLayer_r3 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r3",
         CubeListBuilder.create().texOffs(-1, 15).mirror().addBox(-4.0F, 0.0F, -3.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(1.85F, 4.225F, 0.4F, 0.121F, -0.05F, 1.0005F)
      );
      PartDefinition LeftArmLayer_r4 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r4",
         CubeListBuilder.create().texOffs(-1, 15).mirror().addBox(-2.0F, 0.0F, -3.0F, 10.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(1.4F, 0.2F, 0.4F, 0.1285F, -0.0249F, 0.8012F)
      );
      PartDefinition LeftArmLayer_r5 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r5",
         CubeListBuilder.create().texOffs(-1, 15).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(1.4F, -1.775F, 0.4F, 0.1309F, 0.0F, 0.6109F)
      );
      PartDefinition HatLayer_r21 = LeftPlate.addOrReplaceChild(
         "HatLayer_r21",
         CubeListBuilder.create().texOffs(14, 7).addBox(4.575F, 0.5F, -1.55F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(0.375F, -1.05F, 1.8F, 0.2364F, -0.2567F, -1.291F)
      );
      PartDefinition HatLayer_r22 = LeftPlate.addOrReplaceChild(
         "HatLayer_r22",
         CubeListBuilder.create().texOffs(13, 5).addBox(0.5F, -0.625F, -5.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.375F, -0.95F, 1.8F, 0.2364F, -0.2567F, -1.291F)
      );
      PartDefinition RightLegging = partdefinition.addOrReplaceChild("RightLegging", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
      PartDefinition RightLegLayer_r1 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r1",
         CubeListBuilder.create().texOffs(16, 48).mirror().addBox(-4.9F, 0.0F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(0.5F, 4.725F, 0.0F, 0.0F, 0.0F, -0.5672F)
      );
      PartDefinition LeftLegLayer_r1 = RightLegging.addOrReplaceChild(
         "LeftLegLayer_r1",
         CubeListBuilder.create().texOffs(48, 48).mirror().addBox(-3.0F, -1.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(-1.325F, 0.15F, 0.0F, 0.1963F, 0.0F, 0.3272F)
      );
      PartDefinition RightLegLayer_r2 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r2",
         CubeListBuilder.create().texOffs(31, 48).addBox(-3.0F, -1.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-2.0F, 4.05F, 0.0F, 0.1093F, 0.1634F, -0.6237F)
      );
      PartDefinition RightLegLayer_r3 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r3",
         CubeListBuilder.create().texOffs(31, 48).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.175F, 6.0F, 0.0F, 0.1963F, 0.0F, 0.3534F)
      );
      PartDefinition RightLegLayer_r4 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r4",
         CubeListBuilder.create().texOffs(31, 48).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.775F, 1.05F, 0.0F, 0.1086F, 0.1639F, -0.6281F)
      );
      PartDefinition LeftLegging = partdefinition.addOrReplaceChild("LeftLegging", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
      PartDefinition LeftLegLayer_r2 = LeftLegging.addOrReplaceChild(
         "LeftLegLayer_r2",
         CubeListBuilder.create().texOffs(31, 48).mirror().addBox(-1.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(1.775F, 1.05F, 0.0F, 0.1086F, -0.1639F, 0.6281F)
      );
      PartDefinition LeftLegLayer_r3 = LeftLegging.addOrReplaceChild(
         "LeftLegLayer_r3",
         CubeListBuilder.create().texOffs(31, 48).mirror().addBox(-6.0F, -1.0F, -2.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)).mirror(false),
         PartPose.offsetAndRotation(2.0F, 4.05F, 0.0F, 0.1093F, -0.1634F, 0.6237F)
      );
      PartDefinition LeftLegLayer_r4 = LeftLegging.addOrReplaceChild(
         "LeftLegLayer_r4",
         CubeListBuilder.create().texOffs(16, 48).addBox(-1.1F, 0.0F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-0.5F, 4.725F, 0.0F, 0.0F, 0.0F, 0.5672F)
      );
      PartDefinition RightLegLayer_r5 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r5",
         CubeListBuilder.create().texOffs(32, 42).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.2F, 6.0F, 0.0F, 0.1963F, 0.0F, -0.3272F)
      );
      PartDefinition RightLegLayer_r6 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r6",
         CubeListBuilder.create().texOffs(48, 48).addBox(-2.0F, -1.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(1.325F, 0.15F, 0.0F, 0.1963F, 0.0F, -0.3272F)
      );
      PartDefinition RightBoot = partdefinition.addOrReplaceChild(
         "RightBoot",
         CubeListBuilder.create().texOffs(20, 52).mirror().addBox(-2.825F, 7.5F, 0.125F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition RightLegLayer_r7 = RightBoot.addOrReplaceChild(
         "RightLegLayer_r7",
         CubeListBuilder.create().texOffs(20, 52).addBox(-3.75F, -8.0F, 2.0F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-0.8F, 13.7F, -1.0F, 0.0F, 0.0F, 0.3403F)
      );
      PartDefinition RightLegLayer_r8 = RightBoot.addOrReplaceChild(
         "RightLegLayer_r8",
         CubeListBuilder.create().texOffs(16, 48).mirror().addBox(-4.9F, 0.0F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(0.5F, 8.625F, 0.0F, 0.0F, 0.0F, -0.5672F)
      );
      PartDefinition LeftBoot = partdefinition.addOrReplaceChild(
         "LeftBoot",
         CubeListBuilder.create().texOffs(20, 52).addBox(2.825F, 7.5F, 0.125F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.55F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftLegLayer_r5 = LeftBoot.addOrReplaceChild(
         "LeftLegLayer_r5",
         CubeListBuilder.create().texOffs(20, 52).mirror().addBox(3.75F, -8.0F, 2.0F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(0.8F, 13.7F, -1.0F, 0.0F, 0.0F, -0.3403F)
      );
      PartDefinition LeftLegLayer_r6 = LeftBoot.addOrReplaceChild(
         "LeftLegLayer_r6",
         CubeListBuilder.create().texOffs(16, 48).addBox(-1.1F, 0.0F, -2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-0.5F, 8.625F, 0.0F, 0.0F, 0.0F, 0.5672F)
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
