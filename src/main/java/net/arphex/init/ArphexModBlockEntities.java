package net.arphex.init;

import net.arphex.block.entity.ArphexJigsawBlockEntity;
import net.arphex.block.entity.AscendedCubeBlockEntity;
import net.arphex.block.entity.BlockOfTimePrismBlockEntity;
import net.arphex.block.entity.FunnelWebBlockEntity;
import net.arphex.block.entity.MobTrophyBlockEntity;
import net.arphex.block.entity.TesseractTransporterBlockEntity;
import net.arphex.block.entity.TrophyBlockEntity;
import net.arphex.block.entity.WarpManifoldBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModBlockEntities {
   public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "arphex");
   public static final RegistryObject<BlockEntityType<?>> ARPHEX_JIGSAW = register("arphex_jigsaw", ArphexModBlocks.ARPHEX_JIGSAW, ArphexJigsawBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> ASCENDED_CUBE = register("ascended_cube", ArphexModBlocks.ASCENDED_CUBE, AscendedCubeBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> WARP_MANIFOLD = register("warp_manifold", ArphexModBlocks.WARP_MANIFOLD, WarpManifoldBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> TESSERACT_TRANSPORTER = register(
      "tesseract_transporter", ArphexModBlocks.TESSERACT_TRANSPORTER, TesseractTransporterBlockEntity::new
   );
   public static final RegistryObject<BlockEntityType<?>> BLOCK_OF_TIME_PRISM = register(
      "block_of_time_prism", ArphexModBlocks.BLOCK_OF_TIME_PRISM, BlockOfTimePrismBlockEntity::new
   );
   public static final RegistryObject<BlockEntityType<?>> FUNNEL_WEB = register("funnel_web", ArphexModBlocks.FUNNEL_WEB, FunnelWebBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> TROPHY = register("trophy", ArphexModBlocks.TROPHY, TrophyBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> MOB_TROPHY = register("mob_trophy", ArphexModBlocks.MOB_TROPHY, MobTrophyBlockEntity::new);

   private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntitySupplier<?> supplier) {
      return REGISTRY.register(registryname, () -> Builder.of(supplier, new Block[]{(Block)block.get()}).build(null));
   }
}
