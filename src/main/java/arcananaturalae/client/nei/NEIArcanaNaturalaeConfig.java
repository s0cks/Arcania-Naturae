package arcananaturalae.client.nei;

import codechicken.nei.api.IConfigureNEI;

public final class NEIArcanaNaturalaeConfig
implements IConfigureNEI{
    @Override
    public void loadConfig(){
        System.out.println("Configuring Floral Arcana NEI Plugin");
    }

    @Override
    public String getName(){
        return "Floral Arcana NEI Plugin";
    }

    @Override
    public String getVersion(){
        return "1.0.0.0";
    }
}