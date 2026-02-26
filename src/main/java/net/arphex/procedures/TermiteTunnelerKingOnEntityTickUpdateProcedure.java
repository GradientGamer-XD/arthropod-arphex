package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TermiteTunnelerKingEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TermiteTunnelerKingOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label240: {
            entity.getPersistentData().putBoolean("arphex", true);
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
               label229:
               if ((entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null) {
                  if (entity instanceof TermiteTunnelerKingEntity _datEntL4 && (Boolean)_datEntL4.getEntityData().get(TermiteTunnelerKingEntity.DATA_following)
                     )
                   {
                     entity.setCustomName(
                        Component.literal(
                           (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getDisplayName().getString()
                              + "'s Termite King (following)"
                        )
                     );
                     break label229;
                  }

                  entity.setCustomName(
                     Component.literal(
                        (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getDisplayName().getString()
                           + "'s Termite King (not following)"
                     )
                  );
               }

               if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
                  && (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null) != null
                  && (
                     entity instanceof TamableAnimal _tamIsTamedByx
                           && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity _livEntx
                           && _tamIsTamedByx.isOwnedBy(_livEntx)
                        || (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof TamableAnimal _tamIsTamedBy
                           && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) instanceof LivingEntity _livEnt
                           && _tamIsTamedBy.isOwnedBy(_livEnt)
                  )
                  && entity instanceof Mob) {
                  try {
                     ((Mob)entity).setTarget(null);
                  } catch (Exception var20) {
                     var20.printStackTrace();
                  }
               }
               break label240;
            }

            if ((!(entity instanceof TermiteTunnelerKingEntity _datEntL21) || !(Boolean)_datEntL21.getEntityData().get(TermiteTunnelerKingEntity.DATA_larvae))
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true).isEmpty()
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
               && entity instanceof Mob _entity) {
               Entity _livEnt = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (_livEnt instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }
         }

         label200: {
            if (entity instanceof TermiteTunnelerKingEntity _datEntL27 && (Boolean)_datEntL27.getEntityData().get(TermiteTunnelerKingEntity.DATA_larvae)) {
               entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 10, false, false));
               }

               entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
               if (entity instanceof TermiteTunnelerKingEntity animatable) {
                  animatable.setTexture("antlarvae");
               }

               if ((!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
                  && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true).isEmpty()
                  && entity instanceof TamableAnimal _toTame) {
                  Entity var48 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), ex -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (var48 instanceof Player _owner) {
                     _toTame.tame(_owner);
                  }
               }
               break label200;
            }

            if (entity instanceof TermiteTunnelerKingEntity animatable) {
               animatable.setTexture("termiteking");
            }
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
               < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F
            && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 5, 0.8, 0.4, 0.8, 0.2);
         }

         entity.setMaxUpStep(2.0F);
         if (entity.isVehicle()
            && (
               !(entity instanceof TamableAnimal _tamIsTamedBy)
                  || !(entity.getFirstPassenger() instanceof LivingEntity _livEnt)
                  || !_tamIsTamedBy.isOwnedBy(_livEnt)
            )) {
            entity.getFirstPassenger().stopRiding();
         }

         if ((entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
            && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getPersistentData().getBoolean("creativespectator")
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var19) {
               var19.printStackTrace();
            }
         }

         label179: {
            if (entity instanceof TermiteTunnelerKingEntity _datEntL52 && (Boolean)_datEntL52.getEntityData().get(TermiteTunnelerKingEntity.DATA_larvae)) {
               entity.setSprinting(true);
               ArphexMod.queueServerWork(1200, () -> {
                  if (entity instanceof TermiteTunnelerKingEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(TermiteTunnelerKingEntity.DATA_larvae, false);
                  }
               });
               break label179;
            }

            entity.setSprinting(false);
         }

         if ((!(entity instanceof LivingEntity _livEnt57) || !_livEnt57.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entityx
            && !_entityx.level().isClientSide()) {
            _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
         }

         if ((!(entity instanceof TamableAnimal _tamEntx) || !_tamEntx.isTame())
            && Mth.nextInt(RandomSource.create(), 1, 60) == 2
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), ex -> true).isEmpty()) {
            ArphexMod.queueServerWork(
               20,
               () -> {
                  if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 120.0, 120.0, 120.0), ex -> true).isEmpty()
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            );
         }
      }
   }
}
