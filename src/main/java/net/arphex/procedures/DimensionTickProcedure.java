package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import net.arphex.ArphexMod;
import net.arphex.init.ArphexModBlocks;
import net.arphex.init.ArphexModItems;
import net.arphex.init.ArphexModMobEffects;
import net.arphex.init.ArphexModParticleTypes;
import net.arphex.network.ArphexModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@SuppressWarnings("ALL")
@EventBusSubscriber
public class DimensionTickProcedure {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.phase == Phase.END) {
            execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            ItemStack warp_wayfinder = ItemStack.EMPTY;
            String substring_chunk = "";
            String substring_chain = "";
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            double chunkbedrock = 0.0;
            double xcalc = 0.0;
            double col_b = 0.0;
            double distance = 0.0;
            double spheresize = 0.0;
            double col_g = 0.0;
            double true_dists = 0.0;
            double col_r = 0.0;
            double sphere_num = 0.0;
            double ycalc = 0.0;
            double sphere_gradient = 0.0;
            double tormentor_distance = 0.0;
            double asc_sphere_y = 0.0;
            double asc_sphere_x = 0.0;
            double asc_sphere_z = 0.0;
            double dist_to_rendered = 0.0;
            double rotation_from_tormentor = 0.0;
            double dropoff = 0.0;
            double i = 0.0;
            double tier_multiply = 0.0;
            double j = 0.0;
            double zcalc = 0.0;
            double k = 0.0;
            double l = 0.0;
            double max_entities = 0.0;
            double opacity = 0.0;
            double dists = 0.0;
            double Radius = 0.0;
            double particleSpeed = 0.0;
            double forward = 0.0;
            double particleAmount = 0.0;
            double distance_check = 0.0;
            double uplength = 0.0;
            double distance_particle = 0.0;
            double loop = 0.0;
            double rightlength = 0.0;
            double angle = 0.0;
            double forwardy = 0.0;
            double forwardz = 0.0;
            double rightx = 0.0;
            double upx = 0.0;
            double forwardx = 0.0;
            double righty = 0.0;
            double rightz = 0.0;
            double upz = 0.0;
            double upy = 0.0;

            if (entity.getPersistentData().getBoolean("creativespectator")) {
                entity.getPersistentData().putBoolean("tormentor_target", false);
            }

            if (entity.getPersistentData().getDouble("just_teleported_arphex") > 44.0
                    && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != ArphexModBlocks.TESSERACT_TRANSPORTER.get()) {
                if (entity instanceof Player _player && !_player.level().isClientSide()) {
                    _player.displayClientMessage(Component.literal("§cYou took heavy damage as no teleporter was found at the destination!"), true);
                }

                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 10.0F);
            }

            if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arphex:the_crawling"))) {
                if (!((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                        .alternate_render
                        && entity.isAlive()) {
                    if (world.isClientSide()
                            && (Integer)Minecraft.getInstance().options.renderDistance().get() > 8
                            && entity instanceof Player _player
                            && _player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("§c9+ render distance found - not recommended in this dimension due to height"), false);
                    }

                    boolean _setval = true;
                    entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.alternate_render = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }

                if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.2, entity.getZ())).getBlock() == Blocks.BARRIER) {
                    if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect((MobEffect)ArphexModMobEffects.CRAWLING.get()))) {
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles((SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), x, y, z, 1, 0.1, 0.3, 0.1, 0.3);
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.CRAWLING.get(), 10, 0, false, false));
                        }

                        if ((entity instanceof LivingEntity _entGetArmorx ? _entGetArmorx.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                                != ArphexModItems.ETERNAL_CHESTPLATE.get()
                                && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                                != ArphexModItems.IMMORTAL_CHESTPLATE.get()
                                && !world.isClientSide()) {
                            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
                        }
                    }
                }

                if (!(
                        ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                .orElse(new ArphexModVariables.PlayerVariables()))
                                .crawling_color_cycle
                                > 0.0
                )) {
                    double _setval = 200.0;
                    entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.crawling_color_cycle = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                } else {
                    double _setval = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new ArphexModVariables.PlayerVariables()))
                            .crawling_color_cycle
                            - 1.0;
                    entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.crawling_color_cycle = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }

                if (!(new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                        } else {
                            return _ent.level().isClientSide() && _ent instanceof Player _player
                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR
                                    : false;
                        }
                    }
                })
                        .checkGamemode(entity)) {
                    if (entity.getY() < 60.0 && Mth.nextInt(RandomSource.create(), 1, 12000) == 5) {
                        boolean _setval = true;
                        entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.show_tormentor_overlay = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    if (entity.getY() > 255.0) {
                        if (world.getBlockState(BlockPos.containing(x, 319.0, z)).getBlock() != ArphexModBlocks.CRAWLING_BARRIER.get()) {
                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                        .getCommands()
                                        .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3((double)(Math.round(x / 16.0) * 16L), 257.0, (double)(Math.round(z / 16.0) * 16L)),
                                                        Vec2.ZERO,
                                                        _level,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _level.getServer(),
                                                        null
                                                )
                                                        .withSuppressedOutput(),
                                                "fill ~-8 257 ~-8 ~8 319 ~8 arphex:crawling_barrier"
                                        );
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                        .getCommands()
                                        .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3((double)(Math.round(x / 16.0) * 16L), 257.0, (double)(Math.round(z / 16.0) * 16L)),
                                                        Vec2.ZERO,
                                                        _level,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _level.getServer(),
                                                        null
                                                )
                                                        .withSuppressedOutput(),
                                                "fill ~-7 257 ~-7 ~7 318 ~7 air"
                                        );
                            }
                        }

                        if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                .orElse(new ArphexModVariables.PlayerVariables()))
                                .pocketdimensionx
                                != 0.0
                                && entity.getX()
                                > ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                .orElse(new ArphexModVariables.PlayerVariables()))
                                .pocketdimensionx
                                - 8.0
                                && entity.getX()
                                < ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                .orElse(new ArphexModVariables.PlayerVariables()))
                                .pocketdimensionx
                                + 8.0
                                && entity.getZ()
                                > ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                .orElse(new ArphexModVariables.PlayerVariables()))
                                .pocketdimensionx
                                - 8.0
                                && entity.getZ()
                                < ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                .orElse(new ArphexModVariables.PlayerVariables()))
                                .pocketdimensionx
                                + 8.0) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.ETERNAL_EVASION.get(), 5, 2, false, false));
                            }

                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 2, false, false));
                            }
                        }
                    } else {
                        if (Math.round(entity.getX() / 32.0) == 0L && Math.round(entity.getZ() / 32.0) == 0L && !world.isClientSide()) {
                            if (world.getBlockState(new BlockPos(0, 230, 0)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(0, 230, 0);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator _entity = _bso.getValues().entrySet().iterator();

                                while (_entity.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)_entity.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var133) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(2, 231, 0)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(2, 231, 0);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var241 = _bso.getValues().entrySet().iterator();

                                while (var241.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var241.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var132) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(0, 231, 2)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(0, 231, 2);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var242 = _bso.getValues().entrySet().iterator();

                                while (var242.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var242.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var131) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(-2, 231, 0)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(-2, 231, 0);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var243 = _bso.getValues().entrySet().iterator();

                                while (var243.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var243.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var130) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(0, 231, -2)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(0, 231, -2);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var244 = _bso.getValues().entrySet().iterator();

                                while (var244.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var244.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var129) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(1, 231, 1)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(1, 231, 1);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var245 = _bso.getValues().entrySet().iterator();

                                while (var245.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var245.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var128) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(1, 231, -1)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(1, 231, -1);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var246 = _bso.getValues().entrySet().iterator();

                                while (var246.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var246.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var127) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(-1, 231, 1)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(-1, 231, 1);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var247 = _bso.getValues().entrySet().iterator();

                                while (var247.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var247.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var126) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(-1, 231, -1)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(-1, 231, -1);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var248 = _bso.getValues().entrySet().iterator();

                                while (var248.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var248.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var125) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(0, 230, 1)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(0, 230, 1);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var249 = _bso.getValues().entrySet().iterator();

                                while (var249.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var249.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var124) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(0, 230, -1)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(0, 230, -1);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var250 = _bso.getValues().entrySet().iterator();

                                while (var250.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var250.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var123) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(1, 230, 0)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(1, 230, 0);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var251 = _bso.getValues().entrySet().iterator();

                                while (var251.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var251.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var122) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(-1, 230, 0)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(-1, 230, 0);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var252 = _bso.getValues().entrySet().iterator();

                                while (var252.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var252.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var121) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (!world.isEmptyBlock(new BlockPos(0, 231, 0))) {
                                BlockPos _bp = new BlockPos(0, 231, 0);
                                BlockState _bs = Blocks.AIR.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var253 = _bso.getValues().entrySet().iterator();

                                while (var253.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var253.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var120) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (!world.isEmptyBlock(new BlockPos(0, 232, 0))) {
                                BlockPos _bp = new BlockPos(0, 232, 0);
                                BlockState _bs = Blocks.AIR.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var254 = _bso.getValues().entrySet().iterator();

                                while (var254.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var254.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var119) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }

                            if (world.getBlockState(new BlockPos(0, 233, 0)).getBlock() != Blocks.BEDROCK) {
                                BlockPos _bp = new BlockPos(0, 233, 0);
                                BlockState _bs = Blocks.BEDROCK.defaultBlockState();
                                BlockState _bso = world.getBlockState(_bp);
                                UnmodifiableIterator var255 = _bso.getValues().entrySet().iterator();

                                while (var255.hasNext()) {
                                    Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var255.next();
                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                    if (_property != null && _bs.getValue(_property) != null) {
                                        try {
                                            _bs = (BlockState)_bs.setValue(_property,  (Comparable)entry.getValue());
                                        } catch (Exception var118) {
                                        }
                                    }
                                }

                                world.setBlock(_bp, _bs, 3);
                            }
                        }

                        if (entity.getY() >= 230.0) {
                            ArphexModVariables.MapVariables.get(world).playeronlayer1 = 300.0;
                            ArphexModVariables.MapVariables.get(world).syncData(world);
                        } else if (entity.getY() >= 120.0) {
                            ArphexModVariables.MapVariables.get(world).playeronlayer2 = 300.0;
                            ArphexModVariables.MapVariables.get(world).syncData(world);
                        } else if (entity.getY() >= 60.0) {
                            ArphexModVariables.MapVariables.get(world).playeronlayer3 = 300.0;
                            ArphexModVariables.MapVariables.get(world).syncData(world);
                        } else {
                            ArphexModVariables.MapVariables.get(world).playeronlayer4 = 300.0;
                            ArphexModVariables.MapVariables.get(world).syncData(world);
                        }
                    }

                    if (ArphexModVariables.MapVariables.get(world).tormentor_health > 0.0 && entity.getY() < 60.0) {
                        if (!(entity.getPersistentData().getDouble("bottomlayer") > 0.0)) {
                            entity.getPersistentData().putDouble("bottomlayer", 400.0);
                            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 12.0F);
                            if (entity instanceof Player _player && !_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal("This layer is too dangerous while The Tormentor is active..."), true);
                            }
                        } else {
                            entity.getPersistentData().putDouble("bottomlayer", entity.getPersistentData().getDouble("bottomlayer") - 1.0);
                        }
                    }
                }

                if (world.getLevelData().isThundering()) {
                    if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                entity.position(),
                                                entity.getRotationVector(),
                                                entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                                4,
                                                entity.getName().getString(),
                                                entity.getDisplayName(),
                                                entity.level().getServer(),
                                                entity
                                        ),
                                        "particle arphex:heavy_smoke ~ ~ ~ 8 8 8 0 1 force @p"
                                );
                    }

                    if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                            != ArphexModItems.IMMORTAL_HELMET.get()) {

                        int breathlessDuration = 0;
                        if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get())) {
                            breathlessDuration = _livEnt.getEffect((MobEffect)ArphexModMobEffects.BREATHLESS.get()).getDuration();
                        }

                        if (breathlessDuration < 150 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.BREATHLESS.get(), 4 + breathlessDuration, 0, false, false));
                        }
                    }
                } else if (world.getLevelData().isRaining()) {
                    if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("arphex:webbed_wasteland"))) {
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                            entity.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                            new CommandSourceStack(
                                                    CommandSource.NULL,
                                                    entity.position(),
                                                    entity.getRotationVector(),
                                                    entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                                    4,
                                                    entity.getName().getString(),
                                                    entity.getDisplayName(),
                                                    entity.level().getServer(),
                                                    entity
                                            ),
                                            "particle arphex:spider_blood_rain ~ ~ ~ 5 5 5 0 100 force @p"
                                    );
                        }
                    } else if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                entity.position(),
                                                entity.getRotationVector(),
                                                entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                                4,
                                                entity.getName().getString(),
                                                entity.getDisplayName(),
                                                entity.level().getServer(),
                                                entity
                                        ),
                                        "particle arphex:blood_rain ~ ~ ~ 5 5 5 0 100 force @p"
                                );
                    }

                    if (!(entity.getPersistentData().getDouble("rainsoundtime") > 0.0)) {
                        entity.getPersistentData().putDouble("rainsoundtime", 30.0);
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                            entity.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                            new CommandSourceStack(
                                                    CommandSource.NULL,
                                                    entity.position(),
                                                    entity.getRotationVector(),
                                                    entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null,
                                                    4,
                                                    entity.getName().getString(),
                                                    entity.getDisplayName(),
                                                    entity.level().getServer(),
                                                    entity
                                            ),
                                            "playsound weather.rain weather @s ~ ~ ~ 0.4 0.5 0.4"
                                    );
                        }
                    } else {
                        entity.getPersistentData().putDouble("rainsoundtime", entity.getPersistentData().getDouble("rainsoundtime") - 1.0);
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)ArphexModMobEffects.NECROSIS.get(), 60, 0, false, false));
                    }
                }
            } else {
                boolean _setval = false;
                entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.alternate_render = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }

            ArphexModVariables.MapVariables.get(world).alternate_entity_tick = true;
            ArphexModVariables.MapVariables.get(world).syncData(world);
            String _setval = ((
                    world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)
            )
                    + "")
                    .replace("ResourceKey[minecraft:dimension / ", "")
                    .replace("]", "")
                    .strip();
            entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.current_player_dimenson = _setval;
                capability.syncPlayerVariables(entity);
            });

            if (entity.getPersistentData().getDouble("sing_scythe_anim") > 0.0) {
                entity.getPersistentData().putDouble("sing_scythe_anim", entity.getPersistentData().getDouble("sing_scythe_anim") - 1.0);
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .killedtormentor
                    > 49.0
                    && entity instanceof ServerPlayer _player) {
                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:tormentor_obliterator"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .killedtormentor
                    > 99.0
                    && entity instanceof ServerPlayer _playerx) {
                Advancement _adv = _playerx.server.getAdvancements().getAdvancement(new ResourceLocation("arphex:ar_ph_ex_master"));
                AdvancementProgress _ap = _playerx.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _playerx.getAdvancements().award(_adv, criteria);
                    }
                }
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .power_shield_cooldown
                    > 0.0) {
                double _setvalx = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                        .power_shield_cooldown
                        - 1.0;
                entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.power_shield_cooldown = _setvalx;
                    capability.syncPlayerVariables(entity);
                });
                if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                        .power_shield_cooldown
                        > 200.0) {
                    if (!(entity.getPersistentData().getDouble("limit_sphere_wrap") > 0.0)) {
                        entity.getPersistentData().putDouble("limit_sphere_wrap", 3.0);
                        loop = 0.0;
                        particleAmount = 50.0;
                        Radius = 5.0;
                        particleSpeed = -0.07;
                        distance_particle = 3.0;
                        forward = Math.sqrt(
                                Math.pow(entity.getPersistentData().getDouble("x_lock_shield"), 2.0)
                                        + Math.pow(entity.getPersistentData().getDouble("y_lock_shield"), 2.0)
                                        + Math.pow(entity.getPersistentData().getDouble("z_lock_shield"), 2.0)
                        );
                        if (forward > 1.0E-4) {
                            forwardx = entity.getPersistentData().getDouble("x_lock_shield") / forward;
                            forwardy = entity.getPersistentData().getDouble("y_lock_shield") / forward;
                            forwardz = entity.getPersistentData().getDouble("z_lock_shield") / forward;
                        }

                        rightx = forwardz;
                        righty = 0.0;
                        rightz = 0.0 - forwardx;
                        rightlength = Math.sqrt(Math.pow(forwardz, 2.0) + Math.pow(righty, 2.0) + Math.pow(rightz, 2.0));
                        if (rightlength < 1.0E-4) {
                            rightx = 1.0;
                            righty = 0.0;
                            rightz = 0.0;
                            rightlength = 1.0;
                        }

                        rightx /= rightlength;
                        righty /= rightlength;
                        rightz /= rightlength;
                        upx = righty * forwardz - rightz * forwardy;
                        upy = rightz * forwardx - rightx * forwardz;
                        upz = rightx * forwardy - righty * forwardx;
                        uplength = Math.sqrt(Math.pow(upx, 2.0) + Math.pow(upy, 2.0) + Math.pow(upz, 2.0));
                        if (uplength > 1.0E-4) {
                            upx /= uplength;
                            upy /= uplength;
                            upz /= uplength;
                        }

                        while (loop < particleAmount) {
                            angle = (Math.PI * 2) / particleAmount * loop;
                            world.addParticle(
                                    (SimpleParticleType)ArphexModParticleTypes.ENTROPY_SHIELD.get(),
                                    entity.getPersistentData().getDouble("xpos_lock_shield")
                                            + forwardx * distance_particle
                                            + rightx * Math.cos(angle) * Radius
                                            + upx * Math.sin(angle) * Radius,
                                    entity.getPersistentData().getDouble("ypos_lock_shield")
                                            + forwardy * distance_particle
                                            + 1.3
                                            + righty * Math.cos(angle) * Radius
                                            + upy * Math.sin(angle) * Radius,
                                    entity.getPersistentData().getDouble("zpos_lock_shield")
                                            + forwardz * distance_particle
                                            + rightz * Math.cos(angle) * Radius
                                            + upz * Math.sin(angle) * Radius,
                                    0.0,
                                    0.0,
                                    0.0
                            );
                            world.addParticle(
                                    (SimpleParticleType)ArphexModParticleTypes.ENTROPY_SHIELD.get(),
                                    entity.getPersistentData().getDouble("xpos_lock_shield")
                                            + forwardx * distance_particle
                                            + rightx * Math.cos(angle) * Radius
                                            + upx * Math.sin(angle) * Radius,
                                    entity.getPersistentData().getDouble("ypos_lock_shield")
                                            + forwardy * distance_particle
                                            + 1.3
                                            + righty * Math.cos(angle) * Radius
                                            + upy * Math.sin(angle) * Radius,
                                    entity.getPersistentData().getDouble("zpos_lock_shield")
                                            + forwardz * distance_particle
                                            + rightz * Math.cos(angle) * Radius
                                            + upz * Math.sin(angle) * Radius,
                                    (rightx * Math.cos(angle) * Radius + upx * Math.sin(angle) * Radius) * particleSpeed,
                                    (righty * Math.cos(angle) * Radius + upy * Math.sin(angle) * Radius) * particleSpeed,
                                    (rightz * Math.cos(angle) * Radius + upz * Math.sin(angle) * Radius) * particleSpeed
                            );
                            loop++;
                        }

                        Vec3 _center = new Vec3(
                                entity.getPersistentData().getDouble("xpos_lock_shield"),
                                entity.getPersistentData().getDouble("ypos_lock_shield"),
                                entity.getPersistentData().getDouble("zpos_lock_shield")
                        );

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                                .stream()
                                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                .toList()) {
                            if ((
                                    entityiterator instanceof LivingEntity
                                            || (entityiterator instanceof Projectile _projEnt ? _projEnt.getDeltaMovement().length() : 0.0) != 0.0
                            )
                                    && !(entityiterator instanceof ArmorStand)
                                    && entityiterator != entity) {
                                distance_check = Math.sqrt(
                                        (entity.getX() - entityiterator.getX()) * (entity.getX() - entityiterator.getX())
                                                + (entity.getY() - entityiterator.getY()) * (entity.getY() - entityiterator.getY())
                                                + (entity.getZ() - entityiterator.getZ()) * (entity.getZ() - entityiterator.getZ())
                                );
                                entityiterator.setDeltaMovement(
                                        new Vec3(
                                                entity.getPersistentData().getDouble("x_lock_shield"),
                                                entity.getPersistentData().getDouble("y_lock_shield"),
                                                entity.getPersistentData().getDouble("z_lock_shield")
                                        )
                                );
                                if ((entityiterator instanceof Projectile _projEntx ? _projEntx.getDeltaMovement().length() : 0.0) != 0.0) {
                                    entityiterator.getPersistentData().putBoolean("reverse_mirror_attack", true);
                                    entityiterator.getPersistentData().putString("uuid_compare_source", entity.getStringUUID());
                                }
                            }
                        }
                    } else {
                        entity.getPersistentData().putDouble("limit_sphere_wrap", entity.getPersistentData().getDouble("limit_sphere_wrap") - 1.0);
                    }
                }
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .power_slam_cooldown
                    > 0.0) {
                double _setvalx = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                        .power_slam_cooldown
                        - 1.0;
                entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.power_slam_cooldown = _setvalx;
                    capability.syncPlayerVariables(entity);
                });
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .power_slam_cooldown
                    > 400.0
                    && (!(entity instanceof Player _plrCldCheck172) || !_plrCldCheck172.getCooldowns().isOnCooldown((Item)ArphexModItems.SEISMIC_PULSE.get()))
                    && world instanceof ServerLevel _level) {
                _level.sendParticles(
                        (SimpleParticleType)ArphexModParticleTypes.HEAVY_RED_SMOKE.get(), entity.getX(), entity.getY(), entity.getZ(), 2, 0.2, 0.2, 0.2, 0.2
                );
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .overlay_purple
                    > 0.0) {
                double _setvalx = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                        .overlay_purple
                        - 1.0;
                entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.overlay_purple = _setvalx;
                    capability.syncPlayerVariables(entity);
                });
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .overlay_green
                    > 0.0) {
                double _setvalx = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                        .overlay_green
                        - 1.0;
                entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.overlay_green = _setvalx;
                    capability.syncPlayerVariables(entity);
                });
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .overlay_solid_black
                    > 0.0) {
                double _setvalx = ((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new ArphexModVariables.PlayerVariables()))
                        .overlay_solid_black
                        - 1.0;
                entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.overlay_solid_black = _setvalx;
                    capability.syncPlayerVariables(entity);
                });
            }

            if (entity.getPersistentData().getDouble("has_bane_of_darkness") > 0.0) {
                entity.getPersistentData().putDouble("has_bane_of_darkness", entity.getPersistentData().getDouble("has_bane_of_darkness") - 1.0);
            }

            if (((ArphexModVariables.PlayerVariables)entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ArphexModVariables.PlayerVariables()))
                    .just_right_clicked) {
                ArphexMod.queueServerWork(1, () -> {
                    boolean _setvalx = false;
                    entity.getCapability(ArphexModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.just_right_clicked = _setvalx;
                        capability.syncPlayerVariables(entity);
                    });
                });
            }

            if ((entity instanceof LivingEntity _entUseTicks181 ? _entUseTicks181.getTicksUsingItem() : 0) > 0
                    && (entity instanceof LivingEntity _entUseItem182 ? _entUseItem182.getUseItem() : ItemStack.EMPTY).getItem() == ArphexModItems.GENESIS_RIFLE.get()
                    && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() != ArphexModItems.GENESIS_RIFLE.get()
                    && entity instanceof LivingEntity _entity) {
                _entity.stopUsingItem();
            }
        }
    }
}