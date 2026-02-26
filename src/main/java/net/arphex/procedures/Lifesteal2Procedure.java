package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.ArachnoidTimeCloneEntity;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.ChronoShotEntity;
import net.arphex.entity.ChronoSpearShotEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.EntropyConduitEntity;
import net.arphex.entity.GravitonShotEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderSinkerEntity;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Lifesteal2Procedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
      }
   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      execute(null, world, damagesource, entity, immediatesourceentity, sourceentity);
   }

   private static void execute(
      @Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity
   ) {
      if (damagesource != null && entity != null && immediatesourceentity != null && sourceentity != null) {
         if (entity instanceof SpiderFlatEntity) {
            if ((sourceentity.isShiftKeyDown() || damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment"))))
               && entity instanceof TamableAnimal _tamEntxx
               && _tamEntxx.isTame()
               && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == sourceentity) {
               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }

               if (ArphexModVariables.MapVariables.get(world).t1_patrons_list.contains(("," + sourceentity.getName().getString() + ",").toLowerCase())) {
                  if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§2T1 Patreon perk detected and mob skin switched!"), true);
                  }

                  if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))) {
                     if ((entity instanceof SpiderFlatEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) > 4) {
                        if (entity instanceof SpiderFlatEntity _datEntSetI) {
                           _datEntSetI.getEntityData().set(SpiderFlatEntity.DATA_patreon_reskin, 0);
                        }
                     } else if (entity instanceof SpiderFlatEntity _datEntSetI) {
                        _datEntSetI.getEntityData()
                           .set(
                              SpiderFlatEntity.DATA_patreon_reskin,
                              (entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0)
                                 + 1
                           );
                     }
                  }

                  if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0) == 0) {
                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_reskin_model, "spiderflat");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_death, "death");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_attack, "attack");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_sneak, "grab");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_swim, "scurrying");
                     }
                  } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0)
                     == 1) {
                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_reskin_model, "spiderbrood");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_death, "death");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_attack, "aggressive");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_sneak, "grab");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_swim, "scurrying");
                     }
                  } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0)
                     == 2) {
                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_reskin_model, "scorpionstriker");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_death, "death");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_attack, "attack");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_sprint, "grab");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_swim, "scurrying");
                     }
                  } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0)
                     == 3) {
                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_reskin_model, "longlegs");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_death, "death");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_attack, "attack");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_sprint, "grab");
                     }
                  } else if ((entity instanceof SpiderFlatEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(SpiderFlatEntity.DATA_patreon_reskin) : 0)
                     == 4) {
                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_reskin_model, "waterroach");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_death, "death");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_attack, "none");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_sprint, "grab");
                     }
                  } else {
                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_reskin_model, "centipedeevictor");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_death, "death");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_attack, "attacking");
                     }

                     if (entity instanceof SpiderFlatEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(SpiderFlatEntity.DATA_sneak, "grab");
                     }
                  }
               } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§cT1 mob reskinning Patreon perk not detected"), true);
               }
            }
         } else if (entity instanceof TamedTarantulaEntity) {
            if (sourceentity.isShiftKeyDown()
               && entity instanceof TamableAnimal _tamEntxx
               && _tamEntxx.isTame()
               && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
               && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == sourceentity) {
               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }

               if (ArphexModVariables.MapVariables.get(world).t2_patrons_list.contains(("," + sourceentity.getName().getString() + ",").toLowerCase())) {
                  if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§2T2 Patreon perk detected and mob skin switched!"), true);
                  }

                  if ((entity instanceof TamedTarantulaEntity _datEntIx ? (Integer)_datEntIx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin) : 0)
                     > 3) {
                     if (entity instanceof TamedTarantulaEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(TamedTarantulaEntity.DATA_patreon_reskin, 0);
                     }
                  } else if (entity instanceof TamedTarantulaEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           TamedTarantulaEntity.DATA_patreon_reskin,
                           (
                                 entity instanceof TamedTarantulaEntity _datEntIxx
                                    ? (Integer)_datEntIxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                                    : 0
                              )
                              + 1
                        );
                  }

                  if ((
                        entity instanceof TamedTarantulaEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                           : 0
                     )
                     == 0) {
                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_reskin_model, "spidertarantula");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_death, "death");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_attack, "attack");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_sneak, "grab");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_swim, "scurrying");
                     }
                  } else if ((
                        entity instanceof TamedTarantulaEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                           : 0
                     )
                     == 1) {
                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_reskin_model, "spiderwander");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_idle, "idleride");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_death, "death");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_attack, "attack");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_sneak, "grab");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_swim, "scurrying");
                     }
                  } else if ((
                        entity instanceof TamedTarantulaEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                           : 0
                     )
                     == 2) {
                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_reskin_model, "spider_ambusher");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_idle, "idletamed");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_walk, "prowlingtamed");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_death, "death");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_attack, "attacktamed");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_sneak, "prowlingtamed");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_swim, "prowlingtamed");
                     }
                  } else if ((
                        entity instanceof TamedTarantulaEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                           : 0
                     )
                     == 3) {
                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_reskin_model, "spiderwidow");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_idle, "idle");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_walk, "scurrying");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_death, "death");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_swim, "scurrying");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_attack, "aggressive");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_sneak, "grab");
                     }
                  } else if ((
                        entity instanceof TamedTarantulaEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(TamedTarantulaEntity.DATA_patreon_reskin)
                           : 0
                     )
                     == 4) {
                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_reskin_model, "spider_recluse");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_idle, "idleride");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_walk, "prowling");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_swim, "prowling");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_death, "death");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_attack, "attacktamed");
                     }

                     if (entity instanceof TamedTarantulaEntity _datEntSetS) {
                        _datEntSetS.getEntityData().set(TamedTarantulaEntity.DATA_sneak, "none");
                     }
                  }
               } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§cT2 mob reskinning Patreon perk not detected"), true);
               }
            }
         } else if (entity instanceof TormentorSummonEntity
            && (sourceentity.isShiftKeyDown() || damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment"))))
            && entity instanceof TamableAnimal _tamEntxx
            && _tamEntxx.isTame()
            && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
            && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == sourceentity) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (ArphexModVariables.MapVariables.get(world).t3_patrons_list.contains(("," + sourceentity.getName().getString() + ",").toLowerCase())) {
               if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§2T3 Patreon perk detected and mob skin switched!"), true);
               }

               if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("arphex:segment")))) {
                  if ((
                        entity instanceof TormentorSummonEntity _datEntIxx
                           ? (Integer)_datEntIxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)
                           : 0
                     )
                     > 0) {
                     if (entity instanceof TormentorSummonEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(TormentorSummonEntity.DATA_patreon_reskin, 0);
                     }
                  } else if (entity instanceof TormentorSummonEntity _datEntSetI) {
                     _datEntSetI.getEntityData()
                        .set(
                           TormentorSummonEntity.DATA_patreon_reskin,
                           (
                                 entity instanceof TormentorSummonEntity _datEntIxxx
                                    ? (Integer)_datEntIxxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)
                                    : 0
                              )
                              + 1
                        );
                  }
               }

               double _setval;
               double var180 = _setval = entity instanceof TormentorSummonEntity _datEntIxxx
                  ? (double)((Integer)_datEntIxxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)).intValue()
                  : 0.0;
               sourceentity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                  capability.player_persistent_patreon_torversion = _setval;
                  capability.syncPlayerVariables(sourceentity);
               });
               if ((
                     entity instanceof TormentorSummonEntity _datEntIxxxx
                        ? (Integer)_datEntIxxxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)
                        : 0
                  )
                  == 0) {
                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_reskin_model, "tormentor");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_idle, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_walk, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_death, "death");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_attack, "foldride");
                  }
               } else if ((
                     entity instanceof TormentorSummonEntity _datEntIxxxx
                        ? (Integer)_datEntIxxxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)
                        : 0
                  )
                  == 1) {
                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_reskin_model, "tormentor_t2");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_idle, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_walk, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_death, "death");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_attack, "foldride");
                  }
               } else if ((
                     entity instanceof TormentorSummonEntity _datEntIxxxx
                        ? (Integer)_datEntIxxxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)
                        : 0
                  )
                  == 2) {
                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_reskin_model, "tormentor_t2");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_idle, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_walk, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_death, "death");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_attack, "foldride");
                  }
               } else if ((
                     entity instanceof TormentorSummonEntity _datEntIxxxx
                        ? (Integer)_datEntIxxxx.getEntityData().get(TormentorSummonEntity.DATA_patreon_reskin)
                        : 0
                  )
                  == 3) {
                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_reskin_model, "tormentor_t2");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_idle, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_walk, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_death, "death");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_attack, "foldride");
                  }
               } else {
                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_reskin_model, "tormentor_t2");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_idle, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_walk, "idleride");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_death, "death");
                  }

                  if (entity instanceof TormentorSummonEntity _datEntSetS) {
                     _datEntSetS.getEntityData().set(TormentorSummonEntity.DATA_attack, "foldride");
                  }
               }
            } else if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§cT3 mob reskinning Patreon perk not detected"), true);
            }
         }

         if (!(immediatesourceentity instanceof ChronoShotEntity) && !(immediatesourceentity instanceof ChronoSpearShotEntity)) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.VISIONARY_SPEAR.get()
               && sourceentity instanceof Player _player) {
               _player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem(), 2);
            }
         } else if (sourceentity instanceof Player
            && (
               entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)
                  || entity == sourceentity
            )
            && event != null
            && event.isCancelable()) {
            event.setCanceled(true);
         }

         if (sourceentity instanceof ArachnoidTrisectorEntity) {
            if (sourceentity == entity
               && !immediatesourceentity.getPersistentData().getBoolean("reverse_mirror_attack")
               && event != null
               && event.isCancelable()) {
               event.setCanceled(true);
            }

            if (entity instanceof ArachnoidTimeCloneEntity && event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (entity instanceof SpiderSinkerEntity && entity instanceof SpiderSinkerEntity _datEntSetI) {
            _datEntSetI.getEntityData().set(SpiderSinkerEntity.DATA_float_time, 400);
         }

         if (entity instanceof EntropyConduitEntity) {
            ArphexMod.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                  _entityx.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 10, 0, false, false));
               }
            });
            if (sourceentity instanceof DiabolosDecimatorEntity && event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (sourceentity instanceof DiabolosDecimatorEntity && damagesource.is(DamageTypes.MOB_ATTACK) && world instanceof ServerLevel _level) {
            _level.sendParticles(
               (SimpleParticleType)ArphexModParticleTypes.ENTROPY_SPEAR.get(), entity.getX(), entity.getY(), entity.getZ(), 10, 0.3, 0.3, 0.3, 0.0
            );
         }

         if (immediatesourceentity instanceof GravitonShotEntity && !damagesource.is(DamageTypes.GENERIC) && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         if ((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ArphexModItems.ABYSSAL_DAGGER.get()
            && sourceentity instanceof Player _plrCldCheck187
            && _plrCldCheck187.getCooldowns()
               .isOnCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())
            && !(sourceentity.getPersistentData().getDouble("immunity_cooldown_dagger") > 0.0)) {
            sourceentity.getPersistentData().putDouble("immunity_cooldown_dagger", 20.0);
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.INVINCIBILITY_TEMP.get(), 10, 0, false, false));
            }
         }
      }
   }
}
