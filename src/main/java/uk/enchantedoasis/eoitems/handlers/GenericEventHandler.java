package uk.enchantedoasis.eoitems.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import uk.enchantedoasis.eoitems.HeartsParticleAnimation;
import uk.enchantedoasis.eoitems.HeartParticlesModel;
import uk.enchantedoasis.eoitems.HeartParticlesRender;

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
            HeartsParticleAnimation animation = new HeartsParticleAnimation( new HeartParticlesModel());
            event.getRenderer().addLayer(new HeartParticlesRender(event.getRenderer(),animation.model, animation));
            added = true;

        }
    }


}
