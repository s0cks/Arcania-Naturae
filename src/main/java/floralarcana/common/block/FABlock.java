package floralarcana.common.block;

import floralarcana.common.FloralArcana;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FABlock
extends Block{
    public FABlock(Material material){
        super(material);
        this.setCreativeTab(FloralArcana.TAB);
    }
}