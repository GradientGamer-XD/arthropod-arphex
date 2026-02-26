package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.SkyStalkerEntity;
import net.arphex.entity.SpiderBroodEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.SpiderMothLarvaeEntity;
import net.arphex.entity.TeleportGhostEntity;
import net.arphex.entity.TinyCentipedeBreacherEntity;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SpiderShieldProcedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingHurtEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(
            event,
            event.getEntity().level(),
            event.getEntity().getX(),
            event.getEntity().getY(),
            event.getEntity().getZ(),
            event.getSource(),
            event.getEntity(),
            event.getSource().getEntity(),
            (double)event.getAmount()
         );
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
      execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
   }

   private static void execute(
      @Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount
   ) {
      if (damagesource != null && entity != null && sourceentity != null) {
         if (sourceentity instanceof Player
            && sourceentity.getPersistentData().getDouble("lensmode") > 0.0
            && sourceentity != entity
            && (double)(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > sourceentity.getPersistentData().getDouble("source_damage")) {
            sourceentity.getPersistentData().putDouble("source_damage", entity instanceof LivingEntity _livEntx ? (double)_livEntx.getHealth() : -1.0);
         }

         if (entity instanceof SpiderMothEntity && sourceentity instanceof SpiderMothLarvaeEntity && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         if ((entity instanceof SpiderMothEntity || entity instanceof CentipedeEvictorEntity)
            && amount > 25.0
            && amount < 250.0
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 26.0F) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.setHealth((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) - 25.0F);
            }
         }

         if (entity instanceof SpiderMothEntity
            && (entity instanceof SpiderMothEntity animatable ? animatable.getTexture() : "null").equals("redglow")
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof TeleportGhostEntity && damagesource.isIndirect() && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof SpiderMothLarvaeEntity && Mth.nextInt(RandomSource.create(), 1, 8) == 8) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles(ParticleTypes.SMOKE, x, y, z, 80, 3.0, 3.0, 3.0, 1.0);
            }

            entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -1.0, 1.0), 0.0, Mth.nextDouble(RandomSource.create(), -1.0, 1.0)));
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (entity instanceof TeleportGhostEntity
            && new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_WALL)).isIndirect()
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof SkyStalkerEntity && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof SpiderMothEntity && sourceentity instanceof SpiderMothLarvaeEntity && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof TinyCentipedeBreacherEntity && damagesource.isIndirect() && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (entity instanceof SpiderBroodEntity && amount > 0.0) {
            if (world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.3, 0.0, 0.0);
               }
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.SPIDER_LARVAE_TINY.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(-0.3, 0.0, 0.0);
               }
            }
         }

         if ((entity instanceof LivingEntity _entGetArmorxxx ? _entGetArmorxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_BOOTS.get()
            && (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_LEGGINGS.get()
            && (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_CHESTPLATE.get()
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_HELMET.get()
            && (
               Math.atan2(sourceentity.getX() - entity.getX(), sourceentity.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot() > 120.0
                  || Math.atan2(sourceentity.getX() - entity.getX(), sourceentity.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot() < -120.0
            )) {
            ((LivingHurtEvent)event).setAmount((float)((double)((LivingHurtEvent)event).getAmount() * 0.9));
            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.2);
            }
         }

         if ((entity instanceof LivingEntity _entGetArmorxxxxxxx ? _entGetArmorxxxxxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_TIER_2_BOOTS.get()
            && (entity instanceof LivingEntity _entGetArmorxxxxxx ? _entGetArmorxxxxxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_TIER_2_LEGGINGS.get()
            && (entity instanceof LivingEntity _entGetArmorxxxxx ? _entGetArmorxxxxx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_TIER_2_CHESTPLATE.get()
            && (entity instanceof LivingEntity _entGetArmorxxxx ? _entGetArmorxxxx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
               == ArphexModItems.CHITIN_ARMOUR_TIER_2_HELMET.get()
            && (
               Math.atan2(sourceentity.getX() - entity.getX(), sourceentity.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot() > 120.0
                  || Math.atan2(sourceentity.getX() - entity.getX(), sourceentity.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot() < -120.0
            )) {
            ((LivingHurtEvent)event).setAmount((float)((double)((LivingHurtEvent)event).getAmount() * 0.8));
            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.2);
            }
         }

         if ((
               (entity instanceof LivingEntity _entGetArmorxxxxxxxxxxxxxxx ? _entGetArmorxxxxxxxxxxxxxxx.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                        .getItem()
                     == ArphexModItems.CHITIN_ARMOUR_TIER_3_BOOTS.get()
                  || (entity instanceof LivingEntity _entGetArmorxxxxxxxxxxxxxx
                           ? _entGetArmorxxxxxxxxxxxxxx.getItemBySlot(EquipmentSlot.FEET)
                           : ItemStack.EMPTY)
                        .getItem()
                     == ArphexModItems.JUGGERNAUT_BOOTS.get()
            )
            && (
               (entity instanceof LivingEntity _entGetArmorxxxxxxxxxxxxx ? _entGetArmorxxxxxxxxxxxxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                           .getItem()
                        == ArphexModItems.CHITIN_ARMOUR_TIER_3_LEGGINGS.get()
                     && (entity instanceof LivingEntity _entGetArmorxxxxxxxxxxxx
                              ? _entGetArmorxxxxxxxxxxxx.getItemBySlot(EquipmentSlot.CHEST)
                              : ItemStack.EMPTY)
                           .getItem()
                        == ArphexModItems.CHITIN_ARMOUR_TIER_3_CHESTPLATE.get()
                     && (entity instanceof LivingEntity _entGetArmorxxxxxxxxxxx ? _entGetArmorxxxxxxxxxxx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                           .getItem()
                        == ArphexModItems.CHITIN_ARMOUR_TIER_3_HELMET.get()
                  || (entity instanceof LivingEntity _entGetArmorxxxxxxxxxx ? _entGetArmorxxxxxxxxxx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                           .getItem()
                        == ArphexModItems.JUGGERNAUT_LEGGINGS.get()
                     && (entity instanceof LivingEntity _entGetArmorxxxxxxxxx ? _entGetArmorxxxxxxxxx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                           .getItem()
                        == ArphexModItems.JUGGERNAUT_CHESTPLATE.get()
                     && (entity instanceof LivingEntity _entGetArmorxxxxxxxx ? _entGetArmorxxxxxxxx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                           .getItem()
                        == ArphexModItems.JUGGERNAUT_HELMET.get()
            )
            && (
               Math.atan2(sourceentity.getX() - entity.getX(), sourceentity.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot() > 120.0
                  || Math.atan2(sourceentity.getX() - entity.getX(), sourceentity.getZ() - entity.getZ()) * 57.5 - 0.0 + (double)entity.getYRot() < -120.0
            )) {
            ((LivingHurtEvent)event).setAmount((float)((double)((LivingHurtEvent)event).getAmount() * 0.6));
            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARCOAL.get(), x, y, z, 5, 0.3, 0.3, 0.3, 0.2);
            }
         }

         if (sourceentity instanceof Player
            && ((ArphexModVariables.PlayerVariables)sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .inherent_power_cooldown
               > 10800.0) {
            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles(ParticleTypes.ELECTRIC_SPARK, entity.getX(), entity.getY(), entity.getZ(), 10, 0.15, 0.15, 0.15, 0.2);
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles(ParticleTypes.SWEEP_ATTACK, entity.getX(), entity.getY(), entity.getZ(), 2, 0.15, 0.15, 0.15, 0.2);
            }

            if (world instanceof ServerLevel _levelxx) {
               _levelxx.sendParticles(
                  (SimpleParticleType)ArphexModParticleTypes.HEAVY_GOLD_SMOKE.get(), entity.getX(), entity.getY(), entity.getZ(), 2, 0.15, 0.15, 0.15, 0.2
               );
            }

            ((LivingHurtEvent)event).setAmount(((LivingHurtEvent)event).getAmount() * 2.0F);
         }

         if (entity instanceof TormentorSphereEntity && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }
      }
   }
}
