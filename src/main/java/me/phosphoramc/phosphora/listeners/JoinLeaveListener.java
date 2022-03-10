package me.phosphoramc.phosphora.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinLeaveListener implements Listener {

    String chatPrefix = ChatColor.BLUE + "" + ChatColor.BOLD;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = chatPrefix + player.getDisplayName();
        if (player.hasPlayedBefore()) {
            player.sendMessage("Welcome back, " + playerName);
        } else {
            player.sendMessage(ChatColor.AQUA + "Welcome to the wilds, " + playerName);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(chatPrefix + player.getDisplayName() + ChatColor.GRAY + " has left the server.");
    }

}
