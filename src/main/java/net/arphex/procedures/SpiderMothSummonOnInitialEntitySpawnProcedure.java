package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.entity.TormentorSummonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SpiderMothSummonOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
            entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
            entityToSpawn.setVisualOnly(true);
            _level.addFreshEntity(entityToSpawn);
         }

         if (entity instanceof TormentorSummonEntity) {
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
}
