package uk.enchantedoasis.eoitems;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

@SuppressWarnings("rawtypes")
public class HeartParticlesRender implements LayerRenderer<EntityLivingBase>, IGeoRenderer<HeartsParticleAnimation> {

    private RenderPlayer renderPlayer;
    public HeartParticlesModel animatedGeoModel;

    public HeartsParticleAnimation animation;

    public HeartParticlesRender(RenderPlayer renderPlayer, HeartParticlesModel animatedGeoModel, HeartsParticleAnimation animation) {
        this.renderPlayer = renderPlayer;
        this.animatedGeoModel = animatedGeoModel;
        this.animation = animation;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.translate(0,-1.5f,0F);
        this.renderPlayer.bindTexture(getGeoModelProvider().getTextureLocation(this));
        GlStateManager.pushMatrix();
        animatedGeoModel.setLivingAnimations(animation, 1);
        this.render(animatedGeoModel.getModel(animatedGeoModel.getModelLocation(animation)), animation , partialTicks,1,1,1,1 );
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    @Override
    public GeoModelProvider<HeartParticlesRender> getGeoModelProvider() {
        return new GeoModelProvider<HeartParticlesRender>() {
            private final ResourceLocation modelResource = new ResourceLocation(EOCustomItemsMod.MODID, "geo/heartsmodel.geo.json");
            private final ResourceLocation textureResource = new ResourceLocation(EOCustomItemsMod.MODID, "textures/heart.png");

            @Override
            public ResourceLocation getModelLocation(HeartParticlesRender object) {
                return modelResource;
            }

            @Override
            public ResourceLocation getTextureLocation(HeartParticlesRender object) {
                return textureResource;
            }
        };
    }

    @Override
    public ResourceLocation getTextureLocation(HeartsParticleAnimation instance) {
        return getGeoModelProvider().getTextureLocation(this);
    }

}
