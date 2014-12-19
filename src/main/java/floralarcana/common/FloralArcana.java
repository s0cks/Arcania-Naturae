package floralarcana.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import floralarcana.common.block.BlockCrystallizedFlower;
import floralarcana.common.network.FAPacketHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "floralarcana", version = "0.0.0.0", name = "Floral Arcana", dependencies = "", useMetadata = true)
public final class FloralArcana{
    @SidedProxy(
            clientSide = "floralarcana.client.ClientProxy",
            serverSide = "floralarcana.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Instance("floralarcana")
    public static FloralArcana instance;

    public static final Logger LOGGER = LogManager.getLogger(FloralArcana.class);
    public static final CreativeTabs TAB = new CreativeTabs("floralarcana"){
        @Override
        public Item getTabIconItem(){
            return Items.diamond;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent e){

    }

    @EventHandler
    public void init(FMLInitializationEvent e){
        FABlocks.init();
        FAItems.init();
        FATiles.init();

        FMLInterModComms.sendMessage("Waila", "register", "floralarcana.client.waila.WailaProvider.create");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
        FAPacketHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new FAGuiHandler());
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent e){

    }

    @EventHandler
    public void callback(IMCEvent e){
        for(FMLInterModComms.IMCMessage msg : e.getMessages()){
            if(msg.key.equalsIgnoreCase("crystallize") && msg.isNBTMessage()){
                LOGGER.info("Registering Crystallized Flower: " + msg.getNBTValue().getString("name"));
                GameRegistry.registerBlock(BlockCrystallizedFlower.fromNBT(msg.getNBTValue()), "blockCrystalizedFlower" + msg.getNBTValue().getString("name"));
            }
        }
    }
}