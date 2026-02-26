package net.arphex.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import java.util.function.Consumer;
import net.arphex.item.renderer.SingularityScytheItemRenderer;
import net.arphex.procedures.RequiredForAnimProcedure;
import net.arphex.procedures.SingularityScytheEntitySwingsItemProcedure;
import net.arphex.procedures.SingularityScytheItemInHandTickProcedure;
import net.arphex.procedures.SingularityScytheItemIsCraftedsmeltedProcedure;
import net.arphex.procedures.SingularityScytheLivingEntityIsHitWithItemProcedure;
import net.arphex.procedures.SingularityScytheOnPlayerStoppedUsingProcedure;
import net.arphex.procedures.SingularityScytheRightclickedProcedure;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SingularityScytheItem extends Item implements GeoItem {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   public String animationprocedure = "empty";
   public static ItemDisplayContext transformType;

   public SingularityScytheItem() {
      super(new Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
   }

   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      super.initializeClient(consumer);
      consumer.accept(new IClientItemExtensions() {
         private final BlockEntityWithoutLevelRenderer renderer = new SingularityScytheItemRenderer();

         public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return this.renderer;
         }
      });
   }

   public void getTransformType(ItemDisplayContext type) {
      transformType = type;
   }

   private PlayState idlePredicate(AnimationState event) {
      if (transformType != null && this.animationprocedure.equals("empty")) {
         event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.none.scythe"));
         return PlayState.CONTINUE;
      } else {
         return PlayState.STOP;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if (transformType != null) {
         if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == State.STOPPED) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == State.STOPPED) {
               this.animationprocedure = "empty";
               event.getController().forceAnimationReset();
            }
         } else if (this.animationprocedure.equals("empty")) {
            return PlayState.STOP;
         }
      }

      return PlayState.CONTINUE;
   }

   public void registerControllers(ControllerRegistrar data) {
      AnimationController procedureController = new AnimationController(this, "procedureController", 0, this::procedurePredicate);
      data.add(new AnimationController[]{procedureController});
      AnimationController idleController = new AnimationController(this, "idleController", 0, this::idlePredicate);
      data.add(new AnimationController[]{idleController});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.BLOCK;
   }

   public int getUseDuration(ItemStack itemstack) {
      return 99999;
   }

   public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
      return 10.0F;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
         builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 49.0, Operation.ADDITION));
         builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, Operation.ADDITION));
         return builder.build();
      } else {
         return super.getDefaultAttributeModifiers(equipmentSlot);
      }
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("§4Scythe with overwhelming control over the laws of physics, capable of turning the strongest foes to cosmic dust"));
      list.add(Component.literal("- §6Massive damage output - 50 damage, amplified to percentage-based damage for stronger targets"));
      list.add(Component.literal("- §cAoE attacks on swing, coming with significant range and spread"));
      list.add(
         Component.literal(
            "- §dRight click ability briefly summons a micro black hole in front of you, swallowing any projectiles and dealing wide ranged damage to any attacking mobs (+withers any mobs in its radius)"
         )
      );
      list.add(Component.literal("- Provides resistance when held"));
      list.add(Component.literal("- §7Dual wielding provides vastly extended melee attack reach"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      ItemStack itemstack = (ItemStack)ar.getObject();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      SingularityScytheRightclickedProcedure.execute(entity, itemstack);
      return ar;
   }

   public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.finishUsingItem(itemstack, world, entity);
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      RequiredForAnimProcedure.execute();
      return retval;
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      SingularityScytheLivingEntityIsHitWithItemProcedure.execute(entity, itemstack);
      return retval;
   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      SingularityScytheEntitySwingsItemProcedure.execute(entity.level(), entity, itemstack);
      return retval;
   }

   public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
      super.onCraftedBy(itemstack, world, entity);
      SingularityScytheItemIsCraftedsmeltedProcedure.execute(itemstack);
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      if (selected) {
         SingularityScytheItemInHandTickProcedure.execute(world, entity, itemstack);
      }
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      SingularityScytheOnPlayerStoppedUsingProcedure.execute();
   }
}
