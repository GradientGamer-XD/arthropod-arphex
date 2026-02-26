package net.arphex.procedures;

import net.minecraft.world.entity.Entity;

public class FormicFireblasterRightclickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("usingff", true);
      }
   }
}
