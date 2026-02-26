package net.arphex.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.arphex.client.model.Modeleternal;
import net.arphex.procedures.EternalBootsTickEventProcedure;
import net.arphex.procedures.EternalChestplateTickEventProcedure;
import net.arphex.procedures.EternalHelmetTickEventProcedure;
import net.arphex.procedures.EternalLeggingsTickEventProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class EternalItem extends ArmorItem {
   public EternalItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 1024;
         }

         public int getDefenseForType(Type type) {
            return new int[]{6, 11, 15, 7}[type.getSlot().getIndex()];
         }

         public int getEnchantmentValue() {
            return 100;
         }

         public SoundEvent getEquipSound() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }

         public String getName() {
            return "eternal";
         }

         public float getToughness() {
            return 6.0F;
         }

         public float getKnockbackResistance() {
            return 0.9F;
         }
      }, type, properties);
   }

   public static class Boots extends EternalItem {
      public Boots() {
         super(Type.BOOTS, new Properties().fireResistant());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(
            new IClientItemExtensions() {
               @OnlyIn(Dist.CLIENT)
               public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                  HumanoidModel armorModel = new HumanoidModel(
                     new ModelPart(
                        Collections.emptyList(),
                        Map.of(
                           "left_leg",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).LeftBoot,
                           "right_leg",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).RightBoot,
                           "head",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "hat",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "body",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "right_arm",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "left_arm",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap())
                        )
                     )
                  );
                  armorModel.crouching = living.isShiftKeyDown();
                  armorModel.riding = defaultModel.riding;
                  armorModel.young = living.isBaby();
                  return armorModel;
               }
            }
         );
      }

      public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
         super.appendHoverText(itemstack, level, list, flag);
         list.add(
            Component.literal("§eDivine boots providing 1 block step height when sprinting and combined abilities of the Infernal, Spectral, and Umbral boots")
         );
         list.add(
            Component.literal(
               "Set bonuses: Other three armour set bonuses, plus Resistance + Eternal Evasion (rechargeable), giving brief automatic damage dodging after sneaking"
            )
         );
         list.add(Component.literal("§7Enchantable "));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/eternalarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            EternalBootsTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Chestplate extends EternalItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Properties().fireResistant());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(
            new IClientItemExtensions() {
               @OnlyIn(Dist.CLIENT)
               public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                  HumanoidModel armorModel = new HumanoidModel(
                     new ModelPart(
                        Collections.emptyList(),
                        Map.of(
                           "body",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).Chestplate,
                           "left_arm",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).LeftPlate,
                           "right_arm",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).RightPlate,
                           "head",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "hat",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "right_leg",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "left_leg",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap())
                        )
                     )
                  );
                  armorModel.crouching = living.isShiftKeyDown();
                  armorModel.riding = defaultModel.riding;
                  armorModel.young = living.isBaby();
                  return armorModel;
               }
            }
         );
      }

      public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
         return entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == this;
      }

      public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
         if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
               entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
         }

         return true;
      }

      public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
         super.appendHoverText(itemstack, level, list, flag);
         list.add(
            Component.literal(
               "§eDivine chestplate with elytra capacity, crawling dimension barrier immunity, and combined abilities of the Infernal, Spectral, and Umbral chestplates"
            )
         );
         list.add(
            Component.literal(
               "Set bonuses: Other three armour set bonuses, plus Resistance + Eternal Evasion (rechargeable), giving brief automatic damage dodging after sneaking"
            )
         );
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/eternalarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            EternalChestplateTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Helmet extends EternalItem {
      public Helmet() {
         super(Type.HELMET, new Properties().fireResistant());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(
            new IClientItemExtensions() {
               public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                  HumanoidModel armorModel = new HumanoidModel(
                     new ModelPart(
                        Collections.emptyList(),
                        Map.of(
                           "head",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).Helmet,
                           "hat",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "body",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "right_arm",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "left_arm",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "right_leg",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "left_leg",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap())
                        )
                     )
                  );
                  armorModel.crouching = living.isShiftKeyDown();
                  armorModel.riding = defaultModel.riding;
                  armorModel.young = living.isBaby();
                  return armorModel;
               }
            }
         );
      }

      public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
         super.appendHoverText(itemstack, level, list, flag);
         list.add(
            Component.literal(
               "§eDivine helmet providing immunity to tormentor vision blurring and combining the abilities of the Infernal, Spectral, and Umbral helmets"
            )
         );
         list.add(
            Component.literal(
               "Set bonuses: Other three armour set bonuses, plus Resistance + Eternal Evasion (rechargeable), giving brief automatic damage dodging after sneaking"
            )
         );
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/eternalarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            EternalHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Leggings extends EternalItem {
      public Leggings() {
         super(Type.LEGGINGS, new Properties().fireResistant());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(
            new IClientItemExtensions() {
               @OnlyIn(Dist.CLIENT)
               public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                  HumanoidModel armorModel = new HumanoidModel(
                     new ModelPart(
                        Collections.emptyList(),
                        Map.of(
                           "left_leg",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).LeftLegging,
                           "right_leg",
                           (new Modeleternal(Minecraft.getInstance().getEntityModels().bakeLayer(Modeleternal.LAYER_LOCATION))).RightLegging,
                           "head",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "hat",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "body",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "right_arm",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                           "left_arm",
                           new ModelPart(Collections.emptyList(), Collections.emptyMap())
                        )
                     )
                  );
                  armorModel.crouching = living.isShiftKeyDown();
                  armorModel.riding = defaultModel.riding;
                  armorModel.young = living.isBaby();
                  return armorModel;
               }
            }
         );
      }

      public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
         super.appendHoverText(itemstack, level, list, flag);
         list.add(
            Component.literal(
               "§eDivine leggings with major jump and speed boost on crouch and combined abilities of the Infernal, Spectral, and Umbral leggings"
            )
         );
         list.add(
            Component.literal(
               "Set bonuses: Other three armour set bonuses, plus Resistance + Eternal Evasion (rechargeable), giving brief automatic damage dodging after sneaking"
            )
         );
         list.add(Component.literal("§7Enchantable "));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/eternalarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            EternalLeggingsTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }
}
