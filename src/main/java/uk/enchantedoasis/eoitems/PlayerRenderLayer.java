package uk.enchantedoasis.eoitems;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class PlayerRenderLayer<T extends IAnimatable> implements LayerRenderer<EntityLivingBase>, IGeoRenderer<T> {

    private RenderPlayer renderPlayer;
    private T animation;
    private AnimatedGeoModel<T> model;

    public PlayerRenderLayer(RenderPlayer renderPlayer, T animation, AnimatedGeoModel<T> model){
        this.renderPlayer = renderPlayer;
        this.animation = animation;
        this.model = model;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.translate(0,-1.5f,0F);
        this.renderPlayer.bindTexture(getGeoModelProvider().getTextureLocation(animation));
        GlStateManager.pushMatrix();
        model.setLivingAnimations(animation, 1);
        this.render(model.getModel(model.getModelLocation(animation)), animation , partialTicks,1,1,1,1 );
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    public AnimatedGeoModel<T> GetAnimatedModel(){
        return model;
    }

    public T GetAnimation(){
        return animation;
    }

    @Override
    public GeoModelProvider<T> getGeoModelProvider() {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(T instance) {
        return getGeoModelProvider().getTextureLocation(animation);
    }
}
