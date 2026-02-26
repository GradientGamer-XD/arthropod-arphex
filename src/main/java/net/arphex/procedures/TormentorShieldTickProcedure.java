package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TormentorShieldEntity;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.TormentorTendrilEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TormentorShieldTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double ringspan = 0.0;
         double ringspin = 0.0;
         boolean scansnearestfirst = false;
         boolean onecheck = false;
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

         entity.getPersistentData().putBoolean("tormentor_summon", true);
         if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
            if (entity instanceof TormentorShieldEntity _datEntSetI) {
               _datEntSetI.getEntityData().set(TormentorShieldEntity.DATA_growsize, 10);
            }
         } else if (entity instanceof TormentorShieldEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(TormentorShieldEntity.DATA_growsize, 14);
         }

         if (entity.isAlive()) {
            if (!entity.getPersistentData().getBoolean("donepos")) {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(500.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (!onecheck
                     && entityiterator.getPersistentData().getBoolean("tormentor_target")
                     && !(
                        ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .tormentor_respite
                           > 0.0
                     )) {
                     if (!world.isClientSide()) {
                        entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() - 2.0, entityiterator.getZ()));
                     }

                     entity.getPersistentData().putDouble("targety", entityiterator.getY());
                     onecheck = true;
                     break;
                  }
               }

               if (!onecheck && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            entity.getPersistentData().putBoolean("donepos", true);
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
                     "tp @s ^ ^ ^" + (1.2 + ArphexModVariables.MapVariables.get(world).tormentor_tier / 3.5)
                  );
            }

            if (!(entity.getPersistentData().getDouble("spherelim") > 0.0)) {
               entity.getPersistentData().putDouble("spherelim", 10.0);
               Vec3 _center = new Vec3(x, y, z);

               TormentorShieldEntity _datEntI;
               for (Entity entityiteratorx : world.getEntitiesOfClass(
                     Entity.class,
                     new AABB(_center, _center)
                        .inflate(
                           (double)(
                                 5
                                    + Math.round(
                                       entity instanceof TormentorShieldEntity _datEntI
                                          ? (float)((Integer)_datEntI.getEntityData().get(TormentorShieldEntity.DATA_growsize)).intValue()
                                          : 0.0F
                                    )
                              )
                              / 2.0
                        ),
                     e -> true
                  )
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx instanceof LivingEntity
                     && !(entityiteratorx instanceof TormentorSphereEntity)
                     && !entityiteratorx.getPersistentData().getBoolean("tormentor_summon")
                     && !entityiteratorx.getPersistentData().getBoolean("creativespectator")
                     && !(entityiteratorx instanceof TormentorTendrilEntity)
                     && !(entityiteratorx instanceof TORMENTOREntity)) {
                     entityiteratorx.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 8.0F
                     );
                     entityiteratorx.setDeltaMovement(new Vec3(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z));
                  }
               }
            } else {
               entity.getPersistentData().putDouble("spherelim", entity.getPersistentData().getDouble("spherelim") - 1.0);
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

         ArphexMod.queueServerWork(400, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1.0, entity.getZ())).canOcclude()) {
            ArphexMod.queueServerWork(20, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.DEATH_SMOKE.get(), x, y, z, 1, 0.0, 0.0, 0.0, 0.1);
               }
            });
         }
      }
   }
}
