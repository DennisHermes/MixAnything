package me.dannusnl.mixanything.warden;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemBuilder() {

    }

    public ItemStack wardenHorn() {
        ItemStack item = new ItemStack(Material.GOAT_HORN);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(100);
        meta.setDisplayName(ChatColor.GOLD + "Warden Horn");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack wardenHead() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(800);
        meta.setDisplayName(ChatColor.GOLD + "Warden Head");
        item.setItemMeta(meta);
        return item;
    }

}
