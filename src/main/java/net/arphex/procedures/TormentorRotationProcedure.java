package net.arphex.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.arphex.network.ArphexModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.level.LevelAccessor;

public class TormentorRotationProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
      ArphexModVariables.MapVariables.get(world).tormentor_rotation = DoubleArgumentType.getDouble(arguments, "tormentor_rotation");
      ArphexModVariables.MapVariables.get(world).syncData(world);
   }
}
