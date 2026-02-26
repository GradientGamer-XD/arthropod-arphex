package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.ArthropleuraAbominationEntity;
import net.arphex.entity.BeetleBulwarkEntity;
import net.arphex.entity.MantisMutilatorEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BrownScarabRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (world.getEntitiesOfClass(ArthropleuraAbominationEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(MantisMutilatorEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
            && !itemstack.getOrCreateTag().getBoolean("done")) {
            if (entity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown(itemstack.getItem())) {
               return;
            }

            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               itemstack.getOrCreateTag().putBoolean("done", true);
            }

            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BEETLE_BULWARK.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            if (!world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()) {
               if (itemstack.getOrCreateTag().getDouble("size") > 0.0) {
                  Entity var20 = world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null);
                  if (var20 instanceof BeetleBulwarkEntity _datEntSetI) {
                     _datEntSetI.getEntityData().set(BeetleBulwarkEntity.DATA_randsize, (int)itemstack.getOrCreateTag().getDouble("size"));
                  }
               }

               if (itemstack.getItem() == ArphexModItems.BROWN_SCARAB.get()) {
                  world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getPersistentData()
                     .putString("beetlever", "scarabb");
                  if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BROWN_SCARAB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               } else if (itemstack.getItem() == ArphexModItems.GREEN_SCARAB.get()) {
                  world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getPersistentData()
                     .putString("beetlever", "scarabg");
                  if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.GREEN_SCARAB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               } else if (itemstack.getItem() == ArphexModItems.GREEN_GOLD_SCARAB.get()) {
                  world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getPersistentData()
                     .putString("beetlever", "scarabt");
                  if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.GREEN_GOLD_SCARAB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               } else if (itemstack.getItem() == ArphexModItems.IRIDESCENT_SCARAB.get()) {
                  world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getPersistentData()
                     .putString("beetlever", "scarabi");
                  if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.IRIDESCENT_SCARAB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               } else if (itemstack.getItem() == ArphexModItems.PURPLE_SCARAB.get()) {
                  world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getPersistentData()
                     .putString("beetlever", "scarabp");
                  if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.PURPLE_SCARAB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               } else if (itemstack.getItem() == ArphexModItems.GOLDEN_SCARAB.get()) {
                  world.getEntitiesOfClass(BeetleBulwarkEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getPersistentData()
                     .putString("beetlever", "scarabgold");
                  if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.GOLDEN_SCARAB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
            }
         }
      }
   }
}
