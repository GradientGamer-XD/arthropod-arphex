package net.arphex.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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

public class SpacetimeChestplateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double tormentor_active = 0.0;
         double strength = 0.0;
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

         label143: {
            itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
            if (entity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown(itemstack.getItem())) {
               if ((entity instanceof Player _plrCldRem6 ? _plrCldRem6.getCooldowns().getCooldownPercent(itemstack.getItem(), 0.0F) * 100.0F : 0.0F) >= 79.0F
                  && (entity instanceof Player _plrCldRem8 ? _plrCldRem8.getCooldowns().getCooldownPercent(itemstack.getItem(), 0.0F) * 100.0F : 0.0F) < 100.0F
                  )
                {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 4, 1));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 4, 0));
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (6.0
                        > Math.sqrt(
                           (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                              + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                              + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                        )) {
                        label119:
                        if (entityiterator instanceof LivingEntity && !(entityiterator instanceof ArmorStand)) {
                           if (entityiterator instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)entityiterator;
                              if (_tamEnt.isTame()) {
                                 break label119;
                              }
                           }

                           if (entityiterator != entity) {
                              entityiterator.setDeltaMovement(
                                 new Vec3(
                                    (entityiterator.getX() - entity.getX())
                                       / (
                                          Math.sqrt(
                                                (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                   + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                   + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                             )
                                             / 2.0
                                       ),
                                    (entityiterator.getY() - entity.getY())
                                       / (
                                          Math.sqrt(
                                                (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                   + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                   + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                             )
                                             / 2.0
                                       ),
                                    (entityiterator.getZ() - entity.getZ())
                                       / (
                                          Math.sqrt(
                                                (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                   + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                   + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                             )
                                             / 2.0
                                       )
                                 )
                              );
                           }
                        }

                        if ((entityiterator instanceof Projectile _projEnt ? _projEnt.getDeltaMovement().length() : 0.0) > 0.0
                           && !entityiterator.level().isClientSide()) {
                           entityiterator.discard();
                        }
                     }
                  }
               }

               Vec3 _center = new Vec3(x, y, z);
               List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList();
               Iterator var29 = _entfound.iterator();

               while (true) {
                  if (!var29.hasNext()) {
                     break label143;
                  }

                  Entity entityiteratorx = (Entity)var29.next();
                  if (entityiteratorx instanceof Player) {
                     double _setval = 5.0;
                     entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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

                  if (entity instanceof Player _player) {
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 400);
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

         if ((!(entity instanceof LivingEntity _livEnt92) || !_livEnt92.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 0, false, false));
         }
      }
   }
}
