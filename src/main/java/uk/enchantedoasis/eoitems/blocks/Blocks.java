package uk.enchantedoasis.eoitems.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.enchantedoasis.eoitems.EOCustomItemsMod;

@GameRegistry.ObjectHolder(EOCustomItemsMod.MODID)
public class Blocks {
    @GameRegistry.ObjectHolder("currency")
    public static BlockCurrency BlockCurrency;

    public static void initModels() {
        BlockCurrency.initModel();
    }
}
