package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.RushScareEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class PureStalkingOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((double)world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1.0, z)) >= 0.3) {
            entity.setShiftKeyDown(true);
         } else {
            entity.setShiftKeyDown(false);
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }

            Entity _wgl = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (_wgl instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 50, 1, false, false));
            }
         }

         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
            && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 35.0, 35.0, 35.0), e -> true).isEmpty()) {
            if (entity instanceof Mob _entity) {
               _entity.getNavigation().stop();
            }

            entity.lookAt(
               Anchor.EYES,
               new Vec3(
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                  world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
               )
            );
         }

         ArphexMod.queueServerWork(1000, () -> {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         });
         if (Mth.nextInt(RandomSource.create(), 1, 160) == 5 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2, false, false));
         }

         if (!world.getEntitiesOfClass(RushScareEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 10 && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (entity.isInWater() && !entity.level().isClientSide()) {
            entity.discard();
         }

         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true).isEmpty()
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
               && entity.getPersistentData().getBoolean("spawnedaway")
               && ((ArphexModVariables.PlayerVariables)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .mothsurvivals
                  >= 5.0
               && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

         entity.setCustomName(Component.literal(""));
      }
   }
}
