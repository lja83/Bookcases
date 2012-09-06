package net.minecraft.src.Bookcases;

import net.minecraft.src.forge.*;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class mod_Bookcase extends NetworkMod
{
    public Block blockBookcase;
    
    @Override
    public String getVersion()
    {
        return "Real Bookcases 0.1";
    }
    
    @Override
    public void load()
    {
        MinecraftForgeClient.preloadTexture("/Bookcases/shelves.png");
        
        blockBookcase = new BlockBookcase(160, this);
        
        //Register Blocks
        ModLoader.registerBlock(blockBookcase);
        
        //Add Recipes
        ModLoader.addRecipe(new ItemStack(blockBookcase, 6), new Object[]
        {
            "XXX", "   ", "XXX", 'X', Block.planks
        });
        
        //Add Names
        ModLoader.addName(blockBookcase, "Bookcase");
        ModLoader.registerTileEntity(BookcaseTileEntity.class, "Bookcase");
        MinecraftForge.setGuiHandler(this, new BookcaseGuiHandler());
    }
}
