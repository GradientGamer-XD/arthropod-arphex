package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.AntArsonistEntity;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.CentipedeEvictorLarvaeEntity;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.entity.HornetHarbingerEntity;
import net.arphex.entity.RoachRiverspawnEntity;
import net.arphex.entity.SmallTormentSphereEntity;
import net.arphex.entity.SpiderBroodEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderFunnelEntity;
import net.arphex.entity.SpiderGoliathEntity;
import net.arphex.entity.SpiderJumpEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderLarvaeTinyEntity;
import net.arphex.entity.SpiderLurkerEntity;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.SpiderMothSummonEntity;
import net.arphex.entity.SpiderProwlerEntity;
import net.arphex.entity.SpiderSnatcherEntity;
import net.arphex.entity.TormentorMothSummonEntity;
import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.entity.VoidSpearEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EntitiesTickProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double ringspan = 0.0;
         double ringspin = 0.0;
         double hominglink = 0.0;
         boolean scansnearestfirst = false;
         boolean attack_attacker = false;
         boolean nearscan_eventmob = false;
         if (entity.getPersistentData().getDouble("just_teleported_arphex") > 0.0) {
            entity.getPersistentData().putDouble("just_teleported_arphex", entity.getPersistentData().getDouble("just_teleported_arphex") - 1.0);
         }

         if (entity.getPersistentData().getDouble("ascendedprotection") > 0.0) {
            entity.getPersistentData().putDouble("ascendedprotection", entity.getPersistentData().getDouble("ascendedprotection") - 1.0);
         }

         if (entity instanceof LivingEntity _livEnt6
            && _livEnt6.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())
            && (
               entity instanceof Spider
                  || entity instanceof CaveSpider
                  || entity instanceof SpiderBroodEntity
                  || entity instanceof SpiderFlatEntity
                  || entity instanceof SpiderFunnelEntity
                  || entity instanceof SpiderGoliathEntity
                  || entity instanceof SpiderJumpEntity
                  || entity instanceof SpiderLarvaeEntity
                  || entity instanceof SpiderLarvaeTinyEntity
                  || entity instanceof SpiderMothEntity
                  || entity instanceof SpiderMothSummonEntity
                  || entity instanceof SpiderProwlerEntity
                  || entity instanceof SpiderSnatcherEntity
            )) {
            entity.getPersistentData().putBoolean("spidertype", true);
            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.WEBBED.get());
            }
         }

         if (entity instanceof LivingEntity) {
            if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")
               && !(Boolean)ConfigurationSettingsConfiguration.ALL_ENTITY_INCLUSION.get()
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")) {
               if (entity.isPassenger()
                  && (!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
                  && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                  entity.stopRiding();
               }

               if (Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get()) > 0L
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(
                     new MobEffectInstance(
                        MobEffects.DAMAGE_BOOST, 20, (int)(Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get()) - 1L), false, false
                     )
                  );
               }

               if (Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY_LOWER.get()) > 0L
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(
                     new MobEffectInstance(
                        MobEffects.WEAKNESS, 20, (int)Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get() - 1.0), false, false
                     )
                  );
               }

               if (Math.round((Double)ConfigurationSettingsConfiguration.RESISTANCE_CONTROL.get()) > 0L
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(
                     new MobEffectInstance(
                        MobEffects.DAMAGE_RESISTANCE,
                        20,
                        (int)Math.round((Double)ConfigurationSettingsConfiguration.RESISTANCE_CONTROL.get() - 1.0),
                        false,
                        false
                     )
                  );
               }
            } else if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")) {
               entity.getPersistentData().putBoolean("arphex", true);
            }
         }

         if (entity instanceof LivingEntity _livEnt43
            && _livEnt43.getMobType() == MobType.ARTHROPOD
            && entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity.getY() < 60.0) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.4, 0.4, 0.4, 0.2);
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 4, false, false));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, true));
               }
            } else if (entity.getY() < 120.0) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2, false, false));
               }
            } else if (entity.getY() < 230.0) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
               }
            } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0, false, false));
            }
         }

         if (entity instanceof TropicalFish && !entity.getPersistentData().getBoolean("donespawn")) {
            entity.getPersistentData().putBoolean("donespawn", true);
            if (world.getEntitiesOfClass(SpiderLurkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 25.0, 25.0, 25.0), e -> true).isEmpty()
               && !world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
               && Mth.nextInt(RandomSource.create(), 1, (int)((Double)ConfigurationSettingsConfiguration.NON_BOSS_SPAWNRATE.get() * 12.0)) == 1
               && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LURKER.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         if (!world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(
                  LivingEntity.class,
                  AABB.ofSize(
                     new Vec3(
                        world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getX(),
                        world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getY(),
                        world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .getZ()
                     ),
                     3.0,
                     3.0,
                     3.0
                  ),
                  e -> true
               )
               .isEmpty()) {
            ArphexMod.queueServerWork(
               3,
               () -> {
                  int var10000;
                  label76: {
                     if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                        break label76;
                     }

                     var10000 = 0;
                  }

                  if (var10000 < 4
                     && !entity.getPersistentData().getBoolean("creativespectator")
                     && !entity.isInvulnerable()
                     && !world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
                     && (
                        world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .getPersistentData()
                              .getBoolean("firedaway")
                           || !(entity instanceof SpiderMothDwellerEntity)
                     )
                     && !world.getEntitiesOfClass(
                           LivingEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getX(),
                                 world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getY(),
                                 world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getZ()
                              ),
                              3.0,
                              3.0,
                              3.0
                           ),
                           e -> true
                        )
                        .isEmpty()
                     && world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
                                    world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getX(),
                                    world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getY(),
                                    world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getZ()
                                 ),
                                 3.0,
                                 3.0,
                                 3.0
                              ),
                              e -> true
                           )
                           .stream()
                           .sorted(
                              (new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 })
                                 .compareDistOf(
                                    world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getX(),
                                    world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getY(),
                                    world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y, z))
                                       .findFirst()
                                       .orElse(null)
                                       .getZ()
                                 )
                           )
                           .findFirst()
                           .orElse(null)
                        == entity) {
                     if (!world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()
                        && entity instanceof Player) {
                        if (!world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .level()
                           .isClientSide()) {
                           world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .discard();
                        }
                     } else if ((!(entity instanceof LivingEntity _livEnt101) || !_livEnt101.isBlocking())
                        && (entity instanceof LivingEntity _entUseItem102 ? _entUseItem102.getUseItem() : ItemStack.EMPTY).getItem()
                           != ArphexModItems.ABYSSAL_BLADE.get()
                        && (entity instanceof LivingEntity _entUseItem104 ? _entUseItem104.getUseItem() : ItemStack.EMPTY).getItem()
                           != ArphexModItems.ABYSS_ASCENDANT.get()) {
                        entity.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)),
                           (float)(5 - (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 5 + 8)
                        );
                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 1, 0.0, 0.0, 0.0, 0.0);
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.3, 0.3, 0.2, 0.6);
                        }

                        if (!world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .level()
                           .isClientSide()) {
                           world.getEntitiesOfClass(VoidSpearEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .discard();
                        }
                     }
                  }
               }
            );
         }

         if ((entity instanceof Cod || entity instanceof TropicalFish) && !entity.getPersistentData().getBoolean("donespawn")) {
            entity.getPersistentData().putBoolean("donespawn", true);
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).isEmpty()
               && world.getEntitiesOfClass(CrabConstrictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
               && !world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
               && Mth.nextInt(RandomSource.create(), 0, (int)Math.round((Double)ConfigurationSettingsConfiguration.NON_BOSS_SPAWNRATE.get() * 140.0)) == 1
               && (
                  world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_cold_ocean"))
                     || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_frozen_ocean"))
                     || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_ocean"))
               )
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, y + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 4.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 1.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 4.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 1.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 4.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 4.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 4.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 4.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 4.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 2.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 3.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 2.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 3.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 3.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 3.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 2.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 3.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 2.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 3.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 2.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 3.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 2.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 3.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 3.0, z - 1.0)).canOcclude()
               && world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.CRAB_CONSTRICTOR.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         if (entity.getPersistentData().getBoolean("smalltormentspheretarget")) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(300.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof SmallTormentSphereEntity) {
                  if (entityiterator instanceof Mob) {
                     Mob _entity = (Mob)entityiterator;
                     if (entity instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                     }
                  }

                  hominglink = Math.sqrt(
                     Math.pow(entity.getX() - entityiterator.getX(), 2.0)
                        + Math.pow(entity.getY() + 0.6 - entityiterator.getY(), 2.0)
                        + Math.pow(entity.getZ() - entityiterator.getZ(), 2.0)
                  );
                  if (hominglink != 0.0) {
                     entityiterator.getPersistentData()
                        .putDouble(
                           "originallockx", (entity.getX() + (double)Mth.nextInt(RandomSource.create(), -120, 120) - entityiterator.getX()) / hominglink * 1.9
                        );
                     entityiterator.getPersistentData()
                        .putDouble(
                           "originallocky", (entity.getY() + (double)Mth.nextInt(RandomSource.create(), -120, 120) - entityiterator.getY()) / hominglink * 1.9
                        );
                     entityiterator.getPersistentData()
                        .putDouble(
                           "originallockz", (entity.getZ() + (double)Mth.nextInt(RandomSource.create(), -120, 120) - entityiterator.getZ()) / hominglink * 1.9
                        );
                  }
               }
            }

            entity.getPersistentData().putBoolean("smalltormentspheretarget", false);
         }

         if (entity.getPersistentData().getBoolean("tormentor_target")
            && !(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)
            && world.getEntitiesOfClass(TormentorMothSummonEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(TormentorScorpioidSummonEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(TormentorVoidlasherSummonEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
            entity.getPersistentData().putBoolean("tormentor_target", false);
         }

         if (entity.getPersistentData().getBoolean("arthropleura_target")) {
            ArphexMod.queueServerWork(20, () -> entity.getPersistentData().putBoolean("arthropleura_target", false));
         }

         if (entity.getPersistentData().getDouble("tormentburntime") > 0.0) {
            entity.getPersistentData().putDouble("tormentburntime", entity.getPersistentData().getDouble("tormentburntime") - 1.0);
            if (entity instanceof Player) {
               double _setval = 5.0;
               entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.time_in_portal = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }

            entity.setSecondsOnFire(1);
            if (entity.getPersistentData().getDouble("tormentburntime") > 30.0) {
               if (!(entity.getPersistentData().getDouble("tormentburn") > 0.0)) {
                  if (world instanceof ServerLevel _levelxx) {
                     _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 1, 0.5, 0.5, 0.5, 0.5);
                  }

                  if ((float)(400 / (((entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) + 4) / 4))
                     > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 10.0F) {
                     entity.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                        (float)Math.round((float)(400 / (((entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0) + 4) / 4)))
                     );
                  } else {
                     entity.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                        (float)Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 10.0F)
                     );
                  }

                  entity.getPersistentData().putDouble("tormentburn", 10.0);
               } else {
                  entity.getPersistentData().putDouble("tormentburn", entity.getPersistentData().getDouble("tormentburn") - 1.0);
               }
            }
         }

         if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")) {
            if ((Double)ConfigurationSettingsConfiguration.RESISTANCE_CONTROL.get() > 0.0
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(
                  new MobEffectInstance(
                     MobEffects.DAMAGE_RESISTANCE, 20, (int)((Double)ConfigurationSettingsConfiguration.RESISTANCE_CONTROL.get() - 1.0), false, false
                  )
               );
            }

            if (entity.isInWater()
               && !(entity instanceof CentipedeEvictorEntity)
               && !(entity instanceof CentipedeEvictorLarvaeEntity)
               && (!(entity instanceof LivingEntity _livEnt225) || !_livEnt225.hasEffect(MobEffects.DOLPHINS_GRACE))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20, 9, false, false));
            }

            if ((Boolean)ConfigurationSettingsConfiguration.FRIENDLY_MODE.get()
               && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 99, false, false));
               }

               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var28) {
                     var28.printStackTrace();
                  }
               }
            }
         }

         if (entity.getPersistentData().getBoolean("unable_to_attack_player_arphex")) {
            if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player
               && entity instanceof Mob) {
               try {
                  ((Mob)entity).setTarget(null);
               } catch (Exception var27) {
                  var27.printStackTrace();
               }
            }

            if (entity instanceof RoachRiverspawnEntity && entity instanceof RoachRiverspawnEntity animatable) {
               animatable.setTexture("platinum_mob");
            }

            if (entity instanceof HornetHarbingerEntity && entity instanceof HornetHarbingerEntity animatable) {
               animatable.setTexture("emerald_mob");
            }

            if (entity instanceof CentipedeEvictorLarvaeEntity && entity instanceof CentipedeEvictorLarvaeEntity animatable) {
               animatable.setTexture("sapphire_mob");
            }

            if (entity instanceof AntArsonistEntity && entity instanceof AntArsonistEntity animatable) {
               animatable.setTexture("ruby_mob");
            }

            if (entity instanceof SpiderLarvaeEntity && entity instanceof SpiderLarvaeEntity animatable) {
               animatable.setTexture("golden_mob");
            }

            if (!(entity.getPersistentData().getDouble("slow_tame_follow_arphex") > 0.0)) {
               if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70.0, 70.0, 70.0), e -> true).isEmpty()) {
                  if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 13.0, 13.0, 13.0), e -> true).isEmpty()) {
                     if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 20, false, false));
                        }
                     } else if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Player
                        && entity instanceof LivingEntity _entity
                        && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 20, false, false));
                     }
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(35.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorx instanceof Player) {
                        if (entity.getPersistentData().getString("owner_force_arphex").equals(entityiteratorx.getDisplayName().getString())) {
                           if (4.0
                              > Math.sqrt(
                                 (entity.getX() - entityiteratorx.getX()) * (entity.getX() - entityiteratorx.getX())
                                    + (entity.getY() - entityiteratorx.getY()) * (entity.getY() - entityiteratorx.getY())
                                    + (entity.getZ() - entityiteratorx.getZ()) * (entity.getZ() - entityiteratorx.getZ())
                              )) {
                              nearscan_eventmob = true;
                           } else {
                              nearscan_eventmob = false;
                           }

                           if ((entityiteratorx instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() != Items.SUGAR
                              && (entityiteratorx instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != Items.SUGAR) {
                              if (nearscan_eventmob) {
                                 if ((entityiteratorx instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null) {
                                    if ((entityiteratorx instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) instanceof Player) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10, false, false));
                                          }
                                       }
                                    } else if (entity instanceof LivingEntity _entity) {
                                       _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                                    }
                                 } else if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10, false, false));
                                    }
                                 }
                              }

                              attack_attacker = true;
                           } else {
                              if (entity instanceof HornetHarbingerEntity && entity.getPersistentData().getDouble("flywalk") < 150.0) {
                                 entity.getPersistentData().putDouble("flywalk", 200.0);
                              }

                              if (nearscan_eventmob) {
                                 if ((entityiteratorx instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null) {
                                    if ((entityiteratorx instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null) instanceof Player) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10, false, false));
                                          }
                                       }
                                    } else if (entity instanceof LivingEntity _entity) {
                                       _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                                    }
                                 } else if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10, false, false));
                                    }
                                 }
                              } else if (entity instanceof Mob _entity) {
                                 _entity.getNavigation().moveTo(entityiteratorx.getX(), entityiteratorx.getY(), entityiteratorx.getZ(), 2.0);
                              }

                              attack_attacker = false;
                           }
                        }
                     } else if ((entityiteratorx instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null) != null
                        && !entityiteratorx.getPersistentData().getBoolean("unable_to_attack_player_arphex")) {
                        if (entityiteratorx instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entityiteratorx;
                           if (_tamEnt.isTame()) {
                              continue;
                           }
                        }

                        if (entity.getPersistentData()
                           .getString("owner_force_arphex")
                           .equals((entityiteratorx instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getDisplayName().getString())) {
                           if (entity instanceof LivingEntity _entity) {
                              _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                           }

                           if (entity instanceof Mob) {
                              Mob _entity = (Mob)entity;
                              if (entityiteratorx instanceof LivingEntity _ent) {
                                 _entity.setTarget(_ent);
                              }
                           }
                        }
                     }
                  }
               }

               entity.getPersistentData().putDouble("slow_tame_follow_arphex", 60.0);
            } else {
               entity.getPersistentData().putDouble("slow_tame_follow_arphex", entity.getPersistentData().getDouble("slow_tame_follow_arphex") - 1.0);
            }
         }
      }
   }
}
