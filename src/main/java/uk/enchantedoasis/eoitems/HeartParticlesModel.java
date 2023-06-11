package uk.enchantedoasis.eoitems;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeartParticlesModel extends AnimatedGeoModel<HeartsParticleAnimation> {

    private static final ResourceLocation modelResource = new ResourceLocation(EOCustomItemsMod.MODID, "geo/heartsmodel.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(EOCustomItemsMod.MODID, "textures/heart.png");
    private static final ResourceLocation animationResource = new ResourceLocation(EOCustomItemsMod.MODID, "animations/hearts.animation.json");

    @Override
    public ResourceLocation getModelLocation(HeartsParticleAnimation object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(HeartsParticleAnimation object) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(HeartsParticleAnimation object) {
        return animationResource;
    }


}
