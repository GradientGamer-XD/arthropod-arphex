package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class LocustTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState clickedBlock = Blocks.AIR.defaultBlockState();
         boolean found = false;
         double portalX = 0.0;
         double portalY = 0.0;
         double portalZ = 0.0;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7.0, 7.0, 7.0), e -> true).isEmpty()) {
            Entity index1 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7.0, 7.0, 7.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (index1 instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 60, 1));
            }
         }

         if (entity.onGround()) {
            entity.setSprinting(false);
         } else if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
            && world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
            && world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
            && world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
            entity.setShiftKeyDown(false);
            entity.setSprinting(true);
         } else if ((entity.getDeltaMovement().x() > 0.1 || entity.getDeltaMovement().z() > 0.1) && !world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
            entity.setSprinting(true);
         } else {
            entity.setSprinting(false);
            entity.setShiftKeyDown(true);
            if (!world.isEmptyBlock(BlockPos.containing(x + 0.3, y, z))) {
               entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
            } else if (!world.isEmptyBlock(BlockPos.containing(x - 0.3, y, z))) {
               entity.lookAt(Anchor.EYES, new Vec3(x - 1.0, y, z));
            } else if (!world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
               entity.lookAt(Anchor.EYES, new Vec3(x, y, z - 0.3));
            } else {
               entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 0.3));
            }
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
            if (!(entity.getPersistentData().getDouble("flywalk") > 4000.0)) {
               if (world.isEmptyBlock(BlockPos.containing(x, y - 0.5, z))) {
                  if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
                     entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 10, 15));
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           entity.getDeltaMovement().y(),
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  } else {
                     entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
                  }
               }

               entity.getPersistentData()
                  .putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
            } else {
               entity.getPersistentData().putDouble("flywalk", 0.0);
            }
         } else {
            entity.setSprinting(false);
            entity.getPersistentData().putDouble("flywalk", 1000.0);
            if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 40));
               if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 0.5) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        0.3,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               } else {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                     )
                  );
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               }
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("flywalk") < 50.0
            && world.isEmptyBlock(BlockPos.containing(x, y - 0.5, z))
            && entity.getPersistentData().getDouble("flyboost") == 3.0) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() / 8.0, -0.4, entity.getDeltaMovement().z() / 8.0));
         }

         if (entity.isInWater() && entity.getPersistentData().getDouble("flyboost") == 3.0) {
            entity.setDeltaMovement(
               new Vec3(entity.getDeltaMovement().x() / 8.0, Mth.nextDouble(RandomSource.create(), 0.3, 0.8), entity.getDeltaMovement().z() / 8.0)
            );
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
            if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.OAK_LEAVES
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.SPRUCE_LEAVES
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.BIRCH_LEAVES
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.JUNGLE_LEAVES
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.ACACIA_LEAVES
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.DARK_OAK_LEAVES
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.MANGROVE_LEAVES
               || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.AZALEA_LEAVES) {
               world.setBlock(BlockPos.containing(x, y, z + 1.0), Blocks.AIR.defaultBlockState(), 3);
            }

            if (entity.getPersistentData().getDouble("flyboost") == 1.0) {
               sx = -2.0;
               found = false;

               for (int index0 = 0; index0 < 4; index0++) {
                  sy = -2.0;

                  for (int index1 = 0; index1 < 1; index1++) {
                     sz = -2.0;

                     for (int index2 = 0; index2 < 4; index2++) {
                        if (!world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).canOcclude()
                           && (
                              world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant97
                                    && _plant97.getPlantType(world, BlockPos.containing(x + sx, y + sy, z + sz)) == PlantType.CROP
                                 || world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant98
                                    && _plant98.getPlantType(world, BlockPos.containing(x + sx, y + sy, z + sz)) == PlantType.PLAINS
                                 || world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant99
                                    && _plant99.getPlantType(world, BlockPos.containing(x + sx, y + sy, z + sz)) == PlantType.CAVE
                           )) {
                           BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
                           Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
                           world.destroyBlock(_pos, false);
                        }

                        if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.GRASS_BLOCK) {
                           world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.DIRT.defaultBlockState(), 3);
                        }

                        sz++;
                     }

                     sy++;
                  }

                  sx++;
               }
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 15, 1.0, 1.0, 1.0, Mth.nextDouble(RandomSource.create(), 0.2, 0.9)
            );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.LOCUST_SWARM.get(), x, y, z, 5, 3.0, 3.0, 3.0, Mth.nextDouble(RandomSource.create(), 0.2, 0.9)
            );
         }
      }
   }
}
