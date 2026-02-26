package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChitinArmourChestplateTickEventProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof TamableAnimal) {
               TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0, false, false));
                        }
                     }

                     if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_TIER_2_CHESTPLATE.get() && entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0, false, false));
                        }
                     }

                     if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_TIER_3_CHESTPLATE.get()
                        || itemstack.getItem() == ArphexModItems.JUGGERNAUT_CHESTPLATE.get()) {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0, false, false));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt10 = (LivingEntity)entityiterator;
                           if (_livEnt10.hasEffect(MobEffects.REGENERATION)) {
                              continue;
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false));
                           }
                        }
                     }
                  }
               }
            }
         }

         if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_TIER_3_CHESTPLATE.get() || itemstack.getItem() == ArphexModItems.JUGGERNAUT_CHESTPLATE.get()) {
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
                     "item modify entity @s armor.chest {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
                  );
            }

            itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         }

         if (itemstack.getItem() == ArphexModItems.JUGGERNAUT_CHESTPLATE.get()
            && entity.isShiftKeyDown()
            && (entity instanceof LivingEntity _entGetArmorxx ? _entGetArmorxx.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
               == ArphexModItems.JUGGERNAUT_HELMET.get()
            && (entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
               == ArphexModItems.JUGGERNAUT_LEGGINGS.get()
            && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
               == ArphexModItems.JUGGERNAUT_BOOTS.get()
            && entity instanceof LivingEntity _entity
            && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, 1, false, false));
         }
      }
   }
}
