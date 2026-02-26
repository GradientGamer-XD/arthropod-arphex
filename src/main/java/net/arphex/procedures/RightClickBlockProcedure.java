package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.ButterflyBewitcherEntity;
import net.arphex.entity.CrabLarvaeEntity;
import net.arphex.entity.FlyFestererEntity;
import net.arphex.entity.LocustLandscourgeEntity;
import net.arphex.entity.RepellantEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderJumpEntity;
import net.arphex.entity.SpiderMothSummonEntity;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class RightClickBlockProcedure {
   @SubscribeEvent
   public static void onRightClickBlock(RightClickBlock event) {
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
         Entity spiderflat = null;
         if (direction == Direction.UP) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BUCKET_OF_WORM_GRUB.get()) {
               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_levelx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.2F);
                     entityToSpawn.setYBodyRot(0.2F);
                     entityToSpawn.setYHeadRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_levelxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.1F);
                     entityToSpawn.setYBodyRot(-0.1F);
                     entityToSpawn.setYHeadRot(-0.1F);
                     entityToSpawn.setDeltaMovement(-0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_levelxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.2F);
                     entityToSpawn.setYBodyRot(-0.2F);
                     entityToSpawn.setYHeadRot(-0.2F);
                     entityToSpawn.setDeltaMovement(-0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_levelxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_levelxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.5);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_levelxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.BLOOD_WORM.get())
                     .spawn(_levelxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.1);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  if (entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_WORM_GRUB.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (entity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BUCKET_OF_LOCUSTS.get()) {
               if (world instanceof ServerLevel _levelxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.2F);
                     entityToSpawn.setYBodyRot(0.2F);
                     entityToSpawn.setYHeadRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.1F);
                     entityToSpawn.setYBodyRot(-0.1F);
                     entityToSpawn.setYHeadRot(-0.1F);
                     entityToSpawn.setDeltaMovement(-0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.2F);
                     entityToSpawn.setYBodyRot(-0.2F);
                     entityToSpawn.setYHeadRot(-0.2F);
                     entityToSpawn.setDeltaMovement(-0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.5);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.LOCUST_LANDSCOURGE.get())
                     .spawn(_levelxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.1);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  if (entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_LOCUSTS.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (entity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BUCKET_OF_MAGGOTS.get()) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.2F);
                     entityToSpawn.setYBodyRot(0.2F);
                     entityToSpawn.setYHeadRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.1F);
                     entityToSpawn.setYBodyRot(-0.1F);
                     entityToSpawn.setYHeadRot(-0.1F);
                     entityToSpawn.setDeltaMovement(-0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.2F);
                     entityToSpawn.setYBodyRot(-0.2F);
                     entityToSpawn.setYHeadRot(-0.2F);
                     entityToSpawn.setDeltaMovement(-0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.5);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.MAGGOT_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.1);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  if (entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_MAGGOTS.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (entity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SPIDER_CRAB_JAR.get()
               && world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.CRAB_LARVAE.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                        Entity patt16675$temp = world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt16675$temp instanceof TamableAnimal _toTame && entity instanceof Player _owner) {
                           _toTame.tame(_owner);
                        }

                        if (!(entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getDisplayName()
                           .getString()
                           .equals("Spider Crab Jar")) {
                           world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(
                                 Component.literal(
                                    (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                       .getDisplayName()
                                       .getString()
                                       .replace("]", "")
                                       .replace("[", "")
                                 )
                              );
                           Entity patt17912$temp = world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null);
                           if (patt17912$temp instanceof LivingEntity _entityx) {
                              _entityx.setHealth(
                                 (float)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                                    .getOrCreateTag()
                                    .getDouble("spiderhealth")
                              );
                           }
                        }
                     }
                  }
               );
               ArphexMod.queueServerWork(2, () -> {
                  if (entity instanceof LivingEntity _entityx) {
                     ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.SPIDER_JAR.get()).copy();
                     _setstack.setCount(1);
                     _entityx.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entityx instanceof Player _playerx) {
                        _playerx.getInventory().setChanged();
                     }
                  }
               });
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BUCKET_OF_ROACHES.get()) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.2F);
                     entityToSpawn.setYBodyRot(0.2F);
                     entityToSpawn.setYHeadRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.1F);
                     entityToSpawn.setYBodyRot(-0.1F);
                     entityToSpawn.setYHeadRot(-0.1F);
                     entityToSpawn.setDeltaMovement(-0.05, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(-0.2F);
                     entityToSpawn.setYBodyRot(-0.2F);
                     entityToSpawn.setYHeadRot(-0.2F);
                     entityToSpawn.setDeltaMovement(-0.1, 0.0, 0.0);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.1);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.1F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.05);
                  }
               }

               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.ROACH_RIVERSPAWN.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setXRot(-0.2F);
                     entityToSpawn.setDeltaMovement(0.0, 0.0, -0.1);
                  }
               }

               if (!entity.getPersistentData().getBoolean("creativespectator")) {
                  if (entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ArphexModItems.BUCKET_OF_ROACHES.get());
                     _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }

                  if (entity instanceof Player _player) {
                     ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SPIDER_FLAT_JAR.get()
               && world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_FLAT.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                        Entity patt23532$temp = world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt23532$temp instanceof TamableAnimal _toTame && entity instanceof Player _owner) {
                           _toTame.tame(_owner);
                        }

                        if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getDisplayName()
                           .getString()
                           .contains("Spider Flat Jar")) {
                           world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(Component.literal(entity.getDisplayName().getString() + "'s Spider Flat"));
                        } else {
                           world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(
                                 Component.literal(
                                    (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                                       .getDisplayName()
                                       .getString()
                                       .replace("]", "")
                                       .replace("[", "")
                                 )
                              );
                        }

                        patt23532$temp = world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt23532$temp instanceof LivingEntity _entityxx) {
                           _entityxx.setHealth(
                              (float)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                                 .getOrCreateTag()
                                 .getDouble("spiderhealth")
                           );
                        }

                        patt23532$temp = world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt23532$temp instanceof SpiderFlatEntity _datEntSetI) {
                           _datEntSetI.getEntityData()
                              .set(
                                 SpiderFlatEntity.DATA_patreon_reskin,
                                 (int)(entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                    .getOrCreateTag()
                                    .getDouble("patreon_reskin")
                              );
                        }

                        if (entity instanceof LivingEntity _entityx) {
                           ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.SPIDER_JAR.get()).copy();
                           _setstack.setCount(1);
                           _entityx.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entityx instanceof Player _playerx) {
                              _playerx.getInventory().setChanged();
                           }
                        }
                     }
                  }
               );
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SPIDER_JUMP_JAR.get()
               && world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_JUMP.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                        if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getOrCreateTag()
                           .getBoolean("peacock")) {
                           Entity patt27850$temp = world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null);
                           if (patt27850$temp instanceof SpiderJumpEntity animatable) {
                              animatable.setTexture("spiderjumpingrare");
                           }
                        } else {
                           Entity patt28348$temp = world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null);
                           if (patt28348$temp instanceof SpiderJumpEntity animatable) {
                              animatable.setTexture("spiderjumping");
                           }
                        }

                        Entity patt28830$temp = world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt28830$temp instanceof TamableAnimal _toTame && entity instanceof Player _owner) {
                           _toTame.tame(_owner);
                        }

                        if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                           .getDisplayName()
                           .getString()
                           .contains("Spider Jump Jar")) {
                           world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(Component.literal(entity.getDisplayName().getString() + "'s Spider Jump"));
                        } else {
                           world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(
                                 Component.literal(
                                    (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                       .getDisplayName()
                                       .getString()
                                       .replace("]", "")
                                       .replace("[", "")
                                 )
                              );
                        }

                        patt28830$temp = world.getEntitiesOfClass(SpiderJumpEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y, z))
                           .findFirst()
                           .orElse(null);
                        if (patt28830$temp instanceof LivingEntity _entityxx) {
                           _entityxx.setHealth(
                              (float)(entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                                 .getOrCreateTag()
                                 .getDouble("spiderhealth")
                           );
                        }

                        if (entity instanceof LivingEntity _entityx) {
                           ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.SPIDER_JAR.get()).copy();
                           _setstack.setCount(1);
                           _entityx.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entityx instanceof Player _playerx) {
                              _playerx.getInventory().setChanged();
                           }
                        }
                     }
                  }
               );
            }

            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.SPIDER_MOTH_SUMMONER.get()
               && (
                  !(entity instanceof Player _plrCldCheck130)
                     || !_plrCldCheck130.getCooldowns()
                        .isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())
               )
               && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .moth_summon_active
                  <= 0.0) {
               if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                     .smshealth
                  > 60.0) {
                  if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_MOTH_SUMMON.get())
                        .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setYRot(0.1F);
                        entityToSpawn.setYBodyRot(0.1F);
                        entityToSpawn.setYHeadRot(0.1F);
                        entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                     }
                  }

                  ArphexMod.queueServerWork(
                     1,
                     () -> {
                        if (!world.getEntitiesOfClass(SpiderMothSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true)
                           .isEmpty()) {
                           Entity patt32841$temp = world.getEntitiesOfClass(
                                 SpiderMothSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true
                              )
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y + 1.0, z))
                              .findFirst()
                              .orElse(null);
                           if (patt32841$temp instanceof TamableAnimal _toTame && entity instanceof Player _owner) {
                              _toTame.tame(_owner);
                           }

                           Entity patt33361$temp = world.getEntitiesOfClass(
                                 SpiderMothSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true
                              )
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y + 1.0, z))
                              .findFirst()
                              .orElse(null);
                           if (patt33361$temp instanceof LivingEntity _entityx) {
                              _entityx.setHealth(
                                 (float)((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .smshealth
                              );
                           }

                           if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getDisplayName()
                              .getString()
                              .replace("]", "")
                              .replace("[", "")
                              .equals("Spider Moth Portal")) {
                              world.getEntitiesOfClass(SpiderMothSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y + 1.0, z))
                                 .findFirst()
                                 .orElse(null)
                                 .setCustomName(Component.literal(entity.getDisplayName().getString() + "'s Spider Moth Summon"));
                           } else {
                              world.getEntitiesOfClass(SpiderMothSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y + 1.0, z))
                                 .findFirst()
                                 .orElse(null)
                                 .setCustomName(
                                    Component.literal(
                                       (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                                          .getDisplayName()
                                          .getString()
                                          .replace("]", "")
                                          .replace("[", "")
                                    )
                                 );
                           }
                        }

                        if (entity instanceof Player _playerx) {
                           _playerx.getCooldowns()
                              .addCooldown((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
                        }
                     }
                  );
               } else {
                  ArphexMod.queueServerWork(3, () -> {
                     if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                        _playerx.displayClientMessage(Component.literal("Your summon needs to recover health before it can return..."), true);
                     }
                  });
               }
            }
         }

         if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TORMENTOR_SUMMONER.get()
            && (
               !(entity instanceof Player _plrCldCheck154)
                  || !_plrCldCheck154.getCooldowns()
                     .isOnCooldown((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem())
            )
            && ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .tormentor_summon_active
               <= 0.0) {
            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .tmshealth
               > 60.0) {
               if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR_SUMMON.get())
                     .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(0.1F);
                     entityToSpawn.setYBodyRot(0.1F);
                     entityToSpawn.setYHeadRot(0.1F);
                     entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
                  }
               }

               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (!world.getEntitiesOfClass(TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                        Entity patt37168$temp = world.getEntitiesOfClass(
                              TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y + 1.0, z))
                           .findFirst()
                           .orElse(null);
                        if (patt37168$temp instanceof TamableAnimal _toTame && entity instanceof Player _owner) {
                           _toTame.tame(_owner);
                        }

                        Entity patt37681$temp = world.getEntitiesOfClass(
                              TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y + 1.0, z))
                           .findFirst()
                           .orElse(null);
                        if (patt37681$temp instanceof LivingEntity _entityx) {
                           _entityx.setHealth(
                              (float)((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                    .orElse(new ArphexModVariables.PlayerVariables()))
                                 .tmshealth
                           );
                        }

                        patt37681$temp = world.getEntitiesOfClass(
                              TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true
                           )
                           .stream()
                           .sorted((new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                              }
                           }).compareDistOf(x, y + 1.0, z))
                           .findFirst()
                           .orElse(null);
                        if (patt37681$temp instanceof TormentorSummonEntity _datEntSetI) {
                           _datEntSetI.getEntityData()
                              .set(
                                 TormentorSummonEntity.DATA_patreon_reskin,
                                 (int)((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                       .orElse(new ArphexModVariables.PlayerVariables()))
                                    .player_persistent_patreon_torversion
                              );
                        }

                        if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getDisplayName()
                           .getString()
                           .replace("]", "")
                           .replace("[", "")
                           .equals("§e§lTormentor Summoner")) {
                           world.getEntitiesOfClass(TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y + 1.0, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(Component.literal("§e§l" + entity.getDisplayName().getString() + "'s Tormentor Summon"));
                        } else if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getDisplayName()
                           .getString()
                           .replace("]", "")
                           .replace("[", "")
                           .startsWith("§e§l")) {
                           world.getEntitiesOfClass(TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y + 1.0, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(
                                 Component.literal(
                                    (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY)
                                       .getDisplayName()
                                       .getString()
                                       .replace("]", "")
                                       .replace("[", "")
                                 )
                              );
                        } else {
                           world.getEntitiesOfClass(TormentorSummonEntity.class, AABB.ofSize(new Vec3(x, y + 1.0, z), 20.0, 20.0, 20.0), e -> true)
                              .stream()
                              .sorted((new Object() {
                                 Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                 }
                              }).compareDistOf(x, y + 1.0, z))
                              .findFirst()
                              .orElse(null)
                              .setCustomName(
                                 Component.literal(
                                    "§e§l"
                                       + (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                                          .getDisplayName()
                                          .getString()
                                          .replace("]", "")
                                          .replace("[", "")
                                 )
                              );
                        }
                     }

                     if (entity instanceof Player _playerx) {
                        _playerx.getCooldowns()
                           .addCooldown((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
                     }
                  }
               );
            } else {
               ArphexMod.queueServerWork(3, () -> {
                  if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                     _playerx.displayClientMessage(Component.literal("Your summon needs to recover health before it can return..."), true);
                  }
               });
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.BUG_REPELLANT.get()) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.REPELLANT.get())
                  .spawn(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(0.1F);
                  entityToSpawn.setYBodyRot(0.1F);
                  entityToSpawn.setYHeadRot(0.1F);
                  entityToSpawn.setDeltaMovement(0.05, 0.0, 0.0);
               }
            }

            if (!entity.getPersistentData().getBoolean("creativespectator")) {
               (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
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
                        "give @s glass_bottle"
                     );
               }
            }

            ArphexMod.queueServerWork(
               5,
               () -> {
                  if (!world.getEntitiesOfClass(RepellantEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true).isEmpty()) {
                     Entity patt43121$temp = world.getEntitiesOfClass(RepellantEntity.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                           }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                     if (patt43121$temp instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                        _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get(), 1200, 1, false, false));
                     }
                  }
               }
            );
         }

         if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && entity.getY() > 255.0
            && !entity.isShiftKeyDown()
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.CRAWLING_BARRIER.get()) {
            if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
               ResourceKey<Level> destinationType = Level.OVERWORLD;
               if (_player.level().dimension() == destinationType) {
                  return;
               }

               ServerLevel nextLevel = _player.server.getLevel(destinationType);
               if (nextLevel != null) {
                  _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0.0F));
                  _player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
                  _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));

                  for (MobEffectInstance _effectinstance : _player.getActiveEffects()) {
                     _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
                  }

                  _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 0, false, false));
            }
         }

         if ((
               (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_CRYSTAL.get()
                  || (Boolean)ConfigurationSettingsConfiguration.CRAWLING_ONLY.get()
            )
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ArphexModBlocks.CRAWLING_ALTAR.get()) {
            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.END_ROD) {
               if (world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == Blocks.BEDROCK) {
                  if (world.getBlockState(BlockPos.containing(x + 5.0, y + 1.0, z)).getBlock() == ArphexModBlocks.SCORCH.get()
                     || (Boolean)ConfigurationSettingsConfiguration.CRAWLING_ONLY.get()) {
                     if (world.getBlockState(BlockPos.containing(x - 5.0, y + 1.0, z)).getBlock() == ArphexModBlocks.SCORCH.get()
                        || (Boolean)ConfigurationSettingsConfiguration.CRAWLING_ONLY.get()) {
                        if (world.getBlockState(BlockPos.containing(x, y + 1.0, z + 5.0)).getBlock() == ArphexModBlocks.SCORCH.get()
                           || (Boolean)ConfigurationSettingsConfiguration.CRAWLING_ONLY.get()) {
                           if (world.getBlockState(BlockPos.containing(x, y + 1.0, z - 5.0)).getBlock() != ArphexModBlocks.SCORCH.get()
                              && !(Boolean)ConfigurationSettingsConfiguration.CRAWLING_ONLY.get()) {
                              if (entity instanceof Player _player && !_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal("The pillars are not all lit"), true);
                              }
                           } else {
                              if (entity instanceof ServerPlayer _player) {
                                 Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:crawling_portal_activated"));
                                 AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                 if (!_ap.isDone()) {
                                    for (String criteria : _ap.getRemainingCriteria()) {
                                       _player.getAdvancements().award(_adv, criteria);
                                    }
                                 }
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(x, y - 1.0, z),
                                             Vec2.ZERO,
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "fill ~-2 ~ ~-2 ~2 ~ ~2 arphex:crawling_portal"
                                    );
                              }

                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(x, y - 2.0, z),
                                             Vec2.ZERO,
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "fill ~-2 ~ ~-2 ~2 ~ ~2 bedrock"
                                    );
                              }

                              world.setBlock(BlockPos.containing(x + 3.0, y - 2.0, z), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 4.0, y - 2.0, z), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 3.0, y - 2.0, z), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 4.0, y - 2.0, z), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 2.0, z + 3.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 2.0, z + 4.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 2.0, z - 3.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 2.0, z - 4.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 1.0, y - 2.0, z + 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 1.0, y - 2.0, z - 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 1.0, y - 2.0, z + 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 1.0, y - 2.0, z - 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 3.0, y - 2.0, z - 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 3.0, y - 2.0, z + 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 1.0, y - 2.0, z - 3.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 1.0, y - 2.0, z - 3.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 3.0, y - 2.0, z - 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 3.0, y - 2.0, z + 1.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 1.0, y - 2.0, z + 3.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 1.0, y - 2.0, z + 3.0), Blocks.BEDROCK.defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 3.0, y - 1.0, z), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x + 4.0, y - 1.0, z), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 3.0, y - 1.0, z), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x - 4.0, y - 1.0, z), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 1.0, z + 3.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 1.0, z + 4.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 1.0, z - 3.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(BlockPos.containing(x, y - 1.0, z - 4.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3);
                              world.setBlock(
                                 BlockPos.containing(x + 1.0, y - 1.0, z + 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x + 1.0, y - 1.0, z - 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x - 1.0, y - 1.0, z + 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x - 1.0, y - 1.0, z - 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x - 3.0, y - 1.0, z - 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x - 3.0, y - 1.0, z + 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x - 1.0, y - 1.0, z - 3.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x + 1.0, y - 1.0, z - 3.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x + 3.0, y - 1.0, z - 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x + 3.0, y - 1.0, z + 1.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x - 1.0, y - 1.0, z + 3.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(
                                 BlockPos.containing(x + 1.0, y - 1.0, z + 3.0), ((Block)ArphexModBlocks.CRAWLING_PORTAL.get()).defaultBlockState(), 3
                              );
                              world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                              if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                                 LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                                 entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                                 entityToSpawn.setVisualOnly(true);
                                 _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.addFreshEntity(entityToSpawn);
                              }

                              if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                                 _playerx.displayClientMessage(Component.literal("§c§lBEWARE: PROT 4 NETHERITE OR ABOVE RECOMMENDED BEFORE ENTERING"), true);
                              }

                              if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                                 _playerx.displayClientMessage(Component.literal("§c§lBEWARE: PROT 4 NETHERITE OR ABOVE RECOMMENDED BEFORE ENTERING"), false);
                              }
                           }
                        } else if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                           _playerx.displayClientMessage(Component.literal("The pillars are not all lit"), true);
                        }
                     } else if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                        _playerx.displayClientMessage(Component.literal("The pillars are not all lit"), true);
                     }
                  } else if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                     _playerx.displayClientMessage(Component.literal("The pillars are not all lit"), true);
                  }
               } else if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                  _playerx.displayClientMessage(Component.literal("Bedrock missing"), true);
               }
            } else if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("End rod missing"), true);
            }
         }

         if (blockstate.getBlock() == ArphexModBlocks.SCORCH_TORCH_WALL.get() || blockstate.getBlock() == ArphexModBlocks.SCORCH_TORCH_GROUND.get()) {
            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.SCORCH_FLAME.get(), x + 0.5, y + 0.5, z + 0.5, 30, 0.1, 0.1, 0.1, 0.05
               );
            }

            if (world instanceof ServerLevel _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
               _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.GOLDEN_OPAL.get(), x + 0.5, y + 0.5, z + 0.5, 5, 0.1, 0.1, 0.1, 0.05
               );
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt283 = (LivingEntity)entityiterator;
                  if (_livEnt283.getMobType() == MobType.ARTHROPOD
                     && (entityiterator instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMaxHealth() : -1.0F) <= 30.0F) {
                     if ((entityiterator instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null && entityiterator instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(x, y, z, 1.0);
                     }

                     if (entityiterator instanceof ButterflyBewitcherEntity
                        || entityiterator instanceof FlyFestererEntity
                        || entityiterator instanceof LocustLandscourgeEntity) {
                        entityiterator.lookAt(Anchor.EYES, new Vec3(x, y, z));
                        entityiterator.setDeltaMovement(
                           new Vec3(entityiterator.getLookAngle().x, entityiterator.getLookAngle().y, entityiterator.getLookAngle().z)
                        );
                     }
                  }
               }
            }
         }

         if (entity.getName().getString().equals("Vllax")
            && direction == Direction.UP
            && (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
            if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("You need to sneak"), true);
            }

            if (entity.isShiftKeyDown()) {
               if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                  _playerx.displayClientMessage(Component.literal("Given self maximum gear - remember you can use any command with vxc (command)"), false);
               }

               if (entity instanceof Player _playerx) {
                  _playerx.getInventory().armor.set(3, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_HELMET.get()));
                  _playerx.getInventory().setChanged();
               } else if (entity instanceof LivingEntity _living) {
                  _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_HELMET.get()));
               }

               if (entity instanceof Player _playerx) {
                  _playerx.getInventory().armor.set(2, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_CHESTPLATE.get()));
                  _playerx.getInventory().setChanged();
               } else if (entity instanceof LivingEntity _living) {
                  _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_CHESTPLATE.get()));
               }

               if (entity instanceof Player _playerx) {
                  _playerx.getInventory().armor.set(1, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_LEGGINGS.get()));
                  _playerx.getInventory().setChanged();
               } else if (entity instanceof LivingEntity _living) {
                  _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_LEGGINGS.get()));
               }

               if (entity instanceof Player _playerx) {
                  _playerx.getInventory().armor.set(0, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_BOOTS.get()));
                  _playerx.getInventory().setChanged();
               } else if (entity instanceof LivingEntity _living) {
                  _living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)ArphexModItems.IMMORTAL_BOOTS.get()));
               }

               if (entity instanceof LivingEntity _entity) {
                  ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.INFINITE_TORMENT.get()).copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player _playerx) {
                     _playerx.getInventory().setChanged();
                  }
               }

               if (entity instanceof LivingEntity _entityx) {
                  ItemStack _setstack = new ItemStack((ItemLike)ArphexModItems.INFINITE_TORMENT.get()).copy();
                  _setstack.setCount(1);
                  _entityx.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_entityx instanceof Player _playerx) {
                     _playerx.getInventory().setChanged();
                  }
               }

               (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                  .enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4);
               (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                  .enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4);
               (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                  .enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4);
               (entity instanceof LivingEntity _entGetArmorxxx ? _entGetArmorxxx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                  .enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4);
            }
         }

         if (blockstate.is(BlockTags.create(new ResourceLocation("minecraft:beds")))
            && entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("§cRespawn point set in the crawling"), true);
            }

            if (entity instanceof ServerPlayer _serverPlayer) {
               _serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(x, y, z), _serverPlayer.getYRot(), true, false);
            }
         }

         if ((entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ArphexModItems.SINGULARITY_SCYTHE.get()
            && (
               !(entity instanceof Player _plrCldCheck328)
                  || !_plrCldCheck328.getCooldowns()
                     .isOnCooldown((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem())
            )
            && entity instanceof Player _playerx) {
            _playerx.getCooldowns()
               .addCooldown((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 5);
         }
      }
   }
}
