package at.aimrose.service.perks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHungerListener implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        Player p = (Player)e.getEntity();
        if(p.hasPermission(Perk.NO_HUNGER.getPermission())) {
            if(PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.NO_HUNGER)) {
                p.setFoodLevel(20);
                e.setCancelled(true);
            }
        }
    }
}
