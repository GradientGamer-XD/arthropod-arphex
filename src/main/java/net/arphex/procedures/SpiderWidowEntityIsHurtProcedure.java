package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.SpiderSnatcherEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SpiderWidowEntityIsHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double attackcycle = 0.0;
         if (entity.getPersistentData().getDouble("attackcycle") < 20.0) {
            entity.getPersistentData().putDouble("attackcycle", entity.getPersistentData().getDouble("attackcycle") + 1.0);
         } else {
            entity.getPersistentData().putDouble("attackcycle", 1.0);
         }

         if (entity.getPersistentData().getDouble("attackcycle") == 2.0) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(1.0F);
                  entityToSpawn.setYBodyRot(1.0F);
                  entityToSpawn.setYHeadRot(1.0F);
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0,
                  1.3,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 3.0
               )
            );
            ArphexMod.queueServerWork(
               10,
               () -> entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)), 0.1, Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                     )
                  )
            );
         }

         if (entity.getPersistentData().getDouble("attackcycle") == 12.0) {
            if (entity instanceof SpiderSnatcherEntity) {
               ((SpiderSnatcherEntity)entity).setAnimation("animation.spiderwidow.aggressive");
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 100, 1.0, 1.0, 1.0, 0.5);
            }

            ArphexMod.queueServerWork(20, () -> {
               if (world instanceof ServerLevel _levelxx) {
                  _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 200, 1.0, 1.0, 1.0, 0.7);
               }
            });
            ArphexMod.queueServerWork(
               40,
               () -> {
                  if (entity instanceof SpiderSnatcherEntity) {
                     ((SpiderSnatcherEntity)entity).setAnimation("empty");
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.sendParticles(ParticleTypes.WHITE_ASH, x, y, z, 200, 2.0, 2.0, 2.0, 1.0);
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "effect give @e[type=!arphex:spider_snatcher,distance=..5] arphex:webbed 4 0"
                        );
                  }
               }
            );
         }

         if (entity.getPersistentData().getDouble("attackcycle") >= 13.0) {
            ArphexMod.queueServerWork(40, () -> {
               if (entity instanceof SpiderSnatcherEntity) {
                  ((SpiderSnatcherEntity)entity).setAnimation("empty");
               }
            });
         }

         if (world instanceof Level _levelxx) {
            if (!_levelxx.isClientSide()) {
               _levelxx.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large")),
                  SoundSource.HOSTILE,
                  1.0F,
                  (float)Math.random()
               );
            } else {
               _levelxx.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod_large")),
                  SoundSource.HOSTILE,
                  1.0F,
                  (float)Math.random(),
                  false
               );
            }
         }
      }
   }
}
