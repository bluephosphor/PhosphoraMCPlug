package me.phosphoramc.phosphora.listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.ArrayList;

import static me.phosphoramc.phosphora.Phosphora.addHiddenTag;

public class TPBowListener implements Listener {
    ArrayList<Projectile> activeArrows = new ArrayList<>();

    @EventHandler
    public void onArrowFire(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Projectile arrow = event.getEntity();
            Player shooter = (Player) arrow.getShooter();
            ArrayList<String> bowCheck = new ArrayList<>();
            bowCheck.add(addHiddenTag("#tpbow"));
            if(shooter.getInventory().getItemInMainHand().getItemMeta().getLore().containsAll(bowCheck)){
                activeArrows.add(arrow);
            }
        }
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Projectile arrow  = event.getEntity();
            if (activeArrows.contains(arrow)){
                Player player = (Player) arrow.getShooter();
                Location startingPoint = player.getLocation();
                Location destination   = arrow.getLocation();

                player.playSound (startingPoint, Sound.ENTITY_ENDERMAN_TELEPORT, 0.5F, 1.0F);
                player.playEffect(startingPoint, Effect.ENDER_SIGNAL, null);

                float p = startingPoint.getPitch();
                float y = startingPoint.getYaw();
                destination.setPitch(p);
                destination.setYaw(y);

                player.teleport(destination);

                player.playSound(destination, Sound.ENTITY_ENDERMAN_TELEPORT, 0.5F, 1.0F);
                player.playEffect(destination, Effect.ENDER_SIGNAL, null);

                activeArrows.remove(arrow);
            }
        }
    }
}
