package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.init.ArphexModEntities;
import net.arphex.init.ArphexModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChronoShotProjectileHitsLivingEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
      if (entity != null && immediatesourceentity != null && sourceentity != null) {
         if ((!(entity instanceof TamableAnimal _tamIsTamedBy) || !(sourceentity instanceof LivingEntity _livEnt) || !_tamIsTamedBy.isOwnedBy(_livEnt))
            && entity != sourceentity) {
            if (!(entity instanceof SphereAnimEntity)) {
               ArphexMod.queueServerWork(
                  1,
                  () -> {
                     if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ((EntityType)ArphexModEntities.SPHERE_ANIM.get())
                           .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                        }
                     }

                     ArphexMod.queueServerWork(
                        2,
                        () -> {
                           if (!world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
                              Entity patt2285$temp = world.getEntitiesOfClass(
                                    SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true
                                 )
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null);
                              if (patt2285$temp instanceof SphereAnimEntity _datEntSetS) {
                                 _datEntSetS.getEntityData().set(SphereAnimEntity.DATA_color, "green");
                              }

                              patt2285$temp = world.getEntitiesOfClass(SphereAnimEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                                 .stream()
                                 .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                       return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                 }).compareDistOf(x, y, z))
                                 .findFirst()
                                 .orElse(null);
                              if (patt2285$temp instanceof SphereAnimEntity _datEntSetI) {
                                 _datEntSetI.getEntityData().set(SphereAnimEntity.DATA_max_size, 50);
                              }
                           }
                        }
                     );
                  }
               );
            }

            if (entity instanceof TORMENTOREntity) {
               if (!immediatesourceentity.getPersistentData().getBoolean("done_torhit")) {
                  if (immediatesourceentity.getPersistentData().getBoolean("chrono_boost")) {
                     entity.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                        108.0F
                     );
                  } else {
                     entity.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                        85.0F
                     );
                  }
               }

               immediatesourceentity.getPersistentData().putBoolean("done_torhit", true);
            } else if ((!(entity instanceof LivingEntity _livEnt19) || !_livEnt19.isBlocking())
               && (entity instanceof LivingEntity _entUseItem20 ? _entUseItem20.getUseItem() : ItemStack.EMPTY).getItem()
                  != ArphexModItems.ABYSS_ASCENDANT.get()) {
               if (sourceentity instanceof ArachnoidTrisectorEntity) {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                     Math.max(9.0F, (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F) / 10.0F)
                  );
               } else if (immediatesourceentity.getPersistentData().getBoolean("chrono_boost")) {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                     100.0F
                  );
               } else {
                  entity.hurt(
                     new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), sourceentity),
                     80.0F
                  );
               }
            }
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }
      }
   }
}
