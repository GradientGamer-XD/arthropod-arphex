package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ExpandHitboxProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_riding = null;
         if (entity.isPassenger()) {
            if (entity.getVehicle() != null && entity instanceof LivingEntity _entity) {
               _entity.setHealth(entity.getVehicle() instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F);
            }
         } else {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        entity.position(),
                        entity.getRotationVector(),
                        entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                        4,
                        entity.getName().getString(),
                        entity.getDisplayName(),
                        entity.level().getServer(),
                        entity
                     ),
                     "data merge entity @s {NoAI:1}"
                  );
            }

            if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()) {
               entity_riding = world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if (entity_riding instanceof LivingEntity _livEnt9
                  && _livEnt9.hasEffect(MobEffects.INVISIBILITY)
                  && entity instanceof LivingEntity _entity
                  && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0, false, false));
               }

               if (entity_riding.isVehicle()) {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else {
                  entity.startRiding(entity_riding);
               }
            }

            ArphexMod.queueServerWork(2, () -> {
               if (!entity.isPassenger() && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }
      }
   }
}
