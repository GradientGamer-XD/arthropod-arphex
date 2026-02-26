package net.arphex.procedures;

import net.arphex.entity.TormentorFlashAnimEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class TormentorScareProceed2Procedure {
   public static Entity execute(LevelAccessor world) {
      return world instanceof Level _level
         ? new TormentorFlashAnimEntity((EntityType<TormentorFlashAnimEntity>)ArphexModEntities.TORMENTOR_FLASH_ANIM.get(), _level)
         : null;
   }
}
