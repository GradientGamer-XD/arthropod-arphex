package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpiderMothEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_SMOKE.get(), x, y, z, 5, 0.4, 0.4, 0.4, 0.1);
         }

         if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.DIG_SPEED)) {
            if (world instanceof ServerLevel _level) {
               LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
               entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
               entityToSpawn.setVisualOnly(true);
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)ArphexModItems.SPIDER_MOTH_SUMMONER.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.removeAllEffects();
            }
         }

         ArphexMod.queueServerWork(
            2,
            () -> {
               Vec3 _center = new Vec3(x, y, z);

               for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                  .stream()
                  .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                  .toList()) {
                  if (entityiterator instanceof ItemEntity
                     && (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()
                        == ArphexModItems.ABYSSAL_CRYSTAL.get()
                     && !entityiterator.level().isClientSide()
                     && entityiterator.getServer() != null) {
                     entityiterator.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                           new CommandSourceStack(
                              CommandSource.NULL,
                              entityiterator.position(),
                              entityiterator.getRotationVector(),
                              entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null,
                              4,
                              entityiterator.getName().getString(),
                              entityiterator.getDisplayName(),
                              entityiterator.level().getServer(),
                              entityiterator
                           ),
                           "data merge entity @s {Glowing:1b,Invulnerable:1b}"
                        );
                  }
               }
            }
         );
      }
   }
}
