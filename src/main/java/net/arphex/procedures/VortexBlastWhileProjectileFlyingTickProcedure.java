package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class VortexBlastWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean entity_found = false;
         double Radius = 0.0;
         double loop = 0.0;
         double particleSpeed = 0.0;
         double particleAmount = 0.0;
         double raytrace_distance = 0.0;
         double source_distance = 0.0;
         immediatesourceentity.setNoGravity(true);
         if (!immediatesourceentity.getPersistentData().getBoolean("directiondone")) {
            immediatesourceentity.getPersistentData().putBoolean("directiondone", true);
         }

         ArphexMod.queueServerWork(5, () -> {
            immediatesourceentity.getPersistentData().putBoolean("vortexprimed", true);
            immediatesourceentity.getPersistentData().putDouble("fixvectorx", immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("fixvectory", immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("fixvectorz", immediatesourceentity.getDeltaMovement().z());
         });
         if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")
            && !entity.getStringUUID().equals(immediatesourceentity.getPersistentData().getString("uuid_compare_source"))) {
            source_distance = Math.sqrt(
               (immediatesourceentity.getX() - entity.getX()) * (immediatesourceentity.getX() - entity.getX())
                  + (immediatesourceentity.getY() - entity.getY()) * (immediatesourceentity.getY() - entity.getY())
                  + (immediatesourceentity.getZ() - entity.getZ()) * (immediatesourceentity.getZ() - entity.getZ())
            );
            if (source_distance != 0.0) {
               immediatesourceentity.getPersistentData().putDouble("fixvectorx", (entity.getX() - immediatesourceentity.getX()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("fixvectory", (entity.getY() - immediatesourceentity.getY()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("fixvectorz", (entity.getZ() - immediatesourceentity.getZ()) / source_distance * 2.0);
            }
         }

         if (immediatesourceentity.getPersistentData().getBoolean("vortexprimed")) {
            immediatesourceentity.setDeltaMovement(
               new Vec3(
                  immediatesourceentity.getPersistentData().getDouble("fixvectorx"),
                  immediatesourceentity.getPersistentData().getDouble("fixvectory"),
                  immediatesourceentity.getPersistentData().getDouble("fixvectorz")
               )
            );
            if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        0.3F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        0.3F,
                        false
                     );
                  }
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof LivingEntity && entityiterator != entity) {
                     if (entityiterator instanceof TamableAnimal) {
                        TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                              continue;
                           }
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOIDLASHER_CHAOS_CONTROL.get(), 40, 0, false, false));
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x, y, z, 10, 0.3, 0.3, 0.3, 0.5);
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 10, 0.3, 0.3, 0.3, 0.5);
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(), x, y, z, 20, 0.3, 0.3, 0.3, 0.5);
                     }

                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity),
                        40.0F
                     );
                     entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                     if (!immediatesourceentity.level().isClientSide()) {
                        immediatesourceentity.discard();
                     }
                  }
               }
            }
         }

         ArphexMod.queueServerWork(300, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         if (Math.abs(immediatesourceentity.getDeltaMovement().x())
               + Math.abs(immediatesourceentity.getDeltaMovement().y())
               + Math.abs(immediatesourceentity.getDeltaMovement().z())
            < 0.8) {
            immediatesourceentity.setDeltaMovement(
               new Vec3(entity.getDeltaMovement().x() * 1.4, entity.getDeltaMovement().y() * 1.4, entity.getDeltaMovement().z() * 1.4)
            );
         }

         int horizontalRadiusSphere = 2;
         int verticalRadiusSphere = 2;
         int yIterationsSphere = verticalRadiusSphere;

         for (int i = -verticalRadiusSphere; i <= yIterationsSphere; i++) {
            for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
               for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                  double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere)
                     + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere)
                     + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
                  if (distanceSq <= 1.0 && world instanceof ServerLevel _levelx) {
                     _levelx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(x + (double)xi, y + (double)i, z + (double)zi),
                                 Vec2.ZERO,
                                 _levelx,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _levelx.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:geode_power ~ ~ ~ 0 0 0 0 5 force"
                        );
                  }
               }
            }
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
               x
                  + 2.0
                     * immediatesourceentity.getPersistentData().getDouble("diryaw")
                     * immediatesourceentity.getPersistentData().getDouble("dirpitch")
                     * Math.cos(immediatesourceentity.getPersistentData().getDouble("zerotothreesixty")),
               y
                  + 2.0
                     * immediatesourceentity.getPersistentData().getDouble("dirpitch")
                     * immediatesourceentity.getPersistentData().getDouble("dirpitch")
                     * Math.sin(immediatesourceentity.getPersistentData().getDouble("zerotothreesixty")),
               z,
               1,
               0.0,
               0.0,
               0.0,
               0.0
            );
         }
      }
   }
}
