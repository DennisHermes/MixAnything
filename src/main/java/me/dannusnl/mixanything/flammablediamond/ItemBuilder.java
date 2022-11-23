package me.dannusnl.mixanything.flammablediamond;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemBuilder {

    ItemBuilder() {

    }

    public ItemStack flammebleDiamondBlock() {
        ItemStack flammebleDiamondBlock = new ItemStack(Material.TNT);
        ItemMeta flammebleDiamondBlockMeta = flammebleDiamondBlock.getItemMeta();
        flammebleDiamondBlockMeta.setCustomModelData(100);
        flammebleDiamondBlockMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Flammeble Diamond Block");
        ArrayList<String> flammebleDiamondBlockLore = new ArrayList<>();
        flammebleDiamondBlockLore.add(ChatColor.YELLOW + "A diamond block that is highly explosive.");
        flammebleDiamondBlockMeta.setLore(flammebleDiamondBlockLore);
        flammebleDiamondBlock.setItemMeta(flammebleDiamondBlockMeta);
        return flammebleDiamondBlock;
    }

    public ItemStack flammebleDiamond() {
        ItemStack flammebleDiamond = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta flammebleDiamondMeta = flammebleDiamond.getItemMeta();
        flammebleDiamondMeta.setCustomModelData(400);
        flammebleDiamondMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Flammeble Diamond");
        ArrayList<String> flammebleDiamondLore = new ArrayList<>();
        flammebleDiamondLore.add(ChatColor.YELLOW + "A diamond that is on fire.");
        flammebleDiamondMeta.setLore(flammebleDiamondLore);
        flammebleDiamond.setItemMeta(flammebleDiamondMeta);
        return flammebleDiamond;
    }

    public ItemStack flammebleDiamondPickaxe() {
        ItemStack flammebleDiamondPickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta flammebleDiamondPickaxeMeta = flammebleDiamondPickaxe.getItemMeta();
        flammebleDiamondPickaxeMeta.setCustomModelData(100);
        flammebleDiamondPickaxeMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Flammeble Diamond Pickaxe");
        ArrayList<String> flammebleDiamondPickaxeLore = new ArrayList<>();
        flammebleDiamondPickaxeLore.add(ChatColor.YELLOW + "A pickaxe with some explosive power.");
        flammebleDiamondPickaxeMeta.setLore(flammebleDiamondPickaxeLore);
        flammebleDiamondPickaxe.setItemMeta(flammebleDiamondPickaxeMeta);
        return flammebleDiamondPickaxe;
    }

}
