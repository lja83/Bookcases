package realbookcase.common;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import realbookcase.client.BookcaseGui;
import cpw.mods.fml.common.network.IGuiHandler;

public class BookcaseGuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof BookcaseTileEntity)
        {
            return new BookcaseContainer(player.inventory, (BookcaseTileEntity)tileEntity);
        }
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof BookcaseTileEntity)
        {
            return new BookcaseGui(player.inventory, (BookcaseTileEntity)tileEntity);
        }
        return null;
    }
}
