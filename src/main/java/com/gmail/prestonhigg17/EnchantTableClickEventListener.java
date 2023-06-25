package com.gmail.prestonhigg17;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnchantTableClickEventListener implements Listener
{
    @EventHandler
    public void onPlayerClickEnchantTableListener(PlayerInteractEvent event)
    {
        try
        {
            Block block = event.getClickedBlock();
            if (block.getType().equals(Material.ENCHANTING_TABLE))
            {
                CheckForBookshelves checkForBookshelves = new CheckForBookshelves(block);
                CheckForAir checkForAir = new CheckForAir(block);
                CalculateTableLevel calculateTableLevel = new CalculateTableLevel(checkForBookshelves.getBookshelfCount(), checkForAir.getAirBlockCount());
                Bukkit.broadcastMessage(block.toString());
                Bukkit.broadcastMessage("Bookshelf Count: " + checkForBookshelves.getBookshelfCount());
                Bukkit.broadcastMessage("Air Count: " + checkForAir.getAirBlockCount());
                int array[] = calculateTableLevel.getTableLevel();
                Bukkit.broadcastMessage("Calculated Shelf Amount: " + array[0]);
                Bukkit.broadcastMessage("Calculated Shelf Amount: " + array[1]);
                Bukkit.broadcastMessage("Calculated Shelf Amount: " + array[2]);
            }
        } catch (NullPointerException e)
        {
        }
    }
}
