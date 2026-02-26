package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ScorpioidBloodlusterOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Vec3 _center = new Vec3(x, y, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof Player) {
               String _setval = "true";
               entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.ShowOverlay2 = _setval;
                  capability.syncPlayerVariables(entityiterator);
               });
               ArphexMod.queueServerWork(3, () -> {
                  String _setvalx = "false";
                  entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                     capability.ShowOverlay2 = _setvalx;
                     capability.syncPlayerVariables(entityiterator);
                  });
               });
            }
         }

         if (world instanceof ServerLevel _level) {
            LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
            entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
            entityToSpawn.setVisualOnly(true);
            _level.addFreshEntity(entityToSpawn);
         }

         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true).isEmpty()) {
               ArphexMod.queueServerWork(2, () -> {
                  if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                     return;
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "scorpioid-cancel-already-exists";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
               });
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true).isEmpty()
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()
               && ((ArphexModVariables.PlayerVariables)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 250.0, 250.0, 250.0), e -> true)
                     .stream()
                     .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                     }).compareDistOf(x, y, z))
                     .findFirst()
                     .orElse(null)
                     .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables()))
                  .killedscorpioid) {
               ArphexMod.queueServerWork(2, () -> {
                  if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                     return;
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "scorpioid-nearby-player-already-killed";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
               });
            }
         }

         label65:
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()) {
            Entity var19 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if ((var19 instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               != ArphexModItems.SCORPIOID_BLOODLUSTER_EGG.get()) {
               var19 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null);
               if ((var19 instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.SCORPIOID_BLOODLUSTER_EGG.get()) {
                  break label65;
               }
            }

            Entity var22 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (var22 instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Scorpioid Bloodluster marked as spawned by player"), true);
            }

            return;
         }

         entity.getPersistentData().putBoolean("spawnedawayfromplayer", true);
      }
   }
}
