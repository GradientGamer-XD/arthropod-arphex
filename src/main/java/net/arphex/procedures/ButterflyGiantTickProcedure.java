package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ButterflyBewitcherEntity;
import net.arphex.entity.ButterflyBewitcherGiantEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ButterflyGiantTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         if (entity.isVehicle()) {
            entity.setShiftKeyDown(false);
         } else if (!entity.onGround() && world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            if (!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame()) {
               if (entity.getPersistentData().getDouble("flywalk") < 200.0) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
               } else {
                  if (entity.getPersistentData().getDouble("flyboost") == 5.0) {
                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           entity.getX() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                           y,
                           entity.getZ() + Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
                        )
                     );
                     entity.setDeltaMovement(
                        new Vec3(
                           Mth.nextDouble(RandomSource.create(), -0.4, 0.4), entity.getDeltaMovement().y(), Mth.nextDouble(RandomSource.create(), -0.4, 0.4)
                        )
                     );
                  }

                  if (entity.getPersistentData().getDouble("yboost") == 5.0) {
                     entity.setDeltaMovement(
                        new Vec3(entity.getDeltaMovement().x(), Mth.nextDouble(RandomSource.create(), -0.3, 0.3), entity.getDeltaMovement().z())
                     );
                  }
               }
            }

            entity.setShiftKeyDown(false);
         } else {
            entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
            if (entity.getDeltaMovement().x() < 0.1 && entity.getDeltaMovement().z() < 0.1) {
               entity.setShiftKeyDown(true);
            } else {
               entity.setShiftKeyDown(false);
            }
         }

         if (entity.isInWater()) {
            entity.setDeltaMovement(
               new Vec3(
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                  Mth.nextDouble(RandomSource.create(), 0.3, 0.8),
                  Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
               )
            );
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 2.0F
               > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(), x, y, z, 5, 0.2, 0.2, 0.2, 0.2);
         }

         label205:
         if (entity.isVehicle() && entity.getFirstPassenger() != null && entity.getFirstPassenger() instanceof Player) {
            if ((
                  !(entity.getFirstPassenger() instanceof ServerPlayer _plr45)
                     || !(_plr45.level() instanceof ServerLevel)
                     || !_plr45.getAdvancements()
                        .getOrStartProgress(_plr45.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:butterfly_rider")))
                        .isDone()
               )
               && entity.getFirstPassenger() instanceof ServerPlayer _player) {
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:butterfly_rider"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for (String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }

            if (((ArphexModVariables.PlayerVariables)entity.getFirstPassenger()
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .holdingspace) {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.1, entity.getDeltaMovement().z()));
            } else {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.1, entity.getDeltaMovement().z()));
            }

            if (entity instanceof TamableAnimal _tamIsTamedBy && entity.getFirstPassenger() instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)
               )
             {
               break label205;
            }

            if (entity.getFirstPassenger() instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("Cannot ride butterfly - requires taming with flowers"), true);
            }

            entity.getFirstPassenger().stopRiding();
         }

         label230: {
            if (entity instanceof TamableAnimal _tamEntx && _tamEntx.isTame()) {
               break label230;
            }

            if (!(entity.getPersistentData().getDouble("yboost") > 0.0)) {
               entity.getPersistentData().putDouble("yboost", (double)Mth.nextInt(RandomSource.create(), 15, 20));
            } else {
               entity.getPersistentData().putDouble("yboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }

            if (!(entity.getPersistentData().getDouble("flyboost") > 0.0)) {
               entity.getPersistentData().putDouble("flyboost", (double)Mth.nextInt(RandomSource.create(), 5, 15));
            } else {
               entity.getPersistentData().putDouble("flyboost", entity.getPersistentData().getDouble("flyboost") - 1.0);
            }

            if (!(entity.getPersistentData().getDouble("flywalk") > 4000.0)) {
               entity.getPersistentData()
                  .putDouble("flywalk", entity.getPersistentData().getDouble("flywalk") + (double)Mth.nextInt(RandomSource.create(), 0, 2));
            } else {
               entity.getPersistentData().putDouble("flywalk", 0.0);
            }
         }

         label231: {
            if (entity instanceof TamableAnimal _tamEntx && _tamEntx.isTame() && entity.isVehicle()) {
               break label231;
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (!entityiterator.getPersistentData().getBoolean("creativespectator")
                  && !(entityiterator instanceof ButterflyBewitcherEntity)
                  && !(entityiterator instanceof ButterflyBewitcherGiantEntity)
                  && entityiterator != (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null)
                  && !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
                  && !entityiterator.isPassenger()
                  && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 1));
                  }
               }
            }
         }

         if (entity instanceof LivingEntity _livEnt88
            && _livEnt88.hasEffect(MobEffects.REGENERATION)
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0));
         }

         if ((!(entity instanceof TamableAnimal _tamEntxxx) || !_tamEntxxx.isTame())
            && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) == null) {
            if (!(entity.getPersistentData().getDouble("despawncheck") > 0.0)) {
               if (entity.getDisplayName().getString().equals("Butterfly Bewitcher Giant")) {
                  if ((!(entity instanceof TamableAnimal _tamEntxxxxx) || !_tamEntxxxxx.isTame())
                     && (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null) == null
                     && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()) {
                     ArphexMod.queueServerWork(
                        20,
                        () -> {
                           if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()
                              && !entity.level().isClientSide()) {
                              entity.discard();
                           }
                        }
                     );
                  }

                  entity.getPersistentData().putDouble("despawncheck", 100.0);
               }
            } else {
               entity.getPersistentData().putDouble("despawncheck", entity.getPersistentData().getDouble("despawncheck") - 1.0);
            }
         }
      }
   }
}
