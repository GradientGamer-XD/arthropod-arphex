package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.ArthropleuraAbominationEntity;
import net.arphex.entity.SegmentedBodyEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SegmentedHeadOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dists = 0.0;
         boolean bodyfound = false;
         if (!world.isClientSide() && entity.isAlive()) {
            entity.getPersistentData().putBoolean("bodyfoundarph", false);
            if (entity instanceof ArthropleuraAbominationEntity _datEntSetS) {
               _datEntSetS.getEntityData().set(ArthropleuraAbominationEntity.DATA_uuidmap, entity.getStringUUID());
            }

            if ((!(entity instanceof LivingEntity _livEnt5) || !_livEnt5.hasEffect(MobEffects.REGENERATION))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
                  && entityiterator.getPersistentData().getBoolean("arthropleura_target")
                  && entity instanceof Mob _entity
                  && entityiterator instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }

               if (entityiterator instanceof SegmentedBodyEntity
                  && (entityiterator instanceof SegmentedBodyEntity _datEntSx ? (String)_datEntSx.getEntityData().get(SegmentedBodyEntity.DATA_uuid_map) : "")
                     .equals(
                        entity instanceof ArthropleuraAbominationEntity _datEntS
                           ? _datEntS.getEntityData().get(ArthropleuraAbominationEntity.DATA_uuidmap)
                           : ""
                     )
                  && (
                        entityiterator instanceof SegmentedBodyEntity _datEntI
                           ? (Integer)_datEntI.getEntityData().get(SegmentedBodyEntity.DATA_segmentnum_arphex)
                           : 0
                     )
                     == 1) {
                  entity.getPersistentData().putBoolean("bodyfoundarph", true);
                  label203:
                  if (entity.getPersistentData().getDouble("segupwardstransfer") > 0.0) {
                     entityiterator.getPersistentData().putDouble("segupwardstransfer", 1.0);
                     entity.getPersistentData().putDouble("segupwardstransfer", 0.0);
                     if (entityiterator instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                        break label203;
                     }

                     entityiterator.hurt(
                        new DamageSource(
                           world.registryAccess()
                              .registryOrThrow(Registries.DAMAGE_TYPE)
                              .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))
                        ),
                        0.0F
                     );
                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 20, 0, false, false));
                     }
                  }

                  if (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().z()) == 0.0) {
                     if (entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get())) {
                        continue;
                     }

                     entity.setYRot(entityiterator.getYRot());
                     entity.setXRot(entity.getXRot());
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }
               }
            }

            if (!entity.getPersistentData().getBoolean("bodyfoundarph")
               && (
                     entity instanceof ArthropleuraAbominationEntity _datEntI
                        ? (Integer)_datEntI.getEntityData().get(ArthropleuraAbominationEntity.DATA_cooldown_head)
                        : 0
                  )
                  <= 0) {
               if (entity instanceof ArthropleuraAbominationEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(ArthropleuraAbominationEntity.DATA_cooldown_head, 20);
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(entity.getX(), entity.getY() + 0.3, entity.getZ() + 0.3),
                              Vec2.ZERO,
                              _level,
                              4,
                              "",
                              Component.literal(""),
                              _level.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "execute unless entity @e[distance=..20,type=arphex:segmented_body,nbt={Datasegmentnum_arphex:1,Datauuid_map:"
                           + (
                              entity instanceof ArthropleuraAbominationEntity _datEntS
                                 ? (String)_datEntS.getEntityData().get(ArthropleuraAbominationEntity.DATA_uuidmap)
                                 : ""
                           )
                           + "}] run summon arphex:segmented_body"
                     );
               }
            }

            if ((
                     entity instanceof ArthropleuraAbominationEntity _datEntI
                        ? (Integer)_datEntI.getEntityData().get(ArthropleuraAbominationEntity.DATA_cooldown_head)
                        : 0
                  )
                  > 0
               && entity instanceof ArthropleuraAbominationEntity _datEntSetI) {
               _datEntSetI.getEntityData()
                  .set(
                     ArthropleuraAbominationEntity.DATA_cooldown_head,
                     (
                           entity instanceof ArthropleuraAbominationEntity _datEntIx
                              ? (Integer)_datEntIx.getEntityData().get(ArthropleuraAbominationEntity.DATA_cooldown_head)
                              : 0
                        )
                        - 1
                  );
            }
         }

         if (entity.isAlive()) {
            if (entity instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get())
               || Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().z()) > 0.1 && !entity.isVehicle()) {
               if (!(entity.getPersistentData().getDouble("fallingpulses") > 0.0)) {
                  entity.getPersistentData().putDouble("fallingpulses", 15.0);
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0,
                        entity.getDeltaMovement().y(),
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.0
                     )
                  );
               } else {
                  entity.getPersistentData().putDouble("fallingpulses", entity.getPersistentData().getDouble("fallingpulses") - 1.0);
               }
            }

            if (entity.getPersistentData().getDouble("breaktime") > 0.0) {
               entity.getPersistentData().putDouble("breaktime", entity.getPersistentData().getDouble("breaktime") - 1.0);
            } else {
               if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
                  && entity.getDisplayName().getString().equals("Arthropleura Abomination")
                  && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()) {
                  ArphexMod.queueServerWork(
                     20,
                     () -> {
                        if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
                           && !entity.level().isClientSide()) {
                           entity.discard();
                        }
                     }
                  );
               }

               if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)
                  && (!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
                  && (Boolean)ConfigurationSettingsConfiguration.ARPHEX_GRIEFING.get()
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass"
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
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace glass_pane"
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

                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 air replace #minecraft:leaves"
                        );
                  }
               }

               entity.getPersistentData().putDouble("breaktime", 15.0);
            }

            if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame()) && entity.isVehicle()) {
               for (Entity entityiterator : entity.getIndirectPassengers()) {
                  entityiterator.stopRiding();
               }
            }

            entity.setMaxUpStep(1.0F);
         }
      }
   }
}
