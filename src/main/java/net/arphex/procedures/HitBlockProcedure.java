package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class HitBlockProcedure {
   @SubscribeEvent
   public static void onLeftClickBlock(LeftClickBlock event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(
            event,
            event.getLevel(),
            (double)event.getPos().getX(),
            (double)event.getPos().getY(),
            (double)event.getPos().getZ(),
            event.getLevel().getBlockState(event.getPos()),
            event.getFace(),
            event.getEntity()
         );
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity) {
      execute(null, world, x, y, z, blockstate, direction, entity);
   }

   private static void execute(
      @Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity
   ) {
      if (direction != null && entity != null) {
         boolean dimensioncooldown = false;
         if (blockstate.getBlock() == ArphexModBlocks.INVISIBLE_HALF_SLAB.get() && !world.isClientSide()) {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
         }

         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()
            && (
               !(entity instanceof Player _plrCldCheck7)
                  || !_plrCldCheck7.getCooldowns()
                     .isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())
            )
            && blockstate.getBlock() == Blocks.COBWEB) {
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.COBWEB.defaultBlockState()));
            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 20);
            }
         }

         label719:
         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ATOMISER.get()) {
            if (entity instanceof Player _plrCldCheck17
               && _plrCldCheck17.getCooldowns()
                  .isOnCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem())) {
               break label719;
            }

            if (blockstate.getBlock() == ArphexModBlocks.SCORCH_PILLAR.get() && !world.isClientSide()) {
               world.destroyBlock(BlockPos.containing(x, y, z), false);
               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ArphexModBlocks.SCORCH_PILLAR.get()).defaultBlockState()));
               world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.BARRIER_GAP.get()).defaultBlockState(), 3);
            }

            if (blockstate.getBlock() == ArphexModBlocks.CRAWLING_ALTAR.get() && !world.isClientSide()) {
               world.destroyBlock(BlockPos.containing(x, y, z), false);
               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ArphexModBlocks.CRAWLING_ALTAR.get()).defaultBlockState()));
               world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.BARRIER_GAP.get()).defaultBlockState(), 3);
            }

            if (blockstate.getBlock() == Blocks.BARRIER
               && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                  == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 10, 0.3, 0.3, 0.3, 0.2);
               }

               world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ArphexModBlocks.CRAWLING_BARRIER.get()).defaultBlockState()));
               if (!world.isClientSide()) {
                  world.destroyBlock(BlockPos.containing(x, y, z), false);
                  world.setBlock(BlockPos.containing(x, y, z), ((Block)ArphexModBlocks.BARRIER_GAP.get()).defaultBlockState(), 3);
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns()
                     .addCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
               }
            }
         }

         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ASCENDANT_STAFF.get()) {
            entity.getPersistentData().putDouble("levotime", 200.0);
            entity.getPersistentData().putDouble("oplevx", x);
            entity.getPersistentData().putDouble("oplevy", y);
            entity.getPersistentData().putDouble("oplevz", z);
         }

         label708:
         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ETHEREAL_STAFF.get()) {
            if (entity instanceof Player _plrCldCheck51
               && _plrCldCheck51.getCooldowns()
                  .isOnCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem())) {
               break label708;
            }

            if (entity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect((MobEffect)ArphexModMobEffects.ETHEREAL_CHARGE.get())) {
               if (entity.getPersistentData().getDouble("ethportalx") == 0.0
                  && entity.getPersistentData().getDouble("ethportaly") == 0.0
                  && entity.getPersistentData().getDouble("ethportalz") == 0.0) {
                  if (entity instanceof Player _player) {
                     _player.getCooldowns()
                        .addCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
                  }

                  entity.getPersistentData()
                     .putString("ethdimension", (entity.level().dimension() + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip());
                  entity.getPersistentData().putDouble("ethportalx", x);
                  entity.getPersistentData().putDouble("ethportaly", y);
                  entity.getPersistentData().putDouble("ethportalz", z);
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ETHEREAL_CHARGE.get(), 600, 0, false, false));
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
                           "execute in "
                              + entity.getPersistentData().getString("ethdimension")
                              + " run tp "
                              + entity.getPersistentData().getDouble("ethportalx")
                              + " "
                              + (entity.getPersistentData().getDouble("ethportaly") + 1.0)
                              + " "
                              + entity.getPersistentData().getDouble("ethportalz")
                        );
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GHOST_TELEPORT.get(), x, y, z, 10, 0.4, 0.4, 0.4, 0.3);
                  }
               }
               break label708;
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
            }

            entity.getPersistentData().putDouble("ethportalx", x);
            entity.getPersistentData().putDouble("ethportaly", y);
            entity.getPersistentData().putDouble("ethportalz", z);
            entity.getPersistentData()
               .putString("ethdimension", (entity.level().dimension() + "").replace("ResourceKey[minecraft:dimension / ", "").replace("]", "").strip());
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ETHEREAL_CHARGE.get(), 600, 0, false, false));
            }
         }

         if ((
               (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SILK_SLINGER.get()
                  || (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.TARANTULA_TETHER.get()
            )
            && (
               !(entity instanceof Player _plrCldCheck85)
                  || !_plrCldCheck85.getCooldowns()
                     .isOnCooldown((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem())
            )
            && world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z))
            && world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))) {
            if (entity instanceof Player _player) {
               _player.getCooldowns()
                  .addCooldown((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
            }

            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.WEB_HARNESS_DOWN.get())
                  .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }

         label678:
         if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.FORCE_GAUNTLET.get()
            || (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ArphexModItems.TEMPOROSPATIAL_TRANSMITTER.get()
            || (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.CHAOS_GAUNTLET.get()
               && !entity.isShiftKeyDown()) {
            if (entity instanceof Player _plrCldCheck99
               && _plrCldCheck99.getCooldowns()
                  .isOnCooldown((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem())) {
               break label678;
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns()
                  .addCooldown((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 40);
            }

            if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ArphexModItems.FORCE_GAUNTLET.get()) {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y + 1.0, z, 20, 0.6, 0.4, 0.6, 0.5);
               }
            } else if ((entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ArphexModItems.TEMPOROSPATIAL_TRANSMITTER.get()) {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.TIME_SPLASH_PARTICLE.get(), x, y + 1.0, z, 20, 0.6, 0.4, 0.6, 0.5);
               }
            } else if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y + 1.0, z, 20, 0.6, 0.4, 0.6, 0.5);
            }

            if (world instanceof ServerLevel _levelx) {
               _levelx.sendParticles(ParticleTypes.EXPLOSION, x, y + 1.0, z, 5, 0.4, 0.3, 0.4, 0.5);
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     0.5F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     0.5F,
                     false
                  );
               }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator != entity) {
                  if (x - entityiterator.getX() > 0.0 && z - entityiterator.getZ() > 0.0) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           (0.0 - (x - entityiterator.getX()))
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              ),
                           0.3,
                           (0.0 - (z - entityiterator.getZ()))
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              )
                        )
                     );
                  } else if (x - entityiterator.getX() < 0.0 && z - entityiterator.getZ() < 0.0) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           Math.abs(x - entityiterator.getX())
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              ),
                           0.3,
                           Math.abs(z - entityiterator.getZ())
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              )
                        )
                     );
                  } else if (x - entityiterator.getX() > 0.0 && z - entityiterator.getZ() < 0.0) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           (0.0 - (x - entityiterator.getX()))
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              ),
                           0.3,
                           Math.abs(z - entityiterator.getZ())
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              )
                        )
                     );
                  } else {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           Math.abs(x - entityiterator.getX())
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              ),
                           0.3,
                           (0.0 - (z - entityiterator.getZ()))
                              * (
                                 (double)(300.0F / (200.0F + (entityiterator instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F)))
                                    / 1.5
                              )
                        )
                     );
                  }
               }
            }
         }

         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.CHAOS_GAUNTLET.get()
            && entity.isShiftKeyDown()) {
            if (world instanceof ServerLevel _levelxx) {
               _levelxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "effect clear @e[distance=..40] arphex:chaos_controlled"
                  );
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                           CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelxx, 4, "", Component.literal(""), _levelxx.getServer(), null
                        )
                        .withSuppressedOutput(),
                     "effect clear @e[distance=..40] arphex:chaos_target"
                  );
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 10, 0.4, 0.4, 0.4, 0.2);
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 10, 0.4, 0.4, 0.4, 0.2);
            }
         }

         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSS_ASCENDANT.get()) {
            entity.getPersistentData().putDouble("openhit", 10.0);
         }

         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ASCENDANT_STAFF.get()) {
            entity.getPersistentData().putDouble("openhit", 10.0);
         }

         label638:
         if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ANT_COMMANDER.get()) {
            if (entity instanceof Player _plrCldCheck155
               && _plrCldCheck155.getCooldowns()
                  .isOnCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem())) {
               break label638;
            }

            if (entity.isShiftKeyDown()) {
               entity.getPersistentData().putBoolean("queennearcheck", false);
               if (entity instanceof Player _player) {
                  _player.getCooldowns()
                     .addCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorx instanceof AntArsonistAlateQueenEntity && entityiteratorx instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorx;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEntxxx)) {
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal("Priority area reset for queen"), true);
                              }
                           }

                           entity.getPersistentData().putBoolean("queennearcheck", true);
                           if (entityiteratorx instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(AntArsonistAlateQueenEntity.DATA_Xarea, 0);
                           }

                           if (entityiteratorx instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(AntArsonistAlateQueenEntity.DATA_Yarea, 0);
                           }

                           if (entityiteratorx instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData().set(AntArsonistAlateQueenEntity.DATA_Zarea, 0);
                           }
                        }
                     }
                  }
               }

               if (!entity.getPersistentData().getBoolean("queennearcheck") && entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("No tamed queen nearby (area reset attempted)"), true);
               }
            } else {
               if (entity instanceof Player _player) {
                  _player.getCooldowns()
                     .addCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
               }

               entity.getPersistentData().putBoolean("queennearcheck", false);
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiteratorxx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiteratorxx instanceof AntArsonistAlateQueenEntity && entityiteratorxx instanceof TamableAnimal) {
                     TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiteratorxx;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEntxxx = (LivingEntity)entity;
                        if (_tamIsTamedBy.isOwnedBy(_livEntxxx)) {
                           entity.getPersistentData().putBoolean("queennearcheck", true);
                           if (blockstate.getBlock() == Blocks.STONE) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal("Stone selected for breaking"), true);
                                 }
                              }

                              if (entityiteratorxx instanceof AntArsonistAlateQueenEntity _datEntSetS) {
                                 _datEntSetS.getEntityData().set(AntArsonistAlateQueenEntity.DATA_antcommand, "stone");
                              }
                           } else if (!blockstate.is(BlockTags.create(new ResourceLocation("minecraft:logs")))
                              && !blockstate.is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal("Disabled ant block breaking"), true);
                                 }
                              }

                              if (entityiteratorxx instanceof AntArsonistAlateQueenEntity _datEntSetS) {
                                 _datEntSetS.getEntityData().set(AntArsonistAlateQueenEntity.DATA_antcommand, "none");
                              }
                           } else {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal("Logs/leaves selected for breaking"), true);
                                 }
                              }

                              if (entityiteratorxx instanceof AntArsonistAlateQueenEntity _datEntSetS) {
                                 _datEntSetS.getEntityData().set(AntArsonistAlateQueenEntity.DATA_antcommand, "logs");
                              }
                           }
                        }
                     }
                  }
               }

               if (!entity.getPersistentData().getBoolean("queennearcheck") && entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("No tamed queen nearby (block designation attempted)"), true);
               }
            }
         }

         if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            int var160;
            label606: {
               if (entity instanceof LivingEntity _livEntxx && _livEntxx.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                  var160 = _livEntxx.getEffect(MobEffects.DIG_SLOWDOWN).getAmplifier();
                  break label606;
               }

               var160 = 0;
            }

            if (var160 == 2 && blockstate.getBlock() == Blocks.SPAWNER) {
               if (world instanceof ServerLevel _levelxx) {
                  _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 20, 0.3, 0.3, 0.3, 0.4);
               }

               if ((
                     (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof TieredItem _tierItem
                        ? _tierItem.getTier().getLevel()
                        : 0
                  )
                  >= 2) {
                  if (!world.isClientSide()) {
                     world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                  }

                  if (world instanceof Level _levelxx) {
                     if (!_levelxx.isClientSide()) {
                        _levelxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.break")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.break")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  if (world instanceof Level _levelxxx && !_levelxxx.isClientSide()) {
                     _levelxxx.explode(null, x, y, z, 0.0F, ExplosionInteraction.BLOCK);
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1));
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
                  }
               } else if (!entity.getPersistentData().getBoolean("creativespectator") && entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("You need a stronger mining tool"), true);
               }
            }
         }

         if (!world.isClientSide()) {
            label598:
            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .power_slam_cooldown
                  > 400.0
               && !world.isClientSide()
               && direction == Direction.UP
               && world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
               && entity.isShiftKeyDown()) {
               if (entity instanceof Player _plrCldCheck214 && _plrCldCheck214.getCooldowns().isOnCooldown((Item)ArphexModItems.SEISMIC_PULSE.get())) {
                  break label598;
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown((Item)ArphexModItems.SEISMIC_PULSE.get(), 100);
               }

               BlockwaveProcedure.execute(world, x, y, z);
               if (world instanceof ServerLevel _levelxxx) {
                  _levelxxx.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 100, 0.8, 0.8, 0.8, 0.5);
               }
            }

            if (!world.isClientSide()
               && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.OBLIVION_RAY.get()
               && entity.isShiftKeyDown()) {
               if (entity instanceof Player _plrCldCheck221 && _plrCldCheck221.getCooldowns().isOnCooldown((Item)ArphexModItems.OBLIVION_RAY.get())) {
                  return;
               }

               if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                  .getOrCreateTag()
                  .getBoolean("oblivion_ray_mining_mode")) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§cDisabled block mining mode for oblivion ray"), true);
                  }

                  (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putBoolean("oblivion_ray_mining_mode", false);
               } else {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§aEnabled block mining mode for oblivion ray"), true);
                  }

                  (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putBoolean("oblivion_ray_mining_mode", true);
               }

               if (entity instanceof Player _player) {
                  _player.getCooldowns().addCooldown((Item)ArphexModItems.OBLIVION_RAY.get(), 10);
               }
            }
         }
      }
   }
}
