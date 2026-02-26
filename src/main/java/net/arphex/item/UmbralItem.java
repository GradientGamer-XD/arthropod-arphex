package net.arphex.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.arphex.client.model.Modelumbral;
import net.arphex.procedures.UmbralBootsTickProcedure;
import net.arphex.procedures.UmbralChestplateTickProcedure;
import net.arphex.procedures.UmbralHelmetTickProcedure;
import net.arphex.procedures.UmbralLeggingsTickProcedure;
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

public abstract class UmbralItem extends ArmorItem {
   public UmbralItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 1024;
         }

         public int getDefenseForType(Type type) {
            return new int[]{5, 10, 13, 5}[type.getSlot().getIndex()];
         }

         public int getEnchantmentValue() {
            return 50;
         }

         public SoundEvent getEquipSound() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }

         public String getName() {
            return "umbral";
         }

         public float getToughness() {
            return 6.0F;
         }

         public float getKnockbackResistance() {
            return 0.2F;
         }
      }, type, properties);
   }

   public static class Boots extends UmbralItem {
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
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).LeftBoot,
                           "right_leg",
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).RightBoot,
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
         list.add(Component.literal("§5Umbral boots capable of repelling the endless void, providing immunity from falling into the void"));
         list.add(Component.literal("Set bonuses: Automatic void shield protection harms and repels attacking mobs, plus complete immunity to weak attacks"));
         list.add(Component.literal("§7Created by smithing netherite boots with an umbral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/umbralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            UmbralBootsTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Chestplate extends UmbralItem {
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
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).Chestplate,
                           "left_arm",
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).LeftPlate,
                           "right_arm",
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).RightPlate,
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
            Component.literal(
               "§5Umbral chestplate capable of repelling the endless void, providing a 50% chance to teleport away from otherwise-fatal attacks - with cooldown"
            )
         );
         list.add(Component.literal("Set bonuses: Automatic void shield protection harms and repels attacking mobs, plus complete immunity to weak attacks"));
         list.add(Component.literal("§7Created by smithing a netherite chestplate with an umbral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/umbralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            UmbralChestplateTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Helmet extends UmbralItem {
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
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).Helmet,
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
         list.add(Component.literal("§5Umbral helmet capable of repelling the endless void, providing immunity to poison and levitation if crouching"));
         list.add(Component.literal("Set bonuses: Automatic void shield protection harms and repels attacking mobs, plus complete immunity to weak attacks"));
         list.add(Component.literal("§7Created by smithing a netherite helmet with an umbral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/umbralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            UmbralHelmetTickProcedure.execute(entity, itemstack);
         }
      }
   }

   public static class Leggings extends UmbralItem {
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
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).LeftLegging,
                           "right_leg",
                           (new Modelumbral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelumbral.LAYER_LOCATION))).RightLegging,
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
         list.add(Component.literal("§5Umbral leggings capable of repelling the endless void, providing a strong jump boost - especially when sneaking "));
         list.add(Component.literal("Set bonuses: Automatic void shield protection harms and repels attacking mobs, plus complete immunity to weak attacks"));
         list.add(Component.literal("§7Created by smithing netherite leggings with an umbral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/umbralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            UmbralLeggingsTickProcedure.execute(entity, itemstack);
         }
      }
   }
}
