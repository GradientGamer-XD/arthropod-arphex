package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GenesisShotWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         double limit_lines = 0.0;
         double smoothen_line = 0.0;
         double source_distance = 0.0;
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle arphex:entropy_glow ~ ~ ~ 0 0 0 0 2 force"
               );
         }

         smoothen_line = 0.0;

         for (int index0 = 0; index0 < 10; index0++) {
            if ((immediatesourceentity.getPersistentData().getDouble("prev_x") != 0.0 || immediatesourceentity.getPersistentData().getDouble("prev_z") != 0.0)
               && world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL,
                           new Vec3(
                              immediatesourceentity.getPersistentData().getDouble("prev_x")
                                 + (immediatesourceentity.getX() - immediatesourceentity.getPersistentData().getDouble("prev_x")) * smoothen_line,
                              immediatesourceentity.getPersistentData().getDouble("prev_y")
                                 + (immediatesourceentity.getY() - immediatesourceentity.getPersistentData().getDouble("prev_y")) * smoothen_line,
                              immediatesourceentity.getPersistentData().getDouble("prev_z")
                                 + (immediatesourceentity.getZ() - immediatesourceentity.getPersistentData().getDouble("prev_z")) * smoothen_line
                           ),
                           Vec2.ZERO,
                           _level,
                           4,
                           "",
                           Component.literal(""),
                           _level.getServer(),
                           null
                        )
                        .withSuppressedOutput(),
                     "particle arphex:entropy_glow ~ ~ ~ 0 0 0 0 1 force"
                  );
            }

            smoothen_line += 0.1;
         }

         immediatesourceentity.getPersistentData().putDouble("prev_x", immediatesourceentity.getX());
         immediatesourceentity.getPersistentData().putDouble("prev_y", immediatesourceentity.getY());
         immediatesourceentity.getPersistentData().putDouble("prev_z", immediatesourceentity.getZ());
         if (immediatesourceentity.getPersistentData().getDouble("deltalockx") == 0.0) {
            immediatesourceentity.getPersistentData().putDouble("deltalockx", immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("deltalocky", immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("deltalockz", immediatesourceentity.getDeltaMovement().z());
         } else {
            immediatesourceentity.setDeltaMovement(
               new Vec3(
                  immediatesourceentity.getPersistentData().getDouble("deltalockx"),
                  immediatesourceentity.getPersistentData().getDouble("deltalocky"),
                  immediatesourceentity.getPersistentData().getDouble("deltalockz")
               )
            );
         }

         if (entity instanceof DiabolosDecimatorEntity) {
            immediatesourceentity.getPersistentData().putDouble("lifetime_track", immediatesourceentity.getPersistentData().getDouble("lifetime_track") + 1.0);
            if (immediatesourceentity.getPersistentData().getDouble("lifetime_track") > 80.0 && !immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }

            if (immediatesourceentity.getPersistentData().getDouble("lifetime_track") % 12.0 == 0.0) {
               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
                  if (!immediatesourceentity.level().isClientSide()) {
                     immediatesourceentity.discard();
                  }
               } else if (Math.sqrt(
                     (entity.getX() - (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX())
                           * (entity.getX() - (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX())
                        + (entity.getY() - (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY())
                           * (entity.getY() - (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY())
                        + (entity.getZ() - (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ())
                           * (entity.getZ() - (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ())
                  )
                  > Math.sqrt(
                     (entity.getX() - immediatesourceentity.getX()) * (entity.getX() - immediatesourceentity.getX())
                        + (entity.getY() - immediatesourceentity.getY()) * (entity.getY() - immediatesourceentity.getY())
                        + (entity.getZ() - immediatesourceentity.getZ()) * (entity.getZ() - immediatesourceentity.getZ())
                  )) {
                  source_distance = Math.sqrt(
                     (immediatesourceentity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxx.getTarget() : null).getX())
                           * (immediatesourceentity.getX() - (entity instanceof Mob _mobEntxxxxxxxxxxx ? _mobEntxxxxxxxxxxx.getTarget() : null).getX())
                        + (immediatesourceentity.getY() - (entity instanceof Mob _mobEntxxxxxxxxxx ? _mobEntxxxxxxxxxx.getTarget() : null).getY())
                           * (immediatesourceentity.getY() - (entity instanceof Mob _mobEntxxxxxxxxx ? _mobEntxxxxxxxxx.getTarget() : null).getY())
                        + (immediatesourceentity.getZ() - (entity instanceof Mob _mobEntxxxxxxxx ? _mobEntxxxxxxxx.getTarget() : null).getZ())
                           * (immediatesourceentity.getZ() - (entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null).getZ())
                  );
                  immediatesourceentity.getPersistentData()
                     .putDouble(
                        "deltalockx",
                        ((entity instanceof Mob _mobEntxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxx.getTarget() : null).getX() - immediatesourceentity.getX())
                           / source_distance
                           * 2.0
                     );
                  immediatesourceentity.getPersistentData()
                     .putDouble(
                        "deltalocky",
                        ((entity instanceof Mob _mobEntxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxx.getTarget() : null).getY() + 2.0 - immediatesourceentity.getY())
                           / source_distance
                           * 2.0
                     );
                  immediatesourceentity.getPersistentData()
                     .putDouble(
                        "deltalockz",
                        ((entity instanceof Mob _mobEntxxxxxxxxxxxxxxx ? _mobEntxxxxxxxxxxxxxxx.getTarget() : null).getZ() - immediatesourceentity.getZ())
                           / source_distance
                           * 2.0
                     );
               }
            }
         }

         if (immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")
            && !entity.getStringUUID().equals(immediatesourceentity.getPersistentData().getString("uuid_compare_source"))) {
            source_distance = Math.sqrt(
               (immediatesourceentity.getX() - entity.getX()) * (immediatesourceentity.getX() - entity.getX())
                  + (immediatesourceentity.getY() - entity.getY()) * (immediatesourceentity.getY() - entity.getY())
                  + (immediatesourceentity.getZ() - entity.getZ()) * (immediatesourceentity.getZ() - entity.getZ())
            );
            if (source_distance != 0.0) {
               immediatesourceentity.getPersistentData().putDouble("deltalockx", (entity.getX() - immediatesourceentity.getX()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("deltalocky", (entity.getY() - immediatesourceentity.getY()) / source_distance * 2.0);
               immediatesourceentity.getPersistentData().putDouble("deltalockz", (entity.getZ() - immediatesourceentity.getZ()) / source_distance * 2.0);
            }
         }

         for (Entity entityiterator : new ArrayList(world.players())) {
            if (immediatesourceentity.getX() + 400.0 > entityiterator.getX()
               && immediatesourceentity.getX() - 400.0 < entityiterator.getX()
               && immediatesourceentity.getZ() + 400.0 > entityiterator.getZ()
               && immediatesourceentity.getZ() - 400.0 < entityiterator.getZ()) {
               double _setval = 5.0;
               entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.sphere_near = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
            }
         }

         immediatesourceentity.setNoGravity(true);
         ArphexMod.queueServerWork(400, () -> {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         });
         ArphexMod.queueServerWork(5, () -> {
            if (!immediatesourceentity.getPersistentData().getBoolean("sparktime_particles")) {
               immediatesourceentity.getPersistentData().putBoolean("sparktime_particles", true);
            }
         });
         if (immediatesourceentity.getPersistentData().getBoolean("sparktime_particles")) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiteratorx instanceof LivingEntity
                  && !(entityiteratorx instanceof ArmorStand)
                  && !(entityiteratorx instanceof Player)
                  && entityiteratorx != entity) {
                  if (entityiteratorx instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorx;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                           continue;
                        }
                     }
                  }

                  ArphexMod.queueServerWork(10, () -> {
                     if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1, false, false));
                     }
                  });
               }
            }
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle arphex:heavy_gold_smoke ~ ~ ~ 0 0 0 1 0 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle smoke ~ ~ ~ 0.2 0.2 0.2 0.4 5 force"
               );
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(
                        CommandSource.NULL,
                        new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()),
                        Vec2.ZERO,
                        _level,
                        4,
                        "",
                        Component.literal(""),
                        _level.getServer(),
                        null
                     )
                     .withSuppressedOutput(),
                  "particle smoke ~ ~ ~ 0.2 0.2 0.2 0.4 5 force"
               );
         }

         ArphexMod.queueServerWork(
            5,
            () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(
                              CommandSource.NULL,
                              new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()),
                              Vec2.ZERO,
                              _levelx,
                              4,
                              "",
                              Component.literal(""),
                              _levelx.getServer(),
                              null
                           )
                           .withSuppressedOutput(),
                        "particle arphex:heavy_smoke ~ ~ ~ 0.2 0.2 0.2 0.4 5 force"
                     );
               }
            }
         );
      }
   }
}
