package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ScorpioidKillProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof Mob) {
            try {
               ((Mob)entity).setTarget(null);
            } catch (Exception var13) {
               var13.printStackTrace();
            }
         }

         if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
               _level.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.hurt")),
                  SoundSource.HOSTILE,
                  0.5F,
                  -5.0F
               );
            } else {
               _level.playLocalSound(
                  x,
                  y,
                  z,
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.hurt")),
                  SoundSource.HOSTILE,
                  0.5F,
                  -5.0F,
                  false
               );
            }
         }

         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player && !entity.getPersistentData().getBoolean("creativespectator")) {
               String _setval = "true";
               entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.ShowOverlay2 = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
               ArphexMod.queueServerWork(5, () -> {
                  String _setvalx = "false";
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.ShowOverlay2 = _setvalx;
                     capability.syncPlayerVariables(entityiterator);
                  });
               });
            }
         }

         if (world instanceof Level _levelx) {
            if (!_levelx.isClientSide()) {
               _levelx.playSound(
                  null,
                  BlockPos.containing(x, y, z),
                  (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")),
                  SoundSource.HOSTILE,
                  0.6F,
                  -5.0F
               );
            } else {
               _levelx.playLocalSound(
                  x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:mothscare")), SoundSource.HOSTILE, 0.6F, -5.0F, false
               );
            }
         }

         if ((!world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z)) || !world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z)))
            && world instanceof ServerLevel _levelxx) {
            _levelxx.sendParticles((SimpleParticleType)ArphexModParticleTypes.SOLID_SMOKE.get(), x, y, z, 40, 0.4, 0.4, 0.4, 0.2);
         }
      }
   }
}
