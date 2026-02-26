package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderFunnelEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;

public class SpiderFunnelOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.onGround() && world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y + 1.0, z, 10, 0.1, 0.1, 0.1, 0.1);
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))) {
            if (!ModList.get().isLoaded("nyfsspiders") && world.isClientSide()) {
               if (world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
                  if (entity instanceof SpiderFunnelEntity) {
                     ((SpiderFunnelEntity)entity).setAnimation("animation.spiderfunnel.grabmove");
                  }
               } else if (entity instanceof SpiderFunnelEntity) {
                  ((SpiderFunnelEntity)entity).setAnimation("empty");
               }
            }

            entity.setSprinting(false);
         } else {
            entity.setShiftKeyDown(false);
            if (world.isClientSide() && entity instanceof SpiderFunnelEntity) {
               ((SpiderFunnelEntity)entity).setAnimation("empty");
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
               && (!(entity instanceof LivingEntity _livEnt15) || !_livEnt15.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get()))
               && entity instanceof LivingEntity _entity
               && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 20, false, false));
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
               && entity.getDeltaMovement().x() == 0.0
               && entity.getDeltaMovement().z() == 0.0) {
               entity.setSprinting(true);
            } else {
               entity.setSprinting(false);
            }
         }

         if (!entity.getPersistentData().getBoolean("despawnedrider")) {
            entity.getPersistentData().putBoolean("despawnedrider", true);
            if (entity.isVehicle() && entity.getFirstPassenger() != null && !entity.getFirstPassenger().level().isClientSide()) {
               entity.getFirstPassenger().discard();
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.FUNNEL_WEB.get()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 200, 0, false, false));
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")
               && entity instanceof Mob _entity) {
               Entity var11 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var11 instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }

            entity.setDeltaMovement(new Vec3(0.0, 0.4, 0.0));
            ArphexMod.queueServerWork(
               10,
               () -> entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                        -0.6,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                     )
                  )
            );
         }
      }
   }
}
