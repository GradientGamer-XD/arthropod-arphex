package net.arphex.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.arphex.client.model.Modelchitinweak;
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

public abstract class ChitinArmourItem extends ArmorItem {
   public ChitinArmourItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 20;
         }

         public int getDefenseForType(Type type) {
            return new int[]{2, 5, 6, 2}[type.getSlot().getIndex()];
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
            return "chitin_armour";
         }

         public float getToughness() {
            return 2.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Boots extends ChitinArmourItem {
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
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).LeftBoot,
                           "right_leg",
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).RightBoot,
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
         list.add(Component.literal("Boots crafted from hard exoskeleton material, providing a slight double jump ability"));
         list.add(Component.literal("Set bonus: 10% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmorweak.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourBootsTickEventProcedure.execute(world, entity, itemstack);
         }
      }
   }

   public static class Chestplate extends ChitinArmourItem {
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
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).Chestplate,
                           "left_arm",
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).LeftPlate,
                           "right_arm",
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).RightPlate,
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
         list.add(Component.literal("Chestplate crafted from hard exoskeleton material, providing resistance effects to all nearby tamed mobs"));
         list.add(Component.literal("Set bonus: 10% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Enchantable "));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmorweak.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourChestplateTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Helmet extends ChitinArmourItem {
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
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).Helmet,
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
               "Helmet crafted from hard exoskeleton material, providing short-range heightened awareness abilities when crouching (blue line = neutral, red line = attacking, purple line = player, green line = tamed, white line = item, others can't see the lines)"
            )
         );
         list.add(Component.literal("Set bonus: 10% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmorweak.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Leggings extends ChitinArmourItem {
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
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).LeftLegging,
                           "right_leg",
                           (new Modelchitinweak(Minecraft.getInstance().getEntityModels().bakeLayer(Modelchitinweak.LAYER_LOCATION))).RightLegging,
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
         list.add(Component.literal("Leggings crafted from hard exoskeleton material, providing immunity to Webbed effects"));
         list.add(Component.literal("Set bonus: 10% reduction to all damage taken from behind"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/chitinarmorweak.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            ChitinArmourLeggingsTickEventProcedure.execute(world, entity, itemstack);
         }
      }
   }
}
