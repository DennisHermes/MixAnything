package me.dannusnl.mixanything.flammablediamond;

import me.dannusnl.mixanything.MixAnything;
import me.dannusnl.mixanything.PreventMerge;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collection;

public class FlammebleDiamond implements Listener {

    @EventHandler
    public void onTntPlace(BlockPlaceEvent e) {
        if (e.getItemInHand() == null) return;
        if (!e.getItemInHand().getType().equals(Material.TNT)) return;
        if (!e.getItemInHand().hasItemMeta()) return;
        if (!e.getItemInHand().getItemMeta().hasCustomModelData()) return;
        if (e.getItemInHand().getItemMeta().getCustomModelData() != 100) return;

        ArmorStand ar = e.getBlockPlaced().getWorld().spawn(e.getBlockPlaced().getLocation().add(0.5, -0.4, 0.5), ArmorStand.class);
        ar.getEquipment().setHelmet(new ItemBuilder().flammebleDiamondBlock());
        ar.setMarker(true);
        ar.setVisible(false);
        ar.setCustomName("FlammebleDiamondBlock");
        ar.setCustomNameVisible(false);
    }

    @EventHandler
    public void onTntPrime(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getClickedBlock() == null) return;
        if (!e.getClickedBlock().getType().equals(Material.TNT)) return;
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.FLINT_AND_STEEL)) return;

        if (!e.getClickedBlock().getType().equals(Material.TNT)) return;
        Collection<Entity> entities = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, -0.4, 0.5), 0.3, 0.3, 0.3);
        if (entities.isEmpty()) return;
        for (Entity ent : entities) {
            if (ent.getType().equals(EntityType.ARMOR_STAND)) {
                if (!ent.getCustomName().equals("FlammebleDiamondBlock")) return;

                e.setCancelled(true);
                ent.remove();
                e.getClickedBlock().setType(Material.AIR);

                TNTPrimed tnt = e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), TNTPrimed.class);
                tnt.setCustomName("FlammebleDiamondBlock");
                tnt.setCustomNameVisible(false);
            }
        }
    }

    @EventHandler
    public void onTntExplode(EntityExplodeEvent e) {
        if (!e.getEntity().getType().equals(EntityType.PRIMED_TNT)) return;
        if (e.getEntity().getCustomName() == null) return;
        if (!e.getEntity().getCustomName().equals("FlammebleDiamondBlock")) return;

        PreventMerge.mergeEnabled = false;
        Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> PreventMerge.mergeEnabled = true, 100);

        Location loc = e.getLocation();
        int radius = 2;
        for (double x = loc.getX() - radius; x < loc.getX() + radius; x++ ) {
            for (double z = loc.getZ() - radius; z < loc.getZ() + radius; z++) {
                int random = (int) (Math.random() * 5);
                if (random > 1) {
                    Location newLoc = new Location(loc.getWorld(), x, loc.getY(), z);
                    newLoc.getWorld().dropItemNaturally(newLoc, new ItemBuilder().flammebleDiamond());
                }
            }
        }
    }

}
