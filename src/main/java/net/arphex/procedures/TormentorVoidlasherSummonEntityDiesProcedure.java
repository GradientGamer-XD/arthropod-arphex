package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorVoidlasherSummonEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
      if (sourceentity != null) {
         if (sourceentity != null && sourceentity instanceof Player && ArphexModVariables.MapVariables.get(world).tormentor_health > 5.0) {
            if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Killing it damaged the TORMENTOR!"), true);
            }

            if (!world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true).isEmpty()
               && world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                  != null) {
               Entity var9 = world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (var9 instanceof LivingEntity _entity) {
                  _entity.removeEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get());
               }

               world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 700.0, 700.0, 700.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null)
                  .hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), sourceentity), 100.0F
                  );
            }
         }
      }
   }
}
