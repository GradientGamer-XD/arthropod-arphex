package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.BeetleTickMiteEntity;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.BloodthirstyTendrilEntity;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.HornetHarbingerEntity;
import net.arphex.entity.HornetHarbingerGiantEntity;
import net.arphex.entity.LongLegsEntity;
import net.arphex.entity.LongLegsTinyEntity;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.SpiderBroodEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderFunnelEntity;
import net.arphex.entity.SpiderGoliathEntity;
import net.arphex.entity.SpiderJumpEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderLarvaeTinyEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.SpiderMothLarvaeEntity;
import net.arphex.entity.SpiderProwlerEntity;
import net.arphex.entity.SpiderSnatcherEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.entity.TinyCentipedeBreacherEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class DwellerTargetProcedure {
   @SubscribeEvent
   public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
      execute(
         event,
         event.getEntity().level(),
         event.getEntity().getX(),
         event.getEntity().getY(),
         event.getEntity().getZ(),
         event.getOriginalTarget(),
         event.getEntity()
      );
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      execute(null, world, x, y, z, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         double raytrace_distance = 0.0;
         boolean entity_found = false;
         if ((
               (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.UMBRAL_CHESTPLATE.get()
                  || (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ETERNAL_CHESTPLATE.get()
                  || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     == ArphexModItems.IMMORTAL_CHESTPLATE.get()
            )
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ABYSSAL_DETECTOR.get(), 50, 0, false, false));
         }

         if (sourceentity instanceof SpiderMothEntity) {
            if (!(sourceentity.getPersistentData().getDouble("flytime") > 0.0)) {
               sourceentity.getPersistentData().putDouble("flytime", (double)Mth.nextInt(RandomSource.create(), 15, 35));
            } else {
               sourceentity.getPersistentData().putDouble("flytime", sourceentity.getPersistentData().getDouble("flytime") - 1.0);
            }

            if (sourceentity instanceof LivingEntity _livEnt13
               && _livEnt13.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())
               && !entity.getPersistentData().getString("flyvers").equals("float")) {
               if (sourceentity.getPersistentData().getDouble("flytime") == 5.0) {
                  sourceentity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0,
                        sourceentity.getDeltaMovement().y(),
                        Math.sin((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0
                     )
                  );
               }

               if (sourceentity.getZ() + 20.0 > entity.getZ()
                  || sourceentity.getZ() - 20.0 < entity.getZ()
                  || sourceentity.getX() + 20.0 > entity.getX()
                  || sourceentity.getX() - 20.0 < entity.getX()) {
                  if (entity.getPersistentData().getString("flyvers").equals("clockwise")) {
                     if (sourceentity.getPersistentData().getDouble("flytime") == 4.0 && !world.isClientSide()) {
                        sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX() + 10.0, entity.getY(), entity.getZ() + 10.0));
                     }
                  } else if (entity.getPersistentData().getString("flyvers").equals("anticlockwise")
                     && sourceentity.getPersistentData().getDouble("flytime") == 4.0
                     && !world.isClientSide()) {
                     sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX() - 10.0, entity.getY(), entity.getZ() - 10.0));
                  }
               }
            }

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
                     "effect clear @e[type=arphex:spider_moth,limit=1,distance=..7] slow_falling"
                  );
            }

            if (entity.getPersistentData().getString("chasemode").equals("chasing")) {
               if ((!(sourceentity instanceof LivingEntity _livEnt47) || !_livEnt47.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get()))
                  && !world.isClientSide()) {
                  sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
               }

               sourceentity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)),
                     sourceentity.getDeltaMovement().y(),
                     Math.sin((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0))
                  )
               );
            }

            if (entity instanceof SpiderMothLarvaeEntity && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var33) {
                  var33.printStackTrace();
               }
            }

            if ((entity instanceof Player && entity.getPersistentData().getBoolean("creativespectator") || !entity.isAlive()) && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var32) {
                  var32.printStackTrace();
               }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator == entity && entity.isAlive()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _livEnt65 = (LivingEntity)sourceentity;
                     if (_livEnt65.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                        continue;
                     }
                  }

                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0, true, false));
                     }
                  }
               }
            }

            if (!entity.getPersistentData().getBoolean("growattack")
               && !(sourceentity instanceof SpiderMothEntity animatable ? animatable.getTexture() : "null").equals("redglow")
               && sourceentity.getX() + 2.1 > entity.getX()
               && sourceentity.getX() - 2.1 < entity.getX()
               && sourceentity.getY() + 1.0 > entity.getY()
               && sourceentity.getY() - 1.0 < entity.getY()
               && sourceentity.getZ() + 2.1 > entity.getZ()
               && sourceentity.getZ() - 2.1 < entity.getZ()) {
               if (!world.isClientSide()) {
                  sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 7, true, false));
               }

               if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 3, true, false));
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 5, 3, true, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "effect give @p[distance=..3] minecraft:nausea 4 3"
                     );
               }
            }

            if (sourceentity.isInWater() && world instanceof ServerLevel _level) {
               _level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 30, 2.0, 2.0, 2.0, 0.3);
            }

            if (entity.isInWater() && Mth.nextInt(RandomSource.create(), 1, 200) == 5 && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.TELEPORT_GHOST.get())
                  .spawn(_level, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .ShowOverlay
               .equals("true")) {
               if (!world.isClientSide()) {
                  sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
               }

               sourceentity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)),
                     0.7,
                     Math.sin((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0))
                  )
               );
               ArphexMod.queueServerWork(
                  15,
                  () -> {
                     if (!world.isClientSide()) {
                        sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
                     }

                     sourceentity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)),
                           0.1,
                           Math.sin((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0))
                        )
                     );
                  }
               );
            }

            if (sourceentity.getPersistentData().getBoolean("growattack")) {
               if (!world.isClientSide()) {
                  sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
               }

               if (entity instanceof SpiderMothEntity animatable) {
                  animatable.setTexture("redglow");
               }
            }
         }

         if (sourceentity instanceof SpiderLarvaeEntity) {
            if (sourceentity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.LEVITATION);
            }

            if (sourceentity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.SLOW_FALLING);
            }
         }

         if ((
               sourceentity instanceof LongLegsEntity
                  || sourceentity instanceof LongLegsTinyEntity
                  || sourceentity instanceof SpiderLarvaeEntity
                  || sourceentity instanceof SpiderLarvaeTinyEntity
                  || sourceentity instanceof BeetleTickMiteEntity
            )
            && entity.getY() < sourceentity.getY() - 0.9) {
            if (!world.isClientSide()) {
               sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
            }

            sourceentity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                  -0.4,
                  Math.sin((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
         }

         if (entity instanceof SpiderBroodEntity
            && (
               sourceentity instanceof SpiderLarvaeEntity
                  || sourceentity instanceof SpiderLarvaeTinyEntity
                  || sourceentity instanceof CaveSpider
                  || sourceentity instanceof Spider
            )
            && sourceentity instanceof Mob) {
            try {
               ((Mob)sourceentity).setTarget(null);
            } catch (Exception var31) {
               var31.printStackTrace();
            }
         }

         if (sourceentity instanceof SpiderBroodEntity) {
            if (sourceentity instanceof Mob _entity) {
               _entity.getNavigation().moveTo(entity.getX(), entity.getY(), entity.getZ(), 1.0);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorx == entity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 3, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 2, false, false));
                     }
                  }
               }
            }

            if (!entity.isAlive() && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var30) {
                  var30.printStackTrace();
               }
            }
         }

         if (sourceentity instanceof SpiderSnatcherEntity && !entity.isAlive() && sourceentity instanceof Mob) {
            try {
               ((Mob)sourceentity).setTarget(null);
            } catch (Exception var29) {
               var29.printStackTrace();
            }
         }

         if (sourceentity instanceof SpiderBroodEntity
            && !world.getEntitiesOfClass(SpiderBroodEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 7.0, 7.0, 7.0), e -> true)
               .isEmpty()
            && world.getEntitiesOfClass(SpiderBroodEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 7.0, 7.0, 7.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                  .findFirst()
                  .orElse(null)
               == sourceentity) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 10, false, false));
            }

            if (!world.isClientSide()) {
               sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
            }

            sourceentity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(sourceentity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0,
                  -1.0,
                  Math.sin((double)(sourceentity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
         }

         if (sourceentity instanceof SpiderSnatcherEntity
            && entity instanceof LivingEntity _livEnt181
            && _livEnt181.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())
            && !world.getEntitiesOfClass(
                  SpiderSnatcherEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 7.0, 7.0, 7.0), e -> true
               )
               .isEmpty()
            && world.getEntitiesOfClass(
                     SpiderSnatcherEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 7.0, 7.0, 7.0), e -> true
                  )
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(entity.getX(), entity.getY(), entity.getZ()))
                  .findFirst()
                  .orElse(null)
               == sourceentity) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 10, false, false));
            }

            if (!world.isClientSide()) {
               sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
            }

            sourceentity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(sourceentity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0,
                  -1.0,
                  Math.sin((double)(sourceentity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
         }

         if (sourceentity instanceof SpiderSnatcherEntity
            && entity instanceof LivingEntity _livEnt201
            && _livEnt201.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get())
            && sourceentity.getPersistentData().getDouble("webtime") == 5.0) {
            sourceentity.setSprinting(true);
            Level projectileLevel = sourceentity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = (new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new WebbedArrowEntity((EntityType<? extends WebbedArrowEntity>)ArphexModEntities.WEBBED_ARROW.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     return entityToSpawn;
                  }
               }).getArrow(projectileLevel, sourceentity, (float)(Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get()) + 4L), 1);
               _entityToSpawn.setPos(sourceentity.getX(), sourceentity.getEyeY() - 0.1, sourceentity.getZ());
               _entityToSpawn.shoot(sourceentity.getLookAngle().x, sourceentity.getLookAngle().y, sourceentity.getLookAngle().z, 4.0F, 0.05F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            ArphexMod.queueServerWork(20, () -> sourceentity.setSprinting(false));
         }

         if (sourceentity instanceof SpiderSnatcherEntity
            && (!(entity instanceof LivingEntity _livEnt210) || !_livEnt210.hasEffect((MobEffect)ArphexModMobEffects.WEBBED.get()))) {
            ArphexMod.queueServerWork(10, () -> sourceentity.setSprinting(false));
         }

         if (sourceentity instanceof CentipedeEvictorEntity) {
            if (sourceentity.getX() + 15.0 > entity.getX()
               && sourceentity.getX() - 15.0 < entity.getX()
               && sourceentity.getY() + 15.0 > entity.getY()
               && sourceentity.getY() - 15.0 < entity.getY()
               && sourceentity.getZ() + 15.0 > entity.getZ()
               && sourceentity.getZ() - 15.0 < entity.getZ()) {
               sourceentity.setSprinting(true);
               sourceentity.getPersistentData().putBoolean("targetnear", true);
            } else {
               sourceentity.setSprinting(false);
               sourceentity.getPersistentData().putBoolean("targetnear", false);
            }

            if (!entity.isAlive() && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var28) {
                  var28.printStackTrace();
               }
            }
         }

         if (sourceentity instanceof TinyCentipedeBreacherEntity) {
            if (world instanceof ServerLevel _levelx) {
               _levelx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null)
                        .withSuppressedOutput(),
                     "execute at @e[type=arphex:tiny_centipede_breacher,limit=1,sort=nearest] run tp @e[type=arphex:tiny_centipede_breacher,limit=1,sort=nearest] ^ ^ ^0.01"
                  );
            }

            if (sourceentity.getY() > entity.getY()) {
               sourceentity.setDeltaMovement(new Vec3(sourceentity.getDeltaMovement().x(), -0.2, sourceentity.getDeltaMovement().z()));
            } else {
               sourceentity.setDeltaMovement(new Vec3(sourceentity.getDeltaMovement().x(), 0.2, sourceentity.getDeltaMovement().z()));
            }

            if (!entity.isAlive() && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var27) {
                  var27.printStackTrace();
               }
            }
         }

         if (sourceentity instanceof SpiderMothEntity
            && sourceentity.getX() + 8.0 > entity.getX()
            && sourceentity.getX() - 8.0 < entity.getX()
            && sourceentity.getY() + 8.0 > entity.getY()
            && sourceentity.getY() - 8.0 < entity.getY()
            && sourceentity.getZ() + 8.0 > entity.getZ()
            && sourceentity.getZ() - 8.0 < entity.getZ()) {
            sourceentity.setShiftKeyDown(false);
            if (sourceentity instanceof SpiderMothEntity) {
               ((SpiderMothEntity)sourceentity).setAnimation("empty");
            }
         }

         if (sourceentity.isAlive()
            && (
               (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ABYSSAL_DAGGER.get()
                  || (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ABYSSAL_DAGGER.get()
                  || (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ABYSSAL_BLADE.get()
                  || (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ABYSSAL_BLADE.get()
                  || (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ABYSSAL_PICKAXE.get()
                  || (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.ABYSSAL_PICKAXE.get()
                  || (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
                  || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
            )
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ABYSSAL_DETECTOR.get(), 20, 0, false, false));
         }

         if (sourceentity instanceof SpiderFlatEntity
            && sourceentity instanceof TamableAnimal _tamEntx
            && _tamEntx.isTame()
            && entity instanceof TamableAnimal _tamEnt
            && _tamEnt.isTame()) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 50, false, false));
            }

            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 50, false, false));
            }

            if (!entity.isVehicle() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 50, false, false));
            }
         }

         if (sourceentity instanceof SpiderMothLarvaeEntity) {
            if (entity instanceof SpiderMothEntity && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var26) {
                  var26.printStackTrace();
               }
            }

            if (!world.getEntitiesOfClass(BloodProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).isEmpty()
               && sourceentity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 10, 1, false, false));
            }

            if (sourceentity instanceof LivingEntity _livEnt289 && _livEnt289.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
               sourceentity.setShiftKeyDown(true);
            }

            if (sourceentity.getPersistentData().getDouble("rushtime") > 250.0) {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.3, 0.3, 0.3, 0.3);
               }

               sourceentity.setShiftKeyDown(true);
               if (!(sourceentity.getX() + 1.5 > entity.getX())
                  || !(sourceentity.getX() - 1.5 < entity.getX())
                  || !(sourceentity.getY() + 1.5 > entity.getY())
                  || !(sourceentity.getY() - 1.5 < entity.getY())
                  || !(sourceentity.getZ() + 1.5 > entity.getZ())
                  || !(sourceentity.getZ() - 1.5 < entity.getZ())) {
                  sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
                  sourceentity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -0.2,
                        Math.sin((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  );
               } else if (sourceentity.getPersistentData().getDouble("damglim_larvae") > 0.0) {
                  if ((!(entity instanceof LivingEntity _livEnt307) || !_livEnt307.isBlocking())
                     && (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        != ArphexModItems.ABYSSAL_BLADE.get()
                     && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                        != ArphexModItems.ABYSSAL_BLADE.get()
                     && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        != ArphexModItems.ABYSS_ASCENDANT.get()
                     && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.ABYSS_ASCENDANT.get()
                     )
                   {
                     entity.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), sourceentity),
                        1.0F
                     );
                  }

                  sourceentity.getPersistentData().putDouble("damglim_larvae", 10.0);
               } else {
                  entity.getPersistentData().putDouble("damglim_larvae", sourceentity.getPersistentData().getDouble("damglim_larvae") - 1.0);
               }
            } else {
               if (!(sourceentity instanceof LivingEntity _livEnt328) || !_livEnt328.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  sourceentity.setShiftKeyDown(false);
               }

               if (sourceentity.getPersistentData().getDouble("rushtime") == 250.0) {
                  sourceentity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(sourceentity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 4.0,
                        0.4,
                        Math.sin((double)(sourceentity.getYRot() - 90.0F) * (Math.PI / 180.0)) / 4.0
                     )
                  );
               }
            }
         }

         if ((sourceentity instanceof TamedTarantulaEntity || sourceentity instanceof SpiderFlatEntity)
            && sourceentity instanceof TamableAnimal _tamEntx
            && _tamEntx.isTame()
            && entity instanceof TamableAnimal _tamIsTamedBy
            && (sourceentity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt
            && _tamIsTamedBy.isOwnedBy(_livEnt)) {
            if (sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var25) {
                  var25.printStackTrace();
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 99, false, false));
            }
         }

         if (sourceentity instanceof TORMENTOREntity) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorxx instanceof LivingEntity) {
                  LivingEntity _livEnt342 = (LivingEntity)entityiteratorxx;
                  if (_livEnt342.getMobType() == MobType.ARTHROPOD
                     && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
                     && entityiteratorxx instanceof Mob) {
                     Mob _entity = (Mob)entityiteratorxx;
                     if ((sourceentity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                     }
                  }
               }
            }
         }

         if (sourceentity instanceof HornetHarbingerGiantEntity) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorxxx instanceof HornetHarbingerEntity && entityiteratorxxx instanceof Mob) {
                  Mob _entity = (Mob)entityiteratorxxx;
                  if ((sourceentity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity _ent) {
                     _entity.setTarget(_ent);
                  }
               }
            }
         }

         if (sourceentity instanceof ScorpioidBloodlusterEntity) {
            sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
            if (sourceentity instanceof LivingEntity _livEnt358 && _livEnt358.hasEffect((MobEffect)ArphexModMobEffects.THUNDER_SENSE.get())) {
               if (sourceentity.getPersistentData().getDouble("forcefieldattack") == 5.0) {
                  Level projectileLevel = sourceentity.level();
                  if (!projectileLevel.isClientSide()) {
                     Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                              AbstractArrow entityToSpawn = new BloodthirstyTendrilEntity(
                                 (EntityType<? extends BloodthirstyTendrilEntity>)ArphexModEntities.BLOODTHIRSTY_TENDRIL.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              entityToSpawn.setPierceLevel(piercing);
                              entityToSpawn.setSecondsOnFire(100);
                              return entityToSpawn;
                           }
                        })
                        .getArrow(
                           projectileLevel,
                           sourceentity,
                           (float)(Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get()) + 5L),
                           2,
                           (byte)3
                        );
                     _entityToSpawn.setPos(sourceentity.getX(), sourceentity.getEyeY() - 0.1, sourceentity.getZ());
                     _entityToSpawn.shoot(sourceentity.getLookAngle().x, sourceentity.getLookAngle().y, sourceentity.getLookAngle().z, 3.0F, 3.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }

                  projectileLevel = sourceentity.level();
                  if (!projectileLevel.isClientSide()) {
                     Projectile _entityToSpawn = (new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                              AbstractArrow entityToSpawn = new BloodthirstyTendrilEntity(
                                 (EntityType<? extends BloodthirstyTendrilEntity>)ArphexModEntities.BLOODTHIRSTY_TENDRIL.get(), level
                              );
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              entityToSpawn.setPierceLevel(piercing);
                              entityToSpawn.setSecondsOnFire(100);
                              return entityToSpawn;
                           }
                        })
                        .getArrow(
                           projectileLevel,
                           sourceentity,
                           (float)(Math.round((Double)ConfigurationSettingsConfiguration.OVERALL_DIFFICULTY.get()) + 5L),
                           2,
                           (byte)3
                        );
                     _entityToSpawn.setPos(sourceentity.getX(), sourceentity.getEyeY() - 0.1, sourceentity.getZ());
                     _entityToSpawn.shoot(sourceentity.getLookAngle().x, sourceentity.getLookAngle().y, sourceentity.getLookAngle().z, 3.0F, 3.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }

                  sourceentity.getPersistentData().putDouble("forcefieldattack", sourceentity.getPersistentData().getDouble("forcefieldattack") - 1.0);
               }

               if (!(sourceentity.getPersistentData().getDouble("forcefieldattack") > 0.0)) {
                  sourceentity.getPersistentData().putDouble("forcefieldattack", (double)Mth.nextInt(RandomSource.create(), 15, 35));
               } else {
                  sourceentity.getPersistentData().putDouble("forcefieldattack", sourceentity.getPersistentData().getDouble("forcefieldattack") - 1.0);
               }
            }
         }

         if (sourceentity instanceof SpiderProwlerEntity && world instanceof ServerLevel _levelx) {
            _levelx.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                        Vec2.ZERO,
                        _levelx,
                        4,
                        "",
                        Component.literal(""),
                        _levelx.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "effect give @e[type=arphex:spider_prowler,distance=..5] arphex:spider_silk_touch 1 40 true"
               );
         }

         if (sourceentity instanceof SpiderJumpEntity
            && (!(sourceentity instanceof SpiderJumpEntity _datEntL379) || !(Boolean)_datEntL379.getEntityData().get(SpiderJumpEntity.DATA_sit))) {
            if (!(sourceentity.getPersistentData().getDouble("jumptime") > 0.0)) {
               sourceentity.getPersistentData().putDouble("jumptime", (double)Mth.nextInt(RandomSource.create(), 15, 80));
               sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
               if (!world.isEmptyBlock(BlockPos.containing(sourceentity.getX(), sourceentity.getY() - 1.0, sourceentity.getZ()))
                  || !world.isEmptyBlock(BlockPos.containing(sourceentity.getX() - 1.0, sourceentity.getY(), sourceentity.getZ()))
                  || !world.isEmptyBlock(BlockPos.containing(sourceentity.getX() + 1.0, sourceentity.getY(), sourceentity.getZ()))
                  || !world.isEmptyBlock(BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ() - 1.0))
                  || !world.isEmptyBlock(BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ() + 1.0))) {
                  sourceentity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.5,
                        Mth.nextDouble(RandomSource.create(), 0.3, 1.5),
                        Math.sin((double)(sourceentity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.5
                     )
                  );
               }
            } else {
               sourceentity.getPersistentData().putDouble("jumptime", sourceentity.getPersistentData().getDouble("jumptime") - 1.0);
            }
         }

         if (entity instanceof SpiderGoliathEntity || entity instanceof SpiderFunnelEntity) {
            ArphexMod.queueServerWork(20, () -> {
               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 20, 0, false, false));
               }
            });
         }

         if (sourceentity instanceof SpiderGoliathEntity || sourceentity instanceof SpiderFunnelEntity) {
            ArphexMod.queueServerWork(20, () -> {
               if (Mth.nextInt(RandomSource.create(), 1, 20) == 1 && sourceentity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 600, 0, false, false));
               }
            });
         }

         if (sourceentity instanceof CrabConstrictorEntity && !world.isClientSide()) {
            sourceentity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ()));
         }

         if (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString().startsWith("arphex:")) {
            if ((Boolean)ConfigurationSettingsConfiguration.FRIENDLY_MODE.get() && entity instanceof Player && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var24) {
                  var24.printStackTrace();
               }
            }

            if (!entity.isAlive() && sourceentity instanceof Mob) {
               try {
                  ((Mob)sourceentity).setTarget(null);
               } catch (Exception var23) {
                  var23.printStackTrace();
               }
            }
         }

         if (sourceentity instanceof DiabolosDecimatorEntity
            && !(entity instanceof Player)
            && (
               !(sourceentity instanceof DiabolosDecimatorEntity _datEntL436) || !(Boolean)_datEntL436.getEntityData().get(DiabolosDecimatorEntity.DATA_primed)
            )) {
            sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
         }
      }
   }
}
