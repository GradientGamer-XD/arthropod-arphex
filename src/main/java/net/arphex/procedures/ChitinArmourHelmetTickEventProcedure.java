package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ChitinArmourHelmetTickEventProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double expand = 0.0;
         double lineZ = 0.0;
         double lineY = 0.0;
         double lineX = 0.0;
         double scanpower = 0.0;
         double line_limit = 0.0;
         if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_HELMET.get()) {
            scanpower = 40.0;
         } else if (itemstack.getItem() == ArphexModItems.CHITIN_ARMOUR_TIER_2_HELMET.get()) {
            scanpower = 70.0;
         } else {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer()
                  .getCommands()
                  .performPrefixedCommand(
                     new CommandSourceStack(
                        CommandSource.NULL,
                        entity.position(),
                        entity.getRotationVector(),
                        entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                        4,
                        entity.getName().getString(),
                        entity.getDisplayName(),
                        entity.level().getServer(),
                        entity
                     ),
                     "item modify entity @s armor.head {\"function\":\"minecraft:set_components\",\"components\":{\"minecraft:unbreakable\":{\"show_in_tooltip\":true}}}"
                  );
            }

            scanpower = 100.0;
            itemstack.getOrCreateTag().putBoolean("Unbreakable", true);
         }

         if (entity.isShiftKeyDown()) {
            if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect((MobEffect)ArphexModMobEffects.ENHANCED_SENSES.get())) {
               return;
            }

            line_limit = 0.0;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(scanpower / 2.0), e -> true)
               .stream()
               .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
               .toList()) {
               if (line_limit < 15.0) {
                  line_limit++;
                  lineX = 0.0;
                  lineY = 0.0;
                  lineZ = 0.0;
                  expand = 0.0;
                  if (entityiterator != entity) {
                     if (entityiterator instanceof TORMENTOREntity) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:glow_sense_player ~ ~2 ~ 0 0 0 0 2 force @p"
                              );
                        }

                        lineX = entity.getX() - entityiterator.getX();
                        lineY = entity.getY() + 1.0 - entityiterator.getY();
                        lineZ = entity.getZ() - entityiterator.getZ();
                        expand = expand;

                        for (int index0 = 0; index0 < 20; index0++) {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:solid_smoke ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                                 );
                           }

                           expand -= 0.05;
                        }
                     } else if (entityiterator instanceof Player) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:glow_sense_player ~ ~2 ~ 0 0 0 0 2 force @p"
                              );
                        }

                        lineX = entity.getX() - entityiterator.getX();
                        lineY = entity.getY() + 1.0 - entityiterator.getY();
                        lineZ = entity.getZ() - entityiterator.getZ();
                        expand = expand;

                        for (int index1 = 0; index1 < 20; index1++) {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:glow_sense_player ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                                 );
                           }

                           expand -= 0.05;
                        }
                     } else if (entityiterator instanceof LivingEntity) {
                        if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)
                           )
                         {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:glow_sense_tamed ~ ~2 ~ 0 0 0 0 2 force " + entity.getDisplayName().getString()
                                 );
                           }

                           lineX = entity.getX() - entityiterator.getX();
                           lineY = entity.getY() + 1.0 - entityiterator.getY();
                           lineZ = entity.getZ() - entityiterator.getZ();
                           expand = expand;

                           for (int index2 = 0; index2 < 20; index2++) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                             Vec2.ZERO,
                                             _level,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _level.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "particle arphex:glow_sense_tamed ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                                    );
                              }

                              expand -= 0.04;
                           }
                           continue;
                        }

                        if ((entityiterator instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null) {
                           if ((entityiterator instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) == entity) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                             Vec2.ZERO,
                                             _level,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _level.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "particle arphex:glow_sense ~ ~2 ~ 0 0 0 0 2 force " + entity.getDisplayName().getString()
                                    );
                              }

                              lineX = entity.getX() - entityiterator.getX();
                              lineY = entity.getY() + 1.0 - entityiterator.getY();
                              lineZ = entity.getZ() - entityiterator.getZ();
                              expand = expand;

                              for (int index3 = 0; index3 < 20; index3++) {
                                 if (world instanceof ServerLevel _level) {
                                    _level.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                             )
                                             .withSuppressedOutput(),
                                          "particle arphex:glow_sense ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                                       );
                                 }

                                 expand -= 0.04;
                              }
                           } else {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                             Vec2.ZERO,
                                             _level,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _level.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "particle arphex:glow_sense_neutral ~ ~2 ~ 0 0 0 0 2 force " + entity.getDisplayName().getString()
                                    );
                              }

                              lineX = entity.getX() - entityiterator.getX();
                              lineY = entity.getY() + 1.0 - entityiterator.getY();
                              lineZ = entity.getZ() - entityiterator.getZ();
                              expand = expand;

                              for (int index4 = 0; index4 < 20; index4++) {
                                 if (world instanceof ServerLevel _level) {
                                    _level.getServer()
                                       .getCommands()
                                       .performPrefixedCommand(
                                          new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                             )
                                             .withSuppressedOutput(),
                                          "particle arphex:glow_sense_neutral ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                                       );
                                 }

                                 expand -= 0.04;
                              }
                           }
                        } else {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:glow_sense_neutral ~ ~2 ~ 0 0 0 0 2 force " + entity.getDisplayName().getString()
                                 );
                           }

                           lineX = entity.getX() - entityiterator.getX();
                           lineY = entity.getY() + 1.0 - entityiterator.getY();
                           lineZ = entity.getZ() - entityiterator.getZ();
                           expand = expand;

                           for (int index5 = 0; index5 < 20; index5++) {
                              if (world instanceof ServerLevel _level) {
                                 _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                       new CommandSourceStack(
                                             CommandSource.NULL,
                                             new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                             Vec2.ZERO,
                                             _level,
                                             4,
                                             "",
                                             Component.literal(""),
                                             _level.getServer(),
                                             null
                                          )
                                          .withSuppressedOutput(),
                                       "particle arphex:glow_sense_neutral ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                                    );
                              }

                              expand -= 0.04;
                           }
                        }
                     } else if (entityiterator instanceof ItemEntity) {
                        if (world instanceof ServerLevel _level) {
                           _level.getServer()
                              .getCommands()
                              .performPrefixedCommand(
                                 new CommandSourceStack(
                                       CommandSource.NULL,
                                       new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                       Vec2.ZERO,
                                       _level,
                                       4,
                                       "",
                                       Component.literal(""),
                                       _level.getServer(),
                                       null
                                    )
                                    .withSuppressedOutput(),
                                 "particle arphex:glow_sense_item ~ ~2 ~ 0 0 0 0 2 force " + entity.getDisplayName().getString()
                              );
                        }

                        lineX = entity.getX() - entityiterator.getX();
                        lineY = entity.getY() + 1.0 - entityiterator.getY();
                        lineZ = entity.getZ() - entityiterator.getZ();
                        expand = expand;

                        for (int index6 = 0; index6 < 20; index6++) {
                           if (world instanceof ServerLevel _level) {
                              _level.getServer()
                                 .getCommands()
                                 .performPrefixedCommand(
                                    new CommandSourceStack(
                                          CommandSource.NULL,
                                          new Vec3(entity.getX() + lineX * expand, entity.getY() + 1.0 + lineY * expand, entity.getZ() + lineZ * expand),
                                          Vec2.ZERO,
                                          _level,
                                          4,
                                          "",
                                          Component.literal(""),
                                          _level.getServer(),
                                          null
                                       )
                                       .withSuppressedOutput(),
                                    "particle arphex:glow_sense_item ~ ~ ~ 0 0 0 0 1 force " + entity.getDisplayName().getString()
                                 );
                           }

                           expand -= 0.04;
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
