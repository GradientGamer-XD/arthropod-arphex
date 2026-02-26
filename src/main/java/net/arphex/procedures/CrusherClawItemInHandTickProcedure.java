package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
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

public class CrusherClawItemInHandTickProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double homing = 0.0;
         Entity entity_lock = null;
         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:crab_kill"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         label65:
         if ((entity instanceof LivingEntity _entUseTicks1 ? _entUseTicks1.getTicksUsingItem() : 0) > 50) {
            if (entity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(itemstack.getItem())) {
               break label65;
            }

            entity_lock = world.getEntitiesOfClass(
                  LivingEntity.class,
                  AABB.ofSize(
                     new Vec3(
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
                           .getX(),
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
                           .getY(),
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
                     ),
                     8.0,
                     8.0,
                     8.0
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
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)),
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
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)),
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
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)),
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
            if (entity_lock != null && entity_lock != entity) {
               if (entity_lock instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CONSTRICTED.get(), 5, 0));
               }

               entity.getPersistentData().putDouble("crabcool", entity.getPersistentData().getDouble("crabcool") + 3.0);
               if ((entity_lock instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) <= 250.0F) {
                  entity_lock.setDeltaMovement(
                     new Vec3(
                        entity.getX()
                           - Math.sin(Math.toRadians((double)entity.getYRot())) * 3.5 * Math.cos(Math.toRadians((double)entity.getXRot()))
                           - entity_lock.getX(),
                        entity.getY() + 1.6 - Math.sin(Math.toRadians((double)entity.getXRot())) * 3.5 - entity_lock.getY(),
                        entity.getZ()
                           + Math.cos(Math.toRadians((double)entity.getYRot())) * 3.5 * Math.cos(Math.toRadians((double)entity.getXRot()))
                           - entity_lock.getZ()
                     )
                  );
               }
            }
         }

         if ((entity instanceof LivingEntity _entUseTicks26 ? _entUseTicks26.getTicksUsingItem() : 0) < 1) {
            if (!(entity.getPersistentData().getDouble("crabcool") > 0.0)) {
               entity.getPersistentData().putDouble("crabcool", 0.0);
            } else {
               entity.getPersistentData().putDouble("crabcool", entity.getPersistentData().getDouble("crabcool") - 1.0);
            }
         }

         if ((entity instanceof LivingEntity _entUseTicks31 ? _entUseTicks31.getTicksUsingItem() : 0) >= 450 && entity instanceof Player _playerx) {
            _playerx.getCooldowns().addCooldown(itemstack.getItem(), 100);
         }
      }
   }
}
