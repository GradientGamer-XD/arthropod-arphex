package net.arphex.procedures;

import javax.annotation.Nullable;
import net.arphex.network.ArphexModVariables;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.level.LevelEvent.Load;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WorldLoadProcedure {
   @SubscribeEvent
   public static void onWorldLoad(Load event) {
      execute(event, event.getLevel());
   }

   public static void execute(LevelAccessor world) {
      execute(null, world);
   }

   private static void execute(@Nullable Event event, LevelAccessor world) {
      if (ModList.get().isLoaded("projecte")) {
         ArphexModVariables.WorldVariables.get(world).checkedprojecte = true;
         ArphexModVariables.WorldVariables.get(world).syncData(world);
      }

      ArphexModVariables.MapVariables.get(world).reload_render = true;
      ArphexModVariables.MapVariables.get(world).syncData(world);
      ArphexModVariables.MapVariables.get(world).t3_patrons_list = ",vllax,dev,yourlocal_buddy,zeronil7,evs__,".toLowerCase();
      ArphexModVariables.MapVariables.get(world).syncData(world);
      ArphexModVariables.MapVariables.get(world).t2_patrons_list = (",donron_squeaktoe,faker_sans,sniffsnorfsnumf,sillygoober_mp2,lifeloverxdhaha,sirxey,rajiomaniakku,hollowed_out1,lexistapparently,"
            + ArphexModVariables.MapVariables.get(world).t3_patrons_list)
         .toLowerCase();
      ArphexModVariables.MapVariables.get(world).syncData(world);
      ArphexModVariables.MapVariables.get(world).t1_patrons_list = (",BLACKB0XWARRI0R,RatlordOli,ArcaneScavenger,crmblb4rmbl,angry_bluepigeon,luna31121998,"
            + ArphexModVariables.MapVariables.get(world).t2_patrons_list)
         .toLowerCase();
      ArphexModVariables.MapVariables.get(world).syncData(world);
   }
}
