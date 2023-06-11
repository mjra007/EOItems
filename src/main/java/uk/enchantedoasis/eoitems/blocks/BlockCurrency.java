package uk.enchantedoasis.eoitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.enchantedoasis.eoitems.Items.Items;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockCurrency extends Block  implements ITileEntityProvider{

    public BlockCurrency(String name) {
        super(Material.ROCK, MapColor.LIME);
        this.setRegistryName(name);
        this.setTranslationKey(name);
        setHardness(50.0f);
        setResistance(15.0f);
        setHarvestLevel("pickaxe",3);
        setLightLevel(0.0f);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean addRunningEffects(IBlockState state, World world, BlockPos pos, Entity entity) {
        return super.addRunningEffects(state, world, pos, entity);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }


    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Items.ItemCurrency, 0, new ModelResourceLocation("eoitems:geo/currency.geo", "inventory"));
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

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new CurrencyTileEntity();
    }

    public CurrencyTileEntity getTileEntity(World world, BlockPos pos){
        TileEntity te = world.getTileEntity(pos);
        if(te !=null && te instanceof  CurrencyTileEntity){
            return (CurrencyTileEntity)te;
        }
        return null;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        CurrencyTileEntity te = getTileEntity(worldIn, pos);
      //  te.isBlockBreaking = false;
    //    super.onBlockHarvested(worldIn, pos, state, player);

    }


}
