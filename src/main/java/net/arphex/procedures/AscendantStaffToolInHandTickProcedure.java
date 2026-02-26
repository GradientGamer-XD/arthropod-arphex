package net.arphex.procedures;

import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AscendantStaffToolInHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.FIRE_OPAL_SHARDS.get(), x, y, z, 1, 0.2, 0.2, 0.2, 0.0);
         }

         if ((!(entity instanceof Player _plrCldCheck2) || !_plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))
            && entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.LEVITATION);
         }

         if (entity.getPersistentData().getDouble("openhit") > 0.0) {
            entity.getPersistentData().putDouble("openhit", entity.getPersistentData().getDouble("openhit") - 1.0);
         }

         if (entity instanceof ServerPlayer _player) {
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:ascendant_staff_craft"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for (String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }
      }
   }
}
