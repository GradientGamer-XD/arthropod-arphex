package net.arphex.procedures;

import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class GravitonHitsEntityProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         if ((!(entity instanceof TamableAnimal _tamIsTamedBy) || !(sourceentity instanceof LivingEntity _livEnt) || !_tamIsTamedBy.isOwnedBy(_livEnt))
            && entity != sourceentity) {
            if (entity instanceof TORMENTOREntity) {
               if (!immediatesourceentity.getPersistentData().getBoolean("done_torhit")) {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                     108.0F
                  );
               }

               immediatesourceentity.getPersistentData().putBoolean("done_torhit", true);
            } else if ((!(entity instanceof LivingEntity _livEnt7) || !_livEnt7.isBlocking())
               && (entity instanceof LivingEntity _entUseItem8 ? _entUseItem8.getUseItem() : ItemStack.EMPTY).getItem() != ArphexModItems.ABYSS_ASCENDANT.get()
               )
             {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                  Math.max(17.0F, (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 7.0F)
               );
            }
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
