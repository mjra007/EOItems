package uk.enchantedoasis.eoitems;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class PlayerLayerModel extends AnimatedGeoModel<PlayerLayerAnimation> {

        private final ResourceLocation modelResource;
        private final ResourceLocation textureResource;
        private final ResourceLocation animationResource;

        public PlayerLayerModel(String modelFile, String animationFile, String textureFile)
        {
            modelResource = new ResourceLocation(EOCustomItemsMod.MODID, "geo/"+modelFile);
            textureResource = new ResourceLocation(EOCustomItemsMod.MODID, "textures/"+textureFile);
            animationResource = new ResourceLocation(EOCustomItemsMod.MODID, "animations/"+animationFile);
        }

        @Override
        public ResourceLocation getModelLocation(PlayerLayerAnimation object) {
            return modelResource;
        }

        @Override
        public ResourceLocation getTextureLocation(PlayerLayerAnimation object) {
            return textureResource;
        }

        @Override
        public ResourceLocation getAnimationFileLocation(PlayerLayerAnimation object) {
            return animationResource;
        }

    @Override
    public void setLivingAnimations(PlayerLayerAnimation entity, Integer uniqueID) {
        super.setLivingAnimations(entity, uniqueID);
    }

    @Override
    public IBone getBone(String boneName) {
        return super.getBone(boneName);
    }
}
