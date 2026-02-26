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

public class Modeleternal<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "modeleternal"), "main");
   public final ModelPart Helmet;
   public final ModelPart Chestplate;
   public final ModelPart RightPlate;
   public final ModelPart LeftPlate;
   public final ModelPart RightLegging;
   public final ModelPart LeftLegging;
   public final ModelPart RightBoot;
   public final ModelPart LeftBoot;
   public final ModelPart bb_main;

   public Modeleternal(ModelPart root) {
      this.Helmet = root.getChild("Helmet");
      this.Chestplate = root.getChild("Chestplate");
      this.RightPlate = root.getChild("RightPlate");
      this.LeftPlate = root.getChild("LeftPlate");
      this.RightLegging = root.getChild("RightLegging");
      this.LeftLegging = root.getChild("LeftLegging");
      this.RightBoot = root.getChild("RightBoot");
      this.LeftBoot = root.getChild("LeftBoot");
      this.bb_main = root.getChild("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Helmet = partdefinition.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
      PartDefinition BodyLayer_r1 = Helmet.addOrReplaceChild(
         "BodyLayer_r1",
         CubeListBuilder.create().texOffs(23, 8).mirror().addBox(-1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(-1.95F, -8.225F, -2.45F, -0.4257F, -0.0988F, -0.2099F)
      );
      PartDefinition HatLayer_r1 = Helmet.addOrReplaceChild(
         "HatLayer_r1",
         CubeListBuilder.create().texOffs(17, 7).mirror().addBox(-2.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-0.075F, -8.575F, -3.25F, 0.7854F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r2 = Helmet.addOrReplaceChild(
         "BodyLayer_r2",
         CubeListBuilder.create().texOffs(23, 8).addBox(1.0F, -3.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.95F, -8.225F, -2.45F, -0.4257F, 0.0988F, 0.2099F)
      );
      PartDefinition BodyLayer_r3 = Helmet.addOrReplaceChild(
         "BodyLayer_r3",
         CubeListBuilder.create().texOffs(26, 0).addBox(1.0F, -7.0F, -2.0F, 0.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.5F, -7.575F, -2.625F, -0.4349F, -0.0368F, -0.0835F)
      );
      PartDefinition HatLayer_r2 = Helmet.addOrReplaceChild(
         "HatLayer_r2",
         CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-2.075F, -9.575F, -3.35F, -0.4608F, 0.1393F, 0.2727F)
      );
      PartDefinition HatLayer_r3 = Helmet.addOrReplaceChild(
         "HatLayer_r3",
         CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(1.925F, -9.575F, -3.35F, -0.4608F, -0.1393F, -0.2727F)
      );
      PartDefinition BodyLayer_r4 = Helmet.addOrReplaceChild(
         "BodyLayer_r4",
         CubeListBuilder.create().texOffs(26, 1).addBox(1.0F, -7.0F, -2.0F, 0.0F, 6.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-3.675F, -7.575F, -2.625F, -0.4349F, 0.0368F, 0.0748F)
      );
      PartDefinition HatLayer_r4 = Helmet.addOrReplaceChild(
         "HatLayer_r4",
         CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-0.075F, -10.075F, -2.85F, -0.3491F, 0.0F, 0.0F)
      );
      PartDefinition BodyLayer_r5 = Helmet.addOrReplaceChild(
         "BodyLayer_r5",
         CubeListBuilder.create().texOffs(20, 8).addBox(1.0F, -4.0F, -2.0F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-1.05F, -8.575F, -1.9F, -0.3272F, 0.0F, -0.0044F)
      );
      PartDefinition HatLayer_r5 = Helmet.addOrReplaceChild(
         "HatLayer_r5",
         CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-4.5F, 0.5F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(5.475F, -4.225F, 0.15F, 0.2441F, 0.2397F, 1.2912F)
      );
      PartDefinition HatLayer_r6 = Helmet.addOrReplaceChild(
         "HatLayer_r6",
         CubeListBuilder.create().texOffs(7, 0).addBox(-1.5F, 0.5F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-5.35F, -4.225F, 0.1F, 0.2364F, -0.2567F, -1.291F)
      );
      PartDefinition BodyLayer_r6 = Helmet.addOrReplaceChild(
         "BodyLayer_r6",
         CubeListBuilder.create().texOffs(4, 26).addBox(1.0F, -1.2F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)),
         PartPose.offsetAndRotation(0.075F, -6.7F, -2.35F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition BodyLayer_r7 = Helmet.addOrReplaceChild(
         "BodyLayer_r7",
         CubeListBuilder.create().texOffs(40, 4).addBox(1.0F, -2.2F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)),
         PartPose.offsetAndRotation(0.075F, -6.0F, -2.275F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition Chestplate = partdefinition.addOrReplaceChild("Chestplate", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition BodyLayer_r8 = Chestplate.addOrReplaceChild(
         "BodyLayer_r8",
         CubeListBuilder.create().texOffs(18, 14).mirror().addBox(-1.5F, -8.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.25F)).mirror(false),
         PartPose.offsetAndRotation(1.1F, 7.7F, -0.475F, 0.0F, 0.0F, -0.8072F)
      );
      PartDefinition BodyLayer_r9 = Chestplate.addOrReplaceChild(
         "BodyLayer_r9",
         CubeListBuilder.create().texOffs(19, 14).addBox(0.5F, -6.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.05F, 7.0F, -0.475F, 0.0F, 0.0F, -2.378F)
      );
      PartDefinition BodyLayer_r10 = Chestplate.addOrReplaceChild(
         "BodyLayer_r10",
         CubeListBuilder.create().texOffs(18, 14).addBox(-0.5F, -6.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.26F)),
         PartPose.offsetAndRotation(-0.425F, 6.4F, -0.475F, 0.0F, 0.0F, 2.3693F)
      );
      PartDefinition BodyLayer_r11 = Chestplate.addOrReplaceChild(
         "BodyLayer_r11",
         CubeListBuilder.create().texOffs(19, 14).addBox(0.5F, -8.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-1.1F, 7.7F, -0.475F, 0.0F, 0.0F, 0.8072F)
      );
      PartDefinition BodyLayer_r12 = Chestplate.addOrReplaceChild(
         "BodyLayer_r12",
         CubeListBuilder.create().texOffs(19, 14).addBox(0.0F, -8.0F, -2.0F, 1.0F, 10.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(-1.0F, 3.8F, -1.1F, 0.0F, 0.0F, 0.781F)
      );
      PartDefinition BodyLayer_r13 = Chestplate.addOrReplaceChild(
         "BodyLayer_r13",
         CubeListBuilder.create().texOffs(18, 14).addBox(0.0F, -8.0F, -2.0F, 1.0F, 10.0F, 6.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(0.5F, 4.5F, -1.15F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition BodyLayer_r14 = Chestplate.addOrReplaceChild(
         "BodyLayer_r14",
         CubeListBuilder.create().texOffs(41, 4).addBox(2.0F, -2.2F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)),
         PartPose.offsetAndRotation(0.225F, 6.0F, -1.375F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition BodyLayer_r15 = Chestplate.addOrReplaceChild(
         "BodyLayer_r15",
         CubeListBuilder.create().texOffs(41, 4).addBox(2.0F, -2.2F, -2.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)),
         PartPose.offsetAndRotation(0.225F, 10.5F, -1.775F, 0.0F, 0.0F, -0.7898F)
      );
      PartDefinition HatLayer_r7 = Chestplate.addOrReplaceChild(
         "HatLayer_r7",
         CubeListBuilder.create().texOffs(12, 23).addBox(0.5F, 0.5F, -4.0F, 12.0F, 0.0F, 2.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(5.35F, -1.275F, 4.7F, -0.4549F, -0.4774F, -0.4507F)
      );
      PartDefinition HatLayer_r8 = Chestplate.addOrReplaceChild(
         "HatLayer_r8",
         CubeListBuilder.create().texOffs(9, 37).addBox(0.5F, 0.5F, -3.0F, 19.0F, 0.0F, 0.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(5.35F, -0.675F, 3.775F, -0.4549F, -0.4774F, -0.4507F)
      );
      PartDefinition HatLayer_r9 = Chestplate.addOrReplaceChild(
         "HatLayer_r9",
         CubeListBuilder.create().texOffs(9, 37).mirror().addBox(-19.5F, 0.5F, -3.0F, 19.0F, 0.0F, 0.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-5.35F, -0.675F, 3.775F, -0.4549F, 0.4774F, 0.4507F)
      );
      PartDefinition HatLayer_r10 = Chestplate.addOrReplaceChild(
         "HatLayer_r10",
         CubeListBuilder.create().texOffs(12, 23).mirror().addBox(-12.5F, 0.5F, -4.0F, 12.0F, 0.0F, 2.0F, new CubeDeformation(0.55F)).mirror(false),
         PartPose.offsetAndRotation(-5.35F, -1.275F, 4.7F, -0.4549F, 0.4774F, 0.4507F)
      );
      PartDefinition RightPlate = partdefinition.addOrReplaceChild("RightPlate", CubeListBuilder.create(), PartPose.offset(-4.45F, 2.0F, 0.0F));
      PartDefinition RightArmLayer_r1 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r1",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.9F, 5.925F, 0.4F, 0.1244F, 0.0409F, -0.9268F)
      );
      PartDefinition LeftArmLayer_r1 = RightPlate.addOrReplaceChild(
         "LeftArmLayer_r1",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, 1.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(1.0F, -2.7F, 0.7F, -0.0232F, -0.1299F, 2.0061F)
      );
      PartDefinition RightArmLayer_r2 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r2",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.4F, 3.325F, 0.4F, 0.1293F, 0.0204F, -0.7666F)
      );
      PartDefinition RightArmLayer_r3 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r3",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.4F, -1.775F, 0.4F, 0.1309F, 0.0F, -0.6109F)
      );
      PartDefinition RightArmLayer_r4 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r4",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-2.85F, 2.725F, 0.4F, 0.1308F, 0.0057F, -0.6541F)
      );
      PartDefinition RightArmLayer_r5 = RightPlate.addOrReplaceChild(
         "RightArmLayer_r5",
         CubeListBuilder.create().texOffs(-1, 15).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-1.4F, 0.2F, 0.4F, 0.1308F, 0.0057F, -0.6541F)
      );
      PartDefinition HatLayer_r11 = RightPlate.addOrReplaceChild(
         "HatLayer_r11",
         CubeListBuilder.create()
            .texOffs(15, 7)
            .mirror()
            .addBox(-7.6F, 0.5F, -1.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.55F))
            .mirror(false)
            .texOffs(11, 3)
            .mirror()
            .addBox(-3.5F, 0.5F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.55F))
            .mirror(false),
         PartPose.offsetAndRotation(-0.05F, -1.0F, 1.85F, 0.2441F, 0.2397F, 1.2912F)
      );
      PartDefinition LeftPlate = partdefinition.addOrReplaceChild("LeftPlate", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
      PartDefinition LeftArmLayer_r2 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r2",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, 1.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.25F)),
         PartPose.offsetAndRotation(0.75F, -3.2F, 0.4F, 0.102F, -0.0822F, 1.235F)
      );
      PartDefinition LeftArmLayer_r3 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r3",
         CubeListBuilder.create().texOffs(37, 15).addBox(-4.0F, 0.0F, -3.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(1.175F, 5.925F, 0.4F, 0.1219F, -0.0479F, 0.9308F)
      );
      PartDefinition LeftArmLayer_r4 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r4",
         CubeListBuilder.create().texOffs(38, 15).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(1.175F, 3.425F, 0.4F, 0.1282F, -0.0266F, 0.7619F)
      );
      PartDefinition LeftArmLayer_r5 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r5",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(1.175F, -1.875F, 0.4F, 0.1309F, 0.0F, 0.5585F)
      );
      PartDefinition LeftArmLayer_r6 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r6",
         CubeListBuilder.create().texOffs(37, 15).addBox(-4.0F, 0.0F, -3.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(2.5F, 3.0F, 0.4F, 0.1292F, -0.021F, 0.7186F)
      );
      PartDefinition LeftArmLayer_r7 = LeftPlate.addOrReplaceChild(
         "LeftArmLayer_r7",
         CubeListBuilder.create().texOffs(39, 15).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(1.175F, 0.45F, 0.4F, 0.1292F, -0.021F, 0.7186F)
      );
      PartDefinition HatLayer_r12 = LeftPlate.addOrReplaceChild(
         "HatLayer_r12",
         CubeListBuilder.create()
            .texOffs(14, 7)
            .addBox(4.575F, 0.5F, -1.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.55F))
            .texOffs(11, 3)
            .addBox(0.5F, 0.5F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.55F)),
         PartPose.offsetAndRotation(-0.175F, -0.95F, 1.8F, 0.2364F, -0.2567F, -1.291F)
      );
      PartDefinition RightLegging = partdefinition.addOrReplaceChild(
         "RightLegging",
         CubeListBuilder.create().texOffs(25, 14).addBox(-1.8F, -3.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition RightLegLayer_r1 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r1",
         CubeListBuilder.create().texOffs(31, 48).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.175F, 6.0F, 0.0F, 0.1963F, 0.0F, 0.3534F)
      );
      PartDefinition RightLegLayer_r2 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r2",
         CubeListBuilder.create().texOffs(31, 48).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.175F, 0.5F, 0.0F, 0.1963F, 0.0F, 0.3534F)
      );
      PartDefinition RightLegLayer_r3 = RightLegging.addOrReplaceChild(
         "RightLegLayer_r3",
         CubeListBuilder.create().texOffs(31, 48).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(-0.175F, 3.0F, 0.0F, 0.1963F, 0.0F, 0.3534F)
      );
      PartDefinition LeftLegging = partdefinition.addOrReplaceChild(
         "LeftLegging",
         CubeListBuilder.create().texOffs(25, 14).addBox(-2.025F, -3.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      PartDefinition RightLegLayer_r4 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r4",
         CubeListBuilder.create().texOffs(32, 42).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.2F, 6.0F, 0.0F, 0.1963F, 0.0F, -0.3272F)
      );
      PartDefinition RightLegLayer_r5 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r5",
         CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.2F, 0.5F, 0.0F, 0.1963F, 0.0F, -0.3272F)
      );
      PartDefinition RightLegLayer_r6 = LeftLegging.addOrReplaceChild(
         "RightLegLayer_r6",
         CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.35F)),
         PartPose.offsetAndRotation(0.2F, 3.0F, 0.0F, 0.1963F, 0.0F, -0.3272F)
      );
      PartDefinition RightBoot = partdefinition.addOrReplaceChild(
         "RightBoot",
         CubeListBuilder.create()
            .texOffs(16, 48)
            .addBox(-2.0F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(20, 52)
            .addBox(-2.0F, 7.0F, 1.0F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.55F)),
         PartPose.offset(-1.9F, 12.0F, 0.0F)
      );
      PartDefinition LeftBoot = partdefinition.addOrReplaceChild(
         "LeftBoot",
         CubeListBuilder.create()
            .texOffs(16, 48)
            .addBox(-2.0F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.55F))
            .texOffs(20, 52)
            .addBox(2.2F, 7.0F, 1.0F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.55F)),
         PartPose.offset(1.9F, 12.0F, 0.0F)
      );
      PartDefinition bb_main = partdefinition.addOrReplaceChild(
         "bb_main",
         CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 24.0F, 0.0F)
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
      this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
