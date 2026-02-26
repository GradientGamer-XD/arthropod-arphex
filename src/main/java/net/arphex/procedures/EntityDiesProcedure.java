package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.ArachnoidTimeCloneEntity;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.EntropyConduitEntity;
import net.arphex.entity.HitboxExpanderEntity;
import net.arphex.entity.NemesisProjectileEntity;
import net.arphex.entity.ScarabSummonEntity;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.SpiderGoliathEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderMatriarchEntity;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TimeDistortionWaveEntity;
import net.arphex.entity.TormentorMothSummonEntity;
import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTestEntity;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.entity.VenusFlytrapEntity;
import net.arphex.entity.WaspNemesisEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EntityDiesProcedure {
   @SubscribeEvent
   public static void onEntityDeath(LivingDeathEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(
            event,
            event.getEntity().level(),
            event.getEntity().getX(),
            event.getEntity().getY(),
            event.getEntity().getZ(),
            event.getEntity(),
            event.getSource().getEntity()
         );
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      execute(null, world, x, y, z, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         ItemStack custom_itemstack = ItemStack.EMPTY;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double cocoon_scan = 0.0;
         double milestone_value = 0.0;
         boolean found = false;
         boolean checkbane = false;
         if ((Boolean)ConfigurationSettingsConfiguration.DROP_TROPHIES.get()
            && entity instanceof LivingEntity
            && sourceentity instanceof Player
            && ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")
            && !entity.getPersistentData().getBoolean("done_trophy_arphex")) {
            milestone_value = (double)Math.max(
               10L, Math.round(1044.0 * Math.pow(entity instanceof LivingEntity _livEnt ? (double)_livEnt.getMaxHealth() : -1.0, -0.67068))
            );
            if ((
                  (sourceentity instanceof ServerPlayer _spx ? _spx.getStats().getValue(Stats.ENTITY_KILLED.get(entity.getType())) : 0) > 1
                        && (double)(sourceentity instanceof ServerPlayer _sp ? _sp.getStats().getValue(Stats.ENTITY_KILLED.get(entity.getType())) : 0)
                              % milestone_value
                           == 0.0
                     || (sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.INFINITE_TORMENT.get()
               )
               && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("clone")
               && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("hallucination")
               && !(entity instanceof VenusFlytrapEntity)
               && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("web")
               && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("moth_summon")) {
               custom_itemstack = new ItemStack((ItemLike)ArphexModItems.TROPHY_ITEM.get());
               custom_itemstack.getOrCreateTag()
                  .putString(
                     "trophy_entity",
                     ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().replace("_tiny", "").replace("_giant", "").replace("arphex:", "").strip()
                  );
               custom_itemstack.getOrCreateTag()
                  .putDouble("trophy_entity_size", 1.0 / (Math.cbrt((double)(entity.getBbHeight() * entity.getBbWidth())) * 10.0) * 4.0);
               if (milestone_value > 0.0) {
                  custom_itemstack.getOrCreateTag()
                     .putDouble(
                        "milestone_number",
                        (double)(sourceentity instanceof ServerPlayer _spxx ? _spxx.getStats().getValue(Stats.ENTITY_KILLED.get(entity.getType())) : 0)
                           / milestone_value
                     );
               }

               custom_itemstack.setHoverName(Component.literal(entity.getDisplayName().getString() + " Trophy"));
               if (custom_itemstack.getOrCreateTag().getString("trophy_entity").length() > 1 && world instanceof ServerLevel _level) {
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, custom_itemstack);
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }

               entity.getPersistentData().putBoolean("done_trophy_arphex", true);
            }
         }

         if (entity instanceof HitboxExpanderEntity || entity instanceof TimeDistortionWaveEntity) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.setHealth(1024.0F);
            }
         }

         if (entity instanceof LivingEntity _livEnt28
            && _livEnt28.getMobType() == MobType.ARTHROPOD
            && ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")
            && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) < 301.0F
            && (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) > 1.0F
            && !(entity instanceof SpiderMothEntity)
            && Mth.nextInt(RandomSource.create(), (int)(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F), 300) == 300
            && world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.RAW_HEMOLYMPH.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         if (entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect((MobEffect)ArphexModMobEffects.VOID_PROTECTION.get())) {
            sx = -12.0;
            found = false;
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (!found) {
                  for (int index0 = 0; index0 < 24; index0++) {
                     if (!found) {
                        sy = -12.0;

                        for (int index1 = 0; index1 < 24; index1++) {
                           if (!found) {
                              sz = -12.0;
                              if (!found) {
                                 for (int index2 = 0; index2 < 24; index2++) {
                                    if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))
                                       && world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 1.0, z + sz))
                                       && !world.isEmptyBlock(BlockPos.containing(x + sx, y + sy - 1.0, z + sz))) {
                                       if (entity instanceof LivingEntity _entity) {
                                          _entity.setHealth(1.0F);
                                       }

                                       if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get(), 2400, 0, false, false));
                                       }

                                       if (entity instanceof LivingEntity _entity) {
                                          _entity.removeEffect(MobEffects.WITHER);
                                       }

                                       entity.clearFire();
                                       entity.teleportTo(x + sx, y + sy, z + sz);
                                       if (entity instanceof ServerPlayer _serverPlayer) {
                                          _serverPlayer.connection.teleport(x + sx, y + sy, z + sz, entity.getYRot(), entity.getXRot());
                                       }

                                       if (event != null && event.isCancelable()) {
                                          event.setCanceled(true);
                                       }

                                       found = true;
                                    }

                                    sz++;
                                 }

                                 sy++;
                              }
                           }
                        }

                        sx++;
                     }
                  }
               }
            } else {
               sx = 12.0;
               if (!found) {
                  for (int index3 = 0; index3 < 24; index3++) {
                     if (!found) {
                        sy = 12.0;

                        for (int index4 = 0; index4 < 24; index4++) {
                           if (!found) {
                              sz = 12.0;
                              if (!found) {
                                 for (int index5 = 0; index5 < 24; index5++) {
                                    if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))
                                       && world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 1.0, z + sz))
                                       && !world.isEmptyBlock(BlockPos.containing(x + sx, y + sy - 1.0, z + sz))) {
                                       if (entity instanceof LivingEntity _entity) {
                                          _entity.setHealth(1.0F);
                                       }

                                       if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get(), 2400, 0, false, false));
                                       }

                                       if (entity instanceof LivingEntity _entity) {
                                          _entity.removeEffect(MobEffects.WITHER);
                                       }

                                       entity.clearFire();
                                       entity.teleportTo(x + sx, y + sy, z + sz);
                                       if (entity instanceof ServerPlayer _serverPlayer) {
                                          _serverPlayer.connection.teleport(x + sx, y + sy, z + sz, entity.getYRot(), entity.getXRot());
                                       }

                                       if (event != null && event.isCancelable()) {
                                          event.setCanceled(true);
                                       }

                                       found = true;
                                    }

                                    sz--;
                                 }

                                 sy--;
                              }
                           }
                        }

                        sx--;
                     }
                  }
               }
            }
         }

         if (entity instanceof SpiderMothEntity
            && sourceentity instanceof Player
            && ((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .mothsurvivals
               <= 3.0) {
            double _setval = 5.0;
            sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.mothsurvivals = _setval;
               capability.syncPlayerVariables(sourceentity);
            });
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 300, 3.0, 3.0, 3.0, 1.0);
            }
         }

         if (entity instanceof ScorpioidBloodlusterEntity
            && sourceentity instanceof Player
            && !((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .killedscorpioid) {
            boolean _setval = true;
            sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.killedscorpioid = _setval;
               capability.syncPlayerVariables(sourceentity);
            });
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 300, 3.0, 3.0, 3.0, 1.0);
            }
         }

         if (entity instanceof SpiderMothDwellerEntity
            && sourceentity instanceof Player
            && !((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .killedvoidlasher) {
            boolean _setval = true;
            sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.killedvoidlasher = _setval;
               capability.syncPlayerVariables(sourceentity);
            });
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 300, 3.0, 3.0, 3.0, 1.0);
            }
         }

         if (entity instanceof Player && sourceentity instanceof SpiderMothEntity) {
            label802:
            if (!(entity.getPersistentData().getDouble("has_bane_of_darkness") > 0.0)) {
               if (sourceentity instanceof LivingEntity _livEnt66 && _livEnt66.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                  break label802;
               }

               ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "moth_killed_player_without_bane";
               ArphexModVariables.MapVariables.get(world).syncData(world);
               if (!sourceentity.level().isClientSide()) {
                  sourceentity.discard();
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }
         }

         if (entity instanceof Player
            && !world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            if (!(entity.getPersistentData().getDouble("has_bane_of_darkness") > 0.0)) {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof SpiderMothEntity && entityiterator.getPersistentData().getBoolean("spawnedawayfromplayer")) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt75 = (LivingEntity)entityiterator;
                        if (_livEnt75.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                           continue;
                        }
                     }

                     if (!entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                     }

                     ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "moth-player-died-near-without-bane";
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
                     }
                  }
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.PURPLE_GLINTS.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }
         }

         if (entity instanceof Player
            && !world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
            && !(entity.getPersistentData().getDouble("has_bane_of_darkness") > 0.0)) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorx instanceof ScorpioidBloodlusterEntity && entityiteratorx.getPersistentData().getBoolean("spawnedawayfromplayer")) {
                  if (entityiteratorx instanceof LivingEntity) {
                     LivingEntity _livEnt89 = (LivingEntity)entityiteratorx;
                     if (_livEnt89.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                        continue;
                     }
                  }

                  if (!entityiteratorx.level().isClientSide()) {
                     entityiteratorx.discard();
                  }

                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "scorpioid-player-died-near-without-bane";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
                  }
               }
            }
         }

         if (entity instanceof Player
            && (
               !world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
                  || !world.getEntitiesOfClass(ArachnoidTrisectorEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
            )
            && !(entity.getPersistentData().getDouble("has_bane_of_darkness") > 0.0)) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.PURPLE_GLINTS.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if ((entityiteratorxx instanceof SpiderMothDwellerEntity || entityiteratorxx instanceof ArachnoidTrisectorEntity)
                  && entityiteratorxx.getPersistentData().getBoolean("spawnedawayfromplayer")) {
                  if (entityiteratorxx instanceof LivingEntity) {
                     LivingEntity _livEnt103 = (LivingEntity)entityiteratorxx;
                     if (_livEnt103.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                        continue;
                     }
                  }

                  if (!entityiteratorxx.level().isClientSide()) {
                     entityiteratorxx.discard();
                  }

                  if (entityiteratorxx instanceof SpiderMothDwellerEntity) {
                     ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "voidlasher-player-died-near-without-bane";
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                  } else {
                     ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "trisector-player-died-near-without-bane";
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.PURPLE_GLINTS.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 50, 1.0, 1.0, 1.0, 0.5);
                  }
               }
            }
         }

         if (entity instanceof ScarabSummonEntity) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.setHealth(1.0F);
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (entity instanceof AntArsonistAlateQueenEntity
            && entity instanceof TamableAnimal _tamEntx
            && _tamEntx.isTame()
            && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null) {
            if ((entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Your ant queen died, and the colony is now no longer able to repopulate."), true);
            }

            if (sourceentity instanceof Player && sourceentity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(
                  Component.literal(
                     "You killed "
                        + (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getDisplayName().getString()
                        + "'s ant queen, destroying their ant colony!"
                  ),
                  true
               );
            }
         }

         if (entity instanceof SpiderMothEntity && !ArphexModVariables.MapVariables.get(world).bosskills.contains("moth")) {
            ArphexModVariables.MapVariables.get(world).bosskills = ArphexModVariables.MapVariables.get(world).bosskills + "moth";
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (ArphexModVariables.MapVariables.get(world).bosskills.contains("moth")
               && ArphexModVariables.MapVariables.get(world).bosskills.contains("scorpioid")
               && ArphexModVariables.MapVariables.get(world).bosskills.contains("voidlasher")) {
               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer()
                     .getPlayerList()
                     .broadcastSystemMessage(
                        Component.literal(
                           sourceentity.getDisplayName().getString()
                              + " destroyed the last of the three demonic entities, freeing each dimension from their oppressive influence. However, there remains another much larger threat..."
                        ),
                        false
                     );
               }

               ArphexMod.queueServerWork(
                  200,
                  () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "tellraw @a [{\"text\":\"THE ULTIMATE TERROR ARRIVES FROM A DIMENSION BEYOND. BEWARE THE TORMENTOR!\", \"color\": \"red\" }]"
                           );
                     }
                  }
               );
            }
         }

         if (entity instanceof ScorpioidBloodlusterEntity && !ArphexModVariables.MapVariables.get(world).bosskills.contains("scorpioid")) {
            ArphexModVariables.MapVariables.get(world).bosskills = ArphexModVariables.MapVariables.get(world).bosskills + "scorpioid";
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (ArphexModVariables.MapVariables.get(world).bosskills.contains("moth")
               && ArphexModVariables.MapVariables.get(world).bosskills.contains("scorpioid")
               && ArphexModVariables.MapVariables.get(world).bosskills.contains("voidlasher")) {
               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer()
                     .getPlayerList()
                     .broadcastSystemMessage(
                        Component.literal(
                           sourceentity.getDisplayName().getString()
                              + " destroyed the last of the three demonic entities, freeing each dimension from their oppressive influence. However, there remains another much larger threat..."
                        ),
                        false
                     );
               }

               ArphexMod.queueServerWork(
                  200,
                  () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "tellraw @a [{\"text\":\"THE ULTIMATE TERROR ARRIVES FROM A DIMENSION BEYOND. BEWARE THE TORMENTOR!\", \"color\": \"red\" }]"
                           );
                     }
                  }
               );
            }
         }

         if (entity instanceof SpiderMothDwellerEntity && !ArphexModVariables.MapVariables.get(world).bosskills.contains("voidlasher")) {
            ArphexModVariables.MapVariables.get(world).bosskills = ArphexModVariables.MapVariables.get(world).bosskills + "voidlasher";
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (ArphexModVariables.MapVariables.get(world).bosskills.contains("moth")
               && ArphexModVariables.MapVariables.get(world).bosskills.contains("scorpioid")
               && ArphexModVariables.MapVariables.get(world).bosskills.contains("voidlasher")) {
               if (!world.isClientSide() && world.getServer() != null) {
                  world.getServer()
                     .getPlayerList()
                     .broadcastSystemMessage(
                        Component.literal(
                           sourceentity.getDisplayName().getString()
                              + " destroyed the last of the three demonic entities, freeing each dimension from their oppressive influence. However, there remains another much larger threat..."
                        ),
                        false
                     );
               }

               ArphexMod.queueServerWork(
                  200,
                  () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "tellraw @a [{\"text\":\"THE ULTIMATE TERROR ARRIVES FROM A DIMENSION BEYOND. BEWARE THE TORMENTOR!\", \"color\": \"red\" }]"
                           );
                     }
                  }
               );
            }
         }

         if (entity instanceof TORMENTOREntity) {
            if (!ArphexModVariables.MapVariables.get(world).bosskills.contains("tormentor")) {
               ArphexModVariables.MapVariables.get(world).bosskills = ArphexModVariables.MapVariables.get(world).bosskills + "tormentor";
               ArphexModVariables.MapVariables.get(world).syncData(world);
            }

            if (ArphexModVariables.MapVariables.get(world).tormentor_health > 5.0 && event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if ((
               entity instanceof TormentorTestEntity
                  || entity instanceof TormentorT2Entity
                  || entity instanceof TormentorT3Entity
                  || entity instanceof TormentorT4Entity
                  || entity instanceof TormentorT5Entity
            )
            && ArphexModVariables.MapVariables.get(world).tormentor_health > 1.0
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof SpiderGoliathEntity && sourceentity instanceof WaspNemesisEntity) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.WASP_NEMESIS.get())
                  .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(WaspNemesisEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                     Entity patt27415$temp = world.getEntitiesOfClass(WaspNemesisEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (patt27415$temp instanceof WaspNemesisEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(WaspNemesisEntity.DATA_size, 5);
                     }
                  }
               }
            );
         }

         if (entity instanceof TORMENTOREntity) {
            ArphexMod.queueServerWork(
               2,
               () -> {
                  if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 4.0)) {
                     if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                        Entity patt28219$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if ((patt28219$temp instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()) {
                           return;
                        }
                     }

                     if (world instanceof ServerLevel _levelx) {
                        ItemEntity entityToSpawnx = new ItemEntity(_levelx, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                        entityToSpawnx.setPickUpDelay(10);
                        _levelx.addFreshEntity(entityToSpawnx);
                     }

                     TORMENTOREntityDiesProcedure.execute(world, x, y, z);
                  }
               }
            );
         }

         if (sourceentity instanceof Player) {
            if (entity instanceof SpiderLarvaeEntity) {
               sourceentity.getPersistentData().putBoolean("spidergrab", false);
            }

            if ((
                  entity instanceof TormentorVoidlasherSummonEntity
                     || entity instanceof TormentorScorpioidSummonEntity
                     || entity instanceof TormentorMothSummonEntity
               )
               && ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0
               && sourceentity instanceof Player _player
               && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Killing the summon damaged the TORMENTOR!"), true);
            }
         }

         if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")
            && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("hallucination")
            && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("projectile")
            && !entity.isInvisible()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) < 150.0F) {
            ArphexMod.queueServerWork(
               10,
               () -> {
                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(
                        (SimpleParticleType)ArphexModParticleTypes.DEATH_SPLASH.get(),
                        x,
                        y,
                        z,
                        (int)(entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F),
                        0.3 + (double)((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) / 500.0F),
                        0.3 + (double)((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 500.0F),
                        0.3 + (double)((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 500.0F),
                        0.2
                     );
                  }
               }
            );
         }

         if (entity instanceof Player
            && (
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.INFINITE_TORMENT.get()
                  || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.INFINITE_TORMENT.get()
            )
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (sourceentity instanceof SpiderMatriarchEntity) {
            cocoon_scan = 0.0;
            if (entity.getBbHeight() < 2.0F && entity.getBbWidth() < 1.0F) {
               for (int index6 = 0; index6 < 20; index6++) {
                  if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y + cocoon_scan, z)).getBlock()).toString().contains("silken")
                     && world.isEmptyBlock(BlockPos.containing(x, y + cocoon_scan - 1.0, z))
                     && world.isEmptyBlock(BlockPos.containing(x, y + cocoon_scan - 2.0, z))) {
                     entity.teleportTo(Math.floor(x) + 0.5, Math.floor(y + cocoon_scan - 2.0), Math.floor(z) + 0.5);
                     if (entity instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection
                           .teleport(Math.floor(x) + 0.5, Math.floor(y + cocoon_scan - 2.0), Math.floor(z) + 0.5, entity.getYRot(), entity.getXRot());
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 0, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 240, 0, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 480, 0, false, false));
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 480, 0, false, false));
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 50, 0.5, 10.0, 0.5, 0.2);
                     }

                     world.setBlock(
                        BlockPos.containing(x, y + cocoon_scan - 1.0, z), ((Block)ArphexModBlocks.SPIDER_COCOON_PLAYER.get()).defaultBlockState(), 3
                     );
                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     if (entity instanceof LivingEntity _entity) {
                        _entity.setHealth(1.0F);
                     }
                     break;
                  }

                  cocoon_scan++;
               }
            }
         }

         if (entity instanceof ArachnoidTimeCloneEntity) {
            if (entity instanceof LivingEntity _entity) {
               _entity.setHealth(1.0F);
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (sourceentity instanceof Player
            && entity instanceof SpiderMothEntity
            && (
               !(sourceentity instanceof ServerPlayer _plr203)
                  || !(_plr203.level() instanceof ServerLevel)
                  || !_plr203.getAdvancements()
                     .getOrStartProgress(_plr203.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:moth_ward")))
                     .isDone()
            )
            && sourceentity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:moth_ward"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         label676:
         if ((sourceentity instanceof ArachnoidTrisectorEntity || sourceentity instanceof DiabolosDecimatorEntity) && entity instanceof Player) {
            if (sourceentity instanceof LivingEntity _livEnt208 && _livEnt208.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
               break label676;
            }

            checkbane = false;
            if (!(entity.getPersistentData().getDouble("has_bane_of_darkness") > 0.0)) {
               if (!sourceentity.level().isClientSide()) {
                  sourceentity.discard();
               }

               if (sourceentity instanceof ArachnoidTrisectorEntity) {
                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "trisector-killed-player-without-bane";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
               } else {
                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "diabolos-killed-player-without-bane";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
               }
            }
         }

         if (entity instanceof NemesisProjectileEntity) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (entity instanceof EntropyConduitEntity) {
            if (sourceentity instanceof Player && sourceentity instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("§aDestroying the Entropy Conduit healed you and damaged the Diabolos!"), true);
            }

            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false));
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(),
                  sourceentity.getX(),
                  sourceentity.getY(),
                  sourceentity.getZ(),
                  5,
                  0.3,
                  0.3,
                  0.3,
                  0.2
               );
            }
         }

         if (entity instanceof SphereAnimEntity && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof SpiderMothEntity && entity instanceof LivingEntity _livEnt224 && _livEnt224.hasEffect(MobEffects.DIG_SPEED)) {
            if (world instanceof ServerLevel _levelx) {
               ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, new ItemStack((ItemLike)ArphexModItems.SPIDER_MOTH_SUMMONER.get()));
               entityToSpawn.setPickUpDelay(10);
               entityToSpawn.setUnlimitedLifetime();
               _levelx.addFreshEntity(entityToSpawn);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeAllEffects();
            }
         }
      }
   }
}
