package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;

public class SpiderFlatOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("climbradius", 1.05);
         ArphexMod.queueServerWork(
            2,
            () -> {
               if (entity instanceof TamableAnimal _tamEntx
                  && _tamEntx.isTame()
                  && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null) {
                  entity.hurt(
                     new DamageSource(
                        world.registryAccess()
                           .registryOrThrow(Registries.DAMAGE_TYPE)
                           .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment"))),
                        entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null
                     ),
                     1.0F
                  );
               }
            }
         );
      }
   }
}
