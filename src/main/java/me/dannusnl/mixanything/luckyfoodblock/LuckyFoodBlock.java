package me.dannusnl.mixanything.luckyfoodblock;

import me.dannusnl.mixanything.MixAnything;
import me.dannusnl.mixanything.PreventMerge;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

public class LuckyFoodBlock implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.getItemInHand() == null) return;
        if (!e.getItemInHand().getType().equals(Material.HAY_BLOCK)) return;
        if (!e.getItemInHand().hasItemMeta()) return;
        if (!e.getItemInHand().getItemMeta().hasCustomModelData()) return;
        if (e.getItemInHand().getItemMeta().getCustomModelData() != 100) return;

        ArmorStand ar = e.getBlockPlaced().getWorld().spawn(e.getBlockPlaced().getLocation().add(0.5, -0.4, 0.5), ArmorStand.class);
        ar.getEquipment().setHelmet(new ItemBuilder().luckyFoodBlock());
        ar.setMarker(true);
        ar.setVisible(false);
        ar.setCustomName("LuckyFoodBlock");
        ar.setCustomNameVisible(false);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (!e.getBlock().getType().equals(Material.HAY_BLOCK)) return;

        Collection<Entity> entities = e.getBlock().getWorld().getNearbyEntities(e.getBlock().getLocation().add(0.5, -0.4, 0.5), 0.3, 0.3, 0.3);
        if (entities.isEmpty()) return;
        for (Entity ent : entities) {
            if (ent.getType().equals(EntityType.ARMOR_STAND)) {
                if (!ent.getCustomName().equals("LuckyFoodBlock")) continue;

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                ent.remove();

                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemBuilder().luckyFoodBlock());

                int random = (int) (Math.random() * 5);
                if (random == 0) {
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemBuilder().eatableTotem());
                } else if (random == 1) {
                    PreventMerge.mergeEnabled = false;
                    Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> PreventMerge.mergeEnabled = true, 100);
                    for (int i = 0; i < 10; i++) {
                        Item item = e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemBuilder().luckyBread());
                        item.setVelocity(item.getVelocity().multiply(0.5).setY(1));
                        item.setGlowing(true);
                    }
                } else if (random == 2) {
                    Husk zombie = e.getBlock().getWorld().spawn(e.getBlock().getLocation(), Husk.class);
                    zombie.setCustomName(ChatColor.GREEN + "§lUnlucky Zombie");
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                    zombie.setTarget(e.getPlayer());
                } else if (random == 3) {
                    for (int i = 0; i < 3; i++) {
                        Wolf wolf = e.getBlock().getWorld().spawn(e.getBlock().getLocation(), Wolf.class);
                        wolf.setCustomName(ChatColor.GREEN + "§lEmerald Wolf");
                        wolf.setTamed(true);
                        wolf.setOwner(e.getPlayer());
                    }
                } else if (random == 4) {
                    e.getBlock().setType(Material.CHEST);
                    Chest meta = (Chest) e.getBlock().getState();
                    ItemBuilder itemBuilder = new ItemBuilder();
                    meta.getInventory().setItem(3, itemBuilder.emeraldLeggings());
                    meta.getInventory().setItem(14, itemBuilder.emeraldHelmet());
                    meta.getInventory().setItem(19, itemBuilder.emeraldBoots());
                }
            }
        }
    }

}
