package net.arphex.init;

import net.arphex.enchantment.WitherAuraEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModEnchantments {
   public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, "arphex");
   public static final RegistryObject<Enchantment> WITHER_AURA = REGISTRY.register("wither_aura", () -> new WitherAuraEnchantment());
}
