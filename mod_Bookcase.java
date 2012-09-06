package net.minecraft.src.Bookcases;

import net.minecraft.src.forge.*;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class mod_Bookcase extends NetworkMod
{
    public Block blockHelloWorld;
    
    @Override
    public String getVersion()
    {
        return "Tutorial Mod 1.0.0";
    }
    
    @Override
    public void load()
    {
        MinecraftForgeClient.preloadTexture("/Bookcases/shelves.png");
        
        blockHelloWorld = new BlockBookcase(160);
        
        //Register Blocks
        ModLoader.registerBlock(blockHelloWorld);
        
        //Add Recipes
        ModLoader.addRecipe(new ItemStack(blockHelloWorld, 3), new Object[]
        {
            "   ", "X+X", "   ", 'X', Block.dirt, '+', Block.wood
        });
        
        //Add Names
        // ModLoader.addName(blockHelloWorld, "Bookcase");
        
        // ModLoader.registerTileEntity(BookcaseTileEntity.class, "Bookcase");
    }
}
