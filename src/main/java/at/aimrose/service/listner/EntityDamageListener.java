package at.aimrose.service.listner;

import at.aimrose.service.commands.God;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();

        if (God.god.contains(p.getName())) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

}
