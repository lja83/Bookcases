package net.minecraft.src.Bookcases;

import net.minecraft.src.*;
import net.minecraft.src.forge.*;
import net.minecraft.src.Bookcases.*;
import net.minecraft.src.forge.ITextureProvider;

import java.util.Iterator;
import java.util.Random;

public class BlockBookcase extends BlockContainer implements ITextureProvider
{
    private Random random = new Random();
    private mod_Bookcase modInstance;

    protected BlockBookcase(int par1, mod_Bookcase instance)
    {
        super(par1, Material.wood);
        blockIndexInTexture = 15;
        setHardness(1.5f);
        setStepSound(soundWoodFootstep);
        setBlockName("Bookcase");
        
        modInstance = instance;
    }


    public String getTextureFile()
    {
        return "/Bookcases/shelves.png";
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
    }

    public void onBlockRemoval(World par1World, int par2, int par3, int par4)
    {
        BookcaseTileEntity var5 = (BookcaseTileEntity)par1World.getBlockTileEntity(par2, par3, par4);

        if (var5 != null)
        {
            for (int var6 = 0; var6 < var5.getSizeInventory(); ++var6)
            {
                ItemStack var7 = var5.getStackInSlot(var6);

                if (var7 != null)
                {
                    float var8 = this.random.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem var12;

                    for (float var10 = this.random.nextFloat() * 0.8F + 0.1F; var7.stackSize > 0; par1World.spawnEntityInWorld(var12))
                    {
                        int var11 = this.random.nextInt(21) + 10;

                        if (var11 > var7.stackSize)
                        {
                            var11 = var7.stackSize;
                        }

                        var7.stackSize -= var11;
                        var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));
                        float var13 = 0.05F;
                        var12.motionX = (double)((float)this.random.nextGaussian() * var13);
                        var12.motionY = (double)((float)this.random.nextGaussian() * var13 + 0.2F);
                        var12.motionZ = (double)((float)this.random.nextGaussian() * var13);

                        if (var7.hasTagCompound())
                        {
                            var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
                        }
                    }
                }
            }
        }

        super.onBlockRemoval(par1World, par2, par3, par4);
    }

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y, int z, int side)
    {
        int blockSide = blockIndexInTexture;
        if (side > 1) {
            Object tileEntity = par1IBlockAccess.getBlockTileEntity(x, y, z);
            blockSide = ((BookcaseTileEntity)tileEntity).getNumUsedSlots();
        }
        return blockSide;
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int side)
    {
        int blockSide = 15;
        if (side > 1)
        {
            // blockSide = 4;
            blockSide = 0;
        }
        
        return blockSide;
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
        par5EntityPlayer.openGui(modInstance, 0, par1World, par2, par3, par4);
        return true;
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