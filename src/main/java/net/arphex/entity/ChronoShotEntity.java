package net.arphex.entity;

import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.ChronoShotProjectileHitsLivingEntityProcedure;
import net.arphex.procedures.ChronoShotWhileProjectileFlyingTickProcedure;
import net.arphex.procedures.GenesisShotProjectileHitsBlockProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class ChronoShotEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack((ItemLike)ArphexModBlocks.INVISIBLE_DETECTOR_BLOCK.get());

   public ChronoShotEntity(SpawnEntity packet, Level world) {
      super((EntityType)ArphexModEntities.CHRONO_SHOT.get(), world);
   }

   public ChronoShotEntity(EntityType<? extends ChronoShotEntity> type, Level world) {
      super(type, world);
   }

   public ChronoShotEntity(EntityType<? extends ChronoShotEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public ChronoShotEntity(EntityType<? extends ChronoShotEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getItem() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack getPickupItem() {
      return PROJECTILE_ITEM;
   }

   protected void doPostHurtEffects(LivingEntity entity) {
      super.doPostHurtEffects(entity);
      entity.setArrowCount(entity.getArrowCount() - 1);
   }

   public void onHitEntity(EntityHitResult entityHitResult) {
      super.onHitEntity(entityHitResult);
      ChronoShotProjectileHitsLivingEntityProcedure.execute(
         this.level(), this.getX(), this.getY(), this.getZ(), entityHitResult.getEntity(), this, this.getOwner()
      );
   }

   public void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      GenesisShotProjectileHitsBlockProcedure.execute(
         this.level(),
         (double)blockHitResult.getBlockPos().getX(),
         (double)blockHitResult.getBlockPos().getY(),
         (double)blockHitResult.getBlockPos().getZ(),
         this.getOwner(),
         this
      );
   }

   public void tick() {
      super.tick();
      ChronoShotWhileProjectileFlyingTickProcedure.execute(this.level(), this.getOwner(), this);
      if (this.inGround) {
         this.discard();
      }
   }

   public static ChronoShotEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.0F, 5.0, 5);
   }

   public static ChronoShotEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      ChronoShotEntity entityarrow = new ChronoShotEntity((EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      world.playSound(
         null,
         entity.getX(),
         entity.getY(),
         entity.getZ(),
         (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
         SoundSource.PLAYERS,
         1.0F,
         1.0F / (random.nextFloat() * 0.5F + 1.0F) + power / 2.0F
      );
      return entityarrow;
   }

   public static ChronoShotEntity shoot(LivingEntity entity, LivingEntity target) {
      ChronoShotEntity entityarrow = new ChronoShotEntity((EntityType<? extends ChronoShotEntity>)ArphexModEntities.CHRONO_SHOT.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(5.0);
      entityarrow.setKnockback(5);
      entityarrow.setCritArrow(false);
      entity.level().addFreshEntity(entityarrow);
      entity.level()
         .playSound(
            null,
            entity.getX(),
            entity.getY(),
            entity.getZ(),
            (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
            SoundSource.PLAYERS,
            1.0F,
            1.0F / (RandomSource.create().nextFloat() * 0.5F + 1.0F)
         );
      return entityarrow;
   }
}
