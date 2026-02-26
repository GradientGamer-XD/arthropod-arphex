package net.arphex.procedures;

import java.util.Comparator;
import net.arphex.entity.SpiderRecluseEntity;
import net.arphex.init.ArphexModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveWebOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean solidfound = false;
         Entity nearest = null;
         entity.teleportTo(Math.floor(x) + 0.5, y, Math.floor(z) + 0.5);
         if (entity instanceof ServerPlayer _serverPlayer) {
            _serverPlayer.connection.teleport(Math.floor(x) + 0.5, y, Math.floor(z) + 0.5, entity.getYRot(), entity.getXRot());
         }

         if (world.isEmptyBlock(BlockPos.containing(x, y + 2.0, z))
            && !world.getEntitiesOfClass(SpiderRecluseEntity.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 8.0, 8.0, 8.0), e -> true).isEmpty()) {
            entity.getPersistentData().putDouble("webtimer", 2400.0);
            nearest = world.getEntitiesOfClass(SpiderRecluseEntity.class, AABB.ofSize(new Vec3(x, y + 2.0, z), 8.0, 8.0, 8.0), e -> true)
               .stream()
               .sorted((new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                  }
               }).compareDistOf(x, y + 2.0, z))
               .findFirst()
               .orElse(null);
            if ((nearest instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) == null
               && (nearest instanceof SpiderRecluseEntity _datEntI ? (Integer)_datEntI.getEntityData().get(SpiderRecluseEntity.DATA_size) : 0) <= 30) {
               nearest.teleportTo(x, y + 2.0, z);
               if (nearest instanceof ServerPlayer _serverPlayer) {
                  _serverPlayer.connection.teleport(x, y + 2.0, z, nearest.getYRot(), nearest.getXRot());
               }

               if (nearest instanceof SpiderRecluseEntity _datEntSetI) {
                  _datEntSetI.getEntityData().set(SpiderRecluseEntity.DATA_hangweb, 3);
               }

               nearest.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (!world.isClientSide()) {
                  nearest.setYRot(entity.getYRot() + 90.0F);
                  nearest.setXRot(0.0F);
                  nearest.setYBodyRot(nearest.getYRot());
                  nearest.setYHeadRot(nearest.getYRot());
                  nearest.yRotO = nearest.getYRot();
                  nearest.xRotO = nearest.getXRot();
                  if (nearest instanceof LivingEntity _entity) {
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }
            }
         }

         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         solidfound = false;
         if (world.getBlockState(BlockPos.containing(x + 1.0, y + 4.0, z)).canOcclude()
            && world.getBlockState(BlockPos.containing(x - 1.0, y + 4.0, z)).canOcclude()) {
            entity.setShiftKeyDown(false);
            entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
            solidfound = true;
         }

         if (world.getBlockState(BlockPos.containing(x, y + 4.0, z + 1.0)).canOcclude()
            && world.getBlockState(BlockPos.containing(x, y + 4.0, z - 1.0)).canOcclude()) {
            entity.setShiftKeyDown(false);
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 1.0));
            solidfound = true;
         }

         if (world.getBlockState(BlockPos.containing(x + 2.0, y + 3.0, z)).canOcclude()
            && world.getBlockState(BlockPos.containing(x - 2.0, y + 3.0, z)).canOcclude()) {
            entity.setShiftKeyDown(true);
            entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
            solidfound = true;
         }

         if (world.getBlockState(BlockPos.containing(x, y + 3.0, z + 2.0)).canOcclude()
            && world.getBlockState(BlockPos.containing(x, y + 3.0, z - 2.0)).canOcclude()) {
            entity.setShiftKeyDown(true);
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 1.0));
            solidfound = true;
         }

         if (world.getBlockState(BlockPos.containing(x + 1.0, y + 3.0, z)).canOcclude()
            && world.getBlockState(BlockPos.containing(x - 1.0, y + 3.0, z)).canOcclude()) {
            entity.setShiftKeyDown(true);
            entity.lookAt(Anchor.EYES, new Vec3(x + 1.0, y, z));
            solidfound = true;
         }

         if (world.getBlockState(BlockPos.containing(x, y + 3.0, z + 1.0)).canOcclude()
            && world.getBlockState(BlockPos.containing(x, y + 3.0, z - 1.0)).canOcclude()) {
            entity.setShiftKeyDown(true);
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z + 1.0));
            solidfound = true;
         }

         if (!solidfound && !entity.level().isClientSide()) {
            entity.discard();
         }

         Vec3 _center = new Vec3(x, y + 3.0, z);

         for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (!ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString().contains("spider")
               && !entityiterator.getPersistentData().getBoolean("creativespectator")) {
               entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.THIN_WEB.get(), x, entityiterator.getY(), z, 1, 0.2, 0.4, 0.2, 0.1);
               }
            }
         }

         entity.getPersistentData().putDouble("webtimer", entity.getPersistentData().getDouble("webtimer") + 1.0);
         if (entity.getPersistentData().getDouble("webtimer") > 4800.0
            && world.getEntitiesOfClass(SpiderRecluseEntity.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty()
            && !entity.level().isClientSide()) {
            entity.discard();
         }
      }
   }
}
