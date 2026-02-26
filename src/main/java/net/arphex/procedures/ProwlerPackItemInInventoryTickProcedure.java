package net.arphex.procedures;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class ProwlerPackItemInInventoryTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double radius = 0.0;
         if (!world.isClientSide()) {
            radius = 12.0;
            if (itemstack.getItem() == ArphexModItems.SINGULARITY_SATCHEL.get()) {
               radius = 18.0;
               if ((new Object() {
                  public ItemStack getItemStack(int sltid, ItemStack _isc) {
                     AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                     _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                     return _retval.get();
                  }
               }).getItemStack(90, itemstack).getItem() == ArphexModItems.MANTLE_OF_VITALITY.get()) {
                  if (entity instanceof LivingEntity _entity) {
                     _entity.removeEffect(MobEffects.WITHER);
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.removeEffect(MobEffects.POISON);
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.removeEffect((MobEffect)ArphexModMobEffects.NECROSIS.get());
                  }
               }

               if ((new Object() {
                  public ItemStack getItemStack(int sltid, ItemStack _isc) {
                     AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                     _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                     return _retval.get();
                  }
               }).getItemStack(91, itemstack).getItem() == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                  entity.getPersistentData().putDouble("has_bane_of_darkness", 5.0);
                  if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()
                     && world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "effect give @e[type=arphex:spider_moth,distance=..30] slowness 1 1"
                        );
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.removeEffect(MobEffects.DARKNESS);
                  }

                  if (entity instanceof Player _plrCldCheck16 && _plrCldCheck16.getCooldowns().isOnCooldown((Item)ArphexModItems.ABYSSAL_PICKAXE.get())
                     || entity instanceof Player _plrCldCheck17 && _plrCldCheck17.getCooldowns().isOnCooldown((Item)ArphexModItems.ABYSS_ATOMISER.get())) {
                     if ((!(entity instanceof LivingEntity _livEnt18) || !_livEnt18.hasEffect(MobEffects.NIGHT_VISION)) && world instanceof ServerLevel _level) {
                        _level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 50, 2.0, 2.0, 2.0, 0.4);
                     }

                     if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0, false, false));
                     }
                  }
               }

               if ((new Object() {
                  public ItemStack getItemStack(int sltid, ItemStack _isc) {
                     AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                     _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                     return _retval.get();
                  }
               }).getItemStack(92, itemstack).getItem() == ArphexModItems.VITALITY_VIEWFINDER.get() && (new Object() {
                  public ItemStack getItemStack(int sltid, ItemStack _isc) {
                     AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                     _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(sltid).copy()));
                     return _retval.get();
                  }
               }).getItemStack(92, itemstack).getOrCreateTag().getBoolean("lensmode")) {
                  entity.getPersistentData().putDouble("lensmode", 5.0);
               }
            }

            if (itemstack.getOrCreateTag().getBoolean("graspmode")) {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof ItemEntity) {
                     entityiterator.setDeltaMovement(
                        new Vec3(
                           (entity.getX() - entityiterator.getX()) / 10.0,
                           (entity.getY() - entityiterator.getY()) / 10.0,
                           (entity.getZ() - entityiterator.getZ()) / 10.0
                        )
                     );
                  }
               }
            }
         }
      }
   }
}
