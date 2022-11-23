package me.dannusnl.mixanything.luckyfoodblock;

import me.dannusnl.mixanything.MixAnything;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LuckyEating implements Listener {

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        if (e.getItem() == null) return;
        if (!e.getItem().getType().equals(Material.GOLDEN_APPLE)) return;
        if (e.getItem().getItemMeta() == null) return;
        if (!e.getItem().getItemMeta().hasCustomModelData()) return;

        if (e.getItem().getItemMeta().getCustomModelData() == 100) {

            e.getPlayer().playEffect(EntityEffect.TOTEM_RESURRECT);
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 600, 1));
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 9));

        } else if (e.getItem().getItemMeta().getCustomModelData() == 200) {

            Bukkit.getScheduler().runTaskLater(MixAnything.getInstance(), () -> e.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION), 1);
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1200, 2));
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 600, 2));

        }
    }

}
