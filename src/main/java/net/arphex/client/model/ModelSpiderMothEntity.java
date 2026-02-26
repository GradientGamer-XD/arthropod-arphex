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

public class ModelSpiderMothEntity<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("arphex", "model_spider_moth_entity"), "main");
   public final ModelPart torso;
   public final ModelPart rwing;
   public final ModelPart lwing;
   public final ModelPart rleg;
   public final ModelPart lleg;
   public final ModelPart head;
   public final ModelPart larm;
   public final ModelPart larmstwo;
   public final ModelPart larmsthree;
   public final ModelPart rarm;
   public final ModelPart rarmstwo;
   public final ModelPart rarmsthree;

   public ModelSpiderMothEntity(ModelPart root) {
      this.torso = root.getChild("torso");
      this.rwing = root.getChild("rwing");
      this.lwing = root.getChild("lwing");
      this.rleg = root.getChild("rleg");
      this.lleg = root.getChild("lleg");
      this.head = root.getChild("head");
      this.larm = root.getChild("larm");
      this.larmstwo = root.getChild("larmstwo");
      this.larmsthree = root.getChild("larmsthree");
      this.rarm = root.getChild("rarm");
      this.rarmstwo = root.getChild("rarmstwo");
      this.rarmsthree = root.getChild("rarmsthree");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition torso = partdefinition.addOrReplaceChild(
         "torso",
         CubeListBuilder.create()
            .texOffs(0, 17)
            .addBox(-17.1667F, -7.9486F, -0.0341F, 36.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-3.1667F, -6.9486F, -3.0341F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 17)
            .addBox(-6.1667F, -6.9486F, -0.0341F, 12.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.1667F, 9.7727F, 6.1816F, 0.6545F, 0.0F, 0.0F)
      );
      PartDefinition cube_r1 = torso.addOrReplaceChild(
         "cube_r1",
         CubeListBuilder.create().texOffs(16, -2).addBox(-2.0F, -21.8F, -2.0F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-0.1667F, 13.8514F, -2.0341F, 0.0F, -0.7854F, 0.0F)
      );
      PartDefinition cube_r2 = torso.addOrReplaceChild(
         "cube_r2",
         CubeListBuilder.create()
            .texOffs(-1, -1)
            .addBox(-2.0F, -7.8F, 3.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(-1, -1)
            .addBox(-1.0F, -13.8F, 2.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-0.1667F, 13.8514F, -2.0341F, 0.3054F, 0.0F, 0.0F)
      );
      PartDefinition rwing = partdefinition.addOrReplaceChild(
         "rwing",
         CubeListBuilder.create().texOffs(0, 17).addBox(-25.9285F, -4.0F, 0.0196F, 26.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-5.1078F, 3.6541F, 1.2617F, 0.6981F, -0.0436F, 0.0436F)
      );
      PartDefinition cube_r3 = rwing.addOrReplaceChild(
         "cube_r3",
         CubeListBuilder.create().texOffs(0, 17).addBox(-31.0F, -16.8F, 26.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(3.0715F, 16.8F, -20.9804F, 0.0F, -0.2182F, 0.0F)
      );
      PartDefinition lwing = partdefinition.addOrReplaceChild(
         "lwing", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5128F, 4.0995F, 2.6023F, 0.6981F, -0.0436F, 0.0436F)
      );
      PartDefinition cube_r4 = lwing.addOrReplaceChild(
         "cube_r4",
         CubeListBuilder.create().texOffs(0, 17).addBox(24.0F, -21.8F, 5.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-4.2306F, 21.8F, -2.0186F, 0.0F, 0.1309F, 0.0F)
      );
      PartDefinition cube_r5 = lwing.addOrReplaceChild(
         "cube_r5",
         CubeListBuilder.create().texOffs(0, 17).addBox(5.0F, -25.8F, 2.0F, 26.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-4.2306F, 21.8F, -2.0186F, 0.0045F, -0.0107F, -0.0439F)
      );
      PartDefinition rleg = partdefinition.addOrReplaceChild("rleg", CubeListBuilder.create(), PartPose.offset(-2.5F, 18.0596F, 9.0117F));
      PartDefinition cube_r6 = rleg.addOrReplaceChild(
         "cube_r6",
         CubeListBuilder.create().texOffs(19, 28).addBox(-3.0F, -10.0F, 10.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(2.5F, 5.9404F, -9.0117F, 0.3491F, 0.0F, 0.0F)
      );
      PartDefinition lleg = partdefinition.addOrReplaceChild("lleg", CubeListBuilder.create(), PartPose.offset(2.5F, 15.0596F, 9.0117F));
      PartDefinition cube_r7 = lleg.addOrReplaceChild(
         "cube_r7",
         CubeListBuilder.create().texOffs(13, 22).addBox(2.0F, -10.0F, 10.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-2.5F, 8.9404F, -9.0117F, 0.3491F, 0.0F, 0.0F)
      );
      PartDefinition head = partdefinition.addOrReplaceChild(
         "head",
         CubeListBuilder.create()
            .texOffs(0, 13)
            .addBox(-5.0F, 0.9486F, -1.161F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(18, 21)
            .addBox(-2.0F, -3.2514F, -1.161F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(27, 11)
            .addBox(-1.0F, -4.2514F, -1.161F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 2.8032F, -1.1994F, 0.2182F, 0.0F, 0.0F)
      );
      PartDefinition cube_r8 = head.addOrReplaceChild(
         "cube_r8",
         CubeListBuilder.create().texOffs(16, 19).addBox(-2.0F, -20.0F, -15.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 21.7486F, -0.161F, -0.6545F, 0.0F, 0.0F)
      );
      PartDefinition larm = partdefinition.addOrReplaceChild(
         "larm",
         CubeListBuilder.create()
            .texOffs(6, 21)
            .addBox(-0.6667F, -0.6667F, -0.6667F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(-0.6667F, 10.3333F, -0.6667F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(0.3333F, 14.3333F, -0.6667F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offset(4.6667F, 4.6667F, -0.3333F)
      );
      PartDefinition larmstwo = partdefinition.addOrReplaceChild(
         "larmstwo",
         CubeListBuilder.create()
            .texOffs(6, 21)
            .addBox(-0.6667F, -1.6667F, -0.6667F, 1.0F, 19.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(-0.6667F, 9.3333F, -0.6667F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(0.3333F, 13.3333F, -0.6667F, 0.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(4.9454F, 5.2173F, 0.0687F, 0.3927F, -0.4363F, -0.5672F)
      );
      PartDefinition larmsthree = partdefinition.addOrReplaceChild(
         "larmsthree",
         CubeListBuilder.create()
            .texOffs(6, 21)
            .addBox(-0.6667F, 0.3333F, -0.6667F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(-0.6667F, 11.3333F, -0.6667F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(0.3333F, 15.3333F, -0.6667F, 0.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(3.4141F, 2.9599F, 0.0687F, 0.3927F, -0.4363F, -0.829F)
      );
      PartDefinition rarm = partdefinition.addOrReplaceChild(
         "rarm",
         CubeListBuilder.create()
            .texOffs(0, 21)
            .addBox(-0.3333F, 0.3333F, -0.6667F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(-0.3333F, 15.3333F, -0.6667F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(-0.3333F, 11.3333F, -0.6667F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-4.6768F, 3.6667F, -0.1295F, 0.0F, 0.0436F, 0.0F)
      );
      PartDefinition rarmstwo = partdefinition.addOrReplaceChild(
         "rarmstwo",
         CubeListBuilder.create()
            .texOffs(6, 21)
            .addBox(-0.6667F, 1.3333F, -0.6667F, 1.0F, 19.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(-0.6667F, 12.3333F, -0.6667F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(0.3333F, 16.3333F, -0.6667F, 0.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-2.9462F, 3.7616F, -0.5844F, 0.3927F, -0.4363F, 0.2618F)
      );
      PartDefinition rarmsthree = partdefinition.addOrReplaceChild(
         "rarmsthree",
         CubeListBuilder.create()
            .texOffs(6, 21)
            .addBox(-0.6667F, -2.6667F, -0.6667F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(-0.6667F, 8.3333F, -0.6667F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(1, 22)
            .addBox(0.3333F, 12.3333F, -0.6667F, 0.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-5.9425F, 5.7051F, 0.0687F, 0.3927F, -0.4363F, 0.4363F)
      );
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(
      PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha
   ) {
      this.torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.rwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.lwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.rleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.lleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.larm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.larmstwo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.larmsthree.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.rarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.rarmstwo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.rarmsthree.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
