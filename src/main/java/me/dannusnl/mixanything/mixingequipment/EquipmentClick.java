package me.dannusnl.mixanything.mixingequipment;

import me.dannusnl.mixanything.MixAnything;
import me.dannusnl.mixanything.luckyfoodblock.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class EquipmentClick implements Listener {

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

                    BlenderClick blenderClick = new BlenderClick();
                    blenderClick.onBlenderClick(e);

                } else if (ent.getCustomName().equals("Mixer")) {

                    Collection<Entity> entities0 = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, -0.4, 0.5), 0.3, 0.3, 0.3);
                    if (entities0.isEmpty()) return;
                    for (Entity ent0 : entities0) {
                        if (ent0.getType().equals(EntityType.ARMOR_STAND)) {
                            if (ent0.getCustomName().equals("MixerContent")) {
                                ArmorStand ar = (ArmorStand) ent0;
                                if (!ar.getEquipment().getHelmet().getType().equals(Material.AIR)) {
                                    int cmd = ar.getEquipment().getHelmet().getItemMeta().getCustomModelData();
                                    if (cmd == 1800) {
                                        me.dannusnl.mixanything.flammablediamond.ItemBuilder ib = new me.dannusnl.mixanything.flammablediamond.ItemBuilder();
                                        e.getPlayer().getInventory().addItem(ib.flammebleDiamondBlock());
                                        ar.getEquipment().setHelmet(null);
                                    } else if (cmd == 1900) {
                                            e.getPlayer().getInventory().addItem(new ItemBuilder().luckyFoodBlock());
                                            ar.getEquipment().setHelmet(null);
                                    } else if (cmd == 2000) {
                                        me.dannusnl.mixanything.spikyiron.ItemBuilder ib = new me.dannusnl.mixanything.spikyiron.ItemBuilder();
                                        e.getPlayer().getInventory().addItem(ib.spikeyIronBlock());
                                        ar.getEquipment().setHelmet(null);
                                    } else if (cmd == 100) {
                                        e.getPlayer().getInventory().addItem(ar.getEquipment().getHelmet());
                                        ar.getEquipment().setHelmet(null);
                                    } else if (cmd == 1400 || cmd == 1500 || cmd == 1600 || cmd == 1700) {
                                        if (e.getItem().getType().equals(Material.FLINT_AND_STEEL)) {
                                            e.setCancelled(true);
                                            for (int i = 0; i < 10; i++) {
                                                Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getClickedBlock().getWorld().spawnParticle(Particle.LAVA, e.getClickedBlock().getLocation().add(0.5, 1, 0.5), 50, 0.1, 0.1, 0.1, 0.1), i * 10);
                                            }
                                            Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {

                                                if (cmd == 1400) {
                                                    ItemStack item = new ItemStack(Material.RABBIT_FOOT);
                                                    ItemMeta meta = item.getItemMeta();
                                                    meta.setCustomModelData(1800);
                                                    item.setItemMeta(meta);
                                                    ar.getEquipment().setHelmet(item);
                                                } else if (cmd == 1500) {
                                                    ItemStack item = new ItemStack(Material.RABBIT_FOOT);
                                                    ItemMeta meta = item.getItemMeta();
                                                    meta.setCustomModelData(1900);
                                                    item.setItemMeta(meta);
                                                    ar.getEquipment().setHelmet(item);
                                                } else if (cmd == 1600) {
                                                    ItemStack item = new ItemStack(Material.RABBIT_FOOT);
                                                    ItemMeta meta = item.getItemMeta();
                                                    meta.setCustomModelData(2000);
                                                    item.setItemMeta(meta);
                                                    ar.getEquipment().setHelmet(item);
                                                } else if (cmd == 1700) {
                                                    me.dannusnl.mixanything.warden.ItemBuilder ib = new me.dannusnl.mixanything.warden.ItemBuilder();
                                                    ar.getEquipment().setHelmet(ib.wardenHorn());
                                                }
                                            }, 100);
                                        }
                                    }
                                } else {
                                    if (e.getItem() != null) {
                                        int cmd = e.getItem().getItemMeta().getCustomModelData();
                                        if (cmd == 1000 || cmd == 1100 || cmd == 1200 || cmd == 1300) {
                                            ItemStack item = new ItemStack(Material.RABBIT_FOOT);
                                            ItemMeta meta = item.getItemMeta();
                                            meta.setCustomModelData(cmd + 400);
                                            item.setItemMeta(meta);
                                            ar.getEquipment().setHelmet(item);
                                            Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {
                                                me.dannusnl.mixanything.mixingequipment.ItemBuilder itemBuilder = new me.dannusnl.mixanything.mixingequipment.ItemBuilder();
                                                e.getPlayer().getEquipment().setItemInMainHand(itemBuilder.emptyJar());
                                            }, 2);
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

            }
        }
    }

}
