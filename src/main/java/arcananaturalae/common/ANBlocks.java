package arcananaturalae.common;

import cpw.mods.fml.common.registry.GameRegistry;
import arcananaturalae.common.block.BlockCrystallizedFlower;
import net.minecraft.block.Block;

public final class ANBlocks{
    public static final Block blockAirShardFlower = new BlockCrystallizedFlower(ThaumcraftItems.itemAirShard)
            .setBlockName("airShardFlower");
    public static final Block blockFireShardFlower = new BlockCrystallizedFlower(ThaumcraftItems.itemFireShard)
            .setBlockName("fireShardFlower");
    public static final Block blockWaterShardFlower = new BlockCrystallizedFlower(ThaumcraftItems.itemWaterShard)
            .setBlockName("waterShardFlower");
    public static final Block blockEarthShardFlower = new BlockCrystallizedFlower(ThaumcraftItems.itemEarthShard)
            .setBlockName("earthShardFlower");
    public static final Block blockOrderShardFlower = new BlockCrystallizedFlower(ThaumcraftItems.itemOrderShard)
            .setBlockName("orderShardFlower");
    public static final Block blockEntropyShardFlower = new BlockCrystallizedFlower(ThaumcraftItems.itemEntropyShard)
            .setBlockName("entropyShardFlower");

    public static void init(){
        GameRegistry.registerBlock(blockAirShardFlower, "blockAirShardFlower");
        GameRegistry.registerBlock(blockFireShardFlower, "blockFireShardFlower");
        GameRegistry.registerBlock(blockWaterShardFlower, "blockWaterShardFlower");
        GameRegistry.registerBlock(blockEarthShardFlower, "blockEarthShardFlower");
        GameRegistry.registerBlock(blockOrderShardFlower, "blockOrderShardFlower");
        GameRegistry.registerBlock(blockEntropyShardFlower, "blockEntropyShardFlower");
    }
}