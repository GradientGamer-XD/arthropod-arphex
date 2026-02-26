package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ForceGauntletToolInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         Entity nearest_raytrace_entity = null;
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 1, false, false));
         }

         entity.getPersistentData().putDouble("headtilt", (double)((0.0F - entity.getXRot()) / 12.0F));
         entity.getPersistentData().putDouble("scandist", 6.0);
         entity.getPersistentData().putDouble("pullspeed", 0.2);
         if (entity.getPersistentData().getDouble("forcecharges") > 300.0) {
            if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 40);
            }

            entity.getPersistentData().putDouble("forcecharges", 0.0);
         }

         label278: {
            label257:
            if (entity.getPersistentData().getBoolean("usinggauntlet")) {
               if (entity instanceof Player _plrCldCheck12 && _plrCldCheck12.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  break label257;
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.FORCE_POWER.get(), 5, 0, false, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(), x, y + 2.5, z, 3, 0.1, 0.1, 0.1, 0.05);
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y + 2.5, z, 3, 0.1, 0.1, 0.1, 0.05);
               }
               break label278;
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get());
            }
         }

         if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
            Vec3 _center = new Vec3(
               (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity
                     )
                  )
                  .getBlockPos()
                  .getX(),
               (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity
                     )
                  )
                  .getBlockPos()
                  .getY(),
               (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity
                     )
                  )
                  .getBlockPos()
                  .getZ()
            );

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:impact_projectiles")))
                  || entityiterator instanceof BloodProjectileEntity
                  || entityiterator instanceof WebbedArrowEntity) {
                  entityiterator.setDeltaMovement(
                     new Vec3(
                        Mth.nextDouble(RandomSource.create(), -0.05, 0.05),
                        Mth.nextDouble(RandomSource.create(), -0.05, 0.05),
                        Mth.nextDouble(RandomSource.create(), -0.05, 0.05)
                     )
                  );
               }
            }
         }

         for (int index0 = 0; index0 < 7; index0++) {
            nearest_raytrace_entity = world.getEntitiesOfClass(
                  LivingEntity.class,
                  AABB.ofSize(
                     new Vec3(
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY(),
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     6.0,
                     6.0,
                     6.0
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
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY(),
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     )
               )
               .findFirst()
               .orElse(null);
            if (nearest_raytrace_entity == null) {
               nearest_raytrace_entity = world.getEntitiesOfClass(
                     ItemEntity.class,
                     AABB.ofSize(
                        new Vec3(
                           (double)entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                    Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           (double)entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                    Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY(),
                           (double)entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                    Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        6.0,
                        6.0,
                        6.0
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
                           (double)entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                    Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           (double)entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                    Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY(),
                           (double)entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                    Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        )
                  )
                  .findFirst()
                  .orElse(null);
            }

            if (nearest_raytrace_entity != null && entity != nearest_raytrace_entity) {
               if ((!(entity instanceof Player _plrCldCheck47) || !_plrCldCheck47.getCooldowns().isOnCooldown(itemstack.getItem()))
                  && nearest_raytrace_entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.FORCE_LIFT.get(), 3, 1, false, false));
               }

               if (!(nearest_raytrace_entity instanceof LivingEntity)) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles(
                        (SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(),
                        nearest_raytrace_entity.getX(),
                        nearest_raytrace_entity.getY(),
                        nearest_raytrace_entity.getZ(),
                        2,
                        0.1,
                        0.1,
                        0.1,
                        0.1
                     );
                  }
               } else {
                  label200:
                  if (entity.getPersistentData().getBoolean("firegauntlet")) {
                     if (entity instanceof Player _plrCldCheck52 && _plrCldCheck52.getCooldowns().isOnCooldown(itemstack.getItem())) {
                        break label200;
                     }

                     Vec3 _center = new Vec3(
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY(),
                        (double)entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     );

                     for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiteratorx.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:impact_projectiles")))
                           || entityiteratorx instanceof BloodProjectileEntity
                           || entityiteratorx instanceof WebbedArrowEntity
                           || entityiteratorx instanceof LivingEntity
                           || entityiteratorx instanceof DragonFireball
                           || entityiteratorx instanceof SmallFireball
                           || entityiteratorx instanceof LargeFireball) {
                           if (entityiteratorx instanceof LivingEntity) {
                              entity.getPersistentData().putBoolean("firegauntlet", false);
                              if ((entityiteratorx instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 0) {
                                 if (entity != null && entityiteratorx != null) {
                                    entityiteratorx.hurt(
                                       new DamageSource(
                                          world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FLY_INTO_WALL), entity
                                       ),
                                       (float)Math.round((float)(20 / (entityiteratorx instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0)))
                                    );
                                 }
                              } else if (entity != null && entityiteratorx != null) {
                                 entityiteratorx.hurt(
                                    new DamageSource(
                                       world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FLY_INTO_WALL), entity
                                    ),
                                    20.0F
                                 );
                              }

                              entityiteratorx.setDeltaMovement(
                                 new Vec3(
                                    Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                                       * (
                                          (double)(
                                                300.0F
                                                   / (200.0F + (nearest_raytrace_entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F))
                                             )
                                             / 1.5
                                       )
                                       * 4.0,
                                    0.7,
                                    Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                                       * (
                                          (double)(
                                                300.0F
                                                   / (200.0F + (nearest_raytrace_entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F))
                                             )
                                             / 1.5
                                       )
                                       * 4.0
                                 )
                              );
                              break;
                           }

                           entityiteratorx.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 0.6666666666666666 * 4.0,
                                 0.2,
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 0.6666666666666666 * 4.0
                              )
                           );
                        }
                     }

                     if ((nearest_raytrace_entity instanceof LivingEntity _livEntx ? _livEntx.getArmorValue() : 0) > 0) {
                        nearest_raytrace_entity.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FLY_INTO_WALL), entity),
                           (float)Math.round((float)(20 / (nearest_raytrace_entity instanceof LivingEntity _livEntxx ? _livEntxx.getArmorValue() : 0)))
                        );
                     } else {
                        nearest_raytrace_entity.hurt(
                           new DamageSource(
                              world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FLY_INTO_WALL),
                              nearest_raytrace_entity
                           ),
                           20.0F
                        );
                     }

                     nearest_raytrace_entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                              * (
                                 (double)(300.0F / (200.0F + (nearest_raytrace_entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              )
                              * 4.0,
                           0.8,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0))
                              * (
                                 (double)(300.0F / (200.0F + (nearest_raytrace_entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              )
                              * 4.0
                        )
                     );
                     lineX = entity.getX() - nearest_raytrace_entity.getX();
                     lineY = entity.getY() - nearest_raytrace_entity.getY();
                     lineZ = entity.getZ() - nearest_raytrace_entity.getZ();
                     expand = expand;

                     for (int index1 = 0; index1 < 20; index1++) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(entity.getX() + lineX * expand, entity.getY() + lineY * expand, entity.getZ() + lineZ * expand),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:heavy_purple_smoke ~ ~ ~ 0 0 0 0 1 force"
                              );
                        }

                        expand -= 0.05;
                     }

                     if (entity instanceof Player _player) {
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 40);
                     }
                  }
               }

               if (entity instanceof LivingEntity _livEnt111 && _livEnt111.hasEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get())) {
                  nearest_raytrace_entity.fallDistance = 0.0F;
                  if (entity.isShiftKeyDown()) {
                     if (!(
                           (
                                    Math.abs(
                                          (double)entity.level()
                                                .clip(
                                                   new ClipContext(
                                                      entity.getEyePosition(1.0F),
                                                      entity.getEyePosition(1.0F)
                                                         .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                                      Block.OUTLINE,
                                                      Fluid.NONE,
                                                      entity
                                                   )
                                                )
                                                .getBlockPos()
                                                .getX()
                                             - nearest_raytrace_entity.getX()
                                       )
                                       + Math.abs(
                                          (double)entity.level()
                                                .clip(
                                                   new ClipContext(
                                                      entity.getEyePosition(1.0F),
                                                      entity.getEyePosition(1.0F)
                                                         .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                                      Block.OUTLINE,
                                                      Fluid.NONE,
                                                      entity
                                                   )
                                                )
                                                .getBlockPos()
                                                .getY()
                                             - nearest_raytrace_entity.getY()
                                       )
                                       + Math.abs(
                                          (double)entity.level()
                                                .clip(
                                                   new ClipContext(
                                                      entity.getEyePosition(1.0F),
                                                      entity.getEyePosition(1.0F)
                                                         .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                                      Block.OUTLINE,
                                                      Fluid.NONE,
                                                      entity
                                                   )
                                                )
                                                .getBlockPos()
                                                .getZ()
                                             - nearest_raytrace_entity.getZ()
                                       )
                                 )
                                 / 3.0
                              > 25.0
                        )
                        && entity != nearest_raytrace_entity) {
                        nearest_raytrace_entity.setDeltaMovement(
                           new Vec3(
                              (entity.getX() - nearest_raytrace_entity.getX()) / ((entity.getPersistentData().getDouble("pullspeed") + 1.0) * 10.0),
                              (entity.getY() + entity.getPersistentData().getDouble("headtilt") - nearest_raytrace_entity.getY())
                                 / ((entity.getPersistentData().getDouble("pullspeed") + 1.0) * 10.0),
                              (entity.getZ() - nearest_raytrace_entity.getZ()) / ((entity.getPersistentData().getDouble("pullspeed") + 1.0) * 10.0)
                           )
                        );
                        entity.getPersistentData()
                           .putDouble(
                              "forcecharges",
                              entity.getPersistentData().getDouble("forcecharges")
                                 + (double)((20.0F + (nearest_raytrace_entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)) / 30.0F)
                           );
                     }
                  } else if (!(
                        (
                                 Math.abs(
                                       (double)entity.level()
                                             .clip(
                                                new ClipContext(
                                                   entity.getEyePosition(1.0F),
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                                   Block.OUTLINE,
                                                   Fluid.NONE,
                                                   entity
                                                )
                                             )
                                             .getBlockPos()
                                             .getX()
                                          - nearest_raytrace_entity.getX()
                                    )
                                    + Math.abs(
                                       (double)entity.level()
                                             .clip(
                                                new ClipContext(
                                                   entity.getEyePosition(1.0F),
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                                   Block.OUTLINE,
                                                   Fluid.NONE,
                                                   entity
                                                )
                                             )
                                             .getBlockPos()
                                             .getY()
                                          - nearest_raytrace_entity.getY()
                                    )
                                    + Math.abs(
                                       (double)entity.level()
                                             .clip(
                                                new ClipContext(
                                                   entity.getEyePosition(1.0F),
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
                                                   Block.OUTLINE,
                                                   Fluid.NONE,
                                                   entity
                                                )
                                             )
                                             .getBlockPos()
                                             .getZ()
                                          - nearest_raytrace_entity.getZ()
                                    )
                              )
                              / 3.0
                           > 25.0
                     )
                     && entity != nearest_raytrace_entity) {
                     nearest_raytrace_entity.setDeltaMovement(
                        new Vec3(
                           Math.min(
                              Math.max(
                                 (
                                       entity.getX()
                                          - Math.sin(Math.toRadians((double)entity.getYRot()))
                                             * entity.getPersistentData().getDouble("scandist")
                                             * Math.cos(Math.toRadians((double)entity.getXRot()))
                                          - nearest_raytrace_entity.getX()
                                    )
                                    / (entity.getPersistentData().getDouble("pullspeed") + 1.0),
                                 -3.5
                              ),
                              3.5
                           ),
                           Math.min(
                              Math.max(
                                 (
                                       entity.getY()
                                          + 1.6
                                          - Math.sin(Math.toRadians((double)entity.getXRot())) * entity.getPersistentData().getDouble("scandist")
                                          - nearest_raytrace_entity.getY()
                                    )
                                    / (entity.getPersistentData().getDouble("pullspeed") + 1.0),
                                 -3.5
                              ),
                              3.5
                           ),
                           Math.min(
                              Math.max(
                                 (
                                       entity.getZ()
                                          + Math.cos(Math.toRadians((double)entity.getYRot()))
                                             * entity.getPersistentData().getDouble("scandist")
                                             * Math.cos(Math.toRadians((double)entity.getXRot()))
                                          - nearest_raytrace_entity.getZ()
                                    )
                                    / (entity.getPersistentData().getDouble("pullspeed") + 1.0),
                                 -3.5
                              ),
                              3.5
                           )
                        )
                     );
                     entity.getPersistentData()
                        .putDouble(
                           "forcecharges",
                           entity.getPersistentData().getDouble("forcecharges")
                              + (double)((nearest_raytrace_entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 20.0F)
                        );
                  }
               }
            }

            entity.getPersistentData().putDouble("scandist", entity.getPersistentData().getDouble("scandist") + 3.0);
         }

         entity.getPersistentData().putDouble("forcecharges", entity.getPersistentData().getDouble("forcecharges") - 1.0);
         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:force_gauntlet_craft"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }
      }
   }
}
