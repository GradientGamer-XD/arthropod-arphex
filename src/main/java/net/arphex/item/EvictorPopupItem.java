package net.arphex.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class EvictorPopupItem extends Item {
   public EvictorPopupItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }
}
