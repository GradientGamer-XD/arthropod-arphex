package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.event.level.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.IItemHandler;

@EventBusSubscriber
public class SummonAltarProcedure {
   @SubscribeEvent
   public static void onBlockPlace(EntityPlaceEvent event) {
      execute(event, event.getLevel(), (double)event.getPos().getX(), (double)event.getPos().getY(), (double)event.getPos().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double diamonds = 0.0;
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.SOUL_FIRE) {
            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.SOUL_SAND
               && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.MANGLED_SPIDER_FLESH.get()) {
               diamonds = 0.0;
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
                     ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
                     if (ArphexModItems.BANE_OF_THE_DARKNESS.get() == itemstackiterator.getItem()) {
                        diamonds += (double)itemstackiterator.getCount();
                     }

                     if (ArphexModItems.SINGULARITY_SATCHEL.get() == itemstackiterator.getItem()
                        && (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(91, itemstackiterator)
                              .getItem()
                           == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                        diamonds += (double)itemstackiterator.getCount();
                     }
                  }
               }

               if (!(diamonds > 0.0)) {
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("Try again with a Bane of the Darkness in your inventory..."), true);
                  }
               } else {
                  if (entity instanceof ServerPlayer _player) {
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:moth_summon"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                  }

                  ArphexMod.queueServerWork(20, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(40, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(60, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(80, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(100, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(
                     120,
                     () -> {
                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.SOUL_FIRE
                           && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.SOUL_SAND
                           && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.MANGLED_SPIDER_FLESH.get()) {
                           if (world instanceof ServerLevel _level) {
                              _level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                           }

                           if (world instanceof ServerLevel _level) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH.get())
                                 .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           Vec3 _center = new Vec3(x, y, z);

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (entityiterator instanceof SpiderMothEntity) {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), -1, 0, false, false));
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 999999, 0, false, false));
                                    }
                                 }
                              }
                           }

                           if (!world.isClientSide()) {
                              world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SOUL_FIRE.defaultBlockState()));
                              BlockPos _bp = BlockPos.containing(x, y, z);
                              BlockState _bs = Blocks.AIR.defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var16x) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                              world.levelEvent(2001, BlockPos.containing(x, y - 1.0, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
                              BlockPos _bpx = BlockPos.containing(x, y - 1.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var15x) {
                                    }
                                 }
                              }

                              world.setBlock(_bpx, _bs, 3);
                              world.levelEvent(
                                 2001, BlockPos.containing(x, y - 2.0, z), Block.getId(((Block)ArphexModBlocks.MANGLED_SPIDER_FLESH.get()).defaultBlockState())
                              );
                              BlockPos _bpxx = BlockPos.containing(x, y - 2.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpxx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var14) {
                                    }
                                 }
                              }

                              world.setBlock(_bpxx, _bs, 3);
                           }
                        }

                        ArphexMod.queueServerWork(
                           1,
                           () -> {
                              if (world instanceof Level _levelx && !_levelx.isClientSide()) {
                                 _levelx.explode(null, x, y, z, 6.0F, ExplosionInteraction.NONE);
                              }

                              Vec3 _center = new Vec3(x, y, z);

                              for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
                                 .stream()
                                 .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                 .toList()) {
                                 if (entityiteratorx instanceof SpiderMothEntity) {
                                    if (entityiteratorx instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiteratorx;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), -1, 0, false, false));
                                       }
                                    }

                                    if (entityiteratorx instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiteratorx;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(
                                             new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 999999, 0, false, false)
                                          );
                                       }
                                    }
                                 }
                              }
                           }
                        );
                     }
                  );
               }
            }

            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.SOUL_SAND
               && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.MANGLED_SCORPION_FLESH.get()) {
               diamonds = 0.0;
               AtomicReference<IItemHandler> _iitemhandlerrefx = new AtomicReference<>();
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerrefx::set);
               if (_iitemhandlerrefx.get() != null) {
                  for (int _idx = 0; _idx < _iitemhandlerrefx.get().getSlots(); _idx++) {
                     ItemStack itemstackiteratorx = _iitemhandlerrefx.get().getStackInSlot(_idx).copy();
                     if (ArphexModItems.BANE_OF_THE_DARKNESS.get() == itemstackiteratorx.getItem()) {
                        diamonds += (double)itemstackiteratorx.getCount();
                     }

                     if (ArphexModItems.SINGULARITY_SATCHEL.get() == itemstackiteratorx.getItem()
                        && (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(91, itemstackiteratorx)
                              .getItem()
                           == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                        diamonds += (double)itemstackiteratorx.getCount();
                     }
                  }
               }

               if (!(diamonds > 0.0)) {
                  if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                     _playerx.displayClientMessage(Component.literal("Try again with a Bane of the Darkness in your inventory..."), true);
                  }
               } else {
                  if (entity instanceof ServerPlayer _playerx) {
                     Advancement _adv = _playerx.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:scorpioid_summon"));
                     AdvancementProgress _ap = _playerx.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                           _playerx.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                  }

                  ArphexMod.queueServerWork(20, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(40, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(60, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(80, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(100, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(
                     120,
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.SOUL_FIRE
                           && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.SOUL_SAND
                           && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.MANGLED_SCORPION_FLESH.get()) {
                           if (world instanceof ServerLevel _level) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.SCORPIOID_BLOODLUSTER.get())
                                 .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           Vec3 _center = new Vec3(x, y, z);

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (entityiterator instanceof ScorpioidBloodlusterEntity) {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), -1, 0, false, false));
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 999999, 0, false, false));
                                    }
                                 }
                              }
                           }

                           if (!world.isClientSide()) {
                              world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SOUL_FIRE.defaultBlockState()));
                              BlockPos _bp = BlockPos.containing(x, y, z);
                              BlockState _bs = Blocks.AIR.defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var16x) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                              world.levelEvent(2001, BlockPos.containing(x, y - 1.0, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
                              BlockPos _bpx = BlockPos.containing(x, y - 1.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var15x) {
                                    }
                                 }
                              }

                              world.setBlock(_bpx, _bs, 3);
                              world.levelEvent(
                                 2001,
                                 BlockPos.containing(x, y - 2.0, z),
                                 Block.getId(((Block)ArphexModBlocks.MANGLED_SCORPION_FLESH.get()).defaultBlockState())
                              );
                              BlockPos _bpxx = BlockPos.containing(x, y - 2.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpxx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var14) {
                                    }
                                 }
                              }

                              world.setBlock(_bpxx, _bs, 3);
                           }

                           ArphexMod.queueServerWork(
                              1,
                              () -> {
                                 if (world instanceof Level _levelx && !_levelx.isClientSide()) {
                                    _levelx.explode(null, x, y, z, 6.0F, ExplosionInteraction.NONE);
                                 }

                                 Vec3 _centerx = new Vec3(x, y, z);

                                 for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(60.0), e -> true)
                                    .stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                    .toList()) {
                                    if (entityiteratorx instanceof ScorpioidBloodlusterEntity) {
                                       if (entityiteratorx instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiteratorx;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(
                                                new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), -1, 0, false, false)
                                             );
                                          }
                                       }

                                       if (entityiteratorx instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiteratorx;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(
                                                new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 999999, 0, false, false)
                                             );
                                          }
                                       }
                                    }
                                 }
                              }
                           );
                        }
                     }
                  );
               }
            }

            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.SOUL_SAND
               && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.MANGLED_FLY_FLESH.get()) {
               diamonds = 0.0;
               AtomicReference<IItemHandler> _iitemhandlerrefxx = new AtomicReference<>();
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerrefxx::set);
               if (_iitemhandlerrefxx.get() != null) {
                  for (int _idx = 0; _idx < _iitemhandlerrefxx.get().getSlots(); _idx++) {
                     ItemStack itemstackiteratorxx = _iitemhandlerrefxx.get().getStackInSlot(_idx).copy();
                     if (ArphexModItems.BANE_OF_THE_DARKNESS.get() == itemstackiteratorxx.getItem()) {
                        diamonds += (double)itemstackiteratorxx.getCount();
                     }

                     if (ArphexModItems.SINGULARITY_SATCHEL.get() == itemstackiteratorxx.getItem()
                        && (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(91, itemstackiteratorxx)
                              .getItem()
                           == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                        diamonds += (double)itemstackiteratorxx.getCount();
                     }
                  }
               }

               if (diamonds > 0.0) {
                  if (entity instanceof ServerPlayer _playerxx) {
                     Advancement _adv = _playerxx.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:voidlasher_summon"));
                     AdvancementProgress _ap = _playerxx.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                           _playerxx.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                  }

                  ArphexMod.queueServerWork(20, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(40, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(60, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(80, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(100, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_PURPLE_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                     }
                  });
                  ArphexMod.queueServerWork(
                     120,
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.SOUL_FIRE
                           && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.SOUL_SAND
                           && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.MANGLED_FLY_FLESH.get()) {
                           if (world instanceof ServerLevel _level) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.DRACONIC_VOIDLASHER.get())
                                 .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           if (!world.isClientSide()) {
                              world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SOUL_FIRE.defaultBlockState()));
                              BlockPos _bp = BlockPos.containing(x, y, z);
                              BlockState _bs = Blocks.AIR.defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var10 = _bso.getValues().entrySet().iterator();

                              while (var10.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var10.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var16x) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                              world.levelEvent(2001, BlockPos.containing(x, y - 1.0, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
                              _bp = BlockPos.containing(x, y - 1.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bp);
                              var10 = _bso.getValues().entrySet().iterator();

                              while (var10.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var10.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var15x) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                              world.levelEvent(
                                 2001, BlockPos.containing(x, y - 2.0, z), Block.getId(((Block)ArphexModBlocks.MANGLED_FLY_FLESH.get()).defaultBlockState())
                              );
                              _bp = BlockPos.containing(x, y - 2.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bp);
                              var10 = _bso.getValues().entrySet().iterator();

                              while (var10.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var10.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var14) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                           }

                           ArphexMod.queueServerWork(
                              1,
                              () -> {
                                 if (world instanceof Level _levelx && !_levelx.isClientSide()) {
                                    _levelx.explode(null, x, y, z, 6.0F, ExplosionInteraction.NONE);
                                 }

                                 Vec3 _center = new Vec3(x, y, z);

                                 for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
                                    .stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                    .toList()) {
                                    if (entityiterator instanceof SpiderMothDwellerEntity) {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(
                                                new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), -1, 0, false, false)
                                             );
                                          }
                                       }

                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(
                                                new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 999999, 0, false, false)
                                             );
                                          }
                                       }
                                    }
                                 }
                              }
                           );
                        }
                     }
                  );
               } else if (entity instanceof Player _playerxxx && !_playerxxx.level().isClientSide()) {
                  _playerxxx.displayClientMessage(Component.literal("Try again with a Bane of the Darkness in your inventory..."), true);
               }
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.SCORCH.get()) {
            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.SCORCHED_SAND.get()
               && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.CHITIN_BLOCK.get()) {
               diamonds = 0.0;
               AtomicReference<IItemHandler> _iitemhandlerrefxxx = new AtomicReference<>();
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerrefxxx::set);
               if (_iitemhandlerrefxxx.get() != null) {
                  for (int _idx = 0; _idx < _iitemhandlerrefxxx.get().getSlots(); _idx++) {
                     ItemStack itemstackiteratorxxx = _iitemhandlerrefxxx.get().getStackInSlot(_idx).copy();
                     if (ArphexModItems.BANE_OF_THE_DARKNESS.get() == itemstackiteratorxxx.getItem()) {
                        diamonds += (double)itemstackiteratorxxx.getCount();
                     }

                     if (ArphexModItems.SINGULARITY_SATCHEL.get() == itemstackiteratorxxx.getItem()
                        && (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(91, itemstackiteratorxxx)
                              .getItem()
                           == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                        diamonds += (double)itemstackiteratorxxx.getCount();
                     }
                  }
               }

               if (diamonds > 0.0) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                  }

                  ArphexMod.queueServerWork(20, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(40, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(60, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(80, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(100, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GREEN_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(
                     120,
                     () -> {
                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.SCORCH.get()
                           && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.SCORCHED_SAND.get()
                           && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.CHITIN_BLOCK.get()) {
                           if (world instanceof ServerLevel _level) {
                              _level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                           }

                           if (world instanceof ServerLevel _level) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.ARACHNOID_TRISECTOR.get())
                                 .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           ArphexMod.queueServerWork(
                              2,
                              () -> {
                                 Vec3 _center = new Vec3(x, y, z);

                                 for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), e -> true)
                                    .stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                    .toList()) {
                                    if (entityiteratorx instanceof ArachnoidTrisectorEntity) {
                                       if (entityiteratorx instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiteratorx;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(
                                                new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), -1, 0, false, false)
                                             );
                                          }
                                       }

                                       if (entityiteratorx instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiteratorx;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(
                                                new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 999999, 0, false, false)
                                             );
                                          }
                                       }
                                    }
                                 }
                              }
                           );
                           Vec3 _center = new Vec3(x, y, z);

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (entityiterator instanceof Player && entityiterator instanceof Player) {
                                 Player _playerxxx = (Player)entityiterator;
                                 if (!_playerxxx.level().isClientSide()) {
                                    _playerxxx.displayClientMessage(Component.literal("§cBeware... this boss can be destructive to terrain"), true);
                                 }
                              }
                           }

                           if (!world.isClientSide()) {
                              world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState()));
                              BlockPos _bp = BlockPos.containing(x, y, z);
                              BlockState _bs = Blocks.AIR.defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var16x) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                              world.levelEvent(
                                 2001, BlockPos.containing(x, y - 1.0, z), Block.getId(((Block)ArphexModBlocks.SCORCHED_SAND.get()).defaultBlockState())
                              );
                              BlockPos _bpx = BlockPos.containing(x, y - 1.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var15x) {
                                    }
                                 }
                              }

                              world.setBlock(_bpx, _bs, 3);
                              world.levelEvent(
                                 2001, BlockPos.containing(x, y - 2.0, z), Block.getId(((Block)ArphexModBlocks.CHITIN_BLOCK.get()).defaultBlockState())
                              );
                              BlockPos _bpxx = BlockPos.containing(x, y - 2.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpxx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var14) {
                                    }
                                 }
                              }

                              world.setBlock(_bpxx, _bs, 3);
                           }

                           ArphexMod.queueServerWork(1, () -> {
                              if (world instanceof Level _levelx && !_levelx.isClientSide()) {
                                 _levelx.explode(null, x, y, z, 6.0F, ExplosionInteraction.NONE);
                              }
                           });
                        }
                     }
                  );
               } else if (entity instanceof Player _playerxxx && !_playerxxx.level().isClientSide()) {
                  _playerxxx.displayClientMessage(Component.literal("Try again with a Bane of the Darkness in your inventory..."), true);
               }
            }

            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.SCORCHED_SAND.get()
               && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.HEAVY_CHITIN_BLOCK.get()) {
               diamonds = 0.0;
               AtomicReference<IItemHandler> _iitemhandlerrefxxxx = new AtomicReference<>();
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerrefxxxx::set);
               if (_iitemhandlerrefxxxx.get() != null) {
                  for (int _idx = 0; _idx < _iitemhandlerrefxxxx.get().getSlots(); _idx++) {
                     ItemStack itemstackiteratorxxxx = _iitemhandlerrefxxxx.get().getStackInSlot(_idx).copy();
                     if (ArphexModItems.BANE_OF_THE_DARKNESS.get() == itemstackiteratorxxxx.getItem()) {
                        diamonds += (double)itemstackiteratorxxxx.getCount();
                     }

                     if (ArphexModItems.SINGULARITY_SATCHEL.get() == itemstackiteratorxxxx.getItem()
                        && (new Object() {
                                 public ItemStack getItemStack(int sltid, ItemStack _isc) {
                                    AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                    _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                                       .ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                                    return _retval.get();
                                 }
                              })
                              .getItemStack(91, itemstackiteratorxxxx)
                              .getItem()
                           == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                        diamonds += (double)itemstackiteratorxxxx.getCount();
                     }
                  }
               }

               if (diamonds > 0.0) {
                  if (world instanceof ServerLevel _level) {
                     _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                  }

                  ArphexMod.queueServerWork(20, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(40, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(60, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(80, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(100, () -> {
                     if (world instanceof ServerLevel _level) {
                        _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), x, y, z, 500, 3.0, 3.0, 3.0, 0.2);
                     }
                  });
                  ArphexMod.queueServerWork(
                     120,
                     () -> {
                        if (world instanceof ServerLevel _level) {
                           _level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 500, 3.0, 3.0, 3.0, 0.1);
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.SCORCH.get()
                           && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ArphexModBlocks.SCORCHED_SAND.get()
                           && world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ArphexModBlocks.HEAVY_CHITIN_BLOCK.get()) {
                           if (world instanceof ServerLevel _level) {
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.DIABOLOS_DECIMATOR.get())
                                 .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           Vec3 _center = new Vec3(x, y, z);

                           for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
                              .stream()
                              .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                              .toList()) {
                              if (entityiterator instanceof Player && entityiterator instanceof Player) {
                                 Player _playerxxx = (Player)entityiterator;
                                 if (!_playerxxx.level().isClientSide()) {
                                    _playerxxx.displayClientMessage(Component.literal("§cBeware... this boss can be destructive to terrain"), true);
                                 }
                              }
                           }

                           ArphexMod.queueServerWork(1, () -> {
                              if (world instanceof Level _levelx && !_levelx.isClientSide()) {
                                 _levelx.explode(null, x, y, z, 6.0F, ExplosionInteraction.NONE);
                              }
                           });
                           if (!world.isClientSide()) {
                              world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)ArphexModBlocks.SCORCH.get()).defaultBlockState()));
                              BlockPos _bp = BlockPos.containing(x, y, z);
                              BlockState _bs = Blocks.AIR.defaultBlockState();
                              BlockState _bso = world.getBlockState(_bp);
                              UnmodifiableIterator var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var16x) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                              world.levelEvent(
                                 2001, BlockPos.containing(x, y - 1.0, z), Block.getId(((Block)ArphexModBlocks.SCORCHED_SAND.get()).defaultBlockState())
                              );
                              BlockPos _bpx = BlockPos.containing(x, y - 1.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var15x) {
                                    }
                                 }
                              }

                              world.setBlock(_bpx, _bs, 3);
                              world.levelEvent(
                                 2001, BlockPos.containing(x, y - 2.0, z), Block.getId(((Block)ArphexModBlocks.HEAVY_CHITIN_BLOCK.get()).defaultBlockState())
                              );
                              BlockPos _bpxx = BlockPos.containing(x, y - 2.0, z);
                              _bs = Blocks.AIR.defaultBlockState();
                              _bso = world.getBlockState(_bpxx);
                              var29x = _bso.getValues().entrySet().iterator();

                              while (var29x.hasNext()) {
                                 Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var29x.next();
                                 Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, entry.getValue());
                                    } catch (Exception var14) {
                                    }
                                 }
                              }

                              world.setBlock(_bpxx, _bs, 3);
                           }
                        }
                     }
                  );
               } else if (entity instanceof Player _playerxxx && !_playerxxx.level().isClientSide()) {
                  _playerxxx.displayClientMessage(Component.literal("Try again with a Bane of the Darkness in your inventory..."), true);
               }
            }
         }
      }
   }
}
