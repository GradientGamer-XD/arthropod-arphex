package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpearOfParalysisRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
            for (Entity entityiterator : new ArrayList(world.players())) {
               if (400.0 > Math.abs(entity.getX() - entityiterator.getX())
                  && 400.0 > Math.abs(entity.getY() - entityiterator.getY())
                  && 400.0 > Math.abs(entity.getZ() - entityiterator.getZ())) {
                  double _setval = 5.0;
                  entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.laser_emitter_near = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }
         }

         label204: {
            if (entity instanceof Player _plrCldCheck11 && _plrCldCheck11.getCooldowns().isOnCooldown(itemstack.getItem())) {
               break label204;
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.2);
            }

            if ((entity instanceof LivingEntity _entUseTicks13 ? _entUseTicks13.getTicksUsingItem() : 0) > 0) {
               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 3, false, false));
               }

               if (!(itemstack.getOrCreateTag().getDouble("spear_freeze_power") > 0.0)) {
                  itemstack.getOrCreateTag().putDouble("spear_freeze_power", 2.0);
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     label172:
                     if (entityiteratorx instanceof LivingEntity && entityiteratorx != entity) {
                        if (entityiteratorx instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
                           break label172;
                        }

                        int var40;
                        label163: {
                           if (entityiteratorx instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                              var40 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                              break label163;
                           }

                           var40 = 0;
                        }

                        if (var40 < 20 && !entityiteratorx.level().isClientSide() && entityiteratorx.getServer() != null) {
                           CommandSourceStack var10001;
                           int var10002;
                           label153: {
                              var41 = entityiteratorx.getServer().getCommands();
                              var10001 = new CommandSourceStack(
                                 CommandSource.NULL,
                                 entityiteratorx.position(),
                                 entityiteratorx.getRotationVector(),
                                 entityiteratorx.level() instanceof ServerLevel ? (ServerLevel)entityiteratorx.level() : null,
                                 4,
                                 entityiteratorx.getName().getString(),
                                 entityiteratorx.getDisplayName(),
                                 entityiteratorx.level().getServer(),
                                 entityiteratorx
                              );
                              if (entityiteratorx instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get())) {
                                 var10002 = _livEnt.getEffect((MobEffect)ArphexModMobEffects.TIME_FREEZE.get()).getAmplifier();
                                 break label153;
                              }

                              var10002 = 0;
                           }

                           var41.performPrefixedCommand(var10001, "effect give @s arphex:time_freeze 2 " + Math.round((float)(var10002 + 1)));
                        }
                        continue;
                     }

                     if ((entityiteratorx instanceof Projectile _projEnt ? _projEnt.getDeltaMovement().length() : 0.0) > 0.0) {
                        entityiteratorx.setDeltaMovement(new Vec3(0.0, -0.3, 0.0));
                     }
                  }
               } else {
                  itemstack.getOrCreateTag().putDouble("spear_freeze_power", itemstack.getOrCreateTag().getDouble("spear_freeze_power") - 1.0);
               }

               if ((entity instanceof LivingEntity _entUseTicks32 ? _entUseTicks32.getTicksUsingItem() : 0) > 80) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§aTime freeze ability - charged full power attack"), true);
                  }
               } else if ((entity instanceof LivingEntity _entUseTicks34 ? _entUseTicks34.getTicksUsingItem() : 0) > 40) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§aTime freeze ability - charged weak attack.."), true);
                  }
               } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§aTime freeze ability - charging attack..."), true);
               }

               if ((entity instanceof LivingEntity _entUseTicks37 ? _entUseTicks37.getTicksUsingItem() : 0) > 60
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5, 1, false, false));
               }

               if ((entity instanceof LivingEntity _entUseTicks39 ? _entUseTicks39.getTicksUsingItem() : 0) > 160) {
                  if (entity instanceof LivingEntity _entity) {
                     _entity.stopUsingItem();
                  }

                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§aTime freeze ability - overcharged"), true);
                  }

                  if (entity instanceof Player _player) {
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 320);
                  }
               }
            }
         }

         if ((!(entity instanceof LivingEntity _livEnt44) || !_livEnt44.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 30, 0, false, false));
         }
      }
   }
}
