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
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.phosphoramc.phosphora.Phosphora.addHiddenTag;

public class VaultCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            Inventory shadowVault = Bukkit.createInventory(p, 9, "Shadow Vault");
            //pick
            ItemStack item1 = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemMeta meta1 = item1.getItemMeta();
            meta1.setDisplayName(ChatColor.AQUA + "Shadow Pick II");
            ArrayList<String> lore1 = new ArrayList<>();
            lore1.add(ChatColor.RED + "it ruthlessly tore through the unflinching earth");
            lore1.add(ChatColor.RED + "returning untold bounties to it's beholder");
            meta1.setLore(lore1);
            item1.setItemMeta(meta1);
            item1.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
            item1.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            item1.addUnsafeEnchantment(Enchantment.MENDING, 1);
            item1.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);

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

            //elytra
            ItemStack item4 = new ItemStack(Material.ELYTRA, 1);
            ItemMeta meta4 = item4.getItemMeta();
            meta4.setDisplayName(ChatColor.AQUA + "Forbidden Wings");
            ArrayList<String> lore4 = new ArrayList<>();
            lore4.add(ChatColor.RED + "the protective properties of these wings remain a mystery");
            lore4.add(ChatColor.RED + "to all whom have attempted to study them.");
            meta4.setLore(lore4);
            item4.setItemMeta(meta4);
            item4.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            item4.addUnsafeEnchantment(Enchantment.MENDING, 1);
            item4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);

            //tpbow
            ItemStack tpbow = new ItemStack(Material.BOW);
            ItemMeta meta5 = tpbow.getItemMeta();
            meta5.setDisplayName(ChatColor.AQUA + "Enderbow");
            ArrayList<String> lore5 = new ArrayList<>();
            lore5.add(addHiddenTag("#tpbow"));
            lore5.add(ChatColor.RED + "it is said that explorers trapped in The End,");
            lore5.add(ChatColor.RED + "once had to resort to using unfavorable materials to");
            lore5.add(ChatColor.RED + "craft tools and weapons to defend themselves.");
            lore5.add("");
            lore5.add(ChatColor.RED + "This rare specimen, having been crafted from Enderman bones,");
            lore5.add(ChatColor.RED + "has adopted some rather special characteristics.");
            lore5.add(ChatColor.YELLOW + "not recommended for combat situations.");
            meta5.setLore(lore5);
            tpbow.setItemMeta(meta5);
            tpbow.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            tpbow.addUnsafeEnchantment(Enchantment.MENDING, 1);
            tpbow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

            ItemStack[] items = {
                    item1,
                    item2,
                    item3,
                    item4,
                    new ItemStack(Material.FIREWORK_ROCKET, 64),
                    tpbow,
                    new ItemStack(Material.ARROW, 32)
            };

            shadowVault.setContents(items);

            p.openInventory(shadowVault);
        } else {
            System.out.println("A player needs to run this command.");
        }

        return true;
    }
}
