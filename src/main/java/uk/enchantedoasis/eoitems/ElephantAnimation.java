package uk.enchantedoasis.eoitems;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

public class ElephantAnimation extends PlayerLayerAnimation{

    public ElephantAnimation(PlayerLayerModel model) {
        super(model);
    }

    @Override
    public void registerControllers(AnimationData data) {
        //data.addAnimationController(new AnimationController<ElephantAnimation>(this, "elephant_controller", 1, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
       // event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.alaawii_elephant_on_head.idle", true));
        return PlayState.CONTINUE;
    }
}
