package net.arphex.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.arphex.client.model.Modelspectral;
import net.arphex.procedures.SpectralBootsTickProcedure;
import net.arphex.procedures.SpectralChestplateTickProcedure;
import net.arphex.procedures.SpectralHelmetTickProcedure;
import net.arphex.procedures.SpectralLeggingsTickProcedure;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class SpectralItem extends ArmorItem {
   public SpectralItem(Type type, Properties properties) {
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
            return "spectral";
         }

         public float getToughness() {
            return 6.0F;
         }

         public float getKnockbackResistance() {
            return 0.3F;
         }
      }, type, properties);
   }

   public static class Boots extends SpectralItem {
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
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).LeftBoot,
                           "right_leg",
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).RightBoot,
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
               "§9Spectral boots capable of absorbing the shadow of death, providing a spectral walking ability - you can walk on liquids and non-solid objects (hold space to do so)"
            )
         );
         list.add(Component.literal("Set bonuses: Strong attacks steal health from enemies, plus complete immunity to taking damage from weak attacks"));
         list.add(Component.literal("§7Created by smithing netherite boots with a spectral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/spectralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpectralBootsTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Chestplate extends SpectralItem {
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
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).Chestplate,
                           "left_arm",
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).LeftPlate,
                           "right_arm",
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).RightPlate,
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
         list.add(Component.literal("§9Spectral chestplate capable of absorbing the shadow of death, providing an absorption effect every 10 seconds "));
         list.add(Component.literal("Set bonuses: Strong attacks steal health from enemies, plus complete immunity to taking damage from weak attacks"));
         list.add(Component.literal("§7Created by smithing a netherite chestplate with a spectral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/spectralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpectralChestplateTickProcedure.execute(entity, itemstack);
         }
      }
   }

   public static class Helmet extends SpectralItem {
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
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).Helmet,
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
         list.add(Component.literal("§9Spectral helmet capable of absorbing the shadow of death, providing immunity to blindness and nausea "));
         list.add(Component.literal("Set bonuses: Strong attacks steal health from enemies, plus complete immunity to taking damage from weak attacks"));
         list.add(Component.literal("§7Created by smithing a netherite helmet with a spectral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/spectralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpectralHelmetTickProcedure.execute(entity, itemstack);
         }
      }
   }

   public static class Leggings extends SpectralItem {
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
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).LeftLegging,
                           "right_leg",
                           (new Modelspectral(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspectral.LAYER_LOCATION))).RightLegging,
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
               "§9Spectral leggings capable of absorbing the shadow of death, providing a powerful sneak-triggered rechargeable ability to give all nearby entities strong slowness while gaining night vision and a burst of invisibility "
            )
         );
         list.add(Component.literal("Set bonuses: Strong attacks steal health from enemies, plus complete immunity to taking damage from weak attacks"));
         list.add(Component.literal("§7Created by smithing netherite leggings with a spectral ingot"));
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         if (entity instanceof LivingEntity living && living.hasEffect(MobEffects.INVISIBILITY)) {
            return "arphex:textures/entities/blank.png";
         }

         return "arphex:textures/entities/spectralarmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpectralLeggingsTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }
}
