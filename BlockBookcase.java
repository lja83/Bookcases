package net.minecraft.src.Bookcases;

import net.minecraft.src.*;
import net.minecraft.src.Bookcases.BookcaseTileEntity;

import java.util.Iterator;
import java.util.Random;

public class BlockBookcase extends BlockContainer
{
    private Random random = new Random();

    protected BlockBookcase(int par1)
    {
        super(par1, Material.wood);
        blockIndexInTexture = 35;
        setHardness(1.5f);
        setStepSound(soundWoodFootstep);
        setBlockName("Bookcase");
    }


    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
    }

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int side)
    {
        return getBlockTextureFromSide(side);
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int side)
    {
        int blockSide = blockIndexInTexture;
        if (side == 0 || side == 1)
        {
            blockSide = 4;
        }
        
        return ModLoader.addOverride("/terrain.png", "/Bookcases/shelf_01.png");
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return true;
    }

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        Object var6 = (BookcaseTileEntity)par1World.getBlockTileEntity(par2, par3, par4);

        par5EntityPlayer.displayGUIChest((IInventory)var6);
        return true;

        // if (var6 == null)
        // {
        //     return true;
        // }
        // else if (par1World.isBlockSolidOnSide(par2, par3 + 1, par4, 0))
        // {
        //     return true;
        // }
        // else if (isOcelotBlockingChest(par1World, par2, par3, par4))
        // {
        //     return true;
        // }
        // else if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID && (par1World.isBlockSolidOnSide(par2 - 1, par3 + 1, par4, 0) || isOcelotBlockingChest(par1World, par2 - 1, par3, par4)))
        // {
        //     return true;
        // }
        // else if (par1World.getBlockId(par2 + 1, par3, par4) == this.blockID && (par1World.isBlockSolidOnSide(par2 + 1, par3 + 1, par4, 0) || isOcelotBlockingChest(par1World, par2 + 1, par3, par4)))
        // {
        //     return true;
        // }
        // else if (par1World.getBlockId(par2, par3, par4 - 1) == this.blockID && (par1World.isBlockSolidOnSide(par2, par3 + 1, par4 - 1, 0) || isOcelotBlockingChest(par1World, par2, par3, par4 - 1)))
        // {
        //     return true;
        // }
        // else if (par1World.getBlockId(par2, par3, par4 + 1) == this.blockID && (par1World.isBlockSolidOnSide(par2, par3 + 1, par4 + 1, 0) || isOcelotBlockingChest(par1World, par2, par3, par4 + 1)))
        // {
        //     return true;
        // }
        // else
        // {
        //     if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID)
        //     {
        //         var6 = new InventoryLargeChest("Large chest", (TileEntityChest)par1World.getBlockTileEntity(par2 - 1, par3, par4), (IInventory)var6);
        //     }

        //     if (par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        //     {
        //         var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)par1World.getBlockTileEntity(par2 + 1, par3, par4));
        //     }

        //     if (par1World.getBlockId(par2, par3, par4 - 1) == this.blockID)
        //     {
        //         var6 = new InventoryLargeChest("Large chest", (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4 - 1), (IInventory)var6);
        //     }

        //     if (par1World.getBlockId(par2, par3, par4 + 1) == this.blockID)
        //     {
        //         var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4 + 1));
        //     }

        //     if (par1World.isRemote)
        //     {
        //         return true;
        //     }
        //     else
        //     {
        //         par5EntityPlayer.displayGUIChest((IInventory)var6);
        //         return true;
        //     }
        // }
    }

    /**
     * Returns the TileEntity used by this block.
     */
    public TileEntity getBlockEntity()
    {
        return new BookcaseTileEntity();
    }

    
    // public BlockBookcase(int blockID)
    // {
    //     super(blockID, Material.wood);
    //     blockIndexInTexture = 1;
    //     setHardness(2.0f);
    //     setResistance(5.0f);
    //     setStepSound(soundWoodFootstep);
        
    //     setBlockName("Bookcase");
    // }
    
    // @Override
    // public String getTextureFile()
    // {
    //     return "/terrain.png";
    // }
    
    // @Override
    // public int getBlockTextureFromSide(int side)
    // {
    //     switch(side)
    //     {
    //         case 0:
    //             return 21;
    //         case 1:
    //             return 21;
    //     }
    //     return blockIndexInTexture;
    // }
    
    // @Override
    // public TileEntity getBlockEntity()
    // {
    //     return new BookcaseTileEntity();
    // }
    
    // @Override
    // public boolean blockActivated(World world, int x, int y, int z,
    //     EntityPlayer player)
    // {
    //     TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
    //     if (tileEntity == null || player.isSneaking()) {
    //         return false;
    //     }
    //     //opens gui, to be implemented later
    //     //player.openGui();
    //     return true;
    // }
}