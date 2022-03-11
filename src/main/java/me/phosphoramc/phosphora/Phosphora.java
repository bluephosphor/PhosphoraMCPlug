package me.phosphoramc.phosphora;

import me.phosphoramc.phosphora.commands.FeedCommand;
import me.phosphoramc.phosphora.commands.GodCommand;
import me.phosphoramc.phosphora.listeners.JoinLeaveListener;
import me.phosphoramc.phosphora.listeners.XPBottleBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Phosphora extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Welcome to the Wilds");
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(),this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(),this);
        getCommand("god").setExecutor(new GodCommand());
        getCommand("eat").setExecutor(new FeedCommand());
    }
}

