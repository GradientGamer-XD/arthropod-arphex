package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VoidlasherDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.1);
      }

      ArphexMod.queueServerWork(
         2,
         () -> {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof ItemEntity
                  && (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VOID_GEODE.get()
                  && !entityiterator.level().isClientSide()
                  && entityiterator.getServer() != null) {
                  entityiterator.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                           CommandSource.NULL,
                           entityiterator.position(),
                           entityiterator.getRotationVector(),
                           entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                           4,
                           entityiterator.getName().getString(),
                           entityiterator.getDisplayName(),
                           entityiterator.level().getServer(),
                           entityiterator
                        ),
                        "data merge entity @s {Glowing:1b,Invulnerable:1b}"
                     );
               }
            }
         }
      );
   }
}
