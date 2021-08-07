package at.aimrose.service.listner;

import at.aimrose.service.commands.God;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();

        if (God.god.contains(p.getName())) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

}
