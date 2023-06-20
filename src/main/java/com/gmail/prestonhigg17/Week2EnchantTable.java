package com.gmail.prestonhigg17;

import org.bukkit.plugin.java.JavaPlugin;

public class Week2EnchantTable extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        super.onEnable();
        getServer().getPluginManager().registerEvents(new EnchantTableClickEventListener(), this);
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
    }
}