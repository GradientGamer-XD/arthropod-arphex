package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.entity.CrabLarvaeEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ConstrictedOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MobEffects.REGENERATION);
         }

         if (!(entity.getPersistentData().getDouble("crushdamage") > 0.0)) {
            if (!(entity instanceof CrabConstrictorEntity)
               && (!(entity instanceof LivingEntity _livEnt3) || !_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE))
               && !entity.getPersistentData().getBoolean("creativespectator")) {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.CHARRED_BLOOD.get(), x, y, z, 10, 0.2, 0.2, 0.2, 0.3);
               }

               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3.0F);
               entity.getPersistentData().putDouble("crushdamage", 19.0);
            }
         } else {
            entity.getPersistentData().putDouble("crushdamage", entity.getPersistentData().getDouble("crushdamage") - 1.0);
         }

         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 5, 5, false, false));
         }

         if (!world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).isEmpty()
            && !world.isEmptyBlock(BlockPos.containing(x, y - 1.5, z))
            && world.getEntitiesOfClass(CrabLarvaeEntity.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
               }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).isShiftKeyDown()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 0, false, false));
            }

            entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
         }
      }
   }
}
