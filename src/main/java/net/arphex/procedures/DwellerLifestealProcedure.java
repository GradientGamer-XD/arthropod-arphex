package net.arphex.procedures;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class DwellerLifestealProcedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(
            event,
            event.getEntity().level(),
            event.getEntity().getX(),
            event.getEntity().getY(),
            event.getEntity().getZ(),
            event.getSource(),
            event.getEntity(),
            event.getSource().getDirectEntity(),
            event.getSource().getEntity(),
            (double)event.getAmount()
         );
      }
   }

   public static void execute(
      LevelAccessor world,
      double x,
      double y,
      double z,
      DamageSource damagesource,
      Entity entity,
      Entity immediatesourceentity,
      Entity sourceentity,
      double amount
   ) {
      execute(null, world, x, y, z, damagesource, entity, immediatesourceentity, sourceentity, amount);
   }

   private static void execute(
      @Nullable Event param0,
      LevelAccessor param1,
      double param2,
      double param4,
      double param6,
      DamageSource param8,
      Entity param9,
      Entity param10,
      Entity param11,
      double param12
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.OutOfMemoryError: Java heap space
      //   at org.jetbrains.java.decompiler.util.collections.FastSparseSetFactory$FastSparseSet.getCopy(FastSparseSetFactory.java:95)
      //   at org.jetbrains.java.decompiler.util.collections.SFormsFastMapDirect.getCopy(SFormsFastMapDirect.java:67)
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.SSAUConstructorSparseEx.updateLiveMap(SSAUConstructorSparseEx.java:269)
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.SSAUConstructorSparseEx.varReadSingleVersion(SSAUConstructorSparseEx.java:110)
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.SFormsConstructor.varRead(SFormsConstructor.java:167)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.VarExprent.processSforms(VarExprent.java:509)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.Exprent.processSforms(Exprent.java:316)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.processSforms(InvocationExprent.java:1827)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.AssignmentExprent.processSforms(AssignmentExprent.java:305)
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.SFormsConstructor.ssaStatements(SFormsConstructor.java:126)
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.SSAUConstructorSparseEx.splitVariables(SSAUConstructorSparseEx.java:45)
      //   at org.jetbrains.java.decompiler.modules.decompiler.StackVarsProcessor.simplifyStackVars(StackVarsProcessor.java:65)
      //   at org.jetbrains.java.decompiler.modules.decompiler.StackVarsProcessor.simplifyStackVars(StackVarsProcessor.java:40)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:224)
      //
      // Bytecode:
      // 0000: aload 8
      // 0002: ifnull 0014
      // 0005: aload 9
      // 0007: ifnull 0014
      // 000a: aload 10
      // 000c: ifnull 0014
      // 000f: aload 11
      // 0011: ifnonnull 0015
      // 0014: return
      // 0015: ldc ""
      // 0017: astore 14
      // 0019: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 001c: astore 15
      // 001e: bipush 0
      // 001f: istore 16
      // 0021: bipush 0
      // 0022: istore 17
      // 0024: bipush 0
      // 0025: istore 18
      // 0027: dconst_0
      // 0028: dstore 19
      // 002a: dconst_0
      // 002b: dstore 21
      // 002d: dconst_0
      // 002e: dstore 23
      // 0030: dconst_0
      // 0031: dstore 25
      // 0033: dconst_0
      // 0034: dstore 27
      // 0036: dconst_0
      // 0037: dstore 29
      // 0039: dconst_0
      // 003a: dstore 31
      // 003c: dconst_0
      // 003d: dstore 33
      // 003f: dconst_0
      // 0040: dstore 35
      // 0042: dconst_0
      // 0043: dstore 37
      // 0045: dconst_0
      // 0046: dstore 39
      // 0048: dconst_0
      // 0049: dstore 41
      // 004b: dconst_0
      // 004c: dstore 43
      // 004e: aload 9
      // 0050: instanceof net/arphex/entity/TORMENTOREntity
      // 0053: ifeq 0072
      // 0056: aload 1
      // 0057: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 005a: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_hitbox_split D
      // 005d: dconst_0
      // 005e: dcmpl
      // 005f: ifle 0072
      // 0062: aload 0
      // 0063: ifnull 0072
      // 0066: aload 0
      // 0067: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 006a: ifeq 0072
      // 006d: aload 0
      // 006e: bipush 1
      // 006f: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0072: aload 9
      // 0074: instanceof net/arphex/entity/TormentorHitboxEntity
      // 0077: ifne 0082
      // 007a: aload 9
      // 007c: instanceof net/arphex/entity/TormentorShieldEntity
      // 007f: ifeq 00c2
      // 0082: aload 11
      // 0084: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0087: ldc "tormentor_summon"
      // 0089: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 008c: ifne 0097
      // 008f: aload 11
      // 0091: instanceof net/arphex/entity/TORMENTOREntity
      // 0094: ifeq 00aa
      // 0097: aload 0
      // 0098: ifnull 00c2
      // 009b: aload 0
      // 009c: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 009f: ifeq 00c2
      // 00a2: aload 0
      // 00a3: bipush 1
      // 00a4: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 00a7: goto 00c2
      // 00aa: aload 11
      // 00ac: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 00af: ldc "creativespectator"
      // 00b1: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 00b4: ifne 00c2
      // 00b7: aload 11
      // 00b9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 00bc: ldc "tormentor_target"
      // 00be: bipush 1
      // 00bf: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 00c2: aload 9
      // 00c4: instanceof net/arphex/entity/TormentorSphereEntity
      // 00c7: ifeq 00da
      // 00ca: aload 0
      // 00cb: ifnull 00da
      // 00ce: aload 0
      // 00cf: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 00d2: ifeq 00da
      // 00d5: aload 0
      // 00d6: bipush 1
      // 00d7: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 00da: aload 9
      // 00dc: instanceof net/arphex/entity/TORMENTOREntity
      // 00df: ifeq 0196
      // 00e2: dload 12
      // 00e4: ldc2_w 9.99999999E8
      // 00e7: dcmpl
      // 00e8: ifle 0196
      // 00eb: aload 1
      // 00ec: instanceof net/minecraft/server/level/ServerLevel
      // 00ef: ifeq 0133
      // 00f2: aload 1
      // 00f3: checkcast net/minecraft/server/level/ServerLevel
      // 00f6: astore 45
      // 00f8: aload 45
      // 00fa: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 00fd: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 0100: new net/minecraft/commands/CommandSourceStack
      // 0103: dup
      // 0104: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 0107: new net/minecraft/world/phys/Vec3
      // 010a: dup
      // 010b: dload 2
      // 010c: dload 4
      // 010e: dload 6
      // 0110: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0113: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 0116: aload 45
      // 0118: bipush 4
      // 0119: ldc ""
      // 011b: ldc ""
      // 011d: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0120: aload 45
      // 0122: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0125: aconst_null
      // 0126: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 0129: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 012c: ldc_w "arphex despawn @e[type=arphex:tormentor_test]"
      // 012f: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 0132: pop
      // 0133: aload 9
      // 0135: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 0138: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 013b: ifne 0143
      // 013e: aload 9
      // 0140: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 0143: aload 1
      // 0144: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0147: dconst_0
      // 0148: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 014b: aload 1
      // 014c: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 014f: aload 1
      // 0150: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0153: aload 1
      // 0154: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0157: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_seal_limit D
      // 015a: dconst_0
      // 015b: dcmpl
      // 015c: ifgt 0196
      // 015f: aload 1
      // 0160: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 0165: ifne 0184
      // 0168: aload 1
      // 0169: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 016e: ifnull 0184
      // 0171: aload 1
      // 0172: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 0177: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 017a: ldc_w "Tormentor Sealed"
      // 017d: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0180: bipush 0
      // 0181: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 0184: aload 1
      // 0185: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0188: ldc2_w 2000.0
      // 018b: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_seal_limit D
      // 018e: aload 1
      // 018f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0192: aload 1
      // 0193: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0196: aload 9
      // 0198: instanceof net/arphex/entity/TormentorTestEntity
      // 019b: ifne 01be
      // 019e: aload 9
      // 01a0: instanceof net/arphex/entity/TormentorT2Entity
      // 01a3: ifne 01be
      // 01a6: aload 9
      // 01a8: instanceof net/arphex/entity/TormentorT3Entity
      // 01ab: ifne 01be
      // 01ae: aload 9
      // 01b0: instanceof net/arphex/entity/TormentorT4Entity
      // 01b3: ifne 01be
      // 01b6: aload 9
      // 01b8: instanceof net/arphex/entity/TormentorT5Entity
      // 01bb: ifeq 01eb
      // 01be: aload 11
      // 01c0: ifnull 01db
      // 01c3: aload 8
      // 01c5: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 01c8: new net/minecraft/resources/ResourceLocation
      // 01cb: dup
      // 01cc: ldc_w "arphex:segment"
      // 01cf: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 01d2: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 01d5: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 01d8: ifne 01eb
      // 01db: aload 0
      // 01dc: ifnull 01eb
      // 01df: aload 0
      // 01e0: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 01e3: ifeq 01eb
      // 01e6: aload 0
      // 01e7: bipush 1
      // 01e8: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 01eb: aload 11
      // 01ed: instanceof net/minecraft/world/entity/LivingEntity
      // 01f0: ifeq 0202
      // 01f3: aload 11
      // 01f5: checkcast net/minecraft/world/entity/LivingEntity
      // 01f8: astore 45
      // 01fa: aload 45
      // 01fc: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 01ff: goto 0205
      // 0202: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 0205: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 0208: getstatic net/arphex/init/ArphexModItems.INFINITE_TORMENT Lnet/minecraftforge/registries/RegistryObject;
      // 020b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 020e: if_acmpne 04a6
      // 0211: aload 9
      // 0213: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0216: ldc_w "force_death"
      // 0219: bipush 1
      // 021a: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 021d: aload 9
      // 021f: instanceof net/minecraft/world/entity/LivingEntity
      // 0222: ifeq 04a6
      // 0225: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.DROP_TROPHIES Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 0228: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 022b: checkcast java/lang/Boolean
      // 022e: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 0231: ifeq 038d
      // 0234: aload 11
      // 0236: instanceof net/minecraft/world/entity/player/Player
      // 0239: ifeq 038d
      // 023c: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 023f: aload 9
      // 0241: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 0244: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 0249: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 024c: ldc_w "arphex:"
      // 024f: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0252: ifeq 038d
      // 0255: aload 9
      // 0257: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 025a: ldc_w "done_trophy_arphex"
      // 025d: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0260: ifne 038d
      // 0263: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 0266: aload 9
      // 0268: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 026b: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 0270: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 0273: ldc_w "clone"
      // 0276: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0279: ifne 038d
      // 027c: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 027f: aload 9
      // 0281: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 0284: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 0289: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 028c: ldc_w "hallucination"
      // 028f: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0292: ifne 038d
      // 0295: aload 9
      // 0297: instanceof net/arphex/entity/VenusFlytrapEntity
      // 029a: ifne 038d
      // 029d: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 02a0: aload 9
      // 02a2: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 02a5: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 02aa: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 02ad: ldc_w "web"
      // 02b0: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 02b3: ifne 038d
      // 02b6: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 02b9: aload 9
      // 02bb: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 02be: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 02c3: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 02c6: ldc_w "moth_summon"
      // 02c9: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 02cc: ifne 038d
      // 02cf: new net/minecraft/world/item/ItemStack
      // 02d2: dup
      // 02d3: getstatic net/arphex/init/ArphexModItems.TROPHY_ITEM Lnet/minecraftforge/registries/RegistryObject;
      // 02d6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 02d9: checkcast net/minecraft/world/level/ItemLike
      // 02dc: invokespecial net/minecraft/world/item/ItemStack.<init> (Lnet/minecraft/world/level/ItemLike;)V
      // 02df: astore 15
      // 02e1: aload 15
      // 02e3: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 02e6: ldc_w "trophy_entity"
      // 02e9: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 02ec: aload 9
      // 02ee: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 02f1: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 02f6: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 02f9: ldc_w "_tiny"
      // 02fc: ldc ""
      // 02fe: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 0301: ldc_w "_giant"
      // 0304: ldc ""
      // 0306: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 0309: ldc_w "arphex:"
      // 030c: ldc ""
      // 030e: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 0311: invokevirtual java/lang/String.strip ()Ljava/lang/String;
      // 0314: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0317: aload 15
      // 0319: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 031c: ldc_w "trophy_entity_size"
      // 031f: dconst_1
      // 0320: aload 9
      // 0322: invokevirtual net/minecraft/world/entity/Entity.getBbHeight ()F
      // 0325: aload 9
      // 0327: invokevirtual net/minecraft/world/entity/Entity.getBbWidth ()F
      // 032a: fmul
      // 032b: f2d
      // 032c: invokestatic java/lang/Math.cbrt (D)D
      // 032f: ldc2_w 10.0
      // 0332: dmul
      // 0333: ddiv
      // 0334: ldc2_w 4.0
      // 0337: dmul
      // 0338: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 033b: aload 15
      // 033d: aload 9
      // 033f: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 0342: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 0347: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001 Trophy" ]
      // 034c: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 034f: invokevirtual net/minecraft/world/item/ItemStack.setHoverName (Lnet/minecraft/network/chat/Component;)Lnet/minecraft/world/item/ItemStack;
      // 0352: pop
      // 0353: aload 1
      // 0354: instanceof net/minecraft/server/level/ServerLevel
      // 0357: ifeq 0381
      // 035a: aload 1
      // 035b: checkcast net/minecraft/server/level/ServerLevel
      // 035e: astore 46
      // 0360: new net/minecraft/world/entity/item/ItemEntity
      // 0363: dup
      // 0364: aload 46
      // 0366: dload 2
      // 0367: dload 4
      // 0369: dload 6
      // 036b: aload 15
      // 036d: invokespecial net/minecraft/world/entity/item/ItemEntity.<init> (Lnet/minecraft/world/level/Level;DDDLnet/minecraft/world/item/ItemStack;)V
      // 0370: astore 47
      // 0372: aload 47
      // 0374: bipush 10
      // 0376: invokevirtual net/minecraft/world/entity/item/ItemEntity.setPickUpDelay (I)V
      // 0379: aload 46
      // 037b: aload 47
      // 037d: invokevirtual net/minecraft/server/level/ServerLevel.addFreshEntity (Lnet/minecraft/world/entity/Entity;)Z
      // 0380: pop
      // 0381: aload 9
      // 0383: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0386: ldc_w "done_trophy_arphex"
      // 0389: bipush 1
      // 038a: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 038d: aload 11
      // 038f: invokevirtual net/minecraft/world/entity/Entity.isShiftKeyDown ()Z
      // 0392: ifeq 03a8
      // 0395: aload 9
      // 0397: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 039a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 039d: ifne 04a6
      // 03a0: aload 9
      // 03a2: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 03a5: goto 04a6
      // 03a8: aload 9
      // 03aa: instanceof net/minecraft/world/entity/LivingEntity
      // 03ad: ifeq 03bf
      // 03b0: aload 9
      // 03b2: checkcast net/minecraft/world/entity/LivingEntity
      // 03b5: astore 46
      // 03b7: aload 46
      // 03b9: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 03bc: goto 03c2
      // 03bf: ldc_w -1.0
      // 03c2: fconst_0
      // 03c3: fcmpl
      // 03c4: ifle 03dc
      // 03c7: aload 9
      // 03c9: instanceof net/minecraft/world/entity/LivingEntity
      // 03cc: ifeq 03dc
      // 03cf: aload 9
      // 03d1: checkcast net/minecraft/world/entity/LivingEntity
      // 03d4: astore 47
      // 03d6: aload 47
      // 03d8: fconst_1
      // 03d9: invokevirtual net/minecraft/world/entity/LivingEntity.setHealth (F)V
      // 03dc: aload 9
      // 03de: instanceof net/arphex/entity/TORMENTOREntity
      // 03e1: ifeq 0403
      // 03e4: aload 1
      // 03e5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 03e8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 03eb: dconst_1
      // 03ec: dcmpl
      // 03ed: ifle 04a6
      // 03f0: aload 1
      // 03f1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 03f4: dconst_1
      // 03f5: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 03f8: aload 1
      // 03f9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 03fc: aload 1
      // 03fd: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0400: goto 04a6
      // 0403: aload 9
      // 0405: instanceof net/minecraft/world/entity/LivingEntity
      // 0408: ifeq 0418
      // 040b: aload 9
      // 040d: checkcast net/minecraft/world/entity/LivingEntity
      // 0410: astore 46
      // 0412: aload 46
      // 0414: invokevirtual net/minecraft/world/entity/LivingEntity.removeAllEffects ()Z
      // 0417: pop
      // 0418: aload 9
      // 041a: new net/minecraft/world/damagesource/DamageSource
      // 041d: dup
      // 041e: aload 1
      // 041f: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0424: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0427: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 042c: getstatic net/minecraft/world/damagesource/DamageTypes.MAGIC Lnet/minecraft/resources/ResourceKey;
      // 042f: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0434: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0437: aload 9
      // 0439: instanceof net/minecraft/world/entity/LivingEntity
      // 043c: ifeq 044e
      // 043f: aload 9
      // 0441: checkcast net/minecraft/world/entity/LivingEntity
      // 0444: astore 46
      // 0446: aload 46
      // 0448: invokevirtual net/minecraft/world/entity/LivingEntity.getMaxHealth ()F
      // 044b: goto 0451
      // 044e: ldc_w -1.0
      // 0451: ldc_w 100.0
      // 0454: fmul
      // 0455: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0458: pop
      // 0459: aload 9
      // 045b: new net/minecraft/world/damagesource/DamageSource
      // 045e: dup
      // 045f: aload 1
      // 0460: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0465: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0468: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 046d: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 0470: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0475: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0478: aload 9
      // 047a: instanceof net/minecraft/world/entity/LivingEntity
      // 047d: ifeq 048f
      // 0480: aload 9
      // 0482: checkcast net/minecraft/world/entity/LivingEntity
      // 0485: astore 46
      // 0487: aload 46
      // 0489: invokevirtual net/minecraft/world/entity/LivingEntity.getMaxHealth ()F
      // 048c: goto 0492
      // 048f: ldc_w -1.0
      // 0492: ldc_w 100.0
      // 0495: fmul
      // 0496: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0499: pop
      // 049a: bipush 1
      // 049b: aload 9
      // 049d: aload 1
      // 049e: invokedynamic run (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$3 (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;)V, ()V ]
      // 04a3: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 04a6: aload 10
      // 04a8: instanceof net/arphex/entity/GenesisShotEntity
      // 04ab: ifne 04ce
      // 04ae: aload 10
      // 04b0: instanceof net/arphex/entity/TormentRifleEntity
      // 04b3: ifne 04ce
      // 04b6: aload 10
      // 04b8: instanceof net/arphex/entity/AbyssExplosiveEntity
      // 04bb: ifne 04ce
      // 04be: aload 10
      // 04c0: instanceof net/arphex/entity/TormentExplosiveEntity
      // 04c3: ifne 04ce
      // 04c6: aload 10
      // 04c8: instanceof net/arphex/entity/ChronoShotEntity
      // 04cb: ifeq 04de
      // 04ce: aload 0
      // 04cf: ifnull 04de
      // 04d2: aload 0
      // 04d3: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 04d6: ifeq 04de
      // 04d9: aload 0
      // 04da: bipush 1
      // 04db: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 04de: aload 11
      // 04e0: instanceof net/minecraft/world/entity/player/Player
      // 04e3: ifeq 050a
      // 04e6: aload 11
      // 04e8: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 04eb: ldc_w "lensmode"
      // 04ee: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 04f1: dconst_0
      // 04f2: dcmpl
      // 04f3: ifle 050a
      // 04f6: aload 11
      // 04f8: aload 9
      // 04fa: if_acmpeq 050a
      // 04fd: bipush 3
      // 04fe: aload 11
      // 0500: aload 9
      // 0502: invokedynamic run (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$4 (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0507: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 050a: aload 9
      // 050c: instanceof net/arphex/entity/TORMENTOREntity
      // 050f: ifeq 0556
      // 0512: aload 11
      // 0514: instanceof net/minecraft/world/entity/player/Player
      // 0517: ifeq 052e
      // 051a: aload 1
      // 051b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 051e: aload 11
      // 0520: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 0523: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 0526: aload 1
      // 0527: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 052a: aload 1
      // 052b: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 052e: aload 11
      // 0530: instanceof net/arphex/entity/TormentorMothSummonEntity
      // 0533: ifne 0546
      // 0536: aload 11
      // 0538: instanceof net/arphex/entity/TormentorScorpioidSummonEntity
      // 053b: ifne 0546
      // 053e: aload 11
      // 0540: instanceof net/arphex/entity/TormentorVoidlasherSummonEntity
      // 0543: ifeq 0556
      // 0546: aload 0
      // 0547: ifnull 0556
      // 054a: aload 0
      // 054b: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 054e: ifeq 0556
      // 0551: aload 0
      // 0552: bipush 1
      // 0553: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0556: aload 11
      // 0558: instanceof net/arphex/entity/TormentorCaterpillarEntity
      // 055b: ifeq 056e
      // 055e: aload 11
      // 0560: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 0563: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0566: ifne 056e
      // 0569: aload 11
      // 056b: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 056e: aload 11
      // 0570: instanceof net/minecraft/world/entity/player/Player
      // 0573: ifeq 0596
      // 0576: aload 9
      // 0578: instanceof net/arphex/entity/TORMENTOREntity
      // 057b: ifeq 0596
      // 057e: dconst_0
      // 057f: dstore 45
      // 0581: aload 11
      // 0583: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0586: aconst_null
      // 0587: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 058a: dload 45
      // 058c: aload 11
      // 058e: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$5 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 0593: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 0596: aload 9
      // 0598: instanceof net/arphex/entity/TormentorScorpioidSummonEntity
      // 059b: ifeq 0680
      // 059e: aload 9
      // 05a0: instanceof net/arphex/entity/TormentorScorpioidSummonEntity
      // 05a3: ifeq 061d
      // 05a6: aload 9
      // 05a8: checkcast net/arphex/entity/TormentorScorpioidSummonEntity
      // 05ab: astore 45
      // 05ad: aload 45
      // 05af: invokevirtual net/arphex/entity/TormentorScorpioidSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 05b2: getstatic net/arphex/entity/TormentorScorpioidSummonEntity.DATA_flee_mode Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 05b5: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 05b8: checkcast java/lang/Boolean
      // 05bb: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 05be: ifeq 061d
      // 05c1: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 05c4: bipush 1
      // 05c5: bipush 2
      // 05c6: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 05c9: bipush 2
      // 05ca: if_icmpne 0680
      // 05cd: aload 9
      // 05cf: instanceof net/arphex/entity/TormentorScorpioidSummonEntity
      // 05d2: ifeq 05eb
      // 05d5: aload 9
      // 05d7: checkcast net/arphex/entity/TormentorScorpioidSummonEntity
      // 05da: astore 46
      // 05dc: aload 46
      // 05de: invokevirtual net/arphex/entity/TormentorScorpioidSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 05e1: getstatic net/arphex/entity/TormentorScorpioidSummonEntity.DATA_flee_mode Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 05e4: bipush 0
      // 05e5: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 05e8: invokevirtual net/minecraft/network/syncher/SynchedEntityData.set (Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;)V
      // 05eb: aload 1
      // 05ec: instanceof net/minecraft/server/level/ServerLevel
      // 05ef: ifeq 061a
      // 05f2: aload 1
      // 05f3: checkcast net/minecraft/server/level/ServerLevel
      // 05f6: astore 46
      // 05f8: aload 46
      // 05fa: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 05fd: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0600: checkcast net/minecraft/core/particles/SimpleParticleType
      // 0603: dload 2
      // 0604: dload 4
      // 0606: dload 6
      // 0608: bipush 25
      // 060a: ldc2_w 0.5
      // 060d: ldc2_w 0.5
      // 0610: ldc2_w 0.5
      // 0613: ldc2_w 0.5
      // 0616: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 0619: pop
      // 061a: goto 0680
      // 061d: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 0620: bipush 1
      // 0621: bipush 15
      // 0623: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 0626: bipush 2
      // 0627: if_icmpne 0680
      // 062a: aload 9
      // 062c: instanceof net/minecraft/world/entity/LivingEntity
      // 062f: ifeq 064a
      // 0632: aload 9
      // 0634: checkcast net/minecraft/world/entity/LivingEntity
      // 0637: astore 46
      // 0639: aload 46
      // 063b: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 063e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0641: checkcast net/minecraft/world/effect/MobEffect
      // 0644: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0647: ifne 0680
      // 064a: aload 9
      // 064c: instanceof net/minecraft/world/entity/LivingEntity
      // 064f: ifeq 0680
      // 0652: aload 9
      // 0654: checkcast net/minecraft/world/entity/LivingEntity
      // 0657: astore 47
      // 0659: aload 47
      // 065b: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 065e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0661: ifne 0680
      // 0664: aload 47
      // 0666: new net/minecraft/world/effect/MobEffectInstance
      // 0669: dup
      // 066a: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 066d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0670: checkcast net/minecraft/world/effect/MobEffect
      // 0673: sipush 160
      // 0676: bipush 1
      // 0677: bipush 0
      // 0678: bipush 0
      // 0679: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 067c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 067f: pop
      // 0680: aload 11
      // 0682: instanceof net/arphex/entity/TormentorScorpioidSummonEntity
      // 0685: ifeq 071c
      // 0688: aload 11
      // 068a: instanceof net/minecraft/world/entity/LivingEntity
      // 068d: ifeq 06b5
      // 0690: aload 11
      // 0692: checkcast net/minecraft/world/entity/LivingEntity
      // 0695: astore 45
      // 0697: aload 45
      // 0699: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 069c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 069f: ifne 06b5
      // 06a2: aload 45
      // 06a4: new net/minecraft/world/effect/MobEffectInstance
      // 06a7: dup
      // 06a8: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 06ab: bipush 60
      // 06ad: bipush 1
      // 06ae: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 06b1: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 06b4: pop
      // 06b5: aload 1
      // 06b6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 06b9: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 06bc: ldc2_w 1010.0
      // 06bf: dcmpg
      // 06c0: ifge 071c
      // 06c3: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 06c6: bipush 1
      // 06c7: bipush 2
      // 06c8: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 06cb: bipush 2
      // 06cc: if_icmpne 071c
      // 06cf: aload 11
      // 06d1: instanceof net/arphex/entity/TormentorScorpioidSummonEntity
      // 06d4: ifeq 06ed
      // 06d7: aload 11
      // 06d9: checkcast net/arphex/entity/TormentorScorpioidSummonEntity
      // 06dc: astore 45
      // 06de: aload 45
      // 06e0: invokevirtual net/arphex/entity/TormentorScorpioidSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 06e3: getstatic net/arphex/entity/TormentorScorpioidSummonEntity.DATA_flee_mode Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 06e6: bipush 1
      // 06e7: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 06ea: invokevirtual net/minecraft/network/syncher/SynchedEntityData.set (Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;)V
      // 06ed: aload 1
      // 06ee: instanceof net/minecraft/server/level/ServerLevel
      // 06f1: ifeq 071c
      // 06f4: aload 1
      // 06f5: checkcast net/minecraft/server/level/ServerLevel
      // 06f8: astore 45
      // 06fa: aload 45
      // 06fc: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_RED_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 06ff: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0702: checkcast net/minecraft/core/particles/SimpleParticleType
      // 0705: dload 2
      // 0706: dload 4
      // 0708: dload 6
      // 070a: bipush 25
      // 070c: ldc2_w 0.5
      // 070f: ldc2_w 0.5
      // 0712: ldc2_w 0.5
      // 0715: ldc2_w 0.5
      // 0718: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 071b: pop
      // 071c: aload 11
      // 071e: instanceof net/arphex/entity/TormentorVoidlasherSummonEntity
      // 0721: ifeq 073b
      // 0724: aload 11
      // 0726: aload 9
      // 0728: if_acmpne 073b
      // 072b: aload 0
      // 072c: ifnull 073b
      // 072f: aload 0
      // 0730: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0733: ifeq 073b
      // 0736: aload 0
      // 0737: bipush 1
      // 0738: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 073b: aload 11
      // 073d: instanceof net/arphex/entity/TORMENTOREntity
      // 0740: ifeq 0765
      // 0743: aload 9
      // 0745: instanceof net/minecraft/world/entity/player/Player
      // 0748: ifeq 0765
      // 074b: ldc2_w 100.0
      // 074e: dstore 45
      // 0750: aload 9
      // 0752: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0755: aconst_null
      // 0756: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0759: dload 45
      // 075b: aload 9
      // 075d: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$6 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 0762: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 0765: aload 11
      // 0767: instanceof net/arphex/entity/CrabConstrictorEntity
      // 076a: ifeq 0795
      // 076d: aload 9
      // 076f: instanceof net/minecraft/world/entity/player/Player
      // 0772: ifeq 0795
      // 0775: aload 9
      // 0777: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 077a: aload 11
      // 077c: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 077f: dconst_1
      // 0780: dsub
      // 0781: dcmpg
      // 0782: ifge 0795
      // 0785: aload 0
      // 0786: ifnull 0795
      // 0789: aload 0
      // 078a: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 078d: ifeq 0795
      // 0790: aload 0
      // 0791: bipush 1
      // 0792: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0795: aload 9
      // 0797: instanceof net/arphex/entity/SpiderAmbusherEntity
      // 079a: ifeq 07c8
      // 079d: aload 9
      // 079f: instanceof net/minecraft/world/entity/LivingEntity
      // 07a2: ifeq 07bd
      // 07a5: aload 9
      // 07a7: checkcast net/minecraft/world/entity/LivingEntity
      // 07aa: astore 45
      // 07ac: aload 45
      // 07ae: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 07b1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 07b4: checkcast net/minecraft/world/effect/MobEffect
      // 07b7: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 07ba: ifne 07c8
      // 07bd: bipush 1
      // 07be: aload 9
      // 07c0: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$7 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 07c5: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 07c8: aload 9
      // 07ca: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 07cd: ifeq 07db
      // 07d0: bipush 1
      // 07d1: aload 9
      // 07d3: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$8 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 07d8: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 07db: aload 11
      // 07dd: instanceof net/minecraft/world/entity/player/Player
      // 07e0: ifeq 0b3e
      // 07e3: aload 9
      // 07e5: instanceof net/arphex/entity/SpiderMothEntity
      // 07e8: ifeq 0b3e
      // 07eb: aload 11
      // 07ed: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 07f0: aconst_null
      // 07f1: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 07f4: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 07f7: dup
      // 07f8: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 07fb: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 07fe: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0801: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 0804: ldc2_w 3.0
      // 0807: dcmpg
      // 0808: ifge 0b3e
      // 080b: aload 9
      // 080d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0810: ldc_w "spawnedawayfromplayer"
      // 0813: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0816: bipush 1
      // 0817: if_icmpne 0b3e
      // 081a: aload 9
      // 081c: instanceof net/minecraft/world/entity/LivingEntity
      // 081f: ifeq 0831
      // 0822: aload 9
      // 0824: checkcast net/minecraft/world/entity/LivingEntity
      // 0827: astore 45
      // 0829: aload 45
      // 082b: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 082e: goto 0834
      // 0831: ldc_w -1.0
      // 0834: ldc_w 310.0
      // 0837: fcmpg
      // 0838: ifge 0b3e
      // 083b: aload 9
      // 083d: instanceof net/minecraft/world/entity/LivingEntity
      // 0840: ifeq 0855
      // 0843: aload 9
      // 0845: checkcast net/minecraft/world/entity/LivingEntity
      // 0848: astore 46
      // 084a: aload 46
      // 084c: getstatic net/minecraft/world/effect/MobEffects.DIG_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 084f: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0852: ifne 0b3e
      // 0855: aload 9
      // 0857: instanceof net/minecraft/world/entity/LivingEntity
      // 085a: ifeq 0875
      // 085d: aload 9
      // 085f: checkcast net/minecraft/world/entity/LivingEntity
      // 0862: astore 47
      // 0864: aload 47
      // 0866: getstatic net/arphex/init/ArphexModMobEffects.DESPAWN_IMMUNITY Lnet/minecraftforge/registries/RegistryObject;
      // 0869: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 086c: checkcast net/minecraft/world/effect/MobEffect
      // 086f: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0872: ifne 0b3e
      // 0875: aload 11
      // 0877: instanceof net/minecraft/server/level/ServerPlayer
      // 087a: ifeq 08b2
      // 087d: aload 11
      // 087f: checkcast net/minecraft/server/level/ServerPlayer
      // 0882: astore 48
      // 0884: aload 48
      // 0886: invokevirtual net/minecraft/server/level/ServerPlayer.level ()Lnet/minecraft/world/level/Level;
      // 0889: instanceof net/minecraft/server/level/ServerLevel
      // 088c: ifeq 08b2
      // 088f: aload 48
      // 0891: invokevirtual net/minecraft/server/level/ServerPlayer.getAdvancements ()Lnet/minecraft/server/PlayerAdvancements;
      // 0894: aload 48
      // 0896: getfield net/minecraft/server/level/ServerPlayer.server Lnet/minecraft/server/MinecraftServer;
      // 0899: invokevirtual net/minecraft/server/MinecraftServer.getAdvancements ()Lnet/minecraft/server/ServerAdvancementManager;
      // 089c: new net/minecraft/resources/ResourceLocation
      // 089f: dup
      // 08a0: ldc_w "arphex:moth_ward"
      // 08a3: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 08a6: invokevirtual net/minecraft/server/ServerAdvancementManager.getAdvancement (Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/advancements/Advancement;
      // 08a9: invokevirtual net/minecraft/server/PlayerAdvancements.getOrStartProgress (Lnet/minecraft/advancements/Advancement;)Lnet/minecraft/advancements/AdvancementProgress;
      // 08ac: invokevirtual net/minecraft/advancements/AdvancementProgress.isDone ()Z
      // 08af: ifne 091e
      // 08b2: aload 11
      // 08b4: instanceof net/minecraft/server/level/ServerPlayer
      // 08b7: ifeq 091e
      // 08ba: aload 11
      // 08bc: checkcast net/minecraft/server/level/ServerPlayer
      // 08bf: astore 49
      // 08c1: aload 49
      // 08c3: getfield net/minecraft/server/level/ServerPlayer.server Lnet/minecraft/server/MinecraftServer;
      // 08c6: invokevirtual net/minecraft/server/MinecraftServer.getAdvancements ()Lnet/minecraft/server/ServerAdvancementManager;
      // 08c9: new net/minecraft/resources/ResourceLocation
      // 08cc: dup
      // 08cd: ldc_w "arphex:moth_ward"
      // 08d0: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 08d3: invokevirtual net/minecraft/server/ServerAdvancementManager.getAdvancement (Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/advancements/Advancement;
      // 08d6: astore 50
      // 08d8: aload 49
      // 08da: invokevirtual net/minecraft/server/level/ServerPlayer.getAdvancements ()Lnet/minecraft/server/PlayerAdvancements;
      // 08dd: aload 50
      // 08df: invokevirtual net/minecraft/server/PlayerAdvancements.getOrStartProgress (Lnet/minecraft/advancements/Advancement;)Lnet/minecraft/advancements/AdvancementProgress;
      // 08e2: astore 51
      // 08e4: aload 51
      // 08e6: invokevirtual net/minecraft/advancements/AdvancementProgress.isDone ()Z
      // 08e9: ifne 091e
      // 08ec: aload 51
      // 08ee: invokevirtual net/minecraft/advancements/AdvancementProgress.getRemainingCriteria ()Ljava/lang/Iterable;
      // 08f1: invokeinterface java/lang/Iterable.iterator ()Ljava/util/Iterator; 1
      // 08f6: astore 52
      // 08f8: aload 52
      // 08fa: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 08ff: ifeq 091e
      // 0902: aload 52
      // 0904: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0909: checkcast java/lang/String
      // 090c: astore 53
      // 090e: aload 49
      // 0910: invokevirtual net/minecraft/server/level/ServerPlayer.getAdvancements ()Lnet/minecraft/server/PlayerAdvancements;
      // 0913: aload 50
      // 0915: aload 53
      // 0917: invokevirtual net/minecraft/server/PlayerAdvancements.award (Lnet/minecraft/advancements/Advancement;Ljava/lang/String;)Z
      // 091a: pop
      // 091b: goto 08f8
      // 091e: aload 9
      // 0920: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 0923: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0926: ifne 092e
      // 0929: aload 9
      // 092b: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 092e: aload 1
      // 092f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0932: ldc_w "moth-ward"
      // 0935: putfield net/arphex/network/ArphexModVariables$MapVariables.last_despawn_reasons Ljava/lang/String;
      // 0938: aload 1
      // 0939: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 093c: aload 1
      // 093d: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0940: aload 1
      // 0941: instanceof net/minecraft/server/level/ServerLevel
      // 0944: ifeq 096b
      // 0947: aload 1
      // 0948: checkcast net/minecraft/server/level/ServerLevel
      // 094b: astore 48
      // 094d: aload 48
      // 094f: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 0952: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0955: checkcast net/minecraft/core/particles/SimpleParticleType
      // 0958: dload 2
      // 0959: dload 4
      // 095b: dload 6
      // 095d: bipush 15
      // 095f: dconst_1
      // 0960: ldc2_w 0.4
      // 0963: dconst_1
      // 0964: ldc2_w 0.3
      // 0967: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 096a: pop
      // 096b: aload 11
      // 096d: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0970: aconst_null
      // 0971: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0974: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0977: dup
      // 0978: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 097b: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 097e: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0981: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 0984: dconst_1
      // 0985: dadd
      // 0986: dstore 48
      // 0988: aload 11
      // 098a: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 098d: aconst_null
      // 098e: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0991: dload 48
      // 0993: aload 11
      // 0995: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$9 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 099a: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 099d: aload 11
      // 099f: instanceof net/minecraft/world/entity/player/Player
      // 09a2: ifeq 09c3
      // 09a5: aload 11
      // 09a7: checkcast net/minecraft/world/entity/player/Player
      // 09aa: astore 48
      // 09ac: aload 48
      // 09ae: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 09b1: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 09b4: ifne 09c3
      // 09b7: aload 48
      // 09b9: ldc_w "You warded it off, but sense that it will return stronger... Beware the thunderstorms"
      // 09bc: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 09bf: bipush 1
      // 09c0: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 09c3: aload 11
      // 09c5: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 09c8: aconst_null
      // 09c9: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 09cc: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 09cf: dup
      // 09d0: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 09d3: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 09d6: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 09d9: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 09dc: dconst_1
      // 09dd: dcmpl
      // 09de: ifne 0a23
      // 09e1: aload 1
      // 09e2: instanceof net/minecraft/server/level/ServerLevel
      // 09e5: ifeq 0a23
      // 09e8: aload 1
      // 09e9: checkcast net/minecraft/server/level/ServerLevel
      // 09ec: astore 48
      // 09ee: getstatic net/minecraft/world/entity/EntityType.LIGHTNING_BOLT Lnet/minecraft/world/entity/EntityType;
      // 09f1: aload 48
      // 09f3: invokevirtual net/minecraft/world/entity/EntityType.create (Lnet/minecraft/world/level/Level;)Lnet/minecraft/world/entity/Entity;
      // 09f6: checkcast net/minecraft/world/entity/LightningBolt
      // 09f9: astore 49
      // 09fb: aload 49
      // 09fd: aload 9
      // 09ff: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 0a02: aload 9
      // 0a04: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 0a07: aload 9
      // 0a09: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 0a0c: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 0a0f: invokestatic net/minecraft/world/phys/Vec3.atBottomCenterOf (Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;
      // 0a12: invokevirtual net/minecraft/world/entity/LightningBolt.moveTo (Lnet/minecraft/world/phys/Vec3;)V
      // 0a15: aload 49
      // 0a17: bipush 1
      // 0a18: invokevirtual net/minecraft/world/entity/LightningBolt.setVisualOnly (Z)V
      // 0a1b: aload 48
      // 0a1d: aload 49
      // 0a1f: invokevirtual net/minecraft/server/level/ServerLevel.addFreshEntity (Lnet/minecraft/world/entity/Entity;)Z
      // 0a22: pop
      // 0a23: aload 11
      // 0a25: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0a28: aconst_null
      // 0a29: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0a2c: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0a2f: dup
      // 0a30: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0a33: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0a36: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0a39: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 0a3c: ldc2_w 2.0
      // 0a3f: dcmpl
      // 0a40: ifne 0ab8
      // 0a43: aload 1
      // 0a44: instanceof net/minecraft/server/level/ServerLevel
      // 0a47: ifeq 0a85
      // 0a4a: aload 1
      // 0a4b: checkcast net/minecraft/server/level/ServerLevel
      // 0a4e: astore 48
      // 0a50: getstatic net/minecraft/world/entity/EntityType.LIGHTNING_BOLT Lnet/minecraft/world/entity/EntityType;
      // 0a53: aload 48
      // 0a55: invokevirtual net/minecraft/world/entity/EntityType.create (Lnet/minecraft/world/level/Level;)Lnet/minecraft/world/entity/Entity;
      // 0a58: checkcast net/minecraft/world/entity/LightningBolt
      // 0a5b: astore 49
      // 0a5d: aload 49
      // 0a5f: aload 9
      // 0a61: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 0a64: aload 9
      // 0a66: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 0a69: aload 9
      // 0a6b: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 0a6e: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 0a71: invokestatic net/minecraft/world/phys/Vec3.atBottomCenterOf (Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;
      // 0a74: invokevirtual net/minecraft/world/entity/LightningBolt.moveTo (Lnet/minecraft/world/phys/Vec3;)V
      // 0a77: aload 49
      // 0a79: bipush 1
      // 0a7a: invokevirtual net/minecraft/world/entity/LightningBolt.setVisualOnly (Z)V
      // 0a7d: aload 48
      // 0a7f: aload 49
      // 0a81: invokevirtual net/minecraft/server/level/ServerLevel.addFreshEntity (Lnet/minecraft/world/entity/Entity;)Z
      // 0a84: pop
      // 0a85: bipush 20
      // 0a87: aload 1
      // 0a88: aload 9
      // 0a8a: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$10 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0a8f: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0a92: aload 11
      // 0a94: instanceof net/minecraft/world/entity/player/Player
      // 0a97: ifeq 0ab8
      // 0a9a: aload 11
      // 0a9c: checkcast net/minecraft/world/entity/player/Player
      // 0a9f: astore 48
      // 0aa1: aload 48
      // 0aa3: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 0aa6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0aa9: ifne 0ab8
      // 0aac: aload 48
      // 0aae: ldc_w "Terrifying demonic entities have appeared in the nether and the end..."
      // 0ab1: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0ab4: bipush 1
      // 0ab5: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 0ab8: aload 11
      // 0aba: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0abd: aconst_null
      // 0abe: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0ac1: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0ac4: dup
      // 0ac5: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0ac8: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0acb: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0ace: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 0ad1: ldc2_w 3.0
      // 0ad4: dcmpl
      // 0ad5: ifne 0b3e
      // 0ad8: aload 1
      // 0ad9: instanceof net/minecraft/server/level/ServerLevel
      // 0adc: ifeq 0b1a
      // 0adf: aload 1
      // 0ae0: checkcast net/minecraft/server/level/ServerLevel
      // 0ae3: astore 48
      // 0ae5: getstatic net/minecraft/world/entity/EntityType.LIGHTNING_BOLT Lnet/minecraft/world/entity/EntityType;
      // 0ae8: aload 48
      // 0aea: invokevirtual net/minecraft/world/entity/EntityType.create (Lnet/minecraft/world/level/Level;)Lnet/minecraft/world/entity/Entity;
      // 0aed: checkcast net/minecraft/world/entity/LightningBolt
      // 0af0: astore 49
      // 0af2: aload 49
      // 0af4: aload 9
      // 0af6: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 0af9: aload 9
      // 0afb: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 0afe: aload 9
      // 0b00: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 0b03: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 0b06: invokestatic net/minecraft/world/phys/Vec3.atBottomCenterOf (Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;
      // 0b09: invokevirtual net/minecraft/world/entity/LightningBolt.moveTo (Lnet/minecraft/world/phys/Vec3;)V
      // 0b0c: aload 49
      // 0b0e: bipush 1
      // 0b0f: invokevirtual net/minecraft/world/entity/LightningBolt.setVisualOnly (Z)V
      // 0b12: aload 48
      // 0b14: aload 49
      // 0b16: invokevirtual net/minecraft/server/level/ServerLevel.addFreshEntity (Lnet/minecraft/world/entity/Entity;)Z
      // 0b19: pop
      // 0b1a: bipush 20
      // 0b1c: aload 1
      // 0b1d: aload 9
      // 0b1f: dload 2
      // 0b20: dload 4
      // 0b22: dload 6
      // 0b24: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$11 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;DDD)V, ()V ]
      // 0b29: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0b2c: bipush 50
      // 0b2e: aload 1
      // 0b2f: aload 9
      // 0b31: dload 2
      // 0b32: dload 4
      // 0b34: dload 6
      // 0b36: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$12 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;DDD)V, ()V ]
      // 0b3b: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0b3e: aload 9
      // 0b40: instanceof net/arphex/entity/HitboxExpanderEntity
      // 0b43: ifeq 0c27
      // 0b46: aload 0
      // 0b47: ifnull 0b56
      // 0b4a: aload 0
      // 0b4b: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0b4e: ifeq 0b56
      // 0b51: aload 0
      // 0b52: bipush 1
      // 0b53: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0b56: aload 9
      // 0b58: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 0b5b: ifnull 0c27
      // 0b5e: aload 9
      // 0b60: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 0b63: astore 46
      // 0b65: aload 46
      // 0b67: instanceof net/minecraft/world/entity/LivingEntity
      // 0b6a: ifeq 0b85
      // 0b6d: aload 46
      // 0b6f: checkcast net/minecraft/world/entity/LivingEntity
      // 0b72: astore 45
      // 0b74: aload 45
      // 0b76: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 0b79: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0b7c: checkcast net/minecraft/world/effect/MobEffect
      // 0b7f: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0b82: ifne 0c27
      // 0b85: dload 12
      // 0b87: ldc2_w 25.0
      // 0b8a: dcmpl
      // 0b8b: ifle 0bf1
      // 0b8e: dload 12
      // 0b90: ldc2_w 250.0
      // 0b93: dcmpg
      // 0b94: ifge 0bf1
      // 0b97: aload 9
      // 0b99: instanceof net/minecraft/world/entity/LivingEntity
      // 0b9c: ifeq 0bae
      // 0b9f: aload 9
      // 0ba1: checkcast net/minecraft/world/entity/LivingEntity
      // 0ba4: astore 46
      // 0ba6: aload 46
      // 0ba8: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 0bab: goto 0bb1
      // 0bae: ldc_w -1.0
      // 0bb1: ldc_w 25.0
      // 0bb4: fcmpl
      // 0bb5: ifle 0bf1
      // 0bb8: aload 9
      // 0bba: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 0bbd: new net/minecraft/world/damagesource/DamageSource
      // 0bc0: dup
      // 0bc1: aload 1
      // 0bc2: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0bc7: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0bca: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 0bcf: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0bd2: new net/minecraft/resources/ResourceLocation
      // 0bd5: dup
      // 0bd6: ldc_w "arphex:segment"
      // 0bd9: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 0bdc: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 0bdf: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0be4: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0be7: ldc_w 25.0
      // 0bea: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0bed: pop
      // 0bee: goto 0c27
      // 0bf1: aload 9
      // 0bf3: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 0bf6: new net/minecraft/world/damagesource/DamageSource
      // 0bf9: dup
      // 0bfa: aload 1
      // 0bfb: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0c00: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0c03: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 0c08: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0c0b: new net/minecraft/resources/ResourceLocation
      // 0c0e: dup
      // 0c0f: ldc_w "arphex:segment"
      // 0c12: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 0c15: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 0c18: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0c1d: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0c20: dload 12
      // 0c22: d2f
      // 0c23: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0c26: pop
      // 0c27: aload 9
      // 0c29: instanceof net/arphex/entity/SpiderMothEntity
      // 0c2c: ifne 0c47
      // 0c2f: aload 9
      // 0c31: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 0c34: ifne 0c47
      // 0c37: aload 9
      // 0c39: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 0c3c: ifne 0c47
      // 0c3f: aload 9
      // 0c41: instanceof net/arphex/entity/CrabConstrictorEntity
      // 0c44: ifeq 0cd0
      // 0c47: dload 12
      // 0c49: ldc2_w 25.0
      // 0c4c: dcmpl
      // 0c4d: ifle 0cd0
      // 0c50: dload 12
      // 0c52: ldc2_w 250.0
      // 0c55: dcmpg
      // 0c56: ifge 0cd0
      // 0c59: aload 9
      // 0c5b: instanceof net/minecraft/world/entity/LivingEntity
      // 0c5e: ifeq 0c70
      // 0c61: aload 9
      // 0c63: checkcast net/minecraft/world/entity/LivingEntity
      // 0c66: astore 45
      // 0c68: aload 45
      // 0c6a: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 0c6d: goto 0c73
      // 0c70: ldc_w -1.0
      // 0c73: ldc_w 25.0
      // 0c76: fcmpl
      // 0c77: ifle 0cd0
      // 0c7a: aload 0
      // 0c7b: ifnull 0c8a
      // 0c7e: aload 0
      // 0c7f: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0c82: ifeq 0c8a
      // 0c85: aload 0
      // 0c86: bipush 1
      // 0c87: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0c8a: aload 9
      // 0c8c: instanceof net/minecraft/world/entity/LivingEntity
      // 0c8f: ifeq 0caa
      // 0c92: aload 9
      // 0c94: checkcast net/minecraft/world/entity/LivingEntity
      // 0c97: astore 46
      // 0c99: aload 46
      // 0c9b: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 0c9e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0ca1: checkcast net/minecraft/world/effect/MobEffect
      // 0ca4: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0ca7: ifne 0cd0
      // 0caa: aload 9
      // 0cac: new net/minecraft/world/damagesource/DamageSource
      // 0caf: dup
      // 0cb0: aload 1
      // 0cb1: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0cb6: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0cb9: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 0cbe: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 0cc1: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0cc6: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0cc9: ldc_w 25.0
      // 0ccc: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0ccf: pop
      // 0cd0: aload 9
      // 0cd2: instanceof net/arphex/entity/TormentorLarvaeEntity
      // 0cd5: ifeq 0d40
      // 0cd8: dload 12
      // 0cda: ldc2_w 25.0
      // 0cdd: dcmpl
      // 0cde: ifle 0d40
      // 0ce1: dload 12
      // 0ce3: ldc2_w 9999999.0
      // 0ce6: dcmpg
      // 0ce7: ifge 0d40
      // 0cea: aload 0
      // 0ceb: ifnull 0cfa
      // 0cee: aload 0
      // 0cef: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0cf2: ifeq 0cfa
      // 0cf5: aload 0
      // 0cf6: bipush 1
      // 0cf7: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0cfa: aload 9
      // 0cfc: instanceof net/minecraft/world/entity/LivingEntity
      // 0cff: ifeq 0d1a
      // 0d02: aload 9
      // 0d04: checkcast net/minecraft/world/entity/LivingEntity
      // 0d07: astore 45
      // 0d09: aload 45
      // 0d0b: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 0d0e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0d11: checkcast net/minecraft/world/effect/MobEffect
      // 0d14: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0d17: ifne 0d40
      // 0d1a: aload 9
      // 0d1c: new net/minecraft/world/damagesource/DamageSource
      // 0d1f: dup
      // 0d20: aload 1
      // 0d21: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0d26: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0d29: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 0d2e: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 0d31: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0d36: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0d39: ldc_w 25.0
      // 0d3c: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0d3f: pop
      // 0d40: aload 9
      // 0d42: instanceof net/arphex/entity/TormentorMothSummonEntity
      // 0d45: ifne 0d58
      // 0d48: aload 9
      // 0d4a: instanceof net/arphex/entity/TormentorScorpioidSummonEntity
      // 0d4d: ifne 0d58
      // 0d50: aload 9
      // 0d52: instanceof net/arphex/entity/TormentorVoidlasherSummonEntity
      // 0d55: ifeq 0e0c
      // 0d58: aload 9
      // 0d5a: instanceof net/minecraft/world/entity/LivingEntity
      // 0d5d: ifeq 0d78
      // 0d60: aload 9
      // 0d62: checkcast net/minecraft/world/entity/LivingEntity
      // 0d65: astore 45
      // 0d67: aload 45
      // 0d69: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 0d6c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0d6f: checkcast net/minecraft/world/effect/MobEffect
      // 0d72: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0d75: ifne 0da6
      // 0d78: aload 9
      // 0d7a: instanceof net/minecraft/world/entity/LivingEntity
      // 0d7d: ifeq 0da0
      // 0d80: aload 9
      // 0d82: checkcast net/minecraft/world/entity/LivingEntity
      // 0d85: astore 46
      // 0d87: aload 46
      // 0d89: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 0d8c: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0d8f: ifeq 0da0
      // 0d92: aload 46
      // 0d94: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 0d97: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 0d9a: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 0d9d: goto 0da1
      // 0da0: bipush 0
      // 0da1: bipush 6
      // 0da3: if_icmpne 0db9
      // 0da6: aload 0
      // 0da7: ifnull 0e0c
      // 0daa: aload 0
      // 0dab: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0dae: ifeq 0e0c
      // 0db1: aload 0
      // 0db2: bipush 1
      // 0db3: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0db6: goto 0e0c
      // 0db9: dload 12
      // 0dbb: ldc2_w 25.0
      // 0dbe: dcmpl
      // 0dbf: ifle 0e01
      // 0dc2: dload 12
      // 0dc4: ldc2_w 9999999.0
      // 0dc7: dcmpg
      // 0dc8: ifge 0e01
      // 0dcb: aload 0
      // 0dcc: ifnull 0ddb
      // 0dcf: aload 0
      // 0dd0: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0dd3: ifeq 0ddb
      // 0dd6: aload 0
      // 0dd7: bipush 1
      // 0dd8: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0ddb: aload 9
      // 0ddd: new net/minecraft/world/damagesource/DamageSource
      // 0de0: dup
      // 0de1: aload 1
      // 0de2: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0de7: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0dea: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 0def: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 0df2: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0df7: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0dfa: ldc_w 25.0
      // 0dfd: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0e00: pop
      // 0e01: bipush 1
      // 0e02: aload 9
      // 0e04: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$13 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0e09: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0e0c: aload 9
      // 0e0e: instanceof net/arphex/entity/SpiderMothEntity
      // 0e11: ifne 0e2c
      // 0e14: aload 9
      // 0e16: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 0e19: ifne 0e2c
      // 0e1c: aload 9
      // 0e1e: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 0e21: ifne 0e2c
      // 0e24: aload 9
      // 0e26: instanceof net/arphex/entity/WaspNemesisEntity
      // 0e29: ifeq 0eef
      // 0e2c: aload 11
      // 0e2e: instanceof net/arphex/entity/CrabConstrictorEntity
      // 0e31: ifeq 0e5b
      // 0e34: bipush 1
      // 0e35: aload 9
      // 0e37: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$14 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0e3c: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0e3f: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 0e42: bipush 1
      // 0e43: bipush 3
      // 0e44: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 0e47: bipush 1
      // 0e48: if_icmpne 0e5b
      // 0e4b: aload 0
      // 0e4c: ifnull 0e5b
      // 0e4f: aload 0
      // 0e50: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0e53: ifeq 0e5b
      // 0e56: aload 0
      // 0e57: bipush 1
      // 0e58: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0e5b: aload 9
      // 0e5d: instanceof net/minecraft/world/entity/LivingEntity
      // 0e60: ifeq 0e7b
      // 0e63: aload 9
      // 0e65: checkcast net/minecraft/world/entity/LivingEntity
      // 0e68: astore 45
      // 0e6a: aload 45
      // 0e6c: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 0e6f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0e72: checkcast net/minecraft/world/effect/MobEffect
      // 0e75: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0e78: ifne 0e86
      // 0e7b: bipush 1
      // 0e7c: aload 9
      // 0e7e: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$15 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0e83: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0e86: aload 9
      // 0e88: instanceof net/minecraft/world/entity/LivingEntity
      // 0e8b: ifeq 0e9d
      // 0e8e: aload 9
      // 0e90: checkcast net/minecraft/world/entity/LivingEntity
      // 0e93: astore 45
      // 0e95: aload 45
      // 0e97: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 0e9a: goto 0ea0
      // 0e9d: ldc_w -1.0
      // 0ea0: ldc_w 25.0
      // 0ea3: fcmpl
      // 0ea4: ifle 0eef
      // 0ea7: dload 12
      // 0ea9: ldc2_w 25.0
      // 0eac: dcmpl
      // 0ead: ifle 0eef
      // 0eb0: dload 12
      // 0eb2: ldc2_w 250.0
      // 0eb5: dcmpg
      // 0eb6: ifge 0eef
      // 0eb9: aload 0
      // 0eba: ifnull 0ec9
      // 0ebd: aload 0
      // 0ebe: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0ec1: ifeq 0ec9
      // 0ec4: aload 0
      // 0ec5: bipush 1
      // 0ec6: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0ec9: aload 9
      // 0ecb: new net/minecraft/world/damagesource/DamageSource
      // 0ece: dup
      // 0ecf: aload 1
      // 0ed0: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0ed5: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0ed8: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 0edd: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 0ee0: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0ee5: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0ee8: ldc_w 25.0
      // 0eeb: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0eee: pop
      // 0eef: aload 9
      // 0ef1: instanceof net/arphex/entity/SpiderReaperEntity
      // 0ef4: ifne 0eff
      // 0ef7: aload 9
      // 0ef9: instanceof net/arphex/entity/SpiderInfestorEntity
      // 0efc: ifeq 0fa6
      // 0eff: aload 9
      // 0f01: instanceof net/minecraft/world/entity/LivingEntity
      // 0f04: ifeq 0f32
      // 0f07: aload 9
      // 0f09: checkcast net/minecraft/world/entity/LivingEntity
      // 0f0c: astore 45
      // 0f0e: aload 45
      // 0f10: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 0f13: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0f16: checkcast net/minecraft/world/effect/MobEffect
      // 0f19: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0f1c: ifeq 0f32
      // 0f1f: aload 0
      // 0f20: ifnull 0fa6
      // 0f23: aload 0
      // 0f24: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0f27: ifeq 0fa6
      // 0f2a: aload 0
      // 0f2b: bipush 1
      // 0f2c: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0f2f: goto 0fa6
      // 0f32: bipush 1
      // 0f33: aload 9
      // 0f35: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$16 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0f3a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0f3d: aload 9
      // 0f3f: instanceof net/minecraft/world/entity/LivingEntity
      // 0f42: ifeq 0f54
      // 0f45: aload 9
      // 0f47: checkcast net/minecraft/world/entity/LivingEntity
      // 0f4a: astore 46
      // 0f4c: aload 46
      // 0f4e: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 0f51: goto 0f57
      // 0f54: ldc_w -1.0
      // 0f57: ldc_w 35.0
      // 0f5a: fcmpl
      // 0f5b: ifle 0fa6
      // 0f5e: dload 12
      // 0f60: ldc2_w 35.0
      // 0f63: dcmpl
      // 0f64: ifle 0fa6
      // 0f67: dload 12
      // 0f69: ldc2_w 250.0
      // 0f6c: dcmpg
      // 0f6d: ifge 0fa6
      // 0f70: aload 0
      // 0f71: ifnull 0f80
      // 0f74: aload 0
      // 0f75: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0f78: ifeq 0f80
      // 0f7b: aload 0
      // 0f7c: bipush 1
      // 0f7d: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0f80: aload 9
      // 0f82: new net/minecraft/world/damagesource/DamageSource
      // 0f85: dup
      // 0f86: aload 1
      // 0f87: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 0f8c: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 0f8f: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 0f94: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 0f97: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 0f9c: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 0f9f: ldc_w 35.0
      // 0fa2: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 0fa5: pop
      // 0fa6: aload 9
      // 0fa8: instanceof net/arphex/entity/CrabConstrictorEntity
      // 0fab: ifne 0fc6
      // 0fae: aload 9
      // 0fb0: instanceof net/arphex/entity/SpiderMatriarchEntity
      // 0fb3: ifne 0fc6
      // 0fb6: aload 9
      // 0fb8: instanceof net/arphex/entity/ArachnoidTrisectorEntity
      // 0fbb: ifne 0fc6
      // 0fbe: aload 9
      // 0fc0: instanceof net/arphex/entity/DiabolosDecimatorEntity
      // 0fc3: ifeq 1086
      // 0fc6: aload 9
      // 0fc8: instanceof net/minecraft/world/entity/LivingEntity
      // 0fcb: ifeq 0ff9
      // 0fce: aload 9
      // 0fd0: checkcast net/minecraft/world/entity/LivingEntity
      // 0fd3: astore 45
      // 0fd5: aload 45
      // 0fd7: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 0fda: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0fdd: checkcast net/minecraft/world/effect/MobEffect
      // 0fe0: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 0fe3: ifeq 0ff9
      // 0fe6: aload 0
      // 0fe7: ifnull 1086
      // 0fea: aload 0
      // 0feb: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 0fee: ifeq 1086
      // 0ff1: aload 0
      // 0ff2: bipush 1
      // 0ff3: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 0ff6: goto 1086
      // 0ff9: aload 9
      // 0ffb: instanceof net/minecraft/world/entity/LivingEntity
      // 0ffe: ifeq 1010
      // 1001: aload 9
      // 1003: checkcast net/minecraft/world/entity/LivingEntity
      // 1006: astore 46
      // 1008: aload 46
      // 100a: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 100d: goto 1013
      // 1010: ldc_w -1.0
      // 1013: ldc_w 40.0
      // 1016: fcmpl
      // 1017: ifle 107b
      // 101a: dload 12
      // 101c: ldc2_w 40.0
      // 101f: dcmpl
      // 1020: ifle 107b
      // 1023: dload 12
      // 1025: ldc2_w 250.0
      // 1028: dcmpg
      // 1029: iflt 1045
      // 102c: aload 9
      // 102e: instanceof net/arphex/entity/ArachnoidTrisectorEntity
      // 1031: ifne 103c
      // 1034: aload 9
      // 1036: instanceof net/arphex/entity/DiabolosDecimatorEntity
      // 1039: ifeq 107b
      // 103c: dload 12
      // 103e: ldc2_w 9.99999999E8
      // 1041: dcmpg
      // 1042: ifge 107b
      // 1045: aload 0
      // 1046: ifnull 1055
      // 1049: aload 0
      // 104a: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 104d: ifeq 1055
      // 1050: aload 0
      // 1051: bipush 1
      // 1052: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 1055: aload 9
      // 1057: new net/minecraft/world/damagesource/DamageSource
      // 105a: dup
      // 105b: aload 1
      // 105c: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 1061: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 1064: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 1069: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 106c: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 1071: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 1074: ldc_w 40.0
      // 1077: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 107a: pop
      // 107b: bipush 1
      // 107c: aload 9
      // 107e: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$17 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1083: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1086: aload 11
      // 1088: instanceof net/arphex/entity/TormentorSummonEntity
      // 108b: ifeq 1136
      // 108e: aload 0
      // 108f: ifnull 109e
      // 1092: aload 0
      // 1093: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 1096: ifeq 109e
      // 1099: aload 0
      // 109a: bipush 1
      // 109b: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 109e: aload 11
      // 10a0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 10a3: ldc_w "attacklimitsummon"
      // 10a6: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 10a9: dconst_0
      // 10aa: dcmpl
      // 10ab: ifgt 1136
      // 10ae: aload 11
      // 10b0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 10b3: ldc_w "attacklimitsummon"
      // 10b6: ldc2_w 20.0
      // 10b9: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 10bc: aload 9
      // 10be: new net/minecraft/world/damagesource/DamageSource
      // 10c1: dup
      // 10c2: aload 1
      // 10c3: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 10c8: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 10cb: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 10d0: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 10d3: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 10d8: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 10db: bipush 20
      // 10dd: aload 11
      // 10df: instanceof net/arphex/entity/TormentorSummonEntity
      // 10e2: ifeq 1100
      // 10e5: aload 11
      // 10e7: checkcast net/arphex/entity/TormentorSummonEntity
      // 10ea: astore 46
      // 10ec: aload 46
      // 10ee: invokevirtual net/arphex/entity/TormentorSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 10f1: getstatic net/arphex/entity/TormentorSummonEntity.DATA_ownerkills Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 10f4: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 10f7: checkcast java/lang/Integer
      // 10fa: invokevirtual java/lang/Integer.intValue ()I
      // 10fd: goto 1101
      // 1100: bipush 0
      // 1101: bipush 2
      // 1102: imul
      // 1103: iadd
      // 1104: aload 9
      // 1106: instanceof net/minecraft/world/entity/LivingEntity
      // 1109: ifeq 111b
      // 110c: aload 9
      // 110e: checkcast net/minecraft/world/entity/LivingEntity
      // 1111: astore 45
      // 1113: aload 45
      // 1115: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 1118: goto 111c
      // 111b: bipush 0
      // 111c: bipush 5
      // 111d: imul
      // 111e: i2f
      // 111f: invokestatic java/lang/Math.round (F)I
      // 1122: isub
      // 1123: i2f
      // 1124: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 1127: pop
      // 1128: bipush 1
      // 1129: aload 9
      // 112b: aload 1
      // 112c: aload 11
      // 112e: invokedynamic run (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$18 (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1133: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1136: aload 9
      // 1138: instanceof net/arphex/entity/TormentorSummonEntity
      // 113b: ifeq 11e5
      // 113e: aload 9
      // 1140: instanceof net/minecraft/world/entity/LivingEntity
      // 1143: ifeq 1171
      // 1146: aload 9
      // 1148: checkcast net/minecraft/world/entity/LivingEntity
      // 114b: astore 45
      // 114d: aload 45
      // 114f: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 1152: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1155: checkcast net/minecraft/world/effect/MobEffect
      // 1158: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 115b: ifeq 1171
      // 115e: aload 0
      // 115f: ifnull 11e5
      // 1162: aload 0
      // 1163: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 1166: ifeq 11e5
      // 1169: aload 0
      // 116a: bipush 1
      // 116b: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 116e: goto 11e5
      // 1171: aload 9
      // 1173: instanceof net/minecraft/world/entity/LivingEntity
      // 1176: ifeq 1188
      // 1179: aload 9
      // 117b: checkcast net/minecraft/world/entity/LivingEntity
      // 117e: astore 46
      // 1180: aload 46
      // 1182: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 1185: goto 118b
      // 1188: ldc_w -1.0
      // 118b: ldc_w 40.0
      // 118e: fcmpl
      // 118f: ifle 11da
      // 1192: dload 12
      // 1194: ldc2_w 40.0
      // 1197: dcmpl
      // 1198: ifle 11da
      // 119b: dload 12
      // 119d: ldc2_w 9.99999999E8
      // 11a0: dcmpg
      // 11a1: ifge 11da
      // 11a4: aload 0
      // 11a5: ifnull 11b4
      // 11a8: aload 0
      // 11a9: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 11ac: ifeq 11b4
      // 11af: aload 0
      // 11b0: bipush 1
      // 11b1: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 11b4: aload 9
      // 11b6: new net/minecraft/world/damagesource/DamageSource
      // 11b9: dup
      // 11ba: aload 1
      // 11bb: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 11c0: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 11c3: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 11c8: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 11cb: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 11d0: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 11d3: ldc_w 40.0
      // 11d6: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 11d9: pop
      // 11da: bipush 1
      // 11db: aload 9
      // 11dd: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$19 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 11e2: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 11e5: aload 9
      // 11e7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 11ea: ldc "tormentor_summon"
      // 11ec: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 11ef: ifeq 1214
      // 11f2: aload 11
      // 11f4: instanceof net/minecraft/world/entity/player/Player
      // 11f7: ifeq 1214
      // 11fa: ldc2_w 12000.0
      // 11fd: dstore 45
      // 11ff: aload 11
      // 1201: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1204: aconst_null
      // 1205: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1208: dload 45
      // 120a: aload 11
      // 120c: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$20 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 1211: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 1214: aload 9
      // 1216: instanceof net/arphex/entity/TORMENTOREntity
      // 1219: ifeq 1228
      // 121c: aload 1
      // 121d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1220: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_hitbox_split D
      // 1223: dconst_0
      // 1224: dcmpl
      // 1225: ifle 1230
      // 1228: aload 9
      // 122a: instanceof net/arphex/entity/TormentorHitboxEntity
      // 122d: ifeq 1cdd
      // 1230: aload 10
      // 1232: instanceof net/arphex/entity/GenesisShotEntity
      // 1235: ifne 1cdd
      // 1238: aload 10
      // 123a: instanceof net/arphex/entity/ChronoShotEntity
      // 123d: ifne 1cdd
      // 1240: aload 10
      // 1242: instanceof net/arphex/entity/TormentBlastEntity
      // 1245: ifne 1cdd
      // 1248: aload 10
      // 124a: instanceof net/arphex/entity/TormentRifleEntity
      // 124d: ifne 1cdd
      // 1250: aload 11
      // 1252: instanceof net/minecraft/world/entity/LivingEntity
      // 1255: ifeq 1267
      // 1258: aload 11
      // 125a: checkcast net/minecraft/world/entity/LivingEntity
      // 125d: astore 45
      // 125f: aload 45
      // 1261: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1264: goto 126a
      // 1267: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 126a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 126d: getstatic net/arphex/init/ArphexModItems.INFINITE_TORMENT Lnet/minecraftforge/registries/RegistryObject;
      // 1270: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1273: if_acmpeq 1cdd
      // 1276: aload 11
      // 1278: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 127b: ldc "creativespectator"
      // 127d: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1280: ifne 128e
      // 1283: aload 11
      // 1285: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1288: ldc "tormentor_target"
      // 128a: bipush 1
      // 128b: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 128e: aload 11
      // 1290: instanceof net/minecraft/world/entity/player/Player
      // 1293: ifeq 12b0
      // 1296: ldc2_w 12000.0
      // 1299: dstore 46
      // 129b: aload 11
      // 129d: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 12a0: aconst_null
      // 12a1: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 12a4: dload 46
      // 12a6: aload 11
      // 12a8: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$21 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 12ad: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 12b0: aload 9
      // 12b2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 12b5: ldc_w "justspawnedminion"
      // 12b8: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 12bb: dconst_0
      // 12bc: dcmpl
      // 12bd: ifgt 1442
      // 12c0: dload 12
      // 12c2: ldc2_w 10.0
      // 12c5: dcmpl
      // 12c6: ifle 1442
      // 12c9: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 12cc: bipush 1
      // 12cd: bipush 40
      // 12cf: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 12d2: bipush 2
      // 12d3: if_icmpne 1442
      // 12d6: aload 1
      // 12d7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 12da: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 12dd: ldc2_w 200.0
      // 12e0: dcmpg
      // 12e1: iflt 12f0
      // 12e4: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 12e7: bipush 1
      // 12e8: bipush 3
      // 12e9: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 12ec: bipush 2
      // 12ed: if_icmpne 1325
      // 12f0: aload 1
      // 12f1: instanceof net/minecraft/server/level/ServerLevel
      // 12f4: ifeq 1325
      // 12f7: aload 1
      // 12f8: checkcast net/minecraft/server/level/ServerLevel
      // 12fb: astore 46
      // 12fd: getstatic net/arphex/init/ArphexModEntities.TORMENTOR_TENDRIL Lnet/minecraftforge/registries/RegistryObject;
      // 1300: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1303: checkcast net/minecraft/world/entity/EntityType
      // 1306: aload 46
      // 1308: dload 2
      // 1309: dload 4
      // 130b: dload 6
      // 130d: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 1310: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 1313: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 1316: astore 47
      // 1318: aload 47
      // 131a: ifnull 1325
      // 131d: aload 47
      // 131f: dconst_0
      // 1320: dconst_0
      // 1321: dconst_0
      // 1322: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 1325: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 1328: bipush 1
      // 1329: bipush 3
      // 132a: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 132d: bipush 2
      // 132e: if_icmpne 1389
      // 1331: aload 9
      // 1333: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1336: ldc_w "justspawnedminion"
      // 1339: ldc2_w 1200.0
      // 133c: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 133f: aload 1
      // 1340: instanceof net/minecraft/server/level/ServerLevel
      // 1343: ifeq 1386
      // 1346: aload 1
      // 1347: checkcast net/minecraft/server/level/ServerLevel
      // 134a: astore 46
      // 134c: getstatic net/arphex/init/ArphexModEntities.TORMENTOR_MOTH_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 134f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1352: checkcast net/minecraft/world/entity/EntityType
      // 1355: aload 46
      // 1357: dload 2
      // 1358: dload 4
      // 135a: dload 6
      // 135c: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 135f: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 1362: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 1365: astore 47
      // 1367: aload 47
      // 1369: ifnull 1386
      // 136c: aload 47
      // 136e: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 1371: ldc2_w -1.0
      // 1374: dconst_1
      // 1375: invokestatic net/minecraft/util/Mth.nextDouble (Lnet/minecraft/util/RandomSource;DD)D
      // 1378: dconst_0
      // 1379: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 137c: ldc2_w -1.0
      // 137f: dconst_1
      // 1380: invokestatic net/minecraft/util/Mth.nextDouble (Lnet/minecraft/util/RandomSource;DD)D
      // 1383: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 1386: goto 1442
      // 1389: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 138c: bipush 1
      // 138d: bipush 2
      // 138e: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 1391: bipush 2
      // 1392: if_icmpne 13ed
      // 1395: aload 9
      // 1397: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 139a: ldc_w "justspawnedminion"
      // 139d: ldc2_w 1200.0
      // 13a0: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 13a3: aload 1
      // 13a4: instanceof net/minecraft/server/level/ServerLevel
      // 13a7: ifeq 13ea
      // 13aa: aload 1
      // 13ab: checkcast net/minecraft/server/level/ServerLevel
      // 13ae: astore 46
      // 13b0: getstatic net/arphex/init/ArphexModEntities.TORMENTOR_SCORPIOID_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 13b3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 13b6: checkcast net/minecraft/world/entity/EntityType
      // 13b9: aload 46
      // 13bb: dload 2
      // 13bc: dload 4
      // 13be: dload 6
      // 13c0: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 13c3: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 13c6: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 13c9: astore 47
      // 13cb: aload 47
      // 13cd: ifnull 13ea
      // 13d0: aload 47
      // 13d2: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 13d5: ldc2_w -1.0
      // 13d8: dconst_1
      // 13d9: invokestatic net/minecraft/util/Mth.nextDouble (Lnet/minecraft/util/RandomSource;DD)D
      // 13dc: dconst_0
      // 13dd: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 13e0: ldc2_w -1.0
      // 13e3: dconst_1
      // 13e4: invokestatic net/minecraft/util/Mth.nextDouble (Lnet/minecraft/util/RandomSource;DD)D
      // 13e7: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 13ea: goto 1442
      // 13ed: aload 9
      // 13ef: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 13f2: ldc_w "justspawnedminion"
      // 13f5: ldc2_w 1200.0
      // 13f8: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 13fb: aload 1
      // 13fc: instanceof net/minecraft/server/level/ServerLevel
      // 13ff: ifeq 1442
      // 1402: aload 1
      // 1403: checkcast net/minecraft/server/level/ServerLevel
      // 1406: astore 46
      // 1408: getstatic net/arphex/init/ArphexModEntities.TORMENTOR_VOIDLASHER_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 140b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 140e: checkcast net/minecraft/world/entity/EntityType
      // 1411: aload 46
      // 1413: dload 2
      // 1414: dload 4
      // 1416: dload 6
      // 1418: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 141b: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 141e: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 1421: astore 47
      // 1423: aload 47
      // 1425: ifnull 1442
      // 1428: aload 47
      // 142a: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 142d: ldc2_w -1.0
      // 1430: dconst_1
      // 1431: invokestatic net/minecraft/util/Mth.nextDouble (Lnet/minecraft/util/RandomSource;DD)D
      // 1434: dconst_0
      // 1435: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 1438: ldc2_w -1.0
      // 143b: dconst_1
      // 143c: invokestatic net/minecraft/util/Mth.nextDouble (Lnet/minecraft/util/RandomSource;DD)D
      // 143f: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 1442: aload 1
      // 1443: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1446: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 1449: aload 11
      // 144b: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 144e: f2d
      // 144f: dsub
      // 1450: ldc2_w 180.0
      // 1453: dadd
      // 1454: ldc2_w 360.0
      // 1457: drem
      // 1458: ldc2_w 360.0
      // 145b: dadd
      // 145c: ldc2_w 360.0
      // 145f: drem
      // 1460: ldc2_w 180.0
      // 1463: dsub
      // 1464: invokestatic java/lang/Math.abs (D)D
      // 1467: dstore 41
      // 1469: dload 41
      // 146b: ldc2_w 90.0
      // 146e: dcmpl
      // 146f: ifgt 1489
      // 1472: aload 9
      // 1474: aload 11
      // 1476: if_acmpne 1cc5
      // 1479: aload 9
      // 147b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 147e: ldc_w "able_to_harm_self"
      // 1481: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1484: dconst_0
      // 1485: dcmpl
      // 1486: ifle 1cc5
      // 1489: aload 9
      // 148b: instanceof net/minecraft/world/entity/LivingEntity
      // 148e: ifeq 14a0
      // 1491: aload 9
      // 1493: checkcast net/minecraft/world/entity/LivingEntity
      // 1496: astore 46
      // 1498: aload 46
      // 149a: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 149d: goto 14a3
      // 14a0: ldc_w -1.0
      // 14a3: fconst_0
      // 14a4: fcmpl
      // 14a5: ifle 1c9a
      // 14a8: dload 12
      // 14aa: ldc2_w 10.0
      // 14ad: dcmpl
      // 14ae: ifle 1c9a
      // 14b1: aload 9
      // 14b3: instanceof net/minecraft/world/entity/LivingEntity
      // 14b6: ifeq 14cb
      // 14b9: aload 9
      // 14bb: checkcast net/minecraft/world/entity/LivingEntity
      // 14be: astore 47
      // 14c0: aload 47
      // 14c2: getstatic net/minecraft/world/effect/MobEffects.HUNGER Lnet/minecraft/world/effect/MobEffect;
      // 14c5: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 14c8: ifne 1cdd
      // 14cb: aload 1
      // 14cc: instanceof net/minecraft/world/level/Level
      // 14cf: ifeq 14e0
      // 14d2: aload 1
      // 14d3: checkcast net/minecraft/world/level/Level
      // 14d6: astore 48
      // 14d8: aload 48
      // 14da: invokevirtual net/minecraft/world/level/Level.dimension ()Lnet/minecraft/resources/ResourceKey;
      // 14dd: goto 14fd
      // 14e0: aload 1
      // 14e1: instanceof net/minecraft/world/level/WorldGenLevel
      // 14e4: ifeq 14fa
      // 14e7: aload 1
      // 14e8: checkcast net/minecraft/world/level/WorldGenLevel
      // 14eb: astore 49
      // 14ed: aload 49
      // 14ef: invokeinterface net/minecraft/world/level/WorldGenLevel.getLevel ()Lnet/minecraft/server/level/ServerLevel; 1
      // 14f4: invokevirtual net/minecraft/server/level/ServerLevel.dimension ()Lnet/minecraft/resources/ResourceKey;
      // 14f7: goto 14fd
      // 14fa: getstatic net/minecraft/world/level/Level.OVERWORLD Lnet/minecraft/resources/ResourceKey;
      // 14fd: getstatic net/minecraft/core/registries/Registries.DIMENSION Lnet/minecraft/resources/ResourceKey;
      // 1500: new net/minecraft/resources/ResourceLocation
      // 1503: dup
      // 1504: ldc_w "arphex:the_crawling"
      // 1507: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 150a: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 150d: if_acmpeq 1cdd
      // 1510: aload 9
      // 1512: instanceof net/minecraft/world/entity/LivingEntity
      // 1515: ifeq 1538
      // 1518: aload 9
      // 151a: checkcast net/minecraft/world/entity/LivingEntity
      // 151d: astore 50
      // 151f: aload 50
      // 1521: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 1524: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 1527: ifeq 1538
      // 152a: aload 50
      // 152c: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 152f: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 1532: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 1535: goto 1539
      // 1538: bipush 0
      // 1539: bipush 3
      // 153a: if_icmple 1544
      // 153d: aload 9
      // 153f: aload 11
      // 1541: if_acmpne 1cdd
      // 1544: aload 1
      // 1545: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1548: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_variable_damage_limit D
      // 154b: dconst_0
      // 154c: dcmpl
      // 154d: ifle 1557
      // 1550: aload 9
      // 1552: aload 11
      // 1554: if_acmpne 1cdd
      // 1557: aload 1
      // 1558: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 155b: getfield net/arphex/network/ArphexModVariables$MapVariables.limhit_tormentor Z
      // 155e: ifne 1c37
      // 1561: aload 1
      // 1562: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1565: bipush 1
      // 1566: putfield net/arphex/network/ArphexModVariables$MapVariables.limhit_tormentor Z
      // 1569: aload 1
      // 156a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 156d: aload 1
      // 156e: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1571: new java/util/ArrayList
      // 1574: dup
      // 1575: aload 1
      // 1576: invokeinterface net/minecraft/world/level/LevelAccessor.players ()Ljava/util/List; 1
      // 157b: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 157e: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 1581: astore 51
      // 1583: aload 51
      // 1585: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 158a: ifeq 19d4
      // 158d: aload 51
      // 158f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1594: checkcast net/minecraft/world/entity/Entity
      // 1597: astore 52
      // 1599: aload 1
      // 159a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 159d: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 15a0: dconst_1
      // 15a1: dcmpl
      // 15a2: ifne 1670
      // 15a5: aload 1
      // 15a6: ldc_w net/arphex/entity/TormentorTestEntity
      // 15a9: new net/minecraft/world/phys/Vec3
      // 15ac: dup
      // 15ad: aload 52
      // 15af: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 15b2: aload 52
      // 15b4: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 15b7: aload 52
      // 15b9: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 15bc: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 15bf: ldc2_w 100.0
      // 15c2: ldc2_w 100.0
      // 15c5: ldc2_w 100.0
      // 15c8: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 15cb: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$22 (Lnet/arphex/entity/TormentorTestEntity;)Z, (Lnet/arphex/entity/TormentorTestEntity;)Z ]
      // 15d0: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 15d5: invokeinterface java/util/List.isEmpty ()Z 1
      // 15da: ifne 19d1
      // 15dd: aload 1
      // 15de: ldc_w net/arphex/entity/TormentorTestEntity
      // 15e1: new net/minecraft/world/phys/Vec3
      // 15e4: dup
      // 15e5: aload 52
      // 15e7: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 15ea: aload 52
      // 15ec: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 15ef: aload 52
      // 15f1: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 15f4: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 15f7: ldc2_w 100.0
      // 15fa: ldc2_w 100.0
      // 15fd: ldc2_w 100.0
      // 1600: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 1603: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$23 (Lnet/arphex/entity/TormentorTestEntity;)Z, (Lnet/arphex/entity/TormentorTestEntity;)Z ]
      // 1608: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 160d: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 1612: new net/arphex/procedures/DwellerLifestealProcedure$1
      // 1615: dup
      // 1616: invokespecial net/arphex/procedures/DwellerLifestealProcedure$1.<init> ()V
      // 1619: aload 52
      // 161b: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 161e: aload 52
      // 1620: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1623: aload 52
      // 1625: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1628: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$1.compareDistOf (DDD)Ljava/util/Comparator;
      // 162b: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 1630: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 1635: aconst_null
      // 1636: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1639: checkcast net/minecraft/world/entity/Entity
      // 163c: new net/minecraft/world/damagesource/DamageSource
      // 163f: dup
      // 1640: aload 1
      // 1641: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 1646: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 1649: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 164e: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 1651: new net/minecraft/resources/ResourceLocation
      // 1654: dup
      // 1655: ldc_w "arphex:segment"
      // 1658: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 165b: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 165e: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 1663: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 1666: ldc_w 5.0
      // 1669: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 166c: pop
      // 166d: goto 19d1
      // 1670: aload 1
      // 1671: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1674: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 1677: ldc2_w 2.0
      // 167a: dcmpl
      // 167b: ifne 1749
      // 167e: aload 1
      // 167f: ldc_w net/arphex/entity/TormentorT2Entity
      // 1682: new net/minecraft/world/phys/Vec3
      // 1685: dup
      // 1686: aload 52
      // 1688: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 168b: aload 52
      // 168d: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1690: aload 52
      // 1692: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1695: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1698: ldc2_w 100.0
      // 169b: ldc2_w 100.0
      // 169e: ldc2_w 100.0
      // 16a1: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 16a4: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$24 (Lnet/arphex/entity/TormentorT2Entity;)Z, (Lnet/arphex/entity/TormentorT2Entity;)Z ]
      // 16a9: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 16ae: invokeinterface java/util/List.isEmpty ()Z 1
      // 16b3: ifne 19d1
      // 16b6: aload 1
      // 16b7: ldc_w net/arphex/entity/TormentorT2Entity
      // 16ba: new net/minecraft/world/phys/Vec3
      // 16bd: dup
      // 16be: aload 52
      // 16c0: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 16c3: aload 52
      // 16c5: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 16c8: aload 52
      // 16ca: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 16cd: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 16d0: ldc2_w 100.0
      // 16d3: ldc2_w 100.0
      // 16d6: ldc2_w 100.0
      // 16d9: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 16dc: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$25 (Lnet/arphex/entity/TormentorT2Entity;)Z, (Lnet/arphex/entity/TormentorT2Entity;)Z ]
      // 16e1: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 16e6: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 16eb: new net/arphex/procedures/DwellerLifestealProcedure$2
      // 16ee: dup
      // 16ef: invokespecial net/arphex/procedures/DwellerLifestealProcedure$2.<init> ()V
      // 16f2: aload 52
      // 16f4: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 16f7: aload 52
      // 16f9: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 16fc: aload 52
      // 16fe: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1701: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$2.compareDistOf (DDD)Ljava/util/Comparator;
      // 1704: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 1709: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 170e: aconst_null
      // 170f: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1712: checkcast net/minecraft/world/entity/Entity
      // 1715: new net/minecraft/world/damagesource/DamageSource
      // 1718: dup
      // 1719: aload 1
      // 171a: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 171f: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 1722: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 1727: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 172a: new net/minecraft/resources/ResourceLocation
      // 172d: dup
      // 172e: ldc_w "arphex:segment"
      // 1731: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 1734: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 1737: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 173c: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 173f: ldc_w 5.0
      // 1742: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 1745: pop
      // 1746: goto 19d1
      // 1749: aload 1
      // 174a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 174d: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 1750: ldc2_w 3.0
      // 1753: dcmpl
      // 1754: ifne 1822
      // 1757: aload 1
      // 1758: ldc_w net/arphex/entity/TormentorT3Entity
      // 175b: new net/minecraft/world/phys/Vec3
      // 175e: dup
      // 175f: aload 52
      // 1761: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 1764: aload 52
      // 1766: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1769: aload 52
      // 176b: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 176e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1771: ldc2_w 100.0
      // 1774: ldc2_w 100.0
      // 1777: ldc2_w 100.0
      // 177a: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 177d: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$26 (Lnet/arphex/entity/TormentorT3Entity;)Z, (Lnet/arphex/entity/TormentorT3Entity;)Z ]
      // 1782: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 1787: invokeinterface java/util/List.isEmpty ()Z 1
      // 178c: ifne 19d1
      // 178f: aload 1
      // 1790: ldc_w net/arphex/entity/TormentorT3Entity
      // 1793: new net/minecraft/world/phys/Vec3
      // 1796: dup
      // 1797: aload 52
      // 1799: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 179c: aload 52
      // 179e: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 17a1: aload 52
      // 17a3: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 17a6: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 17a9: ldc2_w 100.0
      // 17ac: ldc2_w 100.0
      // 17af: ldc2_w 100.0
      // 17b2: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 17b5: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$27 (Lnet/arphex/entity/TormentorT3Entity;)Z, (Lnet/arphex/entity/TormentorT3Entity;)Z ]
      // 17ba: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 17bf: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 17c4: new net/arphex/procedures/DwellerLifestealProcedure$3
      // 17c7: dup
      // 17c8: invokespecial net/arphex/procedures/DwellerLifestealProcedure$3.<init> ()V
      // 17cb: aload 52
      // 17cd: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 17d0: aload 52
      // 17d2: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 17d5: aload 52
      // 17d7: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 17da: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$3.compareDistOf (DDD)Ljava/util/Comparator;
      // 17dd: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 17e2: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 17e7: aconst_null
      // 17e8: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 17eb: checkcast net/minecraft/world/entity/Entity
      // 17ee: new net/minecraft/world/damagesource/DamageSource
      // 17f1: dup
      // 17f2: aload 1
      // 17f3: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 17f8: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 17fb: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 1800: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 1803: new net/minecraft/resources/ResourceLocation
      // 1806: dup
      // 1807: ldc_w "arphex:segment"
      // 180a: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 180d: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 1810: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 1815: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 1818: ldc_w 5.0
      // 181b: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 181e: pop
      // 181f: goto 19d1
      // 1822: aload 1
      // 1823: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1826: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 1829: ldc2_w 4.0
      // 182c: dcmpl
      // 182d: ifne 18fb
      // 1830: aload 1
      // 1831: ldc_w net/arphex/entity/TormentorT4Entity
      // 1834: new net/minecraft/world/phys/Vec3
      // 1837: dup
      // 1838: aload 52
      // 183a: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 183d: aload 52
      // 183f: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1842: aload 52
      // 1844: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1847: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 184a: ldc2_w 100.0
      // 184d: ldc2_w 100.0
      // 1850: ldc2_w 100.0
      // 1853: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 1856: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$28 (Lnet/arphex/entity/TormentorT4Entity;)Z, (Lnet/arphex/entity/TormentorT4Entity;)Z ]
      // 185b: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 1860: invokeinterface java/util/List.isEmpty ()Z 1
      // 1865: ifne 19d1
      // 1868: aload 1
      // 1869: ldc_w net/arphex/entity/TormentorT4Entity
      // 186c: new net/minecraft/world/phys/Vec3
      // 186f: dup
      // 1870: aload 52
      // 1872: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 1875: aload 52
      // 1877: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 187a: aload 52
      // 187c: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 187f: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1882: ldc2_w 100.0
      // 1885: ldc2_w 100.0
      // 1888: ldc2_w 100.0
      // 188b: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 188e: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$29 (Lnet/arphex/entity/TormentorT4Entity;)Z, (Lnet/arphex/entity/TormentorT4Entity;)Z ]
      // 1893: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 1898: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 189d: new net/arphex/procedures/DwellerLifestealProcedure$4
      // 18a0: dup
      // 18a1: invokespecial net/arphex/procedures/DwellerLifestealProcedure$4.<init> ()V
      // 18a4: aload 52
      // 18a6: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 18a9: aload 52
      // 18ab: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 18ae: aload 52
      // 18b0: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 18b3: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$4.compareDistOf (DDD)Ljava/util/Comparator;
      // 18b6: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 18bb: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 18c0: aconst_null
      // 18c1: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 18c4: checkcast net/minecraft/world/entity/Entity
      // 18c7: new net/minecraft/world/damagesource/DamageSource
      // 18ca: dup
      // 18cb: aload 1
      // 18cc: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 18d1: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 18d4: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 18d9: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 18dc: new net/minecraft/resources/ResourceLocation
      // 18df: dup
      // 18e0: ldc_w "arphex:segment"
      // 18e3: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 18e6: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 18e9: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 18ee: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 18f1: ldc_w 5.0
      // 18f4: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 18f7: pop
      // 18f8: goto 19d1
      // 18fb: aload 1
      // 18fc: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 18ff: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 1902: ldc2_w 5.0
      // 1905: dcmpl
      // 1906: ifne 19d1
      // 1909: aload 1
      // 190a: ldc_w net/arphex/entity/TormentorT5Entity
      // 190d: new net/minecraft/world/phys/Vec3
      // 1910: dup
      // 1911: aload 52
      // 1913: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 1916: aload 52
      // 1918: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 191b: aload 52
      // 191d: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1920: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1923: ldc2_w 100.0
      // 1926: ldc2_w 100.0
      // 1929: ldc2_w 100.0
      // 192c: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 192f: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$30 (Lnet/arphex/entity/TormentorT5Entity;)Z, (Lnet/arphex/entity/TormentorT5Entity;)Z ]
      // 1934: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 1939: invokeinterface java/util/List.isEmpty ()Z 1
      // 193e: ifne 19d1
      // 1941: aload 1
      // 1942: ldc_w net/arphex/entity/TormentorT5Entity
      // 1945: new net/minecraft/world/phys/Vec3
      // 1948: dup
      // 1949: aload 52
      // 194b: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 194e: aload 52
      // 1950: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1953: aload 52
      // 1955: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1958: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 195b: ldc2_w 100.0
      // 195e: ldc2_w 100.0
      // 1961: ldc2_w 100.0
      // 1964: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 1967: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$31 (Lnet/arphex/entity/TormentorT5Entity;)Z, (Lnet/arphex/entity/TormentorT5Entity;)Z ]
      // 196c: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 1971: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 1976: new net/arphex/procedures/DwellerLifestealProcedure$5
      // 1979: dup
      // 197a: invokespecial net/arphex/procedures/DwellerLifestealProcedure$5.<init> ()V
      // 197d: aload 52
      // 197f: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 1982: aload 52
      // 1984: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1987: aload 52
      // 1989: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 198c: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$5.compareDistOf (DDD)Ljava/util/Comparator;
      // 198f: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 1994: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 1999: aconst_null
      // 199a: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 199d: checkcast net/minecraft/world/entity/Entity
      // 19a0: new net/minecraft/world/damagesource/DamageSource
      // 19a3: dup
      // 19a4: aload 1
      // 19a5: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 19aa: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 19ad: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 19b2: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 19b5: new net/minecraft/resources/ResourceLocation
      // 19b8: dup
      // 19b9: ldc_w "arphex:segment"
      // 19bc: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 19bf: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 19c2: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 19c7: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 19ca: ldc_w 5.0
      // 19cd: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 19d0: pop
      // 19d1: goto 1583
      // 19d4: aload 9
      // 19d6: aload 11
      // 19d8: if_acmpne 1a16
      // 19db: aload 1
      // 19dc: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 19df: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 19e2: ldc2_w 5.0
      // 19e5: dcmpl
      // 19e6: ifle 1a06
      // 19e9: aload 1
      // 19ea: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 19ed: aload 1
      // 19ee: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 19f1: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 19f4: ldc2_w 5.0
      // 19f7: dsub
      // 19f8: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 19fb: aload 1
      // 19fc: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 19ff: aload 1
      // 1a00: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1a03: goto 1a16
      // 1a06: aload 1
      // 1a07: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a0a: dconst_1
      // 1a0b: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1a0e: aload 1
      // 1a0f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a12: aload 1
      // 1a13: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1a16: aload 11
      // 1a18: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1a1b: aconst_null
      // 1a1c: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1a1f: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1a22: dup
      // 1a23: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1a26: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1a29: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1a2c: getfield net/arphex/network/ArphexModVariables$PlayerVariables.inherent_power_cooldown D
      // 1a2f: ldc2_w 10800.0
      // 1a32: dcmpl
      // 1a33: ifle 1a41
      // 1a36: dload 12
      // 1a38: ldc2_w 2.0
      // 1a3b: dmul
      // 1a3c: dstore 39
      // 1a3e: goto 1a45
      // 1a41: dload 12
      // 1a43: dstore 39
      // 1a45: dload 39
      // 1a47: ldc2_w 100.0
      // 1a4a: dcmpl
      // 1a4b: ifle 1a8c
      // 1a4e: aload 1
      // 1a4f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a52: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1a55: ldc2_w 10.0
      // 1a58: dcmpl
      // 1a59: ifle 1a79
      // 1a5c: aload 1
      // 1a5d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a60: aload 1
      // 1a61: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a64: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1a67: ldc2_w 10.0
      // 1a6a: dsub
      // 1a6b: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1a6e: aload 1
      // 1a6f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a72: aload 1
      // 1a73: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1a76: goto 1c37
      // 1a79: aload 1
      // 1a7a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a7d: dconst_1
      // 1a7e: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1a81: aload 1
      // 1a82: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a85: aload 1
      // 1a86: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1a89: goto 1c37
      // 1a8c: dload 39
      // 1a8e: ldc2_w 90.0
      // 1a91: dcmpl
      // 1a92: ifle 1ad3
      // 1a95: aload 1
      // 1a96: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1a99: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1a9c: ldc2_w 9.0
      // 1a9f: dcmpl
      // 1aa0: ifle 1ac0
      // 1aa3: aload 1
      // 1aa4: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1aa7: aload 1
      // 1aa8: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1aab: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1aae: ldc2_w 9.0
      // 1ab1: dsub
      // 1ab2: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1ab5: aload 1
      // 1ab6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1ab9: aload 1
      // 1aba: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1abd: goto 1c37
      // 1ac0: aload 1
      // 1ac1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1ac4: dconst_1
      // 1ac5: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1ac8: aload 1
      // 1ac9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1acc: aload 1
      // 1acd: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1ad0: goto 1c37
      // 1ad3: dload 39
      // 1ad5: ldc2_w 80.0
      // 1ad8: dcmpl
      // 1ad9: ifle 1b1a
      // 1adc: aload 1
      // 1add: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1ae0: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1ae3: ldc2_w 8.0
      // 1ae6: dcmpl
      // 1ae7: ifle 1b07
      // 1aea: aload 1
      // 1aeb: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1aee: aload 1
      // 1aef: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1af2: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1af5: ldc2_w 8.0
      // 1af8: dsub
      // 1af9: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1afc: aload 1
      // 1afd: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b00: aload 1
      // 1b01: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1b04: goto 1c37
      // 1b07: aload 1
      // 1b08: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b0b: dconst_1
      // 1b0c: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b0f: aload 1
      // 1b10: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b13: aload 1
      // 1b14: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1b17: goto 1c37
      // 1b1a: dload 39
      // 1b1c: ldc2_w 70.0
      // 1b1f: dcmpl
      // 1b20: ifle 1b61
      // 1b23: aload 1
      // 1b24: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b27: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b2a: ldc2_w 7.0
      // 1b2d: dcmpl
      // 1b2e: ifle 1b4e
      // 1b31: aload 1
      // 1b32: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b35: aload 1
      // 1b36: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b39: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b3c: ldc2_w 7.0
      // 1b3f: dsub
      // 1b40: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b43: aload 1
      // 1b44: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b47: aload 1
      // 1b48: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1b4b: goto 1c37
      // 1b4e: aload 1
      // 1b4f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b52: dconst_1
      // 1b53: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b56: aload 1
      // 1b57: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b5a: aload 1
      // 1b5b: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1b5e: goto 1c37
      // 1b61: dload 39
      // 1b63: ldc2_w 60.0
      // 1b66: dcmpl
      // 1b67: ifle 1b87
      // 1b6a: aload 1
      // 1b6b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b6e: aload 1
      // 1b6f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b72: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b75: ldc2_w 6.0
      // 1b78: dsub
      // 1b79: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b7c: aload 1
      // 1b7d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b80: aload 1
      // 1b81: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1b84: goto 1c37
      // 1b87: dload 39
      // 1b89: ldc2_w 50.0
      // 1b8c: dcmpl
      // 1b8d: ifle 1bad
      // 1b90: aload 1
      // 1b91: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b94: aload 1
      // 1b95: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1b98: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1b9b: ldc2_w 5.0
      // 1b9e: dsub
      // 1b9f: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1ba2: aload 1
      // 1ba3: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1ba6: aload 1
      // 1ba7: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1baa: goto 1c37
      // 1bad: dload 39
      // 1baf: ldc2_w 40.0
      // 1bb2: dcmpl
      // 1bb3: ifle 1bd3
      // 1bb6: aload 1
      // 1bb7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1bba: aload 1
      // 1bbb: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1bbe: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1bc1: ldc2_w 4.0
      // 1bc4: dsub
      // 1bc5: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1bc8: aload 1
      // 1bc9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1bcc: aload 1
      // 1bcd: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1bd0: goto 1c37
      // 1bd3: dload 39
      // 1bd5: ldc2_w 30.0
      // 1bd8: dcmpl
      // 1bd9: ifle 1bf9
      // 1bdc: aload 1
      // 1bdd: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1be0: aload 1
      // 1be1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1be4: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1be7: ldc2_w 3.0
      // 1bea: dsub
      // 1beb: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1bee: aload 1
      // 1bef: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1bf2: aload 1
      // 1bf3: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1bf6: goto 1c37
      // 1bf9: dload 39
      // 1bfb: ldc2_w 20.0
      // 1bfe: dcmpl
      // 1bff: ifle 1c1f
      // 1c02: aload 1
      // 1c03: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c06: aload 1
      // 1c07: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c0a: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1c0d: ldc2_w 2.0
      // 1c10: dsub
      // 1c11: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1c14: aload 1
      // 1c15: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c18: aload 1
      // 1c19: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1c1c: goto 1c37
      // 1c1f: aload 1
      // 1c20: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c23: aload 1
      // 1c24: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c27: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1c2a: dconst_1
      // 1c2b: dsub
      // 1c2c: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1c2f: aload 1
      // 1c30: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c33: aload 1
      // 1c34: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1c37: aload 9
      // 1c39: instanceof net/minecraft/world/entity/LivingEntity
      // 1c3c: ifeq 1c71
      // 1c3f: aload 9
      // 1c41: checkcast net/minecraft/world/entity/LivingEntity
      // 1c44: astore 51
      // 1c46: aload 51
      // 1c48: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1c4b: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 1c4e: ifne 1c71
      // 1c51: aload 51
      // 1c53: new net/minecraft/world/effect/MobEffectInstance
      // 1c56: dup
      // 1c57: getstatic net/minecraft/world/effect/MobEffects.HUNGER Lnet/minecraft/world/effect/MobEffect;
      // 1c5a: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_HIT_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 1c5d: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 1c60: checkcast java/lang/Double
      // 1c63: invokevirtual java/lang/Double.doubleValue ()D
      // 1c66: d2i
      // 1c67: bipush 0
      // 1c68: bipush 0
      // 1c69: bipush 0
      // 1c6a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1c6d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1c70: pop
      // 1c71: aload 1
      // 1c72: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c75: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_HIT_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 1c78: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 1c7b: checkcast java/lang/Double
      // 1c7e: invokevirtual java/lang/Double.doubleValue ()D
      // 1c81: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_variable_damage_limit D
      // 1c84: aload 1
      // 1c85: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1c88: aload 1
      // 1c89: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 1c8c: bipush 1
      // 1c8d: aload 9
      // 1c8f: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$32 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1c94: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1c97: goto 1cdd
      // 1c9a: aload 11
      // 1c9c: instanceof net/minecraft/world/entity/player/Player
      // 1c9f: ifeq 1cdd
      // 1ca2: aload 9
      // 1ca4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1ca7: ldc_w "checktormentorlower"
      // 1caa: aload 1
      // 1cab: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1cae: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 1cb1: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1cb4: bipush 2
      // 1cb5: aload 1
      // 1cb6: aload 9
      // 1cb8: aload 11
      // 1cba: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$33 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1cbf: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1cc2: goto 1cdd
      // 1cc5: aload 11
      // 1cc7: instanceof net/arphex/entity/TORMENTOREntity
      // 1cca: ifne 1cdd
      // 1ccd: aload 0
      // 1cce: ifnull 1cdd
      // 1cd1: aload 0
      // 1cd2: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 1cd5: ifeq 1cdd
      // 1cd8: aload 0
      // 1cd9: bipush 1
      // 1cda: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 1cdd: aload 9
      // 1cdf: instanceof net/arphex/entity/SpiderSnatcherEntity
      // 1ce2: ifne 1d15
      // 1ce5: aload 9
      // 1ce7: instanceof net/arphex/entity/WaspNemesisEntity
      // 1cea: ifne 1d15
      // 1ced: aload 9
      // 1cef: instanceof net/arphex/entity/SpiderReaperEntity
      // 1cf2: ifne 1d15
      // 1cf5: aload 9
      // 1cf7: instanceof net/arphex/entity/CentipedeEvictorEntity
      // 1cfa: ifne 1d15
      // 1cfd: aload 9
      // 1cff: instanceof net/arphex/entity/SpiderProwlerEntity
      // 1d02: ifne 1d15
      // 1d05: aload 9
      // 1d07: instanceof net/arphex/entity/SolifugeSkulkerEntity
      // 1d0a: ifne 1d15
      // 1d0d: aload 9
      // 1d0f: instanceof net/arphex/entity/CrabConstrictorEntity
      // 1d12: ifeq 1d7e
      // 1d15: dload 12
      // 1d17: ldc2_w 50.0
      // 1d1a: dcmpl
      // 1d1b: ifle 1d7e
      // 1d1e: dload 12
      // 1d20: ldc2_w 250.0
      // 1d23: dcmpg
      // 1d24: ifge 1d7e
      // 1d27: aload 9
      // 1d29: instanceof net/minecraft/world/entity/LivingEntity
      // 1d2c: ifeq 1d3e
      // 1d2f: aload 9
      // 1d31: checkcast net/minecraft/world/entity/LivingEntity
      // 1d34: astore 45
      // 1d36: aload 45
      // 1d38: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 1d3b: goto 1d41
      // 1d3e: ldc_w -1.0
      // 1d41: ldc_w 50.0
      // 1d44: fcmpl
      // 1d45: ifle 1d7e
      // 1d48: aload 0
      // 1d49: ifnull 1d58
      // 1d4c: aload 0
      // 1d4d: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 1d50: ifeq 1d58
      // 1d53: aload 0
      // 1d54: bipush 1
      // 1d55: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 1d58: aload 9
      // 1d5a: new net/minecraft/world/damagesource/DamageSource
      // 1d5d: dup
      // 1d5e: aload 1
      // 1d5f: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 1d64: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 1d67: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 1d6c: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 1d6f: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 1d74: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 1d77: ldc_w 50.0
      // 1d7a: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 1d7d: pop
      // 1d7e: aload 9
      // 1d80: instanceof net/arphex/entity/TormentorTendrilEntity
      // 1d83: ifeq 1def
      // 1d86: dload 12
      // 1d88: ldc2_w 20.0
      // 1d8b: dcmpl
      // 1d8c: ifle 1def
      // 1d8f: dload 12
      // 1d91: ldc2_w 9.9999999E7
      // 1d94: dcmpg
      // 1d95: ifge 1def
      // 1d98: aload 9
      // 1d9a: instanceof net/minecraft/world/entity/LivingEntity
      // 1d9d: ifeq 1daf
      // 1da0: aload 9
      // 1da2: checkcast net/minecraft/world/entity/LivingEntity
      // 1da5: astore 45
      // 1da7: aload 45
      // 1da9: invokevirtual net/minecraft/world/entity/LivingEntity.getHealth ()F
      // 1dac: goto 1db2
      // 1daf: ldc_w -1.0
      // 1db2: ldc_w 20.0
      // 1db5: fcmpl
      // 1db6: ifle 1def
      // 1db9: aload 0
      // 1dba: ifnull 1dc9
      // 1dbd: aload 0
      // 1dbe: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 1dc1: ifeq 1dc9
      // 1dc4: aload 0
      // 1dc5: bipush 1
      // 1dc6: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 1dc9: aload 9
      // 1dcb: new net/minecraft/world/damagesource/DamageSource
      // 1dce: dup
      // 1dcf: aload 1
      // 1dd0: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 1dd5: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 1dd8: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 1ddd: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 1de0: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 1de5: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 1de8: ldc_w 20.0
      // 1deb: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 1dee: pop
      // 1def: aload 11
      // 1df1: instanceof net/minecraft/world/entity/player/Player
      // 1df4: ifeq 1e21
      // 1df7: aload 9
      // 1df9: instanceof net/arphex/entity/SpiderMothEntity
      // 1dfc: ifeq 1e21
      // 1dff: aload 9
      // 1e01: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1e04: ldc_w "playerlookedatmoth"
      // 1e07: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 1e0a: ldc_w "no"
      // 1e0d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1e10: ifeq 1e21
      // 1e13: aload 9
      // 1e15: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1e18: ldc_w "playerlookedatmoth"
      // 1e1b: ldc_w "looking"
      // 1e1e: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 1e21: aload 9
      // 1e23: instanceof net/arphex/entity/SpiderMothEntity
      // 1e26: ifeq 1e89
      // 1e29: aload 11
      // 1e2b: instanceof net/minecraft/world/entity/LivingEntity
      // 1e2e: ifeq 1e40
      // 1e31: aload 11
      // 1e33: checkcast net/minecraft/world/entity/LivingEntity
      // 1e36: astore 45
      // 1e38: aload 45
      // 1e3a: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1e3d: goto 1e43
      // 1e40: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1e43: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1e46: getstatic net/arphex/init/ArphexModItems.BANE_OF_THE_DARKNESS Lnet/minecraftforge/registries/RegistryObject;
      // 1e49: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1e4c: if_acmpne 1e89
      // 1e4f: aload 1
      // 1e50: instanceof net/minecraft/server/level/ServerLevel
      // 1e53: ifeq 1e7e
      // 1e56: aload 1
      // 1e57: checkcast net/minecraft/server/level/ServerLevel
      // 1e5a: astore 46
      // 1e5c: aload 46
      // 1e5e: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 1e61: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1e64: checkcast net/minecraft/core/particles/SimpleParticleType
      // 1e67: dload 2
      // 1e68: dload 4
      // 1e6a: dload 6
      // 1e6c: bipush 30
      // 1e6e: ldc2_w 0.2
      // 1e71: ldc2_w 0.2
      // 1e74: ldc2_w 0.2
      // 1e77: ldc2_w 0.2
      // 1e7a: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 1e7d: pop
      // 1e7e: bipush 2
      // 1e7f: aload 9
      // 1e81: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$34 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1e86: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1e89: aload 11
      // 1e8b: instanceof net/arphex/entity/SpiderMothEntity
      // 1e8e: ifeq 1f2c
      // 1e91: aload 9
      // 1e93: instanceof net/minecraft/world/entity/LivingEntity
      // 1e96: ifeq 1ea8
      // 1e99: aload 9
      // 1e9b: checkcast net/minecraft/world/entity/LivingEntity
      // 1e9e: astore 45
      // 1ea0: aload 45
      // 1ea2: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 1ea5: ifne 1f2c
      // 1ea8: aload 9
      // 1eaa: instanceof net/minecraft/world/entity/player/Player
      // 1ead: ifeq 1ed5
      // 1eb0: aload 9
      // 1eb2: checkcast net/minecraft/world/entity/player/Player
      // 1eb5: astore 46
      // 1eb7: aload 46
      // 1eb9: invokevirtual net/minecraft/world/entity/player/Player.getInventory ()Lnet/minecraft/world/entity/player/Inventory;
      // 1ebc: new net/minecraft/world/item/ItemStack
      // 1ebf: dup
      // 1ec0: getstatic net/arphex/init/ArphexModItems.BANE_OF_THE_DARKNESS Lnet/minecraftforge/registries/RegistryObject;
      // 1ec3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1ec6: checkcast net/minecraft/world/level/ItemLike
      // 1ec9: invokespecial net/minecraft/world/item/ItemStack.<init> (Lnet/minecraft/world/level/ItemLike;)V
      // 1ecc: invokevirtual net/minecraft/world/entity/player/Inventory.contains (Lnet/minecraft/world/item/ItemStack;)Z
      // 1ecf: ifeq 1ed5
      // 1ed2: goto 1f2c
      // 1ed5: aload 11
      // 1ed7: instanceof net/minecraft/world/entity/LivingEntity
      // 1eda: ifeq 1f03
      // 1edd: aload 11
      // 1edf: checkcast net/minecraft/world/entity/LivingEntity
      // 1ee2: astore 47
      // 1ee4: aload 47
      // 1ee6: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1ee9: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 1eec: ifne 1f03
      // 1eef: aload 47
      // 1ef1: new net/minecraft/world/effect/MobEffectInstance
      // 1ef4: dup
      // 1ef5: getstatic net/minecraft/world/effect/MobEffects.HEAL Lnet/minecraft/world/effect/MobEffect;
      // 1ef8: bipush 1
      // 1ef9: bipush 0
      // 1efa: bipush 0
      // 1efb: bipush 1
      // 1efc: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1eff: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1f02: pop
      // 1f03: aload 1
      // 1f04: instanceof net/minecraft/server/level/ServerLevel
      // 1f07: ifeq 1f2c
      // 1f0a: aload 1
      // 1f0b: checkcast net/minecraft/server/level/ServerLevel
      // 1f0e: astore 47
      // 1f10: aload 47
      // 1f12: getstatic net/minecraft/core/particles/ParticleTypes.PORTAL Lnet/minecraft/core/particles/SimpleParticleType;
      // 1f15: dload 2
      // 1f16: dload 4
      // 1f18: dload 6
      // 1f1a: bipush 50
      // 1f1c: ldc2_w 0.7
      // 1f1f: ldc2_w 0.7
      // 1f22: ldc2_w 0.7
      // 1f25: ldc2_w 6.0
      // 1f28: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 1f2b: pop
      // 1f2c: aload 11
      // 1f2e: instanceof net/arphex/entity/TeleportGhostEntity
      // 1f31: ifeq 2073
      // 1f34: aload 1
      // 1f35: ldc_w net/arphex/entity/SpiderMothEntity
      // 1f38: new net/minecraft/world/phys/Vec3
      // 1f3b: dup
      // 1f3c: dload 2
      // 1f3d: dload 4
      // 1f3f: dload 6
      // 1f41: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1f44: ldc2_w 200.0
      // 1f47: ldc2_w 200.0
      // 1f4a: ldc2_w 200.0
      // 1f4d: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 1f50: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$35 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 1f55: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 1f5a: invokeinterface java/util/List.isEmpty ()Z 1
      // 1f5f: ifne 2073
      // 1f62: aload 1
      // 1f63: instanceof net/minecraft/server/level/ServerLevel
      // 1f66: ifeq 1faa
      // 1f69: aload 1
      // 1f6a: checkcast net/minecraft/server/level/ServerLevel
      // 1f6d: astore 45
      // 1f6f: aload 45
      // 1f71: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 1f74: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 1f77: new net/minecraft/commands/CommandSourceStack
      // 1f7a: dup
      // 1f7b: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 1f7e: new net/minecraft/world/phys/Vec3
      // 1f81: dup
      // 1f82: dload 2
      // 1f83: dload 4
      // 1f85: dload 6
      // 1f87: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1f8a: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 1f8d: aload 45
      // 1f8f: bipush 4
      // 1f90: ldc ""
      // 1f92: ldc ""
      // 1f94: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 1f97: aload 45
      // 1f99: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 1f9c: aconst_null
      // 1f9d: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 1fa0: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 1fa3: ldc_w "execute at @e[type=arphex:spider_moth,limit=1,distance=..60] run particle arphex:ghost_teleport ~ ~ ~ 1 1 1 0.4 20"
      // 1fa6: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 1fa9: pop
      // 1faa: aload 1
      // 1fab: instanceof net/minecraft/server/level/ServerLevel
      // 1fae: ifeq 1ff2
      // 1fb1: aload 1
      // 1fb2: checkcast net/minecraft/server/level/ServerLevel
      // 1fb5: astore 45
      // 1fb7: aload 45
      // 1fb9: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 1fbc: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 1fbf: new net/minecraft/commands/CommandSourceStack
      // 1fc2: dup
      // 1fc3: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 1fc6: new net/minecraft/world/phys/Vec3
      // 1fc9: dup
      // 1fca: dload 2
      // 1fcb: dload 4
      // 1fcd: dload 6
      // 1fcf: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1fd2: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 1fd5: aload 45
      // 1fd7: bipush 4
      // 1fd8: ldc ""
      // 1fda: ldc ""
      // 1fdc: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 1fdf: aload 45
      // 1fe1: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 1fe4: aconst_null
      // 1fe5: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 1fe8: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 1feb: ldc_w "tp @e[type=arphex:spider_moth,limit=1,distance=..60] ~ ~ ~"
      // 1fee: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 1ff1: pop
      // 1ff2: aload 1
      // 1ff3: instanceof net/minecraft/server/level/ServerLevel
      // 1ff6: ifeq 203a
      // 1ff9: aload 1
      // 1ffa: checkcast net/minecraft/server/level/ServerLevel
      // 1ffd: astore 45
      // 1fff: aload 45
      // 2001: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 2004: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 2007: new net/minecraft/commands/CommandSourceStack
      // 200a: dup
      // 200b: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 200e: new net/minecraft/world/phys/Vec3
      // 2011: dup
      // 2012: dload 2
      // 2013: dload 4
      // 2015: dload 6
      // 2017: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 201a: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 201d: aload 45
      // 201f: bipush 4
      // 2020: ldc ""
      // 2022: ldc ""
      // 2024: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 2027: aload 45
      // 2029: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 202c: aconst_null
      // 202d: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 2030: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 2033: ldc_w "effect clear @e[type=arphex:spider_moth,limit=1,distance=..60] arphex:force_power"
      // 2036: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 2039: pop
      // 203a: aload 1
      // 203b: instanceof net/minecraft/server/level/ServerLevel
      // 203e: ifeq 2063
      // 2041: aload 1
      // 2042: checkcast net/minecraft/server/level/ServerLevel
      // 2045: astore 45
      // 2047: aload 45
      // 2049: getstatic net/arphex/init/ArphexModParticleTypes.GHOST_TELEPORT Lnet/minecraftforge/registries/RegistryObject;
      // 204c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 204f: checkcast net/minecraft/core/particles/SimpleParticleType
      // 2052: dload 2
      // 2053: dload 4
      // 2055: dload 6
      // 2057: bipush 20
      // 2059: dconst_1
      // 205a: dconst_1
      // 205b: dconst_1
      // 205c: ldc2_w 0.6
      // 205f: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 2062: pop
      // 2063: aload 11
      // 2065: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 2068: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 206b: ifne 2073
      // 206e: aload 11
      // 2070: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 2073: aload 11
      // 2075: instanceof net/arphex/entity/SpiderLarvaeEntity
      // 2078: ifeq 20aa
      // 207b: aload 9
      // 207d: instanceof net/minecraft/world/entity/player/Player
      // 2080: ifeq 20aa
      // 2083: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 2086: bipush 1
      // 2087: bipush 3
      // 2088: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 208b: bipush 3
      // 208c: if_icmpne 20aa
      // 208f: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.FRIENDLY_MODE Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 2092: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 2095: checkcast java/lang/Boolean
      // 2098: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 209b: ifne 20aa
      // 209e: aload 9
      // 20a0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 20a3: ldc_w "spidergrab"
      // 20a6: bipush 1
      // 20a7: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 20aa: aload 11
      // 20ac: instanceof net/arphex/entity/CentipedeStalkerEntity
      // 20af: ifeq 2110
      // 20b2: aload 9
      // 20b4: instanceof net/minecraft/world/entity/LivingEntity
      // 20b7: ifeq 20e1
      // 20ba: aload 9
      // 20bc: checkcast net/minecraft/world/entity/LivingEntity
      // 20bf: astore 45
      // 20c1: aload 45
      // 20c3: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 20c6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 20c9: ifne 20e1
      // 20cc: aload 45
      // 20ce: new net/minecraft/world/effect/MobEffectInstance
      // 20d1: dup
      // 20d2: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 20d5: bipush 40
      // 20d7: bipush 1
      // 20d8: bipush 0
      // 20d9: bipush 1
      // 20da: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 20dd: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 20e0: pop
      // 20e1: aload 9
      // 20e3: instanceof net/minecraft/world/entity/LivingEntity
      // 20e6: ifeq 2110
      // 20e9: aload 9
      // 20eb: checkcast net/minecraft/world/entity/LivingEntity
      // 20ee: astore 45
      // 20f0: aload 45
      // 20f2: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 20f5: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 20f8: ifne 2110
      // 20fb: aload 45
      // 20fd: new net/minecraft/world/effect/MobEffectInstance
      // 2100: dup
      // 2101: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SLOWDOWN Lnet/minecraft/world/effect/MobEffect;
      // 2104: bipush 40
      // 2106: bipush 1
      // 2107: bipush 0
      // 2108: bipush 1
      // 2109: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 210c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 210f: pop
      // 2110: aload 11
      // 2112: instanceof net/arphex/entity/ScorpionStrikerEntity
      // 2115: ifeq 225d
      // 2118: aload 9
      // 211a: instanceof net/minecraft/world/entity/player/Player
      // 211d: ifeq 225d
      // 2120: aload 9
      // 2122: instanceof net/minecraft/world/entity/LivingEntity
      // 2125: ifeq 214f
      // 2128: aload 9
      // 212a: checkcast net/minecraft/world/entity/LivingEntity
      // 212d: astore 45
      // 212f: aload 45
      // 2131: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2134: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2137: ifne 214f
      // 213a: aload 45
      // 213c: new net/minecraft/world/effect/MobEffectInstance
      // 213f: dup
      // 2140: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 2143: bipush 80
      // 2145: bipush 1
      // 2146: bipush 0
      // 2147: bipush 1
      // 2148: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 214b: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 214e: pop
      // 214f: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 2152: bipush 1
      // 2153: bipush 4
      // 2154: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 2157: bipush 2
      // 2158: if_icmpne 225d
      // 215b: aload 9
      // 215d: instanceof net/minecraft/world/entity/LivingEntity
      // 2160: ifeq 2190
      // 2163: aload 9
      // 2165: checkcast net/minecraft/world/entity/LivingEntity
      // 2168: astore 45
      // 216a: aload 45
      // 216c: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 216f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2172: ifne 2190
      // 2175: aload 45
      // 2177: new net/minecraft/world/effect/MobEffectInstance
      // 217a: dup
      // 217b: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 217e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2181: checkcast net/minecraft/world/effect/MobEffect
      // 2184: bipush 40
      // 2186: bipush 0
      // 2187: bipush 0
      // 2188: bipush 1
      // 2189: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 218c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 218f: pop
      // 2190: aload 9
      // 2192: instanceof net/minecraft/world/entity/LivingEntity
      // 2195: ifeq 21bf
      // 2198: aload 9
      // 219a: checkcast net/minecraft/world/entity/LivingEntity
      // 219d: astore 45
      // 219f: aload 45
      // 21a1: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 21a4: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 21a7: ifne 21bf
      // 21aa: aload 45
      // 21ac: new net/minecraft/world/effect/MobEffectInstance
      // 21af: dup
      // 21b0: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SLOWDOWN Lnet/minecraft/world/effect/MobEffect;
      // 21b3: bipush 80
      // 21b5: bipush 1
      // 21b6: bipush 0
      // 21b7: bipush 0
      // 21b8: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 21bb: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 21be: pop
      // 21bf: aload 9
      // 21c1: instanceof net/minecraft/world/entity/LivingEntity
      // 21c4: ifeq 21ee
      // 21c7: aload 9
      // 21c9: checkcast net/minecraft/world/entity/LivingEntity
      // 21cc: astore 45
      // 21ce: aload 45
      // 21d0: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 21d3: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 21d6: ifne 21ee
      // 21d9: aload 45
      // 21db: new net/minecraft/world/effect/MobEffectInstance
      // 21de: dup
      // 21df: getstatic net/minecraft/world/effect/MobEffects.DARKNESS Lnet/minecraft/world/effect/MobEffect;
      // 21e2: bipush 80
      // 21e4: bipush 1
      // 21e5: bipush 0
      // 21e6: bipush 0
      // 21e7: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 21ea: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 21ed: pop
      // 21ee: bipush 3
      // 21ef: aload 1
      // 21f0: dload 2
      // 21f1: dload 4
      // 21f3: dload 6
      // 21f5: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$36 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 21fa: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 21fd: bipush 6
      // 21ff: aload 1
      // 2200: dload 2
      // 2201: dload 4
      // 2203: dload 6
      // 2205: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$37 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 220a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 220d: bipush 9
      // 220f: aload 1
      // 2210: dload 2
      // 2211: dload 4
      // 2213: dload 6
      // 2215: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$38 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 221a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 221d: bipush 12
      // 221f: aload 1
      // 2220: dload 2
      // 2221: dload 4
      // 2223: dload 6
      // 2225: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$39 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 222a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 222d: bipush 15
      // 222f: aload 1
      // 2230: dload 2
      // 2231: dload 4
      // 2233: dload 6
      // 2235: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$40 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 223a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 223d: bipush 18
      // 223f: aload 1
      // 2240: dload 2
      // 2241: dload 4
      // 2243: dload 6
      // 2245: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$41 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 224a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 224d: bipush 21
      // 224f: aload 1
      // 2250: dload 2
      // 2251: dload 4
      // 2253: dload 6
      // 2255: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$42 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 225a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 225d: aload 11
      // 225f: instanceof net/arphex/entity/SpiderLarvaeEntity
      // 2262: ifeq 230b
      // 2265: aload 9
      // 2267: instanceof net/minecraft/world/entity/LivingEntity
      // 226a: ifeq 2294
      // 226d: aload 9
      // 226f: checkcast net/minecraft/world/entity/LivingEntity
      // 2272: astore 45
      // 2274: aload 45
      // 2276: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2279: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 227c: ifne 2294
      // 227f: aload 45
      // 2281: new net/minecraft/world/effect/MobEffectInstance
      // 2284: dup
      // 2285: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SLOWDOWN Lnet/minecraft/world/effect/MobEffect;
      // 2288: bipush 60
      // 228a: bipush 0
      // 228b: bipush 0
      // 228c: bipush 0
      // 228d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2290: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2293: pop
      // 2294: aload 9
      // 2296: instanceof net/minecraft/world/entity/LivingEntity
      // 2299: ifeq 22d5
      // 229c: aload 9
      // 229e: checkcast net/minecraft/world/entity/LivingEntity
      // 22a1: astore 45
      // 22a3: aload 45
      // 22a5: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SLOWDOWN Lnet/minecraft/world/effect/MobEffect;
      // 22a8: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 22ab: ifeq 22d5
      // 22ae: aload 1
      // 22af: instanceof net/minecraft/server/level/ServerLevel
      // 22b2: ifeq 22d5
      // 22b5: aload 1
      // 22b6: checkcast net/minecraft/server/level/ServerLevel
      // 22b9: astore 46
      // 22bb: aload 46
      // 22bd: getstatic net/arphex/init/ArphexModParticleTypes.THIN_WEB Lnet/minecraftforge/registries/RegistryObject;
      // 22c0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 22c3: checkcast net/minecraft/core/particles/SimpleParticleType
      // 22c6: dload 2
      // 22c7: dload 4
      // 22c9: dload 6
      // 22cb: bipush 25
      // 22cd: dconst_1
      // 22ce: dconst_1
      // 22cf: dconst_1
      // 22d0: dconst_0
      // 22d1: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 22d4: pop
      // 22d5: aload 1
      // 22d6: instanceof net/minecraft/server/level/ServerLevel
      // 22d9: ifeq 22fb
      // 22dc: aload 1
      // 22dd: checkcast net/minecraft/server/level/ServerLevel
      // 22e0: astore 45
      // 22e2: aload 45
      // 22e4: getstatic net/arphex/init/ArphexModParticleTypes.THIN_WEB Lnet/minecraftforge/registries/RegistryObject;
      // 22e7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 22ea: checkcast net/minecraft/core/particles/SimpleParticleType
      // 22ed: dload 2
      // 22ee: dload 4
      // 22f0: dload 6
      // 22f2: bipush 5
      // 22f3: dconst_1
      // 22f4: dconst_1
      // 22f5: dconst_1
      // 22f6: dconst_0
      // 22f7: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 22fa: pop
      // 22fb: bipush 10
      // 22fd: aload 1
      // 22fe: dload 2
      // 22ff: dload 4
      // 2301: dload 6
      // 2303: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$43 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 2308: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 230b: aload 11
      // 230d: instanceof net/arphex/entity/SpiderBroodEntity
      // 2310: ifeq 2358
      // 2313: aload 9
      // 2315: instanceof net/minecraft/world/entity/LivingEntity
      // 2318: ifeq 2348
      // 231b: aload 9
      // 231d: checkcast net/minecraft/world/entity/LivingEntity
      // 2320: astore 45
      // 2322: aload 45
      // 2324: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2327: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 232a: ifne 2348
      // 232d: aload 45
      // 232f: new net/minecraft/world/effect/MobEffectInstance
      // 2332: dup
      // 2333: getstatic net/arphex/init/ArphexModMobEffects.WEBBED Lnet/minecraftforge/registries/RegistryObject;
      // 2336: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2339: checkcast net/minecraft/world/effect/MobEffect
      // 233c: bipush 60
      // 233e: bipush 0
      // 233f: bipush 0
      // 2340: bipush 0
      // 2341: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2344: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2347: pop
      // 2348: bipush 20
      // 234a: aload 1
      // 234b: dload 2
      // 234c: dload 4
      // 234e: dload 6
      // 2350: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$44 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 2355: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2358: aload 11
      // 235a: instanceof net/arphex/entity/SpiderSnatcherEntity
      // 235d: ifeq 23c4
      // 2360: aload 9
      // 2362: instanceof net/minecraft/world/entity/LivingEntity
      // 2365: ifeq 2395
      // 2368: aload 9
      // 236a: checkcast net/minecraft/world/entity/LivingEntity
      // 236d: astore 45
      // 236f: aload 45
      // 2371: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2374: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2377: ifne 2395
      // 237a: aload 45
      // 237c: new net/minecraft/world/effect/MobEffectInstance
      // 237f: dup
      // 2380: getstatic net/arphex/init/ArphexModMobEffects.WEBBED Lnet/minecraftforge/registries/RegistryObject;
      // 2383: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2386: checkcast net/minecraft/world/effect/MobEffect
      // 2389: bipush 40
      // 238b: bipush 1
      // 238c: bipush 0
      // 238d: bipush 0
      // 238e: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2391: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2394: pop
      // 2395: aload 9
      // 2397: instanceof net/minecraft/world/entity/LivingEntity
      // 239a: ifeq 23c4
      // 239d: aload 9
      // 239f: checkcast net/minecraft/world/entity/LivingEntity
      // 23a2: astore 45
      // 23a4: aload 45
      // 23a6: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 23a9: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 23ac: ifne 23c4
      // 23af: aload 45
      // 23b1: new net/minecraft/world/effect/MobEffectInstance
      // 23b4: dup
      // 23b5: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 23b8: bipush 60
      // 23ba: bipush 0
      // 23bb: bipush 0
      // 23bc: bipush 0
      // 23bd: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 23c0: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 23c3: pop
      // 23c4: aload 11
      // 23c6: instanceof net/arphex/entity/CentipedeEvictorEntity
      // 23c9: ifeq 2444
      // 23cc: aload 9
      // 23ce: instanceof net/minecraft/world/entity/LivingEntity
      // 23d1: ifeq 23fb
      // 23d4: aload 9
      // 23d6: checkcast net/minecraft/world/entity/LivingEntity
      // 23d9: astore 45
      // 23db: aload 45
      // 23dd: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 23e0: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 23e3: ifne 23fb
      // 23e6: aload 45
      // 23e8: new net/minecraft/world/effect/MobEffectInstance
      // 23eb: dup
      // 23ec: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SLOWDOWN Lnet/minecraft/world/effect/MobEffect;
      // 23ef: bipush 40
      // 23f1: bipush 0
      // 23f2: bipush 0
      // 23f3: bipush 0
      // 23f4: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 23f7: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 23fa: pop
      // 23fb: aload 9
      // 23fd: instanceof net/minecraft/world/entity/LivingEntity
      // 2400: ifeq 2415
      // 2403: aload 9
      // 2405: checkcast net/minecraft/world/entity/LivingEntity
      // 2408: astore 45
      // 240a: aload 45
      // 240c: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 240f: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2412: ifne 2444
      // 2415: aload 9
      // 2417: instanceof net/minecraft/world/entity/LivingEntity
      // 241a: ifeq 2444
      // 241d: aload 9
      // 241f: checkcast net/minecraft/world/entity/LivingEntity
      // 2422: astore 46
      // 2424: aload 46
      // 2426: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2429: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 242c: ifne 2444
      // 242f: aload 46
      // 2431: new net/minecraft/world/effect/MobEffectInstance
      // 2434: dup
      // 2435: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 2438: bipush 20
      // 243a: bipush 0
      // 243b: bipush 0
      // 243c: bipush 0
      // 243d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2440: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2443: pop
      // 2444: aload 11
      // 2446: instanceof net/arphex/entity/TinyCentipedeBreacherEntity
      // 2449: ifeq 24a9
      // 244c: aload 9
      // 244e: instanceof net/minecraft/world/entity/LivingEntity
      // 2451: ifeq 247a
      // 2454: aload 9
      // 2456: checkcast net/minecraft/world/entity/LivingEntity
      // 2459: astore 45
      // 245b: aload 45
      // 245d: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2460: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2463: ifne 247a
      // 2466: aload 45
      // 2468: new net/minecraft/world/effect/MobEffectInstance
      // 246b: dup
      // 246c: getstatic net/minecraft/world/effect/MobEffects.BLINDNESS Lnet/minecraft/world/effect/MobEffect;
      // 246f: bipush 5
      // 2470: bipush 0
      // 2471: bipush 0
      // 2472: bipush 0
      // 2473: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2476: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2479: pop
      // 247a: aload 9
      // 247c: instanceof net/minecraft/world/entity/LivingEntity
      // 247f: ifeq 24a9
      // 2482: aload 9
      // 2484: checkcast net/minecraft/world/entity/LivingEntity
      // 2487: astore 45
      // 2489: aload 45
      // 248b: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 248e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2491: ifne 24a9
      // 2494: aload 45
      // 2496: new net/minecraft/world/effect/MobEffectInstance
      // 2499: dup
      // 249a: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 249d: bipush 20
      // 249f: bipush 0
      // 24a0: bipush 0
      // 24a1: bipush 0
      // 24a2: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 24a5: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 24a8: pop
      // 24a9: aload 9
      // 24ab: instanceof net/arphex/entity/SpiderMothEntity
      // 24ae: ifeq 25ce
      // 24b1: aload 9
      // 24b3: instanceof net/minecraft/world/entity/LivingEntity
      // 24b6: ifeq 24fa
      // 24b9: aload 9
      // 24bb: checkcast net/minecraft/world/entity/LivingEntity
      // 24be: astore 45
      // 24c0: aload 45
      // 24c2: getstatic net/minecraft/world/effect/MobEffects.INVISIBILITY Lnet/minecraft/world/effect/MobEffect;
      // 24c5: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 24c8: ifeq 24fa
      // 24cb: aload 1
      // 24cc: instanceof net/minecraft/server/level/ServerLevel
      // 24cf: ifeq 24fa
      // 24d2: aload 1
      // 24d3: checkcast net/minecraft/server/level/ServerLevel
      // 24d6: astore 46
      // 24d8: aload 46
      // 24da: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_RED_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 24dd: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 24e0: checkcast net/minecraft/core/particles/SimpleParticleType
      // 24e3: dload 2
      // 24e4: dload 4
      // 24e6: dload 6
      // 24e8: bipush 40
      // 24ea: ldc2_w 0.4
      // 24ed: ldc2_w 0.4
      // 24f0: ldc2_w 0.4
      // 24f3: ldc2_w 0.2
      // 24f6: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 24f9: pop
      // 24fa: aload 1
      // 24fb: ldc_w net/minecraft/world/entity/player/Player
      // 24fe: new net/minecraft/world/phys/Vec3
      // 2501: dup
      // 2502: dload 2
      // 2503: dload 4
      // 2505: dload 6
      // 2507: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 250a: ldc2_w 150.0
      // 250d: ldc2_w 150.0
      // 2510: ldc2_w 150.0
      // 2513: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 2516: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$45 (Lnet/minecraft/world/entity/player/Player;)Z, (Lnet/minecraft/world/entity/player/Player;)Z ]
      // 251b: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 2520: invokeinterface java/util/List.isEmpty ()Z 1
      // 2525: ifne 257e
      // 2528: aload 1
      // 2529: ldc_w net/minecraft/world/entity/player/Player
      // 252c: new net/minecraft/world/phys/Vec3
      // 252f: dup
      // 2530: dload 2
      // 2531: dload 4
      // 2533: dload 6
      // 2535: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2538: ldc2_w 150.0
      // 253b: ldc2_w 150.0
      // 253e: ldc2_w 150.0
      // 2541: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 2544: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$46 (Lnet/minecraft/world/entity/player/Player;)Z, (Lnet/minecraft/world/entity/player/Player;)Z ]
      // 2549: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 254e: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 2553: new net/arphex/procedures/DwellerLifestealProcedure$6
      // 2556: dup
      // 2557: invokespecial net/arphex/procedures/DwellerLifestealProcedure$6.<init> ()V
      // 255a: dload 2
      // 255b: dload 4
      // 255d: dload 6
      // 255f: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$6.compareDistOf (DDD)Ljava/util/Comparator;
      // 2562: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 2567: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 256c: aconst_null
      // 256d: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 2570: checkcast net/minecraft/world/entity/Entity
      // 2573: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2576: ldc "creativespectator"
      // 2578: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 257b: ifeq 25ce
      // 257e: aload 11
      // 2580: instanceof net/arphex/entity/SpiderMothLarvaeEntity
      // 2583: ifne 25ce
      // 2586: aload 11
      // 2588: instanceof net/arphex/entity/SpiderMothEntity
      // 258b: ifne 25ce
      // 258e: aload 9
      // 2590: instanceof net/minecraft/world/entity/Mob
      // 2593: ifeq 25a5
      // 2596: aload 9
      // 2598: checkcast net/minecraft/world/entity/Mob
      // 259b: astore 45
      // 259d: aload 45
      // 259f: invokevirtual net/minecraft/world/entity/Mob.getTarget ()Lnet/minecraft/world/entity/LivingEntity;
      // 25a2: goto 25a6
      // 25a5: aconst_null
      // 25a6: ifnonnull 25ce
      // 25a9: aload 9
      // 25ab: instanceof net/minecraft/world/entity/Mob
      // 25ae: ifeq 25ce
      // 25b1: aload 9
      // 25b3: checkcast net/minecraft/world/entity/Mob
      // 25b6: astore 46
      // 25b8: aload 11
      // 25ba: instanceof net/minecraft/world/entity/LivingEntity
      // 25bd: ifeq 25ce
      // 25c0: aload 11
      // 25c2: checkcast net/minecraft/world/entity/LivingEntity
      // 25c5: astore 47
      // 25c7: aload 46
      // 25c9: aload 47
      // 25cb: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 25ce: aload 11
      // 25d0: instanceof net/minecraft/world/entity/animal/Pufferfish
      // 25d3: ifeq 25ee
      // 25d6: aload 9
      // 25d8: instanceof net/arphex/entity/SpiderLurkerEntity
      // 25db: ifeq 25ee
      // 25de: aload 0
      // 25df: ifnull 25ee
      // 25e2: aload 0
      // 25e3: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 25e6: ifeq 25ee
      // 25e9: aload 0
      // 25ea: bipush 1
      // 25eb: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 25ee: aload 11
      // 25f0: instanceof net/arphex/entity/SpiderMothEntity
      // 25f3: ifeq 2674
      // 25f6: aload 11
      // 25f8: getstatic net/minecraft/commands/arguments/EntityAnchorArgument$Anchor.EYES Lnet/minecraft/commands/arguments/EntityAnchorArgument$Anchor;
      // 25fb: new net/minecraft/world/phys/Vec3
      // 25fe: dup
      // 25ff: aload 9
      // 2601: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2604: aload 9
      // 2606: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 2609: aload 9
      // 260b: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 260e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2611: invokevirtual net/minecraft/world/entity/Entity.lookAt (Lnet/minecraft/commands/arguments/EntityAnchorArgument$Anchor;Lnet/minecraft/world/phys/Vec3;)V
      // 2614: aload 1
      // 2615: dload 2
      // 2616: dload 4
      // 2618: dconst_1
      // 2619: dadd
      // 261a: dload 6
      // 261c: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 261f: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 2624: ifeq 263c
      // 2627: aload 1
      // 2628: dload 2
      // 2629: dload 4
      // 262b: ldc2_w 2.0
      // 262e: dadd
      // 262f: dload 6
      // 2631: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 2634: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 2639: ifne 2674
      // 263c: aload 1
      // 263d: instanceof net/minecraft/server/level/ServerLevel
      // 2640: ifeq 2674
      // 2643: aload 1
      // 2644: checkcast net/minecraft/server/level/ServerLevel
      // 2647: astore 45
      // 2649: aload 45
      // 264b: getstatic net/arphex/init/ArphexModParticleTypes.SOLID_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 264e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2651: checkcast net/minecraft/core/particles/SimpleParticleType
      // 2654: aload 11
      // 2656: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2659: aload 11
      // 265b: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 265e: aload 11
      // 2660: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2663: bipush 2
      // 2664: ldc2_w 0.4
      // 2667: ldc2_w 0.4
      // 266a: ldc2_w 0.4
      // 266d: ldc2_w 0.2
      // 2670: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 2673: pop
      // 2674: aload 11
      // 2676: instanceof net/arphex/entity/SpiderFunnelEntity
      // 2679: ifeq 270a
      // 267c: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 267f: bipush 1
      // 2680: bipush 2
      // 2681: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 2684: bipush 2
      // 2685: if_icmpne 270a
      // 2688: aload 9
      // 268a: instanceof net/minecraft/world/entity/LivingEntity
      // 268d: ifeq 269f
      // 2690: aload 9
      // 2692: checkcast net/minecraft/world/entity/LivingEntity
      // 2695: astore 45
      // 2697: aload 45
      // 2699: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 269c: ifne 26d5
      // 269f: aload 9
      // 26a1: instanceof net/minecraft/world/entity/LivingEntity
      // 26a4: ifeq 26d5
      // 26a7: aload 9
      // 26a9: checkcast net/minecraft/world/entity/LivingEntity
      // 26ac: astore 46
      // 26ae: aload 46
      // 26b0: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 26b3: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 26b6: ifne 26d5
      // 26b9: aload 46
      // 26bb: new net/minecraft/world/effect/MobEffectInstance
      // 26be: dup
      // 26bf: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 26c2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 26c5: checkcast net/minecraft/world/effect/MobEffect
      // 26c8: sipush 300
      // 26cb: bipush 1
      // 26cc: bipush 0
      // 26cd: bipush 1
      // 26ce: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 26d1: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 26d4: pop
      // 26d5: aload 9
      // 26d7: instanceof net/minecraft/world/entity/LivingEntity
      // 26da: ifeq 270a
      // 26dd: aload 9
      // 26df: checkcast net/minecraft/world/entity/LivingEntity
      // 26e2: astore 45
      // 26e4: aload 45
      // 26e6: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 26e9: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 26ec: ifne 270a
      // 26ef: aload 45
      // 26f1: new net/minecraft/world/effect/MobEffectInstance
      // 26f4: dup
      // 26f5: getstatic net/arphex/init/ArphexModMobEffects.WEBBED Lnet/minecraftforge/registries/RegistryObject;
      // 26f8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 26fb: checkcast net/minecraft/world/effect/MobEffect
      // 26fe: bipush 50
      // 2700: bipush 1
      // 2701: bipush 0
      // 2702: bipush 0
      // 2703: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2706: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2709: pop
      // 270a: aload 11
      // 270c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 270f: ldc_w "rotationtoplayer"
      // 2712: aload 11
      // 2714: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 2717: f2d
      // 2718: aload 11
      // 271a: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 271d: aload 9
      // 271f: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2722: dsub
      // 2723: aload 11
      // 2725: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2728: aload 9
      // 272a: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 272d: dsub
      // 272e: invokestatic java/lang/Math.atan2 (DD)D
      // 2731: ldc2_w 57.5
      // 2734: dmul
      // 2735: dsub
      // 2736: ldc2_w 180.0
      // 2739: dsub
      // 273a: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 273d: aload 9
      // 273f: instanceof net/minecraft/world/entity/LivingEntity
      // 2742: ifeq 2754
      // 2745: aload 9
      // 2747: checkcast net/minecraft/world/entity/LivingEntity
      // 274a: astore 45
      // 274c: aload 45
      // 274e: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 2751: goto 2757
      // 2754: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2757: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 275a: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 275d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2760: if_acmpeq 2803
      // 2763: aload 9
      // 2765: instanceof net/minecraft/world/entity/LivingEntity
      // 2768: ifeq 277a
      // 276b: aload 9
      // 276d: checkcast net/minecraft/world/entity/LivingEntity
      // 2770: astore 46
      // 2772: aload 46
      // 2774: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 2777: goto 277d
      // 277a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 277d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2780: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 2783: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2786: if_acmpeq 2803
      // 2789: aload 9
      // 278b: instanceof net/minecraft/world/entity/LivingEntity
      // 278e: ifeq 27a0
      // 2791: aload 9
      // 2793: checkcast net/minecraft/world/entity/LivingEntity
      // 2796: astore 47
      // 2798: aload 47
      // 279a: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 279d: goto 27a3
      // 27a0: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 27a3: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 27a6: getstatic net/arphex/init/ArphexModItems.FORCE_GAUNTLET Lnet/minecraftforge/registries/RegistryObject;
      // 27a9: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 27ac: if_acmpeq 2803
      // 27af: aload 9
      // 27b1: instanceof net/minecraft/world/entity/LivingEntity
      // 27b4: ifeq 27c6
      // 27b7: aload 9
      // 27b9: checkcast net/minecraft/world/entity/LivingEntity
      // 27bc: astore 48
      // 27be: aload 48
      // 27c0: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 27c3: goto 27c9
      // 27c6: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 27c9: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 27cc: getstatic net/arphex/init/ArphexModItems.VORTEX_DEVASTATOR Lnet/minecraftforge/registries/RegistryObject;
      // 27cf: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 27d2: if_acmpeq 27fb
      // 27d5: aload 9
      // 27d7: instanceof net/minecraft/world/entity/LivingEntity
      // 27da: ifeq 27ec
      // 27dd: aload 9
      // 27df: checkcast net/minecraft/world/entity/LivingEntity
      // 27e2: astore 49
      // 27e4: aload 49
      // 27e6: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 27e9: goto 27ef
      // 27ec: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 27ef: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 27f2: getstatic net/arphex/init/ArphexModItems.VORTEX_DEVASTATOR Lnet/minecraftforge/registries/RegistryObject;
      // 27f5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 27f8: if_acmpne 32a4
      // 27fb: aload 9
      // 27fd: invokevirtual net/minecraft/world/entity/Entity.isShiftKeyDown ()Z
      // 2800: ifeq 32a4
      // 2803: aload 9
      // 2805: instanceof net/minecraft/world/entity/LivingEntity
      // 2808: ifeq 281a
      // 280b: aload 9
      // 280d: checkcast net/minecraft/world/entity/LivingEntity
      // 2810: astore 50
      // 2812: aload 50
      // 2814: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 2817: goto 281d
      // 281a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 281d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2820: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 2823: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2826: if_acmpne 2af8
      // 2829: aload 11
      // 282b: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 282e: aload 9
      // 2830: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2833: dsub
      // 2834: aload 11
      // 2836: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2839: aload 9
      // 283b: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 283e: dsub
      // 283f: invokestatic java/lang/Math.atan2 (DD)D
      // 2842: ldc2_w 57.5
      // 2845: dmul
      // 2846: dconst_0
      // 2847: dsub
      // 2848: aload 9
      // 284a: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 284d: f2d
      // 284e: dadd
      // 284f: ldc2_w 20.0
      // 2852: dcmpg
      // 2853: ifge 292a
      // 2856: aload 11
      // 2858: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 285b: aload 9
      // 285d: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2860: dsub
      // 2861: aload 11
      // 2863: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2866: aload 9
      // 2868: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 286b: dsub
      // 286c: invokestatic java/lang/Math.atan2 (DD)D
      // 286f: ldc2_w 57.5
      // 2872: dmul
      // 2873: dconst_0
      // 2874: dsub
      // 2875: aload 9
      // 2877: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 287a: f2d
      // 287b: dadd
      // 287c: ldc2_w -20.0
      // 287f: dcmpl
      // 2880: ifle 292a
      // 2883: aload 11
      // 2885: instanceof net/minecraft/world/entity/LivingEntity
      // 2888: ifeq 28b2
      // 288b: aload 11
      // 288d: checkcast net/minecraft/world/entity/LivingEntity
      // 2890: astore 51
      // 2892: aload 51
      // 2894: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2897: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 289a: ifne 28b2
      // 289d: aload 51
      // 289f: new net/minecraft/world/effect/MobEffectInstance
      // 28a2: dup
      // 28a3: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 28a6: bipush 10
      // 28a8: bipush 1
      // 28a9: bipush 0
      // 28aa: bipush 0
      // 28ab: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 28ae: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 28b1: pop
      // 28b2: aload 1
      // 28b3: instanceof net/minecraft/world/level/Level
      // 28b6: ifeq 2917
      // 28b9: aload 1
      // 28ba: checkcast net/minecraft/world/level/Level
      // 28bd: astore 51
      // 28bf: aload 51
      // 28c1: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 28c4: ifne 28f2
      // 28c7: aload 51
      // 28c9: aconst_null
      // 28ca: dload 2
      // 28cb: dload 4
      // 28cd: dload 6
      // 28cf: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 28d2: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 28d5: new net/minecraft/resources/ResourceLocation
      // 28d8: dup
      // 28d9: ldc_w "item.shield.block"
      // 28dc: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 28df: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 28e4: checkcast net/minecraft/sounds/SoundEvent
      // 28e7: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 28ea: fconst_1
      // 28eb: fconst_1
      // 28ec: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 28ef: goto 2917
      // 28f2: aload 51
      // 28f4: dload 2
      // 28f5: dload 4
      // 28f7: dload 6
      // 28f9: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 28fc: new net/minecraft/resources/ResourceLocation
      // 28ff: dup
      // 2900: ldc_w "item.shield.block"
      // 2903: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 2906: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 290b: checkcast net/minecraft/sounds/SoundEvent
      // 290e: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 2911: fconst_1
      // 2912: fconst_1
      // 2913: bipush 0
      // 2914: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 2917: aload 0
      // 2918: ifnull 2af8
      // 291b: aload 0
      // 291c: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 291f: ifeq 2af8
      // 2922: aload 0
      // 2923: bipush 1
      // 2924: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 2927: goto 2af8
      // 292a: aload 9
      // 292c: instanceof net/minecraft/world/entity/LivingEntity
      // 292f: ifeq 2af8
      // 2932: aload 9
      // 2934: checkcast net/minecraft/world/entity/LivingEntity
      // 2937: astore 51
      // 2939: aload 51
      // 293b: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 293e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2941: checkcast net/minecraft/world/effect/MobEffect
      // 2944: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2947: ifeq 2af8
      // 294a: aload 9
      // 294c: instanceof net/minecraft/world/entity/LivingEntity
      // 294f: ifeq 2961
      // 2952: aload 9
      // 2954: checkcast net/minecraft/world/entity/LivingEntity
      // 2957: astore 52
      // 2959: aload 52
      // 295b: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 295e: ifne 2af8
      // 2961: aload 9
      // 2963: instanceof net/minecraft/world/entity/LivingEntity
      // 2966: ifeq 2978
      // 2969: aload 9
      // 296b: checkcast net/minecraft/world/entity/LivingEntity
      // 296e: astore 53
      // 2970: aload 53
      // 2972: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 2975: goto 2979
      // 2978: bipush 0
      // 2979: bipush 5
      // 297a: if_icmple 29ff
      // 297d: aload 9
      // 297f: new net/minecraft/world/damagesource/DamageSource
      // 2982: dup
      // 2983: aload 1
      // 2984: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 2989: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 298c: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 2991: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 2994: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 2999: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 299c: dload 12
      // 299e: aload 9
      // 29a0: instanceof net/minecraft/world/entity/LivingEntity
      // 29a3: ifeq 29d2
      // 29a6: aload 9
      // 29a8: checkcast net/minecraft/world/entity/LivingEntity
      // 29ab: astore 55
      // 29ad: aload 55
      // 29af: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 29b2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 29b5: checkcast net/minecraft/world/effect/MobEffect
      // 29b8: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 29bb: ifeq 29d2
      // 29be: aload 55
      // 29c0: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 29c3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 29c6: checkcast net/minecraft/world/effect/MobEffect
      // 29c9: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 29cc: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 29cf: goto 29d3
      // 29d2: bipush 0
      // 29d3: bipush 3
      // 29d4: iadd
      // 29d5: i2d
      // 29d6: ldc2_w 2.5
      // 29d9: ddiv
      // 29da: dmul
      // 29db: aload 9
      // 29dd: instanceof net/minecraft/world/entity/LivingEntity
      // 29e0: ifeq 29f2
      // 29e3: aload 9
      // 29e5: checkcast net/minecraft/world/entity/LivingEntity
      // 29e8: astore 54
      // 29ea: aload 54
      // 29ec: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 29ef: goto 29f3
      // 29f2: bipush 0
      // 29f3: bipush 5
      // 29f4: idiv
      // 29f5: i2d
      // 29f6: ddiv
      // 29f7: d2f
      // 29f8: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 29fb: pop
      // 29fc: goto 2a62
      // 29ff: aload 9
      // 2a01: new net/minecraft/world/damagesource/DamageSource
      // 2a04: dup
      // 2a05: aload 1
      // 2a06: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 2a0b: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 2a0e: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 2a13: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 2a16: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 2a1b: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 2a1e: dload 12
      // 2a20: aload 9
      // 2a22: instanceof net/minecraft/world/entity/LivingEntity
      // 2a25: ifeq 2a54
      // 2a28: aload 9
      // 2a2a: checkcast net/minecraft/world/entity/LivingEntity
      // 2a2d: astore 54
      // 2a2f: aload 54
      // 2a31: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2a34: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2a37: checkcast net/minecraft/world/effect/MobEffect
      // 2a3a: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2a3d: ifeq 2a54
      // 2a40: aload 54
      // 2a42: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2a45: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2a48: checkcast net/minecraft/world/effect/MobEffect
      // 2a4b: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 2a4e: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 2a51: goto 2a55
      // 2a54: bipush 0
      // 2a55: bipush 3
      // 2a56: iadd
      // 2a57: i2d
      // 2a58: ldc2_w 2.5
      // 2a5b: ddiv
      // 2a5c: dmul
      // 2a5d: d2f
      // 2a5e: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 2a61: pop
      // 2a62: aload 1
      // 2a63: instanceof net/minecraft/server/level/ServerLevel
      // 2a66: ifeq 2ac9
      // 2a69: aload 1
      // 2a6a: checkcast net/minecraft/server/level/ServerLevel
      // 2a6d: astore 53
      // 2a6f: aload 53
      // 2a71: getstatic net/arphex/init/ArphexModParticleTypes.CHARRED_BLOOD Lnet/minecraftforge/registries/RegistryObject;
      // 2a74: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2a77: checkcast net/minecraft/core/particles/SimpleParticleType
      // 2a7a: dload 2
      // 2a7b: dload 4
      // 2a7d: dload 6
      // 2a7f: aload 9
      // 2a81: instanceof net/minecraft/world/entity/LivingEntity
      // 2a84: ifeq 2ab3
      // 2a87: aload 9
      // 2a89: checkcast net/minecraft/world/entity/LivingEntity
      // 2a8c: astore 54
      // 2a8e: aload 54
      // 2a90: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2a93: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2a96: checkcast net/minecraft/world/effect/MobEffect
      // 2a99: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2a9c: ifeq 2ab3
      // 2a9f: aload 54
      // 2aa1: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2aa4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2aa7: checkcast net/minecraft/world/effect/MobEffect
      // 2aaa: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 2aad: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 2ab0: goto 2ab4
      // 2ab3: bipush 0
      // 2ab4: bipush 10
      // 2ab6: iadd
      // 2ab7: bipush 5
      // 2ab8: imul
      // 2ab9: ldc2_w 0.5
      // 2abc: ldc2_w 0.5
      // 2abf: ldc2_w 0.5
      // 2ac2: ldc2_w 0.2
      // 2ac5: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 2ac8: pop
      // 2ac9: aload 9
      // 2acb: instanceof net/minecraft/world/entity/LivingEntity
      // 2ace: ifeq 2af8
      // 2ad1: aload 9
      // 2ad3: checkcast net/minecraft/world/entity/LivingEntity
      // 2ad6: astore 53
      // 2ad8: aload 53
      // 2ada: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2add: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2ae0: ifne 2af8
      // 2ae3: aload 53
      // 2ae5: new net/minecraft/world/effect/MobEffectInstance
      // 2ae8: dup
      // 2ae9: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 2aec: bipush 10
      // 2aee: bipush 0
      // 2aef: bipush 0
      // 2af0: bipush 0
      // 2af1: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2af4: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2af7: pop
      // 2af8: aload 9
      // 2afa: instanceof net/minecraft/world/entity/LivingEntity
      // 2afd: ifeq 2b0f
      // 2b00: aload 9
      // 2b02: checkcast net/minecraft/world/entity/LivingEntity
      // 2b05: astore 50
      // 2b07: aload 50
      // 2b09: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 2b0c: goto 2b12
      // 2b0f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2b12: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2b15: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 2b18: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2b1b: if_acmpeq 2bb8
      // 2b1e: aload 9
      // 2b20: instanceof net/minecraft/world/entity/LivingEntity
      // 2b23: ifeq 2b35
      // 2b26: aload 9
      // 2b28: checkcast net/minecraft/world/entity/LivingEntity
      // 2b2b: astore 51
      // 2b2d: aload 51
      // 2b2f: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 2b32: goto 2b38
      // 2b35: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2b38: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2b3b: getstatic net/arphex/init/ArphexModItems.FORCE_GAUNTLET Lnet/minecraftforge/registries/RegistryObject;
      // 2b3e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2b41: if_acmpeq 2b98
      // 2b44: aload 9
      // 2b46: instanceof net/minecraft/world/entity/LivingEntity
      // 2b49: ifeq 2b5b
      // 2b4c: aload 9
      // 2b4e: checkcast net/minecraft/world/entity/LivingEntity
      // 2b51: astore 52
      // 2b53: aload 52
      // 2b55: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2b58: goto 2b5e
      // 2b5b: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2b5e: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2b61: getstatic net/arphex/init/ArphexModItems.VORTEX_DEVASTATOR Lnet/minecraftforge/registries/RegistryObject;
      // 2b64: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2b67: if_acmpeq 2b90
      // 2b6a: aload 9
      // 2b6c: instanceof net/minecraft/world/entity/LivingEntity
      // 2b6f: ifeq 2b81
      // 2b72: aload 9
      // 2b74: checkcast net/minecraft/world/entity/LivingEntity
      // 2b77: astore 53
      // 2b79: aload 53
      // 2b7b: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2b7e: goto 2b84
      // 2b81: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2b84: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2b87: getstatic net/arphex/init/ArphexModItems.VORTEX_DEVASTATOR Lnet/minecraftforge/registries/RegistryObject;
      // 2b8a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2b8d: if_acmpne 3492
      // 2b90: aload 9
      // 2b92: invokevirtual net/minecraft/world/entity/Entity.isShiftKeyDown ()Z
      // 2b95: ifeq 3492
      // 2b98: aload 9
      // 2b9a: instanceof net/minecraft/world/entity/LivingEntity
      // 2b9d: ifeq 3492
      // 2ba0: aload 9
      // 2ba2: checkcast net/minecraft/world/entity/LivingEntity
      // 2ba5: astore 54
      // 2ba7: aload 54
      // 2ba9: getstatic net/arphex/init/ArphexModMobEffects.BLOCKING_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 2bac: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2baf: checkcast net/minecraft/world/effect/MobEffect
      // 2bb2: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2bb5: ifeq 3492
      // 2bb8: aload 9
      // 2bba: instanceof net/minecraft/world/entity/LivingEntity
      // 2bbd: ifeq 2bcf
      // 2bc0: aload 9
      // 2bc2: checkcast net/minecraft/world/entity/LivingEntity
      // 2bc5: astore 55
      // 2bc7: aload 55
      // 2bc9: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2bcc: goto 2bd2
      // 2bcf: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2bd2: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2bd5: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 2bd8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2bdb: if_acmpne 2efe
      // 2bde: aload 9
      // 2be0: instanceof net/minecraft/world/entity/LivingEntity
      // 2be3: ifeq 2bf5
      // 2be6: aload 9
      // 2be8: checkcast net/minecraft/world/entity/LivingEntity
      // 2beb: astore 56
      // 2bed: aload 56
      // 2bef: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2bf2: goto 2bf8
      // 2bf5: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2bf8: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2bfb: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 2bfe: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2c01: if_acmpne 2efe
      // 2c04: aload 11
      // 2c06: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2c09: aload 9
      // 2c0b: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2c0e: dsub
      // 2c0f: aload 11
      // 2c11: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2c14: aload 9
      // 2c16: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2c19: dsub
      // 2c1a: invokestatic java/lang/Math.atan2 (DD)D
      // 2c1d: ldc2_w 57.5
      // 2c20: dmul
      // 2c21: dconst_0
      // 2c22: dsub
      // 2c23: aload 9
      // 2c25: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 2c28: f2d
      // 2c29: dadd
      // 2c2a: ldc2_w 80.0
      // 2c2d: dcmpg
      // 2c2e: ifge 2d2d
      // 2c31: aload 11
      // 2c33: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2c36: aload 9
      // 2c38: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2c3b: dsub
      // 2c3c: aload 11
      // 2c3e: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2c41: aload 9
      // 2c43: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2c46: dsub
      // 2c47: invokestatic java/lang/Math.atan2 (DD)D
      // 2c4a: ldc2_w 57.5
      // 2c4d: dmul
      // 2c4e: dconst_0
      // 2c4f: dsub
      // 2c50: aload 9
      // 2c52: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 2c55: f2d
      // 2c56: dadd
      // 2c57: ldc2_w -80.0
      // 2c5a: dcmpl
      // 2c5b: ifle 2d2d
      // 2c5e: aload 11
      // 2c60: instanceof net/minecraft/world/entity/LivingEntity
      // 2c63: ifeq 2c8d
      // 2c66: aload 11
      // 2c68: checkcast net/minecraft/world/entity/LivingEntity
      // 2c6b: astore 57
      // 2c6d: aload 57
      // 2c6f: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2c72: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2c75: ifne 2c8d
      // 2c78: aload 57
      // 2c7a: new net/minecraft/world/effect/MobEffectInstance
      // 2c7d: dup
      // 2c7e: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 2c81: bipush 10
      // 2c83: bipush 1
      // 2c84: bipush 0
      // 2c85: bipush 0
      // 2c86: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2c89: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2c8c: pop
      // 2c8d: aload 1
      // 2c8e: instanceof net/minecraft/world/level/Level
      // 2c91: ifeq 2cf2
      // 2c94: aload 1
      // 2c95: checkcast net/minecraft/world/level/Level
      // 2c98: astore 57
      // 2c9a: aload 57
      // 2c9c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2c9f: ifne 2ccd
      // 2ca2: aload 57
      // 2ca4: aconst_null
      // 2ca5: dload 2
      // 2ca6: dload 4
      // 2ca8: dload 6
      // 2caa: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 2cad: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 2cb0: new net/minecraft/resources/ResourceLocation
      // 2cb3: dup
      // 2cb4: ldc_w "item.shield.block"
      // 2cb7: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 2cba: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 2cbf: checkcast net/minecraft/sounds/SoundEvent
      // 2cc2: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 2cc5: fconst_1
      // 2cc6: fconst_1
      // 2cc7: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 2cca: goto 2cf2
      // 2ccd: aload 57
      // 2ccf: dload 2
      // 2cd0: dload 4
      // 2cd2: dload 6
      // 2cd4: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 2cd7: new net/minecraft/resources/ResourceLocation
      // 2cda: dup
      // 2cdb: ldc_w "item.shield.block"
      // 2cde: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 2ce1: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 2ce6: checkcast net/minecraft/sounds/SoundEvent
      // 2ce9: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 2cec: fconst_1
      // 2ced: fconst_1
      // 2cee: bipush 0
      // 2cef: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 2cf2: aload 1
      // 2cf3: instanceof net/minecraft/server/level/ServerLevel
      // 2cf6: ifeq 2d1a
      // 2cf9: aload 1
      // 2cfa: checkcast net/minecraft/server/level/ServerLevel
      // 2cfd: astore 57
      // 2cff: aload 57
      // 2d01: getstatic net/minecraft/core/particles/ParticleTypes.SWEEP_ATTACK Lnet/minecraft/core/particles/SimpleParticleType;
      // 2d04: dload 2
      // 2d05: dload 4
      // 2d07: dload 6
      // 2d09: bipush 2
      // 2d0a: ldc2_w 0.7
      // 2d0d: ldc2_w 0.7
      // 2d10: ldc2_w 0.7
      // 2d13: ldc2_w 0.6
      // 2d16: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 2d19: pop
      // 2d1a: aload 0
      // 2d1b: ifnull 3492
      // 2d1e: aload 0
      // 2d1f: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 2d22: ifeq 3492
      // 2d25: aload 0
      // 2d26: bipush 1
      // 2d27: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 2d2a: goto 3492
      // 2d2d: aload 9
      // 2d2f: instanceof net/minecraft/world/entity/LivingEntity
      // 2d32: ifeq 2efb
      // 2d35: aload 9
      // 2d37: checkcast net/minecraft/world/entity/LivingEntity
      // 2d3a: astore 57
      // 2d3c: aload 57
      // 2d3e: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2d41: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2d44: checkcast net/minecraft/world/effect/MobEffect
      // 2d47: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2d4a: ifeq 2efb
      // 2d4d: aload 9
      // 2d4f: instanceof net/minecraft/world/entity/LivingEntity
      // 2d52: ifeq 2d64
      // 2d55: aload 9
      // 2d57: checkcast net/minecraft/world/entity/LivingEntity
      // 2d5a: astore 58
      // 2d5c: aload 58
      // 2d5e: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 2d61: ifne 2efb
      // 2d64: aload 9
      // 2d66: instanceof net/minecraft/world/entity/LivingEntity
      // 2d69: ifeq 2d7b
      // 2d6c: aload 9
      // 2d6e: checkcast net/minecraft/world/entity/LivingEntity
      // 2d71: astore 59
      // 2d73: aload 59
      // 2d75: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 2d78: goto 2d7c
      // 2d7b: bipush 0
      // 2d7c: bipush 5
      // 2d7d: if_icmple 2e02
      // 2d80: aload 9
      // 2d82: new net/minecraft/world/damagesource/DamageSource
      // 2d85: dup
      // 2d86: aload 1
      // 2d87: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 2d8c: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 2d8f: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 2d94: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 2d97: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 2d9c: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 2d9f: dload 12
      // 2da1: aload 9
      // 2da3: instanceof net/minecraft/world/entity/LivingEntity
      // 2da6: ifeq 2dd5
      // 2da9: aload 9
      // 2dab: checkcast net/minecraft/world/entity/LivingEntity
      // 2dae: astore 61
      // 2db0: aload 61
      // 2db2: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2db5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2db8: checkcast net/minecraft/world/effect/MobEffect
      // 2dbb: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2dbe: ifeq 2dd5
      // 2dc1: aload 61
      // 2dc3: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2dc6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2dc9: checkcast net/minecraft/world/effect/MobEffect
      // 2dcc: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 2dcf: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 2dd2: goto 2dd6
      // 2dd5: bipush 0
      // 2dd6: bipush 3
      // 2dd7: iadd
      // 2dd8: i2d
      // 2dd9: ldc2_w 2.5
      // 2ddc: ddiv
      // 2ddd: dmul
      // 2dde: aload 9
      // 2de0: instanceof net/minecraft/world/entity/LivingEntity
      // 2de3: ifeq 2df5
      // 2de6: aload 9
      // 2de8: checkcast net/minecraft/world/entity/LivingEntity
      // 2deb: astore 60
      // 2ded: aload 60
      // 2def: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 2df2: goto 2df6
      // 2df5: bipush 0
      // 2df6: bipush 5
      // 2df7: idiv
      // 2df8: i2d
      // 2df9: ddiv
      // 2dfa: d2f
      // 2dfb: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 2dfe: pop
      // 2dff: goto 2e65
      // 2e02: aload 9
      // 2e04: new net/minecraft/world/damagesource/DamageSource
      // 2e07: dup
      // 2e08: aload 1
      // 2e09: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 2e0e: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 2e11: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 2e16: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 2e19: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 2e1e: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 2e21: dload 12
      // 2e23: aload 9
      // 2e25: instanceof net/minecraft/world/entity/LivingEntity
      // 2e28: ifeq 2e57
      // 2e2b: aload 9
      // 2e2d: checkcast net/minecraft/world/entity/LivingEntity
      // 2e30: astore 60
      // 2e32: aload 60
      // 2e34: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2e37: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2e3a: checkcast net/minecraft/world/effect/MobEffect
      // 2e3d: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2e40: ifeq 2e57
      // 2e43: aload 60
      // 2e45: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2e48: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2e4b: checkcast net/minecraft/world/effect/MobEffect
      // 2e4e: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 2e51: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 2e54: goto 2e58
      // 2e57: bipush 0
      // 2e58: bipush 3
      // 2e59: iadd
      // 2e5a: i2d
      // 2e5b: ldc2_w 2.5
      // 2e5e: ddiv
      // 2e5f: dmul
      // 2e60: d2f
      // 2e61: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 2e64: pop
      // 2e65: aload 1
      // 2e66: instanceof net/minecraft/server/level/ServerLevel
      // 2e69: ifeq 2ecc
      // 2e6c: aload 1
      // 2e6d: checkcast net/minecraft/server/level/ServerLevel
      // 2e70: astore 59
      // 2e72: aload 59
      // 2e74: getstatic net/arphex/init/ArphexModParticleTypes.CHARRED_BLOOD Lnet/minecraftforge/registries/RegistryObject;
      // 2e77: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2e7a: checkcast net/minecraft/core/particles/SimpleParticleType
      // 2e7d: dload 2
      // 2e7e: dload 4
      // 2e80: dload 6
      // 2e82: aload 9
      // 2e84: instanceof net/minecraft/world/entity/LivingEntity
      // 2e87: ifeq 2eb6
      // 2e8a: aload 9
      // 2e8c: checkcast net/minecraft/world/entity/LivingEntity
      // 2e8f: astore 60
      // 2e91: aload 60
      // 2e93: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2e96: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2e99: checkcast net/minecraft/world/effect/MobEffect
      // 2e9c: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2e9f: ifeq 2eb6
      // 2ea2: aload 60
      // 2ea4: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2ea7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2eaa: checkcast net/minecraft/world/effect/MobEffect
      // 2ead: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 2eb0: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 2eb3: goto 2eb7
      // 2eb6: bipush 0
      // 2eb7: bipush 10
      // 2eb9: iadd
      // 2eba: bipush 5
      // 2ebb: imul
      // 2ebc: ldc2_w 0.5
      // 2ebf: ldc2_w 0.5
      // 2ec2: ldc2_w 0.5
      // 2ec5: ldc2_w 0.2
      // 2ec8: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 2ecb: pop
      // 2ecc: aload 9
      // 2ece: instanceof net/minecraft/world/entity/LivingEntity
      // 2ed1: ifeq 2efb
      // 2ed4: aload 9
      // 2ed6: checkcast net/minecraft/world/entity/LivingEntity
      // 2ed9: astore 59
      // 2edb: aload 59
      // 2edd: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2ee0: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2ee3: ifne 2efb
      // 2ee6: aload 59
      // 2ee8: new net/minecraft/world/effect/MobEffectInstance
      // 2eeb: dup
      // 2eec: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 2eef: bipush 10
      // 2ef1: bipush 0
      // 2ef2: bipush 0
      // 2ef3: bipush 0
      // 2ef4: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2ef7: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2efa: pop
      // 2efb: goto 3492
      // 2efe: aload 11
      // 2f00: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2f03: aload 9
      // 2f05: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2f08: dsub
      // 2f09: aload 11
      // 2f0b: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2f0e: aload 9
      // 2f10: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2f13: dsub
      // 2f14: invokestatic java/lang/Math.atan2 (DD)D
      // 2f17: ldc2_w 57.5
      // 2f1a: dmul
      // 2f1b: dconst_0
      // 2f1c: dsub
      // 2f1d: aload 9
      // 2f1f: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 2f22: f2d
      // 2f23: dadd
      // 2f24: ldc2_w 40.0
      // 2f27: dcmpg
      // 2f28: ifge 30d3
      // 2f2b: aload 11
      // 2f2d: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2f30: aload 9
      // 2f32: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2f35: dsub
      // 2f36: aload 11
      // 2f38: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2f3b: aload 9
      // 2f3d: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2f40: dsub
      // 2f41: invokestatic java/lang/Math.atan2 (DD)D
      // 2f44: ldc2_w 57.5
      // 2f47: dmul
      // 2f48: dconst_0
      // 2f49: dsub
      // 2f4a: aload 9
      // 2f4c: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 2f4f: f2d
      // 2f50: dadd
      // 2f51: ldc2_w -40.0
      // 2f54: dcmpl
      // 2f55: ifle 30d3
      // 2f58: aload 11
      // 2f5a: instanceof net/minecraft/world/entity/LivingEntity
      // 2f5d: ifeq 2f87
      // 2f60: aload 11
      // 2f62: checkcast net/minecraft/world/entity/LivingEntity
      // 2f65: astore 57
      // 2f67: aload 57
      // 2f69: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2f6c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2f6f: ifne 2f87
      // 2f72: aload 57
      // 2f74: new net/minecraft/world/effect/MobEffectInstance
      // 2f77: dup
      // 2f78: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 2f7b: bipush 10
      // 2f7d: bipush 1
      // 2f7e: bipush 0
      // 2f7f: bipush 0
      // 2f80: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2f83: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2f86: pop
      // 2f87: aload 9
      // 2f89: instanceof net/minecraft/world/entity/LivingEntity
      // 2f8c: ifeq 2f9e
      // 2f8f: aload 9
      // 2f91: checkcast net/minecraft/world/entity/LivingEntity
      // 2f94: astore 57
      // 2f96: aload 57
      // 2f98: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2f9b: goto 2fa1
      // 2f9e: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2fa1: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2fa4: getstatic net/arphex/init/ArphexModItems.VORTEX_DEVASTATOR Lnet/minecraftforge/registries/RegistryObject;
      // 2fa7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2faa: if_acmpeq 2fd3
      // 2fad: aload 9
      // 2faf: instanceof net/minecraft/world/entity/LivingEntity
      // 2fb2: ifeq 2fc4
      // 2fb5: aload 9
      // 2fb7: checkcast net/minecraft/world/entity/LivingEntity
      // 2fba: astore 58
      // 2fbc: aload 58
      // 2fbe: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2fc1: goto 2fc7
      // 2fc4: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2fc7: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2fca: getstatic net/arphex/init/ArphexModItems.VORTEX_DEVASTATOR Lnet/minecraftforge/registries/RegistryObject;
      // 2fcd: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2fd0: if_acmpne 300d
      // 2fd3: aload 1
      // 2fd4: instanceof net/minecraft/server/level/ServerLevel
      // 2fd7: ifeq 3002
      // 2fda: aload 1
      // 2fdb: checkcast net/minecraft/server/level/ServerLevel
      // 2fde: astore 59
      // 2fe0: aload 59
      // 2fe2: getstatic net/arphex/init/ArphexModParticleTypes.CHARCOAL Lnet/minecraftforge/registries/RegistryObject;
      // 2fe5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2fe8: checkcast net/minecraft/core/particles/SimpleParticleType
      // 2feb: dload 2
      // 2fec: dload 4
      // 2fee: dload 6
      // 2ff0: bipush 10
      // 2ff2: ldc2_w 0.3
      // 2ff5: ldc2_w 0.3
      // 2ff8: ldc2_w 0.3
      // 2ffb: ldc2_w 0.5
      // 2ffe: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 3001: pop
      // 3002: bipush 1
      // 3003: aload 9
      // 3005: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$47 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 300a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 300d: aload 9
      // 300f: instanceof net/minecraft/world/entity/LivingEntity
      // 3012: ifeq 3024
      // 3015: aload 9
      // 3017: checkcast net/minecraft/world/entity/LivingEntity
      // 301a: astore 57
      // 301c: aload 57
      // 301e: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 3021: goto 3027
      // 3024: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3027: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 302a: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 302d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3030: if_acmpne 305b
      // 3033: aload 1
      // 3034: instanceof net/minecraft/server/level/ServerLevel
      // 3037: ifeq 305b
      // 303a: aload 1
      // 303b: checkcast net/minecraft/server/level/ServerLevel
      // 303e: astore 58
      // 3040: aload 58
      // 3042: getstatic net/minecraft/core/particles/ParticleTypes.SWEEP_ATTACK Lnet/minecraft/core/particles/SimpleParticleType;
      // 3045: dload 2
      // 3046: dload 4
      // 3048: dload 6
      // 304a: bipush 2
      // 304b: ldc2_w 0.7
      // 304e: ldc2_w 0.7
      // 3051: ldc2_w 0.7
      // 3054: ldc2_w 0.6
      // 3057: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 305a: pop
      // 305b: aload 1
      // 305c: instanceof net/minecraft/world/level/Level
      // 305f: ifeq 30c0
      // 3062: aload 1
      // 3063: checkcast net/minecraft/world/level/Level
      // 3066: astore 57
      // 3068: aload 57
      // 306a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 306d: ifne 309b
      // 3070: aload 57
      // 3072: aconst_null
      // 3073: dload 2
      // 3074: dload 4
      // 3076: dload 6
      // 3078: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 307b: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 307e: new net/minecraft/resources/ResourceLocation
      // 3081: dup
      // 3082: ldc_w "item.shield.block"
      // 3085: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 3088: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 308d: checkcast net/minecraft/sounds/SoundEvent
      // 3090: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 3093: fconst_1
      // 3094: fconst_1
      // 3095: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 3098: goto 30c0
      // 309b: aload 57
      // 309d: dload 2
      // 309e: dload 4
      // 30a0: dload 6
      // 30a2: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 30a5: new net/minecraft/resources/ResourceLocation
      // 30a8: dup
      // 30a9: ldc_w "item.shield.block"
      // 30ac: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 30af: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 30b4: checkcast net/minecraft/sounds/SoundEvent
      // 30b7: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 30ba: fconst_1
      // 30bb: fconst_1
      // 30bc: bipush 0
      // 30bd: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 30c0: aload 0
      // 30c1: ifnull 3492
      // 30c4: aload 0
      // 30c5: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 30c8: ifeq 3492
      // 30cb: aload 0
      // 30cc: bipush 1
      // 30cd: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 30d0: goto 3492
      // 30d3: aload 9
      // 30d5: instanceof net/minecraft/world/entity/LivingEntity
      // 30d8: ifeq 32a1
      // 30db: aload 9
      // 30dd: checkcast net/minecraft/world/entity/LivingEntity
      // 30e0: astore 57
      // 30e2: aload 57
      // 30e4: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 30e7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 30ea: checkcast net/minecraft/world/effect/MobEffect
      // 30ed: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 30f0: ifeq 32a1
      // 30f3: aload 9
      // 30f5: instanceof net/minecraft/world/entity/LivingEntity
      // 30f8: ifeq 310a
      // 30fb: aload 9
      // 30fd: checkcast net/minecraft/world/entity/LivingEntity
      // 3100: astore 58
      // 3102: aload 58
      // 3104: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 3107: ifne 32a1
      // 310a: aload 9
      // 310c: instanceof net/minecraft/world/entity/LivingEntity
      // 310f: ifeq 3121
      // 3112: aload 9
      // 3114: checkcast net/minecraft/world/entity/LivingEntity
      // 3117: astore 59
      // 3119: aload 59
      // 311b: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 311e: goto 3122
      // 3121: bipush 0
      // 3122: bipush 5
      // 3123: if_icmple 31a8
      // 3126: aload 9
      // 3128: new net/minecraft/world/damagesource/DamageSource
      // 312b: dup
      // 312c: aload 1
      // 312d: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 3132: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 3135: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 313a: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 313d: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 3142: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 3145: dload 12
      // 3147: aload 9
      // 3149: instanceof net/minecraft/world/entity/LivingEntity
      // 314c: ifeq 317b
      // 314f: aload 9
      // 3151: checkcast net/minecraft/world/entity/LivingEntity
      // 3154: astore 61
      // 3156: aload 61
      // 3158: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 315b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 315e: checkcast net/minecraft/world/effect/MobEffect
      // 3161: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 3164: ifeq 317b
      // 3167: aload 61
      // 3169: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 316c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 316f: checkcast net/minecraft/world/effect/MobEffect
      // 3172: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 3175: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 3178: goto 317c
      // 317b: bipush 0
      // 317c: bipush 3
      // 317d: iadd
      // 317e: i2d
      // 317f: ldc2_w 2.5
      // 3182: ddiv
      // 3183: dmul
      // 3184: aload 9
      // 3186: instanceof net/minecraft/world/entity/LivingEntity
      // 3189: ifeq 319b
      // 318c: aload 9
      // 318e: checkcast net/minecraft/world/entity/LivingEntity
      // 3191: astore 60
      // 3193: aload 60
      // 3195: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3198: goto 319c
      // 319b: bipush 0
      // 319c: bipush 5
      // 319d: idiv
      // 319e: i2d
      // 319f: ddiv
      // 31a0: d2f
      // 31a1: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 31a4: pop
      // 31a5: goto 320b
      // 31a8: aload 9
      // 31aa: new net/minecraft/world/damagesource/DamageSource
      // 31ad: dup
      // 31ae: aload 1
      // 31af: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 31b4: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 31b7: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 31bc: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 31bf: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 31c4: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 31c7: dload 12
      // 31c9: aload 9
      // 31cb: instanceof net/minecraft/world/entity/LivingEntity
      // 31ce: ifeq 31fd
      // 31d1: aload 9
      // 31d3: checkcast net/minecraft/world/entity/LivingEntity
      // 31d6: astore 60
      // 31d8: aload 60
      // 31da: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 31dd: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 31e0: checkcast net/minecraft/world/effect/MobEffect
      // 31e3: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 31e6: ifeq 31fd
      // 31e9: aload 60
      // 31eb: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 31ee: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 31f1: checkcast net/minecraft/world/effect/MobEffect
      // 31f4: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 31f7: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 31fa: goto 31fe
      // 31fd: bipush 0
      // 31fe: bipush 3
      // 31ff: iadd
      // 3200: i2d
      // 3201: ldc2_w 2.5
      // 3204: ddiv
      // 3205: dmul
      // 3206: d2f
      // 3207: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 320a: pop
      // 320b: aload 1
      // 320c: instanceof net/minecraft/server/level/ServerLevel
      // 320f: ifeq 3272
      // 3212: aload 1
      // 3213: checkcast net/minecraft/server/level/ServerLevel
      // 3216: astore 59
      // 3218: aload 59
      // 321a: getstatic net/arphex/init/ArphexModParticleTypes.CHARRED_BLOOD Lnet/minecraftforge/registries/RegistryObject;
      // 321d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3220: checkcast net/minecraft/core/particles/SimpleParticleType
      // 3223: dload 2
      // 3224: dload 4
      // 3226: dload 6
      // 3228: aload 9
      // 322a: instanceof net/minecraft/world/entity/LivingEntity
      // 322d: ifeq 325c
      // 3230: aload 9
      // 3232: checkcast net/minecraft/world/entity/LivingEntity
      // 3235: astore 60
      // 3237: aload 60
      // 3239: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 323c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 323f: checkcast net/minecraft/world/effect/MobEffect
      // 3242: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 3245: ifeq 325c
      // 3248: aload 60
      // 324a: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 324d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3250: checkcast net/minecraft/world/effect/MobEffect
      // 3253: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 3256: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 3259: goto 325d
      // 325c: bipush 0
      // 325d: bipush 10
      // 325f: iadd
      // 3260: bipush 5
      // 3261: imul
      // 3262: ldc2_w 0.5
      // 3265: ldc2_w 0.5
      // 3268: ldc2_w 0.5
      // 326b: ldc2_w 0.2
      // 326e: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 3271: pop
      // 3272: aload 9
      // 3274: instanceof net/minecraft/world/entity/LivingEntity
      // 3277: ifeq 32a1
      // 327a: aload 9
      // 327c: checkcast net/minecraft/world/entity/LivingEntity
      // 327f: astore 59
      // 3281: aload 59
      // 3283: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3286: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3289: ifne 32a1
      // 328c: aload 59
      // 328e: new net/minecraft/world/effect/MobEffectInstance
      // 3291: dup
      // 3292: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 3295: bipush 10
      // 3297: bipush 0
      // 3298: bipush 0
      // 3299: bipush 0
      // 329a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 329d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 32a0: pop
      // 32a1: goto 3492
      // 32a4: aload 9
      // 32a6: instanceof net/minecraft/world/entity/LivingEntity
      // 32a9: ifeq 3492
      // 32ac: aload 9
      // 32ae: checkcast net/minecraft/world/entity/LivingEntity
      // 32b1: astore 50
      // 32b3: aload 50
      // 32b5: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 32b8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 32bb: checkcast net/minecraft/world/effect/MobEffect
      // 32be: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 32c1: ifeq 3492
      // 32c4: aload 9
      // 32c6: instanceof net/minecraft/world/entity/LivingEntity
      // 32c9: ifeq 32db
      // 32cc: aload 9
      // 32ce: checkcast net/minecraft/world/entity/LivingEntity
      // 32d1: astore 51
      // 32d3: aload 51
      // 32d5: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 32d8: ifne 3492
      // 32db: aload 9
      // 32dd: instanceof net/minecraft/world/entity/LivingEntity
      // 32e0: ifeq 32fb
      // 32e3: aload 9
      // 32e5: checkcast net/minecraft/world/entity/LivingEntity
      // 32e8: astore 52
      // 32ea: aload 52
      // 32ec: getstatic net/arphex/init/ArphexModMobEffects.ETERNAL_EVASION Lnet/minecraftforge/registries/RegistryObject;
      // 32ef: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 32f2: checkcast net/minecraft/world/effect/MobEffect
      // 32f5: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 32f8: ifne 3492
      // 32fb: aload 9
      // 32fd: instanceof net/minecraft/world/entity/LivingEntity
      // 3300: ifeq 3312
      // 3303: aload 9
      // 3305: checkcast net/minecraft/world/entity/LivingEntity
      // 3308: astore 53
      // 330a: aload 53
      // 330c: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 330f: goto 3313
      // 3312: bipush 0
      // 3313: bipush 5
      // 3314: if_icmple 3399
      // 3317: aload 9
      // 3319: new net/minecraft/world/damagesource/DamageSource
      // 331c: dup
      // 331d: aload 1
      // 331e: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 3323: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 3326: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 332b: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 332e: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 3333: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 3336: dload 12
      // 3338: aload 9
      // 333a: instanceof net/minecraft/world/entity/LivingEntity
      // 333d: ifeq 336c
      // 3340: aload 9
      // 3342: checkcast net/minecraft/world/entity/LivingEntity
      // 3345: astore 55
      // 3347: aload 55
      // 3349: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 334c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 334f: checkcast net/minecraft/world/effect/MobEffect
      // 3352: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 3355: ifeq 336c
      // 3358: aload 55
      // 335a: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 335d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3360: checkcast net/minecraft/world/effect/MobEffect
      // 3363: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 3366: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 3369: goto 336d
      // 336c: bipush 0
      // 336d: bipush 3
      // 336e: iadd
      // 336f: i2d
      // 3370: ldc2_w 2.5
      // 3373: ddiv
      // 3374: dmul
      // 3375: aload 9
      // 3377: instanceof net/minecraft/world/entity/LivingEntity
      // 337a: ifeq 338c
      // 337d: aload 9
      // 337f: checkcast net/minecraft/world/entity/LivingEntity
      // 3382: astore 54
      // 3384: aload 54
      // 3386: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3389: goto 338d
      // 338c: bipush 0
      // 338d: bipush 5
      // 338e: idiv
      // 338f: i2d
      // 3390: ddiv
      // 3391: d2f
      // 3392: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 3395: pop
      // 3396: goto 33fc
      // 3399: aload 9
      // 339b: new net/minecraft/world/damagesource/DamageSource
      // 339e: dup
      // 339f: aload 1
      // 33a0: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 33a5: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 33a8: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 33ad: getstatic net/minecraft/world/damagesource/DamageTypes.WITHER Lnet/minecraft/resources/ResourceKey;
      // 33b0: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 33b5: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 33b8: dload 12
      // 33ba: aload 9
      // 33bc: instanceof net/minecraft/world/entity/LivingEntity
      // 33bf: ifeq 33ee
      // 33c2: aload 9
      // 33c4: checkcast net/minecraft/world/entity/LivingEntity
      // 33c7: astore 54
      // 33c9: aload 54
      // 33cb: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 33ce: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 33d1: checkcast net/minecraft/world/effect/MobEffect
      // 33d4: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 33d7: ifeq 33ee
      // 33da: aload 54
      // 33dc: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 33df: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 33e2: checkcast net/minecraft/world/effect/MobEffect
      // 33e5: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 33e8: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 33eb: goto 33ef
      // 33ee: bipush 0
      // 33ef: bipush 3
      // 33f0: iadd
      // 33f1: i2d
      // 33f2: ldc2_w 2.5
      // 33f5: ddiv
      // 33f6: dmul
      // 33f7: d2f
      // 33f8: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 33fb: pop
      // 33fc: aload 1
      // 33fd: instanceof net/minecraft/server/level/ServerLevel
      // 3400: ifeq 3463
      // 3403: aload 1
      // 3404: checkcast net/minecraft/server/level/ServerLevel
      // 3407: astore 53
      // 3409: aload 53
      // 340b: getstatic net/arphex/init/ArphexModParticleTypes.CHARRED_BLOOD Lnet/minecraftforge/registries/RegistryObject;
      // 340e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3411: checkcast net/minecraft/core/particles/SimpleParticleType
      // 3414: dload 2
      // 3415: dload 4
      // 3417: dload 6
      // 3419: aload 9
      // 341b: instanceof net/minecraft/world/entity/LivingEntity
      // 341e: ifeq 344d
      // 3421: aload 9
      // 3423: checkcast net/minecraft/world/entity/LivingEntity
      // 3426: astore 54
      // 3428: aload 54
      // 342a: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 342d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3430: checkcast net/minecraft/world/effect/MobEffect
      // 3433: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 3436: ifeq 344d
      // 3439: aload 54
      // 343b: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 343e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3441: checkcast net/minecraft/world/effect/MobEffect
      // 3444: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 3447: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 344a: goto 344e
      // 344d: bipush 0
      // 344e: bipush 10
      // 3450: iadd
      // 3451: bipush 5
      // 3452: imul
      // 3453: ldc2_w 0.5
      // 3456: ldc2_w 0.5
      // 3459: ldc2_w 0.5
      // 345c: ldc2_w 0.2
      // 345f: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 3462: pop
      // 3463: aload 9
      // 3465: instanceof net/minecraft/world/entity/LivingEntity
      // 3468: ifeq 3492
      // 346b: aload 9
      // 346d: checkcast net/minecraft/world/entity/LivingEntity
      // 3470: astore 53
      // 3472: aload 53
      // 3474: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3477: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 347a: ifne 3492
      // 347d: aload 53
      // 347f: new net/minecraft/world/effect/MobEffectInstance
      // 3482: dup
      // 3483: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 3486: bipush 10
      // 3488: bipush 0
      // 3489: bipush 0
      // 348a: bipush 0
      // 348b: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 348e: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3491: pop
      // 3492: aload 11
      // 3494: instanceof net/minecraft/world/entity/LivingEntity
      // 3497: ifeq 34a9
      // 349a: aload 11
      // 349c: checkcast net/minecraft/world/entity/LivingEntity
      // 349f: astore 45
      // 34a1: aload 45
      // 34a3: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 34a6: goto 34ac
      // 34a9: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 34ac: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 34af: getstatic net/arphex/init/ArphexModItems.MANTIS_MACHETE Lnet/minecraftforge/registries/RegistryObject;
      // 34b2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 34b5: if_acmpne 3507
      // 34b8: aload 9
      // 34ba: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 34bd: ldc_w 180.0
      // 34c0: fadd
      // 34c1: ldc_w 360.0
      // 34c4: frem
      // 34c5: aload 11
      // 34c7: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 34ca: ldc_w 180.0
      // 34cd: fadd
      // 34ce: ldc_w 360.0
      // 34d1: frem
      // 34d2: fsub
      // 34d3: invokestatic java/lang/Math.abs (F)F
      // 34d6: ldc_w 90.0
      // 34d9: fcmpg
      // 34da: ifge 3507
      // 34dd: aload 9
      // 34df: new net/minecraft/world/damagesource/DamageSource
      // 34e2: dup
      // 34e3: aload 1
      // 34e4: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 34e9: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 34ec: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 34f1: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 34f4: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 34f9: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 34fc: dload 12
      // 34fe: ldc2_w 1.5
      // 3501: dmul
      // 3502: d2f
      // 3503: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 3506: pop
      // 3507: aload 11
      // 3509: instanceof net/minecraft/world/entity/player/Player
      // 350c: ifeq 35f8
      // 350f: aload 9
      // 3511: instanceof net/minecraft/world/entity/TamableAnimal
      // 3514: ifeq 353a
      // 3517: aload 9
      // 3519: checkcast net/minecraft/world/entity/TamableAnimal
      // 351c: astore 45
      // 351e: aload 11
      // 3520: instanceof net/minecraft/world/entity/LivingEntity
      // 3523: ifeq 353a
      // 3526: aload 11
      // 3528: checkcast net/minecraft/world/entity/LivingEntity
      // 352b: astore 46
      // 352d: aload 45
      // 352f: aload 46
      // 3531: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 3534: ifeq 353a
      // 3537: goto 35f8
      // 353a: new net/minecraft/world/phys/Vec3
      // 353d: dup
      // 353e: dload 2
      // 353f: dload 4
      // 3541: dload 6
      // 3543: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3546: astore 47
      // 3548: aload 1
      // 3549: ldc net/minecraft/world/entity/Entity
      // 354b: new net/minecraft/world/phys/AABB
      // 354e: dup
      // 354f: aload 47
      // 3551: aload 47
      // 3553: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 3556: ldc2_w 25.0
      // 3559: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 355c: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$48 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 3561: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3566: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 356b: aload 47
      // 356d: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$49 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 3572: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 3575: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 357a: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 357f: astore 48
      // 3581: aload 48
      // 3583: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3588: astore 49
      // 358a: aload 49
      // 358c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3591: ifeq 35f8
      // 3594: aload 49
      // 3596: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 359b: checkcast net/minecraft/world/entity/Entity
      // 359e: astore 50
      // 35a0: aload 50
      // 35a2: instanceof net/minecraft/world/entity/TamableAnimal
      // 35a5: ifeq 35f5
      // 35a8: aload 50
      // 35aa: checkcast net/minecraft/world/entity/TamableAnimal
      // 35ad: astore 51
      // 35af: aload 11
      // 35b1: instanceof net/minecraft/world/entity/LivingEntity
      // 35b4: ifeq 35f5
      // 35b7: aload 11
      // 35b9: checkcast net/minecraft/world/entity/LivingEntity
      // 35bc: astore 52
      // 35be: aload 51
      // 35c0: aload 52
      // 35c2: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 35c5: ifeq 35f5
      // 35c8: aload 50
      // 35ca: instanceof net/arphex/entity/SpiderFlatEntity
      // 35cd: ifeq 35f5
      // 35d0: aload 50
      // 35d2: instanceof net/minecraft/world/entity/Mob
      // 35d5: ifeq 35f5
      // 35d8: aload 50
      // 35da: checkcast net/minecraft/world/entity/Mob
      // 35dd: astore 53
      // 35df: aload 9
      // 35e1: instanceof net/minecraft/world/entity/LivingEntity
      // 35e4: ifeq 35f5
      // 35e7: aload 9
      // 35e9: checkcast net/minecraft/world/entity/LivingEntity
      // 35ec: astore 54
      // 35ee: aload 53
      // 35f0: aload 54
      // 35f2: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 35f5: goto 358a
      // 35f8: aload 9
      // 35fa: instanceof net/minecraft/world/entity/player/Player
      // 35fd: ifeq 36e9
      // 3600: new net/minecraft/world/phys/Vec3
      // 3603: dup
      // 3604: dload 2
      // 3605: dload 4
      // 3607: dload 6
      // 3609: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 360c: astore 45
      // 360e: aload 1
      // 360f: ldc net/minecraft/world/entity/Entity
      // 3611: new net/minecraft/world/phys/AABB
      // 3614: dup
      // 3615: aload 45
      // 3617: aload 45
      // 3619: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 361c: ldc2_w 25.0
      // 361f: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 3622: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$50 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 3627: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 362c: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3631: aload 45
      // 3633: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$51 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 3638: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 363b: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3640: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 3645: astore 46
      // 3647: aload 46
      // 3649: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 364e: astore 47
      // 3650: aload 47
      // 3652: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3657: ifeq 36e9
      // 365a: aload 47
      // 365c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3661: checkcast net/minecraft/world/entity/Entity
      // 3664: astore 48
      // 3666: aload 48
      // 3668: instanceof net/minecraft/world/entity/TamableAnimal
      // 366b: ifeq 36e6
      // 366e: aload 48
      // 3670: checkcast net/minecraft/world/entity/TamableAnimal
      // 3673: astore 49
      // 3675: aload 9
      // 3677: instanceof net/minecraft/world/entity/LivingEntity
      // 367a: ifeq 36e6
      // 367d: aload 9
      // 367f: checkcast net/minecraft/world/entity/LivingEntity
      // 3682: astore 50
      // 3684: aload 49
      // 3686: aload 50
      // 3688: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 368b: ifeq 36e6
      // 368e: aload 48
      // 3690: instanceof net/arphex/entity/SpiderFlatEntity
      // 3693: ifeq 36e6
      // 3696: aload 11
      // 3698: instanceof net/minecraft/world/entity/TamableAnimal
      // 369b: ifeq 36c1
      // 369e: aload 11
      // 36a0: checkcast net/minecraft/world/entity/TamableAnimal
      // 36a3: astore 51
      // 36a5: aload 9
      // 36a7: instanceof net/minecraft/world/entity/LivingEntity
      // 36aa: ifeq 36c1
      // 36ad: aload 9
      // 36af: checkcast net/minecraft/world/entity/LivingEntity
      // 36b2: astore 52
      // 36b4: aload 51
      // 36b6: aload 52
      // 36b8: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 36bb: ifeq 36c1
      // 36be: goto 36e6
      // 36c1: aload 48
      // 36c3: instanceof net/minecraft/world/entity/Mob
      // 36c6: ifeq 36e6
      // 36c9: aload 48
      // 36cb: checkcast net/minecraft/world/entity/Mob
      // 36ce: astore 53
      // 36d0: aload 11
      // 36d2: instanceof net/minecraft/world/entity/LivingEntity
      // 36d5: ifeq 36e6
      // 36d8: aload 11
      // 36da: checkcast net/minecraft/world/entity/LivingEntity
      // 36dd: astore 54
      // 36df: aload 53
      // 36e1: aload 54
      // 36e3: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 36e6: goto 3650
      // 36e9: aload 11
      // 36eb: instanceof net/minecraft/world/entity/LivingEntity
      // 36ee: ifeq 3700
      // 36f1: aload 11
      // 36f3: checkcast net/minecraft/world/entity/LivingEntity
      // 36f6: astore 45
      // 36f8: aload 45
      // 36fa: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 36fd: goto 3703
      // 3700: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3703: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3706: getstatic net/arphex/init/ArphexModItems.STAFF_OF_VITALITY Lnet/minecraftforge/registries/RegistryObject;
      // 3709: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 370c: if_acmpne 3813
      // 370f: aload 11
      // 3711: instanceof net/minecraft/world/entity/player/Player
      // 3714: ifeq 3746
      // 3717: aload 11
      // 3719: checkcast net/minecraft/world/entity/player/Player
      // 371c: astore 46
      // 371e: aload 46
      // 3720: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 3723: aload 11
      // 3725: instanceof net/minecraft/world/entity/LivingEntity
      // 3728: ifeq 373a
      // 372b: aload 11
      // 372d: checkcast net/minecraft/world/entity/LivingEntity
      // 3730: astore 47
      // 3732: aload 47
      // 3734: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 3737: goto 373d
      // 373a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 373d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3740: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 3743: ifne 3813
      // 3746: aload 1
      // 3747: instanceof net/minecraft/server/level/ServerLevel
      // 374a: ifeq 3775
      // 374d: aload 1
      // 374e: checkcast net/minecraft/server/level/ServerLevel
      // 3751: astore 48
      // 3753: aload 48
      // 3755: getstatic net/arphex/init/ArphexModParticleTypes.GOLDEN_OPAL Lnet/minecraftforge/registries/RegistryObject;
      // 3758: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 375b: checkcast net/minecraft/core/particles/SimpleParticleType
      // 375e: dload 2
      // 375f: dload 4
      // 3761: dload 6
      // 3763: bipush 10
      // 3765: ldc2_w 0.3
      // 3768: ldc2_w 0.3
      // 376b: ldc2_w 0.3
      // 376e: ldc2_w 0.2
      // 3771: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 3774: pop
      // 3775: aload 1
      // 3776: instanceof net/minecraft/server/level/ServerLevel
      // 3779: ifeq 379e
      // 377c: aload 1
      // 377d: checkcast net/minecraft/server/level/ServerLevel
      // 3780: astore 48
      // 3782: aload 48
      // 3784: getstatic net/minecraft/core/particles/ParticleTypes.HEART Lnet/minecraft/core/particles/SimpleParticleType;
      // 3787: dload 2
      // 3788: dload 4
      // 378a: dload 6
      // 378c: bipush 10
      // 378e: ldc2_w 0.3
      // 3791: ldc2_w 0.3
      // 3794: ldc2_w 0.3
      // 3797: ldc2_w 0.2
      // 379a: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 379d: pop
      // 379e: aload 9
      // 37a0: instanceof net/minecraft/world/entity/LivingEntity
      // 37a3: ifeq 37cc
      // 37a6: aload 9
      // 37a8: checkcast net/minecraft/world/entity/LivingEntity
      // 37ab: astore 48
      // 37ad: aload 48
      // 37af: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 37b2: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 37b5: ifne 37cc
      // 37b8: aload 48
      // 37ba: new net/minecraft/world/effect/MobEffectInstance
      // 37bd: dup
      // 37be: getstatic net/minecraft/world/effect/MobEffects.HEAL Lnet/minecraft/world/effect/MobEffect;
      // 37c1: bipush 1
      // 37c2: bipush 0
      // 37c3: bipush 0
      // 37c4: bipush 1
      // 37c5: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 37c8: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 37cb: pop
      // 37cc: aload 11
      // 37ce: instanceof net/minecraft/world/entity/player/Player
      // 37d1: ifeq 3803
      // 37d4: aload 11
      // 37d6: checkcast net/minecraft/world/entity/player/Player
      // 37d9: astore 48
      // 37db: aload 48
      // 37dd: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 37e0: aload 11
      // 37e2: instanceof net/minecraft/world/entity/LivingEntity
      // 37e5: ifeq 37f7
      // 37e8: aload 11
      // 37ea: checkcast net/minecraft/world/entity/LivingEntity
      // 37ed: astore 49
      // 37ef: aload 49
      // 37f1: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 37f4: goto 37fa
      // 37f7: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 37fa: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 37fd: sipush 200
      // 3800: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 3803: aload 0
      // 3804: ifnull 3813
      // 3807: aload 0
      // 3808: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 380b: ifeq 3813
      // 380e: aload 0
      // 380f: bipush 1
      // 3810: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 3813: aload 11
      // 3815: instanceof net/minecraft/world/entity/LivingEntity
      // 3818: ifeq 382a
      // 381b: aload 11
      // 381d: checkcast net/minecraft/world/entity/LivingEntity
      // 3820: astore 45
      // 3822: aload 45
      // 3824: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 3827: goto 382d
      // 382a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 382d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3830: getstatic net/arphex/init/ArphexModItems.DAGGER_OF_DISSOLUTION Lnet/minecraftforge/registries/RegistryObject;
      // 3833: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3836: if_acmpeq 38d1
      // 3839: aload 11
      // 383b: instanceof net/minecraft/world/entity/LivingEntity
      // 383e: ifeq 3850
      // 3841: aload 11
      // 3843: checkcast net/minecraft/world/entity/LivingEntity
      // 3846: astore 46
      // 3848: aload 46
      // 384a: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 384d: goto 3853
      // 3850: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3853: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3856: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 3859: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 385c: if_acmpne 3885
      // 385f: aload 11
      // 3861: instanceof net/minecraft/world/entity/LivingEntity
      // 3864: ifeq 3876
      // 3867: aload 11
      // 3869: checkcast net/minecraft/world/entity/LivingEntity
      // 386c: astore 47
      // 386e: aload 47
      // 3870: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 3873: goto 3879
      // 3876: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3879: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 387c: getstatic net/arphex/init/ArphexModItems.ABYSSAL_DAGGER Lnet/minecraftforge/registries/RegistryObject;
      // 387f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3882: if_acmpeq 38d1
      // 3885: aload 11
      // 3887: instanceof net/minecraft/world/entity/LivingEntity
      // 388a: ifeq 389c
      // 388d: aload 11
      // 388f: checkcast net/minecraft/world/entity/LivingEntity
      // 3892: astore 48
      // 3894: aload 48
      // 3896: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 3899: goto 389f
      // 389c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 389f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 38a2: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 38a5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 38a8: if_acmpne 3936
      // 38ab: aload 11
      // 38ad: instanceof net/minecraft/world/entity/LivingEntity
      // 38b0: ifeq 38c2
      // 38b3: aload 11
      // 38b5: checkcast net/minecraft/world/entity/LivingEntity
      // 38b8: astore 49
      // 38ba: aload 49
      // 38bc: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 38bf: goto 38c5
      // 38c2: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 38c5: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 38c8: getstatic net/arphex/init/ArphexModItems.ABYSSAL_DAGGER Lnet/minecraftforge/registries/RegistryObject;
      // 38cb: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 38ce: if_acmpne 3936
      // 38d1: aload 9
      // 38d3: instanceof net/minecraft/world/entity/LivingEntity
      // 38d6: ifeq 3907
      // 38d9: aload 9
      // 38db: checkcast net/minecraft/world/entity/LivingEntity
      // 38de: astore 50
      // 38e0: aload 50
      // 38e2: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 38e5: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 38e8: ifne 3907
      // 38eb: aload 50
      // 38ed: new net/minecraft/world/effect/MobEffectInstance
      // 38f0: dup
      // 38f1: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 38f4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 38f7: checkcast net/minecraft/world/effect/MobEffect
      // 38fa: sipush 160
      // 38fd: bipush 1
      // 38fe: bipush 0
      // 38ff: bipush 1
      // 3900: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3903: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3906: pop
      // 3907: aload 9
      // 3909: instanceof net/minecraft/world/entity/LivingEntity
      // 390c: ifeq 3936
      // 390f: aload 9
      // 3911: checkcast net/minecraft/world/entity/LivingEntity
      // 3914: astore 50
      // 3916: aload 50
      // 3918: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 391b: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 391e: ifne 3936
      // 3921: aload 50
      // 3923: new net/minecraft/world/effect/MobEffectInstance
      // 3926: dup
      // 3927: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 392a: bipush 80
      // 392c: bipush 0
      // 392d: bipush 0
      // 392e: bipush 1
      // 392f: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3932: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3935: pop
      // 3936: aload 11
      // 3938: instanceof net/minecraft/world/entity/LivingEntity
      // 393b: ifeq 394d
      // 393e: aload 11
      // 3940: checkcast net/minecraft/world/entity/LivingEntity
      // 3943: astore 45
      // 3945: aload 45
      // 3947: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 394a: goto 3950
      // 394d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3950: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3953: getstatic net/arphex/init/ArphexModItems.ABYSSAL_DAGGER Lnet/minecraftforge/registries/RegistryObject;
      // 3956: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3959: if_acmpne 39f1
      // 395c: aload 9
      // 395e: instanceof net/minecraft/world/entity/LivingEntity
      // 3961: ifeq 3992
      // 3964: aload 9
      // 3966: checkcast net/minecraft/world/entity/LivingEntity
      // 3969: astore 46
      // 396b: aload 46
      // 396d: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3970: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3973: ifne 3992
      // 3976: aload 46
      // 3978: new net/minecraft/world/effect/MobEffectInstance
      // 397b: dup
      // 397c: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 397f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3982: checkcast net/minecraft/world/effect/MobEffect
      // 3985: sipush 200
      // 3988: bipush 2
      // 3989: bipush 0
      // 398a: bipush 1
      // 398b: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 398e: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3991: pop
      // 3992: aload 9
      // 3994: instanceof net/minecraft/world/entity/LivingEntity
      // 3997: ifeq 39c2
      // 399a: aload 9
      // 399c: checkcast net/minecraft/world/entity/LivingEntity
      // 399f: astore 46
      // 39a1: aload 46
      // 39a3: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 39a6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 39a9: ifne 39c2
      // 39ac: aload 46
      // 39ae: new net/minecraft/world/effect/MobEffectInstance
      // 39b1: dup
      // 39b2: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 39b5: sipush 160
      // 39b8: bipush 0
      // 39b9: bipush 0
      // 39ba: bipush 1
      // 39bb: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 39be: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 39c1: pop
      // 39c2: aload 11
      // 39c4: instanceof net/minecraft/world/entity/LivingEntity
      // 39c7: ifeq 39f1
      // 39ca: aload 11
      // 39cc: checkcast net/minecraft/world/entity/LivingEntity
      // 39cf: astore 46
      // 39d1: aload 46
      // 39d3: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 39d6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 39d9: ifne 39f1
      // 39dc: aload 46
      // 39de: new net/minecraft/world/effect/MobEffectInstance
      // 39e1: dup
      // 39e2: getstatic net/minecraft/world/effect/MobEffects.WEAKNESS Lnet/minecraft/world/effect/MobEffect;
      // 39e5: bipush 70
      // 39e7: bipush 0
      // 39e8: bipush 0
      // 39e9: bipush 0
      // 39ea: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 39ed: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 39f0: pop
      // 39f1: aload 9
      // 39f3: instanceof net/minecraft/world/entity/LivingEntity
      // 39f6: ifeq 3a08
      // 39f9: aload 9
      // 39fb: checkcast net/minecraft/world/entity/LivingEntity
      // 39fe: astore 45
      // 3a00: aload 45
      // 3a02: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 3a05: goto 3a0b
      // 3a08: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3a0b: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3a0e: getstatic net/arphex/init/ArphexModItems.ABYSSAL_DAGGER Lnet/minecraftforge/registries/RegistryObject;
      // 3a11: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3a14: if_acmpeq 3a3d
      // 3a17: aload 9
      // 3a19: instanceof net/minecraft/world/entity/LivingEntity
      // 3a1c: ifeq 3a2e
      // 3a1f: aload 9
      // 3a21: checkcast net/minecraft/world/entity/LivingEntity
      // 3a24: astore 46
      // 3a26: aload 46
      // 3a28: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 3a2b: goto 3a31
      // 3a2e: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3a31: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3a34: getstatic net/arphex/init/ArphexModItems.ABYSSAL_DAGGER Lnet/minecraftforge/registries/RegistryObject;
      // 3a37: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3a3a: if_acmpne 3a9b
      // 3a3d: aload 9
      // 3a3f: instanceof net/minecraft/world/entity/LivingEntity
      // 3a42: ifeq 3a6c
      // 3a45: aload 9
      // 3a47: checkcast net/minecraft/world/entity/LivingEntity
      // 3a4a: astore 47
      // 3a4c: aload 47
      // 3a4e: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3a51: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3a54: ifne 3a6c
      // 3a57: aload 47
      // 3a59: new net/minecraft/world/effect/MobEffectInstance
      // 3a5c: dup
      // 3a5d: getstatic net/minecraft/world/effect/MobEffects.INVISIBILITY Lnet/minecraft/world/effect/MobEffect;
      // 3a60: bipush 30
      // 3a62: bipush 1
      // 3a63: bipush 0
      // 3a64: bipush 0
      // 3a65: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3a68: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3a6b: pop
      // 3a6c: aload 11
      // 3a6e: instanceof net/minecraft/world/entity/LivingEntity
      // 3a71: ifeq 3a9b
      // 3a74: aload 11
      // 3a76: checkcast net/minecraft/world/entity/LivingEntity
      // 3a79: astore 47
      // 3a7b: aload 47
      // 3a7d: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3a80: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3a83: ifne 3a9b
      // 3a86: aload 47
      // 3a88: new net/minecraft/world/effect/MobEffectInstance
      // 3a8b: dup
      // 3a8c: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SLOWDOWN Lnet/minecraft/world/effect/MobEffect;
      // 3a8f: bipush 30
      // 3a91: bipush 0
      // 3a92: bipush 0
      // 3a93: bipush 0
      // 3a94: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3a97: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3a9a: pop
      // 3a9b: aload 11
      // 3a9d: instanceof net/minecraft/world/entity/player/Player
      // 3aa0: ifeq 3c26
      // 3aa3: aload 9
      // 3aa5: instanceof net/minecraft/world/entity/TamableAnimal
      // 3aa8: ifeq 3ace
      // 3aab: aload 9
      // 3aad: checkcast net/minecraft/world/entity/TamableAnimal
      // 3ab0: astore 45
      // 3ab2: aload 11
      // 3ab4: instanceof net/minecraft/world/entity/LivingEntity
      // 3ab7: ifeq 3ace
      // 3aba: aload 11
      // 3abc: checkcast net/minecraft/world/entity/LivingEntity
      // 3abf: astore 46
      // 3ac1: aload 45
      // 3ac3: aload 46
      // 3ac5: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 3ac8: ifeq 3ace
      // 3acb: goto 3c26
      // 3ace: new net/minecraft/world/phys/Vec3
      // 3ad1: dup
      // 3ad2: dload 2
      // 3ad3: dload 4
      // 3ad5: dload 6
      // 3ad7: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3ada: astore 47
      // 3adc: aload 1
      // 3add: ldc net/minecraft/world/entity/Entity
      // 3adf: new net/minecraft/world/phys/AABB
      // 3ae2: dup
      // 3ae3: aload 47
      // 3ae5: aload 47
      // 3ae7: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 3aea: ldc2_w 15.0
      // 3aed: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 3af0: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$52 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 3af5: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3afa: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3aff: aload 47
      // 3b01: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$53 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 3b06: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 3b09: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3b0e: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 3b13: astore 48
      // 3b15: aload 48
      // 3b17: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3b1c: astore 49
      // 3b1e: aload 49
      // 3b20: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3b25: ifeq 3c26
      // 3b28: aload 49
      // 3b2a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3b2f: checkcast net/minecraft/world/entity/Entity
      // 3b32: astore 50
      // 3b34: aload 50
      // 3b36: instanceof net/arphex/entity/TamedTarantulaEntity
      // 3b39: ifeq 3c23
      // 3b3c: aload 1
      // 3b3d: ldc_w net/arphex/entity/TamedTarantulaEntity
      // 3b40: new net/minecraft/world/phys/Vec3
      // 3b43: dup
      // 3b44: dload 2
      // 3b45: dload 4
      // 3b47: dload 6
      // 3b49: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3b4c: ldc2_w 30.0
      // 3b4f: ldc2_w 30.0
      // 3b52: ldc2_w 30.0
      // 3b55: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 3b58: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$54 (Lnet/arphex/entity/TamedTarantulaEntity;)Z, (Lnet/arphex/entity/TamedTarantulaEntity;)Z ]
      // 3b5d: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3b62: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3b67: new net/arphex/procedures/DwellerLifestealProcedure$7
      // 3b6a: dup
      // 3b6b: invokespecial net/arphex/procedures/DwellerLifestealProcedure$7.<init> ()V
      // 3b6e: dload 2
      // 3b6f: dload 4
      // 3b71: dload 6
      // 3b73: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$7.compareDistOf (DDD)Ljava/util/Comparator;
      // 3b76: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3b7b: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 3b80: aconst_null
      // 3b81: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 3b84: checkcast net/minecraft/world/entity/Entity
      // 3b87: astore 53
      // 3b89: aload 53
      // 3b8b: instanceof net/minecraft/world/entity/TamableAnimal
      // 3b8e: ifeq 3c23
      // 3b91: aload 53
      // 3b93: checkcast net/minecraft/world/entity/TamableAnimal
      // 3b96: astore 51
      // 3b98: aload 11
      // 3b9a: instanceof net/minecraft/world/entity/LivingEntity
      // 3b9d: ifeq 3c23
      // 3ba0: aload 11
      // 3ba2: checkcast net/minecraft/world/entity/LivingEntity
      // 3ba5: astore 52
      // 3ba7: aload 51
      // 3ba9: aload 52
      // 3bab: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 3bae: ifeq 3c23
      // 3bb1: aload 1
      // 3bb2: ldc_w net/arphex/entity/TamedTarantulaEntity
      // 3bb5: new net/minecraft/world/phys/Vec3
      // 3bb8: dup
      // 3bb9: dload 2
      // 3bba: dload 4
      // 3bbc: dload 6
      // 3bbe: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3bc1: ldc2_w 30.0
      // 3bc4: ldc2_w 30.0
      // 3bc7: ldc2_w 30.0
      // 3bca: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 3bcd: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$55 (Lnet/arphex/entity/TamedTarantulaEntity;)Z, (Lnet/arphex/entity/TamedTarantulaEntity;)Z ]
      // 3bd2: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3bd7: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3bdc: new net/arphex/procedures/DwellerLifestealProcedure$8
      // 3bdf: dup
      // 3be0: invokespecial net/arphex/procedures/DwellerLifestealProcedure$8.<init> ()V
      // 3be3: dload 2
      // 3be4: dload 4
      // 3be6: dload 6
      // 3be8: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$8.compareDistOf (DDD)Ljava/util/Comparator;
      // 3beb: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3bf0: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 3bf5: aconst_null
      // 3bf6: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 3bf9: checkcast net/minecraft/world/entity/Entity
      // 3bfc: astore 55
      // 3bfe: aload 55
      // 3c00: instanceof net/minecraft/world/entity/Mob
      // 3c03: ifeq 3c23
      // 3c06: aload 55
      // 3c08: checkcast net/minecraft/world/entity/Mob
      // 3c0b: astore 53
      // 3c0d: aload 9
      // 3c0f: instanceof net/minecraft/world/entity/LivingEntity
      // 3c12: ifeq 3c23
      // 3c15: aload 9
      // 3c17: checkcast net/minecraft/world/entity/LivingEntity
      // 3c1a: astore 54
      // 3c1c: aload 53
      // 3c1e: aload 54
      // 3c20: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 3c23: goto 3b1e
      // 3c26: aload 9
      // 3c28: instanceof net/minecraft/world/entity/player/Player
      // 3c2b: ifeq 3d86
      // 3c2e: new net/minecraft/world/phys/Vec3
      // 3c31: dup
      // 3c32: dload 2
      // 3c33: dload 4
      // 3c35: dload 6
      // 3c37: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3c3a: astore 45
      // 3c3c: aload 1
      // 3c3d: ldc net/minecraft/world/entity/Entity
      // 3c3f: new net/minecraft/world/phys/AABB
      // 3c42: dup
      // 3c43: aload 45
      // 3c45: aload 45
      // 3c47: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 3c4a: ldc2_w 15.0
      // 3c4d: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 3c50: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$56 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 3c55: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3c5a: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3c5f: aload 45
      // 3c61: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$57 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 3c66: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 3c69: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3c6e: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 3c73: astore 46
      // 3c75: aload 46
      // 3c77: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3c7c: astore 47
      // 3c7e: aload 47
      // 3c80: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3c85: ifeq 3d86
      // 3c88: aload 47
      // 3c8a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3c8f: checkcast net/minecraft/world/entity/Entity
      // 3c92: astore 48
      // 3c94: aload 48
      // 3c96: instanceof net/arphex/entity/TamedTarantulaEntity
      // 3c99: ifeq 3d83
      // 3c9c: aload 1
      // 3c9d: ldc_w net/arphex/entity/TamedTarantulaEntity
      // 3ca0: new net/minecraft/world/phys/Vec3
      // 3ca3: dup
      // 3ca4: dload 2
      // 3ca5: dload 4
      // 3ca7: dload 6
      // 3ca9: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3cac: ldc2_w 30.0
      // 3caf: ldc2_w 30.0
      // 3cb2: ldc2_w 30.0
      // 3cb5: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 3cb8: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$58 (Lnet/arphex/entity/TamedTarantulaEntity;)Z, (Lnet/arphex/entity/TamedTarantulaEntity;)Z ]
      // 3cbd: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3cc2: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3cc7: new net/arphex/procedures/DwellerLifestealProcedure$9
      // 3cca: dup
      // 3ccb: invokespecial net/arphex/procedures/DwellerLifestealProcedure$9.<init> ()V
      // 3cce: dload 2
      // 3ccf: dload 4
      // 3cd1: dload 6
      // 3cd3: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$9.compareDistOf (DDD)Ljava/util/Comparator;
      // 3cd6: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3cdb: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 3ce0: aconst_null
      // 3ce1: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 3ce4: checkcast net/minecraft/world/entity/Entity
      // 3ce7: astore 51
      // 3ce9: aload 51
      // 3ceb: instanceof net/minecraft/world/entity/TamableAnimal
      // 3cee: ifeq 3d83
      // 3cf1: aload 51
      // 3cf3: checkcast net/minecraft/world/entity/TamableAnimal
      // 3cf6: astore 49
      // 3cf8: aload 9
      // 3cfa: instanceof net/minecraft/world/entity/LivingEntity
      // 3cfd: ifeq 3d83
      // 3d00: aload 9
      // 3d02: checkcast net/minecraft/world/entity/LivingEntity
      // 3d05: astore 50
      // 3d07: aload 49
      // 3d09: aload 50
      // 3d0b: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 3d0e: ifeq 3d83
      // 3d11: aload 1
      // 3d12: ldc_w net/arphex/entity/TamedTarantulaEntity
      // 3d15: new net/minecraft/world/phys/Vec3
      // 3d18: dup
      // 3d19: dload 2
      // 3d1a: dload 4
      // 3d1c: dload 6
      // 3d1e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3d21: ldc2_w 30.0
      // 3d24: ldc2_w 30.0
      // 3d27: ldc2_w 30.0
      // 3d2a: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 3d2d: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$59 (Lnet/arphex/entity/TamedTarantulaEntity;)Z, (Lnet/arphex/entity/TamedTarantulaEntity;)Z ]
      // 3d32: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3d37: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3d3c: new net/arphex/procedures/DwellerLifestealProcedure$10
      // 3d3f: dup
      // 3d40: invokespecial net/arphex/procedures/DwellerLifestealProcedure$10.<init> ()V
      // 3d43: dload 2
      // 3d44: dload 4
      // 3d46: dload 6
      // 3d48: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$10.compareDistOf (DDD)Ljava/util/Comparator;
      // 3d4b: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3d50: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 3d55: aconst_null
      // 3d56: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 3d59: checkcast net/minecraft/world/entity/Entity
      // 3d5c: astore 53
      // 3d5e: aload 53
      // 3d60: instanceof net/minecraft/world/entity/Mob
      // 3d63: ifeq 3d83
      // 3d66: aload 53
      // 3d68: checkcast net/minecraft/world/entity/Mob
      // 3d6b: astore 51
      // 3d6d: aload 11
      // 3d6f: instanceof net/minecraft/world/entity/LivingEntity
      // 3d72: ifeq 3d83
      // 3d75: aload 11
      // 3d77: checkcast net/minecraft/world/entity/LivingEntity
      // 3d7a: astore 52
      // 3d7c: aload 51
      // 3d7e: aload 52
      // 3d80: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 3d83: goto 3c7e
      // 3d86: aload 11
      // 3d88: instanceof net/arphex/entity/HornetHarbingerEntity
      // 3d8b: ifeq 3df2
      // 3d8e: aload 9
      // 3d90: instanceof net/minecraft/world/entity/LivingEntity
      // 3d93: ifeq 3dc3
      // 3d96: aload 9
      // 3d98: checkcast net/minecraft/world/entity/LivingEntity
      // 3d9b: astore 45
      // 3d9d: aload 45
      // 3d9f: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3da2: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3da5: ifne 3dc3
      // 3da8: aload 45
      // 3daa: new net/minecraft/world/effect/MobEffectInstance
      // 3dad: dup
      // 3dae: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 3db1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3db4: checkcast net/minecraft/world/effect/MobEffect
      // 3db7: bipush 100
      // 3db9: bipush 0
      // 3dba: bipush 0
      // 3dbb: bipush 1
      // 3dbc: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3dbf: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3dc2: pop
      // 3dc3: aload 9
      // 3dc5: instanceof net/minecraft/world/entity/LivingEntity
      // 3dc8: ifeq 3df2
      // 3dcb: aload 9
      // 3dcd: checkcast net/minecraft/world/entity/LivingEntity
      // 3dd0: astore 45
      // 3dd2: aload 45
      // 3dd4: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3dd7: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3dda: ifne 3df2
      // 3ddd: aload 45
      // 3ddf: new net/minecraft/world/effect/MobEffectInstance
      // 3de2: dup
      // 3de3: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 3de6: bipush 50
      // 3de8: bipush 0
      // 3de9: bipush 0
      // 3dea: bipush 0
      // 3deb: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3dee: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3df1: pop
      // 3df2: aload 11
      // 3df4: instanceof net/arphex/entity/HornetHarbingerGiantEntity
      // 3df7: ifeq 3e60
      // 3dfa: aload 9
      // 3dfc: instanceof net/minecraft/world/entity/LivingEntity
      // 3dff: ifeq 3e30
      // 3e02: aload 9
      // 3e04: checkcast net/minecraft/world/entity/LivingEntity
      // 3e07: astore 45
      // 3e09: aload 45
      // 3e0b: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3e0e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3e11: ifne 3e30
      // 3e14: aload 45
      // 3e16: new net/minecraft/world/effect/MobEffectInstance
      // 3e19: dup
      // 3e1a: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 3e1d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3e20: checkcast net/minecraft/world/effect/MobEffect
      // 3e23: sipush 250
      // 3e26: bipush 1
      // 3e27: bipush 0
      // 3e28: bipush 1
      // 3e29: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3e2c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3e2f: pop
      // 3e30: aload 9
      // 3e32: instanceof net/minecraft/world/entity/LivingEntity
      // 3e35: ifeq 3e60
      // 3e38: aload 9
      // 3e3a: checkcast net/minecraft/world/entity/LivingEntity
      // 3e3d: astore 45
      // 3e3f: aload 45
      // 3e41: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3e44: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3e47: ifne 3e60
      // 3e4a: aload 45
      // 3e4c: new net/minecraft/world/effect/MobEffectInstance
      // 3e4f: dup
      // 3e50: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 3e53: sipush 200
      // 3e56: bipush 0
      // 3e57: bipush 0
      // 3e58: bipush 0
      // 3e59: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3e5c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3e5f: pop
      // 3e60: aload 11
      // 3e62: instanceof net/arphex/entity/SpiderMothLarvaeEntity
      // 3e65: ifeq 3e9f
      // 3e68: aload 9
      // 3e6a: instanceof net/arphex/entity/SpiderMothEntity
      // 3e6d: ifeq 3e9f
      // 3e70: aload 9
      // 3e72: instanceof net/minecraft/world/entity/LivingEntity
      // 3e75: ifeq 3e9f
      // 3e78: aload 9
      // 3e7a: checkcast net/minecraft/world/entity/LivingEntity
      // 3e7d: astore 45
      // 3e7f: aload 45
      // 3e81: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3e84: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3e87: ifne 3e9f
      // 3e8a: aload 45
      // 3e8c: new net/minecraft/world/effect/MobEffectInstance
      // 3e8f: dup
      // 3e90: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 3e93: bipush 30
      // 3e95: bipush 1
      // 3e96: bipush 0
      // 3e97: bipush 1
      // 3e98: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3e9b: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3e9e: pop
      // 3e9f: aload 11
      // 3ea1: instanceof net/minecraft/world/entity/player/Player
      // 3ea4: ifeq 3edf
      // 3ea7: aload 11
      // 3ea9: instanceof net/minecraft/world/entity/player/Player
      // 3eac: ifeq 3edf
      // 3eaf: aload 11
      // 3eb1: checkcast net/minecraft/world/entity/player/Player
      // 3eb4: astore 45
      // 3eb6: aload 45
      // 3eb8: invokevirtual net/minecraft/world/entity/player/Player.getInventory ()Lnet/minecraft/world/entity/player/Inventory;
      // 3ebb: new net/minecraft/world/item/ItemStack
      // 3ebe: dup
      // 3ebf: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 3ec2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3ec5: checkcast net/minecraft/world/level/ItemLike
      // 3ec8: invokespecial net/minecraft/world/item/ItemStack.<init> (Lnet/minecraft/world/level/ItemLike;)V
      // 3ecb: invokevirtual net/minecraft/world/entity/player/Inventory.contains (Lnet/minecraft/world/item/ItemStack;)Z
      // 3ece: ifeq 3edf
      // 3ed1: aload 9
      // 3ed3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3ed6: ldc_w "abyssdestruction"
      // 3ed9: ldc2_w 100.0
      // 3edc: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3edf: aload 11
      // 3ee1: instanceof net/arphex/entity/MosquitoMorbidityEntity
      // 3ee4: ifeq 3f52
      // 3ee7: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 3eea: bipush 1
      // 3eeb: bipush 5
      // 3eec: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 3eef: bipush 2
      // 3ef0: if_icmpne 3f52
      // 3ef3: aload 9
      // 3ef5: instanceof net/minecraft/world/entity/LivingEntity
      // 3ef8: ifeq 3f23
      // 3efb: aload 9
      // 3efd: checkcast net/minecraft/world/entity/LivingEntity
      // 3f00: astore 45
      // 3f02: aload 45
      // 3f04: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3f07: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3f0a: ifne 3f23
      // 3f0d: aload 45
      // 3f0f: new net/minecraft/world/effect/MobEffectInstance
      // 3f12: dup
      // 3f13: getstatic net/minecraft/world/effect/MobEffects.POISON Lnet/minecraft/world/effect/MobEffect;
      // 3f16: sipush 200
      // 3f19: bipush 0
      // 3f1a: bipush 0
      // 3f1b: bipush 1
      // 3f1c: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3f1f: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3f22: pop
      // 3f23: aload 9
      // 3f25: instanceof net/minecraft/world/entity/LivingEntity
      // 3f28: ifeq 3f52
      // 3f2b: aload 9
      // 3f2d: checkcast net/minecraft/world/entity/LivingEntity
      // 3f30: astore 45
      // 3f32: aload 45
      // 3f34: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3f37: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3f3a: ifne 3f52
      // 3f3d: aload 45
      // 3f3f: new net/minecraft/world/effect/MobEffectInstance
      // 3f42: dup
      // 3f43: getstatic net/minecraft/world/effect/MobEffects.CONFUSION Lnet/minecraft/world/effect/MobEffect;
      // 3f46: bipush 100
      // 3f48: bipush 0
      // 3f49: bipush 0
      // 3f4a: bipush 0
      // 3f4b: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3f4e: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3f51: pop
      // 3f52: aload 11
      // 3f54: invokevirtual net/minecraft/world/entity/Entity.isVehicle ()Z
      // 3f57: ifeq 3fff
      // 3f5a: aload 11
      // 3f5c: instanceof net/arphex/entity/SpiderMothSummonEntity
      // 3f5f: ifeq 3fff
      // 3f62: aload 11
      // 3f64: instanceof net/minecraft/world/entity/LivingEntity
      // 3f67: ifeq 3f91
      // 3f6a: aload 11
      // 3f6c: checkcast net/minecraft/world/entity/LivingEntity
      // 3f6f: astore 45
      // 3f71: aload 45
      // 3f73: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3f76: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3f79: ifne 3f91
      // 3f7c: aload 45
      // 3f7e: new net/minecraft/world/effect/MobEffectInstance
      // 3f81: dup
      // 3f82: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 3f85: bipush 60
      // 3f87: bipush 3
      // 3f88: bipush 0
      // 3f89: bipush 0
      // 3f8a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3f8d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3f90: pop
      // 3f91: aload 11
      // 3f93: invokevirtual net/minecraft/world/entity/Entity.getFirstPassenger ()Lnet/minecraft/world/entity/Entity;
      // 3f96: astore 46
      // 3f98: aload 46
      // 3f9a: instanceof net/minecraft/world/entity/LivingEntity
      // 3f9d: ifeq 3fc7
      // 3fa0: aload 46
      // 3fa2: checkcast net/minecraft/world/entity/LivingEntity
      // 3fa5: astore 45
      // 3fa7: aload 45
      // 3fa9: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3fac: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3faf: ifne 3fc7
      // 3fb2: aload 45
      // 3fb4: new net/minecraft/world/effect/MobEffectInstance
      // 3fb7: dup
      // 3fb8: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 3fbb: bipush 60
      // 3fbd: bipush 1
      // 3fbe: bipush 0
      // 3fbf: bipush 0
      // 3fc0: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3fc3: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3fc6: pop
      // 3fc7: aload 1
      // 3fc8: instanceof net/minecraft/server/level/ServerLevel
      // 3fcb: ifeq 3fff
      // 3fce: aload 1
      // 3fcf: checkcast net/minecraft/server/level/ServerLevel
      // 3fd2: astore 45
      // 3fd4: aload 45
      // 3fd6: getstatic net/arphex/init/ArphexModParticleTypes.CHARRED_BLOOD Lnet/minecraftforge/registries/RegistryObject;
      // 3fd9: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3fdc: checkcast net/minecraft/core/particles/SimpleParticleType
      // 3fdf: aload 11
      // 3fe1: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3fe4: aload 11
      // 3fe6: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 3fe9: aload 11
      // 3feb: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3fee: bipush 5
      // 3fef: ldc2_w 0.1
      // 3ff2: ldc2_w 0.1
      // 3ff5: ldc2_w 0.1
      // 3ff8: ldc2_w 0.2
      // 3ffb: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 3ffe: pop
      // 3fff: aload 1
      // 4000: ldc_w net/arphex/entity/SpiderMothSummonEntity
      // 4003: new net/minecraft/world/phys/Vec3
      // 4006: dup
      // 4007: dload 2
      // 4008: dload 4
      // 400a: dload 6
      // 400c: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 400f: ldc2_w 80.0
      // 4012: ldc2_w 80.0
      // 4015: ldc2_w 80.0
      // 4018: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 401b: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$60 (Lnet/arphex/entity/SpiderMothSummonEntity;)Z, (Lnet/arphex/entity/SpiderMothSummonEntity;)Z ]
      // 4020: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 4025: invokeinterface java/util/List.isEmpty ()Z 1
      // 402a: ifne 4147
      // 402d: aload 11
      // 402f: instanceof net/minecraft/world/entity/player/Player
      // 4032: ifeq 4147
      // 4035: aload 9
      // 4037: instanceof net/minecraft/world/entity/TamableAnimal
      // 403a: ifeq 4060
      // 403d: aload 9
      // 403f: checkcast net/minecraft/world/entity/TamableAnimal
      // 4042: astore 45
      // 4044: aload 11
      // 4046: instanceof net/minecraft/world/entity/LivingEntity
      // 4049: ifeq 4060
      // 404c: aload 11
      // 404e: checkcast net/minecraft/world/entity/LivingEntity
      // 4051: astore 46
      // 4053: aload 45
      // 4055: aload 46
      // 4057: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 405a: ifeq 4060
      // 405d: goto 4147
      // 4060: aload 1
      // 4061: ldc_w net/arphex/entity/SpiderMothSummonEntity
      // 4064: new net/minecraft/world/phys/Vec3
      // 4067: dup
      // 4068: dload 2
      // 4069: dload 4
      // 406b: dload 6
      // 406d: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4070: ldc2_w 80.0
      // 4073: ldc2_w 80.0
      // 4076: ldc2_w 80.0
      // 4079: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 407c: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$61 (Lnet/arphex/entity/SpiderMothSummonEntity;)Z, (Lnet/arphex/entity/SpiderMothSummonEntity;)Z ]
      // 4081: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 4086: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 408b: new net/arphex/procedures/DwellerLifestealProcedure$11
      // 408e: dup
      // 408f: invokespecial net/arphex/procedures/DwellerLifestealProcedure$11.<init> ()V
      // 4092: dload 2
      // 4093: dload 4
      // 4095: dload 6
      // 4097: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$11.compareDistOf (DDD)Ljava/util/Comparator;
      // 409a: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 409f: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 40a4: aconst_null
      // 40a5: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 40a8: checkcast net/minecraft/world/entity/Entity
      // 40ab: astore 49
      // 40ad: aload 49
      // 40af: instanceof net/minecraft/world/entity/TamableAnimal
      // 40b2: ifeq 4147
      // 40b5: aload 49
      // 40b7: checkcast net/minecraft/world/entity/TamableAnimal
      // 40ba: astore 47
      // 40bc: aload 11
      // 40be: instanceof net/minecraft/world/entity/LivingEntity
      // 40c1: ifeq 4147
      // 40c4: aload 11
      // 40c6: checkcast net/minecraft/world/entity/LivingEntity
      // 40c9: astore 48
      // 40cb: aload 47
      // 40cd: aload 48
      // 40cf: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 40d2: ifeq 4147
      // 40d5: aload 1
      // 40d6: ldc_w net/arphex/entity/SpiderMothSummonEntity
      // 40d9: new net/minecraft/world/phys/Vec3
      // 40dc: dup
      // 40dd: dload 2
      // 40de: dload 4
      // 40e0: dload 6
      // 40e2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 40e5: ldc2_w 80.0
      // 40e8: ldc2_w 80.0
      // 40eb: ldc2_w 80.0
      // 40ee: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 40f1: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$62 (Lnet/arphex/entity/SpiderMothSummonEntity;)Z, (Lnet/arphex/entity/SpiderMothSummonEntity;)Z ]
      // 40f6: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 40fb: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 4100: new net/arphex/procedures/DwellerLifestealProcedure$12
      // 4103: dup
      // 4104: invokespecial net/arphex/procedures/DwellerLifestealProcedure$12.<init> ()V
      // 4107: dload 2
      // 4108: dload 4
      // 410a: dload 6
      // 410c: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$12.compareDistOf (DDD)Ljava/util/Comparator;
      // 410f: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 4114: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 4119: aconst_null
      // 411a: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 411d: checkcast net/minecraft/world/entity/Entity
      // 4120: astore 51
      // 4122: aload 51
      // 4124: instanceof net/minecraft/world/entity/Mob
      // 4127: ifeq 4147
      // 412a: aload 51
      // 412c: checkcast net/minecraft/world/entity/Mob
      // 412f: astore 49
      // 4131: aload 9
      // 4133: instanceof net/minecraft/world/entity/LivingEntity
      // 4136: ifeq 4147
      // 4139: aload 9
      // 413b: checkcast net/minecraft/world/entity/LivingEntity
      // 413e: astore 50
      // 4140: aload 49
      // 4142: aload 50
      // 4144: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 4147: aload 9
      // 4149: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 414c: ifeq 41d7
      // 414f: bipush 1
      // 4150: aload 9
      // 4152: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$63 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 4157: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 415a: aload 9
      // 415c: instanceof net/minecraft/world/entity/LivingEntity
      // 415f: ifeq 419b
      // 4162: aload 9
      // 4164: checkcast net/minecraft/world/entity/LivingEntity
      // 4167: astore 45
      // 4169: aload 45
      // 416b: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 416e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4171: checkcast net/minecraft/world/effect/MobEffect
      // 4174: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 4177: ifeq 419b
      // 417a: aload 9
      // 417c: instanceof net/minecraft/world/entity/LivingEntity
      // 417f: ifeq 4198
      // 4182: aload 9
      // 4184: checkcast net/minecraft/world/entity/LivingEntity
      // 4187: astore 46
      // 4189: aload 46
      // 418b: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 418e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4191: checkcast net/minecraft/world/effect/MobEffect
      // 4194: invokevirtual net/minecraft/world/entity/LivingEntity.removeEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 4197: pop
      // 4198: goto 41d7
      // 419b: aload 9
      // 419d: instanceof net/minecraft/world/entity/LivingEntity
      // 41a0: ifeq 41d7
      // 41a3: aload 9
      // 41a5: checkcast net/minecraft/world/entity/LivingEntity
      // 41a8: astore 46
      // 41aa: aload 46
      // 41ac: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 41af: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 41b2: ifne 41d7
      // 41b5: aload 46
      // 41b7: new net/minecraft/world/effect/MobEffectInstance
      // 41ba: dup
      // 41bb: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 41be: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 41c1: checkcast net/minecraft/world/effect/MobEffect
      // 41c4: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 41c7: bipush 1
      // 41c8: bipush 50
      // 41ca: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 41cd: bipush 0
      // 41ce: bipush 0
      // 41cf: bipush 0
      // 41d0: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 41d3: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 41d6: pop
      // 41d7: aload 11
      // 41d9: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 41dc: ifeq 4313
      // 41df: aload 9
      // 41e1: instanceof net/minecraft/world/entity/LivingEntity
      // 41e4: ifeq 41ff
      // 41e7: aload 9
      // 41e9: checkcast net/minecraft/world/entity/LivingEntity
      // 41ec: astore 45
      // 41ee: aload 45
      // 41f0: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 41f3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 41f6: checkcast net/minecraft/world/effect/MobEffect
      // 41f9: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 41fc: ifne 4237
      // 41ff: aload 9
      // 4201: instanceof net/minecraft/world/entity/LivingEntity
      // 4204: ifeq 4234
      // 4207: aload 9
      // 4209: checkcast net/minecraft/world/entity/LivingEntity
      // 420c: astore 46
      // 420e: aload 46
      // 4210: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 4213: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4216: ifne 4234
      // 4219: aload 46
      // 421b: new net/minecraft/world/effect/MobEffectInstance
      // 421e: dup
      // 421f: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 4222: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4225: checkcast net/minecraft/world/effect/MobEffect
      // 4228: bipush 40
      // 422a: bipush 0
      // 422b: bipush 0
      // 422c: bipush 1
      // 422d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 4230: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 4233: pop
      // 4234: goto 4313
      // 4237: aload 9
      // 4239: instanceof net/minecraft/world/entity/LivingEntity
      // 423c: ifeq 426b
      // 423f: aload 9
      // 4241: checkcast net/minecraft/world/entity/LivingEntity
      // 4244: astore 46
      // 4246: aload 46
      // 4248: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 424b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 424e: checkcast net/minecraft/world/effect/MobEffect
      // 4251: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 4254: ifeq 426b
      // 4257: aload 46
      // 4259: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 425c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 425f: checkcast net/minecraft/world/effect/MobEffect
      // 4262: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 4265: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 4268: goto 426c
      // 426b: bipush 0
      // 426c: bipush 4
      // 426d: if_icmple 42a8
      // 4270: aload 9
      // 4272: instanceof net/minecraft/world/entity/LivingEntity
      // 4275: ifeq 42a5
      // 4278: aload 9
      // 427a: checkcast net/minecraft/world/entity/LivingEntity
      // 427d: astore 47
      // 427f: aload 47
      // 4281: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 4284: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4287: ifne 42a5
      // 428a: aload 47
      // 428c: new net/minecraft/world/effect/MobEffectInstance
      // 428f: dup
      // 4290: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 4293: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4296: checkcast net/minecraft/world/effect/MobEffect
      // 4299: bipush 60
      // 429b: bipush 5
      // 429c: bipush 0
      // 429d: bipush 1
      // 429e: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 42a1: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 42a4: pop
      // 42a5: goto 4313
      // 42a8: aload 9
      // 42aa: instanceof net/minecraft/world/entity/LivingEntity
      // 42ad: ifeq 4313
      // 42b0: aload 9
      // 42b2: checkcast net/minecraft/world/entity/LivingEntity
      // 42b5: astore 47
      // 42b7: aload 47
      // 42b9: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 42bc: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 42bf: ifne 4313
      // 42c2: aload 47
      // 42c4: new net/minecraft/world/effect/MobEffectInstance
      // 42c7: dup
      // 42c8: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 42cb: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 42ce: checkcast net/minecraft/world/effect/MobEffect
      // 42d1: bipush 50
      // 42d3: aload 9
      // 42d5: instanceof net/minecraft/world/entity/LivingEntity
      // 42d8: ifeq 4307
      // 42db: aload 9
      // 42dd: checkcast net/minecraft/world/entity/LivingEntity
      // 42e0: astore 48
      // 42e2: aload 48
      // 42e4: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 42e7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 42ea: checkcast net/minecraft/world/effect/MobEffect
      // 42ed: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 42f0: ifeq 4307
      // 42f3: aload 48
      // 42f5: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 42f8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 42fb: checkcast net/minecraft/world/effect/MobEffect
      // 42fe: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 4301: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 4304: goto 4308
      // 4307: bipush 0
      // 4308: bipush 1
      // 4309: iadd
      // 430a: bipush 0
      // 430b: bipush 1
      // 430c: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 430f: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 4312: pop
      // 4313: aload 11
      // 4315: instanceof net/arphex/entity/MosquitoMorbidityEntity
      // 4318: ifeq 434a
      // 431b: aload 11
      // 431d: instanceof net/minecraft/world/entity/LivingEntity
      // 4320: ifeq 434a
      // 4323: aload 11
      // 4325: checkcast net/minecraft/world/entity/LivingEntity
      // 4328: astore 45
      // 432a: aload 45
      // 432c: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 432f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4332: ifne 434a
      // 4335: aload 45
      // 4337: new net/minecraft/world/effect/MobEffectInstance
      // 433a: dup
      // 433b: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 433e: bipush 40
      // 4340: bipush 0
      // 4341: bipush 0
      // 4342: bipush 1
      // 4343: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 4346: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 4349: pop
      // 434a: aload 11
      // 434c: instanceof net/minecraft/world/entity/LivingEntity
      // 434f: ifeq 4361
      // 4352: aload 11
      // 4354: checkcast net/minecraft/world/entity/LivingEntity
      // 4357: astore 45
      // 4359: aload 45
      // 435b: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 435e: goto 4364
      // 4361: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4364: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4367: getstatic net/arphex/init/ArphexModItems.ASCENDANT_STAFF Lnet/minecraftforge/registries/RegistryObject;
      // 436a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 436d: if_acmpne 439f
      // 4370: aload 9
      // 4372: instanceof net/minecraft/world/entity/LivingEntity
      // 4375: ifeq 439f
      // 4378: aload 9
      // 437a: checkcast net/minecraft/world/entity/LivingEntity
      // 437d: astore 46
      // 437f: aload 46
      // 4381: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 4384: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4387: ifne 439f
      // 438a: aload 46
      // 438c: new net/minecraft/world/effect/MobEffectInstance
      // 438f: dup
      // 4390: getstatic net/minecraft/world/effect/MobEffects.LEVITATION Lnet/minecraft/world/effect/MobEffect;
      // 4393: bipush 60
      // 4395: bipush 1
      // 4396: bipush 0
      // 4397: bipush 1
      // 4398: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 439b: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 439e: pop
      // 439f: aload 9
      // 43a1: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 43a4: ifeq 4411
      // 43a7: dload 12
      // 43a9: ldc2_w 0.5
      // 43ac: dcmpl
      // 43ad: ifle 4411
      // 43b0: aload 9
      // 43b2: instanceof net/minecraft/world/entity/LivingEntity
      // 43b5: ifeq 43d0
      // 43b8: aload 9
      // 43ba: checkcast net/minecraft/world/entity/LivingEntity
      // 43bd: astore 45
      // 43bf: aload 45
      // 43c1: getstatic net/arphex/init/ArphexModMobEffects.THUNDER_SENSE Lnet/minecraftforge/registries/RegistryObject;
      // 43c4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 43c7: checkcast net/minecraft/world/effect/MobEffect
      // 43ca: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 43cd: ifne 4411
      // 43d0: aload 9
      // 43d2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 43d5: ldc_w "attackcycle"
      // 43d8: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 43db: dconst_0
      // 43dc: dcmpl
      // 43dd: ifgt 43f9
      // 43e0: aload 9
      // 43e2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 43e5: ldc_w "attackcycle"
      // 43e8: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 43eb: bipush 16
      // 43ed: bipush 30
      // 43ef: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 43f2: i2d
      // 43f3: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 43f6: goto 4411
      // 43f9: aload 9
      // 43fb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 43fe: ldc_w "attackcycle"
      // 4401: aload 9
      // 4403: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4406: ldc_w "attackcycle"
      // 4409: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 440c: dconst_1
      // 440d: dsub
      // 440e: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 4411: aload 9
      // 4413: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 4416: ifeq 4507
      // 4419: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 441c: bipush 1
      // 441d: bipush 5
      // 441e: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 4421: bipush 3
      // 4422: if_icmpne 4463
      // 4425: aload 1
      // 4426: instanceof net/minecraft/server/level/ServerLevel
      // 4429: ifeq 4451
      // 442c: aload 1
      // 442d: checkcast net/minecraft/server/level/ServerLevel
      // 4430: astore 45
      // 4432: aload 45
      // 4434: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_RED_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 4437: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 443a: checkcast net/minecraft/core/particles/SimpleParticleType
      // 443d: dload 2
      // 443e: dload 4
      // 4440: dload 6
      // 4442: bipush 5
      // 4443: ldc2_w 3.0
      // 4446: ldc2_w 3.0
      // 4449: ldc2_w 3.0
      // 444c: dconst_1
      // 444d: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 4450: pop
      // 4451: bipush 10
      // 4453: aload 1
      // 4454: dload 2
      // 4455: dload 4
      // 4457: dload 6
      // 4459: aload 9
      // 445b: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$65 (Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V, ()V ]
      // 4460: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 4463: aload 9
      // 4465: instanceof net/minecraft/world/entity/Mob
      // 4468: ifeq 447a
      // 446b: aload 9
      // 446d: checkcast net/minecraft/world/entity/Mob
      // 4470: astore 45
      // 4472: aload 45
      // 4474: invokevirtual net/minecraft/world/entity/Mob.getTarget ()Lnet/minecraft/world/entity/LivingEntity;
      // 4477: goto 447b
      // 447a: aconst_null
      // 447b: ifnonnull 44b9
      // 447e: aload 11
      // 4480: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4483: ldc "creativespectator"
      // 4485: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 4488: bipush 1
      // 4489: if_icmpne 4494
      // 448c: aload 11
      // 448e: instanceof net/arphex/entity/ScorpioidCloneEntity
      // 4491: ifeq 44b9
      // 4494: aload 9
      // 4496: instanceof net/minecraft/world/entity/Mob
      // 4499: ifeq 44b9
      // 449c: aload 9
      // 449e: checkcast net/minecraft/world/entity/Mob
      // 44a1: astore 46
      // 44a3: aload 11
      // 44a5: instanceof net/minecraft/world/entity/LivingEntity
      // 44a8: ifeq 44b9
      // 44ab: aload 11
      // 44ad: checkcast net/minecraft/world/entity/LivingEntity
      // 44b0: astore 47
      // 44b2: aload 46
      // 44b4: aload 47
      // 44b6: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 44b9: dload 12
      // 44bb: ldc2_w 12.0
      // 44be: dcmpl
      // 44bf: ifle 4507
      // 44c2: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 44c5: bipush 1
      // 44c6: bipush 3
      // 44c7: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 44ca: bipush 3
      // 44cb: if_icmpne 4507
      // 44ce: aload 9
      // 44d0: new net/minecraft/world/phys/Vec3
      // 44d3: dup
      // 44d4: aload 9
      // 44d6: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 44d9: ldc_w 90.0
      // 44dc: fsub
      // 44dd: f2d
      // 44de: ldc2_w 0.017453292519943295
      // 44e1: dmul
      // 44e2: invokestatic java/lang/Math.cos (D)D
      // 44e5: ldc2_w 2.0
      // 44e8: ddiv
      // 44e9: ldc2_w 0.6
      // 44ec: aload 9
      // 44ee: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 44f1: ldc_w 90.0
      // 44f4: fsub
      // 44f5: f2d
      // 44f6: ldc2_w 0.017453292519943295
      // 44f9: dmul
      // 44fa: invokestatic java/lang/Math.sin (D)D
      // 44fd: ldc2_w 2.0
      // 4500: ddiv
      // 4501: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4504: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 4507: aload 11
      // 4509: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 450c: ifeq 4601
      // 450f: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 4512: bipush 1
      // 4513: bipush 3
      // 4514: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 4517: bipush 2
      // 4518: if_icmple 4550
      // 451b: aload 11
      // 451d: instanceof net/minecraft/world/entity/LivingEntity
      // 4520: ifeq 4550
      // 4523: aload 11
      // 4525: checkcast net/minecraft/world/entity/LivingEntity
      // 4528: astore 45
      // 452a: aload 45
      // 452c: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 452f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4532: ifne 4550
      // 4535: aload 45
      // 4537: new net/minecraft/world/effect/MobEffectInstance
      // 453a: dup
      // 453b: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 453e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4541: checkcast net/minecraft/world/effect/MobEffect
      // 4544: bipush 10
      // 4546: bipush 5
      // 4547: bipush 0
      // 4548: bipush 0
      // 4549: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 454c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 454f: pop
      // 4550: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 4553: bipush 1
      // 4554: bipush 20
      // 4556: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 4559: bipush 2
      // 455a: if_icmple 458c
      // 455d: aload 9
      // 455f: instanceof net/minecraft/world/entity/LivingEntity
      // 4562: ifeq 458c
      // 4565: aload 9
      // 4567: checkcast net/minecraft/world/entity/LivingEntity
      // 456a: astore 45
      // 456c: aload 45
      // 456e: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 4571: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4574: ifne 458c
      // 4577: aload 45
      // 4579: new net/minecraft/world/effect/MobEffectInstance
      // 457c: dup
      // 457d: getstatic net/minecraft/world/effect/MobEffects.LEVITATION Lnet/minecraft/world/effect/MobEffect;
      // 4580: bipush 10
      // 4582: bipush 5
      // 4583: bipush 0
      // 4584: bipush 0
      // 4585: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 4588: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 458b: pop
      // 458c: aload 11
      // 458e: instanceof net/arphex/entity/ScorpioidBloodlusterEntity
      // 4591: ifeq 4601
      // 4594: aload 11
      // 4596: instanceof net/minecraft/world/entity/LivingEntity
      // 4599: ifeq 45b4
      // 459c: aload 11
      // 459e: checkcast net/minecraft/world/entity/LivingEntity
      // 45a1: astore 45
      // 45a3: aload 45
      // 45a5: getstatic net/arphex/init/ArphexModMobEffects.THUNDER_SENSE Lnet/minecraftforge/registries/RegistryObject;
      // 45a8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 45ab: checkcast net/minecraft/world/effect/MobEffect
      // 45ae: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 45b1: ifne 4601
      // 45b4: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 45b7: bipush 1
      // 45b8: bipush 3
      // 45b9: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 45bc: bipush 2
      // 45bd: if_icmple 4601
      // 45c0: aload 9
      // 45c2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 45c5: ldc_w "attackcycle"
      // 45c8: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 45cb: dconst_0
      // 45cc: dcmpl
      // 45cd: ifgt 45e9
      // 45d0: aload 9
      // 45d2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 45d5: ldc_w "attackcycle"
      // 45d8: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 45db: bipush 16
      // 45dd: bipush 30
      // 45df: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 45e2: i2d
      // 45e3: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 45e6: goto 4601
      // 45e9: aload 9
      // 45eb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 45ee: ldc_w "attackcycle"
      // 45f1: aload 9
      // 45f3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 45f6: ldc_w "attackcycle"
      // 45f9: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 45fc: dconst_1
      // 45fd: dsub
      // 45fe: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 4601: aload 11
      // 4603: instanceof net/minecraft/world/entity/LivingEntity
      // 4606: ifeq 4618
      // 4609: aload 11
      // 460b: checkcast net/minecraft/world/entity/LivingEntity
      // 460e: astore 45
      // 4610: aload 45
      // 4612: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 4615: goto 461b
      // 4618: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 461b: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 461e: getstatic net/arphex/init/ArphexModItems.ETHEREAL_STAFF Lnet/minecraftforge/registries/RegistryObject;
      // 4621: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4624: if_acmpne 467b
      // 4627: aload 9
      // 4629: instanceof net/minecraft/world/entity/LivingEntity
      // 462c: ifeq 463e
      // 462f: aload 9
      // 4631: checkcast net/minecraft/world/entity/LivingEntity
      // 4634: astore 46
      // 4636: aload 46
      // 4638: invokevirtual net/minecraft/world/entity/LivingEntity.getMaxHealth ()F
      // 463b: goto 4641
      // 463e: ldc_w -1.0
      // 4641: ldc_w 100.0
      // 4644: fcmpg
      // 4645: ifge 467b
      // 4648: aload 11
      // 464a: instanceof net/minecraft/world/entity/LivingEntity
      // 464d: ifeq 467b
      // 4650: aload 11
      // 4652: checkcast net/minecraft/world/entity/LivingEntity
      // 4655: astore 47
      // 4657: aload 47
      // 4659: getstatic net/arphex/init/ArphexModMobEffects.ETHEREAL_CHARGE Lnet/minecraftforge/registries/RegistryObject;
      // 465c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 465f: checkcast net/minecraft/world/effect/MobEffect
      // 4662: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 4665: ifeq 467b
      // 4668: bipush 5
      // 4669: aload 1
      // 466a: aload 11
      // 466c: aload 9
      // 466e: dload 2
      // 466f: dload 4
      // 4671: dload 6
      // 4673: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$66 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;DDD)V, ()V ]
      // 4678: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 467b: aload 11
      // 467d: instanceof net/arphex/entity/AntArsonistEntity
      // 4680: ifeq 4695
      // 4683: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 4686: bipush 1
      // 4687: bipush 2
      // 4688: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 468b: bipush 2
      // 468c: if_icmpne 4695
      // 468f: aload 9
      // 4691: bipush 5
      // 4692: invokevirtual net/minecraft/world/entity/Entity.setSecondsOnFire (I)V
      // 4695: aload 9
      // 4697: instanceof net/minecraft/world/entity/LivingEntity
      // 469a: ifeq 46af
      // 469d: aload 9
      // 469f: checkcast net/minecraft/world/entity/LivingEntity
      // 46a2: astore 45
      // 46a4: aload 45
      // 46a6: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 46a9: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 46ac: goto 46b2
      // 46af: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 46b2: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 46b5: getstatic net/arphex/init/ArphexModItems.ETERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 46b8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 46bb: if_acmpne 4739
      // 46be: aload 9
      // 46c0: instanceof net/minecraft/world/entity/LivingEntity
      // 46c3: ifeq 46d8
      // 46c6: aload 9
      // 46c8: checkcast net/minecraft/world/entity/LivingEntity
      // 46cb: astore 46
      // 46cd: aload 46
      // 46cf: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 46d2: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 46d5: goto 46db
      // 46d8: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 46db: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 46de: getstatic net/arphex/init/ArphexModItems.ETERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 46e1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 46e4: if_acmpne 4739
      // 46e7: aload 9
      // 46e9: instanceof net/minecraft/world/entity/LivingEntity
      // 46ec: ifeq 4701
      // 46ef: aload 9
      // 46f1: checkcast net/minecraft/world/entity/LivingEntity
      // 46f4: astore 47
      // 46f6: aload 47
      // 46f8: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 46fb: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 46fe: goto 4704
      // 4701: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4704: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4707: getstatic net/arphex/init/ArphexModItems.ETERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 470a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 470d: if_acmpne 4739
      // 4710: aload 9
      // 4712: instanceof net/minecraft/world/entity/LivingEntity
      // 4715: ifeq 472a
      // 4718: aload 9
      // 471a: checkcast net/minecraft/world/entity/LivingEntity
      // 471d: astore 48
      // 471f: aload 48
      // 4721: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 4724: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4727: goto 472d
      // 472a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 472d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4730: getstatic net/arphex/init/ArphexModItems.ETERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 4733: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4736: if_acmpeq 47dd
      // 4739: aload 9
      // 473b: instanceof net/minecraft/world/entity/LivingEntity
      // 473e: ifeq 4753
      // 4741: aload 9
      // 4743: checkcast net/minecraft/world/entity/LivingEntity
      // 4746: astore 49
      // 4748: aload 49
      // 474a: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 474d: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4750: goto 4756
      // 4753: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4756: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4759: getstatic net/arphex/init/ArphexModItems.IMMORTAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 475c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 475f: if_acmpne 4f4a
      // 4762: aload 9
      // 4764: instanceof net/minecraft/world/entity/LivingEntity
      // 4767: ifeq 477c
      // 476a: aload 9
      // 476c: checkcast net/minecraft/world/entity/LivingEntity
      // 476f: astore 50
      // 4771: aload 50
      // 4773: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 4776: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4779: goto 477f
      // 477c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 477f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4782: getstatic net/arphex/init/ArphexModItems.IMMORTAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 4785: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4788: if_acmpne 4f4a
      // 478b: aload 9
      // 478d: instanceof net/minecraft/world/entity/LivingEntity
      // 4790: ifeq 47a5
      // 4793: aload 9
      // 4795: checkcast net/minecraft/world/entity/LivingEntity
      // 4798: astore 51
      // 479a: aload 51
      // 479c: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 479f: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 47a2: goto 47a8
      // 47a5: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 47a8: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 47ab: getstatic net/arphex/init/ArphexModItems.IMMORTAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 47ae: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 47b1: if_acmpne 4f4a
      // 47b4: aload 9
      // 47b6: instanceof net/minecraft/world/entity/LivingEntity
      // 47b9: ifeq 47ce
      // 47bc: aload 9
      // 47be: checkcast net/minecraft/world/entity/LivingEntity
      // 47c1: astore 52
      // 47c3: aload 52
      // 47c5: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 47c8: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 47cb: goto 47d1
      // 47ce: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 47d1: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 47d4: getstatic net/arphex/init/ArphexModItems.IMMORTAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 47d7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 47da: if_acmpne 4f4a
      // 47dd: aload 11
      // 47df: new net/minecraft/world/phys/Vec3
      // 47e2: dup
      // 47e3: aload 11
      // 47e5: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 47e8: ldc_w 90.0
      // 47eb: fsub
      // 47ec: f2d
      // 47ed: ldc2_w 0.017453292519943295
      // 47f0: dmul
      // 47f1: invokestatic java/lang/Math.cos (D)D
      // 47f4: ldc2_w 2.0
      // 47f7: ddiv
      // 47f8: ldc2_w 0.6
      // 47fb: aload 11
      // 47fd: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 4800: ldc_w 90.0
      // 4803: fsub
      // 4804: f2d
      // 4805: ldc2_w 0.017453292519943295
      // 4808: dmul
      // 4809: invokestatic java/lang/Math.sin (D)D
      // 480c: ldc2_w 2.0
      // 480f: ddiv
      // 4810: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4813: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 4816: aload 11
      // 4818: instanceof net/minecraft/world/entity/LivingEntity
      // 481b: ifeq 4843
      // 481e: aload 11
      // 4820: checkcast net/minecraft/world/entity/LivingEntity
      // 4823: astore 53
      // 4825: aload 53
      // 4827: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 482a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 482d: ifne 4843
      // 4830: aload 53
      // 4832: new net/minecraft/world/effect/MobEffectInstance
      // 4835: dup
      // 4836: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 4839: bipush 30
      // 483b: bipush 1
      // 483c: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 483f: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 4842: pop
      // 4843: aload 11
      // 4845: bipush 3
      // 4846: invokevirtual net/minecraft/world/entity/Entity.setSecondsOnFire (I)V
      // 4849: dload 12
      // 484b: ldc2_w 5.0
      // 484e: dcmpg
      // 484f: ifgt 48f9
      // 4852: aload 9
      // 4854: instanceof net/minecraft/world/entity/LivingEntity
      // 4857: ifeq 4881
      // 485a: aload 9
      // 485c: checkcast net/minecraft/world/entity/LivingEntity
      // 485f: astore 53
      // 4861: aload 53
      // 4863: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 4866: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4869: ifne 4881
      // 486c: aload 53
      // 486e: new net/minecraft/world/effect/MobEffectInstance
      // 4871: dup
      // 4872: getstatic net/minecraft/world/effect/MobEffects.INVISIBILITY Lnet/minecraft/world/effect/MobEffect;
      // 4875: bipush 10
      // 4877: bipush 1
      // 4878: bipush 0
      // 4879: bipush 0
      // 487a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 487d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 4880: pop
      // 4881: aload 1
      // 4882: instanceof net/minecraft/world/level/Level
      // 4885: ifeq 48e6
      // 4888: aload 1
      // 4889: checkcast net/minecraft/world/level/Level
      // 488c: astore 53
      // 488e: aload 53
      // 4890: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4893: ifne 48c1
      // 4896: aload 53
      // 4898: aconst_null
      // 4899: dload 2
      // 489a: dload 4
      // 489c: dload 6
      // 489e: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 48a1: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 48a4: new net/minecraft/resources/ResourceLocation
      // 48a7: dup
      // 48a8: ldc_w "item.shield.block"
      // 48ab: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 48ae: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 48b3: checkcast net/minecraft/sounds/SoundEvent
      // 48b6: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 48b9: fconst_1
      // 48ba: fconst_1
      // 48bb: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 48be: goto 48e6
      // 48c1: aload 53
      // 48c3: dload 2
      // 48c4: dload 4
      // 48c6: dload 6
      // 48c8: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 48cb: new net/minecraft/resources/ResourceLocation
      // 48ce: dup
      // 48cf: ldc_w "item.shield.block"
      // 48d2: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 48d5: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 48da: checkcast net/minecraft/sounds/SoundEvent
      // 48dd: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 48e0: fconst_1
      // 48e1: fconst_1
      // 48e2: bipush 0
      // 48e3: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 48e6: aload 0
      // 48e7: ifnull 4f4a
      // 48ea: aload 0
      // 48eb: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 48ee: ifeq 4f4a
      // 48f1: aload 0
      // 48f2: bipush 1
      // 48f3: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 48f6: goto 4f4a
      // 48f9: aload 9
      // 48fb: instanceof net/minecraft/world/entity/LivingEntity
      // 48fe: ifeq 4f4a
      // 4901: aload 9
      // 4903: checkcast net/minecraft/world/entity/LivingEntity
      // 4906: astore 53
      // 4908: aload 53
      // 490a: getstatic net/arphex/init/ArphexModMobEffects.ETERNAL_EVASION Lnet/minecraftforge/registries/RegistryObject;
      // 490d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4910: checkcast net/minecraft/world/effect/MobEffect
      // 4913: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 4916: ifeq 4f4a
      // 4919: aload 1
      // 491a: aload 9
      // 491c: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 491f: dconst_1
      // 4920: dadd
      // 4921: aload 9
      // 4923: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4926: aload 9
      // 4928: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 492b: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 492e: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 4933: aload 1
      // 4934: aload 9
      // 4936: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4939: dconst_1
      // 493a: dadd
      // 493b: aload 9
      // 493d: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4940: aload 9
      // 4942: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4945: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4948: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 494b: f2d
      // 494c: ldc2_w 0.2
      // 494f: dcmpg
      // 4950: ifge 4aa6
      // 4953: aload 1
      // 4954: aload 9
      // 4956: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4959: dconst_1
      // 495a: dadd
      // 495b: aload 9
      // 495d: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4960: dconst_1
      // 4961: dadd
      // 4962: aload 9
      // 4964: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4967: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 496a: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 496f: aload 1
      // 4970: aload 9
      // 4972: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4975: dconst_1
      // 4976: dadd
      // 4977: aload 9
      // 4979: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 497c: dconst_1
      // 497d: dadd
      // 497e: aload 9
      // 4980: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4983: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4986: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 4989: f2d
      // 498a: ldc2_w 0.2
      // 498d: dcmpg
      // 498e: ifge 4aa6
      // 4991: aload 9
      // 4993: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4996: aload 9
      // 4998: instanceof net/minecraft/world/entity/LivingEntity
      // 499b: ifeq 49b0
      // 499e: aload 9
      // 49a0: checkcast net/minecraft/world/entity/LivingEntity
      // 49a3: astore 54
      // 49a5: aload 54
      // 49a7: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 49aa: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 49ad: goto 49b3
      // 49b0: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 49b3: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 49b6: ldc_w "etdirx"
      // 49b9: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 49bc: dcmpl
      // 49bd: ifle 4aa6
      // 49c0: aload 11
      // 49c2: instanceof net/minecraft/world/entity/player/Player
      // 49c5: ifeq 49e2
      // 49c8: ldc2_w 20.0
      // 49cb: dstore 55
      // 49cd: aload 11
      // 49cf: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 49d2: aconst_null
      // 49d3: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 49d6: dload 55
      // 49d8: aload 11
      // 49da: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$67 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 49df: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 49e2: aload 1
      // 49e3: instanceof net/minecraft/world/level/Level
      // 49e6: ifeq 4a47
      // 49e9: aload 1
      // 49ea: checkcast net/minecraft/world/level/Level
      // 49ed: astore 55
      // 49ef: aload 55
      // 49f1: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 49f4: ifne 4a22
      // 49f7: aload 55
      // 49f9: aconst_null
      // 49fa: dload 2
      // 49fb: dload 4
      // 49fd: dload 6
      // 49ff: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4a02: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4a05: new net/minecraft/resources/ResourceLocation
      // 4a08: dup
      // 4a09: ldc_w "item.shield.block"
      // 4a0c: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4a0f: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4a14: checkcast net/minecraft/sounds/SoundEvent
      // 4a17: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4a1a: fconst_1
      // 4a1b: fconst_1
      // 4a1c: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 4a1f: goto 4a47
      // 4a22: aload 55
      // 4a24: dload 2
      // 4a25: dload 4
      // 4a27: dload 6
      // 4a29: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4a2c: new net/minecraft/resources/ResourceLocation
      // 4a2f: dup
      // 4a30: ldc_w "item.shield.block"
      // 4a33: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4a36: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4a3b: checkcast net/minecraft/sounds/SoundEvent
      // 4a3e: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4a41: fconst_1
      // 4a42: fconst_1
      // 4a43: bipush 0
      // 4a44: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 4a47: aload 0
      // 4a48: ifnull 4a57
      // 4a4b: aload 0
      // 4a4c: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 4a4f: ifeq 4a57
      // 4a52: aload 0
      // 4a53: bipush 1
      // 4a54: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 4a57: aload 9
      // 4a59: astore 55
      // 4a5b: aload 55
      // 4a5d: aload 9
      // 4a5f: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4a62: dconst_1
      // 4a63: dadd
      // 4a64: aload 9
      // 4a66: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4a69: aload 9
      // 4a6b: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4a6e: invokevirtual net/minecraft/world/entity/Entity.teleportTo (DDD)V
      // 4a71: aload 55
      // 4a73: instanceof net/minecraft/server/level/ServerPlayer
      // 4a76: ifeq 4aa3
      // 4a79: aload 55
      // 4a7b: checkcast net/minecraft/server/level/ServerPlayer
      // 4a7e: astore 56
      // 4a80: aload 56
      // 4a82: getfield net/minecraft/server/level/ServerPlayer.connection Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
      // 4a85: aload 9
      // 4a87: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4a8a: dconst_1
      // 4a8b: dadd
      // 4a8c: aload 9
      // 4a8e: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4a91: aload 9
      // 4a93: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4a96: aload 55
      // 4a98: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 4a9b: aload 55
      // 4a9d: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 4aa0: invokevirtual net/minecraft/server/network/ServerGamePacketListenerImpl.teleport (DDDFF)V
      // 4aa3: goto 4f4a
      // 4aa6: aload 1
      // 4aa7: aload 9
      // 4aa9: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4aac: dconst_1
      // 4aad: dsub
      // 4aae: aload 9
      // 4ab0: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4ab3: aload 9
      // 4ab5: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4ab8: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4abb: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 4ac0: aload 1
      // 4ac1: aload 9
      // 4ac3: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4ac6: dconst_1
      // 4ac7: dsub
      // 4ac8: aload 9
      // 4aca: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4acd: aload 9
      // 4acf: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4ad2: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4ad5: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 4ad8: f2d
      // 4ad9: ldc2_w 0.2
      // 4adc: dcmpg
      // 4add: ifge 4c33
      // 4ae0: aload 1
      // 4ae1: aload 9
      // 4ae3: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4ae6: dconst_1
      // 4ae7: dsub
      // 4ae8: aload 9
      // 4aea: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4aed: dconst_1
      // 4aee: dadd
      // 4aef: aload 9
      // 4af1: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4af4: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4af7: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 4afc: aload 1
      // 4afd: aload 9
      // 4aff: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4b02: dconst_1
      // 4b03: dsub
      // 4b04: aload 9
      // 4b06: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4b09: dconst_1
      // 4b0a: dadd
      // 4b0b: aload 9
      // 4b0d: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4b10: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4b13: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 4b16: f2d
      // 4b17: ldc2_w 0.2
      // 4b1a: dcmpg
      // 4b1b: ifge 4c33
      // 4b1e: aload 9
      // 4b20: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4b23: aload 9
      // 4b25: instanceof net/minecraft/world/entity/LivingEntity
      // 4b28: ifeq 4b3d
      // 4b2b: aload 9
      // 4b2d: checkcast net/minecraft/world/entity/LivingEntity
      // 4b30: astore 55
      // 4b32: aload 55
      // 4b34: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 4b37: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4b3a: goto 4b40
      // 4b3d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4b40: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 4b43: ldc_w "etdirx"
      // 4b46: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 4b49: dcmpg
      // 4b4a: ifge 4c33
      // 4b4d: aload 11
      // 4b4f: instanceof net/minecraft/world/entity/player/Player
      // 4b52: ifeq 4b6f
      // 4b55: ldc2_w 20.0
      // 4b58: dstore 56
      // 4b5a: aload 11
      // 4b5c: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4b5f: aconst_null
      // 4b60: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4b63: dload 56
      // 4b65: aload 11
      // 4b67: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$68 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4b6c: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4b6f: aload 1
      // 4b70: instanceof net/minecraft/world/level/Level
      // 4b73: ifeq 4bd4
      // 4b76: aload 1
      // 4b77: checkcast net/minecraft/world/level/Level
      // 4b7a: astore 56
      // 4b7c: aload 56
      // 4b7e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4b81: ifne 4baf
      // 4b84: aload 56
      // 4b86: aconst_null
      // 4b87: dload 2
      // 4b88: dload 4
      // 4b8a: dload 6
      // 4b8c: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4b8f: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4b92: new net/minecraft/resources/ResourceLocation
      // 4b95: dup
      // 4b96: ldc_w "item.shield.block"
      // 4b99: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4b9c: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4ba1: checkcast net/minecraft/sounds/SoundEvent
      // 4ba4: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4ba7: fconst_1
      // 4ba8: fconst_1
      // 4ba9: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 4bac: goto 4bd4
      // 4baf: aload 56
      // 4bb1: dload 2
      // 4bb2: dload 4
      // 4bb4: dload 6
      // 4bb6: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4bb9: new net/minecraft/resources/ResourceLocation
      // 4bbc: dup
      // 4bbd: ldc_w "item.shield.block"
      // 4bc0: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4bc3: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4bc8: checkcast net/minecraft/sounds/SoundEvent
      // 4bcb: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4bce: fconst_1
      // 4bcf: fconst_1
      // 4bd0: bipush 0
      // 4bd1: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 4bd4: aload 0
      // 4bd5: ifnull 4be4
      // 4bd8: aload 0
      // 4bd9: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 4bdc: ifeq 4be4
      // 4bdf: aload 0
      // 4be0: bipush 1
      // 4be1: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 4be4: aload 9
      // 4be6: astore 56
      // 4be8: aload 56
      // 4bea: aload 9
      // 4bec: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4bef: dconst_1
      // 4bf0: dsub
      // 4bf1: aload 9
      // 4bf3: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4bf6: aload 9
      // 4bf8: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4bfb: invokevirtual net/minecraft/world/entity/Entity.teleportTo (DDD)V
      // 4bfe: aload 56
      // 4c00: instanceof net/minecraft/server/level/ServerPlayer
      // 4c03: ifeq 4c30
      // 4c06: aload 56
      // 4c08: checkcast net/minecraft/server/level/ServerPlayer
      // 4c0b: astore 57
      // 4c0d: aload 57
      // 4c0f: getfield net/minecraft/server/level/ServerPlayer.connection Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
      // 4c12: aload 9
      // 4c14: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4c17: dconst_1
      // 4c18: dsub
      // 4c19: aload 9
      // 4c1b: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4c1e: aload 9
      // 4c20: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4c23: aload 56
      // 4c25: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 4c28: aload 56
      // 4c2a: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 4c2d: invokevirtual net/minecraft/server/network/ServerGamePacketListenerImpl.teleport (DDDFF)V
      // 4c30: goto 4f4a
      // 4c33: aload 1
      // 4c34: aload 9
      // 4c36: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4c39: aload 9
      // 4c3b: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4c3e: aload 9
      // 4c40: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4c43: dconst_1
      // 4c44: dsub
      // 4c45: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4c48: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 4c4d: aload 1
      // 4c4e: aload 9
      // 4c50: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4c53: aload 9
      // 4c55: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4c58: aload 9
      // 4c5a: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4c5d: dconst_1
      // 4c5e: dsub
      // 4c5f: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4c62: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 4c65: f2d
      // 4c66: ldc2_w 0.2
      // 4c69: dcmpg
      // 4c6a: ifge 4dc0
      // 4c6d: aload 1
      // 4c6e: aload 9
      // 4c70: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4c73: aload 9
      // 4c75: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4c78: dconst_1
      // 4c79: dadd
      // 4c7a: aload 9
      // 4c7c: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4c7f: dconst_1
      // 4c80: dsub
      // 4c81: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4c84: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 4c89: aload 1
      // 4c8a: aload 9
      // 4c8c: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4c8f: aload 9
      // 4c91: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4c94: dconst_1
      // 4c95: dadd
      // 4c96: aload 9
      // 4c98: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4c9b: dconst_1
      // 4c9c: dsub
      // 4c9d: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4ca0: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 4ca3: f2d
      // 4ca4: ldc2_w 0.2
      // 4ca7: dcmpg
      // 4ca8: ifge 4dc0
      // 4cab: aload 9
      // 4cad: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4cb0: aload 9
      // 4cb2: instanceof net/minecraft/world/entity/LivingEntity
      // 4cb5: ifeq 4cca
      // 4cb8: aload 9
      // 4cba: checkcast net/minecraft/world/entity/LivingEntity
      // 4cbd: astore 56
      // 4cbf: aload 56
      // 4cc1: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 4cc4: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4cc7: goto 4ccd
      // 4cca: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4ccd: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 4cd0: ldc_w "etdirz"
      // 4cd3: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 4cd6: dcmpg
      // 4cd7: ifge 4dc0
      // 4cda: aload 11
      // 4cdc: instanceof net/minecraft/world/entity/player/Player
      // 4cdf: ifeq 4cfc
      // 4ce2: ldc2_w 20.0
      // 4ce5: dstore 57
      // 4ce7: aload 11
      // 4ce9: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4cec: aconst_null
      // 4ced: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4cf0: dload 57
      // 4cf2: aload 11
      // 4cf4: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$69 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4cf9: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4cfc: aload 1
      // 4cfd: instanceof net/minecraft/world/level/Level
      // 4d00: ifeq 4d61
      // 4d03: aload 1
      // 4d04: checkcast net/minecraft/world/level/Level
      // 4d07: astore 57
      // 4d09: aload 57
      // 4d0b: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4d0e: ifne 4d3c
      // 4d11: aload 57
      // 4d13: aconst_null
      // 4d14: dload 2
      // 4d15: dload 4
      // 4d17: dload 6
      // 4d19: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4d1c: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4d1f: new net/minecraft/resources/ResourceLocation
      // 4d22: dup
      // 4d23: ldc_w "item.shield.block"
      // 4d26: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4d29: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4d2e: checkcast net/minecraft/sounds/SoundEvent
      // 4d31: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4d34: fconst_1
      // 4d35: fconst_1
      // 4d36: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 4d39: goto 4d61
      // 4d3c: aload 57
      // 4d3e: dload 2
      // 4d3f: dload 4
      // 4d41: dload 6
      // 4d43: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4d46: new net/minecraft/resources/ResourceLocation
      // 4d49: dup
      // 4d4a: ldc_w "item.shield.block"
      // 4d4d: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4d50: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4d55: checkcast net/minecraft/sounds/SoundEvent
      // 4d58: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4d5b: fconst_1
      // 4d5c: fconst_1
      // 4d5d: bipush 0
      // 4d5e: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 4d61: aload 0
      // 4d62: ifnull 4d71
      // 4d65: aload 0
      // 4d66: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 4d69: ifeq 4d71
      // 4d6c: aload 0
      // 4d6d: bipush 1
      // 4d6e: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 4d71: aload 9
      // 4d73: astore 57
      // 4d75: aload 57
      // 4d77: aload 9
      // 4d79: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4d7c: aload 9
      // 4d7e: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4d81: aload 9
      // 4d83: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4d86: dconst_1
      // 4d87: dsub
      // 4d88: invokevirtual net/minecraft/world/entity/Entity.teleportTo (DDD)V
      // 4d8b: aload 57
      // 4d8d: instanceof net/minecraft/server/level/ServerPlayer
      // 4d90: ifeq 4dbd
      // 4d93: aload 57
      // 4d95: checkcast net/minecraft/server/level/ServerPlayer
      // 4d98: astore 58
      // 4d9a: aload 58
      // 4d9c: getfield net/minecraft/server/level/ServerPlayer.connection Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
      // 4d9f: aload 9
      // 4da1: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4da4: aload 9
      // 4da6: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4da9: aload 9
      // 4dab: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4dae: dconst_1
      // 4daf: dsub
      // 4db0: aload 57
      // 4db2: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 4db5: aload 57
      // 4db7: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 4dba: invokevirtual net/minecraft/server/network/ServerGamePacketListenerImpl.teleport (DDDFF)V
      // 4dbd: goto 4f4a
      // 4dc0: aload 1
      // 4dc1: aload 9
      // 4dc3: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4dc6: aload 9
      // 4dc8: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4dcb: aload 9
      // 4dcd: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4dd0: dconst_1
      // 4dd1: dadd
      // 4dd2: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4dd5: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 4dda: aload 1
      // 4ddb: aload 9
      // 4ddd: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4de0: aload 9
      // 4de2: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4de5: aload 9
      // 4de7: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4dea: dconst_1
      // 4deb: dadd
      // 4dec: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4def: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 4df2: f2d
      // 4df3: ldc2_w 0.2
      // 4df6: dcmpg
      // 4df7: ifge 4f4a
      // 4dfa: aload 1
      // 4dfb: aload 9
      // 4dfd: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4e00: aload 9
      // 4e02: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4e05: dconst_1
      // 4e06: dadd
      // 4e07: aload 9
      // 4e09: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4e0c: dconst_1
      // 4e0d: dadd
      // 4e0e: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4e11: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 4e16: aload 1
      // 4e17: aload 9
      // 4e19: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4e1c: aload 9
      // 4e1e: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4e21: dconst_1
      // 4e22: dadd
      // 4e23: aload 9
      // 4e25: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4e28: dconst_1
      // 4e29: dadd
      // 4e2a: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4e2d: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 4e30: f2d
      // 4e31: ldc2_w 0.2
      // 4e34: dcmpg
      // 4e35: ifge 4f4a
      // 4e38: aload 9
      // 4e3a: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4e3d: aload 9
      // 4e3f: instanceof net/minecraft/world/entity/LivingEntity
      // 4e42: ifeq 4e57
      // 4e45: aload 9
      // 4e47: checkcast net/minecraft/world/entity/LivingEntity
      // 4e4a: astore 57
      // 4e4c: aload 57
      // 4e4e: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 4e51: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4e54: goto 4e5a
      // 4e57: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4e5a: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 4e5d: ldc_w "etdirz"
      // 4e60: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 4e63: dcmpl
      // 4e64: ifle 4f4a
      // 4e67: aload 11
      // 4e69: instanceof net/minecraft/world/entity/player/Player
      // 4e6c: ifeq 4e89
      // 4e6f: ldc2_w 20.0
      // 4e72: dstore 58
      // 4e74: aload 11
      // 4e76: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4e79: aconst_null
      // 4e7a: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4e7d: dload 58
      // 4e7f: aload 11
      // 4e81: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$70 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4e86: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4e89: aload 1
      // 4e8a: instanceof net/minecraft/world/level/Level
      // 4e8d: ifeq 4eee
      // 4e90: aload 1
      // 4e91: checkcast net/minecraft/world/level/Level
      // 4e94: astore 58
      // 4e96: aload 58
      // 4e98: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4e9b: ifne 4ec9
      // 4e9e: aload 58
      // 4ea0: aconst_null
      // 4ea1: dload 2
      // 4ea2: dload 4
      // 4ea4: dload 6
      // 4ea6: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 4ea9: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4eac: new net/minecraft/resources/ResourceLocation
      // 4eaf: dup
      // 4eb0: ldc_w "item.shield.block"
      // 4eb3: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4eb6: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4ebb: checkcast net/minecraft/sounds/SoundEvent
      // 4ebe: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4ec1: fconst_1
      // 4ec2: fconst_1
      // 4ec3: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 4ec6: goto 4eee
      // 4ec9: aload 58
      // 4ecb: dload 2
      // 4ecc: dload 4
      // 4ece: dload 6
      // 4ed0: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4ed3: new net/minecraft/resources/ResourceLocation
      // 4ed6: dup
      // 4ed7: ldc_w "item.shield.block"
      // 4eda: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4edd: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4ee2: checkcast net/minecraft/sounds/SoundEvent
      // 4ee5: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 4ee8: fconst_1
      // 4ee9: fconst_1
      // 4eea: bipush 0
      // 4eeb: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 4eee: aload 0
      // 4eef: ifnull 4efe
      // 4ef2: aload 0
      // 4ef3: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 4ef6: ifeq 4efe
      // 4ef9: aload 0
      // 4efa: bipush 1
      // 4efb: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 4efe: aload 9
      // 4f00: astore 58
      // 4f02: aload 58
      // 4f04: aload 9
      // 4f06: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4f09: aload 9
      // 4f0b: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4f0e: aload 9
      // 4f10: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4f13: dconst_1
      // 4f14: dadd
      // 4f15: invokevirtual net/minecraft/world/entity/Entity.teleportTo (DDD)V
      // 4f18: aload 58
      // 4f1a: instanceof net/minecraft/server/level/ServerPlayer
      // 4f1d: ifeq 4f4a
      // 4f20: aload 58
      // 4f22: checkcast net/minecraft/server/level/ServerPlayer
      // 4f25: astore 59
      // 4f27: aload 59
      // 4f29: getfield net/minecraft/server/level/ServerPlayer.connection Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
      // 4f2c: aload 9
      // 4f2e: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4f31: aload 9
      // 4f33: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4f36: aload 9
      // 4f38: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4f3b: dconst_1
      // 4f3c: dadd
      // 4f3d: aload 58
      // 4f3f: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 4f42: aload 58
      // 4f44: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 4f47: invokevirtual net/minecraft/server/network/ServerGamePacketListenerImpl.teleport (DDDFF)V
      // 4f4a: aload 9
      // 4f4c: instanceof net/minecraft/world/entity/LivingEntity
      // 4f4f: ifeq 4f64
      // 4f52: aload 9
      // 4f54: checkcast net/minecraft/world/entity/LivingEntity
      // 4f57: astore 45
      // 4f59: aload 45
      // 4f5b: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 4f5e: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4f61: goto 4f67
      // 4f64: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4f67: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4f6a: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 4f6d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4f70: if_acmpne 4fee
      // 4f73: aload 9
      // 4f75: instanceof net/minecraft/world/entity/LivingEntity
      // 4f78: ifeq 4f8d
      // 4f7b: aload 9
      // 4f7d: checkcast net/minecraft/world/entity/LivingEntity
      // 4f80: astore 46
      // 4f82: aload 46
      // 4f84: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 4f87: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4f8a: goto 4f90
      // 4f8d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4f90: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4f93: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 4f96: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4f99: if_acmpne 4fee
      // 4f9c: aload 9
      // 4f9e: instanceof net/minecraft/world/entity/LivingEntity
      // 4fa1: ifeq 4fb6
      // 4fa4: aload 9
      // 4fa6: checkcast net/minecraft/world/entity/LivingEntity
      // 4fa9: astore 47
      // 4fab: aload 47
      // 4fad: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 4fb0: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4fb3: goto 4fb9
      // 4fb6: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4fb9: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4fbc: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 4fbf: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4fc2: if_acmpne 4fee
      // 4fc5: aload 9
      // 4fc7: instanceof net/minecraft/world/entity/LivingEntity
      // 4fca: ifeq 4fdf
      // 4fcd: aload 9
      // 4fcf: checkcast net/minecraft/world/entity/LivingEntity
      // 4fd2: astore 48
      // 4fd4: aload 48
      // 4fd6: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 4fd9: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 4fdc: goto 4fe2
      // 4fdf: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4fe2: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4fe5: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 4fe8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4feb: if_acmpeq 522c
      // 4fee: aload 9
      // 4ff0: instanceof net/minecraft/world/entity/LivingEntity
      // 4ff3: ifeq 5008
      // 4ff6: aload 9
      // 4ff8: checkcast net/minecraft/world/entity/LivingEntity
      // 4ffb: astore 49
      // 4ffd: aload 49
      // 4fff: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 5002: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5005: goto 500b
      // 5008: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 500b: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 500e: getstatic net/arphex/init/ArphexModItems.UMBRAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 5011: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5014: if_acmpne 5092
      // 5017: aload 9
      // 5019: instanceof net/minecraft/world/entity/LivingEntity
      // 501c: ifeq 5031
      // 501f: aload 9
      // 5021: checkcast net/minecraft/world/entity/LivingEntity
      // 5024: astore 50
      // 5026: aload 50
      // 5028: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 502b: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 502e: goto 5034
      // 5031: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5034: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5037: getstatic net/arphex/init/ArphexModItems.UMBRAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 503a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 503d: if_acmpne 5092
      // 5040: aload 9
      // 5042: instanceof net/minecraft/world/entity/LivingEntity
      // 5045: ifeq 505a
      // 5048: aload 9
      // 504a: checkcast net/minecraft/world/entity/LivingEntity
      // 504d: astore 51
      // 504f: aload 51
      // 5051: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 5054: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5057: goto 505d
      // 505a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 505d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5060: getstatic net/arphex/init/ArphexModItems.UMBRAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 5063: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5066: if_acmpne 5092
      // 5069: aload 9
      // 506b: instanceof net/minecraft/world/entity/LivingEntity
      // 506e: ifeq 5083
      // 5071: aload 9
      // 5073: checkcast net/minecraft/world/entity/LivingEntity
      // 5076: astore 52
      // 5078: aload 52
      // 507a: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 507d: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5080: goto 5086
      // 5083: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5086: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5089: getstatic net/arphex/init/ArphexModItems.UMBRAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 508c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 508f: if_acmpeq 522c
      // 5092: aload 9
      // 5094: instanceof net/minecraft/world/entity/LivingEntity
      // 5097: ifeq 50ac
      // 509a: aload 9
      // 509c: checkcast net/minecraft/world/entity/LivingEntity
      // 509f: astore 53
      // 50a1: aload 53
      // 50a3: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 50a6: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 50a9: goto 50af
      // 50ac: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 50af: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 50b2: getstatic net/arphex/init/ArphexModItems.SPECTRAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 50b5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 50b8: if_acmpne 5136
      // 50bb: aload 9
      // 50bd: instanceof net/minecraft/world/entity/LivingEntity
      // 50c0: ifeq 50d5
      // 50c3: aload 9
      // 50c5: checkcast net/minecraft/world/entity/LivingEntity
      // 50c8: astore 54
      // 50ca: aload 54
      // 50cc: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 50cf: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 50d2: goto 50d8
      // 50d5: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 50d8: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 50db: getstatic net/arphex/init/ArphexModItems.SPECTRAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 50de: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 50e1: if_acmpne 5136
      // 50e4: aload 9
      // 50e6: instanceof net/minecraft/world/entity/LivingEntity
      // 50e9: ifeq 50fe
      // 50ec: aload 9
      // 50ee: checkcast net/minecraft/world/entity/LivingEntity
      // 50f1: astore 55
      // 50f3: aload 55
      // 50f5: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 50f8: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 50fb: goto 5101
      // 50fe: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5101: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5104: getstatic net/arphex/init/ArphexModItems.SPECTRAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 5107: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 510a: if_acmpne 5136
      // 510d: aload 9
      // 510f: instanceof net/minecraft/world/entity/LivingEntity
      // 5112: ifeq 5127
      // 5115: aload 9
      // 5117: checkcast net/minecraft/world/entity/LivingEntity
      // 511a: astore 56
      // 511c: aload 56
      // 511e: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 5121: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5124: goto 512a
      // 5127: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 512a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 512d: getstatic net/arphex/init/ArphexModItems.SPECTRAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 5130: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5133: if_acmpeq 522c
      // 5136: aload 9
      // 5138: instanceof net/minecraft/world/entity/LivingEntity
      // 513b: ifeq 5150
      // 513e: aload 9
      // 5140: checkcast net/minecraft/world/entity/LivingEntity
      // 5143: astore 57
      // 5145: aload 57
      // 5147: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 514a: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 514d: goto 5153
      // 5150: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5153: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5156: getstatic net/arphex/init/ArphexModItems.SPACETIME_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 5159: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 515c: if_acmpne 51da
      // 515f: aload 9
      // 5161: instanceof net/minecraft/world/entity/LivingEntity
      // 5164: ifeq 5179
      // 5167: aload 9
      // 5169: checkcast net/minecraft/world/entity/LivingEntity
      // 516c: astore 58
      // 516e: aload 58
      // 5170: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 5173: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5176: goto 517c
      // 5179: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 517c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 517f: getstatic net/arphex/init/ArphexModItems.SPACETIME_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 5182: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5185: if_acmpne 51da
      // 5188: aload 9
      // 518a: instanceof net/minecraft/world/entity/LivingEntity
      // 518d: ifeq 51a2
      // 5190: aload 9
      // 5192: checkcast net/minecraft/world/entity/LivingEntity
      // 5195: astore 59
      // 5197: aload 59
      // 5199: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 519c: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 519f: goto 51a5
      // 51a2: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 51a5: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 51a8: getstatic net/arphex/init/ArphexModItems.SPACETIME_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 51ab: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 51ae: if_acmpne 51da
      // 51b1: aload 9
      // 51b3: instanceof net/minecraft/world/entity/LivingEntity
      // 51b6: ifeq 51cb
      // 51b9: aload 9
      // 51bb: checkcast net/minecraft/world/entity/LivingEntity
      // 51be: astore 60
      // 51c0: aload 60
      // 51c2: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 51c5: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 51c8: goto 51ce
      // 51cb: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 51ce: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 51d1: getstatic net/arphex/init/ArphexModItems.SPACETIME_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 51d4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 51d7: if_acmpeq 522c
      // 51da: aload 9
      // 51dc: instanceof net/minecraft/world/entity/LivingEntity
      // 51df: ifeq 51f4
      // 51e2: aload 9
      // 51e4: checkcast net/minecraft/world/entity/LivingEntity
      // 51e7: astore 61
      // 51e9: aload 61
      // 51eb: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 51ee: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 51f1: goto 51f7
      // 51f4: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 51f7: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 51fa: getstatic net/arphex/init/ArphexModItems.ETERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 51fd: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5200: if_acmpeq 522c
      // 5203: aload 9
      // 5205: instanceof net/minecraft/world/entity/LivingEntity
      // 5208: ifeq 521d
      // 520b: aload 9
      // 520d: checkcast net/minecraft/world/entity/LivingEntity
      // 5210: astore 62
      // 5212: aload 62
      // 5214: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 5217: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 521a: goto 5220
      // 521d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5220: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5223: getstatic net/arphex/init/ArphexModItems.IMMORTAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 5226: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5229: if_acmpne 5487
      // 522c: dload 12
      // 522e: dconst_1
      // 522f: dcmpg
      // 5230: ifgt 52d7
      // 5233: aload 11
      // 5235: instanceof net/minecraft/world/entity/LivingEntity
      // 5238: ifeq 5262
      // 523b: aload 11
      // 523d: checkcast net/minecraft/world/entity/LivingEntity
      // 5240: astore 63
      // 5242: aload 63
      // 5244: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5247: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 524a: ifne 5262
      // 524d: aload 63
      // 524f: new net/minecraft/world/effect/MobEffectInstance
      // 5252: dup
      // 5253: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 5256: bipush 10
      // 5258: bipush 1
      // 5259: bipush 0
      // 525a: bipush 0
      // 525b: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 525e: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5261: pop
      // 5262: aload 1
      // 5263: instanceof net/minecraft/world/level/Level
      // 5266: ifeq 52c7
      // 5269: aload 1
      // 526a: checkcast net/minecraft/world/level/Level
      // 526d: astore 63
      // 526f: aload 63
      // 5271: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5274: ifne 52a2
      // 5277: aload 63
      // 5279: aconst_null
      // 527a: dload 2
      // 527b: dload 4
      // 527d: dload 6
      // 527f: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 5282: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 5285: new net/minecraft/resources/ResourceLocation
      // 5288: dup
      // 5289: ldc_w "item.shield.block"
      // 528c: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 528f: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 5294: checkcast net/minecraft/sounds/SoundEvent
      // 5297: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 529a: fconst_1
      // 529b: fconst_1
      // 529c: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 529f: goto 52c7
      // 52a2: aload 63
      // 52a4: dload 2
      // 52a5: dload 4
      // 52a7: dload 6
      // 52a9: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 52ac: new net/minecraft/resources/ResourceLocation
      // 52af: dup
      // 52b0: ldc_w "item.shield.block"
      // 52b3: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 52b6: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 52bb: checkcast net/minecraft/sounds/SoundEvent
      // 52be: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 52c1: fconst_1
      // 52c2: fconst_1
      // 52c3: bipush 0
      // 52c4: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 52c7: aload 0
      // 52c8: ifnull 52d7
      // 52cb: aload 0
      // 52cc: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 52cf: ifeq 52d7
      // 52d2: aload 0
      // 52d3: bipush 1
      // 52d4: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 52d7: dload 12
      // 52d9: ldc2_w 5.0
      // 52dc: dcmpg
      // 52dd: ifgt 53ad
      // 52e0: aload 9
      // 52e2: instanceof net/minecraft/world/entity/LivingEntity
      // 52e5: ifeq 52fa
      // 52e8: aload 9
      // 52ea: checkcast net/minecraft/world/entity/LivingEntity
      // 52ed: astore 63
      // 52ef: aload 63
      // 52f1: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 52f4: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 52f7: goto 52fd
      // 52fa: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 52fd: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5300: getstatic net/arphex/init/ArphexModItems.IMMORTAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 5303: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5306: if_acmpne 53ad
      // 5309: aload 11
      // 530b: instanceof net/minecraft/world/entity/LivingEntity
      // 530e: ifeq 5338
      // 5311: aload 11
      // 5313: checkcast net/minecraft/world/entity/LivingEntity
      // 5316: astore 64
      // 5318: aload 64
      // 531a: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 531d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5320: ifne 5338
      // 5323: aload 64
      // 5325: new net/minecraft/world/effect/MobEffectInstance
      // 5328: dup
      // 5329: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 532c: bipush 10
      // 532e: bipush 1
      // 532f: bipush 0
      // 5330: bipush 0
      // 5331: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 5334: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5337: pop
      // 5338: aload 1
      // 5339: instanceof net/minecraft/world/level/Level
      // 533c: ifeq 539d
      // 533f: aload 1
      // 5340: checkcast net/minecraft/world/level/Level
      // 5343: astore 64
      // 5345: aload 64
      // 5347: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 534a: ifne 5378
      // 534d: aload 64
      // 534f: aconst_null
      // 5350: dload 2
      // 5351: dload 4
      // 5353: dload 6
      // 5355: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 5358: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 535b: new net/minecraft/resources/ResourceLocation
      // 535e: dup
      // 535f: ldc_w "item.shield.block"
      // 5362: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 5365: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 536a: checkcast net/minecraft/sounds/SoundEvent
      // 536d: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 5370: fconst_1
      // 5371: fconst_1
      // 5372: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 5375: goto 539d
      // 5378: aload 64
      // 537a: dload 2
      // 537b: dload 4
      // 537d: dload 6
      // 537f: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 5382: new net/minecraft/resources/ResourceLocation
      // 5385: dup
      // 5386: ldc_w "item.shield.block"
      // 5389: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 538c: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 5391: checkcast net/minecraft/sounds/SoundEvent
      // 5394: getstatic net/minecraft/sounds/SoundSource.NEUTRAL Lnet/minecraft/sounds/SoundSource;
      // 5397: fconst_1
      // 5398: fconst_1
      // 5399: bipush 0
      // 539a: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 539d: aload 0
      // 539e: ifnull 53ad
      // 53a1: aload 0
      // 53a2: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 53a5: ifeq 53ad
      // 53a8: aload 0
      // 53a9: bipush 1
      // 53aa: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 53ad: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 53b0: bipush 1
      // 53b1: bipush 2
      // 53b2: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 53b5: bipush 2
      // 53b6: if_icmpne 53f0
      // 53b9: aload 11
      // 53bb: bipush 3
      // 53bc: invokevirtual net/minecraft/world/entity/Entity.setSecondsOnFire (I)V
      // 53bf: aload 1
      // 53c0: instanceof net/minecraft/server/level/ServerLevel
      // 53c3: ifeq 53ed
      // 53c6: aload 1
      // 53c7: checkcast net/minecraft/server/level/ServerLevel
      // 53ca: astore 63
      // 53cc: aload 63
      // 53ce: getstatic net/arphex/init/ArphexModParticleTypes.FIRE_OPAL_SHARDS Lnet/minecraftforge/registries/RegistryObject;
      // 53d1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 53d4: checkcast net/minecraft/core/particles/SimpleParticleType
      // 53d7: dload 2
      // 53d8: dload 4
      // 53da: dload 6
      // 53dc: bipush 5
      // 53dd: ldc2_w 0.3
      // 53e0: ldc2_w 0.3
      // 53e3: ldc2_w 0.3
      // 53e6: ldc2_w 0.3
      // 53e9: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 53ec: pop
      // 53ed: goto 544b
      // 53f0: aload 11
      // 53f2: instanceof net/minecraft/world/entity/LivingEntity
      // 53f5: ifeq 541d
      // 53f8: aload 11
      // 53fa: checkcast net/minecraft/world/entity/LivingEntity
      // 53fd: astore 63
      // 53ff: aload 63
      // 5401: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5404: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5407: ifne 541d
      // 540a: aload 63
      // 540c: new net/minecraft/world/effect/MobEffectInstance
      // 540f: dup
      // 5410: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 5413: bipush 30
      // 5415: bipush 1
      // 5416: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 5419: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 541c: pop
      // 541d: aload 1
      // 541e: instanceof net/minecraft/server/level/ServerLevel
      // 5421: ifeq 544b
      // 5424: aload 1
      // 5425: checkcast net/minecraft/server/level/ServerLevel
      // 5428: astore 63
      // 542a: aload 63
      // 542c: getstatic net/arphex/init/ArphexModParticleTypes.ABYSSAL_CRYSTAL_PARTICLE Lnet/minecraftforge/registries/RegistryObject;
      // 542f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5432: checkcast net/minecraft/core/particles/SimpleParticleType
      // 5435: dload 2
      // 5436: dload 4
      // 5438: dload 6
      // 543a: bipush 5
      // 543b: ldc2_w 0.3
      // 543e: ldc2_w 0.3
      // 5441: ldc2_w 0.3
      // 5444: ldc2_w 0.3
      // 5447: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 544a: pop
      // 544b: aload 11
      // 544d: new net/minecraft/world/phys/Vec3
      // 5450: dup
      // 5451: aload 11
      // 5453: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 5456: ldc_w 90.0
      // 5459: fsub
      // 545a: f2d
      // 545b: ldc2_w 0.017453292519943295
      // 545e: dmul
      // 545f: invokestatic java/lang/Math.cos (D)D
      // 5462: ldc2_w 2.0
      // 5465: ddiv
      // 5466: ldc2_w 0.6
      // 5469: aload 11
      // 546b: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 546e: ldc_w 90.0
      // 5471: fsub
      // 5472: f2d
      // 5473: ldc2_w 0.017453292519943295
      // 5476: dmul
      // 5477: invokestatic java/lang/Math.sin (D)D
      // 547a: ldc2_w 2.0
      // 547d: ddiv
      // 547e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5481: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 5484: goto 59b4
      // 5487: aload 9
      // 5489: instanceof net/minecraft/world/entity/LivingEntity
      // 548c: ifeq 54a1
      // 548f: aload 9
      // 5491: checkcast net/minecraft/world/entity/LivingEntity
      // 5494: astore 63
      // 5496: aload 63
      // 5498: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 549b: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 549e: goto 54a4
      // 54a1: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 54a4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 54a7: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 54aa: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 54ad: if_acmpne 5502
      // 54b0: aload 9
      // 54b2: instanceof net/minecraft/world/entity/LivingEntity
      // 54b5: ifeq 54ca
      // 54b8: aload 9
      // 54ba: checkcast net/minecraft/world/entity/LivingEntity
      // 54bd: astore 64
      // 54bf: aload 64
      // 54c1: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 54c4: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 54c7: goto 54cd
      // 54ca: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 54cd: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 54d0: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 54d3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 54d6: if_acmpne 5502
      // 54d9: aload 9
      // 54db: instanceof net/minecraft/world/entity/LivingEntity
      // 54de: ifeq 54f3
      // 54e1: aload 9
      // 54e3: checkcast net/minecraft/world/entity/LivingEntity
      // 54e6: astore 65
      // 54e8: aload 65
      // 54ea: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 54ed: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 54f0: goto 54f6
      // 54f3: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 54f6: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 54f9: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 54fc: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 54ff: if_acmpeq 5673
      // 5502: aload 9
      // 5504: instanceof net/minecraft/world/entity/LivingEntity
      // 5507: ifeq 551c
      // 550a: aload 9
      // 550c: checkcast net/minecraft/world/entity/LivingEntity
      // 550f: astore 66
      // 5511: aload 66
      // 5513: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 5516: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5519: goto 551f
      // 551c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 551f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5522: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 5525: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5528: if_acmpne 557d
      // 552b: aload 9
      // 552d: instanceof net/minecraft/world/entity/LivingEntity
      // 5530: ifeq 5545
      // 5533: aload 9
      // 5535: checkcast net/minecraft/world/entity/LivingEntity
      // 5538: astore 67
      // 553a: aload 67
      // 553c: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 553f: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5542: goto 5548
      // 5545: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5548: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 554b: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 554e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5551: if_acmpne 557d
      // 5554: aload 9
      // 5556: instanceof net/minecraft/world/entity/LivingEntity
      // 5559: ifeq 556e
      // 555c: aload 9
      // 555e: checkcast net/minecraft/world/entity/LivingEntity
      // 5561: astore 68
      // 5563: aload 68
      // 5565: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 5568: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 556b: goto 5571
      // 556e: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5571: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5574: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 5577: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 557a: if_acmpeq 5673
      // 557d: aload 9
      // 557f: instanceof net/minecraft/world/entity/LivingEntity
      // 5582: ifeq 5597
      // 5585: aload 9
      // 5587: checkcast net/minecraft/world/entity/LivingEntity
      // 558a: astore 69
      // 558c: aload 69
      // 558e: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 5591: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5594: goto 559a
      // 5597: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 559a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 559d: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 55a0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 55a3: if_acmpne 55f8
      // 55a6: aload 9
      // 55a8: instanceof net/minecraft/world/entity/LivingEntity
      // 55ab: ifeq 55c0
      // 55ae: aload 9
      // 55b0: checkcast net/minecraft/world/entity/LivingEntity
      // 55b3: astore 70
      // 55b5: aload 70
      // 55b7: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 55ba: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 55bd: goto 55c3
      // 55c0: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 55c3: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 55c6: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 55c9: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 55cc: if_acmpne 55f8
      // 55cf: aload 9
      // 55d1: instanceof net/minecraft/world/entity/LivingEntity
      // 55d4: ifeq 55e9
      // 55d7: aload 9
      // 55d9: checkcast net/minecraft/world/entity/LivingEntity
      // 55dc: astore 71
      // 55de: aload 71
      // 55e0: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 55e3: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 55e6: goto 55ec
      // 55e9: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 55ec: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 55ef: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 55f2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 55f5: if_acmpeq 5673
      // 55f8: aload 9
      // 55fa: instanceof net/minecraft/world/entity/LivingEntity
      // 55fd: ifeq 5612
      // 5600: aload 9
      // 5602: checkcast net/minecraft/world/entity/LivingEntity
      // 5605: astore 72
      // 5607: aload 72
      // 5609: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 560c: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 560f: goto 5615
      // 5612: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5615: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5618: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 561b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 561e: if_acmpne 56af
      // 5621: aload 9
      // 5623: instanceof net/minecraft/world/entity/LivingEntity
      // 5626: ifeq 563b
      // 5629: aload 9
      // 562b: checkcast net/minecraft/world/entity/LivingEntity
      // 562e: astore 73
      // 5630: aload 73
      // 5632: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 5635: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5638: goto 563e
      // 563b: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 563e: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5641: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 5644: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5647: if_acmpne 56af
      // 564a: aload 9
      // 564c: instanceof net/minecraft/world/entity/LivingEntity
      // 564f: ifeq 5664
      // 5652: aload 9
      // 5654: checkcast net/minecraft/world/entity/LivingEntity
      // 5657: astore 74
      // 5659: aload 74
      // 565b: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 565e: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5661: goto 5667
      // 5664: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5667: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 566a: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 566d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5670: if_acmpne 56af
      // 5673: aload 11
      // 5675: new net/minecraft/world/phys/Vec3
      // 5678: dup
      // 5679: aload 11
      // 567b: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 567e: ldc_w 90.0
      // 5681: fsub
      // 5682: f2d
      // 5683: ldc2_w 0.017453292519943295
      // 5686: dmul
      // 5687: invokestatic java/lang/Math.cos (D)D
      // 568a: ldc2_w 4.0
      // 568d: ddiv
      // 568e: ldc2_w 0.6
      // 5691: aload 11
      // 5693: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 5696: ldc_w 90.0
      // 5699: fsub
      // 569a: f2d
      // 569b: ldc2_w 0.017453292519943295
      // 569e: dmul
      // 569f: invokestatic java/lang/Math.sin (D)D
      // 56a2: ldc2_w 4.0
      // 56a5: ddiv
      // 56a6: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 56a9: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 56ac: goto 59b4
      // 56af: aload 9
      // 56b1: instanceof net/minecraft/world/entity/LivingEntity
      // 56b4: ifeq 56c9
      // 56b7: aload 9
      // 56b9: checkcast net/minecraft/world/entity/LivingEntity
      // 56bc: astore 75
      // 56be: aload 75
      // 56c0: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 56c3: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 56c6: goto 56cc
      // 56c9: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 56cc: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 56cf: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 56d2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 56d5: if_acmpne 5701
      // 56d8: aload 9
      // 56da: instanceof net/minecraft/world/entity/LivingEntity
      // 56dd: ifeq 56f2
      // 56e0: aload 9
      // 56e2: checkcast net/minecraft/world/entity/LivingEntity
      // 56e5: astore 76
      // 56e7: aload 76
      // 56e9: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 56ec: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 56ef: goto 56f5
      // 56f2: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 56f5: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 56f8: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 56fb: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 56fe: if_acmpeq 589b
      // 5701: aload 9
      // 5703: instanceof net/minecraft/world/entity/LivingEntity
      // 5706: ifeq 571b
      // 5709: aload 9
      // 570b: checkcast net/minecraft/world/entity/LivingEntity
      // 570e: astore 77
      // 5710: aload 77
      // 5712: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 5715: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5718: goto 571e
      // 571b: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 571e: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5721: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 5724: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5727: if_acmpne 5753
      // 572a: aload 9
      // 572c: instanceof net/minecraft/world/entity/LivingEntity
      // 572f: ifeq 5744
      // 5732: aload 9
      // 5734: checkcast net/minecraft/world/entity/LivingEntity
      // 5737: astore 78
      // 5739: aload 78
      // 573b: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 573e: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5741: goto 5747
      // 5744: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5747: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 574a: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 574d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5750: if_acmpeq 589b
      // 5753: aload 9
      // 5755: instanceof net/minecraft/world/entity/LivingEntity
      // 5758: ifeq 576d
      // 575b: aload 9
      // 575d: checkcast net/minecraft/world/entity/LivingEntity
      // 5760: astore 79
      // 5762: aload 79
      // 5764: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 5767: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 576a: goto 5770
      // 576d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5770: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5773: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 5776: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5779: if_acmpne 57a5
      // 577c: aload 9
      // 577e: instanceof net/minecraft/world/entity/LivingEntity
      // 5781: ifeq 5796
      // 5784: aload 9
      // 5786: checkcast net/minecraft/world/entity/LivingEntity
      // 5789: astore 80
      // 578b: aload 80
      // 578d: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 5790: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5793: goto 5799
      // 5796: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5799: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 579c: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 579f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 57a2: if_acmpeq 589b
      // 57a5: aload 9
      // 57a7: instanceof net/minecraft/world/entity/LivingEntity
      // 57aa: ifeq 57bf
      // 57ad: aload 9
      // 57af: checkcast net/minecraft/world/entity/LivingEntity
      // 57b2: astore 81
      // 57b4: aload 81
      // 57b6: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 57b9: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 57bc: goto 57c2
      // 57bf: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 57c2: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 57c5: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 57c8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 57cb: if_acmpne 57f7
      // 57ce: aload 9
      // 57d0: instanceof net/minecraft/world/entity/LivingEntity
      // 57d3: ifeq 57e8
      // 57d6: aload 9
      // 57d8: checkcast net/minecraft/world/entity/LivingEntity
      // 57db: astore 82
      // 57dd: aload 82
      // 57df: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 57e2: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 57e5: goto 57eb
      // 57e8: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 57eb: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 57ee: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 57f1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 57f4: if_acmpeq 589b
      // 57f7: aload 9
      // 57f9: instanceof net/minecraft/world/entity/LivingEntity
      // 57fc: ifeq 5811
      // 57ff: aload 9
      // 5801: checkcast net/minecraft/world/entity/LivingEntity
      // 5804: astore 83
      // 5806: aload 83
      // 5808: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 580b: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 580e: goto 5814
      // 5811: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5814: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5817: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 581a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 581d: if_acmpne 5849
      // 5820: aload 9
      // 5822: instanceof net/minecraft/world/entity/LivingEntity
      // 5825: ifeq 583a
      // 5828: aload 9
      // 582a: checkcast net/minecraft/world/entity/LivingEntity
      // 582d: astore 84
      // 582f: aload 84
      // 5831: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 5834: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5837: goto 583d
      // 583a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 583d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5840: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 5843: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5846: if_acmpeq 589b
      // 5849: aload 9
      // 584b: instanceof net/minecraft/world/entity/LivingEntity
      // 584e: ifeq 5863
      // 5851: aload 9
      // 5853: checkcast net/minecraft/world/entity/LivingEntity
      // 5856: astore 85
      // 5858: aload 85
      // 585a: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 585d: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5860: goto 5866
      // 5863: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5866: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5869: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 586c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 586f: if_acmpne 58d7
      // 5872: aload 9
      // 5874: instanceof net/minecraft/world/entity/LivingEntity
      // 5877: ifeq 588c
      // 587a: aload 9
      // 587c: checkcast net/minecraft/world/entity/LivingEntity
      // 587f: astore 86
      // 5881: aload 86
      // 5883: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 5886: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5889: goto 588f
      // 588c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 588f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5892: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 5895: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5898: if_acmpne 58d7
      // 589b: aload 11
      // 589d: new net/minecraft/world/phys/Vec3
      // 58a0: dup
      // 58a1: aload 11
      // 58a3: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 58a6: ldc_w 90.0
      // 58a9: fsub
      // 58aa: f2d
      // 58ab: ldc2_w 0.017453292519943295
      // 58ae: dmul
      // 58af: invokestatic java/lang/Math.cos (D)D
      // 58b2: ldc2_w 6.0
      // 58b5: ddiv
      // 58b6: ldc2_w 0.6
      // 58b9: aload 11
      // 58bb: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 58be: ldc_w 90.0
      // 58c1: fsub
      // 58c2: f2d
      // 58c3: ldc2_w 0.017453292519943295
      // 58c6: dmul
      // 58c7: invokestatic java/lang/Math.sin (D)D
      // 58ca: ldc2_w 6.0
      // 58cd: ddiv
      // 58ce: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 58d1: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 58d4: goto 59b4
      // 58d7: aload 9
      // 58d9: instanceof net/minecraft/world/entity/LivingEntity
      // 58dc: ifeq 58f1
      // 58df: aload 9
      // 58e1: checkcast net/minecraft/world/entity/LivingEntity
      // 58e4: astore 87
      // 58e6: aload 87
      // 58e8: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 58eb: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 58ee: goto 58f4
      // 58f1: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 58f4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 58f7: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 58fa: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 58fd: if_acmpeq 597b
      // 5900: aload 9
      // 5902: instanceof net/minecraft/world/entity/LivingEntity
      // 5905: ifeq 591a
      // 5908: aload 9
      // 590a: checkcast net/minecraft/world/entity/LivingEntity
      // 590d: astore 88
      // 590f: aload 88
      // 5911: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 5914: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5917: goto 591d
      // 591a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 591d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5920: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 5923: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5926: if_acmpeq 597b
      // 5929: aload 9
      // 592b: instanceof net/minecraft/world/entity/LivingEntity
      // 592e: ifeq 5943
      // 5931: aload 9
      // 5933: checkcast net/minecraft/world/entity/LivingEntity
      // 5936: astore 89
      // 5938: aload 89
      // 593a: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 593d: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5940: goto 5946
      // 5943: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5946: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5949: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 594c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 594f: if_acmpeq 597b
      // 5952: aload 9
      // 5954: instanceof net/minecraft/world/entity/LivingEntity
      // 5957: ifeq 596c
      // 595a: aload 9
      // 595c: checkcast net/minecraft/world/entity/LivingEntity
      // 595f: astore 90
      // 5961: aload 90
      // 5963: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 5966: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 5969: goto 596f
      // 596c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 596f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5972: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 5975: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5978: if_acmpne 59b4
      // 597b: aload 11
      // 597d: new net/minecraft/world/phys/Vec3
      // 5980: dup
      // 5981: aload 11
      // 5983: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 5986: ldc_w 90.0
      // 5989: fsub
      // 598a: f2d
      // 598b: ldc2_w 0.017453292519943295
      // 598e: dmul
      // 598f: invokestatic java/lang/Math.cos (D)D
      // 5992: ldc2_w 8.0
      // 5995: ddiv
      // 5996: ldc2_w 0.6
      // 5999: aload 11
      // 599b: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 599e: ldc_w 90.0
      // 59a1: fsub
      // 59a2: f2d
      // 59a3: ldc2_w 0.017453292519943295
      // 59a6: dmul
      // 59a7: invokestatic java/lang/Math.sin (D)D
      // 59aa: ldc2_w 8.0
      // 59ad: ddiv
      // 59ae: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 59b1: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 59b4: aload 11
      // 59b6: instanceof net/minecraft/world/entity/player/Player
      // 59b9: ifeq 59eb
      // 59bc: aload 11
      // 59be: checkcast net/minecraft/world/entity/player/Player
      // 59c1: astore 45
      // 59c3: aload 45
      // 59c5: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 59c8: aload 11
      // 59ca: instanceof net/minecraft/world/entity/LivingEntity
      // 59cd: ifeq 59df
      // 59d0: aload 11
      // 59d2: checkcast net/minecraft/world/entity/LivingEntity
      // 59d5: astore 46
      // 59d7: aload 46
      // 59d9: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 59dc: goto 59e2
      // 59df: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 59e2: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 59e5: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 59e8: ifne 5bee
      // 59eb: aload 11
      // 59ed: instanceof net/minecraft/world/entity/LivingEntity
      // 59f0: ifeq 5a02
      // 59f3: aload 11
      // 59f5: checkcast net/minecraft/world/entity/LivingEntity
      // 59f8: astore 47
      // 59fa: aload 47
      // 59fc: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 59ff: goto 5a05
      // 5a02: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5a05: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5a08: getstatic net/arphex/init/ArphexModItems.INFERNAL_SHARD Lnet/minecraftforge/registries/RegistryObject;
      // 5a0b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5a0e: if_acmpne 5a7c
      // 5a11: aload 11
      // 5a13: instanceof net/minecraft/world/entity/player/Player
      // 5a16: ifeq 5a47
      // 5a19: aload 11
      // 5a1b: checkcast net/minecraft/world/entity/player/Player
      // 5a1e: astore 48
      // 5a20: aload 48
      // 5a22: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 5a25: aload 11
      // 5a27: instanceof net/minecraft/world/entity/LivingEntity
      // 5a2a: ifeq 5a3c
      // 5a2d: aload 11
      // 5a2f: checkcast net/minecraft/world/entity/LivingEntity
      // 5a32: astore 49
      // 5a34: aload 49
      // 5a36: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 5a39: goto 5a3f
      // 5a3c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5a3f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5a42: bipush 60
      // 5a44: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 5a47: aload 9
      // 5a49: bipush 10
      // 5a4b: invokevirtual net/minecraft/world/entity/Entity.setSecondsOnFire (I)V
      // 5a4e: aload 1
      // 5a4f: instanceof net/minecraft/server/level/ServerLevel
      // 5a52: ifeq 5a7c
      // 5a55: aload 1
      // 5a56: checkcast net/minecraft/server/level/ServerLevel
      // 5a59: astore 48
      // 5a5b: aload 48
      // 5a5d: getstatic net/arphex/init/ArphexModParticleTypes.FIRE_OPAL_SHARDS Lnet/minecraftforge/registries/RegistryObject;
      // 5a60: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5a63: checkcast net/minecraft/core/particles/SimpleParticleType
      // 5a66: dload 2
      // 5a67: dload 4
      // 5a69: dload 6
      // 5a6b: bipush 5
      // 5a6c: ldc2_w 0.3
      // 5a6f: ldc2_w 0.3
      // 5a72: ldc2_w 0.3
      // 5a75: ldc2_w 0.3
      // 5a78: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 5a7b: pop
      // 5a7c: aload 11
      // 5a7e: instanceof net/minecraft/world/entity/LivingEntity
      // 5a81: ifeq 5a93
      // 5a84: aload 11
      // 5a86: checkcast net/minecraft/world/entity/LivingEntity
      // 5a89: astore 47
      // 5a8b: aload 47
      // 5a8d: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 5a90: goto 5a96
      // 5a93: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5a96: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5a99: getstatic net/arphex/init/ArphexModItems.UMBRAL_SHARD Lnet/minecraftforge/registries/RegistryObject;
      // 5a9c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5a9f: if_acmpne 5b35
      // 5aa2: aload 11
      // 5aa4: instanceof net/minecraft/world/entity/player/Player
      // 5aa7: ifeq 5ad8
      // 5aaa: aload 11
      // 5aac: checkcast net/minecraft/world/entity/player/Player
      // 5aaf: astore 48
      // 5ab1: aload 48
      // 5ab3: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 5ab6: aload 11
      // 5ab8: instanceof net/minecraft/world/entity/LivingEntity
      // 5abb: ifeq 5acd
      // 5abe: aload 11
      // 5ac0: checkcast net/minecraft/world/entity/LivingEntity
      // 5ac3: astore 49
      // 5ac5: aload 49
      // 5ac7: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 5aca: goto 5ad0
      // 5acd: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5ad0: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5ad3: bipush 60
      // 5ad5: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 5ad8: aload 9
      // 5ada: instanceof net/minecraft/world/entity/LivingEntity
      // 5add: ifeq 5b07
      // 5ae0: aload 9
      // 5ae2: checkcast net/minecraft/world/entity/LivingEntity
      // 5ae5: astore 48
      // 5ae7: aload 48
      // 5ae9: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5aec: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5aef: ifne 5b07
      // 5af2: aload 48
      // 5af4: new net/minecraft/world/effect/MobEffectInstance
      // 5af7: dup
      // 5af8: getstatic net/minecraft/world/effect/MobEffects.LEVITATION Lnet/minecraft/world/effect/MobEffect;
      // 5afb: bipush 100
      // 5afd: bipush 0
      // 5afe: bipush 0
      // 5aff: bipush 0
      // 5b00: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 5b03: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5b06: pop
      // 5b07: aload 1
      // 5b08: instanceof net/minecraft/server/level/ServerLevel
      // 5b0b: ifeq 5b35
      // 5b0e: aload 1
      // 5b0f: checkcast net/minecraft/server/level/ServerLevel
      // 5b12: astore 48
      // 5b14: aload 48
      // 5b16: getstatic net/arphex/init/ArphexModParticleTypes.GEODE_POWER Lnet/minecraftforge/registries/RegistryObject;
      // 5b19: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5b1c: checkcast net/minecraft/core/particles/SimpleParticleType
      // 5b1f: dload 2
      // 5b20: dload 4
      // 5b22: dload 6
      // 5b24: bipush 5
      // 5b25: ldc2_w 0.3
      // 5b28: ldc2_w 0.3
      // 5b2b: ldc2_w 0.3
      // 5b2e: ldc2_w 0.3
      // 5b31: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 5b34: pop
      // 5b35: aload 11
      // 5b37: instanceof net/minecraft/world/entity/LivingEntity
      // 5b3a: ifeq 5b4c
      // 5b3d: aload 11
      // 5b3f: checkcast net/minecraft/world/entity/LivingEntity
      // 5b42: astore 47
      // 5b44: aload 47
      // 5b46: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 5b49: goto 5b4f
      // 5b4c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5b4f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5b52: getstatic net/arphex/init/ArphexModItems.SPECTRAL_SHARD Lnet/minecraftforge/registries/RegistryObject;
      // 5b55: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5b58: if_acmpne 5bee
      // 5b5b: aload 11
      // 5b5d: instanceof net/minecraft/world/entity/player/Player
      // 5b60: ifeq 5b91
      // 5b63: aload 11
      // 5b65: checkcast net/minecraft/world/entity/player/Player
      // 5b68: astore 48
      // 5b6a: aload 48
      // 5b6c: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 5b6f: aload 11
      // 5b71: instanceof net/minecraft/world/entity/LivingEntity
      // 5b74: ifeq 5b86
      // 5b77: aload 11
      // 5b79: checkcast net/minecraft/world/entity/LivingEntity
      // 5b7c: astore 49
      // 5b7e: aload 49
      // 5b80: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 5b83: goto 5b89
      // 5b86: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 5b89: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 5b8c: bipush 60
      // 5b8e: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 5b91: aload 9
      // 5b93: instanceof net/minecraft/world/entity/LivingEntity
      // 5b96: ifeq 5bc0
      // 5b99: aload 9
      // 5b9b: checkcast net/minecraft/world/entity/LivingEntity
      // 5b9e: astore 48
      // 5ba0: aload 48
      // 5ba2: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5ba5: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5ba8: ifne 5bc0
      // 5bab: aload 48
      // 5bad: new net/minecraft/world/effect/MobEffectInstance
      // 5bb0: dup
      // 5bb1: getstatic net/minecraft/world/effect/MobEffects.WEAKNESS Lnet/minecraft/world/effect/MobEffect;
      // 5bb4: bipush 100
      // 5bb6: bipush 0
      // 5bb7: bipush 0
      // 5bb8: bipush 0
      // 5bb9: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 5bbc: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5bbf: pop
      // 5bc0: aload 1
      // 5bc1: instanceof net/minecraft/server/level/ServerLevel
      // 5bc4: ifeq 5bee
      // 5bc7: aload 1
      // 5bc8: checkcast net/minecraft/server/level/ServerLevel
      // 5bcb: astore 48
      // 5bcd: aload 48
      // 5bcf: getstatic net/arphex/init/ArphexModParticleTypes.GEODE_POWER Lnet/minecraftforge/registries/RegistryObject;
      // 5bd2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5bd5: checkcast net/minecraft/core/particles/SimpleParticleType
      // 5bd8: dload 2
      // 5bd9: dload 4
      // 5bdb: dload 6
      // 5bdd: bipush 5
      // 5bde: ldc2_w 0.3
      // 5be1: ldc2_w 0.3
      // 5be4: ldc2_w 0.3
      // 5be7: ldc2_w 0.3
      // 5bea: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 5bed: pop
      // 5bee: aload 11
      // 5bf0: instanceof net/arphex/entity/SpiderProwlerEntity
      // 5bf3: ifeq 5c57
      // 5bf6: aload 9
      // 5bf8: instanceof net/minecraft/world/entity/LivingEntity
      // 5bfb: ifeq 5c2a
      // 5bfe: aload 9
      // 5c00: checkcast net/minecraft/world/entity/LivingEntity
      // 5c03: astore 45
      // 5c05: aload 45
      // 5c07: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5c0a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5c0d: ifne 5c2a
      // 5c10: aload 45
      // 5c12: new net/minecraft/world/effect/MobEffectInstance
      // 5c15: dup
      // 5c16: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 5c19: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5c1c: checkcast net/minecraft/world/effect/MobEffect
      // 5c1f: sipush 600
      // 5c22: bipush 1
      // 5c23: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 5c26: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5c29: pop
      // 5c2a: aload 9
      // 5c2c: instanceof net/minecraft/world/entity/LivingEntity
      // 5c2f: ifeq 5c57
      // 5c32: aload 9
      // 5c34: checkcast net/minecraft/world/entity/LivingEntity
      // 5c37: astore 45
      // 5c39: aload 45
      // 5c3b: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5c3e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5c41: ifne 5c57
      // 5c44: aload 45
      // 5c46: new net/minecraft/world/effect/MobEffectInstance
      // 5c49: dup
      // 5c4a: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 5c4d: bipush 40
      // 5c4f: bipush 2
      // 5c50: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 5c53: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5c56: pop
      // 5c57: aload 9
      // 5c59: instanceof net/arphex/entity/FlyFestererEntity
      // 5c5c: ifeq 5cc5
      // 5c5f: aload 9
      // 5c61: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5c64: ldc_w "immunelimitfly"
      // 5c67: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5c6a: dconst_0
      // 5c6b: dcmpl
      // 5c6c: ifle 5cc5
      // 5c6f: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5c72: bipush 1
      // 5c73: bipush 2
      // 5c74: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5c77: bipush 2
      // 5c78: if_icmpne 5cc5
      // 5c7b: aload 9
      // 5c7d: new net/minecraft/world/phys/Vec3
      // 5c80: dup
      // 5c81: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5c84: bipush -2
      // 5c86: bipush 2
      // 5c87: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5c8a: i2d
      // 5c8b: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5c8e: ldc2_w -0.6
      // 5c91: ldc2_w 0.6
      // 5c94: invokestatic net/minecraft/util/Mth.nextDouble (Lnet/minecraft/util/RandomSource;DD)D
      // 5c97: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5c9a: bipush -2
      // 5c9c: bipush 2
      // 5c9d: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5ca0: i2d
      // 5ca1: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5ca4: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 5ca7: aload 0
      // 5ca8: ifnull 5cb7
      // 5cab: aload 0
      // 5cac: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 5caf: ifeq 5cb7
      // 5cb2: aload 0
      // 5cb3: bipush 1
      // 5cb4: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 5cb7: aload 9
      // 5cb9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5cbc: ldc_w "immunelimitfly"
      // 5cbf: ldc2_w 50.0
      // 5cc2: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5cc5: aload 9
      // 5cc7: instanceof net/arphex/entity/ScorpioidShadowCloneEntity
      // 5cca: ifeq 5cdd
      // 5ccd: aload 9
      // 5ccf: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 5cd2: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5cd5: ifne 5cdd
      // 5cd8: aload 9
      // 5cda: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 5cdd: aload 9
      // 5cdf: instanceof net/arphex/entity/SpiderGoliathEntity
      // 5ce2: ifne 5ced
      // 5ce5: aload 9
      // 5ce7: instanceof net/arphex/entity/SpiderFunnelEntity
      // 5cea: ifeq 5d23
      // 5ced: aload 9
      // 5cef: instanceof net/minecraft/world/entity/LivingEntity
      // 5cf2: ifeq 5d23
      // 5cf5: aload 9
      // 5cf7: checkcast net/minecraft/world/entity/LivingEntity
      // 5cfa: astore 45
      // 5cfc: aload 45
      // 5cfe: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5d01: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5d04: ifne 5d23
      // 5d07: aload 45
      // 5d09: new net/minecraft/world/effect/MobEffectInstance
      // 5d0c: dup
      // 5d0d: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 5d10: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5d13: checkcast net/minecraft/world/effect/MobEffect
      // 5d16: sipush 1200
      // 5d19: bipush 0
      // 5d1a: bipush 0
      // 5d1b: bipush 0
      // 5d1c: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 5d1f: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5d22: pop
      // 5d23: aload 9
      // 5d25: instanceof net/arphex/entity/MothMoontrackerEntity
      // 5d28: ifne 5d4b
      // 5d2b: aload 9
      // 5d2d: instanceof net/arphex/entity/FlyFestererEntity
      // 5d30: ifne 5d4b
      // 5d33: aload 9
      // 5d35: instanceof net/arphex/entity/ButterflyBewitcherEntity
      // 5d38: ifne 5d4b
      // 5d3b: aload 9
      // 5d3d: instanceof net/arphex/entity/ButterflyBewitcherGiantEntity
      // 5d40: ifne 5d4b
      // 5d43: aload 9
      // 5d45: instanceof net/arphex/entity/LocustLandscourgeEntity
      // 5d48: ifeq 5d78
      // 5d4b: aload 9
      // 5d4d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5d50: ldc_w "flywalk"
      // 5d53: ldc2_w 300.0
      // 5d56: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5d59: aload 9
      // 5d5b: new net/minecraft/world/phys/Vec3
      // 5d5e: dup
      // 5d5f: aload 9
      // 5d61: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 5d64: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 5d67: ldc2_w 0.3
      // 5d6a: aload 9
      // 5d6c: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 5d6f: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 5d72: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5d75: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 5d78: aload 9
      // 5d7a: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 5d7d: ifeq 5edc
      // 5d80: aload 9
      // 5d82: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5d85: ldc_w "tpdodge"
      // 5d88: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5d8b: ldc2_w 5.0
      // 5d8e: dcmpl
      // 5d8f: ifne 5dae
      // 5d92: aload 9
      // 5d94: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5d97: ldc_w "tping"
      // 5d9a: dconst_0
      // 5d9b: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5d9e: aload 0
      // 5d9f: ifnull 5dae
      // 5da2: aload 0
      // 5da3: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 5da6: ifeq 5dae
      // 5da9: aload 0
      // 5daa: bipush 1
      // 5dab: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 5dae: aload 9
      // 5db0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5db3: ldc_w "tpdodge"
      // 5db6: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5db9: dconst_0
      // 5dba: dcmpl
      // 5dbb: ifgt 5dcf
      // 5dbe: aload 9
      // 5dc0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5dc3: ldc_w "tpdodge"
      // 5dc6: ldc2_w 12.0
      // 5dc9: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5dcc: goto 5de7
      // 5dcf: aload 9
      // 5dd1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5dd4: ldc_w "tpdodge"
      // 5dd7: aload 9
      // 5dd9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5ddc: ldc_w "tpdodge"
      // 5ddf: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5de2: dconst_1
      // 5de3: dsub
      // 5de4: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5de7: aload 9
      // 5de9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5dec: ldc_w "primed"
      // 5def: bipush 1
      // 5df0: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 5df3: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5df6: bipush 1
      // 5df7: bipush 5
      // 5df8: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5dfb: bipush 1
      // 5dfc: if_icmpne 5e14
      // 5dff: aload 9
      // 5e01: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5e04: ldc_w "stillattack"
      // 5e07: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5e0a: bipush 3
      // 5e0b: bipush 100
      // 5e0d: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5e10: i2d
      // 5e11: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5e14: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5e17: bipush 1
      // 5e18: bipush 3
      // 5e19: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5e1c: bipush 1
      // 5e1d: if_icmpne 5e35
      // 5e20: aload 9
      // 5e22: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5e25: ldc_w "attackswitch"
      // 5e28: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5e2b: bipush 3
      // 5e2c: bipush 20
      // 5e2e: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5e31: i2d
      // 5e32: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5e35: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5e38: bipush 1
      // 5e39: bipush 7
      // 5e3b: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 5e3e: bipush 1
      // 5e3f: if_icmpne 5e53
      // 5e42: aload 9
      // 5e44: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5e47: ldc_w "tptime"
      // 5e4a: ldc2_w 10.0
      // 5e4d: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5e50: goto 5e61
      // 5e53: aload 9
      // 5e55: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5e58: ldc_w "blasttime"
      // 5e5b: ldc2_w 3.0
      // 5e5e: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5e61: aload 9
      // 5e63: instanceof net/minecraft/world/entity/LivingEntity
      // 5e66: ifeq 5e81
      // 5e69: aload 9
      // 5e6b: checkcast net/minecraft/world/entity/LivingEntity
      // 5e6e: astore 45
      // 5e70: aload 45
      // 5e72: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 5e75: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5e78: checkcast net/minecraft/world/effect/MobEffect
      // 5e7b: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5e7e: ifne 5edc
      // 5e81: aload 9
      // 5e83: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5e86: ldc_w "shockwavecycle"
      // 5e89: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5e8c: dconst_1
      // 5e8d: dcmpl
      // 5e8e: ifeq 5ec3
      // 5e91: aload 9
      // 5e93: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5e96: ldc_w "shockwavecycle"
      // 5e99: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5e9c: ldc2_w 2.0
      // 5e9f: dcmpl
      // 5ea0: ifne 5eb4
      // 5ea3: aload 9
      // 5ea5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5ea8: ldc_w "shockwavecycle"
      // 5eab: ldc2_w 3.0
      // 5eae: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5eb1: goto 5ed1
      // 5eb4: aload 9
      // 5eb6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5eb9: ldc_w "shockwavecycle"
      // 5ebc: dconst_1
      // 5ebd: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5ec0: goto 5ed1
      // 5ec3: aload 9
      // 5ec5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5ec8: ldc_w "shockwavecycle"
      // 5ecb: ldc2_w 2.0
      // 5ece: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5ed1: bipush 1
      // 5ed2: aload 9
      // 5ed4: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$71 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 5ed9: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 5edc: aload 9
      // 5ede: instanceof net/minecraft/world/entity/LivingEntity
      // 5ee1: ifeq 5f0c
      // 5ee4: aload 9
      // 5ee6: checkcast net/minecraft/world/entity/LivingEntity
      // 5ee9: astore 45
      // 5eeb: aload 45
      // 5eed: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 5ef0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5ef3: checkcast net/minecraft/world/effect/MobEffect
      // 5ef6: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5ef9: ifeq 5f0c
      // 5efc: aload 0
      // 5efd: ifnull 5f0c
      // 5f00: aload 0
      // 5f01: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 5f04: ifeq 5f0c
      // 5f07: aload 0
      // 5f08: bipush 1
      // 5f09: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 5f0c: aload 9
      // 5f0e: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 5f11: ifeq 5f3f
      // 5f14: aload 11
      // 5f16: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5f19: ldc "creativespectator"
      // 5f1b: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 5f1e: ifne 5f3f
      // 5f21: aload 9
      // 5f23: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 5f26: ifeq 5f3f
      // 5f29: aload 9
      // 5f2b: checkcast net/arphex/entity/SpiderMothDwellerEntity
      // 5f2e: astore 45
      // 5f30: aload 45
      // 5f32: invokevirtual net/arphex/entity/SpiderMothDwellerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 5f35: getstatic net/arphex/entity/SpiderMothDwellerEntity.DATA_primed Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 5f38: bipush 1
      // 5f39: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 5f3c: invokevirtual net/minecraft/network/syncher/SynchedEntityData.set (Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;)V
      // 5f3f: aload 11
      // 5f41: instanceof net/arphex/entity/DragonflyDreadnoughtEntity
      // 5f44: ifeq 5f7c
      // 5f47: aload 11
      // 5f49: instanceof net/minecraft/world/entity/LivingEntity
      // 5f4c: ifeq 5f76
      // 5f4f: aload 11
      // 5f51: checkcast net/minecraft/world/entity/LivingEntity
      // 5f54: astore 45
      // 5f56: aload 45
      // 5f58: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5f5b: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5f5e: ifne 5f76
      // 5f61: aload 45
      // 5f63: new net/minecraft/world/effect/MobEffectInstance
      // 5f66: dup
      // 5f67: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 5f6a: bipush 60
      // 5f6c: bipush 1
      // 5f6d: bipush 0
      // 5f6e: bipush 0
      // 5f6f: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 5f72: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5f75: pop
      // 5f76: aload 11
      // 5f78: bipush 1
      // 5f79: invokevirtual net/minecraft/world/entity/Entity.setShiftKeyDown (Z)V
      // 5f7c: aload 11
      // 5f7e: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 5f81: ifeq 5f9b
      // 5f84: aload 11
      // 5f86: aload 9
      // 5f88: if_acmpne 5f9b
      // 5f8b: aload 0
      // 5f8c: ifnull 5f9b
      // 5f8f: aload 0
      // 5f90: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 5f93: ifeq 5f9b
      // 5f96: aload 0
      // 5f97: bipush 1
      // 5f98: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 5f9b: aload 9
      // 5f9d: instanceof net/arphex/entity/TORMENTOREntity
      // 5fa0: ifeq 6017
      // 5fa3: aload 9
      // 5fa5: instanceof net/minecraft/world/entity/LivingEntity
      // 5fa8: ifeq 5fd7
      // 5fab: aload 9
      // 5fad: checkcast net/minecraft/world/entity/LivingEntity
      // 5fb0: astore 45
      // 5fb2: aload 45
      // 5fb4: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5fb7: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5fba: ifne 5fd7
      // 5fbd: aload 45
      // 5fbf: new net/minecraft/world/effect/MobEffectInstance
      // 5fc2: dup
      // 5fc3: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 5fc6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5fc9: checkcast net/minecraft/world/effect/MobEffect
      // 5fcc: bipush 3
      // 5fcd: bipush 1
      // 5fce: bipush 0
      // 5fcf: bipush 0
      // 5fd0: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 5fd3: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5fd6: pop
      // 5fd7: bipush 1
      // 5fd8: aload 9
      // 5fda: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$72 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 5fdf: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 5fe2: aload 11
      // 5fe4: aload 9
      // 5fe6: if_acmpne 6017
      // 5fe9: aload 9
      // 5feb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5fee: ldc_w "able_to_harm_self"
      // 5ff1: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5ff4: dconst_0
      // 5ff5: dcmpl
      // 5ff6: ifgt 6009
      // 5ff9: aload 0
      // 5ffa: ifnull 6009
      // 5ffd: aload 0
      // 5ffe: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 6001: ifeq 6009
      // 6004: aload 0
      // 6005: bipush 1
      // 6006: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 6009: bipush 2
      // 600a: aload 9
      // 600c: aload 1
      // 600d: aload 11
      // 600f: invokedynamic run (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$73 (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 6014: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 6017: aload 11
      // 6019: aload 9
      // 601b: if_acmpeq 62e6
      // 601e: aload 11
      // 6020: instanceof net/minecraft/world/entity/LivingEntity
      // 6023: ifeq 6038
      // 6026: aload 11
      // 6028: checkcast net/minecraft/world/entity/LivingEntity
      // 602b: astore 45
      // 602d: aload 45
      // 602f: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 6032: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 6035: goto 603b
      // 6038: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 603b: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 603e: getstatic net/arphex/init/ArphexModItems.SPECTRAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 6041: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6044: if_acmpne 60c2
      // 6047: aload 11
      // 6049: instanceof net/minecraft/world/entity/LivingEntity
      // 604c: ifeq 6061
      // 604f: aload 11
      // 6051: checkcast net/minecraft/world/entity/LivingEntity
      // 6054: astore 46
      // 6056: aload 46
      // 6058: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 605b: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 605e: goto 6064
      // 6061: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6064: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6067: getstatic net/arphex/init/ArphexModItems.SPECTRAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 606a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 606d: if_acmpne 60c2
      // 6070: aload 11
      // 6072: instanceof net/minecraft/world/entity/LivingEntity
      // 6075: ifeq 608a
      // 6078: aload 11
      // 607a: checkcast net/minecraft/world/entity/LivingEntity
      // 607d: astore 47
      // 607f: aload 47
      // 6081: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 6084: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 6087: goto 608d
      // 608a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 608d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6090: getstatic net/arphex/init/ArphexModItems.SPECTRAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 6093: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6096: if_acmpne 60c2
      // 6099: aload 11
      // 609b: instanceof net/minecraft/world/entity/LivingEntity
      // 609e: ifeq 60b3
      // 60a1: aload 11
      // 60a3: checkcast net/minecraft/world/entity/LivingEntity
      // 60a6: astore 48
      // 60a8: aload 48
      // 60aa: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 60ad: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 60b0: goto 60b6
      // 60b3: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 60b6: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 60b9: getstatic net/arphex/init/ArphexModItems.SPECTRAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 60bc: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 60bf: if_acmpeq 620a
      // 60c2: aload 11
      // 60c4: instanceof net/minecraft/world/entity/LivingEntity
      // 60c7: ifeq 60dc
      // 60ca: aload 11
      // 60cc: checkcast net/minecraft/world/entity/LivingEntity
      // 60cf: astore 49
      // 60d1: aload 49
      // 60d3: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 60d6: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 60d9: goto 60df
      // 60dc: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 60df: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 60e2: getstatic net/arphex/init/ArphexModItems.ETERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 60e5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 60e8: if_acmpne 6166
      // 60eb: aload 11
      // 60ed: instanceof net/minecraft/world/entity/LivingEntity
      // 60f0: ifeq 6105
      // 60f3: aload 11
      // 60f5: checkcast net/minecraft/world/entity/LivingEntity
      // 60f8: astore 50
      // 60fa: aload 50
      // 60fc: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 60ff: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 6102: goto 6108
      // 6105: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6108: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 610b: getstatic net/arphex/init/ArphexModItems.ETERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 610e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6111: if_acmpne 6166
      // 6114: aload 11
      // 6116: instanceof net/minecraft/world/entity/LivingEntity
      // 6119: ifeq 612e
      // 611c: aload 11
      // 611e: checkcast net/minecraft/world/entity/LivingEntity
      // 6121: astore 51
      // 6123: aload 51
      // 6125: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 6128: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 612b: goto 6131
      // 612e: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6131: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6134: getstatic net/arphex/init/ArphexModItems.ETERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 6137: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 613a: if_acmpne 6166
      // 613d: aload 11
      // 613f: instanceof net/minecraft/world/entity/LivingEntity
      // 6142: ifeq 6157
      // 6145: aload 11
      // 6147: checkcast net/minecraft/world/entity/LivingEntity
      // 614a: astore 52
      // 614c: aload 52
      // 614e: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 6151: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 6154: goto 615a
      // 6157: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 615a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 615d: getstatic net/arphex/init/ArphexModItems.ETERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 6160: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6163: if_acmpeq 620a
      // 6166: aload 11
      // 6168: instanceof net/minecraft/world/entity/LivingEntity
      // 616b: ifeq 6180
      // 616e: aload 11
      // 6170: checkcast net/minecraft/world/entity/LivingEntity
      // 6173: astore 53
      // 6175: aload 53
      // 6177: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 617a: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 617d: goto 6183
      // 6180: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6183: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6186: getstatic net/arphex/init/ArphexModItems.IMMORTAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 6189: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 618c: if_acmpne 62e6
      // 618f: aload 11
      // 6191: instanceof net/minecraft/world/entity/LivingEntity
      // 6194: ifeq 61a9
      // 6197: aload 11
      // 6199: checkcast net/minecraft/world/entity/LivingEntity
      // 619c: astore 54
      // 619e: aload 54
      // 61a0: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 61a3: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 61a6: goto 61ac
      // 61a9: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 61ac: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 61af: getstatic net/arphex/init/ArphexModItems.IMMORTAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 61b2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 61b5: if_acmpne 62e6
      // 61b8: aload 11
      // 61ba: instanceof net/minecraft/world/entity/LivingEntity
      // 61bd: ifeq 61d2
      // 61c0: aload 11
      // 61c2: checkcast net/minecraft/world/entity/LivingEntity
      // 61c5: astore 55
      // 61c7: aload 55
      // 61c9: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 61cc: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 61cf: goto 61d5
      // 61d2: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 61d5: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 61d8: getstatic net/arphex/init/ArphexModItems.IMMORTAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 61db: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 61de: if_acmpne 62e6
      // 61e1: aload 11
      // 61e3: instanceof net/minecraft/world/entity/LivingEntity
      // 61e6: ifeq 61fb
      // 61e9: aload 11
      // 61eb: checkcast net/minecraft/world/entity/LivingEntity
      // 61ee: astore 56
      // 61f0: aload 56
      // 61f2: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 61f5: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 61f8: goto 61fe
      // 61fb: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 61fe: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6201: getstatic net/arphex/init/ArphexModItems.IMMORTAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 6204: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6207: if_acmpne 62e6
      // 620a: aload 1
      // 620b: instanceof net/minecraft/server/level/ServerLevel
      // 620e: ifeq 6238
      // 6211: aload 1
      // 6212: checkcast net/minecraft/server/level/ServerLevel
      // 6215: astore 57
      // 6217: aload 57
      // 6219: getstatic net/arphex/init/ArphexModParticleTypes.CHARRED_BLOOD Lnet/minecraftforge/registries/RegistryObject;
      // 621c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 621f: checkcast net/minecraft/core/particles/SimpleParticleType
      // 6222: dload 2
      // 6223: dload 4
      // 6225: dload 6
      // 6227: bipush 2
      // 6228: ldc2_w 0.1
      // 622b: ldc2_w 0.1
      // 622e: ldc2_w 0.1
      // 6231: ldc2_w 0.1
      // 6234: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 6237: pop
      // 6238: dload 12
      // 623a: ldc2_w 20.0
      // 623d: dcmpl
      // 623e: ifle 6273
      // 6241: aload 11
      // 6243: instanceof net/minecraft/world/entity/LivingEntity
      // 6246: ifeq 6270
      // 6249: aload 11
      // 624b: checkcast net/minecraft/world/entity/LivingEntity
      // 624e: astore 57
      // 6250: aload 57
      // 6252: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 6255: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6258: ifne 6270
      // 625b: aload 57
      // 625d: new net/minecraft/world/effect/MobEffectInstance
      // 6260: dup
      // 6261: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 6264: bipush 50
      // 6266: bipush 1
      // 6267: bipush 0
      // 6268: bipush 0
      // 6269: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 626c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 626f: pop
      // 6270: goto 62e6
      // 6273: dload 12
      // 6275: ldc2_w 10.0
      // 6278: dcmpl
      // 6279: ifle 62ae
      // 627c: aload 11
      // 627e: instanceof net/minecraft/world/entity/LivingEntity
      // 6281: ifeq 62ab
      // 6284: aload 11
      // 6286: checkcast net/minecraft/world/entity/LivingEntity
      // 6289: astore 57
      // 628b: aload 57
      // 628d: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 6290: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6293: ifne 62ab
      // 6296: aload 57
      // 6298: new net/minecraft/world/effect/MobEffectInstance
      // 629b: dup
      // 629c: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 629f: bipush 120
      // 62a1: bipush 0
      // 62a2: bipush 0
      // 62a3: bipush 0
      // 62a4: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 62a7: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 62aa: pop
      // 62ab: goto 62e6
      // 62ae: dload 12
      // 62b0: ldc2_w 5.0
      // 62b3: dcmpl
      // 62b4: ifle 62e6
      // 62b7: aload 11
      // 62b9: instanceof net/minecraft/world/entity/LivingEntity
      // 62bc: ifeq 62e6
      // 62bf: aload 11
      // 62c1: checkcast net/minecraft/world/entity/LivingEntity
      // 62c4: astore 57
      // 62c6: aload 57
      // 62c8: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 62cb: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 62ce: ifne 62e6
      // 62d1: aload 57
      // 62d3: new net/minecraft/world/effect/MobEffectInstance
      // 62d6: dup
      // 62d7: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 62da: bipush 60
      // 62dc: bipush 0
      // 62dd: bipush 0
      // 62de: bipush 0
      // 62df: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 62e2: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 62e5: pop
      // 62e6: aload 11
      // 62e8: invokevirtual net/minecraft/world/entity/Entity.onGround ()Z
      // 62eb: ifeq 64fd
      // 62ee: aload 8
      // 62f0: getstatic net/minecraft/world/damagesource/DamageTypes.FLY_INTO_WALL Lnet/minecraft/resources/ResourceKey;
      // 62f3: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 62f6: ifne 64fd
      // 62f9: aload 8
      // 62fb: getstatic net/minecraft/world/damagesource/DamageTypes.ARROW Lnet/minecraft/resources/ResourceKey;
      // 62fe: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 6301: ifne 64fd
      // 6304: aload 11
      // 6306: instanceof net/minecraft/world/entity/LivingEntity
      // 6309: ifeq 631b
      // 630c: aload 11
      // 630e: checkcast net/minecraft/world/entity/LivingEntity
      // 6311: astore 45
      // 6313: aload 45
      // 6315: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 6318: goto 631e
      // 631b: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 631e: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6321: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 6324: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6327: if_acmpeq 6376
      // 632a: aload 11
      // 632c: instanceof net/minecraft/world/entity/LivingEntity
      // 632f: ifeq 6341
      // 6332: aload 11
      // 6334: checkcast net/minecraft/world/entity/LivingEntity
      // 6337: astore 46
      // 6339: aload 46
      // 633b: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 633e: goto 6344
      // 6341: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6344: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6347: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 634a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 634d: if_acmpeq 6376
      // 6350: aload 11
      // 6352: instanceof net/minecraft/world/entity/LivingEntity
      // 6355: ifeq 6367
      // 6358: aload 11
      // 635a: checkcast net/minecraft/world/entity/LivingEntity
      // 635d: astore 47
      // 635f: aload 47
      // 6361: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 6364: goto 636a
      // 6367: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 636a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 636d: getstatic net/arphex/init/ArphexModItems.CRUSHER_CLAW Lnet/minecraftforge/registries/RegistryObject;
      // 6370: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6373: if_acmpne 64fd
      // 6376: aload 11
      // 6378: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 637b: ldc_w "justswung"
      // 637e: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6381: ldc2_w 20.0
      // 6384: dcmpl
      // 6385: iflt 64fd
      // 6388: new net/minecraft/world/phys/Vec3
      // 638b: dup
      // 638c: aload 9
      // 638e: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 6391: aload 9
      // 6393: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 6396: aload 9
      // 6398: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 639b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 639e: astore 48
      // 63a0: aload 1
      // 63a1: ldc net/minecraft/world/entity/Entity
      // 63a3: new net/minecraft/world/phys/AABB
      // 63a6: dup
      // 63a7: aload 48
      // 63a9: aload 48
      // 63ab: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 63ae: ldc2_w 1.5
      // 63b1: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 63b4: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$74 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 63b9: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 63be: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 63c3: aload 48
      // 63c5: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$75 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 63ca: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 63cd: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 63d2: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 63d7: astore 49
      // 63d9: aload 49
      // 63db: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 63e0: astore 50
      // 63e2: aload 50
      // 63e4: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 63e9: ifeq 64fd
      // 63ec: aload 50
      // 63ee: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 63f3: checkcast net/minecraft/world/entity/Entity
      // 63f6: astore 51
      // 63f8: aload 11
      // 63fa: aload 51
      // 63fc: if_acmpeq 64fa
      // 63ff: aload 9
      // 6401: aload 51
      // 6403: if_acmpeq 64fa
      // 6406: aload 51
      // 6408: instanceof net/minecraft/world/entity/TamableAnimal
      // 640b: ifeq 6420
      // 640e: aload 51
      // 6410: checkcast net/minecraft/world/entity/TamableAnimal
      // 6413: astore 52
      // 6415: aload 52
      // 6417: invokevirtual net/minecraft/world/entity/TamableAnimal.isTame ()Z
      // 641a: ifeq 6420
      // 641d: goto 64fa
      // 6420: aload 51
      // 6422: instanceof net/minecraft/world/entity/LivingEntity
      // 6425: ifeq 6448
      // 6428: aload 51
      // 642a: checkcast net/minecraft/world/entity/LivingEntity
      // 642d: astore 53
      // 642f: aload 53
      // 6431: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 6434: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 6437: ifeq 6448
      // 643a: aload 53
      // 643c: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 643f: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 6442: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 6445: goto 6449
      // 6448: bipush 0
      // 6449: bipush 3
      // 644a: if_icmpgt 648f
      // 644d: aload 51
      // 644f: new net/minecraft/world/damagesource/DamageSource
      // 6452: dup
      // 6453: aload 1
      // 6454: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 6459: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 645c: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 6461: getstatic net/minecraft/world/damagesource/DamageTypes.FLY_INTO_WALL Lnet/minecraft/resources/ResourceKey;
      // 6464: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 6469: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 646c: bipush 100
      // 646e: aload 51
      // 6470: instanceof net/minecraft/world/entity/LivingEntity
      // 6473: ifeq 6485
      // 6476: aload 51
      // 6478: checkcast net/minecraft/world/entity/LivingEntity
      // 647b: astore 54
      // 647d: aload 54
      // 647f: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 6482: goto 6486
      // 6485: bipush 0
      // 6486: bipush 10
      // 6488: iadd
      // 6489: idiv
      // 648a: i2f
      // 648b: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 648e: pop
      // 648f: aload 9
      // 6491: new net/minecraft/world/phys/Vec3
      // 6494: dup
      // 6495: aload 9
      // 6497: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 649a: ldc_w 90.0
      // 649d: fadd
      // 649e: f2d
      // 649f: ldc2_w 0.017453292519943295
      // 64a2: dmul
      // 64a3: invokestatic java/lang/Math.cos (D)D
      // 64a6: ldc2_w 2.0
      // 64a9: ddiv
      // 64aa: ldc2_w 0.2
      // 64ad: aload 9
      // 64af: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 64b2: ldc_w 90.0
      // 64b5: fadd
      // 64b6: f2d
      // 64b7: ldc2_w 0.017453292519943295
      // 64ba: dmul
      // 64bb: invokestatic java/lang/Math.sin (D)D
      // 64be: ldc2_w 2.0
      // 64c1: ddiv
      // 64c2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 64c5: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 64c8: aload 1
      // 64c9: instanceof net/minecraft/server/level/ServerLevel
      // 64cc: ifeq 64fa
      // 64cf: aload 1
      // 64d0: checkcast net/minecraft/server/level/ServerLevel
      // 64d3: astore 53
      // 64d5: aload 53
      // 64d7: getstatic net/minecraft/core/particles/ParticleTypes.SWEEP_ATTACK Lnet/minecraft/core/particles/SimpleParticleType;
      // 64da: aload 51
      // 64dc: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 64df: aload 51
      // 64e1: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 64e4: aload 51
      // 64e6: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 64e9: bipush 2
      // 64ea: ldc2_w 0.3
      // 64ed: ldc2_w 0.3
      // 64f0: ldc2_w 0.3
      // 64f3: ldc2_w 0.1
      // 64f6: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 64f9: pop
      // 64fa: goto 63e2
      // 64fd: aload 11
      // 64ff: instanceof net/arphex/entity/CrabConstrictorEntity
      // 6502: ifeq 6693
      // 6505: aload 9
      // 6507: new net/minecraft/world/phys/Vec3
      // 650a: dup
      // 650b: aload 9
      // 650d: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 6510: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 6513: ldc2_w 2.0
      // 6516: ddiv
      // 6517: ldc2_w -0.6
      // 651a: aload 9
      // 651c: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 651f: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 6522: ldc2_w 2.0
      // 6525: ddiv
      // 6526: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6529: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 652c: aload 9
      // 652e: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 6531: aload 11
      // 6533: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 6536: dconst_1
      // 6537: dsub
      // 6538: dcmpl
      // 6539: ifle 6693
      // 653c: new net/minecraft/world/phys/Vec3
      // 653f: dup
      // 6540: aload 9
      // 6542: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 6545: aload 9
      // 6547: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 654a: aload 9
      // 654c: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 654f: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6552: astore 45
      // 6554: aload 1
      // 6555: ldc net/minecraft/world/entity/Entity
      // 6557: new net/minecraft/world/phys/AABB
      // 655a: dup
      // 655b: aload 45
      // 655d: aload 45
      // 655f: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 6562: ldc2_w 4.0
      // 6565: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 6568: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$76 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 656d: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6572: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 6577: aload 45
      // 6579: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$77 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 657e: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 6581: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 6586: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 658b: astore 46
      // 658d: aload 46
      // 658f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 6594: astore 47
      // 6596: aload 47
      // 6598: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 659d: ifeq 6693
      // 65a0: aload 47
      // 65a2: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 65a7: checkcast net/minecraft/world/entity/Entity
      // 65aa: astore 48
      // 65ac: aload 11
      // 65ae: aload 48
      // 65b0: if_acmpeq 6690
      // 65b3: aload 9
      // 65b5: aload 48
      // 65b7: if_acmpeq 6690
      // 65ba: aload 48
      // 65bc: instanceof net/minecraft/world/entity/LivingEntity
      // 65bf: ifeq 65e2
      // 65c2: aload 48
      // 65c4: checkcast net/minecraft/world/entity/LivingEntity
      // 65c7: astore 49
      // 65c9: aload 49
      // 65cb: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 65ce: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 65d1: ifeq 65e2
      // 65d4: aload 49
      // 65d6: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 65d9: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 65dc: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 65df: goto 65e3
      // 65e2: bipush 0
      // 65e3: bipush 3
      // 65e4: if_icmpgt 6629
      // 65e7: aload 48
      // 65e9: new net/minecraft/world/damagesource/DamageSource
      // 65ec: dup
      // 65ed: aload 1
      // 65ee: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 65f3: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 65f6: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 65fb: getstatic net/minecraft/world/damagesource/DamageTypes.FLY_INTO_WALL Lnet/minecraft/resources/ResourceKey;
      // 65fe: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 6603: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 6606: bipush 80
      // 6608: aload 48
      // 660a: instanceof net/minecraft/world/entity/LivingEntity
      // 660d: ifeq 661f
      // 6610: aload 48
      // 6612: checkcast net/minecraft/world/entity/LivingEntity
      // 6615: astore 50
      // 6617: aload 50
      // 6619: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 661c: goto 6620
      // 661f: bipush 0
      // 6620: bipush 10
      // 6622: iadd
      // 6623: idiv
      // 6624: i2f
      // 6625: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 6628: pop
      // 6629: aload 48
      // 662b: new net/minecraft/world/phys/Vec3
      // 662e: dup
      // 662f: aload 9
      // 6631: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 6634: ldc_w 90.0
      // 6637: fadd
      // 6638: f2d
      // 6639: ldc2_w 0.017453292519943295
      // 663c: dmul
      // 663d: invokestatic java/lang/Math.cos (D)D
      // 6640: dconst_1
      // 6641: ddiv
      // 6642: ldc2_w -0.6
      // 6645: aload 9
      // 6647: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 664a: ldc_w 90.0
      // 664d: fadd
      // 664e: f2d
      // 664f: ldc2_w 0.017453292519943295
      // 6652: dmul
      // 6653: invokestatic java/lang/Math.sin (D)D
      // 6656: dconst_1
      // 6657: ddiv
      // 6658: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 665b: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 665e: aload 1
      // 665f: instanceof net/minecraft/server/level/ServerLevel
      // 6662: ifeq 6690
      // 6665: aload 1
      // 6666: checkcast net/minecraft/server/level/ServerLevel
      // 6669: astore 49
      // 666b: aload 49
      // 666d: getstatic net/minecraft/core/particles/ParticleTypes.SWEEP_ATTACK Lnet/minecraft/core/particles/SimpleParticleType;
      // 6670: aload 48
      // 6672: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 6675: aload 48
      // 6677: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 667a: aload 48
      // 667c: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 667f: bipush 2
      // 6680: ldc2_w 0.3
      // 6683: ldc2_w 0.3
      // 6686: ldc2_w 0.3
      // 6689: ldc2_w 0.1
      // 668c: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 668f: pop
      // 6690: goto 6596
      // 6693: aload 9
      // 6695: instanceof net/arphex/entity/CrabConstrictorEntity
      // 6698: ifeq 6701
      // 669b: aload 9
      // 669d: new net/minecraft/world/phys/Vec3
      // 66a0: dup
      // 66a1: dconst_0
      // 66a2: dconst_0
      // 66a3: dconst_0
      // 66a4: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 66a7: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 66aa: aload 10
      // 66ac: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 66af: getstatic net/minecraft/core/registries/Registries.ENTITY_TYPE Lnet/minecraft/resources/ResourceKey;
      // 66b2: new net/minecraft/resources/ResourceLocation
      // 66b5: dup
      // 66b6: ldc_w "minecraft:impact_projectiles"
      // 66b9: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 66bc: invokestatic net/minecraft/tags/TagKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/tags/TagKey;
      // 66bf: invokevirtual net/minecraft/world/entity/EntityType.is (Lnet/minecraft/tags/TagKey;)Z
      // 66c2: ifne 66e5
      // 66c5: aload 10
      // 66c7: instanceof net/arphex/entity/InvisibleArrowEntity
      // 66ca: ifne 66e5
      // 66cd: aload 10
      // 66cf: instanceof net/arphex/entity/WebbedArrowEntity
      // 66d2: ifne 66e5
      // 66d5: aload 10
      // 66d7: instanceof net/arphex/entity/BloodthirstyTendrilEntity
      // 66da: ifne 66e5
      // 66dd: aload 10
      // 66df: instanceof net/arphex/entity/BloodProjectileEntity
      // 66e2: ifeq 6701
      // 66e5: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 66e8: bipush 1
      // 66e9: bipush 2
      // 66ea: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 66ed: bipush 2
      // 66ee: if_icmpne 6701
      // 66f1: aload 0
      // 66f2: ifnull 6701
      // 66f5: aload 0
      // 66f6: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 66f9: ifeq 6701
      // 66fc: aload 0
      // 66fd: bipush 1
      // 66fe: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 6701: aload 11
      // 6703: instanceof net/arphex/entity/SpiderMothSummonEntity
      // 6706: ifeq 6736
      // 6709: aload 9
      // 670b: instanceof net/minecraft/world/entity/LivingEntity
      // 670e: ifeq 6736
      // 6711: aload 9
      // 6713: checkcast net/minecraft/world/entity/LivingEntity
      // 6716: astore 45
      // 6718: aload 45
      // 671a: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 671d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6720: ifne 6736
      // 6723: aload 45
      // 6725: new net/minecraft/world/effect/MobEffectInstance
      // 6728: dup
      // 6729: getstatic net/minecraft/world/effect/MobEffects.REGENERATION Lnet/minecraft/world/effect/MobEffect;
      // 672c: bipush 30
      // 672e: bipush 4
      // 672f: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 6732: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 6735: pop
      // 6736: aload 11
      // 6738: instanceof net/arphex/entity/CrabLarvaeEntity
      // 673b: ifeq 6764
      // 673e: aload 9
      // 6740: instanceof net/minecraft/world/entity/player/Player
      // 6743: ifeq 6764
      // 6746: aload 9
      // 6748: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 674b: ldc_w "attackwait"
      // 674e: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 6751: ifne 6764
      // 6754: aload 0
      // 6755: ifnull 6764
      // 6758: aload 0
      // 6759: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 675c: ifeq 6764
      // 675f: aload 0
      // 6760: bipush 1
      // 6761: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 6764: aload 9
      // 6766: instanceof net/minecraft/world/entity/player/Player
      // 6769: ifeq 7da7
      // 676c: aload 9
      // 676e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6771: ldc_w "justsummonedgold"
      // 6774: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 6777: ifeq 6785
      // 677a: bipush 4
      // 677b: aload 9
      // 677d: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$78 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 6782: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 6785: aload 9
      // 6787: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 678a: ldc_w "justsummonedpurple"
      // 678d: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 6790: ifeq 679e
      // 6793: bipush 4
      // 6794: aload 9
      // 6796: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$79 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 679b: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 679e: aload 9
      // 67a0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 67a3: ldc_w "justsummonediridescent"
      // 67a6: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 67a9: ifeq 67b7
      // 67ac: bipush 4
      // 67ad: aload 9
      // 67af: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$80 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 67b4: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 67b7: aload 9
      // 67b9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 67bc: ldc_w "justsummonedgreengold"
      // 67bf: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 67c2: ifeq 67d0
      // 67c5: bipush 4
      // 67c6: aload 9
      // 67c8: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$81 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 67cd: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 67d0: aload 9
      // 67d2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 67d5: ldc_w "justsummonedgreen"
      // 67d8: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 67db: ifeq 67e9
      // 67de: bipush 4
      // 67df: aload 9
      // 67e1: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$82 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 67e6: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 67e9: aload 9
      // 67eb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 67ee: ldc_w "justsummonedbrown"
      // 67f1: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 67f4: ifeq 6802
      // 67f7: bipush 4
      // 67f8: aload 9
      // 67fa: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$83 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 67ff: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 6802: aload 9
      // 6804: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6807: ldc_w "brownbeetles"
      // 680a: dconst_0
      // 680b: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 680e: aload 9
      // 6810: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6813: ldc_w "greenbeetles"
      // 6816: dconst_0
      // 6817: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 681a: aload 9
      // 681c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 681f: ldc_w "ggbeetles"
      // 6822: dconst_0
      // 6823: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6826: aload 9
      // 6828: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 682b: ldc_w "irbeetles"
      // 682e: dconst_0
      // 682f: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6832: aload 9
      // 6834: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6837: ldc_w "purplebeetles"
      // 683a: dconst_0
      // 683b: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 683e: aload 9
      // 6840: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6843: ldc_w "goldbeetles"
      // 6846: dconst_0
      // 6847: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 684a: new java/util/concurrent/atomic/AtomicReference
      // 684d: dup
      // 684e: invokespecial java/util/concurrent/atomic/AtomicReference.<init> ()V
      // 6851: astore 45
      // 6853: aload 9
      // 6855: getstatic net/minecraftforge/common/capabilities/ForgeCapabilities.ITEM_HANDLER Lnet/minecraftforge/common/capabilities/Capability;
      // 6858: aconst_null
      // 6859: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 685c: aload 45
      // 685e: dup
      // 685f: invokestatic java/util/Objects.requireNonNull (Ljava/lang/Object;)Ljava/lang/Object;
      // 6862: pop
      // 6863: invokedynamic accept (Ljava/util/concurrent/atomic/AtomicReference;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V, (Lnet/minecraftforge/items/IItemHandler;)V ]
      // 6868: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 686b: aload 45
      // 686d: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 6870: ifnull 6aa8
      // 6873: bipush 0
      // 6874: istore 46
      // 6876: iload 46
      // 6878: aload 45
      // 687a: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 687d: checkcast net/minecraftforge/items/IItemHandler
      // 6880: invokeinterface net/minecraftforge/items/IItemHandler.getSlots ()I 1
      // 6885: if_icmpge 6aa8
      // 6888: aload 45
      // 688a: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 688d: checkcast net/minecraftforge/items/IItemHandler
      // 6890: iload 46
      // 6892: invokeinterface net/minecraftforge/items/IItemHandler.getStackInSlot (I)Lnet/minecraft/world/item/ItemStack; 2
      // 6897: invokevirtual net/minecraft/world/item/ItemStack.copy ()Lnet/minecraft/world/item/ItemStack;
      // 689a: astore 47
      // 689c: getstatic net/arphex/init/ArphexModItems.SEALED_BROWN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 689f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 68a2: aload 47
      // 68a4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 68a7: if_acmpne 68c7
      // 68aa: aload 9
      // 68ac: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 68af: ldc_w "brownbeetles"
      // 68b2: aload 9
      // 68b4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 68b7: ldc_w "brownbeetles"
      // 68ba: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 68bd: aload 47
      // 68bf: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 68c2: i2d
      // 68c3: dadd
      // 68c4: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 68c7: getstatic net/arphex/init/ArphexModItems.SEALED_GREEN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 68ca: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 68cd: aload 47
      // 68cf: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 68d2: if_acmpne 68f2
      // 68d5: aload 9
      // 68d7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 68da: ldc_w "greenbeetles"
      // 68dd: aload 9
      // 68df: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 68e2: ldc_w "greenbeetles"
      // 68e5: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 68e8: aload 47
      // 68ea: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 68ed: i2d
      // 68ee: dadd
      // 68ef: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 68f2: getstatic net/arphex/init/ArphexModItems.SEALED_GREEN_GOLD_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 68f5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 68f8: aload 47
      // 68fa: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 68fd: if_acmpne 691d
      // 6900: aload 9
      // 6902: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6905: ldc_w "ggbeetles"
      // 6908: aload 9
      // 690a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 690d: ldc_w "ggbeetles"
      // 6910: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6913: aload 47
      // 6915: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 6918: i2d
      // 6919: dadd
      // 691a: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 691d: getstatic net/arphex/init/ArphexModItems.SEALED_IRIDESCENT_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 6920: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6923: aload 47
      // 6925: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6928: if_acmpne 6948
      // 692b: aload 9
      // 692d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6930: ldc_w "irbeetles"
      // 6933: aload 9
      // 6935: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6938: ldc_w "irbeetles"
      // 693b: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 693e: aload 47
      // 6940: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 6943: i2d
      // 6944: dadd
      // 6945: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6948: getstatic net/arphex/init/ArphexModItems.SEALED_PURPLE_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 694b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 694e: aload 47
      // 6950: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6953: if_acmpne 6973
      // 6956: aload 9
      // 6958: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 695b: ldc_w "purplebeetles"
      // 695e: aload 9
      // 6960: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6963: ldc_w "purplebeetles"
      // 6966: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6969: aload 47
      // 696b: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 696e: i2d
      // 696f: dadd
      // 6970: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6973: getstatic net/arphex/init/ArphexModItems.SEALED_GOLDEN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 6976: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6979: aload 47
      // 697b: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 697e: if_acmpne 699e
      // 6981: aload 9
      // 6983: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6986: ldc_w "goldbeetles"
      // 6989: aload 9
      // 698b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 698e: ldc_w "goldbeetles"
      // 6991: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6994: aload 47
      // 6996: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 6999: i2d
      // 699a: dadd
      // 699b: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 699e: getstatic net/arphex/init/ArphexModItems.SINGULARITY_SATCHEL Lnet/minecraftforge/registries/RegistryObject;
      // 69a1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 69a4: aload 47
      // 69a6: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 69a9: if_acmpne 6aa2
      // 69ac: aload 9
      // 69ae: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 69b1: ldc_w "brownbeetles"
      // 69b4: aload 9
      // 69b6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 69b9: ldc_w "brownbeetles"
      // 69bc: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 69bf: new net/arphex/procedures/DwellerLifestealProcedure$16
      // 69c2: dup
      // 69c3: invokespecial net/arphex/procedures/DwellerLifestealProcedure$16.<init> ()V
      // 69c6: bipush 89
      // 69c8: aload 47
      // 69ca: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$16.getItemStack (ILnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;
      // 69cd: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 69d0: i2d
      // 69d1: dadd
      // 69d2: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 69d5: aload 9
      // 69d7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 69da: ldc_w "greenbeetles"
      // 69dd: aload 9
      // 69df: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 69e2: ldc_w "greenbeetles"
      // 69e5: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 69e8: new net/arphex/procedures/DwellerLifestealProcedure$17
      // 69eb: dup
      // 69ec: invokespecial net/arphex/procedures/DwellerLifestealProcedure$17.<init> ()V
      // 69ef: bipush 88
      // 69f1: aload 47
      // 69f3: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$17.getItemStack (ILnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;
      // 69f6: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 69f9: i2d
      // 69fa: dadd
      // 69fb: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 69fe: aload 9
      // 6a00: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a03: ldc_w "ggbeetles"
      // 6a06: aload 9
      // 6a08: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a0b: ldc_w "ggbeetles"
      // 6a0e: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6a11: new net/arphex/procedures/DwellerLifestealProcedure$18
      // 6a14: dup
      // 6a15: invokespecial net/arphex/procedures/DwellerLifestealProcedure$18.<init> ()V
      // 6a18: bipush 87
      // 6a1a: aload 47
      // 6a1c: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$18.getItemStack (ILnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;
      // 6a1f: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 6a22: i2d
      // 6a23: dadd
      // 6a24: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6a27: aload 9
      // 6a29: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a2c: ldc_w "irbeetles"
      // 6a2f: aload 9
      // 6a31: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a34: ldc_w "irbeetles"
      // 6a37: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6a3a: new net/arphex/procedures/DwellerLifestealProcedure$19
      // 6a3d: dup
      // 6a3e: invokespecial net/arphex/procedures/DwellerLifestealProcedure$19.<init> ()V
      // 6a41: bipush 86
      // 6a43: aload 47
      // 6a45: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$19.getItemStack (ILnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;
      // 6a48: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 6a4b: i2d
      // 6a4c: dadd
      // 6a4d: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6a50: aload 9
      // 6a52: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a55: ldc_w "purplebeetles"
      // 6a58: aload 9
      // 6a5a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a5d: ldc_w "purplebeetles"
      // 6a60: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6a63: new net/arphex/procedures/DwellerLifestealProcedure$20
      // 6a66: dup
      // 6a67: invokespecial net/arphex/procedures/DwellerLifestealProcedure$20.<init> ()V
      // 6a6a: bipush 85
      // 6a6c: aload 47
      // 6a6e: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$20.getItemStack (ILnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;
      // 6a71: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 6a74: i2d
      // 6a75: dadd
      // 6a76: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6a79: aload 9
      // 6a7b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a7e: ldc_w "goldbeetles"
      // 6a81: aload 9
      // 6a83: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6a86: ldc_w "goldbeetles"
      // 6a89: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6a8c: new net/arphex/procedures/DwellerLifestealProcedure$21
      // 6a8f: dup
      // 6a90: invokespecial net/arphex/procedures/DwellerLifestealProcedure$21.<init> ()V
      // 6a93: bipush 84
      // 6a95: aload 47
      // 6a97: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$21.getItemStack (ILnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;
      // 6a9a: invokevirtual net/minecraft/world/item/ItemStack.getCount ()I
      // 6a9d: i2d
      // 6a9e: dadd
      // 6a9f: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6aa2: iinc 46 1
      // 6aa5: goto 6876
      // 6aa8: aload 9
      // 6aaa: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6aad: ldc_w "brownbeetles"
      // 6ab0: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6ab3: ldc2_w 10.0
      // 6ab6: dcmpl
      // 6ab7: ifle 6ac8
      // 6aba: aload 9
      // 6abc: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6abf: ldc_w "brownbeetles"
      // 6ac2: ldc2_w 10.0
      // 6ac5: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6ac8: aload 9
      // 6aca: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6acd: ldc_w "greenbeetles"
      // 6ad0: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6ad3: ldc2_w 10.0
      // 6ad6: dcmpl
      // 6ad7: ifle 6ae8
      // 6ada: aload 9
      // 6adc: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6adf: ldc_w "greenbeetles"
      // 6ae2: ldc2_w 10.0
      // 6ae5: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6ae8: aload 9
      // 6aea: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6aed: ldc_w "ggbeetles"
      // 6af0: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6af3: ldc2_w 10.0
      // 6af6: dcmpl
      // 6af7: ifle 6b08
      // 6afa: aload 9
      // 6afc: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6aff: ldc_w "ggbeetles"
      // 6b02: ldc2_w 10.0
      // 6b05: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6b08: aload 9
      // 6b0a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b0d: ldc_w "irbeetles"
      // 6b10: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6b13: ldc2_w 10.0
      // 6b16: dcmpl
      // 6b17: ifle 6b28
      // 6b1a: aload 9
      // 6b1c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b1f: ldc_w "irbeetles"
      // 6b22: ldc2_w 10.0
      // 6b25: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6b28: aload 9
      // 6b2a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b2d: ldc_w "purplebeetles"
      // 6b30: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6b33: ldc2_w 10.0
      // 6b36: dcmpl
      // 6b37: ifle 6b48
      // 6b3a: aload 9
      // 6b3c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b3f: ldc_w "purplebeetles"
      // 6b42: ldc2_w 10.0
      // 6b45: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6b48: aload 9
      // 6b4a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b4d: ldc_w "goldbeetles"
      // 6b50: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6b53: ldc2_w 10.0
      // 6b56: dcmpl
      // 6b57: ifle 6b68
      // 6b5a: aload 9
      // 6b5c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b5f: ldc_w "goldbeetles"
      // 6b62: ldc2_w 10.0
      // 6b65: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6b68: aload 9
      // 6b6a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b6d: ldc_w "brownbeetles"
      // 6b70: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6b73: dconst_0
      // 6b74: dcmpl
      // 6b75: ifle 6d59
      // 6b78: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6b7b: aload 9
      // 6b7d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b80: ldc_w "brownbeetles"
      // 6b83: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6b86: d2i
      // 6b87: bipush 10
      // 6b89: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6b8c: bipush 10
      // 6b8e: if_icmpne 6d59
      // 6b91: aload 1
      // 6b92: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6b95: new net/minecraft/world/phys/Vec3
      // 6b98: dup
      // 6b99: dload 2
      // 6b9a: dload 4
      // 6b9c: dload 6
      // 6b9e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6ba1: ldc2_w 25.0
      // 6ba4: ldc2_w 25.0
      // 6ba7: ldc2_w 25.0
      // 6baa: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6bad: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$84 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6bb2: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6bb7: invokeinterface java/util/List.isEmpty ()Z 1
      // 6bbc: ifne 6ce5
      // 6bbf: aload 1
      // 6bc0: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6bc3: new net/minecraft/world/phys/Vec3
      // 6bc6: dup
      // 6bc7: dload 2
      // 6bc8: dload 4
      // 6bca: dload 6
      // 6bcc: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6bcf: ldc2_w 25.0
      // 6bd2: ldc2_w 25.0
      // 6bd5: ldc2_w 25.0
      // 6bd8: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6bdb: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$85 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6be0: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6be5: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 6bea: new net/arphex/procedures/DwellerLifestealProcedure$22
      // 6bed: dup
      // 6bee: invokespecial net/arphex/procedures/DwellerLifestealProcedure$22.<init> ()V
      // 6bf1: dload 2
      // 6bf2: dload 4
      // 6bf4: dload 6
      // 6bf6: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$22.compareDistOf (DDD)Ljava/util/Comparator;
      // 6bf9: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 6bfe: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 6c03: aconst_null
      // 6c04: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 6c07: checkcast net/minecraft/world/entity/Entity
      // 6c0a: astore 47
      // 6c0c: aload 47
      // 6c0e: instanceof net/minecraft/world/entity/TamableAnimal
      // 6c11: ifeq 6c91
      // 6c14: aload 47
      // 6c16: checkcast net/minecraft/world/entity/TamableAnimal
      // 6c19: astore 45
      // 6c1b: aload 9
      // 6c1d: instanceof net/minecraft/world/entity/LivingEntity
      // 6c20: ifeq 6c91
      // 6c23: aload 9
      // 6c25: checkcast net/minecraft/world/entity/LivingEntity
      // 6c28: astore 46
      // 6c2a: aload 45
      // 6c2c: aload 46
      // 6c2e: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 6c31: ifeq 6c91
      // 6c34: aload 1
      // 6c35: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6c38: new net/minecraft/world/phys/Vec3
      // 6c3b: dup
      // 6c3c: dload 2
      // 6c3d: dload 4
      // 6c3f: dload 6
      // 6c41: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6c44: ldc2_w 25.0
      // 6c47: ldc2_w 25.0
      // 6c4a: ldc2_w 25.0
      // 6c4d: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6c50: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$86 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6c55: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6c5a: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 6c5f: new net/arphex/procedures/DwellerLifestealProcedure$23
      // 6c62: dup
      // 6c63: invokespecial net/arphex/procedures/DwellerLifestealProcedure$23.<init> ()V
      // 6c66: dload 2
      // 6c67: dload 4
      // 6c69: dload 6
      // 6c6b: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$23.compareDistOf (DDD)Ljava/util/Comparator;
      // 6c6e: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 6c73: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 6c78: aconst_null
      // 6c79: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 6c7c: checkcast net/minecraft/world/entity/Entity
      // 6c7f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6c82: ldc_w "scarab"
      // 6c85: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 6c88: ldc_w "brown"
      // 6c8b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 6c8e: ifne 6d59
      // 6c91: aload 9
      // 6c93: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6c96: ldc_w "justsummonedbrown"
      // 6c99: bipush 1
      // 6c9a: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 6c9d: aload 1
      // 6c9e: instanceof net/minecraft/server/level/ServerLevel
      // 6ca1: ifeq 6ce2
      // 6ca4: aload 1
      // 6ca5: checkcast net/minecraft/server/level/ServerLevel
      // 6ca8: astore 47
      // 6caa: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 6cad: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6cb0: checkcast net/minecraft/world/entity/EntityType
      // 6cb3: aload 47
      // 6cb5: dload 2
      // 6cb6: dload 4
      // 6cb8: dload 6
      // 6cba: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 6cbd: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 6cc0: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 6cc3: astore 48
      // 6cc5: aload 48
      // 6cc7: ifnull 6ce2
      // 6cca: aload 48
      // 6ccc: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6ccf: bipush -1
      // 6cd0: bipush 1
      // 6cd1: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6cd4: i2d
      // 6cd5: dconst_0
      // 6cd6: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6cd9: bipush -1
      // 6cda: bipush 1
      // 6cdb: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6cde: i2d
      // 6cdf: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 6ce2: goto 6d59
      // 6ce5: aload 9
      // 6ce7: instanceof net/minecraft/world/entity/player/Player
      // 6cea: ifeq 6d08
      // 6ced: aload 9
      // 6cef: checkcast net/minecraft/world/entity/player/Player
      // 6cf2: astore 45
      // 6cf4: aload 45
      // 6cf6: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 6cf9: getstatic net/arphex/init/ArphexModItems.SEALED_BROWN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 6cfc: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6cff: checkcast net/minecraft/world/item/Item
      // 6d02: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 6d05: ifne 6d59
      // 6d08: aload 9
      // 6d0a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6d0d: ldc_w "justsummonedbrown"
      // 6d10: bipush 1
      // 6d11: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 6d14: aload 1
      // 6d15: instanceof net/minecraft/server/level/ServerLevel
      // 6d18: ifeq 6d59
      // 6d1b: aload 1
      // 6d1c: checkcast net/minecraft/server/level/ServerLevel
      // 6d1f: astore 46
      // 6d21: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 6d24: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6d27: checkcast net/minecraft/world/entity/EntityType
      // 6d2a: aload 46
      // 6d2c: dload 2
      // 6d2d: dload 4
      // 6d2f: dload 6
      // 6d31: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 6d34: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 6d37: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 6d3a: astore 47
      // 6d3c: aload 47
      // 6d3e: ifnull 6d59
      // 6d41: aload 47
      // 6d43: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6d46: bipush -1
      // 6d47: bipush 1
      // 6d48: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6d4b: i2d
      // 6d4c: dconst_0
      // 6d4d: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6d50: bipush -1
      // 6d51: bipush 1
      // 6d52: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6d55: i2d
      // 6d56: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 6d59: aload 9
      // 6d5b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6d5e: ldc_w "greenbeetles"
      // 6d61: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6d64: dconst_0
      // 6d65: dcmpl
      // 6d66: ifle 6f4a
      // 6d69: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6d6c: aload 9
      // 6d6e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6d71: ldc_w "greenbeetles"
      // 6d74: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6d77: d2i
      // 6d78: bipush 10
      // 6d7a: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6d7d: bipush 10
      // 6d7f: if_icmpne 6f4a
      // 6d82: aload 1
      // 6d83: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6d86: new net/minecraft/world/phys/Vec3
      // 6d89: dup
      // 6d8a: dload 2
      // 6d8b: dload 4
      // 6d8d: dload 6
      // 6d8f: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6d92: ldc2_w 25.0
      // 6d95: ldc2_w 25.0
      // 6d98: ldc2_w 25.0
      // 6d9b: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6d9e: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$87 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6da3: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6da8: invokeinterface java/util/List.isEmpty ()Z 1
      // 6dad: ifne 6ed6
      // 6db0: aload 1
      // 6db1: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6db4: new net/minecraft/world/phys/Vec3
      // 6db7: dup
      // 6db8: dload 2
      // 6db9: dload 4
      // 6dbb: dload 6
      // 6dbd: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6dc0: ldc2_w 25.0
      // 6dc3: ldc2_w 25.0
      // 6dc6: ldc2_w 25.0
      // 6dc9: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6dcc: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$88 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6dd1: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6dd6: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 6ddb: new net/arphex/procedures/DwellerLifestealProcedure$24
      // 6dde: dup
      // 6ddf: invokespecial net/arphex/procedures/DwellerLifestealProcedure$24.<init> ()V
      // 6de2: dload 2
      // 6de3: dload 4
      // 6de5: dload 6
      // 6de7: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$24.compareDistOf (DDD)Ljava/util/Comparator;
      // 6dea: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 6def: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 6df4: aconst_null
      // 6df5: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 6df8: checkcast net/minecraft/world/entity/Entity
      // 6dfb: astore 47
      // 6dfd: aload 47
      // 6dff: instanceof net/minecraft/world/entity/TamableAnimal
      // 6e02: ifeq 6e82
      // 6e05: aload 47
      // 6e07: checkcast net/minecraft/world/entity/TamableAnimal
      // 6e0a: astore 45
      // 6e0c: aload 9
      // 6e0e: instanceof net/minecraft/world/entity/LivingEntity
      // 6e11: ifeq 6e82
      // 6e14: aload 9
      // 6e16: checkcast net/minecraft/world/entity/LivingEntity
      // 6e19: astore 46
      // 6e1b: aload 45
      // 6e1d: aload 46
      // 6e1f: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 6e22: ifeq 6e82
      // 6e25: aload 1
      // 6e26: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6e29: new net/minecraft/world/phys/Vec3
      // 6e2c: dup
      // 6e2d: dload 2
      // 6e2e: dload 4
      // 6e30: dload 6
      // 6e32: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6e35: ldc2_w 25.0
      // 6e38: ldc2_w 25.0
      // 6e3b: ldc2_w 25.0
      // 6e3e: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6e41: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$89 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6e46: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6e4b: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 6e50: new net/arphex/procedures/DwellerLifestealProcedure$25
      // 6e53: dup
      // 6e54: invokespecial net/arphex/procedures/DwellerLifestealProcedure$25.<init> ()V
      // 6e57: dload 2
      // 6e58: dload 4
      // 6e5a: dload 6
      // 6e5c: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$25.compareDistOf (DDD)Ljava/util/Comparator;
      // 6e5f: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 6e64: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 6e69: aconst_null
      // 6e6a: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 6e6d: checkcast net/minecraft/world/entity/Entity
      // 6e70: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6e73: ldc_w "scarab"
      // 6e76: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 6e79: ldc_w "green"
      // 6e7c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 6e7f: ifne 6f4a
      // 6e82: aload 9
      // 6e84: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6e87: ldc_w "justsummonedgreen"
      // 6e8a: bipush 1
      // 6e8b: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 6e8e: aload 1
      // 6e8f: instanceof net/minecraft/server/level/ServerLevel
      // 6e92: ifeq 6ed3
      // 6e95: aload 1
      // 6e96: checkcast net/minecraft/server/level/ServerLevel
      // 6e99: astore 47
      // 6e9b: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 6e9e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6ea1: checkcast net/minecraft/world/entity/EntityType
      // 6ea4: aload 47
      // 6ea6: dload 2
      // 6ea7: dload 4
      // 6ea9: dload 6
      // 6eab: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 6eae: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 6eb1: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 6eb4: astore 48
      // 6eb6: aload 48
      // 6eb8: ifnull 6ed3
      // 6ebb: aload 48
      // 6ebd: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6ec0: bipush -1
      // 6ec1: bipush 1
      // 6ec2: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6ec5: i2d
      // 6ec6: dconst_0
      // 6ec7: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6eca: bipush -1
      // 6ecb: bipush 1
      // 6ecc: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6ecf: i2d
      // 6ed0: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 6ed3: goto 6f4a
      // 6ed6: aload 9
      // 6ed8: instanceof net/minecraft/world/entity/player/Player
      // 6edb: ifeq 6ef9
      // 6ede: aload 9
      // 6ee0: checkcast net/minecraft/world/entity/player/Player
      // 6ee3: astore 45
      // 6ee5: aload 45
      // 6ee7: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 6eea: getstatic net/arphex/init/ArphexModItems.SEALED_GREEN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 6eed: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6ef0: checkcast net/minecraft/world/item/Item
      // 6ef3: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 6ef6: ifne 6f4a
      // 6ef9: aload 9
      // 6efb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6efe: ldc_w "justsummonedgreen"
      // 6f01: bipush 1
      // 6f02: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 6f05: aload 1
      // 6f06: instanceof net/minecraft/server/level/ServerLevel
      // 6f09: ifeq 6f4a
      // 6f0c: aload 1
      // 6f0d: checkcast net/minecraft/server/level/ServerLevel
      // 6f10: astore 46
      // 6f12: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 6f15: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6f18: checkcast net/minecraft/world/entity/EntityType
      // 6f1b: aload 46
      // 6f1d: dload 2
      // 6f1e: dload 4
      // 6f20: dload 6
      // 6f22: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 6f25: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 6f28: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 6f2b: astore 47
      // 6f2d: aload 47
      // 6f2f: ifnull 6f4a
      // 6f32: aload 47
      // 6f34: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6f37: bipush -1
      // 6f38: bipush 1
      // 6f39: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6f3c: i2d
      // 6f3d: dconst_0
      // 6f3e: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6f41: bipush -1
      // 6f42: bipush 1
      // 6f43: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6f46: i2d
      // 6f47: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 6f4a: aload 9
      // 6f4c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6f4f: ldc_w "ggbeetles"
      // 6f52: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6f55: dconst_0
      // 6f56: dcmpl
      // 6f57: ifle 713b
      // 6f5a: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6f5d: aload 9
      // 6f5f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6f62: ldc_w "ggbeetles"
      // 6f65: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6f68: d2i
      // 6f69: bipush 10
      // 6f6b: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 6f6e: bipush 10
      // 6f70: if_icmpne 713b
      // 6f73: aload 1
      // 6f74: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6f77: new net/minecraft/world/phys/Vec3
      // 6f7a: dup
      // 6f7b: dload 2
      // 6f7c: dload 4
      // 6f7e: dload 6
      // 6f80: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6f83: ldc2_w 25.0
      // 6f86: ldc2_w 25.0
      // 6f89: ldc2_w 25.0
      // 6f8c: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6f8f: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$90 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6f94: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6f99: invokeinterface java/util/List.isEmpty ()Z 1
      // 6f9e: ifne 70c7
      // 6fa1: aload 1
      // 6fa2: ldc_w net/arphex/entity/ScarabSummonEntity
      // 6fa5: new net/minecraft/world/phys/Vec3
      // 6fa8: dup
      // 6fa9: dload 2
      // 6faa: dload 4
      // 6fac: dload 6
      // 6fae: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 6fb1: ldc2_w 25.0
      // 6fb4: ldc2_w 25.0
      // 6fb7: ldc2_w 25.0
      // 6fba: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 6fbd: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$91 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 6fc2: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 6fc7: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 6fcc: new net/arphex/procedures/DwellerLifestealProcedure$26
      // 6fcf: dup
      // 6fd0: invokespecial net/arphex/procedures/DwellerLifestealProcedure$26.<init> ()V
      // 6fd3: dload 2
      // 6fd4: dload 4
      // 6fd6: dload 6
      // 6fd8: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$26.compareDistOf (DDD)Ljava/util/Comparator;
      // 6fdb: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 6fe0: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 6fe5: aconst_null
      // 6fe6: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 6fe9: checkcast net/minecraft/world/entity/Entity
      // 6fec: astore 47
      // 6fee: aload 47
      // 6ff0: instanceof net/minecraft/world/entity/TamableAnimal
      // 6ff3: ifeq 7073
      // 6ff6: aload 47
      // 6ff8: checkcast net/minecraft/world/entity/TamableAnimal
      // 6ffb: astore 45
      // 6ffd: aload 9
      // 6fff: instanceof net/minecraft/world/entity/LivingEntity
      // 7002: ifeq 7073
      // 7005: aload 9
      // 7007: checkcast net/minecraft/world/entity/LivingEntity
      // 700a: astore 46
      // 700c: aload 45
      // 700e: aload 46
      // 7010: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 7013: ifeq 7073
      // 7016: aload 1
      // 7017: ldc_w net/arphex/entity/ScarabSummonEntity
      // 701a: new net/minecraft/world/phys/Vec3
      // 701d: dup
      // 701e: dload 2
      // 701f: dload 4
      // 7021: dload 6
      // 7023: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7026: ldc2_w 25.0
      // 7029: ldc2_w 25.0
      // 702c: ldc2_w 25.0
      // 702f: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7032: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$92 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 7037: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 703c: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 7041: new net/arphex/procedures/DwellerLifestealProcedure$27
      // 7044: dup
      // 7045: invokespecial net/arphex/procedures/DwellerLifestealProcedure$27.<init> ()V
      // 7048: dload 2
      // 7049: dload 4
      // 704b: dload 6
      // 704d: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$27.compareDistOf (DDD)Ljava/util/Comparator;
      // 7050: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 7055: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 705a: aconst_null
      // 705b: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 705e: checkcast net/minecraft/world/entity/Entity
      // 7061: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7064: ldc_w "scarab"
      // 7067: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 706a: ldc_w "greengold"
      // 706d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7070: ifne 713b
      // 7073: aload 9
      // 7075: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7078: ldc_w "justsummonedgreengold"
      // 707b: bipush 1
      // 707c: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 707f: aload 1
      // 7080: instanceof net/minecraft/server/level/ServerLevel
      // 7083: ifeq 70c4
      // 7086: aload 1
      // 7087: checkcast net/minecraft/server/level/ServerLevel
      // 708a: astore 47
      // 708c: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 708f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7092: checkcast net/minecraft/world/entity/EntityType
      // 7095: aload 47
      // 7097: dload 2
      // 7098: dload 4
      // 709a: dload 6
      // 709c: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 709f: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 70a2: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 70a5: astore 48
      // 70a7: aload 48
      // 70a9: ifnull 70c4
      // 70ac: aload 48
      // 70ae: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 70b1: bipush -1
      // 70b2: bipush 1
      // 70b3: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 70b6: i2d
      // 70b7: dconst_0
      // 70b8: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 70bb: bipush -1
      // 70bc: bipush 1
      // 70bd: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 70c0: i2d
      // 70c1: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 70c4: goto 713b
      // 70c7: aload 9
      // 70c9: instanceof net/minecraft/world/entity/player/Player
      // 70cc: ifeq 70ea
      // 70cf: aload 9
      // 70d1: checkcast net/minecraft/world/entity/player/Player
      // 70d4: astore 45
      // 70d6: aload 45
      // 70d8: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 70db: getstatic net/arphex/init/ArphexModItems.SEALED_GREEN_GOLD_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 70de: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 70e1: checkcast net/minecraft/world/item/Item
      // 70e4: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 70e7: ifne 713b
      // 70ea: aload 9
      // 70ec: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 70ef: ldc_w "justsummonedgreengold"
      // 70f2: bipush 1
      // 70f3: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 70f6: aload 1
      // 70f7: instanceof net/minecraft/server/level/ServerLevel
      // 70fa: ifeq 713b
      // 70fd: aload 1
      // 70fe: checkcast net/minecraft/server/level/ServerLevel
      // 7101: astore 46
      // 7103: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 7106: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7109: checkcast net/minecraft/world/entity/EntityType
      // 710c: aload 46
      // 710e: dload 2
      // 710f: dload 4
      // 7111: dload 6
      // 7113: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 7116: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 7119: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 711c: astore 47
      // 711e: aload 47
      // 7120: ifnull 713b
      // 7123: aload 47
      // 7125: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7128: bipush -1
      // 7129: bipush 1
      // 712a: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 712d: i2d
      // 712e: dconst_0
      // 712f: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7132: bipush -1
      // 7133: bipush 1
      // 7134: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7137: i2d
      // 7138: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 713b: aload 9
      // 713d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7140: ldc_w "irbeetles"
      // 7143: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7146: dconst_0
      // 7147: dcmpl
      // 7148: ifle 732c
      // 714b: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 714e: aload 9
      // 7150: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7153: ldc_w "irbeetles"
      // 7156: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7159: d2i
      // 715a: bipush 10
      // 715c: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 715f: bipush 10
      // 7161: if_icmpne 732c
      // 7164: aload 1
      // 7165: ldc_w net/arphex/entity/ScarabSummonEntity
      // 7168: new net/minecraft/world/phys/Vec3
      // 716b: dup
      // 716c: dload 2
      // 716d: dload 4
      // 716f: dload 6
      // 7171: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7174: ldc2_w 25.0
      // 7177: ldc2_w 25.0
      // 717a: ldc2_w 25.0
      // 717d: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7180: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$93 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 7185: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 718a: invokeinterface java/util/List.isEmpty ()Z 1
      // 718f: ifne 72b8
      // 7192: aload 1
      // 7193: ldc_w net/arphex/entity/ScarabSummonEntity
      // 7196: new net/minecraft/world/phys/Vec3
      // 7199: dup
      // 719a: dload 2
      // 719b: dload 4
      // 719d: dload 6
      // 719f: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 71a2: ldc2_w 25.0
      // 71a5: ldc2_w 25.0
      // 71a8: ldc2_w 25.0
      // 71ab: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 71ae: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$94 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 71b3: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 71b8: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 71bd: new net/arphex/procedures/DwellerLifestealProcedure$28
      // 71c0: dup
      // 71c1: invokespecial net/arphex/procedures/DwellerLifestealProcedure$28.<init> ()V
      // 71c4: dload 2
      // 71c5: dload 4
      // 71c7: dload 6
      // 71c9: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$28.compareDistOf (DDD)Ljava/util/Comparator;
      // 71cc: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 71d1: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 71d6: aconst_null
      // 71d7: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 71da: checkcast net/minecraft/world/entity/Entity
      // 71dd: astore 47
      // 71df: aload 47
      // 71e1: instanceof net/minecraft/world/entity/TamableAnimal
      // 71e4: ifeq 7264
      // 71e7: aload 47
      // 71e9: checkcast net/minecraft/world/entity/TamableAnimal
      // 71ec: astore 45
      // 71ee: aload 9
      // 71f0: instanceof net/minecraft/world/entity/LivingEntity
      // 71f3: ifeq 7264
      // 71f6: aload 9
      // 71f8: checkcast net/minecraft/world/entity/LivingEntity
      // 71fb: astore 46
      // 71fd: aload 45
      // 71ff: aload 46
      // 7201: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 7204: ifeq 7264
      // 7207: aload 1
      // 7208: ldc_w net/arphex/entity/ScarabSummonEntity
      // 720b: new net/minecraft/world/phys/Vec3
      // 720e: dup
      // 720f: dload 2
      // 7210: dload 4
      // 7212: dload 6
      // 7214: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7217: ldc2_w 25.0
      // 721a: ldc2_w 25.0
      // 721d: ldc2_w 25.0
      // 7220: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7223: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$95 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 7228: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 722d: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 7232: new net/arphex/procedures/DwellerLifestealProcedure$29
      // 7235: dup
      // 7236: invokespecial net/arphex/procedures/DwellerLifestealProcedure$29.<init> ()V
      // 7239: dload 2
      // 723a: dload 4
      // 723c: dload 6
      // 723e: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$29.compareDistOf (DDD)Ljava/util/Comparator;
      // 7241: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 7246: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 724b: aconst_null
      // 724c: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 724f: checkcast net/minecraft/world/entity/Entity
      // 7252: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7255: ldc_w "scarab"
      // 7258: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 725b: ldc_w "iridescent"
      // 725e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7261: ifne 732c
      // 7264: aload 9
      // 7266: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7269: ldc_w "justsummonediridescent"
      // 726c: bipush 1
      // 726d: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 7270: aload 1
      // 7271: instanceof net/minecraft/server/level/ServerLevel
      // 7274: ifeq 72b5
      // 7277: aload 1
      // 7278: checkcast net/minecraft/server/level/ServerLevel
      // 727b: astore 47
      // 727d: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 7280: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7283: checkcast net/minecraft/world/entity/EntityType
      // 7286: aload 47
      // 7288: dload 2
      // 7289: dload 4
      // 728b: dload 6
      // 728d: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 7290: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 7293: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 7296: astore 48
      // 7298: aload 48
      // 729a: ifnull 72b5
      // 729d: aload 48
      // 729f: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 72a2: bipush -1
      // 72a3: bipush 1
      // 72a4: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 72a7: i2d
      // 72a8: dconst_0
      // 72a9: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 72ac: bipush -1
      // 72ad: bipush 1
      // 72ae: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 72b1: i2d
      // 72b2: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 72b5: goto 732c
      // 72b8: aload 9
      // 72ba: instanceof net/minecraft/world/entity/player/Player
      // 72bd: ifeq 72db
      // 72c0: aload 9
      // 72c2: checkcast net/minecraft/world/entity/player/Player
      // 72c5: astore 45
      // 72c7: aload 45
      // 72c9: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 72cc: getstatic net/arphex/init/ArphexModItems.SEALED_IRIDESCENT_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 72cf: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 72d2: checkcast net/minecraft/world/item/Item
      // 72d5: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 72d8: ifne 732c
      // 72db: aload 9
      // 72dd: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 72e0: ldc_w "justsummonediridescent"
      // 72e3: bipush 1
      // 72e4: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 72e7: aload 1
      // 72e8: instanceof net/minecraft/server/level/ServerLevel
      // 72eb: ifeq 732c
      // 72ee: aload 1
      // 72ef: checkcast net/minecraft/server/level/ServerLevel
      // 72f2: astore 46
      // 72f4: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 72f7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 72fa: checkcast net/minecraft/world/entity/EntityType
      // 72fd: aload 46
      // 72ff: dload 2
      // 7300: dload 4
      // 7302: dload 6
      // 7304: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 7307: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 730a: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 730d: astore 47
      // 730f: aload 47
      // 7311: ifnull 732c
      // 7314: aload 47
      // 7316: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7319: bipush -1
      // 731a: bipush 1
      // 731b: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 731e: i2d
      // 731f: dconst_0
      // 7320: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7323: bipush -1
      // 7324: bipush 1
      // 7325: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7328: i2d
      // 7329: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 732c: aload 9
      // 732e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7331: ldc_w "purplebeetles"
      // 7334: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7337: dconst_0
      // 7338: dcmpl
      // 7339: ifle 751d
      // 733c: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 733f: aload 9
      // 7341: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7344: ldc_w "purplebeetles"
      // 7347: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 734a: d2i
      // 734b: bipush 10
      // 734d: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7350: bipush 10
      // 7352: if_icmpne 751d
      // 7355: aload 1
      // 7356: ldc_w net/arphex/entity/ScarabSummonEntity
      // 7359: new net/minecraft/world/phys/Vec3
      // 735c: dup
      // 735d: dload 2
      // 735e: dload 4
      // 7360: dload 6
      // 7362: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7365: ldc2_w 25.0
      // 7368: ldc2_w 25.0
      // 736b: ldc2_w 25.0
      // 736e: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7371: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$96 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 7376: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 737b: invokeinterface java/util/List.isEmpty ()Z 1
      // 7380: ifne 74a9
      // 7383: aload 1
      // 7384: ldc_w net/arphex/entity/ScarabSummonEntity
      // 7387: new net/minecraft/world/phys/Vec3
      // 738a: dup
      // 738b: dload 2
      // 738c: dload 4
      // 738e: dload 6
      // 7390: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7393: ldc2_w 25.0
      // 7396: ldc2_w 25.0
      // 7399: ldc2_w 25.0
      // 739c: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 739f: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$97 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 73a4: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 73a9: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 73ae: new net/arphex/procedures/DwellerLifestealProcedure$30
      // 73b1: dup
      // 73b2: invokespecial net/arphex/procedures/DwellerLifestealProcedure$30.<init> ()V
      // 73b5: dload 2
      // 73b6: dload 4
      // 73b8: dload 6
      // 73ba: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$30.compareDistOf (DDD)Ljava/util/Comparator;
      // 73bd: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 73c2: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 73c7: aconst_null
      // 73c8: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 73cb: checkcast net/minecraft/world/entity/Entity
      // 73ce: astore 47
      // 73d0: aload 47
      // 73d2: instanceof net/minecraft/world/entity/TamableAnimal
      // 73d5: ifeq 7455
      // 73d8: aload 47
      // 73da: checkcast net/minecraft/world/entity/TamableAnimal
      // 73dd: astore 45
      // 73df: aload 9
      // 73e1: instanceof net/minecraft/world/entity/LivingEntity
      // 73e4: ifeq 7455
      // 73e7: aload 9
      // 73e9: checkcast net/minecraft/world/entity/LivingEntity
      // 73ec: astore 46
      // 73ee: aload 45
      // 73f0: aload 46
      // 73f2: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 73f5: ifeq 7455
      // 73f8: aload 1
      // 73f9: ldc_w net/arphex/entity/ScarabSummonEntity
      // 73fc: new net/minecraft/world/phys/Vec3
      // 73ff: dup
      // 7400: dload 2
      // 7401: dload 4
      // 7403: dload 6
      // 7405: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7408: ldc2_w 25.0
      // 740b: ldc2_w 25.0
      // 740e: ldc2_w 25.0
      // 7411: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7414: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$98 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 7419: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 741e: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 7423: new net/arphex/procedures/DwellerLifestealProcedure$31
      // 7426: dup
      // 7427: invokespecial net/arphex/procedures/DwellerLifestealProcedure$31.<init> ()V
      // 742a: dload 2
      // 742b: dload 4
      // 742d: dload 6
      // 742f: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$31.compareDistOf (DDD)Ljava/util/Comparator;
      // 7432: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 7437: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 743c: aconst_null
      // 743d: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 7440: checkcast net/minecraft/world/entity/Entity
      // 7443: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7446: ldc_w "scarab"
      // 7449: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 744c: ldc_w "purple"
      // 744f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7452: ifne 751d
      // 7455: aload 9
      // 7457: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 745a: ldc_w "justsummonedpurple"
      // 745d: bipush 1
      // 745e: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 7461: aload 1
      // 7462: instanceof net/minecraft/server/level/ServerLevel
      // 7465: ifeq 74a6
      // 7468: aload 1
      // 7469: checkcast net/minecraft/server/level/ServerLevel
      // 746c: astore 47
      // 746e: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 7471: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7474: checkcast net/minecraft/world/entity/EntityType
      // 7477: aload 47
      // 7479: dload 2
      // 747a: dload 4
      // 747c: dload 6
      // 747e: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 7481: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 7484: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 7487: astore 48
      // 7489: aload 48
      // 748b: ifnull 74a6
      // 748e: aload 48
      // 7490: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7493: bipush -1
      // 7494: bipush 1
      // 7495: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7498: i2d
      // 7499: dconst_0
      // 749a: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 749d: bipush -1
      // 749e: bipush 1
      // 749f: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 74a2: i2d
      // 74a3: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 74a6: goto 751d
      // 74a9: aload 9
      // 74ab: instanceof net/minecraft/world/entity/player/Player
      // 74ae: ifeq 74cc
      // 74b1: aload 9
      // 74b3: checkcast net/minecraft/world/entity/player/Player
      // 74b6: astore 45
      // 74b8: aload 45
      // 74ba: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 74bd: getstatic net/arphex/init/ArphexModItems.SEALED_PURPLE_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 74c0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 74c3: checkcast net/minecraft/world/item/Item
      // 74c6: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 74c9: ifne 751d
      // 74cc: aload 9
      // 74ce: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 74d1: ldc_w "justsummonedpurple"
      // 74d4: bipush 1
      // 74d5: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 74d8: aload 1
      // 74d9: instanceof net/minecraft/server/level/ServerLevel
      // 74dc: ifeq 751d
      // 74df: aload 1
      // 74e0: checkcast net/minecraft/server/level/ServerLevel
      // 74e3: astore 46
      // 74e5: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 74e8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 74eb: checkcast net/minecraft/world/entity/EntityType
      // 74ee: aload 46
      // 74f0: dload 2
      // 74f1: dload 4
      // 74f3: dload 6
      // 74f5: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 74f8: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 74fb: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 74fe: astore 47
      // 7500: aload 47
      // 7502: ifnull 751d
      // 7505: aload 47
      // 7507: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 750a: bipush -1
      // 750b: bipush 1
      // 750c: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 750f: i2d
      // 7510: dconst_0
      // 7511: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7514: bipush -1
      // 7515: bipush 1
      // 7516: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7519: i2d
      // 751a: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 751d: aload 9
      // 751f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7522: ldc_w "goldbeetles"
      // 7525: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7528: dconst_0
      // 7529: dcmpl
      // 752a: ifle 7711
      // 752d: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7530: aload 9
      // 7532: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7535: ldc_w "goldbeetles"
      // 7538: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 753b: invokestatic java/lang/Math.round (D)J
      // 753e: l2i
      // 753f: bipush 10
      // 7541: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7544: bipush 10
      // 7546: if_icmpne 7711
      // 7549: aload 1
      // 754a: ldc_w net/arphex/entity/ScarabSummonEntity
      // 754d: new net/minecraft/world/phys/Vec3
      // 7550: dup
      // 7551: dload 2
      // 7552: dload 4
      // 7554: dload 6
      // 7556: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7559: ldc2_w 25.0
      // 755c: ldc2_w 25.0
      // 755f: ldc2_w 25.0
      // 7562: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7565: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$99 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 756a: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 756f: invokeinterface java/util/List.isEmpty ()Z 1
      // 7574: ifne 769d
      // 7577: aload 1
      // 7578: ldc_w net/arphex/entity/ScarabSummonEntity
      // 757b: new net/minecraft/world/phys/Vec3
      // 757e: dup
      // 757f: dload 2
      // 7580: dload 4
      // 7582: dload 6
      // 7584: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7587: ldc2_w 25.0
      // 758a: ldc2_w 25.0
      // 758d: ldc2_w 25.0
      // 7590: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7593: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$100 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 7598: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 759d: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 75a2: new net/arphex/procedures/DwellerLifestealProcedure$32
      // 75a5: dup
      // 75a6: invokespecial net/arphex/procedures/DwellerLifestealProcedure$32.<init> ()V
      // 75a9: dload 2
      // 75aa: dload 4
      // 75ac: dload 6
      // 75ae: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$32.compareDistOf (DDD)Ljava/util/Comparator;
      // 75b1: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 75b6: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 75bb: aconst_null
      // 75bc: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 75bf: checkcast net/minecraft/world/entity/Entity
      // 75c2: astore 47
      // 75c4: aload 47
      // 75c6: instanceof net/minecraft/world/entity/TamableAnimal
      // 75c9: ifeq 7649
      // 75cc: aload 47
      // 75ce: checkcast net/minecraft/world/entity/TamableAnimal
      // 75d1: astore 45
      // 75d3: aload 9
      // 75d5: instanceof net/minecraft/world/entity/LivingEntity
      // 75d8: ifeq 7649
      // 75db: aload 9
      // 75dd: checkcast net/minecraft/world/entity/LivingEntity
      // 75e0: astore 46
      // 75e2: aload 45
      // 75e4: aload 46
      // 75e6: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 75e9: ifeq 7649
      // 75ec: aload 1
      // 75ed: ldc_w net/arphex/entity/ScarabSummonEntity
      // 75f0: new net/minecraft/world/phys/Vec3
      // 75f3: dup
      // 75f4: dload 2
      // 75f5: dload 4
      // 75f7: dload 6
      // 75f9: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 75fc: ldc2_w 25.0
      // 75ff: ldc2_w 25.0
      // 7602: ldc2_w 25.0
      // 7605: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 7608: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$101 (Lnet/arphex/entity/ScarabSummonEntity;)Z, (Lnet/arphex/entity/ScarabSummonEntity;)Z ]
      // 760d: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 7612: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 7617: new net/arphex/procedures/DwellerLifestealProcedure$33
      // 761a: dup
      // 761b: invokespecial net/arphex/procedures/DwellerLifestealProcedure$33.<init> ()V
      // 761e: dload 2
      // 761f: dload 4
      // 7621: dload 6
      // 7623: invokevirtual net/arphex/procedures/DwellerLifestealProcedure$33.compareDistOf (DDD)Ljava/util/Comparator;
      // 7626: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 762b: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 7630: aconst_null
      // 7631: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 7634: checkcast net/minecraft/world/entity/Entity
      // 7637: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 763a: ldc_w "scarab"
      // 763d: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7640: ldc_w "gold"
      // 7643: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7646: ifne 7711
      // 7649: aload 9
      // 764b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 764e: ldc_w "justsummonedgold"
      // 7651: bipush 1
      // 7652: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 7655: aload 1
      // 7656: instanceof net/minecraft/server/level/ServerLevel
      // 7659: ifeq 769a
      // 765c: aload 1
      // 765d: checkcast net/minecraft/server/level/ServerLevel
      // 7660: astore 47
      // 7662: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 7665: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7668: checkcast net/minecraft/world/entity/EntityType
      // 766b: aload 47
      // 766d: dload 2
      // 766e: dload 4
      // 7670: dload 6
      // 7672: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 7675: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 7678: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 767b: astore 48
      // 767d: aload 48
      // 767f: ifnull 769a
      // 7682: aload 48
      // 7684: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7687: bipush -1
      // 7688: bipush 1
      // 7689: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 768c: i2d
      // 768d: dconst_0
      // 768e: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7691: bipush -1
      // 7692: bipush 1
      // 7693: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7696: i2d
      // 7697: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 769a: goto 7711
      // 769d: aload 9
      // 769f: instanceof net/minecraft/world/entity/player/Player
      // 76a2: ifeq 76c0
      // 76a5: aload 9
      // 76a7: checkcast net/minecraft/world/entity/player/Player
      // 76aa: astore 45
      // 76ac: aload 45
      // 76ae: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 76b1: getstatic net/arphex/init/ArphexModItems.SEALED_GOLDEN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 76b4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 76b7: checkcast net/minecraft/world/item/Item
      // 76ba: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 76bd: ifne 7711
      // 76c0: aload 1
      // 76c1: instanceof net/minecraft/server/level/ServerLevel
      // 76c4: ifeq 7705
      // 76c7: aload 1
      // 76c8: checkcast net/minecraft/server/level/ServerLevel
      // 76cb: astore 46
      // 76cd: getstatic net/arphex/init/ArphexModEntities.SCARAB_SUMMON Lnet/minecraftforge/registries/RegistryObject;
      // 76d0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 76d3: checkcast net/minecraft/world/entity/EntityType
      // 76d6: aload 46
      // 76d8: dload 2
      // 76d9: dload 4
      // 76db: dload 6
      // 76dd: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 76e0: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 76e3: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 76e6: astore 47
      // 76e8: aload 47
      // 76ea: ifnull 7705
      // 76ed: aload 47
      // 76ef: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 76f2: bipush -1
      // 76f3: bipush 1
      // 76f4: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 76f7: i2d
      // 76f8: dconst_0
      // 76f9: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 76fc: bipush -1
      // 76fd: bipush 1
      // 76fe: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7701: i2d
      // 7702: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (DDD)V
      // 7705: aload 9
      // 7707: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 770a: ldc_w "justsummonedgold"
      // 770d: bipush 1
      // 770e: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 7711: dconst_0
      // 7712: aload 9
      // 7714: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7717: ldc_w "purplebeetles"
      // 771a: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 771d: aload 9
      // 771f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7722: ldc_w "goldbeetles"
      // 7725: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7728: dadd
      // 7729: aload 9
      // 772b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 772e: ldc_w "irbeetles"
      // 7731: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7734: dadd
      // 7735: aload 9
      // 7737: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 773a: ldc_w "ggbeetles"
      // 773d: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7740: dadd
      // 7741: aload 9
      // 7743: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7746: ldc_w "greenbeetles"
      // 7749: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 774c: dadd
      // 774d: aload 9
      // 774f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7752: ldc_w "brownbeetles"
      // 7755: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7758: dadd
      // 7759: dcmpg
      // 775a: ifge 7da7
      // 775d: aload 9
      // 775f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7762: ldc_w "highestscarab"
      // 7765: ldc_w "none"
      // 7768: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 776b: new net/minecraft/world/phys/Vec3
      // 776e: dup
      // 776f: dload 2
      // 7770: dload 4
      // 7772: dload 6
      // 7774: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7777: astore 45
      // 7779: aload 1
      // 777a: ldc net/minecraft/world/entity/Entity
      // 777c: new net/minecraft/world/phys/AABB
      // 777f: dup
      // 7780: aload 45
      // 7782: aload 45
      // 7784: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 7787: ldc2_w 12.5
      // 778a: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 778d: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$102 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 7792: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 7797: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 779c: aload 45
      // 779e: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$103 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 77a3: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 77a6: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 77ab: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 77b0: astore 46
      // 77b2: aload 46
      // 77b4: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 77b9: astore 47
      // 77bb: aload 47
      // 77bd: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 77c2: ifeq 7a0e
      // 77c5: aload 47
      // 77c7: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 77cc: checkcast net/minecraft/world/entity/Entity
      // 77cf: astore 48
      // 77d1: aload 48
      // 77d3: instanceof net/arphex/entity/ScarabSummonEntity
      // 77d6: ifeq 7a0b
      // 77d9: aload 48
      // 77db: instanceof net/minecraft/world/entity/TamableAnimal
      // 77de: ifeq 7a0b
      // 77e1: aload 48
      // 77e3: checkcast net/minecraft/world/entity/TamableAnimal
      // 77e6: astore 49
      // 77e8: aload 9
      // 77ea: instanceof net/minecraft/world/entity/LivingEntity
      // 77ed: ifeq 7a0b
      // 77f0: aload 9
      // 77f2: checkcast net/minecraft/world/entity/LivingEntity
      // 77f5: astore 50
      // 77f7: aload 49
      // 77f9: aload 50
      // 77fb: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 77fe: ifeq 7a0b
      // 7801: aload 48
      // 7803: instanceof net/arphex/entity/ScarabSummonEntity
      // 7806: ifeq 7821
      // 7809: aload 48
      // 780b: checkcast net/arphex/entity/ScarabSummonEntity
      // 780e: astore 51
      // 7810: aload 51
      // 7812: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7815: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7818: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 781b: checkcast java/lang/String
      // 781e: goto 7823
      // 7821: ldc ""
      // 7823: ldc_w "brown"
      // 7826: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7829: ifeq 784e
      // 782c: aload 9
      // 782e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7831: ldc_w "highestscarab"
      // 7834: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7837: ldc_w "none"
      // 783a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 783d: ifeq 784e
      // 7840: aload 9
      // 7842: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7845: ldc_w "highestscarab"
      // 7848: ldc_w "brown"
      // 784b: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 784e: aload 48
      // 7850: instanceof net/arphex/entity/ScarabSummonEntity
      // 7853: ifeq 786e
      // 7856: aload 48
      // 7858: checkcast net/arphex/entity/ScarabSummonEntity
      // 785b: astore 51
      // 785d: aload 51
      // 785f: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7862: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7865: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7868: checkcast java/lang/String
      // 786b: goto 7870
      // 786e: ldc ""
      // 7870: ldc_w "green"
      // 7873: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7876: ifeq 78af
      // 7879: aload 9
      // 787b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 787e: ldc_w "highestscarab"
      // 7881: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7884: ldc_w "brown"
      // 7887: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 788a: ifne 78a1
      // 788d: aload 9
      // 788f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7892: ldc_w "highestscarab"
      // 7895: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7898: ldc_w "none"
      // 789b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 789e: ifeq 78af
      // 78a1: aload 9
      // 78a3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 78a6: ldc_w "highestscarab"
      // 78a9: ldc_w "green"
      // 78ac: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 78af: aload 48
      // 78b1: instanceof net/arphex/entity/ScarabSummonEntity
      // 78b4: ifeq 78cf
      // 78b7: aload 48
      // 78b9: checkcast net/arphex/entity/ScarabSummonEntity
      // 78bc: astore 51
      // 78be: aload 51
      // 78c0: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 78c3: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 78c6: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 78c9: checkcast java/lang/String
      // 78cc: goto 78d1
      // 78cf: ldc ""
      // 78d1: ldc_w "greengold"
      // 78d4: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 78d7: ifeq 7924
      // 78da: aload 9
      // 78dc: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 78df: ldc_w "highestscarab"
      // 78e2: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 78e5: ldc_w "green"
      // 78e8: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 78eb: ifne 7916
      // 78ee: aload 9
      // 78f0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 78f3: ldc_w "highestscarab"
      // 78f6: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 78f9: ldc_w "brown"
      // 78fc: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 78ff: ifne 7916
      // 7902: aload 9
      // 7904: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7907: ldc_w "highestscarab"
      // 790a: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 790d: ldc_w "none"
      // 7910: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7913: ifeq 7924
      // 7916: aload 9
      // 7918: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 791b: ldc_w "highestscarab"
      // 791e: ldc_w "greengold"
      // 7921: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 7924: aload 48
      // 7926: instanceof net/arphex/entity/ScarabSummonEntity
      // 7929: ifeq 7944
      // 792c: aload 48
      // 792e: checkcast net/arphex/entity/ScarabSummonEntity
      // 7931: astore 51
      // 7933: aload 51
      // 7935: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7938: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 793b: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 793e: checkcast java/lang/String
      // 7941: goto 7946
      // 7944: ldc ""
      // 7946: ldc_w "iridescent"
      // 7949: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 794c: ifeq 7985
      // 794f: aload 9
      // 7951: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7954: ldc_w "highestscarab"
      // 7957: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 795a: ldc_w "purple"
      // 795d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7960: ifne 7985
      // 7963: aload 9
      // 7965: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7968: ldc_w "highestscarab"
      // 796b: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 796e: ldc_w "gold"
      // 7971: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7974: ifne 7985
      // 7977: aload 9
      // 7979: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 797c: ldc_w "highestscarab"
      // 797f: ldc_w "iridescent"
      // 7982: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 7985: aload 48
      // 7987: instanceof net/arphex/entity/ScarabSummonEntity
      // 798a: ifeq 79a5
      // 798d: aload 48
      // 798f: checkcast net/arphex/entity/ScarabSummonEntity
      // 7992: astore 51
      // 7994: aload 51
      // 7996: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7999: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 799c: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 799f: checkcast java/lang/String
      // 79a2: goto 79a7
      // 79a5: ldc ""
      // 79a7: ldc_w "purple"
      // 79aa: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 79ad: ifeq 79d2
      // 79b0: aload 9
      // 79b2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 79b5: ldc_w "highestscarab"
      // 79b8: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 79bb: ldc_w "gold"
      // 79be: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 79c1: ifne 79d2
      // 79c4: aload 9
      // 79c6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 79c9: ldc_w "highestscarab"
      // 79cc: ldc_w "purple"
      // 79cf: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 79d2: aload 48
      // 79d4: instanceof net/arphex/entity/ScarabSummonEntity
      // 79d7: ifeq 79f2
      // 79da: aload 48
      // 79dc: checkcast net/arphex/entity/ScarabSummonEntity
      // 79df: astore 51
      // 79e1: aload 51
      // 79e3: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 79e6: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 79e9: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 79ec: checkcast java/lang/String
      // 79ef: goto 79f4
      // 79f2: ldc ""
      // 79f4: ldc_w "gold"
      // 79f7: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 79fa: ifeq 7a0b
      // 79fd: aload 9
      // 79ff: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7a02: ldc_w "highestscarab"
      // 7a05: ldc_w "gold"
      // 7a08: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 7a0b: goto 77bb
      // 7a0e: new net/minecraft/world/phys/Vec3
      // 7a11: dup
      // 7a12: dload 2
      // 7a13: dload 4
      // 7a15: dload 6
      // 7a17: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7a1a: astore 45
      // 7a1c: aload 1
      // 7a1d: ldc net/minecraft/world/entity/Entity
      // 7a1f: new net/minecraft/world/phys/AABB
      // 7a22: dup
      // 7a23: aload 45
      // 7a25: aload 45
      // 7a27: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 7a2a: ldc2_w 12.5
      // 7a2d: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 7a30: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$104 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 7a35: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 7a3a: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 7a3f: aload 45
      // 7a41: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$105 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 7a46: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 7a49: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 7a4e: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 7a53: astore 46
      // 7a55: aload 46
      // 7a57: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 7a5c: astore 47
      // 7a5e: aload 47
      // 7a60: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 7a65: ifeq 7da7
      // 7a68: aload 47
      // 7a6a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 7a6f: checkcast net/minecraft/world/entity/Entity
      // 7a72: astore 48
      // 7a74: aload 48
      // 7a76: instanceof net/arphex/entity/ScarabSummonEntity
      // 7a79: ifeq 7da4
      // 7a7c: aload 48
      // 7a7e: instanceof net/minecraft/world/entity/TamableAnimal
      // 7a81: ifeq 7da4
      // 7a84: aload 48
      // 7a86: checkcast net/minecraft/world/entity/TamableAnimal
      // 7a89: astore 49
      // 7a8b: aload 9
      // 7a8d: instanceof net/minecraft/world/entity/LivingEntity
      // 7a90: ifeq 7da4
      // 7a93: aload 9
      // 7a95: checkcast net/minecraft/world/entity/LivingEntity
      // 7a98: astore 50
      // 7a9a: aload 49
      // 7a9c: aload 50
      // 7a9e: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 7aa1: ifeq 7da4
      // 7aa4: aload 9
      // 7aa6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7aa9: ldc_w "highestscarab"
      // 7aac: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7aaf: ldc_w "brown"
      // 7ab2: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7ab5: ifeq 7b24
      // 7ab8: aload 48
      // 7aba: instanceof net/arphex/entity/ScarabSummonEntity
      // 7abd: ifeq 7ad8
      // 7ac0: aload 48
      // 7ac2: checkcast net/arphex/entity/ScarabSummonEntity
      // 7ac5: astore 51
      // 7ac7: aload 51
      // 7ac9: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7acc: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7acf: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7ad2: checkcast java/lang/String
      // 7ad5: goto 7ada
      // 7ad8: ldc ""
      // 7ada: ldc_w "brown"
      // 7add: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7ae0: ifeq 7b24
      // 7ae3: aload 48
      // 7ae5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7ae8: ldc_w "despawnable"
      // 7aeb: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 7aee: ifeq 7b24
      // 7af1: aload 48
      // 7af3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7af6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7af9: ifne 7b01
      // 7afc: aload 48
      // 7afe: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 7b01: aload 9
      // 7b03: instanceof net/minecraft/world/entity/player/Player
      // 7b06: ifeq 7b24
      // 7b09: aload 9
      // 7b0b: checkcast net/minecraft/world/entity/player/Player
      // 7b0e: astore 52
      // 7b10: aload 52
      // 7b12: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 7b15: getstatic net/arphex/init/ArphexModItems.SEALED_BROWN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 7b18: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7b1b: checkcast net/minecraft/world/item/Item
      // 7b1e: sipush 200
      // 7b21: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 7b24: aload 9
      // 7b26: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7b29: ldc_w "highestscarab"
      // 7b2c: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7b2f: ldc_w "green"
      // 7b32: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7b35: ifeq 7ba4
      // 7b38: aload 48
      // 7b3a: instanceof net/arphex/entity/ScarabSummonEntity
      // 7b3d: ifeq 7b58
      // 7b40: aload 48
      // 7b42: checkcast net/arphex/entity/ScarabSummonEntity
      // 7b45: astore 51
      // 7b47: aload 51
      // 7b49: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7b4c: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7b4f: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7b52: checkcast java/lang/String
      // 7b55: goto 7b5a
      // 7b58: ldc ""
      // 7b5a: ldc_w "green"
      // 7b5d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7b60: ifeq 7ba4
      // 7b63: aload 48
      // 7b65: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7b68: ldc_w "despawnable"
      // 7b6b: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 7b6e: ifeq 7ba4
      // 7b71: aload 48
      // 7b73: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7b76: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7b79: ifne 7b81
      // 7b7c: aload 48
      // 7b7e: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 7b81: aload 9
      // 7b83: instanceof net/minecraft/world/entity/player/Player
      // 7b86: ifeq 7ba4
      // 7b89: aload 9
      // 7b8b: checkcast net/minecraft/world/entity/player/Player
      // 7b8e: astore 52
      // 7b90: aload 52
      // 7b92: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 7b95: getstatic net/arphex/init/ArphexModItems.SEALED_GREEN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 7b98: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7b9b: checkcast net/minecraft/world/item/Item
      // 7b9e: sipush 200
      // 7ba1: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 7ba4: aload 9
      // 7ba6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7ba9: ldc_w "highestscarab"
      // 7bac: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7baf: ldc_w "greengold"
      // 7bb2: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7bb5: ifeq 7c24
      // 7bb8: aload 48
      // 7bba: instanceof net/arphex/entity/ScarabSummonEntity
      // 7bbd: ifeq 7bd8
      // 7bc0: aload 48
      // 7bc2: checkcast net/arphex/entity/ScarabSummonEntity
      // 7bc5: astore 51
      // 7bc7: aload 51
      // 7bc9: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7bcc: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7bcf: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7bd2: checkcast java/lang/String
      // 7bd5: goto 7bda
      // 7bd8: ldc ""
      // 7bda: ldc_w "greengold"
      // 7bdd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7be0: ifeq 7c24
      // 7be3: aload 48
      // 7be5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7be8: ldc_w "despawnable"
      // 7beb: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 7bee: ifeq 7c24
      // 7bf1: aload 48
      // 7bf3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7bf6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7bf9: ifne 7c01
      // 7bfc: aload 48
      // 7bfe: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 7c01: aload 9
      // 7c03: instanceof net/minecraft/world/entity/player/Player
      // 7c06: ifeq 7c24
      // 7c09: aload 9
      // 7c0b: checkcast net/minecraft/world/entity/player/Player
      // 7c0e: astore 52
      // 7c10: aload 52
      // 7c12: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 7c15: getstatic net/arphex/init/ArphexModItems.SEALED_GREEN_GOLD_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 7c18: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7c1b: checkcast net/minecraft/world/item/Item
      // 7c1e: sipush 200
      // 7c21: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 7c24: aload 9
      // 7c26: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7c29: ldc_w "highestscarab"
      // 7c2c: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7c2f: ldc_w "iridescent"
      // 7c32: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7c35: ifeq 7ca4
      // 7c38: aload 48
      // 7c3a: instanceof net/arphex/entity/ScarabSummonEntity
      // 7c3d: ifeq 7c58
      // 7c40: aload 48
      // 7c42: checkcast net/arphex/entity/ScarabSummonEntity
      // 7c45: astore 51
      // 7c47: aload 51
      // 7c49: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7c4c: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7c4f: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7c52: checkcast java/lang/String
      // 7c55: goto 7c5a
      // 7c58: ldc ""
      // 7c5a: ldc_w "iridescent"
      // 7c5d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7c60: ifeq 7ca4
      // 7c63: aload 48
      // 7c65: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7c68: ldc_w "despawnable"
      // 7c6b: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 7c6e: ifeq 7ca4
      // 7c71: aload 48
      // 7c73: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7c76: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7c79: ifne 7c81
      // 7c7c: aload 48
      // 7c7e: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 7c81: aload 9
      // 7c83: instanceof net/minecraft/world/entity/player/Player
      // 7c86: ifeq 7ca4
      // 7c89: aload 9
      // 7c8b: checkcast net/minecraft/world/entity/player/Player
      // 7c8e: astore 52
      // 7c90: aload 52
      // 7c92: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 7c95: getstatic net/arphex/init/ArphexModItems.SEALED_IRIDESCENT_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 7c98: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7c9b: checkcast net/minecraft/world/item/Item
      // 7c9e: sipush 200
      // 7ca1: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 7ca4: aload 9
      // 7ca6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7ca9: ldc_w "highestscarab"
      // 7cac: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7caf: ldc_w "purple"
      // 7cb2: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7cb5: ifeq 7d24
      // 7cb8: aload 48
      // 7cba: instanceof net/arphex/entity/ScarabSummonEntity
      // 7cbd: ifeq 7cd8
      // 7cc0: aload 48
      // 7cc2: checkcast net/arphex/entity/ScarabSummonEntity
      // 7cc5: astore 51
      // 7cc7: aload 51
      // 7cc9: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7ccc: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7ccf: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7cd2: checkcast java/lang/String
      // 7cd5: goto 7cda
      // 7cd8: ldc ""
      // 7cda: ldc_w "purple"
      // 7cdd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7ce0: ifeq 7d24
      // 7ce3: aload 48
      // 7ce5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7ce8: ldc_w "despawnable"
      // 7ceb: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 7cee: ifeq 7d24
      // 7cf1: aload 48
      // 7cf3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7cf6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7cf9: ifne 7d01
      // 7cfc: aload 48
      // 7cfe: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 7d01: aload 9
      // 7d03: instanceof net/minecraft/world/entity/player/Player
      // 7d06: ifeq 7d24
      // 7d09: aload 9
      // 7d0b: checkcast net/minecraft/world/entity/player/Player
      // 7d0e: astore 52
      // 7d10: aload 52
      // 7d12: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 7d15: getstatic net/arphex/init/ArphexModItems.SEALED_PURPLE_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 7d18: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7d1b: checkcast net/minecraft/world/item/Item
      // 7d1e: sipush 200
      // 7d21: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 7d24: aload 9
      // 7d26: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7d29: ldc_w "highestscarab"
      // 7d2c: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7d2f: ldc_w "gold"
      // 7d32: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7d35: ifeq 7da4
      // 7d38: aload 48
      // 7d3a: instanceof net/arphex/entity/ScarabSummonEntity
      // 7d3d: ifeq 7d58
      // 7d40: aload 48
      // 7d42: checkcast net/arphex/entity/ScarabSummonEntity
      // 7d45: astore 51
      // 7d47: aload 51
      // 7d49: invokevirtual net/arphex/entity/ScarabSummonEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7d4c: getstatic net/arphex/entity/ScarabSummonEntity.DATA_scarab Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7d4f: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7d52: checkcast java/lang/String
      // 7d55: goto 7d5a
      // 7d58: ldc ""
      // 7d5a: ldc_w "gold"
      // 7d5d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7d60: ifeq 7da4
      // 7d63: aload 48
      // 7d65: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7d68: ldc_w "despawnable"
      // 7d6b: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 7d6e: ifeq 7da4
      // 7d71: aload 48
      // 7d73: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7d76: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7d79: ifne 7d81
      // 7d7c: aload 48
      // 7d7e: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 7d81: aload 9
      // 7d83: instanceof net/minecraft/world/entity/player/Player
      // 7d86: ifeq 7da4
      // 7d89: aload 9
      // 7d8b: checkcast net/minecraft/world/entity/player/Player
      // 7d8e: astore 52
      // 7d90: aload 52
      // 7d92: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 7d95: getstatic net/arphex/init/ArphexModItems.SEALED_GOLDEN_SCARAB Lnet/minecraftforge/registries/RegistryObject;
      // 7d98: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7d9b: checkcast net/minecraft/world/item/Item
      // 7d9e: sipush 200
      // 7da1: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 7da4: goto 7a5e
      // 7da7: aload 11
      // 7da9: instanceof net/arphex/entity/SpiderReaperEntity
      // 7dac: ifeq 7e1b
      // 7daf: aload 9
      // 7db1: instanceof net/arphex/entity/SpiderInfestorEntity
      // 7db4: ifne 7de6
      // 7db7: aload 9
      // 7db9: instanceof net/minecraft/world/entity/LivingEntity
      // 7dbc: ifeq 7de6
      // 7dbf: aload 9
      // 7dc1: checkcast net/minecraft/world/entity/LivingEntity
      // 7dc4: astore 45
      // 7dc6: aload 45
      // 7dc8: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 7dcb: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7dce: ifne 7de6
      // 7dd1: aload 45
      // 7dd3: new net/minecraft/world/effect/MobEffectInstance
      // 7dd6: dup
      // 7dd7: getstatic net/minecraft/world/effect/MobEffects.WEAKNESS Lnet/minecraft/world/effect/MobEffect;
      // 7dda: bipush 60
      // 7ddc: bipush 0
      // 7ddd: bipush 0
      // 7dde: bipush 0
      // 7ddf: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 7de2: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 7de5: pop
      // 7de6: aload 9
      // 7de8: instanceof net/minecraft/world/entity/LivingEntity
      // 7deb: ifeq 7e1b
      // 7dee: aload 9
      // 7df0: checkcast net/minecraft/world/entity/LivingEntity
      // 7df3: astore 45
      // 7df5: aload 45
      // 7df7: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 7dfa: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7dfd: ifne 7e1b
      // 7e00: aload 45
      // 7e02: new net/minecraft/world/effect/MobEffectInstance
      // 7e05: dup
      // 7e06: getstatic net/arphex/init/ArphexModMobEffects.WEBBED Lnet/minecraftforge/registries/RegistryObject;
      // 7e09: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7e0c: checkcast net/minecraft/world/effect/MobEffect
      // 7e0f: bipush 60
      // 7e11: bipush 0
      // 7e12: bipush 0
      // 7e13: bipush 0
      // 7e14: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 7e17: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 7e1a: pop
      // 7e1b: aload 11
      // 7e1d: instanceof net/arphex/entity/AntArsonistWorkerEntity
      // 7e20: ifne 7e33
      // 7e23: aload 11
      // 7e25: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 7e28: ifne 7e33
      // 7e2b: aload 11
      // 7e2d: instanceof net/arphex/entity/AntArsonistDroneEntity
      // 7e30: ifeq 7e9b
      // 7e33: aload 11
      // 7e35: new net/minecraft/world/phys/Vec3
      // 7e38: dup
      // 7e39: aload 11
      // 7e3b: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 7e3e: ldc_w 90.0
      // 7e41: fsub
      // 7e42: f2d
      // 7e43: ldc2_w 0.017453292519943295
      // 7e46: dmul
      // 7e47: invokestatic java/lang/Math.cos (D)D
      // 7e4a: ldc2_w 5.0
      // 7e4d: ddiv
      // 7e4e: aload 11
      // 7e50: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 7e53: invokevirtual net/minecraft/world/phys/Vec3.y ()D
      // 7e56: aload 11
      // 7e58: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 7e5b: ldc_w 90.0
      // 7e5e: fsub
      // 7e5f: f2d
      // 7e60: ldc2_w 0.017453292519943295
      // 7e63: dmul
      // 7e64: invokestatic java/lang/Math.sin (D)D
      // 7e67: ldc2_w 5.0
      // 7e6a: ddiv
      // 7e6b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7e6e: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 7e71: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 7e74: bipush 1
      // 7e75: bipush 5
      // 7e76: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 7e79: bipush 2
      // 7e7a: if_icmpne 7e83
      // 7e7d: aload 9
      // 7e7f: bipush 5
      // 7e80: invokevirtual net/minecraft/world/entity/Entity.setSecondsOnFire (I)V
      // 7e83: aload 9
      // 7e85: instanceof net/minecraft/world/entity/monster/Creeper
      // 7e88: ifeq 7e9b
      // 7e8b: aload 0
      // 7e8c: ifnull 7e9b
      // 7e8f: aload 0
      // 7e90: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 7e93: ifeq 7e9b
      // 7e96: aload 0
      // 7e97: bipush 1
      // 7e98: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 7e9b: aload 9
      // 7e9d: instanceof net/arphex/entity/AntArsonistAlateQueenEntity
      // 7ea0: ifeq 808d
      // 7ea3: aload 9
      // 7ea5: instanceof net/minecraft/world/entity/TamableAnimal
      // 7ea8: ifeq 808d
      // 7eab: aload 9
      // 7ead: checkcast net/minecraft/world/entity/TamableAnimal
      // 7eb0: astore 45
      // 7eb2: aload 45
      // 7eb4: invokevirtual net/minecraft/world/entity/TamableAnimal.isTame ()Z
      // 7eb7: ifeq 808d
      // 7eba: aload 11
      // 7ebc: instanceof net/minecraft/world/entity/TamableAnimal
      // 7ebf: ifeq 7f0c
      // 7ec2: aload 11
      // 7ec4: checkcast net/minecraft/world/entity/TamableAnimal
      // 7ec7: astore 46
      // 7ec9: aload 9
      // 7ecb: instanceof net/minecraft/world/entity/TamableAnimal
      // 7ece: ifeq 7ee0
      // 7ed1: aload 9
      // 7ed3: checkcast net/minecraft/world/entity/TamableAnimal
      // 7ed6: astore 47
      // 7ed8: aload 47
      // 7eda: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 7edd: goto 7ee1
      // 7ee0: aconst_null
      // 7ee1: astore 49
      // 7ee3: aload 49
      // 7ee5: instanceof net/minecraft/world/entity/LivingEntity
      // 7ee8: ifeq 7f0c
      // 7eeb: aload 49
      // 7eed: checkcast net/minecraft/world/entity/LivingEntity
      // 7ef0: astore 48
      // 7ef2: aload 46
      // 7ef4: aload 48
      // 7ef6: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 7ef9: ifeq 7f0c
      // 7efc: aload 0
      // 7efd: ifnull 7f0c
      // 7f00: aload 0
      // 7f01: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 7f04: ifeq 7f0c
      // 7f07: aload 0
      // 7f08: bipush 1
      // 7f09: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 7f0c: new net/minecraft/world/phys/Vec3
      // 7f0f: dup
      // 7f10: dload 2
      // 7f11: dload 4
      // 7f13: dload 6
      // 7f15: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 7f18: astore 46
      // 7f1a: aload 1
      // 7f1b: ldc net/minecraft/world/entity/Entity
      // 7f1d: new net/minecraft/world/phys/AABB
      // 7f20: dup
      // 7f21: aload 46
      // 7f23: aload 46
      // 7f25: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 7f28: ldc2_w 50.0
      // 7f2b: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 7f2e: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$106 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 7f33: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 7f38: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 7f3d: aload 46
      // 7f3f: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$107 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 7f44: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 7f47: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 7f4c: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 7f51: astore 47
      // 7f53: aload 47
      // 7f55: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 7f5a: astore 48
      // 7f5c: aload 48
      // 7f5e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 7f63: ifeq 808d
      // 7f66: aload 48
      // 7f68: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 7f6d: checkcast net/minecraft/world/entity/Entity
      // 7f70: astore 49
      // 7f72: aload 49
      // 7f74: instanceof net/minecraft/world/entity/TamableAnimal
      // 7f77: ifeq 8040
      // 7f7a: aload 49
      // 7f7c: checkcast net/minecraft/world/entity/TamableAnimal
      // 7f7f: astore 50
      // 7f81: aload 50
      // 7f83: invokevirtual net/minecraft/world/entity/TamableAnimal.isTame ()Z
      // 7f86: ifeq 8040
      // 7f89: aload 49
      // 7f8b: instanceof net/arphex/entity/AntArsonistWorkerEntity
      // 7f8e: ifeq 7ff6
      // 7f91: aload 49
      // 7f93: instanceof net/arphex/entity/AntArsonistWorkerEntity
      // 7f96: ifeq 7fb4
      // 7f99: aload 49
      // 7f9b: checkcast net/arphex/entity/AntArsonistWorkerEntity
      // 7f9e: astore 51
      // 7fa0: aload 51
      // 7fa2: invokevirtual net/arphex/entity/AntArsonistWorkerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 7fa5: getstatic net/arphex/entity/AntArsonistWorkerEntity.DATA_following Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 7fa8: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 7fab: checkcast java/lang/Boolean
      // 7fae: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 7fb1: ifne 7ff6
      // 7fb4: aload 11
      // 7fb6: aload 49
      // 7fb8: instanceof net/minecraft/world/entity/TamableAnimal
      // 7fbb: ifeq 7fcd
      // 7fbe: aload 49
      // 7fc0: checkcast net/minecraft/world/entity/TamableAnimal
      // 7fc3: astore 52
      // 7fc5: aload 52
      // 7fc7: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 7fca: goto 7fce
      // 7fcd: aconst_null
      // 7fce: if_acmpeq 7ff6
      // 7fd1: aload 49
      // 7fd3: instanceof net/minecraft/world/entity/Mob
      // 7fd6: ifeq 7ff6
      // 7fd9: aload 49
      // 7fdb: checkcast net/minecraft/world/entity/Mob
      // 7fde: astore 53
      // 7fe0: aload 11
      // 7fe2: instanceof net/minecraft/world/entity/LivingEntity
      // 7fe5: ifeq 7ff6
      // 7fe8: aload 11
      // 7fea: checkcast net/minecraft/world/entity/LivingEntity
      // 7fed: astore 54
      // 7fef: aload 53
      // 7ff1: aload 54
      // 7ff3: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 7ff6: aload 49
      // 7ff8: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 7ffb: ifeq 8040
      // 7ffe: aload 11
      // 8000: aload 49
      // 8002: instanceof net/minecraft/world/entity/TamableAnimal
      // 8005: ifeq 8017
      // 8008: aload 49
      // 800a: checkcast net/minecraft/world/entity/TamableAnimal
      // 800d: astore 51
      // 800f: aload 51
      // 8011: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 8014: goto 8018
      // 8017: aconst_null
      // 8018: if_acmpne 8040
      // 801b: aload 49
      // 801d: instanceof net/minecraft/world/entity/Mob
      // 8020: ifeq 8040
      // 8023: aload 49
      // 8025: checkcast net/minecraft/world/entity/Mob
      // 8028: astore 52
      // 802a: aload 11
      // 802c: instanceof net/minecraft/world/entity/LivingEntity
      // 802f: ifeq 8040
      // 8032: aload 11
      // 8034: checkcast net/minecraft/world/entity/LivingEntity
      // 8037: astore 53
      // 8039: aload 52
      // 803b: aload 53
      // 803d: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 8040: aload 49
      // 8042: instanceof net/arphex/entity/AntArsonistEntity
      // 8045: ifeq 808a
      // 8048: aload 11
      // 804a: aload 9
      // 804c: instanceof net/minecraft/world/entity/TamableAnimal
      // 804f: ifeq 8061
      // 8052: aload 9
      // 8054: checkcast net/minecraft/world/entity/TamableAnimal
      // 8057: astore 50
      // 8059: aload 50
      // 805b: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 805e: goto 8062
      // 8061: aconst_null
      // 8062: if_acmpeq 808a
      // 8065: aload 49
      // 8067: instanceof net/minecraft/world/entity/Mob
      // 806a: ifeq 808a
      // 806d: aload 49
      // 806f: checkcast net/minecraft/world/entity/Mob
      // 8072: astore 51
      // 8074: aload 11
      // 8076: instanceof net/minecraft/world/entity/LivingEntity
      // 8079: ifeq 808a
      // 807c: aload 11
      // 807e: checkcast net/minecraft/world/entity/LivingEntity
      // 8081: astore 52
      // 8083: aload 51
      // 8085: aload 52
      // 8087: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 808a: goto 7f5c
      // 808d: aload 11
      // 808f: instanceof net/arphex/entity/AntArsonistEntity
      // 8092: ifeq 80bb
      // 8095: aload 11
      // 8097: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 809a: ldc_w "fromqueen"
      // 809d: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 80a0: ifeq 80bb
      // 80a3: aload 9
      // 80a5: instanceof net/minecraft/world/entity/player/Player
      // 80a8: ifeq 80bb
      // 80ab: aload 0
      // 80ac: ifnull 80bb
      // 80af: aload 0
      // 80b0: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 80b3: ifeq 80bb
      // 80b6: aload 0
      // 80b7: bipush 1
      // 80b8: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 80bb: aload 11
      // 80bd: instanceof net/arphex/entity/AntArsonistAlateQueenEntity
      // 80c0: ifne 80cb
      // 80c3: aload 11
      // 80c5: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 80c8: ifeq 8149
      // 80cb: aload 9
      // 80cd: instanceof net/minecraft/world/entity/TamableAnimal
      // 80d0: ifeq 8110
      // 80d3: aload 9
      // 80d5: checkcast net/minecraft/world/entity/TamableAnimal
      // 80d8: astore 45
      // 80da: aload 11
      // 80dc: instanceof net/minecraft/world/entity/TamableAnimal
      // 80df: ifeq 80f1
      // 80e2: aload 11
      // 80e4: checkcast net/minecraft/world/entity/TamableAnimal
      // 80e7: astore 46
      // 80e9: aload 46
      // 80eb: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 80ee: goto 80f2
      // 80f1: aconst_null
      // 80f2: astore 48
      // 80f4: aload 48
      // 80f6: instanceof net/minecraft/world/entity/LivingEntity
      // 80f9: ifeq 8110
      // 80fc: aload 48
      // 80fe: checkcast net/minecraft/world/entity/LivingEntity
      // 8101: astore 47
      // 8103: aload 45
      // 8105: aload 47
      // 8107: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 810a: ifeq 8110
      // 810d: goto 811e
      // 8110: aload 9
      // 8112: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8115: ldc_w "fromqueen"
      // 8118: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 811b: ifeq 8149
      // 811e: aload 11
      // 8120: instanceof net/minecraft/world/entity/Mob
      // 8123: ifeq 8139
      // 8126: aload 11
      // 8128: checkcast net/minecraft/world/entity/Mob
      // 812b: aconst_null
      // 812c: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 812f: goto 8139
      // 8132: astore 48
      // 8134: aload 48
      // 8136: invokevirtual java/lang/Exception.printStackTrace ()V
      // 8139: aload 0
      // 813a: ifnull 8149
      // 813d: aload 0
      // 813e: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8141: ifeq 8149
      // 8144: aload 0
      // 8145: bipush 1
      // 8146: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8149: aload 11
      // 814b: instanceof net/minecraft/world/entity/player/Player
      // 814e: ifeq 81b1
      // 8151: aload 9
      // 8153: instanceof net/arphex/entity/AntArsonistWorkerEntity
      // 8156: ifne 8161
      // 8159: aload 9
      // 815b: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 815e: ifeq 81b1
      // 8161: aload 9
      // 8163: instanceof net/minecraft/world/entity/TamableAnimal
      // 8166: ifeq 818c
      // 8169: aload 9
      // 816b: checkcast net/minecraft/world/entity/TamableAnimal
      // 816e: astore 45
      // 8170: aload 11
      // 8172: instanceof net/minecraft/world/entity/LivingEntity
      // 8175: ifeq 818c
      // 8178: aload 11
      // 817a: checkcast net/minecraft/world/entity/LivingEntity
      // 817d: astore 46
      // 817f: aload 45
      // 8181: aload 46
      // 8183: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 8186: ifeq 818c
      // 8189: goto 81b1
      // 818c: aload 9
      // 818e: instanceof net/minecraft/world/entity/Mob
      // 8191: ifeq 81b1
      // 8194: aload 9
      // 8196: checkcast net/minecraft/world/entity/Mob
      // 8199: astore 47
      // 819b: aload 11
      // 819d: instanceof net/minecraft/world/entity/LivingEntity
      // 81a0: ifeq 81b1
      // 81a3: aload 11
      // 81a5: checkcast net/minecraft/world/entity/LivingEntity
      // 81a8: astore 48
      // 81aa: aload 47
      // 81ac: aload 48
      // 81ae: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 81b1: aload 11
      // 81b3: instanceof net/minecraft/world/entity/LivingEntity
      // 81b6: ifeq 81c8
      // 81b9: aload 11
      // 81bb: checkcast net/minecraft/world/entity/LivingEntity
      // 81be: astore 45
      // 81c0: aload 45
      // 81c2: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 81c5: goto 81cb
      // 81c8: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 81cb: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 81ce: getstatic net/arphex/init/ArphexModItems.ABYSSAL_DAGGER Lnet/minecraftforge/registries/RegistryObject;
      // 81d1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 81d4: if_acmpne 85a5
      // 81d7: aload 11
      // 81d9: instanceof net/minecraft/world/entity/player/Player
      // 81dc: ifeq 85a5
      // 81df: aload 11
      // 81e1: checkcast net/minecraft/world/entity/player/Player
      // 81e4: astore 46
      // 81e6: aload 46
      // 81e8: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 81eb: aload 11
      // 81ed: instanceof net/minecraft/world/entity/LivingEntity
      // 81f0: ifeq 8202
      // 81f3: aload 11
      // 81f5: checkcast net/minecraft/world/entity/LivingEntity
      // 81f8: astore 47
      // 81fa: aload 47
      // 81fc: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 81ff: goto 8205
      // 8202: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8205: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 8208: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 820b: ifeq 85a5
      // 820e: aload 11
      // 8210: instanceof net/minecraft/world/entity/LivingEntity
      // 8213: ifeq 8228
      // 8216: aload 11
      // 8218: checkcast net/minecraft/world/entity/LivingEntity
      // 821b: astore 48
      // 821d: aload 48
      // 821f: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8222: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8225: ifne 8290
      // 8228: aload 11
      // 822a: instanceof net/minecraft/world/entity/LivingEntity
      // 822d: ifeq 8257
      // 8230: aload 11
      // 8232: checkcast net/minecraft/world/entity/LivingEntity
      // 8235: astore 49
      // 8237: aload 49
      // 8239: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 823c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 823f: ifne 8257
      // 8242: aload 49
      // 8244: new net/minecraft/world/effect/MobEffectInstance
      // 8247: dup
      // 8248: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 824b: bipush 100
      // 824d: bipush 0
      // 824e: bipush 0
      // 824f: bipush 0
      // 8250: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8253: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8256: pop
      // 8257: aload 11
      // 8259: instanceof net/minecraft/world/entity/player/Player
      // 825c: ifeq 828d
      // 825f: aload 11
      // 8261: checkcast net/minecraft/world/entity/player/Player
      // 8264: astore 49
      // 8266: aload 49
      // 8268: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 826b: aload 11
      // 826d: instanceof net/minecraft/world/entity/LivingEntity
      // 8270: ifeq 8282
      // 8273: aload 11
      // 8275: checkcast net/minecraft/world/entity/LivingEntity
      // 8278: astore 50
      // 827a: aload 50
      // 827c: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 827f: goto 8285
      // 8282: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8285: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 8288: bipush 100
      // 828a: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 828d: goto 85a5
      // 8290: aload 11
      // 8292: instanceof net/minecraft/world/entity/LivingEntity
      // 8295: ifeq 82b8
      // 8298: aload 11
      // 829a: checkcast net/minecraft/world/entity/LivingEntity
      // 829d: astore 49
      // 829f: aload 49
      // 82a1: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 82a4: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 82a7: ifeq 82b8
      // 82aa: aload 49
      // 82ac: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 82af: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 82b2: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 82b5: goto 82b9
      // 82b8: bipush 0
      // 82b9: bipush 1
      // 82ba: if_icmpge 8325
      // 82bd: aload 11
      // 82bf: instanceof net/minecraft/world/entity/LivingEntity
      // 82c2: ifeq 82ec
      // 82c5: aload 11
      // 82c7: checkcast net/minecraft/world/entity/LivingEntity
      // 82ca: astore 50
      // 82cc: aload 50
      // 82ce: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 82d1: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 82d4: ifne 82ec
      // 82d7: aload 50
      // 82d9: new net/minecraft/world/effect/MobEffectInstance
      // 82dc: dup
      // 82dd: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 82e0: bipush 80
      // 82e2: bipush 1
      // 82e3: bipush 0
      // 82e4: bipush 0
      // 82e5: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 82e8: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 82eb: pop
      // 82ec: aload 11
      // 82ee: instanceof net/minecraft/world/entity/player/Player
      // 82f1: ifeq 8322
      // 82f4: aload 11
      // 82f6: checkcast net/minecraft/world/entity/player/Player
      // 82f9: astore 50
      // 82fb: aload 50
      // 82fd: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 8300: aload 11
      // 8302: instanceof net/minecraft/world/entity/LivingEntity
      // 8305: ifeq 8317
      // 8308: aload 11
      // 830a: checkcast net/minecraft/world/entity/LivingEntity
      // 830d: astore 51
      // 830f: aload 51
      // 8311: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 8314: goto 831a
      // 8317: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 831a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 831d: bipush 80
      // 831f: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 8322: goto 85a5
      // 8325: aload 11
      // 8327: instanceof net/minecraft/world/entity/LivingEntity
      // 832a: ifeq 834d
      // 832d: aload 11
      // 832f: checkcast net/minecraft/world/entity/LivingEntity
      // 8332: astore 50
      // 8334: aload 50
      // 8336: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8339: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 833c: ifeq 834d
      // 833f: aload 50
      // 8341: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8344: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 8347: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 834a: goto 834e
      // 834d: bipush 0
      // 834e: bipush 1
      // 834f: if_icmpne 83ba
      // 8352: aload 11
      // 8354: instanceof net/minecraft/world/entity/LivingEntity
      // 8357: ifeq 8381
      // 835a: aload 11
      // 835c: checkcast net/minecraft/world/entity/LivingEntity
      // 835f: astore 51
      // 8361: aload 51
      // 8363: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8366: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8369: ifne 8381
      // 836c: aload 51
      // 836e: new net/minecraft/world/effect/MobEffectInstance
      // 8371: dup
      // 8372: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8375: bipush 60
      // 8377: bipush 2
      // 8378: bipush 0
      // 8379: bipush 0
      // 837a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 837d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8380: pop
      // 8381: aload 11
      // 8383: instanceof net/minecraft/world/entity/player/Player
      // 8386: ifeq 83b7
      // 8389: aload 11
      // 838b: checkcast net/minecraft/world/entity/player/Player
      // 838e: astore 51
      // 8390: aload 51
      // 8392: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 8395: aload 11
      // 8397: instanceof net/minecraft/world/entity/LivingEntity
      // 839a: ifeq 83ac
      // 839d: aload 11
      // 839f: checkcast net/minecraft/world/entity/LivingEntity
      // 83a2: astore 52
      // 83a4: aload 52
      // 83a6: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 83a9: goto 83af
      // 83ac: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 83af: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 83b2: bipush 60
      // 83b4: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 83b7: goto 85a5
      // 83ba: aload 11
      // 83bc: instanceof net/minecraft/world/entity/LivingEntity
      // 83bf: ifeq 83e2
      // 83c2: aload 11
      // 83c4: checkcast net/minecraft/world/entity/LivingEntity
      // 83c7: astore 51
      // 83c9: aload 51
      // 83cb: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 83ce: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 83d1: ifeq 83e2
      // 83d4: aload 51
      // 83d6: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 83d9: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 83dc: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 83df: goto 83e3
      // 83e2: bipush 0
      // 83e3: bipush 2
      // 83e4: if_icmpne 844f
      // 83e7: aload 11
      // 83e9: instanceof net/minecraft/world/entity/LivingEntity
      // 83ec: ifeq 8416
      // 83ef: aload 11
      // 83f1: checkcast net/minecraft/world/entity/LivingEntity
      // 83f4: astore 52
      // 83f6: aload 52
      // 83f8: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 83fb: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 83fe: ifne 8416
      // 8401: aload 52
      // 8403: new net/minecraft/world/effect/MobEffectInstance
      // 8406: dup
      // 8407: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 840a: bipush 50
      // 840c: bipush 3
      // 840d: bipush 0
      // 840e: bipush 0
      // 840f: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8412: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8415: pop
      // 8416: aload 11
      // 8418: instanceof net/minecraft/world/entity/player/Player
      // 841b: ifeq 844c
      // 841e: aload 11
      // 8420: checkcast net/minecraft/world/entity/player/Player
      // 8423: astore 52
      // 8425: aload 52
      // 8427: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 842a: aload 11
      // 842c: instanceof net/minecraft/world/entity/LivingEntity
      // 842f: ifeq 8441
      // 8432: aload 11
      // 8434: checkcast net/minecraft/world/entity/LivingEntity
      // 8437: astore 53
      // 8439: aload 53
      // 843b: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 843e: goto 8444
      // 8441: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8444: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 8447: bipush 50
      // 8449: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 844c: goto 85a5
      // 844f: aload 11
      // 8451: instanceof net/minecraft/world/entity/LivingEntity
      // 8454: ifeq 8477
      // 8457: aload 11
      // 8459: checkcast net/minecraft/world/entity/LivingEntity
      // 845c: astore 52
      // 845e: aload 52
      // 8460: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8463: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8466: ifeq 8477
      // 8469: aload 52
      // 846b: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 846e: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 8471: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 8474: goto 8478
      // 8477: bipush 0
      // 8478: bipush 3
      // 8479: if_icmpne 84e4
      // 847c: aload 11
      // 847e: instanceof net/minecraft/world/entity/LivingEntity
      // 8481: ifeq 84ab
      // 8484: aload 11
      // 8486: checkcast net/minecraft/world/entity/LivingEntity
      // 8489: astore 53
      // 848b: aload 53
      // 848d: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8490: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8493: ifne 84ab
      // 8496: aload 53
      // 8498: new net/minecraft/world/effect/MobEffectInstance
      // 849b: dup
      // 849c: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 849f: bipush 20
      // 84a1: bipush 4
      // 84a2: bipush 0
      // 84a3: bipush 0
      // 84a4: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 84a7: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 84aa: pop
      // 84ab: aload 11
      // 84ad: instanceof net/minecraft/world/entity/player/Player
      // 84b0: ifeq 84e1
      // 84b3: aload 11
      // 84b5: checkcast net/minecraft/world/entity/player/Player
      // 84b8: astore 53
      // 84ba: aload 53
      // 84bc: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 84bf: aload 11
      // 84c1: instanceof net/minecraft/world/entity/LivingEntity
      // 84c4: ifeq 84d6
      // 84c7: aload 11
      // 84c9: checkcast net/minecraft/world/entity/LivingEntity
      // 84cc: astore 54
      // 84ce: aload 54
      // 84d0: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 84d3: goto 84d9
      // 84d6: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 84d9: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 84dc: bipush 50
      // 84de: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 84e1: goto 85a5
      // 84e4: aload 11
      // 84e6: instanceof net/minecraft/world/entity/LivingEntity
      // 84e9: ifeq 850c
      // 84ec: aload 11
      // 84ee: checkcast net/minecraft/world/entity/LivingEntity
      // 84f1: astore 53
      // 84f3: aload 53
      // 84f5: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 84f8: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 84fb: ifeq 850c
      // 84fe: aload 53
      // 8500: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8503: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 8506: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 8509: goto 850d
      // 850c: bipush 0
      // 850d: bipush 3
      // 850e: if_icmple 85a5
      // 8511: aload 11
      // 8513: instanceof net/minecraft/world/entity/LivingEntity
      // 8516: ifeq 8540
      // 8519: aload 11
      // 851b: checkcast net/minecraft/world/entity/LivingEntity
      // 851e: astore 54
      // 8520: aload 54
      // 8522: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8525: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8528: ifne 8540
      // 852b: aload 54
      // 852d: new net/minecraft/world/effect/MobEffectInstance
      // 8530: dup
      // 8531: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8534: bipush 50
      // 8536: bipush 5
      // 8537: bipush 0
      // 8538: bipush 0
      // 8539: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 853c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 853f: pop
      // 8540: aload 11
      // 8542: instanceof net/minecraft/world/entity/LivingEntity
      // 8545: ifeq 856f
      // 8548: aload 11
      // 854a: checkcast net/minecraft/world/entity/LivingEntity
      // 854d: astore 54
      // 854f: aload 54
      // 8551: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8554: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8557: ifne 856f
      // 855a: aload 54
      // 855c: new net/minecraft/world/effect/MobEffectInstance
      // 855f: dup
      // 8560: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_BOOST Lnet/minecraft/world/effect/MobEffect;
      // 8563: bipush 50
      // 8565: bipush 1
      // 8566: bipush 0
      // 8567: bipush 0
      // 8568: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 856b: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 856e: pop
      // 856f: aload 11
      // 8571: instanceof net/minecraft/world/entity/player/Player
      // 8574: ifeq 85a5
      // 8577: aload 11
      // 8579: checkcast net/minecraft/world/entity/player/Player
      // 857c: astore 54
      // 857e: aload 54
      // 8580: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 8583: aload 11
      // 8585: instanceof net/minecraft/world/entity/LivingEntity
      // 8588: ifeq 859a
      // 858b: aload 11
      // 858d: checkcast net/minecraft/world/entity/LivingEntity
      // 8590: astore 55
      // 8592: aload 55
      // 8594: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 8597: goto 859d
      // 859a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 859d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 85a0: bipush 50
      // 85a2: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 85a5: aload 11
      // 85a7: instanceof net/minecraft/world/entity/LivingEntity
      // 85aa: ifeq 85bc
      // 85ad: aload 11
      // 85af: checkcast net/minecraft/world/entity/LivingEntity
      // 85b2: astore 45
      // 85b4: aload 45
      // 85b6: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 85b9: goto 85bf
      // 85bc: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 85bf: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 85c2: getstatic net/arphex/init/ArphexModItems.CRAWLING_CONTAINER Lnet/minecraftforge/registries/RegistryObject;
      // 85c5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 85c8: if_acmpne 898c
      // 85cb: aload 11
      // 85cd: instanceof net/minecraft/world/entity/LivingEntity
      // 85d0: ifeq 85ff
      // 85d3: aload 11
      // 85d5: checkcast net/minecraft/world/entity/LivingEntity
      // 85d8: astore 46
      // 85da: aload 46
      // 85dc: getstatic net/arphex/init/ArphexModMobEffects.ETERNAL_EVASION Lnet/minecraftforge/registries/RegistryObject;
      // 85df: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 85e2: checkcast net/minecraft/world/effect/MobEffect
      // 85e5: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 85e8: ifeq 85ff
      // 85eb: aload 46
      // 85ed: getstatic net/arphex/init/ArphexModMobEffects.ETERNAL_EVASION Lnet/minecraftforge/registries/RegistryObject;
      // 85f0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 85f3: checkcast net/minecraft/world/effect/MobEffect
      // 85f6: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 85f9: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 85fc: goto 8600
      // 85ff: bipush 0
      // 8600: bipush 2
      // 8601: if_icmpne 878d
      // 8604: aload 9
      // 8606: instanceof net/minecraft/world/entity/player/Player
      // 8609: ifne 862d
      // 860c: aload 9
      // 860e: instanceof net/minecraft/world/entity/LivingEntity
      // 8611: ifeq 8623
      // 8614: aload 9
      // 8616: checkcast net/minecraft/world/entity/LivingEntity
      // 8619: astore 47
      // 861b: aload 47
      // 861d: invokevirtual net/minecraft/world/entity/LivingEntity.getMaxHealth ()F
      // 8620: goto 8626
      // 8623: ldc_w -1.0
      // 8626: ldc_w 100.0
      // 8629: fcmpg
      // 862a: ifge 898c
      // 862d: aload 11
      // 862f: instanceof net/minecraft/world/entity/player/Player
      // 8632: ifeq 8653
      // 8635: aload 11
      // 8637: checkcast net/minecraft/world/entity/player/Player
      // 863a: astore 48
      // 863c: aload 48
      // 863e: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 8641: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8644: ifne 8653
      // 8647: aload 48
      // 8649: ldc_w "Kicked entity from your pocket dimension"
      // 864c: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 864f: bipush 1
      // 8650: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 8653: aload 9
      // 8655: instanceof net/minecraft/world/entity/player/Player
      // 8658: ifeq 8681
      // 865b: aload 9
      // 865d: instanceof net/minecraft/world/entity/player/Player
      // 8660: ifeq 8681
      // 8663: aload 9
      // 8665: checkcast net/minecraft/world/entity/player/Player
      // 8668: astore 48
      // 866a: aload 48
      // 866c: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 866f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8672: ifne 8681
      // 8675: aload 48
      // 8677: ldc_w "Kicked from pocket dimension"
      // 867a: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 867d: bipush 1
      // 867e: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 8681: aload 0
      // 8682: ifnull 8691
      // 8685: aload 0
      // 8686: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8689: ifeq 8691
      // 868c: aload 0
      // 868d: bipush 1
      // 868e: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8691: aload 9
      // 8693: astore 48
      // 8695: aload 48
      // 8697: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 869a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 869d: ifne 878a
      // 86a0: aload 48
      // 86a2: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 86a5: ifnull 878a
      // 86a8: aload 48
      // 86aa: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 86ad: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 86b0: new net/minecraft/commands/CommandSourceStack
      // 86b3: dup
      // 86b4: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 86b7: aload 48
      // 86b9: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 86bc: aload 48
      // 86be: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 86c1: aload 48
      // 86c3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 86c6: instanceof net/minecraft/server/level/ServerLevel
      // 86c9: ifeq 86d7
      // 86cc: aload 48
      // 86ce: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 86d1: checkcast net/minecraft/server/level/ServerLevel
      // 86d4: goto 86d8
      // 86d7: aconst_null
      // 86d8: bipush 4
      // 86d9: aload 48
      // 86db: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 86de: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 86e3: aload 48
      // 86e5: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 86e8: aload 48
      // 86ea: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 86ed: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 86f0: aload 48
      // 86f2: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 86f5: aload 11
      // 86f7: instanceof net/minecraft/world/entity/LivingEntity
      // 86fa: ifeq 870c
      // 86fd: aload 11
      // 86ff: checkcast net/minecraft/world/entity/LivingEntity
      // 8702: astore 52
      // 8704: aload 52
      // 8706: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 8709: goto 870f
      // 870c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 870f: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 8712: ldc_w "camefrom"
      // 8715: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 8718: aload 11
      // 871a: instanceof net/minecraft/world/entity/LivingEntity
      // 871d: ifeq 872f
      // 8720: aload 11
      // 8722: checkcast net/minecraft/world/entity/LivingEntity
      // 8725: astore 51
      // 8727: aload 51
      // 8729: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 872c: goto 8732
      // 872f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8732: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 8735: ldc_w "latestx"
      // 8738: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 873b: aload 11
      // 873d: instanceof net/minecraft/world/entity/LivingEntity
      // 8740: ifeq 8752
      // 8743: aload 11
      // 8745: checkcast net/minecraft/world/entity/LivingEntity
      // 8748: astore 50
      // 874a: aload 50
      // 874c: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 874f: goto 8755
      // 8752: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8755: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 8758: ldc_w "latesty"
      // 875b: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 875e: aload 11
      // 8760: instanceof net/minecraft/world/entity/LivingEntity
      // 8763: ifeq 8775
      // 8766: aload 11
      // 8768: checkcast net/minecraft/world/entity/LivingEntity
      // 876b: astore 49
      // 876d: aload 49
      // 876f: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 8772: goto 8778
      // 8775: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8778: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 877b: ldc_w "latestz"
      // 877e: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8781: invokedynamic makeConcatWithConstants (Ljava/lang/String;DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run tp \u0001 \u0001 \u0001" ]
      // 8786: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 8789: pop
      // 878a: goto 898c
      // 878d: aload 11
      // 878f: instanceof net/minecraft/world/entity/player/Player
      // 8792: ifeq 87c4
      // 8795: aload 11
      // 8797: checkcast net/minecraft/world/entity/player/Player
      // 879a: astore 47
      // 879c: aload 47
      // 879e: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 87a1: aload 11
      // 87a3: instanceof net/minecraft/world/entity/LivingEntity
      // 87a6: ifeq 87b8
      // 87a9: aload 11
      // 87ab: checkcast net/minecraft/world/entity/LivingEntity
      // 87ae: astore 48
      // 87b0: aload 48
      // 87b2: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 87b5: goto 87bb
      // 87b8: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 87bb: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 87be: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 87c1: ifne 88f6
      // 87c4: aload 9
      // 87c6: instanceof net/minecraft/world/entity/player/Player
      // 87c9: ifeq 8858
      // 87cc: aload 9
      // 87ce: instanceof net/minecraft/world/entity/LivingEntity
      // 87d1: ifeq 87fb
      // 87d4: aload 9
      // 87d6: checkcast net/minecraft/world/entity/LivingEntity
      // 87d9: astore 49
      // 87db: aload 49
      // 87dd: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 87e0: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 87e3: ifne 87fb
      // 87e6: aload 49
      // 87e8: new net/minecraft/world/effect/MobEffectInstance
      // 87eb: dup
      // 87ec: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 87ef: bipush 10
      // 87f1: bipush 0
      // 87f2: bipush 0
      // 87f3: bipush 0
      // 87f4: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 87f7: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 87fa: pop
      // 87fb: aload 11
      // 87fd: instanceof net/minecraft/world/entity/LivingEntity
      // 8800: ifeq 8812
      // 8803: aload 11
      // 8805: checkcast net/minecraft/world/entity/LivingEntity
      // 8808: astore 49
      // 880a: aload 49
      // 880c: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 880f: goto 8815
      // 8812: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8815: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 8818: ldc_w "playertrackfortp"
      // 881b: aload 9
      // 881d: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 8820: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 8823: aload 9
      // 8825: instanceof net/minecraft/world/entity/player/Player
      // 8828: ifeq 8855
      // 882b: aload 9
      // 882d: checkcast net/minecraft/world/entity/player/Player
      // 8830: astore 49
      // 8832: aload 49
      // 8834: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 8837: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 883a: ifne 8855
      // 883d: aload 49
      // 883f: aload 11
      // 8841: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 8844: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 8849: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Pocket dimension invite from \u0001, right click them within 5s to accept" ]
      // 884e: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 8851: bipush 0
      // 8852: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 8855: goto 88f6
      // 8858: aload 9
      // 885a: instanceof net/minecraft/world/entity/LivingEntity
      // 885d: ifeq 886f
      // 8860: aload 9
      // 8862: checkcast net/minecraft/world/entity/LivingEntity
      // 8865: astore 49
      // 8867: aload 49
      // 8869: invokevirtual net/minecraft/world/entity/LivingEntity.getMaxHealth ()F
      // 886c: goto 8872
      // 886f: ldc_w -1.0
      // 8872: ldc_w 100.0
      // 8875: fcmpg
      // 8876: ifge 88f6
      // 8879: aload 9
      // 887b: instanceof net/minecraft/world/entity/LivingEntity
      // 887e: ifeq 88a8
      // 8881: aload 9
      // 8883: checkcast net/minecraft/world/entity/LivingEntity
      // 8886: astore 50
      // 8888: aload 50
      // 888a: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 888d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8890: ifne 88a8
      // 8893: aload 50
      // 8895: new net/minecraft/world/effect/MobEffectInstance
      // 8898: dup
      // 8899: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 889c: bipush 10
      // 889e: bipush 0
      // 889f: bipush 0
      // 88a0: bipush 0
      // 88a1: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 88a4: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 88a7: pop
      // 88a8: aload 11
      // 88aa: instanceof net/minecraft/world/entity/LivingEntity
      // 88ad: ifeq 88bf
      // 88b0: aload 11
      // 88b2: checkcast net/minecraft/world/entity/LivingEntity
      // 88b5: astore 50
      // 88b7: aload 50
      // 88b9: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 88bc: goto 88c2
      // 88bf: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 88c2: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 88c5: ldc_w "fiveseconds"
      // 88c8: ldc2_w 100.0
      // 88cb: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 88ce: aload 11
      // 88d0: instanceof net/minecraft/world/entity/LivingEntity
      // 88d3: ifeq 88e5
      // 88d6: aload 11
      // 88d8: checkcast net/minecraft/world/entity/LivingEntity
      // 88db: astore 50
      // 88dd: aload 50
      // 88df: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 88e2: goto 88e8
      // 88e5: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 88e8: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 88eb: ldc_w "trackfortp"
      // 88ee: aload 9
      // 88f0: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 88f3: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 88f6: aload 11
      // 88f8: instanceof net/minecraft/world/entity/player/Player
      // 88fb: ifeq 892d
      // 88fe: aload 11
      // 8900: checkcast net/minecraft/world/entity/player/Player
      // 8903: astore 47
      // 8905: aload 47
      // 8907: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 890a: aload 11
      // 890c: instanceof net/minecraft/world/entity/LivingEntity
      // 890f: ifeq 8921
      // 8912: aload 11
      // 8914: checkcast net/minecraft/world/entity/LivingEntity
      // 8917: astore 48
      // 8919: aload 48
      // 891b: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 891e: goto 8924
      // 8921: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8924: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 8927: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 892a: ifne 898c
      // 892d: aload 9
      // 892f: instanceof net/minecraft/world/entity/player/Player
      // 8932: ifne 8956
      // 8935: aload 9
      // 8937: instanceof net/minecraft/world/entity/LivingEntity
      // 893a: ifeq 894c
      // 893d: aload 9
      // 893f: checkcast net/minecraft/world/entity/LivingEntity
      // 8942: astore 49
      // 8944: aload 49
      // 8946: invokevirtual net/minecraft/world/entity/LivingEntity.getMaxHealth ()F
      // 8949: goto 894f
      // 894c: ldc_w -1.0
      // 894f: ldc_w 100.0
      // 8952: fcmpg
      // 8953: ifge 898c
      // 8956: aload 11
      // 8958: instanceof net/minecraft/world/entity/player/Player
      // 895b: ifeq 897c
      // 895e: aload 11
      // 8960: checkcast net/minecraft/world/entity/player/Player
      // 8963: astore 50
      // 8965: aload 50
      // 8967: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 896a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 896d: ifne 897c
      // 8970: aload 50
      // 8972: ldc_w "Added 5 second dimension invite to entity"
      // 8975: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 8978: bipush 1
      // 8979: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 897c: aload 0
      // 897d: ifnull 898c
      // 8980: aload 0
      // 8981: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8984: ifeq 898c
      // 8987: aload 0
      // 8988: bipush 1
      // 8989: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 898c: aload 11
      // 898e: instanceof net/arphex/entity/TORMENTOREntity
      // 8991: ifeq 89e8
      // 8994: aload 9
      // 8996: instanceof net/minecraft/world/entity/LivingEntity
      // 8999: ifeq 89b4
      // 899c: aload 9
      // 899e: checkcast net/minecraft/world/entity/LivingEntity
      // 89a1: astore 45
      // 89a3: aload 45
      // 89a5: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 89a8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 89ab: checkcast net/minecraft/world/effect/MobEffect
      // 89ae: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 89b1: ifne 89e8
      // 89b4: aload 1
      // 89b5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 89b8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 89bb: ldc2_w 1024.0
      // 89be: dcmpg
      // 89bf: ifge 89e8
      // 89c2: aload 1
      // 89c3: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 89c6: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 89c9: ldc2_w 50.0
      // 89cc: dcmpl
      // 89cd: ifle 89e8
      // 89d0: aload 1
      // 89d1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 89d4: aload 1
      // 89d5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 89d8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 89db: dconst_1
      // 89dc: dadd
      // 89dd: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 89e0: aload 1
      // 89e1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 89e4: aload 1
      // 89e5: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 89e8: aload 9
      // 89ea: instanceof net/arphex/entity/MantisMutilatorEntity
      // 89ed: ifeq 8a26
      // 89f0: aload 9
      // 89f2: instanceof net/minecraft/world/entity/LivingEntity
      // 89f5: ifeq 8a26
      // 89f8: aload 9
      // 89fa: checkcast net/minecraft/world/entity/LivingEntity
      // 89fd: astore 45
      // 89ff: aload 45
      // 8a01: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8a04: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8a07: ifne 8a26
      // 8a0a: aload 45
      // 8a0c: new net/minecraft/world/effect/MobEffectInstance
      // 8a0f: dup
      // 8a10: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 8a13: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8a16: checkcast net/minecraft/world/effect/MobEffect
      // 8a19: sipush 300
      // 8a1c: bipush 0
      // 8a1d: bipush 0
      // 8a1e: bipush 0
      // 8a1f: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8a22: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8a25: pop
      // 8a26: aload 11
      // 8a28: instanceof net/arphex/entity/MantisMutilatorEntity
      // 8a2b: ifeq 8a64
      // 8a2e: aload 11
      // 8a30: instanceof net/minecraft/world/entity/LivingEntity
      // 8a33: ifeq 8a64
      // 8a36: aload 11
      // 8a38: checkcast net/minecraft/world/entity/LivingEntity
      // 8a3b: astore 45
      // 8a3d: aload 45
      // 8a3f: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8a42: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8a45: ifne 8a64
      // 8a48: aload 45
      // 8a4a: new net/minecraft/world/effect/MobEffectInstance
      // 8a4d: dup
      // 8a4e: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 8a51: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8a54: checkcast net/minecraft/world/effect/MobEffect
      // 8a57: sipush 300
      // 8a5a: bipush 0
      // 8a5b: bipush 0
      // 8a5c: bipush 0
      // 8a5d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8a60: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8a63: pop
      // 8a64: aload 11
      // 8a66: instanceof net/arphex/entity/SpiderMothLarvaeEntity
      // 8a69: ifeq 8a84
      // 8a6c: aload 9
      // 8a6e: instanceof net/arphex/entity/SpiderMothEntity
      // 8a71: ifeq 8a84
      // 8a74: aload 0
      // 8a75: ifnull 8a84
      // 8a78: aload 0
      // 8a79: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8a7c: ifeq 8a84
      // 8a7f: aload 0
      // 8a80: bipush 1
      // 8a81: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8a84: aload 11
      // 8a86: instanceof net/arphex/entity/SpiderMothSummonEntity
      // 8a89: ifeq 8ad2
      // 8a8c: aload 9
      // 8a8e: instanceof net/minecraft/world/entity/LivingEntity
      // 8a91: ifeq 8aa3
      // 8a94: aload 9
      // 8a96: checkcast net/minecraft/world/entity/LivingEntity
      // 8a99: astore 45
      // 8a9b: aload 45
      // 8a9d: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 8aa0: ifne 8ad2
      // 8aa3: aload 9
      // 8aa5: instanceof net/minecraft/world/entity/LivingEntity
      // 8aa8: ifeq 8ad2
      // 8aab: aload 9
      // 8aad: checkcast net/minecraft/world/entity/LivingEntity
      // 8ab0: astore 46
      // 8ab2: aload 46
      // 8ab4: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8ab7: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8aba: ifne 8ad2
      // 8abd: aload 46
      // 8abf: new net/minecraft/world/effect/MobEffectInstance
      // 8ac2: dup
      // 8ac3: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 8ac6: bipush 60
      // 8ac8: bipush 1
      // 8ac9: bipush 0
      // 8aca: bipush 0
      // 8acb: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8ace: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8ad1: pop
      // 8ad2: aload 9
      // 8ad4: instanceof net/arphex/entity/SpiderInfestorEntity
      // 8ad7: ifeq 8b10
      // 8ada: aload 9
      // 8adc: instanceof net/minecraft/world/entity/LivingEntity
      // 8adf: ifeq 8b10
      // 8ae2: aload 9
      // 8ae4: checkcast net/minecraft/world/entity/LivingEntity
      // 8ae7: astore 45
      // 8ae9: aload 45
      // 8aeb: getstatic net/minecraft/world/effect/MobEffects.INVISIBILITY Lnet/minecraft/world/effect/MobEffect;
      // 8aee: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8af1: ifeq 8b10
      // 8af4: bipush 10
      // 8af6: aload 9
      // 8af8: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$108 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 8afd: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 8b00: aload 0
      // 8b01: ifnull 8b10
      // 8b04: aload 0
      // 8b05: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8b08: ifeq 8b10
      // 8b0b: aload 0
      // 8b0c: bipush 1
      // 8b0d: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8b10: aload 11
      // 8b12: instanceof net/arphex/entity/SpiderInfestorEntity
      // 8b15: ifeq 8bc0
      // 8b18: aload 11
      // 8b1a: instanceof net/minecraft/world/entity/LivingEntity
      // 8b1d: ifeq 8b45
      // 8b20: aload 11
      // 8b22: checkcast net/minecraft/world/entity/LivingEntity
      // 8b25: astore 45
      // 8b27: aload 45
      // 8b29: getstatic net/minecraft/world/effect/MobEffects.INVISIBILITY Lnet/minecraft/world/effect/MobEffect;
      // 8b2c: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8b2f: ifeq 8b45
      // 8b32: aload 0
      // 8b33: ifnull 8bc0
      // 8b36: aload 0
      // 8b37: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8b3a: ifeq 8bc0
      // 8b3d: aload 0
      // 8b3e: bipush 1
      // 8b3f: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8b42: goto 8bc0
      // 8b45: aload 9
      // 8b47: instanceof net/minecraft/world/entity/LivingEntity
      // 8b4a: ifeq 8b5c
      // 8b4d: aload 9
      // 8b4f: checkcast net/minecraft/world/entity/LivingEntity
      // 8b52: astore 46
      // 8b54: aload 46
      // 8b56: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 8b59: ifne 8bc0
      // 8b5c: aload 9
      // 8b5e: instanceof net/minecraft/world/entity/LivingEntity
      // 8b61: ifeq 8b8b
      // 8b64: aload 9
      // 8b66: checkcast net/minecraft/world/entity/LivingEntity
      // 8b69: astore 47
      // 8b6b: aload 47
      // 8b6d: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8b70: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8b73: ifne 8b8b
      // 8b76: aload 47
      // 8b78: new net/minecraft/world/effect/MobEffectInstance
      // 8b7b: dup
      // 8b7c: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 8b7f: bipush 60
      // 8b81: bipush 0
      // 8b82: bipush 0
      // 8b83: bipush 0
      // 8b84: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8b87: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8b8a: pop
      // 8b8b: aload 9
      // 8b8d: instanceof net/minecraft/world/entity/LivingEntity
      // 8b90: ifeq 8bc0
      // 8b93: aload 9
      // 8b95: checkcast net/minecraft/world/entity/LivingEntity
      // 8b98: astore 47
      // 8b9a: aload 47
      // 8b9c: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8b9f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8ba2: ifne 8bc0
      // 8ba5: aload 47
      // 8ba7: new net/minecraft/world/effect/MobEffectInstance
      // 8baa: dup
      // 8bab: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 8bae: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8bb1: checkcast net/minecraft/world/effect/MobEffect
      // 8bb4: bipush 60
      // 8bb6: bipush 0
      // 8bb7: bipush 0
      // 8bb8: bipush 0
      // 8bb9: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8bbc: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8bbf: pop
      // 8bc0: aload 11
      // 8bc2: instanceof net/arphex/entity/WaspNemesisEntity
      // 8bc5: ifeq 8c93
      // 8bc8: aload 9
      // 8bca: instanceof net/minecraft/world/entity/LivingEntity
      // 8bcd: ifeq 8bdf
      // 8bd0: aload 9
      // 8bd2: checkcast net/minecraft/world/entity/LivingEntity
      // 8bd5: astore 45
      // 8bd7: aload 45
      // 8bd9: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 8bdc: ifne 8c93
      // 8bdf: aload 9
      // 8be1: instanceof net/minecraft/world/entity/LivingEntity
      // 8be4: ifeq 8c0e
      // 8be7: aload 9
      // 8be9: checkcast net/minecraft/world/entity/LivingEntity
      // 8bec: astore 46
      // 8bee: aload 46
      // 8bf0: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8bf3: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8bf6: ifne 8c0e
      // 8bf9: aload 46
      // 8bfb: new net/minecraft/world/effect/MobEffectInstance
      // 8bfe: dup
      // 8bff: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 8c02: bipush 60
      // 8c04: bipush 0
      // 8c05: bipush 0
      // 8c06: bipush 0
      // 8c07: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8c0a: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8c0d: pop
      // 8c0e: aload 9
      // 8c10: instanceof net/minecraft/world/entity/LivingEntity
      // 8c13: ifeq 8c43
      // 8c16: aload 9
      // 8c18: checkcast net/minecraft/world/entity/LivingEntity
      // 8c1b: astore 46
      // 8c1d: aload 46
      // 8c1f: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8c22: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8c25: ifne 8c43
      // 8c28: aload 46
      // 8c2a: new net/minecraft/world/effect/MobEffectInstance
      // 8c2d: dup
      // 8c2e: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 8c31: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8c34: checkcast net/minecraft/world/effect/MobEffect
      // 8c37: bipush 60
      // 8c39: bipush 0
      // 8c3a: bipush 0
      // 8c3b: bipush 0
      // 8c3c: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8c3f: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8c42: pop
      // 8c43: aload 9
      // 8c45: instanceof net/minecraft/world/entity/LivingEntity
      // 8c48: ifeq 8c72
      // 8c4b: aload 9
      // 8c4d: checkcast net/minecraft/world/entity/LivingEntity
      // 8c50: astore 46
      // 8c52: aload 46
      // 8c54: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8c57: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8c5a: ifne 8c72
      // 8c5d: aload 46
      // 8c5f: new net/minecraft/world/effect/MobEffectInstance
      // 8c62: dup
      // 8c63: getstatic net/minecraft/world/effect/MobEffects.WEAKNESS Lnet/minecraft/world/effect/MobEffect;
      // 8c66: bipush 20
      // 8c68: bipush 0
      // 8c69: bipush 0
      // 8c6a: bipush 0
      // 8c6b: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8c6e: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8c71: pop
      // 8c72: aload 9
      // 8c74: new net/minecraft/world/phys/Vec3
      // 8c77: dup
      // 8c78: dconst_0
      // 8c79: dconst_0
      // 8c7a: dconst_0
      // 8c7b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 8c7e: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 8c81: bipush 10
      // 8c83: aload 1
      // 8c84: dload 2
      // 8c85: dload 4
      // 8c87: dload 6
      // 8c89: aload 9
      // 8c8b: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$110 (Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V, ()V ]
      // 8c90: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 8c93: aload 11
      // 8c95: instanceof net/minecraft/world/entity/LivingEntity
      // 8c98: ifeq 8caa
      // 8c9b: aload 11
      // 8c9d: checkcast net/minecraft/world/entity/LivingEntity
      // 8ca0: astore 45
      // 8ca2: aload 45
      // 8ca4: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 8ca7: goto 8cad
      // 8caa: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 8cad: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 8cb0: getstatic net/arphex/init/ArphexModItems.SPEAR_OF_PARALYSIS Lnet/minecraftforge/registries/RegistryObject;
      // 8cb3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8cb6: if_acmpne 8ccb
      // 8cb9: bipush 10
      // 8cbb: aload 1
      // 8cbc: dload 2
      // 8cbd: dload 4
      // 8cbf: dload 6
      // 8cc1: aload 9
      // 8cc3: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$112 (Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V, ()V ]
      // 8cc8: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 8ccb: aload 9
      // 8ccd: instanceof net/arphex/entity/SegmentedBodyEntity
      // 8cd0: ifeq 8d9e
      // 8cd3: aload 8
      // 8cd5: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 8cd8: new net/minecraft/resources/ResourceLocation
      // 8cdb: dup
      // 8cdc: ldc_w "arphex:segment"
      // 8cdf: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 8ce2: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 8ce5: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 8ce8: ifne 8d9e
      // 8ceb: aload 9
      // 8ced: instanceof net/minecraft/world/entity/LivingEntity
      // 8cf0: ifeq 8d0b
      // 8cf3: aload 9
      // 8cf5: checkcast net/minecraft/world/entity/LivingEntity
      // 8cf8: astore 45
      // 8cfa: aload 45
      // 8cfc: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 8cff: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8d02: checkcast net/minecraft/world/effect/MobEffect
      // 8d05: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8d08: ifne 8d9e
      // 8d0b: aload 11
      // 8d0d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8d10: ldc_w "arthropleura_target"
      // 8d13: bipush 1
      // 8d14: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 8d17: aload 0
      // 8d18: ifnull 8d27
      // 8d1b: aload 0
      // 8d1c: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8d1f: ifeq 8d27
      // 8d22: aload 0
      // 8d23: bipush 1
      // 8d24: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8d27: aload 9
      // 8d29: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8d2c: ldc_w "segdamagetransfer"
      // 8d2f: dload 12
      // 8d31: invokestatic java/lang/Math.round (D)J
      // 8d34: l2d
      // 8d35: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8d38: aload 9
      // 8d3a: new net/minecraft/world/damagesource/DamageSource
      // 8d3d: dup
      // 8d3e: aload 1
      // 8d3f: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 8d44: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 8d47: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 8d4c: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 8d4f: new net/minecraft/resources/ResourceLocation
      // 8d52: dup
      // 8d53: ldc_w "arphex:segment"
      // 8d56: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 8d59: invokestatic net/minecraft/resources/ResourceKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/resources/ResourceKey;
      // 8d5c: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 8d61: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 8d64: fconst_0
      // 8d65: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 8d68: pop
      // 8d69: aload 9
      // 8d6b: instanceof net/minecraft/world/entity/LivingEntity
      // 8d6e: ifeq 8d9e
      // 8d71: aload 9
      // 8d73: checkcast net/minecraft/world/entity/LivingEntity
      // 8d76: astore 46
      // 8d78: aload 46
      // 8d7a: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8d7d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8d80: ifne 8d9e
      // 8d83: aload 46
      // 8d85: new net/minecraft/world/effect/MobEffectInstance
      // 8d88: dup
      // 8d89: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 8d8c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8d8f: checkcast net/minecraft/world/effect/MobEffect
      // 8d92: bipush 20
      // 8d94: bipush 0
      // 8d95: bipush 0
      // 8d96: bipush 0
      // 8d97: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8d9a: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8d9d: pop
      // 8d9e: aload 9
      // 8da0: instanceof net/arphex/entity/ArthropleuraAbominationEntity
      // 8da3: ifeq 8e34
      // 8da6: aload 9
      // 8da8: instanceof net/minecraft/world/entity/LivingEntity
      // 8dab: ifeq 8dc6
      // 8dae: aload 9
      // 8db0: checkcast net/minecraft/world/entity/LivingEntity
      // 8db3: astore 45
      // 8db5: aload 45
      // 8db7: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 8dba: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8dbd: checkcast net/minecraft/world/effect/MobEffect
      // 8dc0: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8dc3: ifne 8e34
      // 8dc6: dload 12
      // 8dc8: ldc2_w 50.0
      // 8dcb: dcmpl
      // 8dcc: ifle 8df3
      // 8dcf: dload 12
      // 8dd1: ldc2_w 200.0
      // 8dd4: dcmpg
      // 8dd5: iflt 8df3
      // 8dd8: aload 0
      // 8dd9: ifnull 8de8
      // 8ddc: aload 0
      // 8ddd: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8de0: ifeq 8de8
      // 8de3: aload 0
      // 8de4: bipush 1
      // 8de5: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8de8: aload 9
      // 8dea: aload 8
      // 8dec: ldc_w 50.0
      // 8def: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 8df2: pop
      // 8df3: aload 9
      // 8df5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8df8: ldc_w "segupwardstransfer"
      // 8dfb: dconst_1
      // 8dfc: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8dff: aload 9
      // 8e01: instanceof net/minecraft/world/entity/LivingEntity
      // 8e04: ifeq 8e34
      // 8e07: aload 9
      // 8e09: checkcast net/minecraft/world/entity/LivingEntity
      // 8e0c: astore 46
      // 8e0e: aload 46
      // 8e10: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8e13: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8e16: ifne 8e34
      // 8e19: aload 46
      // 8e1b: new net/minecraft/world/effect/MobEffectInstance
      // 8e1e: dup
      // 8e1f: getstatic net/arphex/init/ArphexModMobEffects.INVINCIBILITY_TEMP Lnet/minecraftforge/registries/RegistryObject;
      // 8e22: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8e25: checkcast net/minecraft/world/effect/MobEffect
      // 8e28: bipush 20
      // 8e2a: bipush 0
      // 8e2b: bipush 0
      // 8e2c: bipush 0
      // 8e2d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8e30: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8e33: pop
      // 8e34: aload 11
      // 8e36: instanceof net/arphex/entity/ArthropleuraAbominationEntity
      // 8e39: ifeq 8ee3
      // 8e3c: aload 11
      // 8e3e: instanceof net/minecraft/world/entity/TamableAnimal
      // 8e41: ifeq 8ee3
      // 8e44: aload 11
      // 8e46: checkcast net/minecraft/world/entity/TamableAnimal
      // 8e49: astore 45
      // 8e4b: aload 45
      // 8e4d: invokevirtual net/minecraft/world/entity/TamableAnimal.isTame ()Z
      // 8e50: ifeq 8ee3
      // 8e53: aload 9
      // 8e55: instanceof net/minecraft/world/entity/TamableAnimal
      // 8e58: ifeq 8ee3
      // 8e5b: aload 9
      // 8e5d: checkcast net/minecraft/world/entity/TamableAnimal
      // 8e60: astore 46
      // 8e62: aload 46
      // 8e64: invokevirtual net/minecraft/world/entity/TamableAnimal.isTame ()Z
      // 8e67: ifeq 8ee3
      // 8e6a: aload 11
      // 8e6c: instanceof net/minecraft/world/entity/TamableAnimal
      // 8e6f: ifeq 8e81
      // 8e72: aload 11
      // 8e74: checkcast net/minecraft/world/entity/TamableAnimal
      // 8e77: astore 47
      // 8e79: aload 47
      // 8e7b: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 8e7e: goto 8e82
      // 8e81: aconst_null
      // 8e82: ifnull 8ee3
      // 8e85: aload 9
      // 8e87: instanceof net/minecraft/world/entity/TamableAnimal
      // 8e8a: ifeq 8e9c
      // 8e8d: aload 9
      // 8e8f: checkcast net/minecraft/world/entity/TamableAnimal
      // 8e92: astore 48
      // 8e94: aload 48
      // 8e96: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 8e99: goto 8e9d
      // 8e9c: aconst_null
      // 8e9d: ifnull 8ee3
      // 8ea0: aload 9
      // 8ea2: instanceof net/minecraft/world/entity/TamableAnimal
      // 8ea5: ifeq 8eb7
      // 8ea8: aload 9
      // 8eaa: checkcast net/minecraft/world/entity/TamableAnimal
      // 8ead: astore 49
      // 8eaf: aload 49
      // 8eb1: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 8eb4: goto 8eb8
      // 8eb7: aconst_null
      // 8eb8: aload 11
      // 8eba: instanceof net/minecraft/world/entity/TamableAnimal
      // 8ebd: ifeq 8ecf
      // 8ec0: aload 11
      // 8ec2: checkcast net/minecraft/world/entity/TamableAnimal
      // 8ec5: astore 50
      // 8ec7: aload 50
      // 8ec9: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 8ecc: goto 8ed0
      // 8ecf: aconst_null
      // 8ed0: if_acmpne 8ee3
      // 8ed3: aload 0
      // 8ed4: ifnull 8ee3
      // 8ed7: aload 0
      // 8ed8: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8edb: ifeq 8ee3
      // 8ede: aload 0
      // 8edf: bipush 1
      // 8ee0: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8ee3: aload 11
      // 8ee5: instanceof net/arphex/entity/VenusFlytrapEntity
      // 8ee8: ifeq 8f15
      // 8eeb: aload 8
      // 8eed: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 8ef0: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 8ef3: ifne 8f15
      // 8ef6: aload 0
      // 8ef7: ifnull 8f06
      // 8efa: aload 0
      // 8efb: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 8efe: ifeq 8f06
      // 8f01: aload 0
      // 8f02: bipush 1
      // 8f03: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 8f06: bipush 14
      // 8f08: aload 11
      // 8f0a: aload 1
      // 8f0b: aload 9
      // 8f0d: invokedynamic run (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$115 (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 8f12: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 8f15: aload 11
      // 8f17: instanceof net/arphex/entity/SpiderAmbusherEntity
      // 8f1a: ifeq 8fbf
      // 8f1d: aload 11
      // 8f1f: instanceof net/minecraft/world/entity/LivingEntity
      // 8f22: ifeq 8fbf
      // 8f25: aload 11
      // 8f27: checkcast net/minecraft/world/entity/LivingEntity
      // 8f2a: astore 45
      // 8f2c: aload 45
      // 8f2e: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 8f31: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8f34: checkcast net/minecraft/world/effect/MobEffect
      // 8f37: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8f3a: ifeq 8fbf
      // 8f3d: aload 9
      // 8f3f: instanceof net/minecraft/world/entity/LivingEntity
      // 8f42: ifeq 8f72
      // 8f45: aload 9
      // 8f47: checkcast net/minecraft/world/entity/LivingEntity
      // 8f4a: astore 46
      // 8f4c: aload 46
      // 8f4e: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8f51: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8f54: ifne 8f72
      // 8f57: aload 46
      // 8f59: new net/minecraft/world/effect/MobEffectInstance
      // 8f5c: dup
      // 8f5d: getstatic net/arphex/init/ArphexModMobEffects.WEBBED Lnet/minecraftforge/registries/RegistryObject;
      // 8f60: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8f63: checkcast net/minecraft/world/effect/MobEffect
      // 8f66: bipush 120
      // 8f68: bipush 3
      // 8f69: bipush 0
      // 8f6a: bipush 0
      // 8f6b: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8f6e: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8f71: pop
      // 8f72: aload 9
      // 8f74: instanceof net/minecraft/world/entity/LivingEntity
      // 8f77: ifeq 8fa1
      // 8f7a: aload 9
      // 8f7c: checkcast net/minecraft/world/entity/LivingEntity
      // 8f7f: astore 46
      // 8f81: aload 46
      // 8f83: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8f86: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8f89: ifne 8fa1
      // 8f8c: aload 46
      // 8f8e: new net/minecraft/world/effect/MobEffectInstance
      // 8f91: dup
      // 8f92: getstatic net/minecraft/world/effect/MobEffects.WEAKNESS Lnet/minecraft/world/effect/MobEffect;
      // 8f95: bipush 60
      // 8f97: bipush 3
      // 8f98: bipush 0
      // 8f99: bipush 0
      // 8f9a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 8f9d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8fa0: pop
      // 8fa1: aload 11
      // 8fa3: instanceof net/minecraft/world/entity/LivingEntity
      // 8fa6: ifeq 8fbf
      // 8fa9: aload 11
      // 8fab: checkcast net/minecraft/world/entity/LivingEntity
      // 8fae: astore 46
      // 8fb0: aload 46
      // 8fb2: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 8fb5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8fb8: checkcast net/minecraft/world/effect/MobEffect
      // 8fbb: invokevirtual net/minecraft/world/entity/LivingEntity.removeEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8fbe: pop
      // 8fbf: aload 9
      // 8fc1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8fc4: ldc_w "ascendedprotection"
      // 8fc7: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8fca: dconst_0
      // 8fcb: dcmpl
      // 8fcc: ifle 901d
      // 8fcf: aload 11
      // 8fd1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8fd4: ldc_w "ascendedprotection"
      // 8fd7: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8fda: dconst_0
      // 8fdb: dcmpl
      // 8fdc: ifgt 901d
      // 8fdf: aload 11
      // 8fe1: instanceof net/minecraft/world/entity/player/Player
      // 8fe4: ifeq 900d
      // 8fe7: aload 11
      // 8fe9: instanceof net/minecraft/world/entity/player/Player
      // 8fec: ifeq 900d
      // 8fef: aload 11
      // 8ff1: checkcast net/minecraft/world/entity/player/Player
      // 8ff4: astore 45
      // 8ff6: aload 45
      // 8ff8: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 8ffb: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 8ffe: ifne 900d
      // 9001: aload 45
      // 9003: ldc_w "Forcefield blocked attack"
      // 9006: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 9009: bipush 1
      // 900a: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 900d: aload 0
      // 900e: ifnull 901d
      // 9011: aload 0
      // 9012: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9015: ifeq 901d
      // 9018: aload 0
      // 9019: bipush 1
      // 901a: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 901d: aload 11
      // 901f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 9022: ldc_w "ascendedprotection"
      // 9025: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 9028: dconst_0
      // 9029: dcmpl
      // 902a: ifle 907b
      // 902d: aload 9
      // 902f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 9032: ldc_w "ascendedprotection"
      // 9035: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 9038: dconst_0
      // 9039: dcmpl
      // 903a: ifgt 907b
      // 903d: aload 11
      // 903f: instanceof net/minecraft/world/entity/player/Player
      // 9042: ifeq 906b
      // 9045: aload 11
      // 9047: instanceof net/minecraft/world/entity/player/Player
      // 904a: ifeq 906b
      // 904d: aload 11
      // 904f: checkcast net/minecraft/world/entity/player/Player
      // 9052: astore 45
      // 9054: aload 45
      // 9056: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 9059: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 905c: ifne 906b
      // 905f: aload 45
      // 9061: ldc_w "Forcefield blocked attack"
      // 9064: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 9067: bipush 1
      // 9068: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 906b: aload 0
      // 906c: ifnull 907b
      // 906f: aload 0
      // 9070: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9073: ifeq 907b
      // 9076: aload 0
      // 9077: bipush 1
      // 9078: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 907b: aload 9
      // 907d: instanceof net/arphex/entity/TormentorLaserEntity
      // 9080: ifeq 9093
      // 9083: aload 0
      // 9084: ifnull 9093
      // 9087: aload 0
      // 9088: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 908b: ifeq 9093
      // 908e: aload 0
      // 908f: bipush 1
      // 9090: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 9093: aload 9
      // 9095: instanceof net/minecraft/world/entity/player/Player
      // 9098: ifeq 93f4
      // 909b: aload 9
      // 909d: instanceof net/minecraft/world/entity/LivingEntity
      // 90a0: ifeq 90b5
      // 90a3: aload 9
      // 90a5: checkcast net/minecraft/world/entity/LivingEntity
      // 90a8: astore 45
      // 90aa: aload 45
      // 90ac: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 90af: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 90b2: goto 90b8
      // 90b5: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 90b8: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 90bb: getstatic net/arphex/init/ArphexModItems.JUGGERNAUT_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 90be: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 90c1: if_acmpeq 90ed
      // 90c4: aload 9
      // 90c6: instanceof net/minecraft/world/entity/LivingEntity
      // 90c9: ifeq 90de
      // 90cc: aload 9
      // 90ce: checkcast net/minecraft/world/entity/LivingEntity
      // 90d1: astore 46
      // 90d3: aload 46
      // 90d5: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 90d8: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 90db: goto 90e1
      // 90de: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 90e1: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 90e4: getstatic net/arphex/init/ArphexModItems.IMMORTAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 90e7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 90ea: if_acmpne 93bc
      // 90ed: aload 9
      // 90ef: instanceof net/minecraft/world/entity/LivingEntity
      // 90f2: ifeq 9107
      // 90f5: aload 9
      // 90f7: checkcast net/minecraft/world/entity/LivingEntity
      // 90fa: astore 47
      // 90fc: aload 47
      // 90fe: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 9101: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 9104: goto 910a
      // 9107: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 910a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 910d: getstatic net/arphex/init/ArphexModItems.JUGGERNAUT_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 9110: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9113: if_acmpeq 913f
      // 9116: aload 9
      // 9118: instanceof net/minecraft/world/entity/LivingEntity
      // 911b: ifeq 9130
      // 911e: aload 9
      // 9120: checkcast net/minecraft/world/entity/LivingEntity
      // 9123: astore 48
      // 9125: aload 48
      // 9127: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 912a: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 912d: goto 9133
      // 9130: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9133: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 9136: getstatic net/arphex/init/ArphexModItems.IMMORTAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 9139: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 913c: if_acmpne 93bc
      // 913f: aload 9
      // 9141: instanceof net/minecraft/world/entity/player/Player
      // 9144: ifeq 9179
      // 9147: aload 9
      // 9149: checkcast net/minecraft/world/entity/player/Player
      // 914c: astore 49
      // 914e: aload 49
      // 9150: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 9153: aload 9
      // 9155: instanceof net/minecraft/world/entity/LivingEntity
      // 9158: ifeq 916d
      // 915b: aload 9
      // 915d: checkcast net/minecraft/world/entity/LivingEntity
      // 9160: astore 50
      // 9162: aload 50
      // 9164: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 9167: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 916a: goto 9170
      // 916d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9170: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 9173: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 9176: ifne 91a2
      // 9179: aload 9
      // 917b: instanceof net/minecraft/world/entity/LivingEntity
      // 917e: ifeq 9193
      // 9181: aload 9
      // 9183: checkcast net/minecraft/world/entity/LivingEntity
      // 9186: astore 51
      // 9188: aload 51
      // 918a: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 918d: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 9190: goto 9196
      // 9193: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9196: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 9199: getstatic net/arphex/init/ArphexModItems.JUGGERNAUT_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 919c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 919f: if_acmpeq 9205
      // 91a2: aload 9
      // 91a4: instanceof net/minecraft/world/entity/player/Player
      // 91a7: ifeq 93bc
      // 91aa: aload 9
      // 91ac: checkcast net/minecraft/world/entity/player/Player
      // 91af: astore 52
      // 91b1: aload 52
      // 91b3: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 91b6: aload 9
      // 91b8: instanceof net/minecraft/world/entity/LivingEntity
      // 91bb: ifeq 91d0
      // 91be: aload 9
      // 91c0: checkcast net/minecraft/world/entity/LivingEntity
      // 91c3: astore 53
      // 91c5: aload 53
      // 91c7: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 91ca: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 91cd: goto 91d3
      // 91d0: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 91d3: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 91d6: invokevirtual net/minecraft/world/item/ItemCooldowns.isOnCooldown (Lnet/minecraft/world/item/Item;)Z
      // 91d9: ifeq 93bc
      // 91dc: aload 9
      // 91de: instanceof net/minecraft/world/entity/LivingEntity
      // 91e1: ifeq 91f6
      // 91e4: aload 9
      // 91e6: checkcast net/minecraft/world/entity/LivingEntity
      // 91e9: astore 54
      // 91eb: aload 54
      // 91ed: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 91f0: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 91f3: goto 91f9
      // 91f6: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 91f9: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 91fc: getstatic net/arphex/init/ArphexModItems.IMMORTAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 91ff: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9202: if_acmpne 93bc
      // 9205: aload 9
      // 9207: instanceof net/minecraft/world/entity/LivingEntity
      // 920a: ifeq 921f
      // 920d: aload 9
      // 920f: checkcast net/minecraft/world/entity/LivingEntity
      // 9212: astore 55
      // 9214: aload 55
      // 9216: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 9219: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 921c: goto 9222
      // 921f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9222: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 9225: getstatic net/arphex/init/ArphexModItems.JUGGERNAUT_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 9228: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 922b: if_acmpeq 9257
      // 922e: aload 9
      // 9230: instanceof net/minecraft/world/entity/LivingEntity
      // 9233: ifeq 9248
      // 9236: aload 9
      // 9238: checkcast net/minecraft/world/entity/LivingEntity
      // 923b: astore 56
      // 923d: aload 56
      // 923f: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 9242: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 9245: goto 924b
      // 9248: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 924b: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 924e: getstatic net/arphex/init/ArphexModItems.IMMORTAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 9251: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9254: if_acmpne 93bc
      // 9257: aload 9
      // 9259: instanceof net/minecraft/world/entity/LivingEntity
      // 925c: ifeq 9271
      // 925f: aload 9
      // 9261: checkcast net/minecraft/world/entity/LivingEntity
      // 9264: astore 57
      // 9266: aload 57
      // 9268: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 926b: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 926e: goto 9274
      // 9271: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9274: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 9277: getstatic net/arphex/init/ArphexModItems.JUGGERNAUT_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 927a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 927d: if_acmpeq 92a9
      // 9280: aload 9
      // 9282: instanceof net/minecraft/world/entity/LivingEntity
      // 9285: ifeq 929a
      // 9288: aload 9
      // 928a: checkcast net/minecraft/world/entity/LivingEntity
      // 928d: astore 58
      // 928f: aload 58
      // 9291: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 9294: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 9297: goto 929d
      // 929a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 929d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 92a0: getstatic net/arphex/init/ArphexModItems.IMMORTAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 92a3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 92a6: if_acmpne 93bc
      // 92a9: aload 9
      // 92ab: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 92ae: aload 11
      // 92b0: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 92b3: dsub
      // 92b4: aload 9
      // 92b6: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 92b9: aload 11
      // 92bb: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 92be: dsub
      // 92bf: invokestatic java/lang/Math.atan2 (DD)D
      // 92c2: invokestatic java/lang/Math.toDegrees (D)D
      // 92c5: aload 9
      // 92c7: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 92ca: f2d
      // 92cb: dsub
      // 92cc: ldc2_w 360.0
      // 92cf: dadd
      // 92d0: ldc2_w 360.0
      // 92d3: drem
      // 92d4: ldc2_w 270.0
      // 92d7: dsub
      // 92d8: invokestatic java/lang/Math.abs (D)D
      // 92db: ldc2_w 360.0
      // 92de: aload 9
      // 92e0: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 92e3: aload 11
      // 92e5: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 92e8: dsub
      // 92e9: aload 9
      // 92eb: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 92ee: aload 11
      // 92f0: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 92f3: dsub
      // 92f4: invokestatic java/lang/Math.atan2 (DD)D
      // 92f7: invokestatic java/lang/Math.toDegrees (D)D
      // 92fa: aload 9
      // 92fc: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 92ff: f2d
      // 9300: dsub
      // 9301: ldc2_w 360.0
      // 9304: dadd
      // 9305: ldc2_w 360.0
      // 9308: drem
      // 9309: ldc2_w 270.0
      // 930c: dsub
      // 930d: invokestatic java/lang/Math.abs (D)D
      // 9310: dsub
      // 9311: invokestatic java/lang/Math.min (DD)D
      // 9314: ldc2_w 90.0
      // 9317: dcmpl
      // 9318: ifle 93bc
      // 931b: aload 9
      // 931d: instanceof net/minecraft/world/entity/LivingEntity
      // 9320: ifeq 9335
      // 9323: aload 9
      // 9325: checkcast net/minecraft/world/entity/LivingEntity
      // 9328: astore 59
      // 932a: aload 59
      // 932c: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 932f: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 9332: goto 9338
      // 9335: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9338: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 933b: getstatic net/arphex/init/ArphexModItems.JUGGERNAUT_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 933e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9341: if_acmpne 937d
      // 9344: aload 9
      // 9346: instanceof net/minecraft/world/entity/player/Player
      // 9349: ifeq 937d
      // 934c: aload 9
      // 934e: checkcast net/minecraft/world/entity/player/Player
      // 9351: astore 60
      // 9353: aload 60
      // 9355: invokevirtual net/minecraft/world/entity/player/Player.getCooldowns ()Lnet/minecraft/world/item/ItemCooldowns;
      // 9358: aload 9
      // 935a: instanceof net/minecraft/world/entity/LivingEntity
      // 935d: ifeq 9372
      // 9360: aload 9
      // 9362: checkcast net/minecraft/world/entity/LivingEntity
      // 9365: astore 61
      // 9367: aload 61
      // 9369: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 936c: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 936f: goto 9375
      // 9372: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9375: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 9378: bipush 100
      // 937a: invokevirtual net/minecraft/world/item/ItemCooldowns.addCooldown (Lnet/minecraft/world/item/Item;I)V
      // 937d: aload 1
      // 937e: instanceof net/minecraft/server/level/ServerLevel
      // 9381: ifeq 93ac
      // 9384: aload 1
      // 9385: checkcast net/minecraft/server/level/ServerLevel
      // 9388: astore 59
      // 938a: aload 59
      // 938c: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 938f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9392: checkcast net/minecraft/core/particles/SimpleParticleType
      // 9395: dload 2
      // 9396: dload 4
      // 9398: dload 6
      // 939a: bipush 20
      // 939c: ldc2_w 0.4
      // 939f: ldc2_w 0.4
      // 93a2: ldc2_w 0.4
      // 93a5: ldc2_w 0.2
      // 93a8: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 93ab: pop
      // 93ac: aload 0
      // 93ad: ifnull 93bc
      // 93b0: aload 0
      // 93b1: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 93b4: ifeq 93bc
      // 93b7: aload 0
      // 93b8: bipush 1
      // 93b9: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 93bc: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.FRIENDLY_MODE Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 93bf: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 93c2: checkcast java/lang/Boolean
      // 93c5: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 93c8: ifeq 93f4
      // 93cb: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 93ce: aload 11
      // 93d0: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 93d3: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 93d8: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 93db: ldc_w "arphex:"
      // 93de: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 93e1: ifeq 93f4
      // 93e4: aload 0
      // 93e5: ifnull 93f4
      // 93e8: aload 0
      // 93e9: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 93ec: ifeq 93f4
      // 93ef: aload 0
      // 93f0: bipush 1
      // 93f1: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 93f4: aload 11
      // 93f6: instanceof net/arphex/entity/TinyCentipedeBreacherEntity
      // 93f9: ifeq 940c
      // 93fc: aload 11
      // 93fe: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 9401: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9404: ifne 940c
      // 9407: aload 11
      // 9409: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 940c: aload 11
      // 940e: instanceof net/arphex/entity/SpiderReaperEntity
      // 9411: ifeq 956f
      // 9414: aload 1
      // 9415: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 941a: ifne 956f
      // 941d: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 9420: bipush 1
      // 9421: bipush 4
      // 9422: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 9425: bipush 3
      // 9426: if_icmpne 94c6
      // 9429: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 942c: bipush -3
      // 942e: bipush 3
      // 942f: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 9432: i2d
      // 9433: dstore 31
      // 9435: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 9438: bipush -3
      // 943a: bipush 3
      // 943b: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 943e: i2d
      // 943f: dstore 33
      // 9441: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 9444: bipush -3
      // 9446: bipush 3
      // 9447: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 944a: i2d
      // 944b: dstore 35
      // 944d: aload 1
      // 944e: aload 9
      // 9450: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 9453: dload 31
      // 9455: dadd
      // 9456: aload 9
      // 9458: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 945b: dload 33
      // 945d: dadd
      // 945e: aload 9
      // 9460: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 9463: dload 35
      // 9465: dadd
      // 9466: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 9469: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 946e: ifeq 94c6
      // 9471: aload 1
      // 9472: aload 9
      // 9474: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 9477: dload 31
      // 9479: dadd
      // 947a: aload 9
      // 947c: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 947f: dload 33
      // 9481: dadd
      // 9482: dconst_1
      // 9483: dsub
      // 9484: aload 9
      // 9486: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 9489: dload 35
      // 948b: dadd
      // 948c: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 948f: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 9494: ifne 94c6
      // 9497: aload 1
      // 9498: aload 9
      // 949a: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 949d: dload 31
      // 949f: dadd
      // 94a0: aload 9
      // 94a2: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 94a5: dload 33
      // 94a7: dadd
      // 94a8: aload 9
      // 94aa: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 94ad: dload 35
      // 94af: dadd
      // 94b0: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 94b3: getstatic net/arphex/init/ArphexModBlocks.REAPER_WEB Lnet/minecraftforge/registries/RegistryObject;
      // 94b6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 94b9: checkcast net/minecraft/world/level/block/Block
      // 94bc: invokevirtual net/minecraft/world/level/block/Block.defaultBlockState ()Lnet/minecraft/world/level/block/state/BlockState;
      // 94bf: bipush 3
      // 94c0: invokeinterface net/minecraft/world/level/LevelAccessor.setBlock (Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z 4
      // 94c5: pop
      // 94c6: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 94c9: bipush 1
      // 94ca: bipush 4
      // 94cb: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 94ce: bipush 3
      // 94cf: if_icmpne 956f
      // 94d2: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 94d5: bipush -3
      // 94d7: bipush 3
      // 94d8: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 94db: i2d
      // 94dc: dstore 31
      // 94de: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 94e1: bipush -3
      // 94e3: bipush 3
      // 94e4: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 94e7: i2d
      // 94e8: dstore 33
      // 94ea: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 94ed: bipush -3
      // 94ef: bipush 3
      // 94f0: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 94f3: i2d
      // 94f4: dstore 35
      // 94f6: aload 1
      // 94f7: aload 9
      // 94f9: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 94fc: dload 31
      // 94fe: dadd
      // 94ff: aload 9
      // 9501: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 9504: dload 33
      // 9506: dadd
      // 9507: aload 9
      // 9509: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 950c: dload 35
      // 950e: dadd
      // 950f: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 9512: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 9517: ifeq 956f
      // 951a: aload 1
      // 951b: aload 9
      // 951d: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 9520: dload 31
      // 9522: dadd
      // 9523: aload 9
      // 9525: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 9528: dload 33
      // 952a: dadd
      // 952b: dconst_1
      // 952c: dsub
      // 952d: aload 9
      // 952f: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 9532: dload 35
      // 9534: dadd
      // 9535: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 9538: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 953d: ifne 956f
      // 9540: aload 1
      // 9541: aload 9
      // 9543: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 9546: dload 31
      // 9548: dadd
      // 9549: aload 9
      // 954b: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 954e: dload 33
      // 9550: dadd
      // 9551: aload 9
      // 9553: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 9556: dload 35
      // 9558: dadd
      // 9559: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 955c: getstatic net/arphex/init/ArphexModBlocks.REAPER_WEB Lnet/minecraftforge/registries/RegistryObject;
      // 955f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9562: checkcast net/minecraft/world/level/block/Block
      // 9565: invokevirtual net/minecraft/world/level/block/Block.defaultBlockState ()Lnet/minecraft/world/level/block/state/BlockState;
      // 9568: bipush 3
      // 9569: invokeinterface net/minecraft/world/level/LevelAccessor.setBlock (Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z 4
      // 956e: pop
      // 956f: aload 11
      // 9571: instanceof net/arphex/entity/SpiderRecluseEntity
      // 9574: ifeq 95c2
      // 9577: aload 9
      // 9579: instanceof net/minecraft/world/entity/LivingEntity
      // 957c: ifeq 958e
      // 957f: aload 9
      // 9581: checkcast net/minecraft/world/entity/LivingEntity
      // 9584: astore 45
      // 9586: aload 45
      // 9588: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 958b: ifne 95c2
      // 958e: aload 9
      // 9590: instanceof net/minecraft/world/entity/LivingEntity
      // 9593: ifeq 95c2
      // 9596: aload 9
      // 9598: checkcast net/minecraft/world/entity/LivingEntity
      // 959b: astore 46
      // 959d: aload 46
      // 959f: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 95a2: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 95a5: ifne 95c2
      // 95a8: aload 46
      // 95aa: new net/minecraft/world/effect/MobEffectInstance
      // 95ad: dup
      // 95ae: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 95b1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 95b4: checkcast net/minecraft/world/effect/MobEffect
      // 95b7: sipush 200
      // 95ba: bipush 1
      // 95bb: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 95be: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 95c1: pop
      // 95c2: aload 9
      // 95c4: instanceof net/arphex/entity/TormentorMothSummonEntity
      // 95c7: ifne 95da
      // 95ca: aload 9
      // 95cc: instanceof net/arphex/entity/TormentorMothSummonEntity
      // 95cf: ifne 95da
      // 95d2: aload 9
      // 95d4: instanceof net/arphex/entity/TormentorMothSummonEntity
      // 95d7: ifeq 9656
      // 95da: aload 11
      // 95dc: instanceof net/minecraft/world/entity/player/Player
      // 95df: ifeq 9656
      // 95e2: aload 9
      // 95e4: instanceof net/minecraft/world/entity/LivingEntity
      // 95e7: ifeq 9610
      // 95ea: aload 9
      // 95ec: checkcast net/minecraft/world/entity/LivingEntity
      // 95ef: astore 45
      // 95f1: aload 45
      // 95f3: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 95f6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 95f9: ifne 9610
      // 95fc: aload 45
      // 95fe: new net/minecraft/world/effect/MobEffectInstance
      // 9601: dup
      // 9602: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 9605: bipush 3
      // 9606: bipush 0
      // 9607: bipush 0
      // 9608: bipush 0
      // 9609: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 960c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 960f: pop
      // 9610: aload 9
      // 9612: instanceof net/minecraft/world/entity/LivingEntity
      // 9615: ifeq 9645
      // 9618: aload 9
      // 961a: checkcast net/minecraft/world/entity/LivingEntity
      // 961d: astore 45
      // 961f: aload 45
      // 9621: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9624: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9627: ifne 9645
      // 962a: aload 45
      // 962c: new net/minecraft/world/effect/MobEffectInstance
      // 962f: dup
      // 9630: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 9633: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9636: checkcast net/minecraft/world/effect/MobEffect
      // 9639: bipush 40
      // 963b: bipush 0
      // 963c: bipush 0
      // 963d: bipush 0
      // 963e: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 9641: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9644: pop
      // 9645: bipush 3
      // 9646: aload 9
      // 9648: aload 1
      // 9649: dload 2
      // 964a: dload 4
      // 964c: dload 6
      // 964e: invokedynamic run (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$121 (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 9653: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 9656: aload 11
      // 9658: instanceof net/arphex/entity/MantisMutilatorEntity
      // 965b: ifeq 967e
      // 965e: aload 9
      // 9660: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 9663: aload 11
      // 9665: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 9668: dconst_1
      // 9669: dadd
      // 966a: dcmpl
      // 966b: ifle 967e
      // 966e: aload 0
      // 966f: ifnull 967e
      // 9672: aload 0
      // 9673: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9676: ifeq 967e
      // 9679: aload 0
      // 967a: bipush 1
      // 967b: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 967e: getstatic net/arphex/init/ArphexModEnchantments.WITHER_AURA Lnet/minecraftforge/registries/RegistryObject;
      // 9681: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9684: checkcast net/minecraft/world/item/enchantment/Enchantment
      // 9687: aload 11
      // 9689: instanceof net/minecraft/world/entity/LivingEntity
      // 968c: ifeq 969e
      // 968f: aload 11
      // 9691: checkcast net/minecraft/world/entity/LivingEntity
      // 9694: astore 45
      // 9696: aload 45
      // 9698: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 969b: goto 96a1
      // 969e: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 96a1: invokestatic net/minecraft/world/item/enchantment/EnchantmentHelper.getItemEnchantmentLevel (Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/item/ItemStack;)I
      // 96a4: ifeq 9805
      // 96a7: aload 11
      // 96a9: instanceof net/minecraft/world/entity/LivingEntity
      // 96ac: ifeq 96be
      // 96af: aload 11
      // 96b1: checkcast net/minecraft/world/entity/LivingEntity
      // 96b4: astore 46
      // 96b6: aload 46
      // 96b8: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 96bb: goto 96c1
      // 96be: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 96c1: getstatic net/arphex/init/ArphexModEnchantments.WITHER_AURA Lnet/minecraftforge/registries/RegistryObject;
      // 96c4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 96c7: checkcast net/minecraft/world/item/enchantment/Enchantment
      // 96ca: invokevirtual net/minecraft/world/item/ItemStack.getEnchantmentLevel (Lnet/minecraft/world/item/enchantment/Enchantment;)I
      // 96cd: ifne 96fd
      // 96d0: aload 9
      // 96d2: instanceof net/minecraft/world/entity/LivingEntity
      // 96d5: ifeq 96fd
      // 96d8: aload 9
      // 96da: checkcast net/minecraft/world/entity/LivingEntity
      // 96dd: astore 47
      // 96df: aload 47
      // 96e1: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 96e4: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 96e7: ifne 96fd
      // 96ea: aload 47
      // 96ec: new net/minecraft/world/effect/MobEffectInstance
      // 96ef: dup
      // 96f0: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 96f3: bipush 60
      // 96f5: bipush 0
      // 96f6: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 96f9: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 96fc: pop
      // 96fd: aload 11
      // 96ff: instanceof net/minecraft/world/entity/LivingEntity
      // 9702: ifeq 9714
      // 9705: aload 11
      // 9707: checkcast net/minecraft/world/entity/LivingEntity
      // 970a: astore 46
      // 970c: aload 46
      // 970e: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 9711: goto 9717
      // 9714: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 9717: getstatic net/arphex/init/ArphexModEnchantments.WITHER_AURA Lnet/minecraftforge/registries/RegistryObject;
      // 971a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 971d: checkcast net/minecraft/world/item/enchantment/Enchantment
      // 9720: invokevirtual net/minecraft/world/item/ItemStack.getEnchantmentLevel (Lnet/minecraft/world/item/enchantment/Enchantment;)I
      // 9723: bipush 1
      // 9724: if_icmpne 9781
      // 9727: aload 9
      // 9729: instanceof net/minecraft/world/entity/LivingEntity
      // 972c: ifeq 9754
      // 972f: aload 9
      // 9731: checkcast net/minecraft/world/entity/LivingEntity
      // 9734: astore 47
      // 9736: aload 47
      // 9738: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 973b: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 973e: ifne 9754
      // 9741: aload 47
      // 9743: new net/minecraft/world/effect/MobEffectInstance
      // 9746: dup
      // 9747: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 974a: bipush 60
      // 974c: bipush 0
      // 974d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 9750: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9753: pop
      // 9754: aload 9
      // 9756: instanceof net/minecraft/world/entity/LivingEntity
      // 9759: ifeq 9781
      // 975c: aload 9
      // 975e: checkcast net/minecraft/world/entity/LivingEntity
      // 9761: astore 47
      // 9763: aload 47
      // 9765: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9768: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 976b: ifne 9781
      // 976e: aload 47
      // 9770: new net/minecraft/world/effect/MobEffectInstance
      // 9773: dup
      // 9774: getstatic net/minecraft/world/effect/MobEffects.DARKNESS Lnet/minecraft/world/effect/MobEffect;
      // 9777: bipush 60
      // 9779: bipush 0
      // 977a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 977d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9780: pop
      // 9781: aload 11
      // 9783: instanceof net/minecraft/world/entity/LivingEntity
      // 9786: ifeq 9798
      // 9789: aload 11
      // 978b: checkcast net/minecraft/world/entity/LivingEntity
      // 978e: astore 46
      // 9790: aload 46
      // 9792: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 9795: goto 979b
      // 9798: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 979b: getstatic net/arphex/init/ArphexModEnchantments.WITHER_AURA Lnet/minecraftforge/registries/RegistryObject;
      // 979e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 97a1: checkcast net/minecraft/world/item/enchantment/Enchantment
      // 97a4: invokevirtual net/minecraft/world/item/ItemStack.getEnchantmentLevel (Lnet/minecraft/world/item/enchantment/Enchantment;)I
      // 97a7: bipush 2
      // 97a8: if_icmplt 9805
      // 97ab: aload 9
      // 97ad: instanceof net/minecraft/world/entity/LivingEntity
      // 97b0: ifeq 97d8
      // 97b3: aload 9
      // 97b5: checkcast net/minecraft/world/entity/LivingEntity
      // 97b8: astore 47
      // 97ba: aload 47
      // 97bc: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 97bf: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 97c2: ifne 97d8
      // 97c5: aload 47
      // 97c7: new net/minecraft/world/effect/MobEffectInstance
      // 97ca: dup
      // 97cb: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 97ce: bipush 60
      // 97d0: bipush 1
      // 97d1: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 97d4: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 97d7: pop
      // 97d8: aload 9
      // 97da: instanceof net/minecraft/world/entity/LivingEntity
      // 97dd: ifeq 9805
      // 97e0: aload 9
      // 97e2: checkcast net/minecraft/world/entity/LivingEntity
      // 97e5: astore 47
      // 97e7: aload 47
      // 97e9: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 97ec: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 97ef: ifne 9805
      // 97f2: aload 47
      // 97f4: new net/minecraft/world/effect/MobEffectInstance
      // 97f7: dup
      // 97f8: getstatic net/minecraft/world/effect/MobEffects.DARKNESS Lnet/minecraft/world/effect/MobEffect;
      // 97fb: bipush 60
      // 97fd: bipush 0
      // 97fe: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 9801: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9804: pop
      // 9805: aload 9
      // 9807: instanceof net/minecraft/world/entity/player/Player
      // 980a: ifeq 982b
      // 980d: aload 11
      // 980f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 9812: ldc_w "unable_to_attack_player_arphex"
      // 9815: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 9818: ifeq 982b
      // 981b: aload 0
      // 981c: ifnull 982b
      // 981f: aload 0
      // 9820: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9823: ifeq 982b
      // 9826: aload 0
      // 9827: bipush 1
      // 9828: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 982b: aload 11
      // 982d: instanceof net/arphex/entity/SpiderObstructerEntity
      // 9830: ifeq 9991
      // 9833: aload 9
      // 9835: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 9838: ldc "creativespectator"
      // 983a: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 983d: ifne 9991
      // 9840: aload 9
      // 9842: instanceof net/minecraft/world/entity/LivingEntity
      // 9845: ifeq 9857
      // 9848: aload 9
      // 984a: checkcast net/minecraft/world/entity/LivingEntity
      // 984d: astore 45
      // 984f: aload 45
      // 9851: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 9854: goto 9858
      // 9857: bipush 0
      // 9858: bipush 20
      // 985a: if_icmpge 9991
      // 985d: aload 11
      // 985f: instanceof net/arphex/entity/SpiderObstructerEntity
      // 9862: ifeq 9880
      // 9865: aload 11
      // 9867: checkcast net/arphex/entity/SpiderObstructerEntity
      // 986a: astore 46
      // 986c: aload 46
      // 986e: invokevirtual net/arphex/entity/SpiderObstructerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 9871: getstatic net/arphex/entity/SpiderObstructerEntity.DATA_trapdoor_x Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 9874: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 9877: checkcast java/lang/Integer
      // 987a: invokevirtual java/lang/Integer.intValue ()I
      // 987d: goto 9881
      // 9880: bipush 0
      // 9881: ifne 98d2
      // 9884: aload 11
      // 9886: instanceof net/arphex/entity/SpiderObstructerEntity
      // 9889: ifeq 98a7
      // 988c: aload 11
      // 988e: checkcast net/arphex/entity/SpiderObstructerEntity
      // 9891: astore 47
      // 9893: aload 47
      // 9895: invokevirtual net/arphex/entity/SpiderObstructerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 9898: getstatic net/arphex/entity/SpiderObstructerEntity.DATA_trapdoor_y Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 989b: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 989e: checkcast java/lang/Integer
      // 98a1: invokevirtual java/lang/Integer.intValue ()I
      // 98a4: goto 98a8
      // 98a7: bipush 0
      // 98a8: ifne 98d2
      // 98ab: aload 11
      // 98ad: instanceof net/arphex/entity/SpiderObstructerEntity
      // 98b0: ifeq 98ce
      // 98b3: aload 11
      // 98b5: checkcast net/arphex/entity/SpiderObstructerEntity
      // 98b8: astore 48
      // 98ba: aload 48
      // 98bc: invokevirtual net/arphex/entity/SpiderObstructerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 98bf: getstatic net/arphex/entity/SpiderObstructerEntity.DATA_trapdoor_z Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 98c2: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 98c5: checkcast java/lang/Integer
      // 98c8: invokevirtual java/lang/Integer.intValue ()I
      // 98cb: goto 98cf
      // 98ce: bipush 0
      // 98cf: ifeq 9991
      // 98d2: aload 9
      // 98d4: instanceof net/minecraft/world/entity/LivingEntity
      // 98d7: ifeq 98e9
      // 98da: aload 9
      // 98dc: checkcast net/minecraft/world/entity/LivingEntity
      // 98df: astore 49
      // 98e1: aload 49
      // 98e3: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 98e6: ifne 9991
      // 98e9: aload 9
      // 98eb: invokevirtual net/minecraft/world/entity/Entity.isPassenger ()Z
      // 98ee: ifne 9991
      // 98f1: aload 11
      // 98f3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 98f6: ldc_w "target_in_burrow"
      // 98f9: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 98fc: dconst_0
      // 98fd: dcmpl
      // 98fe: ifgt 9991
      // 9901: aload 9
      // 9903: aload 11
      // 9905: invokevirtual net/minecraft/world/entity/Entity.startRiding (Lnet/minecraft/world/entity/Entity;)Z
      // 9908: pop
      // 9909: aload 11
      // 990b: instanceof net/minecraft/world/entity/Mob
      // 990e: ifeq 9991
      // 9911: aload 11
      // 9913: checkcast net/minecraft/world/entity/Mob
      // 9916: astore 50
      // 9918: aload 50
      // 991a: invokevirtual net/minecraft/world/entity/Mob.getNavigation ()Lnet/minecraft/world/entity/ai/navigation/PathNavigation;
      // 991d: aload 11
      // 991f: instanceof net/arphex/entity/SpiderObstructerEntity
      // 9922: ifeq 9941
      // 9925: aload 11
      // 9927: checkcast net/arphex/entity/SpiderObstructerEntity
      // 992a: astore 51
      // 992c: aload 51
      // 992e: invokevirtual net/arphex/entity/SpiderObstructerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 9931: getstatic net/arphex/entity/SpiderObstructerEntity.DATA_trapdoor_x Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 9934: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 9937: checkcast java/lang/Integer
      // 993a: invokevirtual java/lang/Integer.intValue ()I
      // 993d: i2d
      // 993e: goto 9942
      // 9941: dconst_0
      // 9942: aload 11
      // 9944: instanceof net/arphex/entity/SpiderObstructerEntity
      // 9947: ifeq 9966
      // 994a: aload 11
      // 994c: checkcast net/arphex/entity/SpiderObstructerEntity
      // 994f: astore 52
      // 9951: aload 52
      // 9953: invokevirtual net/arphex/entity/SpiderObstructerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 9956: getstatic net/arphex/entity/SpiderObstructerEntity.DATA_trapdoor_y Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 9959: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 995c: checkcast java/lang/Integer
      // 995f: invokevirtual java/lang/Integer.intValue ()I
      // 9962: i2d
      // 9963: goto 9967
      // 9966: dconst_0
      // 9967: aload 11
      // 9969: instanceof net/arphex/entity/SpiderObstructerEntity
      // 996c: ifeq 998b
      // 996f: aload 11
      // 9971: checkcast net/arphex/entity/SpiderObstructerEntity
      // 9974: astore 53
      // 9976: aload 53
      // 9978: invokevirtual net/arphex/entity/SpiderObstructerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 997b: getstatic net/arphex/entity/SpiderObstructerEntity.DATA_trapdoor_z Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 997e: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 9981: checkcast java/lang/Integer
      // 9984: invokevirtual java/lang/Integer.intValue ()I
      // 9987: i2d
      // 9988: goto 998c
      // 998b: dconst_0
      // 998c: dconst_1
      // 998d: invokevirtual net/minecraft/world/entity/ai/navigation/PathNavigation.moveTo (DDDD)Z
      // 9990: pop
      // 9991: aload 9
      // 9993: instanceof net/arphex/entity/SpiderObstructerEntity
      // 9996: ifeq 99c7
      // 9999: aload 9
      // 999b: instanceof net/arphex/entity/SpiderObstructerEntity
      // 999e: ifeq 99b9
      // 99a1: aload 9
      // 99a3: checkcast net/arphex/entity/SpiderObstructerEntity
      // 99a6: astore 45
      // 99a8: aload 45
      // 99aa: invokevirtual net/arphex/entity/SpiderObstructerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 99ad: getstatic net/arphex/entity/SpiderObstructerEntity.DATA_cooldown Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 99b0: sipush 200
      // 99b3: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 99b6: invokevirtual net/minecraft/network/syncher/SynchedEntityData.set (Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;)V
      // 99b9: aload 9
      // 99bb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 99be: ldc_w "target_time_limit"
      // 99c1: ldc2_w 200.0
      // 99c4: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 99c7: aload 9
      // 99c9: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 99cc: ifeq 9a1c
      // 99cf: aload 11
      // 99d1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 99d4: ldc "creativespectator"
      // 99d6: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 99d9: ifne 9a1c
      // 99dc: aload 9
      // 99de: instanceof net/minecraft/world/entity/Mob
      // 99e1: ifeq 99f3
      // 99e4: aload 9
      // 99e6: checkcast net/minecraft/world/entity/Mob
      // 99e9: astore 45
      // 99eb: aload 45
      // 99ed: invokevirtual net/minecraft/world/entity/Mob.getTarget ()Lnet/minecraft/world/entity/LivingEntity;
      // 99f0: goto 99f4
      // 99f3: aconst_null
      // 99f4: ifnonnull 9a1c
      // 99f7: aload 9
      // 99f9: instanceof net/minecraft/world/entity/Mob
      // 99fc: ifeq 9a1c
      // 99ff: aload 9
      // 9a01: checkcast net/minecraft/world/entity/Mob
      // 9a04: astore 46
      // 9a06: aload 11
      // 9a08: instanceof net/minecraft/world/entity/LivingEntity
      // 9a0b: ifeq 9a1c
      // 9a0e: aload 11
      // 9a10: checkcast net/minecraft/world/entity/LivingEntity
      // 9a13: astore 47
      // 9a15: aload 46
      // 9a17: aload 47
      // 9a19: invokevirtual net/minecraft/world/entity/Mob.setTarget (Lnet/minecraft/world/entity/LivingEntity;)V
      // 9a1c: aload 11
      // 9a1e: instanceof net/arphex/entity/NemesisProjectileEntity
      // 9a21: ifeq 9aae
      // 9a24: aload 9
      // 9a26: instanceof net/minecraft/world/entity/LivingEntity
      // 9a29: ifeq 9a3e
      // 9a2c: aload 9
      // 9a2e: checkcast net/minecraft/world/entity/LivingEntity
      // 9a31: astore 45
      // 9a33: aload 45
      // 9a35: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 9a38: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 9a3b: ifne 9aae
      // 9a3e: aload 9
      // 9a40: instanceof net/minecraft/world/entity/LivingEntity
      // 9a43: ifeq 9a6d
      // 9a46: aload 9
      // 9a48: checkcast net/minecraft/world/entity/LivingEntity
      // 9a4b: astore 46
      // 9a4d: aload 46
      // 9a4f: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9a52: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9a55: ifne 9a6d
      // 9a58: aload 46
      // 9a5a: new net/minecraft/world/effect/MobEffectInstance
      // 9a5d: dup
      // 9a5e: getstatic net/minecraft/world/effect/MobEffects.WITHER Lnet/minecraft/world/effect/MobEffect;
      // 9a61: bipush 20
      // 9a63: bipush 1
      // 9a64: bipush 0
      // 9a65: bipush 0
      // 9a66: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 9a69: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9a6c: pop
      // 9a6d: bipush 10
      // 9a6f: aload 11
      // 9a71: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$122 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 9a76: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 9a79: aload 9
      // 9a7b: instanceof net/minecraft/world/entity/LivingEntity
      // 9a7e: ifeq 9aae
      // 9a81: aload 9
      // 9a83: checkcast net/minecraft/world/entity/LivingEntity
      // 9a86: astore 46
      // 9a88: aload 46
      // 9a8a: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9a8d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9a90: ifne 9aae
      // 9a93: aload 46
      // 9a95: new net/minecraft/world/effect/MobEffectInstance
      // 9a98: dup
      // 9a99: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 9a9c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9a9f: checkcast net/minecraft/world/effect/MobEffect
      // 9aa2: bipush 60
      // 9aa4: bipush 1
      // 9aa5: bipush 0
      // 9aa6: bipush 0
      // 9aa7: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 9aaa: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9aad: pop
      // 9aae: aload 11
      // 9ab0: instanceof net/arphex/entity/HornetProjectileEntity
      // 9ab3: ifeq 9b40
      // 9ab6: aload 9
      // 9ab8: instanceof net/minecraft/world/entity/LivingEntity
      // 9abb: ifeq 9ad0
      // 9abe: aload 9
      // 9ac0: checkcast net/minecraft/world/entity/LivingEntity
      // 9ac3: astore 45
      // 9ac5: aload 45
      // 9ac7: getstatic net/minecraft/world/effect/MobEffects.POISON Lnet/minecraft/world/effect/MobEffect;
      // 9aca: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 9acd: ifne 9b0b
      // 9ad0: aload 9
      // 9ad2: instanceof net/minecraft/world/entity/LivingEntity
      // 9ad5: ifeq 9aff
      // 9ad8: aload 9
      // 9ada: checkcast net/minecraft/world/entity/LivingEntity
      // 9add: astore 46
      // 9adf: aload 46
      // 9ae1: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9ae4: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9ae7: ifne 9aff
      // 9aea: aload 46
      // 9aec: new net/minecraft/world/effect/MobEffectInstance
      // 9aef: dup
      // 9af0: getstatic net/minecraft/world/effect/MobEffects.POISON Lnet/minecraft/world/effect/MobEffect;
      // 9af3: bipush 60
      // 9af5: bipush 0
      // 9af6: bipush 0
      // 9af7: bipush 0
      // 9af8: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 9afb: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9afe: pop
      // 9aff: bipush 10
      // 9b01: aload 11
      // 9b03: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$123 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 9b08: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 9b0b: aload 9
      // 9b0d: instanceof net/minecraft/world/entity/LivingEntity
      // 9b10: ifeq 9b40
      // 9b13: aload 9
      // 9b15: checkcast net/minecraft/world/entity/LivingEntity
      // 9b18: astore 45
      // 9b1a: aload 45
      // 9b1c: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9b1f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9b22: ifne 9b40
      // 9b25: aload 45
      // 9b27: new net/minecraft/world/effect/MobEffectInstance
      // 9b2a: dup
      // 9b2b: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 9b2e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9b31: checkcast net/minecraft/world/effect/MobEffect
      // 9b34: bipush 60
      // 9b36: bipush 1
      // 9b37: bipush 0
      // 9b38: bipush 0
      // 9b39: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 9b3c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9b3f: pop
      // 9b40: aload 9
      // 9b42: instanceof net/arphex/entity/HornetProjectileEntity
      // 9b45: ifne 9b50
      // 9b48: aload 9
      // 9b4a: instanceof net/arphex/entity/NemesisProjectileEntity
      // 9b4d: ifeq 9b9a
      // 9b50: aload 8
      // 9b52: getstatic net/minecraft/world/damagesource/DamageTypes.STING Lnet/minecraft/resources/ResourceKey;
      // 9b55: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 9b58: ifne 9b9a
      // 9b5b: aload 0
      // 9b5c: ifnull 9b6b
      // 9b5f: aload 0
      // 9b60: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9b63: ifeq 9b6b
      // 9b66: aload 0
      // 9b67: bipush 1
      // 9b68: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 9b6b: aload 9
      // 9b6d: new net/minecraft/world/damagesource/DamageSource
      // 9b70: dup
      // 9b71: aload 1
      // 9b72: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 9b77: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 9b7a: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 9b7f: getstatic net/minecraft/world/damagesource/DamageTypes.STING Lnet/minecraft/resources/ResourceKey;
      // 9b82: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 9b87: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 9b8a: fconst_0
      // 9b8b: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 9b8e: pop
      // 9b8f: bipush 5
      // 9b90: aload 9
      // 9b92: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/DwellerLifestealProcedure.lambda$execute$124 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 9b97: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 9b9a: aload 9
      // 9b9c: instanceof net/minecraft/world/entity/TamableAnimal
      // 9b9f: ifeq 9c43
      // 9ba2: aload 9
      // 9ba4: checkcast net/minecraft/world/entity/TamableAnimal
      // 9ba7: astore 45
      // 9ba9: aload 45
      // 9bab: invokevirtual net/minecraft/world/entity/TamableAnimal.isTame ()Z
      // 9bae: ifeq 9c43
      // 9bb1: aload 11
      // 9bb3: instanceof net/minecraft/world/entity/TamableAnimal
      // 9bb6: ifeq 9bc8
      // 9bb9: aload 11
      // 9bbb: checkcast net/minecraft/world/entity/TamableAnimal
      // 9bbe: astore 46
      // 9bc0: aload 46
      // 9bc2: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 9bc5: goto 9bc9
      // 9bc8: aconst_null
      // 9bc9: ifnull 9c43
      // 9bcc: aload 9
      // 9bce: instanceof net/minecraft/world/entity/TamableAnimal
      // 9bd1: ifeq 9be3
      // 9bd4: aload 9
      // 9bd6: checkcast net/minecraft/world/entity/TamableAnimal
      // 9bd9: astore 47
      // 9bdb: aload 47
      // 9bdd: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 9be0: goto 9be4
      // 9be3: aconst_null
      // 9be4: ifnull 9c43
      // 9be7: aload 9
      // 9be9: instanceof net/minecraft/world/entity/TamableAnimal
      // 9bec: ifeq 9bfe
      // 9bef: aload 9
      // 9bf1: checkcast net/minecraft/world/entity/TamableAnimal
      // 9bf4: astore 48
      // 9bf6: aload 48
      // 9bf8: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 9bfb: goto 9bff
      // 9bfe: aconst_null
      // 9bff: aload 11
      // 9c01: instanceof net/minecraft/world/entity/TamableAnimal
      // 9c04: ifeq 9c16
      // 9c07: aload 11
      // 9c09: checkcast net/minecraft/world/entity/TamableAnimal
      // 9c0c: astore 49
      // 9c0e: aload 49
      // 9c10: invokevirtual net/minecraft/world/entity/TamableAnimal.getOwner ()Lnet/minecraft/world/entity/LivingEntity;
      // 9c13: goto 9c17
      // 9c16: aconst_null
      // 9c17: if_acmpne 9c43
      // 9c1a: getstatic net/minecraftforge/registries/ForgeRegistries.ENTITY_TYPES Lnet/minecraftforge/registries/IForgeRegistry;
      // 9c1d: aload 11
      // 9c1f: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 9c22: invokeinterface net/minecraftforge/registries/IForgeRegistry.getKey (Ljava/lang/Object;)Lnet/minecraft/resources/ResourceLocation; 2
      // 9c27: invokevirtual net/minecraft/resources/ResourceLocation.toString ()Ljava/lang/String;
      // 9c2a: ldc_w "arphex:"
      // 9c2d: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 9c30: ifeq 9c43
      // 9c33: aload 0
      // 9c34: ifnull 9c43
      // 9c37: aload 0
      // 9c38: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9c3b: ifeq 9c43
      // 9c3e: aload 0
      // 9c3f: bipush 1
      // 9c40: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 9c43: aload 10
      // 9c45: instanceof net/arphex/entity/TormentExplosiveEntity
      // 9c48: ifeq 9c66
      // 9c4b: aload 8
      // 9c4d: getstatic net/minecraft/world/damagesource/DamageTypes.ARROW Lnet/minecraft/resources/ResourceKey;
      // 9c50: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 9c53: ifeq 9c66
      // 9c56: aload 0
      // 9c57: ifnull 9c66
      // 9c5a: aload 0
      // 9c5b: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9c5e: ifeq 9c66
      // 9c61: aload 0
      // 9c62: bipush 1
      // 9c63: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 9c66: aload 9
      // 9c68: instanceof net/minecraft/world/entity/LivingEntity
      // 9c6b: ifeq 9cad
      // 9c6e: aload 9
      // 9c70: checkcast net/minecraft/world/entity/LivingEntity
      // 9c73: astore 45
      // 9c75: aload 45
      // 9c77: getstatic net/arphex/init/ArphexModMobEffects.TIME_FREEZE Lnet/minecraftforge/registries/RegistryObject;
      // 9c7a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9c7d: checkcast net/minecraft/world/effect/MobEffect
      // 9c80: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 9c83: ifeq 9cad
      // 9c86: dload 12
      // 9c88: ldc2_w 5.0
      // 9c8b: dcmpl
      // 9c8c: ifle 9cad
      // 9c8f: aload 9
      // 9c91: instanceof net/minecraft/world/entity/LivingEntity
      // 9c94: ifeq 9cad
      // 9c97: aload 9
      // 9c99: checkcast net/minecraft/world/entity/LivingEntity
      // 9c9c: astore 46
      // 9c9e: aload 46
      // 9ca0: getstatic net/arphex/init/ArphexModMobEffects.TIME_FREEZE Lnet/minecraftforge/registries/RegistryObject;
      // 9ca3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9ca6: checkcast net/minecraft/world/effect/MobEffect
      // 9ca9: invokevirtual net/minecraft/world/entity/LivingEntity.removeEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 9cac: pop
      // 9cad: aload 11
      // 9caf: instanceof net/arphex/entity/SpiderLungerEntity
      // 9cb2: ifeq 9ce2
      // 9cb5: aload 9
      // 9cb7: instanceof net/minecraft/world/entity/LivingEntity
      // 9cba: ifeq 9ce2
      // 9cbd: aload 9
      // 9cbf: checkcast net/minecraft/world/entity/LivingEntity
      // 9cc2: astore 45
      // 9cc4: aload 45
      // 9cc6: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9cc9: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9ccc: ifne 9ce2
      // 9ccf: aload 45
      // 9cd1: new net/minecraft/world/effect/MobEffectInstance
      // 9cd4: dup
      // 9cd5: getstatic net/minecraft/world/effect/MobEffects.POISON Lnet/minecraft/world/effect/MobEffect;
      // 9cd8: bipush 60
      // 9cda: bipush 1
      // 9cdb: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 9cde: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9ce1: pop
      // 9ce2: aload 11
      // 9ce4: instanceof net/arphex/entity/SpiderChaserHallucination3Entity
      // 9ce7: ifeq 9cfa
      // 9cea: aload 0
      // 9ceb: ifnull 9cfa
      // 9cee: aload 0
      // 9cef: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9cf2: ifeq 9cfa
      // 9cf5: aload 0
      // 9cf6: bipush 1
      // 9cf7: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 9cfa: aload 11
      // 9cfc: instanceof net/arphex/entity/SpiderMatriarchEntity
      // 9cff: ifeq 9dc6
      // 9d02: aload 11
      // 9d04: instanceof net/arphex/entity/SpiderMatriarchEntity
      // 9d07: ifeq 9d20
      // 9d0a: aload 11
      // 9d0c: checkcast net/arphex/entity/SpiderMatriarchEntity
      // 9d0f: astore 45
      // 9d11: aload 45
      // 9d13: invokevirtual net/arphex/entity/SpiderMatriarchEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 9d16: getstatic net/arphex/entity/SpiderMatriarchEntity.DATA_time_since_landing_attack Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 9d19: bipush 0
      // 9d1a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 9d1d: invokevirtual net/minecraft/network/syncher/SynchedEntityData.set (Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;)V
      // 9d20: aload 9
      // 9d22: instanceof net/minecraft/world/entity/LivingEntity
      // 9d25: ifeq 9d90
      // 9d28: aload 9
      // 9d2a: checkcast net/minecraft/world/entity/LivingEntity
      // 9d2d: astore 45
      // 9d2f: aload 45
      // 9d31: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9d34: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9d37: ifne 9d90
      // 9d3a: aload 45
      // 9d3c: new net/minecraft/world/effect/MobEffectInstance
      // 9d3f: dup
      // 9d40: getstatic net/arphex/init/ArphexModMobEffects.PARALYSIS Lnet/minecraftforge/registries/RegistryObject;
      // 9d43: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9d46: checkcast net/minecraft/world/effect/MobEffect
      // 9d49: bipush 50
      // 9d4b: bipush 9
      // 9d4d: aload 9
      // 9d4f: instanceof net/minecraft/world/entity/LivingEntity
      // 9d52: ifeq 9d81
      // 9d55: aload 9
      // 9d57: checkcast net/minecraft/world/entity/LivingEntity
      // 9d5a: astore 46
      // 9d5c: aload 46
      // 9d5e: getstatic net/arphex/init/ArphexModMobEffects.PARALYSIS Lnet/minecraftforge/registries/RegistryObject;
      // 9d61: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9d64: checkcast net/minecraft/world/effect/MobEffect
      // 9d67: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 9d6a: ifeq 9d81
      // 9d6d: aload 46
      // 9d6f: getstatic net/arphex/init/ArphexModMobEffects.PARALYSIS Lnet/minecraftforge/registries/RegistryObject;
      // 9d72: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9d75: checkcast net/minecraft/world/effect/MobEffect
      // 9d78: invokevirtual net/minecraft/world/entity/LivingEntity.getEffect (Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;
      // 9d7b: invokevirtual net/minecraft/world/effect/MobEffectInstance.getAmplifier ()I
      // 9d7e: goto 9d82
      // 9d81: bipush 0
      // 9d82: bipush 1
      // 9d83: iadd
      // 9d84: invokestatic java/lang/Math.min (II)I
      // 9d87: bipush 0
      // 9d88: bipush 0
      // 9d89: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 9d8c: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9d8f: pop
      // 9d90: aload 11
      // 9d92: instanceof net/arphex/entity/SpiderMatriarchEntity
      // 9d95: ifeq 9db3
      // 9d98: aload 11
      // 9d9a: checkcast net/arphex/entity/SpiderMatriarchEntity
      // 9d9d: astore 45
      // 9d9f: aload 45
      // 9da1: invokevirtual net/arphex/entity/SpiderMatriarchEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 9da4: getstatic net/arphex/entity/SpiderMatriarchEntity.DATA_lunge_time Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 9da7: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 9daa: checkcast java/lang/Integer
      // 9dad: invokevirtual java/lang/Integer.intValue ()I
      // 9db0: goto 9db4
      // 9db3: bipush 0
      // 9db4: sipush 400
      // 9db7: if_icmple 9dc6
      // 9dba: aload 11
      // 9dbc: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 9dbf: ldc_w "reverse_low"
      // 9dc2: bipush 1
      // 9dc3: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 9dc6: aload 11
      // 9dc8: instanceof net/arphex/entity/SpiderMatriarchLarvaeEntity
      // 9dcb: ifeq 9e03
      // 9dce: aload 9
      // 9dd0: instanceof net/minecraft/world/entity/LivingEntity
      // 9dd3: ifeq 9e03
      // 9dd6: aload 9
      // 9dd8: checkcast net/minecraft/world/entity/LivingEntity
      // 9ddb: astore 45
      // 9ddd: aload 45
      // 9ddf: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 9de2: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 9de5: ifne 9e03
      // 9de8: aload 45
      // 9dea: new net/minecraft/world/effect/MobEffectInstance
      // 9ded: dup
      // 9dee: getstatic net/arphex/init/ArphexModMobEffects.PARALYSIS Lnet/minecraftforge/registries/RegistryObject;
      // 9df1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 9df4: checkcast net/minecraft/world/effect/MobEffect
      // 9df7: bipush 50
      // 9df9: bipush 0
      // 9dfa: bipush 0
      // 9dfb: bipush 0
      // 9dfc: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 9dff: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 9e02: pop
      // 9e03: aload 10
      // 9e05: instanceof net/arphex/entity/HomingSparkEntity
      // 9e08: ifeq 9e26
      // 9e0b: aload 8
      // 9e0d: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 9e10: invokevirtual net/minecraft/world/damagesource/DamageSource.is (Lnet/minecraft/resources/ResourceKey;)Z
      // 9e13: ifne 9e26
      // 9e16: aload 0
      // 9e17: ifnull 9e26
      // 9e1a: aload 0
      // 9e1b: invokevirtual net/minecraftforge/eventbus/api/Event.isCancelable ()Z
      // 9e1e: ifeq 9e26
      // 9e21: aload 0
      // 9e22: bipush 1
      // 9e23: invokevirtual net/minecraftforge/eventbus/api/Event.setCanceled (Z)V
      // 9e26: return
   }
}
