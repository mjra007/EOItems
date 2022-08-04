package uk.enchantedoasis.eoitems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.enchantedoasis.eoitems.Items.Items;
import uk.enchantedoasis.eoitems.handlers.ExampleConfig;
import uk.enchantedoasis.eoitems.handlers.GenericEventHandler;
import uk.enchantedoasis.eoitems.proxy.CommonProxy;

@Mod(modid = EOCustomItemsMod.MODID, version = EOCustomItemsMod.VERSION, name = EOCustomItemsMod.NAME)
public class EOCustomItemsMod {
    public static final String MODID = "eoitems";
    public static final String NAME = "Enchanted Oasis Custom Items";
    public static final String VERSION = "1.0.0";

    public static SimpleNetworkWrapper packetHandler;

    @Mod.Instance(EOCustomItemsMod.MODID)
    public static EOCustomItemsMod instance;
    @SidedProxy(clientSide = "uk.enchantedoasis.eoitems.proxy.ClientProxy", serverSide = "uk.enchantedoasis.eoitems.CommonProxy")
    public static CommonProxy proxy;

    public static final Logger logger = LogManager.getLogger("ExampleMod");

    @EventHandler
    public void load(FMLInitializationEvent event) {

    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        // NO-OP
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ExampleConfig.load(event);
        MinecraftForge.EVENT_BUS.register(new GenericEventHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
    }


}
