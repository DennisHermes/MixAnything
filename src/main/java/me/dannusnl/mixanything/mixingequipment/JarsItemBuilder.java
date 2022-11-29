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
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Jar of Flammable Diamond");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack jarOfEmerald() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1100);
        meta.setDisplayName(ChatColor.GREEN + "Jar of Lucky Food Block");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack jarOfIron() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1200);
        meta.setDisplayName(ChatColor.WHITE + "Jar of Spikey Iron");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack jarOfSculk() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1300);
        meta.setDisplayName(ChatColor.DARK_GRAY + "Jar of Warden Horn");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack jarOfTheoreticalSpace() {
        ItemStack jar = new ItemStack(Material.MILK_BUCKET);
        ItemMeta meta = jar.getItemMeta();
        meta.setCustomModelData(100);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Jar of Theoretical Space");
        jar.setItemMeta(meta);
        return jar;
    }

}
