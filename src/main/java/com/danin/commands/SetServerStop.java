package com.danin.commands;

import com.danin.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class SetServerStop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        
        if(sender.hasPermission("stopserver.setserverstop")){
            if(args.length == 1){
                try{
                    int time = Integer.parseInt(args[0]);
                    FileConfiguration config = Main.getPlugin().getConfig();
                    config.set("time", time);
                    Main.getPlugin().saveConfig();
                    sender.sendMessage(ChatColor.GREEN+"Set time");
                }catch(NumberFormatException e){
                    sender.sendMessage(ChatColor.RED+"Please enter a valid time in seconds");
                }            
            }else{
                sender.sendMessage(ChatColor.RED+"use /setserverstop <time>");
            }
        }else{
            sender.sendMessage(ChatColor.RED+"You don't have the required permission");
        }
        

        return false;
    }
}
