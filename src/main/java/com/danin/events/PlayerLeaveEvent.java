package com.danin.events;

import com.danin.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveEvent implements Listener{
    
    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent event){
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
            public void run(){
                if(Bukkit.getServer().getOnlinePlayers().size()> 0){
                    return;
                }

                FileConfiguration config = Main.getPlugin().getConfig();
                int time = config.getInt("time");

                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                    public void run(){
                        if(Bukkit.getServer().getOnlinePlayers().size() == 0){
                            Bukkit.getServer().shutdown();
                        }
                    }
                }, 20*time);
            }
        }, 20);
    }
}
