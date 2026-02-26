package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.JudgementBlastEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class JudgementBlastWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         ArphexMod.queueServerWork(5, () -> {
            if (!immediatesourceentity.getPersistentData().getBoolean("dirdone2")) {
               immediatesourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
               immediatesourceentity.getPersistentData().putBoolean("dirdone2", true);
            }
         });
         if (!entity.getPersistentData().getBoolean("dirdone")) {
            entity.getPersistentData().putDouble("xvec", entity.getLookAngle().x);
            entity.getPersistentData().putDouble("yvec", entity.getLookAngle().y);
            entity.getPersistentData().putDouble("zvec", entity.getLookAngle().z);
            entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
            entity.getPersistentData().putBoolean("dirdone", true);
         }

         ArphexMod.queueServerWork(100, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         immediatesourceentity.setNoGravity(true);

         for (int index0 = 0; index0 < 8; index0++) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.HEAVY_WHITE_SMOKES.get(),
                  immediatesourceentity.getX(),
                  immediatesourceentity.getY(),
                  immediatesourceentity.getZ(),
                  0,
                  immediatesourceentity.getPersistentData().getDouble("xvec") * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                  immediatesourceentity.getPersistentData().getDouble("yvec") * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                  immediatesourceentity.getPersistentData().getDouble("zvec") * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                  0.4
               );
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.WHITE_PARTICLES.get(),
                  immediatesourceentity.getX(),
                  immediatesourceentity.getY(),
                  immediatesourceentity.getZ(),
                  0,
                  immediatesourceentity.getPersistentData().getDouble("xvec") * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                  immediatesourceentity.getPersistentData().getDouble("yvec") * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                  immediatesourceentity.getPersistentData().getDouble("zvec") * 5.0 + Mth.nextDouble(RandomSource.create(), -1.0, 3.0),
                  0.4
               );
            }
         }

         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
                  SoundSource.NEUTRAL,
                  0.2F,
                  0.1F
               );
            } else {
               _level.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
                  SoundSource.NEUTRAL,
                  0.2F,
                  0.1F,
                  false
               );
            }
         }

         if (immediatesourceentity.getPersistentData().getBoolean("dirdone2")) {
            Vec3 _center = new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator != entity && !(entityiterator instanceof JudgementBlastEntity)) {
                  if (entityiterator instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                           continue;
                        }
                     }
                  }

                  if (!(entityiterator instanceof ItemEntity)) {
                     entityiterator.setSecondsOnFire(20);
                     if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 5) {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity),
                           (float)(5 / ((entityiterator instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) / 6))
                        );
                     } else {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity),
                           5.0F
                        );
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 2, false, false));
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           ParticleTypes.SOUL_FIRE_FLAME, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 5, 0.3, 0.3, 0.3, 0.3
                        );
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           (SimpleParticleType)ArphexModParticleTypes.GOLDEN_OPAL.get(),
                           entityiterator.getX(),
                           entityiterator.getY(),
                           entityiterator.getZ(),
                           5,
                           0.3,
                           0.3,
                           0.3,
                           0.3
                        );
                     }
                  }
               }
            }
         }

         ArphexMod.queueServerWork(10, () -> immediatesourceentity.getPersistentData().putBoolean("start", true));
         if (immediatesourceentity.getPersistentData().getBoolean("start")) {
            if (world.isEmptyBlock(BlockPos.containing(x, y, z)) && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks71 ? _entUseTicks71.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x, y, z), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z)) && world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks76 ? _entUseTicks76.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z)) && world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks81 ? _entUseTicks81.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0)) && world.getBlockState(BlockPos.containing(x, y - 1.0, z - 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks86 ? _entUseTicks86.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x, y, z - 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x, y, z - 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0)) && world.getBlockState(BlockPos.containing(x, y - 1.0, z + 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks91 ? _entUseTicks91.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x, y, z + 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x, y, z + 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z + 1.0))
               && world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z + 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks96 ? _entUseTicks96.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z + 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z + 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z + 1.0))
               && world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z + 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks101 ? _entUseTicks101.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z + 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z + 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z - 1.0))
               && world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z - 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks106 ? _entUseTicks106.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z - 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x - 1.0, y, z - 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z - 1.0))
               && world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z - 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks111 ? _entUseTicks111.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z - 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x + 1.0, y, z - 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks116 ? _entUseTicks116.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x, y - 1.0, z), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x, y - 1.0, z), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y - 1.0, z)) && world.getBlockState(BlockPos.containing(x + 1.0, y - 2.0, z)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks121 ? _entUseTicks121.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x + 1.0, y - 1.0, z), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x + 1.0, y - 1.0, z), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x - 1.0, y - 1.0, z)) && world.getBlockState(BlockPos.containing(x - 1.0, y - 2.0, z)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks126 ? _entUseTicks126.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x - 1.0, y - 1.0, z), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x - 1.0, y - 1.0, z), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z - 1.0)) && world.getBlockState(BlockPos.containing(x, y - 2.0, z - 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks131 ? _entUseTicks131.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x, y - 1.0, z - 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x, y - 1.0, z - 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z + 1.0)) && world.getBlockState(BlockPos.containing(x, y - 2.0, z + 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks136 ? _entUseTicks136.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x, y - 1.0, z + 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x, y - 1.0, z + 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y - 1.0, z + 1.0))
               && world.getBlockState(BlockPos.containing(x + 1.0, y - 2.0, z + 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks141 ? _entUseTicks141.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x + 1.0, y - 1.0, z + 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x + 1.0, y - 1.0, z + 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x - 1.0, y - 1.0, z + 1.0))
               && world.getBlockState(BlockPos.containing(x - 1.0, y - 2.0, z + 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks146 ? _entUseTicks146.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x - 1.0, y - 1.0, z + 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x - 1.0, y - 1.0, z + 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x - 1.0, y - 1.0, z - 1.0))
               && world.getBlockState(BlockPos.containing(x - 1.0, y - 2.0, z - 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks151 ? _entUseTicks151.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x - 1.0, y - 1.0, z - 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x - 1.0, y - 1.0, z - 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }

            if (world.isEmptyBlock(BlockPos.containing(x + 1.0, y - 1.0, z - 1.0))
               && world.getBlockState(BlockPos.containing(x + 1.0, y - 2.0, z - 1.0)).canOcclude()) {
               if ((entity instanceof LivingEntity _entUseTicks156 ? _entUseTicks156.getTicksUsingItem() : 0) > 85) {
                  world.setBlock(BlockPos.containing(x + 1.0, y - 1.0, z - 1.0), ((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState(), 3);
               } else {
                  world.setBlock(BlockPos.containing(x + 1.0, y - 1.0, z - 1.0), Blocks.FIRE.defaultBlockState(), 3);
               }
            }
         }
      }
   }
}
