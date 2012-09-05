package net.minecraft.src.Bookcases;

import net.minecraft.src.*;

public class BookcaseContainer extends Container
{
    private IInventory bookCaseInventory;
    private int numRows;

    public BookcaseContainer(IInventory par1IInventory)
    {
        addSlot(new Slot(bookCaseInventory, 0, 76, 37));
        // bindPlayerInventory(inventoryPlayer);
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

            if (par1 < this.numRows * 9)
            {
                if (!this.mergeItemStack(var4, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 0, this.numRows * 9, false))
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
