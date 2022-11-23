package me.dannusnl.mixanything;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;

public class PreventMerge implements Listener {

    public static boolean mergeEnabled = true;

    @EventHandler
    public void cancelMerge(ItemMergeEvent e) {
        if (!mergeEnabled) e.setCancelled(true);
    }

}
