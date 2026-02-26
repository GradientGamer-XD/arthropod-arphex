package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.SpiderMothDwellerEntity;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class VoidlasherSpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()
               && !world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true).isEmpty()) {
               entity.getPersistentData().putBoolean("despawning", true);
               ArphexMod.queueServerWork(2, () -> {
                  if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                     return;
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "voidlasher-cancel-already-exists";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
               });
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 350.0, 350.0, 350.0), e -> true).isEmpty()
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).isEmpty()
               && (
                  ((ArphexModVariables.PlayerVariables)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 350.0, 350.0, 350.0), e -> true)
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
                        .killedvoidlasher
                     || ((ArphexModVariables.PlayerVariables)world.getEntitiesOfClass(
                                 Player.class, AABB.ofSize(new Vec3(x, y, z), 350.0, 350.0, 350.0), e -> true
                              )
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
                           .mothsurvivals
                        < 2.0
               )) {
               entity.getPersistentData().putBoolean("despawning", true);
               ArphexMod.queueServerWork(2, () -> {
                  if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                     return;
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "voidlasher-nearby-player-already-killed";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
               });
            }

            if (!world.getEntitiesOfClass(EnderDragon.class, AABB.ofSize(new Vec3(x, y, z), 200.0, 200.0, 200.0), e -> true).isEmpty()) {
               entity.getPersistentData().putBoolean("despawning", true);
               ArphexMod.queueServerWork(2, () -> {
                  if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get())) {
                     return;
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  ArphexModVariables.MapVariables.get(world).last_despawn_reasons = "voidlasher-enderdragon-exists";
                  ArphexModVariables.MapVariables.get(world).syncData(world);
               });
            }
         }

         ArphexMod.queueServerWork(
            1,
            () -> {
               if (!entity.getPersistentData().getBoolean("despawning")) {
                  if (world instanceof ServerLevel _level) {
                     LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
                     entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                     entityToSpawn.setVisualOnly(true);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof Player) {
                        if (!entityiterator.getPersistentData().getBoolean("creativespectator")) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.MOTH_CURSE.get(), 300, 2, false, false));
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 0, false, false));
                              }
                           }
                        }

                        String _setval = "true";
                        entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                           capability.ShowOverlay3 = _setval;
                           capability.syncPlayerVariables(entityiterator);
                        });
                        ArphexMod.queueServerWork(3, () -> {
                           String _setvalx = "false";
                           entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.ShowOverlay3 = _setvalx;
                              capability.syncPlayerVariables(entityiterator);
                           });
                        });
                     }
                  }
               }
            }
         );
         label53:
         if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
            Entity _player = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((_player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               != ArphexModItems.DRACONIC_VOIDLASHER_EGG.get()) {
               _player = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null);
               if ((_player instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.DRACONIC_VOIDLASHER_EGG.get()) {
                  break label53;
               }
            }

            Entity var11 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48.0, 48.0, 48.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (var11 instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("Voidlasher marked as spawned by player"), true);
            }

            return;
         }

         entity.getPersistentData().putBoolean("spawnedawayfromplayer", true);
      }
   }
}
