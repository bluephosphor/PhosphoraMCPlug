package me.phosphoramc.phosphora;

import me.phosphoramc.phosphora.listeners.JoinLeaveListener;
import me.phosphoramc.phosphora.listeners.XPBottleBreakListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Phosphora extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Welcome to the Wilds");
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(),this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(),this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        return true;
    }
}

