package me.phosphoramc.phosphora.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VaultCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            Inventory shadowVault = Bukkit.createInventory(p, 9, "Shadow Vault");
            //pick
            ItemStack item1 = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemMeta meta1 = item1.getItemMeta();
            meta1.setDisplayName(ChatColor.AQUA + "Shadow Pick I");
            ArrayList<String> lore1 = new ArrayList<>();
            lore1.add(ChatColor.RED + "it cut through the brittle and cracked earth");
            lore1.add(ChatColor.RED + "with such grace, leaving no sign of disturbance");
            lore1.add(ChatColor.RED + "in it's wake.");
            meta1.setLore(lore1);
            item1.setItemMeta(meta1);
            item1.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
            item1.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            item1.addUnsafeEnchantment(Enchantment.MENDING, 1);
            item1.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);

            //sword
            ItemStack item2 = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName(ChatColor.AQUA + "Shadow Blade I");
            ArrayList<String> lore2 = new ArrayList<>();
            lore2.add(ChatColor.RED + "it tore through it's enemies");
            lore2.add(ChatColor.RED + "with precision and ease");
            meta2.setLore(lore2);
            item2.setItemMeta(meta2);
            item2.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            item2.addUnsafeEnchantment(Enchantment.MENDING, 1);
            item2.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 15);
            item2.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);

            //axe
            ItemStack item3 = new ItemStack(Material.IRON_AXE, 1);
            ItemMeta meta3 = item3.getItemMeta();
            meta3.setDisplayName(ChatColor.AQUA + "Shadow Axe I");
            ArrayList<String> lore3 = new ArrayList<>();
            lore3.add(ChatColor.RED + "there were none who met the receiving end");
            lore3.add(ChatColor.RED + "of this blade and lived to tell the tale.");
            meta3.setLore(lore3);
            item3.setItemMeta(meta3);
            item3.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            item3.addUnsafeEnchantment(Enchantment.MENDING, 1);
            item3.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 30);
            item3.addUnsafeEnchantment(Enchantment.DIG_SPEED, 5);

            ItemStack[] items = {item1, item2, item3};

            shadowVault.setContents(items);

            p.openInventory(shadowVault);
        } else {
            System.out.println("A player needs to run this command.");
        }

        return true;
    }
}
