package net.arphex.potion;

import java.util.function.Consumer;
import net.arphex.procedures.ChaosControlledEffectExpiresProcedure;
import net.arphex.procedures.ChaosTargetActiveTickConditionProcedure;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

public class ChaosTargetMobEffect extends MobEffect {
   public ChaosTargetMobEffect() {
      super(MobEffectCategory.HARMFUL, -10092442);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      ChaosTargetActiveTickConditionProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      ChaosControlledEffectExpiresProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }

   public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
      consumer.accept(
         new IClientMobEffectExtensions() {
            public boolean isVisibleInInventory(MobEffectInstance effect) {
               return false;
            }

            public boolean renderInventoryText(
               MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset
            ) {
               return false;
            }

            public boolean isVisibleInGui(MobEffectInstance effect) {
               return false;
            }
         }
      );
   }
}
