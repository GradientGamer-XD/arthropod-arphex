package net.arphex.procedures;

import net.arphex.entity.TormentorLowDisplayAnimEntity;
import net.arphex.init.ArphexModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class TormentorScareProceed3Procedure {
   public static Entity execute(LevelAccessor world) {
      return world instanceof Level _level
         ? new TormentorLowDisplayAnimEntity((EntityType<TormentorLowDisplayAnimEntity>)ArphexModEntities.TORMENTOR_LOW_DISPLAY_ANIM.get(), _level)
         : null;
   }
}
