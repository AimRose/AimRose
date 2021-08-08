package at.aimrose.service.perks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class XpDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        if(p.hasPermission(Perk.KEEP_XP.getPermission())) {
            if(PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.KEEP_XP)) {

               e.setKeepLevel(true);
            }
        }
    }
}


