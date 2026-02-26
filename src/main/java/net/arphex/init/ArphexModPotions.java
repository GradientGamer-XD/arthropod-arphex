package net.arphex.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModPotions {
   public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, "arphex");
   public static final RegistryObject<Potion> POTION_OF_NECROSIS = REGISTRY.register(
      "potion_of_necrosis",
      () -> new Potion(new MobEffectInstance[]{new MobEffectInstance((MobEffect)ArphexModMobEffects.NECROSIS.get(), 3600, 0, false, true)})
   );
}
