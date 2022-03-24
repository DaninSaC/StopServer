package com.danin.main;

import com.danin.commands.SetServerStop;
import com.danin.events.PlayerLeaveEvent;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    
    private static Main plugin;

    public void onEnable(){
        plugin = this;

        getCommand("setserverstop").setExecutor(new SetServerStop());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerLeaveEvent(), plugin);
    }

    public static Main getPlugin(){
        return plugin;
    }
}
