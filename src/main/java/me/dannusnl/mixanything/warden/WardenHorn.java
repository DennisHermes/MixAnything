package me.dannusnl.mixanything.warden;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Warden;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WardenHorn implements Listener {

    @EventHandler
    public void onWardenHornUse(PlayerInteractEvent e) {
        if (!(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR))) return;
        if (e.getItem() == null) return;
        if (e.getItem().getType() != Material.GOAT_HORN) return;
        if (!e.getItem().hasItemMeta()) return;
        if (!e.getItem().getItemMeta().hasCustomModelData()) return;
        if (e.getItem().getItemMeta().getCustomModelData() != 100) return;

        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ITEM_GOAT_HORN_SOUND_7, 1, 1);
        Location loc = e.getPlayer().getLocation().add(2, 1, 2);

        Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> e.getPlayer().getInventory().setItemInMainHand(null), 1);

        Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> {
            loc.getWorld().strikeLightning(loc);
            Warden warden = (Warden) loc.getWorld().spawnEntity(loc, EntityType.WARDEN);
            e.getPlayer().playSound(loc, Sound.ENTITY_WARDEN_EMERGE, 1, 1);
            warden.setTarget(e.getPlayer());
        }, 60);

    }

}
