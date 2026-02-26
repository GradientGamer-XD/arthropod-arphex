package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SmallWebTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double randomattempt = 0.0;
         double randomattemptz = 0.0;
         double randomattempty = 0.0;
         if (world instanceof ServerLevel _level) {
            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, y, z, 1, 1.0, 1.0, 1.0, 0.05);
         }

         if (!world.isEmptyBlock(BlockPos.containing(x + 1.0, y + 1.0, z)) && !world.isEmptyBlock(BlockPos.containing(x - 1.0, y + 1.0, z))) {
            entity.lookAt(Anchor.EYES, new Vec3(entity.getX() - 5.0, entity.getY(), entity.getZ()));
         } else if (!world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z + 1.0)) && !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z - 1.0))) {
            entity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ() - 5.0));
         } else if (!world.isEmptyBlock(BlockPos.containing(x + 1.0, y + 1.0, z)) || !world.isEmptyBlock(BlockPos.containing(x - 1.0, y + 1.0, z))) {
            entity.lookAt(Anchor.EYES, new Vec3(entity.getX() - 5.0, entity.getY(), entity.getZ()));
         } else if (!world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z + 1.0)) || !world.isEmptyBlock(BlockPos.containing(x, y + 1.0, z - 1.0))) {
            entity.lookAt(Anchor.EYES, new Vec3(entity.getX(), entity.getY(), entity.getZ() - 5.0));
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

         Vec3 _center = new Vec3(x, y + 0.5, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (!entityiterator.getPersistentData().getBoolean("creativespectator")
               && !ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString().contains("spider")
               && (entityiterator instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               ArphexMod.queueServerWork(5, () -> entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25)));
            }
         }

         _center = new Vec3(x, y + 1.0, z);

         for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (!entityiteratorx.getPersistentData().getBoolean("creativespectator")
               && !ForgeRegistries.ENTITY_TYPES.getKey(entityiteratorx.getType()).toString().contains("spider")
               && (entityiteratorx instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null) {
               ArphexMod.queueServerWork(5, () -> entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25)));
            }
         }

         if (entity instanceof LivingEntity _entity) {
            _entity.removeAllEffects();
         }

         if ((entity.isInWall() || !world.isEmptyBlock(BlockPos.containing(x, y, z))) && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
      }
   }
}
