package net.arphex.procedures;

import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class BucketOfWormGrubRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BUCKET_OF_WORM_GRUB.get()) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(0.1F);
                  entityToSpawn.setYBodyRot(0.1F);
                  entityToSpawn.setYHeadRot(0.1F);
                  entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_levelx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(0.2F);
                  entityToSpawn.setYBodyRot(0.2F);
                  entityToSpawn.setYHeadRot(0.2F);
                  entityToSpawn.setDeltaMovement(0.1, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_levelxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(-0.1F);
                  entityToSpawn.setYBodyRot(-0.1F);
                  entityToSpawn.setYHeadRot(-0.1F);
                  entityToSpawn.setDeltaMovement(-0.05, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_levelxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(-0.2F);
                  entityToSpawn.setYBodyRot(-0.2F);
                  entityToSpawn.setYHeadRot(-0.2F);
                  entityToSpawn.setDeltaMovement(-0.1, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_levelxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setXRot(0.1F);
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.05);
               }
            }

            if (world instanceof ServerLevel _levelxxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_levelxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setXRot(0.2F);
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.5);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_levelxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setXRot(-0.1F);
                  entityToSpawn.setDeltaMovement(0.0, 0.0, -0.05);
               }
            }

            if (world instanceof ServerLevel _levelxxxxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                  .spawn(_levelxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setXRot(-0.2F);
                  entityToSpawn.setDeltaMovement(0.0, 0.0, -0.1);
               }
            }

            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               if (entity instanceof Player _player) {
                  ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_WORM_GRUB.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
               }
            }
         }
      }
   }
}
