package net.arphex.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.arphex.client.model.Modelvitality;
import net.arphex.procedures.VitalityArmourBootsTickEventProcedure;
import net.arphex.procedures.VitalityArmourChestplateTickEventProcedure;
import net.arphex.procedures.VitalityArmourHelmetTickEventProcedure;
import net.arphex.procedures.VitalityArmourLeggingsTickEventProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class VitalityArmourItem extends ArmorItem {
   public VitalityArmourItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 50;
         }

         public int getDefenseForType(Type type) {
            return new int[]{3, 4, 8, 5}[type.getSlot().getIndex()];
         }

         public int getEnchantmentValue() {
            return 10;
         }

         public SoundEvent getEquipSound() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod"));
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }

         public String getName() {
            return "vitality_armour";
         }

         public float getToughness() {
            return 2.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Boots extends VitalityArmourItem {
      public Boots() {
         super(Type.BOOTS, new Properties());
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
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).LeftBoot,
                           "right_leg",
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).RightBoot,
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
         list.add(Component.literal("Boots crafted from the essence of vitality, providing a significant speed boost"));
         list.add(Component.literal("Set bonus: Major regeneration"));
         list.add(Component.literal("§7Created by smithing golden boots with a mantle of vitality"));
         list.add(Component.literal("§7Enchantable "));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/vitalityarmour.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            VitalityArmourBootsTickEventProcedure.execute(entity);
         }
      }
   }

   public static class Chestplate extends VitalityArmourItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Properties());
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
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).Chestplate,
                           "left_arm",
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).LeftPlate,
                           "right_arm",
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).RightPlate,
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

      public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
         super.appendHoverText(itemstack, level, list, flag);
         list.add(Component.literal("Chestplate crafted from the essence of vitality, providing boosted health every 30 seconds"));
         list.add(Component.literal("Set bonus: Major regeneration"));
         list.add(Component.literal("§7Created by smithing a golden chestplate with a mantle of vitality"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/vitalityarmour.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            VitalityArmourChestplateTickEventProcedure.execute(entity);
         }
      }
   }

   public static class Helmet extends VitalityArmourItem {
      public Helmet() {
         super(Type.HELMET, new Properties());
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
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).Helmet,
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
         list.add(Component.literal("Helmet crafted from the essence of vitality, providing protection from nausea and blindness"));
         list.add(Component.literal("Set bonus: Major regeneration"));
         list.add(Component.literal("§7Created by smithing a golden helmet with a mantle of vitality"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/vitalityarmour.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            VitalityArmourHelmetTickEventProcedure.execute(entity);
         }
      }
   }

   public static class Leggings extends VitalityArmourItem {
      public Leggings() {
         super(Type.LEGGINGS, new Properties());
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
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).LeftLegging,
                           "right_leg",
                           (new Modelvitality(Minecraft.getInstance().getEntityModels().bakeLayer(Modelvitality.LAYER_LOCATION))).RightLegging,
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
         list.add(Component.literal("Leggings crafted from the essence of vitality, providing regeneration and immunity to necrosis"));
         list.add(Component.literal("Set bonus: Major regeneration"));
         list.add(Component.literal("§7Created by smithing golden leggings with a mantle of vitality"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/vitalityarmour.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            VitalityArmourLeggingsTickEventProcedure.execute(entity);
         }
      }
   }
}
