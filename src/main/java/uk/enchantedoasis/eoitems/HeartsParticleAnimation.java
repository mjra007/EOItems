package uk.enchantedoasis.eoitems;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimatableModel;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class HeartsParticleAnimation implements IAnimatable {

    static{
        AnimationController.addModelFetcher(new Fetcher());
    }
    private AnimationFactory factory = new AnimationFactory(this);
    public HeartParticlesModel model;
    public HeartsParticleAnimation(HeartParticlesModel model){
        this.model = model;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<HeartsParticleAnimation>(this, "heart_controller", 1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.heart_particles.idle", true));
        return PlayState.CONTINUE;
    }

    public static class Fetcher implements AnimationController.ModelFetcher<HeartsParticleAnimation> {

        @Override
        public IAnimatableModel<HeartsParticleAnimation> apply(IAnimatable iAnimatable) {
            if (iAnimatable instanceof HeartsParticleAnimation) {
                HeartsParticleAnimation animation = (HeartsParticleAnimation)iAnimatable;
                System.out.println("inside fetcher");
                return animation.model;
            }
            System.out.println("outside fetcher");
            return null;
        }
    }
}
