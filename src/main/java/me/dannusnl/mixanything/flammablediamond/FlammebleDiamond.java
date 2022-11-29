package me.dannusnl.mixanything.flammablediamond;

import me.dannusnl.mixanything.MixAnything;
import me.dannusnl.mixanything.PreventMerge;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        ItemBuilder itemBuilder = new ItemBuilder();
        ar.getEquipment().setHelmet(itemBuilder.flammebleDiamondBlock());
        ar.setMarker(true);
        ar.setVisible(false);
        ar.setCustomName("FlammebleDiamondBlock");
        ar.setCustomNameVisible(false);
    }

    @EventHandler
    public void onTntRemove(BlockBreakEvent e) {
        if (e.getBlock().getType() != Material.TNT) return;
        Collection<Entity> entities = e.getBlock().getWorld().getNearbyEntities(e.getBlock().getLocation().add(0.5, -0.4, 0.5), 0.3, 0.3, 0.3);
        if (entities.isEmpty()) return;
        for (Entity ent : entities) {
            if (ent instanceof ArmorStand) {
                if (ent.getCustomName() == null) return;
                if (!ent.getCustomName().equals("FlammebleDiamondBlock")) return;
                e.setDropItems(false);
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemBuilder().flammebleDiamondBlock());
                ent.remove();
            }
        }
    }

    @EventHandler
    public void onTntPrime(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getClickedBlock() == null) return;
        if (!e.getClickedBlock().getType().equals(Material.TNT)) return;
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.FLINT_AND_STEEL)) return;

        Collection<Entity> entities = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, -0.4, 0.5), 0.3, 0.3, 0.3);
        if (entities.isEmpty()) return;
        for (Entity ent : entities) {
            if (ent.getType().equals(EntityType.ARMOR_STAND)) {
                if (!ent.getCustomName().equals("FlammebleDiamondBlock")) continue;

                ArmorStand ar = (ArmorStand) ent;

                e.setCancelled(true);
                e.getClickedBlock().setType(Material.AIR);

                ItemStack item1 = new ItemStack(Material.TNT);
                ItemMeta meta1 = item1.getItemMeta();
                meta1.setCustomModelData(100);
                item1.setItemMeta(meta1);

                ItemStack item2 = new ItemStack(Material.TNT);
                ItemMeta meta2 = item2.getItemMeta();
                meta2.setCustomModelData(200);
                item2.setItemMeta(meta2);

                ar.getEquipment().setHelmet(item2);

                for (int i = 0; i < 8; i++) {
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getClickedBlock().getWorld().spawnParticle(Particle.LAVA, e.getClickedBlock().getLocation().add(0.5, 1, 0.5), 50, 0.1, 0.1, 0.1, 0.1), i * 10);
                }

                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item1), 10);
                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item2), 20);
                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item1), 30);
                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item2), 40);
                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item1), 50);
                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item2), 60);
                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item1), 70);
                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> ar.getEquipment().setHelmet(item2), 80);

                Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> {
                    TNTPrimed tnt = e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), TNTPrimed.class);
                    tnt.setFuseTicks(0);
                    tnt.setCustomName("FlammebleDiamondBlock");
                    tnt.setCustomNameVisible(false);
                    ar.remove();
                }, 80);
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
                    newLoc.getWorld().spawnParticle(Particle.LAVA, newLoc, 10, 0.5, 0.5, 0.5, 0.5);
                }
            }
        }
    }

}
