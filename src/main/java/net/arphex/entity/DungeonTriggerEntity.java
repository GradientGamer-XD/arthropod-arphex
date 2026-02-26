package net.arphex.entity;

import net.arphex.init.ArphexModEntities;
import net.arphex.procedures.DungeonTriggerOnEntityTickUpdateProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

public class DungeonTriggerEntity extends PathfinderMob {
   public DungeonTriggerEntity(SpawnEntity packet, Level world) {
      this((EntityType<DungeonTriggerEntity>)ArphexModEntities.DUNGEON_TRIGGER.get(), world);
   }

   public DungeonTriggerEntity(EntityType<DungeonTriggerEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 0;
      this.setNoAi(true);
      this.setPersistenceRequired();
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      return damagesource.is(DamageTypes.FALL) ? false : super.hurt(damagesource, amount);
   }

   public void baseTick() {
      super.baseTick();
      DungeonTriggerOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 5.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
      return builder.add(Attributes.FOLLOW_RANGE, 16.0);
   }
}
