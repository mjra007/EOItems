package uk.enchantedoasis.eoitems;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimatableModel;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class PlayerLayerAnimation implements IAnimatable {

    private static Map<Class<? extends PlayerLayerAnimation>, PlayerLayerAnimation> animations = new ConcurrentHashMap<>();

    static{
        AnimationController.addModelFetcher(new PlayerLayerAnimation.Fetcher());
    }
    protected AnimationFactory factory = new AnimationFactory(this);
    protected PlayerLayerModel model;

    public PlayerLayerAnimation(PlayerLayerModel model){
        this.model = model;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public <T extends PlayerLayerAnimation> AnimatedGeoModel<T> getModel(){
        return (AnimatedGeoModel<T>)model;
    }
    public static class Fetcher implements AnimationController.ModelFetcher<PlayerLayerAnimation> {

        @Override
        public IAnimatableModel<PlayerLayerAnimation> apply(IAnimatable iAnimatable) {
            if (iAnimatable instanceof PlayerLayerAnimation) {
                 PlayerLayerAnimation animation = animations.get(iAnimatable.getClass());
                 return animation == null ? null : animation.model;
            }
             return null;
        }
    }

    public static PlayerLayerAnimation getAnimation(Class<? extends PlayerLayerAnimation> item) {
        return animations.get(item);
    }

    public static void registerAnimation(Class<? extends PlayerLayerAnimation> itemClass, PlayerLayerAnimation animation) {
        animations.put(itemClass, animation);
    }

}
