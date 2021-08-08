package at.aimrose.service.perks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class InvDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        if(p.hasPermission(Perk.KEEP_INVENTORY.getPermission())) {
            if(PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.KEEP_INVENTORY)) {

                e.setKeepInventory(true);
            }
        }
    }

}
