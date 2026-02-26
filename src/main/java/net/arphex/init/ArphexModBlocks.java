package net.arphex.init;

import net.arphex.block.AntNestBlock;
import net.arphex.block.AntShieldTemporaryBlock;
import net.arphex.block.ArphexJigsawBlock;
import net.arphex.block.AscendedCubeBlock;
import net.arphex.block.BaneBlossomBlock;
import net.arphex.block.BarrierGapBlock;
import net.arphex.block.BlockOfAbyssalCrystalBlock;
import net.arphex.block.BlockOfEntropyMatrixBlock;
import net.arphex.block.BlockOfFireOpalBlock;
import net.arphex.block.BlockOfTimePrismBlock;
import net.arphex.block.BlockOfVoidGeodeBlock;
import net.arphex.block.ChitinBlockBlock;
import net.arphex.block.CobwebPassableBlock;
import net.arphex.block.CrawlingAltarBlock;
import net.arphex.block.CrawlingBarrierBlock;
import net.arphex.block.CrawlingClayBlock;
import net.arphex.block.CrawlingCompostBlock;
import net.arphex.block.CrawlingPortalBlock;
import net.arphex.block.DecadentDustBlock;
import net.arphex.block.ExquisiteOreBlock;
import net.arphex.block.FunnelWebBlock;
import net.arphex.block.HeavyChitinBlockBlock;
import net.arphex.block.InvisibleDetectorBlockBlock;
import net.arphex.block.InvisibleHalfSlabBlock;
import net.arphex.block.MangledFlyFleshBlock;
import net.arphex.block.MangledScorpionFleshBlock;
import net.arphex.block.MangledSpiderFleshBlock;
import net.arphex.block.MobTrophyBlock;
import net.arphex.block.RandomLootChoicesBlock;
import net.arphex.block.ReaperWebBlock;
import net.arphex.block.ScorchBlock;
import net.arphex.block.ScorchPillarBlock;
import net.arphex.block.ScorchTorchGroundBlock;
import net.arphex.block.ScorchTorchWallBlock;
import net.arphex.block.ScorchedGlassBlock;
import net.arphex.block.ScorchedSandBlock;
import net.arphex.block.SilkenSoilBlock;
import net.arphex.block.SilkenStoneBlock;
import net.arphex.block.SpiderCocoonBlock;
import net.arphex.block.SpiderCocoonCreeperBlock;
import net.arphex.block.SpiderCocoonPlayerBlock;
import net.arphex.block.SpiderCocoonSkeletonBlock;
import net.arphex.block.SpiderCocoonVillagerBlock;
import net.arphex.block.SpiderEggBlock;
import net.arphex.block.StructureFillBlockBlock;
import net.arphex.block.TermiteMoundBlock;
import net.arphex.block.TesseractTransporterBlock;
import net.arphex.block.TrapdoorDirtBlock;
import net.arphex.block.TrapdoorGrassBlock;
import net.arphex.block.TrophyBlock;
import net.arphex.block.WarpManifoldBlock;
import net.arphex.block.WebLineBlock;
import net.arphex.block.WebWallBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModBlocks {
   public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "arphex");
   public static final RegistryObject<Block> MANGLED_SPIDER_FLESH = REGISTRY.register("mangled_spider_flesh", () -> new MangledSpiderFleshBlock());
   public static final RegistryObject<Block> BLOCK_OF_FIRE_OPAL = REGISTRY.register("block_of_fire_opal", () -> new BlockOfFireOpalBlock());
   public static final RegistryObject<Block> MANGLED_SCORPION_FLESH = REGISTRY.register("mangled_scorpion_flesh", () -> new MangledScorpionFleshBlock());
   public static final RegistryObject<Block> BLOCK_OF_ABYSSAL_CRYSTAL = REGISTRY.register("block_of_abyssal_crystal", () -> new BlockOfAbyssalCrystalBlock());
   public static final RegistryObject<Block> BLOCK_OF_VOID_GEODE = REGISTRY.register("block_of_void_geode", () -> new BlockOfVoidGeodeBlock());
   public static final RegistryObject<Block> MANGLED_FLY_FLESH = REGISTRY.register("mangled_fly_flesh", () -> new MangledFlyFleshBlock());
   public static final RegistryObject<Block> SCORCH = REGISTRY.register("scorch", () -> new ScorchBlock());
   public static final RegistryObject<Block> CRAWLING_BARRIER = REGISTRY.register("crawling_barrier", () -> new CrawlingBarrierBlock());
   public static final RegistryObject<Block> ANT_NEST = REGISTRY.register("ant_nest", () -> new AntNestBlock());
   public static final RegistryObject<Block> ARPHEX_JIGSAW = REGISTRY.register("arphex_jigsaw", () -> new ArphexJigsawBlock());
   public static final RegistryObject<Block> ANT_SHIELD_TEMPORARY = REGISTRY.register("ant_shield_temporary", () -> new AntShieldTemporaryBlock());
   public static final RegistryObject<Block> TERMITE_MOUND = REGISTRY.register("termite_mound", () -> new TermiteMoundBlock());
   public static final RegistryObject<Block> CRAWLING_CLAY = REGISTRY.register("crawling_clay", () -> new CrawlingClayBlock());
   public static final RegistryObject<Block> DECADENT_DUST = REGISTRY.register("decadent_dust", () -> new DecadentDustBlock());
   public static final RegistryObject<Block> EXQUISITE_ORE = REGISTRY.register("exquisite_ore", () -> new ExquisiteOreBlock());
   public static final RegistryObject<Block> RANDOM_LOOT_CHOICES = REGISTRY.register("random_loot_choices", () -> new RandomLootChoicesBlock());
   public static final RegistryObject<Block> INVISIBLE_DETECTOR_BLOCK = REGISTRY.register("invisible_detector_block", () -> new InvisibleDetectorBlockBlock());
   public static final RegistryObject<Block> CRAWLING_PORTAL = REGISTRY.register("crawling_portal", () -> new CrawlingPortalBlock());
   public static final RegistryObject<Block> ASCENDED_CUBE = REGISTRY.register("ascended_cube", () -> new AscendedCubeBlock());
   public static final RegistryObject<Block> CRAWLING_COMPOST = REGISTRY.register("crawling_compost", () -> new CrawlingCompostBlock());
   public static final RegistryObject<Block> BANE_BLOSSOM = REGISTRY.register("bane_blossom", () -> new BaneBlossomBlock());
   public static final RegistryObject<Block> WARP_MANIFOLD = REGISTRY.register("warp_manifold", () -> new WarpManifoldBlock());
   public static final RegistryObject<Block> SCORCH_TORCH_WALL = REGISTRY.register("scorch_torch_wall", () -> new ScorchTorchWallBlock());
   public static final RegistryObject<Block> SCORCH_TORCH_GROUND = REGISTRY.register("scorch_torch_ground", () -> new ScorchTorchGroundBlock());
   public static final RegistryObject<Block> CHITIN_BLOCK = REGISTRY.register("chitin_block", () -> new ChitinBlockBlock());
   public static final RegistryObject<Block> TESSERACT_TRANSPORTER = REGISTRY.register("tesseract_transporter", () -> new TesseractTransporterBlock());
   public static final RegistryObject<Block> SCORCHED_GLASS = REGISTRY.register("scorched_glass", () -> new ScorchedGlassBlock());
   public static final RegistryObject<Block> SCORCHED_SAND = REGISTRY.register("scorched_sand", () -> new ScorchedSandBlock());
   public static final RegistryObject<Block> HEAVY_CHITIN_BLOCK = REGISTRY.register("heavy_chitin_block", () -> new HeavyChitinBlockBlock());
   public static final RegistryObject<Block> BLOCK_OF_TIME_PRISM = REGISTRY.register("block_of_time_prism", () -> new BlockOfTimePrismBlock());
   public static final RegistryObject<Block> BLOCK_OF_ENTROPY_MATRIX = REGISTRY.register("block_of_entropy_matrix", () -> new BlockOfEntropyMatrixBlock());
   public static final RegistryObject<Block> REAPER_WEB = REGISTRY.register("reaper_web", () -> new ReaperWebBlock());
   public static final RegistryObject<Block> FUNNEL_WEB = REGISTRY.register("funnel_web", () -> new FunnelWebBlock());
   public static final RegistryObject<Block> TRAPDOOR_GRASS = REGISTRY.register("trapdoor_grass", () -> new TrapdoorGrassBlock());
   public static final RegistryObject<Block> TRAPDOOR_DIRT = REGISTRY.register("trapdoor_dirt", () -> new TrapdoorDirtBlock());
   public static final RegistryObject<Block> BARRIER_GAP = REGISTRY.register("barrier_gap", () -> new BarrierGapBlock());
   public static final RegistryObject<Block> SCORCH_PILLAR = REGISTRY.register("scorch_pillar", () -> new ScorchPillarBlock());
   public static final RegistryObject<Block> CRAWLING_ALTAR = REGISTRY.register("crawling_altar", () -> new CrawlingAltarBlock());
   public static final RegistryObject<Block> INVISIBLE_HALF_SLAB = REGISTRY.register("invisible_half_slab", () -> new InvisibleHalfSlabBlock());
   public static final RegistryObject<Block> STRUCTURE_FILL_BLOCK = REGISTRY.register("structure_fill_block", () -> new StructureFillBlockBlock());
   public static final RegistryObject<Block> SILKEN_SOIL = REGISTRY.register("silken_soil", () -> new SilkenSoilBlock());
   public static final RegistryObject<Block> SILKEN_STONE = REGISTRY.register("silken_stone", () -> new SilkenStoneBlock());
   public static final RegistryObject<Block> SPIDER_EGG = REGISTRY.register("spider_egg", () -> new SpiderEggBlock());
   public static final RegistryObject<Block> SPIDER_COCOON = REGISTRY.register("spider_cocoon", () -> new SpiderCocoonBlock());
   public static final RegistryObject<Block> SPIDER_COCOON_CREEPER = REGISTRY.register("spider_cocoon_creeper", () -> new SpiderCocoonCreeperBlock());
   public static final RegistryObject<Block> SPIDER_COCOON_SKELETON = REGISTRY.register("spider_cocoon_skeleton", () -> new SpiderCocoonSkeletonBlock());
   public static final RegistryObject<Block> SPIDER_COCOON_VILLAGER = REGISTRY.register("spider_cocoon_villager", () -> new SpiderCocoonVillagerBlock());
   public static final RegistryObject<Block> WEB_WALL = REGISTRY.register("web_wall", () -> new WebWallBlock());
   public static final RegistryObject<Block> WEB_LINE = REGISTRY.register("web_line", () -> new WebLineBlock());
   public static final RegistryObject<Block> SPIDER_COCOON_PLAYER = REGISTRY.register("spider_cocoon_player", () -> new SpiderCocoonPlayerBlock());
   public static final RegistryObject<Block> COBWEB_PASSABLE = REGISTRY.register("cobweb_passable", () -> new CobwebPassableBlock());
   public static final RegistryObject<Block> TROPHY = REGISTRY.register("trophy", () -> new TrophyBlock());
   public static final RegistryObject<Block> MOB_TROPHY = REGISTRY.register("mob_trophy", () -> new MobTrophyBlock());

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class ClientSideHandler {
      @SubscribeEvent
      public static void blockColorLoad(net.minecraftforge.client.event.RegisterColorHandlersEvent.Block event) {
         BaneBlossomBlock.blockColorLoad(event);
      }

      @SubscribeEvent
      public static void itemColorLoad(Item event) {
         BaneBlossomBlock.itemColorLoad(event);
      }
   }
}
