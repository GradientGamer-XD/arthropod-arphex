package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpearOfParalysisItemInHandTickProcedure {
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

         if (entity instanceof Player _plrCldCheck11 && _plrCldCheck11.getCooldowns().isOnCooldown(itemstack.getItem())) {
            return;
         }

         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.2);
         }

         if ((entity instanceof LivingEntity _entUseTicks13 ? _entUseTicks13.getTicksUsingItem() : 0) > 60) {
            if (entity instanceof LivingEntity _entity) {
               _entity.stopUsingItem();
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 30, 0.5, 0.5, 0.5, 0.2);
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorx != entity && entityiteratorx instanceof LivingEntity) {
                  entityiteratorx.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3.0F
                  );
                  entityiteratorx.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  ArphexMod.queueServerWork(
                     10,
                     () -> {
                        entityiterator.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3.0F
                        );
                        entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        ArphexMod.queueServerWork(
                           10,
                           () -> {
                              entityiterator.hurt(
                                 new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3.0F
                              );
                              entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                           }
                        );
                     }
                  );
               }
            }
         }
      }
   }
}
