package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothSummonEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderMothSummonOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean foundowner = false;
         if ((!(entity instanceof LivingEntity _livEnt0) || !_livEnt0.hasEffect(MobEffects.REGENERATION))
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
         }

         if (!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame()) {
            ArphexMod.queueServerWork(20, () -> {
               if ((!(entity instanceof TamableAnimal _tamEntx) || !_tamEntx.isTame()) && !entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         entity.getPersistentData().putDouble("spiderjump", entity.getPersistentData().getDouble("spiderjump") - 1.0);
         if (entity.getPersistentData().getBoolean("hovermode") && entity.isVehicle()) {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         }

         if (entity.onGround()) {
            entity.getPersistentData().putBoolean("hovermode", false);
         }

         if (entity instanceof TamableAnimal _tamEntx
            && _tamEntx.isTame()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
            && entity.getY() + 1.0
               < world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getY()
            && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            if (!world.isClientSide()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     (entity instanceof TamableAnimal _tamEntxxxx ? _tamEntxxxx.getOwner() : null).getX(),
                     (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null).getY(),
                     (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null).getZ()
                  )
               );
            }

            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                  0.6,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
            > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
            if (entity instanceof SpiderMothSummonEntity animatable) {
               animatable.setTexture("fullshadow");
            }
         } else if (entity instanceof SpiderMothSummonEntity animatable) {
            animatable.setTexture("horrormothlowhealthfixed");
         }

         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getBoolean("noai_reset") && !entity.level().isClientSide() && entity.getServer() != null) {
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
                  "data modify entity @s NoAI set value 0b"
               );
         }

         if (entity.isVehicle()) {
            entity.getFirstPassenger().fallDistance = 0.0F;
            if (!(entity instanceof TamableAnimal _tamIsTamedBy)
               || !(entity.getFirstPassenger() instanceof LivingEntity _livEntxx)
               || !_tamIsTamedBy.isOwnedBy(_livEntxx)) {
               entity.getFirstPassenger().stopRiding();
            }
         } else if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
            && entity.getY() + 1.0 < (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY()) {
            entity.getPersistentData().putBoolean("noai_reset", true);
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
                     "data modify entity @s NoAI set value 1b"
                  );
            }

            if (!world.isClientSide()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX(),
                     (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY(),
                     (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ()
                  )
               );
            }

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
                     "data modify entity @s NoAI set value 0b"
                  );
            }

            entity.getPersistentData().putBoolean("noai_reset", false);
            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                  0.3,
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
               )
            );
         }

         entity.setMaxUpStep(1.5F);
         if (entity instanceof TamableAnimal _tamEntxx
            && _tamEntxx.isTame()
            && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) != null
            && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null)
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var29) {
               var29.printStackTrace();
            }
         }

         if (!(entity.getPersistentData().getDouble("mothownercheck") > 0.0)) {
            foundowner = false;
            entity.getPersistentData().putDouble("mothownercheck", 20.0);
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null) {
                  if ((entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) == entityiterator) {
                     foundowner = true;
                  }

                  if (entityiterator instanceof SpiderMothSummonEntity
                     && entityiterator != entity
                     && entityiterator instanceof TamableAnimal _tamIsTamedBy
                     && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) instanceof LivingEntity _livEntxx
                     && _tamIsTamedBy.isOwnedBy(_livEntxx)
                     && entity.getX() < entityiterator.getX()
                     && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }

            if (!foundowner) {
               if (entity instanceof LivingEntity _livEnt90 && _livEnt90.hasEffect(MobEffects.UNLUCK) && !entity.level().isClientSide()) {
                  entity.discard();
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 30, 0, false, false));
               }
            }
         } else {
            entity.getPersistentData().putDouble("mothownercheck", entity.getPersistentData().getDouble("mothownercheck") - 1.0);
         }

         if (entity.isAlive()
            && entity instanceof TamableAnimal _tamEntx
            && _tamEntx.isTame()
            && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) != null) {
            double _setval = 160.0;
            (entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null)
               .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .ifPresent(capability -> {
                  capability.moth_summon_active = _setval;
                  capability.syncPlayerVariables(entity instanceof TamableAnimal _tamEntxx ? _tamEntxx.getOwner() : null);
               });
            double var84 = _setval = entity instanceof LivingEntity _livEntxx ? (double)_livEntxx.getHealth() : -1.0;
            (entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null)
               .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
               .ifPresent(capability -> {
                  capability.smshealth = _setval;
                  capability.syncPlayerVariables(entity instanceof TamableAnimal _tamEntxxx ? _tamEntxxx.getOwner() : null);
               });
         }

         Vec3 motion = entity.getDeltaMovement();
         if (motion.x != 0.0 || motion.y != 0.0 || motion.z != 0.0) {
            boolean inCobweb = false;
            AABB box = entity.getBoundingBox();
            Level lvl = entity.level();
            double minX = box.minX;
            double minY = box.minY;
            double minZ = box.minZ;
            double maxX = box.maxX;
            double maxY = box.maxY;
            double maxZ = box.maxZ;

            for (int bx = (int)Math.floor(minX); bx <= (int)Math.floor(maxX); bx++) {
               for (int by = (int)Math.floor(minY); by <= (int)Math.floor(maxY); by++) {
                  for (int bz = (int)Math.floor(minZ); bz <= (int)Math.floor(maxZ); bz++) {
                     BlockState state = lvl.getBlockState(new BlockPos(bx, by, bz));
                     if (state.getBlock() == Blocks.COBWEB
                        && (double)(bx + 1) > minX
                        && (double)bx < maxX
                        && (double)(by + 1) > minY
                        && (double)by < maxY
                        && (double)(bz + 1) > minZ
                        && (double)bz < maxZ) {
                        inCobweb = true;
                        entity.makeStuckInBlock(state, new Vec3(2.0, 3.0, 2.0));
                        break;
                     }
                  }

                  if (inCobweb) {
                     break;
                  }
               }

               if (inCobweb) {
                  break;
               }
            }
         }
      }
   }
}
