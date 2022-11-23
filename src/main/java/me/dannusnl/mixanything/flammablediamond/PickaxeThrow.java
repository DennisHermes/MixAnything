package me.dannusnl.mixanything.flammablediamond;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PickaxeThrow implements Listener {

    ArrayList<Fireball> fireballs = new ArrayList<>();

    @EventHandler
    public void throwPickaxe(PlayerInteractEvent e) {
        if (!(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR))) return;
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.NETHERITE_PICKAXE)) return;
        if (!e.getItem().hasItemMeta()) return;
        if (!e.getItem().getItemMeta().hasCustomModelData()) return;
        if (e.getItem().getItemMeta().getCustomModelData() != 100) return;

        Fireball fireball = e.getPlayer().launchProjectile(Fireball.class);
        fireball.setShooter(e.getPlayer());
        fireball.setYield(4);
        fireballs.add(fireball);
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 1);
    }

    @EventHandler
    public void blockExploding(EntityExplodeEvent e) {
        if (!e.getEntityType().equals(EntityType.FIREBALL)) return;
        if (!fireballs.contains(e.getEntity())) return;
        if (fireballs.isEmpty()) return;

        fireballs.remove(e.getEntity());

        Location loc = e.getLocation();
        double radius = 1.5;
        for (double x = loc.getX() - radius; x < loc.getX() + radius; x++ ) {
            for (double y = loc.getY() - radius; y < loc.getY() + radius; y++) {
                for (double z = loc.getZ() - radius; z < loc.getZ() + radius; z++) {
                    Location l = new Location(loc.getWorld(), x, y, z);
                    if (l.getBlock().getType().equals(Material.BEDROCK)) l.getBlock().setType(Material.VOID_AIR);
                }
            }
        }

        for (Block block : e.blockList()) {
            Collection<ItemStack> drops = block.getDrops();
            Collection<ItemStack> newDrops = new ArrayList<>();

            block.getWorld().spawnParticle(Particle.LAVA, block.getLocation(), 10, 0.5, 0.5, 0.5, 0.5);

            for (ItemStack item : drops) {
                Iterator<Recipe> iter = Bukkit.recipeIterator();
                while (iter.hasNext()) {
                    Recipe recipe = iter.next();
                    if (!(recipe instanceof FurnaceRecipe)) continue;
                    if (((FurnaceRecipe) recipe).getInput().getType() != item.getType()) continue;
                    newDrops.add(recipe.getResult());
                    break;
                }
            }

            for (ItemStack item : newDrops) {
                block.getWorld().dropItemNaturally(block.getLocation(), item);
            }
        }
    }

}
