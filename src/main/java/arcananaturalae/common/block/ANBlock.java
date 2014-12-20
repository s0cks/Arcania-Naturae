package arcananaturalae.common.block;

import arcananaturalae.common.ArcanaNaturalae;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ANBlock
extends Block{
    public ANBlock(Material material){
        super(material);
        this.setCreativeTab(ArcanaNaturalae.TAB);
    }
}