package me.dannusnl.mixanything.theoreticalspace;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.UUID;

public class VoidBucket implements Listener {

    public ArrayList<UUID> cooldown = new ArrayList<>();

    @EventHandler
    public void onVoidBucketClick(PlayerInteractEvent e) {
        if (cooldown.contains(e.getPlayer().getUniqueId())) return;
        if (!e.getAction().equals(Action.RIGHT_CLICK_AIR)) return;
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.BUCKET)) return;

        cooldown.add(e.getPlayer().getUniqueId());
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> cooldown.remove(e.getPlayer().getUniqueId()), 3);

        if (e.getPlayer().getLocation().getY() < -57) {
            Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(new ItemBuilder().voidBucket()), 3);
        }
    }

}
