package net.arphex.procedures;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import com.mojang.math.Axis;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.BlockTestEntity;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTestEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Font.DisplayMode;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.MultiBufferSource.BufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;
import org.joml.Vector3f;

@EventBusSubscriber({Dist.CLIENT})
public class WorldRenderTestProcedure {
   private static RenderLevelStageEvent provider = null;
   private static Map<EntityType, Entity> data = new HashMap<>();

   public static void renderBackground(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color) {
      Minecraft minecraft = Minecraft.getInstance();
      Font font = minecraft.font;
      BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
      Vec3 pos = provider.getCamera().getPosition();
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, -scale, 1.0F);
      poseStack.translate((float)(font.width(texts) - 1) * -0.5F, (float)(9 - 1) * -0.5F, 0.0F);
      Matrix4f matrix4f = poseStack.last().pose();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      font.drawInBatch(texts, 0.0F, 0.0F, 0, false, matrix4f, bufferSource, DisplayMode.SEE_THROUGH, color, 15728880);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   public static void renderBlock(BlockState blockState, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      BlockPos blockPos = BlockPos.containing(x, y, z);
      Vec3 pos = provider.getCamera().getPosition();
      int packedLight = glowing ? 15728880 : LevelRenderer.getLightColor(Minecraft.getInstance().level, blockPos);
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, scale, scale);
      poseStack.translate(-0.5F, -0.5F, -0.5F);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      renderBlockModel(blockState, blockPos, poseStack, packedLight);
      renderBlockEntity(blockState, blockPos, poseStack, packedLight);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   private static void renderBlockEntity(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
      if (blockState.getBlock() instanceof EntityBlock entityBlock) {
         Minecraft minecraft = Minecraft.getInstance();
         ClientLevel level = minecraft.level;
         BlockEntity blockEntity = entityBlock.newBlockEntity(blockPos, blockState);
         if (blockEntity != null) {
            BlockEntityRenderer blockEntityRenderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
            if (blockEntityRenderer != null) {
               BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
               blockEntity.setLevel(level);
               blockEntityRenderer.render(blockEntity, 0.0F, poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
            }
         }
      }
   }

   private static void renderBlockModel(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
      if (blockState.getRenderShape() == RenderShape.MODEL) {
         Minecraft minecraft = Minecraft.getInstance();
         ClientLevel level = minecraft.level;
         BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
         BlockRenderDispatcher dispatcher = minecraft.getBlockRenderer();
         ModelBlockRenderer renderer = dispatcher.getModelRenderer();
         BakedModel bakedModel = dispatcher.getBlockModel(blockState);
         ModelData modelData = bakedModel.getModelData(level, blockPos, blockState, ModelData.builder().build());
         Pose pose = poseStack.last();
         int color = minecraft.getBlockColors().getColor(blockState, level, blockPos);
         float red = (float)(color >> 16 & 0xFF) / 255.0F;
         float green = (float)(color >> 8 & 0xFF) / 255.0F;
         float blue = (float)(color & 0xFF) / 255.0F;

         for (RenderType renderType : bakedModel.getRenderTypes(blockState, RandomSource.create(42L), modelData)) {
            renderer.renderModel(
               pose,
               bufferSource.getBuffer(Sheets.translucentCullBlockSheet()),
               blockState,
               bakedModel,
               red,
               green,
               blue,
               packedLight,
               OverlayTexture.NO_OVERLAY,
               modelData,
               renderType
            );
         }
      }
   }

   public static void renderEntity(EntityType type, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      if (type != null) {
         ClientLevel level = Minecraft.getInstance().level;
         if (level != null) {
            Entity entity = null;
            if (data.containsKey(type)) {
               entity = data.get(type);
               if (entity == null || entity.level() != level) {
                  entity = type.create(level);
                  if (entity == null) {
                     return;
                  }

                  data.put(type, entity);
               }
            } else {
               entity = type.create(level);
               if (entity == null) {
                  return;
               }

               data.put(type, entity);
            }

            renderEntity(entity, 0.0F, x, y, z, yaw, pitch, roll, scale, glowing ? 15728880 : LevelRenderer.getLightColor(level, BlockPos.containing(x, y, z)));
         }
      }
   }

   public static void renderEntity(Entity entity, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
      float partialTick = provider.getPartialTick();
      int packedLight = glowing ? 15728880 : Minecraft.getInstance().getEntityRenderDispatcher().getPackedLightCoords(entity, partialTick);
      renderEntity(entity, partialTick, x, y, z, yaw, pitch, roll, scale, packedLight);
   }

   private static void renderEntity(
      Entity entity, float partialTick, double x, double y, double z, float yaw, float pitch, float roll, float scale, int packedLight
   ) {
      if (entity != null) {
         Minecraft minecraft = Minecraft.getInstance();
         BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
         EntityRenderer renderer = minecraft.getEntityRenderDispatcher().getRenderer(entity);
         Vec3 pos = provider.getCamera().getPosition();
         float offset = entity.getBbHeight() / 2.0F * scale;
         PoseStack poseStack = provider.getPoseStack();
         poseStack.pushPose();
         poseStack.translate(x - pos.x(), y + (double)offset - pos.y(), z - pos.z());
         poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
         poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
         poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
         poseStack.translate(0.0F, -offset, 0.0F);
         poseStack.scale(scale, scale, scale);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         renderer.render(entity, entity.getViewYRot(partialTick), partialTick, poseStack, bufferSource, packedLight);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         poseStack.popPose();
      }
   }

   public static void renderItem(
      ItemStack itemStack, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean flipping, boolean glowing
   ) {
      Minecraft minecraft = Minecraft.getInstance();
      BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
      ItemRenderer renderer = minecraft.getItemRenderer();
      Vec3 pos = provider.getCamera().getPosition();
      int packedLight = glowing ? 15728880 : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, scale, scale);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      renderer.renderStatic(
         null, itemStack, ItemDisplayContext.FIXED, flipping, poseStack, bufferSource, minecraft.level, packedLight, OverlayTexture.NO_OVERLAY, 0
      );
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   public static void renderLine(double x1, double y1, double z1, double x2, double y2, double z2, int color) {
      BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
      Vec3 pos = provider.getCamera().getPosition();
      Vector3f normal = new Vec3(x2 - x1, y2 - y1, z2 - z1).normalize().toVector3f();
      Matrix4f matrix4f = provider.getPoseStack().last().pose();
      VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
      vertexConsumer.vertex(matrix4f, (float)(x1 - pos.x()), (float)(y1 - pos.y()), (float)(z1 - pos.z()))
         .color(color)
         .normal(normal.x(), normal.y(), normal.z())
         .endVertex();
      vertexConsumer.vertex(matrix4f, (float)(x2 - pos.x()), (float)(y2 - pos.y()), (float)(z2 - pos.z()))
         .color(color)
         .normal(normal.x(), normal.y(), normal.z())
         .endVertex();
   }

   public static void renderTexts(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color, boolean glowing) {
      Minecraft minecraft = Minecraft.getInstance();
      Font font = minecraft.font;
      BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
      Vec3 pos = provider.getCamera().getPosition();
      int packedLight = glowing ? 15728880 : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
      PoseStack poseStack = provider.getPoseStack();
      poseStack.pushPose();
      poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
      poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
      poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
      poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
      poseStack.scale(scale, -scale, 1.0F);
      poseStack.translate((float)(font.width(texts) - 1) * -0.5F, (float)(9 - 1) * -0.5F, 0.0F);
      Matrix4f matrix4f = poseStack.last().pose();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      font.drawInBatch(texts, 0.0F, 0.0F, color, false, matrix4f, bufferSource, DisplayMode.NORMAL, 0, packedLight);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
   }

   @SubscribeEvent
   public static void renderModels(RenderLevelStageEvent event) {
      provider = event;
      if (provider.getStage() == Stage.AFTER_ENTITIES) {
         ClientLevel level = Minecraft.getInstance().level;
         Entity entity = provider.getCamera().getEntity();
         Vec3 pos = entity.getPosition(provider.getPartialTick());
         execute(provider);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(true);
      }
   }

   public static void execute() {
      execute(null);
   }

   private static void execute(@Nullable Event event) {
      ItemStack warp_wayfinder = ItemStack.EMPTY;
      Entity render_entity = null;
      Entity nearest_render = null;
      Entity immortal_player = null;
      double dists = 0.0;
      double dist_to_rendered = 0.0;
      double xcalc = 0.0;
      double ycalc = 0.0;
      double zcalc = 0.0;
      double i = 0.0;
      double j = 0.0;
      double k = 0.0;
      double l = 0.0;
      double colr = 0.0;
      double colg = 0.0;
      double colb = 0.0;
      double max_mobs = 0.0;
      double col_b = 0.0;
      double distance = 0.0;
      double spheresize = 0.0;
      double rotation_from_tormentor = 0.0;
      double amplify = 0.0;
      double max_entities = 0.0;
      double col_g = 0.0;
      double col_r = 0.0;
      double opacity = 0.0;
      double tormentor_distance = 0.0;
      double yaw_offset = 0.0;
      double coolsmooth = 0.0;
      if (Minecraft.getInstance().player != null) {
         Entity entity = Minecraft.getInstance().player;
         double x = entity.getX();
         double y = entity.getY();
         double z = entity.getZ();
         LevelAccessor world = entity.level();
         ResourceKey<Level> dimension = entity.level().dimension();
         if (world instanceof ClientLevel _blockEntityContext) {
            int _scanRange = Minecraft.getInstance().options.getEffectiveRenderDistance();
            BlockPos _scanCenter = Minecraft.getInstance().player.blockPosition();

            for (int _chunkZ = -_scanRange; _chunkZ <= _scanRange; _chunkZ++) {
               for (int _chunkX = -_scanRange; _chunkX <= _scanRange; _chunkX++) {
                  LevelChunk _levelChunk = _blockEntityContext.getChunk(
                     SectionPos.blockToSectionCoord(_scanCenter.getX() + (_chunkX << 4)), SectionPos.blockToSectionCoord(_scanCenter.getZ() + (_chunkZ << 4))
                  );
                  if (_levelChunk != null) {
                     for (Entry<BlockPos, BlockEntity> _blockEntityEntry : _levelChunk.getBlockEntities().entrySet()) {
                        BlockState blockstateiterator = _blockEntityEntry.getValue().getBlockState();
                        int positionx = _blockEntityEntry.getKey().getX();
                        int positiony = _blockEntityEntry.getKey().getY();
                        int positionz = _blockEntityEntry.getKey().getZ();
                        if (blockstateiterator.getBlock() == ArphexModBlocks.MOB_TROPHY.get()) {
                           String nbtEntity = (new Object() {
                              public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                 BlockEntity blockEntity = world.getBlockEntity(pos);
                                 return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                              }
                           }).getValue(world, BlockPos.containing((double)positionx, (double)positiony, (double)positionz), "trophy_entity");
                           if (nbtEntity != null && !nbtEntity.isEmpty()) {
                              String key = nbtEntity.toLowerCase(Locale.ROOT);
                              ResourceLocation rl = new ResourceLocation("arphex", key);
                              EntityType<?> entityType = (EntityType<?>)((Level)world).registryAccess().registryOrThrow(Registries.ENTITY_TYPE).get(rl);
                              if (entityType != null && world instanceof Level) {
                                 Level level = (Level)world;
                                 Entity renderEntity = entityType.create(level);
                                 if (renderEntity != null) {
                                    double scaleValue = (new Object() {
                                       public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                          BlockEntity blockEntity = world.getBlockEntity(pos);
                                          return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : 0.2;
                                       }
                                    }).getValue(world, BlockPos.containing((double)positionx, (double)positiony, (double)positionz), "trophy_entity_size");
                                    float scale = (float)scaleValue;
                                    Direction blockFacing = (new Object() {
                                          public Direction getDirection(BlockState _bs) {
                                             if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                                                return (Direction)_bs.getValue(_dp);
                                             } else {
                                                if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                                                   && _ep.getPossibleValues().toArray()[0] instanceof net.minecraft.core.Direction.Axis) {
                                                   return Direction.fromAxisAndDirection(
                                                      (net.minecraft.core.Direction.Axis)_bs.getValue(_ep), AxisDirection.POSITIVE
                                                   );
                                                }

                                                return Direction.NORTH;
                                             }
                                          }
                                       })
                                       .getDirection(blockstateiterator);

                                    float yaw = switch (blockFacing) {
                                       case NORTH -> 180.0F;
                                       case SOUTH -> 0.0F;
                                       case EAST -> 270.0F;
                                       case WEST -> 90.0F;
                                       default -> 180.0F;
                                    };
                                    if (renderEntity instanceof LivingEntity) {
                                       LivingEntity living = (LivingEntity)renderEntity;
                                       living.setSilent(true);
                                       living.setInvulnerable(true);

                                       try {
                                          Method setNoAi = living.getClass().getMethod("setNoAi", boolean.class);
                                          setNoAi.invoke(living, true);
                                       } catch (Exception var89) {
                                          var89.printStackTrace();
                                       }
                                    }

                                    renderEntity(
                                       renderEntity,
                                       (double)((float)positionx + 0.5F),
                                       (double)((float)positiony + 0.2F),
                                       (double)((float)positionz + 0.5F),
                                       yaw,
                                       0.0F,
                                       0.0F,
                                       scale,
                                       true
                                    );
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .immortal_near
            > 0.0) {
            for (Entity entityiterator : new ArrayList(world.players())) {
               if (Math.abs(entity.getX() - entityiterator.getX()) < 200.0
                  && Math.abs(entity.getY() - entityiterator.getY()) < 200.0
                  && Math.abs(entity.getZ() - entityiterator.getZ()) < 200.0) {
                  render_entity = entityiterator;
                  if (((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .inherent_power_cooldown
                        > 10800.0
                     && (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                        == ArphexModItems.IMMORTAL_CHESTPLATE.get()) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entityiterator;
                        if (_livEnt11.hasEffect(MobEffects.INVISIBILITY)) {
                           continue;
                        }
                     }

                     if (entityiterator.getXRot() > -60.0F
                        && (
                           entityiterator
                                 != world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), ex -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                              || Minecraft.getInstance().options.getCameraType() == CameraType.THIRD_PERSON_FRONT
                        )) {
                        coolsmooth = Math.min(
                              1.0,
                              Math.max(
                                 0.0,
                                 (
                                       12000.0
                                          - ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(
                                                   ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                )
                                                .orElse(new ArphexModVariables.PlayerVariables()))
                                             .inherent_power_cooldown
                                    )
                                    / 12.0
                                    / 10.0
                              )
                           )
                           * Math.min(
                              1.0,
                              Math.max(
                                 0.0,
                                 (
                                       100.0
                                          - (
                                                12000.0
                                                   - ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(
                                                            ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null
                                                         )
                                                         .orElse(new ArphexModVariables.PlayerVariables()))
                                                      .inherent_power_cooldown
                                             )
                                             / 12.0
                                    )
                                    / 10.0
                              )
                           );
                        renderEntity(
                           entityiterator,
                           (double)entityiterator.level()
                              .clip(
                                 new ClipContext(
                                    entityiterator.getEyePosition(1.0F),
                                    entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0 - 3.0 * coolsmooth)),
                                    Block.COLLIDER,
                                    Fluid.NONE,
                                    entityiterator
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           entityiterator.getY(),
                           (double)entityiterator.level()
                              .clip(
                                 new ClipContext(
                                    entityiterator.getEyePosition(1.0F),
                                    entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0 - 3.0 * coolsmooth)),
                                    Block.COLLIDER,
                                    Fluid.NONE,
                                    entityiterator
                                 )
                              )
                              .getBlockPos()
                              .getZ(),
                           0.0F,
                           0.0F,
                           0.0F,
                           (float)(2.0 * coolsmooth),
                           true
                        );
                     }
                  }
               }
            }
         }

         if ((
               ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0
                  || ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0
                  || entity instanceof LivingEntity _livEnt21
                     && _livEnt21.hasEffect((MobEffect)ArphexModMobEffects.DISPLAY_TORMENTOR_INITIAL.get())
                     && dimension == Level.OVERWORLD
            )
            && (
               ArphexModVariables.MapVariables.get(world)
                     .tormentor_target_dimension
                     .equals(
                        ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .player_dimension
                     )
                  || entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect((MobEffect)ArphexModMobEffects.DISPLAY_TORMENTOR_INITIAL.get())
            )) {
            dists = Math.sqrt(
               (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                     * (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
                  + (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                     * (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                  + (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                     * (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
            );
            xcalc = x
               + (ArphexModVariables.MapVariables.get(world).tormentor_x - x)
                  / dists
                  * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
            ycalc = y
               + (ArphexModVariables.MapVariables.get(world).tormentor_y - y)
                  / dists
                  * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F)
               + dists * 0.0025;
            zcalc = z
               + (ArphexModVariables.MapVariables.get(world).tormentor_z - z)
                  / dists
                  * (double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F);
            dist_to_rendered = Math.sqrt(
               (entity.getX() - xcalc) * (entity.getX() - xcalc)
                  + (entity.getY() - ycalc) * (entity.getY() - ycalc)
                  + (entity.getZ() - zcalc) * (entity.getZ() - zcalc)
            );
            if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0
                  && !world.getEntitiesOfClass(TormentorTestEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true).isEmpty()
               || ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0
                  && !world.getEntitiesOfClass(TormentorT2Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true).isEmpty()
               || ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0
                  && !world.getEntitiesOfClass(TormentorT3Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true).isEmpty()
               || ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0
                  && !world.getEntitiesOfClass(TormentorT4Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true).isEmpty()
               || ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0
                  && !world.getEntitiesOfClass(TormentorT5Entity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true).isEmpty()) {
               RenderSystem.depthMask(true);
               RenderSystem.enableDepthTest();
               RenderSystem.disableCull();
               if (dist_to_rendered > dists) {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), ex -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
                        if (entityiteratorx instanceof TormentorTestEntity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorx instanceof TormentorTestEntity _datEntS
                                    ? _datEntS.getEntityData().get(TormentorTestEntity.DATA_uuid_target)
                                    : ""
                              )) {
                           render_entity = entityiteratorx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
                        if (entityiteratorx instanceof TormentorT2Entity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorx instanceof TormentorT2Entity _datEntS ? _datEntS.getEntityData().get(TormentorT2Entity.DATA_uuid_target) : ""
                              )) {
                           render_entity = entityiteratorx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
                        if (entityiteratorx instanceof TormentorT3Entity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorx instanceof TormentorT3Entity _datEntS ? _datEntS.getEntityData().get(TormentorT3Entity.DATA_uuid_target) : ""
                              )) {
                           render_entity = entityiteratorx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
                        if (entityiteratorx instanceof TormentorT4Entity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorx instanceof TormentorT4Entity _datEntS ? _datEntS.getEntityData().get(TormentorT4Entity.DATA_uuid_target) : ""
                              )) {
                           render_entity = entityiteratorx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0
                        && entityiteratorx instanceof TormentorT5Entity
                        && entity.getStringUUID()
                           .equals(
                              entityiteratorx instanceof TormentorT5Entity _datEntS ? _datEntS.getEntityData().get(TormentorT5Entity.DATA_uuid_target) : ""
                           )) {
                        render_entity = entityiteratorx;
                        break;
                     }
                  }

                  if (render_entity != null) {
                     yaw_offset = ArphexModVariables.MapVariables.get(world).tormentor_rotation;
                     renderEntity(
                        render_entity,
                        ArphexModVariables.MapVariables.get(world).tormentor_x,
                        ArphexModVariables.MapVariables.get(world).tormentor_y,
                        ArphexModVariables.MapVariables.get(world).tormentor_z,
                        (float)ArphexModVariables.MapVariables.get(world).tormentor_rotation,
                        0.0F,
                        0.0F,
                        (float)(9000.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 1000.0),
                        false
                     );
                  }
               } else {
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), ex -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
                        if (entityiteratorxx instanceof TormentorTestEntity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorxx instanceof TormentorTestEntity _datEntS
                                    ? _datEntS.getEntityData().get(TormentorTestEntity.DATA_uuid_target)
                                    : ""
                              )) {
                           render_entity = entityiteratorxx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
                        if (entityiteratorxx instanceof TormentorT2Entity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorxx instanceof TormentorT2Entity _datEntS ? _datEntS.getEntityData().get(TormentorT2Entity.DATA_uuid_target) : ""
                              )) {
                           render_entity = entityiteratorxx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
                        if (entityiteratorxx instanceof TormentorT3Entity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorxx instanceof TormentorT3Entity _datEntS ? _datEntS.getEntityData().get(TormentorT3Entity.DATA_uuid_target) : ""
                              )) {
                           render_entity = entityiteratorxx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
                        if (entityiteratorxx instanceof TormentorT4Entity
                           && entity.getStringUUID()
                              .equals(
                                 entityiteratorxx instanceof TormentorT4Entity _datEntS ? _datEntS.getEntityData().get(TormentorT4Entity.DATA_uuid_target) : ""
                              )) {
                           render_entity = entityiteratorxx;
                           break;
                        }
                     } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0
                        && entityiteratorxx instanceof TormentorT5Entity
                        && entity.getStringUUID()
                           .equals(
                              entityiteratorxx instanceof TormentorT5Entity _datEntS ? _datEntS.getEntityData().get(TormentorT5Entity.DATA_uuid_target) : ""
                           )) {
                        render_entity = entityiteratorxx;
                        break;
                     }
                  }

                  if (render_entity != null) {
                     yaw_offset = ArphexModVariables.MapVariables.get(world).tormentor_rotation;
                     renderEntity(
                        render_entity,
                        xcalc,
                        ycalc,
                        zcalc,
                        (float)ArphexModVariables.MapVariables.get(world).tormentor_rotation,
                        0.0F,
                        0.0F,
                        (float)(
                           (9000.0 + ArphexModVariables.MapVariables.get(world).tormentor_tier * 1000.0)
                              * ((double)(Minecraft.getInstance().gameRenderer.getRenderDistance() + 100.0F) / dists)
                        ),
                        false
                     );
                  }
               }
            }
         }

         if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
            if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
               renderEntity(
                  (EntityType)ArphexModEntities.TORMENTOR_LOW_DISPLAY.get(), entity.getX() + 100.0, -300.0, entity.getZ(), 40.0F, 0.0F, 0.0F, 1.0F, false
               );
            }

            if ((Boolean)ConfigurationSettingsConfiguration.TORMENTOR_SKY_RENDER.get()
               && entity.level().dimension() == Level.OVERWORLD
               && world.dimensionType().moonPhase(world.dayTime()) == 0
               && world.dayTime() > 14000L
               && world.dayTime() < 22000L) {
               renderEntity(
                  (EntityType)ArphexModEntities.TORMENTOR_LOW_DISPLAY.get(),
                  entity.getX() + 100.0,
                  entity.getY() + 600.0,
                  entity.getZ(),
                  40.0F,
                  0.0F,
                  0.0F,
                  0.2F,
                  false
               );
            }
         }

         if ((
               (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.SPACETIME_HELMET.get()
                  || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.IMMORTAL_HELMET.get()
            )
            && entity.isShiftKeyDown()) {
            max_mobs = 20.0;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), ex -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (max_mobs > 0.0
                  && entityiteratorxxx != entity
                  && entityiteratorxxx instanceof LivingEntity
                  && !(entityiteratorxxx instanceof TormentorTestEntity)
                  && !(entityiteratorxxx instanceof TormentorT2Entity)
                  && !(entityiteratorxxx instanceof TormentorT3Entity)
                  && !(entityiteratorxxx instanceof TormentorT4Entity)
                  && !(entityiteratorxxx instanceof TormentorT5Entity)
                  && !(entityiteratorxxx instanceof BlockTestEntity)) {
                  colr = 255.0;
                  colg = 255.0;
                  colb = 255.0;
                  if (entityiteratorxxx instanceof Monster) {
                     colr = 255.0;
                     colg = 0.0;
                     colb = 0.0;
                  }

                  if (entityiteratorxxx instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxxx;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                           colr = 0.0;
                           colg = 255.0;
                           colb = 0.0;
                        }
                     }
                  }

                  if (entityiteratorxxx instanceof Player) {
                     colr = 0.0;
                     colg = 0.0;
                     colb = 255.0;
                  }

                  max_mobs--;
                  RenderSystem.depthMask(false);
                  RenderSystem.disableDepthTest();
                  renderTexts(
                     Math.round(entityiteratorxxx instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F)
                        + " / "
                        + Math.round(entityiteratorxxx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)
                        + " ♥",
                     entityiteratorxxx.getX(),
                     entityiteratorxxx.getY() + (double)entityiteratorxxx.getBbHeight() + 0.5,
                     entityiteratorxxx.getZ(),
                     (float)(Math.atan2(entity.getZ() - entityiteratorxxx.getZ(), entity.getX() - entityiteratorxxx.getX()) * (180.0 / Math.PI) - 90.0),
                     0.0F,
                     0.0F,
                     (float)(0.025 + (double)(Math.min(entityiteratorxxx instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F, 1024.0F) / 10240.0F)),
                     0xFF000000 | (int)colr << 16 | (int)colg << 8 | (int)colb,
                     true
                  );
               }
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()
            || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
            if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_WAYFINDER.get()) {
               warp_wayfinder = entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY;
            } else {
               warp_wayfinder = entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY;
            }

            RenderSystem.disableCull();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            if (entity.getDeltaMovement().x() == 0.0 && entity.getDeltaMovement().z() == 0.0 && Math.abs(entity.getDeltaMovement().y()) < 0.08) {
               if ((new Object() {
                     public ItemStack getItemStack(int sltid, ItemStack _isc) {
                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                        _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                        return _retval.get();
                     }
                  }).getItemStack(0, warp_wayfinder).getItem() != ItemStack.EMPTY.getItem()
                  && (
                     warp_wayfinder.getOrCreateTag().getDouble("target_1_x") != 0.0
                        || warp_wayfinder.getOrCreateTag().getDouble("target_1_y") != 0.0
                        || warp_wayfinder.getOrCreateTag().getDouble("target_1_z") != 0.0
                  )
                  && warp_wayfinder.getOrCreateTag()
                     .getString("target_1_dimension")
                     .equals(
                        (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                           + ""
                     )) {
                  dists = Math.sqrt(
                     (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_1_x"))
                           * (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_1_x"))
                        + (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_1_y"))
                           * (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_1_y"))
                        + (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_1_z"))
                           * (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_1_z"))
                  );
                  xcalc = entity.getX() + (warp_wayfinder.getOrCreateTag().getDouble("target_1_x") + 0.5 - entity.getX()) / dists * 1.0;
                  ycalc = entity.getY()
                     + (double)entity.getBbHeight() * 0.9
                     + (warp_wayfinder.getOrCreateTag().getDouble("target_1_y") + 0.5 - entity.getY()) / dists * 1.0;
                  zcalc = entity.getZ() + (warp_wayfinder.getOrCreateTag().getDouble("target_1_z") + 0.5 - entity.getZ()) / dists * 1.0;
                  if (3.0 > dists) {
                     if ((new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(0, warp_wayfinder)
                           .getItem()
                        != Items.NAME_TAG) {
                        renderItem(
                           (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(0, warp_wayfinder),
                           warp_wayfinder.getOrCreateTag().getDouble("target_1_x") + 0.5,
                           warp_wayfinder.getOrCreateTag().getDouble("target_1_y") + 2.0,
                           warp_wayfinder.getOrCreateTag().getDouble("target_1_z") + 0.5,
                           (float)(
                              Math.atan2(
                                       entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_1_z"),
                                       entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_1_x")
                                    )
                                    * (180.0 / Math.PI)
                                 - 90.0
                           ),
                           0.0F,
                           0.0F,
                           1.0F,
                           false,
                           true
                        );
                     }
                  } else {
                     renderTexts(
                        (new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(0, warp_wayfinder)
                           .getDisplayName()
                           .getString()
                           .replace("]", "")
                           .replace("[", ""),
                        xcalc,
                        ycalc + 0.1,
                        zcalc,
                        (float)(
                           Math.atan2(
                                    entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_1_z"),
                                    entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_1_x")
                                 )
                                 * (180.0 / Math.PI)
                              - 90.0
                        ),
                        0.0F,
                        0.0F,
                        0.002F,
                        -1,
                        true
                     );
                     if ((new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(0, warp_wayfinder)
                           .getItem()
                        != Items.NAME_TAG) {
                        renderItem(
                           (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(0, warp_wayfinder),
                           xcalc,
                           ycalc,
                           zcalc,
                           (float)(
                              Math.atan2(
                                       entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_1_z"),
                                       entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_1_x")
                                    )
                                    * (180.0 / Math.PI)
                                 - 90.0
                           ),
                           0.0F,
                           0.0F,
                           0.1F,
                           false,
                           true
                        );
                     }
                  }
               }

               if ((new Object() {
                     public ItemStack getItemStack(int sltid, ItemStack _isc) {
                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                        _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                        return _retval.get();
                     }
                  }).getItemStack(1, warp_wayfinder).getItem() != ItemStack.EMPTY.getItem()
                  && (
                     warp_wayfinder.getOrCreateTag().getDouble("target_2_x") != 0.0
                        || warp_wayfinder.getOrCreateTag().getDouble("target_2_y") != 0.0
                        || warp_wayfinder.getOrCreateTag().getDouble("target_2_z") != 0.0
                  )
                  && warp_wayfinder.getOrCreateTag()
                     .getString("target_2_dimension")
                     .equals(
                        (
                              world instanceof Level _lvlx
                                 ? _lvlx.dimension()
                                 : (world instanceof WorldGenLevel _wglx ? _wglx.getLevel().dimension() : Level.OVERWORLD)
                           )
                           + ""
                     )) {
                  dists = Math.sqrt(
                     (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_2_x"))
                           * (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_2_x"))
                        + (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_2_y"))
                           * (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_2_y"))
                        + (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_2_z"))
                           * (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_2_z"))
                  );
                  xcalc = entity.getX() + (warp_wayfinder.getOrCreateTag().getDouble("target_2_x") + 0.5 - entity.getX()) / dists * 1.0;
                  ycalc = entity.getY()
                     + (double)entity.getBbHeight() * 0.9
                     + (warp_wayfinder.getOrCreateTag().getDouble("target_2_y") + 0.5 - entity.getY()) / dists * 1.0;
                  zcalc = entity.getZ() + (warp_wayfinder.getOrCreateTag().getDouble("target_2_z") + 0.5 - entity.getZ()) / dists * 1.0;
                  if (5.0 > dists) {
                     if ((new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(1, warp_wayfinder)
                           .getItem()
                        != Items.NAME_TAG) {
                        renderItem(
                           (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(1, warp_wayfinder),
                           warp_wayfinder.getOrCreateTag().getDouble("target_2_x") + 0.5,
                           warp_wayfinder.getOrCreateTag().getDouble("target_2_y") + 2.0,
                           warp_wayfinder.getOrCreateTag().getDouble("target_2_z") + 0.5,
                           (float)(
                              Math.atan2(
                                       entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_2_z"),
                                       entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_2_x")
                                    )
                                    * (180.0 / Math.PI)
                                 - 90.0
                           ),
                           0.0F,
                           0.0F,
                           1.0F,
                           false,
                           true
                        );
                     }
                  } else {
                     renderTexts(
                        (new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(1, warp_wayfinder)
                           .getDisplayName()
                           .getString()
                           .replace("]", "")
                           .replace("[", ""),
                        xcalc,
                        ycalc + 0.1,
                        zcalc,
                        (float)(
                           Math.atan2(
                                    entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_2_z"),
                                    entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_2_x")
                                 )
                                 * (180.0 / Math.PI)
                              - 90.0
                        ),
                        0.0F,
                        0.0F,
                        0.002F,
                        -1,
                        true
                     );
                     if ((new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(1, warp_wayfinder)
                           .getItem()
                        != Items.NAME_TAG) {
                        renderItem(
                           (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(1, warp_wayfinder),
                           xcalc,
                           ycalc,
                           zcalc,
                           (float)(
                              Math.atan2(
                                       entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_2_z"),
                                       entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_2_x")
                                    )
                                    * (180.0 / Math.PI)
                                 - 90.0
                           ),
                           0.0F,
                           0.0F,
                           0.1F,
                           false,
                           true
                        );
                     }
                  }
               }

               if ((new Object() {
                     public ItemStack getItemStack(int sltid, ItemStack _isc) {
                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                        _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                        return _retval.get();
                     }
                  }).getItemStack(2, warp_wayfinder).getItem() != ItemStack.EMPTY.getItem()
                  && (
                     warp_wayfinder.getOrCreateTag().getDouble("target_3_x") != 0.0
                        || warp_wayfinder.getOrCreateTag().getDouble("target_3_y") != 0.0
                        || warp_wayfinder.getOrCreateTag().getDouble("target_3_z") != 0.0
                  )
                  && warp_wayfinder.getOrCreateTag()
                     .getString("target_3_dimension")
                     .equals(
                        (
                              world instanceof Level _lvlxx
                                 ? _lvlxx.dimension()
                                 : (world instanceof WorldGenLevel _wglxx ? _wglxx.getLevel().dimension() : Level.OVERWORLD)
                           )
                           + ""
                     )) {
                  dists = Math.sqrt(
                     (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_3_x"))
                           * (entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_3_x"))
                        + (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_3_y"))
                           * (entity.getY() - warp_wayfinder.getOrCreateTag().getDouble("target_3_y"))
                        + (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_3_z"))
                           * (entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_3_z"))
                  );
                  xcalc = entity.getX() + (warp_wayfinder.getOrCreateTag().getDouble("target_3_x") + 0.5 - entity.getX()) / dists * 1.0;
                  ycalc = entity.getY()
                     + (double)entity.getBbHeight() * 0.9
                     + (warp_wayfinder.getOrCreateTag().getDouble("target_3_y") + 0.5 - entity.getY()) / dists * 1.0;
                  zcalc = entity.getZ() + (warp_wayfinder.getOrCreateTag().getDouble("target_3_z") + 0.5 - entity.getZ()) / dists * 1.0;
                  if (5.0 > dists) {
                     if ((new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(2, warp_wayfinder)
                           .getItem()
                        != Items.NAME_TAG) {
                        renderItem(
                           (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(2, warp_wayfinder),
                           warp_wayfinder.getOrCreateTag().getDouble("target_3_x") + 0.5,
                           warp_wayfinder.getOrCreateTag().getDouble("target_3_y") + 2.0,
                           warp_wayfinder.getOrCreateTag().getDouble("target_3_z") + 0.5,
                           (float)(
                              Math.atan2(
                                       entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_3_z"),
                                       entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_3_x")
                                    )
                                    * (180.0 / Math.PI)
                                 - 90.0
                           ),
                           0.0F,
                           0.0F,
                           1.0F,
                           false,
                           true
                        );
                     }
                  } else {
                     renderTexts(
                        (new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(2, warp_wayfinder)
                           .getDisplayName()
                           .getString()
                           .replace("]", "")
                           .replace("[", ""),
                        xcalc,
                        ycalc + 0.1,
                        zcalc,
                        (float)(
                           Math.atan2(
                                    entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_3_z"),
                                    entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_3_x")
                                 )
                                 * (180.0 / Math.PI)
                              - 90.0
                        ),
                        0.0F,
                        0.0F,
                        0.002F,
                        -1,
                        true
                     );
                     if ((new Object() {
                              public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                 AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                 _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                 return _retval.get();
                              }
                           })
                           .getItemStack(2, warp_wayfinder)
                           .getItem()
                        != Items.NAME_TAG) {
                        renderItem(
                           (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(2, warp_wayfinder),
                           xcalc,
                           ycalc,
                           zcalc,
                           (float)(
                              Math.atan2(
                                       entity.getZ() - warp_wayfinder.getOrCreateTag().getDouble("target_3_z"),
                                       entity.getX() - warp_wayfinder.getOrCreateTag().getDouble("target_3_x")
                                    )
                                    * (180.0 / Math.PI)
                                 - 90.0
                           ),
                           0.0F,
                           0.0F,
                           0.1F,
                           false,
                           true
                        );
                     }
                  }
               }
            }
         }
      }
   }
}
