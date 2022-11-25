package me.dannusnl.mixanything.theoreticalspace;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.UUID;

public class BlockRemoving implements Listener {

    ArrayList<UUID> cooldown = new ArrayList<>();

    @EventHandler
    public void onEraseBlock(PlayerInteractEvent e) {
        if (cooldown.contains(e.getPlayer().getUniqueId())) return;
        if (!ActivateSpaceBuffs.spaceBuffsActive) return;
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getItem() != null) return;

        cooldown.add(e.getPlayer().getUniqueId());
        Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> cooldown.remove(e.getPlayer().getUniqueId()), 3);

        e.getClickedBlock().setType(Material.AIR);
        e.getClickedBlock().getWorld().spawnParticle(Particle.CLOUD, e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5), 50, 0.01, 0.01, 0.01, 0.1);
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, 10, 1);

        TNTPrimed tnt = e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), TNTPrimed.class);
        tnt.setFuseTicks(0);

        Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> e.getPlayer().getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), new ItemBuilder().GUI()), 1);
    }

    @EventHandler
    public void onExplosionDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType().equals(EntityType.PRIMED_TNT)) {
            e.setCancelled(true);
        }
    }

}
