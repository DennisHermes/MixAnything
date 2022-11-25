package me.dannusnl.mixanything.warden;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EquipHead implements Listener {

    @EventHandler
    public void onEquipHead(PlayerInteractEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getType() != Material.RABBIT_FOOT) return;
        if (!e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) return;
        if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 800) return;

        e.getPlayer().getInventory().setHelmet(e.getItem());
        Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> e.getPlayer().getInventory().setItemInMainHand(null), 1);
    }

}
