package net.arphex.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

public class TendrilHitsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean check = false;
         if (sourceentity != entity) {
            entity.setDeltaMovement(
               new Vec3(
                  Math.sin(Math.toRadians((double)(sourceentity.getYRot() + 180.0F))) * 2.0 * -1.0,
                  (Math.sin(Math.toRadians((double)(0.0F - sourceentity.getXRot()))) + 0.5) * 1.5,
                  Math.cos(Math.toRadians((double)sourceentity.getYRot())) * 2.0 * -1.0
               )
            );
            if (entity instanceof LivingEntity _livEnt5 && _livEnt5.isBlocking()) {
               check = false;
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
               entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
                     ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
                     if (itemstackiterator.getItem() == ArphexModItems.BANE_OF_THE_DARKNESS.get()) {
                        check = true;
                     }
                  }
               }

               if (!check && world instanceof ServerLevel _level) {
                  _level.getServer()
                     .getCommands()
                     .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                           .withSuppressedOutput(),
                        "effect give @e[type=arphex:scorpioid_bloodluster, distance=..20] regeneration 2 4"
                     );
               }
            }

            label71: {
               if (entity instanceof LivingEntity _livEnt10 && _livEnt10.isBlocking()) {
                  break label71;
               }

               if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.WITHER)) {
                  if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 1, false, false));
                  }
                  break label71;
               }

               if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 0, false, false));
               }
            }

            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
            }
         }
      }
   }
}
