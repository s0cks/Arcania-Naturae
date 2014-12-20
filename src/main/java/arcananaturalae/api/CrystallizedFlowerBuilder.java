package arcananaturalae.api;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class CrystallizedFlowerBuilder{
    private final String modid;
    private String name;
    private String texture;
    private ItemStack shard;

    public CrystallizedFlowerBuilder(String modid){
        this.modid = modid;
    }

    public CrystallizedFlowerBuilder setName(String name){
        this.name = name;
        return this;
    }

    public CrystallizedFlowerBuilder setTexture(String texture){
        this.texture = texture;
        return this;
    }

    public CrystallizedFlowerBuilder setShard(ItemStack shard){
        this.shard = shard;
        return this;
    }

    public NBTTagCompound build(){
        NBTTagCompound comp = new NBTTagCompound();
        NBTTagCompound item = new NBTTagCompound();
        this.shard.writeToNBT(item);
        comp.setString("name", this.name);
        comp.setString("texture", this.modid + ":" + this.texture);
        comp.setTag("shard", item);
        return comp;
    }
}