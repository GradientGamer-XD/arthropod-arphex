package net.arphex.init;

import net.arphex.client.model.ModelSpiderMothEntity;
import net.arphex.client.model.Modelbar_Converted;
import net.arphex.client.model.Modelchitin;
import net.arphex.client.model.Modelchitinstrong;
import net.arphex.client.model.Modelchitinweak;
import net.arphex.client.model.Modeleternal;
import net.arphex.client.model.Modelgenesis_shot;
import net.arphex.client.model.Modelimmortal;
import net.arphex.client.model.Modelinfernal;
import net.arphex.client.model.Modeljuggernaut;
import net.arphex.client.model.Modelspacetime;
import net.arphex.client.model.Modelspectral;
import net.arphex.client.model.Modelumbral;
import net.arphex.client.model.Modelvitality;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class ArphexModModels {
   @SubscribeEvent
   public static void registerLayerDefinitions(RegisterLayerDefinitions event) {
      event.registerLayerDefinition(ModelSpiderMothEntity.LAYER_LOCATION, ModelSpiderMothEntity::createBodyLayer);
      event.registerLayerDefinition(Modelumbral.LAYER_LOCATION, Modelumbral::createBodyLayer);
      event.registerLayerDefinition(Modelgenesis_shot.LAYER_LOCATION, Modelgenesis_shot::createBodyLayer);
      event.registerLayerDefinition(Modeljuggernaut.LAYER_LOCATION, Modeljuggernaut::createBodyLayer);
      event.registerLayerDefinition(Modelbar_Converted.LAYER_LOCATION, Modelbar_Converted::createBodyLayer);
      event.registerLayerDefinition(Modelvitality.LAYER_LOCATION, Modelvitality::createBodyLayer);
      event.registerLayerDefinition(Modelinfernal.LAYER_LOCATION, Modelinfernal::createBodyLayer);
      event.registerLayerDefinition(Modelspectral.LAYER_LOCATION, Modelspectral::createBodyLayer);
      event.registerLayerDefinition(Modelchitin.LAYER_LOCATION, Modelchitin::createBodyLayer);
      event.registerLayerDefinition(Modelchitinweak.LAYER_LOCATION, Modelchitinweak::createBodyLayer);
      event.registerLayerDefinition(Modelchitinstrong.LAYER_LOCATION, Modelchitinstrong::createBodyLayer);
      event.registerLayerDefinition(Modelimmortal.LAYER_LOCATION, Modelimmortal::createBodyLayer);
      event.registerLayerDefinition(Modeleternal.LAYER_LOCATION, Modeleternal::createBodyLayer);
      event.registerLayerDefinition(Modelspacetime.LAYER_LOCATION, Modelspacetime::createBodyLayer);
   }
}
