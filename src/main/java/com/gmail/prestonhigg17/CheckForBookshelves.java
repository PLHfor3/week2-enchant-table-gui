package com.gmail.prestonhigg17;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import static com.gmail.prestonhigg17.EnchantTableClickEventListener.*;

public class CheckForBookshelves
{
    static Location ploc;
    static int bookshelfCount = 0;

    public static int calculateLevel()
    {
        Block block = enchantingTable;
        ploc = block.getLocation();
        return bookshelfCount;
    }

    public int countBookshelves()
    {
        for (int y = 0; y <= 1; y++)
        {
            for (int x = -2; x <= 2; x++)
            {
                for (int z = -2; z <= -2; z++)
                {
                    if (ploc.add(x, y, z).getBlock().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from enchant table
                    {
                        bookshelfCount++;
                    }
                }
            }
        }
        return 0;
    }
}
