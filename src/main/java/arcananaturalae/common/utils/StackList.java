package arcananaturalae.common.utils;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public final class StackList
extends ArrayList<ItemStack>{
    public StackList addStack(ItemStack stack){
        this.add(stack);
        return this;
    }
}