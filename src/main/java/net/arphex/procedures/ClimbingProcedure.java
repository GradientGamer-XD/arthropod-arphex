package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.entity.AntArsonistEntity;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.entity.LongLegsEntity;
import net.arphex.entity.LongLegsTinyEntity;
import net.arphex.entity.RoachRiverspawnEntity;
import net.arphex.entity.SilverfishSpectreEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderJumpEntity;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.init.ArphexModMobEffects;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ClimbingProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getBoolean("arphexclimber")
            && (
               !(entity instanceof SilverfishSpectreEntity)
                     && !(entity instanceof RoachRiverspawnEntity)
                     && !(entity instanceof LongLegsEntity)
                     && !(entity instanceof LongLegsTinyEntity)
                     && !(entity instanceof SpiderFlatEntity)
                     && !(entity instanceof SpiderJumpEntity)
                     && !(entity instanceof AntArsonistEntity)
                     && !(entity instanceof AntArsonistWorkerEntity)
                  || !(entity instanceof LivingEntity _livEnt9)
                  || !_livEnt9.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())
            )
            && (
               !(entity instanceof TamedTarantulaEntity)
                  || entity.isVehicle()
                     && entity instanceof LivingEntity _livEnt12
                     && _livEnt12.hasEffect((MobEffect)ArphexModMobEffects.SPIDER_SILK_TOUCH.get())
            )
            && !entity.isInWater()) {
            if ((double)world.getBlockState(BlockPos.containing(x, y + 0.5, z)).getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z)) >= 0.3
               || (double)world.getBlockState(BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") - 0.05, y + 0.5, z))
                     .getDestroySpeed(world, BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") - 0.05, y + 0.5, z))
                  >= 0.3
               || (double)world.getBlockState(BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") - 0.05), y + 0.5, z))
                     .getDestroySpeed(world, BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") - 0.05), y + 0.5, z))
                  >= 0.3
               || (double)world.getBlockState(BlockPos.containing(x, y + 0.5, z - (entity.getPersistentData().getDouble("climbradius") - 0.05)))
                     .getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z - (entity.getPersistentData().getDouble("climbradius") - 0.05)))
                  >= 0.3
               || (double)world.getBlockState(BlockPos.containing(x, y + 0.5, z + entity.getPersistentData().getDouble("climbradius") - 0.05))
                     .getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z + entity.getPersistentData().getDouble("climbradius") - 0.05))
                  >= 0.3) {
               if (entity.isVehicle()) {
                  ArphexMod.queueServerWork(
                     10,
                     () -> {
                        if ((
                              (double)world.getBlockState(BlockPos.containing(x, y + 0.5, z)).getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z)) >= 0.3
                                 || (double)world.getBlockState(BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") - 0.05, y + 0.5, z))
                                       .getDestroySpeed(world, BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") - 0.05, y + 0.5, z))
                                    >= 0.3
                                 || (double)world.getBlockState(
                                          BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") - 0.05), y + 0.5, z)
                                       )
                                       .getDestroySpeed(
                                          world, BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") - 0.05), y + 0.5, z)
                                       )
                                    >= 0.3
                                 || (double)world.getBlockState(
                                          BlockPos.containing(x, y + 0.5, z - (entity.getPersistentData().getDouble("climbradius") - 0.05))
                                       )
                                       .getDestroySpeed(
                                          world, BlockPos.containing(x, y + 0.5, z - (entity.getPersistentData().getDouble("climbradius") - 0.05))
                                       )
                                    >= 0.3
                                 || (double)world.getBlockState(BlockPos.containing(x, y + 0.5, z + entity.getPersistentData().getDouble("climbradius") - 0.05))
                                       .getDestroySpeed(world, BlockPos.containing(x, y + 0.5, z + entity.getPersistentData().getDouble("climbradius") - 0.05))
                                    >= 0.3
                           )
                           && entity instanceof LivingEntity _entityx
                           && !_entityx.level().isClientSide()) {
                           _entityx.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 50, 1, false, false));
                        }
                     }
                  );
               }

               if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
                  ArphexMod.queueServerWork(
                     13,
                     () -> entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 0.0299,
                              0.15,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 0.0299
                           )
                        )
                  );
               } else if (entity.getY() < (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY()) {
                  if (entity.getY() > (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getY()) {
                     entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                           (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX(),
                           (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getY(),
                           (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getZ()
                        )
                     );
                  }

                  ArphexMod.queueServerWork(
                     13,
                     () -> entity.setDeltaMovement(
                           new Vec3(
                              Math.cos((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 0.0299,
                              0.15,
                              Math.sin((double)(entity.getYRot() + 90.0F) * (Math.PI / 180.0)) * 0.0299
                           )
                        )
                  );
               }
            }

            if (entity.getPersistentData().getDouble("climbradius") <= 0.2) {
               ArphexMod.queueServerWork(10, () -> {
                  if (entity.getPersistentData().getDouble("climbradius") <= 0.2) {
                     entity.getPersistentData().putDouble("climbradius", 1.0);
                  }
               });
            }

            if (!(entity instanceof TamedTarantulaEntity)
               && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
               && world.isEmptyBlock(BlockPos.containing(x, y - 1.0, z))
               && !entity.onGround()
               && entity.getDeltaMovement().y() > 0.1) {
               if ((double)world.getBlockState(BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") + 0.05, y, z))
                     .getDestroySpeed(world, BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") + 0.05, y, z))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x + 2.0, y, z));
               } else if ((double)world.getBlockState(BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") + 0.05), y, z))
                     .getDestroySpeed(world, BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") + 0.05), y, z))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x - 2.0, y, z));
               } else if ((double)world.getBlockState(BlockPos.containing(x, y, z - (entity.getPersistentData().getDouble("climbradius") + 0.05)))
                     .getDestroySpeed(world, BlockPos.containing(x, y, z - (entity.getPersistentData().getDouble("climbradius") + 0.05)))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x, y, z - 2.0));
               } else if ((double)world.getBlockState(BlockPos.containing(x, y, z + entity.getPersistentData().getDouble("climbradius") + 0.05))
                     .getDestroySpeed(world, BlockPos.containing(x, y, z + entity.getPersistentData().getDouble("climbradius") + 0.05))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 2.0));
               } else if ((double)world.getBlockState(BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") + 0.05, y - 1.0, z))
                     .getDestroySpeed(world, BlockPos.containing(x + entity.getPersistentData().getDouble("climbradius") + 0.05, y - 1.0, z))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x + 2.0, y, z));
               } else if ((double)world.getBlockState(BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") + 0.05), y - 1.0, z))
                     .getDestroySpeed(world, BlockPos.containing(x - (entity.getPersistentData().getDouble("climbradius") + 0.05), y - 1.0, z))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x - 2.0, y, z));
               } else if ((double)world.getBlockState(BlockPos.containing(x, y - 1.0, z - (entity.getPersistentData().getDouble("climbradius") + 0.05)))
                     .getDestroySpeed(world, BlockPos.containing(x, y - 1.0, z - (entity.getPersistentData().getDouble("climbradius") + 0.05)))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x, y, z - 2.0));
               } else if ((double)world.getBlockState(BlockPos.containing(x, y - 1.0, z + entity.getPersistentData().getDouble("climbradius") + 0.05))
                     .getDestroySpeed(world, BlockPos.containing(x, y - 1.0, z + entity.getPersistentData().getDouble("climbradius") + 0.05))
                  >= 0.3) {
                  if (entity instanceof Mob _entity) {
                     _entity.getNavigation().stop();
                  }

                  entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 2.0));
               }
            }
         }
      }
   }
}
