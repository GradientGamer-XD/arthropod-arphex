package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TormentorInitialOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean found = false;
         if ((Boolean)ConfigurationSettingsConfiguration.DWELLERS_INCLUSION.get()
            && !ArphexModVariables.MapVariables.get(world).full_tormentor_has_previously_spawned
            && !(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)
            && ArphexModVariables.MapVariables.get(world).bosskills.contains("moth")
            && ArphexModVariables.MapVariables.get(world).bosskills.contains("scorpioid")
            && ArphexModVariables.MapVariables.get(world).bosskills.contains("voidlasher")) {
            ArphexModVariables.MapVariables.get(world).tormentor_rotation = (double)entity.getYRot();
            ArphexModVariables.MapVariables.get(world).syncData(world);
            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "execute at @e[type=arphex:tormentor_initial,limit=1,sort=nearest] run tp @e[type=arphex:tormentor_initial,limit=1,sort=nearest] ^ ^0.02 ^0.2"
                  );
            }

            if (world instanceof ServerLevel _level) {
               _level.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                     "data merge entity @e[type=arphex:tormentor_initial,sort=nearest,limit=1] {Invulnerable:1b}"
                  );
            }

            entity.setDeltaMovement(
               new Vec3(
                  Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 5.0,
                  entity.getDeltaMovement().y(),
                  Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) / 5.0
               )
            );
            if (world.isEmptyBlock(BlockPos.containing(x, y - 150.0, z))) {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.4, entity.getDeltaMovement().z()));
            } else {
               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.4, entity.getDeltaMovement().z()));
            }

            ArphexMod.queueServerWork(600, () -> entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), -0.8, entity.getDeltaMovement().z())));
            ArphexMod.queueServerWork(680, () -> {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            });
            if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150.0, 150.0, 150.0), e -> true).isEmpty()) {
               if (!(entity.getPersistentData().getDouble("checkslow") > 0.0)) {
                  found = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(250.0), e -> true)
                     .stream()
                     .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                     .toList()) {
                     if (entityiterator instanceof Player) {
                        found = true;
                        if (!entityiterator.getPersistentData().getBoolean("creativespectator") && !entity.getPersistentData().getBoolean("done")) {
                           if (!(
                                 Math.atan2(entity.getX() - entityiterator.getX(), entity.getZ() - entityiterator.getZ()) * 57.5
                                       - 0.0
                                       + (double)entityiterator.getYRot()
                                    < 10.0
                              )
                              || !(
                                 Math.atan2(entity.getX() - entityiterator.getX(), entity.getZ() - entityiterator.getZ()) * 57.5
                                       - 0.0
                                       + (double)entityiterator.getYRot()
                                    > -10.0
                              )) {
                              if (!(entity instanceof LivingEntity)) {
                                 continue;
                              }

                              LivingEntity _livEnt37 = (LivingEntity)entity;
                              if (!_livEnt37.hasEffect((MobEffect)ArphexModMobEffects.CRAWLING.get())) {
                                 continue;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2, 1, false, false));
                              }
                           }

                           if (world instanceof ServerLevel _level) {
                              LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create(_level);
                              entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
                              entityToSpawn.setVisualOnly(true);
                              _level.addFreshEntity(entityToSpawn);
                           }

                           ArphexModVariables.MapVariables.get(world).tormentor_health = 1024.0;
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                           ArphexModVariables.MapVariables.get(world).tormentor_x = entity.getX();
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                           ArphexModVariables.MapVariables.get(world).tormentor_y = entity.getY();
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                           ArphexModVariables.MapVariables.get(world).tormentor_z = entity.getZ();
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                           ArphexModVariables.MapVariables.get(world).tormentor_last_player_spawned = false;
                           ArphexModVariables.MapVariables.get(world).syncData(world);
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              Entity entityToSpawn = ((EntityType)ArphexModEntities.TORMENTOR.get())
                                 .spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                              if (entityToSpawn != null) {
                                 entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                              }
                           }

                           entity.getPersistentData().putBoolean("done", true);
                           ArphexMod.queueServerWork(
                              20,
                              () -> {
                                 if (!(ArphexModVariables.MapVariables.get(world).tormentor_entity_loaded > 0.0)
                                    && world.getEntitiesOfClass(TORMENTOREntity.class, AABB.ofSize(new Vec3(x, y, z), 500.0, 500.0, 500.0), e -> true)
                                       .isEmpty()
                                    && world instanceof ServerLevel _levelx) {
                                    Entity entityToSpawnx = ((EntityType)ArphexModEntities.TORMENTOR.get())
                                       .spawn(_levelx, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawnx != null) {
                                       entityToSpawnx.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                 }
                              }
                           );
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                       )
                                       .withSuppressedOutput(),
                                    "tellraw @a [{\"text\":\"THE TORMENTOR HAS AWAKENED. EVERY DIMENSION SHUDDERS IN TERROR\",\"bold\":true,\"color\":\"red\"},{\"text\":\"\\nDO NOT ATTACK unless you are prepared to face its explosive wrath!\",\"bold\":true,\"color\":\"white\"}]"
                                 );
                           }

                           if (!world.isClientSide() && world.getServer() != null) {
                              world.getServer()
                                 .getPlayerList()
                                 .broadcastSystemMessage(Component.literal("The Crawling Compass can locate a portal to seal this monstrosity..."), false);
                           }

                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }
                        }
                     }
                  }

                  if (!found && !entity.level().isClientSide()) {
                     entity.discard();
                  }

                  entity.getPersistentData().putDouble("checkslow", 5.0);
               } else {
                  entity.getPersistentData().putDouble("checkslow", entity.getPersistentData().getDouble("checkslow") - 1.0);
               }
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

         if (world instanceof ServerLevel _level) {
            _level.getServer()
               .getCommands()
               .performPrefixedCommand(
                  new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                     .withSuppressedOutput(),
                  "effect give @e[type=player] arphex:display_tormentor_initial 2 0 true"
               );
         }

         if (!(ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0)) {
            ArphexModVariables.MapVariables.get(world).tormentor_x = entity.getX();
            ArphexModVariables.MapVariables.get(world).syncData(world);
            ArphexModVariables.MapVariables.get(world).tormentor_y = entity.getY();
            ArphexModVariables.MapVariables.get(world).syncData(world);
            ArphexModVariables.MapVariables.get(world).tormentor_z = entity.getZ();
            ArphexModVariables.MapVariables.get(world).syncData(world);
         }
      }
   }
}
