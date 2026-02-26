package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.ScorpioidCloneEntity;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ScorpioidCloneTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.isInWall() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 5, false, false));
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) {
            entity.setSprinting(false);
            entity.setShiftKeyDown(false);
         } else if (!(entity.getDeltaMovement().x() > 0.0) && !(entity.getDeltaMovement().z() > 0.0) && !world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))
            )
          {
            entity.setShiftKeyDown(true);
            entity.setSprinting(false);
         } else {
            entity.setShiftKeyDown(false);
            entity.setSprinting(true);
         }

         if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
            label186: {
               if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())) {
                  break label186;
               }

               if (entity.getY() < (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY() + 0.5) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0,
                        0.3,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0
                     )
                  );
               } else {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0,
                        -0.2,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 4.0
                     )
                  );
               }
            }

            if ((entity.getPersistentData().getDouble("tptime") == 5.0 || entity.getPersistentData().getDouble("tptime") == 45.0)
               && world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute at @e[type=arphex:scorpioid_bloodluster,limit=1,sort=nearest] run tp @e[type=arphex:scorpioid_bloodluster,limit=1,sort=nearest] ^ ^0.01 ^0.08"
                  );
            }

            if (entity.getPersistentData().getDouble("tptime") > 0.0) {
               entity.getPersistentData().putDouble("tptime", entity.getPersistentData().getDouble("tptime") - 1.0);
            } else {
               entity.getPersistentData().putDouble("tptime", 80.0);
            }
         }

         if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
            }
         }

         if (world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.3);
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.WITHER);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
         }

         if (!world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()) {
            Entity var24 = world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (!((var24 instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof ScorpioidCloneEntity) && entity instanceof Mob _entity) {
               Entity var13 = world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var13 instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }
         }

         if ((entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof Player
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")
            && entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var14) {
               var14.printStackTrace();
            }
         }

         if (!world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()
            && world.isClientSide()) {
            Entity var26 = world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((var26 instanceof ScorpioidBloodlusterEntity animatable ? animatable.getTexture() : "null").equals("scorpioidbloodluster")) {
               if (entity instanceof ScorpioidCloneEntity animatablex) {
                  animatablex.setTexture("scorpioidbloodluster");
               }

               if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z)) && world instanceof ServerLevel _level) {
                  _level.sendParticles(
                     (SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(),
                     x,
                     y,
                     z,
                     (int)((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) / 2.5),
                     0.8,
                     2.0,
                     0.8,
                     3.0
                  );
               }
            } else {
               if (entity instanceof ScorpioidCloneEntity animatable) {
                  animatable.setTexture("scorpioidbloodluster2");
               }

               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
               }

               if (world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z)) && world instanceof ServerLevel _level) {
                  _level.sendParticles(
                     (SimpleParticleType)ArphexModParticleTypes.SPIDER_BLOOD.get(),
                     x,
                     y,
                     z,
                     (int)((double)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) / 2.5),
                     0.8,
                     2.0,
                     0.8,
                     3.0
                  );
               }
            }
         }
      }
   }
}
