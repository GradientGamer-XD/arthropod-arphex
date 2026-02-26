package net.arphex.procedures;

import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class VortexDevastatorToolInInventoryTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player _plrCldCheck1
            && _plrCldCheck1.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem())
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VORTEX_DEVASTATOR.get()) {
            entity.fallDistance = 0.0F;
         }

         if (entity.getPersistentData().getDouble("movingvortex") > 0.0) {
            entity.getPersistentData().putDouble("movingvortex", entity.getPersistentData().getDouble("movingvortex") - 1.0);
            if (Math.abs(entity.getDeltaMovement().x()) < 2.0 && Math.abs(entity.getDeltaMovement().z()) < 2.0) {
               if (entity.isPassenger()) {
                  entity.getVehicle()
                     .setDeltaMovement(
                        new Vec3(
                           entity.getVehicle().getDeltaMovement().x() * 1.5,
                           entity.getVehicle().getDeltaMovement().y() + 0.2,
                           entity.getVehicle().getDeltaMovement().z() * 1.5
                        )
                     );
               } else {
                  entity.setDeltaMovement(
                     new Vec3(entity.getDeltaMovement().x() * 2.0, entity.getDeltaMovement().y() + 0.3, entity.getDeltaMovement().z() * 2.0)
                  );
               }

               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.shoot")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        0.3F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.shoot")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        0.3F,
                        false
                     );
                  }
               }
            }
         }
      }
   }
}
