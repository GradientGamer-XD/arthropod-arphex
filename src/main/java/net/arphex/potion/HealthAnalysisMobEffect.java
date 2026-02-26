package net.arphex.potion;

import java.util.function.Consumer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

public class HealthAnalysisMobEffect extends MobEffect {
   public HealthAnalysisMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }

   public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
      consumer.accept(new IClientMobEffectExtensions() {
         public boolean isVisibleInGui(MobEffectInstance effect) {
            return false;
         }
      });
   }
}
