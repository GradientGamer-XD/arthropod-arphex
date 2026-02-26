package net.arphex.world.features.treedecorators;

import com.mojang.serialization.Codec;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator.Context;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.ForgeRegistries.Keys;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class WebbedWastelandFruitDecorator extends CocoaDecorator {
   public static Codec<WebbedWastelandFruitDecorator> CODEC = Codec.unit(WebbedWastelandFruitDecorator::new);
   public static TreeDecoratorType<?> DECORATOR_TYPE = new TreeDecoratorType(CODEC);

   @SubscribeEvent
   public static void registerTreeDecorator(RegisterEvent event) {
      event.register(Keys.TREE_DECORATOR_TYPES, registerHelper -> registerHelper.register("webbed_wasteland_tree_fruit_decorator", DECORATOR_TYPE));
   }

   public WebbedWastelandFruitDecorator() {
      super(0.2F);
   }

   protected TreeDecoratorType<?> type() {
      return DECORATOR_TYPE;
   }

   public void place(Context context) {
      RandomSource randomsource = context.random();
      if (!(randomsource.nextFloat() >= 0.2F)) {
         List<BlockPos> list = context.logs();
         int i = list.get(0).getY();
         list.stream().filter(p_69980_ -> p_69980_.getY() - i <= 2).forEach(p_226026_ -> {
            for (Direction direction : Plane.HORIZONTAL) {
               if (randomsource.nextFloat() <= 0.25F) {
                  Direction direction1 = direction.getOpposite();
                  BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                  if (context.isAir(blockpos)) {
                     context.setBlock(blockpos, oriented(Blocks.COBWEB.defaultBlockState(), direction1));
                  }
               }
            }
         });
      }
   }

   private static BlockState oriented(BlockState blockstate, Direction direction) {
      return switch (direction) {
         case SOUTH -> blockstate.getBlock().rotate(blockstate, Rotation.CLOCKWISE_180);
         case EAST -> blockstate.getBlock().rotate(blockstate, Rotation.CLOCKWISE_90);
         case WEST -> blockstate.getBlock().rotate(blockstate, Rotation.COUNTERCLOCKWISE_90);
         default -> blockstate;
      };
   }
}
