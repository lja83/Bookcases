package net.minecraft.src.Bookcases;

import net.minecraft.src.*;

public class BookcaseContainer extends Container
{
    private IInventory bookCaseInventory;
    private int numRows;
    private int numCols;

    public BookcaseContainer(InventoryPlayer inventoryPlayer, BookcaseTileEntity tileEntity)
    {
        bookCaseInventory = tileEntity;
        // addSlot(new Slot(bookCaseInventory, 0, 76, 37));
        
        // this.numRows = par2IInventory.getSizeInventory() / 9;
        this.numRows = 2;
        this.numCols = tileEntity.getSizeInventory() / numRows;
        
        int var3 = (this.numRows - 4) * 18;
        int var4;
        int var5;

        for (var4 = 0; var4 < this.numRows; ++var4)
        {
            for (var5 = 0; var5 < numCols; ++var5)
            {
                this.addSlot(new Slot(tileEntity, var5 + var4 * numCols, 8 + var5 * 18, 18 + var4 * 18));
            }
        }

        for (var4 = 0; var4 < 3; ++var4)
        {
            for (var5 = 0; var5 < 9; ++var5)
            {
                this.addSlot(new Slot(inventoryPlayer, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3));
            }
        }

        for (var4 = 0; var4 < 9; ++var4)
        {
            this.addSlot(new Slot(inventoryPlayer, var4, 8 + var4 * 18, 161 + var3));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return bookCaseInventory.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 < this.numRows * this.numCols)
            {
                if (!this.mergeItemStack(var4, this.numRows * this.numCols, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 0, this.numRows * this.numCols, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }
        }

        return var2;
    }
}
