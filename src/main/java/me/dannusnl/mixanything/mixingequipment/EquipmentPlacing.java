package me.dannusnl.mixanything.mixingequipment;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class EquipmentPlacing implements Listener {

    public ArrayList<UUID> cooldown = new ArrayList<>();

    @EventHandler
    public void onEquipmentPlace(PlayerInteractEvent e) {
        if (cooldown.contains(e.getPlayer().getUniqueId())) return;
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.RABBIT_FOOT)) return;
        if (!e.getItem().hasItemMeta()) return;
        if (!e.getItem().getItemMeta().hasCustomModelData()) return;

        cooldown.add(e.getPlayer().getUniqueId());
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> cooldown.remove(e.getPlayer().getUniqueId()), 3);

        if (e.getItem().getItemMeta().getCustomModelData() == 100) {

            Block targetBlockLocation = e.getPlayer().getTargetBlock(null, 10).getRelative(e.getBlockFace());
            targetBlockLocation.setType(Material.BARRIER);
            ArmorStand ar = targetBlockLocation.getWorld().spawn(targetBlockLocation.getLocation().add(0.5, -1.4, 0.5), ArmorStand.class);
            ar.getEquipment().setHelmet(new ItemBuilder().blender());
            ar.setMarker(true);
            ar.setVisible(false);
            ar.setCustomName("Blender");
            ar.setCustomNameVisible(false);

        } else if (e.getItem().getItemMeta().getCustomModelData() == 300) {

            Block targetBlockLocation = e.getPlayer().getTargetBlock(null, 10).getRelative(e.getBlockFace());
            targetBlockLocation.setType(Material.BARRIER);
            ArmorStand ar = targetBlockLocation.getWorld().spawn(targetBlockLocation.getLocation().add(0.5, -1.4, 0.5), ArmorStand.class);
            ar.getEquipment().setHelmet(new ItemBuilder().mixer());
            ar.setMarker(true);
            ar.setVisible(false);
            ar.setCustomName("Mixer");
            ar.setCustomNameVisible(false);

        }

    }

    @EventHandler
    public void onEquipmentRemove(PlayerInteractEvent e) {
        if (cooldown.contains(e.getPlayer().getUniqueId())) return;
        if (!e.getAction().equals(Action.LEFT_CLICK_BLOCK)) return;
        if (!e.getClickedBlock().getType().equals(Material.BARRIER)) return;

        cooldown.add(e.getPlayer().getUniqueId());
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> cooldown.remove(e.getPlayer().getUniqueId()), 3);

        Collection<Entity> entities = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, -1.4, 0.5), 0.3, 0.3, 0.3);
        if (entities.isEmpty()) return;
        for (Entity ent : entities) {
            if (ent.getType().equals(EntityType.ARMOR_STAND)) {
                if (!(ent.getCustomName().equals("Blender") || ent.getCustomName().equals("Mixer"))) continue;

                e.setCancelled(true);
                e.getClickedBlock().setType(Material.AIR);
                ent.remove();

                if (ent.getCustomName().equals("Blender")) {
                    e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), new ItemBuilder().blender());
                } else if (ent.getCustomName().equals("Mixer")) {
                    e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), new ItemBuilder().mixer());
                }

            }
        }
    }

}
