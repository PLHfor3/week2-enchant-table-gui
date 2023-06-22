package com.gmail.prestonhigg17;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class CheckForBookshelves
{
    private Location tableLocation;
    private int bookshelfCount;

    public CheckForBookshelves(Block block)
    {
        this.tableLocation = block.getLocation();
    }

    public int getBookshelfCount()
    {
        return bookshelfCount;
    }

    public void calculateLevel()
    {

    }

    public void countBookshelves()
    {
        World world = tableLocation.getWorld();
        int x = tableLocation.getBlockX();
        int y = tableLocation.getBlockY();
        int z = tableLocation.getBlockZ();
        bookshelfCount = 0;

        for (int yIndex = 0; yIndex <= 1; yIndex++)
        {
            for (int xIndex = -2; xIndex <= 2; xIndex++)
            {
                for (int zIndex = -2; zIndex <= 2; zIndex++)
                {
                    if (world.getBlockAt(x + xIndex, y + yIndex, z + zIndex).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from enchant table
                    {
                        bookshelfCount++;
                    }
                }
            }
        }
        removeCornerShelvesFromCorner(world, x, y, z);
    }

    public void removeCornerShelvesFromCorner(World world, int x, int y, int z)
    {
        for (int yIndex = 0; yIndex <= 1; yIndex++)
        {
            if (world.getBlockAt(x + 2, y + yIndex, z + 2).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from enchant table
            {
                bookshelfCount--;
            }
            if (world.getBlockAt(x + 2, y + yIndex, z - 2).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from enchant table
            {
                bookshelfCount--;
            }
            if (world.getBlockAt(x - 2, y + yIndex, z + 2).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from enchant table
            {
                bookshelfCount--;
            }
            if (world.getBlockAt(x - 2, y + yIndex, z - 2).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from enchant table
            {
                bookshelfCount--;
            }
        }
    }
}
