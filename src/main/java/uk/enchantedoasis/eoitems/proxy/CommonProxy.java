package uk.enchantedoasis.eoitems.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import uk.enchantedoasis.eoitems.CreativeTab;
import uk.enchantedoasis.eoitems.Items.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import uk.enchantedoasis.eoitems.blocks.BlockCurrency;
import uk.enchantedoasis.eoitems.blocks.Blocks;

@Mod.EventBusSubscriber
public class CommonProxy implements IGuiHandler {

    public CommonProxy() {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Items.Tab = new CreativeTab();
        event.getRegistry().register(new ItemOasisKey("oasis_key"));
        event.getRegistry().register(new ItemOasisKey("angelic_key"));
        event.getRegistry().register(new ItemOasisKey("vote_key"));
        event.getRegistry().register(new ItemFallenAngelSwordClone("fallen_angel_sword_clone"));
        event.getRegistry().register(new ItemFallenAngelSword("fallen_angel_sword"));
        event.getRegistry().register(new ItemFallenAngelAxe("fallen_angel_axe"));
        event.getRegistry().register(new ItemBlock(Blocks.BlockCurrency).setRegistryName("currency").setCreativeTab(Items.Tab));
        event.getRegistry().register(new ItemCoin("coin"));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockCurrency("currency"));
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

        if (te == null)
            return null;

        return null;

    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }


}
