package com.gmail.prestonhigg17;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class CheckForAir
{
    private Location tableLocation;
    private int shelvesToRemoveFromCount; //defines how many bookshelves should be removed from the total number calculated

    public int getAirBlockCount()
    {
        return shelvesToRemoveFromCount;
    }

    public CheckForAir(Block block)
    {
        this.tableLocation = block.getLocation();
    }

    public void countAirBlocks()
    {
        World world = tableLocation.getWorld();
        int x = tableLocation.getBlockX();
        int y = tableLocation.getBlockY();
        int z = tableLocation.getBlockZ();
        shelvesToRemoveFromCount = 0;

        for (int yIndex = 0; yIndex <= 1; yIndex++)
        {
            for (int xIndex = -1; xIndex <= 1; xIndex++)
            {
                for (int zIndex = -1; zIndex <= 1; zIndex++)
                {
                    if (!world.getBlockAt(x + xIndex, y + yIndex, z + zIndex).getType().equals(Material.AIR)) // check for block type at each surrounding coords from enchant table
                    {
                        bookshelvesAroundAir(world.getBlockAt(x + xIndex, y + yIndex, z + zIndex), world);
                    }
                }
            }
        }
    }

    public void bookshelvesAroundAir(Block block, World world)
    {
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        for (int xIndex = -1; xIndex <= 1; xIndex++)
        {
            if (world.getBlockAt(x + xIndex, y, z).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from not air block
            {
                shelvesToRemoveFromCount++;
            }
        }
        for (int zIndex = -1; zIndex <= 1; zIndex++)
        {
            if (world.getBlockAt(x, y, z + zIndex).getType().equals(Material.BOOKSHELF)) // check for block type at each surrounding coords from not air block
            {
                shelvesToRemoveFromCount++;
            }
        }
    }
}
