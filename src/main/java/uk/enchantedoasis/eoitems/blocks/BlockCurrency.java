package uk.enchantedoasis.eoitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.enchantedoasis.eoitems.Items.Items;

import java.util.Random;

public class BlockCurrency extends Block {

    public BlockCurrency(String name) {
        super(Material.ROCK, MapColor.LIME);
        this.setRegistryName(name);
        this.setTranslationKey(name);
        setHardness(3.0f);
        setResistance(15.0f);
        setHarvestLevel("pickaxe",3);
        setLightLevel(0.0f);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Items.ItemCurrency, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.ItemCoin;
    }

    @Override
    public int quantityDropped(Random rand) {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        int maxFortune  = Math.min(fortune, 3);
        if (maxFortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(maxFortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }


}
