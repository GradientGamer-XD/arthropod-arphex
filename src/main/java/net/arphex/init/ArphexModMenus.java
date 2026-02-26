package net.arphex.init;

import net.arphex.world.inventory.BackpackMenu;
import net.arphex.world.inventory.InherentPowersMenu;
import net.arphex.world.inventory.SuperBackpackMenu;
import net.arphex.world.inventory.WayfinderMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModMenus {
   public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "arphex");
   public static final RegistryObject<MenuType<BackpackMenu>> BACKPACK = REGISTRY.register("backpack", () -> IForgeMenuType.create(BackpackMenu::new));
   public static final RegistryObject<MenuType<SuperBackpackMenu>> SUPER_BACKPACK = REGISTRY.register(
      "super_backpack", () -> IForgeMenuType.create(SuperBackpackMenu::new)
   );
   public static final RegistryObject<MenuType<WayfinderMenu>> WAYFINDER = REGISTRY.register("wayfinder", () -> IForgeMenuType.create(WayfinderMenu::new));
   public static final RegistryObject<MenuType<InherentPowersMenu>> INHERENT_POWERS = REGISTRY.register(
      "inherent_powers", () -> IForgeMenuType.create(InherentPowersMenu::new)
   );
}
