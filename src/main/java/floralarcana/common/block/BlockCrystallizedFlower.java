package floralarcana.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.ArrayList;

public final class BlockCrystallizedFlower
extends FABlock{
    private final ItemStack shard;

    public BlockCrystallizedFlower(ItemStack shard){
        super(Material.glass);
        this.shard = shard;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(this.shard);
        return drops;
    }

    public static Block fromNBT(NBTTagCompound comp){
        String name = comp.getString("name");
        String texture = comp.getString("texture");
        ItemStack shard = ItemStack.loadItemStackFromNBT(comp.getCompoundTag("shard"));

        return new BlockCrystallizedFlower(shard).setBlockName(name).setBlockTextureName(texture);
    }
}