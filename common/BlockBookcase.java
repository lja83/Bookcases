package Bookcases.common;

import java.util.Random;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockBookcase extends BlockContainer
{
    private Random random = new Random();
    private Bookcases_mod modInstance;
    
    public BlockBookcase(int blockID, Bookcases_mod instance)
    {
        super(blockID, Material.wood);
        blockIndexInTexture = 15;
        
        modInstance = instance;
    }
    
    public String getTextureFile()
    {
        return "/Bookcases/shelves.png";
    }
    
    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int idk, float what, float these, float are)
    {
        player.openGui(modInstance, 0, world, x, y, z);
        return true;
    }
    
    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        BookcaseTileEntity var7 = (BookcaseTileEntity)par1World.getBlockTileEntity(par2, par3, par4);

        if (var7 != null)
        {
            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null)
                {
                    float var10 = this.random.nextFloat() * 0.8F + 0.1F;
                    float var11 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem var14;

                    for (float var12 = this.random.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; par1World.spawnEntityInWorld(var14))
                    {
                        int var13 = this.random.nextInt(21) + 10;

                        if (var13 > var9.stackSize)
                        {
                            var13 = var9.stackSize;
                        }

                        var9.stackSize -= var13;
                        var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
                        float var15 = 0.05F;
                        var14.motionX = (double)((float)this.random.nextGaussian() * var15);
                        var14.motionY = (double)((float)this.random.nextGaussian() * var15 + 0.2F);
                        var14.motionZ = (double)((float)this.random.nextGaussian() * var15);

                        if (var9.hasTagCompound())
                        {
                            var14.item.setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
    public int getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        int blockSide = blockIndexInTexture;
        if (side > 1)
        {
            Object tileEntity = blockAccess.getBlockTileEntity(x, y, z);
            blockSide = ((BookcaseTileEntity)tileEntity).getNumUsedSlots();
        }
        return blockSide;
    }
    
    public int getBlockTextureFromSide(int side)
    {
        int blockSide = blockIndexInTexture;
        if (side > 1)
        {
            blockSide = 0;
        }
        return blockSide;
    }
    
    public TileEntity createNewTileEntity(World world)
    {
        return new BookcaseTileEntity();
    }
}
