package me.dannusnl.mixanything.flammablediamond;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PickaxeMining implements Listener {

    @EventHandler
    public void onPickaxeMining(BlockBreakEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand() == null) return;
        if (!e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_PICKAXE)) return;
        if (!e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) return;
        if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 100) return;

        e.setCancelled(true);

        Location loc = e.getBlock().getLocation().add(1, 1, 1);
        double radius = 1.5;
        for (double x = loc.getX() - radius; x < loc.getX() + radius; x++ ) {
            for (double y = loc.getY() - radius; y < loc.getY() + radius; y++ ) {
                for (double z = loc.getZ() - radius; z < loc.getZ() + radius; z++ ) {
                    Location l = new Location(loc.getWorld(), x, y, z);

                    Collection<ItemStack> drops = l.getBlock().getDrops();
                    Collection<ItemStack> newDrops = new ArrayList<>();

                    l.getWorld().spawnParticle(Particle.LAVA, l, 10, 0.5, 0.5, 0.5, 0.5);

                    for (ItemStack item : drops) {
                        Iterator<Recipe> iter = Bukkit.recipeIterator();
                        while (iter.hasNext()) {
                            Recipe recipe = iter.next();
                            if (!(recipe instanceof FurnaceRecipe)) continue;
                            if (((FurnaceRecipe) recipe).getInput().getType() == item.getType()) newDrops.add(recipe.getResult());
                            else newDrops.add(item);

                            break;
                        }
                    }

                    for (ItemStack item : newDrops) {
                        l.getWorld().dropItemNaturally(l, item);
                    }

                    l.getBlock().setType(Material.AIR);
                }
            }
        }
    }

}
