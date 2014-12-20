package arcananaturalae.common;

import arcananaturalae.common.network.ANPacketHandler;
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
import arcananaturalae.common.block.BlockCrystallizedFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "arcananaturalae", version = "0.0.0.0", name = "Arcana Naturalae", dependencies = "", useMetadata = true)
public final class ArcanaNaturalae{
    @SidedProxy(
            clientSide = "arcananaturalae.client.ClientProxy",
            serverSide = "arcananaturalae.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Instance("arcananaturalae")
    public static ArcanaNaturalae instance;

    public static final Logger LOGGER = LogManager.getLogger(ArcanaNaturalae.class);
    public static final CreativeTabs TAB = new CreativeTabs("arcananaturalae"){
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
        ANBlocks.init();
        ANItems.init();
        ANTiles.init();

        FMLInterModComms.sendMessage("Waila", "register", "arcananaturalae.client.waila.WailaProvider.create");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
        ANPacketHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ANGuiHandler());
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