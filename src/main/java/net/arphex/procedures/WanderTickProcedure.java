package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.SpiderProwlerEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WanderTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphexclimber", true);
         if ((entity instanceof SpiderProwlerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderProwlerEntity.DATA_ontheprowl) : 0) > 0
            && entity instanceof SpiderProwlerEntity _datEntSetI) {
            _datEntSetI.getEntityData()
               .set(
                  SpiderProwlerEntity.DATA_ontheprowl,
                  (entity instanceof SpiderProwlerEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderProwlerEntity.DATA_ontheprowl) : 0) - 1
               );
         }

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
            if (world.isClientSide() && entity instanceof SpiderProwlerEntity) {
               ((SpiderProwlerEntity)entity).setAnimation("empty");
            }
         } else {
            entity.setSprinting(false);
            if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z)) && !entity.onGround()) {
               if (world.isClientSide()) {
                  if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
                     if (entity instanceof SpiderProwlerEntity) {
                        ((SpiderProwlerEntity)entity).setAnimation("animation.spiderwander.grabmove");
                     }
                  } else if (entity instanceof SpiderProwlerEntity) {
                     ((SpiderProwlerEntity)entity).setAnimation("empty");
                  }
               }

               entity.setShiftKeyDown(true);
               if (world.isClientSide() && entity instanceof SpiderProwlerEntity) {
                  ((SpiderProwlerEntity)entity).setAnimation("empty");
               }
            } else {
               entity.setShiftKeyDown(false);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
                  && !(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                           } else {
                              return _ent.level().isClientSide() && _ent instanceof Player _player
                                 ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                       == GameType.CREATIVE
                                 : false;
                           }
                        }
                     })
                     .checkGamemode(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null)
                     )
                  && !(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                           } else {
                              return _ent.level().isClientSide() && _ent instanceof Player _player
                                 ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                       == GameType.SPECTATOR
                                 : false;
                           }
                        }
                     })
                     .checkGamemode(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null)
                     )
                  && (entity instanceof SpiderProwlerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderProwlerEntity.DATA_ontheprowl) : 0) <= 0) {
                  if (Mth.nextInt(RandomSource.create(), 1, 2000) == 5 && entity instanceof SpiderProwlerEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(SpiderProwlerEntity.DATA_ontheprowl, 1200);
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 20, false, false));
                  }

                  entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                  if (world.isClientSide() && entity instanceof SpiderProwlerEntity) {
                     ((SpiderProwlerEntity)entity).setAnimation("animation.spiderwander.aggression");
                  }
               } else {
                  if (world.isClientSide() && entity instanceof SpiderProwlerEntity) {
                     ((SpiderProwlerEntity)entity).setAnimation("empty");
                  }

                  if (entity instanceof SpiderProwlerEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           SpiderProwlerEntity.DATA_ontheprowl,
                           (entity instanceof SpiderProwlerEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderProwlerEntity.DATA_ontheprowl) : 0)
                              - 1
                        );
                  }
               }
            }
         }

         entity.setMaxUpStep(1.5F);
         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
            && entity instanceof LivingEntity _livEnt54
            && _livEnt54.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
            if (!(entity.getPersistentData().getDouble("timer") > 0.0)) {
               entity.getPersistentData().putDouble("timer", 600.0);
            } else {
               entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            }

            if (entity.getPersistentData().getDouble("timer") == 5.0 && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         }

         if (world instanceof ServerLevel _levelx) {
            _levelx.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.TINY_SPIDER.get(),
               x,
               y + 1.0,
               z,
               (int)((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) / 6.0F),
               1.2,
               0.8,
               1.2,
               0.05
            );
         }

         label270: {
            if (entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(MobEffects.REGENERATION)) {
               break label270;
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
            }

            if (entity instanceof CentipedeEvictorEntity) {
               entity.setMaxUpStep(4.0F);
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
               }
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
            < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 3.0F) {
            if (entity instanceof SpiderProwlerEntity animatable) {
               animatable.setTexture("spiderwanderlow");
            }

            if ((!(entity instanceof LivingEntity _livEnt71) || !_livEnt71.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
            }
         } else if (entity instanceof SpiderProwlerEntity animatable) {
            animatable.setTexture("spiderwander");
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
            if (!(entity.getPersistentData().getDouble("wanderbreak") > 0.0)) {
               entity.getPersistentData().putDouble("wanderbreak", 15.0);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass"
                        );
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass_pane"
                        );
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #arphex:breakable_doors"
                        );
                  }
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
                  && world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                           )
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
