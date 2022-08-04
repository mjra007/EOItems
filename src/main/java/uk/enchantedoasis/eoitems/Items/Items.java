package uk.enchantedoasis.eoitems.Items;

import uk.enchantedoasis.eoitems.CreativeTab;
import uk.enchantedoasis.eoitems.EOCustomItemsMod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(EOCustomItemsMod.MODID)
public class Items {
    @GameRegistry.ObjectHolder("oasiskey")
    public static OasisKey OasisKey;

    @GameRegistry.ObjectHolder("angelickey")
    public static OasisKey AngelicKey;

    @GameRegistry.ObjectHolder("angelicskullswordclone")
    public static AngelicSkullSwordClone AngelicSkullSwordClone;

    @GameRegistry.ObjectHolder("angelicskullsword")
    public static AngelicSkullSword AngelicSkullSword;
    public static CreativeTab Tab;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        OasisKey.initModel();
        AngelicKey.initModel();
        AngelicSkullSwordClone.initModel();
        AngelicSkullSword.initModel();
    }
}
