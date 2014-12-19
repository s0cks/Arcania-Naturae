package floralarcana.common.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public final class FAPacketHandler{
    public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("floralarcana");

    public static void init(){

    }
}