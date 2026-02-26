package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderInfestorEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SpiderInfestorOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.isClientSide()) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
               if (entity instanceof SpiderInfestorEntity animatable) {
                  animatable.setTexture("sandspider");
               }
            } else if (entity instanceof SpiderInfestorEntity animatable) {
               animatable.setTexture("sandspider2");
            }
         }

         if ((entity instanceof SpiderInfestorEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderInfestorEntity.DATA_ontheprowl) : 0) <= 0) {
            if (entity instanceof SpiderInfestorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SpiderInfestorEntity.DATA_ontheprowl, Mth.nextInt(RandomSource.create(), 600, 2400));
            }
         } else {
            if ((entity instanceof SpiderInfestorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderInfestorEntity.DATA_ontheprowl) : 0) < 181) {
               if (entity.onGround()) {
                  entity.setSprinting(true);
               }

               if ((entity instanceof SpiderInfestorEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SpiderInfestorEntity.DATA_ontheprowl) : 0) < 40
                  && entity.isSprinting()) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, -1, 0, false, false));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 999999, 0, false, false));
                  }

                  ArphexMod.queueServerWork(5, () -> entity.setSprinting(false));
               }
            } else if (entity.isSprinting()) {
               entity.setSprinting(false);
            }

            if (entity instanceof SpiderInfestorEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderInfestorEntity.DATA_ontheprowl,
                     (entity instanceof SpiderInfestorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderInfestorEntity.DATA_ontheprowl) : 0) - 1
                  );
            }
         }

         if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.INVISIBILITY) || entity.isSprinting()) {
            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
            }

            if (entity instanceof SpiderInfestorEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     SpiderInfestorEntity.DATA_timehiding,
                     (entity instanceof SpiderInfestorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderInfestorEntity.DATA_timehiding) : 0) + 1
                  );
            }
         } else if (entity instanceof SpiderInfestorEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderInfestorEntity.DATA_timehiding, 0);
         }

         if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
            && 12.0
               > Math.sqrt(
                  Math.pow(entity.getX() - (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX(), 2.0)
                     + Math.pow(entity.getY() - (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY(), 2.0)
                     + (entity.getZ() - (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()) * 2.0
               )
            && (entity instanceof SpiderInfestorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderInfestorEntity.DATA_timehiding) : 0) > 80) {
            if (entity instanceof SpiderInfestorEntity) {
               ((SpiderInfestorEntity)entity).setAnimation("animation.spider_infestor.prowling");
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.INVISIBILITY);
            }

            if (entity instanceof SpiderInfestorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SpiderInfestorEntity.DATA_timehiding, 0);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 100, 1.0, 0.6, 1.0, 1.0);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                     SoundSource.HOSTILE,
                     0.4F,
                     0.8F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                     SoundSource.HOSTILE,
                     0.4F,
                     0.8F,
                     false
                  );
               }
            }

            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                  0.6,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
            ArphexMod.queueServerWork(
               8,
               () -> {
                  if ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) != null) {
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
                           0.6,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  }
               }
            );
         }

         if (!entity.onGround()
            && (entity instanceof SpiderInfestorEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderInfestorEntity.DATA_timehiding) : 0) > 80) {
            if (entity instanceof SpiderInfestorEntity) {
               ((SpiderInfestorEntity)entity).setAnimation("animation.spider_infestor.prowling");
            }

            ArphexMod.queueServerWork(15, () -> {
               if (entity instanceof LivingEntity _entity) {
                  _entity.removeEffect(MobEffects.INVISIBILITY);
               }
            });
            if (entity instanceof SpiderInfestorEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SpiderInfestorEntity.DATA_timehiding, 0);
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 100, 1.0, 0.6, 1.0, 1.0);
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                     SoundSource.HOSTILE,
                     0.4F,
                     0.8F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
                     SoundSource.HOSTILE,
                     0.4F,
                     0.8F,
                     false
                  );
               }
            }

            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                  0.6,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
         }

         if (entity.isVehicle()
            && entity.getFirstPassenger() != null
            && entity.getFirstPassenger() instanceof Skeleton
            && !entity.getPersistentData().getBoolean("donedes")) {
            if (!entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }

            entity.getPersistentData().putBoolean("donedes", true);
         }

         label368: {
            entity.setMaxUpStep(2.0F);
            if (entity instanceof LivingEntity _livEnt83 && _livEnt83.hasEffect(MobEffects.INVISIBILITY)) {
               if (world instanceof ServerLevel _levelxx) {
                  _levelxx.sendParticles(
                     (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
                     x,
                     y - 0.5,
                     z,
                     Math.round((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) / 64.0F),
                     1.6,
                     1.0,
                     1.6,
                     0.05
                  );
               }
               break label368;
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(),
                  x,
                  y + 1.0,
                  z,
                  (int)((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F) / 16.0F),
                  1.6,
                  1.0,
                  1.6,
                  0.05
               );
            }
         }

         if ((!(entity instanceof LivingEntity _livEnt88) || !_livEnt88.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0, false, false));
         }

         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
            if (!(entity.getPersistentData().getDouble("wanderbreak") > 0.0)) {
               entity.getPersistentData().putDouble("wanderbreak", 50.0);
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace glass_pane"
                        );
                  }

                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #arphex:breakable_doors"
                        );
                  }
               }

               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
                  && world instanceof ServerLevel _levelxx) {
                  _levelxx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                           )
                           .withSuppressedOutput(),
                        "fill ~-2 ~-2 ~-2 ~2 ~2 ~2 air replace #minecraft:leaves"
                     );
               }
            } else {
               entity.getPersistentData().putDouble("wanderbreak", entity.getPersistentData().getDouble("wanderbreak") - 1.0);
            }
         }

         if (entity.getPersistentData().getBoolean("crashdown")) {
            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.LONG_HEAVY_PURPLE_SMOKE.get(), x, y, z, 10, 0.4, 0.4, 0.4, 0.1);
            }

            if (entity.onGround()) {
               if (world instanceof ServerLevel _levelxx) {
                  _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.LONG_HEAVY_PURPLE_SMOKE.get(), x, y, z, 50, 0.4, 0.4, 0.4, 0.5);
               }

               if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
                  && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()) {
                  if (world instanceof Level _levelxx && !_levelxx.isClientSide()) {
                     _levelxx.explode(null, x, y, z, 8.0F, ExplosionInteraction.MOB);
                  }

                  entity.setDeltaMovement(new Vec3(0.0, -1.0, 0.0));
                  ArphexMod.queueServerWork(5, () -> entity.setDeltaMovement(new Vec3(0.0, -1.0, 0.0)));
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof LivingEntity && entityiterator != entity && !entityiterator.getPersistentData().getBoolean("creativespectator")
                     )
                   {
                     entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 20.0F
                     );
                  }
               }

               entity.getPersistentData().putBoolean("crashdown", false);
            }

            ArphexMod.queueServerWork(120, () -> entity.getPersistentData().putBoolean("crashdown", false));
         }

         Vec3 motion = entity.getDeltaMovement();
         if (motion.x != 0.0 || motion.y != 0.0 || motion.z != 0.0) {
            boolean inCobweb = false;
            AABB box = entity.getBoundingBox();
            Level lvl = entity.level();
            double minX = box.minX;
            double minY = box.minY;
            double minZ = box.minZ;
            double maxX = box.maxX;
            double maxY = box.maxY;
            double maxZ = box.maxZ;

            for (int bx = (int)Math.floor(minX); bx <= (int)Math.floor(maxX); bx++) {
               for (int by = (int)Math.floor(minY); by <= (int)Math.floor(maxY); by++) {
                  for (int bz = (int)Math.floor(minZ); bz <= (int)Math.floor(maxZ); bz++) {
                     BlockState state = lvl.getBlockState(new BlockPos(bx, by, bz));
                     if (state.getBlock() == Blocks.COBWEB
                        && (double)(bx + 1) > minX
                        && (double)bx < maxX
                        && (double)(by + 1) > minY
                        && (double)by < maxY
                        && (double)(bz + 1) > minZ
                        && (double)bz < maxZ) {
                        inCobweb = true;
                        entity.makeStuckInBlock(state, new Vec3(2.0, 3.0, 2.0));
                        break;
                     }
                  }

                  if (inCobweb) {
                     break;
                  }
               }

               if (inCobweb) {
                  break;
               }
            }
         }
      }
   }
}
