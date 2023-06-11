package uk.enchantedoasis.eoitems.blocks;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import uk.enchantedoasis.eoitems.EOCustomItemsMod;

public class CurrencyModel extends AnimatedGeoModel<CurrencyTileEntity> {
    @Override
    public ResourceLocation getModelLocation(CurrencyTileEntity object) {
        return new ResourceLocation(EOCustomItemsMod.MODID, "geo/currency.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CurrencyTileEntity object) {
        return new ResourceLocation(EOCustomItemsMod.MODID, "textures/block/currency.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CurrencyTileEntity animatable) {
        return new ResourceLocation(EOCustomItemsMod.MODID, "animations/breakcurrency.animation.json");
    }
}
