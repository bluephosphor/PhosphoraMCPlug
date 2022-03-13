package me.phosphoramc.phosphora;

import me.phosphoramc.phosphora.commands.VaultCommand;
import me.phosphoramc.phosphora.listeners.JoinLeaveListener;
import me.phosphoramc.phosphora.listeners.TPBowListener;
import me.phosphoramc.phosphora.listeners.XPBottleBreakListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Phosphora extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Welcome to the Wilds");
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(),this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(),this);
        getServer().getPluginManager().registerEvents(new TPBowListener(), this);
        getCommand("shadowvault").setExecutor(new VaultCommand());
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    public static String addHiddenTag(String message) {
        StringBuilder builder = new StringBuilder();

        for(char c : message.toCharArray()){
            builder.append(ChatColor.COLOR_CHAR).append(c);
        }

        return builder.toString();
    }
}

