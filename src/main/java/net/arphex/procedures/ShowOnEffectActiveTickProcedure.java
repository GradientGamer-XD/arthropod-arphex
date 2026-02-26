package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class ShowOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.getY() > 175.0) {
            if (world.isClientSide()) {
               Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack((ItemLike)ArphexModItems.SNATCHER_POPUP.get()));
            }
         } else if (entity.getY() > 90.0) {
            if (world.isClientSide()) {
               Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack((ItemLike)ArphexModItems.EVICTOR_POPUP.get()));
            }
         } else if (world.isClientSide()) {
            Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack((ItemLike)ArphexModItems.SPIDER_MOTH_SUMMONER.get()));
         }
      }
   }
}
