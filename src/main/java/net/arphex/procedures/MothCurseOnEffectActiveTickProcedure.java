package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class MothCurseOnEffectActiveTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Player _playerHasItemx
               && _playerHasItemx.getInventory().contains(new ItemStack((ItemLike)ArphexModItems.BANE_OF_THE_DARKNESS.get()))
            || entity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack((ItemLike)ArphexModItems.ABYSS_ASCENDANT.get()))
            )
          {
            return;
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20, 0, false, false));
         }

         if (entity.getPersistentData().getDouble("shake") > 0.0) {
            entity.getPersistentData().putDouble("shake", entity.getPersistentData().getDouble("shake") + 1.0);
            if (entity.getPersistentData().getDouble("shake") > 100.0) {
               entity.getPersistentData().putDouble("shake", (double)Mth.nextInt(RandomSource.create(), 1, 20));
            }
         } else {
            entity.getPersistentData().putDouble("shake", (double)Mth.nextInt(RandomSource.create(), 1, 20));
         }

         if (entity.getPersistentData().getDouble("shake") < 14.0) {
            entity.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -2.0, 2.0)));
            entity.setXRot((float)((double)entity.getXRot() + Mth.nextDouble(RandomSource.create(), -2.0, 2.0)));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity _entity) {
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }
      }
   }
}
