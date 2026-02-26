package net.arphex.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModParticleTypes {
   public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "arphex");
   public static final RegistryObject<SimpleParticleType> HEAVY_SMOKE = REGISTRY.register("heavy_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> THIN_WEB = REGISTRY.register("thin_web", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> CHARCOAL = REGISTRY.register("charcoal", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> CHARRED_BLOOD = REGISTRY.register("charred_blood", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> TINY_SPIDER = REGISTRY.register("tiny_spider", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SOLID_SMOKE = REGISTRY.register("solid_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> ABYSSAL_CRYSTAL_PARTICLE = REGISTRY.register(
      "abyssal_crystal_particle", () -> new SimpleParticleType(true)
   );
   public static final RegistryObject<SimpleParticleType> HEAVY_RED_SMOKE = REGISTRY.register("heavy_red_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> ROPE_WEB = REGISTRY.register("rope_web", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> TINY_MOTH = REGISTRY.register("tiny_moth", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GHOST_TELEPORT = REGISTRY.register("ghost_teleport", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SPIDER_BLOOD = REGISTRY.register("spider_blood", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> FIRE_OPAL_SHARDS = REGISTRY.register("fire_opal_shards", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> ABYSS_DESTRUCTION = REGISTRY.register("abyss_destruction", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> INFERNAL_SHARD_PARTICLE = REGISTRY.register(
      "infernal_shard_particle", () -> new SimpleParticleType(true)
   );
   public static final RegistryObject<SimpleParticleType> LOCUST_SWARM = REGISTRY.register("locust_swarm", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GEODE_POWER = REGISTRY.register("geode_power", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> HEAVY_PURPLE_SMOKE = REGISTRY.register("heavy_purple_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> PURPLE_GLINTS = REGISTRY.register("purple_glints", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GOLDEN_OPAL = REGISTRY.register("golden_opal", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> HEAVY_WHITE_SMOKES = REGISTRY.register("heavy_white_smokes", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> WHITE_PARTICLES = REGISTRY.register("white_particles", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> SCORCH_FLAME = REGISTRY.register("scorch_flame", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> WHITECOAL = REGISTRY.register("whitecoal", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> ETERNAL_FLAME = REGISTRY.register("eternal_flame", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> TORMENTOR_SMOKE = REGISTRY.register("tormentor_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> HUGE_FIRE = REGISTRY.register("huge_fire", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> DEATH_SMOKE = REGISTRY.register("death_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SOLID_CORE = REGISTRY.register("solid_core", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> WHITE_GLOW_SMOKE = REGISTRY.register("white_glow_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GLOW_SENSE = REGISTRY.register("glow_sense", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GLOW_SENSE_NEUTRAL = REGISTRY.register("glow_sense_neutral", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GLOW_SENSE_PLAYER = REGISTRY.register("glow_sense_player", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GLOW_SENSE_ITEM = REGISTRY.register("glow_sense_item", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GLOW_SENSE_TAMED = REGISTRY.register("glow_sense_tamed", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> LONG_HEAVY_PURPLE_SMOKE = REGISTRY.register(
      "long_heavy_purple_smoke", () -> new SimpleParticleType(true)
   );
   public static final RegistryObject<SimpleParticleType> WHITE_PARTICLE_SHORT = REGISTRY.register("white_particle_short", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> TORMENT_SPIRALLING = REGISTRY.register("torment_spiralling", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> TORMENT_SPIRALLING_SMALL = REGISTRY.register(
      "torment_spiralling_small", () -> new SimpleParticleType(true)
   );
   public static final RegistryObject<SimpleParticleType> SOLID_RED_SMOKE = REGISTRY.register("solid_red_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> TIME_SPLASH_PARTICLE = REGISTRY.register("time_splash_particle", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SMALL_TIME = REGISTRY.register("small_time", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> BLOOD_RAIN = REGISTRY.register("blood_rain", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SPIDER_BLOOD_RAIN = REGISTRY.register("spider_blood_rain", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SOLID_CORE_MEDIUM = REGISTRY.register("solid_core_medium", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SOLID_CORE_SMALL = REGISTRY.register("solid_core_small", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SMALL_WHITE_GLOW_SMOKE = REGISTRY.register(
      "small_white_glow_smoke", () -> new SimpleParticleType(true)
   );
   public static final RegistryObject<SimpleParticleType> RED_GLOW_SMOKE = REGISTRY.register("red_glow_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> HEAVY_GREEN_SMOKE = REGISTRY.register("heavy_green_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> HEAVY_GOLD_SMOKE = REGISTRY.register("heavy_gold_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> SOLID_CORE_2 = REGISTRY.register("solid_core_2", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> ENTROPY_SPLASH_PARTICLE = REGISTRY.register(
      "entropy_splash_particle", () -> new SimpleParticleType(true)
   );
   public static final RegistryObject<SimpleParticleType> ENTROPY_GLOW = REGISTRY.register("entropy_glow", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> DEATH_SPLASH = REGISTRY.register("death_splash", () -> new SimpleParticleType(false));
   public static final RegistryObject<SimpleParticleType> TINY_TIME = REGISTRY.register("tiny_time", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> TIME_AURA_PARTICLE = REGISTRY.register("time_aura_particle", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> ENTROPY_SHIELD = REGISTRY.register("entropy_shield", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> HEAVY_BLUE_SMOKE = REGISTRY.register("heavy_blue_smoke", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> GALAXY_CORE = REGISTRY.register("galaxy_core", () -> new SimpleParticleType(true));
   public static final RegistryObject<SimpleParticleType> ENTROPY_SPEAR = REGISTRY.register("entropy_spear", () -> new SimpleParticleType(true));
}
