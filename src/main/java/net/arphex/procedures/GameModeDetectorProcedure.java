package net.arphex.procedures;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class GameModeDetectorProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event param0, LevelAccessor param1, double param2, double param4, double param6, Entity param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.OutOfMemoryError: Java heap space
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.VarMapHolder.ofNormal(VarMapHolder.java:34)
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.SFormsConstructor.ssaStatements(SFormsConstructor.java:110)
      //   at org.jetbrains.java.decompiler.modules.decompiler.sforms.SSAUConstructorSparseEx.splitVariables(SSAUConstructorSparseEx.java:45)
      //   at org.jetbrains.java.decompiler.modules.decompiler.StackVarsProcessor.simplifyStackVars(StackVarsProcessor.java:86)
      //   at org.jetbrains.java.decompiler.modules.decompiler.StackVarsProcessor.simplifyStackVars(StackVarsProcessor.java:40)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:292)
      //
      // Bytecode:
      // 0000: aload 8
      // 0002: ifnonnull 0006
      // 0005: return
      // 0006: ldc ""
      // 0008: astore 9
      // 000a: aconst_null
      // 000b: astore 10
      // 000d: bipush 0
      // 000e: istore 11
      // 0010: bipush 0
      // 0011: istore 12
      // 0013: bipush 0
      // 0014: istore 13
      // 0016: bipush 0
      // 0017: istore 14
      // 0019: bipush 0
      // 001a: istore 15
      // 001c: bipush 0
      // 001d: istore 16
      // 001f: bipush 0
      // 0020: istore 17
      // 0022: dconst_0
      // 0023: dstore 18
      // 0025: dconst_0
      // 0026: dstore 20
      // 0028: dconst_0
      // 0029: dstore 22
      // 002b: dconst_0
      // 002c: dstore 24
      // 002e: dconst_0
      // 002f: dstore 26
      // 0031: dconst_0
      // 0032: dstore 28
      // 0034: dconst_0
      // 0035: dstore 30
      // 0037: dconst_0
      // 0038: dstore 32
      // 003a: dconst_0
      // 003b: dstore 34
      // 003d: dconst_0
      // 003e: dstore 36
      // 0040: dconst_0
      // 0041: dstore 38
      // 0043: dconst_0
      // 0044: dstore 40
      // 0046: dconst_0
      // 0047: dstore 42
      // 0049: dconst_0
      // 004a: dstore 44
      // 004c: dconst_0
      // 004d: dstore 46
      // 004f: dconst_0
      // 0050: dstore 48
      // 0052: dconst_0
      // 0053: dstore 50
      // 0055: dconst_0
      // 0056: dstore 52
      // 0058: dconst_0
      // 0059: dstore 54
      // 005b: dconst_0
      // 005c: dstore 56
      // 005e: dconst_0
      // 005f: dstore 58
      // 0061: dconst_0
      // 0062: dstore 60
      // 0064: dconst_0
      // 0065: dstore 62
      // 0067: dconst_0
      // 0068: dstore 64
      // 006a: dconst_0
      // 006b: dstore 66
      // 006d: dconst_0
      // 006e: dstore 68
      // 0070: dconst_0
      // 0071: dstore 70
      // 0073: dconst_0
      // 0074: dstore 72
      // 0076: dconst_0
      // 0077: dstore 74
      // 0079: dconst_0
      // 007a: dstore 76
      // 007c: dconst_0
      // 007d: dstore 78
      // 007f: dconst_0
      // 0080: dstore 80
      // 0082: dconst_0
      // 0083: dstore 82
      // 0085: dconst_0
      // 0086: dstore 84
      // 0088: dconst_0
      // 0089: dstore 86
      // 008b: dconst_0
      // 008c: dstore 88
      // 008e: dconst_0
      // 008f: dstore 90
      // 0091: dconst_0
      // 0092: dstore 92
      // 0094: dconst_0
      // 0095: dstore 94
      // 0097: dconst_0
      // 0098: dstore 96
      // 009a: dconst_0
      // 009b: dstore 98
      // 009d: dconst_0
      // 009e: dstore 100
      // 00a0: dconst_0
      // 00a1: dstore 102
      // 00a3: dconst_0
      // 00a4: dstore 104
      // 00a6: dconst_0
      // 00a7: dstore 106
      // 00a9: dconst_0
      // 00aa: dstore 108
      // 00ac: dconst_0
      // 00ad: dstore 110
      // 00af: dconst_0
      // 00b0: dstore 112
      // 00b2: dconst_0
      // 00b3: dstore 114
      // 00b5: dconst_0
      // 00b6: dstore 116
      // 00b8: dconst_0
      // 00b9: dstore 118
      // 00bb: dconst_0
      // 00bc: dstore 120
      // 00be: dconst_0
      // 00bf: dstore 122
      // 00c1: dconst_0
      // 00c2: dstore 124
      // 00c4: dconst_0
      // 00c5: dstore 126
      // 00c7: dconst_0
      // 00c8: dstore 128
      // 00ca: dconst_0
      // 00cb: dstore 130
      // 00cd: dconst_0
      // 00ce: dstore 132
      // 00d0: aload 8
      // 00d2: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 00d5: aconst_null
      // 00d6: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 00d9: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 00dc: dup
      // 00dd: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 00e0: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 00e3: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 00e6: getfield net/arphex/network/ArphexModVariables$PlayerVariables.torment_intensity D
      // 00e9: dconst_0
      // 00ea: dcmpl
      // 00eb: ifle 0120
      // 00ee: aload 8
      // 00f0: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 00f3: aconst_null
      // 00f4: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 00f7: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 00fa: dup
      // 00fb: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 00fe: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0101: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0104: getfield net/arphex/network/ArphexModVariables$PlayerVariables.torment_intensity D
      // 0107: dconst_1
      // 0108: dsub
      // 0109: dstore 134
      // 010b: aload 8
      // 010d: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0110: aconst_null
      // 0111: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0114: dload 134
      // 0116: aload 8
      // 0118: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$0 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 011d: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 0120: aload 8
      // 0122: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0125: ldc "sneakjump_enable"
      // 0127: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 012a: dconst_0
      // 012b: dcmpl
      // 012c: ifle 0145
      // 012f: aload 8
      // 0131: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0134: ldc "sneakjump_enable"
      // 0136: aload 8
      // 0138: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 013b: ldc "sneakjump_enable"
      // 013d: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 0140: dconst_1
      // 0141: dsub
      // 0142: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 0145: aload 8
      // 0147: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 014a: aconst_null
      // 014b: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 014e: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0151: dup
      // 0152: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0155: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0158: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 015b: getfield net/arphex/network/ArphexModVariables$PlayerVariables.inherent_power_cooldown D
      // 015e: dconst_0
      // 015f: dcmpl
      // 0160: ifle 0195
      // 0163: aload 8
      // 0165: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0168: aconst_null
      // 0169: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 016c: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 016f: dup
      // 0170: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0173: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0176: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0179: getfield net/arphex/network/ArphexModVariables$PlayerVariables.inherent_power_cooldown D
      // 017c: dconst_1
      // 017d: dsub
      // 017e: dstore 134
      // 0180: aload 8
      // 0182: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0185: aconst_null
      // 0186: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0189: dload 134
      // 018b: aload 8
      // 018d: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$1 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 0192: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 0195: aload 8
      // 0197: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 019a: aconst_null
      // 019b: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 019e: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 01a1: dup
      // 01a2: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 01a5: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 01a8: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 01ab: getfield net/arphex/network/ArphexModVariables$PlayerVariables.power_press Z
      // 01ae: ifeq 01f2
      // 01b1: aload 8
      // 01b3: instanceof net/minecraft/server/level/ServerPlayer
      // 01b6: ifeq 01da
      // 01b9: aload 8
      // 01bb: checkcast net/minecraft/server/level/ServerPlayer
      // 01be: astore 134
      // 01c0: dload 2
      // 01c1: dload 4
      // 01c3: dload 6
      // 01c5: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 01c8: astore 135
      // 01ca: aload 134
      // 01cc: new net/arphex/procedures/GameModeDetectorProcedure$1
      // 01cf: dup
      // 01d0: aload 135
      // 01d2: invokespecial net/arphex/procedures/GameModeDetectorProcedure$1.<init> (Lnet/minecraft/core/BlockPos;)V
      // 01d5: aload 135
      // 01d7: invokestatic net/minecraftforge/network/NetworkHooks.openScreen (Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/MenuProvider;Lnet/minecraft/core/BlockPos;)V
      // 01da: bipush 0
      // 01db: istore 134
      // 01dd: aload 8
      // 01df: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 01e2: aconst_null
      // 01e3: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 01e6: iload 134
      // 01e8: aload 8
      // 01ea: invokedynamic accept (ZLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$2 (ZLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 01ef: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 01f2: aload 1
      // 01f3: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 01f6: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 01f9: dconst_0
      // 01fa: dcmpl
      // 01fb: ifle 0457
      // 01fe: bipush 0
      // 01ff: istore 17
      // 0201: new net/minecraft/world/phys/Vec3
      // 0204: dup
      // 0205: dload 2
      // 0206: dload 4
      // 0208: dload 6
      // 020a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 020d: astore 134
      // 020f: aload 1
      // 0210: ldc net/minecraft/world/entity/Entity
      // 0212: new net/minecraft/world/phys/AABB
      // 0215: dup
      // 0216: aload 134
      // 0218: aload 134
      // 021a: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 021d: ldc2_w 50.0
      // 0220: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 0223: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$3 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 0228: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 022d: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 0232: aload 134
      // 0234: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$4 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 0239: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 023c: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 0241: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 0246: astore 135
      // 0248: aload 135
      // 024a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 024f: astore 136
      // 0251: aload 136
      // 0253: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0258: ifeq 03c6
      // 025b: aload 136
      // 025d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0262: checkcast net/minecraft/world/entity/Entity
      // 0265: astore 137
      // 0267: aload 1
      // 0268: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 026b: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 026e: dconst_1
      // 026f: dcmpl
      // 0270: ifne 02ab
      // 0273: aload 137
      // 0275: instanceof net/arphex/entity/TormentorTestEntity
      // 0278: ifeq 03c3
      // 027b: aload 8
      // 027d: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 0280: aload 137
      // 0282: instanceof net/arphex/entity/TormentorTestEntity
      // 0285: ifeq 029d
      // 0288: aload 137
      // 028a: checkcast net/arphex/entity/TormentorTestEntity
      // 028d: astore 138
      // 028f: aload 138
      // 0291: invokevirtual net/arphex/entity/TormentorTestEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 0294: getstatic net/arphex/entity/TormentorTestEntity.DATA_uuid_target Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 0297: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 029a: goto 029f
      // 029d: ldc ""
      // 029f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 02a2: ifeq 03c3
      // 02a5: bipush 1
      // 02a6: istore 17
      // 02a8: goto 03c6
      // 02ab: aload 1
      // 02ac: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 02af: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 02b2: ldc2_w 2.0
      // 02b5: dcmpl
      // 02b6: ifne 02f1
      // 02b9: aload 137
      // 02bb: instanceof net/arphex/entity/TormentorT2Entity
      // 02be: ifeq 03c3
      // 02c1: aload 8
      // 02c3: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 02c6: aload 137
      // 02c8: instanceof net/arphex/entity/TormentorT2Entity
      // 02cb: ifeq 02e3
      // 02ce: aload 137
      // 02d0: checkcast net/arphex/entity/TormentorT2Entity
      // 02d3: astore 138
      // 02d5: aload 138
      // 02d7: invokevirtual net/arphex/entity/TormentorT2Entity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 02da: getstatic net/arphex/entity/TormentorT2Entity.DATA_uuid_target Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 02dd: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 02e0: goto 02e5
      // 02e3: ldc ""
      // 02e5: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 02e8: ifeq 03c3
      // 02eb: bipush 1
      // 02ec: istore 17
      // 02ee: goto 03c6
      // 02f1: aload 1
      // 02f2: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 02f5: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 02f8: ldc2_w 3.0
      // 02fb: dcmpl
      // 02fc: ifne 0337
      // 02ff: aload 137
      // 0301: instanceof net/arphex/entity/TormentorT3Entity
      // 0304: ifeq 03c3
      // 0307: aload 8
      // 0309: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 030c: aload 137
      // 030e: instanceof net/arphex/entity/TormentorT3Entity
      // 0311: ifeq 0329
      // 0314: aload 137
      // 0316: checkcast net/arphex/entity/TormentorT3Entity
      // 0319: astore 138
      // 031b: aload 138
      // 031d: invokevirtual net/arphex/entity/TormentorT3Entity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 0320: getstatic net/arphex/entity/TormentorT3Entity.DATA_uuid_target Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 0323: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 0326: goto 032b
      // 0329: ldc ""
      // 032b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 032e: ifeq 03c3
      // 0331: bipush 1
      // 0332: istore 17
      // 0334: goto 03c6
      // 0337: aload 1
      // 0338: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 033b: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 033e: ldc2_w 4.0
      // 0341: dcmpl
      // 0342: ifne 037d
      // 0345: aload 137
      // 0347: instanceof net/arphex/entity/TormentorT4Entity
      // 034a: ifeq 03c3
      // 034d: aload 8
      // 034f: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 0352: aload 137
      // 0354: instanceof net/arphex/entity/TormentorT4Entity
      // 0357: ifeq 036f
      // 035a: aload 137
      // 035c: checkcast net/arphex/entity/TormentorT4Entity
      // 035f: astore 138
      // 0361: aload 138
      // 0363: invokevirtual net/arphex/entity/TormentorT4Entity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 0366: getstatic net/arphex/entity/TormentorT4Entity.DATA_uuid_target Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 0369: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 036c: goto 0371
      // 036f: ldc ""
      // 0371: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0374: ifeq 03c3
      // 0377: bipush 1
      // 0378: istore 17
      // 037a: goto 03c6
      // 037d: aload 1
      // 037e: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0381: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 0384: ldc2_w 5.0
      // 0387: dcmpl
      // 0388: ifne 03c3
      // 038b: aload 137
      // 038d: instanceof net/arphex/entity/TormentorT5Entity
      // 0390: ifeq 03c3
      // 0393: aload 8
      // 0395: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 0398: aload 137
      // 039a: instanceof net/arphex/entity/TormentorT5Entity
      // 039d: ifeq 03b5
      // 03a0: aload 137
      // 03a2: checkcast net/arphex/entity/TormentorT5Entity
      // 03a5: astore 138
      // 03a7: aload 138
      // 03a9: invokevirtual net/arphex/entity/TormentorT5Entity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 03ac: getstatic net/arphex/entity/TormentorT5Entity.DATA_uuid_target Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 03af: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 03b2: goto 03b7
      // 03b5: ldc ""
      // 03b7: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 03ba: ifeq 03c3
      // 03bd: bipush 1
      // 03be: istore 17
      // 03c0: goto 03c6
      // 03c3: goto 0251
      // 03c6: iload 17
      // 03c8: ifne 0457
      // 03cb: aload 1
      // 03cc: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 03cf: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 03d2: dconst_1
      // 03d3: dcmpl
      // 03d4: ifne 03e6
      // 03d7: bipush 1
      // 03d8: aload 1
      // 03d9: aload 8
      // 03db: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$6 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 03e0: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 03e3: goto 0457
      // 03e6: aload 1
      // 03e7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 03ea: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 03ed: ldc2_w 2.0
      // 03f0: dcmpl
      // 03f1: ifne 0403
      // 03f4: bipush 1
      // 03f5: aload 1
      // 03f6: aload 8
      // 03f8: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$8 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 03fd: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0400: goto 0457
      // 0403: aload 1
      // 0404: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0407: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 040a: ldc2_w 3.0
      // 040d: dcmpl
      // 040e: ifne 0420
      // 0411: bipush 1
      // 0412: aload 1
      // 0413: aload 8
      // 0415: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$10 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 041a: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 041d: goto 0457
      // 0420: aload 1
      // 0421: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0424: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 0427: ldc2_w 4.0
      // 042a: dcmpl
      // 042b: ifne 043d
      // 042e: bipush 1
      // 042f: aload 1
      // 0430: aload 8
      // 0432: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$12 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0437: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 043a: goto 0457
      // 043d: aload 1
      // 043e: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0441: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_tier D
      // 0444: ldc2_w 5.0
      // 0447: dcmpl
      // 0448: ifne 0457
      // 044b: bipush 1
      // 044c: aload 1
      // 044d: aload 8
      // 044f: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$14 (Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0454: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0457: aload 8
      // 0459: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 045c: aconst_null
      // 045d: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0460: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0463: dup
      // 0464: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0467: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 046a: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 046d: getfield net/arphex/network/ArphexModVariables$PlayerVariables.ShowOverlay4 Z
      // 0470: ifeq 047e
      // 0473: bipush 4
      // 0474: aload 8
      // 0476: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$16 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 047b: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 047e: aload 8
      // 0480: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0483: aconst_null
      // 0484: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0487: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 048a: dup
      // 048b: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 048e: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0491: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0494: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_render D
      // 0497: dconst_0
      // 0498: dcmpl
      // 0499: ifle 04ce
      // 049c: aload 8
      // 049e: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 04a1: aconst_null
      // 04a2: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 04a5: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 04a8: dup
      // 04a9: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 04ac: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 04af: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 04b2: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_render D
      // 04b5: dconst_1
      // 04b6: dsub
      // 04b7: dstore 134
      // 04b9: aload 8
      // 04bb: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 04be: aconst_null
      // 04bf: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 04c2: dload 134
      // 04c4: aload 8
      // 04c6: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$17 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 04cb: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 04ce: aload 8
      // 04d0: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 04d3: aconst_null
      // 04d4: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 04d7: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 04da: dup
      // 04db: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 04de: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 04e1: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 04e4: getfield net/arphex/network/ArphexModVariables$PlayerVariables.laser_emitter_near D
      // 04e7: dconst_0
      // 04e8: dcmpl
      // 04e9: ifle 051e
      // 04ec: aload 8
      // 04ee: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 04f1: aconst_null
      // 04f2: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 04f5: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 04f8: dup
      // 04f9: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 04fc: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 04ff: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0502: getfield net/arphex/network/ArphexModVariables$PlayerVariables.laser_emitter_near D
      // 0505: dconst_1
      // 0506: dsub
      // 0507: dstore 134
      // 0509: aload 8
      // 050b: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 050e: aconst_null
      // 050f: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0512: dload 134
      // 0514: aload 8
      // 0516: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$18 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 051b: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 051e: aload 8
      // 0520: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0523: aconst_null
      // 0524: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0527: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 052a: dup
      // 052b: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 052e: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0531: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0534: getfield net/arphex/network/ArphexModVariables$PlayerVariables.sphere_near D
      // 0537: dconst_0
      // 0538: dcmpl
      // 0539: ifle 056e
      // 053c: aload 8
      // 053e: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0541: aconst_null
      // 0542: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0545: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0548: dup
      // 0549: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 054c: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 054f: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0552: getfield net/arphex/network/ArphexModVariables$PlayerVariables.sphere_near D
      // 0555: dconst_1
      // 0556: dsub
      // 0557: dstore 134
      // 0559: aload 8
      // 055b: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 055e: aconst_null
      // 055f: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0562: dload 134
      // 0564: aload 8
      // 0566: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$19 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 056b: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 056e: aload 8
      // 0570: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0573: aconst_null
      // 0574: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0577: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 057a: dup
      // 057b: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 057e: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0581: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0584: getfield net/arphex/network/ArphexModVariables$PlayerVariables.overlay_white D
      // 0587: dconst_0
      // 0588: dcmpl
      // 0589: ifle 05be
      // 058c: aload 8
      // 058e: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0591: aconst_null
      // 0592: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0595: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0598: dup
      // 0599: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 059c: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 059f: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 05a2: getfield net/arphex/network/ArphexModVariables$PlayerVariables.overlay_white D
      // 05a5: dconst_1
      // 05a6: dsub
      // 05a7: dstore 134
      // 05a9: aload 8
      // 05ab: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 05ae: aconst_null
      // 05af: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 05b2: dload 134
      // 05b4: aload 8
      // 05b6: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$20 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 05bb: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 05be: aload 8
      // 05c0: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 05c3: aconst_null
      // 05c4: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 05c7: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 05ca: dup
      // 05cb: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 05ce: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 05d1: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 05d4: getfield net/arphex/network/ArphexModVariables$PlayerVariables.overlay_red D
      // 05d7: dconst_0
      // 05d8: dcmpl
      // 05d9: ifle 060e
      // 05dc: aload 8
      // 05de: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 05e1: aconst_null
      // 05e2: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 05e5: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 05e8: dup
      // 05e9: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 05ec: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 05ef: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 05f2: getfield net/arphex/network/ArphexModVariables$PlayerVariables.overlay_red D
      // 05f5: dconst_1
      // 05f6: dsub
      // 05f7: dstore 134
      // 05f9: aload 8
      // 05fb: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 05fe: aconst_null
      // 05ff: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0602: dload 134
      // 0604: aload 8
      // 0606: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$21 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 060b: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 060e: aload 8
      // 0610: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0613: aconst_null
      // 0614: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0617: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 061a: dup
      // 061b: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 061e: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0621: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0624: getfield net/arphex/network/ArphexModVariables$PlayerVariables.overlay_black D
      // 0627: dconst_0
      // 0628: dcmpl
      // 0629: ifle 065e
      // 062c: aload 8
      // 062e: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0631: aconst_null
      // 0632: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0635: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0638: dup
      // 0639: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 063c: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 063f: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0642: getfield net/arphex/network/ArphexModVariables$PlayerVariables.overlay_black D
      // 0645: dconst_1
      // 0646: dsub
      // 0647: dstore 134
      // 0649: aload 8
      // 064b: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 064e: aconst_null
      // 064f: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0652: dload 134
      // 0654: aload 8
      // 0656: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$22 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 065b: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 065e: aload 1
      // 065f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0662: getfield net/arphex/network/ArphexModVariables$MapVariables.torchatcooldown D
      // 0665: dconst_0
      // 0666: dcmpl
      // 0667: ifle 0682
      // 066a: aload 1
      // 066b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 066e: aload 1
      // 066f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0672: getfield net/arphex/network/ArphexModVariables$MapVariables.torchatcooldown D
      // 0675: dconst_1
      // 0676: dsub
      // 0677: putfield net/arphex/network/ArphexModVariables$MapVariables.torchatcooldown D
      // 067a: aload 1
      // 067b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 067e: aload 1
      // 067f: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0682: aload 8
      // 0684: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0687: ldc_w "antblocktimer"
      // 068a: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 068d: dconst_0
      // 068e: dcmpl
      // 068f: ifle 06cb
      // 0692: aload 8
      // 0694: instanceof net/minecraft/world/entity/player/Player
      // 0697: ifeq 06bf
      // 069a: aload 8
      // 069c: checkcast net/minecraft/world/entity/player/Player
      // 069f: astore 134
      // 06a1: aload 134
      // 06a3: invokevirtual net/minecraft/world/entity/player/Player.getInventory ()Lnet/minecraft/world/entity/player/Inventory;
      // 06a6: new net/minecraft/world/item/ItemStack
      // 06a9: dup
      // 06aa: getstatic net/arphex/init/ArphexModItems.ANT_COMMANDER Lnet/minecraftforge/registries/RegistryObject;
      // 06ad: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 06b0: checkcast net/minecraft/world/level/ItemLike
      // 06b3: invokespecial net/minecraft/world/item/ItemStack.<init> (Lnet/minecraft/world/level/ItemLike;)V
      // 06b6: invokevirtual net/minecraft/world/entity/player/Inventory.contains (Lnet/minecraft/world/item/ItemStack;)Z
      // 06b9: ifeq 06bf
      // 06bc: goto 06cb
      // 06bf: aload 8
      // 06c1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 06c4: ldc_w "antblocktimer"
      // 06c7: dconst_0
      // 06c8: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 06cb: aload 8
      // 06cd: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 06d0: ldc_w "lensmode"
      // 06d3: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 06d6: dconst_0
      // 06d7: dcmpl
      // 06d8: ifle 06f3
      // 06db: aload 8
      // 06dd: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 06e0: ldc_w "lensmode"
      // 06e3: aload 8
      // 06e5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 06e8: ldc_w "lensmode"
      // 06eb: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 06ee: dconst_1
      // 06ef: dsub
      // 06f0: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 06f3: aload 8
      // 06f5: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 06f8: aconst_null
      // 06f9: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 06fc: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 06ff: dup
      // 0700: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0703: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0706: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0709: getfield net/arphex/network/ArphexModVariables$PlayerVariables.time_in_portal D
      // 070c: dconst_0
      // 070d: dcmpl
      // 070e: ifle 0824
      // 0711: aload 1
      // 0712: aload 8
      // 0714: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 0717: aload 8
      // 0719: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 071c: aload 8
      // 071e: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 0721: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 0724: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 0729: invokevirtual net/minecraft/world/level/block/state/BlockState.getBlock ()Lnet/minecraft/world/level/block/Block;
      // 072c: getstatic net/arphex/init/ArphexModBlocks.CRAWLING_PORTAL Lnet/minecraftforge/registries/RegistryObject;
      // 072f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0732: if_acmpeq 0824
      // 0735: aload 1
      // 0736: aload 8
      // 0738: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 073b: aload 8
      // 073d: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 0740: dconst_1
      // 0741: dadd
      // 0742: aload 8
      // 0744: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 0747: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 074a: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 074f: invokevirtual net/minecraft/world/level/block/state/BlockState.getBlock ()Lnet/minecraft/world/level/block/Block;
      // 0752: getstatic net/arphex/init/ArphexModBlocks.CRAWLING_PORTAL Lnet/minecraftforge/registries/RegistryObject;
      // 0755: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0758: if_acmpeq 0824
      // 075b: aload 1
      // 075c: aload 8
      // 075e: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 0761: aload 8
      // 0763: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 0766: dconst_1
      // 0767: dadd
      // 0768: aload 8
      // 076a: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 076d: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 0770: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 0775: invokevirtual net/minecraft/world/level/block/state/BlockState.getBlock ()Lnet/minecraft/world/level/block/Block;
      // 0778: getstatic net/minecraft/world/level/block/Blocks.NETHERRACK Lnet/minecraft/world/level/block/Block;
      // 077b: if_acmpne 07bc
      // 077e: aload 1
      // 077f: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 0784: ifne 07bc
      // 0787: aload 8
      // 0789: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 078c: aload 8
      // 078e: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 0791: dconst_1
      // 0792: dadd
      // 0793: aload 8
      // 0795: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 0798: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 079b: astore 134
      // 079d: aload 1
      // 079e: aload 134
      // 07a0: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 07a5: aload 1
      // 07a6: dload 2
      // 07a7: dload 4
      // 07a9: dload 6
      // 07ab: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 07ae: aconst_null
      // 07af: invokestatic net/minecraft/world/level/block/Block.dropResources (Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;)V
      // 07b2: aload 1
      // 07b3: aload 134
      // 07b5: bipush 0
      // 07b6: invokeinterface net/minecraft/world/level/LevelAccessor.destroyBlock (Lnet/minecraft/core/BlockPos;Z)Z 3
      // 07bb: pop
      // 07bc: aload 1
      // 07bd: aload 8
      // 07bf: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 07c2: aload 8
      // 07c4: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 07c7: aload 8
      // 07c9: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 07cc: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 07cf: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 07d4: invokevirtual net/minecraft/world/level/block/state/BlockState.getBlock ()Lnet/minecraft/world/level/block/Block;
      // 07d7: getstatic net/minecraft/world/level/block/Blocks.NETHERRACK Lnet/minecraft/world/level/block/Block;
      // 07da: if_acmpne 0819
      // 07dd: aload 1
      // 07de: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 07e3: ifne 0819
      // 07e6: aload 8
      // 07e8: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 07eb: aload 8
      // 07ed: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 07f0: aload 8
      // 07f2: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 07f5: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 07f8: astore 134
      // 07fa: aload 1
      // 07fb: aload 134
      // 07fd: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 0802: aload 1
      // 0803: dload 2
      // 0804: dload 4
      // 0806: dload 6
      // 0808: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 080b: aconst_null
      // 080c: invokestatic net/minecraft/world/level/block/Block.dropResources (Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;)V
      // 080f: aload 1
      // 0810: aload 134
      // 0812: bipush 0
      // 0813: invokeinterface net/minecraft/world/level/LevelAccessor.destroyBlock (Lnet/minecraft/core/BlockPos;Z)Z 3
      // 0818: pop
      // 0819: bipush 1
      // 081a: aload 8
      // 081c: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$24 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0821: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0824: aload 8
      // 0826: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0829: aconst_null
      // 082a: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 082d: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0830: dup
      // 0831: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0834: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0837: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 083a: getfield net/arphex/network/ArphexModVariables$PlayerVariables.show_tormentor_overlay Z
      // 083d: ifeq 087a
      // 0840: aload 8
      // 0842: instanceof net/minecraft/world/entity/LivingEntity
      // 0845: ifeq 086e
      // 0848: aload 8
      // 084a: checkcast net/minecraft/world/entity/LivingEntity
      // 084d: astore 134
      // 084f: aload 134
      // 0851: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 0854: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0857: ifne 086e
      // 085a: aload 134
      // 085c: new net/minecraft/world/effect/MobEffectInstance
      // 085f: dup
      // 0860: getstatic net/minecraft/world/effect/MobEffects.DARKNESS Lnet/minecraft/world/effect/MobEffect;
      // 0863: bipush 3
      // 0864: bipush 0
      // 0865: bipush 0
      // 0866: bipush 0
      // 0867: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 086a: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 086d: pop
      // 086e: bipush 8
      // 0870: aload 8
      // 0872: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$26 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0877: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 087a: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.WELCOME_MESSAGE Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 087d: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 0880: checkcast java/lang/Boolean
      // 0883: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 0886: ifeq 09ab
      // 0889: aload 1
      // 088a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 088d: getfield net/arphex/network/ArphexModVariables$MapVariables.onetimesplash Z
      // 0890: ifne 09ab
      // 0893: aload 1
      // 0894: instanceof net/minecraft/server/level/ServerLevel
      // 0897: ifeq 08db
      // 089a: aload 1
      // 089b: checkcast net/minecraft/server/level/ServerLevel
      // 089e: astore 134
      // 08a0: aload 134
      // 08a2: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 08a5: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 08a8: new net/minecraft/commands/CommandSourceStack
      // 08ab: dup
      // 08ac: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 08af: new net/minecraft/world/phys/Vec3
      // 08b2: dup
      // 08b3: dload 2
      // 08b4: dload 4
      // 08b6: dload 6
      // 08b8: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 08bb: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 08be: aload 134
      // 08c0: bipush 4
      // 08c1: ldc ""
      // 08c3: ldc ""
      // 08c5: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 08c8: aload 134
      // 08ca: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 08cd: aconst_null
      // 08ce: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 08d1: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 08d4: ldc_w "tellraw @a [ { \"text\": \"Beware the thunder bringing forth demonic arachnid overlords. Endure the siege of realistic horrors of nature - \", \"color\": \"gold\" }, { \"text\": \"Welcome to Arthropod Phobia Expansions, by \", \"color\": \"red\" }, { \"text\": \"V\", \"color\": \"red\" }, { \"text\": \"l\", \"color\": \"gold\" }, { \"text\": \"l\", \"color\": \"yellow\" }, { \"text\": \"a\", \"color\": \"green\" }, { \"text\": \"x\", \"color\": \"aqua\" }, { \"text\": \": \", \"color\": \"red\" }, { \"text\": \"Detailed information available on the wiki: \", \"color\": \"gold\" }, { \"text\": \"arphex.miraheze.org\", \"color\": \"yellow\", \"underlined\": true, \"clickEvent\": { \"action\": \"open_url\", \"value\": \"https://arphex.miraheze.org\" } }, { \"text\": \" and support available on the Discord server: \", \"color\": \"gold\" }, { \"text\": \"discord.gg/sQQPZQSEpS\", \"color\": \"dark_purple\", \"underlined\": true, \"clickEvent\": { \"action\": \"open_url\", \"value\": \"https://discord.gg/sQQPZQSEpS\" } }, { \"text\": \"\\n--------------------------------------------------\", \"color\": \"white\" }, { \"text\": \"\\nSpawnrates are configurable - Rare by default, especially in other mod biomes\", \"color\": \"yellow\" }, { \"text\": \"\\n--------------------------------------------------\", \"color\": \"white\" }, { \"text\": \"\\nOptiFine may break ArPhEx armour rendering - Embeddium recommended instead\", \"color\": \"yellow\" }, { \"text\": \"\\n--------------------------------------------------\", \"color\": \"white\" } ]"
      // 08d7: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 08da: pop
      // 08db: ldc_w "1.20.1"
      // 08de: ldc_w "1.19."
      // 08e1: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 08e4: ifne 093b
      // 08e7: invokestatic net/minecraftforge/fml/ModList.get ()Lnet/minecraftforge/fml/ModList;
      // 08ea: ldc_w "geckoanimfix"
      // 08ed: invokevirtual net/minecraftforge/fml/ModList.isLoaded (Ljava/lang/String;)Z
      // 08f0: ifeq 093b
      // 08f3: aload 1
      // 08f4: instanceof net/minecraft/server/level/ServerLevel
      // 08f7: ifeq 093b
      // 08fa: aload 1
      // 08fb: checkcast net/minecraft/server/level/ServerLevel
      // 08fe: astore 134
      // 0900: aload 134
      // 0902: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0905: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 0908: new net/minecraft/commands/CommandSourceStack
      // 090b: dup
      // 090c: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 090f: new net/minecraft/world/phys/Vec3
      // 0912: dup
      // 0913: dload 2
      // 0914: dload 4
      // 0916: dload 6
      // 0918: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 091b: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 091e: aload 134
      // 0920: bipush 4
      // 0921: ldc ""
      // 0923: ldc ""
      // 0925: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0928: aload 134
      // 092a: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 092d: aconst_null
      // 092e: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 0931: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 0934: ldc_w "tellraw @a [ {\"text\":\"Iris/Oculus & Geckolib Compat mod detected - This mod is incompatible with ArPhEx (breaks animations) and is not needed!\",\"color\":\"red\"}, {\"text\":\"\\n--------------------------------------------------\",\"color\":\"white\"} ]"
      // 0937: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 093a: pop
      // 093b: invokestatic net/minecraftforge/fml/ModList.get ()Lnet/minecraftforge/fml/ModList;
      // 093e: ldc_w "nyfsspiders"
      // 0941: invokevirtual net/minecraftforge/fml/ModList.isLoaded (Ljava/lang/String;)Z
      // 0944: ifne 099b
      // 0947: ldc_w "1.20.1"
      // 094a: ldc_w "1.19."
      // 094d: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0950: ifne 099b
      // 0953: aload 1
      // 0954: instanceof net/minecraft/server/level/ServerLevel
      // 0957: ifeq 099b
      // 095a: aload 1
      // 095b: checkcast net/minecraft/server/level/ServerLevel
      // 095e: astore 134
      // 0960: aload 134
      // 0962: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0965: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 0968: new net/minecraft/commands/CommandSourceStack
      // 096b: dup
      // 096c: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 096f: new net/minecraft/world/phys/Vec3
      // 0972: dup
      // 0973: dload 2
      // 0974: dload 4
      // 0976: dload 6
      // 0978: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 097b: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 097e: aload 134
      // 0980: bipush 4
      // 0981: ldc ""
      // 0983: ldc ""
      // 0985: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0988: aload 134
      // 098a: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 098d: aconst_null
      // 098e: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 0991: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 0994: ldc_w "tellraw @a [ {\"text\":\"Nyf's Spiders not found. This mod is recommended when using ArPhEx (compatible).\",\"color\":\"red\"}, {\"text\":\"\\n--------------------------------------------------\",\"color\":\"white\"} ]"
      // 0997: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 099a: pop
      // 099b: aload 1
      // 099c: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 099f: bipush 1
      // 09a0: putfield net/arphex/network/ArphexModVariables$MapVariables.onetimesplash Z
      // 09a3: aload 1
      // 09a4: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 09a7: aload 1
      // 09a8: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 09ab: aload 8
      // 09ad: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 09b0: ldc_w "abyssdestruction"
      // 09b3: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 09b6: dconst_1
      // 09b7: dcmpl
      // 09b8: ifne 09ec
      // 09bb: aload 1
      // 09bc: instanceof net/minecraft/server/level/ServerLevel
      // 09bf: ifeq 09ec
      // 09c2: aload 1
      // 09c3: checkcast net/minecraft/server/level/ServerLevel
      // 09c6: astore 134
      // 09c8: aload 134
      // 09ca: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_RED_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 09cd: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 09d0: checkcast net/minecraft/core/particles/SimpleParticleType
      // 09d3: dload 2
      // 09d4: dload 4
      // 09d6: dconst_1
      // 09d7: dadd
      // 09d8: dload 6
      // 09da: bipush 10
      // 09dc: ldc2_w 0.1
      // 09df: ldc2_w 0.1
      // 09e2: ldc2_w 0.1
      // 09e5: ldc2_w 0.1
      // 09e8: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 09eb: pop
      // 09ec: aload 8
      // 09ee: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 09f1: aconst_null
      // 09f2: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 09f5: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 09f8: dup
      // 09f9: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 09fc: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 09ff: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0a02: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 0a05: dconst_1
      // 0a06: dcmpl
      // 0a07: ifge 0a22
      // 0a0a: dconst_0
      // 0a0b: dstore 134
      // 0a0d: aload 8
      // 0a0f: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0a12: aconst_null
      // 0a13: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0a16: dload 134
      // 0a18: aload 8
      // 0a1a: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$27 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 0a1f: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 0a22: aload 8
      // 0a24: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0a27: aconst_null
      // 0a28: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0a2b: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0a2e: dup
      // 0a2f: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0a32: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0a35: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0a38: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 0a3b: dconst_1
      // 0a3c: dcmpg
      // 0a3d: ifgt 0af8
      // 0a40: aload 8
      // 0a42: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0a45: ldc_w "creativespectator"
      // 0a48: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0a4b: ifne 0af8
      // 0a4e: aload 1
      // 0a4f: ldc_w net/arphex/entity/SpiderMothEntity
      // 0a52: new net/minecraft/world/phys/Vec3
      // 0a55: dup
      // 0a56: dload 2
      // 0a57: dload 4
      // 0a59: dload 6
      // 0a5b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0a5e: ldc2_w 20.0
      // 0a61: ldc2_w 20.0
      // 0a64: ldc2_w 20.0
      // 0a67: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 0a6a: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$28 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 0a6f: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 0a74: invokeinterface java/util/List.isEmpty ()Z 1
      // 0a79: ifne 0af8
      // 0a7c: aload 1
      // 0a7d: ldc_w net/arphex/entity/SpiderMothEntity
      // 0a80: new net/minecraft/world/phys/Vec3
      // 0a83: dup
      // 0a84: dload 2
      // 0a85: dload 4
      // 0a87: dload 6
      // 0a89: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0a8c: ldc2_w 20.0
      // 0a8f: ldc2_w 20.0
      // 0a92: ldc2_w 20.0
      // 0a95: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 0a98: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$29 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 0a9d: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 0aa2: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 0aa7: new net/arphex/procedures/GameModeDetectorProcedure$2
      // 0aaa: dup
      // 0aab: invokespecial net/arphex/procedures/GameModeDetectorProcedure$2.<init> ()V
      // 0aae: dload 2
      // 0aaf: dload 4
      // 0ab1: dload 6
      // 0ab3: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$2.compareDistOf (DDD)Ljava/util/Comparator;
      // 0ab6: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 0abb: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 0ac0: aconst_null
      // 0ac1: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0ac4: checkcast net/minecraft/world/entity/Entity
      // 0ac7: astore 135
      // 0ac9: aload 135
      // 0acb: instanceof net/minecraft/world/entity/LivingEntity
      // 0ace: ifeq 0af8
      // 0ad1: aload 135
      // 0ad3: checkcast net/minecraft/world/entity/LivingEntity
      // 0ad6: astore 134
      // 0ad8: aload 134
      // 0ada: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 0add: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0ae0: ifne 0af8
      // 0ae3: aload 134
      // 0ae5: new net/minecraft/world/effect/MobEffectInstance
      // 0ae8: dup
      // 0ae9: getstatic net/minecraft/world/effect/MobEffects.WEAKNESS Lnet/minecraft/world/effect/MobEffect;
      // 0aec: bipush 50
      // 0aee: bipush 1
      // 0aef: bipush 0
      // 0af0: bipush 0
      // 0af1: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 0af4: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 0af7: pop
      // 0af8: aload 8
      // 0afa: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0afd: ldc_w "spidergrab"
      // 0b00: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0b03: ifeq 0b40
      // 0b06: aload 1
      // 0b07: ldc_w net/arphex/entity/SpiderLarvaeEntity
      // 0b0a: new net/minecraft/world/phys/Vec3
      // 0b0d: dup
      // 0b0e: dload 2
      // 0b0f: dload 4
      // 0b11: dload 6
      // 0b13: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0b16: ldc2_w 10.0
      // 0b19: ldc2_w 10.0
      // 0b1c: ldc2_w 10.0
      // 0b1f: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 0b22: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$30 (Lnet/arphex/entity/SpiderLarvaeEntity;)Z, (Lnet/arphex/entity/SpiderLarvaeEntity;)Z ]
      // 0b27: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 0b2c: invokeinterface java/util/List.isEmpty ()Z 1
      // 0b31: ifeq 0b40
      // 0b34: aload 8
      // 0b36: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0b39: ldc_w "spidergrab"
      // 0b3c: bipush 0
      // 0b3d: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 0b40: new net/arphex/procedures/GameModeDetectorProcedure$3
      // 0b43: dup
      // 0b44: invokespecial net/arphex/procedures/GameModeDetectorProcedure$3.<init> ()V
      // 0b47: aload 8
      // 0b49: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$3.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 0b4c: ifne 0b5e
      // 0b4f: new net/arphex/procedures/GameModeDetectorProcedure$4
      // 0b52: dup
      // 0b53: invokespecial net/arphex/procedures/GameModeDetectorProcedure$4.<init> ()V
      // 0b56: aload 8
      // 0b58: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$4.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 0b5b: ifeq 0bc4
      // 0b5e: aload 1
      // 0b5f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0b62: getfield net/arphex/network/ArphexModVariables$MapVariables.survival_only_breached Z
      // 0b65: ifne 0bb8
      // 0b68: aload 1
      // 0b69: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0b6c: bipush 1
      // 0b6d: putfield net/arphex/network/ArphexModVariables$MapVariables.survival_only_breached Z
      // 0b70: aload 1
      // 0b71: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0b74: aload 1
      // 0b75: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0b78: aload 1
      // 0b79: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0b7c: getfield net/arphex/network/ArphexModVariables$MapVariables.gem_mob_challenge Z
      // 0b7f: ifeq 0bb8
      // 0b82: aload 8
      // 0b84: instanceof net/minecraft/world/entity/player/Player
      // 0b87: ifeq 0ba8
      // 0b8a: aload 8
      // 0b8c: checkcast net/minecraft/world/entity/player/Player
      // 0b8f: astore 134
      // 0b91: aload 134
      // 0b93: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 0b96: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0b99: ifne 0ba8
      // 0b9c: aload 134
      // 0b9e: ldc_w "Creative or spectator mode detected, challenge failed for this world (ArPhEx)"
      // 0ba1: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0ba4: bipush 0
      // 0ba5: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 0ba8: aload 1
      // 0ba9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0bac: bipush 0
      // 0bad: putfield net/arphex/network/ArphexModVariables$MapVariables.gem_mob_challenge Z
      // 0bb0: aload 1
      // 0bb1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0bb4: aload 1
      // 0bb5: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0bb8: aload 8
      // 0bba: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0bbd: ldc_w "creativespectator"
      // 0bc0: bipush 1
      // 0bc1: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 0bc4: new net/arphex/procedures/GameModeDetectorProcedure$5
      // 0bc7: dup
      // 0bc8: invokespecial net/arphex/procedures/GameModeDetectorProcedure$5.<init> ()V
      // 0bcb: aload 8
      // 0bcd: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$5.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 0bd0: ifne 0be2
      // 0bd3: new net/arphex/procedures/GameModeDetectorProcedure$6
      // 0bd6: dup
      // 0bd7: invokespecial net/arphex/procedures/GameModeDetectorProcedure$6.<init> ()V
      // 0bda: aload 8
      // 0bdc: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$6.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 0bdf: ifeq 0bee
      // 0be2: aload 8
      // 0be4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0be7: ldc_w "creativespectator"
      // 0bea: bipush 0
      // 0beb: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 0bee: aload 8
      // 0bf0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0bf3: ldc_w "spidermothnear"
      // 0bf6: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0bf9: ifeq 0e90
      // 0bfc: aload 1
      // 0bfd: ldc_w net/arphex/entity/SpiderMothEntity
      // 0c00: new net/minecraft/world/phys/Vec3
      // 0c03: dup
      // 0c04: dload 2
      // 0c05: dload 4
      // 0c07: dload 6
      // 0c09: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0c0c: ldc2_w 300.0
      // 0c0f: ldc2_w 300.0
      // 0c12: ldc2_w 300.0
      // 0c15: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 0c18: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$31 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 0c1d: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 0c22: invokeinterface java/util/List.isEmpty ()Z 1
      // 0c27: ifne 0e33
      // 0c2a: aload 1
      // 0c2b: ldc_w net/arphex/entity/SpiderMothEntity
      // 0c2e: new net/minecraft/world/phys/Vec3
      // 0c31: dup
      // 0c32: dload 2
      // 0c33: dload 4
      // 0c35: dload 6
      // 0c37: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0c3a: ldc2_w 300.0
      // 0c3d: ldc2_w 300.0
      // 0c40: ldc2_w 300.0
      // 0c43: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 0c46: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$32 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 0c4b: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 0c50: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 0c55: new net/arphex/procedures/GameModeDetectorProcedure$7
      // 0c58: dup
      // 0c59: invokespecial net/arphex/procedures/GameModeDetectorProcedure$7.<init> ()V
      // 0c5c: dload 2
      // 0c5d: dload 4
      // 0c5f: dload 6
      // 0c61: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$7.compareDistOf (DDD)Ljava/util/Comparator;
      // 0c64: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 0c69: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 0c6e: aconst_null
      // 0c6f: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0c72: checkcast net/minecraft/world/entity/Entity
      // 0c75: astore 10
      // 0c77: dconst_0
      // 0c78: dstore 18
      // 0c7a: bipush 0
      // 0c7b: istore 11
      // 0c7d: new net/arphex/procedures/GameModeDetectorProcedure$8
      // 0c80: dup
      // 0c81: invokespecial net/arphex/procedures/GameModeDetectorProcedure$8.<init> ()V
      // 0c84: aload 8
      // 0c86: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$8.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 0c89: ifne 0c9b
      // 0c8c: new net/arphex/procedures/GameModeDetectorProcedure$9
      // 0c8f: dup
      // 0c90: invokespecial net/arphex/procedures/GameModeDetectorProcedure$9.<init> ()V
      // 0c93: aload 8
      // 0c95: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$9.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 0c98: ifeq 0e51
      // 0c9b: bipush 0
      // 0c9c: istore 134
      // 0c9e: iload 134
      // 0ca0: sipush 150
      // 0ca3: if_icmpge 0d8c
      // 0ca6: aload 1
      // 0ca7: ldc_w net/arphex/entity/SpiderMothEntity
      // 0caa: new net/minecraft/world/phys/Vec3
      // 0cad: dup
      // 0cae: aload 8
      // 0cb0: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 0cb3: new net/minecraft/world/level/ClipContext
      // 0cb6: dup
      // 0cb7: aload 8
      // 0cb9: fconst_1
      // 0cba: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 0cbd: aload 8
      // 0cbf: fconst_1
      // 0cc0: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 0cc3: aload 8
      // 0cc5: fconst_1
      // 0cc6: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 0cc9: dload 18
      // 0ccb: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 0cce: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 0cd1: getstatic net/minecraft/world/level/ClipContext$Block.COLLIDER Lnet/minecraft/world/level/ClipContext$Block;
      // 0cd4: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 0cd7: aload 8
      // 0cd9: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 0cdc: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 0cdf: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 0ce2: invokevirtual net/minecraft/core/BlockPos.getX ()I
      // 0ce5: i2d
      // 0ce6: aload 8
      // 0ce8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 0ceb: new net/minecraft/world/level/ClipContext
      // 0cee: dup
      // 0cef: aload 8
      // 0cf1: fconst_1
      // 0cf2: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 0cf5: aload 8
      // 0cf7: fconst_1
      // 0cf8: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 0cfb: aload 8
      // 0cfd: fconst_1
      // 0cfe: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 0d01: dload 18
      // 0d03: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 0d06: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 0d09: getstatic net/minecraft/world/level/ClipContext$Block.COLLIDER Lnet/minecraft/world/level/ClipContext$Block;
      // 0d0c: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 0d0f: aload 8
      // 0d11: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 0d14: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 0d17: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 0d1a: invokevirtual net/minecraft/core/BlockPos.getY ()I
      // 0d1d: i2d
      // 0d1e: aload 8
      // 0d20: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 0d23: new net/minecraft/world/level/ClipContext
      // 0d26: dup
      // 0d27: aload 8
      // 0d29: fconst_1
      // 0d2a: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 0d2d: aload 8
      // 0d2f: fconst_1
      // 0d30: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 0d33: aload 8
      // 0d35: fconst_1
      // 0d36: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 0d39: dload 18
      // 0d3b: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 0d3e: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 0d41: getstatic net/minecraft/world/level/ClipContext$Block.COLLIDER Lnet/minecraft/world/level/ClipContext$Block;
      // 0d44: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 0d47: aload 8
      // 0d49: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 0d4c: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 0d4f: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 0d52: invokevirtual net/minecraft/core/BlockPos.getZ ()I
      // 0d55: i2d
      // 0d56: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0d59: ldc2_w 3.0
      // 0d5c: ldc2_w 3.0
      // 0d5f: ldc2_w 3.0
      // 0d62: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 0d65: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$33 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 0d6a: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 0d6f: invokeinterface java/util/List.isEmpty ()Z 1
      // 0d74: ifne 0d7d
      // 0d77: bipush 1
      // 0d78: istore 11
      // 0d7a: goto 0d86
      // 0d7d: bipush 0
      // 0d7e: istore 11
      // 0d80: dload 18
      // 0d82: dconst_1
      // 0d83: dadd
      // 0d84: dstore 18
      // 0d86: iinc 134 1
      // 0d89: goto 0c9e
      // 0d8c: iload 11
      // 0d8e: ifeq 0e22
      // 0d91: aload 10
      // 0d93: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0d96: ldc_w "playerlookedatmoth"
      // 0d99: ldc_w "looking"
      // 0d9c: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0d9f: aload 10
      // 0da1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0da4: ldc_w "lookedmoth"
      // 0da7: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0daa: ifne 0e51
      // 0dad: aload 8
      // 0daf: instanceof net/minecraft/world/entity/LivingEntity
      // 0db2: ifeq 0de2
      // 0db5: aload 8
      // 0db7: checkcast net/minecraft/world/entity/LivingEntity
      // 0dba: astore 134
      // 0dbc: aload 134
      // 0dbe: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 0dc1: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 0dc4: ifne 0de2
      // 0dc7: aload 134
      // 0dc9: new net/minecraft/world/effect/MobEffectInstance
      // 0dcc: dup
      // 0dcd: getstatic net/arphex/init/ArphexModMobEffects.MOTH_CURSE Lnet/minecraftforge/registries/RegistryObject;
      // 0dd0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 0dd3: checkcast net/minecraft/world/effect/MobEffect
      // 0dd6: bipush 40
      // 0dd8: bipush 1
      // 0dd9: bipush 0
      // 0dda: bipush 0
      // 0ddb: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 0dde: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 0de1: pop
      // 0de2: bipush 1
      // 0de3: aload 8
      // 0de5: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$34 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0dea: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0ded: ldc_w "true"
      // 0df0: astore 134
      // 0df2: aload 8
      // 0df4: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0df7: aconst_null
      // 0df8: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0dfb: aload 134
      // 0dfd: aload 8
      // 0dff: invokedynamic accept (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$35 (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 0e04: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 0e07: bipush 10
      // 0e09: aload 8
      // 0e0b: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$37 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0e10: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0e13: aload 10
      // 0e15: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0e18: ldc_w "lookedmoth"
      // 0e1b: bipush 1
      // 0e1c: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 0e1f: goto 0e51
      // 0e22: aload 10
      // 0e24: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0e27: ldc_w "playerlookedatmoth"
      // 0e2a: ldc_w "no"
      // 0e2d: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0e30: goto 0e51
      // 0e33: aload 1
      // 0e34: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0e37: ldc_w "true"
      // 0e3a: putfield net/arphex/network/ArphexModVariables$MapVariables.LookScareLock Ljava/lang/String;
      // 0e3d: aload 1
      // 0e3e: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 0e41: aload 1
      // 0e42: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 0e45: aload 8
      // 0e47: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0e4a: ldc_w "spidermothnear"
      // 0e4d: bipush 0
      // 0e4e: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 0e51: aload 1
      // 0e52: ldc_w net/arphex/entity/SpiderMothEntity
      // 0e55: new net/minecraft/world/phys/Vec3
      // 0e58: dup
      // 0e59: dload 2
      // 0e5a: dload 4
      // 0e5c: dload 6
      // 0e5e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0e61: ldc2_w 30.0
      // 0e64: ldc2_w 30.0
      // 0e67: ldc2_w 30.0
      // 0e6a: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 0e6d: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$38 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 0e72: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 0e77: invokeinterface java/util/List.isEmpty ()Z 1
      // 0e7c: ifeq 0eb8
      // 0e7f: aload 8
      // 0e81: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0e84: ldc_w "dwellerwaiting"
      // 0e87: ldc_w "far"
      // 0e8a: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0e8d: goto 0eb8
      // 0e90: ldc_w "false"
      // 0e93: astore 134
      // 0e95: aload 8
      // 0e97: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0e9a: aconst_null
      // 0e9b: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0e9e: aload 134
      // 0ea0: aload 8
      // 0ea2: invokedynamic accept (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$39 (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 0ea7: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 0eaa: aload 8
      // 0eac: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0eaf: ldc_w "dwellerwaiting"
      // 0eb2: ldc_w "far"
      // 0eb5: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0eb8: aload 8
      // 0eba: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0ebd: aconst_null
      // 0ebe: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0ec1: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0ec4: dup
      // 0ec5: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0ec8: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0ecb: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0ece: getfield net/arphex/network/ArphexModVariables$PlayerVariables.ShowOverlay Ljava/lang/String;
      // 0ed1: ldc_w "true"
      // 0ed4: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0ed7: ifeq 0ee6
      // 0eda: bipush 20
      // 0edc: aload 8
      // 0ede: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$41 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0ee3: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0ee6: aload 8
      // 0ee8: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 0eeb: aconst_null
      // 0eec: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 0eef: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 0ef2: dup
      // 0ef3: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 0ef6: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 0ef9: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 0efc: getfield net/arphex/network/ArphexModVariables$PlayerVariables.ShowOverlay3 Ljava/lang/String;
      // 0eff: ldc_w "true"
      // 0f02: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0f05: ifeq 0f14
      // 0f08: bipush 20
      // 0f0a: aload 8
      // 0f0c: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$43 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 0f11: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 0f14: aload 8
      // 0f16: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0f19: ldc_w "spidergrab"
      // 0f1c: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0f1f: bipush 1
      // 0f20: if_icmpne 1115
      // 0f23: aload 8
      // 0f25: invokevirtual net/minecraft/world/entity/Entity.isUnderWater ()Z
      // 0f28: ifne 1115
      // 0f2b: aload 8
      // 0f2d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 0f30: ldc_w "arphex_special_player"
      // 0f33: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 0f36: ifne 1115
      // 0f39: aload 1
      // 0f3a: instanceof net/minecraft/server/level/ServerLevel
      // 0f3d: ifeq 0f81
      // 0f40: aload 1
      // 0f41: checkcast net/minecraft/server/level/ServerLevel
      // 0f44: astore 134
      // 0f46: aload 134
      // 0f48: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0f4b: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 0f4e: new net/minecraft/commands/CommandSourceStack
      // 0f51: dup
      // 0f52: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 0f55: new net/minecraft/world/phys/Vec3
      // 0f58: dup
      // 0f59: dload 2
      // 0f5a: dload 4
      // 0f5c: dload 6
      // 0f5e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0f61: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 0f64: aload 134
      // 0f66: bipush 4
      // 0f67: ldc ""
      // 0f69: ldc ""
      // 0f6b: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0f6e: aload 134
      // 0f70: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0f73: aconst_null
      // 0f74: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 0f77: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 0f7a: ldc_w "execute at @p run tp @e[type=arphex:spider_larvae,limit=1,sort=nearest,distance=..8] ~ ~1.4 ~0.1"
      // 0f7d: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 0f80: pop
      // 0f81: aload 1
      // 0f82: instanceof net/minecraft/server/level/ServerLevel
      // 0f85: ifeq 0fc9
      // 0f88: aload 1
      // 0f89: checkcast net/minecraft/server/level/ServerLevel
      // 0f8c: astore 134
      // 0f8e: aload 134
      // 0f90: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0f93: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 0f96: new net/minecraft/commands/CommandSourceStack
      // 0f99: dup
      // 0f9a: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 0f9d: new net/minecraft/world/phys/Vec3
      // 0fa0: dup
      // 0fa1: dload 2
      // 0fa2: dload 4
      // 0fa4: dload 6
      // 0fa6: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0fa9: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 0fac: aload 134
      // 0fae: bipush 4
      // 0faf: ldc ""
      // 0fb1: ldc ""
      // 0fb3: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0fb6: aload 134
      // 0fb8: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0fbb: aconst_null
      // 0fbc: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 0fbf: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 0fc2: ldc_w "execute at @p run tp @e[type=arphex:spider_larvae_tiny,limit=1,sort=nearest,distance=..4] ~-0.1 ~1.3 ~-0.1"
      // 0fc5: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 0fc8: pop
      // 0fc9: aload 1
      // 0fca: instanceof net/minecraft/server/level/ServerLevel
      // 0fcd: ifeq 1011
      // 0fd0: aload 1
      // 0fd1: checkcast net/minecraft/server/level/ServerLevel
      // 0fd4: astore 134
      // 0fd6: aload 134
      // 0fd8: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 0fdb: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 0fde: new net/minecraft/commands/CommandSourceStack
      // 0fe1: dup
      // 0fe2: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 0fe5: new net/minecraft/world/phys/Vec3
      // 0fe8: dup
      // 0fe9: dload 2
      // 0fea: dload 4
      // 0fec: dload 6
      // 0fee: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 0ff1: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 0ff4: aload 134
      // 0ff6: bipush 4
      // 0ff7: ldc ""
      // 0ff9: ldc ""
      // 0ffb: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 0ffe: aload 134
      // 1000: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 1003: aconst_null
      // 1004: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 1007: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 100a: ldc_w "effect give @e[type=arphex:spider_larvae,limit=1,sort=nearest] regeneration 1 1 true"
      // 100d: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 1010: pop
      // 1011: aload 1
      // 1012: instanceof net/minecraft/server/level/ServerLevel
      // 1015: ifeq 1059
      // 1018: aload 1
      // 1019: checkcast net/minecraft/server/level/ServerLevel
      // 101c: astore 134
      // 101e: aload 134
      // 1020: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 1023: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 1026: new net/minecraft/commands/CommandSourceStack
      // 1029: dup
      // 102a: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 102d: new net/minecraft/world/phys/Vec3
      // 1030: dup
      // 1031: dload 2
      // 1032: dload 4
      // 1034: dload 6
      // 1036: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1039: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 103c: aload 134
      // 103e: bipush 4
      // 103f: ldc ""
      // 1041: ldc ""
      // 1043: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 1046: aload 134
      // 1048: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 104b: aconst_null
      // 104c: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 104f: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 1052: ldc_w "effect give @e[type=arphex:spider_larvae_tiny,limit=1,sort=nearest] regeneration 1 1 true"
      // 1055: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 1058: pop
      // 1059: aload 1
      // 105a: instanceof net/minecraft/server/level/ServerLevel
      // 105d: ifeq 1083
      // 1060: aload 1
      // 1061: checkcast net/minecraft/server/level/ServerLevel
      // 1064: astore 134
      // 1066: aload 134
      // 1068: getstatic net/minecraft/core/particles/ParticleTypes.WHITE_ASH Lnet/minecraft/core/particles/SimpleParticleType;
      // 106b: dload 2
      // 106c: dload 4
      // 106e: ldc2_w 1.6
      // 1071: dadd
      // 1072: dload 6
      // 1074: bipush 4
      // 1075: ldc2_w 0.1
      // 1078: dconst_1
      // 1079: ldc2_w 0.1
      // 107c: ldc2_w 0.1
      // 107f: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 1082: pop
      // 1083: aload 8
      // 1085: instanceof net/minecraft/world/entity/LivingEntity
      // 1088: ifeq 10b8
      // 108b: aload 8
      // 108d: checkcast net/minecraft/world/entity/LivingEntity
      // 1090: astore 134
      // 1092: aload 134
      // 1094: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1097: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 109a: ifne 10b8
      // 109d: aload 134
      // 109f: new net/minecraft/world/effect/MobEffectInstance
      // 10a2: dup
      // 10a3: getstatic net/arphex/init/ArphexModMobEffects.WEBBED Lnet/minecraftforge/registries/RegistryObject;
      // 10a6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 10a9: checkcast net/minecraft/world/effect/MobEffect
      // 10ac: bipush 20
      // 10ae: bipush 0
      // 10af: bipush 1
      // 10b0: bipush 0
      // 10b1: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 10b4: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 10b7: pop
      // 10b8: aload 8
      // 10ba: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 10bd: ldc_w "timegrabsp"
      // 10c0: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 10c3: dconst_0
      // 10c4: dcmpl
      // 10c5: ifgt 10fd
      // 10c8: aload 8
      // 10ca: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 10cd: ldc_w "timegrabsp"
      // 10d0: ldc2_w 30.0
      // 10d3: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 10d6: aload 8
      // 10d8: new net/minecraft/world/damagesource/DamageSource
      // 10db: dup
      // 10dc: aload 1
      // 10dd: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 10e2: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 10e5: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 10ea: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 10ed: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 10f2: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;)V
      // 10f5: fconst_1
      // 10f6: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 10f9: pop
      // 10fa: goto 1115
      // 10fd: aload 8
      // 10ff: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1102: ldc_w "timegrabsp"
      // 1105: aload 8
      // 1107: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 110a: ldc_w "timegrabsp"
      // 110d: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1110: dconst_1
      // 1111: dsub
      // 1112: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1115: aload 8
      // 1117: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 111a: ldc_w "spidergrab"
      // 111d: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1120: bipush 1
      // 1121: if_icmpne 118c
      // 1124: aload 1
      // 1125: ldc_w net/arphex/entity/SpiderLarvaeEntity
      // 1128: new net/minecraft/world/phys/Vec3
      // 112b: dup
      // 112c: dload 2
      // 112d: dload 4
      // 112f: dload 6
      // 1131: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1134: ldc2_w 7.0
      // 1137: ldc2_w 7.0
      // 113a: ldc2_w 7.0
      // 113d: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 1140: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$44 (Lnet/arphex/entity/SpiderLarvaeEntity;)Z, (Lnet/arphex/entity/SpiderLarvaeEntity;)Z ]
      // 1145: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 114a: invokeinterface java/util/List.isEmpty ()Z 1
      // 114f: ifeq 118c
      // 1152: aload 1
      // 1153: ldc_w net/arphex/entity/SpiderLarvaeTinyEntity
      // 1156: new net/minecraft/world/phys/Vec3
      // 1159: dup
      // 115a: dload 2
      // 115b: dload 4
      // 115d: dload 6
      // 115f: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1162: ldc2_w 5.0
      // 1165: ldc2_w 5.0
      // 1168: ldc2_w 5.0
      // 116b: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 116e: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$45 (Lnet/arphex/entity/SpiderLarvaeTinyEntity;)Z, (Lnet/arphex/entity/SpiderLarvaeTinyEntity;)Z ]
      // 1173: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 1178: invokeinterface java/util/List.isEmpty ()Z 1
      // 117d: ifeq 118c
      // 1180: aload 8
      // 1182: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1185: ldc_w "spidergrab"
      // 1188: bipush 0
      // 1189: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 118c: aload 8
      // 118e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1191: ldc_w "creativespectator"
      // 1194: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1197: bipush 1
      // 1198: if_icmpne 11a7
      // 119b: aload 8
      // 119d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 11a0: ldc_w "spidergrab"
      // 11a3: bipush 0
      // 11a4: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 11a7: aload 8
      // 11a9: invokevirtual net/minecraft/world/entity/Entity.onGround ()Z
      // 11ac: ifeq 11cd
      // 11af: aload 8
      // 11b1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 11b4: ldc_w "abysstimer"
      // 11b7: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 11ba: dconst_0
      // 11bb: dcmpl
      // 11bc: ifne 11cd
      // 11bf: aload 8
      // 11c1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 11c4: ldc_w "doublejumpmax"
      // 11c7: ldc_w "reset"
      // 11ca: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 11cd: aload 8
      // 11cf: instanceof net/minecraft/world/entity/LivingEntity
      // 11d2: ifeq 11e4
      // 11d5: aload 8
      // 11d7: checkcast net/minecraft/world/entity/LivingEntity
      // 11da: astore 134
      // 11dc: aload 134
      // 11de: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 11e1: goto 11e7
      // 11e4: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 11e7: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 11ea: getstatic net/arphex/init/ArphexModItems.ABYSSAL_CRYSTAL Lnet/minecraftforge/registries/RegistryObject;
      // 11ed: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 11f0: if_acmpne 1222
      // 11f3: aload 8
      // 11f5: instanceof net/minecraft/world/entity/LivingEntity
      // 11f8: ifeq 1222
      // 11fb: aload 8
      // 11fd: checkcast net/minecraft/world/entity/LivingEntity
      // 1200: astore 135
      // 1202: aload 135
      // 1204: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1207: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 120a: ifne 1222
      // 120d: aload 135
      // 120f: new net/minecraft/world/effect/MobEffectInstance
      // 1212: dup
      // 1213: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_BOOST Lnet/minecraft/world/effect/MobEffect;
      // 1216: bipush 10
      // 1218: bipush 0
      // 1219: bipush 0
      // 121a: bipush 0
      // 121b: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 121e: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1221: pop
      // 1222: aload 8
      // 1224: instanceof net/minecraft/world/entity/LivingEntity
      // 1227: ifeq 1239
      // 122a: aload 8
      // 122c: checkcast net/minecraft/world/entity/LivingEntity
      // 122f: astore 134
      // 1231: aload 134
      // 1233: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1236: goto 123c
      // 1239: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 123c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 123f: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 1242: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1245: if_acmpeq 126e
      // 1248: aload 8
      // 124a: instanceof net/minecraft/world/entity/LivingEntity
      // 124d: ifeq 125f
      // 1250: aload 8
      // 1252: checkcast net/minecraft/world/entity/LivingEntity
      // 1255: astore 135
      // 1257: aload 135
      // 1259: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 125c: goto 1262
      // 125f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1262: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1265: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 1268: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 126b: if_acmpne 1332
      // 126e: aload 8
      // 1270: instanceof net/minecraft/world/entity/LivingEntity
      // 1273: ifeq 1285
      // 1276: aload 8
      // 1278: checkcast net/minecraft/world/entity/LivingEntity
      // 127b: astore 136
      // 127d: aload 136
      // 127f: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1282: goto 1288
      // 1285: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1288: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 128b: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 128e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1291: if_acmpne 12bc
      // 1294: aload 8
      // 1296: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1299: ldc_w "abysstimer"
      // 129c: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 129f: dconst_0
      // 12a0: dcmpg
      // 12a1: ifle 12bc
      // 12a4: aload 8
      // 12a6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 12a9: ldc_w "abysstimer"
      // 12ac: aload 8
      // 12ae: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 12b1: ldc_w "abysstimer"
      // 12b4: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 12b7: dconst_1
      // 12b8: dsub
      // 12b9: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 12bc: aload 8
      // 12be: instanceof net/minecraft/world/entity/LivingEntity
      // 12c1: ifeq 130a
      // 12c4: aload 8
      // 12c6: checkcast net/minecraft/world/entity/LivingEntity
      // 12c9: astore 136
      // 12cb: aload 136
      // 12cd: invokevirtual net/minecraft/world/entity/LivingEntity.isBlocking ()Z
      // 12d0: ifeq 130a
      // 12d3: aload 8
      // 12d5: invokevirtual net/minecraft/world/entity/Entity.onGround ()Z
      // 12d8: ifeq 130a
      // 12db: aload 8
      // 12dd: instanceof net/minecraft/world/entity/LivingEntity
      // 12e0: ifeq 130a
      // 12e3: aload 8
      // 12e5: checkcast net/minecraft/world/entity/LivingEntity
      // 12e8: astore 137
      // 12ea: aload 137
      // 12ec: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 12ef: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 12f2: ifne 130a
      // 12f5: aload 137
      // 12f7: new net/minecraft/world/effect/MobEffectInstance
      // 12fa: dup
      // 12fb: getstatic net/minecraft/world/effect/MobEffects.SLOW_FALLING Lnet/minecraft/world/effect/MobEffect;
      // 12fe: bipush 60
      // 1300: bipush 1
      // 1301: bipush 1
      // 1302: bipush 0
      // 1303: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1306: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1309: pop
      // 130a: aload 8
      // 130c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 130f: ldc_w "abysstimer"
      // 1312: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1315: dconst_0
      // 1316: dcmpl
      // 1317: ifle 1332
      // 131a: aload 8
      // 131c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 131f: ldc_w "abysstimer"
      // 1322: aload 8
      // 1324: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1327: ldc_w "abysstimer"
      // 132a: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 132d: dconst_1
      // 132e: dsub
      // 132f: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1332: aload 8
      // 1334: instanceof net/minecraft/world/entity/LivingEntity
      // 1337: ifeq 1349
      // 133a: aload 8
      // 133c: checkcast net/minecraft/world/entity/LivingEntity
      // 133f: astore 134
      // 1341: aload 134
      // 1343: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1346: goto 134c
      // 1349: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 134c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 134f: getstatic net/arphex/init/ArphexModItems.BUCKET_OF_MAGGOTS Lnet/minecraftforge/registries/RegistryObject;
      // 1352: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1355: if_acmpeq 13ca
      // 1358: aload 8
      // 135a: instanceof net/minecraft/world/entity/LivingEntity
      // 135d: ifeq 136f
      // 1360: aload 8
      // 1362: checkcast net/minecraft/world/entity/LivingEntity
      // 1365: astore 135
      // 1367: aload 135
      // 1369: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 136c: goto 1372
      // 136f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1372: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1375: getstatic net/arphex/init/ArphexModItems.BUCKET_OF_ROACHES Lnet/minecraftforge/registries/RegistryObject;
      // 1378: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 137b: if_acmpeq 13ca
      // 137e: aload 8
      // 1380: instanceof net/minecraft/world/entity/LivingEntity
      // 1383: ifeq 1395
      // 1386: aload 8
      // 1388: checkcast net/minecraft/world/entity/LivingEntity
      // 138b: astore 136
      // 138d: aload 136
      // 138f: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1392: goto 1398
      // 1395: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1398: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 139b: getstatic net/arphex/init/ArphexModItems.BUCKET_OF_LOCUSTS Lnet/minecraftforge/registries/RegistryObject;
      // 139e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 13a1: if_acmpeq 13ca
      // 13a4: aload 8
      // 13a6: instanceof net/minecraft/world/entity/LivingEntity
      // 13a9: ifeq 13bb
      // 13ac: aload 8
      // 13ae: checkcast net/minecraft/world/entity/LivingEntity
      // 13b1: astore 137
      // 13b3: aload 137
      // 13b5: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 13b8: goto 13be
      // 13bb: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 13be: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 13c1: getstatic net/arphex/init/ArphexModItems.BUCKET_OF_WORM_GRUB Lnet/minecraftforge/registries/RegistryObject;
      // 13c4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 13c7: if_acmpne 1436
      // 13ca: aload 8
      // 13cc: instanceof net/minecraft/server/level/ServerPlayer
      // 13cf: ifeq 1436
      // 13d2: aload 8
      // 13d4: checkcast net/minecraft/server/level/ServerPlayer
      // 13d7: astore 138
      // 13d9: aload 138
      // 13db: getfield net/minecraft/server/level/ServerPlayer.server Lnet/minecraft/server/MinecraftServer;
      // 13de: invokevirtual net/minecraft/server/MinecraftServer.getAdvancements ()Lnet/minecraft/server/ServerAdvancementManager;
      // 13e1: new net/minecraft/resources/ResourceLocation
      // 13e4: dup
      // 13e5: ldc_w "arphex:bucket_of_disease"
      // 13e8: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 13eb: invokevirtual net/minecraft/server/ServerAdvancementManager.getAdvancement (Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/advancements/Advancement;
      // 13ee: astore 139
      // 13f0: aload 138
      // 13f2: invokevirtual net/minecraft/server/level/ServerPlayer.getAdvancements ()Lnet/minecraft/server/PlayerAdvancements;
      // 13f5: aload 139
      // 13f7: invokevirtual net/minecraft/server/PlayerAdvancements.getOrStartProgress (Lnet/minecraft/advancements/Advancement;)Lnet/minecraft/advancements/AdvancementProgress;
      // 13fa: astore 140
      // 13fc: aload 140
      // 13fe: invokevirtual net/minecraft/advancements/AdvancementProgress.isDone ()Z
      // 1401: ifne 1436
      // 1404: aload 140
      // 1406: invokevirtual net/minecraft/advancements/AdvancementProgress.getRemainingCriteria ()Ljava/lang/Iterable;
      // 1409: invokeinterface java/lang/Iterable.iterator ()Ljava/util/Iterator; 1
      // 140e: astore 141
      // 1410: aload 141
      // 1412: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1417: ifeq 1436
      // 141a: aload 141
      // 141c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1421: checkcast java/lang/String
      // 1424: astore 142
      // 1426: aload 138
      // 1428: invokevirtual net/minecraft/server/level/ServerPlayer.getAdvancements ()Lnet/minecraft/server/PlayerAdvancements;
      // 142b: aload 139
      // 142d: aload 142
      // 142f: invokevirtual net/minecraft/server/PlayerAdvancements.award (Lnet/minecraft/advancements/Advancement;Ljava/lang/String;)Z
      // 1432: pop
      // 1433: goto 1410
      // 1436: aload 8
      // 1438: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 143b: aconst_null
      // 143c: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 143f: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1442: dup
      // 1443: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1446: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1449: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 144c: getfield net/arphex/network/ArphexModVariables$PlayerVariables.killedscorpioid Z
      // 144f: ifeq 14fa
      // 1452: aload 8
      // 1454: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1457: aconst_null
      // 1458: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 145b: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 145e: dup
      // 145f: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1462: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1465: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1468: getfield net/arphex/network/ArphexModVariables$PlayerVariables.mothsurvivals D
      // 146b: ldc2_w 3.0
      // 146e: dcmpl
      // 146f: ifle 14fa
      // 1472: aload 8
      // 1474: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1477: aconst_null
      // 1478: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 147b: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 147e: dup
      // 147f: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1482: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1485: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1488: getfield net/arphex/network/ArphexModVariables$PlayerVariables.killedvoidlasher Z
      // 148b: ifeq 14fa
      // 148e: aload 8
      // 1490: instanceof net/minecraft/server/level/ServerPlayer
      // 1493: ifeq 14fa
      // 1496: aload 8
      // 1498: checkcast net/minecraft/server/level/ServerPlayer
      // 149b: astore 134
      // 149d: aload 134
      // 149f: getfield net/minecraft/server/level/ServerPlayer.server Lnet/minecraft/server/MinecraftServer;
      // 14a2: invokevirtual net/minecraft/server/MinecraftServer.getAdvancements ()Lnet/minecraft/server/ServerAdvancementManager;
      // 14a5: new net/minecraft/resources/ResourceLocation
      // 14a8: dup
      // 14a9: ldc_w "arphex:destroyer_of_suffering"
      // 14ac: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 14af: invokevirtual net/minecraft/server/ServerAdvancementManager.getAdvancement (Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/advancements/Advancement;
      // 14b2: astore 135
      // 14b4: aload 134
      // 14b6: invokevirtual net/minecraft/server/level/ServerPlayer.getAdvancements ()Lnet/minecraft/server/PlayerAdvancements;
      // 14b9: aload 135
      // 14bb: invokevirtual net/minecraft/server/PlayerAdvancements.getOrStartProgress (Lnet/minecraft/advancements/Advancement;)Lnet/minecraft/advancements/AdvancementProgress;
      // 14be: astore 136
      // 14c0: aload 136
      // 14c2: invokevirtual net/minecraft/advancements/AdvancementProgress.isDone ()Z
      // 14c5: ifne 14fa
      // 14c8: aload 136
      // 14ca: invokevirtual net/minecraft/advancements/AdvancementProgress.getRemainingCriteria ()Ljava/lang/Iterable;
      // 14cd: invokeinterface java/lang/Iterable.iterator ()Ljava/util/Iterator; 1
      // 14d2: astore 137
      // 14d4: aload 137
      // 14d6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14db: ifeq 14fa
      // 14de: aload 137
      // 14e0: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 14e5: checkcast java/lang/String
      // 14e8: astore 138
      // 14ea: aload 134
      // 14ec: invokevirtual net/minecraft/server/level/ServerPlayer.getAdvancements ()Lnet/minecraft/server/PlayerAdvancements;
      // 14ef: aload 135
      // 14f1: aload 138
      // 14f3: invokevirtual net/minecraft/server/PlayerAdvancements.award (Lnet/minecraft/advancements/Advancement;Ljava/lang/String;)Z
      // 14f6: pop
      // 14f7: goto 14d4
      // 14fa: aload 8
      // 14fc: instanceof net/minecraft/world/entity/LivingEntity
      // 14ff: ifeq 1511
      // 1502: aload 8
      // 1504: checkcast net/minecraft/world/entity/LivingEntity
      // 1507: astore 134
      // 1509: aload 134
      // 150b: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 150e: goto 1514
      // 1511: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1514: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1517: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 151a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 151d: if_acmpne 1557
      // 1520: aload 8
      // 1522: invokevirtual net/minecraft/world/entity/Entity.onGround ()Z
      // 1525: ifeq 1557
      // 1528: aload 8
      // 152a: instanceof net/minecraft/world/entity/LivingEntity
      // 152d: ifeq 1557
      // 1530: aload 8
      // 1532: checkcast net/minecraft/world/entity/LivingEntity
      // 1535: astore 135
      // 1537: aload 135
      // 1539: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 153c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 153f: ifne 1557
      // 1542: aload 135
      // 1544: new net/minecraft/world/effect/MobEffectInstance
      // 1547: dup
      // 1548: getstatic net/minecraft/world/effect/MobEffects.SLOW_FALLING Lnet/minecraft/world/effect/MobEffect;
      // 154b: bipush 10
      // 154d: bipush 1
      // 154e: bipush 1
      // 154f: bipush 0
      // 1550: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1553: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1556: pop
      // 1557: aload 8
      // 1559: instanceof net/minecraft/world/entity/LivingEntity
      // 155c: ifeq 156e
      // 155f: aload 8
      // 1561: checkcast net/minecraft/world/entity/LivingEntity
      // 1564: astore 134
      // 1566: aload 134
      // 1568: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 156b: goto 1571
      // 156e: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1571: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1574: getstatic net/arphex/init/ArphexModItems.TARANTULA_TETHER Lnet/minecraftforge/registries/RegistryObject;
      // 1577: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 157a: if_acmpeq 15a3
      // 157d: aload 8
      // 157f: instanceof net/minecraft/world/entity/LivingEntity
      // 1582: ifeq 1594
      // 1585: aload 8
      // 1587: checkcast net/minecraft/world/entity/LivingEntity
      // 158a: astore 135
      // 158c: aload 135
      // 158e: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1591: goto 1597
      // 1594: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1597: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 159a: getstatic net/arphex/init/ArphexModItems.TARANTULA_TETHER Lnet/minecraftforge/registries/RegistryObject;
      // 159d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 15a0: if_acmpne 176a
      // 15a3: aload 8
      // 15a5: invokevirtual net/minecraft/world/entity/Entity.isPassenger ()Z
      // 15a8: ifne 176a
      // 15ab: aload 1
      // 15ac: dload 2
      // 15ad: dload 4
      // 15af: dconst_0
      // 15b0: dadd
      // 15b1: dload 6
      // 15b3: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 15b6: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 15bb: aload 1
      // 15bc: dload 2
      // 15bd: dload 4
      // 15bf: dconst_0
      // 15c0: dadd
      // 15c1: dload 6
      // 15c3: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 15c6: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 15c9: f2d
      // 15ca: ldc2_w 0.3
      // 15cd: dcmpl
      // 15ce: ifge 16b7
      // 15d1: aload 1
      // 15d2: dload 2
      // 15d3: ldc2_w 0.7
      // 15d6: dadd
      // 15d7: dload 4
      // 15d9: dconst_0
      // 15da: dadd
      // 15db: dload 6
      // 15dd: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 15e0: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 15e5: aload 1
      // 15e6: dload 2
      // 15e7: ldc2_w 0.7
      // 15ea: dadd
      // 15eb: dload 4
      // 15ed: dconst_0
      // 15ee: dadd
      // 15ef: dload 6
      // 15f1: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 15f4: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 15f7: f2d
      // 15f8: ldc2_w 0.3
      // 15fb: dcmpl
      // 15fc: ifge 16b7
      // 15ff: aload 1
      // 1600: dload 2
      // 1601: ldc2_w 0.7
      // 1604: dsub
      // 1605: dload 4
      // 1607: dconst_0
      // 1608: dadd
      // 1609: dload 6
      // 160b: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 160e: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 1613: aload 1
      // 1614: dload 2
      // 1615: ldc2_w 0.7
      // 1618: dsub
      // 1619: dload 4
      // 161b: dconst_0
      // 161c: dadd
      // 161d: dload 6
      // 161f: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 1622: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 1625: f2d
      // 1626: ldc2_w 0.3
      // 1629: dcmpl
      // 162a: ifge 16b7
      // 162d: aload 1
      // 162e: dload 2
      // 162f: dload 4
      // 1631: dconst_0
      // 1632: dadd
      // 1633: dload 6
      // 1635: ldc2_w 0.7
      // 1638: dsub
      // 1639: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 163c: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 1641: aload 1
      // 1642: dload 2
      // 1643: dload 4
      // 1645: dconst_0
      // 1646: dadd
      // 1647: dload 6
      // 1649: ldc2_w 0.7
      // 164c: dsub
      // 164d: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 1650: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 1653: f2d
      // 1654: ldc2_w 0.3
      // 1657: dcmpl
      // 1658: ifge 16b7
      // 165b: aload 1
      // 165c: dload 2
      // 165d: dload 4
      // 165f: ldc2_w 0.5
      // 1662: dadd
      // 1663: dload 6
      // 1665: ldc2_w 0.7
      // 1668: dadd
      // 1669: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 166c: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 1671: aload 1
      // 1672: dload 2
      // 1673: dload 4
      // 1675: ldc2_w 0.5
      // 1678: dadd
      // 1679: dload 6
      // 167b: ldc2_w 0.7
      // 167e: dadd
      // 167f: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 1682: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 1685: f2d
      // 1686: ldc2_w 0.3
      // 1689: dcmpl
      // 168a: ifge 16b7
      // 168d: aload 1
      // 168e: dload 2
      // 168f: dload 4
      // 1691: ldc2_w 2.0
      // 1694: dadd
      // 1695: dload 6
      // 1697: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 169a: invokeinterface net/minecraft/world/level/LevelAccessor.getBlockState (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState; 2
      // 169f: aload 1
      // 16a0: dload 2
      // 16a1: dload 4
      // 16a3: ldc2_w 2.0
      // 16a6: dadd
      // 16a7: dload 6
      // 16a9: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 16ac: invokevirtual net/minecraft/world/level/block/state/BlockState.getDestroySpeed (Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F
      // 16af: f2d
      // 16b0: ldc2_w 0.3
      // 16b3: dcmpl
      // 16b4: iflt 176a
      // 16b7: aload 8
      // 16b9: invokevirtual net/minecraft/world/entity/Entity.isPassenger ()Z
      // 16bc: ifne 176a
      // 16bf: aload 1
      // 16c0: ldc_w net/arphex/entity/WebHarnessEntity
      // 16c3: new net/minecraft/world/phys/Vec3
      // 16c6: dup
      // 16c7: dload 2
      // 16c8: dload 4
      // 16ca: dload 6
      // 16cc: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 16cf: ldc2_w 8.0
      // 16d2: ldc2_w 8.0
      // 16d5: ldc2_w 8.0
      // 16d8: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 16db: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$46 (Lnet/arphex/entity/WebHarnessEntity;)Z, (Lnet/arphex/entity/WebHarnessEntity;)Z ]
      // 16e0: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 16e5: invokeinterface java/util/List.isEmpty ()Z 1
      // 16ea: ifeq 176a
      // 16ed: aload 8
      // 16ef: fconst_0
      // 16f0: putfield net/minecraft/world/entity/Entity.fallDistance F
      // 16f3: aload 1
      // 16f4: instanceof net/minecraft/server/level/ServerLevel
      // 16f7: ifeq 1721
      // 16fa: aload 1
      // 16fb: checkcast net/minecraft/server/level/ServerLevel
      // 16fe: astore 136
      // 1700: aload 136
      // 1702: getstatic net/arphex/init/ArphexModParticleTypes.THIN_WEB Lnet/minecraftforge/registries/RegistryObject;
      // 1705: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1708: checkcast net/minecraft/core/particles/SimpleParticleType
      // 170b: dload 2
      // 170c: dload 4
      // 170e: dload 6
      // 1710: bipush 5
      // 1711: ldc2_w 0.3
      // 1714: ldc2_w 0.3
      // 1717: ldc2_w 0.3
      // 171a: ldc2_w 0.3
      // 171d: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 1720: pop
      // 1721: aload 8
      // 1723: invokevirtual net/minecraft/world/entity/Entity.isShiftKeyDown ()Z
      // 1726: ifeq 174b
      // 1729: aload 8
      // 172b: new net/minecraft/world/phys/Vec3
      // 172e: dup
      // 172f: aload 8
      // 1731: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 1734: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 1737: ldc2_w -0.1
      // 173a: aload 8
      // 173c: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 173f: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 1742: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1745: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 1748: goto 176a
      // 174b: aload 8
      // 174d: new net/minecraft/world/phys/Vec3
      // 1750: dup
      // 1751: aload 8
      // 1753: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 1756: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 1759: ldc2_w 0.15
      // 175c: aload 8
      // 175e: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 1761: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 1764: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1767: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 176a: aload 8
      // 176c: invokevirtual net/minecraft/world/entity/Entity.isPassenger ()Z
      // 176f: ifeq 1b17
      // 1772: aload 8
      // 1774: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1777: instanceof net/arphex/entity/MantisMutilatorEntity
      // 177a: ifeq 17d4
      // 177d: aload 8
      // 177f: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1782: aconst_null
      // 1783: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1786: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1789: dup
      // 178a: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 178d: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1790: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1793: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 1796: ifeq 17d4
      // 1799: aload 8
      // 179b: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 179e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 17a1: ldc_w "checkangle"
      // 17a4: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 17a7: ldc2_w 5.0
      // 17aa: dcmpl
      // 17ab: ifne 17d4
      // 17ae: aload 8
      // 17b0: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 17b3: new net/minecraft/world/phys/Vec3
      // 17b6: dup
      // 17b7: aload 8
      // 17b9: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 17bc: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 17bf: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 17c2: dconst_1
      // 17c3: aload 8
      // 17c5: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 17c8: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 17cb: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 17ce: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 17d1: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 17d4: aload 8
      // 17d6: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 17d9: instanceof net/arphex/entity/SpiderMothSummonEntity
      // 17dc: ifne 17ea
      // 17df: aload 8
      // 17e1: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 17e4: instanceof net/arphex/entity/TormentorSummonEntity
      // 17e7: ifeq 1b17
      // 17ea: aload 8
      // 17ec: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 17ef: instanceof net/arphex/entity/SpiderMothSummonEntity
      // 17f2: ifeq 1887
      // 17f5: aload 8
      // 17f7: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 17fa: astore 135
      // 17fc: aload 135
      // 17fe: instanceof net/minecraft/world/entity/Mob
      // 1801: ifeq 1813
      // 1804: aload 135
      // 1806: checkcast net/minecraft/world/entity/Mob
      // 1809: astore 134
      // 180b: aload 134
      // 180d: invokevirtual net/minecraft/world/entity/Mob.getTarget ()Lnet/minecraft/world/entity/LivingEntity;
      // 1810: goto 1814
      // 1813: aconst_null
      // 1814: ifnull 1869
      // 1817: aload 1
      // 1818: instanceof net/minecraft/server/level/ServerLevel
      // 181b: ifeq 1840
      // 181e: aload 1
      // 181f: checkcast net/minecraft/server/level/ServerLevel
      // 1822: astore 135
      // 1824: aload 135
      // 1826: getstatic net/arphex/init/ArphexModParticleTypes.TINY_SPIDER Lnet/minecraftforge/registries/RegistryObject;
      // 1829: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 182c: checkcast net/minecraft/core/particles/SimpleParticleType
      // 182f: dload 2
      // 1830: dload 4
      // 1832: dload 6
      // 1834: bipush 30
      // 1836: dconst_1
      // 1837: dconst_1
      // 1838: dconst_1
      // 1839: ldc2_w 0.3
      // 183c: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 183f: pop
      // 1840: aload 1
      // 1841: instanceof net/minecraft/server/level/ServerLevel
      // 1844: ifeq 1869
      // 1847: aload 1
      // 1848: checkcast net/minecraft/server/level/ServerLevel
      // 184b: astore 135
      // 184d: aload 135
      // 184f: getstatic net/arphex/init/ArphexModParticleTypes.TINY_MOTH Lnet/minecraftforge/registries/RegistryObject;
      // 1852: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1855: checkcast net/minecraft/core/particles/SimpleParticleType
      // 1858: dload 2
      // 1859: dload 4
      // 185b: dload 6
      // 185d: bipush 30
      // 185f: dconst_1
      // 1860: dconst_1
      // 1861: dconst_1
      // 1862: ldc2_w 0.3
      // 1865: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 1868: pop
      // 1869: aload 8
      // 186b: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 186e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1871: ldc_w "teleportattack"
      // 1874: aload 8
      // 1876: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1879: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 187c: ldc_w "teleportattack"
      // 187f: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1882: dconst_1
      // 1883: dsub
      // 1884: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1887: aload 8
      // 1889: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 188c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 188f: ldc_w "hovermode"
      // 1892: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1895: bipush 1
      // 1896: if_icmpne 18bf
      // 1899: aload 8
      // 189b: instanceof net/minecraft/world/entity/player/Player
      // 189e: ifeq 18bf
      // 18a1: aload 8
      // 18a3: checkcast net/minecraft/world/entity/player/Player
      // 18a6: astore 134
      // 18a8: aload 134
      // 18aa: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 18ad: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 18b0: ifne 18bf
      // 18b3: aload 134
      // 18b5: ldc_w "Hovering Mode Active (Double Jump)"
      // 18b8: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 18bb: bipush 1
      // 18bc: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 18bf: aload 8
      // 18c1: fconst_0
      // 18c2: putfield net/minecraft/world/entity/Entity.fallDistance F
      // 18c5: aload 8
      // 18c7: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 18ca: instanceof net/arphex/entity/TormentorSummonEntity
      // 18cd: ifeq 1928
      // 18d0: aload 8
      // 18d2: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 18d5: aconst_null
      // 18d6: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 18d9: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 18dc: dup
      // 18dd: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 18e0: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 18e3: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 18e6: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 18e9: ifeq 1928
      // 18ec: aload 8
      // 18ee: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 18f1: astore 135
      // 18f3: aload 135
      // 18f5: instanceof net/minecraft/world/entity/LivingEntity
      // 18f8: ifeq 1928
      // 18fb: aload 135
      // 18fd: checkcast net/minecraft/world/entity/LivingEntity
      // 1900: astore 134
      // 1902: aload 134
      // 1904: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1907: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 190a: ifne 1928
      // 190d: aload 134
      // 190f: new net/minecraft/world/effect/MobEffectInstance
      // 1912: dup
      // 1913: getstatic net/arphex/init/ArphexModMobEffects.MOTH_CURSE Lnet/minecraftforge/registries/RegistryObject;
      // 1916: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1919: checkcast net/minecraft/world/effect/MobEffect
      // 191c: bipush 10
      // 191e: bipush 0
      // 191f: bipush 0
      // 1920: bipush 0
      // 1921: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1924: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1927: pop
      // 1928: aload 8
      // 192a: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 192d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1930: ldc_w "hovermode"
      // 1933: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1936: bipush 1
      // 1937: if_icmpne 1946
      // 193a: bipush 20
      // 193c: aload 8
      // 193e: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$47 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1943: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1946: aload 8
      // 1948: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 194b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 194e: ldc_w "doublectrl"
      // 1951: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 1954: ldc_w "waitingforrepeat"
      // 1957: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 195a: ifeq 19c9
      // 195d: aload 8
      // 195f: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1962: aconst_null
      // 1963: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1966: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1969: dup
      // 196a: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 196d: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1970: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1973: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 1976: ifeq 19bd
      // 1979: aload 8
      // 197b: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 197e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1981: ldc_w "doublectrl"
      // 1984: ldc_w "non"
      // 1987: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 198a: aload 8
      // 198c: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 198f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1992: ldc_w "hovermode"
      // 1995: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1998: bipush 1
      // 1999: if_icmpne 19ae
      // 199c: aload 8
      // 199e: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 19a1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 19a4: ldc_w "hovermode"
      // 19a7: bipush 0
      // 19a8: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 19ab: goto 19bd
      // 19ae: aload 8
      // 19b0: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 19b3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 19b6: ldc_w "hovermode"
      // 19b9: bipush 1
      // 19ba: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 19bd: bipush 10
      // 19bf: aload 8
      // 19c1: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$48 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 19c6: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 19c9: aload 8
      // 19cb: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 19ce: aconst_null
      // 19cf: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 19d2: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 19d5: dup
      // 19d6: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 19d9: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 19dc: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 19df: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 19e2: ifne 1a0d
      // 19e5: aload 8
      // 19e7: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 19ea: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 19ed: ldc_w "doublectrl"
      // 19f0: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 19f3: ldc_w "justclicked"
      // 19f6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 19f9: ifeq 1a0d
      // 19fc: aload 8
      // 19fe: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1a01: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1a04: ldc_w "doublectrl"
      // 1a07: ldc_w "waitingforrepeat"
      // 1a0a: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 1a0d: aload 8
      // 1a0f: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1a12: aconst_null
      // 1a13: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1a16: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1a19: dup
      // 1a1a: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1a1d: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1a20: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1a23: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 1a26: ifeq 1b17
      // 1a29: aload 8
      // 1a2b: invokevirtual net/minecraft/world/entity/Entity.isPassenger ()Z
      // 1a2e: ifeq 1b17
      // 1a31: aload 8
      // 1a33: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1a36: astore 135
      // 1a38: aload 135
      // 1a3a: instanceof net/minecraft/world/entity/LivingEntity
      // 1a3d: ifeq 1a6c
      // 1a40: aload 135
      // 1a42: checkcast net/minecraft/world/entity/LivingEntity
      // 1a45: astore 134
      // 1a47: aload 134
      // 1a49: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1a4c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 1a4f: ifne 1a6c
      // 1a52: aload 134
      // 1a54: new net/minecraft/world/effect/MobEffectInstance
      // 1a57: dup
      // 1a58: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 1a5b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1a5e: checkcast net/minecraft/world/effect/MobEffect
      // 1a61: bipush 5
      // 1a62: bipush 0
      // 1a63: bipush 1
      // 1a64: bipush 0
      // 1a65: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1a68: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1a6b: pop
      // 1a6c: aload 8
      // 1a6e: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1a71: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1a74: ldc_w "spiderjump"
      // 1a77: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1a7a: dconst_0
      // 1a7b: dcmpl
      // 1a7c: ifgt 1b17
      // 1a7f: aload 8
      // 1a81: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1a84: astore 135
      // 1a86: aload 135
      // 1a88: instanceof net/minecraft/world/entity/LivingEntity
      // 1a8b: ifeq 1ab5
      // 1a8e: aload 135
      // 1a90: checkcast net/minecraft/world/entity/LivingEntity
      // 1a93: astore 134
      // 1a95: aload 134
      // 1a97: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1a9a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 1a9d: ifne 1ab5
      // 1aa0: aload 134
      // 1aa2: new net/minecraft/world/effect/MobEffectInstance
      // 1aa5: dup
      // 1aa6: getstatic net/minecraft/world/effect/MobEffects.SLOW_FALLING Lnet/minecraft/world/effect/MobEffect;
      // 1aa9: bipush 15
      // 1aab: bipush 0
      // 1aac: bipush 1
      // 1aad: bipush 0
      // 1aae: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1ab1: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1ab4: pop
      // 1ab5: aload 8
      // 1ab7: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1aba: new net/minecraft/world/phys/Vec3
      // 1abd: dup
      // 1abe: aload 8
      // 1ac0: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1ac3: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 1ac6: ldc_w 90.0
      // 1ac9: fadd
      // 1aca: f2d
      // 1acb: ldc2_w 0.017453292519943295
      // 1ace: dmul
      // 1acf: invokestatic java/lang/Math.cos (D)D
      // 1ad2: ldc2_w 1.5
      // 1ad5: dmul
      // 1ad6: dconst_1
      // 1ad7: aload 8
      // 1ad9: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1adc: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 1adf: ldc_w 90.0
      // 1ae2: fadd
      // 1ae3: f2d
      // 1ae4: ldc2_w 0.017453292519943295
      // 1ae7: dmul
      // 1ae8: invokestatic java/lang/Math.sin (D)D
      // 1aeb: ldc2_w 1.5
      // 1aee: dmul
      // 1aef: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1af2: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 1af5: aload 8
      // 1af7: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1afa: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1afd: ldc_w "spiderjump"
      // 1b00: ldc2_w 20.0
      // 1b03: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1b06: aload 8
      // 1b08: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1b0b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1b0e: ldc_w "doublectrl"
      // 1b11: ldc_w "justclicked"
      // 1b14: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 1b17: aload 8
      // 1b19: invokevirtual net/minecraft/world/entity/Entity.isPassenger ()Z
      // 1b1c: ifeq 1d53
      // 1b1f: aload 8
      // 1b21: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1b24: instanceof net/arphex/entity/WebHarnessDownEntity
      // 1b27: ifeq 1c1b
      // 1b2a: aload 8
      // 1b2c: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1b2f: aconst_null
      // 1b30: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1b33: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1b36: dup
      // 1b37: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1b3a: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1b3d: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1b40: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 1b43: ifeq 1bf9
      // 1b46: aload 8
      // 1b48: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1b4b: ldc_w "doublespace"
      // 1b4e: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 1b51: ldc_w "inactive"
      // 1b54: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1b57: ifeq 1b6c
      // 1b5a: aload 8
      // 1b5c: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1b5f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1b62: ldc_w "hovers"
      // 1b65: bipush 0
      // 1b66: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 1b69: goto 1b78
      // 1b6c: bipush 10
      // 1b6e: aload 8
      // 1b70: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$49 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1b75: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1b78: aload 8
      // 1b7a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1b7d: ldc_w "doublespace"
      // 1b80: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 1b83: ldc_w "letgo"
      // 1b86: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1b89: ifeq 1be8
      // 1b8c: aload 8
      // 1b8e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1b91: ldc_w "doublespace"
      // 1b94: ldc_w "clicked2"
      // 1b97: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 1b9a: aload 8
      // 1b9c: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1b9f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1ba2: ldc_w "hovers"
      // 1ba5: bipush 1
      // 1ba6: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 1ba9: aload 8
      // 1bab: instanceof net/minecraft/world/entity/player/Player
      // 1bae: ifeq 1bcf
      // 1bb1: aload 8
      // 1bb3: checkcast net/minecraft/world/entity/player/Player
      // 1bb6: astore 134
      // 1bb8: aload 134
      // 1bba: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 1bbd: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 1bc0: ifne 1bcf
      // 1bc3: aload 134
      // 1bc5: ldc_w "Hovering Mode Active (Double Jump)"
      // 1bc8: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 1bcb: bipush 1
      // 1bcc: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 1bcf: aload 8
      // 1bd1: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1bd4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1bd7: ldc_w "hoverpos"
      // 1bda: aload 8
      // 1bdc: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1bdf: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1be2: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1be5: goto 1c1b
      // 1be8: aload 8
      // 1bea: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1bed: ldc_w "doublespace"
      // 1bf0: ldc_w "clicked1"
      // 1bf3: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 1bf6: goto 1c1b
      // 1bf9: aload 8
      // 1bfb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1bfe: ldc_w "doublespace"
      // 1c01: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 1c04: ldc_w "clicked1"
      // 1c07: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1c0a: ifeq 1c1b
      // 1c0d: aload 8
      // 1c0f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1c12: ldc_w "doublespace"
      // 1c15: ldc_w "letgo"
      // 1c18: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 1c1b: aload 8
      // 1c1d: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1c20: instanceof net/arphex/entity/WebHarnessEntity
      // 1c23: ifne 1c4d
      // 1c26: aload 8
      // 1c28: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1c2b: instanceof net/arphex/entity/WebHarnessDownEntity
      // 1c2e: ifeq 1d53
      // 1c31: aload 8
      // 1c33: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1c36: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1c39: aload 8
      // 1c3b: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1c3e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1c41: ldc_w "targetY"
      // 1c44: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1c47: dconst_1
      // 1c48: dsub
      // 1c49: dcmpg
      // 1c4a: ifge 1d53
      // 1c4d: aload 8
      // 1c4f: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1c52: aconst_null
      // 1c53: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1c56: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1c59: dup
      // 1c5a: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1c5d: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1c60: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1c63: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 1c66: ifeq 1d53
      // 1c69: aload 8
      // 1c6b: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1c6e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1c71: ldc_w "spacelimit"
      // 1c74: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1c77: ifne 1d53
      // 1c7a: aload 8
      // 1c7c: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 1c7f: aload 8
      // 1c81: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1c84: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1c87: ldc_w "targetX"
      // 1c8a: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1c8d: ldc2_w 2.0
      // 1c90: dsub
      // 1c91: dcmpl
      // 1c92: ifle 1d11
      // 1c95: aload 8
      // 1c97: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 1c9a: aload 8
      // 1c9c: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1c9f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1ca2: ldc_w "targetX"
      // 1ca5: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1ca8: ldc2_w 2.0
      // 1cab: dadd
      // 1cac: dcmpg
      // 1cad: ifge 1d11
      // 1cb0: aload 8
      // 1cb2: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1cb5: aload 8
      // 1cb7: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1cba: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1cbd: ldc_w "targetZ"
      // 1cc0: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1cc3: ldc2_w 2.0
      // 1cc6: dsub
      // 1cc7: dcmpl
      // 1cc8: ifle 1d11
      // 1ccb: aload 8
      // 1ccd: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 1cd0: aload 8
      // 1cd2: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1cd5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1cd8: ldc_w "targetZ"
      // 1cdb: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1cde: ldc2_w 2.0
      // 1ce1: dadd
      // 1ce2: dcmpg
      // 1ce3: ifge 1d11
      // 1ce6: aload 8
      // 1ce8: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1ceb: new net/minecraft/world/phys/Vec3
      // 1cee: dup
      // 1cef: aload 8
      // 1cf1: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1cf4: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 1cf7: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 1cfa: ldc2_w 0.1
      // 1cfd: aload 8
      // 1cff: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1d02: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 1d05: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 1d08: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1d0b: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 1d0e: goto 1d53
      // 1d11: aload 8
      // 1d13: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1d16: new net/minecraft/world/phys/Vec3
      // 1d19: dup
      // 1d1a: aload 8
      // 1d1c: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1d1f: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 1d22: ldc_w 90.0
      // 1d25: fadd
      // 1d26: f2d
      // 1d27: ldc2_w 0.017453292519943295
      // 1d2a: dmul
      // 1d2b: invokestatic java/lang/Math.cos (D)D
      // 1d2e: ldc2_w 4.0
      // 1d31: ddiv
      // 1d32: ldc2_w 0.05
      // 1d35: aload 8
      // 1d37: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1d3a: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 1d3d: ldc_w 90.0
      // 1d40: fadd
      // 1d41: f2d
      // 1d42: ldc2_w 0.017453292519943295
      // 1d45: dmul
      // 1d46: invokestatic java/lang/Math.sin (D)D
      // 1d49: ldc2_w 4.0
      // 1d4c: ddiv
      // 1d4d: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1d50: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 1d53: aload 8
      // 1d55: instanceof net/minecraft/world/entity/LivingEntity
      // 1d58: ifeq 1d6a
      // 1d5b: aload 8
      // 1d5d: checkcast net/minecraft/world/entity/LivingEntity
      // 1d60: astore 134
      // 1d62: aload 134
      // 1d64: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1d67: goto 1d6d
      // 1d6a: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1d6d: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1d70: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 1d73: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1d76: if_acmpne 1dba
      // 1d79: aload 8
      // 1d7b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1d7e: ldc_w "abflytime"
      // 1d81: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1d84: ldc2_w 78.0
      // 1d87: dcmpl
      // 1d88: ifle 1dba
      // 1d8b: aload 8
      // 1d8d: instanceof net/minecraft/world/entity/LivingEntity
      // 1d90: ifeq 1dba
      // 1d93: aload 8
      // 1d95: checkcast net/minecraft/world/entity/LivingEntity
      // 1d98: astore 135
      // 1d9a: aload 135
      // 1d9c: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1d9f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 1da2: ifne 1dba
      // 1da5: aload 135
      // 1da7: new net/minecraft/world/effect/MobEffectInstance
      // 1daa: dup
      // 1dab: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_BOOST Lnet/minecraft/world/effect/MobEffect;
      // 1dae: bipush 10
      // 1db0: bipush 0
      // 1db1: bipush 0
      // 1db2: bipush 0
      // 1db3: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1db6: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1db9: pop
      // 1dba: aload 8
      // 1dbc: instanceof net/minecraft/world/entity/LivingEntity
      // 1dbf: ifeq 1dd1
      // 1dc2: aload 8
      // 1dc4: checkcast net/minecraft/world/entity/LivingEntity
      // 1dc7: astore 134
      // 1dc9: aload 134
      // 1dcb: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1dce: goto 1dd4
      // 1dd1: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1dd4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1dd7: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 1dda: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1ddd: if_acmpeq 1e06
      // 1de0: aload 8
      // 1de2: instanceof net/minecraft/world/entity/LivingEntity
      // 1de5: ifeq 1df7
      // 1de8: aload 8
      // 1dea: checkcast net/minecraft/world/entity/LivingEntity
      // 1ded: astore 135
      // 1def: aload 135
      // 1df1: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1df4: goto 1dfa
      // 1df7: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1dfa: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1dfd: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 1e00: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1e03: if_acmpne 1ebf
      // 1e06: aload 8
      // 1e08: fconst_0
      // 1e09: putfield net/minecraft/world/entity/Entity.fallDistance F
      // 1e0c: aload 8
      // 1e0e: instanceof net/minecraft/world/entity/LivingEntity
      // 1e11: ifeq 1e23
      // 1e14: aload 8
      // 1e16: checkcast net/minecraft/world/entity/LivingEntity
      // 1e19: astore 136
      // 1e1b: aload 136
      // 1e1d: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1e20: goto 1e26
      // 1e23: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1e26: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1e29: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 1e2c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1e2f: if_acmpne 1e9f
      // 1e32: aload 8
      // 1e34: instanceof net/minecraft/world/entity/LivingEntity
      // 1e37: ifeq 1e49
      // 1e3a: aload 8
      // 1e3c: checkcast net/minecraft/world/entity/LivingEntity
      // 1e3f: astore 137
      // 1e41: aload 137
      // 1e43: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1e46: goto 1e4c
      // 1e49: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1e4c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1e4f: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 1e52: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1e55: if_acmpne 1e9f
      // 1e58: aload 1
      // 1e59: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 1e5c: getfield net/arphex/network/ArphexModVariables$MapVariables.bosskills Ljava/lang/String;
      // 1e5f: ldc_w "tormentor"
      // 1e62: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 1e65: ifne 1e8e
      // 1e68: aload 8
      // 1e6a: instanceof net/minecraft/world/entity/LivingEntity
      // 1e6d: ifeq 1e7f
      // 1e70: aload 8
      // 1e72: checkcast net/minecraft/world/entity/LivingEntity
      // 1e75: astore 138
      // 1e77: aload 138
      // 1e79: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 1e7c: goto 1e82
      // 1e7f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1e82: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 1e85: ldc_w "crafted"
      // 1e88: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 1e8b: ifne 1ebf
      // 1e8e: aload 8
      // 1e90: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1e93: ldc_w "abflytime"
      // 1e96: ldc2_w 52000.0
      // 1e99: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1e9c: goto 1ebf
      // 1e9f: aload 8
      // 1ea1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1ea4: ldc_w "abflytime"
      // 1ea7: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1eaa: ldc2_w 80.0
      // 1ead: dcmpl
      // 1eae: ifle 1ebf
      // 1eb1: aload 8
      // 1eb3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1eb6: ldc_w "abflytime"
      // 1eb9: ldc2_w 80.0
      // 1ebc: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1ebf: aload 8
      // 1ec1: invokevirtual net/minecraft/world/entity/Entity.isPassenger ()Z
      // 1ec4: ifeq 1fb6
      // 1ec7: aload 8
      // 1ec9: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1ecc: instanceof net/arphex/entity/TamedTarantulaEntity
      // 1ecf: ifeq 1fb6
      // 1ed2: aload 8
      // 1ed4: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 1ed7: aconst_null
      // 1ed8: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 1edb: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 1ede: dup
      // 1edf: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 1ee2: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1ee5: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 1ee8: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 1eeb: ifeq 1fb6
      // 1eee: aload 8
      // 1ef0: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1ef3: astore 135
      // 1ef5: aload 135
      // 1ef7: instanceof net/minecraft/world/entity/LivingEntity
      // 1efa: ifeq 1f29
      // 1efd: aload 135
      // 1eff: checkcast net/minecraft/world/entity/LivingEntity
      // 1f02: astore 134
      // 1f04: aload 134
      // 1f06: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 1f09: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 1f0c: ifne 1f29
      // 1f0f: aload 134
      // 1f11: new net/minecraft/world/effect/MobEffectInstance
      // 1f14: dup
      // 1f15: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 1f18: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1f1b: checkcast net/minecraft/world/effect/MobEffect
      // 1f1e: bipush 5
      // 1f1f: bipush 0
      // 1f20: bipush 1
      // 1f21: bipush 0
      // 1f22: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 1f25: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 1f28: pop
      // 1f29: aload 8
      // 1f2b: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1f2e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1f31: ldc_w "spiderjump"
      // 1f34: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 1f37: dconst_0
      // 1f38: dcmpl
      // 1f39: ifgt 1fb6
      // 1f3c: aload 1
      // 1f3d: dload 2
      // 1f3e: aload 8
      // 1f40: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1f43: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 1f46: ldc2_w 0.1
      // 1f49: dsub
      // 1f4a: dload 6
      // 1f4c: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 1f4f: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 1f54: ifne 1fb6
      // 1f57: aload 8
      // 1f59: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1f5c: new net/minecraft/world/phys/Vec3
      // 1f5f: dup
      // 1f60: aload 8
      // 1f62: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1f65: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 1f68: ldc_w 90.0
      // 1f6b: fadd
      // 1f6c: f2d
      // 1f6d: ldc2_w 0.017453292519943295
      // 1f70: dmul
      // 1f71: invokestatic java/lang/Math.cos (D)D
      // 1f74: ldc2_w 1.2
      // 1f77: ddiv
      // 1f78: ldc2_w 0.85
      // 1f7b: aload 8
      // 1f7d: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1f80: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 1f83: ldc_w 90.0
      // 1f86: fadd
      // 1f87: f2d
      // 1f88: ldc2_w 0.017453292519943295
      // 1f8b: dmul
      // 1f8c: invokestatic java/lang/Math.sin (D)D
      // 1f8f: ldc2_w 1.2
      // 1f92: ddiv
      // 1f93: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 1f96: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 1f99: aload 8
      // 1f9b: invokevirtual net/minecraft/world/entity/Entity.getVehicle ()Lnet/minecraft/world/entity/Entity;
      // 1f9e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 1fa1: ldc_w "spiderjump"
      // 1fa4: ldc2_w 40.0
      // 1fa7: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 1faa: bipush 20
      // 1fac: aload 8
      // 1fae: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$50 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 1fb3: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 1fb6: aload 8
      // 1fb8: instanceof net/minecraft/world/entity/LivingEntity
      // 1fbb: ifeq 1fcd
      // 1fbe: aload 8
      // 1fc0: checkcast net/minecraft/world/entity/LivingEntity
      // 1fc3: astore 134
      // 1fc5: aload 134
      // 1fc7: invokevirtual net/minecraft/world/entity/LivingEntity.getUseItem ()Lnet/minecraft/world/item/ItemStack;
      // 1fca: goto 1fd0
      // 1fcd: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 1fd0: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 1fd3: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 1fd6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 1fd9: if_acmpne 229a
      // 1fdc: aload 8
      // 1fde: instanceof net/minecraft/world/entity/LivingEntity
      // 1fe1: ifeq 2112
      // 1fe4: aload 8
      // 1fe6: checkcast net/minecraft/world/entity/LivingEntity
      // 1fe9: astore 135
      // 1feb: aload 135
      // 1fed: invokevirtual net/minecraft/world/entity/LivingEntity.isFallFlying ()Z
      // 1ff0: ifeq 2112
      // 1ff3: bipush 2
      // 1ff4: aload 1
      // 1ff5: dload 2
      // 1ff6: dload 4
      // 1ff8: dload 6
      // 1ffa: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$51 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 1fff: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2002: bipush 6
      // 2004: aload 1
      // 2005: dload 2
      // 2006: dload 4
      // 2008: dload 6
      // 200a: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;DDD)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$52 (Lnet/minecraft/world/level/LevelAccessor;DDD)V, ()V ]
      // 200f: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2012: aload 8
      // 2014: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 2017: fconst_0
      // 2018: fcmpl
      // 2019: ifle 2061
      // 201c: aload 8
      // 201e: new net/minecraft/world/phys/Vec3
      // 2021: dup
      // 2022: aload 8
      // 2024: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 2027: ldc_w 90.0
      // 202a: fadd
      // 202b: f2d
      // 202c: ldc2_w 0.017453292519943295
      // 202f: dmul
      // 2030: invokestatic java/lang/Math.cos (D)D
      // 2033: ldc2_w 2.0
      // 2036: dmul
      // 2037: fconst_0
      // 2038: aload 8
      // 203a: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 203d: fsub
      // 203e: ldc_w 75.0
      // 2041: fdiv
      // 2042: f2d
      // 2043: aload 8
      // 2045: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 2048: ldc_w 90.0
      // 204b: fadd
      // 204c: f2d
      // 204d: ldc2_w 0.017453292519943295
      // 2050: dmul
      // 2051: invokestatic java/lang/Math.sin (D)D
      // 2054: ldc2_w 2.0
      // 2057: dmul
      // 2058: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 205b: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 205e: goto 20a4
      // 2061: aload 8
      // 2063: new net/minecraft/world/phys/Vec3
      // 2066: dup
      // 2067: aload 8
      // 2069: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 206c: ldc_w 90.0
      // 206f: fadd
      // 2070: f2d
      // 2071: ldc2_w 0.017453292519943295
      // 2074: dmul
      // 2075: invokestatic java/lang/Math.cos (D)D
      // 2078: ldc2_w 2.0
      // 207b: dmul
      // 207c: aload 8
      // 207e: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 2081: invokestatic java/lang/Math.abs (F)F
      // 2084: ldc_w 75.0
      // 2087: fdiv
      // 2088: f2d
      // 2089: aload 8
      // 208b: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 208e: ldc_w 90.0
      // 2091: fadd
      // 2092: f2d
      // 2093: ldc2_w 0.017453292519943295
      // 2096: dmul
      // 2097: invokestatic java/lang/Math.sin (D)D
      // 209a: ldc2_w 2.0
      // 209d: dmul
      // 209e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 20a1: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 20a4: aload 8
      // 20a6: instanceof net/minecraft/world/entity/LivingEntity
      // 20a9: ifeq 20bb
      // 20ac: aload 8
      // 20ae: checkcast net/minecraft/world/entity/LivingEntity
      // 20b1: astore 136
      // 20b3: aload 136
      // 20b5: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 20b8: goto 20be
      // 20bb: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 20be: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 20c1: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 20c4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 20c7: if_acmpne 2101
      // 20ca: aload 8
      // 20cc: instanceof net/minecraft/world/entity/LivingEntity
      // 20cf: ifeq 20e1
      // 20d2: aload 8
      // 20d4: checkcast net/minecraft/world/entity/LivingEntity
      // 20d7: astore 137
      // 20d9: aload 137
      // 20db: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 20de: goto 20e4
      // 20e1: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 20e4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 20e7: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 20ea: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 20ed: if_acmpne 2101
      // 20f0: aload 8
      // 20f2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 20f5: ldc_w "abflytime"
      // 20f8: ldc2_w 52000.0
      // 20fb: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 20fe: goto 229a
      // 2101: aload 8
      // 2103: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2106: ldc_w "abflytime"
      // 2109: ldc2_w 80.0
      // 210c: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 210f: goto 229a
      // 2112: aload 8
      // 2114: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2117: ldc_w "abflytime"
      // 211a: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 211d: ldc2_w 10.0
      // 2120: dcmpl
      // 2121: ifle 229a
      // 2124: aload 1
      // 2125: instanceof net/minecraft/server/level/ServerLevel
      // 2128: ifeq 2153
      // 212b: aload 1
      // 212c: checkcast net/minecraft/server/level/ServerLevel
      // 212f: astore 136
      // 2131: aload 136
      // 2133: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_RED_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 2136: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2139: checkcast net/minecraft/core/particles/SimpleParticleType
      // 213c: dload 2
      // 213d: dload 4
      // 213f: dload 6
      // 2141: bipush 20
      // 2143: ldc2_w 0.5
      // 2146: ldc2_w 0.5
      // 2149: ldc2_w 0.5
      // 214c: ldc2_w 0.5
      // 214f: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 2152: pop
      // 2153: aload 8
      // 2155: instanceof net/minecraft/world/entity/LivingEntity
      // 2158: ifeq 2188
      // 215b: aload 8
      // 215d: checkcast net/minecraft/world/entity/LivingEntity
      // 2160: astore 136
      // 2162: aload 136
      // 2164: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2167: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 216a: ifne 2188
      // 216d: aload 136
      // 216f: new net/minecraft/world/effect/MobEffectInstance
      // 2172: dup
      // 2173: getstatic net/arphex/init/ArphexModMobEffects.AB_FLIGHT Lnet/minecraftforge/registries/RegistryObject;
      // 2176: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2179: checkcast net/minecraft/world/effect/MobEffect
      // 217c: bipush 60
      // 217e: bipush 0
      // 217f: bipush 0
      // 2180: bipush 0
      // 2181: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2184: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2187: pop
      // 2188: new net/minecraft/world/phys/Vec3
      // 218b: dup
      // 218c: dload 2
      // 218d: dload 4
      // 218f: dload 6
      // 2191: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2194: astore 136
      // 2196: aload 1
      // 2197: ldc net/minecraft/world/entity/Entity
      // 2199: new net/minecraft/world/phys/AABB
      // 219c: dup
      // 219d: aload 136
      // 219f: aload 136
      // 21a1: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 21a4: ldc2_w 4.0
      // 21a7: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 21aa: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$53 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 21af: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 21b4: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 21b9: aload 136
      // 21bb: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$54 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 21c0: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 21c3: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 21c8: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 21cd: astore 137
      // 21cf: aload 137
      // 21d1: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 21d6: astore 138
      // 21d8: aload 138
      // 21da: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 21df: ifeq 229a
      // 21e2: aload 138
      // 21e4: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 21e9: checkcast net/minecraft/world/entity/Entity
      // 21ec: astore 139
      // 21ee: aload 139
      // 21f0: instanceof net/minecraft/world/entity/player/Player
      // 21f3: ifne 2211
      // 21f6: aload 139
      // 21f8: getstatic net/minecraft/world/level/block/Blocks.AIR Lnet/minecraft/world/level/block/Block;
      // 21fb: invokevirtual net/minecraft/world/level/block/Block.defaultBlockState ()Lnet/minecraft/world/level/block/state/BlockState;
      // 21fe: new net/minecraft/world/phys/Vec3
      // 2201: dup
      // 2202: ldc2_w 0.25
      // 2205: ldc2_w 0.05
      // 2208: ldc2_w 0.25
      // 220b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 220e: invokevirtual net/minecraft/world/entity/Entity.makeStuckInBlock (Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/phys/Vec3;)V
      // 2211: aload 139
      // 2213: invokevirtual net/minecraft/world/entity/Entity.getType ()Lnet/minecraft/world/entity/EntityType;
      // 2216: getstatic net/minecraft/core/registries/Registries.ENTITY_TYPE Lnet/minecraft/resources/ResourceKey;
      // 2219: new net/minecraft/resources/ResourceLocation
      // 221c: dup
      // 221d: ldc_w "minecraft:impact_projectiles"
      // 2220: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 2223: invokestatic net/minecraft/tags/TagKey.create (Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/tags/TagKey;
      // 2226: invokevirtual net/minecraft/world/entity/EntityType.is (Lnet/minecraft/tags/TagKey;)Z
      // 2229: ifne 2288
      // 222c: aload 139
      // 222e: instanceof net/arphex/entity/BloodProjectileEntity
      // 2231: ifeq 2280
      // 2234: aload 8
      // 2236: instanceof net/minecraft/world/entity/LivingEntity
      // 2239: ifeq 224b
      // 223c: aload 8
      // 223e: checkcast net/minecraft/world/entity/LivingEntity
      // 2241: astore 140
      // 2243: aload 140
      // 2245: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2248: goto 224e
      // 224b: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 224e: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2251: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 2254: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2257: if_acmpeq 2280
      // 225a: aload 8
      // 225c: instanceof net/minecraft/world/entity/LivingEntity
      // 225f: ifeq 2271
      // 2262: aload 8
      // 2264: checkcast net/minecraft/world/entity/LivingEntity
      // 2267: astore 141
      // 2269: aload 141
      // 226b: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 226e: goto 2274
      // 2271: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2274: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2277: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 227a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 227d: if_acmpne 2288
      // 2280: aload 139
      // 2282: instanceof net/arphex/entity/WebbedArrowEntity
      // 2285: ifeq 2297
      // 2288: aload 139
      // 228a: new net/minecraft/world/phys/Vec3
      // 228d: dup
      // 228e: dconst_0
      // 228f: dconst_0
      // 2290: dconst_0
      // 2291: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2294: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 2297: goto 21d8
      // 229a: aload 8
      // 229c: instanceof net/minecraft/world/entity/LivingEntity
      // 229f: ifeq 22b1
      // 22a2: aload 8
      // 22a4: checkcast net/minecraft/world/entity/LivingEntity
      // 22a7: astore 134
      // 22a9: aload 134
      // 22ab: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 22ae: goto 22b4
      // 22b1: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 22b4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 22b7: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 22ba: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 22bd: if_acmpne 2411
      // 22c0: aload 8
      // 22c2: instanceof net/minecraft/world/entity/LivingEntity
      // 22c5: ifeq 22d7
      // 22c8: aload 8
      // 22ca: checkcast net/minecraft/world/entity/LivingEntity
      // 22cd: astore 135
      // 22cf: aload 135
      // 22d1: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 22d4: goto 22da
      // 22d7: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 22da: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 22dd: getstatic net/arphex/init/ArphexModItems.ABYSS_ASCENDANT Lnet/minecraftforge/registries/RegistryObject;
      // 22e0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 22e3: if_acmpne 2411
      // 22e6: aload 8
      // 22e8: fconst_0
      // 22e9: putfield net/minecraft/world/entity/Entity.fallDistance F
      // 22ec: aload 1
      // 22ed: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 22f0: getfield net/arphex/network/ArphexModVariables$MapVariables.bosskills Ljava/lang/String;
      // 22f3: ldc_w "tormentor"
      // 22f6: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 22f9: ifne 2322
      // 22fc: aload 8
      // 22fe: instanceof net/minecraft/world/entity/LivingEntity
      // 2301: ifeq 2313
      // 2304: aload 8
      // 2306: checkcast net/minecraft/world/entity/LivingEntity
      // 2309: astore 136
      // 230b: aload 136
      // 230d: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2310: goto 2316
      // 2313: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2316: invokevirtual net/minecraft/world/item/ItemStack.getOrCreateTag ()Lnet/minecraft/nbt/CompoundTag;
      // 2319: ldc_w "crafted"
      // 231c: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 231f: ifne 2333
      // 2322: aload 8
      // 2324: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2327: ldc_w "abflytime"
      // 232a: ldc2_w 52000.0
      // 232d: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 2330: goto 236f
      // 2333: aload 1
      // 2334: ldc_w net/arphex/entity/TORMENTOREntity
      // 2337: new net/minecraft/world/phys/Vec3
      // 233a: dup
      // 233b: dload 2
      // 233c: dload 4
      // 233e: dload 6
      // 2340: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2343: ldc2_w 600.0
      // 2346: ldc2_w 600.0
      // 2349: ldc2_w 600.0
      // 234c: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 234f: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$55 (Lnet/arphex/entity/TORMENTOREntity;)Z, (Lnet/arphex/entity/TORMENTOREntity;)Z ]
      // 2354: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 2359: invokeinterface java/util/List.isEmpty ()Z 1
      // 235e: ifne 236f
      // 2361: aload 8
      // 2363: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2366: ldc_w "abflytime"
      // 2369: ldc2_w 52000.0
      // 236c: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 236f: aload 8
      // 2371: instanceof net/minecraft/world/entity/LivingEntity
      // 2374: ifeq 239e
      // 2377: aload 8
      // 2379: checkcast net/minecraft/world/entity/LivingEntity
      // 237c: astore 136
      // 237e: aload 136
      // 2380: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2383: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2386: ifne 239e
      // 2389: aload 136
      // 238b: new net/minecraft/world/effect/MobEffectInstance
      // 238e: dup
      // 238f: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 2392: bipush 20
      // 2394: bipush 0
      // 2395: bipush 0
      // 2396: bipush 0
      // 2397: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 239a: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 239d: pop
      // 239e: aload 8
      // 23a0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 23a3: ldc_w "abflytime"
      // 23a6: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 23a9: ldc2_w 10.0
      // 23ac: dcmpl
      // 23ad: ifle 23e2
      // 23b0: aload 8
      // 23b2: instanceof net/minecraft/world/entity/LivingEntity
      // 23b5: ifeq 23df
      // 23b8: aload 8
      // 23ba: checkcast net/minecraft/world/entity/LivingEntity
      // 23bd: astore 136
      // 23bf: aload 136
      // 23c1: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 23c4: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 23c7: ifne 23df
      // 23ca: aload 136
      // 23cc: new net/minecraft/world/effect/MobEffectInstance
      // 23cf: dup
      // 23d0: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_BOOST Lnet/minecraft/world/effect/MobEffect;
      // 23d3: bipush 20
      // 23d5: bipush 1
      // 23d6: bipush 0
      // 23d7: bipush 0
      // 23d8: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 23db: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 23de: pop
      // 23df: goto 2411
      // 23e2: aload 8
      // 23e4: instanceof net/minecraft/world/entity/LivingEntity
      // 23e7: ifeq 2411
      // 23ea: aload 8
      // 23ec: checkcast net/minecraft/world/entity/LivingEntity
      // 23ef: astore 136
      // 23f1: aload 136
      // 23f3: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 23f6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 23f9: ifne 2411
      // 23fc: aload 136
      // 23fe: new net/minecraft/world/effect/MobEffectInstance
      // 2401: dup
      // 2402: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_BOOST Lnet/minecraft/world/effect/MobEffect;
      // 2405: bipush 20
      // 2407: bipush 0
      // 2408: bipush 0
      // 2409: bipush 0
      // 240a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 240d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2410: pop
      // 2411: aload 8
      // 2413: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2416: ldc_w "openhit"
      // 2419: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 241c: dconst_0
      // 241d: dcmpl
      // 241e: ifle 2439
      // 2421: aload 8
      // 2423: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2426: ldc_w "openhit"
      // 2429: aload 8
      // 242b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 242e: ldc_w "openhit"
      // 2431: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2434: dconst_1
      // 2435: dsub
      // 2436: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 2439: aload 8
      // 243b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 243e: ldc_w "abflytime"
      // 2441: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2444: dconst_0
      // 2445: dcmpl
      // 2446: ifle 2469
      // 2449: aload 8
      // 244b: invokevirtual net/minecraft/world/entity/Entity.onGround ()Z
      // 244e: ifne 2469
      // 2451: aload 8
      // 2453: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2456: ldc_w "abflytime"
      // 2459: aload 8
      // 245b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 245e: ldc_w "abflytime"
      // 2461: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2464: dconst_1
      // 2465: dsub
      // 2466: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 2469: aload 8
      // 246b: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 246e: aconst_null
      // 246f: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 2472: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 2475: dup
      // 2476: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 2479: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 247c: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 247f: getfield net/arphex/network/ArphexModVariables$PlayerVariables.ShowOverlay Ljava/lang/String;
      // 2482: ldc_w "true"
      // 2485: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2488: ifeq 24ed
      // 248b: aload 1
      // 248c: ldc_w net/arphex/entity/SpiderMothEntity
      // 248f: new net/minecraft/world/phys/Vec3
      // 2492: dup
      // 2493: dload 2
      // 2494: dload 4
      // 2496: dload 6
      // 2498: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 249b: ldc2_w 80.0
      // 249e: ldc2_w 80.0
      // 24a1: ldc2_w 80.0
      // 24a4: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 24a7: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$56 (Lnet/arphex/entity/SpiderMothEntity;)Z, (Lnet/arphex/entity/SpiderMothEntity;)Z ]
      // 24ac: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 24b1: invokeinterface java/util/List.isEmpty ()Z 1
      // 24b6: ifeq 24ed
      // 24b9: aload 8
      // 24bb: instanceof net/minecraft/world/entity/LivingEntity
      // 24be: ifeq 24ed
      // 24c1: aload 8
      // 24c3: checkcast net/minecraft/world/entity/LivingEntity
      // 24c6: astore 134
      // 24c8: aload 134
      // 24ca: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 24cd: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 24d0: ifne 24ed
      // 24d3: aload 134
      // 24d5: new net/minecraft/world/effect/MobEffectInstance
      // 24d8: dup
      // 24d9: getstatic net/arphex/init/ArphexModMobEffects.MOTH_CURSE Lnet/minecraftforge/registries/RegistryObject;
      // 24dc: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 24df: checkcast net/minecraft/world/effect/MobEffect
      // 24e2: sipush 600
      // 24e5: bipush 1
      // 24e6: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 24e9: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 24ec: pop
      // 24ed: aload 8
      // 24ef: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 24f2: aconst_null
      // 24f3: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 24f6: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 24f9: dup
      // 24fa: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 24fd: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 2500: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 2503: getfield net/arphex/network/ArphexModVariables$PlayerVariables.ShowOverlay2 Ljava/lang/String;
      // 2506: ldc_w "true"
      // 2509: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 250c: ifeq 2534
      // 250f: aload 8
      // 2511: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2514: ldc_w "creativespectator"
      // 2517: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 251a: bipush 1
      // 251b: if_icmpne 2529
      // 251e: bipush 1
      // 251f: aload 8
      // 2521: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$58 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 2526: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2529: bipush 3
      // 252a: aload 8
      // 252c: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$60 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 2531: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2534: aload 8
      // 2536: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2539: ldc_w "creativespectator"
      // 253c: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 253f: ifne 25ac
      // 2542: aload 1
      // 2543: ldc_w net/arphex/entity/ScorpioidBloodlusterEntity
      // 2546: new net/minecraft/world/phys/Vec3
      // 2549: dup
      // 254a: dload 2
      // 254b: dload 4
      // 254d: dload 6
      // 254f: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2552: ldc2_w 30.0
      // 2555: ldc2_w 30.0
      // 2558: ldc2_w 30.0
      // 255b: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 255e: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$61 (Lnet/arphex/entity/ScorpioidBloodlusterEntity;)Z, (Lnet/arphex/entity/ScorpioidBloodlusterEntity;)Z ]
      // 2563: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 2568: invokeinterface java/util/List.isEmpty ()Z 1
      // 256d: ifne 25ac
      // 2570: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 2573: bipush 1
      // 2574: bipush 100
      // 2576: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 2579: bipush 5
      // 257a: if_icmpne 25ac
      // 257d: aload 8
      // 257f: instanceof net/minecraft/world/entity/LivingEntity
      // 2582: ifeq 25ac
      // 2585: aload 8
      // 2587: checkcast net/minecraft/world/entity/LivingEntity
      // 258a: astore 134
      // 258c: aload 134
      // 258e: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2591: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2594: ifne 25ac
      // 2597: aload 134
      // 2599: new net/minecraft/world/effect/MobEffectInstance
      // 259c: dup
      // 259d: getstatic net/minecraft/world/effect/MobEffects.DARKNESS Lnet/minecraft/world/effect/MobEffect;
      // 25a0: bipush 40
      // 25a2: bipush 1
      // 25a3: bipush 0
      // 25a4: bipush 0
      // 25a5: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 25a8: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 25ab: pop
      // 25ac: aload 8
      // 25ae: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 25b1: ldc_w "scorpnear"
      // 25b4: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 25b7: ifeq 28a2
      // 25ba: aload 1
      // 25bb: ldc_w net/arphex/entity/ScorpioidInitialEntity
      // 25be: new net/minecraft/world/phys/Vec3
      // 25c1: dup
      // 25c2: dload 2
      // 25c3: dload 4
      // 25c5: dload 6
      // 25c7: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 25ca: ldc2_w 250.0
      // 25cd: ldc2_w 250.0
      // 25d0: ldc2_w 250.0
      // 25d3: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 25d6: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$62 (Lnet/arphex/entity/ScorpioidInitialEntity;)Z, (Lnet/arphex/entity/ScorpioidInitialEntity;)Z ]
      // 25db: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 25e0: invokeinterface java/util/List.isEmpty ()Z 1
      // 25e5: ifne 2896
      // 25e8: new net/minecraft/world/phys/Vec3
      // 25eb: dup
      // 25ec: aload 8
      // 25ee: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 25f1: new net/minecraft/world/level/ClipContext
      // 25f4: dup
      // 25f5: aload 8
      // 25f7: fconst_1
      // 25f8: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 25fb: aload 8
      // 25fd: fconst_1
      // 25fe: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 2601: aload 8
      // 2603: fconst_1
      // 2604: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 2607: aload 8
      // 2609: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 260c: ldc_w "scorpioid"
      // 260f: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2612: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 2615: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 2618: getstatic net/minecraft/world/level/ClipContext$Block.VISUAL Lnet/minecraft/world/level/ClipContext$Block;
      // 261b: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 261e: aload 8
      // 2620: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 2623: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 2626: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 2629: invokevirtual net/minecraft/core/BlockPos.getX ()I
      // 262c: i2d
      // 262d: aload 8
      // 262f: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 2632: new net/minecraft/world/level/ClipContext
      // 2635: dup
      // 2636: aload 8
      // 2638: fconst_1
      // 2639: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 263c: aload 8
      // 263e: fconst_1
      // 263f: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 2642: aload 8
      // 2644: fconst_1
      // 2645: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 2648: aload 8
      // 264a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 264d: ldc_w "scorpioid"
      // 2650: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2653: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 2656: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 2659: getstatic net/minecraft/world/level/ClipContext$Block.OUTLINE Lnet/minecraft/world/level/ClipContext$Block;
      // 265c: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 265f: aload 8
      // 2661: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 2664: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 2667: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 266a: invokevirtual net/minecraft/core/BlockPos.getY ()I
      // 266d: i2d
      // 266e: aload 8
      // 2670: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 2673: new net/minecraft/world/level/ClipContext
      // 2676: dup
      // 2677: aload 8
      // 2679: fconst_1
      // 267a: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 267d: aload 8
      // 267f: fconst_1
      // 2680: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 2683: aload 8
      // 2685: fconst_1
      // 2686: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 2689: aload 8
      // 268b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 268e: ldc_w "scorpioid"
      // 2691: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2694: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 2697: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 269a: getstatic net/minecraft/world/level/ClipContext$Block.OUTLINE Lnet/minecraft/world/level/ClipContext$Block;
      // 269d: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 26a0: aload 8
      // 26a2: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 26a5: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 26a8: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 26ab: invokevirtual net/minecraft/core/BlockPos.getZ ()I
      // 26ae: i2d
      // 26af: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 26b2: astore 134
      // 26b4: aload 1
      // 26b5: ldc net/minecraft/world/entity/Entity
      // 26b7: new net/minecraft/world/phys/AABB
      // 26ba: dup
      // 26bb: aload 134
      // 26bd: aload 134
      // 26bf: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 26c2: ldc2_w 5.0
      // 26c5: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 26c8: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$63 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 26cd: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 26d2: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 26d7: aload 134
      // 26d9: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$64 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 26de: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 26e1: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 26e6: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 26eb: astore 135
      // 26ed: aload 135
      // 26ef: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 26f4: astore 136
      // 26f6: aload 136
      // 26f8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 26fd: ifeq 278c
      // 2700: aload 136
      // 2702: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2707: checkcast net/minecraft/world/entity/Entity
      // 270a: astore 137
      // 270c: aload 137
      // 270e: instanceof net/arphex/entity/ScorpioidInitialEntity
      // 2711: ifeq 2789
      // 2714: aload 137
      // 2716: instanceof net/minecraft/world/entity/LivingEntity
      // 2719: ifeq 2749
      // 271c: aload 137
      // 271e: checkcast net/minecraft/world/entity/LivingEntity
      // 2721: astore 138
      // 2723: aload 138
      // 2725: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2728: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 272b: ifne 2749
      // 272e: aload 138
      // 2730: new net/minecraft/world/effect/MobEffectInstance
      // 2733: dup
      // 2734: getstatic net/arphex/init/ArphexModMobEffects.NECROSIS Lnet/minecraftforge/registries/RegistryObject;
      // 2737: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 273a: checkcast net/minecraft/world/effect/MobEffect
      // 273d: bipush 60
      // 273f: bipush 0
      // 2740: bipush 0
      // 2741: bipush 0
      // 2742: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2745: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2748: pop
      // 2749: aload 8
      // 274b: instanceof net/minecraft/world/entity/LivingEntity
      // 274e: ifeq 277e
      // 2751: aload 8
      // 2753: checkcast net/minecraft/world/entity/LivingEntity
      // 2756: astore 138
      // 2758: aload 138
      // 275a: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 275d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2760: ifne 277e
      // 2763: aload 138
      // 2765: new net/minecraft/world/effect/MobEffectInstance
      // 2768: dup
      // 2769: getstatic net/arphex/init/ArphexModMobEffects.MOTH_CURSE Lnet/minecraftforge/registries/RegistryObject;
      // 276c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 276f: checkcast net/minecraft/world/effect/MobEffect
      // 2772: bipush 40
      // 2774: bipush 1
      // 2775: bipush 0
      // 2776: bipush 0
      // 2777: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 277a: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 277d: pop
      // 277e: bipush 1
      // 277f: aload 8
      // 2781: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$65 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 2786: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2789: goto 26f6
      // 278c: aload 8
      // 278e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2791: ldc_w "scorpioid"
      // 2794: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2797: dconst_0
      // 2798: dcmpl
      // 2799: ifle 27b7
      // 279c: aload 8
      // 279e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 27a1: ldc_w "scorpioid"
      // 27a4: aload 8
      // 27a6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 27a9: ldc_w "scorpioid"
      // 27ac: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 27af: dconst_1
      // 27b0: dsub
      // 27b1: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 27b4: goto 27c5
      // 27b7: aload 8
      // 27b9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 27bc: ldc_w "scorpioid"
      // 27bf: ldc2_w 120.0
      // 27c2: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 27c5: aload 1
      // 27c6: ldc_w net/arphex/entity/ScorpioidBloodlusterEntity
      // 27c9: new net/minecraft/world/phys/Vec3
      // 27cc: dup
      // 27cd: dload 2
      // 27ce: dload 4
      // 27d0: dload 6
      // 27d2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 27d5: ldc2_w 15.0
      // 27d8: ldc2_w 15.0
      // 27db: ldc2_w 15.0
      // 27de: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 27e1: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$66 (Lnet/arphex/entity/ScorpioidBloodlusterEntity;)Z, (Lnet/arphex/entity/ScorpioidBloodlusterEntity;)Z ]
      // 27e6: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 27eb: invokeinterface java/util/List.isEmpty ()Z 1
      // 27f0: ifne 28a2
      // 27f3: aload 1
      // 27f4: ldc_w net/arphex/entity/ScorpioidBloodlusterEntity
      // 27f7: new net/minecraft/world/phys/Vec3
      // 27fa: dup
      // 27fb: dload 2
      // 27fc: dload 4
      // 27fe: dload 6
      // 2800: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2803: ldc2_w 15.0
      // 2806: ldc2_w 15.0
      // 2809: ldc2_w 15.0
      // 280c: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 280f: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$67 (Lnet/arphex/entity/ScorpioidBloodlusterEntity;)Z, (Lnet/arphex/entity/ScorpioidBloodlusterEntity;)Z ]
      // 2814: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 2819: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 281e: new net/arphex/procedures/GameModeDetectorProcedure$10
      // 2821: dup
      // 2822: invokespecial net/arphex/procedures/GameModeDetectorProcedure$10.<init> ()V
      // 2825: dload 2
      // 2826: dload 4
      // 2828: dload 6
      // 282a: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$10.compareDistOf (DDD)Ljava/util/Comparator;
      // 282d: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 2832: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 2837: aconst_null
      // 2838: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 283b: checkcast net/minecraft/world/entity/Entity
      // 283e: astore 135
      // 2840: aload 135
      // 2842: instanceof net/minecraft/world/entity/LivingEntity
      // 2845: ifeq 2893
      // 2848: aload 135
      // 284a: checkcast net/minecraft/world/entity/LivingEntity
      // 284d: astore 134
      // 284f: aload 134
      // 2851: getstatic net/arphex/init/ArphexModMobEffects.THUNDER_SENSE Lnet/minecraftforge/registries/RegistryObject;
      // 2854: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2857: checkcast net/minecraft/world/effect/MobEffect
      // 285a: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 285d: ifeq 2893
      // 2860: aload 8
      // 2862: instanceof net/minecraft/world/entity/LivingEntity
      // 2865: ifeq 2893
      // 2868: aload 8
      // 286a: checkcast net/minecraft/world/entity/LivingEntity
      // 286d: astore 135
      // 286f: aload 135
      // 2871: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2874: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2877: ifne 2893
      // 287a: aload 135
      // 287c: new net/minecraft/world/effect/MobEffectInstance
      // 287f: dup
      // 2880: getstatic net/arphex/init/ArphexModMobEffects.REPULSION Lnet/minecraftforge/registries/RegistryObject;
      // 2883: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2886: checkcast net/minecraft/world/effect/MobEffect
      // 2889: bipush 60
      // 288b: bipush 1
      // 288c: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;II)V
      // 288f: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2892: pop
      // 2893: goto 28a2
      // 2896: aload 8
      // 2898: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 289b: ldc_w "scorpnear"
      // 289e: bipush 0
      // 289f: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 28a2: aload 8
      // 28a4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 28a7: ldc_w "voidnear"
      // 28aa: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 28ad: ifeq 2bab
      // 28b0: aload 1
      // 28b1: ldc_w net/arphex/entity/SpiderMothDwellerEntity
      // 28b4: new net/minecraft/world/phys/Vec3
      // 28b7: dup
      // 28b8: dload 2
      // 28b9: dload 4
      // 28bb: dload 6
      // 28bd: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 28c0: ldc2_w 250.0
      // 28c3: ldc2_w 250.0
      // 28c6: ldc2_w 250.0
      // 28c9: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 28cc: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$68 (Lnet/arphex/entity/SpiderMothDwellerEntity;)Z, (Lnet/arphex/entity/SpiderMothDwellerEntity;)Z ]
      // 28d1: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 28d6: invokeinterface java/util/List.isEmpty ()Z 1
      // 28db: ifne 2b9f
      // 28de: aload 8
      // 28e0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 28e3: ldc_w "creativespectator"
      // 28e6: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 28e9: ifne 2b9f
      // 28ec: new net/minecraft/world/phys/Vec3
      // 28ef: dup
      // 28f0: aload 8
      // 28f2: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 28f5: new net/minecraft/world/level/ClipContext
      // 28f8: dup
      // 28f9: aload 8
      // 28fb: fconst_1
      // 28fc: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 28ff: aload 8
      // 2901: fconst_1
      // 2902: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 2905: aload 8
      // 2907: fconst_1
      // 2908: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 290b: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 290e: bipush 1
      // 290f: bipush 120
      // 2911: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 2914: i2d
      // 2915: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 2918: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 291b: getstatic net/minecraft/world/level/ClipContext$Block.VISUAL Lnet/minecraft/world/level/ClipContext$Block;
      // 291e: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 2921: aload 8
      // 2923: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 2926: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 2929: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 292c: invokevirtual net/minecraft/core/BlockPos.getX ()I
      // 292f: i2d
      // 2930: aload 8
      // 2932: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 2935: new net/minecraft/world/level/ClipContext
      // 2938: dup
      // 2939: aload 8
      // 293b: fconst_1
      // 293c: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 293f: aload 8
      // 2941: fconst_1
      // 2942: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 2945: aload 8
      // 2947: fconst_1
      // 2948: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 294b: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 294e: bipush 1
      // 294f: bipush 120
      // 2951: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 2954: i2d
      // 2955: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 2958: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 295b: getstatic net/minecraft/world/level/ClipContext$Block.OUTLINE Lnet/minecraft/world/level/ClipContext$Block;
      // 295e: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 2961: aload 8
      // 2963: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 2966: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 2969: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 296c: invokevirtual net/minecraft/core/BlockPos.getY ()I
      // 296f: i2d
      // 2970: aload 8
      // 2972: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 2975: new net/minecraft/world/level/ClipContext
      // 2978: dup
      // 2979: aload 8
      // 297b: fconst_1
      // 297c: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 297f: aload 8
      // 2981: fconst_1
      // 2982: invokevirtual net/minecraft/world/entity/Entity.getEyePosition (F)Lnet/minecraft/world/phys/Vec3;
      // 2985: aload 8
      // 2987: fconst_1
      // 2988: invokevirtual net/minecraft/world/entity/Entity.getViewVector (F)Lnet/minecraft/world/phys/Vec3;
      // 298b: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 298e: bipush 1
      // 298f: bipush 120
      // 2991: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 2994: i2d
      // 2995: invokevirtual net/minecraft/world/phys/Vec3.scale (D)Lnet/minecraft/world/phys/Vec3;
      // 2998: invokevirtual net/minecraft/world/phys/Vec3.add (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
      // 299b: getstatic net/minecraft/world/level/ClipContext$Block.OUTLINE Lnet/minecraft/world/level/ClipContext$Block;
      // 299e: getstatic net/minecraft/world/level/ClipContext$Fluid.NONE Lnet/minecraft/world/level/ClipContext$Fluid;
      // 29a1: aload 8
      // 29a3: invokespecial net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V
      // 29a6: invokevirtual net/minecraft/world/level/Level.clip (Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;
      // 29a9: invokevirtual net/minecraft/world/phys/BlockHitResult.getBlockPos ()Lnet/minecraft/core/BlockPos;
      // 29ac: invokevirtual net/minecraft/core/BlockPos.getZ ()I
      // 29af: i2d
      // 29b0: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 29b3: astore 134
      // 29b5: aload 1
      // 29b6: ldc net/minecraft/world/entity/Entity
      // 29b8: new net/minecraft/world/phys/AABB
      // 29bb: dup
      // 29bc: aload 134
      // 29be: aload 134
      // 29c0: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 29c3: ldc2_w 7.5
      // 29c6: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 29c9: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$69 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 29ce: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 29d3: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 29d8: aload 134
      // 29da: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$70 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 29df: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 29e2: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 29e7: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 29ec: astore 135
      // 29ee: aload 135
      // 29f0: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 29f5: astore 136
      // 29f7: aload 136
      // 29f9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 29fe: ifeq 2b9c
      // 2a01: aload 136
      // 2a03: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2a08: checkcast net/minecraft/world/entity/Entity
      // 2a0b: astore 137
      // 2a0d: aload 137
      // 2a0f: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 2a12: ifeq 2a30
      // 2a15: aload 137
      // 2a17: checkcast net/arphex/entity/SpiderMothDwellerEntity
      // 2a1a: astore 138
      // 2a1c: aload 138
      // 2a1e: invokevirtual net/arphex/entity/SpiderMothDwellerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 2a21: getstatic net/arphex/entity/SpiderMothDwellerEntity.DATA_primed Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 2a24: invokevirtual net/minecraft/network/syncher/SynchedEntityData.get (Lnet/minecraft/network/syncher/EntityDataAccessor;)Ljava/lang/Object;
      // 2a27: checkcast java/lang/Boolean
      // 2a2a: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 2a2d: ifne 2b99
      // 2a30: aload 137
      // 2a32: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 2a35: ifeq 2b99
      // 2a38: aload 8
      // 2a3a: instanceof net/minecraft/world/entity/LivingEntity
      // 2a3d: ifeq 2a6d
      // 2a40: aload 8
      // 2a42: checkcast net/minecraft/world/entity/LivingEntity
      // 2a45: astore 139
      // 2a47: aload 139
      // 2a49: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2a4c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2a4f: ifne 2a6d
      // 2a52: aload 139
      // 2a54: new net/minecraft/world/effect/MobEffectInstance
      // 2a57: dup
      // 2a58: getstatic net/arphex/init/ArphexModMobEffects.MOTH_CURSE Lnet/minecraftforge/registries/RegistryObject;
      // 2a5b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2a5e: checkcast net/minecraft/world/effect/MobEffect
      // 2a61: bipush 40
      // 2a63: bipush 1
      // 2a64: bipush 0
      // 2a65: bipush 0
      // 2a66: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2a69: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2a6c: pop
      // 2a6d: bipush 1
      // 2a6e: aload 8
      // 2a70: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$71 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 2a75: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2a78: aload 137
      // 2a7a: instanceof net/arphex/entity/SpiderMothDwellerEntity
      // 2a7d: ifeq 2a96
      // 2a80: aload 137
      // 2a82: checkcast net/arphex/entity/SpiderMothDwellerEntity
      // 2a85: astore 139
      // 2a87: aload 139
      // 2a89: invokevirtual net/arphex/entity/SpiderMothDwellerEntity.getEntityData ()Lnet/minecraft/network/syncher/SynchedEntityData;
      // 2a8c: getstatic net/arphex/entity/SpiderMothDwellerEntity.DATA_primed Lnet/minecraft/network/syncher/EntityDataAccessor;
      // 2a8f: bipush 1
      // 2a90: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 2a93: invokevirtual net/minecraft/network/syncher/SynchedEntityData.set (Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;)V
      // 2a96: aload 1
      // 2a97: instanceof net/minecraft/server/level/ServerLevel
      // 2a9a: ifeq 2ad8
      // 2a9d: aload 1
      // 2a9e: checkcast net/minecraft/server/level/ServerLevel
      // 2aa1: astore 139
      // 2aa3: getstatic net/minecraft/world/entity/EntityType.LIGHTNING_BOLT Lnet/minecraft/world/entity/EntityType;
      // 2aa6: aload 139
      // 2aa8: invokevirtual net/minecraft/world/entity/EntityType.create (Lnet/minecraft/world/level/Level;)Lnet/minecraft/world/entity/Entity;
      // 2aab: checkcast net/minecraft/world/entity/LightningBolt
      // 2aae: astore 140
      // 2ab0: aload 140
      // 2ab2: aload 137
      // 2ab4: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 2ab7: aload 137
      // 2ab9: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 2abc: aload 137
      // 2abe: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 2ac1: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 2ac4: invokestatic net/minecraft/world/phys/Vec3.atBottomCenterOf (Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;
      // 2ac7: invokevirtual net/minecraft/world/entity/LightningBolt.moveTo (Lnet/minecraft/world/phys/Vec3;)V
      // 2aca: aload 140
      // 2acc: bipush 1
      // 2acd: invokevirtual net/minecraft/world/entity/LightningBolt.setVisualOnly (Z)V
      // 2ad0: aload 139
      // 2ad2: aload 140
      // 2ad4: invokevirtual net/minecraft/server/level/ServerLevel.addFreshEntity (Lnet/minecraft/world/entity/Entity;)Z
      // 2ad7: pop
      // 2ad8: aload 1
      // 2ad9: instanceof net/minecraft/world/level/Level
      // 2adc: ifeq 2b45
      // 2adf: aload 1
      // 2ae0: checkcast net/minecraft/world/level/Level
      // 2ae3: astore 139
      // 2ae5: aload 139
      // 2ae7: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2aea: ifne 2b1c
      // 2aed: aload 139
      // 2aef: aconst_null
      // 2af0: dload 2
      // 2af1: dload 4
      // 2af3: dload 6
      // 2af5: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 2af8: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 2afb: new net/minecraft/resources/ResourceLocation
      // 2afe: dup
      // 2aff: ldc_w "arphex:mothscare"
      // 2b02: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 2b05: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 2b0a: checkcast net/minecraft/sounds/SoundEvent
      // 2b0d: getstatic net/minecraft/sounds/SoundSource.HOSTILE Lnet/minecraft/sounds/SoundSource;
      // 2b10: ldc_w 0.3
      // 2b13: ldc_w 0.1
      // 2b16: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 2b19: goto 2b45
      // 2b1c: aload 139
      // 2b1e: dload 2
      // 2b1f: dload 4
      // 2b21: dload 6
      // 2b23: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 2b26: new net/minecraft/resources/ResourceLocation
      // 2b29: dup
      // 2b2a: ldc_w "arphex:mothscare"
      // 2b2d: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 2b30: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 2b35: checkcast net/minecraft/sounds/SoundEvent
      // 2b38: getstatic net/minecraft/sounds/SoundSource.HOSTILE Lnet/minecraft/sounds/SoundSource;
      // 2b3b: ldc_w 0.3
      // 2b3e: ldc_w 0.1
      // 2b41: bipush 0
      // 2b42: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 2b45: aload 8
      // 2b47: instanceof net/minecraft/world/entity/LivingEntity
      // 2b4a: ifeq 2b74
      // 2b4d: aload 8
      // 2b4f: checkcast net/minecraft/world/entity/LivingEntity
      // 2b52: astore 139
      // 2b54: aload 139
      // 2b56: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2b59: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2b5c: ifne 2b74
      // 2b5f: aload 139
      // 2b61: new net/minecraft/world/effect/MobEffectInstance
      // 2b64: dup
      // 2b65: getstatic net/minecraft/world/effect/MobEffects.BLINDNESS Lnet/minecraft/world/effect/MobEffect;
      // 2b68: bipush 60
      // 2b6a: bipush 1
      // 2b6b: bipush 0
      // 2b6c: bipush 0
      // 2b6d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2b70: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2b73: pop
      // 2b74: ldc_w "true"
      // 2b77: astore 139
      // 2b79: aload 8
      // 2b7b: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 2b7e: aconst_null
      // 2b7f: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 2b82: aload 139
      // 2b84: aload 8
      // 2b86: invokedynamic accept (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$72 (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 2b8b: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 2b8e: bipush 5
      // 2b8f: aload 8
      // 2b91: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$74 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 2b96: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 2b99: goto 29f7
      // 2b9c: goto 2bab
      // 2b9f: aload 8
      // 2ba1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2ba4: ldc_w "voidnearvoidnear"
      // 2ba7: bipush 0
      // 2ba8: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 2bab: aload 8
      // 2bad: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2bb0: ldc_w "flamecool"
      // 2bb3: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2bb6: ldc2_w 140.0
      // 2bb9: dcmpg
      // 2bba: ifge 2bd5
      // 2bbd: aload 8
      // 2bbf: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2bc2: ldc_w "flamecool"
      // 2bc5: aload 8
      // 2bc7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2bca: ldc_w "flamecool"
      // 2bcd: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2bd0: dconst_1
      // 2bd1: dadd
      // 2bd2: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 2bd5: aload 8
      // 2bd7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2bda: ldc_w "shootslow"
      // 2bdd: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2be0: dconst_0
      // 2be1: dcmpl
      // 2be2: ifle 2bfd
      // 2be5: aload 8
      // 2be7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2bea: ldc_w "shootslow"
      // 2bed: aload 8
      // 2bef: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2bf2: ldc_w "shootslow"
      // 2bf5: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 2bf8: dconst_1
      // 2bf9: dsub
      // 2bfa: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 2bfd: aload 8
      // 2bff: instanceof net/minecraft/world/entity/LivingEntity
      // 2c02: ifeq 2c17
      // 2c05: aload 8
      // 2c07: checkcast net/minecraft/world/entity/LivingEntity
      // 2c0a: astore 134
      // 2c0c: aload 134
      // 2c0e: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 2c11: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2c14: goto 2c1a
      // 2c17: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2c1a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2c1d: getstatic net/arphex/init/ArphexModItems.ETERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 2c20: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2c23: if_acmpeq 2ca1
      // 2c26: aload 8
      // 2c28: instanceof net/minecraft/world/entity/LivingEntity
      // 2c2b: ifeq 2c40
      // 2c2e: aload 8
      // 2c30: checkcast net/minecraft/world/entity/LivingEntity
      // 2c33: astore 135
      // 2c35: aload 135
      // 2c37: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 2c3a: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2c3d: goto 2c43
      // 2c40: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2c43: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2c46: getstatic net/arphex/init/ArphexModItems.ETERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 2c49: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2c4c: if_acmpeq 2ca1
      // 2c4f: aload 8
      // 2c51: instanceof net/minecraft/world/entity/LivingEntity
      // 2c54: ifeq 2c69
      // 2c57: aload 8
      // 2c59: checkcast net/minecraft/world/entity/LivingEntity
      // 2c5c: astore 136
      // 2c5e: aload 136
      // 2c60: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 2c63: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2c66: goto 2c6c
      // 2c69: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2c6c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2c6f: getstatic net/arphex/init/ArphexModItems.ETERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 2c72: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2c75: if_acmpeq 2ca1
      // 2c78: aload 8
      // 2c7a: instanceof net/minecraft/world/entity/LivingEntity
      // 2c7d: ifeq 2c92
      // 2c80: aload 8
      // 2c82: checkcast net/minecraft/world/entity/LivingEntity
      // 2c85: astore 137
      // 2c87: aload 137
      // 2c89: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 2c8c: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2c8f: goto 2c95
      // 2c92: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2c95: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2c98: getstatic net/arphex/init/ArphexModItems.ETERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 2c9b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2c9e: if_acmpne 2cd0
      // 2ca1: aload 8
      // 2ca3: instanceof net/minecraft/world/entity/LivingEntity
      // 2ca6: ifeq 2cd0
      // 2ca9: aload 8
      // 2cab: checkcast net/minecraft/world/entity/LivingEntity
      // 2cae: astore 138
      // 2cb0: aload 138
      // 2cb2: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2cb5: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2cb8: ifne 2cd0
      // 2cbb: aload 138
      // 2cbd: new net/minecraft/world/effect/MobEffectInstance
      // 2cc0: dup
      // 2cc1: getstatic net/minecraft/world/effect/MobEffects.FIRE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 2cc4: bipush 20
      // 2cc6: bipush 0
      // 2cc7: bipush 0
      // 2cc8: bipush 0
      // 2cc9: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2ccc: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2ccf: pop
      // 2cd0: aload 8
      // 2cd2: instanceof net/minecraft/world/entity/LivingEntity
      // 2cd5: ifeq 2cea
      // 2cd8: aload 8
      // 2cda: checkcast net/minecraft/world/entity/LivingEntity
      // 2cdd: astore 134
      // 2cdf: aload 134
      // 2ce1: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 2ce4: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2ce7: goto 2ced
      // 2cea: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2ced: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2cf0: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 2cf3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2cf6: if_acmpeq 2d74
      // 2cf9: aload 8
      // 2cfb: instanceof net/minecraft/world/entity/LivingEntity
      // 2cfe: ifeq 2d13
      // 2d01: aload 8
      // 2d03: checkcast net/minecraft/world/entity/LivingEntity
      // 2d06: astore 135
      // 2d08: aload 135
      // 2d0a: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 2d0d: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2d10: goto 2d16
      // 2d13: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2d16: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2d19: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 2d1c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2d1f: if_acmpeq 2d74
      // 2d22: aload 8
      // 2d24: instanceof net/minecraft/world/entity/LivingEntity
      // 2d27: ifeq 2d3c
      // 2d2a: aload 8
      // 2d2c: checkcast net/minecraft/world/entity/LivingEntity
      // 2d2f: astore 136
      // 2d31: aload 136
      // 2d33: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 2d36: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2d39: goto 2d3f
      // 2d3c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2d3f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2d42: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 2d45: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2d48: if_acmpeq 2d74
      // 2d4b: aload 8
      // 2d4d: instanceof net/minecraft/world/entity/LivingEntity
      // 2d50: ifeq 2d65
      // 2d53: aload 8
      // 2d55: checkcast net/minecraft/world/entity/LivingEntity
      // 2d58: astore 137
      // 2d5a: aload 137
      // 2d5c: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 2d5f: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2d62: goto 2d68
      // 2d65: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2d68: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2d6b: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 2d6e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2d71: if_acmpne 2ebb
      // 2d74: aload 8
      // 2d76: instanceof net/minecraft/world/entity/LivingEntity
      // 2d79: ifeq 2d8e
      // 2d7c: aload 8
      // 2d7e: checkcast net/minecraft/world/entity/LivingEntity
      // 2d81: astore 138
      // 2d83: aload 138
      // 2d85: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 2d88: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2d8b: goto 2d91
      // 2d8e: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2d91: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2d94: getstatic net/arphex/init/ArphexModItems.INFERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 2d97: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2d9a: if_acmpne 2e4a
      // 2d9d: aload 8
      // 2d9f: instanceof net/minecraft/world/entity/LivingEntity
      // 2da2: ifeq 2db7
      // 2da5: aload 8
      // 2da7: checkcast net/minecraft/world/entity/LivingEntity
      // 2daa: astore 139
      // 2dac: aload 139
      // 2dae: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 2db1: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2db4: goto 2dba
      // 2db7: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2dba: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2dbd: getstatic net/arphex/init/ArphexModItems.INFERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 2dc0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2dc3: if_acmpne 2e4a
      // 2dc6: aload 8
      // 2dc8: instanceof net/minecraft/world/entity/LivingEntity
      // 2dcb: ifeq 2de0
      // 2dce: aload 8
      // 2dd0: checkcast net/minecraft/world/entity/LivingEntity
      // 2dd3: astore 140
      // 2dd5: aload 140
      // 2dd7: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 2dda: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2ddd: goto 2de3
      // 2de0: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2de3: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2de6: getstatic net/arphex/init/ArphexModItems.INFERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 2de9: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2dec: if_acmpne 2e4a
      // 2def: aload 8
      // 2df1: instanceof net/minecraft/world/entity/LivingEntity
      // 2df4: ifeq 2e09
      // 2df7: aload 8
      // 2df9: checkcast net/minecraft/world/entity/LivingEntity
      // 2dfc: astore 141
      // 2dfe: aload 141
      // 2e00: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 2e03: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 2e06: goto 2e0c
      // 2e09: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2e0c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2e0f: getstatic net/arphex/init/ArphexModItems.INFERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 2e12: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2e15: if_acmpne 2e4a
      // 2e18: aload 8
      // 2e1a: instanceof net/minecraft/world/entity/LivingEntity
      // 2e1d: ifeq 2e47
      // 2e20: aload 8
      // 2e22: checkcast net/minecraft/world/entity/LivingEntity
      // 2e25: astore 142
      // 2e27: aload 142
      // 2e29: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2e2c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2e2f: ifne 2e47
      // 2e32: aload 142
      // 2e34: new net/minecraft/world/effect/MobEffectInstance
      // 2e37: dup
      // 2e38: getstatic net/minecraft/world/effect/MobEffects.FIRE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 2e3b: bipush 20
      // 2e3d: bipush 0
      // 2e3e: bipush 0
      // 2e3f: bipush 0
      // 2e40: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2e43: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2e46: pop
      // 2e47: goto 2e81
      // 2e4a: aload 8
      // 2e4c: invokevirtual net/minecraft/world/entity/Entity.isInLava ()Z
      // 2e4f: ifne 2e81
      // 2e52: aload 8
      // 2e54: instanceof net/minecraft/world/entity/LivingEntity
      // 2e57: ifeq 2e81
      // 2e5a: aload 8
      // 2e5c: checkcast net/minecraft/world/entity/LivingEntity
      // 2e5f: astore 142
      // 2e61: aload 142
      // 2e63: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 2e66: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 2e69: ifne 2e81
      // 2e6c: aload 142
      // 2e6e: new net/minecraft/world/effect/MobEffectInstance
      // 2e71: dup
      // 2e72: getstatic net/minecraft/world/effect/MobEffects.FIRE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 2e75: bipush 20
      // 2e77: bipush 0
      // 2e78: bipush 0
      // 2e79: bipush 0
      // 2e7a: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 2e7d: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 2e80: pop
      // 2e81: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 2e84: bipush 1
      // 2e85: bipush 5
      // 2e86: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 2e89: bipush 2
      // 2e8a: if_icmpne 2ebb
      // 2e8d: aload 1
      // 2e8e: instanceof net/minecraft/server/level/ServerLevel
      // 2e91: ifeq 2ebb
      // 2e94: aload 1
      // 2e95: checkcast net/minecraft/server/level/ServerLevel
      // 2e98: astore 138
      // 2e9a: aload 138
      // 2e9c: getstatic net/arphex/init/ArphexModParticleTypes.INFERNAL_SHARD_PARTICLE Lnet/minecraftforge/registries/RegistryObject;
      // 2e9f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 2ea2: checkcast net/minecraft/core/particles/SimpleParticleType
      // 2ea5: dload 2
      // 2ea6: dload 4
      // 2ea8: dload 6
      // 2eaa: bipush 1
      // 2eab: ldc2_w 0.2
      // 2eae: ldc2_w 0.1
      // 2eb1: ldc2_w 0.2
      // 2eb4: ldc2_w 0.1
      // 2eb7: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 2eba: pop
      // 2ebb: aload 1
      // 2ebc: ldc_w net/arphex/entity/MothMoontrackerEntity
      // 2ebf: new net/minecraft/world/phys/Vec3
      // 2ec2: dup
      // 2ec3: dload 2
      // 2ec4: dload 4
      // 2ec6: dload 6
      // 2ec8: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2ecb: ldc2_w 16.0
      // 2ece: ldc2_w 16.0
      // 2ed1: ldc2_w 16.0
      // 2ed4: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 2ed7: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$75 (Lnet/arphex/entity/MothMoontrackerEntity;)Z, (Lnet/arphex/entity/MothMoontrackerEntity;)Z ]
      // 2edc: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 2ee1: invokeinterface java/util/List.isEmpty ()Z 1
      // 2ee6: ifne 309f
      // 2ee9: aload 8
      // 2eeb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 2eee: ldc_w "creativespectator"
      // 2ef1: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 2ef4: ifeq 2f6c
      // 2ef7: aload 1
      // 2ef8: ldc_w net/arphex/entity/MothMoontrackerEntity
      // 2efb: new net/minecraft/world/phys/Vec3
      // 2efe: dup
      // 2eff: dload 2
      // 2f00: dload 4
      // 2f02: dload 6
      // 2f04: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 2f07: ldc2_w 16.0
      // 2f0a: ldc2_w 16.0
      // 2f0d: ldc2_w 16.0
      // 2f10: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 2f13: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$76 (Lnet/arphex/entity/MothMoontrackerEntity;)Z, (Lnet/arphex/entity/MothMoontrackerEntity;)Z ]
      // 2f18: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 2f1d: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 2f22: new net/arphex/procedures/GameModeDetectorProcedure$11
      // 2f25: dup
      // 2f26: invokespecial net/arphex/procedures/GameModeDetectorProcedure$11.<init> ()V
      // 2f29: dload 2
      // 2f2a: dload 4
      // 2f2c: dload 6
      // 2f2e: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$11.compareDistOf (DDD)Ljava/util/Comparator;
      // 2f31: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 2f36: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 2f3b: aconst_null
      // 2f3c: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 2f3f: checkcast net/minecraft/world/entity/Entity
      // 2f42: astore 136
      // 2f44: aload 136
      // 2f46: instanceof net/minecraft/world/entity/TamableAnimal
      // 2f49: ifeq 309f
      // 2f4c: aload 136
      // 2f4e: checkcast net/minecraft/world/entity/TamableAnimal
      // 2f51: astore 134
      // 2f53: aload 8
      // 2f55: instanceof net/minecraft/world/entity/LivingEntity
      // 2f58: ifeq 309f
      // 2f5b: aload 8
      // 2f5d: checkcast net/minecraft/world/entity/LivingEntity
      // 2f60: astore 135
      // 2f62: aload 134
      // 2f64: aload 135
      // 2f66: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 2f69: ifeq 309f
      // 2f6c: aload 8
      // 2f6e: instanceof net/minecraft/world/entity/LivingEntity
      // 2f71: ifeq 2f86
      // 2f74: aload 8
      // 2f76: checkcast net/minecraft/world/entity/LivingEntity
      // 2f79: astore 136
      // 2f7b: aload 136
      // 2f7d: getstatic net/minecraft/world/effect/MobEffects.GLOWING Lnet/minecraft/world/effect/MobEffect;
      // 2f80: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 2f83: ifne 301e
      // 2f86: aload 8
      // 2f88: instanceof net/minecraft/world/entity/LivingEntity
      // 2f8b: ifeq 2f9d
      // 2f8e: aload 8
      // 2f90: checkcast net/minecraft/world/entity/LivingEntity
      // 2f93: astore 137
      // 2f95: aload 137
      // 2f97: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2f9a: goto 2fa0
      // 2f9d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2fa0: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2fa3: getstatic net/minecraft/world/level/block/Blocks.TORCH Lnet/minecraft/world/level/block/Block;
      // 2fa6: invokevirtual net/minecraft/world/level/block/Block.asItem ()Lnet/minecraft/world/item/Item;
      // 2fa9: if_acmpeq 301e
      // 2fac: aload 8
      // 2fae: instanceof net/minecraft/world/entity/LivingEntity
      // 2fb1: ifeq 2fc3
      // 2fb4: aload 8
      // 2fb6: checkcast net/minecraft/world/entity/LivingEntity
      // 2fb9: astore 138
      // 2fbb: aload 138
      // 2fbd: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2fc0: goto 2fc6
      // 2fc3: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2fc6: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2fc9: getstatic net/minecraft/world/level/block/Blocks.SOUL_TORCH Lnet/minecraft/world/level/block/Block;
      // 2fcc: invokevirtual net/minecraft/world/level/block/Block.asItem ()Lnet/minecraft/world/item/Item;
      // 2fcf: if_acmpeq 301e
      // 2fd2: aload 8
      // 2fd4: instanceof net/minecraft/world/entity/LivingEntity
      // 2fd7: ifeq 2fe9
      // 2fda: aload 8
      // 2fdc: checkcast net/minecraft/world/entity/LivingEntity
      // 2fdf: astore 139
      // 2fe1: aload 139
      // 2fe3: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 2fe6: goto 2fec
      // 2fe9: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 2fec: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 2fef: getstatic net/minecraft/world/level/block/Blocks.LANTERN Lnet/minecraft/world/level/block/Block;
      // 2ff2: invokevirtual net/minecraft/world/level/block/Block.asItem ()Lnet/minecraft/world/item/Item;
      // 2ff5: if_acmpeq 301e
      // 2ff8: aload 8
      // 2ffa: instanceof net/minecraft/world/entity/LivingEntity
      // 2ffd: ifeq 300f
      // 3000: aload 8
      // 3002: checkcast net/minecraft/world/entity/LivingEntity
      // 3005: astore 140
      // 3007: aload 140
      // 3009: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 300c: goto 3012
      // 300f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3012: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3015: getstatic net/minecraft/world/level/block/Blocks.SOUL_LANTERN Lnet/minecraft/world/level/block/Block;
      // 3018: invokevirtual net/minecraft/world/level/block/Block.asItem ()Lnet/minecraft/world/item/Item;
      // 301b: if_acmpne 309f
      // 301e: aload 1
      // 301f: ldc_w net/arphex/entity/MothMoontrackerEntity
      // 3022: new net/minecraft/world/phys/Vec3
      // 3025: dup
      // 3026: dload 2
      // 3027: dload 4
      // 3029: dload 6
      // 302b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 302e: ldc2_w 16.0
      // 3031: ldc2_w 16.0
      // 3034: ldc2_w 16.0
      // 3037: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 303a: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$77 (Lnet/arphex/entity/MothMoontrackerEntity;)Z, (Lnet/arphex/entity/MothMoontrackerEntity;)Z ]
      // 303f: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3044: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3049: new net/arphex/procedures/GameModeDetectorProcedure$12
      // 304c: dup
      // 304d: invokespecial net/arphex/procedures/GameModeDetectorProcedure$12.<init> ()V
      // 3050: dload 2
      // 3051: dload 4
      // 3053: dload 6
      // 3055: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$12.compareDistOf (DDD)Ljava/util/Comparator;
      // 3058: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 305d: invokeinterface java/util/stream/Stream.findFirst ()Ljava/util/Optional; 1
      // 3062: aconst_null
      // 3063: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 3066: checkcast net/minecraft/world/entity/Entity
      // 3069: astore 142
      // 306b: aload 142
      // 306d: instanceof net/minecraft/world/entity/LivingEntity
      // 3070: ifeq 309f
      // 3073: aload 142
      // 3075: checkcast net/minecraft/world/entity/LivingEntity
      // 3078: astore 141
      // 307a: aload 141
      // 307c: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 307f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3082: ifne 309f
      // 3085: aload 141
      // 3087: new net/minecraft/world/effect/MobEffectInstance
      // 308a: dup
      // 308b: getstatic net/arphex/init/ArphexModMobEffects.SPIDER_SILK_TOUCH Lnet/minecraftforge/registries/RegistryObject;
      // 308e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3091: checkcast net/minecraft/world/effect/MobEffect
      // 3094: bipush 5
      // 3095: bipush 0
      // 3096: bipush 0
      // 3097: bipush 0
      // 3098: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 309b: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 309e: pop
      // 309f: aload 8
      // 30a1: instanceof net/minecraft/world/entity/LivingEntity
      // 30a4: ifeq 30b9
      // 30a7: aload 8
      // 30a9: checkcast net/minecraft/world/entity/LivingEntity
      // 30ac: astore 134
      // 30ae: aload 134
      // 30b0: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 30b3: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 30b6: goto 30bc
      // 30b9: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 30bc: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 30bf: getstatic net/arphex/init/ArphexModItems.ETERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 30c2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 30c5: if_acmpne 3143
      // 30c8: aload 8
      // 30ca: instanceof net/minecraft/world/entity/LivingEntity
      // 30cd: ifeq 30e2
      // 30d0: aload 8
      // 30d2: checkcast net/minecraft/world/entity/LivingEntity
      // 30d5: astore 135
      // 30d7: aload 135
      // 30d9: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 30dc: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 30df: goto 30e5
      // 30e2: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 30e5: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 30e8: getstatic net/arphex/init/ArphexModItems.ETERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 30eb: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 30ee: if_acmpne 3143
      // 30f1: aload 8
      // 30f3: instanceof net/minecraft/world/entity/LivingEntity
      // 30f6: ifeq 310b
      // 30f9: aload 8
      // 30fb: checkcast net/minecraft/world/entity/LivingEntity
      // 30fe: astore 136
      // 3100: aload 136
      // 3102: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 3105: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 3108: goto 310e
      // 310b: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 310e: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3111: getstatic net/arphex/init/ArphexModItems.ETERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 3114: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3117: if_acmpne 3143
      // 311a: aload 8
      // 311c: instanceof net/minecraft/world/entity/LivingEntity
      // 311f: ifeq 3134
      // 3122: aload 8
      // 3124: checkcast net/minecraft/world/entity/LivingEntity
      // 3127: astore 137
      // 3129: aload 137
      // 312b: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 312e: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 3131: goto 3137
      // 3134: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3137: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 313a: getstatic net/arphex/init/ArphexModItems.ETERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 313d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3140: if_acmpeq 31e7
      // 3143: aload 8
      // 3145: instanceof net/minecraft/world/entity/LivingEntity
      // 3148: ifeq 315d
      // 314b: aload 8
      // 314d: checkcast net/minecraft/world/entity/LivingEntity
      // 3150: astore 138
      // 3152: aload 138
      // 3154: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 3157: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 315a: goto 3160
      // 315d: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3160: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3163: getstatic net/arphex/init/ArphexModItems.IMMORTAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 3166: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3169: if_acmpne 333f
      // 316c: aload 8
      // 316e: instanceof net/minecraft/world/entity/LivingEntity
      // 3171: ifeq 3186
      // 3174: aload 8
      // 3176: checkcast net/minecraft/world/entity/LivingEntity
      // 3179: astore 139
      // 317b: aload 139
      // 317d: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 3180: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 3183: goto 3189
      // 3186: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3189: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 318c: getstatic net/arphex/init/ArphexModItems.IMMORTAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 318f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3192: if_acmpne 333f
      // 3195: aload 8
      // 3197: instanceof net/minecraft/world/entity/LivingEntity
      // 319a: ifeq 31af
      // 319d: aload 8
      // 319f: checkcast net/minecraft/world/entity/LivingEntity
      // 31a2: astore 140
      // 31a4: aload 140
      // 31a6: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 31a9: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 31ac: goto 31b2
      // 31af: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 31b2: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 31b5: getstatic net/arphex/init/ArphexModItems.IMMORTAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 31b8: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 31bb: if_acmpne 333f
      // 31be: aload 8
      // 31c0: instanceof net/minecraft/world/entity/LivingEntity
      // 31c3: ifeq 31d8
      // 31c6: aload 8
      // 31c8: checkcast net/minecraft/world/entity/LivingEntity
      // 31cb: astore 141
      // 31cd: aload 141
      // 31cf: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 31d2: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 31d5: goto 31db
      // 31d8: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 31db: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 31de: getstatic net/arphex/init/ArphexModItems.IMMORTAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 31e1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 31e4: if_acmpne 333f
      // 31e7: aload 8
      // 31e9: instanceof net/minecraft/world/entity/LivingEntity
      // 31ec: ifeq 3215
      // 31ef: aload 8
      // 31f1: checkcast net/minecraft/world/entity/LivingEntity
      // 31f4: astore 142
      // 31f6: aload 142
      // 31f8: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 31fb: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 31fe: ifne 3215
      // 3201: aload 142
      // 3203: new net/minecraft/world/effect/MobEffectInstance
      // 3206: dup
      // 3207: getstatic net/minecraft/world/effect/MobEffects.DAMAGE_RESISTANCE Lnet/minecraft/world/effect/MobEffect;
      // 320a: bipush 5
      // 320b: bipush 0
      // 320c: bipush 0
      // 320d: bipush 0
      // 320e: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3211: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3214: pop
      // 3215: aload 8
      // 3217: instanceof net/minecraft/world/entity/LivingEntity
      // 321a: ifeq 3235
      // 321d: aload 8
      // 321f: checkcast net/minecraft/world/entity/LivingEntity
      // 3222: astore 142
      // 3224: aload 142
      // 3226: getstatic net/arphex/init/ArphexModMobEffects.AB_FLIGHT Lnet/minecraftforge/registries/RegistryObject;
      // 3229: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 322c: checkcast net/minecraft/world/effect/MobEffect
      // 322f: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 3232: ifne 32c5
      // 3235: aload 8
      // 3237: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 323a: ldc_w "ringspin"
      // 323d: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3240: dconst_0
      // 3241: dcmpg
      // 3242: ifgt 3256
      // 3245: aload 8
      // 3247: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 324a: ldc_w "ringspin"
      // 324d: ldc2_w 360.0
      // 3250: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3253: goto 3270
      // 3256: aload 8
      // 3258: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 325b: ldc_w "ringspin"
      // 325e: aload 8
      // 3260: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3263: ldc_w "ringspin"
      // 3266: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3269: ldc2_w 25.0
      // 326c: dsub
      // 326d: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3270: aload 1
      // 3271: instanceof net/minecraft/server/level/ServerLevel
      // 3274: ifeq 32c5
      // 3277: aload 1
      // 3278: checkcast net/minecraft/server/level/ServerLevel
      // 327b: astore 143
      // 327d: aload 143
      // 327f: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 3282: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 3285: new net/minecraft/commands/CommandSourceStack
      // 3288: dup
      // 3289: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 328c: new net/minecraft/world/phys/Vec3
      // 328f: dup
      // 3290: dload 2
      // 3291: dload 4
      // 3293: dload 6
      // 3295: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3298: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 329b: aload 143
      // 329d: bipush 4
      // 329e: ldc ""
      // 32a0: ldc ""
      // 32a2: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 32a5: aload 143
      // 32a7: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 32aa: aconst_null
      // 32ab: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 32ae: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 32b1: aload 8
      // 32b3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 32b6: ldc_w "ringspin"
      // 32b9: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 32bc: invokedynamic makeConcatWithConstants (D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute as @p at @s rotated \u0001 3 as @p run particle arphex:eternal_flame ^ ^0.3 ^1.5" ]
      // 32c1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 32c4: pop
      // 32c5: aload 8
      // 32c7: instanceof net/minecraft/world/entity/LivingEntity
      // 32ca: ifeq 32dc
      // 32cd: aload 8
      // 32cf: checkcast net/minecraft/world/entity/LivingEntity
      // 32d2: astore 142
      // 32d4: aload 142
      // 32d6: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 32d9: goto 32df
      // 32dc: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 32df: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 32e2: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 32e5: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 32e8: if_acmpne 333f
      // 32eb: aload 8
      // 32ed: instanceof net/minecraft/world/entity/LivingEntity
      // 32f0: ifeq 3302
      // 32f3: aload 8
      // 32f5: checkcast net/minecraft/world/entity/LivingEntity
      // 32f8: astore 143
      // 32fa: aload 143
      // 32fc: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 32ff: goto 3305
      // 3302: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3305: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3308: getstatic net/arphex/init/ArphexModItems.ABYSSAL_BLADE Lnet/minecraftforge/registries/RegistryObject;
      // 330b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 330e: if_acmpne 333f
      // 3311: aload 1
      // 3312: instanceof net/minecraft/server/level/ServerLevel
      // 3315: ifeq 333f
      // 3318: aload 1
      // 3319: checkcast net/minecraft/server/level/ServerLevel
      // 331c: astore 144
      // 331e: aload 144
      // 3320: getstatic net/arphex/init/ArphexModParticleTypes.SCORCH_FLAME Lnet/minecraftforge/registries/RegistryObject;
      // 3323: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3326: checkcast net/minecraft/core/particles/SimpleParticleType
      // 3329: dload 2
      // 332a: dload 4
      // 332c: dload 6
      // 332e: bipush 5
      // 332f: ldc2_w 0.4
      // 3332: ldc2_w 0.4
      // 3335: ldc2_w 0.4
      // 3338: ldc2_w 0.2
      // 333b: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 333e: pop
      // 333f: aload 8
      // 3341: instanceof net/minecraft/world/entity/LivingEntity
      // 3344: ifeq 3359
      // 3347: aload 8
      // 3349: checkcast net/minecraft/world/entity/LivingEntity
      // 334c: astore 134
      // 334e: aload 134
      // 3350: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 3353: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 3356: goto 335c
      // 3359: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 335c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 335f: getstatic net/arphex/init/ArphexModItems.UMBRAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 3362: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3365: if_acmpne 33e3
      // 3368: aload 8
      // 336a: instanceof net/minecraft/world/entity/LivingEntity
      // 336d: ifeq 3382
      // 3370: aload 8
      // 3372: checkcast net/minecraft/world/entity/LivingEntity
      // 3375: astore 135
      // 3377: aload 135
      // 3379: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 337c: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 337f: goto 3385
      // 3382: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3385: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3388: getstatic net/arphex/init/ArphexModItems.UMBRAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 338b: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 338e: if_acmpne 33e3
      // 3391: aload 8
      // 3393: instanceof net/minecraft/world/entity/LivingEntity
      // 3396: ifeq 33ab
      // 3399: aload 8
      // 339b: checkcast net/minecraft/world/entity/LivingEntity
      // 339e: astore 136
      // 33a0: aload 136
      // 33a2: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 33a5: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 33a8: goto 33ae
      // 33ab: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 33ae: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 33b1: getstatic net/arphex/init/ArphexModItems.UMBRAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 33b4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 33b7: if_acmpne 33e3
      // 33ba: aload 8
      // 33bc: instanceof net/minecraft/world/entity/LivingEntity
      // 33bf: ifeq 33d4
      // 33c2: aload 8
      // 33c4: checkcast net/minecraft/world/entity/LivingEntity
      // 33c7: astore 137
      // 33c9: aload 137
      // 33cb: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 33ce: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 33d1: goto 33d7
      // 33d4: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 33d7: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 33da: getstatic net/arphex/init/ArphexModItems.UMBRAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 33dd: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 33e0: if_acmpeq 352b
      // 33e3: aload 8
      // 33e5: instanceof net/minecraft/world/entity/LivingEntity
      // 33e8: ifeq 33fd
      // 33eb: aload 8
      // 33ed: checkcast net/minecraft/world/entity/LivingEntity
      // 33f0: astore 138
      // 33f2: aload 138
      // 33f4: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 33f7: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 33fa: goto 3400
      // 33fd: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3400: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3403: getstatic net/arphex/init/ArphexModItems.ETERNAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 3406: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3409: if_acmpne 3487
      // 340c: aload 8
      // 340e: instanceof net/minecraft/world/entity/LivingEntity
      // 3411: ifeq 3426
      // 3414: aload 8
      // 3416: checkcast net/minecraft/world/entity/LivingEntity
      // 3419: astore 139
      // 341b: aload 139
      // 341d: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 3420: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 3423: goto 3429
      // 3426: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3429: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 342c: getstatic net/arphex/init/ArphexModItems.ETERNAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 342f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3432: if_acmpne 3487
      // 3435: aload 8
      // 3437: instanceof net/minecraft/world/entity/LivingEntity
      // 343a: ifeq 344f
      // 343d: aload 8
      // 343f: checkcast net/minecraft/world/entity/LivingEntity
      // 3442: astore 140
      // 3444: aload 140
      // 3446: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 3449: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 344c: goto 3452
      // 344f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 3452: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3455: getstatic net/arphex/init/ArphexModItems.ETERNAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 3458: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 345b: if_acmpne 3487
      // 345e: aload 8
      // 3460: instanceof net/minecraft/world/entity/LivingEntity
      // 3463: ifeq 3478
      // 3466: aload 8
      // 3468: checkcast net/minecraft/world/entity/LivingEntity
      // 346b: astore 141
      // 346d: aload 141
      // 346f: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 3472: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 3475: goto 347b
      // 3478: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 347b: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 347e: getstatic net/arphex/init/ArphexModItems.ETERNAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 3481: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3484: if_acmpeq 352b
      // 3487: aload 8
      // 3489: instanceof net/minecraft/world/entity/LivingEntity
      // 348c: ifeq 34a1
      // 348f: aload 8
      // 3491: checkcast net/minecraft/world/entity/LivingEntity
      // 3494: astore 142
      // 3496: aload 142
      // 3498: getstatic net/minecraft/world/entity/EquipmentSlot.HEAD Lnet/minecraft/world/entity/EquipmentSlot;
      // 349b: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 349e: goto 34a4
      // 34a1: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 34a4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 34a7: getstatic net/arphex/init/ArphexModItems.IMMORTAL_HELMET Lnet/minecraftforge/registries/RegistryObject;
      // 34aa: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 34ad: if_acmpne 3d3a
      // 34b0: aload 8
      // 34b2: instanceof net/minecraft/world/entity/LivingEntity
      // 34b5: ifeq 34ca
      // 34b8: aload 8
      // 34ba: checkcast net/minecraft/world/entity/LivingEntity
      // 34bd: astore 143
      // 34bf: aload 143
      // 34c1: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 34c4: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 34c7: goto 34cd
      // 34ca: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 34cd: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 34d0: getstatic net/arphex/init/ArphexModItems.IMMORTAL_CHESTPLATE Lnet/minecraftforge/registries/RegistryObject;
      // 34d3: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 34d6: if_acmpne 3d3a
      // 34d9: aload 8
      // 34db: instanceof net/minecraft/world/entity/LivingEntity
      // 34de: ifeq 34f3
      // 34e1: aload 8
      // 34e3: checkcast net/minecraft/world/entity/LivingEntity
      // 34e6: astore 144
      // 34e8: aload 144
      // 34ea: getstatic net/minecraft/world/entity/EquipmentSlot.LEGS Lnet/minecraft/world/entity/EquipmentSlot;
      // 34ed: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 34f0: goto 34f6
      // 34f3: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 34f6: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 34f9: getstatic net/arphex/init/ArphexModItems.IMMORTAL_LEGGINGS Lnet/minecraftforge/registries/RegistryObject;
      // 34fc: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 34ff: if_acmpne 3d3a
      // 3502: aload 8
      // 3504: instanceof net/minecraft/world/entity/LivingEntity
      // 3507: ifeq 351c
      // 350a: aload 8
      // 350c: checkcast net/minecraft/world/entity/LivingEntity
      // 350f: astore 145
      // 3511: aload 145
      // 3513: getstatic net/minecraft/world/entity/EquipmentSlot.FEET Lnet/minecraft/world/entity/EquipmentSlot;
      // 3516: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 3519: goto 351f
      // 351c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 351f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 3522: getstatic net/arphex/init/ArphexModItems.IMMORTAL_BOOTS Lnet/minecraftforge/registries/RegistryObject;
      // 3525: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3528: if_acmpne 3d3a
      // 352b: aload 8
      // 352d: instanceof net/minecraft/world/entity/LivingEntity
      // 3530: ifeq 3d3a
      // 3533: aload 8
      // 3535: checkcast net/minecraft/world/entity/LivingEntity
      // 3538: astore 146
      // 353a: aload 146
      // 353c: getstatic net/arphex/init/ArphexModMobEffects.ABYSSAL_DETECTOR Lnet/minecraftforge/registries/RegistryObject;
      // 353f: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 3542: checkcast net/minecraft/world/effect/MobEffect
      // 3545: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 3548: ifeq 3d3a
      // 354b: aload 8
      // 354d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3550: ldc_w "sping"
      // 3553: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3556: dconst_0
      // 3557: dcmpg
      // 3558: ifgt 356c
      // 355b: aload 8
      // 355d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3560: ldc_w "sping"
      // 3563: ldc2_w 360.0
      // 3566: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3569: goto 3586
      // 356c: aload 8
      // 356e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3571: ldc_w "sping"
      // 3574: aload 8
      // 3576: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3579: ldc_w "sping"
      // 357c: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 357f: ldc2_w 5.0
      // 3582: dsub
      // 3583: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3586: aload 1
      // 3587: instanceof net/minecraft/server/level/ServerLevel
      // 358a: ifeq 35db
      // 358d: aload 1
      // 358e: checkcast net/minecraft/server/level/ServerLevel
      // 3591: astore 147
      // 3593: aload 147
      // 3595: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 3598: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 359b: new net/minecraft/commands/CommandSourceStack
      // 359e: dup
      // 359f: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 35a2: new net/minecraft/world/phys/Vec3
      // 35a5: dup
      // 35a6: dload 2
      // 35a7: dload 4
      // 35a9: dload 6
      // 35ab: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 35ae: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 35b1: aload 147
      // 35b3: bipush 4
      // 35b4: ldc ""
      // 35b6: ldc ""
      // 35b8: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 35bb: aload 147
      // 35bd: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 35c0: aconst_null
      // 35c1: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 35c4: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 35c7: aload 8
      // 35c9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 35cc: ldc_w "sping"
      // 35cf: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 35d2: invokedynamic makeConcatWithConstants (D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute as @p at @s rotated \u0001 3 as @p run particle arphex:heavy_purple_smoke ^ ^0.3 ^1.8" ]
      // 35d7: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 35da: pop
      // 35db: new net/minecraft/world/phys/Vec3
      // 35de: dup
      // 35df: dload 2
      // 35e0: dload 4
      // 35e2: dload 6
      // 35e4: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 35e7: astore 147
      // 35e9: aload 1
      // 35ea: ldc net/minecraft/world/entity/Entity
      // 35ec: new net/minecraft/world/phys/AABB
      // 35ef: dup
      // 35f0: aload 147
      // 35f2: aload 147
      // 35f4: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 35f7: ldc2_w 2.5
      // 35fa: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 35fd: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$78 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 3602: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3607: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 360c: aload 147
      // 360e: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$79 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 3613: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 3616: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 361b: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 3620: astore 148
      // 3622: aload 148
      // 3624: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3629: astore 149
      // 362b: aload 149
      // 362d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3632: ifeq 3d3a
      // 3635: aload 149
      // 3637: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 363c: checkcast net/minecraft/world/entity/Entity
      // 363f: astore 150
      // 3641: aload 150
      // 3643: instanceof net/minecraft/world/entity/Mob
      // 3646: ifeq 3658
      // 3649: aload 150
      // 364b: checkcast net/minecraft/world/entity/Mob
      // 364e: astore 151
      // 3650: aload 151
      // 3652: invokevirtual net/minecraft/world/entity/Mob.getTarget ()Lnet/minecraft/world/entity/LivingEntity;
      // 3655: goto 3659
      // 3658: aconst_null
      // 3659: ifnull 3d37
      // 365c: aload 150
      // 365e: instanceof net/minecraft/world/entity/Mob
      // 3661: ifeq 3673
      // 3664: aload 150
      // 3666: checkcast net/minecraft/world/entity/Mob
      // 3669: astore 152
      // 366b: aload 152
      // 366d: invokevirtual net/minecraft/world/entity/Mob.getTarget ()Lnet/minecraft/world/entity/LivingEntity;
      // 3670: goto 3674
      // 3673: aconst_null
      // 3674: aload 8
      // 3676: if_acmpne 3d37
      // 3679: aload 150
      // 367b: instanceof net/minecraft/world/entity/TamableAnimal
      // 367e: ifeq 36a4
      // 3681: aload 150
      // 3683: checkcast net/minecraft/world/entity/TamableAnimal
      // 3686: astore 153
      // 3688: aload 8
      // 368a: instanceof net/minecraft/world/entity/LivingEntity
      // 368d: ifeq 36a4
      // 3690: aload 8
      // 3692: checkcast net/minecraft/world/entity/LivingEntity
      // 3695: astore 154
      // 3697: aload 153
      // 3699: aload 154
      // 369b: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 369e: ifeq 36a4
      // 36a1: goto 3d37
      // 36a4: aload 8
      // 36a6: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 36a9: ldc_w "sping"
      // 36ac: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 36af: ldc2_w 180.0
      // 36b2: dcmpl
      // 36b3: ifle 39fc
      // 36b6: aload 150
      // 36b8: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 36bb: aload 8
      // 36bd: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 36c0: dsub
      // 36c1: aload 150
      // 36c3: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 36c6: aload 8
      // 36c8: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 36cb: dsub
      // 36cc: invokestatic java/lang/Math.atan2 (DD)D
      // 36cf: ldc2_w 57.5
      // 36d2: dmul
      // 36d3: dconst_0
      // 36d4: dsub
      // 36d5: aload 8
      // 36d7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 36da: ldc_w "sping"
      // 36dd: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 36e0: dadd
      // 36e1: ldc2_w 360.0
      // 36e4: dsub
      // 36e5: ldc2_w 20.0
      // 36e8: dcmpg
      // 36e9: ifge 36f0
      // 36ec: bipush 1
      // 36ed: goto 36f1
      // 36f0: bipush 0
      // 36f1: aload 150
      // 36f3: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 36f6: aload 8
      // 36f8: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 36fb: dsub
      // 36fc: aload 150
      // 36fe: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3701: aload 8
      // 3703: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3706: dsub
      // 3707: invokestatic java/lang/Math.atan2 (DD)D
      // 370a: ldc2_w 57.5
      // 370d: dmul
      // 370e: dconst_0
      // 370f: dsub
      // 3710: aload 8
      // 3712: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3715: ldc_w "sping"
      // 3718: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 371b: dadd
      // 371c: ldc2_w 360.0
      // 371f: dsub
      // 3720: ldc2_w -20.0
      // 3723: dcmpl
      // 3724: ifle 372b
      // 3727: bipush 1
      // 3728: goto 372c
      // 372b: bipush 0
      // 372c: if_icmpne 3d37
      // 372f: aload 150
      // 3731: new net/minecraft/world/damagesource/DamageSource
      // 3734: dup
      // 3735: aload 1
      // 3736: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 373b: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 373e: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 3743: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 3746: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 374b: aload 8
      // 374d: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;Lnet/minecraft/world/entity/Entity;)V
      // 3750: bipush 16
      // 3752: aload 150
      // 3754: instanceof net/minecraft/world/entity/LivingEntity
      // 3757: ifeq 3769
      // 375a: aload 150
      // 375c: checkcast net/minecraft/world/entity/LivingEntity
      // 375f: astore 155
      // 3761: aload 155
      // 3763: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3766: goto 376a
      // 3769: bipush 0
      // 376a: bipush 5
      // 376b: iadd
      // 376c: idiv
      // 376d: i2f
      // 376e: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 3771: pop
      // 3772: aload 1
      // 3773: instanceof net/minecraft/server/level/ServerLevel
      // 3776: ifeq 37a2
      // 3779: aload 1
      // 377a: checkcast net/minecraft/server/level/ServerLevel
      // 377d: astore 155
      // 377f: aload 155
      // 3781: getstatic net/minecraft/core/particles/ParticleTypes.EXPLOSION Lnet/minecraft/core/particles/SimpleParticleType;
      // 3784: aload 150
      // 3786: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3789: aload 150
      // 378b: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 378e: aload 150
      // 3790: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3793: bipush 1
      // 3794: ldc2_w 0.2
      // 3797: ldc2_w 0.2
      // 379a: ldc2_w 0.2
      // 379d: dconst_1
      // 379e: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 37a1: pop
      // 37a2: aload 150
      // 37a4: instanceof net/minecraft/world/entity/LivingEntity
      // 37a7: ifeq 37d1
      // 37aa: aload 150
      // 37ac: checkcast net/minecraft/world/entity/LivingEntity
      // 37af: astore 155
      // 37b1: aload 155
      // 37b3: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 37b6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 37b9: ifne 37d1
      // 37bc: aload 155
      // 37be: new net/minecraft/world/effect/MobEffectInstance
      // 37c1: dup
      // 37c2: getstatic net/minecraft/world/effect/MobEffects.LEVITATION Lnet/minecraft/world/effect/MobEffect;
      // 37c5: bipush 40
      // 37c7: bipush 0
      // 37c8: bipush 0
      // 37c9: bipush 0
      // 37ca: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 37cd: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 37d0: pop
      // 37d1: dload 2
      // 37d2: aload 150
      // 37d4: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 37d7: dsub
      // 37d8: dconst_0
      // 37d9: dcmpl
      // 37da: ifle 3861
      // 37dd: dload 6
      // 37df: aload 150
      // 37e1: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 37e4: dsub
      // 37e5: dconst_0
      // 37e6: dcmpl
      // 37e7: ifle 3861
      // 37ea: aload 150
      // 37ec: new net/minecraft/world/phys/Vec3
      // 37ef: dup
      // 37f0: dconst_0
      // 37f1: dload 2
      // 37f2: aload 150
      // 37f4: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 37f7: dsub
      // 37f8: dsub
      // 37f9: sipush 300
      // 37fc: sipush 200
      // 37ff: aload 150
      // 3801: instanceof net/minecraft/world/entity/LivingEntity
      // 3804: ifeq 3816
      // 3807: aload 150
      // 3809: checkcast net/minecraft/world/entity/LivingEntity
      // 380c: astore 155
      // 380e: aload 155
      // 3810: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3813: goto 3817
      // 3816: bipush 0
      // 3817: bipush 10
      // 3819: imul
      // 381a: iadd
      // 381b: idiv
      // 381c: i2d
      // 381d: ldc2_w 1.5
      // 3820: ddiv
      // 3821: dmul
      // 3822: ldc2_w 0.3
      // 3825: dconst_0
      // 3826: dload 6
      // 3828: aload 150
      // 382a: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 382d: dsub
      // 382e: dsub
      // 382f: sipush 300
      // 3832: sipush 200
      // 3835: aload 150
      // 3837: instanceof net/minecraft/world/entity/LivingEntity
      // 383a: ifeq 384c
      // 383d: aload 150
      // 383f: checkcast net/minecraft/world/entity/LivingEntity
      // 3842: astore 155
      // 3844: aload 155
      // 3846: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3849: goto 384d
      // 384c: bipush 0
      // 384d: bipush 10
      // 384f: imul
      // 3850: iadd
      // 3851: idiv
      // 3852: i2d
      // 3853: ldc2_w 1.5
      // 3856: ddiv
      // 3857: dmul
      // 3858: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 385b: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 385e: goto 3d37
      // 3861: dload 2
      // 3862: aload 150
      // 3864: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3867: dsub
      // 3868: dconst_0
      // 3869: dcmpg
      // 386a: ifge 38f3
      // 386d: dload 6
      // 386f: aload 150
      // 3871: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3874: dsub
      // 3875: dconst_0
      // 3876: dcmpg
      // 3877: ifge 38f3
      // 387a: aload 150
      // 387c: new net/minecraft/world/phys/Vec3
      // 387f: dup
      // 3880: dload 2
      // 3881: aload 150
      // 3883: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3886: dsub
      // 3887: invokestatic java/lang/Math.abs (D)D
      // 388a: sipush 300
      // 388d: sipush 200
      // 3890: aload 150
      // 3892: instanceof net/minecraft/world/entity/LivingEntity
      // 3895: ifeq 38a7
      // 3898: aload 150
      // 389a: checkcast net/minecraft/world/entity/LivingEntity
      // 389d: astore 155
      // 389f: aload 155
      // 38a1: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 38a4: goto 38a8
      // 38a7: bipush 0
      // 38a8: bipush 10
      // 38aa: imul
      // 38ab: iadd
      // 38ac: idiv
      // 38ad: i2d
      // 38ae: ldc2_w 1.5
      // 38b1: ddiv
      // 38b2: dmul
      // 38b3: ldc2_w 0.3
      // 38b6: dload 6
      // 38b8: aload 150
      // 38ba: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 38bd: dsub
      // 38be: invokestatic java/lang/Math.abs (D)D
      // 38c1: sipush 300
      // 38c4: sipush 200
      // 38c7: aload 150
      // 38c9: instanceof net/minecraft/world/entity/LivingEntity
      // 38cc: ifeq 38de
      // 38cf: aload 150
      // 38d1: checkcast net/minecraft/world/entity/LivingEntity
      // 38d4: astore 155
      // 38d6: aload 155
      // 38d8: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 38db: goto 38df
      // 38de: bipush 0
      // 38df: bipush 10
      // 38e1: imul
      // 38e2: iadd
      // 38e3: idiv
      // 38e4: i2d
      // 38e5: ldc2_w 1.5
      // 38e8: ddiv
      // 38e9: dmul
      // 38ea: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 38ed: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 38f0: goto 3d37
      // 38f3: dload 2
      // 38f4: aload 150
      // 38f6: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 38f9: dsub
      // 38fa: dconst_0
      // 38fb: dcmpl
      // 38fc: ifle 3984
      // 38ff: dload 6
      // 3901: aload 150
      // 3903: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3906: dsub
      // 3907: dconst_0
      // 3908: dcmpg
      // 3909: ifge 3984
      // 390c: aload 150
      // 390e: new net/minecraft/world/phys/Vec3
      // 3911: dup
      // 3912: dconst_0
      // 3913: dload 2
      // 3914: aload 150
      // 3916: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3919: dsub
      // 391a: dsub
      // 391b: sipush 300
      // 391e: sipush 200
      // 3921: aload 150
      // 3923: instanceof net/minecraft/world/entity/LivingEntity
      // 3926: ifeq 3938
      // 3929: aload 150
      // 392b: checkcast net/minecraft/world/entity/LivingEntity
      // 392e: astore 155
      // 3930: aload 155
      // 3932: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3935: goto 3939
      // 3938: bipush 0
      // 3939: bipush 10
      // 393b: imul
      // 393c: iadd
      // 393d: idiv
      // 393e: i2d
      // 393f: ldc2_w 1.5
      // 3942: ddiv
      // 3943: dmul
      // 3944: ldc2_w 0.3
      // 3947: dload 6
      // 3949: aload 150
      // 394b: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 394e: dsub
      // 394f: invokestatic java/lang/Math.abs (D)D
      // 3952: sipush 300
      // 3955: sipush 200
      // 3958: aload 150
      // 395a: instanceof net/minecraft/world/entity/LivingEntity
      // 395d: ifeq 396f
      // 3960: aload 150
      // 3962: checkcast net/minecraft/world/entity/LivingEntity
      // 3965: astore 155
      // 3967: aload 155
      // 3969: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 396c: goto 3970
      // 396f: bipush 0
      // 3970: bipush 10
      // 3972: imul
      // 3973: iadd
      // 3974: idiv
      // 3975: i2d
      // 3976: ldc2_w 1.5
      // 3979: ddiv
      // 397a: dmul
      // 397b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 397e: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 3981: goto 3d37
      // 3984: aload 150
      // 3986: new net/minecraft/world/phys/Vec3
      // 3989: dup
      // 398a: dload 2
      // 398b: aload 150
      // 398d: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3990: dsub
      // 3991: invokestatic java/lang/Math.abs (D)D
      // 3994: sipush 300
      // 3997: sipush 200
      // 399a: aload 150
      // 399c: instanceof net/minecraft/world/entity/LivingEntity
      // 399f: ifeq 39b1
      // 39a2: aload 150
      // 39a4: checkcast net/minecraft/world/entity/LivingEntity
      // 39a7: astore 155
      // 39a9: aload 155
      // 39ab: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 39ae: goto 39b2
      // 39b1: bipush 0
      // 39b2: bipush 10
      // 39b4: imul
      // 39b5: iadd
      // 39b6: idiv
      // 39b7: i2d
      // 39b8: ldc2_w 1.5
      // 39bb: ddiv
      // 39bc: dmul
      // 39bd: ldc2_w 0.3
      // 39c0: dconst_0
      // 39c1: dload 6
      // 39c3: aload 150
      // 39c5: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 39c8: dsub
      // 39c9: dsub
      // 39ca: sipush 300
      // 39cd: sipush 200
      // 39d0: aload 150
      // 39d2: instanceof net/minecraft/world/entity/LivingEntity
      // 39d5: ifeq 39e7
      // 39d8: aload 150
      // 39da: checkcast net/minecraft/world/entity/LivingEntity
      // 39dd: astore 155
      // 39df: aload 155
      // 39e1: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 39e4: goto 39e8
      // 39e7: bipush 0
      // 39e8: bipush 10
      // 39ea: imul
      // 39eb: iadd
      // 39ec: idiv
      // 39ed: i2d
      // 39ee: ldc2_w 1.5
      // 39f1: ddiv
      // 39f2: dmul
      // 39f3: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 39f6: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 39f9: goto 3d37
      // 39fc: aload 150
      // 39fe: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3a01: aload 8
      // 3a03: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3a06: dsub
      // 3a07: aload 150
      // 3a09: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3a0c: aload 8
      // 3a0e: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3a11: dsub
      // 3a12: invokestatic java/lang/Math.atan2 (DD)D
      // 3a15: ldc2_w 57.5
      // 3a18: dmul
      // 3a19: dconst_0
      // 3a1a: dsub
      // 3a1b: aload 8
      // 3a1d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3a20: ldc_w "sping"
      // 3a23: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3a26: dadd
      // 3a27: ldc2_w 20.0
      // 3a2a: dcmpg
      // 3a2b: ifge 3a32
      // 3a2e: bipush 1
      // 3a2f: goto 3a33
      // 3a32: bipush 0
      // 3a33: aload 150
      // 3a35: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3a38: aload 8
      // 3a3a: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3a3d: dsub
      // 3a3e: aload 150
      // 3a40: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3a43: aload 8
      // 3a45: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3a48: dsub
      // 3a49: invokestatic java/lang/Math.atan2 (DD)D
      // 3a4c: ldc2_w 57.5
      // 3a4f: dmul
      // 3a50: dconst_0
      // 3a51: dsub
      // 3a52: aload 8
      // 3a54: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3a57: ldc_w "sping"
      // 3a5a: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3a5d: dadd
      // 3a5e: ldc2_w -20.0
      // 3a61: dcmpl
      // 3a62: ifle 3a69
      // 3a65: bipush 1
      // 3a66: goto 3a6a
      // 3a69: bipush 0
      // 3a6a: if_icmpne 3d37
      // 3a6d: aload 150
      // 3a6f: new net/minecraft/world/damagesource/DamageSource
      // 3a72: dup
      // 3a73: aload 1
      // 3a74: invokeinterface net/minecraft/world/level/LevelAccessor.registryAccess ()Lnet/minecraft/core/RegistryAccess; 1
      // 3a79: getstatic net/minecraft/core/registries/Registries.DAMAGE_TYPE Lnet/minecraft/resources/ResourceKey;
      // 3a7c: invokeinterface net/minecraft/core/RegistryAccess.registryOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry; 2
      // 3a81: getstatic net/minecraft/world/damagesource/DamageTypes.GENERIC Lnet/minecraft/resources/ResourceKey;
      // 3a84: invokeinterface net/minecraft/core/Registry.getHolderOrThrow (Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Holder$Reference; 2
      // 3a89: aload 8
      // 3a8b: invokespecial net/minecraft/world/damagesource/DamageSource.<init> (Lnet/minecraft/core/Holder;Lnet/minecraft/world/entity/Entity;)V
      // 3a8e: bipush 16
      // 3a90: aload 150
      // 3a92: instanceof net/minecraft/world/entity/LivingEntity
      // 3a95: ifeq 3aa7
      // 3a98: aload 150
      // 3a9a: checkcast net/minecraft/world/entity/LivingEntity
      // 3a9d: astore 155
      // 3a9f: aload 155
      // 3aa1: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3aa4: goto 3aa8
      // 3aa7: bipush 0
      // 3aa8: bipush 5
      // 3aa9: iadd
      // 3aaa: idiv
      // 3aab: i2f
      // 3aac: invokevirtual net/minecraft/world/entity/Entity.hurt (Lnet/minecraft/world/damagesource/DamageSource;F)Z
      // 3aaf: pop
      // 3ab0: aload 1
      // 3ab1: instanceof net/minecraft/server/level/ServerLevel
      // 3ab4: ifeq 3ae0
      // 3ab7: aload 1
      // 3ab8: checkcast net/minecraft/server/level/ServerLevel
      // 3abb: astore 155
      // 3abd: aload 155
      // 3abf: getstatic net/minecraft/core/particles/ParticleTypes.EXPLOSION Lnet/minecraft/core/particles/SimpleParticleType;
      // 3ac2: aload 150
      // 3ac4: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3ac7: aload 150
      // 3ac9: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 3acc: aload 150
      // 3ace: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3ad1: bipush 1
      // 3ad2: ldc2_w 0.2
      // 3ad5: ldc2_w 0.2
      // 3ad8: ldc2_w 0.2
      // 3adb: dconst_1
      // 3adc: invokevirtual net/minecraft/server/level/ServerLevel.sendParticles (Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I
      // 3adf: pop
      // 3ae0: aload 150
      // 3ae2: instanceof net/minecraft/world/entity/LivingEntity
      // 3ae5: ifeq 3b0f
      // 3ae8: aload 150
      // 3aea: checkcast net/minecraft/world/entity/LivingEntity
      // 3aed: astore 155
      // 3aef: aload 155
      // 3af1: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 3af4: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3af7: ifne 3b0f
      // 3afa: aload 155
      // 3afc: new net/minecraft/world/effect/MobEffectInstance
      // 3aff: dup
      // 3b00: getstatic net/minecraft/world/effect/MobEffects.LEVITATION Lnet/minecraft/world/effect/MobEffect;
      // 3b03: bipush 40
      // 3b05: bipush 0
      // 3b06: bipush 0
      // 3b07: bipush 0
      // 3b08: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 3b0b: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 3b0e: pop
      // 3b0f: dload 2
      // 3b10: aload 150
      // 3b12: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3b15: dsub
      // 3b16: dconst_0
      // 3b17: dcmpl
      // 3b18: ifle 3b9f
      // 3b1b: dload 6
      // 3b1d: aload 150
      // 3b1f: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3b22: dsub
      // 3b23: dconst_0
      // 3b24: dcmpl
      // 3b25: ifle 3b9f
      // 3b28: aload 150
      // 3b2a: new net/minecraft/world/phys/Vec3
      // 3b2d: dup
      // 3b2e: dconst_0
      // 3b2f: dload 2
      // 3b30: aload 150
      // 3b32: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3b35: dsub
      // 3b36: dsub
      // 3b37: sipush 300
      // 3b3a: sipush 200
      // 3b3d: aload 150
      // 3b3f: instanceof net/minecraft/world/entity/LivingEntity
      // 3b42: ifeq 3b54
      // 3b45: aload 150
      // 3b47: checkcast net/minecraft/world/entity/LivingEntity
      // 3b4a: astore 155
      // 3b4c: aload 155
      // 3b4e: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3b51: goto 3b55
      // 3b54: bipush 0
      // 3b55: bipush 20
      // 3b57: imul
      // 3b58: iadd
      // 3b59: idiv
      // 3b5a: i2d
      // 3b5b: ldc2_w 1.5
      // 3b5e: ddiv
      // 3b5f: dmul
      // 3b60: ldc2_w 0.3
      // 3b63: dconst_0
      // 3b64: dload 6
      // 3b66: aload 150
      // 3b68: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3b6b: dsub
      // 3b6c: dsub
      // 3b6d: sipush 300
      // 3b70: sipush 200
      // 3b73: aload 150
      // 3b75: instanceof net/minecraft/world/entity/LivingEntity
      // 3b78: ifeq 3b8a
      // 3b7b: aload 150
      // 3b7d: checkcast net/minecraft/world/entity/LivingEntity
      // 3b80: astore 155
      // 3b82: aload 155
      // 3b84: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3b87: goto 3b8b
      // 3b8a: bipush 0
      // 3b8b: bipush 20
      // 3b8d: imul
      // 3b8e: iadd
      // 3b8f: idiv
      // 3b90: i2d
      // 3b91: ldc2_w 1.5
      // 3b94: ddiv
      // 3b95: dmul
      // 3b96: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3b99: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 3b9c: goto 3d37
      // 3b9f: dload 2
      // 3ba0: aload 150
      // 3ba2: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3ba5: dsub
      // 3ba6: dconst_0
      // 3ba7: dcmpg
      // 3ba8: ifge 3c31
      // 3bab: dload 6
      // 3bad: aload 150
      // 3baf: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3bb2: dsub
      // 3bb3: dconst_0
      // 3bb4: dcmpg
      // 3bb5: ifge 3c31
      // 3bb8: aload 150
      // 3bba: new net/minecraft/world/phys/Vec3
      // 3bbd: dup
      // 3bbe: dload 2
      // 3bbf: aload 150
      // 3bc1: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3bc4: dsub
      // 3bc5: invokestatic java/lang/Math.abs (D)D
      // 3bc8: sipush 300
      // 3bcb: sipush 200
      // 3bce: aload 150
      // 3bd0: instanceof net/minecraft/world/entity/LivingEntity
      // 3bd3: ifeq 3be5
      // 3bd6: aload 150
      // 3bd8: checkcast net/minecraft/world/entity/LivingEntity
      // 3bdb: astore 155
      // 3bdd: aload 155
      // 3bdf: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3be2: goto 3be6
      // 3be5: bipush 0
      // 3be6: bipush 20
      // 3be8: imul
      // 3be9: iadd
      // 3bea: idiv
      // 3beb: i2d
      // 3bec: ldc2_w 1.5
      // 3bef: ddiv
      // 3bf0: dmul
      // 3bf1: ldc2_w 0.3
      // 3bf4: dload 6
      // 3bf6: aload 150
      // 3bf8: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3bfb: dsub
      // 3bfc: invokestatic java/lang/Math.abs (D)D
      // 3bff: sipush 300
      // 3c02: sipush 200
      // 3c05: aload 150
      // 3c07: instanceof net/minecraft/world/entity/LivingEntity
      // 3c0a: ifeq 3c1c
      // 3c0d: aload 150
      // 3c0f: checkcast net/minecraft/world/entity/LivingEntity
      // 3c12: astore 155
      // 3c14: aload 155
      // 3c16: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3c19: goto 3c1d
      // 3c1c: bipush 0
      // 3c1d: bipush 20
      // 3c1f: imul
      // 3c20: iadd
      // 3c21: idiv
      // 3c22: i2d
      // 3c23: ldc2_w 1.5
      // 3c26: ddiv
      // 3c27: dmul
      // 3c28: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3c2b: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 3c2e: goto 3d37
      // 3c31: dload 2
      // 3c32: aload 150
      // 3c34: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3c37: dsub
      // 3c38: dconst_0
      // 3c39: dcmpl
      // 3c3a: ifle 3cc2
      // 3c3d: dload 6
      // 3c3f: aload 150
      // 3c41: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3c44: dsub
      // 3c45: dconst_0
      // 3c46: dcmpg
      // 3c47: ifge 3cc2
      // 3c4a: aload 150
      // 3c4c: new net/minecraft/world/phys/Vec3
      // 3c4f: dup
      // 3c50: dconst_0
      // 3c51: dload 2
      // 3c52: aload 150
      // 3c54: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3c57: dsub
      // 3c58: dsub
      // 3c59: sipush 300
      // 3c5c: sipush 200
      // 3c5f: aload 150
      // 3c61: instanceof net/minecraft/world/entity/LivingEntity
      // 3c64: ifeq 3c76
      // 3c67: aload 150
      // 3c69: checkcast net/minecraft/world/entity/LivingEntity
      // 3c6c: astore 155
      // 3c6e: aload 155
      // 3c70: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3c73: goto 3c77
      // 3c76: bipush 0
      // 3c77: bipush 20
      // 3c79: imul
      // 3c7a: iadd
      // 3c7b: idiv
      // 3c7c: i2d
      // 3c7d: ldc2_w 1.5
      // 3c80: ddiv
      // 3c81: dmul
      // 3c82: ldc2_w 0.3
      // 3c85: dload 6
      // 3c87: aload 150
      // 3c89: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3c8c: dsub
      // 3c8d: invokestatic java/lang/Math.abs (D)D
      // 3c90: sipush 300
      // 3c93: sipush 200
      // 3c96: aload 150
      // 3c98: instanceof net/minecraft/world/entity/LivingEntity
      // 3c9b: ifeq 3cad
      // 3c9e: aload 150
      // 3ca0: checkcast net/minecraft/world/entity/LivingEntity
      // 3ca3: astore 155
      // 3ca5: aload 155
      // 3ca7: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3caa: goto 3cae
      // 3cad: bipush 0
      // 3cae: bipush 20
      // 3cb0: imul
      // 3cb1: iadd
      // 3cb2: idiv
      // 3cb3: i2d
      // 3cb4: ldc2_w 1.5
      // 3cb7: ddiv
      // 3cb8: dmul
      // 3cb9: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3cbc: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 3cbf: goto 3d37
      // 3cc2: aload 150
      // 3cc4: new net/minecraft/world/phys/Vec3
      // 3cc7: dup
      // 3cc8: dload 2
      // 3cc9: aload 150
      // 3ccb: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 3cce: dsub
      // 3ccf: invokestatic java/lang/Math.abs (D)D
      // 3cd2: sipush 300
      // 3cd5: sipush 200
      // 3cd8: aload 150
      // 3cda: instanceof net/minecraft/world/entity/LivingEntity
      // 3cdd: ifeq 3cef
      // 3ce0: aload 150
      // 3ce2: checkcast net/minecraft/world/entity/LivingEntity
      // 3ce5: astore 155
      // 3ce7: aload 155
      // 3ce9: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3cec: goto 3cf0
      // 3cef: bipush 0
      // 3cf0: bipush 20
      // 3cf2: imul
      // 3cf3: iadd
      // 3cf4: idiv
      // 3cf5: i2d
      // 3cf6: ldc2_w 1.5
      // 3cf9: ddiv
      // 3cfa: dmul
      // 3cfb: ldc2_w 0.3
      // 3cfe: dconst_0
      // 3cff: dload 6
      // 3d01: aload 150
      // 3d03: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 3d06: dsub
      // 3d07: dsub
      // 3d08: sipush 300
      // 3d0b: sipush 200
      // 3d0e: aload 150
      // 3d10: instanceof net/minecraft/world/entity/LivingEntity
      // 3d13: ifeq 3d25
      // 3d16: aload 150
      // 3d18: checkcast net/minecraft/world/entity/LivingEntity
      // 3d1b: astore 155
      // 3d1d: aload 155
      // 3d1f: invokevirtual net/minecraft/world/entity/LivingEntity.getArmorValue ()I
      // 3d22: goto 3d26
      // 3d25: bipush 0
      // 3d26: bipush 20
      // 3d28: imul
      // 3d29: iadd
      // 3d2a: idiv
      // 3d2b: i2d
      // 3d2c: ldc2_w 1.5
      // 3d2f: ddiv
      // 3d30: dmul
      // 3d31: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3d34: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 3d37: goto 362b
      // 3d3a: aload 8
      // 3d3c: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3d3f: ldc_w "doublejumpascendant"
      // 3d42: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3d45: ldc2_w -1.0
      // 3d48: dcmpl
      // 3d49: ifle 3d64
      // 3d4c: aload 8
      // 3d4e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3d51: ldc_w "doublejumpascendant"
      // 3d54: aload 8
      // 3d56: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3d59: ldc_w "doublejumpascendant"
      // 3d5c: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3d5f: dconst_1
      // 3d60: dsub
      // 3d61: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3d64: aload 8
      // 3d66: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3d69: ldc_w "ownedantsnear"
      // 3d6c: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3d6f: dconst_0
      // 3d70: dcmpl
      // 3d71: ifle 4053
      // 3d74: aload 8
      // 3d76: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3d79: ldc_w "antlimitcycle"
      // 3d7c: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3d7f: dconst_0
      // 3d80: dcmpl
      // 3d81: ifgt 403b
      // 3d84: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.MAX_ANTS Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 3d87: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 3d8a: checkcast java/lang/Double
      // 3d8d: invokevirtual java/lang/Double.doubleValue ()D
      // 3d90: dconst_0
      // 3d91: dcmpl
      // 3d92: iflt 4053
      // 3d95: aload 8
      // 3d97: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 3d9a: aconst_null
      // 3d9b: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 3d9e: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 3da1: dup
      // 3da2: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 3da5: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 3da8: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 3dab: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tamedants D
      // 3dae: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.MAX_ANTS Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 3db1: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 3db4: checkcast java/lang/Double
      // 3db7: invokevirtual java/lang/Double.doubleValue ()D
      // 3dba: dcmpl
      // 3dbb: ifle 3ea0
      // 3dbe: dconst_0
      // 3dbf: dstore 134
      // 3dc1: aload 8
      // 3dc3: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 3dc6: aconst_null
      // 3dc7: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 3dca: dload 134
      // 3dcc: aload 8
      // 3dce: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$80 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 3dd3: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 3dd6: new net/minecraft/world/phys/Vec3
      // 3dd9: dup
      // 3dda: dload 2
      // 3ddb: dload 4
      // 3ddd: dload 6
      // 3ddf: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3de2: astore 134
      // 3de4: aload 1
      // 3de5: ldc net/minecraft/world/entity/Entity
      // 3de7: new net/minecraft/world/phys/AABB
      // 3dea: dup
      // 3deb: aload 134
      // 3ded: aload 134
      // 3def: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 3df2: ldc2_w 100.0
      // 3df5: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 3df8: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$81 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 3dfd: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3e02: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3e07: aload 134
      // 3e09: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$82 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 3e0e: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 3e11: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3e16: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 3e1b: astore 135
      // 3e1d: aload 135
      // 3e1f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3e24: astore 136
      // 3e26: aload 136
      // 3e28: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3e2d: ifeq 3e9d
      // 3e30: aload 136
      // 3e32: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3e37: checkcast net/minecraft/world/entity/Entity
      // 3e3a: astore 137
      // 3e3c: aload 137
      // 3e3e: instanceof net/arphex/entity/AntArsonistWorkerEntity
      // 3e41: ifne 3e4c
      // 3e44: aload 137
      // 3e46: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 3e49: ifeq 3e9a
      // 3e4c: aload 137
      // 3e4e: instanceof net/minecraft/world/entity/TamableAnimal
      // 3e51: ifeq 3e9a
      // 3e54: aload 137
      // 3e56: checkcast net/minecraft/world/entity/TamableAnimal
      // 3e59: astore 138
      // 3e5b: aload 8
      // 3e5d: instanceof net/minecraft/world/entity/LivingEntity
      // 3e60: ifeq 3e9a
      // 3e63: aload 8
      // 3e65: checkcast net/minecraft/world/entity/LivingEntity
      // 3e68: astore 139
      // 3e6a: aload 138
      // 3e6c: aload 139
      // 3e6e: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 3e71: ifeq 3e9a
      // 3e74: aload 8
      // 3e76: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3e79: ldc_w "furthest_ant"
      // 3e7c: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 3e7f: aload 137
      // 3e81: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 3e84: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 3e87: ifeq 3e9a
      // 3e8a: aload 137
      // 3e8c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 3e8f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 3e92: ifne 3e9a
      // 3e95: aload 137
      // 3e97: invokevirtual net/minecraft/world/entity/Entity.discard ()V
      // 3e9a: goto 3e26
      // 3e9d: goto 4053
      // 3ea0: aload 8
      // 3ea2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3ea5: ldc_w "antlimitcycle"
      // 3ea8: ldc2_w 40.0
      // 3eab: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3eae: aload 8
      // 3eb0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3eb3: ldc_w "furthest_ant_distance"
      // 3eb6: dconst_0
      // 3eb7: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3eba: dconst_0
      // 3ebb: dstore 134
      // 3ebd: aload 8
      // 3ebf: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 3ec2: aconst_null
      // 3ec3: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 3ec6: dload 134
      // 3ec8: aload 8
      // 3eca: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$83 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 3ecf: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 3ed2: aload 8
      // 3ed4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3ed7: ldc_w "furthest_ant"
      // 3eda: dconst_0
      // 3edb: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3ede: new net/minecraft/world/phys/Vec3
      // 3ee1: dup
      // 3ee2: dload 2
      // 3ee3: dload 4
      // 3ee5: dload 6
      // 3ee7: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 3eea: astore 134
      // 3eec: aload 1
      // 3eed: ldc net/minecraft/world/entity/Entity
      // 3eef: new net/minecraft/world/phys/AABB
      // 3ef2: dup
      // 3ef3: aload 134
      // 3ef5: aload 134
      // 3ef7: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 3efa: ldc2_w 100.0
      // 3efd: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 3f00: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$84 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 3f05: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 3f0a: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 3f0f: aload 134
      // 3f11: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$85 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 3f16: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 3f19: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 3f1e: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 3f23: astore 135
      // 3f25: aload 135
      // 3f27: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3f2c: astore 136
      // 3f2e: aload 136
      // 3f30: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3f35: ifeq 4038
      // 3f38: aload 136
      // 3f3a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3f3f: checkcast net/minecraft/world/entity/Entity
      // 3f42: astore 137
      // 3f44: aload 137
      // 3f46: instanceof net/arphex/entity/AntArsonistWorkerEntity
      // 3f49: ifne 3f54
      // 3f4c: aload 137
      // 3f4e: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 3f51: ifeq 4035
      // 3f54: aload 137
      // 3f56: instanceof net/minecraft/world/entity/TamableAnimal
      // 3f59: ifeq 4035
      // 3f5c: aload 137
      // 3f5e: checkcast net/minecraft/world/entity/TamableAnimal
      // 3f61: astore 138
      // 3f63: aload 8
      // 3f65: instanceof net/minecraft/world/entity/LivingEntity
      // 3f68: ifeq 4035
      // 3f6b: aload 8
      // 3f6d: checkcast net/minecraft/world/entity/LivingEntity
      // 3f70: astore 139
      // 3f72: aload 138
      // 3f74: aload 139
      // 3f76: invokevirtual net/minecraft/world/entity/TamableAnimal.isOwnedBy (Lnet/minecraft/world/entity/LivingEntity;)Z
      // 3f79: ifeq 4035
      // 3f7c: aload 137
      // 3f7e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3f81: ldc_w "this_ant"
      // 3f84: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3f87: aload 8
      // 3f89: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3f8c: ldc_w "furthest_ant"
      // 3f8f: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3f92: dcmpl
      // 3f93: ifle 3fbc
      // 3f96: aload 8
      // 3f98: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3f9b: ldc_w "furthest_ant"
      // 3f9e: aload 137
      // 3fa0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3fa3: ldc_w "this_ant"
      // 3fa6: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 3fa9: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 3fac: aload 8
      // 3fae: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 3fb1: ldc_w "furthest_ant"
      // 3fb4: aload 137
      // 3fb6: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 3fb9: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 3fbc: aload 137
      // 3fbe: instanceof net/arphex/entity/AntArsonistWorkerEntity
      // 3fc1: ifeq 3ff9
      // 3fc4: aload 8
      // 3fc6: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 3fc9: aconst_null
      // 3fca: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 3fcd: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 3fd0: dup
      // 3fd1: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 3fd4: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 3fd7: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 3fda: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tamedants D
      // 3fdd: dconst_1
      // 3fde: dadd
      // 3fdf: dstore 140
      // 3fe1: aload 8
      // 3fe3: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 3fe6: aconst_null
      // 3fe7: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 3fea: dload 140
      // 3fec: aload 8
      // 3fee: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$86 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 3ff3: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 3ff6: goto 4035
      // 3ff9: aload 137
      // 3ffb: instanceof net/arphex/entity/AntArsonistSoldierEntity
      // 3ffe: ifeq 4035
      // 4001: aload 8
      // 4003: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4006: aconst_null
      // 4007: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 400a: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 400d: dup
      // 400e: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4011: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4014: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4017: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tamedants D
      // 401a: ldc2_w 3.0
      // 401d: dadd
      // 401e: dstore 140
      // 4020: aload 8
      // 4022: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4025: aconst_null
      // 4026: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4029: dload 140
      // 402b: aload 8
      // 402d: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$87 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4032: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4035: goto 3f2e
      // 4038: goto 4053
      // 403b: aload 8
      // 403d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4040: ldc_w "antlimitcycle"
      // 4043: aload 8
      // 4045: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4048: ldc_w "antlimitcycle"
      // 404b: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 404e: dconst_1
      // 404f: dsub
      // 4050: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 4053: aload 8
      // 4055: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4058: ldc_w "queenslowtotem"
      // 405b: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 405e: ifeq 417b
      // 4061: bipush 0
      // 4062: istore 11
      // 4064: aload 8
      // 4066: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4069: ldc_w "queenslowtotem"
      // 406c: bipush 0
      // 406d: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 4070: new net/arphex/procedures/GameModeDetectorProcedure$13
      // 4073: dup
      // 4074: invokespecial net/arphex/procedures/GameModeDetectorProcedure$13.<init> ()V
      // 4077: aload 8
      // 4079: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$13.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 407c: ifne 408e
      // 407f: new net/arphex/procedures/GameModeDetectorProcedure$14
      // 4082: dup
      // 4083: invokespecial net/arphex/procedures/GameModeDetectorProcedure$14.<init> ()V
      // 4086: aload 8
      // 4088: invokevirtual net/arphex/procedures/GameModeDetectorProcedure$14.checkGamemode (Lnet/minecraft/world/entity/Entity;)Z
      // 408b: ifeq 417b
      // 408e: aload 1
      // 408f: ldc_w net/arphex/entity/TermiteTunnelerQueenEntity
      // 4092: new net/minecraft/world/phys/Vec3
      // 4095: dup
      // 4096: dload 2
      // 4097: dload 4
      // 4099: dload 6
      // 409b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 409e: ldc2_w 150.0
      // 40a1: ldc2_w 150.0
      // 40a4: ldc2_w 150.0
      // 40a7: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 40aa: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$88 (Lnet/arphex/entity/TermiteTunnelerQueenEntity;)Z, (Lnet/arphex/entity/TermiteTunnelerQueenEntity;)Z ]
      // 40af: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 40b4: invokeinterface java/util/List.isEmpty ()Z 1
      // 40b9: ifne 417b
      // 40bc: aload 8
      // 40be: instanceof net/minecraft/world/entity/LivingEntity
      // 40c1: ifeq 40ec
      // 40c4: aload 8
      // 40c6: checkcast net/minecraft/world/entity/LivingEntity
      // 40c9: astore 134
      // 40cb: aload 134
      // 40cd: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 40d0: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 40d3: ifne 40ec
      // 40d6: aload 134
      // 40d8: new net/minecraft/world/effect/MobEffectInstance
      // 40db: dup
      // 40dc: getstatic net/minecraft/world/effect/MobEffects.DIG_SLOWDOWN Lnet/minecraft/world/effect/MobEffect;
      // 40df: sipush 3600
      // 40e2: bipush 2
      // 40e3: bipush 0
      // 40e4: bipush 0
      // 40e5: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 40e8: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 40eb: pop
      // 40ec: aload 1
      // 40ed: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 40f2: ifeq 410e
      // 40f5: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 40f8: getfield net/minecraft/client/Minecraft.gameRenderer Lnet/minecraft/client/renderer/GameRenderer;
      // 40fb: new net/minecraft/world/item/ItemStack
      // 40fe: dup
      // 40ff: getstatic net/arphex/init/ArphexModItems.QUEEN_FATIGUE Lnet/minecraftforge/registries/RegistryObject;
      // 4102: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4105: checkcast net/minecraft/world/level/ItemLike
      // 4108: invokespecial net/minecraft/world/item/ItemStack.<init> (Lnet/minecraft/world/level/ItemLike;)V
      // 410b: invokevirtual net/minecraft/client/renderer/GameRenderer.displayItemActivation (Lnet/minecraft/world/item/ItemStack;)V
      // 410e: aload 1
      // 410f: instanceof net/minecraft/world/level/Level
      // 4112: ifeq 417b
      // 4115: aload 1
      // 4116: checkcast net/minecraft/world/level/Level
      // 4119: astore 134
      // 411b: aload 134
      // 411d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4120: ifne 4152
      // 4123: aload 134
      // 4125: aconst_null
      // 4126: dload 2
      // 4127: dload 4
      // 4129: dload 6
      // 412b: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 412e: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 4131: new net/minecraft/resources/ResourceLocation
      // 4134: dup
      // 4135: ldc_w "entity.elder_guardian.curse"
      // 4138: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 413b: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 4140: checkcast net/minecraft/sounds/SoundEvent
      // 4143: getstatic net/minecraft/sounds/SoundSource.HOSTILE Lnet/minecraft/sounds/SoundSource;
      // 4146: ldc_w 0.5
      // 4149: ldc_w 0.5
      // 414c: invokevirtual net/minecraft/world/level/Level.playSound (Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
      // 414f: goto 417b
      // 4152: aload 134
      // 4154: dload 2
      // 4155: dload 4
      // 4157: dload 6
      // 4159: getstatic net/minecraftforge/registries/ForgeRegistries.SOUND_EVENTS Lnet/minecraftforge/registries/IForgeRegistry;
      // 415c: new net/minecraft/resources/ResourceLocation
      // 415f: dup
      // 4160: ldc_w "entity.elder_guardian.curse"
      // 4163: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4166: invokeinterface net/minecraftforge/registries/IForgeRegistry.getValue (Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object; 2
      // 416b: checkcast net/minecraft/sounds/SoundEvent
      // 416e: getstatic net/minecraft/sounds/SoundSource.HOSTILE Lnet/minecraft/sounds/SoundSource;
      // 4171: ldc_w 0.5
      // 4174: ldc_w 0.5
      // 4177: bipush 0
      // 4178: invokevirtual net/minecraft/world/level/Level.playLocalSound (DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V
      // 417b: aload 1
      // 417c: invokestatic net/arphex/network/ArphexModVariables$WorldVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$WorldVariables;
      // 417f: getfield net/arphex/network/ArphexModVariables$WorldVariables.checkedprojecte Z
      // 4182: ifeq 4a4d
      // 4185: aload 1
      // 4186: invokestatic net/arphex/network/ArphexModVariables$WorldVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$WorldVariables;
      // 4189: bipush 0
      // 418a: putfield net/arphex/network/ArphexModVariables$WorldVariables.checkedprojecte Z
      // 418d: aload 1
      // 418e: invokestatic net/arphex/network/ArphexModVariables$WorldVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$WorldVariables;
      // 4191: aload 1
      // 4192: invokevirtual net/arphex/network/ArphexModVariables$WorldVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 4195: aload 1
      // 4196: instanceof net/minecraft/server/level/ServerLevel
      // 4199: ifeq 41dd
      // 419c: aload 1
      // 419d: checkcast net/minecraft/server/level/ServerLevel
      // 41a0: astore 134
      // 41a2: aload 134
      // 41a4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 41a7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 41aa: new net/minecraft/commands/CommandSourceStack
      // 41ad: dup
      // 41ae: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 41b1: new net/minecraft/world/phys/Vec3
      // 41b4: dup
      // 41b5: dload 2
      // 41b6: dload 4
      // 41b8: dload 6
      // 41ba: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 41bd: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 41c0: aload 134
      // 41c2: bipush 4
      // 41c3: ldc ""
      // 41c5: ldc ""
      // 41c7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 41ca: aload 134
      // 41cc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 41cf: aconst_null
      // 41d0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 41d3: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 41d6: ldc_w "projecte setemc 18000 arphex:chitin"
      // 41d9: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 41dc: pop
      // 41dd: aload 1
      // 41de: instanceof net/minecraft/server/level/ServerLevel
      // 41e1: ifeq 4225
      // 41e4: aload 1
      // 41e5: checkcast net/minecraft/server/level/ServerLevel
      // 41e8: astore 134
      // 41ea: aload 134
      // 41ec: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 41ef: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 41f2: new net/minecraft/commands/CommandSourceStack
      // 41f5: dup
      // 41f6: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 41f9: new net/minecraft/world/phys/Vec3
      // 41fc: dup
      // 41fd: dload 2
      // 41fe: dload 4
      // 4200: dload 6
      // 4202: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4205: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4208: aload 134
      // 420a: bipush 4
      // 420b: ldc ""
      // 420d: ldc ""
      // 420f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4212: aload 134
      // 4214: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4217: aconst_null
      // 4218: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 421b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 421e: ldc_w "projecte setemc 75000 arphex:abyssal_shard"
      // 4221: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4224: pop
      // 4225: aload 1
      // 4226: instanceof net/minecraft/server/level/ServerLevel
      // 4229: ifeq 426d
      // 422c: aload 1
      // 422d: checkcast net/minecraft/server/level/ServerLevel
      // 4230: astore 134
      // 4232: aload 134
      // 4234: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4237: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 423a: new net/minecraft/commands/CommandSourceStack
      // 423d: dup
      // 423e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4241: new net/minecraft/world/phys/Vec3
      // 4244: dup
      // 4245: dload 2
      // 4246: dload 4
      // 4248: dload 6
      // 424a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 424d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4250: aload 134
      // 4252: bipush 4
      // 4253: ldc ""
      // 4255: ldc ""
      // 4257: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 425a: aload 134
      // 425c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 425f: aconst_null
      // 4260: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4263: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4266: ldc_w "projecte setemc 90000 arphex:fire_opal_shard"
      // 4269: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 426c: pop
      // 426d: aload 1
      // 426e: instanceof net/minecraft/server/level/ServerLevel
      // 4271: ifeq 42b5
      // 4274: aload 1
      // 4275: checkcast net/minecraft/server/level/ServerLevel
      // 4278: astore 134
      // 427a: aload 134
      // 427c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 427f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4282: new net/minecraft/commands/CommandSourceStack
      // 4285: dup
      // 4286: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4289: new net/minecraft/world/phys/Vec3
      // 428c: dup
      // 428d: dload 2
      // 428e: dload 4
      // 4290: dload 6
      // 4292: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4295: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4298: aload 134
      // 429a: bipush 4
      // 429b: ldc ""
      // 429d: ldc ""
      // 429f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 42a2: aload 134
      // 42a4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 42a7: aconst_null
      // 42a8: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 42ab: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 42ae: ldc_w "projecte setemc 120000 arphex:void_geode_shard"
      // 42b1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 42b4: pop
      // 42b5: aload 1
      // 42b6: instanceof net/minecraft/server/level/ServerLevel
      // 42b9: ifeq 42fd
      // 42bc: aload 1
      // 42bd: checkcast net/minecraft/server/level/ServerLevel
      // 42c0: astore 134
      // 42c2: aload 134
      // 42c4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 42c7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 42ca: new net/minecraft/commands/CommandSourceStack
      // 42cd: dup
      // 42ce: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 42d1: new net/minecraft/world/phys/Vec3
      // 42d4: dup
      // 42d5: dload 2
      // 42d6: dload 4
      // 42d8: dload 6
      // 42da: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 42dd: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 42e0: aload 134
      // 42e2: bipush 4
      // 42e3: ldc ""
      // 42e5: ldc ""
      // 42e7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 42ea: aload 134
      // 42ec: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 42ef: aconst_null
      // 42f0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 42f3: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 42f6: ldc_w "projecte setemc 150000 arphex:time_prism_shard"
      // 42f9: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 42fc: pop
      // 42fd: aload 1
      // 42fe: instanceof net/minecraft/server/level/ServerLevel
      // 4301: ifeq 4345
      // 4304: aload 1
      // 4305: checkcast net/minecraft/server/level/ServerLevel
      // 4308: astore 134
      // 430a: aload 134
      // 430c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 430f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4312: new net/minecraft/commands/CommandSourceStack
      // 4315: dup
      // 4316: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4319: new net/minecraft/world/phys/Vec3
      // 431c: dup
      // 431d: dload 2
      // 431e: dload 4
      // 4320: dload 6
      // 4322: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4325: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4328: aload 134
      // 432a: bipush 4
      // 432b: ldc ""
      // 432d: ldc ""
      // 432f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4332: aload 134
      // 4334: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4337: aconst_null
      // 4338: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 433b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 433e: ldc_w "projecte setemc 200000 arphex:entropy_matrix_shard"
      // 4341: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4344: pop
      // 4345: aload 1
      // 4346: instanceof net/minecraft/server/level/ServerLevel
      // 4349: ifeq 438d
      // 434c: aload 1
      // 434d: checkcast net/minecraft/server/level/ServerLevel
      // 4350: astore 134
      // 4352: aload 134
      // 4354: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4357: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 435a: new net/minecraft/commands/CommandSourceStack
      // 435d: dup
      // 435e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4361: new net/minecraft/world/phys/Vec3
      // 4364: dup
      // 4365: dload 2
      // 4366: dload 4
      // 4368: dload 6
      // 436a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 436d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4370: aload 134
      // 4372: bipush 4
      // 4373: ldc ""
      // 4375: ldc ""
      // 4377: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 437a: aload 134
      // 437c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 437f: aconst_null
      // 4380: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4383: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4386: ldc_w "projecte setemc 1500 arphex:maggot_grub"
      // 4389: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 438c: pop
      // 438d: aload 1
      // 438e: instanceof net/minecraft/server/level/ServerLevel
      // 4391: ifeq 43d5
      // 4394: aload 1
      // 4395: checkcast net/minecraft/server/level/ServerLevel
      // 4398: astore 134
      // 439a: aload 134
      // 439c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 439f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 43a2: new net/minecraft/commands/CommandSourceStack
      // 43a5: dup
      // 43a6: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 43a9: new net/minecraft/world/phys/Vec3
      // 43ac: dup
      // 43ad: dload 2
      // 43ae: dload 4
      // 43b0: dload 6
      // 43b2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 43b5: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 43b8: aload 134
      // 43ba: bipush 4
      // 43bb: ldc ""
      // 43bd: ldc ""
      // 43bf: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 43c2: aload 134
      // 43c4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 43c7: aconst_null
      // 43c8: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 43cb: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 43ce: ldc_w "projecte setemc 1500 arphex:roach_nymph"
      // 43d1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 43d4: pop
      // 43d5: aload 1
      // 43d6: instanceof net/minecraft/server/level/ServerLevel
      // 43d9: ifeq 441d
      // 43dc: aload 1
      // 43dd: checkcast net/minecraft/server/level/ServerLevel
      // 43e0: astore 134
      // 43e2: aload 134
      // 43e4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 43e7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 43ea: new net/minecraft/commands/CommandSourceStack
      // 43ed: dup
      // 43ee: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 43f1: new net/minecraft/world/phys/Vec3
      // 43f4: dup
      // 43f5: dload 2
      // 43f6: dload 4
      // 43f8: dload 6
      // 43fa: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 43fd: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4400: aload 134
      // 4402: bipush 4
      // 4403: ldc ""
      // 4405: ldc ""
      // 4407: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 440a: aload 134
      // 440c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 440f: aconst_null
      // 4410: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4413: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4416: ldc_w "projecte setemc 1500 arphex:bloodworm_grub"
      // 4419: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 441c: pop
      // 441d: aload 1
      // 441e: instanceof net/minecraft/server/level/ServerLevel
      // 4421: ifeq 4465
      // 4424: aload 1
      // 4425: checkcast net/minecraft/server/level/ServerLevel
      // 4428: astore 134
      // 442a: aload 134
      // 442c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 442f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4432: new net/minecraft/commands/CommandSourceStack
      // 4435: dup
      // 4436: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4439: new net/minecraft/world/phys/Vec3
      // 443c: dup
      // 443d: dload 2
      // 443e: dload 4
      // 4440: dload 6
      // 4442: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4445: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4448: aload 134
      // 444a: bipush 4
      // 444b: ldc ""
      // 444d: ldc ""
      // 444f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4452: aload 134
      // 4454: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4457: aconst_null
      // 4458: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 445b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 445e: ldc_w "projecte setemc 1500 arphex:locust_larvae"
      // 4461: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4464: pop
      // 4465: aload 1
      // 4466: instanceof net/minecraft/server/level/ServerLevel
      // 4469: ifeq 44ad
      // 446c: aload 1
      // 446d: checkcast net/minecraft/server/level/ServerLevel
      // 4470: astore 134
      // 4472: aload 134
      // 4474: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4477: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 447a: new net/minecraft/commands/CommandSourceStack
      // 447d: dup
      // 447e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4481: new net/minecraft/world/phys/Vec3
      // 4484: dup
      // 4485: dload 2
      // 4486: dload 4
      // 4488: dload 6
      // 448a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 448d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4490: aload 134
      // 4492: bipush 4
      // 4493: ldc ""
      // 4495: ldc ""
      // 4497: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 449a: aload 134
      // 449c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 449f: aconst_null
      // 44a0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 44a3: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 44a6: ldc_w "projecte setemc 1500 arphex:burning_glands"
      // 44a9: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 44ac: pop
      // 44ad: aload 1
      // 44ae: instanceof net/minecraft/server/level/ServerLevel
      // 44b1: ifeq 44f5
      // 44b4: aload 1
      // 44b5: checkcast net/minecraft/server/level/ServerLevel
      // 44b8: astore 134
      // 44ba: aload 134
      // 44bc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 44bf: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 44c2: new net/minecraft/commands/CommandSourceStack
      // 44c5: dup
      // 44c6: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 44c9: new net/minecraft/world/phys/Vec3
      // 44cc: dup
      // 44cd: dload 2
      // 44ce: dload 4
      // 44d0: dload 6
      // 44d2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 44d5: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 44d8: aload 134
      // 44da: bipush 4
      // 44db: ldc ""
      // 44dd: ldc ""
      // 44df: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 44e2: aload 134
      // 44e4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 44e7: aconst_null
      // 44e8: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 44eb: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 44ee: ldc_w "projecte setemc 5000 arphex:antenna"
      // 44f1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 44f4: pop
      // 44f5: aload 1
      // 44f6: instanceof net/minecraft/server/level/ServerLevel
      // 44f9: ifeq 453d
      // 44fc: aload 1
      // 44fd: checkcast net/minecraft/server/level/ServerLevel
      // 4500: astore 134
      // 4502: aload 134
      // 4504: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4507: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 450a: new net/minecraft/commands/CommandSourceStack
      // 450d: dup
      // 450e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4511: new net/minecraft/world/phys/Vec3
      // 4514: dup
      // 4515: dload 2
      // 4516: dload 4
      // 4518: dload 6
      // 451a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 451d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4520: aload 134
      // 4522: bipush 4
      // 4523: ldc ""
      // 4525: ldc ""
      // 4527: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 452a: aload 134
      // 452c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 452f: aconst_null
      // 4530: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4533: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4536: ldc_w "projecte setemc 5000 arphex:ectoplasm"
      // 4539: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 453c: pop
      // 453d: aload 1
      // 453e: instanceof net/minecraft/server/level/ServerLevel
      // 4541: ifeq 4585
      // 4544: aload 1
      // 4545: checkcast net/minecraft/server/level/ServerLevel
      // 4548: astore 134
      // 454a: aload 134
      // 454c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 454f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4552: new net/minecraft/commands/CommandSourceStack
      // 4555: dup
      // 4556: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4559: new net/minecraft/world/phys/Vec3
      // 455c: dup
      // 455d: dload 2
      // 455e: dload 4
      // 4560: dload 6
      // 4562: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4565: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4568: aload 134
      // 456a: bipush 4
      // 456b: ldc ""
      // 456d: ldc ""
      // 456f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4572: aload 134
      // 4574: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4577: aconst_null
      // 4578: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 457b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 457e: ldc_w "projecte setemc 6000 arphex:necrotic_fang"
      // 4581: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4584: pop
      // 4585: aload 1
      // 4586: instanceof net/minecraft/server/level/ServerLevel
      // 4589: ifeq 45cd
      // 458c: aload 1
      // 458d: checkcast net/minecraft/server/level/ServerLevel
      // 4590: astore 134
      // 4592: aload 134
      // 4594: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4597: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 459a: new net/minecraft/commands/CommandSourceStack
      // 459d: dup
      // 459e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 45a1: new net/minecraft/world/phys/Vec3
      // 45a4: dup
      // 45a5: dload 2
      // 45a6: dload 4
      // 45a8: dload 6
      // 45aa: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 45ad: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 45b0: aload 134
      // 45b2: bipush 4
      // 45b3: ldc ""
      // 45b5: ldc ""
      // 45b7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 45ba: aload 134
      // 45bc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 45bf: aconst_null
      // 45c0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 45c3: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 45c6: ldc_w "projecte setemc 6000 arphex:venomous_appendage"
      // 45c9: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 45cc: pop
      // 45cd: aload 1
      // 45ce: instanceof net/minecraft/server/level/ServerLevel
      // 45d1: ifeq 4615
      // 45d4: aload 1
      // 45d5: checkcast net/minecraft/server/level/ServerLevel
      // 45d8: astore 134
      // 45da: aload 134
      // 45dc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 45df: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 45e2: new net/minecraft/commands/CommandSourceStack
      // 45e5: dup
      // 45e6: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 45e9: new net/minecraft/world/phys/Vec3
      // 45ec: dup
      // 45ed: dload 2
      // 45ee: dload 4
      // 45f0: dload 6
      // 45f2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 45f5: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 45f8: aload 134
      // 45fa: bipush 4
      // 45fb: ldc ""
      // 45fd: ldc ""
      // 45ff: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4602: aload 134
      // 4604: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4607: aconst_null
      // 4608: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 460b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 460e: ldc_w "projecte setemc 20000 arphex:fly_appendage"
      // 4611: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4614: pop
      // 4615: aload 1
      // 4616: instanceof net/minecraft/server/level/ServerLevel
      // 4619: ifeq 465d
      // 461c: aload 1
      // 461d: checkcast net/minecraft/server/level/ServerLevel
      // 4620: astore 134
      // 4622: aload 134
      // 4624: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4627: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 462a: new net/minecraft/commands/CommandSourceStack
      // 462d: dup
      // 462e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4631: new net/minecraft/world/phys/Vec3
      // 4634: dup
      // 4635: dload 2
      // 4636: dload 4
      // 4638: dload 6
      // 463a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 463d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4640: aload 134
      // 4642: bipush 4
      // 4643: ldc ""
      // 4645: ldc ""
      // 4647: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 464a: aload 134
      // 464c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 464f: aconst_null
      // 4650: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4653: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4656: ldc_w "projecte setemc 75000 arphex:giant_spinneret"
      // 4659: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 465c: pop
      // 465d: aload 1
      // 465e: instanceof net/minecraft/server/level/ServerLevel
      // 4661: ifeq 46a5
      // 4664: aload 1
      // 4665: checkcast net/minecraft/server/level/ServerLevel
      // 4668: astore 134
      // 466a: aload 134
      // 466c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 466f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4672: new net/minecraft/commands/CommandSourceStack
      // 4675: dup
      // 4676: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4679: new net/minecraft/world/phys/Vec3
      // 467c: dup
      // 467d: dload 2
      // 467e: dload 4
      // 4680: dload 6
      // 4682: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4685: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4688: aload 134
      // 468a: bipush 4
      // 468b: ldc ""
      // 468d: ldc ""
      // 468f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4692: aload 134
      // 4694: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4697: aconst_null
      // 4698: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 469b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 469e: ldc_w "projecte setemc 150000 arphex:crusher_claw"
      // 46a1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 46a4: pop
      // 46a5: aload 1
      // 46a6: instanceof net/minecraft/server/level/ServerLevel
      // 46a9: ifeq 46ed
      // 46ac: aload 1
      // 46ad: checkcast net/minecraft/server/level/ServerLevel
      // 46b0: astore 134
      // 46b2: aload 134
      // 46b4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 46b7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 46ba: new net/minecraft/commands/CommandSourceStack
      // 46bd: dup
      // 46be: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 46c1: new net/minecraft/world/phys/Vec3
      // 46c4: dup
      // 46c5: dload 2
      // 46c6: dload 4
      // 46c8: dload 6
      // 46ca: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 46cd: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 46d0: aload 134
      // 46d2: bipush 4
      // 46d3: ldc ""
      // 46d5: ldc ""
      // 46d7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 46da: aload 134
      // 46dc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 46df: aconst_null
      // 46e0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 46e3: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 46e6: ldc_w "projecte setemc 6000 arphex:brown_scarab"
      // 46e9: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 46ec: pop
      // 46ed: aload 1
      // 46ee: instanceof net/minecraft/server/level/ServerLevel
      // 46f1: ifeq 4735
      // 46f4: aload 1
      // 46f5: checkcast net/minecraft/server/level/ServerLevel
      // 46f8: astore 134
      // 46fa: aload 134
      // 46fc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 46ff: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4702: new net/minecraft/commands/CommandSourceStack
      // 4705: dup
      // 4706: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4709: new net/minecraft/world/phys/Vec3
      // 470c: dup
      // 470d: dload 2
      // 470e: dload 4
      // 4710: dload 6
      // 4712: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4715: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4718: aload 134
      // 471a: bipush 4
      // 471b: ldc ""
      // 471d: ldc ""
      // 471f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4722: aload 134
      // 4724: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4727: aconst_null
      // 4728: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 472b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 472e: ldc_w "projecte setemc 12000 arphex:green_scarab"
      // 4731: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4734: pop
      // 4735: aload 1
      // 4736: instanceof net/minecraft/server/level/ServerLevel
      // 4739: ifeq 477d
      // 473c: aload 1
      // 473d: checkcast net/minecraft/server/level/ServerLevel
      // 4740: astore 134
      // 4742: aload 134
      // 4744: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4747: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 474a: new net/minecraft/commands/CommandSourceStack
      // 474d: dup
      // 474e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4751: new net/minecraft/world/phys/Vec3
      // 4754: dup
      // 4755: dload 2
      // 4756: dload 4
      // 4758: dload 6
      // 475a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 475d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4760: aload 134
      // 4762: bipush 4
      // 4763: ldc ""
      // 4765: ldc ""
      // 4767: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 476a: aload 134
      // 476c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 476f: aconst_null
      // 4770: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4773: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4776: ldc_w "projecte setemc 20000 arphex:green_gold_scarab"
      // 4779: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 477c: pop
      // 477d: aload 1
      // 477e: instanceof net/minecraft/server/level/ServerLevel
      // 4781: ifeq 47c5
      // 4784: aload 1
      // 4785: checkcast net/minecraft/server/level/ServerLevel
      // 4788: astore 134
      // 478a: aload 134
      // 478c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 478f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4792: new net/minecraft/commands/CommandSourceStack
      // 4795: dup
      // 4796: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4799: new net/minecraft/world/phys/Vec3
      // 479c: dup
      // 479d: dload 2
      // 479e: dload 4
      // 47a0: dload 6
      // 47a2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 47a5: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 47a8: aload 134
      // 47aa: bipush 4
      // 47ab: ldc ""
      // 47ad: ldc ""
      // 47af: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 47b2: aload 134
      // 47b4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 47b7: aconst_null
      // 47b8: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 47bb: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 47be: ldc_w "projecte setemc 48000 arphex:green_gold_scarab"
      // 47c1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 47c4: pop
      // 47c5: aload 1
      // 47c6: instanceof net/minecraft/server/level/ServerLevel
      // 47c9: ifeq 480d
      // 47cc: aload 1
      // 47cd: checkcast net/minecraft/server/level/ServerLevel
      // 47d0: astore 134
      // 47d2: aload 134
      // 47d4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 47d7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 47da: new net/minecraft/commands/CommandSourceStack
      // 47dd: dup
      // 47de: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 47e1: new net/minecraft/world/phys/Vec3
      // 47e4: dup
      // 47e5: dload 2
      // 47e6: dload 4
      // 47e8: dload 6
      // 47ea: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 47ed: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 47f0: aload 134
      // 47f2: bipush 4
      // 47f3: ldc ""
      // 47f5: ldc ""
      // 47f7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 47fa: aload 134
      // 47fc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 47ff: aconst_null
      // 4800: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4803: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4806: ldc_w "projecte setemc 100000 arphex:iridescent_scarab"
      // 4809: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 480c: pop
      // 480d: aload 1
      // 480e: instanceof net/minecraft/server/level/ServerLevel
      // 4811: ifeq 4855
      // 4814: aload 1
      // 4815: checkcast net/minecraft/server/level/ServerLevel
      // 4818: astore 134
      // 481a: aload 134
      // 481c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 481f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4822: new net/minecraft/commands/CommandSourceStack
      // 4825: dup
      // 4826: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4829: new net/minecraft/world/phys/Vec3
      // 482c: dup
      // 482d: dload 2
      // 482e: dload 4
      // 4830: dload 6
      // 4832: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4835: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4838: aload 134
      // 483a: bipush 4
      // 483b: ldc ""
      // 483d: ldc ""
      // 483f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4842: aload 134
      // 4844: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4847: aconst_null
      // 4848: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 484b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 484e: ldc_w "projecte setemc 200000 arphex:purple_scarab"
      // 4851: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4854: pop
      // 4855: aload 1
      // 4856: instanceof net/minecraft/server/level/ServerLevel
      // 4859: ifeq 489d
      // 485c: aload 1
      // 485d: checkcast net/minecraft/server/level/ServerLevel
      // 4860: astore 134
      // 4862: aload 134
      // 4864: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4867: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 486a: new net/minecraft/commands/CommandSourceStack
      // 486d: dup
      // 486e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4871: new net/minecraft/world/phys/Vec3
      // 4874: dup
      // 4875: dload 2
      // 4876: dload 4
      // 4878: dload 6
      // 487a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 487d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4880: aload 134
      // 4882: bipush 4
      // 4883: ldc ""
      // 4885: ldc ""
      // 4887: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 488a: aload 134
      // 488c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 488f: aconst_null
      // 4890: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4893: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4896: ldc_w "projecte setemc 350000 arphex:golden_scarab"
      // 4899: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 489c: pop
      // 489d: aload 1
      // 489e: instanceof net/minecraft/server/level/ServerLevel
      // 48a1: ifeq 48e5
      // 48a4: aload 1
      // 48a5: checkcast net/minecraft/server/level/ServerLevel
      // 48a8: astore 134
      // 48aa: aload 134
      // 48ac: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 48af: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 48b2: new net/minecraft/commands/CommandSourceStack
      // 48b5: dup
      // 48b6: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 48b9: new net/minecraft/world/phys/Vec3
      // 48bc: dup
      // 48bd: dload 2
      // 48be: dload 4
      // 48c0: dload 6
      // 48c2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 48c5: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 48c8: aload 134
      // 48ca: bipush 4
      // 48cb: ldc ""
      // 48cd: ldc ""
      // 48cf: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 48d2: aload 134
      // 48d4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 48d7: aconst_null
      // 48d8: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 48db: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 48de: ldc_w "projecte setemc 600 arphex:crawling_clay"
      // 48e1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 48e4: pop
      // 48e5: aload 1
      // 48e6: instanceof net/minecraft/server/level/ServerLevel
      // 48e9: ifeq 492d
      // 48ec: aload 1
      // 48ed: checkcast net/minecraft/server/level/ServerLevel
      // 48f0: astore 134
      // 48f2: aload 134
      // 48f4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 48f7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 48fa: new net/minecraft/commands/CommandSourceStack
      // 48fd: dup
      // 48fe: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4901: new net/minecraft/world/phys/Vec3
      // 4904: dup
      // 4905: dload 2
      // 4906: dload 4
      // 4908: dload 6
      // 490a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 490d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4910: aload 134
      // 4912: bipush 4
      // 4913: ldc ""
      // 4915: ldc ""
      // 4917: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 491a: aload 134
      // 491c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 491f: aconst_null
      // 4920: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4923: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4926: ldc_w "projecte setemc 600 arphex:decadent_dust"
      // 4929: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 492c: pop
      // 492d: aload 1
      // 492e: instanceof net/minecraft/server/level/ServerLevel
      // 4931: ifeq 4975
      // 4934: aload 1
      // 4935: checkcast net/minecraft/server/level/ServerLevel
      // 4938: astore 134
      // 493a: aload 134
      // 493c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 493f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4942: new net/minecraft/commands/CommandSourceStack
      // 4945: dup
      // 4946: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4949: new net/minecraft/world/phys/Vec3
      // 494c: dup
      // 494d: dload 2
      // 494e: dload 4
      // 4950: dload 6
      // 4952: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4955: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4958: aload 134
      // 495a: bipush 4
      // 495b: ldc ""
      // 495d: ldc ""
      // 495f: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4962: aload 134
      // 4964: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4967: aconst_null
      // 4968: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 496b: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 496e: ldc_w "projecte setemc 98000 arphex:tectonic_tunneler"
      // 4971: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4974: pop
      // 4975: aload 1
      // 4976: instanceof net/minecraft/server/level/ServerLevel
      // 4979: ifeq 49bd
      // 497c: aload 1
      // 497d: checkcast net/minecraft/server/level/ServerLevel
      // 4980: astore 134
      // 4982: aload 134
      // 4984: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4987: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 498a: new net/minecraft/commands/CommandSourceStack
      // 498d: dup
      // 498e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4991: new net/minecraft/world/phys/Vec3
      // 4994: dup
      // 4995: dload 2
      // 4996: dload 4
      // 4998: dload 6
      // 499a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 499d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 49a0: aload 134
      // 49a2: bipush 4
      // 49a3: ldc ""
      // 49a5: ldc ""
      // 49a7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 49aa: aload 134
      // 49ac: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 49af: aconst_null
      // 49b0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 49b3: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 49b6: ldc_w "projecte setemc 30000 arphex:prowler_pack"
      // 49b9: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 49bc: pop
      // 49bd: aload 1
      // 49be: instanceof net/minecraft/server/level/ServerLevel
      // 49c1: ifeq 4a05
      // 49c4: aload 1
      // 49c5: checkcast net/minecraft/server/level/ServerLevel
      // 49c8: astore 134
      // 49ca: aload 134
      // 49cc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 49cf: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 49d2: new net/minecraft/commands/CommandSourceStack
      // 49d5: dup
      // 49d6: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 49d9: new net/minecraft/world/phys/Vec3
      // 49dc: dup
      // 49dd: dload 2
      // 49de: dload 4
      // 49e0: dload 6
      // 49e2: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 49e5: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 49e8: aload 134
      // 49ea: bipush 4
      // 49eb: ldc ""
      // 49ed: ldc ""
      // 49ef: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 49f2: aload 134
      // 49f4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 49f7: aconst_null
      // 49f8: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 49fb: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 49fe: ldc_w "projecte setemc 150000 arphex:heavy_chitin"
      // 4a01: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4a04: pop
      // 4a05: aload 1
      // 4a06: instanceof net/minecraft/server/level/ServerLevel
      // 4a09: ifeq 4a4d
      // 4a0c: aload 1
      // 4a0d: checkcast net/minecraft/server/level/ServerLevel
      // 4a10: astore 134
      // 4a12: aload 134
      // 4a14: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4a17: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4a1a: new net/minecraft/commands/CommandSourceStack
      // 4a1d: dup
      // 4a1e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4a21: new net/minecraft/world/phys/Vec3
      // 4a24: dup
      // 4a25: dload 2
      // 4a26: dload 4
      // 4a28: dload 6
      // 4a2a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4a2d: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4a30: aload 134
      // 4a32: bipush 4
      // 4a33: ldc ""
      // 4a35: ldc ""
      // 4a37: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4a3a: aload 134
      // 4a3c: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4a3f: aconst_null
      // 4a40: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4a43: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4a46: ldc_w "projecte setemc 1000 arphex:raw_hemolymph"
      // 4a49: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4a4c: pop
      // 4a4d: aload 8
      // 4a4f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4a52: ldc_w "creativespectator"
      // 4a55: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 4a58: ifeq 4a93
      // 4a5b: aload 8
      // 4a5d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4a60: ldc_w "tormentor_target"
      // 4a63: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 4a66: ifeq 4a75
      // 4a69: aload 8
      // 4a6b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4a6e: ldc_w "tormentor_target"
      // 4a71: bipush 0
      // 4a72: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 4a75: aload 8
      // 4a77: instanceof net/minecraft/world/entity/LivingEntity
      // 4a7a: ifeq 4a93
      // 4a7d: aload 8
      // 4a7f: checkcast net/minecraft/world/entity/LivingEntity
      // 4a82: astore 134
      // 4a84: aload 134
      // 4a86: getstatic net/arphex/init/ArphexModMobEffects.TORMENTOR_PRIMARY_TARGET Lnet/minecraftforge/registries/RegistryObject;
      // 4a89: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4a8c: checkcast net/minecraft/world/effect/MobEffect
      // 4a8f: invokevirtual net/minecraft/world/entity/LivingEntity.removeEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 4a92: pop
      // 4a93: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_SHADERS Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 4a96: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 4a99: checkcast java/lang/Boolean
      // 4a9c: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 4a9f: ifeq 4c01
      // 4aa2: aload 8
      // 4aa4: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4aa7: aconst_null
      // 4aa8: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4aab: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4aae: dup
      // 4aaf: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4ab2: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4ab5: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4ab8: getfield net/arphex/network/ArphexModVariables$PlayerVariables.shadertime D
      // 4abb: dconst_0
      // 4abc: dcmpl
      // 4abd: ifle 4af2
      // 4ac0: aload 8
      // 4ac2: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4ac5: aconst_null
      // 4ac6: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4ac9: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4acc: dup
      // 4acd: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4ad0: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4ad3: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4ad6: getfield net/arphex/network/ArphexModVariables$PlayerVariables.shadertime D
      // 4ad9: dconst_1
      // 4ada: dsub
      // 4adb: dstore 134
      // 4add: aload 8
      // 4adf: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4ae2: aconst_null
      // 4ae3: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4ae6: dload 134
      // 4ae8: aload 8
      // 4aea: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$89 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4aef: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4af2: aload 8
      // 4af4: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4af7: aconst_null
      // 4af8: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4afb: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4afe: dup
      // 4aff: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4b02: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4b05: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4b08: getfield net/arphex/network/ArphexModVariables$PlayerVariables.shader2 D
      // 4b0b: dconst_0
      // 4b0c: dcmpl
      // 4b0d: ifle 4b42
      // 4b10: aload 8
      // 4b12: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4b15: aconst_null
      // 4b16: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4b19: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4b1c: dup
      // 4b1d: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4b20: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4b23: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4b26: getfield net/arphex/network/ArphexModVariables$PlayerVariables.shader2 D
      // 4b29: dconst_1
      // 4b2a: dsub
      // 4b2b: dstore 134
      // 4b2d: aload 8
      // 4b2f: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4b32: aconst_null
      // 4b33: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4b36: dload 134
      // 4b38: aload 8
      // 4b3a: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$90 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4b3f: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4b42: aload 1
      // 4b43: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 4b48: ifeq 4c01
      // 4b4b: ldc_w "1.20.1"
      // 4b4e: ldc_w "1.21."
      // 4b51: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 4b54: ifne 4c01
      // 4b57: aload 8
      // 4b59: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4b5c: aconst_null
      // 4b5d: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4b60: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4b63: dup
      // 4b64: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4b67: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4b6a: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4b6d: getfield net/arphex/network/ArphexModVariables$PlayerVariables.shadertime D
      // 4b70: dconst_0
      // 4b71: dcmpl
      // 4b72: ifle 4ba0
      // 4b75: iload 13
      // 4b77: bipush 1
      // 4b78: if_icmpeq 4ba0
      // 4b7b: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 4b7e: getfield net/minecraft/client/Minecraft.gameRenderer Lnet/minecraft/client/renderer/GameRenderer;
      // 4b81: invokevirtual net/minecraft/client/renderer/GameRenderer.currentEffect ()Lnet/minecraft/client/renderer/PostChain;
      // 4b84: ifnonnull 4c01
      // 4b87: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 4b8a: getfield net/minecraft/client/Minecraft.gameRenderer Lnet/minecraft/client/renderer/GameRenderer;
      // 4b8d: new net/minecraft/resources/ResourceLocation
      // 4b90: dup
      // 4b91: ldc_w "minecraft:shaders/post/phosphor.json"
      // 4b94: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4b97: invokevirtual net/minecraft/client/renderer/GameRenderer.loadEffect (Lnet/minecraft/resources/ResourceLocation;)V
      // 4b9a: bipush 1
      // 4b9b: istore 13
      // 4b9d: goto 4c01
      // 4ba0: aload 8
      // 4ba2: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4ba5: aconst_null
      // 4ba6: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4ba9: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4bac: dup
      // 4bad: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4bb0: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4bb3: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4bb6: getfield net/arphex/network/ArphexModVariables$PlayerVariables.shader2 D
      // 4bb9: dconst_0
      // 4bba: dcmpl
      // 4bbb: ifle 4be9
      // 4bbe: iload 13
      // 4bc0: bipush 1
      // 4bc1: if_icmpeq 4be9
      // 4bc4: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 4bc7: getfield net/minecraft/client/Minecraft.gameRenderer Lnet/minecraft/client/renderer/GameRenderer;
      // 4bca: invokevirtual net/minecraft/client/renderer/GameRenderer.currentEffect ()Lnet/minecraft/client/renderer/PostChain;
      // 4bcd: ifnonnull 4c01
      // 4bd0: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 4bd3: getfield net/minecraft/client/Minecraft.gameRenderer Lnet/minecraft/client/renderer/GameRenderer;
      // 4bd6: new net/minecraft/resources/ResourceLocation
      // 4bd9: dup
      // 4bda: ldc_w "minecraft:shaders/post/desaturate.json"
      // 4bdd: invokespecial net/minecraft/resources/ResourceLocation.<init> (Ljava/lang/String;)V
      // 4be0: invokevirtual net/minecraft/client/renderer/GameRenderer.loadEffect (Lnet/minecraft/resources/ResourceLocation;)V
      // 4be3: bipush 1
      // 4be4: istore 13
      // 4be6: goto 4c01
      // 4be9: bipush 0
      // 4bea: istore 13
      // 4bec: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 4bef: getfield net/minecraft/client/Minecraft.gameRenderer Lnet/minecraft/client/renderer/GameRenderer;
      // 4bf2: invokevirtual net/minecraft/client/renderer/GameRenderer.currentEffect ()Lnet/minecraft/client/renderer/PostChain;
      // 4bf5: ifnull 4c01
      // 4bf8: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 4bfb: getfield net/minecraft/client/Minecraft.gameRenderer Lnet/minecraft/client/renderer/GameRenderer;
      // 4bfe: invokevirtual net/minecraft/client/renderer/GameRenderer.shutdownEffect ()V
      // 4c01: aload 8
      // 4c03: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4c06: aconst_null
      // 4c07: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4c0a: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4c0d: dup
      // 4c0e: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4c11: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4c14: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4c17: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentorjustdiednearby D
      // 4c1a: dconst_0
      // 4c1b: dcmpl
      // 4c1c: ifle 4e6f
      // 4c1f: aload 8
      // 4c21: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4c24: aconst_null
      // 4c25: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4c28: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4c2b: dup
      // 4c2c: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4c2f: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4c32: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4c35: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentorjustdiednearby D
      // 4c38: dconst_1
      // 4c39: dsub
      // 4c3a: dstore 134
      // 4c3c: aload 8
      // 4c3e: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4c41: aconst_null
      // 4c42: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4c45: dload 134
      // 4c47: aload 8
      // 4c49: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$91 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4c4e: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4c51: new net/minecraft/world/phys/Vec3
      // 4c54: dup
      // 4c55: dload 2
      // 4c56: dload 4
      // 4c58: dload 6
      // 4c5a: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4c5d: astore 134
      // 4c5f: aload 1
      // 4c60: ldc net/minecraft/world/entity/Entity
      // 4c62: new net/minecraft/world/phys/AABB
      // 4c65: dup
      // 4c66: aload 134
      // 4c68: aload 134
      // 4c6a: invokespecial net/minecraft/world/phys/AABB.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V
      // 4c6d: ldc2_w 100.0
      // 4c70: invokevirtual net/minecraft/world/phys/AABB.inflate (D)Lnet/minecraft/world/phys/AABB;
      // 4c73: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$92 (Lnet/minecraft/world/entity/Entity;)Z, (Lnet/minecraft/world/entity/Entity;)Z ]
      // 4c78: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 4c7d: invokeinterface java/util/List.stream ()Ljava/util/stream/Stream; 1
      // 4c82: aload 134
      // 4c84: invokedynamic applyAsDouble (Lnet/minecraft/world/phys/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$93 (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)D, (Lnet/minecraft/world/entity/Entity;)D ]
      // 4c89: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 4c8c: invokeinterface java/util/stream/Stream.sorted (Ljava/util/Comparator;)Ljava/util/stream/Stream; 2
      // 4c91: invokeinterface java/util/stream/Stream.toList ()Ljava/util/List; 1
      // 4c96: astore 135
      // 4c98: aload 135
      // 4c9a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 4c9f: astore 136
      // 4ca1: aload 136
      // 4ca3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 4ca8: ifeq 4e6f
      // 4cab: aload 136
      // 4cad: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4cb2: checkcast net/minecraft/world/entity/Entity
      // 4cb5: astore 137
      // 4cb7: aload 137
      // 4cb9: instanceof net/minecraft/world/entity/item/ItemEntity
      // 4cbc: ifeq 4e6c
      // 4cbf: aload 137
      // 4cc1: instanceof net/minecraft/world/entity/item/ItemEntity
      // 4cc4: ifeq 4cd6
      // 4cc7: aload 137
      // 4cc9: checkcast net/minecraft/world/entity/item/ItemEntity
      // 4ccc: astore 138
      // 4cce: aload 138
      // 4cd0: invokevirtual net/minecraft/world/entity/item/ItemEntity.getItem ()Lnet/minecraft/world/item/ItemStack;
      // 4cd3: goto 4cd9
      // 4cd6: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 4cd9: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 4cdc: getstatic net/arphex/init/ArphexModItems.CORE_OF_ETERNAL_SUFFERING Lnet/minecraftforge/registries/RegistryObject;
      // 4cdf: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4ce2: if_acmpne 4e6c
      // 4ce5: aload 1
      // 4ce6: instanceof net/minecraft/server/level/ServerLevel
      // 4ce9: ifeq 4d37
      // 4cec: aload 1
      // 4ced: checkcast net/minecraft/server/level/ServerLevel
      // 4cf0: astore 139
      // 4cf2: aload 139
      // 4cf4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4cf7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4cfa: new net/minecraft/commands/CommandSourceStack
      // 4cfd: dup
      // 4cfe: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4d01: new net/minecraft/world/phys/Vec3
      // 4d04: dup
      // 4d05: aload 137
      // 4d07: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4d0a: aload 137
      // 4d0c: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4d0f: aload 137
      // 4d11: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4d14: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4d17: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4d1a: aload 139
      // 4d1c: bipush 4
      // 4d1d: ldc ""
      // 4d1f: ldc ""
      // 4d21: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4d24: aload 139
      // 4d26: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4d29: aconst_null
      // 4d2a: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4d2d: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4d30: ldc_w "particle arphex:tormentor_smoke ~ ~ ~ 0.3 5 0.3 0 1 force"
      // 4d33: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4d36: pop
      // 4d37: aload 1
      // 4d38: instanceof net/minecraft/server/level/ServerLevel
      // 4d3b: ifeq 4d89
      // 4d3e: aload 1
      // 4d3f: checkcast net/minecraft/server/level/ServerLevel
      // 4d42: astore 139
      // 4d44: aload 139
      // 4d46: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4d49: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4d4c: new net/minecraft/commands/CommandSourceStack
      // 4d4f: dup
      // 4d50: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4d53: new net/minecraft/world/phys/Vec3
      // 4d56: dup
      // 4d57: aload 137
      // 4d59: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4d5c: aload 137
      // 4d5e: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4d61: aload 137
      // 4d63: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4d66: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4d69: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4d6c: aload 139
      // 4d6e: bipush 4
      // 4d6f: ldc ""
      // 4d71: ldc ""
      // 4d73: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4d76: aload 139
      // 4d78: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4d7b: aconst_null
      // 4d7c: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4d7f: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4d82: ldc_w "particle arphex:white_glow_smoke ~ ~ ~ 0.3 0.8 0.3 0 1 force"
      // 4d85: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4d88: pop
      // 4d89: aload 1
      // 4d8a: instanceof net/minecraft/server/level/ServerLevel
      // 4d8d: ifeq 4ddb
      // 4d90: aload 1
      // 4d91: checkcast net/minecraft/server/level/ServerLevel
      // 4d94: astore 139
      // 4d96: aload 139
      // 4d98: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4d9b: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4d9e: new net/minecraft/commands/CommandSourceStack
      // 4da1: dup
      // 4da2: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4da5: new net/minecraft/world/phys/Vec3
      // 4da8: dup
      // 4da9: aload 137
      // 4dab: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 4dae: aload 137
      // 4db0: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 4db3: aload 137
      // 4db5: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 4db8: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4dbb: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 4dbe: aload 139
      // 4dc0: bipush 4
      // 4dc1: ldc ""
      // 4dc3: ldc ""
      // 4dc5: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4dc8: aload 139
      // 4dca: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4dcd: aconst_null
      // 4dce: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4dd1: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 4dd4: ldc_w "particle arphex:solid_core ~ ~ ~ 0 0 0 0 1 force"
      // 4dd7: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4dda: pop
      // 4ddb: aload 8
      // 4ddd: instanceof net/minecraft/world/entity/player/Player
      // 4de0: ifeq 4e01
      // 4de3: aload 8
      // 4de5: checkcast net/minecraft/world/entity/player/Player
      // 4de8: astore 139
      // 4dea: aload 139
      // 4dec: invokevirtual net/minecraft/world/entity/player/Player.level ()Lnet/minecraft/world/level/Level;
      // 4def: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4df2: ifne 4e01
      // 4df5: aload 139
      // 4df7: ldc_w "§c§lYour reward is nearby... Be careful handling it"
      // 4dfa: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4dfd: bipush 1
      // 4dfe: invokevirtual net/minecraft/world/entity/player/Player.displayClientMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 4e01: aload 137
      // 4e03: astore 139
      // 4e05: aload 139
      // 4e07: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 4e0a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 4e0d: ifne 4e6c
      // 4e10: aload 139
      // 4e12: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4e15: ifnull 4e6c
      // 4e18: aload 139
      // 4e1a: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4e1d: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 4e20: new net/minecraft/commands/CommandSourceStack
      // 4e23: dup
      // 4e24: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 4e27: aload 139
      // 4e29: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 4e2c: aload 139
      // 4e2e: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 4e31: aload 139
      // 4e33: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 4e36: instanceof net/minecraft/server/level/ServerLevel
      // 4e39: ifeq 4e47
      // 4e3c: aload 139
      // 4e3e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 4e41: checkcast net/minecraft/server/level/ServerLevel
      // 4e44: goto 4e48
      // 4e47: aconst_null
      // 4e48: bipush 4
      // 4e49: aload 139
      // 4e4b: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 4e4e: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 4e53: aload 139
      // 4e55: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 4e58: aload 139
      // 4e5a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 4e5d: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 4e60: aload 139
      // 4e62: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 4e65: ldc_w "data merge entity @s {Glowing:1b,Invulnerable:1b}"
      // 4e68: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 4e6b: pop
      // 4e6c: goto 4ca1
      // 4e6f: aload 1
      // 4e70: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4e73: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 4e76: dconst_0
      // 4e77: dcmpl
      // 4e78: ifle 5052
      // 4e7b: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.DISABLE_TORMENTOR Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 4e7e: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 4e81: checkcast java/lang/Boolean
      // 4e84: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 4e87: ifne 4ea8
      // 4e8a: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.DWELLERS_INCLUSION Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 4e8d: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 4e90: checkcast java/lang/Boolean
      // 4e93: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 4e96: ifeq 4ea8
      // 4e99: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.ALL_ENTITY_INCLUSION Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 4e9c: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 4e9f: checkcast java/lang/Boolean
      // 4ea2: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 4ea5: ifne 4eb8
      // 4ea8: aload 1
      // 4ea9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4eac: dconst_0
      // 4ead: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 4eb0: aload 1
      // 4eb1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4eb4: aload 1
      // 4eb5: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 4eb8: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.DWELLER_HEALTH Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 4ebb: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 4ebe: checkcast java/lang/Boolean
      // 4ec1: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 4ec4: ifeq 4ee7
      // 4ec7: aload 1
      // 4ec8: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4ecb: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 4ece: ldc2_w 60.0
      // 4ed1: dcmpl
      // 4ed2: ifle 4ee7
      // 4ed5: aload 1
      // 4ed6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4ed9: ldc2_w 60.0
      // 4edc: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 4edf: aload 1
      // 4ee0: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4ee3: aload 1
      // 4ee4: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 4ee7: aload 1
      // 4ee8: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4eeb: bipush 1
      // 4eec: putfield net/arphex/network/ArphexModVariables$MapVariables.full_tormentor_has_previously_spawned Z
      // 4eef: aload 1
      // 4ef0: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4ef3: aload 1
      // 4ef4: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 4ef7: aload 8
      // 4ef9: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4efc: aconst_null
      // 4efd: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4f00: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4f03: dup
      // 4f04: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4f07: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4f0a: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4f0d: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_respite D
      // 4f10: dconst_0
      // 4f11: dcmpl
      // 4f12: ifle 4f47
      // 4f15: aload 8
      // 4f17: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4f1a: aconst_null
      // 4f1b: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4f1e: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 4f21: dup
      // 4f22: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 4f25: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 4f28: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 4f2b: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_respite D
      // 4f2e: dconst_1
      // 4f2f: dsub
      // 4f30: dstore 134
      // 4f32: aload 8
      // 4f34: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 4f37: aconst_null
      // 4f38: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 4f3b: dload 134
      // 4f3d: aload 8
      // 4f3f: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$94 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 4f44: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 4f47: aload 8
      // 4f49: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4f4c: ldc_w "failed_tormentor_find_attempts"
      // 4f4f: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 4f52: ldc2_w 10.0
      // 4f55: dcmpl
      // 4f56: ifle 5149
      // 4f59: aload 8
      // 4f5b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 4f5e: ldc_w "failed_tormentor_find_attempts"
      // 4f61: dconst_0
      // 4f62: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 4f65: aload 1
      // 4f66: ldc net/minecraft/world/entity/player/Player
      // 4f68: new net/minecraft/world/phys/Vec3
      // 4f6b: dup
      // 4f6c: aload 1
      // 4f6d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4f70: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 4f73: aload 1
      // 4f74: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4f77: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 4f7a: aload 1
      // 4f7b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4f7e: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 4f81: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 4f84: ldc2_w 50.0
      // 4f87: ldc2_w 50.0
      // 4f8a: ldc2_w 50.0
      // 4f8d: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 4f90: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$95 (Lnet/minecraft/world/entity/player/Player;)Z, (Lnet/minecraft/world/entity/player/Player;)Z ]
      // 4f95: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 4f9a: invokeinterface java/util/List.isEmpty ()Z 1
      // 4f9f: ifeq 5149
      // 4fa2: aload 8
      // 4fa4: instanceof net/minecraft/world/entity/LivingEntity
      // 4fa7: ifeq 4ffe
      // 4faa: aload 8
      // 4fac: checkcast net/minecraft/world/entity/LivingEntity
      // 4faf: astore 134
      // 4fb1: aload 134
      // 4fb3: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 4fb6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 4fb9: checkcast net/minecraft/world/effect/MobEffect
      // 4fbc: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 4fbf: ifeq 4ffe
      // 4fc2: aload 1
      // 4fc3: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 4fc8: ifne 4ffe
      // 4fcb: aload 1
      // 4fcc: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 4fd1: ifnull 4ffe
      // 4fd4: aload 1
      // 4fd5: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 4fda: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 4fdd: aload 1
      // 4fde: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4fe1: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 4fe4: aload 1
      // 4fe5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4fe8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 4feb: aload 1
      // 4fec: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 4fef: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 4ff2: invokedynamic makeConcatWithConstants (DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Spawned new entity at x=\u0001, y=\u0001, z=\u0001" ]
      // 4ff7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 4ffa: bipush 0
      // 4ffb: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 4ffe: aload 1
      // 4fff: instanceof net/minecraft/server/level/ServerLevel
      // 5002: ifeq 504f
      // 5005: aload 1
      // 5006: checkcast net/minecraft/server/level/ServerLevel
      // 5009: astore 134
      // 500b: getstatic net/arphex/init/ArphexModEntities.TORMENTOR Lnet/minecraftforge/registries/RegistryObject;
      // 500e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5011: checkcast net/minecraft/world/entity/EntityType
      // 5014: aload 134
      // 5016: aload 1
      // 5017: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 501a: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 501d: aload 1
      // 501e: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5021: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5024: aload 1
      // 5025: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5028: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 502b: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 502e: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED Lnet/minecraft/world/entity/MobSpawnType;
      // 5031: invokevirtual net/minecraft/world/entity/EntityType.spawn (Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;
      // 5034: astore 135
      // 5036: aload 135
      // 5038: ifnull 504f
      // 503b: aload 135
      // 503d: aload 1
      // 503e: invokeinterface net/minecraft/world/level/LevelAccessor.getRandom ()Lnet/minecraft/util/RandomSource; 1
      // 5043: invokeinterface net/minecraft/util/RandomSource.nextFloat ()F 1
      // 5048: ldc_w 360.0
      // 504b: fmul
      // 504c: invokevirtual net/minecraft/world/entity/Entity.setYRot (F)V
      // 504f: goto 5149
      // 5052: aload 1
      // 5053: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5056: getfield net/arphex/network/ArphexModVariables$MapVariables.chunk_removal_complete Z
      // 5059: ifne 5149
      // 505c: aload 1
      // 505d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5060: getfield net/arphex/network/ArphexModVariables$MapVariables.force_unload_repeats D
      // 5063: dconst_0
      // 5064: dcmpl
      // 5065: ifle 5149
      // 5068: aload 1
      // 5069: instanceof net/minecraft/server/level/ServerLevel
      // 506c: ifeq 50ce
      // 506f: aload 1
      // 5070: checkcast net/minecraft/server/level/ServerLevel
      // 5073: astore 134
      // 5075: aload 134
      // 5077: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 507a: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 507d: new net/minecraft/commands/CommandSourceStack
      // 5080: dup
      // 5081: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 5084: new net/minecraft/world/phys/Vec3
      // 5087: dup
      // 5088: dload 2
      // 5089: dload 4
      // 508b: dload 6
      // 508d: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5090: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 5093: aload 134
      // 5095: bipush 4
      // 5096: ldc ""
      // 5098: ldc ""
      // 509a: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 509d: aload 134
      // 509f: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 50a2: aconst_null
      // 50a3: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 50a6: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 50a9: aload 1
      // 50aa: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 50ad: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 50b0: aload 1
      // 50b1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 50b4: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_x D
      // 50b7: aload 1
      // 50b8: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 50bb: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 50be: aload 1
      // 50bf: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 50c2: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_z D
      // 50c5: invokedynamic makeConcatWithConstants (Ljava/lang/String;DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 \u0001run forceload remove ~ ~" ]
      // 50ca: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 50cd: pop
      // 50ce: aload 8
      // 50d0: instanceof net/minecraft/world/entity/LivingEntity
      // 50d3: ifeq 5131
      // 50d6: aload 8
      // 50d8: checkcast net/minecraft/world/entity/LivingEntity
      // 50db: astore 134
      // 50dd: aload 134
      // 50df: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 50e2: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 50e5: checkcast net/minecraft/world/effect/MobEffect
      // 50e8: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 50eb: ifeq 5131
      // 50ee: aload 1
      // 50ef: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 50f4: ifne 5131
      // 50f7: aload 1
      // 50f8: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 50fd: ifnull 5131
      // 5100: aload 1
      // 5101: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5106: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5109: aload 1
      // 510a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 510d: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 5110: aload 1
      // 5111: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5114: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_x D
      // 5117: aload 1
      // 5118: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 511b: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 511e: aload 1
      // 511f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5122: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_z D
      // 5125: invokedynamic makeConcatWithConstants (Ljava/lang/String;DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 \u0001run forceload remove ~ ~" ]
      // 512a: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 512d: bipush 0
      // 512e: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5131: aload 1
      // 5132: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5135: aload 1
      // 5136: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5139: getfield net/arphex/network/ArphexModVariables$MapVariables.force_unload_repeats D
      // 513c: dconst_1
      // 513d: dsub
      // 513e: putfield net/arphex/network/ArphexModVariables$MapVariables.force_unload_repeats D
      // 5141: aload 1
      // 5142: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5145: aload 1
      // 5146: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5149: aload 8
      // 514b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 514e: ldc_w "alternatechunktormentor"
      // 5151: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 5154: ifeq 56c1
      // 5157: sipush 200
      // 515a: aload 1
      // 515b: invokedynamic run (Lnet/minecraft/world/level/LevelAccessor;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$96 (Lnet/minecraft/world/level/LevelAccessor;)V, ()V ]
      // 5160: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 5163: aload 1
      // 5164: ldc_w net/arphex/entity/TORMENTOREntity
      // 5167: new net/minecraft/world/phys/Vec3
      // 516a: dup
      // 516b: aload 1
      // 516c: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 516f: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5172: aload 1
      // 5173: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5176: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5179: aload 1
      // 517a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 517d: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5180: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5183: ldc2_w 64.0
      // 5186: ldc2_w 64.0
      // 5189: ldc2_w 64.0
      // 518c: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 518f: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$97 (Lnet/arphex/entity/TORMENTOREntity;)Z, (Lnet/arphex/entity/TORMENTOREntity;)Z ]
      // 5194: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 5199: invokeinterface java/util/List.isEmpty ()Z 1
      // 519e: ifne 51f5
      // 51a1: aload 8
      // 51a3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 51a6: ldc_w "failed_tormentor_find_attempts"
      // 51a9: dconst_0
      // 51aa: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 51ad: aload 8
      // 51af: instanceof net/minecraft/world/entity/LivingEntity
      // 51b2: ifeq 51f2
      // 51b5: aload 8
      // 51b7: checkcast net/minecraft/world/entity/LivingEntity
      // 51ba: astore 134
      // 51bc: aload 134
      // 51be: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 51c1: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 51c4: checkcast net/minecraft/world/effect/MobEffect
      // 51c7: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 51ca: ifeq 51f2
      // 51cd: aload 1
      // 51ce: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 51d3: ifne 51f2
      // 51d6: aload 1
      // 51d7: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 51dc: ifnull 51f2
      // 51df: aload 1
      // 51e0: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 51e5: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 51e8: ldc_w "FOUND AND REQUIRED CHUNK LOAD"
      // 51eb: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 51ee: bipush 0
      // 51ef: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 51f2: goto 52b1
      // 51f5: aload 8
      // 51f7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 51fa: ldc_w "failed_tormentor_find_attempts"
      // 51fd: aload 8
      // 51ff: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5202: ldc_w "failed_tormentor_find_attempts"
      // 5205: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5208: dconst_1
      // 5209: dadd
      // 520a: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 520d: aload 8
      // 520f: instanceof net/minecraft/world/entity/LivingEntity
      // 5212: ifeq 52b1
      // 5215: aload 8
      // 5217: checkcast net/minecraft/world/entity/LivingEntity
      // 521a: astore 134
      // 521c: aload 134
      // 521e: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5221: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5224: checkcast net/minecraft/world/effect/MobEffect
      // 5227: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 522a: ifeq 52b1
      // 522d: aload 1
      // 522e: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5233: ifne 5272
      // 5236: aload 1
      // 5237: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 523c: ifnull 5272
      // 523f: aload 1
      // 5240: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5245: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5248: aload 1
      // 5249: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 524c: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 524f: invokestatic java/lang/Math.round (D)J
      // 5252: aload 1
      // 5253: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5256: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5259: invokestatic java/lang/Math.round (D)J
      // 525c: aload 1
      // 525d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5260: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5263: invokestatic java/lang/Math.round (D)J
      // 5266: invokedynamic makeConcatWithConstants (JJJ)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Tormentor Lost at X\u0001 Y\u0001 Z\u0001" ]
      // 526b: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 526e: bipush 0
      // 526f: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5272: aload 1
      // 5273: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5278: ifne 52b1
      // 527b: aload 1
      // 527c: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5281: ifnull 52b1
      // 5284: aload 1
      // 5285: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 528a: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 528d: new java/text/DecimalFormat
      // 5290: dup
      // 5291: ldc_w "##.##"
      // 5294: invokespecial java/text/DecimalFormat.<init> (Ljava/lang/String;)V
      // 5297: aload 8
      // 5299: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 529c: ldc_w "failed_tormentor_find_attempts"
      // 529f: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 52a2: invokevirtual java/text/DecimalFormat.format (D)Ljava/lang/String;
      // 52a5: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Tormentor find attempts (10+ and a new entity spawns): \u0001" ]
      // 52aa: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 52ad: bipush 0
      // 52ae: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 52b1: aload 8
      // 52b3: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 52b6: aload 1
      // 52b7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 52ba: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 52bd: aload 8
      // 52bf: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 52c2: dsub
      // 52c3: ldc2_w 100.0
      // 52c6: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 52c9: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 52cc: checkcast java/lang/Double
      // 52cf: invokevirtual java/lang/Double.doubleValue ()D
      // 52d2: dsub
      // 52d3: ldc2_w 100.0
      // 52d6: ddiv
      // 52d7: dmul
      // 52d8: dadd
      // 52d9: dstore 76
      // 52db: aload 8
      // 52dd: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 52e0: aload 1
      // 52e1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 52e4: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 52e7: aload 8
      // 52e9: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 52ec: dsub
      // 52ed: ldc2_w 100.0
      // 52f0: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 52f3: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 52f6: checkcast java/lang/Double
      // 52f9: invokevirtual java/lang/Double.doubleValue ()D
      // 52fc: dsub
      // 52fd: ldc2_w 100.0
      // 5300: ddiv
      // 5301: dmul
      // 5302: dadd
      // 5303: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 5306: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 5309: checkcast java/lang/Double
      // 530c: invokevirtual java/lang/Double.doubleValue ()D
      // 530f: ldc2_w 2.0
      // 5312: dmul
      // 5313: dadd
      // 5314: dstore 78
      // 5316: aload 8
      // 5318: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 531b: aload 1
      // 531c: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 531f: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5322: aload 8
      // 5324: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 5327: dsub
      // 5328: ldc2_w 100.0
      // 532b: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 532e: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 5331: checkcast java/lang/Double
      // 5334: invokevirtual java/lang/Double.doubleValue ()D
      // 5337: dsub
      // 5338: ldc2_w 100.0
      // 533b: ddiv
      // 533c: dmul
      // 533d: dadd
      // 533e: dstore 80
      // 5340: aload 1
      // 5341: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5344: getfield net/arphex/network/ArphexModVariables$MapVariables.chunk_removal_complete Z
      // 5347: ifne 542c
      // 534a: aload 1
      // 534b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 534e: getfield net/arphex/network/ArphexModVariables$MapVariables.force_unload_repeats D
      // 5351: dconst_0
      // 5352: dcmpl
      // 5353: ifle 542c
      // 5356: aload 1
      // 5357: instanceof net/minecraft/server/level/ServerLevel
      // 535a: ifeq 53b5
      // 535d: aload 1
      // 535e: checkcast net/minecraft/server/level/ServerLevel
      // 5361: astore 134
      // 5363: aload 134
      // 5365: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 5368: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 536b: new net/minecraft/commands/CommandSourceStack
      // 536e: dup
      // 536f: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 5372: new net/minecraft/world/phys/Vec3
      // 5375: dup
      // 5376: dload 2
      // 5377: dload 4
      // 5379: dload 6
      // 537b: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 537e: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 5381: aload 134
      // 5383: bipush 4
      // 5384: ldc ""
      // 5386: ldc ""
      // 5388: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 538b: aload 134
      // 538d: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 5390: aconst_null
      // 5391: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 5394: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 5397: aload 1
      // 5398: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 539b: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 539e: aload 1
      // 539f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 53a2: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_x D
      // 53a5: aload 1
      // 53a6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 53a9: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_z D
      // 53ac: invokedynamic makeConcatWithConstants (Ljava/lang/String;DD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 run forceload remove ~ ~" ]
      // 53b1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 53b4: pop
      // 53b5: aload 8
      // 53b7: instanceof net/minecraft/world/entity/LivingEntity
      // 53ba: ifeq 5411
      // 53bd: aload 8
      // 53bf: checkcast net/minecraft/world/entity/LivingEntity
      // 53c2: astore 134
      // 53c4: aload 134
      // 53c6: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 53c9: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 53cc: checkcast net/minecraft/world/effect/MobEffect
      // 53cf: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 53d2: ifeq 5411
      // 53d5: aload 1
      // 53d6: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 53db: ifne 5411
      // 53de: aload 1
      // 53df: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 53e4: ifnull 5411
      // 53e7: aload 1
      // 53e8: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 53ed: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 53f0: aload 1
      // 53f1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 53f4: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 53f7: aload 1
      // 53f8: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 53fb: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_x D
      // 53fe: aload 1
      // 53ff: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5402: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_z D
      // 5405: invokedynamic makeConcatWithConstants (Ljava/lang/String;DD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 run forceload remove ~ ~" ]
      // 540a: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 540d: bipush 0
      // 540e: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5411: aload 1
      // 5412: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5415: aload 1
      // 5416: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5419: getfield net/arphex/network/ArphexModVariables$MapVariables.force_unload_repeats D
      // 541c: dconst_1
      // 541d: dsub
      // 541e: putfield net/arphex/network/ArphexModVariables$MapVariables.force_unload_repeats D
      // 5421: aload 1
      // 5422: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5425: aload 1
      // 5426: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5429: goto 5471
      // 542c: aload 8
      // 542e: instanceof net/minecraft/world/entity/LivingEntity
      // 5431: ifeq 5471
      // 5434: aload 8
      // 5436: checkcast net/minecraft/world/entity/LivingEntity
      // 5439: astore 134
      // 543b: aload 134
      // 543d: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5440: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5443: checkcast net/minecraft/world/effect/MobEffect
      // 5446: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5449: ifeq 5471
      // 544c: aload 1
      // 544d: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5452: ifne 5471
      // 5455: aload 1
      // 5456: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 545b: ifnull 5471
      // 545e: aload 1
      // 545f: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5464: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5467: ldc_w "Skipped removal 2, already done"
      // 546a: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 546d: bipush 0
      // 546e: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5471: aload 1
      // 5472: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5475: aload 1
      // 5476: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5479: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 547c: putfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_x D
      // 547f: aload 1
      // 5480: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5483: aload 1
      // 5484: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5487: aload 1
      // 5488: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 548b: aload 1
      // 548c: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 548f: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5492: putfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_z D
      // 5495: aload 1
      // 5496: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5499: aload 1
      // 549a: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 549d: ldc2_w 550.0
      // 54a0: aload 8
      // 54a2: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 54a5: aload 1
      // 54a6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 54a9: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 54ac: dsub
      // 54ad: ldc2_w 2.0
      // 54b0: invokestatic java/lang/Math.pow (DD)D
      // 54b3: aload 8
      // 54b5: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 54b8: aload 1
      // 54b9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 54bc: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 54bf: dsub
      // 54c0: ldc2_w 2.0
      // 54c3: invokestatic java/lang/Math.pow (DD)D
      // 54c6: dadd
      // 54c7: aload 8
      // 54c9: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 54cc: aload 1
      // 54cd: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 54d0: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 54d3: dsub
      // 54d4: ldc2_w 2.0
      // 54d7: invokestatic java/lang/Math.pow (DD)D
      // 54da: dadd
      // 54db: invokestatic java/lang/Math.sqrt (D)D
      // 54de: dcmpg
      // 54df: ifge 56b2
      // 54e2: aload 1
      // 54e3: ldc_w net/arphex/entity/TORMENTOREntity
      // 54e6: new net/minecraft/world/phys/Vec3
      // 54e9: dup
      // 54ea: aload 1
      // 54eb: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 54ee: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 54f1: aload 1
      // 54f2: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 54f5: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 54f8: aload 1
      // 54f9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 54fc: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 54ff: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5502: ldc2_w 64.0
      // 5505: ldc2_w 64.0
      // 5508: ldc2_w 64.0
      // 550b: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 550e: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$98 (Lnet/arphex/entity/TORMENTOREntity;)Z, (Lnet/arphex/entity/TORMENTOREntity;)Z ]
      // 5513: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 5518: invokeinterface java/util/List.isEmpty ()Z 1
      // 551d: ifne 566d
      // 5520: aload 1
      // 5521: instanceof net/minecraft/server/level/ServerLevel
      // 5524: ifeq 5580
      // 5527: aload 1
      // 5528: checkcast net/minecraft/server/level/ServerLevel
      // 552b: astore 134
      // 552d: aload 134
      // 552f: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 5532: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 5535: new net/minecraft/commands/CommandSourceStack
      // 5538: dup
      // 5539: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 553c: new net/minecraft/world/phys/Vec3
      // 553f: dup
      // 5540: aload 1
      // 5541: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5544: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5547: aload 1
      // 5548: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 554b: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 554e: aload 1
      // 554f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5552: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5555: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5558: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 555b: aload 134
      // 555d: bipush 4
      // 555e: ldc ""
      // 5560: ldc ""
      // 5562: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5565: aload 134
      // 5567: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 556a: aconst_null
      // 556b: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 556e: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 5571: dload 76
      // 5573: dload 78
      // 5575: dload 80
      // 5577: invokedynamic makeConcatWithConstants (DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "tp @e[type=arphex:tormentor,sort=nearest,limit=1] \u0001 \u0001 \u0001" ]
      // 557c: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 557f: pop
      // 5580: aload 1
      // 5581: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5584: dload 76
      // 5586: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5589: aload 1
      // 558a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 558d: aload 1
      // 558e: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5591: aload 1
      // 5592: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5595: dload 78
      // 5597: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 559a: aload 1
      // 559b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 559e: aload 1
      // 559f: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 55a2: aload 1
      // 55a3: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 55a6: dload 80
      // 55a8: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 55ab: aload 1
      // 55ac: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 55af: aload 1
      // 55b0: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 55b3: aload 8
      // 55b5: instanceof net/minecraft/world/entity/LivingEntity
      // 55b8: ifeq 566a
      // 55bb: aload 8
      // 55bd: checkcast net/minecraft/world/entity/LivingEntity
      // 55c0: astore 134
      // 55c2: aload 134
      // 55c4: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 55c7: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 55ca: checkcast net/minecraft/world/effect/MobEffect
      // 55cd: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 55d0: ifeq 566a
      // 55d3: aload 1
      // 55d4: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 55d9: ifne 55f8
      // 55dc: aload 1
      // 55dd: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 55e2: ifnull 55f8
      // 55e5: aload 1
      // 55e6: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 55eb: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 55ee: ldc_w "TELEPORTING"
      // 55f1: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 55f4: bipush 0
      // 55f5: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 55f8: aload 1
      // 55f9: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 55fe: ifne 566a
      // 5601: aload 1
      // 5602: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5607: ifnull 566a
      // 560a: aload 1
      // 560b: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5610: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5613: new java/text/DecimalFormat
      // 5616: dup
      // 5617: ldc_w "##.##"
      // 561a: invokespecial java/text/DecimalFormat.<init> (Ljava/lang/String;)V
      // 561d: aload 8
      // 561f: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 5622: aload 1
      // 5623: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5626: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5629: dsub
      // 562a: ldc2_w 2.0
      // 562d: invokestatic java/lang/Math.pow (DD)D
      // 5630: aload 8
      // 5632: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 5635: aload 1
      // 5636: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5639: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 563c: dsub
      // 563d: ldc2_w 2.0
      // 5640: invokestatic java/lang/Math.pow (DD)D
      // 5643: dadd
      // 5644: aload 8
      // 5646: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 5649: aload 1
      // 564a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 564d: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5650: dsub
      // 5651: ldc2_w 2.0
      // 5654: invokestatic java/lang/Math.pow (DD)D
      // 5657: dadd
      // 5658: invokestatic java/lang/Math.sqrt (D)D
      // 565b: invokevirtual java/text/DecimalFormat.format (D)Ljava/lang/String;
      // 565e: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Distance from target (550+ increases teleport rate):\u0001" ]
      // 5663: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5666: bipush 0
      // 5667: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 566a: goto 56b2
      // 566d: aload 8
      // 566f: instanceof net/minecraft/world/entity/LivingEntity
      // 5672: ifeq 56b2
      // 5675: aload 8
      // 5677: checkcast net/minecraft/world/entity/LivingEntity
      // 567a: astore 134
      // 567c: aload 134
      // 567e: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5681: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5684: checkcast net/minecraft/world/effect/MobEffect
      // 5687: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 568a: ifeq 56b2
      // 568d: aload 1
      // 568e: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5693: ifne 56b2
      // 5696: aload 1
      // 5697: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 569c: ifnull 56b2
      // 569f: aload 1
      // 56a0: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 56a5: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 56a8: ldc_w "Not found so couldn't teleport"
      // 56ab: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 56ae: bipush 0
      // 56af: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 56b2: aload 8
      // 56b4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 56b7: ldc_w "alternatechunktormentor"
      // 56ba: bipush 0
      // 56bb: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 56be: goto 6388
      // 56c1: aload 1
      // 56c2: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 56c5: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 56c8: dconst_0
      // 56c9: dcmpl
      // 56ca: ifle 6388
      // 56cd: aload 8
      // 56cf: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 56d2: aload 1
      // 56d3: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 56d6: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 56d9: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 56dc: ifeq 5a38
      // 56df: aload 8
      // 56e1: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 56e4: ldc_w "creativespectator"
      // 56e7: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 56ea: ifeq 56ff
      // 56ed: aload 1
      // 56ee: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 56f1: ldc_w "empty"
      // 56f4: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 56f7: aload 1
      // 56f8: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 56fb: aload 1
      // 56fc: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 56ff: aload 8
      // 5701: instanceof net/minecraft/world/entity/LivingEntity
      // 5704: ifeq 5734
      // 5707: aload 8
      // 5709: checkcast net/minecraft/world/entity/LivingEntity
      // 570c: astore 134
      // 570e: aload 134
      // 5710: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 5713: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 5716: ifne 5734
      // 5719: aload 134
      // 571b: new net/minecraft/world/effect/MobEffectInstance
      // 571e: dup
      // 571f: getstatic net/arphex/init/ArphexModMobEffects.TORMENTOR_PRIMARY_TARGET Lnet/minecraftforge/registries/RegistryObject;
      // 5722: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5725: checkcast net/minecraft/world/effect/MobEffect
      // 5728: bipush 60
      // 572a: bipush 0
      // 572b: bipush 0
      // 572c: bipush 0
      // 572d: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 5730: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 5733: pop
      // 5734: aload 1
      // 5735: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5738: ldc2_w 200.0
      // 573b: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_online D
      // 573e: aload 1
      // 573f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5742: aload 1
      // 5743: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5746: aload 1
      // 5747: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 574a: aload 8
      // 574c: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 574f: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_x D
      // 5752: aload 1
      // 5753: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5756: aload 1
      // 5757: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 575a: aload 1
      // 575b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 575e: aload 8
      // 5760: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 5763: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_y D
      // 5766: aload 1
      // 5767: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 576a: aload 1
      // 576b: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 576e: aload 1
      // 576f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5772: aload 8
      // 5774: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 5777: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_z D
      // 577a: aload 1
      // 577b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 577e: aload 1
      // 577f: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5782: aload 1
      // 5783: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5786: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 5789: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_MAX_HEALTH Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 578c: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 578f: checkcast java/lang/Double
      // 5792: invokevirtual java/lang/Double.doubleValue ()D
      // 5795: dcmpl
      // 5796: ifle 57b4
      // 5799: aload 1
      // 579a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 579d: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_MAX_HEALTH Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 57a0: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 57a3: checkcast java/lang/Double
      // 57a6: invokevirtual java/lang/Double.doubleValue ()D
      // 57a9: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 57ac: aload 1
      // 57ad: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 57b0: aload 1
      // 57b1: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 57b4: aload 1
      // 57b5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 57b8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_entity_loaded D
      // 57bb: ldc2_w 180.0
      // 57be: dcmpl
      // 57bf: ifgt 5a66
      // 57c2: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 57c5: bipush 1
      // 57c6: sipush 1200
      // 57c9: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 57cc: bipush 5
      // 57cd: if_icmpne 5818
      // 57d0: aload 1
      // 57d1: instanceof net/minecraft/server/level/ServerLevel
      // 57d4: ifeq 5818
      // 57d7: aload 1
      // 57d8: checkcast net/minecraft/server/level/ServerLevel
      // 57db: astore 134
      // 57dd: getstatic net/minecraft/world/entity/EntityType.LIGHTNING_BOLT Lnet/minecraft/world/entity/EntityType;
      // 57e0: aload 134
      // 57e2: invokevirtual net/minecraft/world/entity/EntityType.create (Lnet/minecraft/world/level/Level;)Lnet/minecraft/world/entity/Entity;
      // 57e5: checkcast net/minecraft/world/entity/LightningBolt
      // 57e8: astore 135
      // 57ea: aload 135
      // 57ec: aload 1
      // 57ed: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 57f0: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 57f3: aload 1
      // 57f4: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 57f7: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 57fa: aload 1
      // 57fb: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 57fe: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5801: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 5804: invokestatic net/minecraft/world/phys/Vec3.atBottomCenterOf (Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;
      // 5807: invokevirtual net/minecraft/world/entity/LightningBolt.moveTo (Lnet/minecraft/world/phys/Vec3;)V
      // 580a: aload 135
      // 580c: bipush 1
      // 580d: invokevirtual net/minecraft/world/entity/LightningBolt.setVisualOnly (Z)V
      // 5810: aload 134
      // 5812: aload 135
      // 5814: invokevirtual net/minecraft/server/level/ServerLevel.addFreshEntity (Lnet/minecraft/world/entity/Entity;)Z
      // 5817: pop
      // 5818: aload 8
      // 581a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 581d: ldc_w "fastrepeat"
      // 5820: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5823: dconst_0
      // 5824: dcmpl
      // 5825: ifgt 5a1d
      // 5828: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_PARTICLES Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 582b: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 582e: checkcast java/lang/Boolean
      // 5831: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 5834: ifeq 5a0c
      // 5837: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.SPECIAL_TORMENTOR_RENDERING Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 583a: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 583d: checkcast java/lang/Boolean
      // 5840: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 5843: ifne 5a0c
      // 5846: bipush 0
      // 5847: istore 134
      // 5849: iload 134
      // 584b: bipush 30
      // 584d: if_icmpge 5a0c
      // 5850: dload 72
      // 5852: dconst_0
      // 5853: dcmpg
      // 5854: ifgt 585f
      // 5857: ldc2_w 30.0
      // 585a: dstore 72
      // 585c: goto 5867
      // 585f: dload 72
      // 5861: ldc2_w 1.5
      // 5864: dsub
      // 5865: dstore 72
      // 5867: bipush 0
      // 5868: istore 135
      // 586a: iload 135
      // 586c: bipush 36
      // 586e: if_icmpge 5a06
      // 5871: dload 74
      // 5873: dconst_0
      // 5874: dcmpg
      // 5875: ifgt 5880
      // 5878: ldc2_w 360.0
      // 587b: dstore 74
      // 587d: goto 5888
      // 5880: dload 74
      // 5882: ldc2_w 10.0
      // 5885: dsub
      // 5886: dstore 74
      // 5888: dload 72
      // 588a: ldc2_w 2.0
      // 588d: dcmpg
      // 588e: ifge 5910
      // 5891: aload 1
      // 5892: instanceof net/minecraft/server/level/ServerLevel
      // 5895: ifeq 590d
      // 5898: aload 1
      // 5899: checkcast net/minecraft/server/level/ServerLevel
      // 589c: astore 136
      // 589e: aload 136
      // 58a0: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 58a3: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 58a6: new net/minecraft/commands/CommandSourceStack
      // 58a9: dup
      // 58aa: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 58ad: new net/minecraft/world/phys/Vec3
      // 58b0: dup
      // 58b1: dload 2
      // 58b2: dload 4
      // 58b4: dload 6
      // 58b6: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 58b9: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 58bc: aload 136
      // 58be: bipush 4
      // 58bf: ldc ""
      // 58c1: ldc ""
      // 58c3: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 58c6: aload 136
      // 58c8: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 58cb: aconst_null
      // 58cc: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 58cf: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 58d2: aload 1
      // 58d3: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 58d6: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 58d9: aload 1
      // 58da: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 58dd: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 58e0: aload 1
      // 58e1: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 58e4: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 58e7: dload 74
      // 58e9: ldc2_w 5.0
      // 58ec: dadd
      // 58ed: dload 72
      // 58ef: dload 72
      // 58f1: dmul
      // 58f2: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 58f5: bipush -10
      // 58f7: bipush 15
      // 58f9: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 58fc: i2d
      // 58fd: dsub
      // 58fe: dload 72
      // 5900: ldc2_w 30.0
      // 5903: dmul
      // 5904: invokedynamic makeConcatWithConstants (DDDDDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute as @p positioned \u0001 \u0001 \u0001 rotated \u0001 0 as @p run particle arphex:death_smoke ^ ^\u0001 ^\u0001 0 -0.2 0 1 0 force" ]
      // 5909: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 590c: pop
      // 590d: goto 5a00
      // 5910: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 5913: dload 72
      // 5915: d2i
      // 5916: bipush 30
      // 5918: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 591b: bipush 28
      // 591d: if_icmpne 5994
      // 5920: aload 1
      // 5921: instanceof net/minecraft/server/level/ServerLevel
      // 5924: ifeq 5994
      // 5927: aload 1
      // 5928: checkcast net/minecraft/server/level/ServerLevel
      // 592b: astore 136
      // 592d: aload 136
      // 592f: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 5932: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 5935: new net/minecraft/commands/CommandSourceStack
      // 5938: dup
      // 5939: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 593c: new net/minecraft/world/phys/Vec3
      // 593f: dup
      // 5940: dload 2
      // 5941: dload 4
      // 5943: dload 6
      // 5945: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5948: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 594b: aload 136
      // 594d: bipush 4
      // 594e: ldc ""
      // 5950: ldc ""
      // 5952: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5955: aload 136
      // 5957: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 595a: aconst_null
      // 595b: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 595e: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 5961: aload 1
      // 5962: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5965: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5968: aload 1
      // 5969: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 596c: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 596f: aload 1
      // 5970: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5973: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5976: dload 74
      // 5978: ldc2_w 5.0
      // 597b: dadd
      // 597c: dload 72
      // 597e: dload 72
      // 5980: dmul
      // 5981: ldc2_w 10.0
      // 5984: dsub
      // 5985: dload 72
      // 5987: ldc2_w 30.0
      // 598a: dmul
      // 598b: invokedynamic makeConcatWithConstants (DDDDDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute as @p positioned \u0001 \u0001 \u0001 rotated \u0001 0 as @p run particle arphex:huge_fire ^ ^\u0001 ^\u0001 3 -0.2 3 1 2 force" ]
      // 5990: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 5993: pop
      // 5994: aload 1
      // 5995: instanceof net/minecraft/server/level/ServerLevel
      // 5998: ifeq 5a00
      // 599b: aload 1
      // 599c: checkcast net/minecraft/server/level/ServerLevel
      // 599f: astore 136
      // 59a1: aload 136
      // 59a3: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 59a6: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 59a9: new net/minecraft/commands/CommandSourceStack
      // 59ac: dup
      // 59ad: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 59b0: new net/minecraft/world/phys/Vec3
      // 59b3: dup
      // 59b4: dload 2
      // 59b5: dload 4
      // 59b7: dload 6
      // 59b9: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 59bc: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 59bf: aload 136
      // 59c1: bipush 4
      // 59c2: ldc ""
      // 59c4: ldc ""
      // 59c6: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 59c9: aload 136
      // 59cb: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 59ce: aconst_null
      // 59cf: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 59d2: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 59d5: aload 1
      // 59d6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 59d9: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 59dc: aload 1
      // 59dd: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 59e0: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 59e3: aload 1
      // 59e4: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 59e7: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 59ea: dload 74
      // 59ec: dload 72
      // 59ee: dload 72
      // 59f0: dmul
      // 59f1: dload 72
      // 59f3: ldc2_w 30.0
      // 59f6: dmul
      // 59f7: invokedynamic makeConcatWithConstants (DDDDDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute as @p positioned \u0001 \u0001 \u0001 rotated \u0001 0 as @p run particle arphex:tormentor_smoke ^ ^\u0001 ^\u0001 0 -0.2 0 1 0 force" ]
      // 59fc: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 59ff: pop
      // 5a00: iinc 135 1
      // 5a03: goto 586a
      // 5a06: iinc 134 1
      // 5a09: goto 5849
      // 5a0c: aload 8
      // 5a0e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5a11: ldc_w "fastrepeat"
      // 5a14: ldc2_w 15.0
      // 5a17: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5a1a: goto 5a66
      // 5a1d: aload 8
      // 5a1f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5a22: ldc_w "fastrepeat"
      // 5a25: aload 8
      // 5a27: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5a2a: ldc_w "fastrepeat"
      // 5a2d: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5a30: dconst_1
      // 5a31: dsub
      // 5a32: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5a35: goto 5a66
      // 5a38: aload 1
      // 5a39: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5a3c: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_online D
      // 5a3f: dconst_0
      // 5a40: dcmpl
      // 5a41: ifgt 5a66
      // 5a44: aload 8
      // 5a46: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5a49: ldc_w "creativespectator"
      // 5a4c: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 5a4f: ifne 5a66
      // 5a52: aload 1
      // 5a53: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5a56: aload 8
      // 5a58: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 5a5b: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 5a5e: aload 1
      // 5a5f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5a62: aload 1
      // 5a63: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5a66: aload 1
      // 5a67: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5a6a: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 5a6d: dconst_0
      // 5a6e: dcmpl
      // 5a6f: ifle 5adb
      // 5a72: aload 1
      // 5a73: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5a76: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_entity_loaded D
      // 5a79: dconst_0
      // 5a7a: dcmpl
      // 5a7b: ifle 5adb
      // 5a7e: aload 1
      // 5a7f: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5a84: ifeq 5a98
      // 5a87: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 5a8a: invokevirtual net/minecraft/client/Minecraft.getConnection ()Lnet/minecraft/client/multiplayer/ClientPacketListener;
      // 5a8d: invokevirtual net/minecraft/client/multiplayer/ClientPacketListener.getOnlinePlayers ()Ljava/util/Collection;
      // 5a90: invokeinterface java/util/Collection.size ()I 1
      // 5a95: goto 5a9e
      // 5a98: invokestatic net/minecraftforge/server/ServerLifecycleHooks.getCurrentServer ()Lnet/minecraft/server/MinecraftServer;
      // 5a9b: invokevirtual net/minecraft/server/MinecraftServer.getPlayerCount ()I
      // 5a9e: ifle 5adb
      // 5aa1: aload 1
      // 5aa2: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5aa5: aload 1
      // 5aa6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5aa9: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_entity_loaded D
      // 5aac: bipush 1
      // 5aad: aload 1
      // 5aae: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5ab3: ifeq 5ac7
      // 5ab6: invokestatic net/minecraft/client/Minecraft.getInstance ()Lnet/minecraft/client/Minecraft;
      // 5ab9: invokevirtual net/minecraft/client/Minecraft.getConnection ()Lnet/minecraft/client/multiplayer/ClientPacketListener;
      // 5abc: invokevirtual net/minecraft/client/multiplayer/ClientPacketListener.getOnlinePlayers ()Ljava/util/Collection;
      // 5abf: invokeinterface java/util/Collection.size ()I 1
      // 5ac4: goto 5acd
      // 5ac7: invokestatic net/minecraftforge/server/ServerLifecycleHooks.getCurrentServer ()Lnet/minecraft/server/MinecraftServer;
      // 5aca: invokevirtual net/minecraft/server/MinecraftServer.getPlayerCount ()I
      // 5acd: idiv
      // 5ace: i2d
      // 5acf: dsub
      // 5ad0: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_entity_loaded D
      // 5ad3: aload 1
      // 5ad4: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5ad7: aload 1
      // 5ad8: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5adb: aload 1
      // 5adc: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5adf: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 5ae2: ldc_w "empty"
      // 5ae5: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 5ae8: ifeq 5b10
      // 5aeb: aload 8
      // 5aed: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5af0: ldc_w "creativespectator"
      // 5af3: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 5af6: ifne 6388
      // 5af9: aload 1
      // 5afa: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5afd: aload 8
      // 5aff: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 5b02: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 5b05: aload 1
      // 5b06: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b09: aload 1
      // 5b0a: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5b0d: goto 6388
      // 5b10: aload 8
      // 5b12: invokevirtual net/minecraft/world/entity/Entity.getStringUUID ()Ljava/lang/String;
      // 5b15: aload 1
      // 5b16: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b19: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 5b1c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 5b1f: ifeq 6388
      // 5b22: aload 8
      // 5b24: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5b27: ldc_w "creativespectator"
      // 5b2a: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 5b2d: ifeq 5b45
      // 5b30: aload 1
      // 5b31: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b34: ldc_w "empty"
      // 5b37: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_follow Ljava/lang/String;
      // 5b3a: aload 1
      // 5b3b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b3e: aload 1
      // 5b3f: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5b42: goto 6388
      // 5b45: aload 1
      // 5b46: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b49: getfield net/arphex/network/ArphexModVariables$MapVariables.alternatecheck Z
      // 5b4c: ifeq 5b74
      // 5b4f: aload 1
      // 5b50: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b53: bipush 0
      // 5b54: putfield net/arphex/network/ArphexModVariables$MapVariables.alternatecheck Z
      // 5b57: aload 1
      // 5b58: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b5b: aload 1
      // 5b5c: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5b5f: aload 1
      // 5b60: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b63: ldc2_w 9.99999999E8
      // 5b66: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_distance_as_uuid D
      // 5b69: aload 1
      // 5b6a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b6d: aload 1
      // 5b6e: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5b71: goto 5b84
      // 5b74: aload 1
      // 5b75: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b78: bipush 1
      // 5b79: putfield net/arphex/network/ArphexModVariables$MapVariables.alternatecheck Z
      // 5b7c: aload 1
      // 5b7d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b80: aload 1
      // 5b81: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5b84: aload 8
      // 5b86: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5b89: ldc_w "torteletime"
      // 5b8c: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 5b8f: dconst_0
      // 5b90: dcmpl
      // 5b91: ifgt 6370
      // 5b94: aload 1
      // 5b95: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5b98: getfield net/arphex/network/ArphexModVariables$MapVariables.chunk_removal_complete Z
      // 5b9b: ifne 5c7a
      // 5b9e: aload 1
      // 5b9f: instanceof net/minecraft/server/level/ServerLevel
      // 5ba2: ifeq 5c04
      // 5ba5: aload 1
      // 5ba6: checkcast net/minecraft/server/level/ServerLevel
      // 5ba9: astore 134
      // 5bab: aload 134
      // 5bad: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 5bb0: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 5bb3: new net/minecraft/commands/CommandSourceStack
      // 5bb6: dup
      // 5bb7: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 5bba: new net/minecraft/world/phys/Vec3
      // 5bbd: dup
      // 5bbe: dload 2
      // 5bbf: dload 4
      // 5bc1: dload 6
      // 5bc3: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5bc6: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 5bc9: aload 134
      // 5bcb: bipush 4
      // 5bcc: ldc ""
      // 5bce: ldc ""
      // 5bd0: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5bd3: aload 134
      // 5bd5: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 5bd8: aconst_null
      // 5bd9: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 5bdc: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 5bdf: aload 1
      // 5be0: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5be3: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 5be6: aload 1
      // 5be7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5bea: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_x D
      // 5bed: aload 1
      // 5bee: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5bf1: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5bf4: aload 1
      // 5bf5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5bf8: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_z D
      // 5bfb: invokedynamic makeConcatWithConstants (Ljava/lang/String;DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 \u0001 run forceload remove ~ ~" ]
      // 5c00: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 5c03: pop
      // 5c04: aload 8
      // 5c06: instanceof net/minecraft/world/entity/LivingEntity
      // 5c09: ifeq 5c67
      // 5c0c: aload 8
      // 5c0e: checkcast net/minecraft/world/entity/LivingEntity
      // 5c11: astore 134
      // 5c13: aload 134
      // 5c15: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5c18: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5c1b: checkcast net/minecraft/world/effect/MobEffect
      // 5c1e: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5c21: ifeq 5c67
      // 5c24: aload 1
      // 5c25: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5c2a: ifne 5c67
      // 5c2d: aload 1
      // 5c2e: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5c33: ifnull 5c67
      // 5c36: aload 1
      // 5c37: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5c3c: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5c3f: aload 1
      // 5c40: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5c43: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 5c46: aload 1
      // 5c47: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5c4a: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_x D
      // 5c4d: aload 1
      // 5c4e: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5c51: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5c54: aload 1
      // 5c55: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5c58: getfield net/arphex/network/ArphexModVariables$MapVariables.last_forceload_z D
      // 5c5b: invokedynamic makeConcatWithConstants (Ljava/lang/String;DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 \u0001 run forceload remove ~ ~" ]
      // 5c60: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5c63: bipush 0
      // 5c64: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5c67: aload 1
      // 5c68: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5c6b: bipush 1
      // 5c6c: putfield net/arphex/network/ArphexModVariables$MapVariables.chunk_removal_complete Z
      // 5c6f: aload 1
      // 5c70: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5c73: aload 1
      // 5c74: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5c77: goto 5cd6
      // 5c7a: aload 8
      // 5c7c: instanceof net/minecraft/world/entity/LivingEntity
      // 5c7f: ifeq 5cd6
      // 5c82: aload 8
      // 5c84: checkcast net/minecraft/world/entity/LivingEntity
      // 5c87: astore 134
      // 5c89: aload 134
      // 5c8b: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5c8e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5c91: checkcast net/minecraft/world/effect/MobEffect
      // 5c94: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5c97: ifeq 5cd6
      // 5c9a: aload 1
      // 5c9b: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5ca0: ifne 5cd6
      // 5ca3: aload 1
      // 5ca4: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5ca9: ifnull 5cd6
      // 5cac: aload 1
      // 5cad: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5cb2: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5cb5: aload 1
      // 5cb6: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5cb9: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5cbc: aload 1
      // 5cbd: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5cc0: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5cc3: aload 1
      // 5cc4: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5cc7: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5cca: invokedynamic makeConcatWithConstants (DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Chunk removal 3 already complete, skipping (x\u0001, y\u0001, z\u0001" ]
      // 5ccf: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5cd2: bipush 0
      // 5cd3: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5cd6: aload 1
      // 5cd7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5cda: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_entity_loaded D
      // 5cdd: dconst_0
      // 5cde: dcmpl
      // 5cdf: ifgt 5db2
      // 5ce2: dconst_0
      // 5ce3: aload 8
      // 5ce5: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 5ce8: aload 1
      // 5ce9: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5cec: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5cef: dsub
      // 5cf0: dsub
      // 5cf1: aload 8
      // 5cf3: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 5cf6: aload 1
      // 5cf7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5cfa: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5cfd: dsub
      // 5cfe: invokestatic java/lang/Math.atan2 (DD)D
      // 5d01: invokestatic java/lang/Math.toDegrees (D)D
      // 5d04: aload 1
      // 5d05: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d08: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d0b: dsub
      // 5d0c: ldc2_w 540.0
      // 5d0f: dadd
      // 5d10: ldc2_w 360.0
      // 5d13: drem
      // 5d14: ldc2_w 180.0
      // 5d17: dsub
      // 5d18: dstore 130
      // 5d1a: dload 130
      // 5d1c: invokestatic java/lang/Math.abs (D)D
      // 5d1f: dconst_1
      // 5d20: dcmpl
      // 5d21: ifle 5d62
      // 5d24: dload 130
      // 5d26: dconst_0
      // 5d27: dcmpl
      // 5d28: ifle 5d48
      // 5d2b: aload 1
      // 5d2c: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d2f: aload 1
      // 5d30: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d33: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d36: ldc2_w 0.25
      // 5d39: dadd
      // 5d3a: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d3d: aload 1
      // 5d3e: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d41: aload 1
      // 5d42: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5d45: goto 5d62
      // 5d48: aload 1
      // 5d49: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d4c: aload 1
      // 5d4d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d50: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d53: ldc2_w 0.25
      // 5d56: dsub
      // 5d57: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d5a: aload 1
      // 5d5b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d5e: aload 1
      // 5d5f: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5d62: aload 1
      // 5d63: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d66: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d69: ldc2_w 180.0
      // 5d6c: dcmpl
      // 5d6d: ifle 5d8a
      // 5d70: aload 1
      // 5d71: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d74: aload 1
      // 5d75: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d78: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d7b: ldc2_w 360.0
      // 5d7e: dsub
      // 5d7f: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d82: aload 1
      // 5d83: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d86: aload 1
      // 5d87: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5d8a: aload 1
      // 5d8b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d8e: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5d91: ldc2_w -180.0
      // 5d94: dcmpg
      // 5d95: ifge 5db2
      // 5d98: aload 1
      // 5d99: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5d9c: aload 1
      // 5d9d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5da0: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5da3: ldc2_w 360.0
      // 5da6: dadd
      // 5da7: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_rotation D
      // 5daa: aload 1
      // 5dab: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5dae: aload 1
      // 5daf: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 5db2: aload 8
      // 5db4: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5db7: ldc_w "torteletime"
      // 5dba: ldc2_w 60.0
      // 5dbd: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5dc0: aload 1
      // 5dc1: ldc_w net/arphex/entity/TORMENTOREntity
      // 5dc4: new net/minecraft/world/phys/Vec3
      // 5dc7: dup
      // 5dc8: dload 2
      // 5dc9: dload 4
      // 5dcb: dload 6
      // 5dcd: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5dd0: ldc2_w 600.0
      // 5dd3: ldc2_w 600.0
      // 5dd6: ldc2_w 600.0
      // 5dd9: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 5ddc: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$99 (Lnet/arphex/entity/TORMENTOREntity;)Z, (Lnet/arphex/entity/TORMENTOREntity;)Z ]
      // 5de1: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 5de6: invokeinterface java/util/List.isEmpty ()Z 1
      // 5deb: ifne 5e33
      // 5dee: aload 8
      // 5df0: instanceof net/minecraft/world/entity/LivingEntity
      // 5df3: ifeq 5e33
      // 5df6: aload 8
      // 5df8: checkcast net/minecraft/world/entity/LivingEntity
      // 5dfb: astore 134
      // 5dfd: aload 134
      // 5dff: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5e02: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5e05: checkcast net/minecraft/world/effect/MobEffect
      // 5e08: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5e0b: ifeq 5e33
      // 5e0e: aload 1
      // 5e0f: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5e14: ifne 5e33
      // 5e17: aload 1
      // 5e18: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5e1d: ifnull 5e33
      // 5e20: aload 1
      // 5e21: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5e26: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5e29: ldc_w "foundwithin600ofplayer"
      // 5e2c: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5e2f: bipush 0
      // 5e30: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5e33: aload 1
      // 5e34: ldc_w net/arphex/entity/TORMENTOREntity
      // 5e37: new net/minecraft/world/phys/Vec3
      // 5e3a: dup
      // 5e3b: dload 2
      // 5e3c: dload 4
      // 5e3e: dload 6
      // 5e40: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5e43: ldc2_w 600.0
      // 5e46: ldc2_w 600.0
      // 5e49: ldc2_w 600.0
      // 5e4c: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 5e4f: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$100 (Lnet/arphex/entity/TORMENTOREntity;)Z, (Lnet/arphex/entity/TORMENTOREntity;)Z ]
      // 5e54: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 5e59: invokeinterface java/util/List.isEmpty ()Z 1
      // 5e5e: ifeq 6388
      // 5e61: aload 1
      // 5e62: ldc_w net/arphex/entity/TORMENTOREntity
      // 5e65: new net/minecraft/world/phys/Vec3
      // 5e68: dup
      // 5e69: aload 1
      // 5e6a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5e6d: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5e70: aload 1
      // 5e71: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5e74: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5e77: aload 1
      // 5e78: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5e7b: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5e7e: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 5e81: ldc2_w 64.0
      // 5e84: ldc2_w 64.0
      // 5e87: ldc2_w 64.0
      // 5e8a: invokestatic net/minecraft/world/phys/AABB.ofSize (Lnet/minecraft/world/phys/Vec3;DDD)Lnet/minecraft/world/phys/AABB;
      // 5e8d: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$101 (Lnet/arphex/entity/TORMENTOREntity;)Z, (Lnet/arphex/entity/TORMENTOREntity;)Z ]
      // 5e92: invokeinterface net/minecraft/world/level/LevelAccessor.getEntitiesOfClass (Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List; 4
      // 5e97: invokeinterface java/util/List.isEmpty ()Z 1
      // 5e9c: ifne 61b5
      // 5e9f: aload 8
      // 5ea1: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 5ea4: aload 1
      // 5ea5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5ea8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5eab: aload 8
      // 5ead: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 5eb0: dsub
      // 5eb1: ldc2_w 100.0
      // 5eb4: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 5eb7: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 5eba: checkcast java/lang/Double
      // 5ebd: invokevirtual java/lang/Double.doubleValue ()D
      // 5ec0: dsub
      // 5ec1: ldc2_w 100.0
      // 5ec4: ddiv
      // 5ec5: dmul
      // 5ec6: dadd
      // 5ec7: dstore 76
      // 5ec9: aload 8
      // 5ecb: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 5ece: ldc_w "failed_tormentor_find_attempts"
      // 5ed1: dconst_0
      // 5ed2: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 5ed5: aload 8
      // 5ed7: instanceof net/minecraft/world/entity/LivingEntity
      // 5eda: ifeq 5f4d
      // 5edd: aload 8
      // 5edf: checkcast net/minecraft/world/entity/LivingEntity
      // 5ee2: astore 134
      // 5ee4: aload 134
      // 5ee6: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5ee9: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5eec: checkcast net/minecraft/world/effect/MobEffect
      // 5eef: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5ef2: ifeq 5f4d
      // 5ef5: aload 1
      // 5ef6: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5efb: ifne 5f1a
      // 5efe: aload 1
      // 5eff: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5f04: ifnull 5f1a
      // 5f07: aload 1
      // 5f08: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5f0d: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5f10: ldc_w "FOUND WITHOUT CHUNK LOAD"
      // 5f13: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5f16: bipush 0
      // 5f17: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5f1a: aload 1
      // 5f1b: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5f20: ifne 5f4d
      // 5f23: aload 1
      // 5f24: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5f29: ifnull 5f4d
      // 5f2c: aload 1
      // 5f2d: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5f32: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5f35: aload 8
      // 5f37: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 5f3a: aload 1
      // 5f3b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5f3e: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 5f41: invokedynamic makeConcatWithConstants (DD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001 + \u0001 /2" ]
      // 5f46: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 5f49: bipush 0
      // 5f4a: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 5f4d: aload 8
      // 5f4f: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 5f52: aload 1
      // 5f53: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5f56: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 5f59: aload 8
      // 5f5b: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 5f5e: dsub
      // 5f5f: ldc2_w 100.0
      // 5f62: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 5f65: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 5f68: checkcast java/lang/Double
      // 5f6b: invokevirtual java/lang/Double.doubleValue ()D
      // 5f6e: dsub
      // 5f6f: ldc2_w 100.0
      // 5f72: ddiv
      // 5f73: dmul
      // 5f74: dadd
      // 5f75: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 5f78: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 5f7b: checkcast java/lang/Double
      // 5f7e: invokevirtual java/lang/Double.doubleValue ()D
      // 5f81: ldc2_w 2.0
      // 5f84: dmul
      // 5f85: dadd
      // 5f86: dstore 78
      // 5f88: aload 8
      // 5f8a: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 5f8d: aload 1
      // 5f8e: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 5f91: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 5f94: aload 8
      // 5f96: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 5f99: dsub
      // 5f9a: ldc2_w 100.0
      // 5f9d: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.TORMENTOR_FOLLOW_SPEED Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 5fa0: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 5fa3: checkcast java/lang/Double
      // 5fa6: invokevirtual java/lang/Double.doubleValue ()D
      // 5fa9: dsub
      // 5faa: ldc2_w 100.0
      // 5fad: ddiv
      // 5fae: dmul
      // 5faf: dadd
      // 5fb0: dstore 80
      // 5fb2: aload 8
      // 5fb4: instanceof net/minecraft/world/entity/LivingEntity
      // 5fb7: ifeq 6044
      // 5fba: aload 8
      // 5fbc: checkcast net/minecraft/world/entity/LivingEntity
      // 5fbf: astore 134
      // 5fc1: aload 134
      // 5fc3: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 5fc6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 5fc9: checkcast net/minecraft/world/effect/MobEffect
      // 5fcc: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 5fcf: ifeq 6044
      // 5fd2: aload 1
      // 5fd3: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 5fd8: ifne 6044
      // 5fdb: aload 1
      // 5fdc: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5fe1: ifnull 6044
      // 5fe4: aload 1
      // 5fe5: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 5fea: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 5fed: new java/text/DecimalFormat
      // 5ff0: dup
      // 5ff1: ldc_w "##.##"
      // 5ff4: invokespecial java/text/DecimalFormat.<init> (Ljava/lang/String;)V
      // 5ff7: aload 8
      // 5ff9: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 5ffc: aload 1
      // 5ffd: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6000: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 6003: dsub
      // 6004: ldc2_w 2.0
      // 6007: invokestatic java/lang/Math.pow (DD)D
      // 600a: aload 8
      // 600c: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 600f: aload 1
      // 6010: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6013: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 6016: dsub
      // 6017: ldc2_w 2.0
      // 601a: invokestatic java/lang/Math.pow (DD)D
      // 601d: dadd
      // 601e: aload 8
      // 6020: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 6023: aload 1
      // 6024: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6027: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 602a: dsub
      // 602b: ldc2_w 2.0
      // 602e: invokestatic java/lang/Math.pow (DD)D
      // 6031: dadd
      // 6032: invokestatic java/lang/Math.sqrt (D)D
      // 6035: invokevirtual java/text/DecimalFormat.format (D)Ljava/lang/String;
      // 6038: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Distance from Tormentor (400+ increases teleport rate):\u0001" ]
      // 603d: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 6040: bipush 0
      // 6041: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 6044: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 6047: bipush 1
      // 6048: bipush 20
      // 604a: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 604d: bipush 5
      // 604e: if_icmpeq 6096
      // 6051: ldc2_w 400.0
      // 6054: aload 8
      // 6056: invokevirtual net/minecraft/world/entity/Entity.getX ()D
      // 6059: aload 1
      // 605a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 605d: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 6060: dsub
      // 6061: ldc2_w 2.0
      // 6064: invokestatic java/lang/Math.pow (DD)D
      // 6067: aload 8
      // 6069: invokevirtual net/minecraft/world/entity/Entity.getY ()D
      // 606c: aload 1
      // 606d: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6070: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 6073: dsub
      // 6074: ldc2_w 2.0
      // 6077: invokestatic java/lang/Math.pow (DD)D
      // 607a: dadd
      // 607b: aload 8
      // 607d: invokevirtual net/minecraft/world/entity/Entity.getZ ()D
      // 6080: aload 1
      // 6081: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6084: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 6087: dsub
      // 6088: ldc2_w 2.0
      // 608b: invokestatic java/lang/Math.pow (DD)D
      // 608e: dadd
      // 608f: invokestatic java/lang/Math.sqrt (D)D
      // 6092: dcmpg
      // 6093: ifge 6388
      // 6096: aload 1
      // 6097: instanceof net/minecraft/server/level/ServerLevel
      // 609a: ifeq 60f6
      // 609d: aload 1
      // 609e: checkcast net/minecraft/server/level/ServerLevel
      // 60a1: astore 134
      // 60a3: aload 134
      // 60a5: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 60a8: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 60ab: new net/minecraft/commands/CommandSourceStack
      // 60ae: dup
      // 60af: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 60b2: new net/minecraft/world/phys/Vec3
      // 60b5: dup
      // 60b6: aload 1
      // 60b7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 60ba: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 60bd: aload 1
      // 60be: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 60c1: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 60c4: aload 1
      // 60c5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 60c8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 60cb: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 60ce: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 60d1: aload 134
      // 60d3: bipush 4
      // 60d4: ldc ""
      // 60d6: ldc ""
      // 60d8: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 60db: aload 134
      // 60dd: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 60e0: aconst_null
      // 60e1: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 60e4: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 60e7: dload 76
      // 60e9: dload 78
      // 60eb: dload 80
      // 60ed: invokedynamic makeConcatWithConstants (DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "tp @e[type=arphex:tormentor,sort=nearest,limit=1] \u0001 \u0001 \u0001" ]
      // 60f2: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 60f5: pop
      // 60f6: aload 8
      // 60f8: instanceof net/minecraft/world/entity/LivingEntity
      // 60fb: ifeq 617f
      // 60fe: aload 8
      // 6100: checkcast net/minecraft/world/entity/LivingEntity
      // 6103: astore 134
      // 6105: aload 134
      // 6107: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 610a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 610d: checkcast net/minecraft/world/effect/MobEffect
      // 6110: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 6113: ifeq 617f
      // 6116: aload 1
      // 6117: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 611c: ifne 6152
      // 611f: aload 1
      // 6120: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 6125: ifnull 6152
      // 6128: aload 1
      // 6129: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 612e: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 6131: aload 1
      // 6132: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6135: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 6138: aload 1
      // 6139: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 613c: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 613f: aload 1
      // 6140: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6143: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 6146: invokedynamic makeConcatWithConstants (DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "Current position: x\u0001 y\u0001 z\u0001" ]
      // 614b: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 614e: bipush 0
      // 614f: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 6152: aload 1
      // 6153: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 6158: ifne 617f
      // 615b: aload 1
      // 615c: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 6161: ifnull 617f
      // 6164: aload 1
      // 6165: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 616a: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 616d: dload 76
      // 616f: dload 78
      // 6171: dload 80
      // 6173: invokedynamic makeConcatWithConstants (DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "TELEPORTING to x\u0001 y\u0001 z\u0001" ]
      // 6178: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 617b: bipush 0
      // 617c: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 617f: aload 1
      // 6180: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6183: dload 76
      // 6185: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 6188: aload 1
      // 6189: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 618c: aload 1
      // 618d: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 6190: aload 1
      // 6191: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6194: dload 78
      // 6196: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 6199: aload 1
      // 619a: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 619d: aload 1
      // 619e: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 61a1: aload 1
      // 61a2: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 61a5: dload 80
      // 61a7: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 61aa: aload 1
      // 61ab: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 61ae: aload 1
      // 61af: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 61b2: goto 6388
      // 61b5: aload 8
      // 61b7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 61ba: ldc_w "alternatechunktormentor"
      // 61bd: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 61c0: ifne 6361
      // 61c3: aload 8
      // 61c5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 61c8: ldc_w "alternatechunktormentor"
      // 61cb: bipush 1
      // 61cc: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 61cf: aload 1
      // 61d0: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 61d3: getfield net/arphex/network/ArphexModVariables$MapVariables.chunk_removal_complete Z
      // 61d6: ifeq 6319
      // 61d9: aload 1
      // 61da: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 61dd: bipush 0
      // 61de: putfield net/arphex/network/ArphexModVariables$MapVariables.chunk_removal_complete Z
      // 61e1: aload 1
      // 61e2: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 61e5: aload 1
      // 61e6: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 61e9: aload 1
      // 61ea: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 61ed: aload 8
      // 61ef: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 61f2: invokevirtual net/minecraft/world/level/Level.dimension ()Lnet/minecraft/resources/ResourceKey;
      // 61f5: invokedynamic makeConcatWithConstants (Lnet/minecraft/resources/ResourceKey;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001" ]
      // 61fa: ldc_w "ResourceKey[minecraft:dimension / "
      // 61fd: ldc ""
      // 61ff: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 6202: ldc_w "]"
      // 6205: ldc ""
      // 6207: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 620a: invokevirtual java/lang/String.strip ()Ljava/lang/String;
      // 620d: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 6210: aload 1
      // 6211: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6214: aload 1
      // 6215: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 6218: aload 8
      // 621a: instanceof net/minecraft/world/entity/LivingEntity
      // 621d: ifeq 627b
      // 6220: aload 8
      // 6222: checkcast net/minecraft/world/entity/LivingEntity
      // 6225: astore 134
      // 6227: aload 134
      // 6229: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 622c: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 622f: checkcast net/minecraft/world/effect/MobEffect
      // 6232: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 6235: ifeq 627b
      // 6238: aload 1
      // 6239: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 623e: ifne 627b
      // 6241: aload 1
      // 6242: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 6247: ifnull 627b
      // 624a: aload 1
      // 624b: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 6250: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 6253: aload 1
      // 6254: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6257: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 625a: aload 1
      // 625b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 625e: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 6261: aload 1
      // 6262: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6265: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 6268: aload 1
      // 6269: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 626c: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 626f: invokedynamic makeConcatWithConstants (Ljava/lang/String;DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 \u0001 run forceload add ~ ~" ]
      // 6274: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 6277: bipush 0
      // 6278: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 627b: aload 8
      // 627d: astore 134
      // 627f: aload 134
      // 6281: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6284: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6287: ifne 6304
      // 628a: aload 134
      // 628c: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 628f: ifnull 6304
      // 6292: aload 134
      // 6294: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6297: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 629a: new net/minecraft/commands/CommandSourceStack
      // 629d: dup
      // 629e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 62a1: aload 134
      // 62a3: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 62a6: aload 134
      // 62a8: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 62ab: aload 134
      // 62ad: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 62b0: instanceof net/minecraft/server/level/ServerLevel
      // 62b3: ifeq 62c1
      // 62b6: aload 134
      // 62b8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 62bb: checkcast net/minecraft/server/level/ServerLevel
      // 62be: goto 62c2
      // 62c1: aconst_null
      // 62c2: bipush 4
      // 62c3: aload 134
      // 62c5: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 62c8: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 62cd: aload 134
      // 62cf: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 62d2: aload 134
      // 62d4: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 62d7: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 62da: aload 134
      // 62dc: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 62df: aload 1
      // 62e0: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 62e3: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_target_dimension Ljava/lang/String;
      // 62e6: aload 1
      // 62e7: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 62ea: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_x D
      // 62ed: aload 1
      // 62ee: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 62f1: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_y D
      // 62f4: aload 1
      // 62f5: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 62f8: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_z D
      // 62fb: invokedynamic makeConcatWithConstants (Ljava/lang/String;DDD)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute in \u0001 run execute positioned \u0001 \u0001 \u0001 run forceload add ~ ~" ]
      // 6300: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6303: pop
      // 6304: aload 1
      // 6305: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6308: ldc2_w 10.0
      // 630b: putfield net/arphex/network/ArphexModVariables$MapVariables.force_unload_repeats D
      // 630e: aload 1
      // 630f: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6312: aload 1
      // 6313: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 6316: goto 6388
      // 6319: aload 8
      // 631b: instanceof net/minecraft/world/entity/LivingEntity
      // 631e: ifeq 635e
      // 6321: aload 8
      // 6323: checkcast net/minecraft/world/entity/LivingEntity
      // 6326: astore 134
      // 6328: aload 134
      // 632a: getstatic net/arphex/init/ArphexModMobEffects.DEBUG_EFFECT Lnet/minecraftforge/registries/RegistryObject;
      // 632d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6330: checkcast net/minecraft/world/effect/MobEffect
      // 6333: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 6336: ifeq 635e
      // 6339: aload 1
      // 633a: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 633f: ifne 635e
      // 6342: aload 1
      // 6343: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 6348: ifnull 635e
      // 634b: aload 1
      // 634c: invokeinterface net/minecraft/world/level/LevelAccessor.getServer ()Lnet/minecraft/server/MinecraftServer; 1
      // 6351: invokevirtual net/minecraft/server/MinecraftServer.getPlayerList ()Lnet/minecraft/server/players/PlayerList;
      // 6354: ldc_w "Chunk removal incomplete, avoided adding chunk"
      // 6357: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 635a: bipush 0
      // 635b: invokevirtual net/minecraft/server/players/PlayerList.broadcastSystemMessage (Lnet/minecraft/network/chat/Component;Z)V
      // 635e: goto 6388
      // 6361: aload 8
      // 6363: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6366: ldc_w "alternatechunktormentor"
      // 6369: bipush 0
      // 636a: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 636d: goto 6388
      // 6370: aload 8
      // 6372: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6375: ldc_w "torteletime"
      // 6378: aload 8
      // 637a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 637d: ldc_w "torteletime"
      // 6380: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 6383: dconst_1
      // 6384: dsub
      // 6385: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 6388: aload 8
      // 638a: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 638d: aconst_null
      // 638e: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 6391: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 6394: dup
      // 6395: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 6398: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 639b: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 639e: getfield net/arphex/network/ArphexModVariables$PlayerVariables.show_tormentor_overlay Z
      // 63a1: ifeq 6407
      // 63a4: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 63a7: bipush 1
      // 63a8: bipush 3
      // 63a9: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 63ac: bipush 1
      // 63ad: if_icmpne 63d0
      // 63b0: invokestatic net/minecraft/util/RandomSource.create ()Lnet/minecraft/util/RandomSource;
      // 63b3: bipush 0
      // 63b4: bipush 2
      // 63b5: invokestatic net/minecraft/util/Mth.nextInt (Lnet/minecraft/util/RandomSource;II)I
      // 63b8: i2d
      // 63b9: dstore 134
      // 63bb: aload 8
      // 63bd: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 63c0: aconst_null
      // 63c1: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 63c4: dload 134
      // 63c6: aload 8
      // 63c8: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$102 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 63cd: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 63d0: aload 8
      // 63d2: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 63d5: aconst_null
      // 63d6: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 63d9: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 63dc: dup
      // 63dd: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 63e0: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 63e3: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 63e6: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_long_range_anim Z
      // 63e9: ifeq 63fb
      // 63ec: bipush 25
      // 63ee: aload 8
      // 63f0: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$104 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 63f5: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 63f8: goto 6407
      // 63fb: bipush 25
      // 63fd: aload 8
      // 63ff: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$106 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 6404: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 6407: aload 1
      // 6408: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 640b: getfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 640e: dconst_0
      // 640f: dcmpl
      // 6410: ifle 6510
      // 6413: getstatic net/arphex/configuration/ConfigurationSettingsConfiguration.DISABLE_TORMENTOR Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
      // 6416: invokevirtual net/minecraftforge/common/ForgeConfigSpec$ConfigValue.get ()Ljava/lang/Object;
      // 6419: checkcast java/lang/Boolean
      // 641c: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 641f: ifeq 6432
      // 6422: aload 1
      // 6423: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 6426: dconst_0
      // 6427: putfield net/arphex/network/ArphexModVariables$MapVariables.tormentor_health D
      // 642a: aload 1
      // 642b: invokestatic net/arphex/network/ArphexModVariables$MapVariables.get (Lnet/minecraft/world/level/LevelAccessor;)Lnet/arphex/network/ArphexModVariables$MapVariables;
      // 642e: aload 1
      // 642f: invokevirtual net/arphex/network/ArphexModVariables$MapVariables.syncData (Lnet/minecraft/world/level/LevelAccessor;)V
      // 6432: aload 8
      // 6434: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 6437: aconst_null
      // 6438: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 643b: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 643e: dup
      // 643f: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 6442: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 6445: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 6448: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_long_range_anim Z
      // 644b: ifeq 645d
      // 644e: bipush 25
      // 6450: aload 8
      // 6452: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$108 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 6457: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 645a: goto 6469
      // 645d: bipush 25
      // 645f: aload 8
      // 6461: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$110 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 6466: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 6469: aload 8
      // 646b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 646e: invokevirtual net/minecraft/world/level/Level.dimension ()Lnet/minecraft/resources/ResourceKey;
      // 6471: invokedynamic makeConcatWithConstants (Lnet/minecraft/resources/ResourceKey;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001" ]
      // 6476: ldc_w "ResourceKey[minecraft:dimension / "
      // 6479: ldc ""
      // 647b: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 647e: ldc_w "]"
      // 6481: ldc ""
      // 6483: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 6486: invokevirtual java/lang/String.strip ()Ljava/lang/String;
      // 6489: astore 134
      // 648b: aload 8
      // 648d: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 6490: aconst_null
      // 6491: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 6494: aload 134
      // 6496: aload 8
      // 6498: invokedynamic accept (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$111 (Ljava/lang/String;Lnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 649d: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 64a0: aload 8
      // 64a2: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 64a5: aconst_null
      // 64a6: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 64a9: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 64ac: dup
      // 64ad: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 64b0: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 64b3: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 64b6: getfield net/arphex/network/ArphexModVariables$PlayerVariables.recently_attacked_tormentor D
      // 64b9: dconst_0
      // 64ba: dcmpl
      // 64bb: ifle 64f3
      // 64be: aload 8
      // 64c0: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 64c3: aconst_null
      // 64c4: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 64c7: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 64ca: dup
      // 64cb: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 64ce: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 64d1: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 64d4: getfield net/arphex/network/ArphexModVariables$PlayerVariables.recently_attacked_tormentor D
      // 64d7: dconst_1
      // 64d8: dsub
      // 64d9: dstore 134
      // 64db: aload 8
      // 64dd: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 64e0: aconst_null
      // 64e1: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 64e4: dload 134
      // 64e6: aload 8
      // 64e8: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$112 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 64ed: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 64f0: goto 6528
      // 64f3: ldc2_w 5.0
      // 64f6: dstore 134
      // 64f8: aload 8
      // 64fa: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 64fd: aconst_null
      // 64fe: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 6501: dload 134
      // 6503: aload 8
      // 6505: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$113 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 650a: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 650d: goto 6528
      // 6510: dconst_0
      // 6511: dstore 134
      // 6513: aload 8
      // 6515: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 6518: aconst_null
      // 6519: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 651c: dload 134
      // 651e: aload 8
      // 6520: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$114 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 6525: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 6528: aload 8
      // 652a: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 652d: aconst_null
      // 652e: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 6531: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 6534: dup
      // 6535: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 6538: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 653b: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 653e: getfield net/arphex/network/ArphexModVariables$PlayerVariables.moth_summon_active D
      // 6541: dconst_0
      // 6542: dcmpl
      // 6543: ifle 6578
      // 6546: aload 8
      // 6548: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 654b: aconst_null
      // 654c: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 654f: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 6552: dup
      // 6553: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 6556: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 6559: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 655c: getfield net/arphex/network/ArphexModVariables$PlayerVariables.moth_summon_active D
      // 655f: dconst_1
      // 6560: dsub
      // 6561: dstore 134
      // 6563: aload 8
      // 6565: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 6568: aconst_null
      // 6569: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 656c: dload 134
      // 656e: aload 8
      // 6570: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$115 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 6575: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 6578: aload 8
      // 657a: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 657d: aconst_null
      // 657e: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 6581: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 6584: dup
      // 6585: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 6588: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 658b: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 658e: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_summon_active D
      // 6591: dconst_0
      // 6592: dcmpl
      // 6593: ifle 65c8
      // 6596: aload 8
      // 6598: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 659b: aconst_null
      // 659c: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 659f: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 65a2: dup
      // 65a3: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 65a6: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 65a9: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 65ac: getfield net/arphex/network/ArphexModVariables$PlayerVariables.tormentor_summon_active D
      // 65af: dconst_1
      // 65b0: dsub
      // 65b1: dstore 134
      // 65b3: aload 8
      // 65b5: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 65b8: aconst_null
      // 65b9: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 65bc: dload 134
      // 65be: aload 8
      // 65c0: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$116 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 65c5: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 65c8: aload 1
      // 65c9: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 65ce: ifeq 6611
      // 65d1: getstatic net/arphex/init/ArphexModKeyMappings.SPACE_PRESS Lnet/minecraft/client/KeyMapping;
      // 65d4: invokevirtual net/minecraft/client/KeyMapping.getKey ()Lcom/mojang/blaze3d/platform/InputConstants$Key;
      // 65d7: invokevirtual com/mojang/blaze3d/platform/InputConstants$Key.getValue ()I
      // 65da: bipush -1
      // 65db: if_icmpeq 65f9
      // 65de: bipush 0
      // 65df: istore 134
      // 65e1: aload 8
      // 65e3: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 65e6: aconst_null
      // 65e7: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 65ea: iload 134
      // 65ec: aload 8
      // 65ee: invokedynamic accept (ZLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$117 (ZLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 65f3: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 65f6: goto 6611
      // 65f9: bipush 1
      // 65fa: istore 134
      // 65fc: aload 8
      // 65fe: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 6601: aconst_null
      // 6602: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 6605: iload 134
      // 6607: aload 8
      // 6609: invokedynamic accept (ZLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$118 (ZLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 660e: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 6611: aload 1
      // 6612: invokeinterface net/minecraft/world/level/LevelAccessor.isClientSide ()Z 1
      // 6617: ifeq 665a
      // 661a: getstatic net/arphex/init/ArphexModKeyMappings.POWER_BIND Lnet/minecraft/client/KeyMapping;
      // 661d: invokevirtual net/minecraft/client/KeyMapping.getKey ()Lcom/mojang/blaze3d/platform/InputConstants$Key;
      // 6620: invokevirtual com/mojang/blaze3d/platform/InputConstants$Key.getValue ()I
      // 6623: bipush -1
      // 6624: if_icmpeq 6642
      // 6627: bipush 0
      // 6628: istore 134
      // 662a: aload 8
      // 662c: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 662f: aconst_null
      // 6630: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 6633: iload 134
      // 6635: aload 8
      // 6637: invokedynamic accept (ZLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$119 (ZLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 663c: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 663f: goto 665a
      // 6642: bipush 1
      // 6643: istore 134
      // 6645: aload 8
      // 6647: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 664a: aconst_null
      // 664b: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 664e: iload 134
      // 6650: aload 8
      // 6652: invokedynamic accept (ZLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$120 (ZLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 6657: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 665a: aload 8
      // 665c: instanceof net/minecraft/world/entity/LivingEntity
      // 665f: ifeq 6671
      // 6662: aload 8
      // 6664: checkcast net/minecraft/world/entity/LivingEntity
      // 6667: astore 134
      // 6669: aload 134
      // 666b: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 666e: goto 6674
      // 6671: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6674: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6677: getstatic net/arphex/init/ArphexModItems.SPEAR_OF_PARALYSIS Lnet/minecraftforge/registries/RegistryObject;
      // 667a: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 667d: if_acmpeq 673e
      // 6680: aload 8
      // 6682: instanceof net/minecraft/world/entity/LivingEntity
      // 6685: ifeq 6697
      // 6688: aload 8
      // 668a: checkcast net/minecraft/world/entity/LivingEntity
      // 668d: astore 135
      // 668f: aload 135
      // 6691: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 6694: goto 669a
      // 6697: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 669a: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 669d: getstatic net/arphex/init/ArphexModItems.CRUSHER_CLAW Lnet/minecraftforge/registries/RegistryObject;
      // 66a0: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 66a3: if_acmpeq 673e
      // 66a6: aload 8
      // 66a8: instanceof net/minecraft/world/entity/LivingEntity
      // 66ab: ifeq 66bd
      // 66ae: aload 8
      // 66b0: checkcast net/minecraft/world/entity/LivingEntity
      // 66b3: astore 136
      // 66b5: aload 136
      // 66b7: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 66ba: goto 66c0
      // 66bd: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 66c0: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 66c3: getstatic net/arphex/init/ArphexModItems.ABYSS_ATOMISER Lnet/minecraftforge/registries/RegistryObject;
      // 66c6: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 66c9: if_acmpeq 673e
      // 66cc: aload 8
      // 66ce: instanceof net/minecraft/world/entity/LivingEntity
      // 66d1: ifeq 66e3
      // 66d4: aload 8
      // 66d6: checkcast net/minecraft/world/entity/LivingEntity
      // 66d9: astore 137
      // 66db: aload 137
      // 66dd: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 66e0: goto 66e6
      // 66e3: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 66e6: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 66e9: getstatic net/arphex/init/ArphexModItems.TEMPOROSPATIAL_TRANSMITTER Lnet/minecraftforge/registries/RegistryObject;
      // 66ec: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 66ef: if_acmpeq 673e
      // 66f2: aload 8
      // 66f4: instanceof net/minecraft/world/entity/LivingEntity
      // 66f7: ifeq 6709
      // 66fa: aload 8
      // 66fc: checkcast net/minecraft/world/entity/LivingEntity
      // 66ff: astore 138
      // 6701: aload 138
      // 6703: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 6706: goto 670c
      // 6709: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 670c: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 670f: getstatic net/arphex/init/ArphexModItems.VISIONARY_SPEAR Lnet/minecraftforge/registries/RegistryObject;
      // 6712: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6715: if_acmpeq 673e
      // 6718: aload 8
      // 671a: instanceof net/minecraft/world/entity/LivingEntity
      // 671d: ifeq 672f
      // 6720: aload 8
      // 6722: checkcast net/minecraft/world/entity/LivingEntity
      // 6725: astore 139
      // 6727: aload 139
      // 6729: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 672c: goto 6732
      // 672f: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6732: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6735: getstatic net/arphex/init/ArphexModItems.INFINITE_TORMENT Lnet/minecraftforge/registries/RegistryObject;
      // 6738: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 673b: if_acmpne 7d10
      // 673e: aload 8
      // 6740: instanceof net/minecraft/world/entity/LivingEntity
      // 6743: ifeq 6755
      // 6746: aload 8
      // 6748: checkcast net/minecraft/world/entity/LivingEntity
      // 674b: astore 140
      // 674d: aload 140
      // 674f: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 6752: goto 6758
      // 6755: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6758: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 675b: getstatic net/arphex/init/ArphexModItems.SPEAR_OF_PARALYSIS Lnet/minecraftforge/registries/RegistryObject;
      // 675e: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6761: if_acmpne 6ae1
      // 6764: aload 8
      // 6766: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6769: ldc_w "arphex_reachmod1"
      // 676c: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 676f: ldc_w "paralysis"
      // 6772: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 6775: ifne 7f49
      // 6778: aload 8
      // 677a: astore 146
      // 677c: aload 146
      // 677e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6781: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6784: ifne 67e3
      // 6787: aload 146
      // 6789: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 678c: ifnull 67e3
      // 678f: aload 146
      // 6791: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6794: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6797: new net/minecraft/commands/CommandSourceStack
      // 679a: dup
      // 679b: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 679e: aload 146
      // 67a0: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 67a3: aload 146
      // 67a5: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 67a8: aload 146
      // 67aa: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 67ad: instanceof net/minecraft/server/level/ServerLevel
      // 67b0: ifeq 67be
      // 67b3: aload 146
      // 67b5: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 67b8: checkcast net/minecraft/server/level/ServerLevel
      // 67bb: goto 67bf
      // 67be: aconst_null
      // 67bf: bipush 4
      // 67c0: aload 146
      // 67c2: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 67c5: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 67ca: aload 146
      // 67cc: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 67cf: aload 146
      // 67d1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 67d4: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 67d7: aload 146
      // 67d9: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 67dc: ldc_w "attribute @s forge:block_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 67df: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 67e2: pop
      // 67e3: aload 8
      // 67e5: astore 146
      // 67e7: aload 146
      // 67e9: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 67ec: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 67ef: ifne 684e
      // 67f2: aload 146
      // 67f4: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 67f7: ifnull 684e
      // 67fa: aload 146
      // 67fc: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 67ff: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6802: new net/minecraft/commands/CommandSourceStack
      // 6805: dup
      // 6806: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6809: aload 146
      // 680b: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 680e: aload 146
      // 6810: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6813: aload 146
      // 6815: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6818: instanceof net/minecraft/server/level/ServerLevel
      // 681b: ifeq 6829
      // 681e: aload 146
      // 6820: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6823: checkcast net/minecraft/server/level/ServerLevel
      // 6826: goto 682a
      // 6829: aconst_null
      // 682a: bipush 4
      // 682b: aload 146
      // 682d: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6830: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6835: aload 146
      // 6837: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 683a: aload 146
      // 683c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 683f: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6842: aload 146
      // 6844: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6847: ldc_w "attribute @s forge:entity_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 684a: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 684d: pop
      // 684e: aload 8
      // 6850: astore 146
      // 6852: aload 146
      // 6854: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6857: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 685a: ifne 68b9
      // 685d: aload 146
      // 685f: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6862: ifnull 68b9
      // 6865: aload 146
      // 6867: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 686a: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 686d: new net/minecraft/commands/CommandSourceStack
      // 6870: dup
      // 6871: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6874: aload 146
      // 6876: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6879: aload 146
      // 687b: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 687e: aload 146
      // 6880: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6883: instanceof net/minecraft/server/level/ServerLevel
      // 6886: ifeq 6894
      // 6889: aload 146
      // 688b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 688e: checkcast net/minecraft/server/level/ServerLevel
      // 6891: goto 6895
      // 6894: aconst_null
      // 6895: bipush 4
      // 6896: aload 146
      // 6898: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 689b: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 68a0: aload 146
      // 68a2: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 68a5: aload 146
      // 68a7: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 68aa: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 68ad: aload 146
      // 68af: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 68b2: ldc_w "attribute @s forge:entity_reach modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 1 add"
      // 68b5: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 68b8: pop
      // 68b9: aload 8
      // 68bb: astore 146
      // 68bd: aload 146
      // 68bf: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 68c2: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 68c5: ifne 6924
      // 68c8: aload 146
      // 68ca: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 68cd: ifnull 6924
      // 68d0: aload 146
      // 68d2: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 68d5: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 68d8: new net/minecraft/commands/CommandSourceStack
      // 68db: dup
      // 68dc: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 68df: aload 146
      // 68e1: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 68e4: aload 146
      // 68e6: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 68e9: aload 146
      // 68eb: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 68ee: instanceof net/minecraft/server/level/ServerLevel
      // 68f1: ifeq 68ff
      // 68f4: aload 146
      // 68f6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 68f9: checkcast net/minecraft/server/level/ServerLevel
      // 68fc: goto 6900
      // 68ff: aconst_null
      // 6900: bipush 4
      // 6901: aload 146
      // 6903: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6906: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 690b: aload 146
      // 690d: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6910: aload 146
      // 6912: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6915: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6918: aload 146
      // 691a: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 691d: ldc_w "attribute @s minecraft:player.block_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6920: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6923: pop
      // 6924: aload 8
      // 6926: astore 146
      // 6928: aload 146
      // 692a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 692d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6930: ifne 698f
      // 6933: aload 146
      // 6935: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6938: ifnull 698f
      // 693b: aload 146
      // 693d: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6940: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6943: new net/minecraft/commands/CommandSourceStack
      // 6946: dup
      // 6947: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 694a: aload 146
      // 694c: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 694f: aload 146
      // 6951: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6954: aload 146
      // 6956: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6959: instanceof net/minecraft/server/level/ServerLevel
      // 695c: ifeq 696a
      // 695f: aload 146
      // 6961: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6964: checkcast net/minecraft/server/level/ServerLevel
      // 6967: goto 696b
      // 696a: aconst_null
      // 696b: bipush 4
      // 696c: aload 146
      // 696e: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6971: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6976: aload 146
      // 6978: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 697b: aload 146
      // 697d: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6980: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6983: aload 146
      // 6985: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6988: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 698b: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 698e: pop
      // 698f: aload 8
      // 6991: astore 146
      // 6993: aload 146
      // 6995: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6998: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 699b: ifne 69fa
      // 699e: aload 146
      // 69a0: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 69a3: ifnull 69fa
      // 69a6: aload 146
      // 69a8: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 69ab: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 69ae: new net/minecraft/commands/CommandSourceStack
      // 69b1: dup
      // 69b2: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 69b5: aload 146
      // 69b7: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 69ba: aload 146
      // 69bc: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 69bf: aload 146
      // 69c1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 69c4: instanceof net/minecraft/server/level/ServerLevel
      // 69c7: ifeq 69d5
      // 69ca: aload 146
      // 69cc: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 69cf: checkcast net/minecraft/server/level/ServerLevel
      // 69d2: goto 69d6
      // 69d5: aconst_null
      // 69d6: bipush 4
      // 69d7: aload 146
      // 69d9: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 69dc: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 69e1: aload 146
      // 69e3: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 69e6: aload 146
      // 69e8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 69eb: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 69ee: aload 146
      // 69f0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 69f3: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e 1 add_value"
      // 69f6: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 69f9: pop
      // 69fa: aload 8
      // 69fc: astore 146
      // 69fe: aload 146
      // 6a00: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6a03: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6a06: ifne 6a65
      // 6a09: aload 146
      // 6a0b: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6a0e: ifnull 6a65
      // 6a11: aload 146
      // 6a13: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6a16: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6a19: new net/minecraft/commands/CommandSourceStack
      // 6a1c: dup
      // 6a1d: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6a20: aload 146
      // 6a22: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6a25: aload 146
      // 6a27: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6a2a: aload 146
      // 6a2c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6a2f: instanceof net/minecraft/server/level/ServerLevel
      // 6a32: ifeq 6a40
      // 6a35: aload 146
      // 6a37: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6a3a: checkcast net/minecraft/server/level/ServerLevel
      // 6a3d: goto 6a41
      // 6a40: aconst_null
      // 6a41: bipush 4
      // 6a42: aload 146
      // 6a44: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6a47: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6a4c: aload 146
      // 6a4e: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6a51: aload 146
      // 6a53: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6a56: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6a59: aload 146
      // 6a5b: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6a5e: ldc_w "/attribute @s forge:attack_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6a61: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6a64: pop
      // 6a65: aload 8
      // 6a67: astore 146
      // 6a69: aload 146
      // 6a6b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6a6e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6a71: ifne 6ad0
      // 6a74: aload 146
      // 6a76: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6a79: ifnull 6ad0
      // 6a7c: aload 146
      // 6a7e: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6a81: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6a84: new net/minecraft/commands/CommandSourceStack
      // 6a87: dup
      // 6a88: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6a8b: aload 146
      // 6a8d: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6a90: aload 146
      // 6a92: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6a95: aload 146
      // 6a97: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6a9a: instanceof net/minecraft/server/level/ServerLevel
      // 6a9d: ifeq 6aab
      // 6aa0: aload 146
      // 6aa2: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6aa5: checkcast net/minecraft/server/level/ServerLevel
      // 6aa8: goto 6aac
      // 6aab: aconst_null
      // 6aac: bipush 4
      // 6aad: aload 146
      // 6aaf: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6ab2: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6ab7: aload 146
      // 6ab9: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6abc: aload 146
      // 6abe: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6ac1: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6ac4: aload 146
      // 6ac6: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6ac9: ldc_w "attribute @s forge:attack_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 1 add"
      // 6acc: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6acf: pop
      // 6ad0: aload 8
      // 6ad2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6ad5: ldc_w "arphex_reachmod1"
      // 6ad8: ldc_w "paralysis"
      // 6adb: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 6ade: goto 7f49
      // 6ae1: aload 8
      // 6ae3: instanceof net/minecraft/world/entity/LivingEntity
      // 6ae6: ifeq 6af8
      // 6ae9: aload 8
      // 6aeb: checkcast net/minecraft/world/entity/LivingEntity
      // 6aee: astore 141
      // 6af0: aload 141
      // 6af2: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 6af5: goto 6afb
      // 6af8: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6afb: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6afe: getstatic net/arphex/init/ArphexModItems.VISIONARY_SPEAR Lnet/minecraftforge/registries/RegistryObject;
      // 6b01: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6b04: if_acmpne 6e84
      // 6b07: aload 8
      // 6b09: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6b0c: ldc_w "arphex_reachmod1"
      // 6b0f: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 6b12: ldc_w "vision"
      // 6b15: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 6b18: ifne 7f49
      // 6b1b: aload 8
      // 6b1d: astore 146
      // 6b1f: aload 146
      // 6b21: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6b24: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6b27: ifne 6b86
      // 6b2a: aload 146
      // 6b2c: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6b2f: ifnull 6b86
      // 6b32: aload 146
      // 6b34: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6b37: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6b3a: new net/minecraft/commands/CommandSourceStack
      // 6b3d: dup
      // 6b3e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6b41: aload 146
      // 6b43: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6b46: aload 146
      // 6b48: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6b4b: aload 146
      // 6b4d: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6b50: instanceof net/minecraft/server/level/ServerLevel
      // 6b53: ifeq 6b61
      // 6b56: aload 146
      // 6b58: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6b5b: checkcast net/minecraft/server/level/ServerLevel
      // 6b5e: goto 6b62
      // 6b61: aconst_null
      // 6b62: bipush 4
      // 6b63: aload 146
      // 6b65: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6b68: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6b6d: aload 146
      // 6b6f: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6b72: aload 146
      // 6b74: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6b77: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6b7a: aload 146
      // 6b7c: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6b7f: ldc_w "attribute @s forge:block_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6b82: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6b85: pop
      // 6b86: aload 8
      // 6b88: astore 146
      // 6b8a: aload 146
      // 6b8c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6b8f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6b92: ifne 6bf1
      // 6b95: aload 146
      // 6b97: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6b9a: ifnull 6bf1
      // 6b9d: aload 146
      // 6b9f: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6ba2: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6ba5: new net/minecraft/commands/CommandSourceStack
      // 6ba8: dup
      // 6ba9: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6bac: aload 146
      // 6bae: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6bb1: aload 146
      // 6bb3: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6bb6: aload 146
      // 6bb8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6bbb: instanceof net/minecraft/server/level/ServerLevel
      // 6bbe: ifeq 6bcc
      // 6bc1: aload 146
      // 6bc3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6bc6: checkcast net/minecraft/server/level/ServerLevel
      // 6bc9: goto 6bcd
      // 6bcc: aconst_null
      // 6bcd: bipush 4
      // 6bce: aload 146
      // 6bd0: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6bd3: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6bd8: aload 146
      // 6bda: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6bdd: aload 146
      // 6bdf: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6be2: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6be5: aload 146
      // 6be7: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6bea: ldc_w "attribute @s forge:entity_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6bed: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6bf0: pop
      // 6bf1: aload 8
      // 6bf3: astore 146
      // 6bf5: aload 146
      // 6bf7: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6bfa: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6bfd: ifne 6c5c
      // 6c00: aload 146
      // 6c02: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6c05: ifnull 6c5c
      // 6c08: aload 146
      // 6c0a: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6c0d: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6c10: new net/minecraft/commands/CommandSourceStack
      // 6c13: dup
      // 6c14: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6c17: aload 146
      // 6c19: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6c1c: aload 146
      // 6c1e: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6c21: aload 146
      // 6c23: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6c26: instanceof net/minecraft/server/level/ServerLevel
      // 6c29: ifeq 6c37
      // 6c2c: aload 146
      // 6c2e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6c31: checkcast net/minecraft/server/level/ServerLevel
      // 6c34: goto 6c38
      // 6c37: aconst_null
      // 6c38: bipush 4
      // 6c39: aload 146
      // 6c3b: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6c3e: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6c43: aload 146
      // 6c45: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6c48: aload 146
      // 6c4a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6c4d: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6c50: aload 146
      // 6c52: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6c55: ldc_w "attribute @s forge:entity_reach modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 4 add"
      // 6c58: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6c5b: pop
      // 6c5c: aload 8
      // 6c5e: astore 146
      // 6c60: aload 146
      // 6c62: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6c65: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6c68: ifne 6cc7
      // 6c6b: aload 146
      // 6c6d: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6c70: ifnull 6cc7
      // 6c73: aload 146
      // 6c75: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6c78: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6c7b: new net/minecraft/commands/CommandSourceStack
      // 6c7e: dup
      // 6c7f: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6c82: aload 146
      // 6c84: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6c87: aload 146
      // 6c89: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6c8c: aload 146
      // 6c8e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6c91: instanceof net/minecraft/server/level/ServerLevel
      // 6c94: ifeq 6ca2
      // 6c97: aload 146
      // 6c99: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6c9c: checkcast net/minecraft/server/level/ServerLevel
      // 6c9f: goto 6ca3
      // 6ca2: aconst_null
      // 6ca3: bipush 4
      // 6ca4: aload 146
      // 6ca6: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6ca9: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6cae: aload 146
      // 6cb0: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6cb3: aload 146
      // 6cb5: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6cb8: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6cbb: aload 146
      // 6cbd: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6cc0: ldc_w "attribute @s minecraft:player.block_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6cc3: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6cc6: pop
      // 6cc7: aload 8
      // 6cc9: astore 146
      // 6ccb: aload 146
      // 6ccd: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6cd0: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6cd3: ifne 6d32
      // 6cd6: aload 146
      // 6cd8: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6cdb: ifnull 6d32
      // 6cde: aload 146
      // 6ce0: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6ce3: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6ce6: new net/minecraft/commands/CommandSourceStack
      // 6ce9: dup
      // 6cea: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6ced: aload 146
      // 6cef: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6cf2: aload 146
      // 6cf4: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6cf7: aload 146
      // 6cf9: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6cfc: instanceof net/minecraft/server/level/ServerLevel
      // 6cff: ifeq 6d0d
      // 6d02: aload 146
      // 6d04: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6d07: checkcast net/minecraft/server/level/ServerLevel
      // 6d0a: goto 6d0e
      // 6d0d: aconst_null
      // 6d0e: bipush 4
      // 6d0f: aload 146
      // 6d11: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6d14: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6d19: aload 146
      // 6d1b: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6d1e: aload 146
      // 6d20: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6d23: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6d26: aload 146
      // 6d28: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6d2b: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6d2e: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6d31: pop
      // 6d32: aload 8
      // 6d34: astore 146
      // 6d36: aload 146
      // 6d38: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6d3b: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6d3e: ifne 6d9d
      // 6d41: aload 146
      // 6d43: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6d46: ifnull 6d9d
      // 6d49: aload 146
      // 6d4b: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6d4e: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6d51: new net/minecraft/commands/CommandSourceStack
      // 6d54: dup
      // 6d55: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6d58: aload 146
      // 6d5a: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6d5d: aload 146
      // 6d5f: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6d62: aload 146
      // 6d64: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6d67: instanceof net/minecraft/server/level/ServerLevel
      // 6d6a: ifeq 6d78
      // 6d6d: aload 146
      // 6d6f: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6d72: checkcast net/minecraft/server/level/ServerLevel
      // 6d75: goto 6d79
      // 6d78: aconst_null
      // 6d79: bipush 4
      // 6d7a: aload 146
      // 6d7c: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6d7f: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6d84: aload 146
      // 6d86: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6d89: aload 146
      // 6d8b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6d8e: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6d91: aload 146
      // 6d93: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6d96: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e 4 add_value"
      // 6d99: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6d9c: pop
      // 6d9d: aload 8
      // 6d9f: astore 146
      // 6da1: aload 146
      // 6da3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6da6: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6da9: ifne 6e08
      // 6dac: aload 146
      // 6dae: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6db1: ifnull 6e08
      // 6db4: aload 146
      // 6db6: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6db9: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6dbc: new net/minecraft/commands/CommandSourceStack
      // 6dbf: dup
      // 6dc0: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6dc3: aload 146
      // 6dc5: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6dc8: aload 146
      // 6dca: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6dcd: aload 146
      // 6dcf: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6dd2: instanceof net/minecraft/server/level/ServerLevel
      // 6dd5: ifeq 6de3
      // 6dd8: aload 146
      // 6dda: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6ddd: checkcast net/minecraft/server/level/ServerLevel
      // 6de0: goto 6de4
      // 6de3: aconst_null
      // 6de4: bipush 4
      // 6de5: aload 146
      // 6de7: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6dea: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6def: aload 146
      // 6df1: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6df4: aload 146
      // 6df6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6df9: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6dfc: aload 146
      // 6dfe: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6e01: ldc_w "/attribute @s forge:attack_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6e04: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6e07: pop
      // 6e08: aload 8
      // 6e0a: astore 146
      // 6e0c: aload 146
      // 6e0e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6e11: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6e14: ifne 6e73
      // 6e17: aload 146
      // 6e19: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6e1c: ifnull 6e73
      // 6e1f: aload 146
      // 6e21: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6e24: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6e27: new net/minecraft/commands/CommandSourceStack
      // 6e2a: dup
      // 6e2b: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6e2e: aload 146
      // 6e30: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6e33: aload 146
      // 6e35: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6e38: aload 146
      // 6e3a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6e3d: instanceof net/minecraft/server/level/ServerLevel
      // 6e40: ifeq 6e4e
      // 6e43: aload 146
      // 6e45: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6e48: checkcast net/minecraft/server/level/ServerLevel
      // 6e4b: goto 6e4f
      // 6e4e: aconst_null
      // 6e4f: bipush 4
      // 6e50: aload 146
      // 6e52: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6e55: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6e5a: aload 146
      // 6e5c: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6e5f: aload 146
      // 6e61: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6e64: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6e67: aload 146
      // 6e69: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6e6c: ldc_w "attribute @s forge:attack_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 4 add"
      // 6e6f: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6e72: pop
      // 6e73: aload 8
      // 6e75: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6e78: ldc_w "arphex_reachmod1"
      // 6e7b: ldc_w "vision"
      // 6e7e: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 6e81: goto 7f49
      // 6e84: aload 8
      // 6e86: instanceof net/minecraft/world/entity/LivingEntity
      // 6e89: ifeq 6e9b
      // 6e8c: aload 8
      // 6e8e: checkcast net/minecraft/world/entity/LivingEntity
      // 6e91: astore 142
      // 6e93: aload 142
      // 6e95: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 6e98: goto 6e9e
      // 6e9b: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 6e9e: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 6ea1: getstatic net/arphex/init/ArphexModItems.CRUSHER_CLAW Lnet/minecraftforge/registries/RegistryObject;
      // 6ea4: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 6ea7: if_acmpne 72fd
      // 6eaa: aload 8
      // 6eac: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 6eaf: ldc_w "arphex_reachmod1"
      // 6eb2: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 6eb5: ldc_w "crush"
      // 6eb8: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 6ebb: ifne 7f49
      // 6ebe: aload 8
      // 6ec0: astore 146
      // 6ec2: aload 146
      // 6ec4: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6ec7: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6eca: ifne 6f29
      // 6ecd: aload 146
      // 6ecf: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6ed2: ifnull 6f29
      // 6ed5: aload 146
      // 6ed7: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6eda: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6edd: new net/minecraft/commands/CommandSourceStack
      // 6ee0: dup
      // 6ee1: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6ee4: aload 146
      // 6ee6: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6ee9: aload 146
      // 6eeb: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6eee: aload 146
      // 6ef0: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6ef3: instanceof net/minecraft/server/level/ServerLevel
      // 6ef6: ifeq 6f04
      // 6ef9: aload 146
      // 6efb: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6efe: checkcast net/minecraft/server/level/ServerLevel
      // 6f01: goto 6f05
      // 6f04: aconst_null
      // 6f05: bipush 4
      // 6f06: aload 146
      // 6f08: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6f0b: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6f10: aload 146
      // 6f12: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6f15: aload 146
      // 6f17: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6f1a: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6f1d: aload 146
      // 6f1f: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6f22: ldc_w "attribute @s forge:block_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6f25: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6f28: pop
      // 6f29: aload 8
      // 6f2b: astore 146
      // 6f2d: aload 146
      // 6f2f: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6f32: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6f35: ifne 6f94
      // 6f38: aload 146
      // 6f3a: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6f3d: ifnull 6f94
      // 6f40: aload 146
      // 6f42: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6f45: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6f48: new net/minecraft/commands/CommandSourceStack
      // 6f4b: dup
      // 6f4c: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6f4f: aload 146
      // 6f51: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6f54: aload 146
      // 6f56: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6f59: aload 146
      // 6f5b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6f5e: instanceof net/minecraft/server/level/ServerLevel
      // 6f61: ifeq 6f6f
      // 6f64: aload 146
      // 6f66: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6f69: checkcast net/minecraft/server/level/ServerLevel
      // 6f6c: goto 6f70
      // 6f6f: aconst_null
      // 6f70: bipush 4
      // 6f71: aload 146
      // 6f73: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6f76: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6f7b: aload 146
      // 6f7d: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6f80: aload 146
      // 6f82: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6f85: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6f88: aload 146
      // 6f8a: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6f8d: ldc_w "attribute @s forge:entity_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 6f90: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6f93: pop
      // 6f94: aload 8
      // 6f96: astore 146
      // 6f98: aload 146
      // 6f9a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6f9d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 6fa0: ifne 6fff
      // 6fa3: aload 146
      // 6fa5: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6fa8: ifnull 6fff
      // 6fab: aload 146
      // 6fad: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6fb0: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 6fb3: new net/minecraft/commands/CommandSourceStack
      // 6fb6: dup
      // 6fb7: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 6fba: aload 146
      // 6fbc: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 6fbf: aload 146
      // 6fc1: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 6fc4: aload 146
      // 6fc6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6fc9: instanceof net/minecraft/server/level/ServerLevel
      // 6fcc: ifeq 6fda
      // 6fcf: aload 146
      // 6fd1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6fd4: checkcast net/minecraft/server/level/ServerLevel
      // 6fd7: goto 6fdb
      // 6fda: aconst_null
      // 6fdb: bipush 4
      // 6fdc: aload 146
      // 6fde: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 6fe1: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 6fe6: aload 146
      // 6fe8: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 6feb: aload 146
      // 6fed: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 6ff0: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 6ff3: aload 146
      // 6ff5: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 6ff8: ldc_w "attribute @s forge:entity_reach modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 2 add"
      // 6ffb: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 6ffe: pop
      // 6fff: aload 8
      // 7001: astore 146
      // 7003: aload 146
      // 7005: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7008: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 700b: ifne 706a
      // 700e: aload 146
      // 7010: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7013: ifnull 706a
      // 7016: aload 146
      // 7018: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 701b: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 701e: new net/minecraft/commands/CommandSourceStack
      // 7021: dup
      // 7022: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7025: aload 146
      // 7027: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 702a: aload 146
      // 702c: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 702f: aload 146
      // 7031: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7034: instanceof net/minecraft/server/level/ServerLevel
      // 7037: ifeq 7045
      // 703a: aload 146
      // 703c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 703f: checkcast net/minecraft/server/level/ServerLevel
      // 7042: goto 7046
      // 7045: aconst_null
      // 7046: bipush 4
      // 7047: aload 146
      // 7049: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 704c: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7051: aload 146
      // 7053: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7056: aload 146
      // 7058: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 705b: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 705e: aload 146
      // 7060: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7063: ldc_w "attribute @s forge:block_reach modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 2 add"
      // 7066: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7069: pop
      // 706a: aload 8
      // 706c: astore 146
      // 706e: aload 146
      // 7070: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7073: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7076: ifne 70d5
      // 7079: aload 146
      // 707b: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 707e: ifnull 70d5
      // 7081: aload 146
      // 7083: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7086: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7089: new net/minecraft/commands/CommandSourceStack
      // 708c: dup
      // 708d: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7090: aload 146
      // 7092: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7095: aload 146
      // 7097: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 709a: aload 146
      // 709c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 709f: instanceof net/minecraft/server/level/ServerLevel
      // 70a2: ifeq 70b0
      // 70a5: aload 146
      // 70a7: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 70aa: checkcast net/minecraft/server/level/ServerLevel
      // 70ad: goto 70b1
      // 70b0: aconst_null
      // 70b1: bipush 4
      // 70b2: aload 146
      // 70b4: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 70b7: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 70bc: aload 146
      // 70be: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 70c1: aload 146
      // 70c3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 70c6: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 70c9: aload 146
      // 70cb: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 70ce: ldc_w "attribute @s minecraft:player.block_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 70d1: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 70d4: pop
      // 70d5: aload 8
      // 70d7: astore 146
      // 70d9: aload 146
      // 70db: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 70de: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 70e1: ifne 7140
      // 70e4: aload 146
      // 70e6: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 70e9: ifnull 7140
      // 70ec: aload 146
      // 70ee: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 70f1: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 70f4: new net/minecraft/commands/CommandSourceStack
      // 70f7: dup
      // 70f8: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 70fb: aload 146
      // 70fd: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7100: aload 146
      // 7102: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7105: aload 146
      // 7107: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 710a: instanceof net/minecraft/server/level/ServerLevel
      // 710d: ifeq 711b
      // 7110: aload 146
      // 7112: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7115: checkcast net/minecraft/server/level/ServerLevel
      // 7118: goto 711c
      // 711b: aconst_null
      // 711c: bipush 4
      // 711d: aload 146
      // 711f: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7122: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7127: aload 146
      // 7129: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 712c: aload 146
      // 712e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7131: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7134: aload 146
      // 7136: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7139: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 713c: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 713f: pop
      // 7140: aload 8
      // 7142: astore 146
      // 7144: aload 146
      // 7146: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7149: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 714c: ifne 71ab
      // 714f: aload 146
      // 7151: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7154: ifnull 71ab
      // 7157: aload 146
      // 7159: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 715c: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 715f: new net/minecraft/commands/CommandSourceStack
      // 7162: dup
      // 7163: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7166: aload 146
      // 7168: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 716b: aload 146
      // 716d: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7170: aload 146
      // 7172: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7175: instanceof net/minecraft/server/level/ServerLevel
      // 7178: ifeq 7186
      // 717b: aload 146
      // 717d: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7180: checkcast net/minecraft/server/level/ServerLevel
      // 7183: goto 7187
      // 7186: aconst_null
      // 7187: bipush 4
      // 7188: aload 146
      // 718a: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 718d: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7192: aload 146
      // 7194: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7197: aload 146
      // 7199: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 719c: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 719f: aload 146
      // 71a1: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 71a4: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e 2 add_value"
      // 71a7: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 71aa: pop
      // 71ab: aload 8
      // 71ad: astore 146
      // 71af: aload 146
      // 71b1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 71b4: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 71b7: ifne 7216
      // 71ba: aload 146
      // 71bc: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 71bf: ifnull 7216
      // 71c2: aload 146
      // 71c4: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 71c7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 71ca: new net/minecraft/commands/CommandSourceStack
      // 71cd: dup
      // 71ce: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 71d1: aload 146
      // 71d3: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 71d6: aload 146
      // 71d8: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 71db: aload 146
      // 71dd: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 71e0: instanceof net/minecraft/server/level/ServerLevel
      // 71e3: ifeq 71f1
      // 71e6: aload 146
      // 71e8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 71eb: checkcast net/minecraft/server/level/ServerLevel
      // 71ee: goto 71f2
      // 71f1: aconst_null
      // 71f2: bipush 4
      // 71f3: aload 146
      // 71f5: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 71f8: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 71fd: aload 146
      // 71ff: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7202: aload 146
      // 7204: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7207: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 720a: aload 146
      // 720c: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 720f: ldc_w "attribute @s minecraft:player.block_interaction_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e 2 add_value"
      // 7212: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7215: pop
      // 7216: aload 8
      // 7218: astore 146
      // 721a: aload 146
      // 721c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 721f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7222: ifne 7281
      // 7225: aload 146
      // 7227: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 722a: ifnull 7281
      // 722d: aload 146
      // 722f: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7232: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7235: new net/minecraft/commands/CommandSourceStack
      // 7238: dup
      // 7239: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 723c: aload 146
      // 723e: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7241: aload 146
      // 7243: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7246: aload 146
      // 7248: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 724b: instanceof net/minecraft/server/level/ServerLevel
      // 724e: ifeq 725c
      // 7251: aload 146
      // 7253: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7256: checkcast net/minecraft/server/level/ServerLevel
      // 7259: goto 725d
      // 725c: aconst_null
      // 725d: bipush 4
      // 725e: aload 146
      // 7260: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7263: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7268: aload 146
      // 726a: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 726d: aload 146
      // 726f: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7272: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7275: aload 146
      // 7277: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 727a: ldc_w "/attribute @s forge:attack_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 727d: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7280: pop
      // 7281: aload 8
      // 7283: astore 146
      // 7285: aload 146
      // 7287: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 728a: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 728d: ifne 72ec
      // 7290: aload 146
      // 7292: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7295: ifnull 72ec
      // 7298: aload 146
      // 729a: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 729d: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 72a0: new net/minecraft/commands/CommandSourceStack
      // 72a3: dup
      // 72a4: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 72a7: aload 146
      // 72a9: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 72ac: aload 146
      // 72ae: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 72b1: aload 146
      // 72b3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 72b6: instanceof net/minecraft/server/level/ServerLevel
      // 72b9: ifeq 72c7
      // 72bc: aload 146
      // 72be: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 72c1: checkcast net/minecraft/server/level/ServerLevel
      // 72c4: goto 72c8
      // 72c7: aconst_null
      // 72c8: bipush 4
      // 72c9: aload 146
      // 72cb: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 72ce: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 72d3: aload 146
      // 72d5: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 72d8: aload 146
      // 72da: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 72dd: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 72e0: aload 146
      // 72e2: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 72e5: ldc_w "attribute @s forge:attack_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 2 add"
      // 72e8: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 72eb: pop
      // 72ec: aload 8
      // 72ee: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 72f1: ldc_w "arphex_reachmod1"
      // 72f4: ldc_w "crush"
      // 72f7: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 72fa: goto 7f49
      // 72fd: aload 8
      // 72ff: instanceof net/minecraft/world/entity/LivingEntity
      // 7302: ifeq 7314
      // 7305: aload 8
      // 7307: checkcast net/minecraft/world/entity/LivingEntity
      // 730a: astore 143
      // 730c: aload 143
      // 730e: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 7311: goto 7317
      // 7314: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 7317: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 731a: getstatic net/arphex/init/ArphexModItems.ABYSS_ATOMISER Lnet/minecraftforge/registries/RegistryObject;
      // 731d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7320: if_acmpne 7635
      // 7323: aload 8
      // 7325: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7328: ldc_w "arphex_reachmod1"
      // 732b: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 732e: ldc_w "atom"
      // 7331: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7334: ifne 7f49
      // 7337: aload 8
      // 7339: astore 146
      // 733b: aload 146
      // 733d: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7340: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7343: ifne 73a2
      // 7346: aload 146
      // 7348: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 734b: ifnull 73a2
      // 734e: aload 146
      // 7350: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7353: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7356: new net/minecraft/commands/CommandSourceStack
      // 7359: dup
      // 735a: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 735d: aload 146
      // 735f: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7362: aload 146
      // 7364: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7367: aload 146
      // 7369: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 736c: instanceof net/minecraft/server/level/ServerLevel
      // 736f: ifeq 737d
      // 7372: aload 146
      // 7374: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7377: checkcast net/minecraft/server/level/ServerLevel
      // 737a: goto 737e
      // 737d: aconst_null
      // 737e: bipush 4
      // 737f: aload 146
      // 7381: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7384: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7389: aload 146
      // 738b: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 738e: aload 146
      // 7390: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7393: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7396: aload 146
      // 7398: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 739b: ldc_w "attribute @s forge:block_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 739e: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 73a1: pop
      // 73a2: aload 8
      // 73a4: astore 146
      // 73a6: aload 146
      // 73a8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 73ab: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 73ae: ifne 740d
      // 73b1: aload 146
      // 73b3: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 73b6: ifnull 740d
      // 73b9: aload 146
      // 73bb: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 73be: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 73c1: new net/minecraft/commands/CommandSourceStack
      // 73c4: dup
      // 73c5: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 73c8: aload 146
      // 73ca: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 73cd: aload 146
      // 73cf: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 73d2: aload 146
      // 73d4: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 73d7: instanceof net/minecraft/server/level/ServerLevel
      // 73da: ifeq 73e8
      // 73dd: aload 146
      // 73df: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 73e2: checkcast net/minecraft/server/level/ServerLevel
      // 73e5: goto 73e9
      // 73e8: aconst_null
      // 73e9: bipush 4
      // 73ea: aload 146
      // 73ec: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 73ef: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 73f4: aload 146
      // 73f6: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 73f9: aload 146
      // 73fb: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 73fe: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7401: aload 146
      // 7403: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7406: ldc_w "attribute @s forge:entity_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7409: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 740c: pop
      // 740d: aload 8
      // 740f: astore 146
      // 7411: aload 146
      // 7413: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7416: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7419: ifne 7478
      // 741c: aload 146
      // 741e: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7421: ifnull 7478
      // 7424: aload 146
      // 7426: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7429: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 742c: new net/minecraft/commands/CommandSourceStack
      // 742f: dup
      // 7430: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7433: aload 146
      // 7435: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7438: aload 146
      // 743a: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 743d: aload 146
      // 743f: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7442: instanceof net/minecraft/server/level/ServerLevel
      // 7445: ifeq 7453
      // 7448: aload 146
      // 744a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 744d: checkcast net/minecraft/server/level/ServerLevel
      // 7450: goto 7454
      // 7453: aconst_null
      // 7454: bipush 4
      // 7455: aload 146
      // 7457: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 745a: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 745f: aload 146
      // 7461: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7464: aload 146
      // 7466: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7469: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 746c: aload 146
      // 746e: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7471: ldc_w "attribute @s forge:block_reach modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 2 add"
      // 7474: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7477: pop
      // 7478: aload 8
      // 747a: astore 146
      // 747c: aload 146
      // 747e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7481: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7484: ifne 74e3
      // 7487: aload 146
      // 7489: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 748c: ifnull 74e3
      // 748f: aload 146
      // 7491: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7494: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7497: new net/minecraft/commands/CommandSourceStack
      // 749a: dup
      // 749b: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 749e: aload 146
      // 74a0: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 74a3: aload 146
      // 74a5: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 74a8: aload 146
      // 74aa: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 74ad: instanceof net/minecraft/server/level/ServerLevel
      // 74b0: ifeq 74be
      // 74b3: aload 146
      // 74b5: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 74b8: checkcast net/minecraft/server/level/ServerLevel
      // 74bb: goto 74bf
      // 74be: aconst_null
      // 74bf: bipush 4
      // 74c0: aload 146
      // 74c2: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 74c5: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 74ca: aload 146
      // 74cc: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 74cf: aload 146
      // 74d1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 74d4: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 74d7: aload 146
      // 74d9: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 74dc: ldc_w "attribute @s minecraft:player.block_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 74df: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 74e2: pop
      // 74e3: aload 8
      // 74e5: astore 146
      // 74e7: aload 146
      // 74e9: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 74ec: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 74ef: ifne 754e
      // 74f2: aload 146
      // 74f4: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 74f7: ifnull 754e
      // 74fa: aload 146
      // 74fc: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 74ff: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7502: new net/minecraft/commands/CommandSourceStack
      // 7505: dup
      // 7506: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7509: aload 146
      // 750b: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 750e: aload 146
      // 7510: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7513: aload 146
      // 7515: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7518: instanceof net/minecraft/server/level/ServerLevel
      // 751b: ifeq 7529
      // 751e: aload 146
      // 7520: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7523: checkcast net/minecraft/server/level/ServerLevel
      // 7526: goto 752a
      // 7529: aconst_null
      // 752a: bipush 4
      // 752b: aload 146
      // 752d: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7530: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7535: aload 146
      // 7537: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 753a: aload 146
      // 753c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 753f: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7542: aload 146
      // 7544: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7547: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 754a: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 754d: pop
      // 754e: aload 8
      // 7550: astore 146
      // 7552: aload 146
      // 7554: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7557: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 755a: ifne 75b9
      // 755d: aload 146
      // 755f: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7562: ifnull 75b9
      // 7565: aload 146
      // 7567: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 756a: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 756d: new net/minecraft/commands/CommandSourceStack
      // 7570: dup
      // 7571: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7574: aload 146
      // 7576: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7579: aload 146
      // 757b: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 757e: aload 146
      // 7580: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7583: instanceof net/minecraft/server/level/ServerLevel
      // 7586: ifeq 7594
      // 7589: aload 146
      // 758b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 758e: checkcast net/minecraft/server/level/ServerLevel
      // 7591: goto 7595
      // 7594: aconst_null
      // 7595: bipush 4
      // 7596: aload 146
      // 7598: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 759b: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 75a0: aload 146
      // 75a2: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 75a5: aload 146
      // 75a7: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 75aa: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 75ad: aload 146
      // 75af: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 75b2: ldc_w "attribute @s minecraft:player.block_interaction_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e 2 add_value"
      // 75b5: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 75b8: pop
      // 75b9: aload 8
      // 75bb: astore 146
      // 75bd: aload 146
      // 75bf: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 75c2: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 75c5: ifne 7624
      // 75c8: aload 146
      // 75ca: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 75cd: ifnull 7624
      // 75d0: aload 146
      // 75d2: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 75d5: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 75d8: new net/minecraft/commands/CommandSourceStack
      // 75db: dup
      // 75dc: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 75df: aload 146
      // 75e1: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 75e4: aload 146
      // 75e6: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 75e9: aload 146
      // 75eb: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 75ee: instanceof net/minecraft/server/level/ServerLevel
      // 75f1: ifeq 75ff
      // 75f4: aload 146
      // 75f6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 75f9: checkcast net/minecraft/server/level/ServerLevel
      // 75fc: goto 7600
      // 75ff: aconst_null
      // 7600: bipush 4
      // 7601: aload 146
      // 7603: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7606: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 760b: aload 146
      // 760d: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7610: aload 146
      // 7612: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7615: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7618: aload 146
      // 761a: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 761d: ldc_w "/attribute @s forge:attack_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7620: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7623: pop
      // 7624: aload 8
      // 7626: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7629: ldc_w "arphex_reachmod1"
      // 762c: ldc_w "atom"
      // 762f: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 7632: goto 7f49
      // 7635: aload 8
      // 7637: instanceof net/minecraft/world/entity/LivingEntity
      // 763a: ifeq 764c
      // 763d: aload 8
      // 763f: checkcast net/minecraft/world/entity/LivingEntity
      // 7642: astore 144
      // 7644: aload 144
      // 7646: invokevirtual net/minecraft/world/entity/LivingEntity.getOffhandItem ()Lnet/minecraft/world/item/ItemStack;
      // 7649: goto 764f
      // 764c: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 764f: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 7652: getstatic net/arphex/init/ArphexModItems.TEMPOROSPATIAL_TRANSMITTER Lnet/minecraftforge/registries/RegistryObject;
      // 7655: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7658: if_acmpne 796d
      // 765b: aload 8
      // 765d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7660: ldc_w "arphex_reachmod1"
      // 7663: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7666: ldc_w "spatial"
      // 7669: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 766c: ifne 7f49
      // 766f: aload 8
      // 7671: astore 146
      // 7673: aload 146
      // 7675: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7678: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 767b: ifne 76da
      // 767e: aload 146
      // 7680: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7683: ifnull 76da
      // 7686: aload 146
      // 7688: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 768b: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 768e: new net/minecraft/commands/CommandSourceStack
      // 7691: dup
      // 7692: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7695: aload 146
      // 7697: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 769a: aload 146
      // 769c: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 769f: aload 146
      // 76a1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 76a4: instanceof net/minecraft/server/level/ServerLevel
      // 76a7: ifeq 76b5
      // 76aa: aload 146
      // 76ac: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 76af: checkcast net/minecraft/server/level/ServerLevel
      // 76b2: goto 76b6
      // 76b5: aconst_null
      // 76b6: bipush 4
      // 76b7: aload 146
      // 76b9: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 76bc: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 76c1: aload 146
      // 76c3: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 76c6: aload 146
      // 76c8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 76cb: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 76ce: aload 146
      // 76d0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 76d3: ldc_w "attribute @s forge:block_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 76d6: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 76d9: pop
      // 76da: aload 8
      // 76dc: astore 146
      // 76de: aload 146
      // 76e0: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 76e3: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 76e6: ifne 7745
      // 76e9: aload 146
      // 76eb: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 76ee: ifnull 7745
      // 76f1: aload 146
      // 76f3: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 76f6: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 76f9: new net/minecraft/commands/CommandSourceStack
      // 76fc: dup
      // 76fd: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7700: aload 146
      // 7702: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7705: aload 146
      // 7707: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 770a: aload 146
      // 770c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 770f: instanceof net/minecraft/server/level/ServerLevel
      // 7712: ifeq 7720
      // 7715: aload 146
      // 7717: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 771a: checkcast net/minecraft/server/level/ServerLevel
      // 771d: goto 7721
      // 7720: aconst_null
      // 7721: bipush 4
      // 7722: aload 146
      // 7724: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7727: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 772c: aload 146
      // 772e: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7731: aload 146
      // 7733: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7736: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7739: aload 146
      // 773b: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 773e: ldc_w "attribute @s forge:entity_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7741: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7744: pop
      // 7745: aload 8
      // 7747: astore 146
      // 7749: aload 146
      // 774b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 774e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7751: ifne 77b0
      // 7754: aload 146
      // 7756: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7759: ifnull 77b0
      // 775c: aload 146
      // 775e: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7761: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7764: new net/minecraft/commands/CommandSourceStack
      // 7767: dup
      // 7768: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 776b: aload 146
      // 776d: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7770: aload 146
      // 7772: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7775: aload 146
      // 7777: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 777a: instanceof net/minecraft/server/level/ServerLevel
      // 777d: ifeq 778b
      // 7780: aload 146
      // 7782: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7785: checkcast net/minecraft/server/level/ServerLevel
      // 7788: goto 778c
      // 778b: aconst_null
      // 778c: bipush 4
      // 778d: aload 146
      // 778f: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7792: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7797: aload 146
      // 7799: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 779c: aload 146
      // 779e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 77a1: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 77a4: aload 146
      // 77a6: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 77a9: ldc_w "attribute @s forge:block_reach modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 6 add"
      // 77ac: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 77af: pop
      // 77b0: aload 8
      // 77b2: astore 146
      // 77b4: aload 146
      // 77b6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 77b9: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 77bc: ifne 781b
      // 77bf: aload 146
      // 77c1: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 77c4: ifnull 781b
      // 77c7: aload 146
      // 77c9: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 77cc: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 77cf: new net/minecraft/commands/CommandSourceStack
      // 77d2: dup
      // 77d3: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 77d6: aload 146
      // 77d8: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 77db: aload 146
      // 77dd: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 77e0: aload 146
      // 77e2: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 77e5: instanceof net/minecraft/server/level/ServerLevel
      // 77e8: ifeq 77f6
      // 77eb: aload 146
      // 77ed: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 77f0: checkcast net/minecraft/server/level/ServerLevel
      // 77f3: goto 77f7
      // 77f6: aconst_null
      // 77f7: bipush 4
      // 77f8: aload 146
      // 77fa: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 77fd: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7802: aload 146
      // 7804: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7807: aload 146
      // 7809: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 780c: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 780f: aload 146
      // 7811: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7814: ldc_w "attribute @s minecraft:player.block_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7817: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 781a: pop
      // 781b: aload 8
      // 781d: astore 146
      // 781f: aload 146
      // 7821: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7824: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7827: ifne 7886
      // 782a: aload 146
      // 782c: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 782f: ifnull 7886
      // 7832: aload 146
      // 7834: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7837: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 783a: new net/minecraft/commands/CommandSourceStack
      // 783d: dup
      // 783e: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7841: aload 146
      // 7843: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7846: aload 146
      // 7848: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 784b: aload 146
      // 784d: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7850: instanceof net/minecraft/server/level/ServerLevel
      // 7853: ifeq 7861
      // 7856: aload 146
      // 7858: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 785b: checkcast net/minecraft/server/level/ServerLevel
      // 785e: goto 7862
      // 7861: aconst_null
      // 7862: bipush 4
      // 7863: aload 146
      // 7865: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7868: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 786d: aload 146
      // 786f: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7872: aload 146
      // 7874: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7877: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 787a: aload 146
      // 787c: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 787f: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7882: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7885: pop
      // 7886: aload 8
      // 7888: astore 146
      // 788a: aload 146
      // 788c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 788f: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7892: ifne 78f1
      // 7895: aload 146
      // 7897: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 789a: ifnull 78f1
      // 789d: aload 146
      // 789f: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 78a2: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 78a5: new net/minecraft/commands/CommandSourceStack
      // 78a8: dup
      // 78a9: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 78ac: aload 146
      // 78ae: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 78b1: aload 146
      // 78b3: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 78b6: aload 146
      // 78b8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 78bb: instanceof net/minecraft/server/level/ServerLevel
      // 78be: ifeq 78cc
      // 78c1: aload 146
      // 78c3: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 78c6: checkcast net/minecraft/server/level/ServerLevel
      // 78c9: goto 78cd
      // 78cc: aconst_null
      // 78cd: bipush 4
      // 78ce: aload 146
      // 78d0: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 78d3: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 78d8: aload 146
      // 78da: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 78dd: aload 146
      // 78df: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 78e2: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 78e5: aload 146
      // 78e7: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 78ea: ldc_w "attribute @s minecraft:player.block_interaction_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e 6 add_value"
      // 78ed: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 78f0: pop
      // 78f1: aload 8
      // 78f3: astore 146
      // 78f5: aload 146
      // 78f7: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 78fa: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 78fd: ifne 795c
      // 7900: aload 146
      // 7902: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7905: ifnull 795c
      // 7908: aload 146
      // 790a: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 790d: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7910: new net/minecraft/commands/CommandSourceStack
      // 7913: dup
      // 7914: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7917: aload 146
      // 7919: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 791c: aload 146
      // 791e: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7921: aload 146
      // 7923: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7926: instanceof net/minecraft/server/level/ServerLevel
      // 7929: ifeq 7937
      // 792c: aload 146
      // 792e: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7931: checkcast net/minecraft/server/level/ServerLevel
      // 7934: goto 7938
      // 7937: aconst_null
      // 7938: bipush 4
      // 7939: aload 146
      // 793b: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 793e: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7943: aload 146
      // 7945: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7948: aload 146
      // 794a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 794d: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7950: aload 146
      // 7952: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7955: ldc_w "/attribute @s forge:attack_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7958: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 795b: pop
      // 795c: aload 8
      // 795e: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7961: ldc_w "arphex_reachmod1"
      // 7964: ldc_w "spatial"
      // 7967: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 796a: goto 7f49
      // 796d: aload 8
      // 796f: instanceof net/minecraft/world/entity/LivingEntity
      // 7972: ifeq 7984
      // 7975: aload 8
      // 7977: checkcast net/minecraft/world/entity/LivingEntity
      // 797a: astore 145
      // 797c: aload 145
      // 797e: invokevirtual net/minecraft/world/entity/LivingEntity.getMainHandItem ()Lnet/minecraft/world/item/ItemStack;
      // 7981: goto 7987
      // 7984: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 7987: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 798a: getstatic net/arphex/init/ArphexModItems.INFINITE_TORMENT Lnet/minecraftforge/registries/RegistryObject;
      // 798d: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 7990: if_acmpne 7f49
      // 7993: aload 8
      // 7995: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7998: ldc_w "arphex_reachmod1"
      // 799b: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 799e: ldc_w "infinite"
      // 79a1: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 79a4: ifne 7f49
      // 79a7: aload 8
      // 79a9: astore 146
      // 79ab: aload 146
      // 79ad: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 79b0: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 79b3: ifne 7a12
      // 79b6: aload 146
      // 79b8: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 79bb: ifnull 7a12
      // 79be: aload 146
      // 79c0: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 79c3: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 79c6: new net/minecraft/commands/CommandSourceStack
      // 79c9: dup
      // 79ca: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 79cd: aload 146
      // 79cf: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 79d2: aload 146
      // 79d4: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 79d7: aload 146
      // 79d9: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 79dc: instanceof net/minecraft/server/level/ServerLevel
      // 79df: ifeq 79ed
      // 79e2: aload 146
      // 79e4: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 79e7: checkcast net/minecraft/server/level/ServerLevel
      // 79ea: goto 79ee
      // 79ed: aconst_null
      // 79ee: bipush 4
      // 79ef: aload 146
      // 79f1: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 79f4: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 79f9: aload 146
      // 79fb: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 79fe: aload 146
      // 7a00: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7a03: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7a06: aload 146
      // 7a08: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7a0b: ldc_w "attribute @s forge:block_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7a0e: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7a11: pop
      // 7a12: aload 8
      // 7a14: astore 146
      // 7a16: aload 146
      // 7a18: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7a1b: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7a1e: ifne 7a7d
      // 7a21: aload 146
      // 7a23: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7a26: ifnull 7a7d
      // 7a29: aload 146
      // 7a2b: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7a2e: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7a31: new net/minecraft/commands/CommandSourceStack
      // 7a34: dup
      // 7a35: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7a38: aload 146
      // 7a3a: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7a3d: aload 146
      // 7a3f: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7a42: aload 146
      // 7a44: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7a47: instanceof net/minecraft/server/level/ServerLevel
      // 7a4a: ifeq 7a58
      // 7a4d: aload 146
      // 7a4f: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7a52: checkcast net/minecraft/server/level/ServerLevel
      // 7a55: goto 7a59
      // 7a58: aconst_null
      // 7a59: bipush 4
      // 7a5a: aload 146
      // 7a5c: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7a5f: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7a64: aload 146
      // 7a66: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7a69: aload 146
      // 7a6b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7a6e: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7a71: aload 146
      // 7a73: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7a76: ldc_w "attribute @s forge:entity_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7a79: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7a7c: pop
      // 7a7d: aload 8
      // 7a7f: astore 146
      // 7a81: aload 146
      // 7a83: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7a86: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7a89: ifne 7ae8
      // 7a8c: aload 146
      // 7a8e: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7a91: ifnull 7ae8
      // 7a94: aload 146
      // 7a96: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7a99: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7a9c: new net/minecraft/commands/CommandSourceStack
      // 7a9f: dup
      // 7aa0: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7aa3: aload 146
      // 7aa5: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7aa8: aload 146
      // 7aaa: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7aad: aload 146
      // 7aaf: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7ab2: instanceof net/minecraft/server/level/ServerLevel
      // 7ab5: ifeq 7ac3
      // 7ab8: aload 146
      // 7aba: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7abd: checkcast net/minecraft/server/level/ServerLevel
      // 7ac0: goto 7ac4
      // 7ac3: aconst_null
      // 7ac4: bipush 4
      // 7ac5: aload 146
      // 7ac7: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7aca: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7acf: aload 146
      // 7ad1: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7ad4: aload 146
      // 7ad6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7ad9: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7adc: aload 146
      // 7ade: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7ae1: ldc_w "attribute @s forge:entity_reach modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 150 add"
      // 7ae4: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7ae7: pop
      // 7ae8: aload 8
      // 7aea: astore 146
      // 7aec: aload 146
      // 7aee: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7af1: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7af4: ifne 7b53
      // 7af7: aload 146
      // 7af9: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7afc: ifnull 7b53
      // 7aff: aload 146
      // 7b01: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7b04: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7b07: new net/minecraft/commands/CommandSourceStack
      // 7b0a: dup
      // 7b0b: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7b0e: aload 146
      // 7b10: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7b13: aload 146
      // 7b15: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7b18: aload 146
      // 7b1a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7b1d: instanceof net/minecraft/server/level/ServerLevel
      // 7b20: ifeq 7b2e
      // 7b23: aload 146
      // 7b25: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7b28: checkcast net/minecraft/server/level/ServerLevel
      // 7b2b: goto 7b2f
      // 7b2e: aconst_null
      // 7b2f: bipush 4
      // 7b30: aload 146
      // 7b32: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7b35: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7b3a: aload 146
      // 7b3c: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7b3f: aload 146
      // 7b41: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7b44: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7b47: aload 146
      // 7b49: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7b4c: ldc_w "attribute @s minecraft:player.block_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7b4f: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7b52: pop
      // 7b53: aload 8
      // 7b55: astore 146
      // 7b57: aload 146
      // 7b59: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7b5c: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7b5f: ifne 7bbe
      // 7b62: aload 146
      // 7b64: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7b67: ifnull 7bbe
      // 7b6a: aload 146
      // 7b6c: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7b6f: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7b72: new net/minecraft/commands/CommandSourceStack
      // 7b75: dup
      // 7b76: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7b79: aload 146
      // 7b7b: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7b7e: aload 146
      // 7b80: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7b83: aload 146
      // 7b85: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7b88: instanceof net/minecraft/server/level/ServerLevel
      // 7b8b: ifeq 7b99
      // 7b8e: aload 146
      // 7b90: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7b93: checkcast net/minecraft/server/level/ServerLevel
      // 7b96: goto 7b9a
      // 7b99: aconst_null
      // 7b9a: bipush 4
      // 7b9b: aload 146
      // 7b9d: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7ba0: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7ba5: aload 146
      // 7ba7: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7baa: aload 146
      // 7bac: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7baf: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7bb2: aload 146
      // 7bb4: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7bb7: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7bba: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7bbd: pop
      // 7bbe: aload 8
      // 7bc0: astore 146
      // 7bc2: aload 146
      // 7bc4: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7bc7: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7bca: ifne 7c29
      // 7bcd: aload 146
      // 7bcf: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7bd2: ifnull 7c29
      // 7bd5: aload 146
      // 7bd7: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7bda: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7bdd: new net/minecraft/commands/CommandSourceStack
      // 7be0: dup
      // 7be1: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7be4: aload 146
      // 7be6: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7be9: aload 146
      // 7beb: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7bee: aload 146
      // 7bf0: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7bf3: instanceof net/minecraft/server/level/ServerLevel
      // 7bf6: ifeq 7c04
      // 7bf9: aload 146
      // 7bfb: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7bfe: checkcast net/minecraft/server/level/ServerLevel
      // 7c01: goto 7c05
      // 7c04: aconst_null
      // 7c05: bipush 4
      // 7c06: aload 146
      // 7c08: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7c0b: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7c10: aload 146
      // 7c12: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7c15: aload 146
      // 7c17: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7c1a: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7c1d: aload 146
      // 7c1f: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7c22: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e 150 add_value"
      // 7c25: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7c28: pop
      // 7c29: aload 8
      // 7c2b: astore 146
      // 7c2d: aload 146
      // 7c2f: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7c32: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7c35: ifne 7c94
      // 7c38: aload 146
      // 7c3a: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7c3d: ifnull 7c94
      // 7c40: aload 146
      // 7c42: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7c45: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7c48: new net/minecraft/commands/CommandSourceStack
      // 7c4b: dup
      // 7c4c: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7c4f: aload 146
      // 7c51: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7c54: aload 146
      // 7c56: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7c59: aload 146
      // 7c5b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7c5e: instanceof net/minecraft/server/level/ServerLevel
      // 7c61: ifeq 7c6f
      // 7c64: aload 146
      // 7c66: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7c69: checkcast net/minecraft/server/level/ServerLevel
      // 7c6c: goto 7c70
      // 7c6f: aconst_null
      // 7c70: bipush 4
      // 7c71: aload 146
      // 7c73: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7c76: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7c7b: aload 146
      // 7c7d: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7c80: aload 146
      // 7c82: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7c85: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7c88: aload 146
      // 7c8a: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7c8d: ldc_w "/attribute @s forge:attack_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7c90: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7c93: pop
      // 7c94: aload 8
      // 7c96: astore 146
      // 7c98: aload 146
      // 7c9a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7c9d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7ca0: ifne 7cff
      // 7ca3: aload 146
      // 7ca5: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7ca8: ifnull 7cff
      // 7cab: aload 146
      // 7cad: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7cb0: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7cb3: new net/minecraft/commands/CommandSourceStack
      // 7cb6: dup
      // 7cb7: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7cba: aload 146
      // 7cbc: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7cbf: aload 146
      // 7cc1: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7cc4: aload 146
      // 7cc6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7cc9: instanceof net/minecraft/server/level/ServerLevel
      // 7ccc: ifeq 7cda
      // 7ccf: aload 146
      // 7cd1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7cd4: checkcast net/minecraft/server/level/ServerLevel
      // 7cd7: goto 7cdb
      // 7cda: aconst_null
      // 7cdb: bipush 4
      // 7cdc: aload 146
      // 7cde: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7ce1: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7ce6: aload 146
      // 7ce8: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7ceb: aload 146
      // 7ced: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7cf0: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7cf3: aload 146
      // 7cf5: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7cf8: ldc_w "attribute @s forge:attack_range modifier add d08c99dd-c47a-4c6f-842f-084efe6ef91e arphexreach 150 add"
      // 7cfb: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7cfe: pop
      // 7cff: aload 8
      // 7d01: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7d04: ldc_w "arphex_reachmod1"
      // 7d07: ldc_w "infinite"
      // 7d0a: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 7d0d: goto 7f49
      // 7d10: aload 8
      // 7d12: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7d15: ldc_w "arphex_reachmod1"
      // 7d18: invokevirtual net/minecraft/nbt/CompoundTag.getString (Ljava/lang/String;)Ljava/lang/String;
      // 7d1b: ldc_w "none"
      // 7d1e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7d21: ifne 7f49
      // 7d24: aload 8
      // 7d26: astore 140
      // 7d28: aload 140
      // 7d2a: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7d2d: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7d30: ifne 7d8f
      // 7d33: aload 140
      // 7d35: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7d38: ifnull 7d8f
      // 7d3b: aload 140
      // 7d3d: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7d40: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7d43: new net/minecraft/commands/CommandSourceStack
      // 7d46: dup
      // 7d47: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7d4a: aload 140
      // 7d4c: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7d4f: aload 140
      // 7d51: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7d54: aload 140
      // 7d56: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7d59: instanceof net/minecraft/server/level/ServerLevel
      // 7d5c: ifeq 7d6a
      // 7d5f: aload 140
      // 7d61: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7d64: checkcast net/minecraft/server/level/ServerLevel
      // 7d67: goto 7d6b
      // 7d6a: aconst_null
      // 7d6b: bipush 4
      // 7d6c: aload 140
      // 7d6e: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7d71: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7d76: aload 140
      // 7d78: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7d7b: aload 140
      // 7d7d: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7d80: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7d83: aload 140
      // 7d85: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7d88: ldc_w "attribute @s forge:block_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7d8b: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7d8e: pop
      // 7d8f: aload 8
      // 7d91: astore 140
      // 7d93: aload 140
      // 7d95: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7d98: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7d9b: ifne 7dfa
      // 7d9e: aload 140
      // 7da0: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7da3: ifnull 7dfa
      // 7da6: aload 140
      // 7da8: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7dab: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7dae: new net/minecraft/commands/CommandSourceStack
      // 7db1: dup
      // 7db2: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7db5: aload 140
      // 7db7: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7dba: aload 140
      // 7dbc: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7dbf: aload 140
      // 7dc1: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7dc4: instanceof net/minecraft/server/level/ServerLevel
      // 7dc7: ifeq 7dd5
      // 7dca: aload 140
      // 7dcc: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7dcf: checkcast net/minecraft/server/level/ServerLevel
      // 7dd2: goto 7dd6
      // 7dd5: aconst_null
      // 7dd6: bipush 4
      // 7dd7: aload 140
      // 7dd9: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7ddc: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7de1: aload 140
      // 7de3: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7de6: aload 140
      // 7de8: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7deb: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7dee: aload 140
      // 7df0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7df3: ldc_w "attribute @s minecraft:player.block_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7df6: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7df9: pop
      // 7dfa: aload 8
      // 7dfc: astore 140
      // 7dfe: aload 140
      // 7e00: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7e03: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7e06: ifne 7e65
      // 7e09: aload 140
      // 7e0b: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7e0e: ifnull 7e65
      // 7e11: aload 140
      // 7e13: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7e16: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7e19: new net/minecraft/commands/CommandSourceStack
      // 7e1c: dup
      // 7e1d: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7e20: aload 140
      // 7e22: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7e25: aload 140
      // 7e27: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7e2a: aload 140
      // 7e2c: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7e2f: instanceof net/minecraft/server/level/ServerLevel
      // 7e32: ifeq 7e40
      // 7e35: aload 140
      // 7e37: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7e3a: checkcast net/minecraft/server/level/ServerLevel
      // 7e3d: goto 7e41
      // 7e40: aconst_null
      // 7e41: bipush 4
      // 7e42: aload 140
      // 7e44: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7e47: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7e4c: aload 140
      // 7e4e: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7e51: aload 140
      // 7e53: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7e56: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7e59: aload 140
      // 7e5b: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7e5e: ldc_w "attribute @s minecraft:player.entity_interaction_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7e61: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7e64: pop
      // 7e65: aload 8
      // 7e67: astore 140
      // 7e69: aload 140
      // 7e6b: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7e6e: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7e71: ifne 7ed0
      // 7e74: aload 140
      // 7e76: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7e79: ifnull 7ed0
      // 7e7c: aload 140
      // 7e7e: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7e81: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7e84: new net/minecraft/commands/CommandSourceStack
      // 7e87: dup
      // 7e88: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7e8b: aload 140
      // 7e8d: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7e90: aload 140
      // 7e92: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7e95: aload 140
      // 7e97: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7e9a: instanceof net/minecraft/server/level/ServerLevel
      // 7e9d: ifeq 7eab
      // 7ea0: aload 140
      // 7ea2: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7ea5: checkcast net/minecraft/server/level/ServerLevel
      // 7ea8: goto 7eac
      // 7eab: aconst_null
      // 7eac: bipush 4
      // 7ead: aload 140
      // 7eaf: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7eb2: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7eb7: aload 140
      // 7eb9: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7ebc: aload 140
      // 7ebe: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7ec1: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7ec4: aload 140
      // 7ec6: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7ec9: ldc_w "attribute @s forge:entity_reach modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7ecc: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7ecf: pop
      // 7ed0: aload 8
      // 7ed2: astore 140
      // 7ed4: aload 140
      // 7ed6: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7ed9: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 7edc: ifne 7f3b
      // 7edf: aload 140
      // 7ee1: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7ee4: ifnull 7f3b
      // 7ee7: aload 140
      // 7ee9: invokevirtual net/minecraft/world/entity/Entity.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7eec: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 7eef: new net/minecraft/commands/CommandSourceStack
      // 7ef2: dup
      // 7ef3: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 7ef6: aload 140
      // 7ef8: invokevirtual net/minecraft/world/entity/Entity.position ()Lnet/minecraft/world/phys/Vec3;
      // 7efb: aload 140
      // 7efd: invokevirtual net/minecraft/world/entity/Entity.getRotationVector ()Lnet/minecraft/world/phys/Vec2;
      // 7f00: aload 140
      // 7f02: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7f05: instanceof net/minecraft/server/level/ServerLevel
      // 7f08: ifeq 7f16
      // 7f0b: aload 140
      // 7f0d: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7f10: checkcast net/minecraft/server/level/ServerLevel
      // 7f13: goto 7f17
      // 7f16: aconst_null
      // 7f17: bipush 4
      // 7f18: aload 140
      // 7f1a: invokevirtual net/minecraft/world/entity/Entity.getName ()Lnet/minecraft/network/chat/Component;
      // 7f1d: invokeinterface net/minecraft/network/chat/Component.getString ()Ljava/lang/String; 1
      // 7f22: aload 140
      // 7f24: invokevirtual net/minecraft/world/entity/Entity.getDisplayName ()Lnet/minecraft/network/chat/Component;
      // 7f27: aload 140
      // 7f29: invokevirtual net/minecraft/world/entity/Entity.level ()Lnet/minecraft/world/level/Level;
      // 7f2c: invokevirtual net/minecraft/world/level/Level.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 7f2f: aload 140
      // 7f31: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 7f34: ldc_w "/attribute @s forge:attack_range modifier remove d08c99dd-c47a-4c6f-842f-084efe6ef91e"
      // 7f37: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 7f3a: pop
      // 7f3b: aload 8
      // 7f3d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7f40: ldc_w "arphex_reachmod1"
      // 7f43: ldc_w "none"
      // 7f46: invokevirtual net/minecraft/nbt/CompoundTag.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 7f49: aload 8
      // 7f4b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7f4e: ldc_w "recoil_genesis"
      // 7f51: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7f54: dconst_0
      // 7f55: dcmpl
      // 7f56: ifle 7ff8
      // 7f59: aload 8
      // 7f5b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7f5e: ldc_w "recoil_genesis"
      // 7f61: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7f64: ldc2_w 19.0
      // 7f67: dcmpg
      // 7f68: ifge 7fe0
      // 7f6b: aload 8
      // 7f6d: astore 134
      // 7f6f: aload 134
      // 7f71: aload 8
      // 7f73: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 7f76: invokevirtual net/minecraft/world/entity/Entity.setYRot (F)V
      // 7f79: aload 134
      // 7f7b: aload 8
      // 7f7d: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 7f80: f2d
      // 7f81: aload 8
      // 7f83: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7f86: ldc_w "recoil_genesis"
      // 7f89: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7f8c: ldc2_w 7.0
      // 7f8f: ddiv
      // 7f90: dsub
      // 7f91: d2f
      // 7f92: invokevirtual net/minecraft/world/entity/Entity.setXRot (F)V
      // 7f95: aload 134
      // 7f97: aload 134
      // 7f99: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 7f9c: invokevirtual net/minecraft/world/entity/Entity.setYBodyRot (F)V
      // 7f9f: aload 134
      // 7fa1: aload 134
      // 7fa3: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 7fa6: invokevirtual net/minecraft/world/entity/Entity.setYHeadRot (F)V
      // 7fa9: aload 134
      // 7fab: aload 134
      // 7fad: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 7fb0: putfield net/minecraft/world/entity/Entity.yRotO F
      // 7fb3: aload 134
      // 7fb5: aload 134
      // 7fb7: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 7fba: putfield net/minecraft/world/entity/Entity.xRotO F
      // 7fbd: aload 134
      // 7fbf: instanceof net/minecraft/world/entity/LivingEntity
      // 7fc2: ifeq 7fe0
      // 7fc5: aload 134
      // 7fc7: checkcast net/minecraft/world/entity/LivingEntity
      // 7fca: astore 135
      // 7fcc: aload 135
      // 7fce: aload 135
      // 7fd0: invokevirtual net/minecraft/world/entity/LivingEntity.getYRot ()F
      // 7fd3: putfield net/minecraft/world/entity/LivingEntity.yBodyRotO F
      // 7fd6: aload 135
      // 7fd8: aload 135
      // 7fda: invokevirtual net/minecraft/world/entity/LivingEntity.getYRot ()F
      // 7fdd: putfield net/minecraft/world/entity/LivingEntity.yHeadRotO F
      // 7fe0: aload 8
      // 7fe2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7fe5: ldc_w "recoil_genesis"
      // 7fe8: aload 8
      // 7fea: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 7fed: ldc_w "recoil_genesis"
      // 7ff0: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 7ff3: dconst_1
      // 7ff4: dsub
      // 7ff5: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 7ff8: aload 8
      // 7ffa: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 7ffd: aconst_null
      // 7ffe: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 8001: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 8004: dup
      // 8005: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 8008: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 800b: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 800e: getfield net/arphex/network/ArphexModVariables$PlayerVariables.track_warp_cooldown D
      // 8011: dconst_0
      // 8012: dcmpl
      // 8013: ifle 8048
      // 8016: aload 8
      // 8018: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 801b: aconst_null
      // 801c: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 801f: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 8022: dup
      // 8023: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 8026: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 8029: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 802c: getfield net/arphex/network/ArphexModVariables$PlayerVariables.track_warp_cooldown D
      // 802f: dconst_1
      // 8030: dsub
      // 8031: dstore 134
      // 8033: aload 8
      // 8035: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 8038: aconst_null
      // 8039: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 803c: dload 134
      // 803e: aload 8
      // 8040: invokedynamic accept (DLnet/minecraft/world/entity/Entity;)Lnet/minecraftforge/common/util/NonNullConsumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$121 (DLnet/minecraft/world/entity/Entity;Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V, (Lnet/arphex/network/ArphexModVariables$PlayerVariables;)V ]
      // 8045: invokevirtual net/minecraftforge/common/util/LazyOptional.ifPresent (Lnet/minecraftforge/common/util/NonNullConsumer;)V
      // 8048: aload 8
      // 804a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 804d: ldc_w "allow_floatingsequence"
      // 8050: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8053: dconst_0
      // 8054: dcmpl
      // 8055: ifle 876d
      // 8058: aload 8
      // 805a: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 805d: ldc_w "allow_floatingsequence"
      // 8060: aload 8
      // 8062: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8065: ldc_w "allow_floatingsequence"
      // 8068: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 806b: dconst_1
      // 806c: dsub
      // 806d: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8070: aload 8
      // 8072: instanceof net/minecraft/world/entity/LivingEntity
      // 8075: ifeq 8112
      // 8078: aload 8
      // 807a: checkcast net/minecraft/world/entity/LivingEntity
      // 807d: astore 134
      // 807f: aload 134
      // 8081: invokevirtual net/minecraft/world/entity/LivingEntity.isFallFlying ()Z
      // 8084: ifeq 8112
      // 8087: aload 8
      // 8089: instanceof net/minecraft/world/entity/LivingEntity
      // 808c: ifeq 80a1
      // 808f: aload 8
      // 8091: checkcast net/minecraft/world/entity/LivingEntity
      // 8094: astore 135
      // 8096: aload 135
      // 8098: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 809b: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 809e: goto 80a4
      // 80a1: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 80a4: invokevirtual net/minecraft/world/item/ItemStack.getItem ()Lnet/minecraft/world/item/Item;
      // 80a7: getstatic net/minecraft/world/item/Items.ELYTRA Lnet/minecraft/world/item/Item;
      // 80aa: if_acmpne 8112
      // 80ad: aload 8
      // 80af: instanceof net/minecraft/world/entity/LivingEntity
      // 80b2: ifeq 80c7
      // 80b5: aload 8
      // 80b7: checkcast net/minecraft/world/entity/LivingEntity
      // 80ba: astore 136
      // 80bc: aload 136
      // 80be: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 80c1: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 80c4: goto 80ca
      // 80c7: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 80ca: invokevirtual net/minecraft/world/item/ItemStack.getDamageValue ()I
      // 80cd: ifle 8112
      // 80d0: aload 8
      // 80d2: instanceof net/minecraft/world/entity/LivingEntity
      // 80d5: ifeq 80ea
      // 80d8: aload 8
      // 80da: checkcast net/minecraft/world/entity/LivingEntity
      // 80dd: astore 137
      // 80df: aload 137
      // 80e1: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 80e4: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 80e7: goto 80ed
      // 80ea: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 80ed: aload 8
      // 80ef: instanceof net/minecraft/world/entity/LivingEntity
      // 80f2: ifeq 8107
      // 80f5: aload 8
      // 80f7: checkcast net/minecraft/world/entity/LivingEntity
      // 80fa: astore 137
      // 80fc: aload 137
      // 80fe: getstatic net/minecraft/world/entity/EquipmentSlot.CHEST Lnet/minecraft/world/entity/EquipmentSlot;
      // 8101: invokevirtual net/minecraft/world/entity/LivingEntity.getItemBySlot (Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;
      // 8104: goto 810a
      // 8107: getstatic net/minecraft/world/item/ItemStack.EMPTY Lnet/minecraft/world/item/ItemStack;
      // 810a: invokevirtual net/minecraft/world/item/ItemStack.getDamageValue ()I
      // 810d: bipush 1
      // 810e: isub
      // 810f: invokevirtual net/minecraft/world/item/ItemStack.setDamageValue (I)V
      // 8112: aload 8
      // 8114: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8117: ldc_w "ringspin"
      // 811a: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 811d: dconst_0
      // 811e: dcmpg
      // 811f: ifgt 8133
      // 8122: aload 8
      // 8124: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8127: ldc_w "ringspin"
      // 812a: ldc2_w 360.0
      // 812d: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8130: goto 814d
      // 8133: aload 8
      // 8135: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8138: ldc_w "ringspin"
      // 813b: aload 8
      // 813d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8140: ldc_w "ringspin"
      // 8143: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8146: ldc2_w 25.0
      // 8149: dsub
      // 814a: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 814d: aload 8
      // 814f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8152: ldc_w "creativespectator"
      // 8155: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 8158: ifeq 8167
      // 815b: aload 8
      // 815d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8160: ldc_w "abflymode"
      // 8163: bipush 0
      // 8164: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 8167: aload 8
      // 8169: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 816c: ldc_w "abflymode"
      // 816f: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 8172: ifne 8195
      // 8175: aload 8
      // 8177: instanceof net/minecraft/world/entity/LivingEntity
      // 817a: ifeq 8258
      // 817d: aload 8
      // 817f: checkcast net/minecraft/world/entity/LivingEntity
      // 8182: astore 134
      // 8184: aload 134
      // 8186: getstatic net/arphex/init/ArphexModMobEffects.AB_FLIGHT Lnet/minecraftforge/registries/RegistryObject;
      // 8189: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 818c: checkcast net/minecraft/world/effect/MobEffect
      // 818f: invokevirtual net/minecraft/world/entity/LivingEntity.hasEffect (Lnet/minecraft/world/effect/MobEffect;)Z
      // 8192: ifeq 8258
      // 8195: aload 1
      // 8196: instanceof net/minecraft/server/level/ServerLevel
      // 8199: ifeq 81ea
      // 819c: aload 1
      // 819d: checkcast net/minecraft/server/level/ServerLevel
      // 81a0: astore 135
      // 81a2: aload 135
      // 81a4: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 81a7: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 81aa: new net/minecraft/commands/CommandSourceStack
      // 81ad: dup
      // 81ae: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 81b1: new net/minecraft/world/phys/Vec3
      // 81b4: dup
      // 81b5: dload 2
      // 81b6: dload 4
      // 81b8: dload 6
      // 81ba: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 81bd: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 81c0: aload 135
      // 81c2: bipush 4
      // 81c3: ldc ""
      // 81c5: ldc ""
      // 81c7: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 81ca: aload 135
      // 81cc: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 81cf: aconst_null
      // 81d0: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 81d3: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 81d6: aload 8
      // 81d8: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 81db: ldc_w "ringspin"
      // 81de: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 81e1: invokedynamic makeConcatWithConstants (D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute as @p at @s rotated \u0001 3 as @p run particle arphex:fire_opal_shards ^ ^0.3 ^1.5" ]
      // 81e6: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 81e9: pop
      // 81ea: aload 1
      // 81eb: instanceof net/minecraft/server/level/ServerLevel
      // 81ee: ifeq 823f
      // 81f1: aload 1
      // 81f2: checkcast net/minecraft/server/level/ServerLevel
      // 81f5: astore 135
      // 81f7: aload 135
      // 81f9: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 81fc: invokevirtual net/minecraft/server/MinecraftServer.getCommands ()Lnet/minecraft/commands/Commands;
      // 81ff: new net/minecraft/commands/CommandSourceStack
      // 8202: dup
      // 8203: getstatic net/minecraft/commands/CommandSource.NULL Lnet/minecraft/commands/CommandSource;
      // 8206: new net/minecraft/world/phys/Vec3
      // 8209: dup
      // 820a: dload 2
      // 820b: dload 4
      // 820d: dload 6
      // 820f: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 8212: getstatic net/minecraft/world/phys/Vec2.ZERO Lnet/minecraft/world/phys/Vec2;
      // 8215: aload 135
      // 8217: bipush 4
      // 8218: ldc ""
      // 821a: ldc ""
      // 821c: invokestatic net/minecraft/network/chat/Component.literal (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
      // 821f: aload 135
      // 8221: invokevirtual net/minecraft/server/level/ServerLevel.getServer ()Lnet/minecraft/server/MinecraftServer;
      // 8224: aconst_null
      // 8225: invokespecial net/minecraft/commands/CommandSourceStack.<init> (Lnet/minecraft/commands/CommandSource;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec2;Lnet/minecraft/server/level/ServerLevel;ILjava/lang/String;Lnet/minecraft/network/chat/Component;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/entity/Entity;)V
      // 8228: invokevirtual net/minecraft/commands/CommandSourceStack.withSuppressedOutput ()Lnet/minecraft/commands/CommandSourceStack;
      // 822b: aload 8
      // 822d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8230: ldc_w "ringspin"
      // 8233: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8236: invokedynamic makeConcatWithConstants (D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "execute as @p at @s rotated \u0001 3 as @p run particle arphex:heavy_red_smoke ^ ^0.3 ^1.5" ]
      // 823b: invokevirtual net/minecraft/commands/Commands.performPrefixedCommand (Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I
      // 823e: pop
      // 823f: aload 1
      // 8240: getstatic net/arphex/init/ArphexModParticleTypes.HEAVY_RED_SMOKE Lnet/minecraftforge/registries/RegistryObject;
      // 8243: invokevirtual net/minecraftforge/registries/RegistryObject.get ()Ljava/lang/Object;
      // 8246: checkcast net/minecraft/core/particles/SimpleParticleType
      // 8249: dload 2
      // 824a: dload 4
      // 824c: dconst_1
      // 824d: dsub
      // 824e: dload 6
      // 8250: dconst_0
      // 8251: dconst_0
      // 8252: dconst_0
      // 8253: invokeinterface net/minecraft/world/level/LevelAccessor.addParticle (Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V 14
      // 8258: aload 8
      // 825a: invokevirtual net/minecraft/world/entity/Entity.onGround ()Z
      // 825d: ifne 8298
      // 8260: aload 8
      // 8262: invokevirtual net/minecraft/world/entity/Entity.isInLava ()Z
      // 8265: ifne 8298
      // 8268: aload 8
      // 826a: invokevirtual net/minecraft/world/entity/Entity.isInWaterRainOrBubble ()Z
      // 826d: ifne 8298
      // 8270: aload 1
      // 8271: dload 2
      // 8272: dload 4
      // 8274: ldc2_w 1.5
      // 8277: dsub
      // 8278: dload 6
      // 827a: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 827d: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8282: ifeq 8298
      // 8285: aload 1
      // 8286: dload 2
      // 8287: dload 4
      // 8289: dconst_1
      // 828a: dsub
      // 828b: dload 6
      // 828d: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 8290: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8295: ifne 82f7
      // 8298: aload 8
      // 829a: invokevirtual net/minecraft/world/entity/Entity.onGround ()Z
      // 829d: ifeq 82ac
      // 82a0: aload 8
      // 82a2: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 82a5: ldc_w "abflymode"
      // 82a8: bipush 0
      // 82a9: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 82ac: aload 8
      // 82ae: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 82b1: ldc_w "abflytime"
      // 82b4: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 82b7: ldc2_w 80.0
      // 82ba: dcmpg
      // 82bb: ifge 82f7
      // 82be: aload 8
      // 82c0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 82c3: ldc_w "abflytime"
      // 82c6: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 82c9: dconst_0
      // 82ca: dcmpl
      // 82cb: iflt 82eb
      // 82ce: aload 8
      // 82d0: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 82d3: ldc_w "abflytime"
      // 82d6: aload 8
      // 82d8: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 82db: ldc_w "abflytime"
      // 82de: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 82e1: ldc2_w 2.0
      // 82e4: dadd
      // 82e5: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 82e8: goto 82f7
      // 82eb: aload 8
      // 82ed: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 82f0: ldc_w "abflytime"
      // 82f3: dconst_0
      // 82f4: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 82f7: aload 8
      // 82f9: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 82fc: ldc_w "creativespectator"
      // 82ff: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 8302: ifeq 8313
      // 8305: aload 8
      // 8307: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 830a: ldc_w "abflytime"
      // 830d: ldc2_w 80.0
      // 8310: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8313: aload 8
      // 8315: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8318: ldc_w "abflymode"
      // 831b: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 831e: ifeq 86e5
      // 8321: aload 8
      // 8323: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8326: ldc_w "abflytime"
      // 8329: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 832c: dconst_0
      // 832d: dcmpl
      // 832e: ifle 86e5
      // 8331: aload 8
      // 8333: instanceof net/minecraft/world/entity/LivingEntity
      // 8336: ifeq 8364
      // 8339: aload 8
      // 833b: checkcast net/minecraft/world/entity/LivingEntity
      // 833e: astore 134
      // 8340: aload 134
      // 8342: invokevirtual net/minecraft/world/entity/LivingEntity.isFallFlying ()Z
      // 8345: ifeq 8364
      // 8348: aload 8
      // 834a: instanceof net/minecraft/world/entity/player/Player
      // 834d: ifeq 8364
      // 8350: aload 8
      // 8352: checkcast net/minecraft/world/entity/player/Player
      // 8355: astore 135
      // 8357: aload 135
      // 8359: invokevirtual net/minecraft/world/entity/player/Player.isFallFlying ()Z
      // 835c: ifeq 8364
      // 835f: aload 135
      // 8361: invokevirtual net/minecraft/world/entity/player/Player.stopFallFlying ()V
      // 8364: aload 8
      // 8366: instanceof net/minecraft/world/entity/LivingEntity
      // 8369: ifeq 8393
      // 836c: aload 8
      // 836e: checkcast net/minecraft/world/entity/LivingEntity
      // 8371: astore 134
      // 8373: aload 134
      // 8375: invokevirtual net/minecraft/world/entity/LivingEntity.level ()Lnet/minecraft/world/level/Level;
      // 8378: invokevirtual net/minecraft/world/level/Level.isClientSide ()Z
      // 837b: ifne 8393
      // 837e: aload 134
      // 8380: new net/minecraft/world/effect/MobEffectInstance
      // 8383: dup
      // 8384: getstatic net/minecraft/world/effect/MobEffects.MOVEMENT_SPEED Lnet/minecraft/world/effect/MobEffect;
      // 8387: bipush 10
      // 8389: bipush 1
      // 838a: bipush 0
      // 838b: bipush 0
      // 838c: invokespecial net/minecraft/world/effect/MobEffectInstance.<init> (Lnet/minecraft/world/effect/MobEffect;IIZZ)V
      // 838f: invokevirtual net/minecraft/world/entity/LivingEntity.addEffect (Lnet/minecraft/world/effect/MobEffectInstance;)Z
      // 8392: pop
      // 8393: aload 8
      // 8395: invokevirtual net/minecraft/world/entity/Entity.isSprinting ()Z
      // 8398: ifeq 8457
      // 839b: aload 8
      // 839d: new net/minecraft/world/phys/Vec3
      // 83a0: dup
      // 83a1: aload 8
      // 83a3: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 83a6: ldc_w 90.0
      // 83a9: fadd
      // 83aa: f2d
      // 83ab: ldc2_w 0.017453292519943295
      // 83ae: dmul
      // 83af: invokestatic java/lang/Math.cos (D)D
      // 83b2: dconst_1
      // 83b3: ddiv
      // 83b4: aload 8
      // 83b6: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 83b9: invokevirtual net/minecraft/world/phys/Vec3.y ()D
      // 83bc: aload 8
      // 83be: invokevirtual net/minecraft/world/entity/Entity.getYRot ()F
      // 83c1: ldc_w 90.0
      // 83c4: fadd
      // 83c5: f2d
      // 83c6: ldc2_w 0.017453292519943295
      // 83c9: dmul
      // 83ca: invokestatic java/lang/Math.sin (D)D
      // 83cd: dconst_1
      // 83ce: ddiv
      // 83cf: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 83d2: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 83d5: aload 8
      // 83d7: invokevirtual net/minecraft/world/entity/Entity.isShiftKeyDown ()Z
      // 83da: ifne 8457
      // 83dd: aload 8
      // 83df: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 83e2: aconst_null
      // 83e3: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 83e6: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 83e9: dup
      // 83ea: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 83ed: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 83f0: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 83f3: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 83f6: ifne 8457
      // 83f9: aload 8
      // 83fb: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 83fe: fconst_0
      // 83ff: fcmpl
      // 8400: ifle 842e
      // 8403: aload 8
      // 8405: new net/minecraft/world/phys/Vec3
      // 8408: dup
      // 8409: aload 8
      // 840b: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 840e: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 8411: fconst_0
      // 8412: aload 8
      // 8414: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 8417: fsub
      // 8418: ldc_w 75.0
      // 841b: fdiv
      // 841c: f2d
      // 841d: aload 8
      // 841f: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 8422: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 8425: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 8428: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 842b: goto 8457
      // 842e: aload 8
      // 8430: new net/minecraft/world/phys/Vec3
      // 8433: dup
      // 8434: aload 8
      // 8436: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 8439: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 843c: aload 8
      // 843e: invokevirtual net/minecraft/world/entity/Entity.getXRot ()F
      // 8441: invokestatic java/lang/Math.abs (F)F
      // 8444: ldc_w 75.0
      // 8447: fdiv
      // 8448: f2d
      // 8449: aload 8
      // 844b: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 844e: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 8451: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 8454: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 8457: aload 8
      // 8459: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 845c: aconst_null
      // 845d: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 8460: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 8463: dup
      // 8464: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 8467: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 846a: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 846d: getfield net/arphex/network/ArphexModVariables$PlayerVariables.holdingspace Z
      // 8470: ifeq 84fb
      // 8473: aload 8
      // 8475: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8478: ldc_w "slowcharge"
      // 847b: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 847e: dconst_1
      // 847f: dcmpg
      // 8480: ifge 849d
      // 8483: aload 8
      // 8485: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8488: ldc_w "slowcharge"
      // 848b: aload 8
      // 848d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8490: ldc_w "slowcharge"
      // 8493: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8496: ldc2_w 0.05
      // 8499: dadd
      // 849a: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 849d: aload 8
      // 849f: invokevirtual net/minecraft/world/entity/Entity.isShiftKeyDown ()Z
      // 84a2: ifeq 84c5
      // 84a5: aload 8
      // 84a7: new net/minecraft/world/phys/Vec3
      // 84aa: dup
      // 84ab: aload 8
      // 84ad: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 84b0: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 84b3: dconst_0
      // 84b4: aload 8
      // 84b6: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 84b9: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 84bc: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 84bf: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 84c2: goto 84ec
      // 84c5: aload 8
      // 84c7: new net/minecraft/world/phys/Vec3
      // 84ca: dup
      // 84cb: aload 8
      // 84cd: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 84d0: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 84d3: aload 8
      // 84d5: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 84d8: ldc_w "slowcharge"
      // 84db: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 84de: aload 8
      // 84e0: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 84e3: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 84e6: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 84e9: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 84ec: aload 8
      // 84ee: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 84f1: ldc_w "slowcharge2"
      // 84f4: dconst_0
      // 84f5: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 84f8: goto 86fd
      // 84fb: aload 8
      // 84fd: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8500: ldc_w "slowcharge"
      // 8503: dconst_0
      // 8504: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8507: aload 8
      // 8509: invokevirtual net/minecraft/world/entity/Entity.isShiftKeyDown ()Z
      // 850c: ifeq 8565
      // 850f: aload 8
      // 8511: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8514: ldc_w "slowcharge2"
      // 8517: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 851a: ldc2_w -1.0
      // 851d: dcmpl
      // 851e: ifle 853b
      // 8521: aload 8
      // 8523: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8526: ldc_w "slowcharge2"
      // 8529: aload 8
      // 852b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 852e: ldc_w "slowcharge2"
      // 8531: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8534: ldc2_w 0.05
      // 8537: dsub
      // 8538: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 853b: aload 8
      // 853d: new net/minecraft/world/phys/Vec3
      // 8540: dup
      // 8541: aload 8
      // 8543: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 8546: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 8549: aload 8
      // 854b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 854e: ldc_w "slowcharge2"
      // 8551: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8554: aload 8
      // 8556: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 8559: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 855c: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 855f: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 8562: goto 86fd
      // 8565: aload 8
      // 8567: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 856a: ldc_w "slowcharge2"
      // 856d: dconst_0
      // 856e: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8571: aload 8
      // 8573: invokevirtual net/minecraft/world/entity/Entity.isSprinting ()Z
      // 8576: ifne 86fd
      // 8579: aload 8
      // 857b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 857e: ldc_w "uplev"
      // 8581: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 8584: ifeq 85de
      // 8587: aload 1
      // 8588: dload 2
      // 8589: dload 4
      // 858b: dconst_1
      // 858c: dsub
      // 858d: dload 6
      // 858f: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 8592: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8597: ifeq 85bc
      // 859a: aload 8
      // 859c: new net/minecraft/world/phys/Vec3
      // 859f: dup
      // 85a0: aload 8
      // 85a2: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 85a5: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 85a8: ldc2_w 0.02
      // 85ab: aload 8
      // 85ad: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 85b0: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 85b3: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 85b6: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 85b9: goto 86fd
      // 85bc: aload 8
      // 85be: new net/minecraft/world/phys/Vec3
      // 85c1: dup
      // 85c2: aload 8
      // 85c4: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 85c7: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 85ca: ldc2_w 0.04
      // 85cd: aload 8
      // 85cf: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 85d2: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 85d5: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 85d8: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 85db: goto 86fd
      // 85de: aload 1
      // 85df: dload 2
      // 85e0: dload 4
      // 85e2: dconst_1
      // 85e3: dsub
      // 85e4: dload 6
      // 85e6: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 85e9: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 85ee: ifeq 86c3
      // 85f1: aload 1
      // 85f2: dload 2
      // 85f3: dconst_1
      // 85f4: dsub
      // 85f5: dload 4
      // 85f7: dconst_1
      // 85f8: dsub
      // 85f9: dload 6
      // 85fb: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 85fe: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8603: ifeq 86c3
      // 8606: aload 1
      // 8607: dload 2
      // 8608: dconst_1
      // 8609: dadd
      // 860a: dload 4
      // 860c: dconst_1
      // 860d: dsub
      // 860e: dload 6
      // 8610: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 8613: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8618: ifeq 86c3
      // 861b: aload 1
      // 861c: dload 2
      // 861d: dload 4
      // 861f: dconst_1
      // 8620: dsub
      // 8621: dload 6
      // 8623: dconst_1
      // 8624: dadd
      // 8625: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 8628: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 862d: ifeq 86c3
      // 8630: aload 1
      // 8631: dload 2
      // 8632: dload 4
      // 8634: dconst_1
      // 8635: dsub
      // 8636: dload 6
      // 8638: dconst_1
      // 8639: dsub
      // 863a: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 863d: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8642: ifeq 86c3
      // 8645: aload 1
      // 8646: dload 2
      // 8647: dconst_1
      // 8648: dsub
      // 8649: dload 4
      // 864b: dconst_1
      // 864c: dsub
      // 864d: dload 6
      // 864f: dconst_1
      // 8650: dsub
      // 8651: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 8654: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8659: ifeq 86c3
      // 865c: aload 1
      // 865d: dload 2
      // 865e: dconst_1
      // 865f: dadd
      // 8660: dload 4
      // 8662: dconst_1
      // 8663: dsub
      // 8664: dload 6
      // 8666: dconst_1
      // 8667: dsub
      // 8668: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 866b: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8670: ifeq 86c3
      // 8673: aload 1
      // 8674: dload 2
      // 8675: dconst_1
      // 8676: dadd
      // 8677: dload 4
      // 8679: dconst_1
      // 867a: dsub
      // 867b: dload 6
      // 867d: dconst_1
      // 867e: dadd
      // 867f: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 8682: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 8687: ifeq 86c3
      // 868a: aload 1
      // 868b: dload 2
      // 868c: dconst_1
      // 868d: dadd
      // 868e: dload 4
      // 8690: dconst_1
      // 8691: dsub
      // 8692: dload 6
      // 8694: dconst_1
      // 8695: dsub
      // 8696: invokestatic net/minecraft/core/BlockPos.containing (DDD)Lnet/minecraft/core/BlockPos;
      // 8699: invokeinterface net/minecraft/world/level/LevelAccessor.isEmptyBlock (Lnet/minecraft/core/BlockPos;)Z 2
      // 869e: ifeq 86c3
      // 86a1: aload 8
      // 86a3: new net/minecraft/world/phys/Vec3
      // 86a6: dup
      // 86a7: aload 8
      // 86a9: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 86ac: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 86af: ldc2_w -0.02
      // 86b2: aload 8
      // 86b4: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 86b7: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 86ba: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 86bd: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 86c0: goto 86fd
      // 86c3: aload 8
      // 86c5: new net/minecraft/world/phys/Vec3
      // 86c8: dup
      // 86c9: aload 8
      // 86cb: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 86ce: invokevirtual net/minecraft/world/phys/Vec3.x ()D
      // 86d1: ldc2_w 0.02
      // 86d4: aload 8
      // 86d6: invokevirtual net/minecraft/world/entity/Entity.getDeltaMovement ()Lnet/minecraft/world/phys/Vec3;
      // 86d9: invokevirtual net/minecraft/world/phys/Vec3.z ()D
      // 86dc: invokespecial net/minecraft/world/phys/Vec3.<init> (DDD)V
      // 86df: invokevirtual net/minecraft/world/entity/Entity.setDeltaMovement (Lnet/minecraft/world/phys/Vec3;)V
      // 86e2: goto 86fd
      // 86e5: aload 8
      // 86e7: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 86ea: ldc_w "slowcharge"
      // 86ed: dconst_0
      // 86ee: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 86f1: aload 8
      // 86f3: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 86f6: ldc_w "slowcharge2"
      // 86f9: dconst_0
      // 86fa: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 86fd: aload 8
      // 86ff: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8702: ldc_w "allow_floatingsequence"
      // 8705: ldc2_w 40.0
      // 8708: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 870b: aload 8
      // 870d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8710: ldc_w "floatingsequence"
      // 8713: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8716: dconst_0
      // 8717: dcmpl
      // 8718: ifgt 8755
      // 871b: aload 8
      // 871d: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8720: ldc_w "floatingsequence"
      // 8723: ldc2_w 40.0
      // 8726: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 8729: aload 8
      // 872b: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 872e: ldc_w "uplev"
      // 8731: invokevirtual net/minecraft/nbt/CompoundTag.getBoolean (Ljava/lang/String;)Z
      // 8734: ifeq 8746
      // 8737: aload 8
      // 8739: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 873c: ldc_w "uplev"
      // 873f: bipush 0
      // 8740: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 8743: goto 876d
      // 8746: aload 8
      // 8748: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 874b: ldc_w "uplev"
      // 874e: bipush 1
      // 874f: invokevirtual net/minecraft/nbt/CompoundTag.putBoolean (Ljava/lang/String;Z)V
      // 8752: goto 876d
      // 8755: aload 8
      // 8757: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 875a: ldc_w "floatingsequence"
      // 875d: aload 8
      // 875f: invokevirtual net/minecraft/world/entity/Entity.getPersistentData ()Lnet/minecraft/nbt/CompoundTag;
      // 8762: ldc_w "floatingsequence"
      // 8765: invokevirtual net/minecraft/nbt/CompoundTag.getDouble (Ljava/lang/String;)D
      // 8768: dconst_1
      // 8769: dsub
      // 876a: invokevirtual net/minecraft/nbt/CompoundTag.putDouble (Ljava/lang/String;D)V
      // 876d: aload 8
      // 876f: getstatic net/arphex/network/ArphexModVariables.PLAYER_VARIABLES_CAPABILITY Lnet/minecraftforge/common/capabilities/Capability;
      // 8772: aconst_null
      // 8773: invokevirtual net/minecraft/world/entity/Entity.getCapability (Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;
      // 8776: new net/arphex/network/ArphexModVariables$PlayerVariables
      // 8779: dup
      // 877a: invokespecial net/arphex/network/ArphexModVariables$PlayerVariables.<init> ()V
      // 877d: invokevirtual net/minecraftforge/common/util/LazyOptional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 8780: checkcast net/arphex/network/ArphexModVariables$PlayerVariables
      // 8783: getfield net/arphex/network/ArphexModVariables$PlayerVariables.ShowOverlay5 Z
      // 8786: ifeq 8794
      // 8789: bipush 3
      // 878a: aload 8
      // 878c: invokedynamic run (Lnet/minecraft/world/entity/Entity;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, net/arphex/procedures/GameModeDetectorProcedure.lambda$execute$123 (Lnet/minecraft/world/entity/Entity;)V, ()V ]
      // 8791: invokestatic net/arphex/ArphexMod.queueServerWork (ILjava/lang/Runnable;)V
      // 8794: return
   }
}
