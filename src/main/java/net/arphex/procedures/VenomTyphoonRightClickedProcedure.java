package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.NemesisProjectileEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VenomTyphoonRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean found = false;
         if (entity.isShiftKeyDown() && entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem())) {
            found = false;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (entityiterator instanceof NemesisProjectileEntity && entityiterator instanceof TamableAnimal) {
                  TamableAnimal _tamIsTamedBy = (TamableAnimal)entityiterator;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_tamIsTamedBy.isOwnedBy(_livEnt)) {
                        if (!entityiterator.level().isClientSide()) {
                           entityiterator.discard();
                        }

                        found = true;
                     }
                  }
               }
            }
         }

         if (found && entity instanceof Player _player && !_player.level().isClientSide()) {
            _player.displayClientMessage(Component.literal("Cancelled all summoned tarantula hawks"), true);
         }
      }
   }
}
