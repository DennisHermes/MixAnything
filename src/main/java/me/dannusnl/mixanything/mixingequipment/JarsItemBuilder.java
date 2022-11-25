package me.dannusnl.mixanything.mixingequipment;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JarsItemBuilder {

    public JarsItemBuilder() {

    }

    public ItemStack jarOfFlammable() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1000);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Jar of Flammable");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack jarOfEmerald() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1100);
        meta.setDisplayName(ChatColor.GREEN + "Jar of Emerald");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack jarOfIron() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1200);
        meta.setDisplayName(ChatColor.WHITE + "Jar of Iron");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack jarOfSculk() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1300);
        meta.setDisplayName(ChatColor.DARK_GRAY + "Jar of Sculk");
        item.setItemMeta(meta);
        return item;
    }

}
