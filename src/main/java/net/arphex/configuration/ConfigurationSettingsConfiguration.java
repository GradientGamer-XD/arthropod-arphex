package net.arphex.configuration;

import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ConfigurationSettingsConfiguration {
   public static final Builder BUILDER = new Builder();
   public static final ForgeConfigSpec SPEC = BUILDER.build();
   public static final ConfigValue<Boolean> DWELLERS_REQUIRE_WEATHER = BUILDER.comment(
         "This controls whether all boss versions will require specific weather conditions to spawn. Without this, they will appear much more frequently. "
      )
      .define("Bosses require weather?", true);
   public static final ConfigValue<Boolean> SPAWN_DWELLERS_NATURALLY = BUILDER.comment(
         "Do you want the boss and clone versions to spawn naturally, or only from summoning structures?"
      )
      .define("Boss natural spawning", true);
   public static final ConfigValue<Double> DWELLERS_FREQUENCY = BUILDER.comment(
         "Bosses and variant spawns are rare by default. 1=twice as common. 2=default rarity. 3=twice as rare. 4=three times rarer. Avoid decimal and negative numbers."
      )
      .define("Boss rarity", 2.0);
   public static final ConfigValue<Boolean> DWELLERS_INCLUSION = BUILDER.comment(
         "This controls whether the stalker bosses (spider moth, scorpioid bloodluster, draconic voidlasher, tormentor) are included in general. Set to false if you only want the other mobs, and the bosses will become unable to be spawned in any way."
      )
      .define("Boss inclusion", true);
   public static final ConfigValue<Double> NON_BOSS_SPAWNRATE = BUILDER.comment(
         "Controls the vanilla biome-specific spawnrates of ALL non-boss mobs in this mod, including minibosses and all regular arthropods. Default multiplier value is 5. You could more than double the ArPhEx spawnrates by setting it to 2 or 1. Lower values = more spawns (minimum value is 1). No maximum rarity. Avoid decimal and negative numbers."
      )
      .define("Non-boss global spawnrates (biome-specific)", 5.0);
   public static final ConfigValue<Double> RANDOM_SYSTEM_SPAWNS = BUILDER.comment(
         "ArPhEx has an additional spawning system that gives a 1 in (10) chance to spawn a random ArPhEx mob each time the natural spawn triggers. This system allows ArPhEx mobs to spawn in any non-vanilla overworld biomes, while still accounting for mob rarity. Default number is 5, meaning it has a 1 in 5 chance to spawn each time. Setting it to 0 disables the additional spawning system entirely. Avoid decimal and negative numbers."
      )
      .define("Random-system spawnrates (not biome-specific)", 5.0);
   public static final ConfigValue<Boolean> ALL_ENTITY_INCLUSION = BUILDER.comment(
         "This value controls whether ArPhEx entities are included in general. Setting to false makes it impossible to spawn ArPhEx mobs, while keeping the items as usual. "
      )
      .define("All entities enabled/disabled", true);
   public static final ConfigValue<Double> MAX_ANTS = BUILDER.comment("Maximum colony tamed ants per player (furthest ants despawn, 20 default)")
      .define("Max tamed ants per player", 20.0);
   public static final ConfigValue<Boolean> CRAWLING_ONLY = BUILDER.comment(
         "Option to limit all natural ArPhEx spawning to the Crawling dimension. Note that you won't be able to craft a crawling compass, so a mod like traveller's compass is recommended"
      )
      .define("Crawling-restrict all mobs", false);
   public static final ConfigValue<Boolean> DISABLE_TORMENTOR = BUILDER.comment(
         "Specifically disables the Tormentor boss entirely. It will be unable to be spawned in any form if this is enabled."
      )
      .define("Disable Tormentor", false);
   public static final ConfigValue<Boolean> ANY_DIMENSION = BUILDER.comment(
         "Disabled by default. If enabled, most mobs will become able to spawn in any dimension, including dimensions from other mods - may cause issues with some mod dimensions. Note, however, that the mobs will have a low spawn weight in other dimensions."
      )
      .define("Spawn in other dimensions", false);
   public static final ConfigValue<Boolean> TORMENTOR_INITIAL_SPAWNING = BUILDER.comment(
         "By default, the Tormentor can spawn naturally once you defeat the first three bosses. At this point, you probably won't be ready yet to fight it, and so will be forced to seal it and locate a crawling portal (all intentional). Set to false to prevent this, and ensure the Tormentor can only spawn from being summoned. The earlier - Boss natural spawning - config option has the same effect, but also controls other bosses."
      )
      .define("Tormentor initial natural spawning", true);
   public static final ConfigValue<Boolean> INSANITY_MODE = BUILDER.comment(
         "Enabling this will significantly amplfy random-system overworld spawns from the mod, and even add crawling dimension mobs like the spider ambusher into the overworld. Even the non-overworld bosses will spawn rarely in the overworld, except for the Tormentor (this must be summoned manually). Minibosses will spawn commonly. Perfect for fast-paced, intense gameplay!"
      )
      .define("Insanity Mode", false);
   public static final ConfigValue<List<? extends String>> DISABLE_SPECIFIC_MOBS = BUILDER.comment(
         "List IDs of any mobs you'd like to disable from the mod, separated by commas. You can find a mob's ID with the /summon command, but note that the arphex: part is not needed, and that this disables mobs completely from being spawned in any way, including existing mobs on world reload. Works on virtually all types of entities from the mod"
      )
      .defineList("Disable Specific Mobs", List.of("mob_id", "mob_id", "mob_id (add as many as needed, e.g. spider_snatcher)"), entry -> true);
   public static final ConfigValue<Boolean> NONBOSS_HALLUCINATIONS = BUILDER.comment(
         "Enabled by default - controls whether non-boss hallucinations (like the spider ones) can spawn. Boss hallucinations are controlled by boss spawning."
      )
      .define("Enable non-boss hallucination spawning", true);
   public static final ConfigValue<Double> VANILLA_REPLACEMENT_MODE = BUILDER.comment(
         "If you're not getting enough spawns from the other spawn settings, you can boost them even further with this mode at the cost of reducing vanilla mob spawns on solid ground (potential performance impact). Replaces X in 10 vanilla mobs with a random arphex mob. If insanity mode is enabled, it will replace them with random insanity mode mobs (can include crawling dimension mobs). Therefore, if you set this value to 10.0, it will replace 10/10 (100%) of vanilla mobs with random arphex equivalents. 1.0 by default"
      )
      .define("Vanilla Replacement Mode", 1.0);
   public static final ConfigValue<Boolean> FRIENDLY_REPLACEMENTS = BUILDER.comment(
         "Will only work if Vanilla Replacement Mode has a value above 0. If you enable this as well, even vanilla animal mobs have a chance to be replaced."
      )
      .define("Vanilla Animal Replacements", false);
   public static final ConfigValue<Boolean> DWELLER_HEALTH = BUILDER.comment(
         "By default, the stalker bosses have hundreds of health points. Choose true to decrease their maximum to just 60 health. Avoid decimal and negative numbers."
      )
      .define("Boss easy-mode", false);
   public static final ConfigValue<Double> OVERALL_DIFFICULTY = BUILDER.comment(
         "Can increase damage for most ArPhEx mob, miniboss, and boss attacks. Affects their ranged projectiles too. Default value is 0. Positive values will give that level of strength to all arphex mobs. Avoid decimal and negative numbers, upper limit is 256. Does not affect Tormentor fight significantly."
      )
      .define("Extra Difficulty Control", 0.0);
   public static final ConfigValue<Double> OVERALL_DIFFICULTY_LOWER = BUILDER.comment(
         "Can lower damage for most ArPhEx mob, miniboss, and boss attacks. Affects their ranged projectiles too. Default value is 0. Positive values will give that level of weakness to all arphex mobs. Avoid decimal and negative numbers, upper limit is 256. Does not affect Tormentor fight significantly."
      )
      .define("Lower Difficulty Control", 0.0);
   public static final ConfigValue<Double> TORMENTOR_MAX_HEALTH = BUILDER.comment(
         "Option to make the TORMENTOR weaker by lowering its max heath to any specific value. Default and maximum value is 1024."
      )
      .define("Tormentor Max Health", 1024.0);
   public static final ConfigValue<Double> TORMENTOR_HIT_SPEED = BUILDER.comment(
         "Value is in ticks. Since 20 ticks equate to a second, the default 25 ticks gives the Tormentor 1.25 seconds of immunity after each time it takes damage."
      )
      .define("Tormentor Damage Speed Limit", 20.0);
   public static final ConfigValue<Boolean> FRIENDLY_MODE = BUILDER.comment(
         "With this mode enabled, all mobs from the mod become unable to target players for attack! For more peaceful gameplay, this is valuable. Full bosses such as the Tormentor and Voidlasher may not follow this setting entirely, so you may want to disable them if using this setting"
      )
      .define("Friendly Mode", false);
   public static final ConfigValue<Double> TORMENTOR_FOLLOW_SPEED = BUILDER.comment(
         "The Tormentor is an omnipresent eldritch god, so it follows you fast. However, you can change the percentage distance of teleportations to target here. 25% of the distance to target per teleportation by default, choose any percentage from 0-100% here"
      )
      .define("Tormentor Follow Speed", 25.0);
   public static final ConfigValue<Boolean> END_ACCESS_CRAWLING = BUILDER.comment(
         "Set to false to disable gateways that lead to the end from the crawling (33% of exit portals)."
      )
      .define("Include End Access from Crawling", true);
   public static final ConfigValue<Double> RESISTANCE_CONTROL = BUILDER.comment(
         "This control enables you to give a resistance potion effect to all arphex mobs. None by default, resistance 5+ would mean mobs are invincible"
      )
      .define("ArPhEx resistance effects", 0.0);
   public static final ConfigValue<Boolean> WELCOME_MESSAGE = BUILDER.comment(
         "When you join a world for the first time with ArPhEx installed, it shows a welcome message, informing you about the wiki and showing that the mod is active. Set to false to disable."
      )
      .define("Welcome message", true);
   public static final ConfigValue<Boolean> STRUCTURE_GENERATION = BUILDER.comment(
         "Allow structure generations? Without them you will need to cheat to access the lower Crawling dimension layers or get ant colonies and termite-related items. Some tiny elements may still generate."
      )
      .define("Structure generation toggle", true);
   public static final ConfigValue<Boolean> SPECIAL_TORMENTOR_RENDERING = BUILDER.comment(
         "Keep enabled if you want to use the bonus rendering system for the Tormentor, featuring modified fog distance and a giant portal over the top of the entity"
      )
      .define("Special Tormentor rendering", true);
   public static final ConfigValue<Double> LIMIT_TORMENTED_WRATH = BUILDER.comment(
         "The Tormented Wrath is an explosive post-Tormentor weapon that can shoot more and more powerful explosives the more times its user has killed the final Tormentor boss. You can limit the charge level here (default is 200, matching with the maximum amount of Tormentor kills that can be registered)"
      )
      .define("Limit Tormented Wrath Power", 100.0);
   public static final ConfigValue<Boolean> ALLOW_ETHEREAL_WALL_BYPASS = BUILDER.comment(
         "Disable to limit the staff's ability to walk through walls if it breaks something in your map or modpack"
      )
      .define("Allow Ethereal Staff wall bypassing", true);
   public static final ConfigValue<Boolean> ANT_QUEEN_OUTSIDE_DAMAGE = BUILDER.comment(
         "To encourage players to build a den for their ant queens, the queens are required to be under a roof, or take damage otherwise. Set to false to disable the damage"
      )
      .define("Ant Queen outside damage", true);
   public static final ConfigValue<Boolean> TORMENTOR_PARTICLES = BUILDER.comment(
         "Set to false to disable the Tormentor's cloud of particles. These can have a significant performance hit for some users."
      )
      .define("Tormentor Particles", true);
   public static final ConfigValue<Boolean> TORMENTOR_SHADERS = BUILDER.comment(
         "Enable Tormentor's ability to add blurring and desaturation shaders when Tormenting"
      )
      .define("Tormentor Shaders", true);
   public static final ConfigValue<List<? extends String>> BONUS_TORMENTOR_CHAT = BUILDER.comment(
         "The Tormentor can occasionally respond to chat messages that mention its name, using a random threatening line. There are 32 built-in messages. You can add your own below, one per line. Each custom entry you add reduces the chance of using a built-in line. If you list 32 or more custom messages, only your custom responses will ever be used."
      )
      .defineList("Bonus Tormentor Chat Messages", List.of("I am here, mortal", "Your torment is inevitable"), entry -> true);
   public static final ConfigValue<Double> TORMENTOR_RESPONSE_CHANCE = BUILDER.comment(
         "When the tormentor responds to a chat message, it has a 50% chance to cooldown. This config option lets you choose how many seconds it would cooldown for"
      )
      .define("Tormentor Response Cooldown", 2400.0);
   public static final ConfigValue<Boolean> ARPHEX_GRIEFING = BUILDER.comment(
         "Set to false to disable mobs like locusts from breaking crops, and minibosses/bosses from breaking leaves. Does not affect tamed ant commands, or the Tormentor's attacks"
      )
      .define("ArPhEx Griefing", true);
   public static final ConfigValue<Boolean> TORMENTOR_GRIEFING = BUILDER.comment(
         "Set to false to disable explosions from the final Tormentor boss' attacks - note that it only attacks if attacked first, and won't target players who died within the last minute, so its terrain damage can be localised to specific areas or avoided entirely with flight."
      )
      .define("Tormentor Griefing", true);
   public static final ConfigValue<Boolean> CRAWLING_CASTLE_SURFACE = BUILDER.comment(
         "Enables the Crawling Castle to generate on the world surface if enabled - otherwise generates underground"
      )
      .define("Crawling Castle Surface", true);
   public static final ConfigValue<Boolean> ARPHEX_ITEM_GRIEFING = BUILDER.comment(
         "Option to disable destructive block breaking from destructive weapons like the Tormented Wrath and Genesis Rifle"
      )
      .define("Arphex Item Griefing", true);
   public static final ConfigValue<Boolean> ARPHEX_BLOCK_GRIEFING = BUILDER.comment(
         "Set to false to disable the Temporospatial Transmitter item's mass block placing abilities - an endgame tool that lets you place up to 64 blocks at once from whatever blocks you have in off-hand. May cause issues in some servers or maps"
      )
      .define("Arphex Block Griefing", true);
   public static final ConfigValue<Boolean> SPACETIME_FLIGHT_VIEW_TILT = BUILDER.comment(
         "Set to false to disable (may cause nausea for some, especially in VR)"
      )
      .define("Spacetime Flight View Tilt", true);
   public static final ConfigValue<Boolean> SHOW_BOSS_POPUP_SCARES = BUILDER.comment(
         "Toggle to false to disable the flash popups of bosses that appear when they spawn nearby or kill any entity."
      )
      .define("Show Boss Scare Popups", true);
   public static final ConfigValue<Boolean> DROP_TROPHIES = BUILDER.comment("Set to false to disable mob kill milestone trophies from dropping")
      .define("Drop Trophies Naturally", true);
   public static final ConfigValue<Boolean> TORMENTOR_SKY_RENDER = BUILDER.comment(
         "By default, the Tormentor can render itself at night during full moons, high in the sky as a bonus scare. Set to false to disable"
      )
      .define("Enable Tormentor Sky Hallucination", true);

   static {
      BUILDER.push("Spawning");
      BUILDER.pop();
      BUILDER.push("Difficulty");
      BUILDER.pop();
      BUILDER.push("Other");
      BUILDER.pop();
   }
}
