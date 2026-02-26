package net.arphex.potion;

import java.util.function.Consumer;
import net.arphex.procedures.VoidCooldownOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

public class VoidCooldownMobEffect extends MobEffect {
   public VoidCooldownMobEffect() {
      super(MobEffectCategory.NEUTRAL, -10092442);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      VoidCooldownOnEffectActiveTickProcedure.execute(entity);
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
