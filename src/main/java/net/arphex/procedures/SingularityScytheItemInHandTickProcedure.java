package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SingularityScytheItemInHandTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double look_x = 0.0;
         double look_y = 0.0;
         double look_z = 0.0;
         double lookx_double = 0.0;
         double looky_double = 0.0;
         double lookz_double = 0.0;
         double particle_number = 0.0;
         double yy = 0.0;
         double radius_at_height = 0.0;
         double angle = 0.0;
         double radius = 0.0;
         double step_size = 0.0;
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 0, false, false));
         }

         if (entity.getPersistentData().getDouble("sing_scythe_anim") > 0.0) {
            look_x = (double)entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(10.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                     Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getBlockPos()
               .getX();
            look_y = (double)entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(10.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                     Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getBlockPos()
               .getY();
            look_z = (double)entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(10.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                     Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getBlockPos()
               .getZ();
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(look_x, look_y, look_z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "particle arphex:heavy_gold_smoke ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(look_x, look_y, look_z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "particle sweep_attack ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                  );
            }

            if (entity.getPersistentData().getDouble("sing_scythe_anim") % 5.0 == 1.0) {
               Vec3 _center = new Vec3(look_x, look_y, look_z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator != entity) {
                     if (entityiterator instanceof TamableAnimal) {
                        TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                              continue;
                           }
                        }
                     }

                     if (entityiterator instanceof LivingEntity
                        && !itemstack.getOrCreateTag().getString("prevent_double_uuid").equals(entityiterator.getStringUUID())) {
                        if (entityiterator instanceof TORMENTOREntity) {
                           entityiterator.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                              100.0F
                           );
                        } else {
                           entityiterator.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                              40.0F
                           );
                        }

                        entityiterator.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                              entity.getDeltaMovement().y(),
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                           )
                        );
                     }
                  }
               }
            }

            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SINGULARITY_SCYTHE.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SINGULARITY_SCYTHE.get()
               && entity.getPersistentData().getDouble("sing_scythe_anim") == 1.0) {
               lookx_double = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(20.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getX();
               looky_double = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(20.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getY();
               lookz_double = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(20.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getZ();
               if (Math.sqrt(
                     (entity.getX() - lookx_double) * (entity.getX() - lookx_double)
                        + (entity.getY() - looky_double) * (entity.getY() - looky_double)
                        + (entity.getZ() - lookz_double) * (entity.getZ() - lookz_double)
                  )
                  > 1.5
                     * Math.sqrt(
                        (entity.getX() - look_x) * (entity.getX() - look_x)
                           + (entity.getY() - look_y) * (entity.getY() - look_y)
                           + (entity.getZ() - look_z) * (entity.getZ() - look_z)
                     )) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(lookx_double, looky_double, lookz_double),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:heavy_gold_smoke ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(lookx_double, looky_double, lookz_double),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle sweep_attack ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                        );
                  }

                  Vec3 _center = new Vec3(lookx_double, looky_double, lookz_double);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorx != entity) {
                        if (entityiteratorx instanceof TamableAnimal) {
                           TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorx;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEntxx = (LivingEntity)entity;
                              if (_tamIsTamedBy.isOwnedBy(_livEntxx)) {
                                 continue;
                              }
                           }
                        }

                        if (entityiteratorx instanceof LivingEntity
                           && !itemstack.getOrCreateTag().getString("prevent_double_uuid").equals(entityiteratorx.getStringUUID())) {
                           if (entityiteratorx instanceof TORMENTOREntity) {
                              entityiteratorx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                                 100.0F
                              );
                           } else {
                              entityiteratorx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                                 40.0F
                              );
                           }

                           entityiteratorx.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                                 entity.getDeltaMovement().y(),
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                              )
                           );
                        }
                     }
                  }
               }

               look_x = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(30.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getX();
               look_y = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(30.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getY();
               look_z = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(30.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getZ();
               if (Math.sqrt(
                     (entity.getX() - look_x) * (entity.getX() - look_x)
                        + (entity.getY() - look_y) * (entity.getY() - look_y)
                        + (entity.getZ() - look_z) * (entity.getZ() - look_z)
                  )
                  > 1.4
                     * Math.sqrt(
                        (entity.getX() - lookx_double) * (entity.getX() - lookx_double)
                           + (entity.getY() - looky_double) * (entity.getY() - looky_double)
                           + (entity.getZ() - lookz_double) * (entity.getZ() - lookz_double)
                     )) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(look_x, look_y, look_z),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:heavy_gold_smoke ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(look_x, look_y, look_z),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle sweep_attack ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                        );
                  }

                  Vec3 _center = new Vec3(look_x, look_y, look_z);

                  for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorxx != entity) {
                        if (entityiteratorxx instanceof TamableAnimal) {
                           TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxx;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEntxx = (LivingEntity)entity;
                              if (_tamIsTamedBy.isOwnedBy(_livEntxx)) {
                                 continue;
                              }
                           }
                        }

                        if (entityiteratorxx instanceof LivingEntity
                           && !itemstack.getOrCreateTag().getString("prevent_double_uuid").equals(entityiteratorxx.getStringUUID())) {
                           if (entity instanceof TORMENTOREntity) {
                              entityiteratorxx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                                 100.0F
                              );
                           } else {
                              entityiteratorxx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                                 40.0F
                              );
                           }

                           entityiteratorxx.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                                 entity.getDeltaMovement().y(),
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                              )
                           );
                        }
                     }
                  }
               }

               lookx_double = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(40.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getX();
               looky_double = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(40.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getY();
               lookz_double = (double)entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(40.0 - entity.getPersistentData().getDouble("sing_scythe_anim"))),
                        Block.OUTLINE,
                        Fluid.NONE,
                        entity
                     )
                  )
                  .getBlockPos()
                  .getZ();
               if (Math.sqrt(
                     (entity.getX() - lookx_double) * (entity.getX() - lookx_double)
                        + (entity.getY() - looky_double) * (entity.getY() - looky_double)
                        + (entity.getZ() - lookz_double) * (entity.getZ() - lookz_double)
                  )
                  > 1.25
                     * Math.sqrt(
                        (entity.getX() - look_x) * (entity.getX() - look_x)
                           + (entity.getY() - look_y) * (entity.getY() - look_y)
                           + (entity.getZ() - look_z) * (entity.getZ() - look_z)
                     )) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(lookx_double, looky_double, lookz_double),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:heavy_gold_smoke ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL,
                                 new Vec3(looky_double, looky_double, lookz_double),
                                 Vec2.ZERO,
                                 _level,
                                 4,
                                 "",
                                 Component.literal(""),
                                 _level.getServer(),
                                 null
                              )
                              .withSuppressedOutput(),
                           "particle sweep_attack ~ ~ ~ 0.1 0.1 0.1 0 5 force"
                        );
                  }

                  Vec3 _center = new Vec3(lookx_double, looky_double, lookz_double);

                  for (Entity entityiteratorxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiteratorxxx != entity) {
                        if (entityiteratorxxx instanceof TamableAnimal) {
                           TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxxx;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEntxx = (LivingEntity)entity;
                              if (_tamIsTamedBy.isOwnedBy(_livEntxx)) {
                                 continue;
                              }
                           }
                        }

                        if (entityiteratorxxx instanceof LivingEntity
                           && !itemstack.getOrCreateTag().getString("prevent_double_uuid").equals(entityiteratorxxx.getStringUUID())) {
                           if (entity instanceof TORMENTOREntity) {
                              entityiteratorxxx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                                 100.0F
                              );
                           } else {
                              entityiteratorxxx.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                                 40.0F
                              );
                           }

                           entityiteratorxxx.setDeltaMovement(
                              new Vec3(
                                 Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                                 entity.getDeltaMovement().y(),
                                 Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                              )
                           );
                        }
                     }
                  }
               }
            }
         }

         if (itemstack.getOrCreateTag().getDouble("shield_scythe") > 0.0) {
            itemstack.getOrCreateTag().putDouble("shield_scythe", itemstack.getOrCreateTag().getDouble("shield_scythe") - 1.0);
            if (itemstack.getOrCreateTag().getDouble("shield_scythe") % 4.0 == 1.0) {
               itemstack.getOrCreateTag()
                  .putDouble(
                     "ss_x_store",
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX()
                  );
               itemstack.getOrCreateTag()
                  .putDouble(
                     "ss_y_store",
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY()
                  );
               itemstack.getOrCreateTag()
                  .putDouble(
                     "ss_z_store",
                     (double)entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)),
                              Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  );
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                     .spawn(
                        _level,
                        BlockPos.containing(
                           itemstack.getOrCreateTag().getDouble("ss_x_store"),
                           itemstack.getOrCreateTag().getDouble("ss_y_store"),
                           itemstack.getOrCreateTag().getDouble("ss_z_store")
                        ),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                  }
               }

               Vec3 _center = new Vec3(
                  itemstack.getOrCreateTag().getDouble("ss_x_store"),
                  itemstack.getOrCreateTag().getDouble("ss_y_store"),
                  itemstack.getOrCreateTag().getDouble("ss_z_store")
               );

               for (Entity entityiteratorxxxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if ((entityiteratorxxxx instanceof Projectile _projEnt ? _projEnt.getDeltaMovement().length() : 0.0) > 0.0) {
                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles(
                           (SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(),
                           entityiteratorxxxx.getX(),
                           entityiteratorxxxx.getY(),
                           entityiteratorxxxx.getZ(),
                           2,
                           3.0,
                           3.0,
                           3.0,
                           1.0
                        );
                     }

                     if (!entityiteratorxxxx.level().isClientSide()) {
                        entityiteratorxxxx.discard();
                     }
                  } else if (entityiteratorxxxx instanceof LivingEntity
                     && !(entityiteratorxxxx instanceof ArmorStand)
                     && !(entityiteratorxxxx instanceof SphereAnimEntity)
                     && (
                        !(entityiteratorxxxx instanceof TamableAnimal _tamIsTamedBy)
                           || !(entity instanceof LivingEntity _livEnt)
                           || !_tamIsTamedBy.isOwnedBy(_livEnt)
                     )
                     && entityiteratorxxxx != entity) {
                     entityiteratorxxxx.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
                        Math.max(15.0F, (entityiteratorxxxx instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 100.0F)
                     );
                     entityiteratorxxxx.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  }
               }

               if (world instanceof ServerLevel _levelx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                     .spawn(
                        _levelx,
                        BlockPos.containing(
                           itemstack.getOrCreateTag().getDouble("ss_x_store"),
                           itemstack.getOrCreateTag().getDouble("ss_y_store") + 1.0,
                           itemstack.getOrCreateTag().getDouble("ss_z_store")
                        ),
                        MobSpawnType.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                  }
               }

               ArphexMod.queueServerWork(
                  2,
                  () -> {
                     if (!world.getEntitiesOfClass(
                           SphereAnimEntity.class,
                           AABB.ofSize(
                              new Vec3(
                                 itemstack.getOrCreateTag().getDouble("ss_x_store"),
                                 itemstack.getOrCreateTag().getDouble("ss_y_store") + 1.0,
                                 itemstack.getOrCreateTag().getDouble("ss_z_store")
                              ),
                              7.0,
                              7.0,
                              7.0
                           ),
                           e -> true
                        )
                        .isEmpty()) {
                        Entity patt20236$temp = world.getEntitiesOfClass(
                              SphereAnimEntity.class,
                              AABB.ofSize(
                                 new Vec3(
                                    itemstack.getOrCreateTag().getDouble("ss_x_store"),
                                    itemstack.getOrCreateTag().getDouble("ss_y_store") + 1.0,
                                    itemstack.getOrCreateTag().getDouble("ss_z_store")
                                 ),
                                 7.0,
                                 7.0,
                                 7.0
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
                                    itemstack.getOrCreateTag().getDouble("ss_x_store"),
                                    itemstack.getOrCreateTag().getDouble("ss_y_store") + 1.0,
                                    itemstack.getOrCreateTag().getDouble("ss_z_store")
                                 )
                           )
                           .findFirst()
                           .orElse(null);
                        if (patt20236$temp instanceof SphereAnimEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_max_size, 200);
                        }

                        patt20236$temp = world.getEntitiesOfClass(
                              SphereAnimEntity.class,
                              AABB.ofSize(
                                 new Vec3(
                                    itemstack.getOrCreateTag().getDouble("ss_x_store"),
                                    itemstack.getOrCreateTag().getDouble("ss_y_store") + 1.0,
                                    itemstack.getOrCreateTag().getDouble("ss_z_store")
                                 ),
                                 7.0,
                                 7.0,
                                 7.0
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
                                    itemstack.getOrCreateTag().getDouble("ss_x_store"),
                                    itemstack.getOrCreateTag().getDouble("ss_y_store") + 1.0,
                                    itemstack.getOrCreateTag().getDouble("ss_z_store")
                                 )
                           )
                           .findFirst()
                           .orElse(null);
                        if (patt20236$temp instanceof SphereAnimEntity _datEntSetS) {
                           _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "black");
                        }
                     }
                  }
               );
               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SINGULARITY_SCYTHE.get()
                  && entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SINGULARITY_SCYTHE.get()
                  && entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.OFF_HAND, true);
               }
            }
         }
      }
   }
}
