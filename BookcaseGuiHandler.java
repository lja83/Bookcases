package net.minecraft.src.Bookcases;

import net.minecraft.src.Bookcases.*;
import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class BookcaseGuiHandler implements IGuiHandler
{
    public BookcaseGuiHandler()
    {}
    
    // @Override
    // public Object getServerGuiElement(int id, EntityPlayer player, World world,
    //                 int x, int y, int z)
    // {
    //     TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
    //     if (tileEntity instanceof BookcaseTileEntity) {
    //         return new BookcaseContainer(player.inventory, (BookcaseTileEntity)tileEntity);
    //     }
    //     return null;
    // }
    
    @Override
    public Object getGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof BookcaseTileEntity) {
            return new GuiBookcase(player.inventory, (BookcaseTileEntity) tileEntity);
        }
        return null;
    }
}