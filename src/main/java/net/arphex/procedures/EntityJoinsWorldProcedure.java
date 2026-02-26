package net.arphex.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EntityJoinsWorldProcedure {
   @SubscribeEvent
   public static void onEntityJoin(EntityJoinLevelEvent event) {
      execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")
            && entity instanceof Projectile
            && Math.abs(entity.getDeltaMovement().x() + entity.getDeltaMovement().y() + entity.getDeltaMovement().z()) < 0.001) {
            ArphexMod.queueServerWork(5, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
         }

         if (entity instanceof SpiderFlatEntity
            && !world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            Entity entityToSpawn = world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y, z))
               .findFirst()
               .orElse(null);
            if (entityToSpawn instanceof TamableAnimal _tamEnt && _tamEnt.isTame() && entity instanceof TamableAnimal _toTame) {
               Entity var14 = world.getEntitiesOfClass(SpiderFlatEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                  .stream()
                  .sorted((new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                     }
                  }).compareDistOf(x, y, z))
                  .findFirst()
                  .orElse(null);
               if ((var14 instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) instanceof Player _owner) {
                  _toTame.tame(_owner);
               }
            }
         }

         if ((Boolean)ConfigurationSettingsConfiguration.WELCOME_MESSAGE.get()
            && entity instanceof Player
            && ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0
            && (
               (new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                           } else {
                              return _ent.level().isClientSide() && _ent instanceof Player _player
                                 ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                       == GameType.CREATIVE
                                 : false;
                           }
                        }
                     })
                     .checkGamemode(entity)
                  || (new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                           } else {
                              return _ent.level().isClientSide() && _ent instanceof Player _player
                                 ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                       == GameType.SPECTATOR
                                 : false;
                           }
                        }
                     })
                     .checkGamemode(entity)
            )
            && entity instanceof Player _player
            && !_player.level().isClientSide()) {
            _player.displayClientMessage(
               Component.literal("§cThe Tormentor is active, and will spawn fully for survival mode players (sealable with /arphex command)"), false
            );
         }

         if ((entity instanceof Cod || entity instanceof TropicalFish) && !entity.getPersistentData().getBoolean("done_crabspawn")) {
            entity.getPersistentData().putBoolean("done_crabspawn", true);
            if (Mth.nextInt(RandomSource.create(), 1, (int)((Double)ConfigurationSettingsConfiguration.NON_BOSS_SPAWNRATE.get() * 200.0)) == 1
               && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60.0, 60.0, 60.0), e -> true).isEmpty()
               && !world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()
               && (
                  world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_cold_ocean"))
                     || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_frozen_ocean"))
                     || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_ocean"))
               )
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y, y + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 4.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 1.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 4.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 1.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 4.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 4.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 4.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 4.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 4.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 2.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 3.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 2.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 3.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 3.0, z)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 3.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 2.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 3.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 2.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x, y + 3.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 2.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 3.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 2.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x - 1.0, y + 3.0, z + 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z - 1.0)).canOcclude()
               && !world.getBlockState(BlockPos.containing(x + 1.0, y + 3.0, z - 1.0)).canOcclude()
               && world instanceof ServerLevel _level) {
               Entity entityToSpawn = ((EntityType)ArphexModEntities.CRAB_CONSTRICTOR.get())
                  .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }
         }
      }
   }
}
