package uk.enchantedoasis.eoitems;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

public class OwlAnimation extends PlayerLayerAnimation {

    public OwlAnimation(PlayerLayerModel model) {
        super(model);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<OwlAnimation>(this, "owl_controller", 1, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

}
