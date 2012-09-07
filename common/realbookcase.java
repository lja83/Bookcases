package realbookcase.common;

import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="JeffApczynski_RealBookcase",
     name="RealBookcase",
     version="0.2")
@NetworkMod(clientSideRequired=true,
            serverSideRequired=false)
public class realbookcase
{
    public static Block blockBookcase;
    
    @SidedProxy(clientSide="realbookcase.client.BookcaseClientProxy",
                serverSide="realbookcase.common.BookcaseCommonProxy")
    public static BookcaseCommonProxy proxy;
    
    @Init
    public void load(FMLInitializationEvent event)
    {
        blockBookcase = new BlockBookcase(160, this);
        blockBookcase.setHardness(1.5f);
        blockBookcase.setStepSound(Block.soundWoodFootstep);
        blockBookcase.setResistance(3f);
        blockBookcase.setBlockName("blockBookcase");
        
        GameRegistry.registerBlock(blockBookcase);
        LanguageRegistry.addName(blockBookcase, "Bookcase");
        
        GameRegistry.addRecipe(
                new ItemStack(blockBookcase, 6),
                new Object[]{"XXX", "   ", "XXX", 'X', Block.planks});
        
        NetworkRegistry.instance().registerGuiHandler(this, new BookcaseGuiHandler());
        GameRegistry.registerTileEntity(BookcaseTileEntity.class, "Bookcase");
        proxy.registerTextures();
    }
}
