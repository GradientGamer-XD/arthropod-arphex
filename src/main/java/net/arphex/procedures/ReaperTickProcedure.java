package net.arphex.procedures;

import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderReaperEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ReaperTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.isSprinting()) {
            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
         }

         entity.getPersistentData().putBoolean("arphexclimber", true);
         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
            && (
               !world.isEmptyBlock(BlockPos.containing(x, y + 3.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y + 4.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y + 3.0, z))
                  || !world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))
            )
            && !entity.onGround()) {
            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
               && (entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                  == (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 1, false, false));
            }

            entity.setShiftKeyDown(false);
            entity.setSprinting(true);
            if (entity instanceof SpiderReaperEntity) {
               ((SpiderReaperEntity)entity).setAnimation("empty");
            }
         } else {
            entity.setSprinting(false);
            if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z)) && !entity.onGround()) {
               if (world.isClientSide()) {
                  if (world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))) {
                     if (entity instanceof SpiderReaperEntity) {
                        ((SpiderReaperEntity)entity).setAnimation("animation.spiderreaper.grabmove");
                     }
                  } else if (entity instanceof SpiderReaperEntity) {
                     ((SpiderReaperEntity)entity).setAnimation("empty");
                  }
               }

               entity.setShiftKeyDown(true);
            } else {
               if (entity instanceof SpiderReaperEntity) {
                  ((SpiderReaperEntity)entity).setAnimation("empty");
               }

               entity.setShiftKeyDown(false);
            }
         }

         entity.setMaxUpStep(2.0F);
         if (world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
               x,
               y + 1.0,
               z,
               (int)((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) / 6.0F),
               1.6,
               1.0,
               1.6,
               0.05
            );
         }

         if ((!(entity instanceof LivingEntity _livEnt35) || !_livEnt35.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
         }

         if (world.isClientSide()) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 3.0F) {
               if (entity instanceof SpiderReaperEntity animatable) {
                  animatable.setTexture("spiderreaper2");
               }

               if ((!(entity instanceof LivingEntity _livEnt41) || !_livEnt41.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
               }
            } else if (entity instanceof SpiderReaperEntity animatable) {
               animatable.setTexture("spiderreaper");
            }
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
            if (!(entity.getPersistentData().getDouble("wanderbreak") > 0.0)) {
               entity.getPersistentData().putDouble("wanderbreak", 15.0);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass_pane"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #arphex:breakable_doors"
                        );
                  }
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
                  && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace #minecraft:leaves"
                     );
               }
            } else {
               entity.getPersistentData().putDouble("wanderbreak", entity.getPersistentData().getDouble("wanderbreak") - 1.0);
            }
         }
      }
   }
}
