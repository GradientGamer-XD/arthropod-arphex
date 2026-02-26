package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SphereAnimOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = 0.0;
         double blackhole = 0.0;
         double distnorm = 0.0;
         double range = 0.0;
         double sizefactor = 0.0;
         double drag = 0.0;
         double pullstrength = 0.0;
         entity.setNoGravity(true);
         if (entity instanceof SphereAnimEntity _datEntL1
            && (Boolean)_datEntL1.getEntityData().get(SphereAnimEntity.DATA_black_hole)
            && world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "particle arphex:entropy_spear ~ ~-60 ~ 10 5 10 0 140 force"
               );
         }

         label271: {
            if (entity instanceof SphereAnimEntity _datEntL3 && (Boolean)_datEntL3.getEntityData().get(SphereAnimEntity.DATA_black_hole)) {
               if (entity instanceof SphereAnimEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_opacity, 220);
               }
               break label271;
            }

            if (entity instanceof SphereAnimEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_opacity, 140);
            }
         }

         if ((entity instanceof SphereAnimEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SphereAnimEntity.DATA_max_size) : 0) <= 0) {
            if (entity instanceof SphereAnimEntity _datEntL7
               && (Boolean)_datEntL7.getEntityData().get(SphereAnimEntity.DATA_black_hole)
               && entity instanceof SphereAnimEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_max_size, 1000);
            }

            ArphexMod.queueServerWork(
               3,
               () -> {
                  if ((entity instanceof SphereAnimEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SphereAnimEntity.DATA_max_size) : 0) <= 0
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         } else {
            label277: {
               if (!(entity instanceof SphereAnimEntity _datEntL12) || !(Boolean)_datEntL12.getEntityData().get(SphereAnimEntity.DATA_revert)) {
                  if ((entity instanceof SphereAnimEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0)
                     < (entity instanceof SphereAnimEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SphereAnimEntity.DATA_max_size) : 0)) {
                     if (entity instanceof SphereAnimEntity _datEntL19 && (Boolean)_datEntL19.getEntityData().get(SphereAnimEntity.DATA_black_hole)) {
                        if (entity instanceof SphereAnimEntity _datEntSetI) {
                           _datEntSetI.getEntityData()
                              .set(
                                 SphereAnimEntity.DATA_sphere_size,
                                 (
                                       entity instanceof SphereAnimEntity _datEntIxx
                                          ? (Integer)_datEntIxx.getEntityData().get(SphereAnimEntity.DATA_sphere_size)
                                          : 0
                                    )
                                    + 3
                              );
                        }
                        break label277;
                     }

                     if (entity instanceof SphereAnimEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              SphereAnimEntity.DATA_sphere_size,
                              (entity instanceof SphereAnimEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0)
                                 + 10
                           );
                     }
                  } else {
                     if (entity instanceof SphereAnimEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(SphereAnimEntity.DATA_revert, true);
                     }

                     if ((entity instanceof SphereAnimEntity _datEntS ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color) : "").equals("black")
                        && world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                 )
                                 .withSuppressedOutput(),
                              "effect give @e[nbt=!{SelectedItem:{id:\"arphex:genesis_rifle\"}},nbt=!{SelectedItem:{id:\"arphex:singularity_scythe\"}},distance=.."
                                 + (entity instanceof SphereAnimEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0)
                                    / 20
                                 + "] wither 5 5"
                           );
                     }
                  }
                  break label277;
               }

               if ((entity instanceof SphereAnimEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0) > 0) {
                  if (entity instanceof SphereAnimEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           SphereAnimEntity.DATA_sphere_size,
                           (entity instanceof SphereAnimEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0) - 10
                        );
                  }
               } else if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, false, false));
         }

         if (entity instanceof SphereAnimEntity _datEntL29 && (Boolean)_datEntL29.getEntityData().get(SphereAnimEntity.DATA_black_hole)) {
            if (!(entity.getPersistentData().getDouble("black_hole_damage_speed") > 0.0)) {
               entity.getPersistentData().putDouble("black_hole_damage_speed", 30.0);
            } else {
               entity.getPersistentData().putDouble("black_hole_damage_speed", entity.getPersistentData().getDouble("black_hole_damage_speed") - 1.0);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity
                  && !(entityiterator instanceof ArmorStand)
                  && !(entityiterator instanceof DiabolosDecimatorEntity)
                  && !(entityiterator instanceof TORMENTOREntity)
                  && !(entityiterator instanceof SphereAnimEntity)) {
                  distance = Math.max(
                     Math.sqrt(
                        (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                           + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                           + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                     ),
                     1.0
                  );
                  if (200.0 > distance) {
                     if (entityiterator instanceof Player) {
                        double _setval = 5.0;
                        entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.sphere_near = _setval;
                           capability.syncPlayerVariables(entityiterator);
                        });
                     }

                     if ((double)(
                           (entity instanceof SphereAnimEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0) / 20
                        )
                        > distance) {
                        double _setval = 5.0;
                        entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.overlay_solid_black = _setval;
                           capability.syncPlayerVariables(entityiterator);
                        });
                        if (entity.getPersistentData().getDouble("black_hole_damage_speed") == 5.0) {
                           entityiterator.hurt(
                              new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                              Math.max(200.0F, (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 5.0F)
                           );
                        }
                     }
                  }

                  if (!entityiterator.getPersistentData().getBoolean("creativespectator") && distance != 0.0) {
                     distnorm = Math.max(0.0, Math.min(1.0 - distance / 150.0, 1.0));
                     sizefactor = Math.sqrt(
                        (double)(
                           (entity instanceof SphereAnimEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0)
                              / 200
                        )
                     );
                     drag = Math.max(1.0 - 0.15 * distnorm * sizefactor, 0.3);
                     pullstrength = 0.11 * distnorm * sizefactor;
                     if (entityiterator instanceof Player) {
                        if (100.0 > distance && entityiterator instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("§cBEWARE - the black hole is pulling you to your doom - run!"), true);
                        }

                        if ((entityiterator instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                                 .getItem()
                              == ArphexModItems.IMMORTAL_BOOTS.get()
                           || (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                                 .getItem()
                              == ArphexModItems.SPACETIME_BOOTS.get()) {
                           pullstrength *= 0.4;
                        }
                     }

                     entityiterator.setDeltaMovement(
                        new Vec3(
                           entityiterator.getDeltaMovement().x() * drag + (entity.getX() - entityiterator.getX()) / distance * pullstrength,
                           entityiterator.getDeltaMovement().y() * drag + (entity.getY() - entityiterator.getY()) / distance * pullstrength,
                           entityiterator.getDeltaMovement().z() * drag + (entity.getZ() - entityiterator.getZ()) / distance * pullstrength
                        )
                     );
                  }
               }
            }

            return;
         }

         for (Entity entityiteratorx : new ArrayList(world.players())) {
            distance = Math.sqrt(
               (entity.getX() - entityiteratorx.getX()) * (entity.getX() - entityiteratorx.getX())
                  + (entity.getY() - (entityiteratorx.getY() + 1.0)) * (entity.getY() - entityiteratorx.getY())
                  + (entity.getZ() - entityiteratorx.getZ()) * (entity.getZ() - entityiteratorx.getZ())
            );
            if (200.0 > distance) {
               double _setval = 5.0;
               entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.sphere_near = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
               if ((double)(
                     (entity instanceof SphereAnimEntity _datEntIxx ? (Integer)_datEntIxx.getEntityData().get(SphereAnimEntity.DATA_sphere_size) : 0) / 20
                  )
                  > distance) {
                  if ((entity instanceof SphereAnimEntity _datEntS ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color) : "").equals("red")) {
                     double _setvalx = 5.0;
                     entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.overlay_red = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  } else if ((entity instanceof SphereAnimEntity _datEntS ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color) : "")
                     .equals("white")) {
                     double _setvalx = 5.0;
                     entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.overlay_white = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  } else if ((entity instanceof SphereAnimEntity _datEntS ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color) : "")
                     .equals("purple")) {
                     double _setvalx = 5.0;
                     entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.overlay_purple = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  } else if ((entity instanceof SphereAnimEntity _datEntS ? (String)_datEntS.getEntityData().get(SphereAnimEntity.DATA_color) : "")
                     .equals("green")) {
                     double _setvalx = 5.0;
                     entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.overlay_green = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  } else {
                     double _setvalx = 5.0;
                     entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.overlay_black = _setval;
                        capability.syncPlayerVariables(entityiterator);
                     });
                  }
               }
            }
         }
      }
   }
}
