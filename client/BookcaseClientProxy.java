package Bookcases.client;

import net.minecraftforge.client.MinecraftForgeClient;
import Bookcases.common.BookcaseCommonProxy;

public class BookcaseClientProxy extends BookcaseCommonProxy
{
    @Override
    public void registerTextures()
    {
        MinecraftForgeClient.preloadTexture("/Bookcases/shelves.png");
    }
}
