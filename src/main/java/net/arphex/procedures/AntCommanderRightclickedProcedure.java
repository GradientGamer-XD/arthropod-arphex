package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AntCommanderRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean dimensioncooldown = false;
         double distray = 0.0;
         double lookx = 0.0;
         double looky = 0.0;
         double lookz = 0.0;
         if (!(entity instanceof Player _plrCldCheck1) || !_plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) {
            if (entity.isShiftKeyDown()) {
               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
               }

               entity.getPersistentData().putBoolean("queennearcheck", false);
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof AntArsonistAlateQueenEntity && entityiterator instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                           entity.getPersistentData().putBoolean("queennearcheck", true);
                           if (entityiterator instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(AntArsonistAlateQueenEntity.DATA_Xarea, (int)x);
                           }

                           if (entityiterator instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(AntArsonistAlateQueenEntity.DATA_Yarea, (int)y);
                           }

                           if (entityiterator instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(AntArsonistAlateQueenEntity.DATA_Zarea, (int)z);
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.level().isClientSide()) {
                                 _player.displayClientMessage(
                                    Component.literal("Current coordinates sent to nearby queen. Nearby workers will prioritise this area"), true
                                 );
                              }
                           }
                        }
                     }
                  }
               }

               if (!entity.getPersistentData().getBoolean("queennearcheck") && entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("No tamed queen nearby (area target attempted)"), true);
               }
            } else if (!world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z)) && entity.onGround()) {
               entity.getPersistentData().putBoolean("queennearcheck", false);
               entity.getPersistentData().putDouble("antnum", 180.0);
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx instanceof AntArsonistWorkerEntity && entityiteratorx instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorx;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                           if (entityiteratorx instanceof Mob _entity) {
                              _entity.getNavigation().moveTo(x, y, z, 2.0);
                           }

                           if (entity.getPersistentData().getDouble("antnum") > 140.0) {
                              entity.getPersistentData().putDouble("antnum", entity.getPersistentData().getDouble("antnum") - 20.0);
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal("Worker ants will attempt building..."), true);
                              }
                           }

                           entity.getPersistentData().putBoolean("queennearcheck", true);
                           if (entityiteratorx instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiteratorx;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.BLOCKING_EFFECT.get(), 140, 0, false, false));
                              }
                           }
                        }
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown(itemstack.getItem(), (int)entity.getPersistentData().getDouble("antnum"));
               }

               if (entity.getPersistentData().getBoolean("queennearcheck")) {
                  entity.getPersistentData().putDouble("antbuildx", x);
                  entity.getPersistentData().putDouble("antbuildy", y);
                  entity.getPersistentData().putDouble("antbuildz", z);
                  entity.getPersistentData().putDouble("antblocktimer", 168.0);
               } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("No worker ants nearby (cannot build)"), true);
               }
            } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Cannot use this ability midair"), true);
            }
         }
      }
   }
}
