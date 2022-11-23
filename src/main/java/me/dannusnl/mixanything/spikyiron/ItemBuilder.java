package me.dannusnl.mixanything.spikyiron;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemBuilder() {

    }

    public ItemStack spikeyIronBlock() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(500);
        meta.setDisplayName(ChatColor.WHITE + "Spikey Iron Block");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack spikeyIronIngot() {
        ItemStack item = new ItemStack(Material.RABBIT_FOOT);
        item.setAmount(9);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(600);
        meta.setDisplayName(ChatColor.WHITE + "Spikey Iron Ingot");
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack spikeyIronChestplate() {
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(700);
        meta.setDisplayName(ChatColor.WHITE + "Spikey Iron Chestplate");
        meta.addEnchant(Enchantment.THORNS, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        item.setItemMeta(meta);
        return item;
    }

}
