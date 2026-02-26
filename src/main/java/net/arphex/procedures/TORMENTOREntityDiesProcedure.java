package net.arphex.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TORMENTOREntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (ArphexModVariables.MapVariables.get(world).tormentor_health <= 5.0 && !(ArphexModVariables.MapVariables.get(world).tormentor_seal_limit > 0.0)) {
         ArphexModVariables.MapVariables.get(world).tormentor_seal_limit = 2000.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).tormentor_health = 0.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded = 24000.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "weather clear"
               );
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "tellraw @a {\"text\":\"THE TORMENTOR AVATAR HAS BEEN DESTROYED, DROPPING A CORE OF SUFFERING\",\"bold\":true,\"color\":\"red\"}"
                  );
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "tellraw @a {\"text\":\"THE TIER 2 TORMENTOR AVATAR HAS BEEN DESTROYED, DROPPING TWO CORES OF SUFFERING\",\"bold\":true,\"color\":\"red\"}"
                  );
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "tellraw @a {\"text\":\"THE TIER 3 TORMENTOR AVATAR HAS BEEN DESTROYED, DROPPING TWO CORES OF SUFFERING\",\"bold\":true,\"color\":\"red\"}"
                  );
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "tellraw @a {\"text\":\"THE TIER 4 TORMENTOR AVATAR HAS BEEN DESTROYED, DROPPING TWO CORES OF SUFFERING\",\"bold\":true,\"color\":\"red\"}"
                  );
            }
         } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0 && world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "tellraw @a {\"text\":\"THE TIER 5 TORMENTOR AVATAR HAS BEEN DESTROYED, DROPPING TWO CORES OF SUFFERING\",\"bold\":true,\"color\":\"red\"}"
               );
         }

         for (int index0 = 0; index0 < 10; index0++) {
            ArphexMod.queueServerWork(
               Mth.nextInt(RandomSource.create(), 1, 400),
               () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "particle arphex:death_smoke ~ ~ ~ 5 5 5 0 50 force"
                        );
                  }

                  ArphexMod.queueServerWork(
                     Mth.nextInt(RandomSource.create(), 1, 400),
                     () -> {
                        if (world instanceof ServerLevel _levelx) {
                           _levelx.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:huge_fire ~ ~ ~ 5 5 5 0 50 force"
                              );
                        }
                     }
                  );
               }
            );
         }

         for (Entity entityiterator : new ArrayList(world.players())) {
            double _setval = 12000.0;
            entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
               capability.tormentorjustdiednearby = _setval;
               capability.syncPlayerVariables(entityiterator);
            });
            if (entityiterator.getPersistentData().getBoolean("tormentor_target")) {
               for (int index1 = 0; index1 < 300; index1++) {
                  ArphexMod.queueServerWork(
                     Mth.nextInt(RandomSource.create(), 1, 1200),
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(
                              (SimpleParticleType)ArphexModParticleTypes.GOLDEN_OPAL.get(),
                              entityiterator.getX(),
                              entityiterator.getY(),
                              entityiterator.getZ(),
                              200,
                              0.5,
                              0.5,
                              0.5,
                              1.0
                           );
                        }
                     }
                  );
               }

               if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 4, false, true));
               }

               if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get(), 1200, 9, false, true));
               }

               if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) {
                  _setval = ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedtormentor
                     + 1.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.killedtormentor = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer()
                        .getPlayerList()
                        .broadcastSystemMessage(Component.literal("§c§lTORMENTOR kill registered for " + entityiterator.getDisplayName().getString()), false);
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 2.0) {
                  _setval = ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedtormentor
                     + 2.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.killedtormentor = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer()
                        .getPlayerList()
                        .broadcastSystemMessage(Component.literal("§c§l2 TORMENTOR kills registered for " + entityiterator.getDisplayName().getString()), false);
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 3.0) {
                  _setval = ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedtormentor
                     + 3.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.killedtormentor = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer()
                        .getPlayerList()
                        .broadcastSystemMessage(Component.literal("§c§l3 TORMENTOR kills registered for " + entityiterator.getDisplayName().getString()), false);
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 4.0) {
                  _setval = ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedtormentor
                     + 4.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.killedtormentor = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer()
                        .getPlayerList()
                        .broadcastSystemMessage(Component.literal("§c§l4 TORMENTOR kills registered for " + entityiterator.getDisplayName().getString()), false);
                  }
               } else if (ArphexModVariables.MapVariables.get(world).tormentor_tier == 5.0) {
                  _setval = ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedtormentor
                     + 5.0;
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.killedtormentor = _setval;
                     capability.syncPlayerVariables(entityiterator);
                  });
                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof ServerLevel _level) {
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     entityToSpawn.setUnlimitedLifetime();
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (!world.isClientSide() && world.getServer() != null) {
                     world.getServer()
                        .getPlayerList()
                        .broadcastSystemMessage(Component.literal("§c§l5 TORMENTOR kills registered for " + entityiterator.getDisplayName().getString()), false);
                  }
               }
            }
         }

         if (world instanceof ServerLevel _level) {
            LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
            entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
            entityToSpawn.setVisualOnly(true);
            _level.addFreshEntity(entityToSpawn);
         }

         ArphexMod.queueServerWork(
            60,
            () -> {
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                     .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               ArphexMod.queueServerWork(
                  2,
                  () -> {
                     if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                        Entity patt15431$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt15431$temp instanceof SphereAnimEntity _datEntSetS) {
                           _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "black");
                        }

                        patt15431$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt15431$temp instanceof SphereAnimEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_max_size, 8000);
                        }
                     }

                     ArphexMod.queueServerWork(
                        80,
                        () -> {
                           if (world instanceof ServerLevel _levelx) {
                              Entity entityToSpawnx = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                                 .spawn(_levelx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawnx != null) {
                              }
                           }

                           ArphexMod.queueServerWork(
                              2,
                              () -> {
                                 if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true)
                                    .isEmpty()) {
                                    Entity patt16935$temp = world.getEntitiesOfClass(
                                          SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true
                                       )
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y + 1.0, z))
                                       .findFirst()
                                       .orElse(null);
                                    if (patt16935$temp instanceof SphereAnimEntity _datEntSetS) {
                                       _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "white");
                                    }

                                    patt16935$temp = world.getEntitiesOfClass(
                                          SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true
                                       )
                                       .stream()
                                       .sorted((new Object() {
                                          Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                             return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                          }
                                       }).compareDistOf(x, y + 1.0, z))
                                       .findFirst()
                                       .orElse(null);
                                    if (patt16935$temp instanceof SphereAnimEntity _datEntSetIx) {
                                       _datEntSetIx.getEntityData().set(SphereAnimEntity.DATA_max_size, 5000);
                                    }
                                 }
                              }
                           );
                        }
                     );
                  }
               );
            }
         );
      } else {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiteratorx instanceof ItemEntity
               && (entityiteratorx instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()
                  == ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()
               && !entityiteratorx.level().isClientSide()) {
               entityiteratorx.discard();
            }
         }
      }
   }
}
