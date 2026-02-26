package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
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

public class EtherealStaffRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ETHEREAL_STAFF.get()
            || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ETHEREAL_STAFF.get()) {
            if (entity.isInWall() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 5, 1, false, false));
            }

            if ((entity instanceof LivingEntity _entUseTicks6 ? _entUseTicks6.getTicksUsingItem() : 0) > 0
               && (!(entity instanceof Player _plrCldCheck8) || !_plrCldCheck8.getCooldowns().isOnCooldown(itemstack.getItem()))
               && (
                  entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
                     || !(entity.getY() >= 127.0)
               )) {
               entity.getPersistentData().putDouble("tpheight", entity.getY());
               if ((Boolean)ConfigurationSettingsConfiguration.ALLOW_ETHEREAL_WALL_BYPASS.get()) {
                  if (world instanceof ServerLevel _level) {
                     _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                                 CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                              )
                              .withSuppressedOutput(),
                           "execute at @p run tp @p ^ ^0.01 ^0.5"
                        );
                  }
               } else if (entity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("This ability is disabled in the mod config file"), true);
               }

               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator != entity && entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2, 1, false, false));
                     }
                  }
               }

               entity.teleportTo(entity.getX(), entity.getPersistentData().getDouble("tpheight"), entity.getZ());
               if (entity instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection
                     .teleport(entity.getX(), entity.getPersistentData().getDouble("tpheight"), entity.getZ(), entity.getYRot(), entity.getXRot());
               }

               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.GHOST_TELEPORT.get(), x, y, z, 2, 0.3, 0.3, 0.3, 0.3);
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ETHEREAL_STAFF.get()) {
                  if (entity instanceof Player _player) {
                     _player.getCooldowns()
                        .addCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).getItem(), 4);
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.OFF_HAND, true);
                  }
               }

               if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ETHEREAL_STAFF.get()) {
                  if (entity instanceof Player _player) {
                     _player.getCooldowns()
                        .addCooldown((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem(), 4);
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               }
            }
         }
      }
   }
}
