package me.dannusnl.mixanything.mixingequipment;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class MixingPotClick implements Listener {

    public ArrayList<UUID> cooldown = new ArrayList<>();

    @EventHandler
    public void onEquipmentRemove(PlayerInteractEvent e) {
        if (cooldown.contains(e.getPlayer().getUniqueId())) return;
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (!e.getClickedBlock().getType().equals(Material.BARRIER)) return;

        cooldown.add(e.getPlayer().getUniqueId());
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> cooldown.remove(e.getPlayer().getUniqueId()), 3);

        Collection<Entity> entities = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, -1.4, 0.5), 0.3, 0.3, 0.3);
        if (entities.isEmpty()) return;
        for (Entity ent : entities) {
            if (ent.getType().equals(EntityType.ARMOR_STAND)) {
                if (!(ent.getCustomName().equals("Blender") || ent.getCustomName().equals("Mixer"))) continue;

                if (ent.getCustomName().equals("Blender")) {

                } else if (ent.getCustomName().equals("Mixer")) {

                }

            }
        }
    }

}
