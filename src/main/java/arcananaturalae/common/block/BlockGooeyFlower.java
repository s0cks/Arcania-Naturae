package arcananaturalae.common.block;

import arcananaturalae.common.ThaumcraftItems;
import arcananaturalae.common.utils.StackList;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public final class BlockGooeyFlower
extends ANBlock{
    public BlockGooeyFlower(){
        super(Material.grass);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        return new StackList().addStack(ThaumcraftItems.itemTaintedGoo);
    }
}