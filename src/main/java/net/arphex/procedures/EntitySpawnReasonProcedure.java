package net.arphex.procedures;

import java.util.ArrayList;
import javax.annotation.Nullable;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.MobSpawnEvent.PositionCheck;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EntitySpawnReasonProcedure {
   @SubscribeEvent
   public static void entitySpawns(PositionCheck event) {
      execute(event, event.getLevel(), event.getX(), event.getY(), event.getZ(), event.getEntity(), event.getSpawnType().toString().toLowerCase());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String spawnType) {
      execute(null, world, x, y, z, entity, spawnType);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String spawnType) {
      if (entity != null && spawnType != null) {
         if (spawnType.equals("natural")) {
            if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")) {
               if ((Boolean)ConfigurationSettingsConfiguration.CRAWLING_ONLY.get()
                  && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                     != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))
                  && event != null
                  && event.isCancelable()) {
                  event.setCanceled(true);
               }
            } else if (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("minecraft:")
               && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                  == Level.OVERWORLD
               && !(Boolean)ConfigurationSettingsConfiguration.CRAWLING_ONLY.get()
               && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).canOcclude()
               && (Double)ConfigurationSettingsConfiguration.VANILLA_REPLACEMENT_MODE.get() > 0.0) {
               if ((Double)ConfigurationSettingsConfiguration.VANILLA_REPLACEMENT_MODE.get() > 10.0) {
                  if (entity instanceof Monster || (Boolean)ConfigurationSettingsConfiguration.FRIENDLY_REPLACEMENTS.get()) {
                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     if ((Boolean)ConfigurationSettingsConfiguration.INSANITY_MODE.get()) {
                        if (world instanceof ServerLevel _level) {
                           Entity entityToSpawn = ((EntityType)ArphexModEntities.INSANE_MODE_SPAWNS.get())
                              .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                           }
                        }
                     } else if (world instanceof ServerLevel _levelx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_AR_PH_EX.get())
                           .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  }
               } else if (Mth.nextInt(RandomSource.create(), (int)((Double)ConfigurationSettingsConfiguration.VANILLA_REPLACEMENT_MODE.get()).doubleValue(), 10)
                  == 10) {
                  if (event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }

                  if ((Boolean)ConfigurationSettingsConfiguration.INSANITY_MODE.get()) {
                     if (world instanceof ServerLevel _levelxx) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.INSANE_MODE_SPAWNS.get())
                           .spawn(_levelxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                     }
                  } else if (world instanceof ServerLevel _levelxxx) {
                     Entity entityToSpawn = ((EntityType)ArphexModEntities.RANDOM_AR_PH_EX.get())
                        .spawn(_levelxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                     }
                  }
               }
            }

            if (entity instanceof SpiderMothEntity) {
               if (!world.getEntitiesOfClass(SpiderMothEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true).isEmpty()
                  && event != null
                  && event.isCancelable()) {
                  event.setCanceled(true);
               }

               for (Entity entityiterator : new ArrayList(world.players())) {
                  if (Math.abs(entity.getX() - entityiterator.getX()) < 128.0
                     && Math.abs(entity.getY() - entityiterator.getY()) < 128.0
                     && Math.abs(entity.getZ() - entityiterator.getZ()) < 128.0
                     && ((ArphexModVariables.PlayerVariables)entityiterator.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                              .orElse(new ArphexModVariables.PlayerVariables()))
                           .mothsurvivals
                        > 4.0
                     && event != null
                     && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               }
            }

            if (entity instanceof ScorpioidBloodlusterEntity) {
               if (!world.getEntitiesOfClass(ScorpioidBloodlusterEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true).isEmpty()
                  && event != null
                  && event.isCancelable()) {
                  event.setCanceled(true);
               }

               for (Entity entityiteratorx : new ArrayList(world.players())) {
                  if (Math.abs(entity.getX() - entityiteratorx.getX()) < 128.0
                     && Math.abs(entity.getY() - entityiteratorx.getY()) < 128.0
                     && Math.abs(entity.getZ() - entityiteratorx.getZ()) < 128.0
                     && ((ArphexModVariables.PlayerVariables)entityiteratorx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedscorpioid
                     && event != null
                     && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               }
            }

            if (entity instanceof SpiderMothDwellerEntity) {
               if (!world.getEntitiesOfClass(SpiderMothDwellerEntity.class, AABB.ofSize(new Vec3(x, y, z), 400.0, 400.0, 400.0), e -> true).isEmpty()
                  && event != null
                  && event.isCancelable()) {
                  event.setCanceled(true);
               }

               for (Entity entityiteratorxx : new ArrayList(world.players())) {
                  if (Math.abs(entity.getX() - entityiteratorxx.getX()) < 128.0
                     && Math.abs(entity.getY() - entityiteratorxx.getY()) < 128.0
                     && Math.abs(entity.getZ() - entityiteratorxx.getZ()) < 128.0
                     && ((ArphexModVariables.PlayerVariables)entityiteratorxx.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                           .orElse(new ArphexModVariables.PlayerVariables()))
                        .killedvoidlasher
                     && event != null
                     && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               }
            }
         }
      }
   }
}
