package net.arphex.procedures;

import net.arphex.ArphexMod;
import net.arphex.configuration.ConfigurationSettingsConfiguration;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.VenusFlytrapEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class InfiniteTormentLivingEntityIsHitWithItemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         ItemStack custom_itemstack = ItemStack.EMPTY;
         boolean found = false;
         boolean checkbane = false;
         double repeat = 0.0;
         double sx = 0.0;
         double sy = 0.0;
         double sz = 0.0;
         double cocoon_scan = 0.0;
         if (sourceentity.isShiftKeyDown()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > 0.0F && entity instanceof LivingEntity _entity) {
               _entity.setHealth(1.0F);
            }

            if (entity instanceof TORMENTOREntity) {
               ArphexModVariables.MapVariables.get(world).tormentor_health = 1.0;
               ArphexModVariables.MapVariables.get(world).syncData(world);
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), sourceentity),
                  entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F
               );
            } else {
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                  (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) * 10.0F
               );
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                  (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) * 10.0F
               );
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) * 10.0F
               );
               entity.hurt(
                  new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                  (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) * 10.0F
               );
               ArphexMod.queueServerWork(1, () -> {
                  if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                     _entity.setHealth(0.0F);
                  }
               });
               ArphexMod.queueServerWork(
                  20,
                  () -> {
                     if (entity.isAlive()) {
                        entity.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity),
                           (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMaxHealth() : -1.0F) * 10.0F
                        );
                        entity.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                           (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) * 10.0F
                        );
                        entity.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                           (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMaxHealth() : -1.0F) * 10.0F
                        );
                        entity.hurt(
                           new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                           (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMaxHealth() : -1.0F) * 10.0F
                        );
                        ArphexMod.queueServerWork(1, () -> {
                           if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                              _entity.setHealth(0.0F);
                           }
                        });
                        ArphexMod.queueServerWork(
                           20,
                           () -> {
                              if (entity.isAlive()) {
                                 entity.hurt(
                                    new DamageSource(
                                       world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), sourceentity
                                    ),
                                    (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                 );
                                 entity.hurt(
                                    new DamageSource(
                                       world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity
                                    ),
                                    (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                 );
                                 entity.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                                    (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                 );
                                 entity.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                                    (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                 );
                                 ArphexMod.queueServerWork(1, () -> {
                                    if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                                       _entity.setHealth(0.0F);
                                    }
                                 });
                                 ArphexMod.queueServerWork(
                                    20,
                                    () -> {
                                       if (entity.isAlive()) {
                                          entity.hurt(
                                             new DamageSource(
                                                world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC),
                                                sourceentity
                                             ),
                                             (entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                          );
                                          entity.hurt(
                                             new DamageSource(
                                                world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC),
                                                sourceentity
                                             ),
                                             (entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                          );
                                          entity.hurt(
                                             new DamageSource(
                                                world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)
                                             ),
                                             (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                          );
                                          entity.hurt(
                                             new DamageSource(
                                                world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)
                                             ),
                                             (entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMaxHealth() : -1.0F) * 10.0F
                                          );
                                          ArphexMod.queueServerWork(1, () -> {
                                             if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                                                _entity.setHealth(0.0F);
                                             }
                                          });
                                          ArphexMod.queueServerWork(
                                             20,
                                             () -> {
                                                if (entity.isAlive()) {
                                                   entity.hurt(
                                                      new DamageSource(
                                                         world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC),
                                                         sourceentity
                                                      ),
                                                      (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxx.getMaxHealth() : -1.0F)
                                                         * 10.0F
                                                   );
                                                   entity.hurt(
                                                      new DamageSource(
                                                         world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC),
                                                         sourceentity
                                                      ),
                                                      (entity instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getMaxHealth() : -1.0F)
                                                         * 10.0F
                                                   );
                                                   entity.hurt(
                                                      new DamageSource(
                                                         world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)
                                                      ),
                                                      (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getMaxHealth() : -1.0F)
                                                         * 10.0F
                                                   );
                                                   entity.hurt(
                                                      new DamageSource(
                                                         world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)
                                                      ),
                                                      (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMaxHealth() : -1.0F)
                                                         * 10.0F
                                                   );
                                                   ArphexMod.queueServerWork(1, () -> {
                                                      if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                                                         _entity.setHealth(0.0F);
                                                      }
                                                   });
                                                   ArphexMod.queueServerWork(
                                                      20,
                                                      () -> {
                                                         if (entity.isAlive()) {
                                                            entity.hurt(
                                                               new DamageSource(
                                                                  world.registryAccess()
                                                                     .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                     .getHolderOrThrow(DamageTypes.MAGIC),
                                                                  sourceentity
                                                               ),
                                                               (
                                                                     entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx
                                                                        ? _livEntxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                        : -1.0F
                                                                  )
                                                                  * 10.0F
                                                            );
                                                            entity.hurt(
                                                               new DamageSource(
                                                                  world.registryAccess()
                                                                     .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                     .getHolderOrThrow(DamageTypes.GENERIC),
                                                                  sourceentity
                                                               ),
                                                               (
                                                                     entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxx
                                                                        ? _livEntxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                        : -1.0F
                                                                  )
                                                                  * 10.0F
                                                            );
                                                            entity.hurt(
                                                               new DamageSource(
                                                                  world.registryAccess()
                                                                     .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                     .getHolderOrThrow(DamageTypes.MAGIC)
                                                               ),
                                                               (
                                                                     entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx
                                                                        ? _livEntxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                        : -1.0F
                                                                  )
                                                                  * 10.0F
                                                            );
                                                            entity.hurt(
                                                               new DamageSource(
                                                                  world.registryAccess()
                                                                     .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                     .getHolderOrThrow(DamageTypes.GENERIC)
                                                               ),
                                                               (
                                                                     entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx
                                                                        ? _livEntxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                        : -1.0F
                                                                  )
                                                                  * 10.0F
                                                            );
                                                            ArphexMod.queueServerWork(1, () -> {
                                                               if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                                                                  _entity.setHealth(0.0F);
                                                               }
                                                            });
                                                            ArphexMod.queueServerWork(
                                                               20,
                                                               () -> {
                                                                  if (entity.isAlive()) {
                                                                     entity.hurt(
                                                                        new DamageSource(
                                                                           world.registryAccess()
                                                                              .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                              .getHolderOrThrow(DamageTypes.MAGIC),
                                                                           sourceentity
                                                                        ),
                                                                        (
                                                                              entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                 : -1.0F
                                                                           )
                                                                           * 10.0F
                                                                     );
                                                                     entity.hurt(
                                                                        new DamageSource(
                                                                           world.registryAccess()
                                                                              .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                              .getHolderOrThrow(DamageTypes.GENERIC),
                                                                           sourceentity
                                                                        ),
                                                                        (
                                                                              entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx
                                                                                 ? _livEntxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                 : -1.0F
                                                                           )
                                                                           * 10.0F
                                                                     );
                                                                     entity.hurt(
                                                                        new DamageSource(
                                                                           world.registryAccess()
                                                                              .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                              .getHolderOrThrow(DamageTypes.MAGIC)
                                                                        ),
                                                                        (
                                                                              entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx
                                                                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                 : -1.0F
                                                                           )
                                                                           * 10.0F
                                                                     );
                                                                     entity.hurt(
                                                                        new DamageSource(
                                                                           world.registryAccess()
                                                                              .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                              .getHolderOrThrow(DamageTypes.GENERIC)
                                                                        ),
                                                                        (
                                                                              entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                                                                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                 : -1.0F
                                                                           )
                                                                           * 10.0F
                                                                     );
                                                                     ArphexMod.queueServerWork(1, () -> {
                                                                        if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                                                                           _entity.setHealth(0.0F);
                                                                        }
                                                                     });
                                                                     ArphexMod.queueServerWork(
                                                                        20,
                                                                        () -> {
                                                                           if (entity.isAlive()) {
                                                                              entity.hurt(
                                                                                 new DamageSource(
                                                                                    world.registryAccess()
                                                                                       .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                       .getHolderOrThrow(DamageTypes.MAGIC),
                                                                                    sourceentity
                                                                                 ),
                                                                                 (
                                                                                       entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                          : -1.0F
                                                                                    )
                                                                                    * 10.0F
                                                                              );
                                                                              entity.hurt(
                                                                                 new DamageSource(
                                                                                    world.registryAccess()
                                                                                       .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                       .getHolderOrThrow(DamageTypes.GENERIC),
                                                                                    sourceentity
                                                                                 ),
                                                                                 (
                                                                                       entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                          : -1.0F
                                                                                    )
                                                                                    * 10.0F
                                                                              );
                                                                              entity.hurt(
                                                                                 new DamageSource(
                                                                                    world.registryAccess()
                                                                                       .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                       .getHolderOrThrow(DamageTypes.MAGIC)
                                                                                 ),
                                                                                 (
                                                                                       entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                          : -1.0F
                                                                                    )
                                                                                    * 10.0F
                                                                              );
                                                                              entity.hurt(
                                                                                 new DamageSource(
                                                                                    world.registryAccess()
                                                                                       .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                       .getHolderOrThrow(DamageTypes.GENERIC)
                                                                                 ),
                                                                                 (
                                                                                       entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                          : -1.0F
                                                                                    )
                                                                                    * 10.0F
                                                                              );
                                                                              ArphexMod.queueServerWork(1, () -> {
                                                                                 if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                                                                                    _entity.setHealth(0.0F);
                                                                                 }
                                                                              });
                                                                              ArphexMod.queueServerWork(
                                                                                 20,
                                                                                 () -> {
                                                                                    if (entity.isAlive()) {
                                                                                       entity.hurt(
                                                                                          new DamageSource(
                                                                                             world.registryAccess()
                                                                                                .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                .getHolderOrThrow(DamageTypes.MAGIC),
                                                                                             sourceentity
                                                                                          ),
                                                                                          (
                                                                                                entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                   : -1.0F
                                                                                             )
                                                                                             * 10.0F
                                                                                       );
                                                                                       entity.hurt(
                                                                                          new DamageSource(
                                                                                             world.registryAccess()
                                                                                                .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                .getHolderOrThrow(DamageTypes.GENERIC),
                                                                                             sourceentity
                                                                                          ),
                                                                                          (
                                                                                                entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                   : -1.0F
                                                                                             )
                                                                                             * 10.0F
                                                                                       );
                                                                                       entity.hurt(
                                                                                          new DamageSource(
                                                                                             world.registryAccess()
                                                                                                .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                .getHolderOrThrow(DamageTypes.MAGIC)
                                                                                          ),
                                                                                          (
                                                                                                entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                   : -1.0F
                                                                                             )
                                                                                             * 10.0F
                                                                                       );
                                                                                       entity.hurt(
                                                                                          new DamageSource(
                                                                                             world.registryAccess()
                                                                                                .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                .getHolderOrThrow(DamageTypes.GENERIC)
                                                                                          ),
                                                                                          (
                                                                                                entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                   : -1.0F
                                                                                             )
                                                                                             * 10.0F
                                                                                       );
                                                                                       ArphexMod.queueServerWork(1, () -> {
                                                                                          if (entity.isAlive() && entity instanceof LivingEntity _entity) {
                                                                                             _entity.setHealth(0.0F);
                                                                                          }
                                                                                       });
                                                                                       ArphexMod.queueServerWork(
                                                                                          20,
                                                                                          () -> {
                                                                                             if (entity.isAlive()) {
                                                                                                entity.hurt(
                                                                                                   new DamageSource(
                                                                                                      world.registryAccess()
                                                                                                         .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                         .getHolderOrThrow(DamageTypes.MAGIC),
                                                                                                      sourceentity
                                                                                                   ),
                                                                                                   (
                                                                                                         entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                            : -1.0F
                                                                                                      )
                                                                                                      * 10.0F
                                                                                                );
                                                                                                entity.hurt(
                                                                                                   new DamageSource(
                                                                                                      world.registryAccess()
                                                                                                         .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                         .getHolderOrThrow(DamageTypes.GENERIC),
                                                                                                      sourceentity
                                                                                                   ),
                                                                                                   (
                                                                                                         entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                            : -1.0F
                                                                                                      )
                                                                                                      * 10.0F
                                                                                                );
                                                                                                entity.hurt(
                                                                                                   new DamageSource(
                                                                                                      world.registryAccess()
                                                                                                         .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                         .getHolderOrThrow(DamageTypes.MAGIC)
                                                                                                   ),
                                                                                                   (
                                                                                                         entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                            : -1.0F
                                                                                                      )
                                                                                                      * 10.0F
                                                                                                );
                                                                                                entity.hurt(
                                                                                                   new DamageSource(
                                                                                                      world.registryAccess()
                                                                                                         .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                                                         .getHolderOrThrow(DamageTypes.GENERIC)
                                                                                                   ),
                                                                                                   (
                                                                                                         entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMaxHealth()
                                                                                                            : -1.0F
                                                                                                      )
                                                                                                      * 10.0F
                                                                                                );
                                                                                                ArphexMod.queueServerWork(1, () -> {
                                                                                                   if (entity.isAlive()
                                                                                                      && entity instanceof LivingEntity _entity) {
                                                                                                      _entity.setHealth(0.0F);
                                                                                                   }
                                                                                                });
                                                                                             }
                                                                                          }
                                                                                       );
                                                                                    }
                                                                                 }
                                                                              );
                                                                           }
                                                                        }
                                                                     );
                                                                  }
                                                               }
                                                            );
                                                         }
                                                      }
                                                   );
                                                }
                                             }
                                          );
                                       }
                                    }
                                 );
                              }
                           }
                        );
                     }
                  }
               );
            }
         }

         if ((Boolean)ConfigurationSettingsConfiguration.DROP_TROPHIES.get()
            && entity instanceof LivingEntity
            && sourceentity instanceof Player
            && ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().startsWith("arphex:")
            && !entity.getPersistentData().getBoolean("done_trophy_arphex")
            && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("clone")
            && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("hallucination")
            && !(entity instanceof VenusFlytrapEntity)
            && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("web")
            && !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().contains("moth_summon")) {
            custom_itemstack = new ItemStack((ItemLike)ArphexModItems.TROPHY_ITEM.get());
            custom_itemstack.getOrCreateTag()
               .putString(
                  "trophy_entity",
                  ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString().replace("_tiny", "").replace("_giant", "").replace("arphex:", "").strip()
               );
            custom_itemstack.getOrCreateTag()
               .putDouble("trophy_entity_size", 1.0 / (Math.cbrt((double)(entity.getBbHeight() * entity.getBbWidth())) * 10.0) * 4.0);
            custom_itemstack.setHoverName(Component.literal(entity.getDisplayName().getString() + " Trophy"));
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, custom_itemstack);
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            entity.getPersistentData().putBoolean("done_trophy_arphex", true);
         }
      }
   }
}
