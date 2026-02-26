package net.arphex.procedures;

import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CrawlingBarrierEntityWalksOnTheBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) < 100.0F) {
            if (entity instanceof LivingEntity _livEnt1
               && _livEnt1.getMobType() == MobType.ARTHROPOD
               && entity instanceof LivingEntity
               && !(entity instanceof TORMENTOREntity)) {
               return;
            }

            label64: {
               if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect((MobEffect)ArphexModMobEffects.CRAWLING.get())) {
                  break label64;
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CRAWLING.get(), 10, 1, false, false));
               }

               if ((entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     != ArphexModItems.ETERNAL_CHESTPLATE.get()
                  && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                     != ArphexModItems.IMMORTAL_CHESTPLATE.get()) {
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 4.0F);
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 1, 0.1, 0.3, 0.1, 0.3);
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 1, 0.1, 0.3, 0.1, 0.3);
            }
         }
      }
   }
}
