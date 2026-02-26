package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

public class SpiderMothDwellerOnInitialEntitySpawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getDisplayName().getString().equals("Monstrous Spider Moth")) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 9999999, 0, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 9999999, 0, false, false));
            }
         }

         entity.getPersistentData().putDouble("minimumlifetime", 0.0);
         label63:
         if ((!(entity instanceof LivingEntity _livEnt4) || !_livEnt4.hasEffect(MobEffects.DIG_SPEED))
            && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
               != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
            && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).isEmpty()) {
            Entity _player = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if ((_player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.SPIDER_MOTH_EGG.get()) {
               _player = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).stream().sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z)).findFirst().orElse(null);
               if ((_player instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.SPIDER_MOTH_EGG.get()) {
                  break label63;
               }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.DESPAWN_IMMUNITY.get(), 9999999, 0, false, false));
            }

            Entity var14 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 24.0, 24.0, 24.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (var14 instanceof Player _playerx && !_playerx.level().isClientSide()) {
               _playerx.displayClientMessage(Component.literal("Spider Moth marked as spawned by player"), true);
            }
         }

         if (!entity.getPersistentData().getBoolean("despawning")) {
            ArphexMod.queueServerWork(
               4,
               () -> {
                  if (!entity.getPersistentData().getBoolean("despawning")) {
                     if (world instanceof ServerLevel _level) {
                        LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                        entityToSpawn.setVisualOnly(true);
                        _level.addFreshEntity(entityToSpawn);
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof Player) {
                           String _setval = "true";
                           entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                              capability.ShowOverlay = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                           ArphexMod.queueServerWork(2, () -> {
                              String _setvalx = "false";
                              entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                 capability.ShowOverlay = _setvalx;
                                 capability.syncPlayerVariables(entityiterator);
                              });
                           });
                        }
                     }
                  }
               }
            );
         }

         entity.getPersistentData().putBoolean("growattack", false);
         ArphexModVariables.MapVariables.get(world).LookScareLock = "no";
         ArphexModVariables.MapVariables.get(world).syncData(world);
         entity.getPersistentData().putString("playerlookedatmoth", "no");
         entity.getPersistentData().putString("dwellerwaiting", "far");
         entity.getPersistentData().putString("soundonce", "one");
         entity.getPersistentData().putString("chasemode", "no");
         ArphexModVariables.MapVariables.get(world).slightrandom = "first";
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexModVariables.MapVariables.get(world).attackcycle = (double)Mth.nextInt(RandomSource.create(), 1, 9);
         ArphexModVariables.MapVariables.get(world).syncData(world);
         ArphexMod.queueServerWork(20, () -> {
            ArphexModVariables.MapVariables.get(world).LookScareLock = "no";
            ArphexModVariables.MapVariables.get(world).syncData(world);
            entity.getPersistentData().putString("playerlookedatmoth", "no");
            entity.getPersistentData().putString("dwellerwaiting", "far");
            entity.getPersistentData().putString("chasemode", "no");
            entity.getPersistentData().putString("soundonce", "one");
         });
      }
   }
}
