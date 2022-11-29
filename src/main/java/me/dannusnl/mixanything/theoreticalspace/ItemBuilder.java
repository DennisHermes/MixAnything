package me.dannusnl.mixanything.theoreticalspace;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemBuilder() {

    }

    public ItemStack voidBucket() {
        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(100);
        meta.setDisplayName(ChatColor.DARK_GRAY + "Void Bucket");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack GUI() {
        ItemStack gui = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = gui.getItemMeta();
        meta.setCustomModelData(700);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "GUI");
        gui.setItemMeta(meta);
        return gui;
    }


}
