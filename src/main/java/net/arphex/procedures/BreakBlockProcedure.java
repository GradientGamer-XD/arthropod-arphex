package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.init.ArphexModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class BreakBlockProcedure {
   @SubscribeEvent
   public static void onBlockBreak(BreakEvent event) {
      execute(event, event.getLevel(), (double)event.getPos().getX(), (double)event.getPos().getY(), (double)event.getPos().getZ(), event.getState());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      execute(null, world, x, y, z, blockstate);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      if (blockstate.is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
         && Mth.nextInt(RandomSource.create(), 1, 100) == 100
         && world instanceof ServerLevel _level) {
         Entity entityToSpawn = ((EntityType)ArphexModEntities.STICK_BUG.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
         if (entityToSpawn != null) {
            entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
         }
      }
   }
}
