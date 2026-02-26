package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentorSummonTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean foundowner = false;
         Entity storepassenger = null;
         if (!(entity.getPersistentData().getDouble("mothownercheck") > 0.0)) {
            if (!entity.isVehicle()
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
               && entity.isInWall()
               && entity instanceof TamableAnimal _tamEntx
               && _tamEntx.isTame()
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null) {
               if (entity.getY() < (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getY()) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.2, 0.0));
               } else {
                  entity.setDeltaMovement(new Vec3(0.0, -0.2, 0.0));
               }
            }

            foundowner = false;
            entity.getPersistentData().putDouble("mothownercheck", 20.0);
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(150.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if ((entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null) {
                  if ((entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null) == entityiterator) {
                     foundowner = true;
                  }

                  if (entityiterator instanceof TormentorSummonEntity
                     && entityiterator != entity
                     && entityiterator instanceof TamableAnimal _tamIsTamedBy
                     && (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null) instanceof LivingEntity _livEnt
                     && _tamIsTamedBy.isOwnedBy(_livEnt)
                     && entity.getX() < entityiterator.getX()
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }

            if (!foundowner) {
               if (entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(MobEffects.UNLUCK) && !entity.level().isClientSide()) {
                  entity.discard();
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 30, 0, false, false));
               }
            }
         } else {
            entity.getPersistentData().putDouble("mothownercheck", entity.getPersistentData().getDouble("mothownercheck") - 1.0);
         }

         entity.noPhysics = true;
         if ((!(entity instanceof LivingEntity _livEnt32) || !_livEnt32.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
         }

         if (!(entity instanceof TamableAnimal _tamEntxx) || !_tamEntxx.isTame()) {
            ArphexMod.queueServerWork(20, () -> {
               if ((!(entity instanceof TamableAnimal _tamEntxxx) || !_tamEntxxx.isTame()) && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (world.isClientSide()) {
            if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 0.0F)) {
               if (entity instanceof TormentorSummonEntity animatable) {
                  animatable.setTexture("tormentordead");
               }
            } else if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F)
               > (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F) {
               if (entity instanceof TormentorSummonEntity animatable) {
                  animatable.setTexture("tormentorsummon");
               }
            } else if (entity instanceof TormentorSummonEntity animatable) {
               animatable.setTexture("tormentor2");
            }
         }

         entity.fallDistance = 0.0F;
         if (entity.isVehicle()) {
            if (entity.getFirstPassenger() != null) {
               entity.getFirstPassenger().fallDistance = 0.0F;
               if (!(entity instanceof TamableAnimal _tamIsTamedBy)
                  || !(entity.getFirstPassenger() instanceof LivingEntity _livEntxxx)
                  || !_tamIsTamedBy.isOwnedBy(_livEntxxx)) {
                  entity.getFirstPassenger().stopRiding();
               }
            }
         } else if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
            if (entity.getY() + 1.0 < (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY()) {
               if (!world.isClientSide()) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ()
                     )
                  );
               }

               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                     0.3,
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            } else if (entity.getY() - 1.0 > (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY()) {
               if (!world.isClientSide()) {
                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ()
                     )
                  );
               }

               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                     -0.03,
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            }
         }

         if (entity instanceof TamableAnimal _tamEntxxx
            && _tamEntxxx.isTame()
            && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null) {
            if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
               && (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null)
                  == (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null)
               && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var19) {
                  var19.printStackTrace();
               }
            }

            if (!(
               ((ArphexModVariables.PlayerVariables)(entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null)
                        .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor
                  > 0.0
            )) {
               if ((entity instanceof TamableAnimal _tamEntxxxxx ? _tamEntxxxxx.getOwner() : null).getPersistentData().getBoolean("creativespectator")) {
                  if ((entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null) instanceof Player _player
                     && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal("You need at least one registered Tormentor kill to use this item (try /arphex set_tormentor_level)"), true
                     );
                  }
               } else if ((entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null) instanceof Player _player
                  && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("You need at least one registered Tormentor kill to use this item"), true);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            if (!world.isClientSide()) {
               if (((ArphexModVariables.PlayerVariables)(entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null)
                        .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .killedtormentor
                  > 100.0) {
                  if (entity instanceof TormentorSummonEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(TormentorSummonEntity.DATA_ownerkills, 100);
                  }
               } else if (entity instanceof TormentorSummonEntity _datEntSetI) {
                  _datEntSetI.getEntityData()
                     .set(
                        TormentorSummonEntity.DATA_ownerkills,
                        (int)Mth.nextDouble(
                           RandomSource.create(),
                           ((ArphexModVariables.PlayerVariables)(entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null)
                                 .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .killedtormentor,
                           ((ArphexModVariables.PlayerVariables)(entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null)
                                 .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .killedtormentor
                        )
                     );
               }
            }
         }

         if ((entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) > 99) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 6, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 6, false, false));
            }
         } else if ((entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) > 80) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 3, false, false));
            }
         } else if ((entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) > 60) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 2, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2, false, false));
            }
         } else if ((entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) > 40) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
            }
         } else if ((entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) > 20) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }
         }

         if (entity.isAlive()
            && entity instanceof TamableAnimal _tamEntxxx
            && _tamEntxxx.isTame()
            && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null) {
            double _setval = 160.0;
            (entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null)
               .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .ifPresent(capability -> {
                  capability.tormentor_summon_active = _setval;
                  capability.syncPlayerVariables(entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null);
               });
            double var164 = _setval = entity instanceof LivingEntity _livEntxxx ? (double)_livEntxxx.getHealth() : -1.0;
            (entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null)
               .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .ifPresent(capability -> {
                  capability.tmshealth = _setval;
                  capability.syncPlayerVariables(entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null);
               });
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:red_glow_smoke ~ ~ ~ 0 0 0 0 2 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 10, 0.4, 0.4, 0.4, 0.1);
         }

         entity.getPersistentData().putDouble("spiderjump", entity.getPersistentData().getDouble("spiderjump") - 1.0);
         if (entity instanceof TamableAnimal _tamEntxxx
            && _tamEntxxx.isTame()
            && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null) {
            double _setval = 150.0;
            (entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null)
               .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .ifPresent(capability -> {
                  capability.tormentor_summon_active = _setval;
                  capability.syncPlayerVariables(entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null);
               });
         }

         if (entity.getY() < 0.0
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.VOID_AIR
            && world.getBlockState(BlockPos.containing(x, y + 15.0, z)).getBlock() == Blocks.VOID_AIR) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.2, entity.getDeltaMovement().z()));
         }

         if (entity.getPersistentData().getDouble("attacklimitsummon") > 0.0) {
            entity.getPersistentData().putDouble("attacklimitsummon", entity.getPersistentData().getDouble("attacklimitsummon") - 1.0);
         }

         if (entity.isVehicle()) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(),
                  x,
                  y
                     + (double)(
                        (entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0)
                           / 50
                     ),
                  z,
                  5,
                  0.1,
                  0.1,
                  0.1,
                  0.1
               );
            }

            if (entity.getFirstPassenger() != null) {
               if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                     == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
                  && entity.getY() > 245.0
                  && entity.getFirstPassenger() != null) {
                  if (entity.getFirstPassenger() instanceof Player && entity.getFirstPassenger() instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("Cannot ride Tormentor Summon into Crawling Containers"), true);
                  }

                  entity.getFirstPassenger().stopRiding();
               }

               if (entity.getPersistentData().getBoolean("hovermode")) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }
            }

            if (entity.getFirstPassenger() != null) {
               label774: {
                  if (entity instanceof TamableAnimal _tamIsTamedBy
                     && entity.getFirstPassenger() instanceof LivingEntity _livEntxxx
                     && _tamIsTamedBy.isOwnedBy(_livEntxxx)
                     && (entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0)
                        >= 10) {
                     break label774;
                  }

                  if ((entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0)
                        < 10
                     && entity.getFirstPassenger() instanceof Player
                     && entity.getFirstPassenger() instanceof Player _player
                     && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal(
                           "Your Tormentor Summon must be level 10+ to ride it - Current level: "
                              + Math.round(
                                 entity instanceof TormentorSummonEntity _datEntIx
                                    ? (float)((Integer)_datEntIx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills)).intValue()
                                    : 0.0F
                              )
                        ),
                        true
                     );
                  }

                  entity.getFirstPassenger().stopRiding();
               }

               if ((entity instanceof TormentorSummonEntity _datEntI ? (Integer)_datEntI.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0) > 80) {
                  if (entity.getFirstPassenger() instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
                  }
               } else if ((
                     entity instanceof TormentorSummonEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0
                  )
                  > 60) {
                  if (entity.getFirstPassenger() instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 2, false, false));
                  }
               } else if ((
                     entity instanceof TormentorSummonEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills) : 0
                  )
                  > 40) {
                  if (entity.getFirstPassenger() instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
                  }
               } else if ((
                        entity instanceof TormentorSummonEntity _datEntIxxx
                           ? (Integer)_datEntIxxx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills)
                           : 0
                     )
                     > 20
                  && entity.getFirstPassenger() instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
               }

               label693:
               if (entity.getFirstPassenger() != null && entity.getFirstPassenger() instanceof Player) {
                  if (entity instanceof LivingEntity _livEnt198 && _livEnt198.hasEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get())) {
                     entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.3, entity.getDeltaMovement().z()));
                     break label693;
                  }

                  if (!entity.getPersistentData().getBoolean("hovermode")) {
                     entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.2, entity.getDeltaMovement().z()));
                  }
               }
            }

            if (entity instanceof LivingEntity _livEnt206 && _livEnt206.hasEffect((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get())) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }
         } else {
            entity.getPersistentData().putBoolean("hovermode", false);
            if (entity.isInWall()
               || !(world.getBlockState(BlockPos.containing(x, y, z)).getBlock() instanceof LiquidBlock) && !world.isEmptyBlock(BlockPos.containing(x, y, z))) {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.2, entity.getDeltaMovement().z()));
            }

            if (!(entity.getPersistentData().getDouble("torsumtick") > 0.0)) {
               entity.getPersistentData().putDouble("torsumtick", 5.0);
               if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) == null) {
                  if ((entity instanceof TamableAnimal _tamEntxxxxxxx ? _tamEntxxxxxxx.getOwner() : null) != null
                     && (double)(
                           12
                              + (
                                    entity instanceof TormentorSummonEntity _datEntIxxx
                                       ? (Integer)_datEntIxxx.getEntityData().get(TormentorSummonEntity.DATA_ownerkills)
                                       : 0
                                 )
                                 / 5
                        )
                        < Math.sqrt(
                           Math.pow(entity.getX() - (entity instanceof TamableAnimal _tamEntxxxxxx ? _tamEntxxxxxx.getOwner() : null).getX(), 2.0)
                              + Math.pow(entity.getY() - (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getY(), 2.0)
                              + (entity.getZ() - (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getZ()) * 2.0
                        )) {
                     entity.setDeltaMovement(
                        new Vec3(
                           ((entity instanceof TamableAnimal _tamEntxxxxxxxxxx ? _tamEntxxxxxxxxxx.getOwner() : null).getX() - entity.getX()) / 16.0,
                           ((entity instanceof TamableAnimal _tamEntxxxxxxxxx ? _tamEntxxxxxxxxx.getOwner() : null).getY() - entity.getY()) / 16.0,
                           ((entity instanceof TamableAnimal _tamEntxxxxxxxx ? _tamEntxxxxxxxx.getOwner() : null).getZ() - entity.getZ()) / 16.0
                        )
                     );
                  }
               } else {
                  entity.setDeltaMovement(
                     new Vec3(
                        ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX() - entity.getX()) / 10.0,
                        ((entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY() - entity.getY()) / 10.0,
                        ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ() - entity.getZ()) / 10.0
                     )
                  );
               }
            } else {
               entity.getPersistentData().putDouble("torsumtick", entity.getPersistentData().getDouble("torsumtick") - 1.0);
            }
         }

         if ((entity instanceof TormentorSummonEntity _datEntIxxx ? (Integer)_datEntIxxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin) : 0)
            == 0) {
            if (entity instanceof TormentorSummonEntity animatable) {
               animatable.setTexture("tormentorsummon");
            }
         } else if (entity instanceof TormentorSummonEntity animatable) {
            animatable.setTexture("tormentort2");
         }
      }
   }
}
