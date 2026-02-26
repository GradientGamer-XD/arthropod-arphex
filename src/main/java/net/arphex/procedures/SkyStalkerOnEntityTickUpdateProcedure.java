package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkyStalkerOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
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

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 1.0, 1.0, 1.0, 1.0);
               }

               if (world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "tp @e[type=arphex:spider_moth,limit=1,sort=nearest] @p"
                     );
               }
            }

            if ((
                  entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())
                     || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()
               )
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
               if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())
                  || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getPersistentData().getBoolean("creativespectator")) {
                  if (Mth.nextInt(RandomSource.create(), 1, 10) == 5) {
                     entity.setDeltaMovement(
                        new Vec3(
                           Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / (double)Mth.nextInt(RandomSource.create(), 60, 300))) / 2.0,
                           0.1,
                           Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                        )
                     );
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 20, 1, false, false));
                  }

                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(
                     Anchor.EYES,
                     new Vec3(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     )
                  );
               }

               if (entity.getY()
                  > world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z)).findFirst().orElse(null).getY() + 2.0) {
                  entity.setDeltaMovement(new Vec3(0.0, -3.0, 0.0));
               }
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
               && (
                  !world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 2.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 3.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 4.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 5.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 6.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 7.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 8.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 9.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 10.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 11.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 12.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 13.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 14.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y - 15.0, z))
               )) {
               if (entity instanceof Mob _entity) {
                  _entity.getNavigation().stop();
               }

               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / Mth.nextDouble(RandomSource.create(), 1.0, 2.0),
                     0.3,
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.5
                  )
               );
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()) {
               if (entity instanceof Mob _entity) {
                  _entity.getNavigation()
                     .moveTo(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                        1.0
                     );
               }

               if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null).getY() + 15.0 < entity.getY()) {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.5,
                        -0.1,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.5
                     )
                  );
               } else {
                  entity.setDeltaMovement(
                     new Vec3(
                        Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.5,
                        0.1,
                        Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 1.5
                     )
                  );
               }
            }

            if ((
                  !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
                     || !world.isEmptyBlock(BlockPos.containing(x + 1.0, y, z))
                     || !world.isEmptyBlock(BlockPos.containing(x - 1.0, y, z))
                     || !world.isEmptyBlock(BlockPos.containing(x, y, z - 1.0))
                     || !world.isEmptyBlock(BlockPos.containing(x, y, z + 1.0))
               )
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()
               && !entity.level().isClientSide()) {
               entity.discard();
            }

            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).isEmpty()) {
               entity.lookAt(
                  Anchor.EYES,
                  new Vec3(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX() + (double)Mth.nextInt(RandomSource.create(), -70, 70),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300.0, 300.0, 300.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                  )
               );
               entity.setDeltaMovement(
                  new Vec3(
                     Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0,
                     0.0,
                     Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 2.0
                  )
               );
            }

            if (Mth.nextInt(RandomSource.create(), 1, 400) == 5
               && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()
               && world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                     ),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothambient")),
                     SoundSource.HOSTILE,
                     1.0F,
                     (float)Mth.nextDouble(RandomSource.create(), 0.7, 1.1)
                  );
               } else {
                  _level.playLocalSound(
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                     world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ(),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:spidermothambient")),
                     SoundSource.HOSTILE,
                     1.0F,
                     (float)Mth.nextDouble(RandomSource.create(), 0.7, 1.1),
                     false
                  );
               }
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70.0, 70.0, 70.0), e -> true).isEmpty()) {
               entity.setShiftKeyDown(true);
            } else {
               entity.setShiftKeyDown(false);
            }

            if (entity.isInWater() && !entity.level().isClientSide()) {
               entity.discard();
            }
         }
      }
   }
}
