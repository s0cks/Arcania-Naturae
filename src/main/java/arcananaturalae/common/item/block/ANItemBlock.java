package arcananaturalae.common.item.block;

import arcananaturalae.common.ArcanaNaturalae;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ANItemBlock
extends ItemBlock{
    public ANItemBlock(Block block){
        super(block);
        this.setCreativeTab(ArcanaNaturalae.TAB);
    }
}