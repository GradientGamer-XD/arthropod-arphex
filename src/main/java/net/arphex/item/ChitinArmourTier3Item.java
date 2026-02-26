package net.arphex.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.arphex.client.model.Modelchitinstrong;
import net.arphex.procedures.ChitinArmourBootsTickEventProcedure;
import net.arphex.procedures.ChitinArmourChestplateTickEventProcedure;
import net.arphex.procedures.ChitinArmourHelmetTickEventProcedure;
import net.arphex.procedures.ChitinArmourLeggingsTickEventProcedure;
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

public abstract class ChitinArmourTier3Item extends ArmorItem {
   public ChitinArmourTier3Item(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 1024;
         }

         public int getDefenseForType(Type type) {
            return new int[]{3, 6, 8, 3}[type.getSlot().getIndex()];
         }

         public int getEnchantmentValue() {
            return 12;
         }

         public SoundEvent getEquipSound() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("arphex:creepy_arthropod"));
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }

         public String getName() {
            return "chitin_armour_tier_3";
         }

         public float getToughness() {
            return 3.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Boots extends ChitinArmourTier3Item {
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
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).LeftBoot,
                           "right_leg",
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).RightBoot,
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
         list.add(Component.literal("Boots crafted from hard exoskeleton material, providing a strong double jump ability"));
         list.add(Component.literal("Set bonus: 40% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Created by smithing tier 2 chitin boots with a netherite ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmor.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourBootsTickEventProcedure.execute(world, entity, itemstack);
         }
      }
   }

   public static class Chestplate extends ChitinArmourTier3Item {
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
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).Chestplate,
                           "left_arm",
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).LeftPlate,
                           "right_arm",
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).RightPlate,
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
         list.add(
            Component.literal("Chestplate crafted from hard exoskeleton material, providing resistance + strength + regen effects to all nearby tamed mobs")
         );
         list.add(Component.literal("Set bonus: 40% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Created by smithing a tier 2 chitin chestplate with a netherite ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmor.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourChestplateTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Helmet extends ChitinArmourTier3Item {
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
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).Helmet,
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
               "Helmet crafted from hard exoskeleton material, providing wide-range heightened awareness abilities when crouching (blue line = neutral, red line = attacking, purple line = player, green line = tamed, white line = item, others can't see the lines)"
            )
         );
         list.add(Component.literal("Set bonus: 40% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Created by smithing a tier 2 chitin helmet with a netherite ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmor.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Leggings extends ChitinArmourTier3Item {
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
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).LeftLegging,
                           "right_leg",
                           (new Modelchitinstrong(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinstrong.LAYER_LOCATION))).RightLegging,
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
         list.add(Component.literal("Leggings crafted from hard exoskeleton material, providing immunity to Webbed effects and strong speed in cobwebs"));
         list.add(Component.literal("Set bonus: 40% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Created by smithing tier 2 chitin leggings with a netherite ingot"));
         list.add(Component.literal("§7Enchantable "));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmor.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourLeggingsTickEventProcedure.execute(world, entity, itemstack);
         }
      }
   }
}
