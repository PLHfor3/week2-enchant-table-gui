package com.gmail.prestonhigg17;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class CheckForBookshelves
{
    Location ploc;
    Block enchantingTable;
    int bookshelfCount;

    public CheckForBookshelves(Block block)
    {
        ploc = block.getLocation();
        this.enchantingTable = block;
    }

    public int getBookshelfCount()
    {
        return bookshelfCount;
    }

    public void calculateLevel()
    {
        Block block = enchantingTable;
        ploc = block.getLocation();
        countBookshelves();
    }

    public void countBookshelves()
    {
        World world = ploc.getWorld();
        int x = ploc.getBlockX();
        int y = ploc.getBlockY();
        int z = ploc.getBlockZ();
        bookshelfCount = 0;

        for (int yIndex = 0; yIndex <= 1; yIndex++)
        {
            for (int xIndex = -2; xIndex <= 2; xIndex++)
            {
                for (int zIndex = -2; zIndex <= 2; zIndex++)
                {
                    Bukkit.broadcastMessage(world.getBlockAt(x + xIndex, y + yIndex, z + zIndex).toString());
                    if (world.getBlockAt(x + xIndex, y + yIndex, z + zIndex).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from enchant table
                    {
                        bookshelfCount++;
                    }
                }
            }
        }
    }
}
