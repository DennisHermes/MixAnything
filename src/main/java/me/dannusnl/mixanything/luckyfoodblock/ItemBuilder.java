package me.dannusnl.mixanything.luckyfoodblock;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemBuilder() {

    }

    public ItemStack luckyFoodBlock() {
        ItemStack itemStack = new ItemStack(Material.HAY_BLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(100);
        itemMeta.setDisplayName(ChatColor.GREEN + "Lucky Food Block");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack eatableTotem() {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(100);
        itemMeta.setDisplayName(ChatColor.GREEN + "Eatable Totem");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack luckyBread() {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(200);
        itemMeta.setDisplayName(ChatColor.GREEN + "Lucky Bread");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack emeraldHelmet() {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(100);
        itemMeta.setDisplayName(ChatColor.GREEN + "Emerald Helmet");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack emeraldLeggings() {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(100);
        itemMeta.setDisplayName(ChatColor.GREEN + "Emerald Leggings");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack emeraldBoots() {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(100);
        itemMeta.setDisplayName(ChatColor.GREEN + "Emerald Boots");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
