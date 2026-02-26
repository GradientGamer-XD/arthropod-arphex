package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChaosGauntletHeldProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         boolean limt1 = false;
         if (entity.getPersistentData().getBoolean("creativespectator")) {
            entity.getPersistentData().putDouble("forcecharges", 0.0);
         }

         label224: {
            entity.getPersistentData().putDouble("scandist", 6.0);
            entity.getPersistentData().putDouble("pullspeed", 0.2);
            label206:
            if (entity.getPersistentData().getBoolean("usinggauntlet")) {
               if (entity instanceof Player _plrCldCheck6 && _plrCldCheck6.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  break label206;
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.FORCE_POWER.get(), 5, 0, false, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(), x, y + 2.5, z, 3, 0.1, 0.1, 0.1, 0.05);
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y + 2.5, z, 3, 0.1, 0.1, 0.1, 0.05);
               }
               break label224;
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect((MobEffect)ArphexModMobEffects.FORCE_POWER.get());
            }
         }

         if (entity.getPersistentData().getDouble("forcecharges") > 300.0 && !entity.getPersistentData().getBoolean("creativespectator")) {
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 300);
            }

            entity.getPersistentData().putDouble("forcecharges", 0.0);
         } else if (!(entity.getPersistentData().getDouble("forcecharges") > 0.0)) {
            entity.getPersistentData().putDouble("forcecharges", 0.0);
         }

         limt1 = false;

         for (int index0 = 0; index0 < 9; index0++) {
            if (!world.getEntitiesOfClass(
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
                        4.0,
                        4.0,
                        4.0
                     ),
                     e -> true
                  )
                  .isEmpty()
               && entity
                  != world.getEntitiesOfClass(
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
                           4.0,
                           4.0,
                           4.0
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
                     .orElse(null)) {
               Entity _ap = world.getEntitiesOfClass(
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
                        4.0,
                        4.0,
                        4.0
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
               if (_ap instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2, 1, false, false));
               }

               label225: {
                  limt1 = true;
                  label184:
                  if (entity.getPersistentData().getBoolean("usinggauntlet")) {
                     if (entity instanceof Player _plrCldCheck43 && _plrCldCheck43.getCooldowns().isOnCooldown(itemstack.getItem())) {
                        break label184;
                     }

                     label219: {
                        Entity _level = world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
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
                                       .getX(),
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
                                       .getY(),
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
                                 ),
                                 4.0,
                                 4.0,
                                 4.0
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                        if (_level instanceof LivingEntity _livEnt51 && _livEnt51.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                           break label219;
                        }

                        label174: {
                           _level = world.getEntitiesOfClass(
                                 LivingEntity.class,
                                 AABB.ofSize(
                                    new Vec3(
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
                                          .getX(),
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
                                          .getY(),
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
                                    ),
                                    4.0,
                                    4.0,
                                    4.0
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                           if ((_level instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) < 300.0F) {
                              double var66 = 300.0 - entity.getPersistentData().getDouble("forcecharges");
                              _level = world.getEntitiesOfClass(
                                    LivingEntity.class,
                                    AABB.ofSize(
                                       new Vec3(
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
                                             .getX(),
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
                                             .getY(),
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
                                       ),
                                       4.0,
                                       4.0,
                                       4.0
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
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                              if (var66 > (double)(_level instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)) {
                                 break label174;
                              }
                           }

                           if (!entity.getPersistentData().getBoolean("creativespectator")) {
                              break label219;
                           }
                        }

                        Entity _livEntx = world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
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
                                       .getX(),
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
                                       .getY(),
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
                                 ),
                                 4.0,
                                 4.0,
                                 4.0
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                        if (_livEntx instanceof LivingEntity _livEnt77 && _livEnt77.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())) {
                           Entity var64 = world.getEntitiesOfClass(
                                 LivingEntity.class,
                                 AABB.ofSize(
                                    new Vec3(
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
                                          .getX(),
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
                                          .getY(),
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
                                    ),
                                    4.0,
                                    4.0,
                                    4.0
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                           if (var64 instanceof LivingEntity _entity) {
                              _entity.removeEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get());
                           }

                           if (entity instanceof Player _player) {
                              _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
                           }
                           break label225;
                        }

                        if (entity.getPersistentData().getBoolean("creativespectator")) {
                           world.getEntitiesOfClass(
                                 LivingEntity.class,
                                 AABB.ofSize(
                                    new Vec3(
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
                                          .getX(),
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
                                          .getY(),
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
                                    ),
                                    4.0,
                                    4.0,
                                    4.0
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                              .orElse(null)
                              .getPersistentData()
                              .putBoolean("creativecontrol", true);
                           Entity _livEntxx = world.getEntitiesOfClass(
                                 LivingEntity.class,
                                 AABB.ofSize(
                                    new Vec3(
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
                                          .getX(),
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
                                          .getY(),
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
                                    ),
                                    4.0,
                                    4.0,
                                    4.0
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                           if (_livEntxx instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get(), 120000, 1, false, false));
                           }
                        } else {
                           world.getEntitiesOfClass(
                                 LivingEntity.class,
                                 AABB.ofSize(
                                    new Vec3(
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
                                          .getX(),
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
                                          .getY(),
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
                                    ),
                                    4.0,
                                    4.0,
                                    4.0
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                              .orElse(null)
                              .getPersistentData()
                              .putBoolean("creativecontrol", false);
                           Entity var26 = world.getEntitiesOfClass(
                                 LivingEntity.class,
                                 AABB.ofSize(
                                    new Vec3(
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
                                          .getX(),
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
                                          .getY(),
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
                                    ),
                                    4.0,
                                    4.0,
                                    4.0
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                           if (var26 instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              MobEffect var10003 = (MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get();
                              var26 = world.getEntitiesOfClass(
                                    LivingEntity.class,
                                    AABB.ofSize(
                                       new Vec3(
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
                                             .getX(),
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
                                             .getY(),
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
                                       ),
                                       4.0,
                                       4.0,
                                       4.0
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
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                   entity.getEyePosition(1.0F)
                                                      .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                              _entity.addEffect(
                                 new MobEffectInstance(
                                    var10003, (int)(300.0F - (var26 instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F)), 1, false, false
                                 )
                              );
                           }
                        }

                        if (entity instanceof Player _player) {
                           _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
                        }

                        if (!entity.getPersistentData().getBoolean("creativespectator")) {
                           CompoundTag var67 = entity.getPersistentData();
                           double var10002 = entity.getPersistentData().getDouble("forcecharges");
                           Entity var63 = world.getEntitiesOfClass(
                                 LivingEntity.class,
                                 AABB.ofSize(
                                    new Vec3(
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
                                          .getX(),
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
                                          .getY(),
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
                                    ),
                                    4.0,
                                    4.0,
                                    4.0
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                                entity.getEyePosition(1.0F)
                                                   .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                           var67.putDouble("forcecharges", var10002 + (double)(var63 instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F));
                        }
                        break label225;
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y + 2.5, z, 15, 0.1, 0.1, 0.1, 0.05);
                     }
                     break label225;
                  }

                  label164:
                  if (entity.getPersistentData().getBoolean("firegauntlet")) {
                     Entity var41 = world.getEntitiesOfClass(
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
                              4.0,
                              4.0,
                              4.0
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
                     if (var41 instanceof LivingEntity _livEnt151 && _livEnt151.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get())) {
                        Entity var48 = world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
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
                                       .getX(),
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
                                       .getY(),
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
                                 ),
                                 4.0,
                                 4.0,
                                 4.0
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                        if (var48 instanceof LivingEntity _entity) {
                           _entity.removeEffect((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get());
                        }

                        entity.getPersistentData().putBoolean("firegauntlet", false);
                        break label164;
                     }

                     Entity var45 = world.getEntitiesOfClass(
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
                              4.0,
                              4.0,
                              4.0
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
                     if (var45 instanceof LivingEntity _livEnt168 && _livEnt168.hasEffect((MobEffect)ArphexModMobEffects.CHAOS_CONTROLLED.get())) {
                        break label164;
                     }

                     if (entity.getPersistentData().getBoolean("creativespectator")) {
                        world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
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
                                       .getX(),
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
                                       .getY(),
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
                                 ),
                                 4.0,
                                 4.0,
                                 4.0
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                           .orElse(null)
                           .getPersistentData()
                           .putBoolean("creativecontrol", true);
                        Entity var54 = world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
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
                                       .getX(),
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
                                       .getY(),
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
                                 ),
                                 4.0,
                                 4.0,
                                 4.0
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                        if (var54 instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get(), 120000, 1, false, false));
                        }
                     } else {
                        world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
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
                                       .getX(),
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
                                       .getY(),
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
                                 ),
                                 4.0,
                                 4.0,
                                 4.0
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                           .orElse(null)
                           .getPersistentData()
                           .putBoolean("creativecontrol", false);
                        Entity var55 = world.getEntitiesOfClass(
                              LivingEntity.class,
                              AABB.ofSize(
                                 new Vec3(
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
                                       .getX(),
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
                                       .getY(),
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
                                 ),
                                 4.0,
                                 4.0,
                                 4.0
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                                             entity.getEyePosition(1.0F)
                                                .add(entity.getViewVector(1.0F).scale(entity.getPersistentData().getDouble("scandist"))),
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
                        if (var55 instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CHAOS_TARGET.get(), 300, 1, false, false));
                        }
                     }

                     entity.getPersistentData().putBoolean("firegauntlet", false);
                  }
               }

               if (limt1) {
                  break;
               }
            }

            entity.getPersistentData().putDouble("scandist", entity.getPersistentData().getDouble("scandist") + 2.0);
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:chaos_gauntlet_craft"));
            AdvancementProgress _apx = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_apx.isDone()) {
               for (String criteria : _apx.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }
      }
   }
}
