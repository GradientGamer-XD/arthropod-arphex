package net.arphex.procedures;

import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class TormentorHitboxOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double tormentor_distance = 0.0;
         boolean slow_self = false;
         if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get())) {
            ArphexModVariables.MapVariables.get(world).limhit_tormentor = false;
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeAllEffects();
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.setHealth((float)ArphexModVariables.MapVariables.get(world).tormentor_health);
         }

         ArphexModVariables.MapVariables.get(world).tormentor_hitbox_split = 5.0;
         ArphexModVariables.MapVariables.get(world).syncData(world);
         tormentor_distance = Math.sqrt(
            (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x) * (entity.getX() - ArphexModVariables.MapVariables.get(world).tormentor_x)
               + (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
                  * (entity.getY() - ArphexModVariables.MapVariables.get(world).tormentor_y)
               + (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
                  * (entity.getZ() - ArphexModVariables.MapVariables.get(world).tormentor_z)
         );
         entity.lookAt(
            Anchor.EYES,
            new Vec3(
               ArphexModVariables.MapVariables.get(world).tormentor_x,
               ArphexModVariables.MapVariables.get(world).tormentor_y,
               ArphexModVariables.MapVariables.get(world).tormentor_z
            )
         );
         entity.teleportTo(entity.getX(), ArphexModVariables.MapVariables.get(world).tormentor_y + 15.0, entity.getZ());
         if (entity instanceof ServerPlayer _serverPlayer) {
            _serverPlayer.connection
               .teleport(entity.getX(), ArphexModVariables.MapVariables.get(world).tormentor_y + 15.0, entity.getZ(), entity.getYRot(), entity.getXRot());
         }

         entity.setDeltaMovement(
            new Vec3(
               Math.cos(((double)entity.getYRot() + tormentor_distance - 50.0) * (Math.PI / 180.0)) / 1.5,
               0.0,
               Math.sin(((double)entity.getYRot() + tormentor_distance - 50.0) * (Math.PI / 180.0)) / 1.5
            )
         );
         if ((tormentor_distance > 100.0 || ArphexModVariables.MapVariables.get(world).tormentor_tier == 1.0) && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.getPersistentData().putBoolean("tormentor_target", false);
         if (!(ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0) && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (!ArphexModVariables.MapVariables.get(world).tormentor_animode.equals("splay") && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (ArphexModVariables.MapVariables.get(world).tormentor_health < 51.0 && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
