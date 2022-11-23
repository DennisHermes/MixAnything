package me.dannusnl.mixanything.mixingequipment;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemBuilder {

    public ItemBuilder() {

    }

    public ItemStack blender() {
        ItemStack blender = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta blenderMeta = blender.getItemMeta();
        blenderMeta.setCustomModelData(100);
        blenderMeta.setDisplayName(ChatColor.AQUA + "Blender");
        ArrayList<String> blenderLore = new ArrayList<>();
        blenderLore.add(ChatColor.YELLOW + "A blender to mix your ingredients.");
        blenderMeta.setLore(blenderLore);
        blender.setItemMeta(blenderMeta);
        return blender;
    }

    public ItemStack emptyJar() {
        ItemStack emptyJar = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta emptyJarMeta = emptyJar.getItemMeta();
        emptyJarMeta.setCustomModelData(200);
        emptyJarMeta.setDisplayName(ChatColor.AQUA + "Empty Jar");
        ArrayList<String> emptyJarLore = new ArrayList<>();
        emptyJarLore.add(ChatColor.YELLOW + "An empty jar to store your fluids.");
        emptyJarMeta.setLore(emptyJarLore);
        emptyJar.setItemMeta(emptyJarMeta);
        return emptyJar;
    }

    public ItemStack mixer() {
        ItemStack mixer = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta mixerMeta = mixer.getItemMeta();
        mixerMeta.setCustomModelData(300);
        mixerMeta.setDisplayName(ChatColor.AQUA + "Mixing Pot");
        ArrayList<String> mixerLore = new ArrayList<>();
        mixerLore.add(ChatColor.YELLOW + "Turn your fluids into a block.");
        mixerMeta.setLore(mixerLore);
        mixer.setItemMeta(mixerMeta);
        return mixer;
    }

}
