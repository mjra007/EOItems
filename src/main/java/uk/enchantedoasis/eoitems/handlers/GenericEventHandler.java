package uk.enchantedoasis.eoitems.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import uk.enchantedoasis.eoitems.*;

public class GenericEventHandler {


    @SubscribeEvent
    public void onEntityJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Entity entity = event.player;

        if (!entity.world.isRemote && entity instanceof EntityPlayerMP) {
            System.out.println("Entity joined world: " + entity);

        }
    }

    static boolean added = false;
    @SubscribeEvent
    public void onPlayerRender(RenderPlayerEvent.Pre event) {
        if(!added){
//            GenericHeartAnimation animation = new GenericHeartAnimation( new PlayerLayerModel("heartsmodel.geo.json","hearts.animation.json","heart.png"));
//            event.getRenderer().addLayer(new PlayerRenderLayer<GenericHeartAnimation>(event.getRenderer(), animation, animation.<GenericHeartAnimation>getModel()));
//            PlayerLayerAnimation.registerAnimation(animation.getClass(), animation);
            added = true;
            OwlAnimation animation2 = new OwlAnimation( new PlayerLayerModel("owl.geo.json","owl.animation.json","owl.png"));
            PlayerLayerAnimation.registerAnimation(animation2.getClass(), animation2);
            event.getRenderer().addLayer(new PlayerRenderLayer<OwlAnimation>(event.getRenderer(), animation2, animation2.<OwlAnimation>getModel()));
//            ElephantAnimation animation3 = new ElephantAnimation( new PlayerLayerModel("elephant.geo.json","elephant.animation.json","elephant.png"));
//            event.getRenderer().addLayer(new PlayerRenderLayer<ElephantAnimation>(event.getRenderer(), animation3, animation3.<ElephantAnimation>getModel()));
//            PlayerLayerAnimation.registerAnimation(animation3.getClass(), animation3);
        }
    }


}
