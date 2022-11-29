package me.dannusnl.mixanything.mixingequipment;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;

public class BlenderClick {

    BlenderClick() {

    }

    public void onBlenderClick(PlayerInteractEvent e) {

        e.setCancelled(true);

        if (e.getItem() == null) return;

        if (e.getItem().getType().equals(Material.RABBIT_FOOT)) {
            if (e.getItem().getItemMeta().getCustomModelData() == 200) {
                Collection<Entity> entities0 = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), 0.2, 0.2, 0.2);
                if (entities0.isEmpty()) return;
                for (Entity ent0 : entities0) {
                    if (!ent0.getType().equals(EntityType.ARMOR_STAND)) continue;
                    if (!ent0.getCustomName().equals("BlenderContent1")) continue;
                    ArmorStand ar = (ArmorStand) ent0;
                    if (ar.getEquipment().getHelmet() == null) return;
                    if (!ar.getEquipment().getHelmet().hasItemMeta()) return;
                    if (!ar.getEquipment().getHelmet().getItemMeta().hasCustomModelData()) return;
                    if (ar.getEquipment().getHelmet().getItemMeta().getCustomModelData() < 2100) return;

                    JarsItemBuilder jarsItemBuilder = new JarsItemBuilder();
                    if (ar.getEquipment().getHelmet().getItemMeta().getCustomModelData() == 2100) {
                        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(jarsItemBuilder.jarOfFlammable()), 1);
                        ar.getEquipment().setHelmet(null);
                    } else if (ar.getEquipment().getHelmet().getItemMeta().getCustomModelData() == 2200) {
                        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(jarsItemBuilder.jarOfEmerald()), 1);
                        ar.getEquipment().setHelmet(null);
                    } else if (ar.getEquipment().getHelmet().getItemMeta().getCustomModelData() == 2300) {
                        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(jarsItemBuilder.jarOfIron()), 1);
                        ar.getEquipment().setHelmet(null);
                    } else if (ar.getEquipment().getHelmet().getItemMeta().getCustomModelData() == 2400) {
                        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(jarsItemBuilder.jarOfSculk()), 1);
                        ar.getEquipment().setHelmet(null);
                    } else if (ar.getEquipment().getHelmet().getItemMeta().getCustomModelData() == 2500) {
                        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(jarsItemBuilder.jarOfTheoreticalSpace()), 1);
                        ar.getEquipment().setHelmet(null);
                    }
                }
            }
            return;
        }

        if (!(e.getItem().getType().equals(Material.DIAMOND) ||
              e.getItem().getType().equals(Material.TNT) ||
              e.getItem().getType().equals(Material.EMERALD) ||
              e.getItem().getType().equals(Material.HAY_BLOCK) ||
              e.getItem().getType().equals(Material.EMERALD) ||
              e.getItem().getType().equals(Material.IRON_BLOCK) ||
              e.getItem().getType().equals(Material.CACTUS) ||
              e.getItem().getType().equals(Material.SCULK) ||
              e.getItem().getType().equals(Material.CHEST) ||
              e.getItem().getType().equals(Material.IRON_NUGGET) ||
              e.getItem().getType().equals(Material.EXPERIENCE_BOTTLE)
        )) return;

        ArmorStand ar0 = null;
        ArmorStand ar1 = null;

        Collection<Entity> entities0 = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, 0, 0.5), 0.2, 0.2, 0.2);
        if (entities0.isEmpty()) return;
        for (Entity ent0 : entities0) {
            if (!ent0.getType().equals(EntityType.ARMOR_STAND)) continue;
            if (!ent0.getCustomName().equals("BlenderContent1")) continue;
            ar0 = (ArmorStand) ent0;
        }

        Collection<Entity> entities1 = e.getClickedBlock().getWorld().getNearbyEntities(e.getClickedBlock().getLocation().add(0.5, 0.07, 0.5), 0.2, 0.2, 0.2);
        if (entities1.isEmpty()) return;
        for (Entity ent1 : entities1) {
            if (!ent1.getType().equals(EntityType.ARMOR_STAND)) continue;
            if (!ent1.getCustomName().equals("BlenderContent2")) continue;
            ar1 = (ArmorStand) ent1;
        }

        if (!ar0.getEquipment().getHelmet().getType().equals(Material.AIR)) {
            if (ar0.getEquipment().getHelmet().getType().equals(Material.TNT)) {
                if (e.getItem().getType().equals(Material.DIAMOND)) {
                    ar1.getEquipment().setHelmet(e.getItem());
                    ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    flammableTnt(ar0, ar1);
                }
            } else if (ar0.getEquipment().getHelmet().getType().equals(Material.DIAMOND)) {
                if (e.getItem().getType().equals(Material.TNT)) {
                    ar1.getEquipment().setHelmet(e.getItem());
                    ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    flammableTnt(ar0, ar1);
                }
            }

            else if (ar0.getEquipment().getHelmet().getType().equals(Material.EMERALD)) {
                if (e.getItem().getType().equals(Material.HAY_BLOCK)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    luckyFood(ar0, ar1);
                }
            } else if (ar0.getEquipment().getHelmet().getType().equals(Material.HAY_BLOCK)) {
                if (e.getItem().getType().equals(Material.EMERALD)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    luckyFood(ar0, ar1);
                }
            }

            else if (ar0.getEquipment().getHelmet().getType().equals(Material.IRON_BLOCK)) {
                if (e.getItem().getType().equals(Material.CACTUS)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    spikeyIron(ar0, ar1);
                }
            } else if (ar0.getEquipment().getHelmet().getType().equals(Material.CACTUS)) {
                if (e.getItem().getType().equals(Material.IRON_BLOCK)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    spikeyIron(ar0, ar1);
                }
            }

            else if (ar0.getEquipment().getHelmet().getType().equals(Material.SCULK)) {
                if (e.getItem().getType().equals(Material.CHEST)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    wardenHorn(ar0, ar1);
                }
            } else if (ar0.getEquipment().getHelmet().getType().equals(Material.CHEST)) {
                if (e.getItem().getType().equals(Material.SCULK)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    wardenHorn(ar0, ar1);
                }
            }

            else if (ar0.getEquipment().getHelmet().getType().equals(Material.IRON_NUGGET)) {
                if (e.getItem().getType().equals(Material.EXPERIENCE_BOTTLE)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    theoreticalSpace(ar0, ar1);
                }
            } else if (ar0.getEquipment().getHelmet().getType().equals(Material.EXPERIENCE_BOTTLE)) {
                if (e.getItem().getType().equals(Material.IRON_NUGGET)) {
                    ar1.getEquipment().setHelmet(e.getItem());ItemStack item = e.getItem();
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);

                    defaultBlend(ar0, ar1);
                    theoreticalSpace(ar0, ar1);
                }
            }

        } else {
            ar0.getEquipment().setHelmet(e.getItem());
            ItemStack item = e.getItem();
            item.setAmount(item.getAmount() - 1);
            Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> e.getPlayer().getInventory().setItemInMainHand(item), 2);
        }

    }

    private void defaultBlend(ArmorStand ar0, ArmorStand ar1) {
        for (int i = 0; i < 100; i++) {
            Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {
                ar0.setRotation(ar0.getLocation().getYaw() + 50, 0);
                ar1.setRotation(ar1.getLocation().getYaw() + 50, 0);
            }, i);
        }
    }

    private void flammableTnt(ArmorStand ar0, ArmorStand ar1) {
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {
            ar0.setRotation(0, 0);
            ar1.setRotation(0, 0);
            ItemStack item = new ItemStack(Material.RABBIT_FOOT);
            ItemMeta meta = item.getItemMeta();
            meta.setCustomModelData(2100);
            item.setItemMeta(meta);
            ar0.getEquipment().setHelmet(item);
            ar1.getEquipment().setHelmet(new ItemStack(Material.AIR));
        }, 100);
    }

    private void luckyFood(ArmorStand ar0, ArmorStand ar1) {
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {
            ar0.setRotation(0, 0);
            ar1.setRotation(0, 0);
            ItemStack item = new ItemStack(Material.RABBIT_FOOT);
            ItemMeta meta = item.getItemMeta();
            meta.setCustomModelData(2200);
            item.setItemMeta(meta);
            ar0.getEquipment().setHelmet(item);
            ar1.getEquipment().setHelmet(new ItemStack(Material.AIR));
        }, 100);
    }

    private void spikeyIron(ArmorStand ar0, ArmorStand ar1) {
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {
            ar0.setRotation(0, 0);
            ar1.setRotation(0, 0);
            ItemStack item = new ItemStack(Material.RABBIT_FOOT);
            ItemMeta meta = item.getItemMeta();
            meta.setCustomModelData(2300);
            item.setItemMeta(meta);
            ar0.getEquipment().setHelmet(item);
            ar1.getEquipment().setHelmet(new ItemStack(Material.AIR));
        }, 100);
    }

    private void wardenHorn(ArmorStand ar0, ArmorStand ar1) {
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {
            ar0.setRotation(0, 0);
            ar1.setRotation(0, 0);
            ItemStack item = new ItemStack(Material.RABBIT_FOOT);
            ItemMeta meta = item.getItemMeta();
            meta.setCustomModelData(2400);
            item.setItemMeta(meta);
            ar0.getEquipment().setHelmet(item);
            ar1.getEquipment().setHelmet(new ItemStack(Material.AIR));
        }, 100);
    }

    private void theoreticalSpace(ArmorStand ar0, ArmorStand ar1) {
        Bukkit.getScheduler().runTaskLater(MixAnything.instance, () -> {
            ar0.setRotation(0, 0);
            ar1.setRotation(0, 0);
            ItemStack item = new ItemStack(Material.RABBIT_FOOT);
            ItemMeta meta = item.getItemMeta();
            meta.setCustomModelData(2500);
            item.setItemMeta(meta);
            ar0.getEquipment().setHelmet(item);
            ar1.getEquipment().setHelmet(new ItemStack(Material.AIR));
        }, 100);
    }

}
