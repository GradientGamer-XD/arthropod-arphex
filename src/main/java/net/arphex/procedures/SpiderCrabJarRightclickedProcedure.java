package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.CrabLarvaeEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderCrabJarRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SPIDER_CRAB_JAR.get()
            && world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.CRAB_LARVAE.get())
                  .spawn(_level, BlockPos.containing(x, y + 0.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(0.1F);
                  entityToSpawn.setYBodyRot(0.1F);
                  entityToSpawn.setYHeadRot(0.1F);
                  entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
               }
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                     Entity patt2195$temp = world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (patt2195$temp instanceof TamableAnimal _toTame && entity instanceof Player _owner) {
                        _toTame.tame(_owner);
                     }

                     if (!(entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                        .getDisplayName()
                        .getString()
                        .equals("Spider Crab Jar")) {
                        world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null)
                           .setCustomName(
                              Component.literal(
                                 (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                    .getDisplayName()
                                    .getString()
                                    .replace("]", "")
                                    .replace("[", "")
                              )
                           );
                        Entity patt3419$temp = world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt3419$temp instanceof LivingEntity _entity) {
                           _entity.setHealth(
                              (float)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                                 .getOrCreateTag()
                                 .getDouble("spiderhealth")
                           );
                        }
                     }
                  }
               }
            );
            ArphexMod.queueServerWork(2, () -> {
               if (entity instanceof LivingEntity _entity) {
                  ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.SPIDER_JAR.get()).copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player _player) {
                     _player.getInventory().setChanged();
                  }
               }
            });
         }
      }
   }
}
