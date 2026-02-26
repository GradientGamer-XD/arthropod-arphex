package net.arphex.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class SnatcherPopupItem extends Item {
   public SnatcherPopupItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }
}
