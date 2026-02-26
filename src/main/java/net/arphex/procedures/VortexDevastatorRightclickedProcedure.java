package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class VortexDevastatorRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         label57: {
            if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
               break label57;
            }

            entity.getPersistentData().putDouble("movingvortex", 5.0);
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 80);
            }

            int horizontalRadiusSphere = 3;
            int verticalRadiusSphere = 3;
            int yIterationsSphere = verticalRadiusSphere;

            for (int i = -verticalRadiusSphere; i <= yIterationsSphere; i++) {
               for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                  for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                     double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere)
                        + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere)
                        + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
                     if (distanceSq <= 1.0) {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(
                              (SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(),
                              x + (double)xi,
                              y + (double)i,
                              z + (double)zi,
                              1,
                              0.0,
                              0.0,
                              0.0,
                              0.0
                           );
                        }

                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(
                              (SimpleParticleType)ArphexModParticleTypes.GEODE_POWER.get(),
                              x + (double)xi,
                              y + (double)i,
                              z + (double)zi,
                              1,
                              0.0,
                              0.0,
                              0.0,
                              0.0
                           );
                        }
                     }
                  }
               }
            }
         }

         ArphexMod.queueServerWork(
            1,
            () -> {
               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VORTEX_DEVASTATOR.get()
                  && entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.OFF_HAND, true);
               }

               if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VORTEX_DEVASTATOR.get()
                  && entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }
            }
         );
      }
   }
}
