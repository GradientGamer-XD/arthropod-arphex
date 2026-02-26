package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.CentipedeEvictorEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TinyCentipedeBreacherOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("arphex", true);
         if (entity.isInWall()) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute as @e[type=arphex:tiny_centipede_breacher,limit=1,sort=nearest] run data merge entity @s {Invulnerable:1}"
                  );
            }
         } else if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "execute as @e[type=arphex:tiny_centipede_breacher,limit=1,sort=nearest] run data merge entity @s {Invulnerable:0}"
               );
         }

         if (entity instanceof Mob _entity) {
            Entity var12 = world.getEntitiesOfClass(CentipedeEvictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((var12 instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _ent) {
               _entity.setTarget(_ent);
            }
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            entity.lookAt(
               Anchor.EYES,
               new Vec3(
                  (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getX(),
                  (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getY(),
                  (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
               )
            );
         }

         if (entity.getDeltaMovement().y() > 0.9) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.0, entity.getDeltaMovement().z()));
         }
      }
   }
}
