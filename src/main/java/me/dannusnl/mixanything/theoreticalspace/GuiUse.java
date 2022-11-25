package me.dannusnl.mixanything.theoreticalspace;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class GuiUse implements Listener {

    @EventHandler
    public void onGuiUse(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_AIR)) return;
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.RABBIT_FOOT)) return;
        if (!e.getItem().hasItemMeta()) return;
        if (!e.getItem().getItemMeta().hasCustomModelData()) return;
        if (e.getItem().getItemMeta().getCustomModelData() != 700) return;

        for (World world : Bukkit.getWorlds()) {
            if (world.getEnvironment().equals(World.Environment.THE_END)) {
                e.getPlayer().teleport(world.getSpawnLocation());
            }
        }
    }

}
