package me.dannusnl.mixanything;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UnlockRecipes implements Listener {

    @EventHandler
    public void unlockRecipes(PlayerJoinEvent e) {
        e.getPlayer().discoverRecipes(MixAnything.getInstance().getNamespaceKeys());
    }

}
