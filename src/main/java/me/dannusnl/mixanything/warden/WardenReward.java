package me.dannusnl.mixanything.warden;

import org.bukkit.Material;
import org.bukkit.entity.Warden;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class WardenReward implements Listener {

    @EventHandler
    public void onWardenReward(EntityDeathEvent e) {
        if (e.getEntity() instanceof Warden) {
            e.getDrops().add(new ItemBuilder().wardenHead());

            ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
            xp.setAmount(5);

            e.getDrops().add(xp);
        }
    }

}
