package uk.enchantedoasis.eoitems.Items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AngelicSkullSwordClone extends ItemSword {

    public AngelicSkullSwordClone(String name){
        super(ToolMaterial.DIAMOND);
        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setCreativeTab(Items.Tab);
        this.setMaxStackSize(64);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }

}
