package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.init.ArphexModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WarpStaffDirectionOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean done = false;
         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "data merge entity @s {NoAI:1}"
               );
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
         }

         done = false;
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (!done
               && entityiterator instanceof Player
               && (
                  (entityiterator instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.WARP_STAFF.get()
                     || (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.WARP_STAFF.get()
               )) {
               if (entity.getPersistentData().getString("uuidlock").length() <= 2) {
                  entity.getPersistentData().putString("uuidlock", entityiterator.getStringUUID());
               }

               done = true;
               if (entity.getPersistentData().getString("uuidlock").equals(entityiterator.getStringUUID())) {
                  entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()));
                  if (entity.getX() == entityiterator.getX() && entity.getY() == entityiterator.getY() && entity.getZ() == entityiterator.getZ()) {
                     entity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY() - 100.0, entity.getZ()));
                  }

                  entity.teleportTo(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ());
                  if (entity instanceof ServerPlayer _serverPlayer) {
                     _serverPlayer.connection.teleport(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), entity.getYRot(), entity.getXRot());
                  }
               }
            }
         }

         if (!done && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
