package uk.enchantedoasis.eoitems.Items;

import net.minecraft.item.ItemBlock;
import uk.enchantedoasis.eoitems.CreativeTab;
import uk.enchantedoasis.eoitems.EOCustomItemsMod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(EOCustomItemsMod.MODID)
public class Items {
    @GameRegistry.ObjectHolder("oasis_key")
    public static ItemOasisKey ItemOasisKey;

    @GameRegistry.ObjectHolder("angelic_key")
    public static ItemOasisKey AngelicKey;

    @GameRegistry.ObjectHolder("vote_key")
    public static ItemOasisKey VoteKey;
    @GameRegistry.ObjectHolder("fallen_angel_sword_clone")
    public static ItemFallenAngelSwordClone ItemFallenAngelSwordClone;

    @GameRegistry.ObjectHolder("fallen_angel_sword")
    public static ItemFallenAngelSword ItemFallenAngelSword;

    @GameRegistry.ObjectHolder("fallen_angel_axe")
    public static ItemFallenAngelAxe ItemFallenAngelAxe;

    @GameRegistry.ObjectHolder("currency")
    public static ItemBlock ItemCurrency;

    @GameRegistry.ObjectHolder("coin")
    public static ItemCoin ItemCoin;

    public static CreativeTab Tab;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        ItemOasisKey.initModel();
        AngelicKey.initModel();
        VoteKey.initModel();
        ItemFallenAngelSwordClone.initModel();
        ItemFallenAngelSword.initModel();
        ItemFallenAngelAxe.initModel();
        ItemCoin.initModel();
    }
}
