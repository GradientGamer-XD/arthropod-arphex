package net.arphex.init;

import net.arphex.entity.AbyssExplosiveEntity;
import net.arphex.entity.AiControllerEntity;
import net.arphex.entity.AiToRideEntity;
import net.arphex.entity.AntArsonistAlateQueenEntity;
import net.arphex.entity.AntArsonistDroneEntity;
import net.arphex.entity.AntArsonistEntity;
import net.arphex.entity.AntArsonistSoldierEntity;
import net.arphex.entity.AntArsonistWorkerEntity;
import net.arphex.entity.AnyDimensionSpawnerEntity;
import net.arphex.entity.AoEflame2Entity;
import net.arphex.entity.AoEflameEntity;
import net.arphex.entity.ArachnoidShadowCloneEntity;
import net.arphex.entity.ArachnoidTimeCloneEntity;
import net.arphex.entity.ArachnoidTrisectorEntity;
import net.arphex.entity.ArthropleuraAbominationEntity;
import net.arphex.entity.AscendSphereAnimEntity;
import net.arphex.entity.AscendantArrowEntity;
import net.arphex.entity.BeetleBulwarkEntity;
import net.arphex.entity.BeetleTickMiteEntity;
import net.arphex.entity.BlockTestEntity;
import net.arphex.entity.BloodProjectileEntity;
import net.arphex.entity.BloodWormEntity;
import net.arphex.entity.BloodthirstyTendrilEntity;
import net.arphex.entity.ButterflyBewitcherEntity;
import net.arphex.entity.ButterflyBewitcherGiantEntity;
import net.arphex.entity.CaveWebEntity;
import net.arphex.entity.CentipedeEvictorEntity;
import net.arphex.entity.CentipedeEvictorLarvaeEntity;
import net.arphex.entity.CentipedeStalkerEntity;
import net.arphex.entity.ChronoShotEntity;
import net.arphex.entity.ChronoSpearShotEntity;
import net.arphex.entity.CrabConstrictorEntity;
import net.arphex.entity.CrabLarvaeEntity;
import net.arphex.entity.CrawlingRandomEntity;
import net.arphex.entity.DiabolosDecimatorCloneEntity;
import net.arphex.entity.DiabolosDecimatorEntity;
import net.arphex.entity.DiabolosShadowCloneEntity;
import net.arphex.entity.DisappearInvisibleEntity;
import net.arphex.entity.DraconFireEntity;
import net.arphex.entity.DraconicCloneEntity;
import net.arphex.entity.DraconicFlyStalkEntity;
import net.arphex.entity.DragonflyDreadnoughtEntity;
import net.arphex.entity.DungeonTriggerEntity;
import net.arphex.entity.DwellerSleepSpawnerEntity;
import net.arphex.entity.EnormousSpiderHallucinationEntity;
import net.arphex.entity.EntropyConduitEntity;
import net.arphex.entity.FlyFestererEntity;
import net.arphex.entity.FlytrapEntity;
import net.arphex.entity.GenesisShotEntity;
import net.arphex.entity.GiantEnemySpiderEntity;
import net.arphex.entity.GiantWebEntity;
import net.arphex.entity.GravitonShotEntity;
import net.arphex.entity.HitboxExpanderEntity;
import net.arphex.entity.HomingSparkEntity;
import net.arphex.entity.HomingVoidseekerEntity;
import net.arphex.entity.HornetHarbingerEntity;
import net.arphex.entity.HornetHarbingerGiantEntity;
import net.arphex.entity.HornetProjectileEntity;
import net.arphex.entity.InsaneModeSpawnsEntity;
import net.arphex.entity.InvisibleArrowEntity;
import net.arphex.entity.InvisibleStalkerEntity;
import net.arphex.entity.JudgementBlastEntity;
import net.arphex.entity.LocustLandscourgeEntity;
import net.arphex.entity.LongLegsEntity;
import net.arphex.entity.LongLegsFlyEntity;
import net.arphex.entity.LongLegsTinyEntity;
import net.arphex.entity.MaggotLarvaeEntity;
import net.arphex.entity.MantisMutilatorEntity;
import net.arphex.entity.MillipedeMarauderEntity;
import net.arphex.entity.MiniatureCoreEntity;
import net.arphex.entity.MosquitoMorbidityEntity;
import net.arphex.entity.MothMoontrackerEntity;
import net.arphex.entity.MothShadowCloneEntity;
import net.arphex.entity.NemesisProjectileEntity;
import net.arphex.entity.OpalArrowEntity;
import net.arphex.entity.PowerHookEntity;
import net.arphex.entity.PureStalkingEntity;
import net.arphex.entity.RandomArPhExEntity;
import net.arphex.entity.RandomTermiteEntity;
import net.arphex.entity.RepellantEntity;
import net.arphex.entity.RoachRiverspawnEntity;
import net.arphex.entity.RushScareEntity;
import net.arphex.entity.ScarabSummonEntity;
import net.arphex.entity.ScorpioidBloodlusterEntity;
import net.arphex.entity.ScorpioidChaserHallucinationEntity;
import net.arphex.entity.ScorpioidCloneEntity;
import net.arphex.entity.ScorpioidInitialEntity;
import net.arphex.entity.ScorpioidShadowCloneEntity;
import net.arphex.entity.ScorpionLarvaeEntity;
import net.arphex.entity.ScorpionStrikerEntity;
import net.arphex.entity.SegmentedBodyEntity;
import net.arphex.entity.SilverfishSpectreEntity;
import net.arphex.entity.SkyStalkerEntity;
import net.arphex.entity.SlowLookTestEntity;
import net.arphex.entity.SmallTormentSphereEntity;
import net.arphex.entity.SmallWebEntity;
import net.arphex.entity.SolifugeSkulkerEntity;
import net.arphex.entity.SpacetimeAnchorEntity;
import net.arphex.entity.SphereAnimEntity;
import net.arphex.entity.SpiderAmbusherEntity;
import net.arphex.entity.SpiderBroodEntity;
import net.arphex.entity.SpiderBroodEntityProjectile;
import net.arphex.entity.SpiderChaserHallucination2Entity;
import net.arphex.entity.SpiderChaserHallucination3Entity;
import net.arphex.entity.SpiderChaserHallucinationEntity;
import net.arphex.entity.SpiderFlatEntity;
import net.arphex.entity.SpiderFunnelEntity;
import net.arphex.entity.SpiderGoliathEntity;
import net.arphex.entity.SpiderInfestorEntity;
import net.arphex.entity.SpiderJumpEntity;
import net.arphex.entity.SpiderLarvaeEntity;
import net.arphex.entity.SpiderLarvaeTinyEntity;
import net.arphex.entity.SpiderLungerEntity;
import net.arphex.entity.SpiderLurkerEntity;
import net.arphex.entity.SpiderMatriarchEntity;
import net.arphex.entity.SpiderMatriarchLarvaeEntity;
import net.arphex.entity.SpiderMothDwellerEntity;
import net.arphex.entity.SpiderMothEntity;
import net.arphex.entity.SpiderMothLarvaeEntity;
import net.arphex.entity.SpiderMothSummonEntity;
import net.arphex.entity.SpiderMothSummonLarvaeEntity;
import net.arphex.entity.SpiderObstructerEntity;
import net.arphex.entity.SpiderProwlerEntity;
import net.arphex.entity.SpiderReaperEntity;
import net.arphex.entity.SpiderRecluseDisplayEntity;
import net.arphex.entity.SpiderRecluseEntity;
import net.arphex.entity.SpiderSinkerEntity;
import net.arphex.entity.SpiderSnatcherEntity;
import net.arphex.entity.SpinpartitestEntity;
import net.arphex.entity.StickBugEntity;
import net.arphex.entity.SummonSunBlastEntity;
import net.arphex.entity.TORMENTOREntity;
import net.arphex.entity.TamedTarantulaEntity;
import net.arphex.entity.TeleportGhostEntity;
import net.arphex.entity.TermiteTunnelerAlateEntity;
import net.arphex.entity.TermiteTunnelerKingEntity;
import net.arphex.entity.TermiteTunnelerQueenEntity;
import net.arphex.entity.TermiteTunnelerSoldierEntity;
import net.arphex.entity.TermiteTunnelerWorkerEntity;
import net.arphex.entity.TimeDistortionWaveEntity;
import net.arphex.entity.TinyCentipedeBreacherEntity;
import net.arphex.entity.TormentBlastEntity;
import net.arphex.entity.TormentExplosiveEntity;
import net.arphex.entity.TormentRifleEntity;
import net.arphex.entity.TormentorCaterpillarEntity;
import net.arphex.entity.TormentorFlashAnimEntity;
import net.arphex.entity.TormentorHitboxEntity;
import net.arphex.entity.TormentorInitialEntity;
import net.arphex.entity.TormentorLarvaeEntity;
import net.arphex.entity.TormentorLaserEntity;
import net.arphex.entity.TormentorLowDisplayAnimEntity;
import net.arphex.entity.TormentorLowDisplayEntity;
import net.arphex.entity.TormentorMothSummonEntity;
import net.arphex.entity.TormentorScorpioidSummonEntity;
import net.arphex.entity.TormentorShieldEntity;
import net.arphex.entity.TormentorSphereEntity;
import net.arphex.entity.TormentorSummonEntity;
import net.arphex.entity.TormentorT2Entity;
import net.arphex.entity.TormentorT3Entity;
import net.arphex.entity.TormentorT4Entity;
import net.arphex.entity.TormentorT5Entity;
import net.arphex.entity.TormentorTendrilEntity;
import net.arphex.entity.TormentorTestEntity;
import net.arphex.entity.TormentorVoidlasherSummonEntity;
import net.arphex.entity.VenusFlytrapEntity;
import net.arphex.entity.VoidSpearEntity;
import net.arphex.entity.VoidlasherShadowCloneEntity;
import net.arphex.entity.VortexBlastEntity;
import net.arphex.entity.WarpStaffDirectionEntity;
import net.arphex.entity.WaspNemesisEntity;
import net.arphex.entity.WebFunnelEntity;
import net.arphex.entity.WebHarnessDownEntity;
import net.arphex.entity.WebHarnessEntity;
import net.arphex.entity.WebHookEntity;
import net.arphex.entity.WebRopeEntity;
import net.arphex.entity.WebbedArrowEntity;
import net.arphex.entity.WidowArrowEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class ArphexModEntities {
   public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "arphex");
   public static final RegistryObject<EntityType<SpiderMothDwellerEntity>> DRACONIC_VOIDLASHER = register(
      "draconic_voidlasher",
      Builder.<SpiderMothDwellerEntity>of(SpiderMothDwellerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderMothDwellerEntity::new)
         .fireImmune()
         .sized(1.99F, 1.99F)
   );
   public static final RegistryObject<EntityType<SpiderMothLarvaeEntity>> SPIDER_MOTH_LARVAE = register(
      "spider_moth_larvae",
      Builder.<SpiderMothLarvaeEntity>of(SpiderMothLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(74)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderMothLarvaeEntity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<TeleportGhostEntity>> TELEPORT_GHOST = register(
      "teleport_ghost",
      Builder.<TeleportGhostEntity>of(TeleportGhostEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(TeleportGhostEntity::new)
         .fireImmune()
         .sized(1.5F, 2.0F)
   );
   public static final RegistryObject<EntityType<MothShadowCloneEntity>> MOTH_SHADOW_CLONE = register(
      "moth_shadow_clone",
      Builder.<MothShadowCloneEntity>of(MothShadowCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(100)
         .setUpdateInterval(3)
         .setCustomClientFactory(MothShadowCloneEntity::new)
         .fireImmune()
         .sized(2.0F, 2.0F)
   );
   public static final RegistryObject<EntityType<SpiderLarvaeEntity>> SPIDER_LARVAE = register(
      "spider_larvae",
      Builder.<SpiderLarvaeEntity>of(SpiderLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(6)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderLarvaeEntity::new)
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<SpiderLarvaeTinyEntity>> SPIDER_LARVAE_TINY = register(
      "spider_larvae_tiny",
      Builder.<SpiderLarvaeTinyEntity>of(SpiderLarvaeTinyEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderLarvaeTinyEntity::new)
         .sized(0.7F, 0.7F)
   );
   public static final RegistryObject<EntityType<LongLegsEntity>> LONG_LEGS = register(
      "long_legs",
      Builder.<LongLegsEntity>of(LongLegsEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(LongLegsEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<LongLegsTinyEntity>> LONG_LEGS_TINY = register(
      "long_legs_tiny",
      Builder.<LongLegsTinyEntity>of(LongLegsTinyEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(LongLegsTinyEntity::new)
         .sized(0.6F, 0.6F)
   );
   public static final RegistryObject<EntityType<DwellerSleepSpawnerEntity>> DWELLER_SLEEP_SPAWNER = register(
      "dweller_sleep_spawner",
      Builder.<DwellerSleepSpawnerEntity>of(DwellerSleepSpawnerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(DwellerSleepSpawnerEntity::new)
         .fireImmune()
         .sized(0.99F, 3.0F)
   );
   public static final RegistryObject<EntityType<CentipedeStalkerEntity>> CENTIPEDE_STALKER = register(
      "centipede_stalker",
      Builder.<CentipedeStalkerEntity>of(CentipedeStalkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(80)
         .setUpdateInterval(3)
         .setCustomClientFactory(CentipedeStalkerEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<BloodWormEntity>> BLOOD_WORM = register(
      "blood_worm",
      Builder.<BloodWormEntity>of(BloodWormEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(BloodWormEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<BeetleTickMiteEntity>> BEETLE_TICK_MITE = register(
      "beetle_tick_mite",
      Builder.<BeetleTickMiteEntity>of(BeetleTickMiteEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(BeetleTickMiteEntity::new)
         .sized(0.4F, 0.4F)
   );
   public static final RegistryObject<EntityType<PureStalkingEntity>> PURE_STALKING = register(
      "pure_stalking",
      Builder.<PureStalkingEntity>of(PureStalkingEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(PureStalkingEntity::new)
         .fireImmune()
         .sized(0.9F, 1.5F)
   );
   public static final RegistryObject<EntityType<RushScareEntity>> RUSH_SCARE = register(
      "rush_scare",
      Builder.<RushScareEntity>of(RushScareEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(RushScareEntity::new)
         .fireImmune()
         .sized(1.9F, 1.9F)
   );
   public static final RegistryObject<EntityType<SpiderBroodEntity>> SPIDER_BROOD = register(
      "spider_brood",
      Builder.<SpiderBroodEntity>of(SpiderBroodEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderBroodEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<SpiderBroodEntityProjectile>> SPIDER_BROOD_PROJECTILE = register(
      "projectile_spider_brood",
      Builder.<SpiderBroodEntityProjectile>of(SpiderBroodEntityProjectile::new, MobCategory.MISC)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .setCustomClientFactory(SpiderBroodEntityProjectile::new)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SkyStalkerEntity>> SKY_STALKER = register(
      "sky_stalker",
      Builder.<SkyStalkerEntity>of(SkyStalkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(50)
         .setUpdateInterval(3)
         .setCustomClientFactory(SkyStalkerEntity::new)
         .fireImmune()
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<SpiderFlatEntity>> SPIDER_FLAT = register(
      "spider_flat",
      Builder.<SpiderFlatEntity>of(SpiderFlatEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(80)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderFlatEntity::new)
         .sized(0.95F, 0.95F)
   );
   public static final RegistryObject<EntityType<WebbedArrowEntity>> WEBBED_ARROW = register(
      "webbed_arrow",
      Builder.<WebbedArrowEntity>of(WebbedArrowEntity::new, MobCategory.MISC)
         .setCustomClientFactory(WebbedArrowEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<CentipedeEvictorEntity>> CENTIPEDE_EVICTOR = register(
      "centipede_evictor",
      Builder.<CentipedeEvictorEntity>of(CentipedeEvictorEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(CentipedeEvictorEntity::new)
         .fireImmune()
         .sized(1.95F, 0.7F)
   );
   public static final RegistryObject<EntityType<CentipedeEvictorLarvaeEntity>> CENTIPEDE_EVICTOR_LARVAE = register(
      "centipede_evictor_larvae",
      Builder.<CentipedeEvictorLarvaeEntity>of(CentipedeEvictorLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(CentipedeEvictorLarvaeEntity::new)
         .fireImmune()
         .sized(0.95F, 0.95F)
   );
   public static final RegistryObject<EntityType<TinyCentipedeBreacherEntity>> TINY_CENTIPEDE_BREACHER = register(
      "tiny_centipede_breacher",
      Builder.<TinyCentipedeBreacherEntity>of(TinyCentipedeBreacherEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TinyCentipedeBreacherEntity::new)
         .fireImmune()
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SpiderLurkerEntity>> SPIDER_LURKER = register(
      "spider_lurker",
      Builder.<SpiderLurkerEntity>of(SpiderLurkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderLurkerEntity::new)
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<InvisibleStalkerEntity>> INVISIBLE_STALKER = register(
      "invisible_stalker",
      Builder.<InvisibleStalkerEntity>of(InvisibleStalkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(300)
         .setUpdateInterval(3)
         .setCustomClientFactory(InvisibleStalkerEntity::new)
         .fireImmune()
         .sized(0.4F, 0.4F)
   );
   public static final RegistryObject<EntityType<SpiderFunnelEntity>> SPIDER_FUNNEL = register(
      "spider_funnel",
      Builder.<SpiderFunnelEntity>of(SpiderFunnelEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderFunnelEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<WebHookEntity>> WEB_HOOK = register(
      "web_hook",
      Builder.<WebHookEntity>of(WebHookEntity::new, MobCategory.MISC)
         .setCustomClientFactory(WebHookEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<WebHarnessEntity>> WEB_HARNESS = register(
      "web_harness",
      Builder.<WebHarnessEntity>of(WebHarnessEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(WebHarnessEntity::new)
         .fireImmune()
         .sized(1.0F, 2.0F)
   );
   public static final RegistryObject<EntityType<WebRopeEntity>> WEB_ROPE = register(
      "web_rope",
      Builder.<WebRopeEntity>of(WebRopeEntity::new, MobCategory.MISC)
         .setCustomClientFactory(WebRopeEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<WebFunnelEntity>> WEB_FUNNEL = register(
      "web_funnel",
      Builder.<WebFunnelEntity>of(WebFunnelEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(50)
         .setUpdateInterval(3)
         .setCustomClientFactory(WebFunnelEntity::new)
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<SpiderGoliathEntity>> SPIDER_GOLIATH = register(
      "spider_goliath",
      Builder.<SpiderGoliathEntity>of(SpiderGoliathEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderGoliathEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<SilverfishSpectreEntity>> SILVERFISH_SPECTRE = register(
      "silverfish_spectre",
      Builder.<SilverfishSpectreEntity>of(SilverfishSpectreEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(20)
         .setUpdateInterval(3)
         .setCustomClientFactory(SilverfishSpectreEntity::new)
         .sized(0.6F, 0.6F)
   );
   public static final RegistryObject<EntityType<PowerHookEntity>> POWER_HOOK = register(
      "power_hook",
      Builder.<PowerHookEntity>of(PowerHookEntity::new, MobCategory.MISC)
         .setCustomClientFactory(PowerHookEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<TamedTarantulaEntity>> TAMED_TARANTULA = register(
      "tamed_tarantula",
      Builder.<TamedTarantulaEntity>of(TamedTarantulaEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(TamedTarantulaEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<HornetHarbingerEntity>> HORNET_HARBINGER = register(
      "hornet_harbinger",
      Builder.<HornetHarbingerEntity>of(HornetHarbingerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(70)
         .setUpdateInterval(3)
         .setCustomClientFactory(HornetHarbingerEntity::new)
         .sized(0.95F, 0.95F)
   );
   public static final RegistryObject<EntityType<HornetHarbingerGiantEntity>> HORNET_HARBINGER_GIANT = register(
      "hornet_harbinger_giant",
      Builder.<HornetHarbingerGiantEntity>of(HornetHarbingerGiantEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(70)
         .setUpdateInterval(3)
         .setCustomClientFactory(HornetHarbingerGiantEntity::new)
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<MosquitoMorbidityEntity>> MOSQUITO_MORBIDITY = register(
      "mosquito_morbidity",
      Builder.<MosquitoMorbidityEntity>of(MosquitoMorbidityEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(20)
         .setUpdateInterval(3)
         .setCustomClientFactory(MosquitoMorbidityEntity::new)
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<SpiderMothSummonEntity>> SPIDER_MOTH_SUMMON = register(
      "spider_moth_summon",
      Builder.<SpiderMothSummonEntity>of(SpiderMothSummonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(70)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderMothSummonEntity::new)
         .fireImmune()
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<LongLegsFlyEntity>> LONG_LEGS_FLY = register(
      "long_legs_fly",
      Builder.<LongLegsFlyEntity>of(LongLegsFlyEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(20)
         .setUpdateInterval(3)
         .setCustomClientFactory(LongLegsFlyEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<ScorpioidBloodlusterEntity>> SCORPIOID_BLOODLUSTER = register(
      "scorpioid_bloodluster",
      Builder.<ScorpioidBloodlusterEntity>of(ScorpioidBloodlusterEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScorpioidBloodlusterEntity::new)
         .fireImmune()
         .sized(1.9F, 2.9F)
   );
   public static final RegistryObject<EntityType<BloodthirstyTendrilEntity>> BLOODTHIRSTY_TENDRIL = register(
      "bloodthirsty_tendril",
      Builder.<BloodthirstyTendrilEntity>of(BloodthirstyTendrilEntity::new, MobCategory.MISC)
         .setCustomClientFactory(BloodthirstyTendrilEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<ScorpioidCloneEntity>> SCORPIOID_CLONE = register(
      "scorpioid_clone",
      Builder.<ScorpioidCloneEntity>of(ScorpioidCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(130)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScorpioidCloneEntity::new)
         .fireImmune()
         .sized(1.2F, 2.0F)
   );
   public static final RegistryObject<EntityType<ScorpioidInitialEntity>> SCORPIOID_INITIAL = register(
      "scorpioid_initial",
      Builder.<ScorpioidInitialEntity>of(ScorpioidInitialEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScorpioidInitialEntity::new)
         .fireImmune()
         .sized(1.9F, 3.4F)
   );
   public static final RegistryObject<EntityType<SpiderMothSummonLarvaeEntity>> SPIDER_MOTH_SUMMON_LARVAE = register(
      "spider_moth_summon_larvae",
      Builder.<SpiderMothSummonLarvaeEntity>of(SpiderMothSummonLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(74)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderMothSummonLarvaeEntity::new)
         .fireImmune()
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<ScorpioidChaserHallucinationEntity>> SCORPIOID_CHASER_HALLUCINATION = register(
      "scorpioid_chaser_hallucination",
      Builder.<ScorpioidChaserHallucinationEntity>of(ScorpioidChaserHallucinationEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(130)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScorpioidChaserHallucinationEntity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<InvisibleArrowEntity>> INVISIBLE_ARROW = register(
      "invisible_arrow",
      Builder.<InvisibleArrowEntity>of(InvisibleArrowEntity::new, MobCategory.MISC)
         .setCustomClientFactory(InvisibleArrowEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<RepellantEntity>> REPELLANT = register(
      "repellant",
      Builder.<RepellantEntity>of(RepellantEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(RepellantEntity::new)
         .fireImmune()
         .sized(0.1F, 0.1F)
   );
   public static final RegistryObject<EntityType<AoEflameEntity>> AO_EFLAME = register(
      "ao_eflame",
      Builder.<AoEflameEntity>of(AoEflameEntity::new, MobCategory.MISC)
         .setCustomClientFactory(AoEflameEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<AoEflame2Entity>> AO_EFLAME_2 = register(
      "ao_eflame_2",
      Builder.<AoEflame2Entity>of(AoEflame2Entity::new, MobCategory.MISC)
         .setCustomClientFactory(AoEflame2Entity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<AntArsonistEntity>> ANT_ARSONIST = register(
      "ant_arsonist",
      Builder.<AntArsonistEntity>of(AntArsonistEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(20)
         .setUpdateInterval(3)
         .setCustomClientFactory(AntArsonistEntity::new)
         .fireImmune()
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<LocustLandscourgeEntity>> LOCUST_LANDSCOURGE = register(
      "locust_landscourge",
      Builder.<LocustLandscourgeEntity>of(LocustLandscourgeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(20)
         .setUpdateInterval(3)
         .setCustomClientFactory(LocustLandscourgeEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<WebHarnessDownEntity>> WEB_HARNESS_DOWN = register(
      "web_harness_down",
      Builder.<WebHarnessDownEntity>of(WebHarnessDownEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(WebHarnessDownEntity::new)
         .fireImmune()
         .sized(1.0F, 2.0F)
   );
   public static final RegistryObject<EntityType<SpiderProwlerEntity>> SPIDER_PROWLER = register(
      "spider_prowler",
      Builder.<SpiderProwlerEntity>of(SpiderProwlerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderProwlerEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<GiantWebEntity>> GIANT_WEB = register(
      "giant_web",
      Builder.<GiantWebEntity>of(GiantWebEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(GiantWebEntity::new)
         .sized(0.2F, 1.9F)
   );
   public static final RegistryObject<EntityType<SpiderJumpEntity>> SPIDER_JUMP = register(
      "spider_jump",
      Builder.<SpiderJumpEntity>of(SpiderJumpEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(80)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderJumpEntity::new)
         .sized(0.65F, 0.65F)
   );
   public static final RegistryObject<EntityType<FlyFestererEntity>> FLY_FESTERER = register(
      "fly_festerer",
      Builder.<FlyFestererEntity>of(FlyFestererEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(10)
         .setUpdateInterval(3)
         .setCustomClientFactory(FlyFestererEntity::new)
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<DisappearInvisibleEntity>> DISAPPEAR_INVISIBLE = register(
      "disappear_invisible",
      Builder.<DisappearInvisibleEntity>of(DisappearInvisibleEntity::new, MobCategory.MISC)
         .setCustomClientFactory(DisappearInvisibleEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SpiderMothEntity>> SPIDER_MOTH = register(
      "spider_moth",
      Builder.<SpiderMothEntity>of(SpiderMothEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(130)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderMothEntity::new)
         .fireImmune()
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<ScorpioidShadowCloneEntity>> SCORPIOID_SHADOW_CLONE = register(
      "scorpioid_shadow_clone",
      Builder.<ScorpioidShadowCloneEntity>of(ScorpioidShadowCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(100)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScorpioidShadowCloneEntity::new)
         .fireImmune()
         .sized(2.0F, 2.0F)
   );
   public static final RegistryObject<EntityType<ButterflyBewitcherGiantEntity>> BUTTERFLY_BEWITCHER_GIANT = register(
      "butterfly_bewitcher_giant",
      Builder.<ButterflyBewitcherGiantEntity>of(ButterflyBewitcherGiantEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(ButterflyBewitcherGiantEntity::new)
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<MillipedeMarauderEntity>> MILLIPEDE_MARAUDER = register(
      "millipede_marauder",
      Builder.<MillipedeMarauderEntity>of(MillipedeMarauderEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(80)
         .setUpdateInterval(3)
         .setCustomClientFactory(MillipedeMarauderEntity::new)
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<MaggotLarvaeEntity>> MAGGOT_LARVAE = register(
      "maggot_larvae",
      Builder.<MaggotLarvaeEntity>of(MaggotLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(6)
         .setUpdateInterval(3)
         .setCustomClientFactory(MaggotLarvaeEntity::new)
         .sized(0.6F, 0.6F)
   );
   public static final RegistryObject<EntityType<RoachRiverspawnEntity>> ROACH_RIVERSPAWN = register(
      "roach_riverspawn",
      Builder.<RoachRiverspawnEntity>of(RoachRiverspawnEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(RoachRiverspawnEntity::new)
         .fireImmune()
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<BloodProjectileEntity>> BLOOD_PROJECTILE = register(
      "blood_projectile",
      Builder.<BloodProjectileEntity>of(BloodProjectileEntity::new, MobCategory.MISC)
         .setCustomClientFactory(BloodProjectileEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<DraconFireEntity>> DRACON_FIRE = register(
      "dracon_fire",
      Builder.<DraconFireEntity>of(DraconFireEntity::new, MobCategory.MISC)
         .setCustomClientFactory(DraconFireEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<HomingVoidseekerEntity>> HOMING_VOIDSEEKER = register(
      "homing_voidseeker",
      Builder.<HomingVoidseekerEntity>of(HomingVoidseekerEntity::new, MobCategory.MISC)
         .setCustomClientFactory(HomingVoidseekerEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<DraconicCloneEntity>> DRACONIC_CLONE = register(
      "draconic_clone",
      Builder.<DraconicCloneEntity>of(DraconicCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(DraconicCloneEntity::new)
         .fireImmune()
         .sized(1.99F, 1.99F)
   );
   public static final RegistryObject<EntityType<VoidSpearEntity>> VOID_SPEAR = register(
      "void_spear",
      Builder.<VoidSpearEntity>of(VoidSpearEntity::new, MobCategory.MISC)
         .setCustomClientFactory(VoidSpearEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<ButterflyBewitcherEntity>> BUTTERFLY_BEWITCHER = register(
      "butterfly_bewitcher",
      Builder.<ButterflyBewitcherEntity>of(ButterflyBewitcherEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(ButterflyBewitcherEntity::new)
         .sized(0.7F, 0.7F)
   );
   public static final RegistryObject<EntityType<DragonflyDreadnoughtEntity>> DRAGONFLY_DREADNOUGHT = register(
      "dragonfly_dreadnought",
      Builder.<DragonflyDreadnoughtEntity>of(DragonflyDreadnoughtEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(DragonflyDreadnoughtEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<VoidlasherShadowCloneEntity>> VOIDLASHER_SHADOW_CLONE = register(
      "voidlasher_shadow_clone",
      Builder.<VoidlasherShadowCloneEntity>of(VoidlasherShadowCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(100)
         .setUpdateInterval(3)
         .setCustomClientFactory(VoidlasherShadowCloneEntity::new)
         .fireImmune()
         .sized(2.0F, 2.0F)
   );
   public static final RegistryObject<EntityType<SpiderSnatcherEntity>> SPIDER_SNATCHER = register(
      "spider_snatcher",
      Builder.<SpiderSnatcherEntity>of(SpiderSnatcherEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(80)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderSnatcherEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<CrabConstrictorEntity>> CRAB_CONSTRICTOR = register(
      "crab_constrictor",
      Builder.<CrabConstrictorEntity>of(CrabConstrictorEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(160)
         .setUpdateInterval(3)
         .setCustomClientFactory(CrabConstrictorEntity::new)
         .fireImmune()
         .sized(1.99F, 2.99F)
   );
   public static final RegistryObject<EntityType<MothMoontrackerEntity>> MOTH_MOONTRACKER = register(
      "moth_moontracker",
      Builder.<MothMoontrackerEntity>of(MothMoontrackerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(70)
         .setUpdateInterval(3)
         .setCustomClientFactory(MothMoontrackerEntity::new)
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<ScorpionStrikerEntity>> SCORPION_STRIKER = register(
      "scorpion_striker",
      Builder.<ScorpionStrikerEntity>of(ScorpionStrikerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScorpionStrikerEntity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<ScorpionLarvaeEntity>> SCORPION_LARVAE = register(
      "scorpion_larvae",
      Builder.<ScorpionLarvaeEntity>of(ScorpionLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScorpionLarvaeEntity::new)
         .fireImmune()
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<RandomArPhExEntity>> RANDOM_AR_PH_EX = register(
      "random_ar_ph_ex",
      Builder.<RandomArPhExEntity>of(RandomArPhExEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(RandomArPhExEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<SmallWebEntity>> SMALL_WEB = register(
      "small_web",
      Builder.<SmallWebEntity>of(SmallWebEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SmallWebEntity::new)
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<SolifugeSkulkerEntity>> SOLIFUGE_SKULKER = register(
      "solifuge_skulker",
      Builder.<SolifugeSkulkerEntity>of(SolifugeSkulkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(SolifugeSkulkerEntity::new)
         .sized(1.4F, 0.9F)
   );
   public static final RegistryObject<EntityType<OpalArrowEntity>> OPAL_ARROW = register(
      "opal_arrow",
      Builder.<OpalArrowEntity>of(OpalArrowEntity::new, MobCategory.MISC)
         .setCustomClientFactory(OpalArrowEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<EnormousSpiderHallucinationEntity>> ENORMOUS_SPIDER_HALLUCINATION = register(
      "enormous_spider_hallucination",
      Builder.<EnormousSpiderHallucinationEntity>of(EnormousSpiderHallucinationEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(300)
         .setUpdateInterval(3)
         .setCustomClientFactory(EnormousSpiderHallucinationEntity::new)
         .fireImmune()
         .sized(4.0F, 4.0F)
   );
   public static final RegistryObject<EntityType<CrabLarvaeEntity>> CRAB_LARVAE = register(
      "crab_larvae",
      Builder.<CrabLarvaeEntity>of(CrabLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(70)
         .setUpdateInterval(3)
         .setCustomClientFactory(CrabLarvaeEntity::new)
         .fireImmune()
         .sized(0.99F, 1.99F)
   );
   public static final RegistryObject<EntityType<AbyssExplosiveEntity>> ABYSS_EXPLOSIVE = register(
      "abyss_explosive",
      Builder.<AbyssExplosiveEntity>of(AbyssExplosiveEntity::new, MobCategory.MISC)
         .setCustomClientFactory(AbyssExplosiveEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<JudgementBlastEntity>> JUDGEMENT_BLAST = register(
      "judgement_blast",
      Builder.<JudgementBlastEntity>of(JudgementBlastEntity::new, MobCategory.MISC)
         .setCustomClientFactory(JudgementBlastEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<DraconicFlyStalkEntity>> DRACONIC_FLY_STALK = register(
      "draconic_fly_stalk",
      Builder.<DraconicFlyStalkEntity>of(DraconicFlyStalkEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(DraconicFlyStalkEntity::new)
         .fireImmune()
         .sized(1.99F, 1.99F)
   );
   public static final RegistryObject<EntityType<VortexBlastEntity>> VORTEX_BLAST = register(
      "vortex_blast",
      Builder.<VortexBlastEntity>of(VortexBlastEntity::new, MobCategory.MISC)
         .setCustomClientFactory(VortexBlastEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<BeetleBulwarkEntity>> BEETLE_BULWARK = register(
      "beetle_bulwark",
      Builder.<BeetleBulwarkEntity>of(BeetleBulwarkEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(BeetleBulwarkEntity::new)
         .fireImmune()
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<ScarabSummonEntity>> SCARAB_SUMMON = register(
      "scarab_summon",
      Builder.<ScarabSummonEntity>of(ScarabSummonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(ScarabSummonEntity::new)
         .sized(0.3F, 0.3F)
   );
   public static final RegistryObject<EntityType<SpiderReaperEntity>> SPIDER_REAPER = register(
      "spider_reaper",
      Builder.<SpiderReaperEntity>of(SpiderReaperEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderReaperEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<DungeonTriggerEntity>> DUNGEON_TRIGGER = register(
      "dungeon_trigger",
      Builder.<DungeonTriggerEntity>of(DungeonTriggerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(DungeonTriggerEntity::new)
         .sized(0.1F, 0.1F)
   );
   public static final RegistryObject<EntityType<AntArsonistWorkerEntity>> ANT_ARSONIST_WORKER = register(
      "ant_arsonist_worker",
      Builder.<AntArsonistWorkerEntity>of(AntArsonistWorkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(AntArsonistWorkerEntity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<AntArsonistSoldierEntity>> ANT_ARSONIST_SOLDIER = register(
      "ant_arsonist_soldier",
      Builder.<AntArsonistSoldierEntity>of(AntArsonistSoldierEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(AntArsonistSoldierEntity::new)
         .fireImmune()
         .sized(1.2F, 1.2F)
   );
   public static final RegistryObject<EntityType<AntArsonistAlateQueenEntity>> ANT_ARSONIST_ALATE_QUEEN = register(
      "ant_arsonist_alate_queen",
      Builder.<AntArsonistAlateQueenEntity>of(AntArsonistAlateQueenEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(AntArsonistAlateQueenEntity::new)
         .fireImmune()
         .sized(0.96F, 0.96F)
   );
   public static final RegistryObject<EntityType<AntArsonistDroneEntity>> ANT_ARSONIST_DRONE = register(
      "ant_arsonist_drone",
      Builder.<AntArsonistDroneEntity>of(AntArsonistDroneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(AntArsonistDroneEntity::new)
         .fireImmune()
         .sized(0.75F, 0.75F)
   );
   public static final RegistryObject<EntityType<TermiteTunnelerWorkerEntity>> TERMITE_TUNNELER_WORKER = register(
      "termite_tunneler_worker",
      Builder.<TermiteTunnelerWorkerEntity>of(TermiteTunnelerWorkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TermiteTunnelerWorkerEntity::new)
         .sized(0.8F, 0.8F)
   );
   public static final RegistryObject<EntityType<TermiteTunnelerSoldierEntity>> TERMITE_TUNNELER_SOLDIER = register(
      "termite_tunneler_soldier",
      Builder.<TermiteTunnelerSoldierEntity>of(TermiteTunnelerSoldierEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TermiteTunnelerSoldierEntity::new)
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<RandomTermiteEntity>> RANDOM_TERMITE = register(
      "random_termite",
      Builder.<RandomTermiteEntity>of(RandomTermiteEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(RandomTermiteEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<TermiteTunnelerAlateEntity>> TERMITE_TUNNELER_ALATE = register(
      "termite_tunneler_alate",
      Builder.<TermiteTunnelerAlateEntity>of(TermiteTunnelerAlateEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TermiteTunnelerAlateEntity::new)
         .sized(0.96F, 0.96F)
   );
   public static final RegistryObject<EntityType<TermiteTunnelerKingEntity>> TERMITE_TUNNELER_KING = register(
      "termite_tunneler_king",
      Builder.<TermiteTunnelerKingEntity>of(TermiteTunnelerKingEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TermiteTunnelerKingEntity::new)
         .sized(1.49F, 1.49F)
   );
   public static final RegistryObject<EntityType<TermiteTunnelerQueenEntity>> TERMITE_TUNNELER_QUEEN = register(
      "termite_tunneler_queen",
      Builder.<TermiteTunnelerQueenEntity>of(TermiteTunnelerQueenEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TermiteTunnelerQueenEntity::new)
         .sized(1.4F, 1.0F)
   );
   public static final RegistryObject<EntityType<TormentBlastEntity>> TORMENT_BLAST = register(
      "torment_blast",
      Builder.<TormentBlastEntity>of(TormentBlastEntity::new, MobCategory.MISC)
         .setCustomClientFactory(TormentBlastEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<TORMENTOREntity>> TORMENTOR = register(
      "tormentor",
      Builder.<TORMENTOREntity>of(TORMENTOREntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TORMENTOREntity::new)
         .fireImmune()
         .sized(8.0F, 8.0F)
   );
   public static final RegistryObject<EntityType<MantisMutilatorEntity>> MANTIS_MUTILATOR = register(
      "mantis_mutilator",
      Builder.<MantisMutilatorEntity>of(MantisMutilatorEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(80)
         .setUpdateInterval(3)
         .setCustomClientFactory(MantisMutilatorEntity::new)
         .fireImmune()
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<TormentorInitialEntity>> TORMENTOR_INITIAL = register(
      "tormentor_initial",
      Builder.<TormentorInitialEntity>of(TormentorInitialEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorInitialEntity::new)
         .fireImmune()
         .sized(3.0F, 10.0F)
   );
   public static final RegistryObject<EntityType<CrawlingRandomEntity>> CRAWLING_RANDOM = register(
      "crawling_random",
      Builder.<CrawlingRandomEntity>of(CrawlingRandomEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(CrawlingRandomEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<TormentorTendrilEntity>> TORMENTOR_TENDRIL = register(
      "tormentor_tendril",
      Builder.<TormentorTendrilEntity>of(TormentorTendrilEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorTendrilEntity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<TormentorMothSummonEntity>> TORMENTOR_MOTH_SUMMON = register(
      "tormentor_moth_summon",
      Builder.<TormentorMothSummonEntity>of(TormentorMothSummonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(130)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorMothSummonEntity::new)
         .fireImmune()
         .sized(4.0F, 4.0F)
   );
   public static final RegistryObject<EntityType<TormentorScorpioidSummonEntity>> TORMENTOR_SCORPIOID_SUMMON = register(
      "tormentor_scorpioid_summon",
      Builder.<TormentorScorpioidSummonEntity>of(TormentorScorpioidSummonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorScorpioidSummonEntity::new)
         .fireImmune()
         .sized(4.0F, 4.0F)
   );
   public static final RegistryObject<EntityType<TormentorVoidlasherSummonEntity>> TORMENTOR_VOIDLASHER_SUMMON = register(
      "tormentor_voidlasher_summon",
      Builder.<TormentorVoidlasherSummonEntity>of(TormentorVoidlasherSummonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorVoidlasherSummonEntity::new)
         .fireImmune()
         .sized(4.0F, 13.0F)
   );
   public static final RegistryObject<EntityType<WidowArrowEntity>> WIDOW_ARROW = register(
      "widow_arrow",
      Builder.<WidowArrowEntity>of(WidowArrowEntity::new, MobCategory.MISC)
         .setCustomClientFactory(WidowArrowEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<TormentRifleEntity>> TORMENT_RIFLE = register(
      "torment_rifle",
      Builder.<TormentRifleEntity>of(TormentRifleEntity::new, MobCategory.MISC)
         .setCustomClientFactory(TormentRifleEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<TormentorSummonEntity>> TORMENTOR_SUMMON = register(
      "tormentor_summon",
      Builder.<TormentorSummonEntity>of(TormentorSummonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorSummonEntity::new)
         .fireImmune()
         .sized(1.99F, 1.99F)
   );
   public static final RegistryObject<EntityType<TormentorSphereEntity>> TORMENTOR_SPHERE = register(
      "tormentor_sphere",
      Builder.<TormentorSphereEntity>of(TormentorSphereEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorSphereEntity::new)
         .fireImmune()
         .sized(3.0F, 3.0F)
   );
   public static final RegistryObject<EntityType<TormentorCaterpillarEntity>> TORMENTOR_CATERPILLAR = register(
      "tormentor_caterpillar",
      Builder.<TormentorCaterpillarEntity>of(TormentorCaterpillarEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorCaterpillarEntity::new)
         .fireImmune()
         .sized(1.9F, 1.9F)
   );
   public static final RegistryObject<EntityType<TormentorLarvaeEntity>> TORMENTOR_LARVAE = register(
      "tormentor_larvae",
      Builder.<TormentorLarvaeEntity>of(TormentorLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorLarvaeEntity::new)
         .fireImmune()
         .sized(0.95F, 0.95F)
   );
   public static final RegistryObject<EntityType<MiniatureCoreEntity>> MINIATURE_CORE = register(
      "miniature_core",
      Builder.<MiniatureCoreEntity>of(MiniatureCoreEntity::new, MobCategory.MISC)
         .setCustomClientFactory(MiniatureCoreEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SmallTormentSphereEntity>> SMALL_TORMENT_SPHERE = register(
      "small_torment_sphere",
      Builder.<SmallTormentSphereEntity>of(SmallTormentSphereEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(650)
         .setUpdateInterval(3)
         .setCustomClientFactory(SmallTormentSphereEntity::new)
         .fireImmune()
         .sized(2.0F, 2.0F)
   );
   public static final RegistryObject<EntityType<SpiderInfestorEntity>> SPIDER_INFESTOR = register(
      "spider_infestor",
      Builder.<SpiderInfestorEntity>of(SpiderInfestorEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderInfestorEntity::new)
         .fireImmune()
         .sized(1.48F, 1.48F)
   );
   public static final RegistryObject<EntityType<TormentExplosiveEntity>> TORMENT_EXPLOSIVE = register(
      "torment_explosive",
      Builder.<TormentExplosiveEntity>of(TormentExplosiveEntity::new, MobCategory.MISC)
         .setCustomClientFactory(TormentExplosiveEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<TormentorLowDisplayEntity>> TORMENTOR_LOW_DISPLAY = register(
      "tormentor_low_display",
      Builder.<TormentorLowDisplayEntity>of(TormentorLowDisplayEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorLowDisplayEntity::new)
         .fireImmune()
         .sized(3.0F, 10.0F)
   );
   public static final RegistryObject<EntityType<TormentorLowDisplayAnimEntity>> TORMENTOR_LOW_DISPLAY_ANIM = register(
      "tormentor_low_display_anim",
      Builder.<TormentorLowDisplayAnimEntity>of(TormentorLowDisplayAnimEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorLowDisplayAnimEntity::new)
         .fireImmune()
         .sized(3.0F, 10.0F)
   );
   public static final RegistryObject<EntityType<SummonSunBlastEntity>> SUMMON_SUN_BLAST = register(
      "summon_sun_blast",
      Builder.<SummonSunBlastEntity>of(SummonSunBlastEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SummonSunBlastEntity::new)
         .fireImmune()
         .sized(0.99F, 0.99F)
   );
   public static final RegistryObject<EntityType<WaspNemesisEntity>> WASP_NEMESIS = register(
      "wasp_nemesis",
      Builder.<WaspNemesisEntity>of(WaspNemesisEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(110)
         .setUpdateInterval(3)
         .setCustomClientFactory(WaspNemesisEntity::new)
         .fireImmune()
         .sized(2.45F, 2.45F)
   );
   public static final RegistryObject<EntityType<SegmentedBodyEntity>> SEGMENTED_BODY = register(
      "segmented_body",
      Builder.<SegmentedBodyEntity>of(SegmentedBodyEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(400)
         .setUpdateInterval(3)
         .setCustomClientFactory(SegmentedBodyEntity::new)
         .fireImmune()
         .sized(0.97F, 0.9F)
   );
   public static final RegistryObject<EntityType<ArthropleuraAbominationEntity>> ARTHROPLEURA_ABOMINATION = register(
      "arthropleura_abomination",
      Builder.<ArthropleuraAbominationEntity>of(ArthropleuraAbominationEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(400)
         .setUpdateInterval(3)
         .setCustomClientFactory(ArthropleuraAbominationEntity::new)
         .fireImmune()
         .sized(0.87F, 0.95F)
   );
   public static final RegistryObject<EntityType<VenusFlytrapEntity>> VENUS_FLYTRAP = register(
      "venus_flytrap",
      Builder.<VenusFlytrapEntity>of(VenusFlytrapEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(VenusFlytrapEntity::new)
         .sized(0.6F, 2.9F)
   );
   public static final RegistryObject<EntityType<FlytrapEntity>> FLYTRAP = register(
      "flytrap",
      Builder.<FlytrapEntity>of(FlytrapEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(FlytrapEntity::new)
         .sized(0.4F, 1.1F)
   );
   public static final RegistryObject<EntityType<SpiderAmbusherEntity>> SPIDER_AMBUSHER = register(
      "spider_ambusher",
      Builder.<SpiderAmbusherEntity>of(SpiderAmbusherEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(80)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderAmbusherEntity::new)
         .sized(1.4F, 0.9F)
   );
   public static final RegistryObject<EntityType<SpinpartitestEntity>> SPINPARTITEST = register(
      "spinpartitest",
      Builder.<SpinpartitestEntity>of(SpinpartitestEntity::new, MobCategory.MISC)
         .setCustomClientFactory(SpinpartitestEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SphereAnimEntity>> SPHERE_ANIM = register(
      "sphere_anim",
      Builder.<SphereAnimEntity>of(SphereAnimEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SphereAnimEntity::new)
         .fireImmune()
         .sized(0.1F, 0.1F)
   );
   public static final RegistryObject<EntityType<AscendantArrowEntity>> ASCENDANT_ARROW = register(
      "ascendant_arrow",
      Builder.<AscendantArrowEntity>of(AscendantArrowEntity::new, MobCategory.MISC)
         .setCustomClientFactory(AscendantArrowEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SlowLookTestEntity>> SLOW_LOOK_TEST = register(
      "slow_look_test",
      Builder.<SlowLookTestEntity>of(SlowLookTestEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SlowLookTestEntity::new)
         .fireImmune()
         .sized(0.6F, 0.5F)
   );
   public static final RegistryObject<EntityType<AiToRideEntity>> AI_TO_RIDE = register(
      "ai_to_ride",
      Builder.<AiToRideEntity>of(AiToRideEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(AiToRideEntity::new)
         .sized(1.44F, 1.45F)
   );
   public static final RegistryObject<EntityType<AiControllerEntity>> AI_CONTROLLER = register(
      "ai_controller",
      Builder.<AiControllerEntity>of(AiControllerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(AiControllerEntity::new)
         .sized(1.45F, 1.45F)
   );
   public static final RegistryObject<EntityType<AscendSphereAnimEntity>> ASCEND_SPHERE_ANIM = register(
      "ascend_sphere_anim",
      Builder.<AscendSphereAnimEntity>of(AscendSphereAnimEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(AscendSphereAnimEntity::new)
         .fireImmune()
         .sized(0.1F, 0.1F)
   );
   public static final RegistryObject<EntityType<TormentorLaserEntity>> TORMENTOR_LASER = register(
      "tormentor_laser",
      Builder.<TormentorLaserEntity>of(TormentorLaserEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorLaserEntity::new)
         .fireImmune()
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<WarpStaffDirectionEntity>> WARP_STAFF_DIRECTION = register(
      "warp_staff_direction",
      Builder.<WarpStaffDirectionEntity>of(WarpStaffDirectionEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(WarpStaffDirectionEntity::new)
         .fireImmune()
         .sized(0.0F, 0.0F)
   );
   public static final RegistryObject<EntityType<GiantEnemySpiderEntity>> GIANT_ENEMY_SPIDER = register(
      "giant_enemy_spider",
      Builder.<GiantEnemySpiderEntity>of(GiantEnemySpiderEntity::new, MobCategory.CREATURE)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(GiantEnemySpiderEntity::new)
         .fireImmune()
         .sized(1.9F, 1.9F)
   );
   public static final RegistryObject<EntityType<InsaneModeSpawnsEntity>> INSANE_MODE_SPAWNS = register(
      "insane_mode_spawns",
      Builder.<InsaneModeSpawnsEntity>of(InsaneModeSpawnsEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(InsaneModeSpawnsEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<SpiderRecluseEntity>> SPIDER_RECLUSE = register(
      "spider_recluse",
      Builder.<SpiderRecluseEntity>of(SpiderRecluseEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderRecluseEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<TormentorFlashAnimEntity>> TORMENTOR_FLASH_ANIM = register(
      "tormentor_flash_anim",
      Builder.<TormentorFlashAnimEntity>of(TormentorFlashAnimEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorFlashAnimEntity::new)
         .fireImmune()
         .sized(3.0F, 10.0F)
   );
   public static final RegistryObject<EntityType<SpiderChaserHallucinationEntity>> SPIDER_CHASER_HALLUCINATION = register(
      "spider_chaser_hallucination",
      Builder.<SpiderChaserHallucinationEntity>of(SpiderChaserHallucinationEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(130)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderChaserHallucinationEntity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<SpiderChaserHallucination2Entity>> SPIDER_CHASER_HALLUCINATION_2 = register(
      "spider_chaser_hallucination_2",
      Builder.<SpiderChaserHallucination2Entity>of(SpiderChaserHallucination2Entity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(130)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderChaserHallucination2Entity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<CaveWebEntity>> CAVE_WEB = register(
      "cave_web",
      Builder.<CaveWebEntity>of(CaveWebEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(CaveWebEntity::new)
         .sized(0.2F, 1.0F)
   );
   public static final RegistryObject<EntityType<AnyDimensionSpawnerEntity>> ANY_DIMENSION_SPAWNER = register(
      "any_dimension_spawner",
      Builder.<AnyDimensionSpawnerEntity>of(AnyDimensionSpawnerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(AnyDimensionSpawnerEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<SpiderObstructerEntity>> SPIDER_OBSTRUCTER = register(
      "spider_obstructer",
      Builder.<SpiderObstructerEntity>of(SpiderObstructerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderObstructerEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<GenesisShotEntity>> GENESIS_SHOT = register(
      "genesis_shot",
      Builder.<GenesisShotEntity>of(GenesisShotEntity::new, MobCategory.MISC)
         .setCustomClientFactory(GenesisShotEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<HornetProjectileEntity>> HORNET_PROJECTILE = register(
      "hornet_projectile",
      Builder.<HornetProjectileEntity>of(HornetProjectileEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(70)
         .setUpdateInterval(3)
         .setCustomClientFactory(HornetProjectileEntity::new)
         .sized(0.95F, 0.95F)
   );
   public static final RegistryObject<EntityType<ChronoShotEntity>> CHRONO_SHOT = register(
      "chrono_shot",
      Builder.<ChronoShotEntity>of(ChronoShotEntity::new, MobCategory.MISC)
         .setCustomClientFactory(ChronoShotEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<TormentorTestEntity>> TORMENTOR_TEST = register(
      "tormentor_test",
      Builder.<TormentorTestEntity>of(TormentorTestEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorTestEntity::new)
         .fireImmune()
         .sized(0.0F, 0.0F)
   );
   public static final RegistryObject<EntityType<SpiderChaserHallucination3Entity>> SPIDER_CHASER_HALLUCINATION_3 = register(
      "spider_chaser_hallucination_3",
      Builder.<SpiderChaserHallucination3Entity>of(SpiderChaserHallucination3Entity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderChaserHallucination3Entity::new)
         .fireImmune()
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<SpiderLungerEntity>> SPIDER_LUNGER = register(
      "spider_lunger",
      Builder.<SpiderLungerEntity>of(SpiderLungerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderLungerEntity::new)
         .sized(1.4F, 1.4F)
   );
   public static final RegistryObject<EntityType<StickBugEntity>> STICK_BUG = register(
      "stick_bug",
      Builder.<StickBugEntity>of(StickBugEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(StickBugEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<TormentorHitboxEntity>> TORMENTOR_HITBOX = register(
      "tormentor_hitbox",
      Builder.<TormentorHitboxEntity>of(TormentorHitboxEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorHitboxEntity::new)
         .fireImmune()
         .sized(8.0F, 8.0F)
   );
   public static final RegistryObject<EntityType<TormentorT2Entity>> TORMENTOR_T_2 = register(
      "tormentor_t_2",
      Builder.<TormentorT2Entity>of(TormentorT2Entity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorT2Entity::new)
         .fireImmune()
         .sized(0.0F, 0.0F)
   );
   public static final RegistryObject<EntityType<TormentorT3Entity>> TORMENTOR_T_3 = register(
      "tormentor_t_3",
      Builder.<TormentorT3Entity>of(TormentorT3Entity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorT3Entity::new)
         .fireImmune()
         .sized(0.0F, 0.0F)
   );
   public static final RegistryObject<EntityType<TormentorT4Entity>> TORMENTOR_T_4 = register(
      "tormentor_t_4",
      Builder.<TormentorT4Entity>of(TormentorT4Entity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorT4Entity::new)
         .fireImmune()
         .sized(0.0F, 0.0F)
   );
   public static final RegistryObject<EntityType<TormentorT5Entity>> TORMENTOR_T_5 = register(
      "tormentor_t_5",
      Builder.<TormentorT5Entity>of(TormentorT5Entity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(500)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorT5Entity::new)
         .fireImmune()
         .sized(0.0F, 0.0F)
   );
   public static final RegistryObject<EntityType<HitboxExpanderEntity>> HITBOX_EXPANDER = register(
      "hitbox_expander",
      Builder.<HitboxExpanderEntity>of(HitboxExpanderEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(HitboxExpanderEntity::new)
         .fireImmune()
         .sized(1.2F, 1.3F)
   );
   public static final RegistryObject<EntityType<TormentorShieldEntity>> TORMENTOR_SHIELD = register(
      "tormentor_shield",
      Builder.<TormentorShieldEntity>of(TormentorShieldEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(60)
         .setUpdateInterval(3)
         .setCustomClientFactory(TormentorShieldEntity::new)
         .fireImmune()
         .sized(3.0F, 3.0F)
   );
   public static final RegistryObject<EntityType<TimeDistortionWaveEntity>> TIME_DISTORTION_WAVE = register(
      "time_distortion_wave",
      Builder.<TimeDistortionWaveEntity>of(TimeDistortionWaveEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(TimeDistortionWaveEntity::new)
         .fireImmune()
         .sized(0.0F, 0.0F)
   );
   public static final RegistryObject<EntityType<SpiderMatriarchEntity>> SPIDER_MATRIARCH = register(
      "spider_matriarch",
      Builder.<SpiderMatriarchEntity>of(SpiderMatriarchEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(128)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderMatriarchEntity::new)
         .fireImmune()
         .sized(1.55F, 1.95F)
   );
   public static final RegistryObject<EntityType<SpiderMatriarchLarvaeEntity>> SPIDER_MATRIARCH_LARVAE = register(
      "spider_matriarch_larvae",
      Builder.<SpiderMatriarchLarvaeEntity>of(SpiderMatriarchLarvaeEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderMatriarchLarvaeEntity::new)
         .sized(1.0F, 1.0F)
   );
   public static final RegistryObject<EntityType<ArachnoidTrisectorEntity>> ARACHNOID_TRISECTOR = register(
      "arachnoid_trisector",
      Builder.<ArachnoidTrisectorEntity>of(ArachnoidTrisectorEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(128)
         .setUpdateInterval(3)
         .setCustomClientFactory(ArachnoidTrisectorEntity::new)
         .fireImmune()
         .sized(1.55F, 3.95F)
   );
   public static final RegistryObject<EntityType<ChronoSpearShotEntity>> CHRONO_SPEAR_SHOT = register(
      "chrono_spear_shot",
      Builder.<ChronoSpearShotEntity>of(ChronoSpearShotEntity::new, MobCategory.MISC)
         .setCustomClientFactory(ChronoSpearShotEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<DiabolosDecimatorEntity>> DIABOLOS_DECIMATOR = register(
      "diabolos_decimator",
      Builder.<DiabolosDecimatorEntity>of(DiabolosDecimatorEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(200)
         .setUpdateInterval(3)
         .setCustomClientFactory(DiabolosDecimatorEntity::new)
         .fireImmune()
         .sized(1.55F, 9.8F)
   );
   public static final RegistryObject<EntityType<SpiderRecluseDisplayEntity>> SPIDER_RECLUSE_DISPLAY = register(
      "spider_recluse_display",
      Builder.<SpiderRecluseDisplayEntity>of(SpiderRecluseDisplayEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderRecluseDisplayEntity::new)
         .sized(0.9F, 0.9F)
   );
   public static final RegistryObject<EntityType<SpacetimeAnchorEntity>> SPACETIME_ANCHOR = register(
      "spacetime_anchor",
      Builder.<SpacetimeAnchorEntity>of(SpacetimeAnchorEntity::new, MobCategory.MISC)
         .setCustomClientFactory(SpacetimeAnchorEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<ArachnoidTimeCloneEntity>> ARACHNOID_TIME_CLONE = register(
      "arachnoid_time_clone",
      Builder.<ArachnoidTimeCloneEntity>of(ArachnoidTimeCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(128)
         .setUpdateInterval(3)
         .setCustomClientFactory(ArachnoidTimeCloneEntity::new)
         .fireImmune()
         .sized(1.55F, 3.95F)
   );
   public static final RegistryObject<EntityType<ArachnoidShadowCloneEntity>> ARACHNOID_SHADOW_CLONE = register(
      "arachnoid_shadow_clone",
      Builder.<ArachnoidShadowCloneEntity>of(ArachnoidShadowCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(100)
         .setUpdateInterval(3)
         .setCustomClientFactory(ArachnoidShadowCloneEntity::new)
         .fireImmune()
         .sized(2.0F, 2.0F)
   );
   public static final RegistryObject<EntityType<BlockTestEntity>> BLOCK_TEST = register(
      "block_test",
      Builder.<BlockTestEntity>of(BlockTestEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .setCustomClientFactory(BlockTestEntity::new)
         .fireImmune()
         .sized(0.5F, 5.0F)
   );
   public static final RegistryObject<EntityType<NemesisProjectileEntity>> NEMESIS_PROJECTILE = register(
      "nemesis_projectile",
      Builder.<NemesisProjectileEntity>of(NemesisProjectileEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(70)
         .setUpdateInterval(3)
         .setCustomClientFactory(NemesisProjectileEntity::new)
         .fireImmune()
         .sized(0.95F, 0.95F)
   );
   public static final RegistryObject<EntityType<SpiderSinkerEntity>> SPIDER_SINKER = register(
      "spider_sinker",
           EntityType.Builder.<SpiderSinkerEntity>of(SpiderSinkerEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(100)
         .setUpdateInterval(3)
         .setCustomClientFactory(SpiderSinkerEntity::new)
         .sized(1.0F, 1.0F)
   );
   public static final RegistryObject<EntityType<HomingSparkEntity>> HOMING_SPARK = register(
      "homing_spark",
      Builder.<HomingSparkEntity>of(HomingSparkEntity::new, MobCategory.MISC)
         .setCustomClientFactory(HomingSparkEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<DiabolosDecimatorCloneEntity>> DIABOLOS_DECIMATOR_CLONE = register(
      "diabolos_decimator_clone",
      Builder.<DiabolosDecimatorCloneEntity>of(DiabolosDecimatorCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(128)
         .setUpdateInterval(3)
         .setCustomClientFactory(DiabolosDecimatorCloneEntity::new)
         .fireImmune()
         .sized(1.55F, 9.8F)
   );
   public static final RegistryObject<EntityType<EntropyConduitEntity>> ENTROPY_CONDUIT = register(
      "entropy_conduit",
      Builder.<EntropyConduitEntity>of(EntropyConduitEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(120)
         .setUpdateInterval(3)
         .setCustomClientFactory(EntropyConduitEntity::new)
         .fireImmune()
         .sized(2.0F, 12.0F)
   );
   public static final RegistryObject<EntityType<GravitonShotEntity>> GRAVITON_SHOT = register(
      "graviton_shot",
      Builder.<GravitonShotEntity>of(GravitonShotEntity::new, MobCategory.MISC)
         .setCustomClientFactory(GravitonShotEntity::new)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<DiabolosShadowCloneEntity>> DIABOLOS_SHADOW_CLONE = register(
      "diabolos_shadow_clone",
      Builder.<DiabolosShadowCloneEntity>of(DiabolosShadowCloneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(100)
         .setUpdateInterval(3)
         .setCustomClientFactory(DiabolosShadowCloneEntity::new)
         .fireImmune()
         .sized(2.0F, 2.0F)
   );

   private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, Builder<T> entityTypeBuilder) {
      return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      event.enqueueWork(() -> {
         SpiderMothDwellerEntity.init();
         SpiderMothLarvaeEntity.init();
         TeleportGhostEntity.init();
         MothShadowCloneEntity.init();
         SpiderLarvaeEntity.init();
         SpiderLarvaeTinyEntity.init();
         LongLegsEntity.init();
         LongLegsTinyEntity.init();
         DwellerSleepSpawnerEntity.init();
         CentipedeStalkerEntity.init();
         BloodWormEntity.init();
         BeetleTickMiteEntity.init();
         PureStalkingEntity.init();
         RushScareEntity.init();
         SpiderBroodEntity.init();
         SkyStalkerEntity.init();
         SpiderFlatEntity.init();
         CentipedeEvictorEntity.init();
         CentipedeEvictorLarvaeEntity.init();
         TinyCentipedeBreacherEntity.init();
         SpiderLurkerEntity.init();
         InvisibleStalkerEntity.init();
         SpiderFunnelEntity.init();
         WebHarnessEntity.init();
         WebFunnelEntity.init();
         SpiderGoliathEntity.init();
         SilverfishSpectreEntity.init();
         TamedTarantulaEntity.init();
         HornetHarbingerEntity.init();
         HornetHarbingerGiantEntity.init();
         MosquitoMorbidityEntity.init();
         SpiderMothSummonEntity.init();
         LongLegsFlyEntity.init();
         ScorpioidBloodlusterEntity.init();
         ScorpioidCloneEntity.init();
         ScorpioidInitialEntity.init();
         SpiderMothSummonLarvaeEntity.init();
         ScorpioidChaserHallucinationEntity.init();
         RepellantEntity.init();
         AntArsonistEntity.init();
         LocustLandscourgeEntity.init();
         WebHarnessDownEntity.init();
         SpiderProwlerEntity.init();
         GiantWebEntity.init();
         SpiderJumpEntity.init();
         FlyFestererEntity.init();
         SpiderMothEntity.init();
         ScorpioidShadowCloneEntity.init();
         ButterflyBewitcherGiantEntity.init();
         MillipedeMarauderEntity.init();
         MaggotLarvaeEntity.init();
         RoachRiverspawnEntity.init();
         DraconicCloneEntity.init();
         ButterflyBewitcherEntity.init();
         DragonflyDreadnoughtEntity.init();
         VoidlasherShadowCloneEntity.init();
         SpiderSnatcherEntity.init();
         CrabConstrictorEntity.init();
         MothMoontrackerEntity.init();
         ScorpionStrikerEntity.init();
         ScorpionLarvaeEntity.init();
         RandomArPhExEntity.init();
         SmallWebEntity.init();
         SolifugeSkulkerEntity.init();
         EnormousSpiderHallucinationEntity.init();
         CrabLarvaeEntity.init();
         DraconicFlyStalkEntity.init();
         BeetleBulwarkEntity.init();
         ScarabSummonEntity.init();
         SpiderReaperEntity.init();
         DungeonTriggerEntity.init();
         AntArsonistWorkerEntity.init();
         AntArsonistSoldierEntity.init();
         AntArsonistAlateQueenEntity.init();
         AntArsonistDroneEntity.init();
         TermiteTunnelerWorkerEntity.init();
         TermiteTunnelerSoldierEntity.init();
         RandomTermiteEntity.init();
         TermiteTunnelerAlateEntity.init();
         TermiteTunnelerKingEntity.init();
         TermiteTunnelerQueenEntity.init();
         TORMENTOREntity.init();
         MantisMutilatorEntity.init();
         TormentorInitialEntity.init();
         CrawlingRandomEntity.init();
         TormentorTendrilEntity.init();
         TormentorMothSummonEntity.init();
         TormentorScorpioidSummonEntity.init();
         TormentorVoidlasherSummonEntity.init();
         TormentorSummonEntity.init();
         TormentorSphereEntity.init();
         TormentorCaterpillarEntity.init();
         TormentorLarvaeEntity.init();
         SmallTormentSphereEntity.init();
         SpiderInfestorEntity.init();
         TormentorLowDisplayEntity.init();
         TormentorLowDisplayAnimEntity.init();
         SummonSunBlastEntity.init();
         WaspNemesisEntity.init();
         SegmentedBodyEntity.init();
         ArthropleuraAbominationEntity.init();
         VenusFlytrapEntity.init();
         FlytrapEntity.init();
         SpiderAmbusherEntity.init();
         SphereAnimEntity.init();
         SlowLookTestEntity.init();
         AiToRideEntity.init();
         AiControllerEntity.init();
         AscendSphereAnimEntity.init();
         TormentorLaserEntity.init();
         WarpStaffDirectionEntity.init();
         GiantEnemySpiderEntity.init();
         InsaneModeSpawnsEntity.init();
         SpiderRecluseEntity.init();
         TormentorFlashAnimEntity.init();
         SpiderChaserHallucinationEntity.init();
         SpiderChaserHallucination2Entity.init();
         CaveWebEntity.init();
         AnyDimensionSpawnerEntity.init();
         SpiderObstructerEntity.init();
         HornetProjectileEntity.init();
         TormentorTestEntity.init();
         SpiderChaserHallucination3Entity.init();
         SpiderLungerEntity.init();
         StickBugEntity.init();
         TormentorHitboxEntity.init();
         TormentorT2Entity.init();
         TormentorT3Entity.init();
         TormentorT4Entity.init();
         TormentorT5Entity.init();
         HitboxExpanderEntity.init();
         TormentorShieldEntity.init();
         TimeDistortionWaveEntity.init();
         SpiderMatriarchEntity.init();
         SpiderMatriarchLarvaeEntity.init();
         ArachnoidTrisectorEntity.init();
         DiabolosDecimatorEntity.init();
         SpiderRecluseDisplayEntity.init();
         ArachnoidTimeCloneEntity.init();
         ArachnoidShadowCloneEntity.init();
         BlockTestEntity.init();
         NemesisProjectileEntity.init();
         SpiderSinkerEntity.init();
         DiabolosDecimatorCloneEntity.init();
         EntropyConduitEntity.init();
         DiabolosShadowCloneEntity.init();
      });
   }

   @SubscribeEvent
   public static void registerAttributes(EntityAttributeCreationEvent event) {
      event.put(DRACONIC_VOIDLASHER.get(), SpiderMothDwellerEntity.createAttributes().build());
      event.put(SPIDER_MOTH_LARVAE.get(), SpiderMothLarvaeEntity.createAttributes().build());
      event.put(TELEPORT_GHOST.get(), TeleportGhostEntity.createAttributes().build());
      event.put(MOTH_SHADOW_CLONE.get(), MothShadowCloneEntity.createAttributes().build());
      event.put(SPIDER_LARVAE.get(), SpiderLarvaeEntity.createAttributes().build());
      event.put(SPIDER_LARVAE_TINY.get(), SpiderLarvaeTinyEntity.createAttributes().build());
      event.put(LONG_LEGS.get(), LongLegsEntity.createAttributes().build());
      event.put(LONG_LEGS_TINY.get(), LongLegsTinyEntity.createAttributes().build());
      event.put(DWELLER_SLEEP_SPAWNER.get(), DwellerSleepSpawnerEntity.createAttributes().build());
      event.put(CENTIPEDE_STALKER.get(), CentipedeStalkerEntity.createAttributes().build());
      event.put(BLOOD_WORM.get(), BloodWormEntity.createAttributes().build());
      event.put(BEETLE_TICK_MITE.get(), BeetleTickMiteEntity.createAttributes().build());
      event.put(PURE_STALKING.get(), PureStalkingEntity.createAttributes().build());
      event.put(RUSH_SCARE.get(), RushScareEntity.createAttributes().build());
      event.put(SPIDER_BROOD.get(), SpiderBroodEntity.createAttributes().build());
      event.put(SKY_STALKER.get(), SkyStalkerEntity.createAttributes().build());
      event.put(SPIDER_FLAT.get(), SpiderFlatEntity.createAttributes().build());
      event.put(CENTIPEDE_EVICTOR.get(), CentipedeEvictorEntity.createAttributes().build());
      event.put(CENTIPEDE_EVICTOR_LARVAE.get(), CentipedeEvictorLarvaeEntity.createAttributes().build());
      event.put(TINY_CENTIPEDE_BREACHER.get(), TinyCentipedeBreacherEntity.createAttributes().build());
      event.put(SPIDER_LURKER.get(), SpiderLurkerEntity.createAttributes().build());
      event.put(INVISIBLE_STALKER.get(), InvisibleStalkerEntity.createAttributes().build());
      event.put(SPIDER_FUNNEL.get(), SpiderFunnelEntity.createAttributes().build());
      event.put(WEB_HARNESS.get(), WebHarnessEntity.createAttributes().build());
      event.put(WEB_FUNNEL.get(), WebFunnelEntity.createAttributes().build());
      event.put(SPIDER_GOLIATH.get(), SpiderGoliathEntity.createAttributes().build());
      event.put(SILVERFISH_SPECTRE.get(), SilverfishSpectreEntity.createAttributes().build());
      event.put(TAMED_TARANTULA.get(), TamedTarantulaEntity.createAttributes().build());
      event.put(HORNET_HARBINGER.get(), HornetHarbingerEntity.createAttributes().build());
      event.put(HORNET_HARBINGER_GIANT.get(), HornetHarbingerGiantEntity.createAttributes().build());
      event.put(MOSQUITO_MORBIDITY.get(), MosquitoMorbidityEntity.createAttributes().build());
      event.put(SPIDER_MOTH_SUMMON.get(), SpiderMothSummonEntity.createAttributes().build());
      event.put(LONG_LEGS_FLY.get(), LongLegsFlyEntity.createAttributes().build());
      event.put(SCORPIOID_BLOODLUSTER.get(), ScorpioidBloodlusterEntity.createAttributes().build());
      event.put(SCORPIOID_CLONE.get(), ScorpioidCloneEntity.createAttributes().build());
      event.put(SCORPIOID_INITIAL.get(), ScorpioidInitialEntity.createAttributes().build());
      event.put(SPIDER_MOTH_SUMMON_LARVAE.get(), SpiderMothSummonLarvaeEntity.createAttributes().build());
      event.put(SCORPIOID_CHASER_HALLUCINATION.get(), ScorpioidChaserHallucinationEntity.createAttributes().build());
      event.put(REPELLANT.get(), RepellantEntity.createAttributes().build());
      event.put(ANT_ARSONIST.get(), AntArsonistEntity.createAttributes().build());
      event.put(LOCUST_LANDSCOURGE.get(), LocustLandscourgeEntity.createAttributes().build());
      event.put(WEB_HARNESS_DOWN.get(), WebHarnessDownEntity.createAttributes().build());
      event.put(SPIDER_PROWLER.get(), SpiderProwlerEntity.createAttributes().build());
      event.put(GIANT_WEB.get(), GiantWebEntity.createAttributes().build());
      event.put(SPIDER_JUMP.get(), SpiderJumpEntity.createAttributes().build());
      event.put(FLY_FESTERER.get(), FlyFestererEntity.createAttributes().build());
      event.put(SPIDER_MOTH.get(), SpiderMothEntity.createAttributes().build());
      event.put(SCORPIOID_SHADOW_CLONE.get(), ScorpioidShadowCloneEntity.createAttributes().build());
      event.put(BUTTERFLY_BEWITCHER_GIANT.get(), ButterflyBewitcherGiantEntity.createAttributes().build());
      event.put(MILLIPEDE_MARAUDER.get(), MillipedeMarauderEntity.createAttributes().build());
      event.put(MAGGOT_LARVAE.get(), MaggotLarvaeEntity.createAttributes().build());
      event.put(ROACH_RIVERSPAWN.get(), RoachRiverspawnEntity.createAttributes().build());
      event.put(DRACONIC_CLONE.get(), DraconicCloneEntity.createAttributes().build());
      event.put(BUTTERFLY_BEWITCHER.get(), ButterflyBewitcherEntity.createAttributes().build());
      event.put(DRAGONFLY_DREADNOUGHT.get(), DragonflyDreadnoughtEntity.createAttributes().build());
      event.put(VOIDLASHER_SHADOW_CLONE.get(), VoidlasherShadowCloneEntity.createAttributes().build());
      event.put(SPIDER_SNATCHER.get(), SpiderSnatcherEntity.createAttributes().build());
      event.put(CRAB_CONSTRICTOR.get(), CrabConstrictorEntity.createAttributes().build());
      event.put(MOTH_MOONTRACKER.get(), MothMoontrackerEntity.createAttributes().build());
      event.put(SCORPION_STRIKER.get(), ScorpionStrikerEntity.createAttributes().build());
      event.put(SCORPION_LARVAE.get(), ScorpionLarvaeEntity.createAttributes().build());
      event.put(RANDOM_AR_PH_EX.get(), RandomArPhExEntity.createAttributes().build());
      event.put(SMALL_WEB.get(), SmallWebEntity.createAttributes().build());
      event.put(SOLIFUGE_SKULKER.get(), SolifugeSkulkerEntity.createAttributes().build());
      event.put(ENORMOUS_SPIDER_HALLUCINATION.get(), EnormousSpiderHallucinationEntity.createAttributes().build());
      event.put(CRAB_LARVAE.get(), CrabLarvaeEntity.createAttributes().build());
      event.put(DRACONIC_FLY_STALK.get(), DraconicFlyStalkEntity.createAttributes().build());
      event.put(BEETLE_BULWARK.get(), BeetleBulwarkEntity.createAttributes().build());
      event.put(SCARAB_SUMMON.get(), ScarabSummonEntity.createAttributes().build());
      event.put(SPIDER_REAPER.get(), SpiderReaperEntity.createAttributes().build());
      event.put(DUNGEON_TRIGGER.get(), DungeonTriggerEntity.createAttributes().build());
      event.put(ANT_ARSONIST_WORKER.get(), AntArsonistWorkerEntity.createAttributes().build());
      event.put(ANT_ARSONIST_SOLDIER.get(), AntArsonistSoldierEntity.createAttributes().build());
      event.put(ANT_ARSONIST_ALATE_QUEEN.get(), AntArsonistAlateQueenEntity.createAttributes().build());
      event.put(ANT_ARSONIST_DRONE.get(), AntArsonistDroneEntity.createAttributes().build());
      event.put(TERMITE_TUNNELER_WORKER.get(), TermiteTunnelerWorkerEntity.createAttributes().build());
      event.put(TERMITE_TUNNELER_SOLDIER.get(), TermiteTunnelerSoldierEntity.createAttributes().build());
      event.put(RANDOM_TERMITE.get(), RandomTermiteEntity.createAttributes().build());
      event.put(TERMITE_TUNNELER_ALATE.get(), TermiteTunnelerAlateEntity.createAttributes().build());
      event.put(TERMITE_TUNNELER_KING.get(), TermiteTunnelerKingEntity.createAttributes().build());
      event.put(TERMITE_TUNNELER_QUEEN.get(), TermiteTunnelerQueenEntity.createAttributes().build());
      event.put(TORMENTOR.get(), TORMENTOREntity.createAttributes().build());
      event.put(MANTIS_MUTILATOR.get(), MantisMutilatorEntity.createAttributes().build());
      event.put(TORMENTOR_INITIAL.get(), TormentorInitialEntity.createAttributes().build());
      event.put(CRAWLING_RANDOM.get(), CrawlingRandomEntity.createAttributes().build());
      event.put(TORMENTOR_TENDRIL.get(), TormentorTendrilEntity.createAttributes().build());
      event.put(TORMENTOR_MOTH_SUMMON.get(), TormentorMothSummonEntity.createAttributes().build());
      event.put(TORMENTOR_SCORPIOID_SUMMON.get(), TormentorScorpioidSummonEntity.createAttributes().build());
      event.put(TORMENTOR_VOIDLASHER_SUMMON.get(), TormentorVoidlasherSummonEntity.createAttributes().build());
      event.put(TORMENTOR_SUMMON.get(), TormentorSummonEntity.createAttributes().build());
      event.put(TORMENTOR_SPHERE.get(), TormentorSphereEntity.createAttributes().build());
      event.put(TORMENTOR_CATERPILLAR.get(), TormentorCaterpillarEntity.createAttributes().build());
      event.put(TORMENTOR_LARVAE.get(), TormentorLarvaeEntity.createAttributes().build());
      event.put(SMALL_TORMENT_SPHERE.get(), SmallTormentSphereEntity.createAttributes().build());
      event.put(SPIDER_INFESTOR.get(), SpiderInfestorEntity.createAttributes().build());
      event.put(TORMENTOR_LOW_DISPLAY.get(), TormentorLowDisplayEntity.createAttributes().build());
      event.put(TORMENTOR_LOW_DISPLAY_ANIM.get(), TormentorLowDisplayAnimEntity.createAttributes().build());
      event.put(SUMMON_SUN_BLAST.get(), SummonSunBlastEntity.createAttributes().build());
      event.put(WASP_NEMESIS.get(), WaspNemesisEntity.createAttributes().build());
      event.put(SEGMENTED_BODY.get(), SegmentedBodyEntity.createAttributes().build());
      event.put(ARTHROPLEURA_ABOMINATION.get(), ArthropleuraAbominationEntity.createAttributes().build());
      event.put(VENUS_FLYTRAP.get(), VenusFlytrapEntity.createAttributes().build());
      event.put(FLYTRAP.get(), FlytrapEntity.createAttributes().build());
      event.put(SPIDER_AMBUSHER.get(), SpiderAmbusherEntity.createAttributes().build());
      event.put(SPHERE_ANIM.get(), SphereAnimEntity.createAttributes().build());
      event.put(SLOW_LOOK_TEST.get(), SlowLookTestEntity.createAttributes().build());
      event.put(AI_TO_RIDE.get(), AiToRideEntity.createAttributes().build());
      event.put(AI_CONTROLLER.get(), AiControllerEntity.createAttributes().build());
      event.put(ASCEND_SPHERE_ANIM.get(), AscendSphereAnimEntity.createAttributes().build());
      event.put(TORMENTOR_LASER.get(), TormentorLaserEntity.createAttributes().build());
      event.put(WARP_STAFF_DIRECTION.get(), WarpStaffDirectionEntity.createAttributes().build());
      event.put(GIANT_ENEMY_SPIDER.get(), GiantEnemySpiderEntity.createAttributes().build());
      event.put(INSANE_MODE_SPAWNS.get(), InsaneModeSpawnsEntity.createAttributes().build());
      event.put(SPIDER_RECLUSE.get(), SpiderRecluseEntity.createAttributes().build());
      event.put(TORMENTOR_FLASH_ANIM.get(), TormentorFlashAnimEntity.createAttributes().build());
      event.put(SPIDER_CHASER_HALLUCINATION.get(), SpiderChaserHallucinationEntity.createAttributes().build());
      event.put(SPIDER_CHASER_HALLUCINATION_2.get(), SpiderChaserHallucination2Entity.createAttributes().build());
      event.put(CAVE_WEB.get(), CaveWebEntity.createAttributes().build());
      event.put(ANY_DIMENSION_SPAWNER.get(), AnyDimensionSpawnerEntity.createAttributes().build());
      event.put(SPIDER_OBSTRUCTER.get(), SpiderObstructerEntity.createAttributes().build());
      event.put(HORNET_PROJECTILE.get(), HornetProjectileEntity.createAttributes().build());
      event.put(TORMENTOR_TEST.get(), TormentorTestEntity.createAttributes().build());
      event.put(SPIDER_CHASER_HALLUCINATION_3.get(), SpiderChaserHallucination3Entity.createAttributes().build());
      event.put(SPIDER_LUNGER.get(), SpiderLungerEntity.createAttributes().build());
      event.put(STICK_BUG.get(), StickBugEntity.createAttributes().build());
      event.put(TORMENTOR_HITBOX.get(), TormentorHitboxEntity.createAttributes().build());
      event.put(TORMENTOR_T_2.get(), TormentorT2Entity.createAttributes().build());
      event.put(TORMENTOR_T_3.get(), TormentorT3Entity.createAttributes().build());
      event.put(TORMENTOR_T_4.get(), TormentorT4Entity.createAttributes().build());
      event.put(TORMENTOR_T_5.get(), TormentorT5Entity.createAttributes().build());
      event.put(HITBOX_EXPANDER.get(), HitboxExpanderEntity.createAttributes().build());
      event.put(TORMENTOR_SHIELD.get(), TormentorShieldEntity.createAttributes().build());
      event.put(TIME_DISTORTION_WAVE.get(), TimeDistortionWaveEntity.createAttributes().build());
      event.put(SPIDER_MATRIARCH.get(), SpiderMatriarchEntity.createAttributes().build());
      event.put(SPIDER_MATRIARCH_LARVAE.get(), SpiderMatriarchLarvaeEntity.createAttributes().build());
      event.put(ARACHNOID_TRISECTOR.get(), ArachnoidTrisectorEntity.createAttributes().build());
      event.put(DIABOLOS_DECIMATOR.get(), DiabolosDecimatorEntity.createAttributes().build());
      event.put(SPIDER_RECLUSE_DISPLAY.get(), SpiderRecluseDisplayEntity.createAttributes().build());
      event.put(ARACHNOID_TIME_CLONE.get(), ArachnoidTimeCloneEntity.createAttributes().build());
      event.put(ARACHNOID_SHADOW_CLONE.get(), ArachnoidShadowCloneEntity.createAttributes().build());
      event.put(BLOCK_TEST.get(), BlockTestEntity.createAttributes().build());
      event.put(NEMESIS_PROJECTILE.get(), NemesisProjectileEntity.createAttributes().build());
      event.put(SPIDER_SINKER.get(), SpiderSinkerEntity.createAttributes().build());
      event.put(DIABOLOS_DECIMATOR_CLONE.get(), DiabolosDecimatorCloneEntity.createAttributes().build());
      event.put(ENTROPY_CONDUIT.get(), EntropyConduitEntity.createAttributes().build());
      event.put(DIABOLOS_SHADOW_CLONE.get(), DiabolosShadowCloneEntity.createAttributes().build());
   }
}
