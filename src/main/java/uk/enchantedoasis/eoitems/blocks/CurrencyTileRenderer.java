package uk.enchantedoasis.eoitems.blocks;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.EnumFacing;
import org.lwjgl.opengl.GL11;
import software.bernie.geckolib3.core.util.Color;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class CurrencyTileRenderer extends GeoBlockRenderer<CurrencyTileEntity> {

    private final AnimatedGeoModel<CurrencyTileEntity> modelProvider;
    public CurrencyTileRenderer(AnimatedGeoModel<CurrencyTileEntity> modelProvider) {
        super(modelProvider);
        this.modelProvider = modelProvider;
    }

    @Override
    public void render(CurrencyTileEntity tile, double x, double y, double z, float partialTicks, int destroyStage) {
        GeoModel model = modelProvider.getModel(modelProvider.getModelLocation(tile));
        modelProvider.setLivingAnimations(tile, this.getUniqueID(tile));

        int light = tile.getWorld().getCombinedLight(tile.getPos(), 0);
        int lx = light % 65536;
        int ly = light / 65536;

        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        OpenGlHelper.setLightmapTextureCoords(GL11.GL_TEXTURE_2D, lx, ly);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);

        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.translate(x, y, z);
        GlStateManager.translate(0, 0.01f, 0);
        GlStateManager.translate(0.5, 0, 0.5);

        rotateBlock(getFacing(tile));

        Minecraft.getMinecraft().renderEngine.bindTexture(getTextureLocation(tile));
        Color renderColor = getRenderColor(tile, partialTicks);
        render(model, tile, partialTicks, (float) renderColor.getRed() / 255f, (float) renderColor.getGreen() / 255f,
                (float) renderColor.getBlue() / 255f, (float) renderColor.getAlpha() / 255);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private EnumFacing getFacing(CurrencyTileEntity tile) {
        IBlockState blockState = tile.getWorld().getBlockState(tile.getPos());

        if (blockState.getPropertyKeys().contains(BlockHorizontal.FACING)) {
            return blockState.getValue(BlockHorizontal.FACING);
        } else if (blockState.getPropertyKeys().contains(BlockDirectional.FACING)) {
            return blockState.getValue(BlockDirectional.FACING);
        } else {
            return EnumFacing.NORTH;
        }
    }
}
