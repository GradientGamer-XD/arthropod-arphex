package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TormentorSummonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorPortalRightClixProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         ArphexMod.queueServerWork(
            3,
            () -> {
               if (entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  return;
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof TormentorSummonEntity && entityiterator instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt) && entityiterator.isAlive()) {
                           if (world instanceof ServerLevel _level) {
                              LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
                              entityToSpawn.moveTo(
                                 Vec3.atBottomCenterOf(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()))
                              );
                              entityToSpawn.setVisualOnly(true);
                              _level.addFreshEntity(entityToSpawn);
                           }

                           if (entity instanceof Player _player) {
                              _player.getCooldowns().addCooldown(itemstack.getItem(), 200);
                           }

                           if (!entityiterator.level().isClientSide()) {
                              entityiterator.discard();
                           }
                        }
                     }
                  }
               }
            }
         );
      }
   }
}
