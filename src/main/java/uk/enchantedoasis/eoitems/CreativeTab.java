package uk.enchantedoasis.eoitems;

import uk.enchantedoasis.eoitems.Items.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
    public CreativeTab() {
        super("eocustomitemstab");
    }


    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.ItemOasisKey);
    }
}
