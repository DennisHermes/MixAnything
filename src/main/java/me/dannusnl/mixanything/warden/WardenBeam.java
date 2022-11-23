package me.dannusnl.mixanything.warden;

import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class WardenBeam implements Listener {

    public WardenBeam() {

    }

    public void wardenBeam(Player p) {
        if (!p.isSneaking()) return;
        if (p.getEquipment().getHelmet() == null) return;
        if (p.getEquipment().getHelmet().getType() != Material.SKELETON_SKULL) return;
        if (!p.getEquipment().getHelmet().hasItemMeta()) return;
        if (!p.getEquipment().getHelmet().getItemMeta().hasCustomModelData()) return;
        if (p.getEquipment().getHelmet().getItemMeta().getCustomModelData() != 100) return;

        for (Entity ent : p.getNearbyEntities(50, 50, 50)) {
            if (ent instanceof LivingEntity) {
                Location eye = p.getEyeLocation();
                Vector toEntity = ((LivingEntity) ent).getEyeLocation().toVector().subtract(eye.toVector());
                double dot = toEntity.normalize().dot(eye.getDirection());

                if (dot > 0.99D) {
                    if (((Damageable) ent).getHealth() != 0) {
                        ((Damageable) ent).setHealth(((Damageable) ent).getHealth() - 1);
                        ((LivingEntity) ent).damage(2);
                    }

                    World world = p.getWorld();

                    Vector playerLocVector = p.getLocation().toVector();
                    Vector tridentLocVector = ent.getLocation().toVector();

                    Vector betweenPandTVector = tridentLocVector.clone().subtract(playerLocVector);
                    Vector directionVector = betweenPandTVector.clone().normalize();

                    for (int i = 0; i < betweenPandTVector.length(); i++) {
                        Vector particlePoint = playerLocVector.clone().add(directionVector.clone().multiply(i));
                        world.spawnParticle(Particle.SONIC_BOOM, particlePoint.getX(), particlePoint.getY() + 1, particlePoint.getZ(), 0, 0.001, 1, 0, 1);
                    }

                    break;
                }
            }
        }
    }

}
