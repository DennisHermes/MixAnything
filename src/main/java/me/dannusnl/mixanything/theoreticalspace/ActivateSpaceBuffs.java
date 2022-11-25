package me.dannusnl.mixanything.theoreticalspace;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class ActivateSpaceBuffs implements Listener {

    public static boolean spaceBuffsActive = false;

    @EventHandler
    public void onSpaceBuffActivate(PlayerItemConsumeEvent e) {
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.MILK_BUCKET)) return;
        if (!e.getItem().hasItemMeta()) return;
        if (!e.getItem().getItemMeta().hasCustomModelData()) return;
        if (e.getItem().getItemMeta().getCustomModelData() != 100) return;

        spaceBuffsActive = true;
        AttributeInstance attribute = e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(100.0D);
        e.getPlayer().setHealth(100.0D);

        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 1);
        e.getPlayer().spawnParticle(org.bukkit.Particle.EXPLOSION_HUGE, e.getPlayer().getLocation(), 3);
    }

}
