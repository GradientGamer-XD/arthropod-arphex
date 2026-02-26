package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MothTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         if (!entity.onGround() && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
            entity.setSprinting(false);
            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
               && world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
               && world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
               && world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))) {
               entity.setShiftKeyDown(false);
            } else if (!(entity.getDeltaMovement().x() > 0.1) && !(entity.getDeltaMovement().z() > 0.1)
               || world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
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
         } else {
            if (!(entity.getDeltaMovement().x() > 0.1) && !(entity.getDeltaMovement().z() > 0.1)) {
               entity.setSprinting(false);
            } else {
               entity.setSprinting(true);
            }

            entity.setShiftKeyDown(false);
         }

         if (!(entity.getPersistentData().getDouble("flywalk") > 1000.0)) {
            entity.getPersistentData().putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
         } else {
            entity.getPersistentData().putDouble("flywalk", 0.0);
         }

         label268: {
            if (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16.0, 16.0, 16.0), e -> true).isEmpty()
                  && entity.getPersistentData().getDouble("flyboost") == 5.0) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16.0, 16.0, 16.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16.0, 16.0, 16.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16.0, 16.0, 16.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     )
                  );
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16.0, 16.0, 16.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16.0, 16.0, 16.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                           world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16.0, 16.0, 16.0), e -> true).stream().sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                           1.0
                        );
                  }

                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        entity.getDeltaMovement().y(),
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               }
               break label268;
            }

            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               break label268;
            }

            if (entity instanceof LivingEntity _livEnt51
               && _livEnt51.hasEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get())
               && (entity.getPersistentData().getDouble("flyboost") == 5.0 || entity.getPersistentData().getDouble("flyboost") == 10.0)) {
               if (entity.getPersistentData().getDouble("highestx") != 0.0
                  && !((double)world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= entity.getPersistentData().getDouble("highestlight"))) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        entity.getPersistentData().getDouble("highestx"),
                        entity.getPersistentData().getDouble("highesty"),
                        entity.getPersistentData().getDouble("highestz")
                     )
                  );
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation()
                        .moveTo(
                           entity.getPersistentData().getDouble("highestx"),
                           entity.getPersistentData().getDouble("highesty"),
                           entity.getPersistentData().getDouble("highestz"),
                           1.0
                        );
                  }

                  if (entity.getPersistentData().getDouble("highesty") > entity.getY()) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           0.3,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  } else {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                           -0.3,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  }
               }
               break label268;
            }

            if (entity.getPersistentData().getDouble("flywalk") < 250.0) {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
            } else {
               if (entity.getPersistentData().getDouble("flyboost") == 5.0) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        entity.getX() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0), y, entity.getZ() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
                     )
                  );
                  entity.setDeltaMovement(
                     new Vec3(Mth.nextDouble(RandomSource.create(), -0.4, 0.4), entity.getDeltaMovement().y(), Mth.nextDouble(RandomSource.create(), -0.4, 0.4))
                  );
               }

               if (entity.getPersistentData().getDouble("yboost") == 5.0) {
                  entity.setDeltaMovement(
                     new Vec3(entity.getDeltaMovement().x(), Mth.nextDouble(RandomSource.create(), -0.3, 0.3), entity.getDeltaMovement().z())
                  );
               }
            }
         }

         if (entity.isInWater()) {
            entity.setDeltaMovement(
               new Vec3(
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                  Mth.nextDouble(RandomSource.create(), 0.3, 0.8),
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
               )
            );
         }

         if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
            if ((!(entity instanceof TamableAnimal _tamEntx) || !_tamEntx.isTame())
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == null
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()) {
               ArphexMod.queueServerWork(
                  20,
                  () -> {
                     if ((!(entity instanceof TamableAnimal _tamEntx) || !_tamEntx.isTame())
                        && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) == null
                        && entity.getDisplayName().getString().equals("Moth Moontracker")
                        && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()
                        && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               );
            }

            entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 15));
         } else {
            entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("yboost") > 0.0)) {
            entity.getPersistentData().putDouble("yboost", (double)Mth.nextInt(RandomSource.create(), 15, 20));
         } else {
            entity.getPersistentData().putDouble("yboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
         }

         if (!(entity.getPersistentData().getDouble("lightfind") > 0.0)) {
            entity.getPersistentData().putDouble("lightfind", (double)Mth.nextInt(RandomSource.create(), 50, 200));
         } else {
            entity.getPersistentData().putDouble("lightfind", entity.getPersistentData().getDouble("lightfind") - 1.0);
         }

         if (entity.getPersistentData().getDouble("lightfind") == 5.0) {
            entity.getPersistentData().putDouble("highestlight", 0.0);
            sx = -6.0;

            for (int index0 = 0; index0 < 12; index0++) {
               sy = -6.0;

               for (int index1 = 0; index1 < 12; index1++) {
                  sz = -6.0;

                  for (int index2 = 0; index2 < 12; index2++) {
                     if ((double)world.getMaxLocalRawBrightness(BlockPos.containing(x + sx, y + sy, z + sz))
                        > entity.getPersistentData().getDouble("highestlight")) {
                        entity.getPersistentData().putDouble("highestx", x + sx);
                        entity.getPersistentData().putDouble("highesty", y + sy);
                        entity.getPersistentData().putDouble("highestz", z + sz);
                        entity.getPersistentData()
                           .putDouble("highestlight", (double)world.getMaxLocalRawBrightness(BlockPos.containing(x + sx, y + sy, z + sz)));
                     }

                     sz++;
                  }

                  sy++;
               }

               sx++;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.MOTH_CURSE.get(), 100, 1, false, false));
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F
               > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 5, 0.2, 0.2, 0.2, 0.2);
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
            && Mth.nextInt(RandomSource.create(), 1, 600) == 1
            && (
               world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.MOSS_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.WHITE_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.ORANGE_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.MAGENTA_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.LIGHT_BLUE_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.YELLOW_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.LIME_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.PINK_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.GRAY_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.LIGHT_GRAY_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.CYAN_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.PURPLE_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.BLUE_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.BROWN_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.GREEN_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.RED_CARPET
                  || world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.BLACK_CARPET
            )) {
            BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
            Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y - 1.0, z), null);
            world.destroyBlock(_pos, false);
         }
      }
   }
}
