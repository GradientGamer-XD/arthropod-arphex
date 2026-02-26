package net.arphex.procedures;

import java.text.DecimalFormat;
import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistEntity;
import net.arphex.entity.AntArsonistSoldierEntity;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.entity.CentipedeEvictorLarvaeEntity;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.entity.CrabLarvaeEntity;
import net.arphex.entity.HornetHarbingerEntity;
import net.arphex.entity.RoachRiverspawnEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderGoliathEntity;
import net.arphex.entity.SpiderJumpEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderLungerEntity;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.entity.TermiteTunnelerKingEntity;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class RightClickEntityProcedure {
   @SubscribeEvent
   public static void onRightClickEntity(EntityInteract event) {
      execute(
         event,
         event.getLevel(),
         (double)event.getPos().getX(),
         (double)event.getPos().getY(),
         (double)event.getPos().getZ(),
         event.getTarget(),
         event.getEntity()
      );
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      execute(null, world, x, y, z, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         ItemStack custom_itemstack = ItemStack.EMPTY;
         boolean found = false;
         boolean checkbane = false;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double cocoon_scan = 0.0;
         boolean _setval = true;
         sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.just_right_clicked = _setval;
            capability.syncPlayerVariables(sourceentity);
         });
         if (!world.isClientSide()) {
            if (sourceentity instanceof LivingEntity _entity) {
               _entity.stopUsingItem();
            }

            if (sourceentity instanceof LivingEntity _entity && _entity.isUsingItem()) {
               return;
            }

            if (entity instanceof CrabLarvaeEntity) {
               label1330:
               if (sourceentity.isShiftKeyDown()) {
                  if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("Toggled following mode"), true);
                  }

                  if (entity instanceof CrabLarvaeEntity _datEntL6 && (Boolean)_datEntL6.getEntityData().get(CrabLarvaeEntity.DATA_following)) {
                     if (entity instanceof CrabLarvaeEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CrabLarvaeEntity.DATA_following, false);
                     }
                     break label1330;
                  }

                  if (entity instanceof CrabLarvaeEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(CrabLarvaeEntity.DATA_following, true);
                  }
               } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(
                     Component.literal(
                        "Your Crab's health is "
                           + Math.round(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                           + " / 200 (sneak+click to toggle following)"
                     ),
                     true
                  );
               }
            }

            label1322:
            if (entity instanceof SpiderFlatEntity) {
               if ((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SPIDER_JAR.get()
                  && entity instanceof TamableAnimal _tamIsTamedBy
                  && sourceentity instanceof LivingEntity _livEnt
                  && _tamIsTamedBy.isOwnedBy(_livEnt)
                  && entity.isAlive()) {
                  if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.SPIDER_JAR.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (sourceentity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.SPIDER_FLAT_JAR.get()).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (!entity.getDisplayName().getString().equals("")) {
                     (sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .setHoverName(Component.literal(entity.getDisplayName().getString()));
                  }

                  (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("spiderhealth", entity instanceof LivingEntity _livEntxx ? (double)_livEntxx.getHealth() : -1.0);
                  (sourceentity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble(
                        "patreon_reskin",
                        entity instanceof SpiderFlatEntity _datEntI
                           ? (double)((Integer)_datEntI.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin)).intValue()
                           : 0.0
                     );
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
                  break label1322;
               }

               if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)) {
                  label1307:
                  if (sourceentity.isShiftKeyDown()) {
                     if (entity instanceof SpiderFlatEntity _datEntL31 && (Boolean)_datEntL31.getEntityData().get(SpiderFlatEntity.DATA_sit)) {
                        if (entity instanceof SpiderFlatEntity _datEntSetL) {
                           _datEntSetL.getEntityData().set(SpiderFlatEntity.DATA_sit, false);
                        }
                        break label1307;
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(SpiderFlatEntity.DATA_sit, true);
                     }
                  } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal(
                           "Crouch+click to toggle sitting. Health: "
                              + Math.round(entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                              + " / 60 (storable in jar)"
                        ),
                        true
                     );
                  }
               }
            }

            label1300:
            if (entity instanceof SpiderJumpEntity) {
               if ((sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.SPIDER_JAR.get()
                  && entity instanceof TamableAnimal _tamIsTamedByx
                  && sourceentity instanceof LivingEntity _livEntx
                  && _tamIsTamedByx.isOwnedBy(_livEntx)
                  && entity.isAlive()) {
                  if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.SPIDER_JAR.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (sourceentity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.SPIDER_JUMP_JAR.get()).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if ((entity instanceof SpiderJumpEntity animatable ? animatable.getTexture() : "null").equals("spiderjumpingrare")) {
                     (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                        .getOrCreateTag()
                        .putBoolean("peacock", true);
                  } else {
                     (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                        .getOrCreateTag()
                        .putBoolean("peacock", false);
                  }

                  if (!entity.getDisplayName().getString().equals("")) {
                     (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                        .setHoverName(Component.literal(entity.getDisplayName().getString()));
                  }

                  (sourceentity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getOrCreateTag()
                     .putDouble("spiderhealth", entity instanceof LivingEntity _livEntxxx ? (double)_livEntxxx.getHealth() : -1.0);
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
                  break label1300;
               }

               if (entity instanceof TamableAnimal _tamIsTamedByx && sourceentity instanceof LivingEntity _livEntx && _tamIsTamedByx.isOwnedBy(_livEntx)) {
                  label1285:
                  if (sourceentity.isShiftKeyDown()) {
                     if (entity instanceof SpiderJumpEntity _datEntL58 && (Boolean)_datEntL58.getEntityData().get(SpiderJumpEntity.DATA_sit)) {
                        if (entity instanceof SpiderJumpEntity _datEntSetL) {
                           _datEntSetL.getEntityData().set(SpiderJumpEntity.DATA_sit, false);
                        }
                        break label1285;
                     }

                     if (entity instanceof SpiderJumpEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(SpiderJumpEntity.DATA_sit, true);
                     }
                  } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal(
                           "Crouch+click to toggle sitting. Health: "
                              + Math.round(entity instanceof LivingEntity _livEntxx ? _livEntxx.getHealth() : -1.0F)
                              + " / 40 (storable in jar)"
                        ),
                        true
                     );
                  }
               }
            }

            if (entity instanceof SpiderFlatEntity
               && (sourceentity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() != ItemStack.EMPTY.getItem()
               && (!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
               && (sourceentity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.MAGGOT_GRUB.get()
               && (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.ROACH_NYMPH.get()
               && (sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.LOCUST_LARVAE.get()) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 5, 1.0, 1.0, 1.0, 0.2);
               }

               if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Using the wrong taming ingredient angered it!"), true);
               }

               if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent) {
                  _entity.setTarget(_ent);
               }
            }

            if (entity instanceof SpiderJumpEntity
               && (!(entity instanceof TamableAnimal _tamEnt) || !_tamEnt.isTame())
               && (sourceentity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.MAGGOT_GRUB.get()
               && (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.LOCUST_LARVAE.get()
               && (sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.ROACH_NYMPH.get()
               && sourceentity instanceof Player _player
               && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Wrong taming ingredient"), true);
            }

            if (entity instanceof CrabLarvaeEntity
               && (sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ArphexModItems.BUCKET_OF_WORM_GRUB.get()
               && world.getEntitiesOfClass(CrabConstrictorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50.0, 50.0, 50.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.5, 0.5, 0.5, 0.1);
               }

               if (!sourceentity.getPersistentData().getBoolean("creativespectator")) {
                  if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_WORM_GRUB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (sourceentity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }
            }

            label1260:
            if (entity instanceof SpiderGoliathEntity
               && (
                  (sourceentity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_MAGGOTS.get()
                     || (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_ROACHES.get()
                     || (sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_LOCUSTS.get()
               )) {
               if (entity instanceof LivingEntity _livEnt101 && _livEnt101.hasEffect(MobEffects.DARKNESS)) {
                  if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("Crawling dimension Goliaths not tameable"), true);
                  }
                  break label1260;
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.5, 0.5, 0.5, 0.1);
               }

               if (!sourceentity.getPersistentData().getBoolean("creativespectator")) {
                  if ((sourceentity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.BUCKET_OF_MAGGOTS.get()) {
                     if (sourceentity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_MAGGOTS.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                     }
                  } else if ((sourceentity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ArphexModItems.BUCKET_OF_ROACHES.get()) {
                     if (sourceentity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_ROACHES.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                     }
                  } else if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_LOCUSTS.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (sourceentity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }

               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!world.getEntitiesOfClass(TamedTarantulaEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                        Entity patt16527$temp = world.getEntitiesOfClass(
                              TamedTarantulaEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt16527$temp instanceof TamedTarantulaEntity _datEntSetS) {
                           _datEntSetS.getEntityData()
                              .set(TamedTarantulaEntity.DATA_variant, entity instanceof SpiderGoliathEntity animatable ? animatable.getTexture() : "null");
                        }
                     } else {
                        ArphexMod.queueServerWork(
                           2,
                           () -> {
                              if (!world.getEntitiesOfClass(TamedTarantulaEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                                 Entity patt17342$temp = world.getEntitiesOfClass(
                                       TamedTarantulaEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true
                                    )
                                    .stream()
                                    .sorted((new Object() {
                                       Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                          return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                       }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null);
                                 if (patt17342$temp instanceof TamedTarantulaEntity _datEntSetSx) {
                                    _datEntSetSx.getEntityData()
                                       .set(
                                          TamedTarantulaEntity.DATA_variant,
                                          entity instanceof SpiderGoliathEntity animatablex ? animatablex.getTexture() : "null"
                                       );
                                 }
                              }
                           }
                        );
                     }
                  }
               );
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }

               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.TAMED_TARANTULA.get())
                     .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 40, 3.0, 3.0, 3.0, 1.0);
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 3.0, 3.0, 3.0, 1.0);
               }
            }

            if (entity instanceof TamedTarantulaEntity
               && (
                  (sourceentity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_MAGGOTS.get()
                     || (sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_ROACHES.get()
                     || (sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_LOCUSTS.get()
               )) {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 3, 0.5, 0.5, 0.5, 0.1);
               }

               if (!sourceentity.getPersistentData().getBoolean("creativespectator")) {
                  if ((sourceentity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_MAGGOTS.get()
                     && sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_MAGGOTS.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if ((sourceentity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_ROACHES.get()
                     && sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_ROACHES.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if ((sourceentity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.BUCKET_OF_LOCUSTS.get()
                     && sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_LOCUSTS.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (sourceentity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }

               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.5, 0.5, 0.5, 0.2);
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, true));
               }
            }

            if (entity instanceof AntArsonistAlateQueenEntity) {
               if ((sourceentity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem() != Items.GOLDEN_APPLE
                  && (sourceentity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() != Items.ENCHANTED_GOLDEN_APPLE
                  )
                {
                  if (entity instanceof TamableAnimal _tamIsTamedByxx
                     && sourceentity instanceof LivingEntity _livEntxxxx
                     && _tamIsTamedByxx.isOwnedBy(_livEntxxxx)
                     && entity instanceof AntArsonistAlateQueenEntity _datEntL193
                     && (Boolean)_datEntL193.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)) {
                     if ((sourceentity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.STICK) {
                        entity.getPersistentData().putString("plantversion", "none");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting disabled"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == Items.WHEAT_SEEDS) {
                        entity.getPersistentData().putString("plantversion", "seeds");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: seeds"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == Items.PUMPKIN_SEEDS) {
                        entity.getPersistentData().putString("plantversion", "pumpkin");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: pumpkin"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == Items.MELON_SEEDS) {
                        entity.getPersistentData().putString("plantversion", "melon");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: melon"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == Items.CARROT) {
                        entity.getPersistentData().putString("plantversion", "carrot");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: carrot"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == Items.POTATO) {
                        entity.getPersistentData().putString("plantversion", "potato");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: potato"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getItem()
                        == Blocks.OAK_SAPLING.asItem()) {
                        entity.getPersistentData().putString("plantversion", "oak");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: oak sapling"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getItem()
                        == Blocks.DARK_OAK_SAPLING.asItem()) {
                        entity.getPersistentData().putString("plantversion", "darkoak");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: dark oak sapling"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getItem()
                        == Blocks.SPRUCE_SAPLING.asItem()) {
                        entity.getPersistentData().putString("plantversion", "spruce");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: spruce sapling"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getItem()
                        == Blocks.BIRCH_SAPLING.asItem()) {
                        entity.getPersistentData().putString("plantversion", "birch");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: birch sapling"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getItem()
                        == Blocks.JUNGLE_SAPLING.asItem()) {
                        entity.getPersistentData().putString("plantversion", "jungle");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: jungle sapling"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getItem()
                        == Blocks.ACACIA_SAPLING.asItem()) {
                        entity.getPersistentData().putString("plantversion", "acacia");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: acacia sapling"), true);
                        }
                     } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == Blocks.CHERRY_SAPLING.asItem()) {
                        entity.getPersistentData().putString("plantversion", "cherry");
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Colony farmland planting mode: cherry sapling"), true);
                        }
                     } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(
                           Component.literal(
                              "Queen current health: "
                                 + new DecimalFormat("##.##")
                                    .format(
                                       entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx ? (double)_livEntxxxxxxxxxxxxxxxxxxxxx.getHealth() : -1.0
                                    )
                                 + "/"
                                 + new DecimalFormat("##.##")
                                    .format(
                                       entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx ? (double)_livEntxxxxxxxxxxxxxxxxxxxx.getMaxHealth() : -1.0
                                    )
                                 + ", and queen current level points: "
                                 + (
                                    entity instanceof AntArsonistAlateQueenEntity _datEntI
                                       ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                                       : 0
                                 )
                           ),
                           true
                        );
                     }
                  }
               } else {
                  label1496: {
                     if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 20, 0.3, 0.3, 0.3, 0.5);
                        }

                        if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getItem()
                           == Items.GOLDEN_APPLE) {
                           if (!sourceentity.getPersistentData().getBoolean("creativespectator") && sourceentity instanceof Player _player) {
                              ItemStack _stktoremove = new ItemStack(Items.GOLDEN_APPLE);
                              _player.getInventory()
                                 .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                           }

                           if (entity instanceof AntArsonistAlateQueenEntity _datEntL159
                              && (Boolean)_datEntL159.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)
                              && entity instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData()
                                 .set(
                                    AntArsonistAlateQueenEntity.DATA_queenlevel,
                                    (
                                          entity instanceof AntArsonistAlateQueenEntity _datEntI
                                             ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                                             : 0
                                       )
                                       + 1200
                                 );
                           }

                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
                           }
                        } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == Items.ENCHANTED_GOLDEN_APPLE) {
                           if (!sourceentity.getPersistentData().getBoolean("creativespectator") && sourceentity instanceof Player _player) {
                              ItemStack _stktoremove = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
                              _player.getInventory()
                                 .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                           }

                           if (entity instanceof AntArsonistAlateQueenEntity _datEntL167
                              && (Boolean)_datEntL167.getEntityData().get(AntArsonistAlateQueenEntity.DATA_alatequeen)
                              && entity instanceof AntArsonistAlateQueenEntity _datEntSetI) {
                              _datEntSetI.getEntityData()
                                 .set(
                                    AntArsonistAlateQueenEntity.DATA_queenlevel,
                                    (
                                          entity instanceof AntArsonistAlateQueenEntity _datEntI
                                             ? (Integer)_datEntI.getEntityData().get(AntArsonistAlateQueenEntity.DATA_queenlevel)
                                             : 0
                                       )
                                       + 9600
                                 );
                           }

                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 3));
                           }
                        }
                        break label1496;
                     }

                     if (world instanceof ServerLevel _levelx) {
                        _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 10, 0.5, 0.5, 0.5, 0.1);
                     }

                     if (Mth.nextInt(RandomSource.create(), 1, 5) == 3
                        || (sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getItem()
                           == Items.ENCHANTED_GOLDEN_APPLE) {
                        if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner) {
                           _toTame.tame(_owner);
                        }

                        if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("Alate tamed - It will turn into a queen in 5 minutes, get it under shelter!"), true);
                        }

                        entity.setCustomName(Component.literal(sourceentity.getDisplayName().getString() + "'s Fire Ant Queen"));
                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 40, 0.3, 0.3, 0.3, 0.3);
                        }

                        if (world instanceof ServerLevel _levelx) {
                           _levelx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 20, 0.3, 0.3, 0.3, 0.3);
                        }
                     }

                     if (!sourceentity.getPersistentData().getBoolean("creativespectator")) {
                        if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getItem()
                           == Items.GOLDEN_APPLE) {
                           if (!sourceentity.getPersistentData().getBoolean("creativespectator")) {
                              if (sourceentity instanceof Player _player) {
                                 ItemStack _stktoremove = new ItemStack(Items.GOLDEN_APPLE);
                                 _player.getInventory()
                                    .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                              }

                              if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
                              }
                           }
                        } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx
                                    ? _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                    : ItemStack.EMPTY)
                                 .getItem()
                              == Items.ENCHANTED_GOLDEN_APPLE
                           && !sourceentity.getPersistentData().getBoolean("creativespectator")) {
                           if (sourceentity instanceof Player _player) {
                              ItemStack _stktoremove = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
                              _player.getInventory()
                                 .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                           }

                           if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 3));
                           }
                        }
                     }
                  }
               }
            }

            if (entity instanceof AntArsonistWorkerEntity || entity instanceof AntArsonistSoldierEntity) {
               if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getItem()
                  == Items.APPLE) {
                  if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack(Items.APPLE);
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 5, 0.4, 0.4, 0.4, 0.1);
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 1, false, true));
                  }
               } else if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getItem()
                  == Items.MELON_SLICE) {
                  if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack(Items.MELON_SLICE);
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 5, 0.4, 0.4, 0.4, 0.1);
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 1, false, true));
                  }
               } else {
                  label1207:
                  if (entity instanceof TamableAnimal _tamIsTamedByxxx
                     && sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx
                     && _tamIsTamedByxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxxxxxxxx)) {
                     if (entity instanceof AntArsonistWorkerEntity _datEntL263
                        && (Boolean)_datEntL263.getEntityData().get(AntArsonistWorkerEntity.DATA_following)) {
                        if (entity instanceof AntArsonistWorkerEntity _datEntSetL) {
                           _datEntSetL.getEntityData().set(AntArsonistWorkerEntity.DATA_following, false);
                        }
                        break label1207;
                     }

                     if (entity instanceof AntArsonistWorkerEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(AntArsonistWorkerEntity.DATA_following, true);
                     }
                  }
               }
            }

            if (entity instanceof TermiteTunnelerKingEntity
               && entity instanceof TamableAnimal _tamIsTamedByxxx
               && sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx
               && _tamIsTamedByxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxxxxxxxx)) {
               if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                  .is(ItemTags.create(new ResourceLocation("minecraft:logs")))) {
                  if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove;
                     ItemStack var322 = _stktoremove = sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                        ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                        : ItemStack.EMPTY;
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 5, 0.4, 0.4, 0.4, 0.1);
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 2, false, true));
                  }
               } else {
                  label1185:
                  if (sourceentity.isShiftKeyDown()) {
                     if (entity instanceof TermiteTunnelerKingEntity _datEntL275
                        && (Boolean)_datEntL275.getEntityData().get(TermiteTunnelerKingEntity.DATA_following)) {
                        if (entity instanceof TermiteTunnelerKingEntity _datEntSetL) {
                           _datEntSetL.getEntityData().set(TermiteTunnelerKingEntity.DATA_following, false);
                        }
                        break label1185;
                     }

                     if (entity instanceof TermiteTunnelerKingEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(TermiteTunnelerKingEntity.DATA_following, true);
                     }
                  }
               }
            }

            if (entity instanceof SpiderLungerEntity
               && entity instanceof TamableAnimal _tamIsTamedByxxxx
               && sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx
               && _tamIsTamedByxxxx.isOwnedBy(_livEntxxxxxxxxxxxxxxxxxxxxxx)) {
               if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     != ArphexModItems.BUCKET_OF_ROACHES.get()
                  && (sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     != ArphexModItems.BUCKET_OF_MAGGOTS.get()
                  && (sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                        .getItem()
                     != ArphexModItems.BUCKET_OF_LOCUSTS.get()) {
                  label1163:
                  if (sourceentity.isShiftKeyDown()) {
                     if (entity instanceof SpiderLungerEntity _datEntL292 && (Boolean)_datEntL292.getEntityData().get(SpiderLungerEntity.DATA_follow)) {
                        if (entity instanceof SpiderLungerEntity _datEntSetL) {
                           _datEntSetL.getEntityData().set(SpiderLungerEntity.DATA_follow, false);
                        }
                        break label1163;
                     }

                     if (entity instanceof SpiderLungerEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(SpiderLungerEntity.DATA_follow, true);
                     }
                  } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(
                        Component.literal(
                           "Crouch+click to toggle following. Health: "
                              + Math.round(
                                 entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getHealth() : -1.0F
                              )
                              + " / 150"
                        ),
                        true
                     );
                  }
               } else {
                  if (sourceentity instanceof Player _player) {
                     ItemStack _stktoremove;
                     ItemStack var326 = _stktoremove = sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx
                        ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                        : ItemStack.EMPTY;
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (entity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (world instanceof ServerLevel _levelx) {
                     _levelx.sendParticles(ParticleTypes.HEART, x, y, z, 5, 0.4, 0.4, 0.4, 0.1);
                  }

                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 2, false, true));
                  }
               }
            }

            if (entity instanceof Player
               && sourceentity instanceof LivingEntity _livEnt298
               && _livEnt298.hasEffect(MobEffects.GLOWING)
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getItem()
                  == ArphexModItems.CRAWLING_CONTAINER.get()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                  .getOrCreateTag()
                  .getString("playertrackfortp")
                  .equals(sourceentity.getStringUUID())) {
               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Accepted pocket dimension invitation"), true);
               }

               if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Pocket dimension invitation accepted"), true);
               }

               (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                  .getOrCreateTag()
                  .putString("trackfortp", sourceentity.getStringUUID());
               (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                  .getOrCreateTag()
                  .putBoolean("activated", true);
            }

            if (sourceentity instanceof Player
               && entity instanceof TormentorSummonEntity
               && sourceentity.isShiftKeyDown()
               && sourceentity instanceof Player _player
               && !_player.level().isClientSide()) {
               _player.displayClientMessage(
                  Component.literal(
                     "Tormentor kills accumulated: "
                        + Math.round(
                           ((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                 .orElse(new ArphexModVariables.PlayerVariables()))
                              .killedtormentor
                        )
                        + " for player"
                  ),
                  true
               );
            }

            if (sourceentity instanceof Player
               && (
                  sourceentity.getDisplayName().getString().equals("noohell")
                     || sourceentity.getDisplayName().getString().equals("LolkoXb")
                     || sourceentity.getDisplayName().getString().equals("Vllax")
               )) {
               sourceentity.getPersistentData().putBoolean("arphex_special_player", true);
               if (entity instanceof RoachRiverspawnEntity) {
                  if (entity instanceof RoachRiverspawnEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(RoachRiverspawnEntity.DATA_shiny, true);
                  }

                  if (!world.isClientSide()) {
                     entity.getPersistentData().putBoolean("unable_to_attack_player_arphex", true);
                     entity.getPersistentData().putString("owner_force_arphex", sourceentity.getDisplayName().getString());
                     if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Tamed the roach! It will follow you if you hold sugar"), true);
                     }

                     entity.setCustomName(Component.literal(sourceentity.getDisplayName().getString() + "'s Platinum Roach"));
                  }
               }

               if (entity instanceof HornetHarbingerEntity) {
                  if (entity instanceof HornetHarbingerEntity animatable) {
                     animatable.setTexture("emerald_mob");
                  }

                  if (entity instanceof HornetHarbingerEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(HornetHarbingerEntity.DATA_shiny, true);
                  }

                  if (!world.isClientSide()) {
                     entity.getPersistentData().putBoolean("unable_to_attack_player_arphex", true);
                     entity.getPersistentData().putString("owner_force_arphex", sourceentity.getDisplayName().getString());
                     if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Tamed the hornet! It will follow you if you hold sugar"), true);
                     }

                     entity.setCustomName(Component.literal(sourceentity.getDisplayName().getString() + "'s Emerald Hornet"));
                  }
               }

               label1149:
               if (entity instanceof CentipedeEvictorLarvaeEntity) {
                  if (entity instanceof CentipedeEvictorLarvaeEntity _datEntL340
                     && (Boolean)_datEntL340.getEntityData().get(CentipedeEvictorLarvaeEntity.DATA_stronger)) {
                     if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Unable to tame the stronger boss centipede variant"), true);
                     }
                     break label1149;
                  }

                  if (entity instanceof CentipedeEvictorLarvaeEntity animatable) {
                     animatable.setTexture("sapphire_mob");
                  }

                  if (!world.isClientSide()) {
                     entity.getPersistentData().putBoolean("unable_to_attack_player_arphex", true);
                     if (entity instanceof CentipedeEvictorLarvaeEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CentipedeEvictorLarvaeEntity.DATA_shinier, true);
                     }

                     entity.getPersistentData().putString("owner_force_arphex", sourceentity.getDisplayName().getString());
                     if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Tamed the centipede larvae! It will follow you if you hold sugar"), true);
                     }

                     entity.setCustomName(Component.literal(sourceentity.getDisplayName().getString() + "'s Sapphire Centipede"));
                  }
               }

               if (entity instanceof SpiderLarvaeEntity) {
                  if (entity instanceof SpiderLarvaeEntity animatable) {
                     animatable.setTexture("golden_mob");
                  }

                  if (entity instanceof SpiderLarvaeEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(SpiderLarvaeEntity.DATA_shiny, true);
                  }

                  if (!world.isClientSide()) {
                     entity.getPersistentData().putBoolean("unable_to_attack_player_arphex", true);
                     entity.getPersistentData().putString("owner_force_arphex", sourceentity.getDisplayName().getString());
                     if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Tamed the spider larvae! It will follow you if you hold sugar"), true);
                     }

                     entity.setCustomName(Component.literal(sourceentity.getDisplayName().getString() + "'s Golden Spider"));
                  }
               }

               if (entity instanceof AntArsonistEntity) {
                  if (entity instanceof AntArsonistEntity animatable) {
                     animatable.setTexture("ruby_mob");
                  }

                  if (entity instanceof AntArsonistEntity _datEntSetL) {
                     _datEntSetL.getEntityData().set(AntArsonistEntity.DATA_shiny, true);
                  }

                  if (!world.isClientSide()) {
                     entity.getPersistentData().putBoolean("unable_to_attack_player_arphex", true);
                     entity.getPersistentData().putString("owner_force_arphex", sourceentity.getDisplayName().getString());
                     if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Tamed the ant arsonist! It will follow you if you hold sugar"), true);
                     }

                     entity.setCustomName(Component.literal(sourceentity.getDisplayName().getString() + "'s Ruby Ant"));
                  }
               }
            }

            if ((sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getItem()
                  == ArphexModItems.TROPHY_ITEM.get()
               && (new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                        } else {
                           return _ent.level().isClientSide() && _ent instanceof Player _player
                              ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                 && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE
                              : false;
                        }
                     }
                  })
                  .checkGamemode(sourceentity)
               && entity instanceof LivingEntity
               && sourceentity instanceof Player
               && ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")) {
               (sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                     : ItemStack.EMPTY)
                  .getOrCreateTag()
                  .putString(
                     "trophy_entity",
                     ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().replace("arphex:", "").replace("_giant", "").replace("_tiny", "").strip()
                  );
               (sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                     : ItemStack.EMPTY)
                  .getOrCreateTag()
                  .putDouble("trophy_entity_size", 1.0 / (Math.cbrt((double)(entity.getBbHeight() * entity.getBbWidth())) * 10.0) * 4.0);
               (sourceentity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                     ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                     : ItemStack.EMPTY)
                  .setHoverName(Component.literal(entity.getDisplayName().getString() + " Trophy"));
               if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Locked trophy to entity successfully"), true);
               }

               if (world instanceof ServerLevel _levelx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelx, x, y, z, custom_itemstack);
                  entityToSpawn.setPickUpDelay(10);
                  _levelx.addFreshEntity(entityToSpawn);
               }
            }
         }
      }
   }
}
