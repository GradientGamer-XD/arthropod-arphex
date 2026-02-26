package net.arphex.init;

import net.arphex.potion.AbFlightMobEffect;
import net.arphex.potion.AbyssalDetectorMobEffect;
import net.arphex.potion.BlockingEffectMobEffect;
import net.arphex.potion.BreathlessMobEffect;
import net.arphex.potion.ChaoLockMobEffect;
import net.arphex.potion.ChaosControlledMobEffect;
import net.arphex.potion.ChaosTargetMobEffect;
import net.arphex.potion.ConstrictedMobEffect;
import net.arphex.potion.CrawlingMobEffect;
import net.arphex.potion.DebugEffectMobEffect;
import net.arphex.potion.DespawnImmunityMobEffect;
import net.arphex.potion.DisplayTormentorInitialMobEffect;
import net.arphex.potion.EnhancedSensesMobEffect;
import net.arphex.potion.EternalEvasionMobEffect;
import net.arphex.potion.EternalSustenanceMobEffect;
import net.arphex.potion.EtherealChargeMobEffect;
import net.arphex.potion.FatigueShowMobEffect;
import net.arphex.potion.ForceLiftMobEffect;
import net.arphex.potion.ForcePowerMobEffect;
import net.arphex.potion.HealthAnalysisMobEffect;
import net.arphex.potion.InvincibilityTempMobEffect;
import net.arphex.potion.MothCurseMobEffect;
import net.arphex.potion.NecrosisMobEffect;
import net.arphex.potion.ParalysisMobEffect;
import net.arphex.potion.RepulsionMobEffect;
import net.arphex.potion.SpiderSilkTouchMobEffect;
import net.arphex.potion.SplinteredSanityMobEffect;
import net.arphex.potion.SupergravityMobEffect;
import net.arphex.potion.ThunderSenseMobEffect;
import net.arphex.potion.TimeFreezeMobEffect;
import net.arphex.potion.TormentMobEffect;
import net.arphex.potion.TormentSpiralMobEffect;
import net.arphex.potion.TormentedMobEffect;
import net.arphex.potion.TormentorPrimaryTargetMobEffect;
import net.arphex.potion.VoidCooldownMobEffect;
import net.arphex.potion.VoidProtectionMobEffect;
import net.arphex.potion.VoidRepulsionMobEffect;
import net.arphex.potion.VoidlasherChaosControlMobEffect;
import net.arphex.potion.VortexCooldownMobEffect;
import net.arphex.potion.WebbedMobEffect;
import net.arphex.potion.ZoomMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArphexModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "arphex");
   public static final RegistryObject<MobEffect> MOTH_CURSE = REGISTRY.register("moth_curse", () -> new MothCurseMobEffect());
   public static final RegistryObject<MobEffect> SPIDER_SILK_TOUCH = REGISTRY.register("spider_silk_touch", () -> new SpiderSilkTouchMobEffect());
   public static final RegistryObject<MobEffect> WEBBED = REGISTRY.register("webbed", () -> new WebbedMobEffect());
   public static final RegistryObject<MobEffect> ABYSSAL_DETECTOR = REGISTRY.register("abyssal_detector", () -> new AbyssalDetectorMobEffect());
   public static final RegistryObject<MobEffect> NECROSIS = REGISTRY.register("necrosis", () -> new NecrosisMobEffect());
   public static final RegistryObject<MobEffect> THUNDER_SENSE = REGISTRY.register("thunder_sense", () -> new ThunderSenseMobEffect());
   public static final RegistryObject<MobEffect> REPULSION = REGISTRY.register("repulsion", () -> new RepulsionMobEffect());
   public static final RegistryObject<MobEffect> ZOOM = REGISTRY.register("zoom", () -> new ZoomMobEffect());
   public static final RegistryObject<MobEffect> FORCE_POWER = REGISTRY.register("force_power", () -> new ForcePowerMobEffect());
   public static final RegistryObject<MobEffect> FORCE_LIFT = REGISTRY.register("force_lift", () -> new ForceLiftMobEffect());
   public static final RegistryObject<MobEffect> BLOCKING_EFFECT = REGISTRY.register("blocking_effect", () -> new BlockingEffectMobEffect());
   public static final RegistryObject<MobEffect> CHAOS_TARGET = REGISTRY.register("chaos_target", () -> new ChaosTargetMobEffect());
   public static final RegistryObject<MobEffect> CHAOS_CONTROLLED = REGISTRY.register("chaos_controlled", () -> new ChaosControlledMobEffect());
   public static final RegistryObject<MobEffect> VOID_PROTECTION = REGISTRY.register("void_protection", () -> new VoidProtectionMobEffect());
   public static final RegistryObject<MobEffect> VOID_COOLDOWN = REGISTRY.register("void_cooldown", () -> new VoidCooldownMobEffect());
   public static final RegistryObject<MobEffect> ETHEREAL_CHARGE = REGISTRY.register("ethereal_charge", () -> new EtherealChargeMobEffect());
   public static final RegistryObject<MobEffect> INVINCIBILITY_TEMP = REGISTRY.register("invincibility_temp", () -> new InvincibilityTempMobEffect());
   public static final RegistryObject<MobEffect> VOID_REPULSION = REGISTRY.register("void_repulsion", () -> new VoidRepulsionMobEffect());
   public static final RegistryObject<MobEffect> HEALTH_ANALYSIS = REGISTRY.register("health_analysis", () -> new HealthAnalysisMobEffect());
   public static final RegistryObject<MobEffect> VOIDLASHER_CHAOS_CONTROL = REGISTRY.register(
      "voidlasher_chaos_control", () -> new VoidlasherChaosControlMobEffect()
   );
   public static final RegistryObject<MobEffect> CONSTRICTED = REGISTRY.register("constricted", () -> new ConstrictedMobEffect());
   public static final RegistryObject<MobEffect> VORTEX_COOLDOWN = REGISTRY.register("vortex_cooldown", () -> new VortexCooldownMobEffect());
   public static final RegistryObject<MobEffect> ETERNAL_EVASION = REGISTRY.register("eternal_evasion", () -> new EternalEvasionMobEffect());
   public static final RegistryObject<MobEffect> AB_FLIGHT = REGISTRY.register("ab_flight", () -> new AbFlightMobEffect());
   public static final RegistryObject<MobEffect> CHAO_LOCK = REGISTRY.register("chao_lock", () -> new ChaoLockMobEffect());
   public static final RegistryObject<MobEffect> CRAWLING = REGISTRY.register("crawling", () -> new CrawlingMobEffect());
   public static final RegistryObject<MobEffect> FATIGUE_SHOW = REGISTRY.register("fatigue_show", () -> new FatigueShowMobEffect());
   public static final RegistryObject<MobEffect> DEBUG_EFFECT = REGISTRY.register("debug_effect", () -> new DebugEffectMobEffect());
   public static final RegistryObject<MobEffect> TORMENT = REGISTRY.register("torment", () -> new TormentMobEffect());
   public static final RegistryObject<MobEffect> TORMENTOR_PRIMARY_TARGET = REGISTRY.register(
      "tormentor_primary_target", () -> new TormentorPrimaryTargetMobEffect()
   );
   public static final RegistryObject<MobEffect> TORMENT_SPIRAL = REGISTRY.register("torment_spiral", () -> new TormentSpiralMobEffect());
   public static final RegistryObject<MobEffect> DISPLAY_TORMENTOR_INITIAL = REGISTRY.register(
      "display_tormentor_initial", () -> new DisplayTormentorInitialMobEffect()
   );
   public static final RegistryObject<MobEffect> BREATHLESS = REGISTRY.register("breathless", () -> new BreathlessMobEffect());
   public static final RegistryObject<MobEffect> DESPAWN_IMMUNITY = REGISTRY.register("despawn_immunity", () -> new DespawnImmunityMobEffect());
   public static final RegistryObject<MobEffect> TIME_FREEZE = REGISTRY.register("time_freeze", () -> new TimeFreezeMobEffect());
   public static final RegistryObject<MobEffect> ENHANCED_SENSES = REGISTRY.register("enhanced_senses", () -> new EnhancedSensesMobEffect());
   public static final RegistryObject<MobEffect> SPLINTERED_SANITY = REGISTRY.register("splintered_sanity", () -> new SplinteredSanityMobEffect());
   public static final RegistryObject<MobEffect> ETERNAL_SUSTENANCE = REGISTRY.register("eternal_sustenance", () -> new EternalSustenanceMobEffect());
   public static final RegistryObject<MobEffect> TORMENTED = REGISTRY.register("tormented", () -> new TormentedMobEffect());
   public static final RegistryObject<MobEffect> PARALYSIS = REGISTRY.register("paralysis", () -> new ParalysisMobEffect());
   public static final RegistryObject<MobEffect> SUPERGRAVITY = REGISTRY.register("supergravity", () -> new SupergravityMobEffect());
}
