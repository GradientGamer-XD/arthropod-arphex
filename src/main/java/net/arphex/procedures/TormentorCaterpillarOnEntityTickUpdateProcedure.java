package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentorCaterpillarOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean foundenemy = false;
         entity.getPersistentData().putBoolean("tormentor_summon", true);
         if (!(entity.getPersistentData().getDouble("caterpillartimer") > 0.0)) {
            entity.getPersistentData().putDouble("caterpillartimer", 10.0);
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                           Vec2.ZERO,
                           _level,
                           4,
                           "",
                           Component.literal(""),
                           _level.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "particle arphex:torment_spiralling_small ~ ~ ~ 0 0 0 0 1 force"
                  );
            }

            ArphexMod.queueServerWork(
               2,
               () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:torment_spiralling_small ~ ~ ~ 0 0 0 0 1 force"
                        );
                  }
               }
            );
            ArphexMod.queueServerWork(
               5,
               () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:torment_spiralling_small ~ ~ ~ 0 0 0 0 1 force"
                        );
                  }
               }
            );
            ArphexMod.queueServerWork(
               8,
               () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:torment_spiralling_small ~ ~ ~ 0 0 0 0 1 force"
                        );
                  }
               }
            );
            if (ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0) {
               foundenemy = false;
               ArphexMod.queueServerWork(80, () -> entity.getPersistentData().putBoolean("startdamaging", true));
               if (entity.getPersistentData().getBoolean("startdamaging") && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "effect give @e[distance=..5] arphex:torment_spiral 1 1 true"
                     );
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (!foundenemy
                     && entityiterator.getPersistentData().getBoolean("tormentor_target")
                     && !(
                        ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .tormentor_respite
                           > 0.0
                     )) {
                     entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1, false, false));
                        }
                     }

                     if (entityiterator.getY() > entity.getY()) {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5,
                              0.4,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5
                           )
                        );
                     } else {
                        entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5,
                              -0.4,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 1.5
                           )
                        );
                     }

                     foundenemy = true;
                  }
               }

               if (!foundenemy) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        ArphexModVariables.MapVariables.get(world).tormentor_x,
                        ArphexModVariables.MapVariables.get(world).tormentor_y,
                        ArphexModVariables.MapVariables.get(world).tormentor_z
                     )
                  );
                  if (entity.getPersistentData().getBoolean("clockwisever")) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 0.0F) * (Math.PI / 180.0)) * 2.0,
                           entity.getDeltaMovement().y(),
                           Math.sin((double)(entity.getYRot() - 0.0F) * (Math.PI / 180.0)) * 2.0
                        )
                     );
                  } else {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 180.0F) * (Math.PI / 180.0)) * 2.0,
                           entity.getDeltaMovement().y(),
                           Math.sin((double)(entity.getYRot() - 180.0F) * (Math.PI / 180.0)) * 2.0
                        )
                     );
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 60) == 2 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 200, 1, false, false));
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 150) == 2) {
                     if (entity.getPersistentData().getBoolean("catdirection")) {
                        entity.getPersistentData().putBoolean("catdirection", false);
                     } else {
                        entity.getPersistentData().putBoolean("catdirection", true);
                     }
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 2) == 2
                     && (!(entity instanceof LivingEntity _livEnt58) || !_livEnt58.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get()))) {
                     if (entity.getPersistentData().getBoolean("catdirection")) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.6, entity.getDeltaMovement().z()));
                     } else {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.6, entity.getDeltaMovement().z()));
                     }
                  }
               }
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            entity.getPersistentData().putDouble("caterpillartimer", entity.getPersistentData().getDouble("caterpillartimer") - 1.0);
         }

         entity.noPhysics = true;
         ArphexMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1000, 1400), () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
      }
   }
}
