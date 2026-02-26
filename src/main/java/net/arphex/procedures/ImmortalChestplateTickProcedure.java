package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ImmortalChestplateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         entity.setAirSupply(300);
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0, false, false));
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5, 0, false, false));
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:immortal_god"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (!(entity.getPersistentData().getDouble("immortal_absorption") > 0.0)) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1, false, false));
            }

            entity.getPersistentData().putDouble("immortal_absorption", 200.0);
         } else {
            entity.getPersistentData().putDouble("immortal_absorption", entity.getPersistentData().getDouble("immortal_absorption") - 1.0);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.VOIDLASHER_CHAOS_CONTROL.get());
         }

         if ((!(entity instanceof LivingEntity _livEnt12) || !_livEnt12.hasEffect((MobEffect)ArphexModMobEffects.VOID_PROTECTION.get()))
            && (!(entity instanceof LivingEntity _livEnt13) || !_livEnt13.hasEffect((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get()))) {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_PROTECTION.get(), 20, 0, false, false));
               }
            } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.VOID_COOLDOWN.get(), 20, 0, false, false));
            }
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                     CommandSource.NULL,
                     entity.position(),
                     entity.getRotationVector(),
                     entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                     4,
                     entity.getName().getString(),
                     entity.getDisplayName(),
                     entity.level().getServer(),
                     entity
                  ),
                  "item modify entity @s armor.chest {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }

         if (entity instanceof LivingEntity _livEnt18
            && _livEnt18.isFallFlying()
            && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .holdingspace) {
            entity.setDeltaMovement(new Vec3(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z));
         }

         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof TamableAnimal) {
               TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt25 = (LivingEntity)entityiterator;
                        if (_livEnt25.hasEffect(MobEffects.REGENERATION)) {
                           continue;
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
                        }
                     }
                  }
               }
            }
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, 1, false, false));
         }

         if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .inherent_power_cooldown
            > 10800.0) {
            for (Entity entityiteratorx : new ArrayList(world.players())) {
               if (Math.abs(entity.getX() - entityiteratorx.getX()) < 200.0
                  && Math.abs(entity.getY() - entityiteratorx.getY()) < 200.0
                  && Math.abs(entity.getZ() - entityiteratorx.getZ()) < 200.0) {
                  double _setval = 5.0;
                  entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.immortal_near = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
               }
            }
         }

         label279: {
            if (entity instanceof Player _plrCldCheck37 && _plrCldCheck37.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.removeEffect(MobEffects.GLOWING);
               }

               if ((entity instanceof Player _plrCldRem40 ? _plrCldRem40.getCooldowns().getCooldownPercent(itemstack.getItem(), 0.0F) * 100.0F : 0.0F) >= 79.0F
                  && (entity instanceof Player _plrCldRem42 ? _plrCldRem42.getCooldowns().getCooldownPercent(itemstack.getItem(), 0.0F) * 100.0F : 0.0F)
                     < 100.0F) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 4, 0));
                  }

                  Vec3 _centerx = new Vec3(x, y, z);

                  for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(6.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (6.0
                        > Math.sqrt(
                           (entity.getX() - entityiteratorxx.getX()) * (entity.getX() - entityiteratorxx.getX())
                              + (entity.getY() - entityiteratorxx.getY()) * (entity.getY() - entityiteratorxx.getY())
                              + (entity.getZ() - entityiteratorxx.getZ()) * (entity.getZ() - entityiteratorxx.getZ())
                        )) {
                        label212:
                        if (entityiteratorxx instanceof LivingEntity && !(entityiteratorxx instanceof ArmorStand)) {
                           if (entityiteratorxx instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)entityiteratorxx;
                              if (_tamEnt.isTame()) {
                                 break label212;
                              }
                           }

                           if (entityiteratorxx != entity) {
                              entityiteratorxx.setDeltaMovement(
                                 new Vec3(
                                    (entityiteratorxx.getX() - entity.getX())
                                       / (
                                          Math.sqrt(
                                                (entity.getX() - entityiteratorxx.getX()) * (entity.getX() - entityiteratorxx.getX())
                                                   + (entity.getY() - entityiteratorxx.getY()) * (entity.getY() - entityiteratorxx.getY())
                                                   + (entity.getZ() - entityiteratorxx.getZ()) * (entity.getZ() - entityiteratorxx.getZ())
                                             )
                                             / 2.0
                                       ),
                                    (entityiteratorxx.getY() - entity.getY())
                                       / (
                                          Math.sqrt(
                                                (entity.getX() - entityiteratorxx.getX()) * (entity.getX() - entityiteratorxx.getX())
                                                   + (entity.getY() - entityiteratorxx.getY()) * (entity.getY() - entityiteratorxx.getY())
                                                   + (entity.getZ() - entityiteratorxx.getZ()) * (entity.getZ() - entityiteratorxx.getZ())
                                             )
                                             / 2.0
                                       ),
                                    (entityiteratorxx.getZ() - entity.getZ())
                                       / (
                                          Math.sqrt(
                                                (entity.getX() - entityiteratorxx.getX()) * (entity.getX() - entityiteratorxx.getX())
                                                   + (entity.getY() - entityiteratorxx.getY()) * (entity.getY() - entityiteratorxx.getY())
                                                   + (entity.getZ() - entityiteratorxx.getZ()) * (entity.getZ() - entityiteratorxx.getZ())
                                             )
                                             / 2.0
                                       )
                                 )
                              );
                           }
                        }

                        if ((entityiteratorxx instanceof Projectile _projEnt ? _projEnt.getDeltaMovement().length() : 0.0) > 0.0
                           && !entityiteratorxx.level().isClientSide()) {
                           entityiteratorxx.discard();
                        }
                     }
                  }
               }

               Iterator var36 = new ArrayList(world.players()).iterator();

               while (true) {
                  if (!var36.hasNext()) {
                     break label279;
                  }

                  Entity entityiteratorxxx = (Entity)var36.next();
                  if (Math.abs(entity.getX() - entityiteratorxxx.getX()) < 200.0
                     && Math.abs(entity.getY() - entityiteratorxxx.getY()) < 200.0
                     && Math.abs(entity.getZ() - entityiteratorxxx.getZ()) < 200.0) {
                     double _setval = 5.0;
                     entityiteratorxxx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.sphere_near = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }
               }
            }

            if (entity.isShiftKeyDown()) {
               if (entity.getPersistentData().getDouble("wait_for_second_crouch") > 0.0 && !entity.getPersistentData().getBoolean("sneaked_trigger")) {
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
                           "particle arphex:heavy_green_smoke ~ ~ ~ 0.3 0.3 0.3 0.5 3 force"
                        );
                  }

                  if (entity instanceof Player _playerx) {
                     _playerx.getCooldowns().addCooldown(itemstack.getItem(), 400);
                  }
               }

               if (!(entity.getPersistentData().getDouble("wait_for_second_crouch") > 0.0) && !entity.getPersistentData().getBoolean("sneaked_trigger")) {
                  entity.getPersistentData().putDouble("wait_for_second_crouch", 10.0);
               }

               entity.getPersistentData().putBoolean("sneaked_trigger", true);
            } else {
               entity.getPersistentData().putBoolean("sneaked_trigger", false);
            }

            if (entity.getPersistentData().getDouble("wait_for_second_crouch") > 0.0) {
               entity.getPersistentData().putDouble("wait_for_second_crouch", entity.getPersistentData().getDouble("wait_for_second_crouch") - 1.0);
            }
         }

         if ((!(entity instanceof LivingEntity _livEnt130) || !_livEnt130.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 0, false, false));
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         entity.clearFire();
      }
   }
}
