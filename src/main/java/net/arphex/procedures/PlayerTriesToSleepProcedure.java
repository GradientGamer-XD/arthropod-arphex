package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerTriesToSleepProcedure {
   @SubscribeEvent
   public static void onPlayerInBed(PlayerSleepInBedEvent event) {
      execute(event, event.getEntity().level(), (double)event.getPos().getX(), (double)event.getPos().getY(), (double)event.getPos().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _livEnt0
            && _livEnt0.hasEffect((MobEffect)ArphexModMobEffects.TORMENTOR_PRIMARY_TARGET.get())
            && !world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 550.0, 550.0, 550.0), e -> true).isEmpty()) {
            ArphexMod.queueServerWork(20, () -> {
               if (entity instanceof LivingEntity _livEnt2 && _livEnt2.isSleeping()) {
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 1.0F);
                  if (entity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("The §c§lTORMENTOR §rwon't let you sleep when nearby..."), true);
                  }
               }
            });
         }
      }
   }
}
