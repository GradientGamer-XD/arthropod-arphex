package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ImmortalLeggingsTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if (entity.isShiftKeyDown()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 30, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 5, 0, false, false));
            }
         } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 1, false, false));
         }

         label216:
         if (entity.isShiftKeyDown()) {
            if (entity instanceof Player _plrCldCheck8 && _plrCldCheck8.getCooldowns().isOnCooldown(itemstack.getItem())) {
               break label216;
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x, y, z, 5, 0.0, 0.0, 0.0, 0.1);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator != entity && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 3, false, false));
                  }
               }
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
                  "item modify entity @s armor.legs {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
               );
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.WEBBED.get());
         }

         if (entity.isShiftKeyDown() && entity.onGround() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 0, false, false));
         }

         if ((
                  entity instanceof Player _plrCldRem21
                     ? _plrCldRem21.getCooldowns().getCooldownPercent((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get(), 0.0F) * 100.0F
                     : 0.0F
               )
               > 79.0F
            && (
                  entity instanceof Player _plrCldRem22
                     ? _plrCldRem22.getCooldowns().getCooldownPercent((Item)ArphexModItems.IMMORTAL_CHESTPLATE.get(), 0.0F) * 100.0F
                     : 0.0F
               )
               < 100.0F) {
            int var42;
            label187: {
               if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.INVISIBILITY)) {
                  var42 = _livEnt.getEffect(MobEffects.INVISIBILITY).getDuration();
                  break label187;
               }

               var42 = 0;
            }

            if (var42 < 21 && entity instanceof LivingEntity _entity) {
               _entity.removeEffect(MobEffects.INVISIBILITY);
            }
         }

         itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         if ((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > entity.getPersistentData().getDouble("bcst1")) {
            entity.getPersistentData().putDouble("bcst1", entity instanceof LivingEntity _livEntx ? (double)_livEntx.getHealth() : -1.0);
         }

         if (!(entity.getPersistentData().getDouble("buffer_cycle_spacetime") > 0.0)) {
            entity.getPersistentData().putDouble("bcst5", entity.getPersistentData().getDouble("bcst4"));
            entity.getPersistentData().putDouble("bcst4", entity.getPersistentData().getDouble("bcst3"));
            entity.getPersistentData().putDouble("bcst3", entity.getPersistentData().getDouble("bcst2"));
            entity.getPersistentData().putDouble("bcst2", entity.getPersistentData().getDouble("bcst1"));
            entity.getPersistentData().putDouble("bcst1", 0.0);
            entity.getPersistentData().putDouble("buffer_cycle_spacetime", 20.0);
         } else {
            entity.getPersistentData().putDouble("buffer_cycle_spacetime", entity.getPersistentData().getDouble("buffer_cycle_spacetime") - 1.0);
         }

         label178:
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) < 5.0F) {
            if (entity instanceof Player _plrCldCheck45 && _plrCldCheck45.getCooldowns().isOnCooldown((Item)ArphexModItems.SPACETIME_LEGGINGS.get())) {
               break label178;
            }

            if (entity.getPersistentData().getDouble("bcst5") > entity.getPersistentData().getDouble("bcst4")) {
               entity.getPersistentData().putDouble("bcst4", entity.getPersistentData().getDouble("bcst5"));
            }

            if (entity.getPersistentData().getDouble("bcst4") > entity.getPersistentData().getDouble("bcst3")) {
               entity.getPersistentData().putDouble("bcst3", entity.getPersistentData().getDouble("bcst4"));
            }

            if (entity.getPersistentData().getDouble("bcst3") > entity.getPersistentData().getDouble("bcst2")) {
               entity.getPersistentData().putDouble("bcst2", entity.getPersistentData().getDouble("bcst3"));
            }

            if (entity.getPersistentData().getDouble("bcst2") > entity.getPersistentData().getDouble("bcst1")) {
               entity.getPersistentData().putDouble("bcst1", entity.getPersistentData().getDouble("bcst2"));
            }

            if (entity.getPersistentData().getDouble("bcst1") > (double)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F)
               && (entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) > 0.0F) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.setHealth((float)entity.getPersistentData().getDouble("bcst1"));
               }

               if (entity instanceof Player _playerx) {
                  _playerx.getCooldowns().addCooldown((Item)ArphexModItems.SPACETIME_LEGGINGS.get(), 600);
               }

               if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                  _playerx.displayClientMessage(Component.literal("§2Health recovered through time!"), true);
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.TIME_SPLASH_PARTICLE.get(), x, y, z, 5, 0.2, 0.3, 0.2, 0.1);
               }
            }
         }

         if (!world.isClientSide() && !entity.level().isClientSide() && entity.getServer() != null) {
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
                  "fill ~-3 ~-3 ~-3 ~3 ~3 ~3 arphex:cobweb_passable replace cobweb"
               );
         }
      }
   }
}
