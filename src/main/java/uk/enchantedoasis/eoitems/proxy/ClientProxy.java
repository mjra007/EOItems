package uk.enchantedoasis.eoitems.proxy;

import uk.enchantedoasis.eoitems.Items.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import uk.enchantedoasis.eoitems.blocks.Blocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

        if (te == null)
            return null;

        return null;
    }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        Items.initModels();
        Blocks.initModels();
    }


}
