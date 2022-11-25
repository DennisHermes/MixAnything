package me.dannusnl.mixanything.spikyiron;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class DamageMechanic {

    public DamageMechanic() {

    }

    public void damageMechanic(Player p) {
        if (p.getInventory().getItemInMainHand() == null) return;
        if (!p.getInventory().getItemInMainHand().getType().equals(Material.RABBIT_FOOT)) return;
        if (!p.getInventory().getItemInMainHand().hasItemMeta()) return;
        if (!p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) return;
        if (p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 600) {
            p.damage(1);
        } else if (p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 500) {
            p.damage(1);
        }
    }

}
