package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.BeetleBulwarkEntity;
import net.arphex.init.ArphexModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BeetleBulwarkEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getString("beetlever").equals("lady")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.RED_DYE));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("rhino")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CHITIN.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("rhino")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CHITIN.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabb")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.BROWN_SCARAB.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                     Entity patt2587$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((patt2587$temp instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BROWN_SCARAB.get()) {
                        Entity patt3100$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        (patt3100$temp instanceof ItemEntity _itemEntx ? _itemEntx.getItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .putDouble(
                              "size",
                              entity instanceof BeetleBulwarkEntity _datEntI
                                 ? (double)((Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize)).intValue()
                                 : 0.0
                           );
                     }
                  }
               }
            );
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabg")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.GREEN_SCARAB.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                     Entity patt4293$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((patt4293$temp instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.GREEN_SCARAB.get()) {
                        Entity patt4811$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        (patt4811$temp instanceof ItemEntity _itemEntx ? _itemEntx.getItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .putDouble(
                              "size",
                              entity instanceof BeetleBulwarkEntity _datEntI
                                 ? (double)((Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize)).intValue()
                                 : 0.0
                           );
                     }
                  }
               }
            );
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabt")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.GREEN_GOLD_SCARAB.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                     Entity patt6027$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((patt6027$temp instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.GREEN_GOLD_SCARAB.get()) {
                        Entity patt6555$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        (patt6555$temp instanceof ItemEntity _itemEntx ? _itemEntx.getItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .putDouble(
                              "size",
                              entity instanceof BeetleBulwarkEntity _datEntI
                                 ? (double)((Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize)).intValue()
                                 : 0.0
                           );
                     }
                  }
               }
            );
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabi")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.IRIDESCENT_SCARAB.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                     Entity patt7789$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((patt7789$temp instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.IRIDESCENT_SCARAB.get()) {
                        Entity patt8322$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        (patt8322$temp instanceof ItemEntity _itemEntx ? _itemEntx.getItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .putDouble(
                              "size",
                              entity instanceof BeetleBulwarkEntity _datEntI
                                 ? (double)((Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize)).intValue()
                                 : 0.0
                           );
                     }
                  }
               }
            );
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabp")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.PURPLE_SCARAB.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                     Entity patt9570$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((patt9570$temp instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.PURPLE_SCARAB.get()) {
                        Entity patt10104$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        (patt10104$temp instanceof ItemEntity _itemEntx ? _itemEntx.getItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .putDouble(
                              "size",
                              entity instanceof BeetleBulwarkEntity _datEntI
                                 ? (double)((Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize)).intValue()
                                 : 0.0
                           );
                     }
                  }
               }
            );
         } else if (entity.getPersistentData().getString("beetlever").equals("scarabgold")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.GOLDEN_SCARAB.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            ArphexMod.queueServerWork(
               1,
               () -> {
                  if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
                     Entity patt11373$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if ((patt11373$temp instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.GOLDEN_SCARAB.get()
                        )
                      {
                        Entity patt11912$temp = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        (patt11912$temp instanceof ItemEntity _itemEntx ? _itemEntx.getItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .putDouble(
                              "size",
                              entity instanceof BeetleBulwarkEntity _datEntI
                                 ? (double)((Integer)_datEntI.getEntityData().get(BeetleBulwarkEntity.DATA_randsize)).intValue()
                                 : 0.0
                           );
                     }
                  }
               }
            );
         }
      }
   }
}
