package uk.enchantedoasis.eoitems.proxy;

import uk.enchantedoasis.eoitems.CreativeTab;
import uk.enchantedoasis.eoitems.Items.AngelicSkullSword;
import uk.enchantedoasis.eoitems.Items.AngelicSkullSwordClone;
import uk.enchantedoasis.eoitems.Items.Items;
import uk.enchantedoasis.eoitems.Items.OasisKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;

@Mod.EventBusSubscriber
public class CommonProxy implements IGuiHandler {

    public CommonProxy() {
        // NO-OP
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Items.Tab = new CreativeTab();
        event.getRegistry().register(new OasisKey("oasiskey"));
        event.getRegistry().register(new OasisKey("angelickey"));
        event.getRegistry().register(new AngelicSkullSwordClone("angelicskullswordclone"));
        event.getRegistry().register(new AngelicSkullSword("angelicskullsword"));
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
