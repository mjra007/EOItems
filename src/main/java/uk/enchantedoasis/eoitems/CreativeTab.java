package uk.enchantedoasis.eoitems;

import uk.enchantedoasis.eoitems.Items.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab extends CreativeTabs {
    public CreativeTab() {
        super("eocustomitemstab");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack createIcon() {
        return new ItemStack(Items.OasisKey);
    }
}
