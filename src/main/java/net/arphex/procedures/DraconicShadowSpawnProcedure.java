package net.arphex.procedures;

import net.arphex.network.ArphexModVariables;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DraconicShadowSpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()) {
            entity.getPersistentData().putBoolean("spawnedaway", false);
         } else {
            entity.getPersistentData().putBoolean("spawnedaway", true);
         }

         if (Mth.nextInt(RandomSource.create(), 1, 10) == 5) {
            ArphexModVariables.MapVariables.get(world).clonesize = Mth.nextDouble(RandomSource.create(), 8.0, 40.0);
            ArphexModVariables.MapVariables.get(world).syncData(world);
         } else {
            ArphexModVariables.MapVariables.get(world).clonesize = Mth.nextDouble(RandomSource.create(), 8.0, 12.0);
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, Mth.nextInt(RandomSource.create(), -6, 4), true, false));
         }
      }
   }
}
