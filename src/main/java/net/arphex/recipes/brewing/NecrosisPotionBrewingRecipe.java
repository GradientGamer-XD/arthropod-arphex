package net.arphex.recipes.brewing;

import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModPotions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class NecrosisPotionBrewingRecipe implements IBrewingRecipe {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(new NecrosisPotionBrewingRecipe()));
   }

   public boolean isInput(ItemStack input) {
      Item inputItem = input.getItem();
      return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION)
         && PotionUtils.getPotion(input) == Potions.WATER;
   }

   public boolean isIngredient(ItemStack ingredient) {
      return Ingredient.of(new ItemStack[]{new ItemStack((ItemLike)ArphexModItems.NECROTIC_FANG.get())}).test(ingredient);
   }

   public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
      return this.isInput(input) && this.isIngredient(ingredient)
         ? PotionUtils.setPotion(new ItemStack(input.getItem()), (Potion)ArphexModPotions.POTION_OF_NECROSIS.get())
         : ItemStack.EMPTY;
   }
}
