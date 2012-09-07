package realbookcase.client;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;

import org.lwjgl.opengl.GL11;

import realbookcase.common.BookcaseContainer;
import realbookcase.common.BookcaseTileEntity;

public class BookcaseGui extends GuiContainer
{
    /**
     * window height is calculated with this values, the more rows, the heigher
     */
    private int inventoryRows = 1;
    private InventoryPlayer inventoryPlayer;
    private BookcaseTileEntity tileEntity;

    public BookcaseGui(InventoryPlayer inventoryPlayer, BookcaseTileEntity tileEntity)
    {
        super(new BookcaseContainer(inventoryPlayer, tileEntity));
        this.tileEntity = tileEntity;
        this.inventoryPlayer = inventoryPlayer;
        
        // this.upperChestInventory = par1IInventory;
        // this.allowUserInput = false;
        short var3 = 222;
        int var4 = var3 - 108;
        this.inventoryRows = tileEntity.getSizeInventory() / 7;
        this.ySize = var4 + this.inventoryRows * 18;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal(this.tileEntity.getInvName()), 8, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal(this.inventoryPlayer.getInvName()), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture("/gui/container.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        // int x = (width - xSize) / 2;
        // int y = (height - ySize) / 2;
        // this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        // Draw container inventory
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        // Draw player inventory
        this.drawTexturedModalRect(x, y + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}
