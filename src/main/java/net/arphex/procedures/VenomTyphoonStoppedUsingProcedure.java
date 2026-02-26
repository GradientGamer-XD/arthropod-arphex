package net.arphex.procedures;

import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class VenomTyphoonStoppedUsingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity.getPersistentData().getString("hornetlock_uuids").length() > 4) {
            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzlong")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     0.5F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:hornetbuzzlong")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     0.5F,
                     false
                  );
               }
            }

            for (int index0 = 0; index0 < 8; index0++) {
               if (world instanceof ServerLevel) {
                  ServerLevel _levelx = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)ArphexModEntities.NEMESIS_PROJECTILE.get())
                     .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(entity.getYRot());
                     entityToSpawn.setYBodyRot(entity.getYRot());
                     entityToSpawn.setYHeadRot(entity.getYRot());
                     entityToSpawn.setXRot(entity.getXRot());
                     entityToSpawn.setDeltaMovement(entity.getLookAngle().x * 2.0, entity.getLookAngle().y * 2.0, entity.getLookAngle().z * 2.0);
                  }
               }
            }
         } else {
            if (entity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("No targets were locked"), true);
            }

            if (entity instanceof Player _player) {
               _player.getCooldowns().addCooldown(itemstack.getItem(), 5);
            }
         }
      }
   }
}
