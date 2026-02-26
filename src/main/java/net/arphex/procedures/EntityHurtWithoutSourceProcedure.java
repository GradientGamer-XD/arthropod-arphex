package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.entity.ArthropleuraAbominationEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.HitboxExpanderEntity;
import net.arphex.entity.SegmentedBodyEntity;
import net.arphex.entity.SmallTormentSphereEntity;
import net.arphex.entity.SummonSunBlastEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TeleportGhostEntity;
import net.arphex.entity.TormentorHitboxEntity;
import net.arphex.entity.TormentorMothSummonEntity;
import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.arphex.entity.TormentorShieldEntity;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTestEntity;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityHurtWithoutSourceProcedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(
            event,
            event.getEntity().level(),
            event.getEntity().getX(),
            event.getEntity().getY(),
            event.getEntity().getZ(),
            event.getSource(),
            event.getEntity(),
            (double)event.getAmount()
         );
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, double amount) {
      execute(null, world, x, y, z, damagesource, entity, amount);
   }

   private static void execute(
      @Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, double amount
   ) {
      if (damagesource != null && entity != null) {
         if (damagesource.getEntity() == null) {
            if (entity instanceof TormentorShieldEntity && event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof HitboxExpanderEntity && event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if ((
                  entity instanceof TormentorTestEntity
                     || entity instanceof TormentorT2Entity
                     || entity instanceof TormentorT3Entity
                     || entity instanceof TormentorT4Entity
                     || entity instanceof TormentorT5Entity
               )
               && !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))
               && event != null
               && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof Player) {
               if ((damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.PLAYER_EXPLOSION))
                  && (
                     (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.TORMENTED_WRATH.get()
                        || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.TORMENTED_WRATH.get()
                  )
                  && event != null
                  && event.isCancelable()) {
                  event.setCanceled(true);
               }

               if (damagesource.is(DamageTypes.IN_WALL)) {
                  if ((
                        (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                              == ArphexModItems.ETHEREAL_STAFF.get()
                           || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                              == ArphexModItems.ETHEREAL_STAFF.get()
                     )
                     && event != null
                     && event.isCancelable()) {
                     event.setCanceled(true);
                  }

                  if (entity.isPassenger() && entity.getVehicle() instanceof TormentorSummonEntity && event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               }
            }

            if (entity instanceof DiabolosDecimatorEntity) {
               if (amount > 20.0 && !(amount > 9.99999999E8)) {
                  if (event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }

                  entity.hurt(damagesource, 20.0F);
               }

               if (!(entity instanceof LivingEntity _livEnt27) || !_livEnt27.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
                  ArphexMod.queueServerWork(1, () -> {
                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 40, 0, false, false));
                     }
                  });
               }
            }

            if (entity instanceof LivingEntity _livEnt30
               && _livEnt30.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())
               && !(amount > 9.99999999E8)
               && event != null
               && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof TORMENTOREntity || entity instanceof TormentorHitboxEntity) {
               if (amount > 9.99999999E8) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "arphex despawn @e[type=arphex:tormentor_test]"
                        );
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  ArphexModVariables.MapVariables.get(world).tormentor_health = 0.0;
                  ArphexModVariables.MapVariables.get(world).syncData(world);
                  if (!(ArphexModVariables.MapVariables.get(world).tormentor_seal_limit > 0.0)) {
                     if (!world.isClientSide() && world.getServer() != null) {
                        world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Tormentor Sealed"), false);
                     }

                     ArphexModVariables.MapVariables.get(world).tormentor_seal_limit = 2000.0;
                     ArphexModVariables.MapVariables.get(world).syncData(world);
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof ItemEntity
                        && (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()
                           == ArphexModItems.CORE_OF_ETERNAL_SUFFERING.get()
                        && !entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                     }
                  }
               } else if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            }

            if ((
                  entity instanceof TormentorMothSummonEntity
                     || entity instanceof TormentorScorpioidSummonEntity
                     || entity instanceof TormentorVoidlasherSummonEntity
               )
               && damagesource.is(DamageTypes.IN_WALL)
               && event != null
               && event.isCancelable()) {
               event.setCanceled(true);
            }

            if ((entity instanceof TeleportGhostEntity || entity instanceof AntArsonistWorkerEntity)
               && damagesource.is(DamageTypes.IN_WALL)
               && event != null
               && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (damagesource.is(DamageTypes.FLY_INTO_WALL)
               && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                  == ArphexModItems.ETERNAL_CHESTPLATE.get()
               && event != null
               && event.isCancelable()) {
               event.setCanceled(true);
            }

            if ((entity instanceof TormentorSphereEntity || entity instanceof SummonSunBlastEntity || entity instanceof SmallTormentSphereEntity)
               && amount < 9.99999999E8
               && event != null
               && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof SegmentedBodyEntity) {
               if (damagesource.is(DamageTypes.IN_WALL)) {
                  if (event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               } else if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))) {
                  if (event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }

                  entity.getPersistentData().putDouble("segdamagetransfer", amount);
                  entity.hurt(
                     new DamageSource(
                        world.registryAccess()
                           .registryOrThrow(Registries.DAMAGE_TYPE)
                           .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))
                     ),
                     0.0F
                  );
               }
            }

            if (entity instanceof ArthropleuraAbominationEntity) {
               entity.getPersistentData().putDouble("segupwardstransfer", 1.0);
            }
         }
      }
   }
}
