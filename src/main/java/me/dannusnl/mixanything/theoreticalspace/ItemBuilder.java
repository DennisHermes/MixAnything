package me.dannusnl.mixanything.theoreticalspace;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemBuilder() {

    }

    public ItemStack jarOfTheoreticalSpace() {
        ItemStack jar = new ItemStack(Material.MILK_BUCKET);
        ItemMeta meta = jar.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Jar of Theoretical Space");
        jar.setItemMeta(meta);
        return jar;
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
