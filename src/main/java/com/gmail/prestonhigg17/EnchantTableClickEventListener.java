package com.gmail.prestonhigg17;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnchantTableClickEventListener implements Listener
{
    public static Block enchantingTable;

    @EventHandler
    public void onPlayerClickEnchantTableListener(PlayerInteractEvent event)
    {
        try
        {
            Block block = event.getClickedBlock();
            if (block.getType().equals(Material.ENCHANTING_TABLE))
            {
                enchantingTable = block;
                Player player = event.getPlayer();
                int bookshelfCount = CheckForBookshelves.calculateLevel();

                try
                {
                    player.setOp(true);
                    player.performCommand("say Bookshelf Count:");
                } finally
                {
                    player.setOp(false);
                }
            }
        } catch (NullPointerException e)
        {
        }
    }
}
