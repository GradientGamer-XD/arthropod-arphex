package net.arphex.procedures;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.arphex.init.ArphexModItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class TrophyCommandProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
      ItemStack custom_itemstack = ItemStack.EMPTY;
      custom_itemstack = new ItemStack((ItemLike)ArphexModItems.TROPHY_ITEM.get());
      custom_itemstack.getOrCreateTag().putString("trophy_entity", StringArgumentType.getString(arguments, "mob_id").replace("arphex:", "").strip());
      custom_itemstack.getOrCreateTag().putDouble("trophy_entity_size", 0.3);
      custom_itemstack.setHoverName(Component.literal("Mob Trophy"));

      try {
         for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
            if (world instanceof ServerLevel _level) {
               ItemEntity entityToSpawn = new ItemEntity(_level, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), custom_itemstack);
               entityToSpawn.setPickUpDelay(0);
               _level.addFreshEntity(entityToSpawn);
            }
         }
      } catch (CommandSyntaxException var7) {
         var7.printStackTrace();
      }
   }
}
