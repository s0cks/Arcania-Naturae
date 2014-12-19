package floralarcana.common.item.block;

import floralarcana.common.FloralArcana;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class FAItemBlock
extends ItemBlock{
    public FAItemBlock(Block block){
        super(block);
        this.setCreativeTab(FloralArcana.TAB);
    }
}