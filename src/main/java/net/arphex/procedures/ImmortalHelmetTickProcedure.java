package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ImmortalHelmetTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double raytrace_distance = 0.0;
         double Radius = 0.0;
         double loop = 0.0;
         double particleSpeed = 0.0;
         double expand = 0.0;
         double line_limit = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         double scanpower = 0.0;
         double _setval = 0.0;
         entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.shadertime = _setval;
            capability.syncPlayerVariables(entity);
         });
         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.BLINDNESS);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.CONFUSION);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.VOIDLASHER_CHAOS_CONTROL.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WEAKNESS);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.MOTH_CURSE.get());
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.POISON);
         }

         if (entity.isShiftKeyDown()) {
            label143:
            if ((entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.IMMORTAL_BOOTS.get()
               && (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.IMMORTAL_LEGGINGS.get()
               && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.IMMORTAL_CHESTPLATE.get()) {
               if (entity instanceof Player _plrCldCheck17 && _plrCldCheck17.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  break label143;
               }

               itemstack.getOrCreateTag().putDouble("etdirx", entity.getX());
               itemstack.getOrCreateTag().putDouble("etdirz", entity.getZ());
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 60);
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get(), 15, 0, false, false));
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.ETERNAL_FLAME.get(), x, y, z, 30, 0.3, 1.5, 0.3, 0.01);
               }
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.LEVITATION);
            }
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
                  "item modify entity @s armor.head {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }

         scanpower = 100.0;
         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (entity.isShiftKeyDown()
            && (
               !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ()))
                  || ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .holdingspace
            )) {
            line_limit = 0.0;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(scanpower / 2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (line_limit < 15.0) {
                  line_limit++;
                  lineX = 0.0;
                  lineY = 0.0;
                  lineZ = 0.0;
                  expand = 0.0;
                  if (entityiterator != entity && entityiterator instanceof ItemEntity) {
                     if (world instanceof ServerLevel _level) {
                        _level.getServer()
                           .getCommands()
                           .performPrefixedCommand(
                              new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                 )
                                 .withSuppressedOutput(),
                              "particle arphex:glow_sense_item ~ ~2 ~ 0 0 0 0 2 force " + entity.getDisplayName().getString()
                           );
                     }

                     lineX = entity.getX() - entityiterator.getX();
                     lineY = entity.getY() + 1.0 - entityiterator.getY();
                     lineZ = entity.getZ() - entityiterator.getZ();
                     expand = expand;

                     for (int index0 = 0; index0 < 20; index0++) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:glow_sense_item ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                              );
                        }

                        expand -= 0.04;
                     }
                  }
               }
            }

            _setval = 3.0;
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.sphere_near = _setval;
               capability.syncPlayerVariables(entity);
            });
         }
      }
   }
}
