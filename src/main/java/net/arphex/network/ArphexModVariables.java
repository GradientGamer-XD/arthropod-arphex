package net.arphex.network;

import java.util.function.Supplier;
import net.arphex.ArphexMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class ArphexModVariables {
   public static final Capability<ArphexModVariables.PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(
      new CapabilityToken<ArphexModVariables.PlayerVariables>() {
      }
   );

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      ArphexMod.addNetworkMessage(
         ArphexModVariables.SavedDataSyncMessage.class,
         ArphexModVariables.SavedDataSyncMessage::buffer,
         ArphexModVariables.SavedDataSyncMessage::new,
         ArphexModVariables.SavedDataSyncMessage::handler
      );
      ArphexMod.addNetworkMessage(
         ArphexModVariables.PlayerVariablesSyncMessage.class,
         ArphexModVariables.PlayerVariablesSyncMessage::buffer,
         ArphexModVariables.PlayerVariablesSyncMessage::new,
         ArphexModVariables.PlayerVariablesSyncMessage::handler
      );
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.register(ArphexModVariables.PlayerVariables.class);
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      @SubscribeEvent
      public static void onPlayerLoggedInSyncPlayerVariables(PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            ((ArphexModVariables.PlayerVariables)event.getEntity()
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .syncPlayerVariables(event.getEntity());
         }
      }

      @SubscribeEvent
      public static void onPlayerRespawnedSyncPlayerVariables(PlayerRespawnEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            ((ArphexModVariables.PlayerVariables)event.getEntity()
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .syncPlayerVariables(event.getEntity());
         }
      }

      @SubscribeEvent
      public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            ((ArphexModVariables.PlayerVariables)event.getEntity()
                  .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new ArphexModVariables.PlayerVariables()))
               .syncPlayerVariables(event.getEntity());
         }
      }

      @SubscribeEvent
      public static void clonePlayer(Clone event) {
         event.getOriginal().revive();
         ArphexModVariables.PlayerVariables original = (ArphexModVariables.PlayerVariables)event.getOriginal()
            .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
            .orElse(new ArphexModVariables.PlayerVariables());
         ArphexModVariables.PlayerVariables clone = (ArphexModVariables.PlayerVariables)event.getEntity()
            .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
            .orElse(new ArphexModVariables.PlayerVariables());
         clone.mothsurvivals = original.mothsurvivals;
         clone.mothtamer = original.mothtamer;
         clone.saturationclock = original.saturationclock;
         clone.killedscorpioid = original.killedscorpioid;
         clone.killedvoidlasher = original.killedvoidlasher;
         clone.abyssfly = original.abyssfly;
         clone.ownedantsnear = original.ownedantsnear;
         clone.pocketdimensionx = original.pocketdimensionx;
         clone.shadertime = original.shadertime;
         clone.tormentor_respite = original.tormentor_respite;
         clone.recently_attacked_tormentor = original.recently_attacked_tormentor;
         clone.torment_cycle = original.torment_cycle;
         clone.torment_mode = original.torment_mode;
         clone.killedtormentor = original.killedtormentor;
         clone.moth_summon_active = original.moth_summon_active;
         clone.tormentor_summon_active = original.tormentor_summon_active;
         clone.smshealth = original.smshealth;
         clone.tmshealth = original.tmshealth;
         clone.track_warp_cooldown = original.track_warp_cooldown;
         clone.tormentorjustdiednearby = original.tormentorjustdiednearby;
         clone.inherent_power_cooldown = original.inherent_power_cooldown;
         clone.player_persistent_patreon_torversion = original.player_persistent_patreon_torversion;
         clone.alternate_render = original.alternate_render;
         clone.patreon_done = original.patreon_done;
         clone.power_shield_cooldown = original.power_shield_cooldown;
         clone.shield_power_unlocked = original.shield_power_unlocked;
         clone.power_slam_cooldown = original.power_slam_cooldown;
         clone.slam_power_unlocked = original.slam_power_unlocked;
         if (!event.isWasDeath()) {
            clone.ShowOverlay = original.ShowOverlay;
            clone.ShowOverlay2 = original.ShowOverlay2;
            clone.holdingspace = original.holdingspace;
            clone.holdleftclick = original.holdleftclick;
            clone.ShowOverlay3 = original.ShowOverlay3;
            clone.doublejumpcool = original.doublejumpcool;
            clone.arphexcompass = original.arphexcompass;
            clone.arphexanglevsyaw = original.arphexanglevsyaw;
            clone.arphextriangx = original.arphextriangx;
            clone.arphextriangz = original.arphextriangz;
            clone.tamedants = original.tamedants;
            clone.show_tormentor_overlay = original.show_tormentor_overlay;
            clone.totemfatigue = original.totemfatigue;
            clone.time_in_portal = original.time_in_portal;
            clone.player_dimension = original.player_dimension;
            clone.tormentor_long_range_anim = original.tormentor_long_range_anim;
            clone.player_overlay = original.player_overlay;
            clone.fov_smoothen = original.fov_smoothen;
            clone.overlay_white = original.overlay_white;
            clone.wrath_charge_time = original.wrath_charge_time;
            clone.overlay_black = original.overlay_black;
            clone.sphere_near = original.sphere_near;
            clone.laser_emitter_near = original.laser_emitter_near;
            clone.overlay_red = original.overlay_red;
            clone.tormentor_render = original.tormentor_render;
            clone.shader2 = original.shader2;
            clone.tormentor_overlay_anim = original.tormentor_overlay_anim;
            clone.crawling_color_cycle = original.crawling_color_cycle;
            clone.immortal_near = original.immortal_near;
            clone.power_press = original.power_press;
            clone.power_unset = original.power_unset;
            clone.torment_intensity = original.torment_intensity;
            clone.spacetime_tilt = original.spacetime_tilt;
            clone.current_ascendant = original.current_ascendant;
            clone.asc_x = original.asc_x;
            clone.asc_y = original.asc_y;
            clone.asc_z = original.asc_z;
            clone.asc_subchain = original.asc_subchain;
            clone.current_player_dimenson = original.current_player_dimenson;
            clone.ShowOverlay4 = original.ShowOverlay4;
            clone.ShowOverlay5 = original.ShowOverlay5;
            clone.overlay_purple = original.overlay_purple;
            clone.overlay_green = original.overlay_green;
            clone.overlay_solid_black = original.overlay_solid_black;
            clone.just_right_clicked = original.just_right_clicked;
         }
      }

      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData mapdata = ArphexModVariables.MapVariables.get(event.getEntity().level());
            SavedData worlddata = ArphexModVariables.WorldVariables.get(event.getEntity().level());
            if (mapdata != null) {
               ArphexMod.PACKET_HANDLER
                  .send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new ArphexModVariables.SavedDataSyncMessage(0, mapdata));
            }

            if (worlddata != null) {
               ArphexMod.PACKET_HANDLER
                  .send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new ArphexModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }
      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData worlddata = ArphexModVariables.WorldVariables.get(event.getEntity().level());
            if (worlddata != null) {
               ArphexMod.PACKET_HANDLER
                  .send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new ArphexModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "arphex_mapvars";
      public String LookScareLock = "\"\"";
      public double attackcycle = 0.0;
      public String slightrandom = "\"\"";
      public double clonesize = 0.0;
      public boolean onetimesplash = false;
      public double pocket_dimension_count = -10.0;
      public String tormentor_target_follow = "empty";
      public double tormentor_target_online = 0.0;
      public String tormentor_target_dimension = "\"\"";
      public double tormentor_target_x = 0.0;
      public double tormentor_target_y = 0.0;
      public double tormentor_target_z = 0.0;
      public double tormentor_health = 0.0;
      public double tormentor_x = 0.0;
      public double tormentor_y = 0.0;
      public double tormentor_z = 0.0;
      public double tormentor_entity_loaded = 0.0;
      public String bosskills = "\"\"";
      public double last_forceload_x = 0.0;
      public double last_forceload_z = 0.0;
      public String closest_tormentor_to_alignment = "\"\"";
      public boolean alternatecheck = false;
      public double tormentor_distance_as_uuid = 9.9999999E7;
      public double tormentor_countdown = 0.0;
      public String messagesequence = "\"\"";
      public double playeronlayer1 = 0.0;
      public double playeronlayer2 = 0.0;
      public double playeronlayer3 = 0.0;
      public double playeronlayer4 = 0.0;
      public boolean chunk_removal_complete = false;
      public double tormentor_rotation = 0.0;
      public boolean reload_render = false;
      public double force_unload_repeats = 0.0;
      public boolean full_tormentor_has_previously_spawned = false;
      public boolean limhit_tormentor = false;
      public boolean thunder_check = false;
      public double torchatcooldown = 0.0;
      public boolean tormentor_last_player_spawned = false;
      public boolean survival_only_breached = false;
      public boolean gem_mob_challenge = false;
      public boolean report_missing_bed = false;
      public String tormentor_animode = "\"\"";
      public double tormentor_seal_limit = 0.0;
      public double tormentor_variable_damage_limit = 0.0;
      public double tormentor_tier = 1.0;
      public double tormentor_hitbox_split = 0.0;
      public double mat_larvae_limit = 0.0;
      public boolean alternate_entity_tick = false;
      public boolean matlarave_spawncap_exceeded_toggle = false;
      public String t1_patrons_list = "\"\"";
      public String t2_patrons_list = "\"\"";
      public String t3_patrons_list = "\"\"";
      public String ascend_cube_coord_list = "\"\"";
      public double slow_global_check_5s = 0.0;
      public double tormentor_shuffle_num = 0.0;
      public String tormentor_shuffle = "\"\"";
      public double tormentor_final_shuffle = 0.0;
      public String last_despawn_reasons = "\"\"";
      static ArphexModVariables.MapVariables clientSide = new ArphexModVariables.MapVariables();

      public static ArphexModVariables.MapVariables load(CompoundTag tag) {
         ArphexModVariables.MapVariables data = new ArphexModVariables.MapVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         this.LookScareLock = nbt.getString("LookScareLock");
         this.attackcycle = nbt.getDouble("attackcycle");
         this.slightrandom = nbt.getString("slightrandom");
         this.clonesize = nbt.getDouble("clonesize");
         this.onetimesplash = nbt.getBoolean("onetimesplash");
         this.pocket_dimension_count = nbt.getDouble("pocket_dimension_count");
         this.tormentor_target_follow = nbt.getString("tormentor_target_follow");
         this.tormentor_target_online = nbt.getDouble("tormentor_target_online");
         this.tormentor_target_dimension = nbt.getString("tormentor_target_dimension");
         this.tormentor_target_x = nbt.getDouble("tormentor_target_x");
         this.tormentor_target_y = nbt.getDouble("tormentor_target_y");
         this.tormentor_target_z = nbt.getDouble("tormentor_target_z");
         this.tormentor_health = nbt.getDouble("tormentor_health");
         this.tormentor_x = nbt.getDouble("tormentor_x");
         this.tormentor_y = nbt.getDouble("tormentor_y");
         this.tormentor_z = nbt.getDouble("tormentor_z");
         this.tormentor_entity_loaded = nbt.getDouble("tormentor_entity_loaded");
         this.bosskills = nbt.getString("bosskills");
         this.last_forceload_x = nbt.getDouble("last_forceload_x");
         this.last_forceload_z = nbt.getDouble("last_forceload_z");
         this.closest_tormentor_to_alignment = nbt.getString("closest_tormentor_to_alignment");
         this.alternatecheck = nbt.getBoolean("alternatecheck");
         this.tormentor_distance_as_uuid = nbt.getDouble("tormentor_distance_as_uuid");
         this.tormentor_countdown = nbt.getDouble("tormentor_countdown");
         this.messagesequence = nbt.getString("messagesequence");
         this.playeronlayer1 = nbt.getDouble("playeronlayer1");
         this.playeronlayer2 = nbt.getDouble("playeronlayer2");
         this.playeronlayer3 = nbt.getDouble("playeronlayer3");
         this.playeronlayer4 = nbt.getDouble("playeronlayer4");
         this.chunk_removal_complete = nbt.getBoolean("chunk_removal_complete");
         this.tormentor_rotation = nbt.getDouble("tormentor_rotation");
         this.reload_render = nbt.getBoolean("reload_render");
         this.force_unload_repeats = nbt.getDouble("force_unload_repeats");
         this.full_tormentor_has_previously_spawned = nbt.getBoolean("full_tormentor_has_previously_spawned");
         this.limhit_tormentor = nbt.getBoolean("limhit_tormentor");
         this.thunder_check = nbt.getBoolean("thunder_check");
         this.torchatcooldown = nbt.getDouble("torchatcooldown");
         this.tormentor_last_player_spawned = nbt.getBoolean("tormentor_last_player_spawned");
         this.survival_only_breached = nbt.getBoolean("survival_only_breached");
         this.gem_mob_challenge = nbt.getBoolean("gem_mob_challenge");
         this.report_missing_bed = nbt.getBoolean("report_missing_bed");
         this.tormentor_animode = nbt.getString("tormentor_animode");
         this.tormentor_seal_limit = nbt.getDouble("tormentor_seal_limit");
         this.tormentor_variable_damage_limit = nbt.getDouble("tormentor_variable_damage_limit");
         this.tormentor_tier = nbt.getDouble("tormentor_tier");
         this.tormentor_hitbox_split = nbt.getDouble("tormentor_hitbox_split");
         this.mat_larvae_limit = nbt.getDouble("mat_larvae_limit");
         this.alternate_entity_tick = nbt.getBoolean("alternate_entity_tick");
         this.matlarave_spawncap_exceeded_toggle = nbt.getBoolean("matlarave_spawncap_exceeded_toggle");
         this.t1_patrons_list = nbt.getString("t1_patrons_list");
         this.t2_patrons_list = nbt.getString("t2_patrons_list");
         this.t3_patrons_list = nbt.getString("t3_patrons_list");
         this.ascend_cube_coord_list = nbt.getString("ascend_cube_coord_list");
         this.slow_global_check_5s = nbt.getDouble("slow_global_check_5s");
         this.tormentor_shuffle_num = nbt.getDouble("tormentor_shuffle_num");
         this.tormentor_shuffle = nbt.getString("tormentor_shuffle");
         this.tormentor_final_shuffle = nbt.getDouble("tormentor_final_shuffle");
         this.last_despawn_reasons = nbt.getString("last_despawn_reasons");
      }

      public CompoundTag save(CompoundTag nbt) {
         nbt.putString("LookScareLock", this.LookScareLock);
         nbt.putDouble("attackcycle", this.attackcycle);
         nbt.putString("slightrandom", this.slightrandom);
         nbt.putDouble("clonesize", this.clonesize);
         nbt.putBoolean("onetimesplash", this.onetimesplash);
         nbt.putDouble("pocket_dimension_count", this.pocket_dimension_count);
         nbt.putString("tormentor_target_follow", this.tormentor_target_follow);
         nbt.putDouble("tormentor_target_online", this.tormentor_target_online);
         nbt.putString("tormentor_target_dimension", this.tormentor_target_dimension);
         nbt.putDouble("tormentor_target_x", this.tormentor_target_x);
         nbt.putDouble("tormentor_target_y", this.tormentor_target_y);
         nbt.putDouble("tormentor_target_z", this.tormentor_target_z);
         nbt.putDouble("tormentor_health", this.tormentor_health);
         nbt.putDouble("tormentor_x", this.tormentor_x);
         nbt.putDouble("tormentor_y", this.tormentor_y);
         nbt.putDouble("tormentor_z", this.tormentor_z);
         nbt.putDouble("tormentor_entity_loaded", this.tormentor_entity_loaded);
         nbt.putString("bosskills", this.bosskills);
         nbt.putDouble("last_forceload_x", this.last_forceload_x);
         nbt.putDouble("last_forceload_z", this.last_forceload_z);
         nbt.putString("closest_tormentor_to_alignment", this.closest_tormentor_to_alignment);
         nbt.putBoolean("alternatecheck", this.alternatecheck);
         nbt.putDouble("tormentor_distance_as_uuid", this.tormentor_distance_as_uuid);
         nbt.putDouble("tormentor_countdown", this.tormentor_countdown);
         nbt.putString("messagesequence", this.messagesequence);
         nbt.putDouble("playeronlayer1", this.playeronlayer1);
         nbt.putDouble("playeronlayer2", this.playeronlayer2);
         nbt.putDouble("playeronlayer3", this.playeronlayer3);
         nbt.putDouble("playeronlayer4", this.playeronlayer4);
         nbt.putBoolean("chunk_removal_complete", this.chunk_removal_complete);
         nbt.putDouble("tormentor_rotation", this.tormentor_rotation);
         nbt.putBoolean("reload_render", this.reload_render);
         nbt.putDouble("force_unload_repeats", this.force_unload_repeats);
         nbt.putBoolean("full_tormentor_has_previously_spawned", this.full_tormentor_has_previously_spawned);
         nbt.putBoolean("limhit_tormentor", this.limhit_tormentor);
         nbt.putBoolean("thunder_check", this.thunder_check);
         nbt.putDouble("torchatcooldown", this.torchatcooldown);
         nbt.putBoolean("tormentor_last_player_spawned", this.tormentor_last_player_spawned);
         nbt.putBoolean("survival_only_breached", this.survival_only_breached);
         nbt.putBoolean("gem_mob_challenge", this.gem_mob_challenge);
         nbt.putBoolean("report_missing_bed", this.report_missing_bed);
         nbt.putString("tormentor_animode", this.tormentor_animode);
         nbt.putDouble("tormentor_seal_limit", this.tormentor_seal_limit);
         nbt.putDouble("tormentor_variable_damage_limit", this.tormentor_variable_damage_limit);
         nbt.putDouble("tormentor_tier", this.tormentor_tier);
         nbt.putDouble("tormentor_hitbox_split", this.tormentor_hitbox_split);
         nbt.putDouble("mat_larvae_limit", this.mat_larvae_limit);
         nbt.putBoolean("alternate_entity_tick", this.alternate_entity_tick);
         nbt.putBoolean("matlarave_spawncap_exceeded_toggle", this.matlarave_spawncap_exceeded_toggle);
         nbt.putString("t1_patrons_list", this.t1_patrons_list);
         nbt.putString("t2_patrons_list", this.t2_patrons_list);
         nbt.putString("t3_patrons_list", this.t3_patrons_list);
         nbt.putString("ascend_cube_coord_list", this.ascend_cube_coord_list);
         nbt.putDouble("slow_global_check_5s", this.slow_global_check_5s);
         nbt.putDouble("tormentor_shuffle_num", this.tormentor_shuffle_num);
         nbt.putString("tormentor_shuffle", this.tormentor_shuffle);
         nbt.putDouble("tormentor_final_shuffle", this.tormentor_final_shuffle);
         nbt.putString("last_despawn_reasons", this.last_despawn_reasons);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level && !world.isClientSide()) {
            ArphexMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new ArphexModVariables.SavedDataSyncMessage(0, this));
         }
      }

      public static ArphexModVariables.MapVariables get(LevelAccessor world) {
         return world instanceof ServerLevelAccessor serverLevelAcc
            ? (ArphexModVariables.MapVariables)serverLevelAcc.getLevel()
               .getServer()
               .getLevel(Level.OVERWORLD)
               .getDataStorage()
               .computeIfAbsent(e -> load(e), ArphexModVariables.MapVariables::new, "arphex_mapvars")
            : clientSide;
      }
   }

   public static class PlayerVariables {
      public String ShowOverlay = "\"\"";
      public double mothsurvivals = 0.0;
      public boolean mothtamer = false;
      public String ShowOverlay2 = "\"\"";
      public double saturationclock = 0.0;
      public boolean killedscorpioid = false;
      public boolean holdingspace = false;
      public boolean holdleftclick = false;
      public boolean killedvoidlasher = false;
      public String ShowOverlay3 = "\"\"";
      public boolean abyssfly = false;
      public double doublejumpcool = 0.0;
      public double arphexcompass = 0.0;
      public double arphexanglevsyaw = 0.0;
      public double arphextriangx = 0.0;
      public double arphextriangz = 0.0;
      public double ownedantsnear = 0.0;
      public double tamedants = 0.0;
      public double pocketdimensionx = 0.0;
      public double shadertime = 0.0;
      public boolean show_tormentor_overlay = false;
      public boolean totemfatigue = false;
      public double time_in_portal = 0.0;
      public double tormentor_respite = 0.0;
      public double recently_attacked_tormentor = 0.0;
      public double torment_cycle = 0.0;
      public String torment_mode = "\"\"";
      public double killedtormentor = 0.0;
      public double moth_summon_active = 0.0;
      public double tormentor_summon_active = 0.0;
      public double smshealth = 0.0;
      public double tmshealth = 0.0;
      public String player_dimension = "\"\"";
      public boolean tormentor_long_range_anim = false;
      public boolean player_overlay = false;
      public double fov_smoothen = 0.0;
      public double overlay_white = 0.0;
      public double wrath_charge_time = 0.0;
      public double overlay_black = 0.0;
      public double sphere_near = 0.0;
      public double laser_emitter_near = 0.0;
      public double overlay_red = 0.0;
      public double tormentor_render = 0.0;
      public double shader2 = 0.0;
      public double tormentor_overlay_anim = 0.0;
      public double track_warp_cooldown = 0.0;
      public double crawling_color_cycle = 0.0;
      public double tormentorjustdiednearby = 0.0;
      public double immortal_near = 0.0;
      public boolean power_press = false;
      public double inherent_power_cooldown = 0.0;
      public boolean power_unset = false;
      public double torment_intensity = 0.0;
      public double spacetime_tilt = 0.0;
      public double player_persistent_patreon_torversion = 0.0;
      public boolean alternate_render = false;
      public String current_ascendant = "";
      public double asc_x = 0.0;
      public double asc_y = 0.0;
      public double asc_z = 0.0;
      public String asc_subchain = "\"\"";
      public String current_player_dimenson = "\"\"";
      public boolean patreon_done = false;
      public boolean ShowOverlay4 = false;
      public double power_shield_cooldown = 0.0;
      public boolean shield_power_unlocked = false;
      public double power_slam_cooldown = 0.0;
      public boolean slam_power_unlocked = false;
      public boolean ShowOverlay5 = false;
      public double overlay_purple = 0.0;
      public double overlay_green = 0.0;
      public double overlay_solid_black = 0.0;
      public boolean just_right_clicked = false;

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer serverPlayer) {
            ArphexMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new ArphexModVariables.PlayerVariablesSyncMessage(this));
         }
      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.putString("ShowOverlay", this.ShowOverlay);
         nbt.putDouble("mothsurvivals", this.mothsurvivals);
         nbt.putBoolean("mothtamer", this.mothtamer);
         nbt.putString("ShowOverlay2", this.ShowOverlay2);
         nbt.putDouble("saturationclock", this.saturationclock);
         nbt.putBoolean("killedscorpioid", this.killedscorpioid);
         nbt.putBoolean("holdingspace", this.holdingspace);
         nbt.putBoolean("holdleftclick", this.holdleftclick);
         nbt.putBoolean("killedvoidlasher", this.killedvoidlasher);
         nbt.putString("ShowOverlay3", this.ShowOverlay3);
         nbt.putBoolean("abyssfly", this.abyssfly);
         nbt.putDouble("doublejumpcool", this.doublejumpcool);
         nbt.putDouble("arphexcompass", this.arphexcompass);
         nbt.putDouble("arphexanglevsyaw", this.arphexanglevsyaw);
         nbt.putDouble("arphextriangx", this.arphextriangx);
         nbt.putDouble("arphextriangz", this.arphextriangz);
         nbt.putDouble("ownedantsnear", this.ownedantsnear);
         nbt.putDouble("tamedants", this.tamedants);
         nbt.putDouble("pocketdimensionx", this.pocketdimensionx);
         nbt.putDouble("shadertime", this.shadertime);
         nbt.putBoolean("show_tormentor_overlay", this.show_tormentor_overlay);
         nbt.putBoolean("totemfatigue", this.totemfatigue);
         nbt.putDouble("time_in_portal", this.time_in_portal);
         nbt.putDouble("tormentor_respite", this.tormentor_respite);
         nbt.putDouble("recently_attacked_tormentor", this.recently_attacked_tormentor);
         nbt.putDouble("torment_cycle", this.torment_cycle);
         nbt.putString("torment_mode", this.torment_mode);
         nbt.putDouble("killedtormentor", this.killedtormentor);
         nbt.putDouble("moth_summon_active", this.moth_summon_active);
         nbt.putDouble("tormentor_summon_active", this.tormentor_summon_active);
         nbt.putDouble("smshealth", this.smshealth);
         nbt.putDouble("tmshealth", this.tmshealth);
         nbt.putString("player_dimension", this.player_dimension);
         nbt.putBoolean("tormentor_long_range_anim", this.tormentor_long_range_anim);
         nbt.putBoolean("player_overlay", this.player_overlay);
         nbt.putDouble("fov_smoothen", this.fov_smoothen);
         nbt.putDouble("overlay_white", this.overlay_white);
         nbt.putDouble("wrath_charge_time", this.wrath_charge_time);
         nbt.putDouble("overlay_black", this.overlay_black);
         nbt.putDouble("sphere_near", this.sphere_near);
         nbt.putDouble("laser_emitter_near", this.laser_emitter_near);
         nbt.putDouble("overlay_red", this.overlay_red);
         nbt.putDouble("tormentor_render", this.tormentor_render);
         nbt.putDouble("shader2", this.shader2);
         nbt.putDouble("tormentor_overlay_anim", this.tormentor_overlay_anim);
         nbt.putDouble("track_warp_cooldown", this.track_warp_cooldown);
         nbt.putDouble("crawling_color_cycle", this.crawling_color_cycle);
         nbt.putDouble("tormentorjustdiednearby", this.tormentorjustdiednearby);
         nbt.putDouble("immortal_near", this.immortal_near);
         nbt.putBoolean("power_press", this.power_press);
         nbt.putDouble("inherent_power_cooldown", this.inherent_power_cooldown);
         nbt.putBoolean("power_unset", this.power_unset);
         nbt.putDouble("torment_intensity", this.torment_intensity);
         nbt.putDouble("spacetime_tilt", this.spacetime_tilt);
         nbt.putDouble("player_persistent_patreon_torversion", this.player_persistent_patreon_torversion);
         nbt.putBoolean("alternate_render", this.alternate_render);
         nbt.putString("current_ascendant", this.current_ascendant);
         nbt.putDouble("asc_x", this.asc_x);
         nbt.putDouble("asc_y", this.asc_y);
         nbt.putDouble("asc_z", this.asc_z);
         nbt.putString("asc_subchain", this.asc_subchain);
         nbt.putString("current_player_dimenson", this.current_player_dimenson);
         nbt.putBoolean("patreon_done", this.patreon_done);
         nbt.putBoolean("ShowOverlay4", this.ShowOverlay4);
         nbt.putDouble("power_shield_cooldown", this.power_shield_cooldown);
         nbt.putBoolean("shield_power_unlocked", this.shield_power_unlocked);
         nbt.putDouble("power_slam_cooldown", this.power_slam_cooldown);
         nbt.putBoolean("slam_power_unlocked", this.slam_power_unlocked);
         nbt.putBoolean("ShowOverlay5", this.ShowOverlay5);
         nbt.putDouble("overlay_purple", this.overlay_purple);
         nbt.putDouble("overlay_green", this.overlay_green);
         nbt.putDouble("overlay_solid_black", this.overlay_solid_black);
         nbt.putBoolean("just_right_clicked", this.just_right_clicked);
         return nbt;
      }

      public void readNBT(Tag tag) {
         CompoundTag nbt = (CompoundTag)tag;
         this.ShowOverlay = nbt.getString("ShowOverlay");
         this.mothsurvivals = nbt.getDouble("mothsurvivals");
         this.mothtamer = nbt.getBoolean("mothtamer");
         this.ShowOverlay2 = nbt.getString("ShowOverlay2");
         this.saturationclock = nbt.getDouble("saturationclock");
         this.killedscorpioid = nbt.getBoolean("killedscorpioid");
         this.holdingspace = nbt.getBoolean("holdingspace");
         this.holdleftclick = nbt.getBoolean("holdleftclick");
         this.killedvoidlasher = nbt.getBoolean("killedvoidlasher");
         this.ShowOverlay3 = nbt.getString("ShowOverlay3");
         this.abyssfly = nbt.getBoolean("abyssfly");
         this.doublejumpcool = nbt.getDouble("doublejumpcool");
         this.arphexcompass = nbt.getDouble("arphexcompass");
         this.arphexanglevsyaw = nbt.getDouble("arphexanglevsyaw");
         this.arphextriangx = nbt.getDouble("arphextriangx");
         this.arphextriangz = nbt.getDouble("arphextriangz");
         this.ownedantsnear = nbt.getDouble("ownedantsnear");
         this.tamedants = nbt.getDouble("tamedants");
         this.pocketdimensionx = nbt.getDouble("pocketdimensionx");
         this.shadertime = nbt.getDouble("shadertime");
         this.show_tormentor_overlay = nbt.getBoolean("show_tormentor_overlay");
         this.totemfatigue = nbt.getBoolean("totemfatigue");
         this.time_in_portal = nbt.getDouble("time_in_portal");
         this.tormentor_respite = nbt.getDouble("tormentor_respite");
         this.recently_attacked_tormentor = nbt.getDouble("recently_attacked_tormentor");
         this.torment_cycle = nbt.getDouble("torment_cycle");
         this.torment_mode = nbt.getString("torment_mode");
         this.killedtormentor = nbt.getDouble("killedtormentor");
         this.moth_summon_active = nbt.getDouble("moth_summon_active");
         this.tormentor_summon_active = nbt.getDouble("tormentor_summon_active");
         this.smshealth = nbt.getDouble("smshealth");
         this.tmshealth = nbt.getDouble("tmshealth");
         this.player_dimension = nbt.getString("player_dimension");
         this.tormentor_long_range_anim = nbt.getBoolean("tormentor_long_range_anim");
         this.player_overlay = nbt.getBoolean("player_overlay");
         this.fov_smoothen = nbt.getDouble("fov_smoothen");
         this.overlay_white = nbt.getDouble("overlay_white");
         this.wrath_charge_time = nbt.getDouble("wrath_charge_time");
         this.overlay_black = nbt.getDouble("overlay_black");
         this.sphere_near = nbt.getDouble("sphere_near");
         this.laser_emitter_near = nbt.getDouble("laser_emitter_near");
         this.overlay_red = nbt.getDouble("overlay_red");
         this.tormentor_render = nbt.getDouble("tormentor_render");
         this.shader2 = nbt.getDouble("shader2");
         this.tormentor_overlay_anim = nbt.getDouble("tormentor_overlay_anim");
         this.track_warp_cooldown = nbt.getDouble("track_warp_cooldown");
         this.crawling_color_cycle = nbt.getDouble("crawling_color_cycle");
         this.tormentorjustdiednearby = nbt.getDouble("tormentorjustdiednearby");
         this.immortal_near = nbt.getDouble("immortal_near");
         this.power_press = nbt.getBoolean("power_press");
         this.inherent_power_cooldown = nbt.getDouble("inherent_power_cooldown");
         this.power_unset = nbt.getBoolean("power_unset");
         this.torment_intensity = nbt.getDouble("torment_intensity");
         this.spacetime_tilt = nbt.getDouble("spacetime_tilt");
         this.player_persistent_patreon_torversion = nbt.getDouble("player_persistent_patreon_torversion");
         this.alternate_render = nbt.getBoolean("alternate_render");
         this.current_ascendant = nbt.getString("current_ascendant");
         this.asc_x = nbt.getDouble("asc_x");
         this.asc_y = nbt.getDouble("asc_y");
         this.asc_z = nbt.getDouble("asc_z");
         this.asc_subchain = nbt.getString("asc_subchain");
         this.current_player_dimenson = nbt.getString("current_player_dimenson");
         this.patreon_done = nbt.getBoolean("patreon_done");
         this.ShowOverlay4 = nbt.getBoolean("ShowOverlay4");
         this.power_shield_cooldown = nbt.getDouble("power_shield_cooldown");
         this.shield_power_unlocked = nbt.getBoolean("shield_power_unlocked");
         this.power_slam_cooldown = nbt.getDouble("power_slam_cooldown");
         this.slam_power_unlocked = nbt.getBoolean("slam_power_unlocked");
         this.ShowOverlay5 = nbt.getBoolean("ShowOverlay5");
         this.overlay_purple = nbt.getDouble("overlay_purple");
         this.overlay_green = nbt.getDouble("overlay_green");
         this.overlay_solid_black = nbt.getDouble("overlay_solid_black");
         this.just_right_clicked = nbt.getBoolean("just_right_clicked");
      }
   }

   @EventBusSubscriber
   private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
      private final ArphexModVariables.PlayerVariables playerVariables = new ArphexModVariables.PlayerVariables();
      private final LazyOptional<ArphexModVariables.PlayerVariables> instance = LazyOptional.of(() -> this.playerVariables);

      @SubscribeEvent
      public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
         if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(new ResourceLocation("arphex", "player_variables"), new ArphexModVariables.PlayerVariablesProvider());
         }
      }

      public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
         return cap == ArphexModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
      }

      public Tag serializeNBT() {
         return this.playerVariables.writeNBT();
      }

      public void deserializeNBT(Tag nbt) {
         this.playerVariables.readNBT(nbt);
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final ArphexModVariables.PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new ArphexModVariables.PlayerVariables();
         this.data.readNBT(buffer.readNbt());
      }

      public PlayerVariablesSyncMessage(ArphexModVariables.PlayerVariables data) {
         this.data = data;
      }

      public static void buffer(ArphexModVariables.PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeNbt((CompoundTag)message.data.writeNBT());
      }

      public static void handler(ArphexModVariables.PlayerVariablesSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(
            () -> {
               if (!context.getDirection().getReceptionSide().isServer()) {
                  ArphexModVariables.PlayerVariables variables = (ArphexModVariables.PlayerVariables)Minecraft.getInstance()
                     .player
                     .getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                     .orElse(new ArphexModVariables.PlayerVariables());
                  variables.ShowOverlay = message.data.ShowOverlay;
                  variables.mothsurvivals = message.data.mothsurvivals;
                  variables.mothtamer = message.data.mothtamer;
                  variables.ShowOverlay2 = message.data.ShowOverlay2;
                  variables.saturationclock = message.data.saturationclock;
                  variables.killedscorpioid = message.data.killedscorpioid;
                  variables.holdingspace = message.data.holdingspace;
                  variables.holdleftclick = message.data.holdleftclick;
                  variables.killedvoidlasher = message.data.killedvoidlasher;
                  variables.ShowOverlay3 = message.data.ShowOverlay3;
                  variables.abyssfly = message.data.abyssfly;
                  variables.doublejumpcool = message.data.doublejumpcool;
                  variables.arphexcompass = message.data.arphexcompass;
                  variables.arphexanglevsyaw = message.data.arphexanglevsyaw;
                  variables.arphextriangx = message.data.arphextriangx;
                  variables.arphextriangz = message.data.arphextriangz;
                  variables.ownedantsnear = message.data.ownedantsnear;
                  variables.tamedants = message.data.tamedants;
                  variables.pocketdimensionx = message.data.pocketdimensionx;
                  variables.shadertime = message.data.shadertime;
                  variables.show_tormentor_overlay = message.data.show_tormentor_overlay;
                  variables.totemfatigue = message.data.totemfatigue;
                  variables.time_in_portal = message.data.time_in_portal;
                  variables.tormentor_respite = message.data.tormentor_respite;
                  variables.recently_attacked_tormentor = message.data.recently_attacked_tormentor;
                  variables.torment_cycle = message.data.torment_cycle;
                  variables.torment_mode = message.data.torment_mode;
                  variables.killedtormentor = message.data.killedtormentor;
                  variables.moth_summon_active = message.data.moth_summon_active;
                  variables.tormentor_summon_active = message.data.tormentor_summon_active;
                  variables.smshealth = message.data.smshealth;
                  variables.tmshealth = message.data.tmshealth;
                  variables.player_dimension = message.data.player_dimension;
                  variables.tormentor_long_range_anim = message.data.tormentor_long_range_anim;
                  variables.player_overlay = message.data.player_overlay;
                  variables.fov_smoothen = message.data.fov_smoothen;
                  variables.overlay_white = message.data.overlay_white;
                  variables.wrath_charge_time = message.data.wrath_charge_time;
                  variables.overlay_black = message.data.overlay_black;
                  variables.sphere_near = message.data.sphere_near;
                  variables.laser_emitter_near = message.data.laser_emitter_near;
                  variables.overlay_red = message.data.overlay_red;
                  variables.tormentor_render = message.data.tormentor_render;
                  variables.shader2 = message.data.shader2;
                  variables.tormentor_overlay_anim = message.data.tormentor_overlay_anim;
                  variables.track_warp_cooldown = message.data.track_warp_cooldown;
                  variables.crawling_color_cycle = message.data.crawling_color_cycle;
                  variables.tormentorjustdiednearby = message.data.tormentorjustdiednearby;
                  variables.immortal_near = message.data.immortal_near;
                  variables.power_press = message.data.power_press;
                  variables.inherent_power_cooldown = message.data.inherent_power_cooldown;
                  variables.power_unset = message.data.power_unset;
                  variables.torment_intensity = message.data.torment_intensity;
                  variables.spacetime_tilt = message.data.spacetime_tilt;
                  variables.player_persistent_patreon_torversion = message.data.player_persistent_patreon_torversion;
                  variables.alternate_render = message.data.alternate_render;
                  variables.current_ascendant = message.data.current_ascendant;
                  variables.asc_x = message.data.asc_x;
                  variables.asc_y = message.data.asc_y;
                  variables.asc_z = message.data.asc_z;
                  variables.asc_subchain = message.data.asc_subchain;
                  variables.current_player_dimenson = message.data.current_player_dimenson;
                  variables.patreon_done = message.data.patreon_done;
                  variables.ShowOverlay4 = message.data.ShowOverlay4;
                  variables.power_shield_cooldown = message.data.power_shield_cooldown;
                  variables.shield_power_unlocked = message.data.shield_power_unlocked;
                  variables.power_slam_cooldown = message.data.power_slam_cooldown;
                  variables.slam_power_unlocked = message.data.slam_power_unlocked;
                  variables.ShowOverlay5 = message.data.ShowOverlay5;
                  variables.overlay_purple = message.data.overlay_purple;
                  variables.overlay_green = message.data.overlay_green;
                  variables.overlay_solid_black = message.data.overlay_solid_black;
                  variables.just_right_clicked = message.data.just_right_clicked;
               }
            }
         );
         context.setPacketHandled(true);
      }
   }

   public static class SavedDataSyncMessage {
      private final int type;
      private SavedData data;

      public SavedDataSyncMessage(FriendlyByteBuf buffer) {
         this.type = buffer.readInt();
         CompoundTag nbt = buffer.readNbt();
         if (nbt != null) {
            this.data = (SavedData)(this.type == 0 ? new ArphexModVariables.MapVariables() : new ArphexModVariables.WorldVariables());
            if (this.data instanceof ArphexModVariables.MapVariables mapVariables) {
               mapVariables.read(nbt);
            } else if (this.data instanceof ArphexModVariables.WorldVariables worldVariables) {
               worldVariables.read(nbt);
            }
         }
      }

      public SavedDataSyncMessage(int type, SavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(ArphexModVariables.SavedDataSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.type);
         if (message.data != null) {
            buffer.writeNbt(message.data.save(new CompoundTag()));
         }
      }

      public static void handler(ArphexModVariables.SavedDataSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
               if (message.type == 0) {
                  ArphexModVariables.MapVariables.clientSide = (ArphexModVariables.MapVariables)message.data;
               } else {
                  ArphexModVariables.WorldVariables.clientSide = (ArphexModVariables.WorldVariables)message.data;
               }
            }
         });
         context.setPacketHandled(true);
      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "arphex_worldvars";
      public boolean checkedprojecte = false;
      static ArphexModVariables.WorldVariables clientSide = new ArphexModVariables.WorldVariables();

      public static ArphexModVariables.WorldVariables load(CompoundTag tag) {
         ArphexModVariables.WorldVariables data = new ArphexModVariables.WorldVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         this.checkedprojecte = nbt.getBoolean("checkedprojecte");
      }

      public CompoundTag save(CompoundTag nbt) {
         nbt.putBoolean("checkedprojecte", this.checkedprojecte);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level level && !level.isClientSide()) {
            ArphexMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new ArphexModVariables.SavedDataSyncMessage(1, this));
         }
      }

      public static ArphexModVariables.WorldVariables get(LevelAccessor world) {
         return world instanceof ServerLevel level
            ? (ArphexModVariables.WorldVariables)level.getDataStorage()
               .computeIfAbsent(e -> load(e), ArphexModVariables.WorldVariables::new, "arphex_worldvars")
            : clientSide;
      }
   }
}
