package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BlockingEffectOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:impact_projectiles")))
            || entityiterator instanceof BloodProjectileEntity
            || entityiterator instanceof WebbedArrowEntity) {
            entityiterator.setDeltaMovement(new Vec3(0.0, -0.2, 0.0));
         }
      }
   }
}
