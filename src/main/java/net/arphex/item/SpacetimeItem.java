package net.arphex.item;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.arphex.client.model.Modelspacetime;
import net.arphex.procedures.SpacetimeBootsTickEventProcedure;
import net.arphex.procedures.SpacetimeChestplateTickProcedure;
import net.arphex.procedures.SpacetimeHelmetTickEventProcedure;
import net.arphex.procedures.SpacetimeLeggingsTickEventProcedure;
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

public abstract class SpacetimeItem extends ArmorItem {
   public SpacetimeItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 1024;
         }

         public int getDefenseForType(Type type) {
            return new int[]{5, 10, 14, 6}[type.getSlot().getIndex()];
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
            return "spacetime";
         }

         public float getToughness() {
            return 6.0F;
         }

         public float getKnockbackResistance() {
            return 1.0F;
         }
      }, type, properties);
   }

   public static class Boots extends SpacetimeItem {
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
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).LeftBoot,
                           "right_leg",
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).RightBoot,
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
               "§2Boots manufactured in the midst of dimensional collapse, providing fall immunity, full block step height when sprinting, and antigravity flight abilities (hold space to ascend, and sprint while airborne to rapidly accelerate your movement - let go when changing directions)"
            )
         );
         list.add(
            Component.literal(
               "Set bonus: Cosmic Perception - You can see the 100 nearest mobs in the world, indicated by orbs (red=monster, green=pet, blue=player, white=other), plus complete immunity to weak attacks"
            )
         );
         list.add(Component.literal("§7Enchantable "));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/spacetimearmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpacetimeBootsTickEventProcedure.execute(world, entity, itemstack);
         }
      }
   }

   public static class Chestplate extends SpacetimeItem {
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
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).Chestplate,
                           "left_arm",
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).LeftPlate,
                           "right_arm",
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).RightPlate,
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
               "§2Chestplate manufactured in the midst of dimensional collapse, providing a 5 second forcefield ability activated by double pressing the crouch key, plus passive regeneration"
            )
         );
         list.add(
            Component.literal(
               "Set bonus: Cosmic Perception - You can see the 100 nearest mobs in the world, indicated by orbs (red=monster, green=pet, blue=player, white=other), plus complete immunity to weak attacks"
            )
         );
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/spacetimearmor.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpacetimeChestplateTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }

   public static class Helmet extends SpacetimeItem {
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
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).Helmet,
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
         list.add(Component.literal("§2Helmet manufactured in the midst of dimensional collapse, providing an ability to see the health of any nearby mobs"));
         list.add(
            Component.literal(
               "Set bonus: Cosmic Perception - You can see the 100 nearest mobs in the world, indicated by orbs (red=monster, green=pet, blue=player, white=other), plus complete immunity to weak attacks"
            )
         );
         list.add(Component.literal("§7Enchantable"));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/spacetimearmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpacetimeHelmetTickEventProcedure.execute(entity, itemstack);
         }
      }
   }

   public static class Leggings extends SpacetimeItem {
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
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).LeftLegging,
                           "right_leg",
                           (new Modelspacetime(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspacetime.LAYER_LOCATION))).RightLegging,
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
               "§2Leggings manufactured in the midst of dimensional collapse - reverses time if you drop to two hearts or below, restoring your health back to the highest it has been within the last five seconds (30 second cooldown)."
            )
         );
         list.add(
            Component.literal(
               "Set bonus: Cosmic Perception - You can see the 100 nearest mobs in the world, indicated by orbs (red=monster, green=pet, blue=player, white=other), plus complete immunity to weak attacks"
            )
         );
         list.add(Component.literal("§7Enchantable "));
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "arphex:textures/entities/spacetimearmor.png";
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
            SpacetimeLeggingsTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
         }
      }
   }
}
